package com.sinch.sdk.core;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.recursive.comparison.RecursiveComparisonConfiguration;

public class TestHelpers {

  private static RecursiveComparisonConfiguration recursiveComparisonConfiguration =
      RecursiveComparisonConfiguration.builder().withStrictTypeChecking(true).build();

  public static void recursiveEquals(Object o1, Object o2) {

    Assertions.assertThat(o1)
        .usingRecursiveComparison(recursiveComparisonConfiguration)
        .isEqualTo(o2);
  }
}
