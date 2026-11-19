package com.sinch.sdk.core.http.transport;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
import org.junit.jupiter.api.Test;

class HttpResponseTest {

  @Test
  void headersAreCopiedAndReadOnly() {
    HttpHeaders headers = new HttpHeaders().add("A", "1");
    HttpResponse response =
        new HttpResponse(200, "OK", headers, new BufferedHttpContentParser(null, null));

    headers.add("A", "2");

    assertEquals(1, response.getHeaders().getAll("A").size());
    assertThrows(UnsupportedOperationException.class, () -> response.getHeaders().add("A", "3"));
  }

  @Test
  void reasonPhraseIsOptional() {
    HttpResponse response =
        new HttpResponse(200, null, new HttpHeaders(), new BufferedHttpContentParser(null, null));

    assertEquals(Optional.empty(), response.getReasonPhrase());
  }
}
