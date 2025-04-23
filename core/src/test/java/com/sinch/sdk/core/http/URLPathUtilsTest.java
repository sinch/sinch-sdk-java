package com.sinch.sdk.core.http;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class URLPathUtilsTest {

  @Test
  void usASCII() {
    assertEquals("foo", URLPathUtils.encodePathSegment("foo"));
  }

  @Test
  void spaces() {
    assertEquals("%20foo%20with%20spaces%20", URLPathUtils.encodePathSegment(" foo with spaces "));
  }

  @Test
  void plus() {
    assertEquals("+foo+with+plus+", URLPathUtils.encodePathSegment("+foo+with+plus+"));
  }

  @Test
  void percent() {
    assertEquals(
        "%25foo%25with%25percent%25", URLPathUtils.encodePathSegment("%foo%with%percent%"));
  }

  @Test
  void slash() {
    assertEquals("%2Ffoo%2Fwith%2Fslash%2F", URLPathUtils.encodePathSegment("/foo/with/slash/"));
  }

  @Test
  void unicode() {
    assertEquals(
        "%F0%9F%94%A5foo%F0%9F%94%A5with%F0%9F%94%A5unicode%F0%9F%93%A7",
        URLPathUtils.encodePathSegment(
            "\uD83D\uDD25foo\uD83D\uDD25with\uD83D\uDD25unicode\uD83D\uDCE7"));
  }
}
