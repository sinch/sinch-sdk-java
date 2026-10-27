package com.sinch.sdk.core.http.transport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;

/**
 * Headers of an HTTP request or response.
 *
 * <p>Names are case-insensitive: looking a header up does not depend on the case it was added with.
 * A name can carry several values, kept in the order they were added; names are kept in the order
 * they were first added, with the case they were first added with.
 *
 * @since 2.4
 */
public final class HttpHeaders {

  private final Map<String, Entry> entries = new LinkedHashMap<>();

  /**
   * Empty headers
   *
   * @since 2.4
   */
  public HttpHeaders() {}

  /**
   * Copy of existing headers
   *
   * @param headers Headers to copy
   * @since 2.4
   */
  public HttpHeaders(HttpHeaders headers) {
    Objects.requireNonNull(headers, "headers");
    headers.entries.forEach(
        (key, entry) -> entries.put(key, new Entry(entry.name, new ArrayList<>(entry.values))));
  }

  /**
   * Add a value to a header, after the values it already carries
   *
   * @param name Header name
   * @param value Value to add
   * @return This instance
   * @since 2.4
   */
  public HttpHeaders add(String name, String value) {
    Objects.requireNonNull(value, "value");
    entries.computeIfAbsent(key(name), k -> new Entry(name, new ArrayList<>())).values.add(value);
    return this;
  }

  /**
   * Set the value of a header, replacing the values it already carries
   *
   * @param name Header name
   * @param value Value to set
   * @return This instance
   * @since 2.4
   */
  public HttpHeaders set(String name, String value) {
    Objects.requireNonNull(value, "value");
    Entry entry = entries.computeIfAbsent(key(name), k -> new Entry(name, new ArrayList<>()));
    entry.values.clear();
    entry.values.add(value);
    return this;
  }

  /**
   * Values of a header
   *
   * @param name Header name
   * @return Values in the order they were added, empty when the header is not present
   * @since 2.4
   */
  public List<String> getAll(String name) {
    Entry entry = entries.get(key(name));
    return null == entry
        ? Collections.emptyList()
        : Collections.unmodifiableList(new ArrayList<>(entry.values));
  }

  /**
   * First value of a header
   *
   * @param name Header name
   * @return First value, empty when the header is not present
   * @since 2.4
   */
  public Optional<String> getFirst(String name) {
    Entry entry = entries.get(key(name));
    return null == entry ? Optional.empty() : Optional.of(entry.values.get(0));
  }

  /**
   * Whether a header is present
   *
   * @param name Header name
   * @return <code>true</code> when at least one value is present for this header
   * @since 2.4
   */
  public boolean contains(String name) {
    return entries.containsKey(key(name));
  }

  /**
   * Remove all values of a header
   *
   * @param name Header name
   * @return <code>true</code> when the header was present
   * @since 2.4
   */
  public boolean remove(String name) {
    return null != entries.remove(key(name));
  }

  /**
   * Names of the headers present
   *
   * @return Names in the order they were first added, with the case they were first added with
   * @since 2.4
   */
  public Set<String> getNames() {
    Set<String> names = new LinkedHashSet<>();
    entries.values().forEach(entry -> names.add(entry.name));
    return Collections.unmodifiableSet(names);
  }

  /**
   * Whether no header is present
   *
   * @return <code>true</code> when empty
   * @since 2.4
   */
  public boolean isEmpty() {
    return entries.isEmpty();
  }

  /**
   * Perform an action for every value of every header, in order
   *
   * @param action Called once per value, with the header name and the value
   * @since 2.4
   */
  public void forEach(BiConsumer<String, String> action) {
    Objects.requireNonNull(action, "action");
    entries
        .values()
        .forEach(entry -> entry.values.forEach(value -> action.accept(entry.name, value)));
  }

  /**
   * Headers as a map
   *
   * @return New map from header names to their values, in order
   * @since 2.4
   */
  public Map<String, List<String>> toMap() {
    Map<String, List<String>> map = new LinkedHashMap<>();
    entries.values().forEach(entry -> map.put(entry.name, new ArrayList<>(entry.values)));
    return map;
  }

  private static String key(String name) {
    Objects.requireNonNull(name, "name");
    return name.toLowerCase(Locale.ROOT);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof HttpHeaders)) {
      return false;
    }
    return toComparable().equals(((HttpHeaders) o).toComparable());
  }

  @Override
  public int hashCode() {
    return toComparable().hashCode();
  }

  private Map<String, List<String>> toComparable() {
    Map<String, List<String>> map = new LinkedHashMap<>();
    entries.forEach((key, entry) -> map.put(key, entry.values));
    return map;
  }

  @Override
  public String toString() {
    return "HttpHeaders" + toMap();
  }

  private static final class Entry {
    private final String name;
    private final List<String> values;

    private Entry(String name, List<String> values) {
      this.name = name;
      this.values = values;
    }
  }
}
