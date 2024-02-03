package com.sinch.sdk.core.utils;

/**
 * Abstract class providing common definition to extendable enums
 *
 * @param <T> Type of value
 * @param <E> Enum type
 */
public abstract class EnumDynamic<T, E extends EnumDynamic<T, E>> {

  private final T value;

  protected EnumDynamic(T value) {
    this.value = value;
  }

  /**
   * Get enum value as String
   *
   * @return Enum value
   */
  public T value() {
    return value;
  }

  @Override
  public String toString() {
    return value().toString();
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof EnumDynamic)) {
      return false;
    }

    return java.util.Objects.equals(this.value, ((EnumDynamic<?, ?>) o).value());
  }

  @Override
  public int hashCode() {
    return value.hashCode();
  }
}
