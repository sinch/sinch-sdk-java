package com.sinch.sdk.core.models;

import com.sinch.sdk.core.TestHelpers;
import org.mockito.ArgumentMatcher;

public class ModelArgMatcher<T> implements ArgumentMatcher<T> {

  private final T left;

  public ModelArgMatcher(T left) {
    this.left = left;
  }

  @Override
  public boolean matches(T right) {
    try {
      TestHelpers.recursiveEquals(right, left);
    } catch (AssertionError e) {
      return false;
    }
    return true;
  }
}
