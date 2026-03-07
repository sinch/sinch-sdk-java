package com.sinch.sdk.domains.numbers.api.v1.adapters;

import static org.junit.jupiter.api.Assertions.*;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class SinchEventsAuthenticationValidationTest {

  SinchEventsAuthenticationValidation sinchEventsAuthenticationValidation =
      new SinchEventsAuthenticationValidation();

  static final String loweredKey =
      SinchEventsAuthenticationValidation.SIGNATURE_HEADER.toLowerCase();
  Map<String, String> headers =
      Stream.of(
              new AbstractMap.SimpleEntry<>(loweredKey, "e289b8fac44491417aeceee28d2715840b5f1aca"))
          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

  String secret = "secret value";
  String body =
      "{\"eventId\":\"01j3fycq0fyqq3gkgxb0g5ekbz\",\"timestamp\":\"2024-07-23T14:02:14.415637289\",\"projectId\":\"b8bae3c6-e7df-422b-9401-8ae3ee3e0aff\",\"resourceId\":\"+12053017799\",\"resourceType\":\"ACTIVE_NUMBER\",\"eventType\":\"PROVISIONING_TO_VOICE_PLATFORM\",\"status\":\"SUCCEEDED\",\"failureCode\":null}";

  @Test
  void checkValidateAuthenticatedRequest() {

    boolean authenticationResult =
        sinchEventsAuthenticationValidation.validateAuthenticationHeader(secret, headers, body);

    assertTrue(authenticationResult);
  }

  @Test
  void checkValidateAuthenticatedRequestInvalidSecret() {

    boolean authenticationResult =
        sinchEventsAuthenticationValidation.validateAuthenticationHeader(
            "not expected secret", headers, body);

    assertFalse(authenticationResult);
  }

  @Test
  void checkValidateAuthenticatedRequestInvalidBody() {

    boolean authenticationResult =
        sinchEventsAuthenticationValidation.validateAuthenticationHeader(
            secret, headers, "not expected body");

    assertFalse(authenticationResult);
  }

  @Test
  void checkValidateAuthenticatedRequestMissingSignature() {

    Map<String, String> headerSet =
        headers.entrySet().stream()
            .filter(entry -> !entry.getKey().equals(loweredKey))
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

    boolean authenticationResult =
        sinchEventsAuthenticationValidation.validateAuthenticationHeader(secret, headerSet, body);

    assertFalse(authenticationResult);
  }

  @Test
  void checkValidateAuthenticatedNoSecret() {

    boolean authenticationResult =
        sinchEventsAuthenticationValidation.validateAuthenticationHeader(null, headers, body);

    assertFalse(authenticationResult);
  }

  @Test
  void checkValidateAuthenticatedEmptySecret() {

    boolean authenticationResult =
        sinchEventsAuthenticationValidation.validateAuthenticationHeader("", headers, body);

    assertFalse(authenticationResult);
  }
}
