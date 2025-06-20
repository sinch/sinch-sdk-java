package com.sinch.sdk.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.models.ServerConfiguration;
import org.junit.jupiter.api.Test;

class ConversationContextTest {

  @Test
  void noConfiguration() {
    ConversationContext context = ConversationContext.builder().build();
    assertNotNull(context);
  }

  @Test
  void region() {
    ConversationContext context =
        ConversationContext.builder().setRegion(ConversationRegion.from("eu")).build();
    assertEquals(context.getRegion(), ConversationRegion.EU);
  }

  @Test
  void defaultRegion() {
    ConversationContext context = ConversationContext.builder().build();
    assertNull(context.getRegion());
  }

  @Test
  void url() {
    ConversationContext context = ConversationContext.builder().setUrl("https://foo.com").build();
    assertEquals(context.getUrl(), "https://foo.com");
  }

  @Test
  void defaultUrl() {
    ConversationContext context = ConversationContext.builder().build();
    assertNull(context.getUrl());
  }

  @Test
  void serverConfiguration() {
    ServerConfiguration expected = new ServerConfiguration("https://foo.com");
    ConversationContext context = ConversationContext.builder().setUrl("https://foo.com").build();
    TestHelpers.recursiveEquals(context.getServer(), expected);
  }

  @Test
  void defaultServerConfiguration() {
    ServerConfiguration expected = new ServerConfiguration(null);
    ConversationContext context = ConversationContext.builder().build();
    TestHelpers.recursiveEquals(context.getServer(), expected);
  }
}
