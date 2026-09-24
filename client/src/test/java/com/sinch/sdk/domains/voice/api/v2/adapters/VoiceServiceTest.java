package com.sinch.sdk.domains.voice.api.v2.adapters;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.models.UnifiedCredentials;
import com.sinch.sdk.models.VoiceContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class VoiceServiceTest {

  @Mock HttpClient httpClient;

  static final ServerConfiguration oAuthServer = new ServerConfiguration("https://oauth.foo.url");
  static final VoiceContext context = VoiceContext.builder().setVoiceV2Url("foo url").build();

  static UnifiedCredentials credentials(String keyId, String keySecret, String projectId) {
    return UnifiedCredentials.builder()
        .setKeyId(keyId)
        .setKeySecret(keySecret)
        .setProjectId(projectId)
        .build();
  }

  VoiceService service(UnifiedCredentials credentials, VoiceContext context) {
    return new VoiceService(credentials, context, oAuthServer, () -> httpClient);
  }

  @Test
  void doNotAcceptNullCredentials() {
    Exception exception =
        assertThrows(NullPointerException.class, () -> service(null, context).calls());
    assertTrue(exception.getMessage().contains("Voice V2 service requires unified credentials"));
  }

  @Test
  void doNotAcceptNullKey() {
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> service(credentials(null, "foo", "foo"), context).calls());
    assertTrue(exception.getMessage().contains("keyId"));
  }

  @Test
  void doNotAcceptNullKeySecret() {
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> service(credentials("foo", null, "foo"), context).calls());
    assertTrue(exception.getMessage().contains("keySecret"));
  }

  @Test
  void doNotAcceptNullProject() {
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> service(credentials("foo", "foo", null), context).calls());
    assertTrue(exception.getMessage().contains("projectId"));
  }

  @Test
  void doNotAcceptNullContext() {
    Exception exception =
        assertThrows(
            NullPointerException.class,
            () -> service(credentials("foo", "foo", "foo"), null).calls());
    assertTrue(exception.getMessage().contains("Voice V2 service requires context"));
  }

  @Test
  void doNotAcceptNullVoiceV2Url() {
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                service(credentials("foo", "foo", "foo"), VoiceContext.builder().build()).calls());
    assertTrue(exception.getMessage().contains("voiceV2Url"));
  }

  @Test
  void initPassed() {
    assertDoesNotThrow(() -> service(credentials("foo", "foo", "foo"), context).calls());
  }

  @Test
  void batchesInitPassed() {
    assertDoesNotThrow(() -> service(credentials("foo", "foo", "foo"), context).batches());
  }

  @Test
  void batchesDoNotAcceptNullCredentials() {
    Exception exception =
        assertThrows(NullPointerException.class, () -> service(null, context).batches());
    assertTrue(exception.getMessage().contains("Voice V2 service requires unified credentials"));
  }
}
