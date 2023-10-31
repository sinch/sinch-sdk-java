package com.sinch.sdk.core.utils;

/**
 * Abstract class providing common definition to extendable enums
 *
 * @param <E> Enum type
 */
public abstract class EnumDynamic<E extends EnumDynamic<E>> {

  private final String value;

  protected EnumDynamic(String value) {
    this.value = value;
  }

  /**
   * Get enum value as String
   *
   * @return Enum value
   */
  public String value() {
    return value;
  }

  public String toString() {
    return value();
  }

  public boolean equals(E o) {
    if (o == this) {
      return true;
    }
    return java.util.Objects.equals(this.value, o.value());
  }

  public int hashCode() {
    return value.hashCode();
  }
}
