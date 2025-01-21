package com.sinch.sdk.core;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.recursive.comparison.RecursiveComparisonConfiguration;

public class TestHelpers {

  private static final RecursiveComparisonConfiguration recursiveComparisonConfiguration =
      RecursiveComparisonConfiguration.builder().withStrictTypeChecking(true).build();

  public static void recursiveEquals(Object actual, Object expected) {

    Assertions.assertThat(actual.getClass()).isEqualTo(expected.getClass());
    Assertions.assertThat(actual)
        .usingRecursiveComparison(recursiveComparisonConfiguration)
        .isEqualTo(expected);
  }
}
