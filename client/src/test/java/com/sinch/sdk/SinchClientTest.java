package com.sinch.sdk;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationRegion;
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
  void defaultSmsRegionIsUS() {
    Configuration configuration = Configuration.builder().build();
    SinchClient client = new SinchClient(configuration);
    assertEquals(SMSRegion.US, client.getConfiguration().getSmsContext().get().getSmsRegion());
  }

  @Test
  void smsRegion() {
    Configuration configuration =
        Configuration.builder().setSmsRegion(SMSRegion.from("eu")).build();
    SinchClient client = new SinchClient(configuration);
    assertEquals(SMSRegion.EU, client.getConfiguration().getSmsContext().get().getSmsRegion());
  }

  @Test
  void defaultConversationUrlAvailable() {
    Configuration configuration =
        Configuration.builder().setKeyId("foo").setKeySecret("foo").setProjectId("foo").build();
    SinchClient client = new SinchClient(configuration);
    assertNotNull(client.getConfiguration().getConversationContext().get().getUrl());
  }

  @Test
  void conversationUrlFromRegion() {
    Configuration configuration =
        Configuration.builder().setConversationRegion(ConversationRegion.EU).build();
    SinchClient client = new SinchClient(configuration);
    assertEquals(
        "https://eu.conversation.api.sinch.com",
        client.getConfiguration().getConversationContext().get().getUrl());
  }

  @Test
  void defaultConversationTemplateUrlAvailable() {
    Configuration configuration =
        Configuration.builder().setConversationRegion(ConversationRegion.EU).build();
    SinchClient client = new SinchClient(configuration);
    assertNotNull(
        client.getConfiguration().getConversationContext().get().getTemplateManagementUrl());
  }

  @Test
  void templateConversationUrlFromRegion() {
    Configuration configuration =
        Configuration.builder().setConversationRegion(ConversationRegion.BR).build();
    SinchClient client = new SinchClient(configuration);
    assertEquals(
        "https://br.template.api.sinch.com",
        client.getConfiguration().getConversationContext().get().getTemplateManagementUrl());
  }

  @Test
  void defaultConversationRegionIsUS() {
    Configuration configuration = Configuration.builder().build();
    SinchClient client = new SinchClient(configuration);
    assertEquals(
        ConversationRegion.US,
        client.getConfiguration().getConversationContext().get().getRegion());
  }

  @Test
  void conversationRegion() {
    Configuration configuration =
        Configuration.builder().setConversationRegion(ConversationRegion.from("br")).build();
    SinchClient client = new SinchClient(configuration);
    assertEquals(
        ConversationRegion.BR,
        client.getConfiguration().getConversationContext().get().getRegion());
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
        "https://calling-euc1.api.sinch.com",
        client.getConfiguration().getVoiceContext().get().getVoiceUrl());
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
        VoiceRegion.EUROPE, client.getConfiguration().getVoiceContext().get().getVoiceRegion());
    assertEquals("my foo url", client.getConfiguration().getVoiceContext().get().getVoiceUrl());
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
