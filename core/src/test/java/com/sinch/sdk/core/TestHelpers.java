package com.sinch.sdk.core;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.recursive.comparison.RecursiveComparisonConfiguration;

public class TestHelpers {

  private static final RecursiveComparisonConfiguration recursiveComparisonConfiguration =
      RecursiveComparisonConfiguration.builder().withStrictTypeChecking(true).build();

  public static void recursiveEquals(Object actual, Object expected, String... excludedFields) {
    Assertions.assertThat(actual.getClass()).isEqualTo(expected.getClass());
    // 1. Find fields of functional interface type
    // 2. Merge excludedFields and functionalFields
    // 3. All of them should be ignored in the recursive comparison
    String[] allExcluded =
        Arrays.stream(
                new String[][] {
                  excludedFields,
                  Arrays.stream(actual.getClass().getDeclaredFields())
                      .filter(f -> isFunctionalInterface(f.getType()))
                      .map(Field::getName)
                      .toArray(String[]::new)
                })
            .flatMap(Arrays::stream)
            .toArray(String[]::new);
    Assertions.assertThat(actual)
        .usingRecursiveComparison(recursiveComparisonConfiguration)
        .ignoringFields(allExcluded)
        .isEqualTo(expected);
  }

  public static void checkIteratorItems(Iterator<?> iterator, int expectedCount) {
    AtomicInteger count = new AtomicInteger();
    iterator.forEachRemaining(i -> count.incrementAndGet());
    Assertions.assertThat(count.get()).isEqualTo(expectedCount);
  }

  static boolean isFunctionalInterface(Class<?> iface) {
    if (!iface.isInterface()) return false;
    // Exclude Object methods (e.g., equals, hashCode)
    List<Method> abstractMethods =
        Arrays.stream(iface.getMethods())
            .filter(m -> Modifier.isAbstract(m.getModifiers()))
            .filter(m -> !m.getDeclaringClass().equals(Object.class))
            .collect(Collectors.toList());

    return abstractMethods.size() == 1;
  }
}
