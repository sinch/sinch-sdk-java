package com.sinch.sdk.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.models.ServerConfiguration;
import org.junit.jupiter.api.Test;

class SmsContextTest {

  @Test
  void noConfiguration() {
    SmsContext context = SmsContext.builder().build();
    assertNotNull(context);
  }

  @Test
  void region() {
    SmsContext context = SmsContext.builder().setSmsRegion(SMSRegion.from("eu")).build();
    assertEquals(context.getSmsRegion(), SMSRegion.EU);
  }

  @Test
  void defaultRegion() {
    SmsContext context = SmsContext.builder().build();
    assertNull(context.getSmsRegion());
  }

  @Test
  void url() {
    SmsContext context = SmsContext.builder().setSmsUrl("hpps://foo.com").build();
    assertEquals(context.getSmsUrl(), "hpps://foo.com");
  }

  @Test
  void defaultUrl() {
    SmsContext context = SmsContext.builder().build();
    assertNull(context.getSmsUrl());
  }

  @Test
  void serverConfiguration() {
    ServerConfiguration expected = new ServerConfiguration("https://foo.com");
    SmsContext context = SmsContext.builder().setSmsUrl("https://foo.com").build();
    TestHelpers.recursiveEquals(context.getSmsServer(), expected);
  }

  @Test
  void serverConfigurationWithRegion() {
    ServerConfiguration expected = new ServerConfiguration("hpps://myvalue.foo.com");
    SmsContext context =
        SmsContext.builder()
            .setSmsUrl("hpps://%s.foo.com")
            .setSmsRegion(SMSRegion.from("myvalue"))
            .build();
    TestHelpers.recursiveEquals(context.getSmsServer(), expected);
  }

  @Test
  void defaultServerConfiguration() {
    ServerConfiguration expected = new ServerConfiguration(null);
    SmsContext context = SmsContext.builder().build();
    TestHelpers.recursiveEquals(context.getSmsServer(), expected);
  }

  @Test
  void regionAsDefault() {
    SmsContext context = SmsContext.builder().setRegionAsDefault(true).build();
    assertTrue(context.regionAsDefault());
  }
}
