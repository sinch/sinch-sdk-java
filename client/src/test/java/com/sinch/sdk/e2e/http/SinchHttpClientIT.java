package com.sinch.sdk.e2e.http;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.core.exceptions.ApiHttpException;
import com.sinch.sdk.core.http.transport.HttpHeaders;
import com.sinch.sdk.core.http.transport.HttpResponse;
import com.sinch.sdk.e2e.Config;
import com.sinch.sdk.http.HttpCallParameters;
import com.sinch.sdk.http.SinchHttpClient;
import java.util.List;
import org.junit.jupiter.api.Test;

/** Low-level HTTP client calls onto the Numbers API of the mock server, authenticated by OAuth2 */
class SinchHttpClientIT {

  private static final String NUMBERS_URL =
      Config.NUMBERS_HOST_NAME + "/v1/projects/" + Config.PROJECT_ID;

  private final SinchHttpClient http = Config.getSinchClient().http();

  @Test
  void listActiveNumbers() {
    HttpResponse response =
        http.get(
            NUMBERS_URL + "/activeNumbers",
            HttpCallParameters.builder()
                .setQueryParameters("?regionCode=US&type=LOCAL")
                .setHeaders(new HttpHeaders().set("accept", "application/json"))
                .build());

    assertEquals(200, response.getStatus());
    List<?> activeNumbers = (List<?>) response.getContent().asMap().get("activeNumbers");
    assertEquals(2, activeNumbers.size());
  }

  @Test
  void checkAvailabilityOfAnUnavailableNumber() {
    ApiHttpException e =
        assertThrows(
            ApiHttpException.class, () -> http.get(NUMBERS_URL + "/availableNumbers/+12015555555"));

    assertEquals(404, e.getCode());
    assertTrue(e.getMessage().contains("+12015555555"), e.getMessage());
  }
}
