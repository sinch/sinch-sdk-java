package com.sinch.sdk.domains.conversation.api.v1.adapters;

import static org.junit.jupiter.api.Assertions.*;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class ConversationWebhooksAuthenticationValidationTest {

  ConversationWebhooksAuthenticationValidation webhooksService =
      new ConversationWebhooksAuthenticationValidation();

  Map<String, String> headers =
      Stream.of(
              new AbstractMap.SimpleEntry<>(
                  ConversationWebhooksAuthenticationValidation.SIGNATURE_HEADER,
                  "6bpJoRmFoXVjfJIVglMoJzYXxnoxRujzR4k2GOXewOE="),
              new AbstractMap.SimpleEntry<>(
                  ConversationWebhooksAuthenticationValidation.ALGORITHM_HEADER, "HmacSHA256"),
              new AbstractMap.SimpleEntry<>(
                  ConversationWebhooksAuthenticationValidation.NONCE_HEADER,
                  "01FJA8B4A7BM43YGWSG9GBV067"),
              new AbstractMap.SimpleEntry<>(
                  ConversationWebhooksAuthenticationValidation.TIMESTAMP_HEADER, "1634579353"))
          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

  String secret = "foo_secret1234";
  String body =
      "{\"app_id\":\"\",\"accepted_time\":\"2021-10-18T17:49:13.813615Z\",\"project_id\":\"e2df3a34-a71b-4448-9db5-a8d2baad28e4\",\"contact_create_notification\":{\"contact\":{\"id\":\"01FJA8B466Y0R2GNXD78MD9SM1\",\"channel_identities\":[{\"channel\":\"SMS\",\"identity\":\"48123456789\",\"app_id\":\"\"}],\"display_name\":\"New"
          + " Test"
          + " Contact\",\"email\":\"new.contact@email.com\",\"external_id\":\"\",\"metadata\":\"\",\"language\":\"EN_US\"}},\"message_metadata\":\"\"}";

  @Test
  void checkValidateAuthenticatedRequest() {

    boolean authenticationResult =
        webhooksService.validateAuthenticationHeader(secret, headers, body);

    assertTrue(authenticationResult);
  }

  @Test
  void checkValidateAuthenticatedRequestInvalidSecret() {

    boolean authenticationResult =
        webhooksService.validateAuthenticationHeader("not expected secret", headers, body);

    assertFalse(authenticationResult);
  }

  @Test
  void checkValidateAuthenticatedRequestInvalidBody() {

    boolean authenticationResult =
        webhooksService.validateAuthenticationHeader(secret, headers, "not expected body");

    assertFalse(authenticationResult);
  }

  @Test
  void checkValidateAuthenticatedRequestMissingSignature() {

    Map<String, String> headerSet =
        headers.entrySet().stream()
            .filter(
                entry ->
                    !entry
                        .getKey()
                        .equals(ConversationWebhooksAuthenticationValidation.SIGNATURE_HEADER))
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

    boolean authenticationResult =
        webhooksService.validateAuthenticationHeader(secret, headerSet, body);

    assertFalse(authenticationResult);
  }

  @Test
  void checkValidateAuthenticatedRequestMissingAlgorithm() {

    Map<String, String> headerSet =
        headers.entrySet().stream()
            .filter(
                entry ->
                    !entry
                        .getKey()
                        .equals(ConversationWebhooksAuthenticationValidation.ALGORITHM_HEADER))
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

    boolean authenticationResult =
        webhooksService.validateAuthenticationHeader(secret, headerSet, body);

    assertFalse(authenticationResult);
  }

  @Test
  void checkValidateAuthenticatedMissingNonce() {

    Map<String, String> headerSet =
        headers.entrySet().stream()
            .filter(
                entry ->
                    !entry
                        .getKey()
                        .equals(ConversationWebhooksAuthenticationValidation.NONCE_HEADER))
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

    boolean authenticationResult =
        webhooksService.validateAuthenticationHeader(secret, headerSet, body);

    assertFalse(authenticationResult);
  }

  @Test
  void checkValidateAuthenticatedMissingTimeStamp() {

    Map<String, String> headerSet =
        headers.entrySet().stream()
            .filter(
                entry ->
                    !entry
                        .getKey()
                        .equals(ConversationWebhooksAuthenticationValidation.TIMESTAMP_HEADER))
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

    boolean authenticationResult =
        webhooksService.validateAuthenticationHeader(secret, headerSet, body);

    assertFalse(authenticationResult);
  }

  @Test
  void checkValidateAuthenticatedNoSecret() {

    boolean authenticationResult =
        webhooksService.validateAuthenticationHeader(null, headers, body);

    assertFalse(authenticationResult);
  }
}
