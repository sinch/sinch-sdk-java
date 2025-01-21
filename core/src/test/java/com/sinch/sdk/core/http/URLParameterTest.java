package com.sinch.sdk.core.http;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sinch.sdk.core.http.URLParameter.STYLE;
import org.junit.jupiter.api.Test;

class URLParameterTest {

  @Test
  void matrix() {
    assertEquals(STYLE.MATRIX, URLParameter.matrix);
  }

  @Test
  void label() {
    assertEquals(STYLE.LABEL, URLParameter.label);
  }

  @Test
  void form() {
    assertEquals(STYLE.FORM, URLParameter.form);
  }

  @Test
  void simple() {
    assertEquals(STYLE.SIMPLE, URLParameter.simple);
  }

  @Test
  void spaceDelimited() {
    assertEquals(STYLE.SPACE_DELIMITED, URLParameter.spaceDelimited);
  }

  @Test
  void pipeDelimited() {
    assertEquals(STYLE.PIPE_DELIMITED, URLParameter.pipeDelimited);
  }

  @Test
  void deepObject() {
    assertEquals(STYLE.DEEP_OBJECT, URLParameter.deepObject);
  }
}
