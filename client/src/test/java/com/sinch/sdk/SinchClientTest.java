package com.sinch.sdk;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.MailgunContext;
import com.sinch.sdk.models.MailgunRegion;
import com.sinch.sdk.models.SMSRegion;
import com.sinch.sdk.models.VoiceContext;
import com.sinch.sdk.models.VoiceRegion;
import java.util.Collections;
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

  @Test
  void defaultMailgunUrlAvailable() {
    Configuration configuration = Configuration.builder().build();
    SinchClient client = new SinchClient(configuration);
    assertNotNull(client.getConfiguration().getMailgunContext().get().getUrl());
  }

  @Test
  void defaultMailgunRegion() {
    Configuration configuration = Configuration.builder().build();
    SinchClient client = new SinchClient(configuration);
    assertNull(client.getConfiguration().getMailgunContext().get().getRegion());
  }

  @Test
  void defaultMailgunStorages() {
    Configuration configuration = Configuration.builder().build();
    SinchClient client = new SinchClient(configuration);
    assertNotNull(client.getConfiguration().getMailgunContext().get().getStorageServers());
    assertFalse(client.getConfiguration().getMailgunContext().get().getStorageServers().isEmpty());
  }

  @Test
  void mailgunUrlFromRegion() {
    Configuration configuration =
        Configuration.builder()
            .setMailgunContext(
                MailgunContext.builder().setRegion(MailgunRegion.from("foo value")).build())
            .build();
    SinchClient client = new SinchClient(configuration);
    assertEquals(
        client.getConfiguration().getMailgunContext().get().getUrl(),
        "https://api.foo value.mailgun.net");
  }

  @Test
  void mailgunUrlFromUrl() {
    Configuration configuration =
        Configuration.builder()
            .setMailgunContext(
                MailgunContext.builder()
                    .setRegion(MailgunRegion.from("foo value"))
                    .setUrl("my foo url")
                    .build())
            .build();
    SinchClient client = new SinchClient(configuration);
    assertEquals(client.getConfiguration().getMailgunContext().get().getUrl(), "my foo url");
  }

  @Test
  void mailgunStoragesUrlFromRegion() {
    Configuration configuration =
        Configuration.builder()
            .setMailgunContext(MailgunContext.builder().setRegion(MailgunRegion.from("EU")).build())
            .build();
    SinchClient client = new SinchClient(configuration);
    assertEquals(
        Collections.singletonList("https://storage-europe-west1.api.mailgun.net"),
        client.getConfiguration().getMailgunContext().get().getStorageUrls());
  }

  @Test
  void mailgunStoragesUrlFromStorageUrlWithoutRegion() {
    Configuration configuration =
        Configuration.builder()
            .setMailgunContext(
                MailgunContext.builder()
                    .setStorageUrls(Collections.singletonList("my foo URL"))
                    .build())
            .build();
    SinchClient client = new SinchClient(configuration);
    assertEquals(
        Collections.singletonList("my foo URL"),
        client.getConfiguration().getMailgunContext().get().getStorageUrls());
  }

  @Test
  void mailgunStoragesUrlFromStorageUrlWithRegion() {
    Configuration configuration =
        Configuration.builder()
            .setMailgunContext(
                MailgunContext.builder()
                    .setRegion(MailgunRegion.from("EU"))
                    .setStorageUrls(Collections.singletonList("my foo URL"))
                    .build())
            .build();
    SinchClient client = new SinchClient(configuration);
    assertEquals(
        Collections.singletonList("my foo URL"),
        client.getConfiguration().getMailgunContext().get().getStorageUrls());
  }
}
