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
 * @param <T> Value type associated to dynamic enum
 * @param <E> Dynamic enum class instance
 * @since 1.0
 */
public final class EnumSupportDynamic<T, E extends EnumDynamic<T, E>> {
  private static final Logger LOGGER = Logger.getLogger(EnumSupportDynamic.class.getName());

  private final Class<E> aClass;
  private final Map<T, E> valueMap;
  private final Function<T, E> surplusFactory;

  private volatile List<E> values;

  /**
   * Create a new instance of managing a dynamic enum
   *
   * @param aClass Related class stored with dynamic enum support
   * @param surplusFactory Factory T function to create a new dynamic enum value
   * @param values Values managed/stored by dynamic enum class
   * @since 1.0
   */
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

  /**
   * Get known values
   *
   * @return Stream of values
   * @since 1.0
   */
  public Stream<E> values() {
    return values.stream();
  }

  /**
   * Returns the value used to create the enum
   *
   * @param e the enum
   * @return Value associated to enum onto creation
   */
  public T valueOf(E e) {
    return e == null ? null : e.value();
  }

  /**
   * Transform Collection to List
   *
   * @param values Collection of values to be transformed
   * @return Created List
   */
  public List<T> valuesOf(Collection<E> values) {
    if (values == null) {
      return null;
    }
    return values.stream().map(this::valueOf).collect(toList());
  }

  /**
   * Get List of enum from Collection and create undefined Enum from the Collection if required
   *
   * @param values Collection of values to be used to fill returned List
   * @return List of enum related to source Collection
   */
  public List<E> fromValues(Collection<T> values) {
    if (values == null) {
      return null;
    }
    return values.stream().map(this::from).collect(toList());
  }

  /**
   * Get a dynamic enum from value
   *
   * <p>If no dynamic enum was already created with <code>value</code> param, a new value is created
   * and returned
   *
   * @param value Value to be associated to newly create element
   * @return Dynamic enum
   */
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

  /**
   * Compare two dynamic enum
   *
   * @param o1 the first object to compare
   * @param o2 the second object to compare
   * @return the value 0 if o1 == o2&amp; a value less than 0 if o1 &lt; o2; and a value greater
   *     than 0 if o1 &gt; o2
   */
  public int compare(Object o1, Object o2) {
    String v1 = toComparableValue(o1);
    String v2 = toComparableValue(o2);
    return Objects.compare(v1, v2, String::compareTo);
  }

  private String toComparableValue(Object o) {

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
