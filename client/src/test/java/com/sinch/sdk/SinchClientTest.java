package com.sinch.sdk;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.SMSRegion;
import com.sinch.sdk.models.VoiceContext;
import com.sinch.sdk.models.VoiceRegion;
import org.junit.jupiter.api.Test;

class SinchClientTest {

  @Test
  void configurationNullGuard() {
    SinchClient client = new SinchClient(null);
    assertNotNull(client);
  }

  @Test
  void noConfiguration() {
    SinchClient client = new SinchClient();
    assertNotNull(client);
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
    assertNotNull(client.getConfiguration().getNumbersContext().get().getNumbersUrl());
  }

  @Test
  void defaultSmsUrlAvailable() {
    Configuration configuration =
        Configuration.builder().setKeyId("foo").setKeySecret("foo").setProjectId("foo").build();
    SinchClient client = new SinchClient(configuration);
    assertNotNull(client.getConfiguration().getSmsContext().get().getSmsUrl());
  }

  @Test
  void defaultSmsRegion() {
    Configuration configuration = Configuration.builder().build();
    SinchClient client = new SinchClient(configuration);
    assertEquals(SMSRegion.US, client.getConfiguration().getSmsContext().get().getSmsRegion());
  }

  @Test
  void defaultVerificationUrlAvailable() {
    Configuration configuration =
        Configuration.builder().setKeyId("foo").setKeySecret("foo").setProjectId("foo").build();
    SinchClient client = new SinchClient(configuration);
    assertNotNull(client.getConfiguration().getVerificationContext().get().getVerificationUrl());
  }

  @Test
  void defaultVoiceRegion() {
    Configuration configuration = Configuration.builder().build();
    SinchClient client = new SinchClient(configuration);
    assertEquals(
        VoiceRegion.GLOBAL, client.getConfiguration().getVoiceContext().get().getVoiceRegion());
  }

  @Test
  void defaultVoiceUrl() {
    Configuration configuration =
        Configuration.builder().setKeyId("foo").setKeySecret("foo").setProjectId("foo").build();
    SinchClient client = new SinchClient(configuration);
    assertFalse(
        StringUtil.isEmpty(client.getConfiguration().getVoiceContext().get().getVoiceUrl()));
  }

  @Test
  void defaultVoiceApplicationManagementUrl() {
    Configuration configuration =
        Configuration.builder().setKeyId("foo").setKeySecret("foo").setProjectId("foo").build();
    SinchClient client = new SinchClient(configuration);
    assertFalse(
        StringUtil.isEmpty(
            client.getConfiguration().getVoiceContext().get().getVoiceApplicationManagementUrl()));
  }

  @Test
  void voiceUrlFromRegion() {
    Configuration configuration =
        Configuration.builder()
            .setKeyId("foo")
            .setKeySecret("foo")
            .setProjectId("foo")
            .setVoiceContext(VoiceContext.builder().setVoiceRegion(VoiceRegion.EUROPE).build())
            .build();
    SinchClient client = new SinchClient(configuration);
    assertEquals(
        client.getConfiguration().getVoiceContext().get().getVoiceUrl(),
        "https://calling-euc1.api.sinch.com");
  }

  @Test
  void voiceUrlFromUrl() {
    Configuration configuration =
        Configuration.builder()
            .setKeyId("foo")
            .setKeySecret("foo")
            .setProjectId("foo")
            .setVoiceContext(
                VoiceContext.builder()
                    .setVoiceRegion(VoiceRegion.EUROPE)
                    .setVoiceUrl("my foo url")
                    .build())
            .build();
    SinchClient client = new SinchClient(configuration);
    assertEquals(
        client.getConfiguration().getVoiceContext().get().getVoiceRegion(), VoiceRegion.EUROPE);
    assertEquals(client.getConfiguration().getVoiceContext().get().getVoiceUrl(), "my foo url");
  }

  @Test
  void voiceApplicationManagementUrlFromUrl() {
    Configuration configuration =
        Configuration.builder()
            .setKeyId("foo")
            .setKeySecret("foo")
            .setProjectId("foo")
            .setVoiceContext(
                VoiceContext.builder().setVoiceApplicationMngmtUrl("my foo url").build())
            .build();
    SinchClient client = new SinchClient(configuration);
    assertEquals(
        client.getConfiguration().getVoiceContext().get().getVoiceApplicationManagementUrl(),
        "my foo url");
  }
}
