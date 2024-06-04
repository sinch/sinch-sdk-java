package com.sinch.sdk.core;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.URLParameter;
import java.time.OffsetDateTime;
import java.util.Collections;
import org.junit.jupiter.api.Test;

public class TestHelpersTest {
  HttpRequest request1 =
      new HttpRequest(
          "the path",
          HttpMethod.PUT,
          Collections.singletonList(new URLParameter("a name", "the value")),
          "the body",
          Collections.singletonMap("a key", "a value"),
          Collections.singletonList("accept/value"),
          Collections.singletonList("content-type/value"),
          Collections.singletonList("auth name"));

  HttpRequest requestEqualsToRequest1 =
      new HttpRequest(
          "the path",
          HttpMethod.PUT,
          Collections.singletonList(new URLParameter("a name", "the value")),
          "the body",
          Collections.singletonMap("a key", "a value"),
          Collections.singletonList("accept/value"),
          Collections.singletonList("content-type/value"),
          Collections.singletonList("auth name"));

  HttpRequest requestDifferentOfRequest1 =
      new HttpRequest(
          "the path",
          HttpMethod.PUT,
          Collections.singletonList(new URLParameter("a name", "the value")),
          "the body",
          Collections.singletonMap("a key", "a value"),
          Collections.singletonList("different accept/value"),
          Collections.singletonList("content-type/value"),
          Collections.singletonList("auth name"));

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
            () -> TestHelpers.recursiveEquals(request1, requestDifferentOfRequest1),
            "Expected recursiveEquals() to throw, but it didn't");
    // expected error message hardcoded according to JUnit 5
    assertTrue(
        thrown
            .getMessage()
            .contains(
                "- actual value  : \"accept/value\"\n"
                    + "- expected value: \"different accept/value\""));
  }

  @Test
  void recursiveEqualsO1O2() {
    TestHelpers.recursiveEquals(request1, requestEqualsToRequest1);
  }

  @Test
  void recursiveEqualsO2O1() {
    TestHelpers.recursiveEquals(requestEqualsToRequest1, request1);
  }
}
