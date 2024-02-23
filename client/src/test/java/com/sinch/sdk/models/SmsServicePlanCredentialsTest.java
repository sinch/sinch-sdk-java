package com.sinch.sdk.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class SmsServicePlanCredentialsTest {
  static final String SERVICE_PLAN_ID = "fooServicePlanId";
  static final String SERVICE_PLAN_TOKEN = "fooServicePlanToken";

  static final SmsServicePlanCredentials credentials =
      SmsServicePlanCredentials.builder()
          .setServicePlanId(SERVICE_PLAN_ID)
          .setApiToken(SERVICE_PLAN_TOKEN)
          .build();

  @Test
  void testToString() {
    String value = credentials.toString();
    assertFalse(
        value.contains(SERVICE_PLAN_ID), "Config should not contains 'service plan id' value");
    assertFalse(
        value.contains(SERVICE_PLAN_TOKEN),
        "Config should not contains 'service plan token' value");
  }

  @Test
  void getServicePlanId() {
    assertEquals(SERVICE_PLAN_ID, credentials.getServicePlanId());
  }

  @Test
  void getApiToken() {
    assertEquals(SERVICE_PLAN_TOKEN, credentials.getApiToken());
  }
}
