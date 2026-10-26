package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;

abstract class HelpersBaseTest extends BaseTest {

  static final String PHONE_JSON = "{\"type\":\"PHONE\",\"phone\":{\"number\":\"+15551234567\"}}";
  static final String HANGUP_JSON = "{\"command\":\"hangup\"}";

  void assertJson(Object value, String expected) throws JsonProcessingException, JSONException {
    JSONAssert.assertEquals(expected, objectMapper.writeValueAsString(value), true);
  }
}
