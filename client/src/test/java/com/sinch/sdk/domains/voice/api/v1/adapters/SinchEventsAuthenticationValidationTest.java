package com.sinch.sdk.domains.voice.api.v1.adapters;

import com.sinch.sdk.auth.SignedRequestValidationTestBase;
import com.sinch.sdk.models.ApplicationCredentials;
import com.sinch.sdk.models.VoiceContext;
import java.util.Map;

public class SinchEventsAuthenticationValidationTest extends SignedRequestValidationTestBase {

  static final String APPLICATION_KEY = "669E367E-6BBA-48AB-AF15-266871C28135";
  static final String APPLICATION_SECRET = "BeIukql3pTKJ8RGL5zo0DA==";
  static final String PATH = "/sinch/callback/ace";
  static final String CONTENT_TYPE = "application/json";
  static final String TIMESTAMP = "2014-09-24T10:59:41Z";
  static final String PAYLOAD =
      "{\"event\":\"ace\",\"callid\":\"822aa4b7-05b4-4d83-87c7-1f835ee0b6f6_257\",\"timestamp\":\"2014-09-24T10:59:41Z\",\"version\":1}";
  static final String SIGNATURE = "Tg6fMyo8mj9pYfWQ9ssbx3Tc1BNC87IEygAfLbJqZb4=";

  final SinchEventsService service =
      new VoiceService(
              ApplicationCredentials.builder()
                  .setApplicationKey(APPLICATION_KEY)
                  .setApplicationSecret(APPLICATION_SECRET)
                  .build(),
              VoiceContext.builder().setVoiceUrl("foo url").build(),
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
