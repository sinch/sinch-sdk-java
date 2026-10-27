package com.sinch.sdk.core.http.transport;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class HttpContentTest {

  @Test
  void ofString() {
    HttpContent content = HttpContent.ofString("foo");

    assertInstanceOf(HttpContent.StringContent.class, content);
    assertEquals("foo", ((HttpContent.StringContent) content).getValue());
  }

  @Test
  void ofBytes() {
    byte[] bytes = {1, 2, 3};
    HttpContent content = HttpContent.ofBytes(bytes);

    assertInstanceOf(HttpContent.BytesContent.class, content);
    assertSame(bytes, ((HttpContent.BytesContent) content).getValue());
  }

  @Test
  void ofFile() {
    File file = new File("foo.txt");
    HttpContent content = HttpContent.ofFile(file);

    assertInstanceOf(HttpContent.FileContent.class, content);
    assertSame(file, ((HttpContent.FileContent) content).getFile());
  }

  @Test
  void ofFormDataKeepsOrderAndIsImmutable() {
    Map<String, Object> parameters = new LinkedHashMap<>();
    parameters.put("to", "someone@adomain.com");
    parameters.put("from", "myself@sinch.com");
    HttpContent content = HttpContent.ofFormData(parameters);

    parameters.put("text", "Hello");

    assertInstanceOf(HttpContent.FormDataContent.class, content);
    Map<String, Object> actual = ((HttpContent.FormDataContent) content).getParameters();
    assertArrayEquals(new Object[] {"to", "from"}, actual.keySet().toArray());
    assertThrows(UnsupportedOperationException.class, () -> actual.put("text", "Hello"));
  }

  @Test
  void nullIsRejected() {
    assertThrows(NullPointerException.class, () -> HttpContent.ofString(null));
    assertThrows(NullPointerException.class, () -> HttpContent.ofBytes(null));
    assertThrows(NullPointerException.class, () -> HttpContent.ofFile(null));
    assertThrows(NullPointerException.class, () -> HttpContent.ofFormData(null));
  }
}
