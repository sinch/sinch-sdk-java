package com.sinch.sdk;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.VoiceRegion;
import org.junit.jupiter.api.Test;

class SinchClientTest {

  @Test
  void doNotAcceptNullKey() {
    Configuration configuration =
        Configuration.builder().setKeyId(null).setKeySecret("foo").setProjectId("foo").build();
    Exception exception =
        assertThrows(NullPointerException.class, () -> new SinchClient(configuration));
    assertTrue(exception.getMessage().contains("keyId"));
  }

  @Test
  void doNotAcceptNullKeySecret() {
    Configuration configuration =
        Configuration.builder().setKeyId("foo").setKeySecret(null).setProjectId("foo").build();
    Exception exception =
        assertThrows(NullPointerException.class, () -> new SinchClient(configuration));
    assertTrue(exception.getMessage().contains("keySecret"));
  }

  @Test
  void doNotAcceptNullProject() {
    Configuration configuration =
        Configuration.builder().setKeyId("foo").setKeySecret("foo").setProjectId(null).build();
    Exception exception =
        assertThrows(NullPointerException.class, () -> new SinchClient(configuration));
    assertTrue(exception.getMessage().contains("projectId"));
  }

  @Test
  void defaultOAuthUrlAvailable() {
    Configuration configuration =
        Configuration.builder().setKeyId("foo").setKeySecret("foo").setProjectId("foo").build();
    SinchClient client = new SinchClient(configuration);
    assertNotNull(client.getConfiguration().getOAuthUrl());
  }

  @Test
  void defaultNumbersUrlAvailable() {
    Configuration configuration =
        Configuration.builder().setKeyId("foo").setKeySecret("foo").setProjectId("foo").build();
    SinchClient client = new SinchClient(configuration);
    assertNotNull(client.getConfiguration().getNumbersUrl());
  }

  @Test
  void defaultSmsUrlAvailable() {
    Configuration configuration =
        Configuration.builder().setKeyId("foo").setKeySecret("foo").setProjectId("foo").build();
    SinchClient client = new SinchClient(configuration);
    assertNotNull(client.getConfiguration().getSmsUrl());
  }

  @Test
  void defaultVerificationUrlAvailable() {
    Configuration configuration =
        Configuration.builder().setKeyId("foo").setKeySecret("foo").setProjectId("foo").build();
    SinchClient client = new SinchClient(configuration);
    assertNotNull(client.getConfiguration().getVerificationUrl());
  }

  @Test
  void defaultVoiceUrl() {
    Configuration configuration =
        Configuration.builder().setKeyId("foo").setKeySecret("foo").setProjectId("foo").build();
    SinchClient client = new SinchClient(configuration);
    assertFalse(StringUtil.isEmpty(client.getConfiguration().getVoiceUrl()));
  }

  @Test
  void voiceUrlFromRegion() {
    Configuration configuration =
        Configuration.builder()
            .setKeyId("foo")
            .setKeySecret("foo")
            .setProjectId("foo")
            .setVoiceRegion(VoiceRegion.EUROPE)
            .build();
    SinchClient client = new SinchClient(configuration);
    assertEquals(client.getConfiguration().getVoiceUrl(), "https://calling-euc1.api.sinch.com");
  }

  @Test
  void voiceUrlFromUrl() {
    Configuration configuration =
        Configuration.builder()
            .setKeyId("foo")
            .setKeySecret("foo")
            .setProjectId("foo")
            .setVoiceRegion(VoiceRegion.EUROPE)
            .setVoiceUrl("my foo url")
            .build();
    SinchClient client = new SinchClient(configuration);
    assertEquals(client.getConfiguration().getVoiceRegion(), VoiceRegion.EUROPE);
    assertEquals(client.getConfiguration().getVoiceUrl(), "my foo url");
  }
}
