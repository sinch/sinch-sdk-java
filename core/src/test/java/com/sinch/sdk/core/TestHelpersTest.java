package com.sinch.sdk.core;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.OffsetDateTime;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class TestHelpersTest {

  static class MyObject {
    final Object o1;
    final Object o2;

    public MyObject(Object o1, Object o2) {
      this.o1 = o1;
      this.o2 = o2;
    }
  }

  MyObject object1 = new MyObject("my value1", Arrays.asList("my value2"));
  MyObject objectEqualsToObject1 = new MyObject("my value1", Arrays.asList("my value2"));
  MyObject objectDifferentFromObject1ByValue =
      new MyObject("my value1", Arrays.asList("my different value2"));
  MyObject objectDifferentFromObject1ByNull = new MyObject("my value1", null);

  @Test
  void recursiveDifferentByClass() {

    AssertionError thrown =
        assertThrows(
            AssertionError.class,
            () -> TestHelpers.recursiveEquals("foo string", OffsetDateTime.now()),
            "Expected recursiveEquals() to throw, but it didn't");
    // expected error message hardcoded according to JUnit 5
    assertTrue(
        thrown
            .getMessage()
            .contains(
                "actual and expected are considered different since the comparison enforces strict"
                    + " type check and expected type"));
  }

  @Test
  void recursiveDifferentByField() {

    AssertionError thrown =
        assertThrows(
            AssertionError.class,
            () -> TestHelpers.recursiveEquals(object1, objectDifferentFromObject1ByValue),
            "Expected recursiveEquals() to throw, but it didn't");
    // expected error message hardcoded according to JUnit 5
    assertTrue(
        thrown
            .getMessage()
            .contains(
                "field/property 'o2[0]' differ:\n"
                    + "- actual value  : \"my value2\"\n"
                    + "- expected value: \"my different value2\""));
  }

  @Test
  void recursiveDifferentByNullO1O2() {

    AssertionError thrown =
        assertThrows(
            AssertionError.class,
            () -> TestHelpers.recursiveEquals(object1, objectDifferentFromObject1ByNull),
            "Expected recursiveEquals() to throw, but it didn't");
    // expected error message hardcoded according to JUnit 5
    assertTrue(
        thrown
            .getMessage()
            .contains(
                "field/property 'o2' differ:\n"
                    + "- actual value  : [\"my value2\"]\n"
                    + "- expected value: null"));
  }

  @Test
  void recursiveDifferentByNullO2O1() {

    AssertionError thrown =
        assertThrows(
            AssertionError.class,
            () -> TestHelpers.recursiveEquals(objectDifferentFromObject1ByNull, object1),
            "Expected recursiveEquals() to throw, but it didn't");
    // expected error message hardcoded according to JUnit 5
    assertTrue(
        thrown
            .getMessage()
            .contains(
                "field/property 'o2' differ:\n"
                    + "- actual value  : null\n"
                    + "- expected value: [\"my value2\"]"));
  }

  @Test
  void recursiveEqualsO1O2() {
    TestHelpers.recursiveEquals(object1, objectEqualsToObject1);
  }

  @Test
  void recursiveEqualsO2O1() {
    TestHelpers.recursiveEquals(objectEqualsToObject1, object1);
  }
}
