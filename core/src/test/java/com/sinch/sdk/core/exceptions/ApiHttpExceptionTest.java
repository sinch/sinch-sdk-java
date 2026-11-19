package com.sinch.sdk.core.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.core.http.transport.BufferedHttpContentParser;
import com.sinch.sdk.core.http.transport.HttpHeaders;
import com.sinch.sdk.core.http.transport.HttpResponse;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

class ApiHttpExceptionTest {

  @Test
  void codeIsTheStatusAndTheResponseIsKept() {
    HttpResponse response = response(404, "Not Found", "{}");

    ApiHttpException e = new ApiHttpException(response);

    assertEquals(404, e.getCode());
    assertSame(response, e.getResponse());
  }

  @Test
  void messageOfANumbersOrConversationError() {
    ApiHttpException e =
        new ApiHttpException(
            response(
                400,
                "Bad Request",
                "{\"error\":{\"code\":400,\"message\":\"Invalid"
                    + " number\",\"status\":\"INVALID_ARGUMENT\"}}"));

    assertEquals("INVALID_ARGUMENT: Invalid number", e.getMessage());
  }

  @Test
  void messageOfAnSmsError() {
    ApiHttpException e =
        new ApiHttpException(
            response(400, null, "{\"code\":\"syntax_invalid_json\",\"text\":\"Invalid JSON\"}"));

    assertEquals("syntax_invalid_json: Invalid JSON", e.getMessage());
  }

  @Test
  void messageOfAProblemDetailsError() {
    ApiHttpException e =
        new ApiHttpException(
            response(
                422,
                null,
                "{\"type\":\"about:blank\",\"title\":\"Invalid\",\"detail\":\"Bad cli\"}"));

    assertEquals("Invalid: Bad cli", e.getMessage());
    assertEquals(422, e.getCode());
  }

  @Test
  void codeRemainsTheStatusWhenTheErrorCarriesAnotherOne() {
    ApiHttpException e =
        new ApiHttpException(
            response(
                403,
                null,
                "{\"error\":{\"code\":7,\"message\":\"Denied\",\"status\":\"PERMISSION_DENIED\"}}"));

    assertEquals(403, e.getCode());
    assertEquals("PERMISSION_DENIED: Denied", e.getMessage());
  }

  @Test
  void messageOfAnUnknownJsonContent() {
    ApiHttpException e = new ApiHttpException(response(500, "Server Error", "{\"foo\":\"bar\"}"));

    assertEquals("HTTP 500 Server Error", e.getMessage());
  }

  @Test
  void messageOfANonJsonContent() {
    ApiHttpException e = new ApiHttpException(response(502, "Bad Gateway", "<html></html>"));

    assertEquals("HTTP 502 Bad Gateway", e.getMessage());
    assertEquals("<html></html>", e.getResponse().getContent().asString());
  }

  @Test
  void messageWithoutReasonPhraseNorContent() {
    ApiHttpException e = new ApiHttpException(response(404, null, null));

    assertEquals("HTTP 404", e.getMessage());
  }

  private static HttpResponse response(int status, String reasonPhrase, String content) {
    return new HttpResponse(
        status,
        reasonPhrase,
        new HttpHeaders().set("content-type", "application/json"),
        new BufferedHttpContentParser(
            null == content ? null : content.getBytes(StandardCharsets.UTF_8), "application/json"));
  }
}
