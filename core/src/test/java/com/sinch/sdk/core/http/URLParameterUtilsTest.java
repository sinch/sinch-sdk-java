package com.sinch.sdk.core.http;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.databind.query_parameter.InstantToIso8601Serializer;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.URLParameter.STYLE;
import com.sinch.sdk.core.models.OptionalValue;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class URLParameterUtilsTest {

  @Test
  void encodeNull() {
    Assertions.assertEquals(Optional.empty(), URLParameterUtils.encode(null));
  }

  @Test
  void encodeEmptyName() {
    assertEquals(Optional.empty(), URLParameterUtils.encode(new URLParameter("", "foo")));
  }

  @Test
  void encodeNullName() {
    assertEquals(Optional.empty(), URLParameterUtils.encode(new URLParameter(null, "foo")));
  }

  @Test
  void encodeFormNullValueNoExplode() {
    assertEquals(
        Optional.empty(),
        URLParameterUtils.encode(new URLParameter("foo", null, URLParameter.STYLE.FORM, false)));
  }

  @Test
  void encodeFormNullValueExplode() {
    assertEquals(
        Optional.empty(),
        URLParameterUtils.encode(new URLParameter("foo", null, URLParameter.STYLE.FORM, true)));
  }

  @Test
  void encodeMatrixEmptyStringNoExplode() {
    assertEquals(
        Optional.of(";foo"),
        URLParameterUtils.encode(new URLParameter("foo", "", URLParameter.STYLE.MATRIX, false)));
  }

  @Test
  void encodeMatrixEmptyStringExplode() {
    assertEquals(
        Optional.of(";foo"),
        URLParameterUtils.encode(new URLParameter("foo", "", URLParameter.STYLE.MATRIX, true)));
  }

  @Test
  void encodeMatrixStringNoExplode() {
    assertEquals(
        Optional.of(";foo=value+with+space+and+%26%2C%2E"),
        URLParameterUtils.encode(
            new URLParameter("foo", "value with space and &,.", URLParameter.STYLE.MATRIX, false)));
  }

  @Test
  void encodeMatrixStringExplode() {
    assertEquals(
        Optional.of(";foo+with+space+and+%26%2C%2E=value+with+space+and+%26%2C%2E"),
        URLParameterUtils.encode(
            new URLParameter(
                "foo with space and &,.",
                "value with space and &,.",
                URLParameter.STYLE.MATRIX,
                true)));
  }

  @Test
  void encodeLabelEmptyStringNoExplode() {
    assertEquals(
        Optional.of("."),
        URLParameterUtils.encode(new URLParameter("foo", "", URLParameter.STYLE.LABEL, false)));
  }

  @Test
  void encodeLabelEmptyStringExplode() {
    assertEquals(
        Optional.of("."),
        URLParameterUtils.encode(new URLParameter("foo", "", URLParameter.STYLE.LABEL, true)));
  }

  @Test
  void encodeLabelStringNoExplode() {
    assertEquals(
        Optional.of(".value+with+space+and+%26%2C%2E"),
        URLParameterUtils.encode(
            new URLParameter("foo", "value with space and &,.", URLParameter.STYLE.LABEL, false)));
  }

  @Test
  void encodeLabelStringExplode() {
    assertEquals(
        Optional.of(".value+with+space+and+%26%2C%2E"),
        URLParameterUtils.encode(
            new URLParameter("foo", "value with space and &,.", URLParameter.STYLE.LABEL, true)));
  }

  @Test
  void encodeFormEmptyStringNoExplode() {
    assertEquals(
        Optional.of("foo="),
        URLParameterUtils.encode(new URLParameter("foo", "", URLParameter.STYLE.FORM, false)));
  }

  @Test
  void encodeFormEmptyStringExplode() {
    assertEquals(
        Optional.of("foo="),
        URLParameterUtils.encode(new URLParameter("foo", "", URLParameter.STYLE.FORM, true)));
  }

  @Test
  void encodeFormStringNoExplode() {
    assertEquals(
        Optional.of("foo=value+with+space+and+%26%2C%2E"),
        URLParameterUtils.encode(
            new URLParameter("foo", "value with space and &,.", URLParameter.STYLE.FORM, false)));
  }

  @Test
  void encodeFormStringExplode() {
    assertEquals(
        Optional.of("foo=value+with+space+and+%26%2C%2E"),
        URLParameterUtils.encode(
            new URLParameter("foo", "value with space and &,.", URLParameter.STYLE.FORM, true)));
  }

  @Test
  void encodeFormStringArrayNoExplode() {
    assertEquals(
        Optional.of("foo=value1+with+space+and+%26%2C%2E,value2+with+space+and+%26%2C%2E"),
        URLParameterUtils.encode(
            new URLParameter(
                "foo",
                Arrays.asList("value1 with space and &,.", "value2 with space and &,."),
                URLParameter.STYLE.FORM,
                false)));
  }

  @Test
  void encodeFormStringArrayExplode() {
    assertEquals(
        Optional.of("foo=value1+with+space+and+%26%2C%2E&foo=value2+with+space+and+%26%2C%2E"),
        URLParameterUtils.encode(
            new URLParameter(
                "foo",
                Arrays.asList("value1 with space and &,.", "value2 with space and &,."),
                URLParameter.STYLE.FORM,
                true)));
  }

  @Test
  void encodeDynamicEnumNoExplode() {
    assertEquals(
        Optional.of("foo=ENUM1+value"),
        URLParameterUtils.encode(
            new URLParameter("foo", AnEnum.ENUM1, URLParameter.STYLE.FORM, false)));
  }

  @Test
  void encodeDynamicEnumExplode() {
    assertEquals(
        Optional.of("foo=ENUM1+value"),
        URLParameterUtils.encode(
            new URLParameter("foo", AnEnum.ENUM1, URLParameter.STYLE.FORM, true)));
  }

  @Test
  void encodeDynamicEnumArrayNoExplode() {
    assertEquals(
        Optional.of("foo=ENUM1+value,ENUM2+value"),
        URLParameterUtils.encode(
            new URLParameter(
                "foo", Arrays.asList(AnEnum.ENUM1, AnEnum.ENUM2), URLParameter.STYLE.FORM, false)));
  }

  @Test
  void encodeDynamicEnumArrayExplode() {
    assertEquals(
        Optional.of("foo=ENUM1+value&foo=ENUM2+value"),
        URLParameterUtils.encode(
            new URLParameter(
                "foo", Arrays.asList(AnEnum.ENUM1, AnEnum.ENUM2), URLParameter.STYLE.FORM, true)));
  }

  @Test
  void encodeSimpleEmptyStringNoExplode() {
    assertThrows(
        ApiException.class,
        () ->
            URLParameterUtils.encode(
                new URLParameter("foo", "", URLParameter.STYLE.SIMPLE, false)));
  }

  @Test
  void encodeSimpleEmptyStringExplode() {
    assertThrows(
        ApiException.class,
        () ->
            URLParameterUtils.encode(new URLParameter("foo", "", URLParameter.STYLE.SIMPLE, true)));
  }

  @Test
  void encodeSimpleStringNoExplode() {
    assertEquals(
        Optional.of("value+with+space+and+%26%2C%2E"),
        URLParameterUtils.encode(
            new URLParameter(
                "foo. with space and &,.",
                "value with space and &,.",
                URLParameter.STYLE.SIMPLE,
                false)));
  }

  @Test
  void encodeSimpleStringExplode() {
    assertEquals(
        Optional.of("value+with+space+and+%26%2C%2E"),
        URLParameterUtils.encode(
            new URLParameter("foo", "value with space and &,.", URLParameter.STYLE.SIMPLE, true)));
  }

  @Test
  void encodeMatrixArrayNoExplode() {
    assertEquals(
        Optional.of(";foo=value1+with+space+and+%26%2C%2E,value2+with+space+and+%26%2C%2E"),
        URLParameterUtils.encode(
            new URLParameter(
                "foo",
                Arrays.asList("value1 with space and &,.", "value2 with space and &,."),
                URLParameter.STYLE.MATRIX,
                false)));
  }

  @Test
  void encodeMatrixArrayExplode() {
    assertEquals(
        Optional.of(";foo=value1+with+space+and+%26%2C%2E;foo=value2+with+space+and+%26%2C%2E"),
        URLParameterUtils.encode(
            new URLParameter(
                "foo",
                Arrays.asList("value1 with space and &,.", "value2 with space and &,."),
                URLParameter.STYLE.MATRIX,
                true)));
  }

  @Test
  void encodeLabelArrayNoExplode() {
    assertEquals(
        Optional.of(".value1+with+space+and+%26%2C%2E.value2+with+space+and+%26%2C%2E"),
        URLParameterUtils.encode(
            new URLParameter(
                "foo",
                Arrays.asList("value1 with space and &,.", "value2 with space and &,."),
                URLParameter.STYLE.LABEL,
                false)));
  }

  @Test
  void encodeLabelArrayExplode() {
    assertEquals(
        Optional.of(".value1+with+space+and+%26%2C%2E.value2+with+space+and+%26%2C%2E"),
        URLParameterUtils.encode(
            new URLParameter(
                "foo",
                Arrays.asList("value1 with space and &,.", "value2 with space and &,."),
                URLParameter.STYLE.LABEL,
                true)));
  }

  @Test
  void encodeFormArrayNoExplode() {
    assertEquals(
        Optional.of("foo=value1+with+space+and+%26%2C%2E,value2+with+space+and+%26%2C%2E"),
        URLParameterUtils.encode(
            new URLParameter(
                "foo",
                Arrays.asList("value1 with space and &,.", "value2 with space and &,."),
                URLParameter.STYLE.FORM,
                false)));
  }

  @Test
  void encodeFormArrayExplode() {
    assertEquals(
        Optional.of("foo=value1+with+space+and+%26%2C%2E&foo=value2+with+space+and+%26%2C%2E"),
        URLParameterUtils.encode(
            new URLParameter(
                "foo",
                Arrays.asList("value1 with space and &,.", "value2 with space and &,."),
                URLParameter.STYLE.FORM,
                true)));
  }

  @Test
  void encodeSimpleArrayNoExplode() {
    assertEquals(
        Optional.of("value1+with+space+and+%26%2C%2E,value2+with+space+and+%26%2C%2E"),
        URLParameterUtils.encode(
            new URLParameter(
                "foo with space and &,.",
                Arrays.asList("value1 with space and &,.", "value2 with space and &,."),
                URLParameter.STYLE.SIMPLE,
                false)));
  }

  @Test
  void encodeSimpleArrayExplode() {
    assertEquals(
        Optional.of("value1+with+space+and+%26%2C%2E,value2+with+space+and+%26%2C%2E"),
        URLParameterUtils.encode(
            new URLParameter(
                "foo",
                Arrays.asList("value1 with space and &,.", "value2 with space and &,."),
                URLParameter.STYLE.SIMPLE,
                true)));
  }

  @Test
  void encodeSpaceDelimitedArrayNoExplode() {
    assertEquals(
        Optional.of("value1+with+space+and+%26%2C%2E%20value2+with+space+and+%26%2C%2E"),
        URLParameterUtils.encode(
            new URLParameter(
                "foo with space and &,.",
                Arrays.asList("value1 with space and &,.", "value2 with space and &,."),
                URLParameter.STYLE.SPACE_DELIMITED,
                false)));
  }

  @Test
  void encodeSpaceDelimitedArrayExplode() {
    assertThrows(
        ApiException.class,
        () ->
            URLParameterUtils.encode(
                new URLParameter(
                    "foo",
                    Arrays.asList("value1 with space and &,.", "value2 with space and &,."),
                    URLParameter.STYLE.SPACE_DELIMITED,
                    true)));
  }

  @Test
  void encodePipeDelimitedArrayNoExplode() {
    assertEquals(
        Optional.of("value1+with+space+and+%26%2C%2E|value2+with+space+and+%26%2C%2E"),
        URLParameterUtils.encode(
            new URLParameter(
                "foo",
                Arrays.asList("value1 with space and &,.", "value2 with space and &,."),
                URLParameter.STYLE.PIPE_DELIMITED,
                false)));
  }

  @Test
  void encodePipeDelimitedArrayExplode() {
    assertThrows(
        ApiException.class,
        () ->
            URLParameterUtils.encode(
                new URLParameter(
                    "foo",
                    Arrays.asList("value1 with space and &,.", "value2 with space and &,."),
                    URLParameter.STYLE.PIPE_DELIMITED,
                    true)));
  }

  @Test
  void addQueryParamNotPresent() {

    // Collections.emptyList() is not modifiable and will throw an exception if trying to add an
    // entry
    assertDoesNotThrow(
        () ->
            URLParameterUtils.addQueryParam(
                OptionalValue.empty(),
                "foo name",
                STYLE.DEEP_OBJECT,
                null,
                Collections.emptyList(),
                false),
        "Ignored empty value");
  }

  @Test
  void addQueryParamInteger() {
    ArrayList<URLParameter> list = new ArrayList<>();

    URLParameterUtils.addQueryParam(
        OptionalValue.of(15), "foo name", STYLE.DEEP_OBJECT, null, list, true);
    assertEquals(1, list.size());

    TestHelpers.recursiveEquals(
        list.get(0), new URLParameter("foo name", 15, STYLE.DEEP_OBJECT, true));
  }

  @Test
  void addQueryParamInstant() {
    ArrayList<URLParameter> list = new ArrayList<>();

    URLParameterUtils.addQueryParam(
        OptionalValue.of(Instant.parse("2024-05-04T10:00:00.123Z")),
        "foo name",
        STYLE.DEEP_OBJECT,
        InstantToIso8601Serializer.getInstance(),
        list,
        true);
    assertEquals(1, list.size());

    TestHelpers.recursiveEquals(
        list.get(0),
        new URLParameter("foo name", "2024-05-04T10:00:00.123Z", STYLE.DEEP_OBJECT, true));
  }
}
