package com.sinch.sdk.core;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.recursive.comparison.RecursiveComparisonConfiguration;

public class TestHelpers {

  private static final RecursiveComparisonConfiguration recursiveComparisonConfiguration =
      RecursiveComparisonConfiguration.builder().withStrictTypeChecking(true).build();

  public static void recursiveEquals(Object actual, Object expected, String... excludedFields) {

    Assertions.assertThat(actual.getClass()).isEqualTo(expected.getClass());
    Assertions.assertThat(actual)
        .usingRecursiveComparison(recursiveComparisonConfiguration)
        .ignoringFields(excludedFields)
        .isEqualTo(expected);
  }

  public static void checkIteratorItems(Iterator<?> iterator, int expectedCount) {
    AtomicInteger count = new AtomicInteger();
    iterator.forEachRemaining(i -> count.incrementAndGet());
    Assertions.assertThat(count.get()).isEqualTo(expectedCount);
  }
}
