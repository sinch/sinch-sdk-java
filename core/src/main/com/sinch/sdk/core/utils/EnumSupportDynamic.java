package com.sinch.sdk.core.utils;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

import java.util.*;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Utility class to manage extendable enumeration set
 *
 * <p>Used to define a known set of value but enable to extend it dynamically
 *
 * <p>Typical use case: being able to send and/or receive values not yet defined at SDK version
 * release
 *
 * @param <T> Value type
 * @param <E> Value instance
 */
public final class EnumSupportDynamic<T, E extends EnumDynamic<T, E>> {
  private static final Logger LOGGER = Logger.getLogger(EnumSupportDynamic.class.getName());

  private final Class<E> aClass;
  private final Map<T, E> valueMap;
  private final Function<T, E> surplusFactory;

  private volatile List<E> values;

  public EnumSupportDynamic(Class<E> aClass, Function<T, E> surplusFactory, List<E> values) {

    this.aClass = aClass;
    this.values = Collections.unmodifiableList(values);
    this.valueMap = this.values.stream().collect(Collectors.toMap(EnumDynamic::value, v -> v));
    this.surplusFactory = surplusFactory;
  }

  private static <E> List<E> createImmutableList(List<E> values2, E newValue) {
    List<E> newValues = new ArrayList<>(values2);
    newValues.add(newValue);
    return Collections.unmodifiableList(newValues);
  }

  public Stream<E> values() {
    return values.stream();
  }

  public T valueOf(E e) {
    return e == null ? null : e.value();
  }

  public List<T> valuesOf(Collection<E> values) {
    if (values == null) {
      return null;
    }
    return values.stream().map(this::valueOf).collect(toList());
  }

  public List<E> fromValues(Collection<T> values) {
    if (values == null) {
      return null;
    }
    return values.stream().map(this::from).collect(toList());
  }

  public E from(T value) {
    if (value == null) {
      return null;
    }

    E e = valueMap.get(value);
    if (e != null) {
      return e;
    }

    synchronized (valueMap) {
      E present = valueMap.get(value);

      if (present == null) {
        E newValue = surplusFactory.apply(value);

        LOGGER.warning(String.format("Dynamically create '%s' from '%s'", newValue, value));

        valueMap.put(value, newValue);
        values = createImmutableList(values, newValue);

        return newValue;
      } else {
        // Racing conditions before entering the synchronized block.
        return present;
      }
    }
  }

  public int compare(Object o1, Object o2) {
    String v1 = toComparableValue(o1);
    String v2 = toComparableValue(o2);
    return Objects.compare(v1, v2, String::compareTo);
  }

  public String toComparableValue(Object o) {

    if (o == null) {
      return null;
    }

    if (o instanceof String) {
      return (String) o;
    }

    if (aClass.isInstance(o)) {
      E obj = aClass.cast(o);
      return obj.value().toString();
    }

    throw new IllegalArgumentException(
        format(
            "Object %s is neither %s nor a String.",
            o.getClass().getSimpleName(), aClass.getSimpleName()));
  }
}
