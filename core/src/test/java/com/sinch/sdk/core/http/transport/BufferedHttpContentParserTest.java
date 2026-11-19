package com.sinch.sdk.core.http.transport;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.core.exceptions.ApiException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class BufferedHttpContentParserTest {

  @Test
  void asStringDefaultsToUtf8() {
    String text = "Ünïcödé résülts";

    BufferedHttpContentParser parser =
        new BufferedHttpContentParser(text.getBytes(StandardCharsets.UTF_8), null);

    assertEquals(text, parser.asString());
  }

  @Test
  void asStringUsesContentTypeCharset() {
    String text = "café";

    BufferedHttpContentParser parser =
        new BufferedHttpContentParser(
            text.getBytes(StandardCharsets.ISO_8859_1), "text/plain; charset=ISO-8859-1");

    assertEquals(text, parser.asString());
  }

  @Test
  void asStringFallsBackToUtf8OnUnknownCharset() {
    String text = "café";

    BufferedHttpContentParser parser =
        new BufferedHttpContentParser(
            text.getBytes(StandardCharsets.UTF_8), "text/plain; charset=not-a-charset");

    assertEquals(text, parser.asString());
  }

  @Test
  void asBytesIsTheContentReceived() {
    byte[] bytes = {(byte) 0xff, (byte) 0xd8, 0, 1};

    BufferedHttpContentParser parser = new BufferedHttpContentParser(bytes, "image/jpeg");

    assertArrayEquals(bytes, parser.asBytes());
    parser.asBytes()[0] = 0;
    assertArrayEquals(bytes, parser.asBytes());
  }

  @Test
  void asStreamCanBeReadSeveralTimes() throws IOException {
    byte[] bytes = "foo".getBytes(StandardCharsets.UTF_8);

    BufferedHttpContentParser parser = new BufferedHttpContentParser(bytes, null);

    assertArrayEquals(bytes, readAll(parser.asStream()));
    assertArrayEquals(bytes, readAll(parser.asStream()));
  }

  @Test
  @SuppressWarnings("unchecked")
  void asMapReadsNestedFields() {
    String json =
        "{\"recipient\":{\"phoneNumber\":\"+1234\"},\"tags\":[\"a\",\"b\"],"
            + "\"count\":3,\"active\":true,\"missing\":null}";

    Map<String, Object> map =
        new BufferedHttpContentParser(json.getBytes(StandardCharsets.UTF_8), "application/json")
            .asMap();

    assertEquals("+1234", ((Map<String, Object>) map.get("recipient")).get("phoneNumber"));
    assertEquals(Arrays.asList("a", "b"), (List<String>) map.get("tags"));
    assertEquals(3, map.get("count"));
    assertEquals(true, map.get("active"));
    assertTrue(map.containsKey("missing"));
    assertNull(map.get("missing"));
    assertFalse(map.containsKey("unknown"));
    assertArrayEquals(
        new Object[] {"recipient", "tags", "count", "active", "missing"}, map.keySet().toArray());
  }

  @Test
  void asMapOfNoContentIsEmpty() {
    assertEquals(Collections.emptyMap(), new BufferedHttpContentParser(null, null).asMap());
    assertEquals(Collections.emptyMap(), new BufferedHttpContentParser(new byte[0], null).asMap());
  }

  @Test
  void asMapRejectsAnArray() {
    BufferedHttpContentParser parser =
        new BufferedHttpContentParser("[1,2]".getBytes(StandardCharsets.UTF_8), null);

    assertThrows(ApiException.class, parser::asMap);
  }

  @Test
  void asMapRejectsInvalidJson() {
    BufferedHttpContentParser parser =
        new BufferedHttpContentParser("not json".getBytes(StandardCharsets.UTF_8), null);

    assertThrows(ApiException.class, parser::asMap);
  }

  @Test
  void noContent() {
    BufferedHttpContentParser parser = new BufferedHttpContentParser(null, null);

    assertEquals("", parser.asString());
    assertArrayEquals(new byte[0], parser.asBytes());
  }

  private static byte[] readAll(InputStream in) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    byte[] buffer = new byte[256];
    int read;
    while ((read = in.read(buffer)) != -1) {
      out.write(buffer, 0, read);
    }
    return out.toByteArray();
  }
}
