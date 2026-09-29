package com.sinch.sdk.domains.verification.api.v1.adapters;

import com.sinch.sdk.auth.SinchEventsApplicationAuthValidationTest;
import com.sinch.sdk.models.ApplicationCredentials;
import com.sinch.sdk.models.VerificationContext;
import java.util.Map;

public class SinchEventsAuthenticationValidationTest
    extends SinchEventsApplicationAuthValidationTest {

  static final String APPLICATION_KEY = "789";
  static final String APPLICATION_SECRET = "9876543210";
  static final String PATH = "/VerificationRequestEvent";
  static final String CONTENT_TYPE = "application/json; charset=utf-8";
  static final String TIMESTAMP = "2023-12-01T15:01:20.0406449Z";
  static final String PAYLOAD =
      "{\"id\":\"018c25e1-7163-5677-b8fb-467d7b1cffa5\",\"event\":\"VerificationResultEvent\",\"method\":\"sms\",\"identity\":{\"verified\":false,\"type\":\"number\",\"endpoint\":\"+33628254417\"},\"status\":\"FAIL\",\"reason\":\"Expired\"}";
  static final String SIGNATURE = "xfKhO0XvlRNJraahUBEJzzi1f3Fn3pYO41/ZzwOHPaQ=";

  final SinchEventsService service =
      new VerificationService(
              ApplicationCredentials.builder()
                  .setApplicationKey(APPLICATION_KEY)
                  .setApplicationSecret(APPLICATION_SECRET)
                  .build(),
              VerificationContext.builder().setVerificationUrl("foo").build(),
              null)
          .sinchEvents();

  @Override
  protected boolean validateAuthenticationHeader(
      String method, String path, Map<String, String> headers, String jsonPayload) {
    return service.validateAuthenticationHeader(method, path, headers, jsonPayload);
  }

  @Override
  protected String applicationKey() {
    return APPLICATION_KEY;
  }

  @Override
  protected String path() {
    return PATH;
  }

  @Override
  protected String contentType() {
    return CONTENT_TYPE;
  }

  @Override
  protected String timestamp() {
    return TIMESTAMP;
  }

  @Override
  protected String payload() {
    return PAYLOAD;
  }

  @Override
  protected String signature() {
    return SIGNATURE;
  }
}
