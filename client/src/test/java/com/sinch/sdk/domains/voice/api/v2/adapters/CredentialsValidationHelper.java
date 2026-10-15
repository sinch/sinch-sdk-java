package com.sinch.sdk.domains.voice.api.v2.adapters;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.voice.models.v2.VoiceContext;
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.function.Consumer;
import java.util.function.Supplier;

class CredentialsValidationHelper {

  static final ServerConfiguration oAuthServer = new ServerConfiguration("https://oauth.foo.url");
  static final VoiceContext context = VoiceContext.builder().setVoiceUrl("foo url").build();

  static void checkCredentials(
      Supplier<HttpClient> httpClientSupplier, Consumer<VoiceService> service) {
    doNotAcceptNullCredentials(httpClientSupplier, service);
    doNotAcceptNullKey(httpClientSupplier, service);
    doNotAcceptNullKeySecret(httpClientSupplier, service);
    doNotAcceptNullProject(httpClientSupplier, service);
    doNotAcceptNullContext(httpClientSupplier, service);
    doNotAcceptNullVoiceUrl(httpClientSupplier, service);
    passInit(httpClientSupplier, service);
  }

  private static UnifiedCredentials credentials(String keyId, String keySecret, String projectId) {
    return UnifiedCredentials.builder()
        .setKeyId(keyId)
        .setKeySecret(keySecret)
        .setProjectId(projectId)
        .build();
  }

  private static VoiceService voiceService(
      UnifiedCredentials credentials,
      VoiceContext context,
      Supplier<HttpClient> httpClientSupplier) {
    return new VoiceService(credentials, context, oAuthServer, httpClientSupplier);
  }

  private static void doNotAcceptNullCredentials(
      Supplier<HttpClient> httpClientSupplier, Consumer<VoiceService> service) {
    Exception exception =
        assertThrows(
            NullPointerException.class,
            () -> service.accept(voiceService(null, context, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("Voice V2 service requires unified credentials"));
  }

  private static void doNotAcceptNullKey(
      Supplier<HttpClient> httpClientSupplier, Consumer<VoiceService> service) {
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                service.accept(
                    voiceService(credentials(null, "foo", "foo"), context, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("keyId"));
  }

  private static void doNotAcceptNullKeySecret(
      Supplier<HttpClient> httpClientSupplier, Consumer<VoiceService> service) {
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                service.accept(
                    voiceService(credentials("foo", null, "foo"), context, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("keySecret"));
  }

  private static void doNotAcceptNullProject(
      Supplier<HttpClient> httpClientSupplier, Consumer<VoiceService> service) {
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                service.accept(
                    voiceService(credentials("foo", "foo", null), context, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("projectId"));
  }

  private static void doNotAcceptNullContext(
      Supplier<HttpClient> httpClientSupplier, Consumer<VoiceService> service) {
    Exception exception =
        assertThrows(
            NullPointerException.class,
            () ->
                service.accept(
                    voiceService(credentials("foo", "foo", "foo"), null, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("Voice V2 service requires context"));
  }

  private static void doNotAcceptNullVoiceUrl(
      Supplier<HttpClient> httpClientSupplier, Consumer<VoiceService> service) {
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                service.accept(
                    voiceService(
                        credentials("foo", "foo", "foo"),
                        VoiceContext.builder().build(),
                        httpClientSupplier)));
    assertTrue(exception.getMessage().contains("voiceUrl"));
  }

  private static void passInit(
      Supplier<HttpClient> httpClientSupplier, Consumer<VoiceService> service) {
    assertDoesNotThrow(
        () ->
            service.accept(
                voiceService(credentials("foo", "foo", "foo"), context, httpClientSupplier)),
        "Init passed");
  }
}
