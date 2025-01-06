package com.sinch.sdk.core.utils;

/**
 * Utility class to manage a pair of information (tuple)
 *
 * @param <N> Type of the left value
 * @param <V> Type of the right value
 */
public class Pair<N, V> {
  private final N left;
  private final V right;

  /**
   * Create a new pair
   *
   * @param left The left (key) value for this pair
   * @param right The right (value) value for this pair
   */
  public Pair(N left, V right) {
    this.left = left;
    this.right = right;
  }

  /**
   * Get the left value of this Pair
   *
   * @return Left value
   */
  public N getLeft() {
    return this.left;
  }

  /**
   * Get the right value of this Pair
   *
   * @return Right value
   */
  public V getRight() {
    return this.right;
  }

  /**
   * Helper to create new instance of Pair
   *
   * @param key key value
   * @param value value of value
   * @param <K> Key type
   * @param <V> Value type
   * @return Right value
   */
  public static <K, V> Pair<K, V> of(K key, V value) {
    return new Pair<>(key, value);
  }

  @Override
  public String toString() {
    return "Pair{" + "left='" + left + '\'' + ", right='" + right + '\'' + '}';
  }
}
