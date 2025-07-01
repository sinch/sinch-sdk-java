package com.sinch.sdk.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.models.ServerConfiguration;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class MailgunContextTest {

  @Test
  void noConfiguration() {
    MailgunContext context = MailgunContext.builder().build();
    assertNotNull(context);
  }

  @Test
  void region() {
    MailgunContext context = MailgunContext.builder().setRegion(MailgunRegion.from("eu")).build();
    assertEquals(context.getRegion(), MailgunRegion.EUROPE);
  }

  @Test
  void defaultRegion() {
    MailgunContext context = MailgunContext.builder().build();
    assertNull(context.getRegion());
  }

  @Test
  void url() {
    MailgunContext context = MailgunContext.builder().setUrl("https://foo.com").build();
    assertEquals(context.getUrl(), "https://foo.com");
  }

  @Test
  void defaultUrl() {
    MailgunContext context = MailgunContext.builder().build();
    assertNull(context.getUrl());
  }

  @Test
  void serverConfiguration() {
    ServerConfiguration expected = new ServerConfiguration("https://foo.com");
    MailgunContext context = MailgunContext.builder().setUrl("https://foo.com").build();
    TestHelpers.recursiveEquals(context.getServer(), expected);
  }

  @Test
  void defaultServerConfiguration() {
    ServerConfiguration expected = new ServerConfiguration(null);
    MailgunContext context = MailgunContext.builder().build();
    TestHelpers.recursiveEquals(context.getServer(), expected);
  }

  @Test
  void storageUrls() {
    MailgunContext context =
        MailgunContext.builder().setStorageUrls(Arrays.asList("https://foo.com")).build();
    TestHelpers.recursiveEquals(context.getStorageUrls(), Arrays.asList("https://foo.com"));
  }
}
