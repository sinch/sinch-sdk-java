package com.sinch.sdk.core.models;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * class adapted from {@link java.util.Optional} enabling to:
 *
 * <ul>
 *   <li>accept null value as authorized and defined value
 *   <li>determine is a value was set with any value (null included) or not
 * </ul>
 *
 * <p>So, this class enable to distinguish a value set to null VS an undefined value
 *
 * @param <T> the type of value
 * @since 1.8
 */
public final class OptionalValue<T> {
  /** Common instance for {@code empty()}. */
  private static final OptionalValue<?> EMPTY = new OptionalValue<>();

  /** If non-null, the value; if null, indicates no value is present */
  private final T value;

  private final boolean isSet;

  /**
   * Constructs an empty instance.
   *
   * @implNote Generally only one empty instance, {@link OptionalValue#EMPTY}, should exist per VM.
   */
  private OptionalValue() {
    this.value = null;
    this.isSet = false;
  }

  /**
   * Returns an empty {@code OptionalValue} instance. No value is present for this {@code Optional}.
   *
   * <p>Though it may be tempting to do so, avoid testing if an object is empty by comparing with
   * {@code ==} against instances returned by {@code Optional.empty()}. There is no guarantee that
   * it is a singleton. Instead, use {@link #isPresent()}.
   *
   * @param <T> The type of the non-existent value
   * @return an empty {@code OptionalValue}
   */
  public static <T> OptionalValue<T> empty() {
    @SuppressWarnings("unchecked")
    OptionalValue<T> t = (OptionalValue<T>) EMPTY;
    return t;
  }

  /**
   * Constructs an instance with the described value.
   *
   * @param value the value to describe
   */
  private OptionalValue(T value) {
    this.value = value;
    this.isSet = true;
  }

  /**
   * Returns an {@code OptionalValue} describing the given value.
   *
   * @param value the value to describe
   * @param <T> the type of the value
   * @return an {@code OptionalValue} with the value present
   */
  public static <T> OptionalValue<T> of(T value) {
    return new OptionalValue<>(value);
  }

  /**
   * If a value is present, returns the value, otherwise throws {@code NoSuchElementException}.
   *
   * <p>The preferred alternative to this method is {@link #orElseThrow()}.
   *
   * @return the value described by this {@code OptionalValue}
   * @throws NoSuchElementException if no value is present
   */
  public T get() {
    if (!this.isSet) {
      throw new NoSuchElementException("No value present");
    }
    return value;
  }

  /**
   * If a value is present, returns {@code true}, otherwise {@code false}.
   *
   * @return {@code true} if a value is present, otherwise {@code false}
   */
  public boolean isPresent() {
    return this.isSet;
  }

  /**
   * If a value is present, performs the given action with the value, otherwise does nothing.
   *
   * @param action the action to be performed, if a value is present
   * @throws NullPointerException if value is present and the given action is {@code null}
   */
  public void ifPresent(Consumer<? super T> action) {
    if (this.isSet) {
      action.accept(value);
    }
  }

  /**
   * If a value is set, performs the given action with the value, otherwise performs the given
   * empty-based action.
   *
   * @param action the action to be performed, if a value is set
   * @param emptyAction the empty-based action to be performed, if no value is present
   * @throws NullPointerException if a value is present and the given action is {@code null}, or no
   *     value is present and the given empty-based action is {@code null}.
   * @since 9
   */
  public void ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction) {
    if (this.isSet) {
      action.accept(value);
    } else {
      emptyAction.run();
    }
  }

  /**
   * If a value is set, returns the value, otherwise returns {@code other}.
   *
   * @param other the value to be returned, if no value is present. May be {@code null}.
   * @return the value, if present, otherwise {@code other}
   */
  public T orElse(T other) {
    return this.isSet ? value : other;
  }

  /**
   * If a value is set, returns the value, otherwise returns the result produced by the supplying
   * function.
   *
   * @param supplier the supplying function that produces a value to be returned
   * @return the value, if present, otherwise the result produced by the supplying function
   * @throws NullPointerException if no value is present and the supplying function is {@code null}
   */
  public T orElseGet(Supplier<? extends T> supplier) {
    return this.isSet ? value : supplier.get();
  }

  /**
   * If a value is set, returns the value, otherwise throws {@code NoSuchElementException}.
   *
   * @return the non-{@code null} value described by this {@code Optional}
   * @throws NoSuchElementException if no value is present
   * @since 10
   */
  public T orElseThrow() {
    if (!this.isSet) {
      throw new NoSuchElementException("No value present");
    }
    return value;
  }

  /**
   * If a value is present, returns the value, otherwise throws an exception produced by the
   * exception supplying function.
   *
   * <p>A method reference to the exception constructor with an empty argument list can be used as
   * the supplier. For example, {@code IllegalStateException::new}
   *
   * @param <X> Type of the exception to be thrown
   * @param exceptionSupplier the supplying function that produces an exception to be thrown
   * @return the value, if present
   * @throws X if no value is present
   * @throws NullPointerException if no value is present and the exception supplying function is
   *     {@code null}
   */
  public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
    if (this.isSet) {
      return value;
    } else {
      throw exceptionSupplier.get();
    }
  }

  /**
   * Indicates whether some other object is "equal to" this {@code Optional}. The other object is
   * considered equal if:
   *
   * <ul>
   *   <li>it is also an {@code OptionalValue} and;
   *   <li>both instances have no value set or;
   *   <li>the present values are "equal to" each other via {@code equals()}.
   * </ul>
   *
   * @param obj an object to be tested for equality
   * @return {@code true} if the other object is "equal to" this object otherwise {@code false}
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof OptionalValue)) {
      return false;
    }
    OptionalValue<?> other = (OptionalValue<?>) obj;
    return this.isSet == other.isSet && Objects.equals(value, other.value);
  }

  /**
   * Returns the hash code of the value, if present, otherwise {@code 0} (zero) if no value is
   * present.
   *
   * @return hash code value of the present value or {@code 0} if no value is present
   */
  @Override
  public int hashCode() {
    return Objects.hashCode(isSet) + Objects.hashCode(value);
  }

  /**
   * Returns a non-empty string representation of this {@code OptionalValue} suitable for debugging.
   * The exact presentation format is unspecified and may vary between implementations and versions.
   *
   * <p>If a value is set the result must include its string representation in the result. undefined
   * and defined (set) {@code OptionalValue}s must be unambiguously differentiable.
   *
   * @return the string representation of this instance
   */
  @Override
  public String toString() {
    return this.isSet ? String.format("OptionalValue[%s]", value) : "OptionalValue.undefined";
  }
}
