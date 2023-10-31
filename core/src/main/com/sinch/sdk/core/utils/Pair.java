package com.sinch.sdk.core.utils;

/** Utility class to manage a pair of information (tuple) */
public class Pair<N, V> {
  private final N left;
  private final V right;

  public Pair(N left, V right) {
    this.left = left;
    this.right = right;
  }

  public N getLeft() {
    return this.left;
  }

  public V getRight() {
    return this.right;
  }

  @Override
  public String toString() {
    return "Pair{" + "left='" + left + '\'' + ", right='" + right + '\'' + '}';
  }
}
