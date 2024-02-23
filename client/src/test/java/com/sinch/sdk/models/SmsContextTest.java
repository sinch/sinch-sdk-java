package com.sinch.sdk.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SmsContextTest {

  static final String SMS_SERVER = "%sfooSMS_SERVER";

  @Test
  void defaultUSForSmSRegion() {
    SmsContext context = SmsContext.builder().setSmsUrl(SMS_SERVER).build();
    assertEquals(context.getSmsRegion(), SMSRegion.US);
  }
}
