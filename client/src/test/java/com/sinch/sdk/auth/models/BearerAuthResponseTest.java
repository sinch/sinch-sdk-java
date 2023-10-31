package com.sinch.sdk.auth.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import org.junit.jupiter.api.Test;

@TestWithResources
public class BearerAuthResponseTest extends BaseTest {

  static final String token = "token value";

  @GivenJsonResource("/client/auth/BearerAuthResponse.json")
  BearerAuthResponse response;

  @Test
  void getAccessToken() {
    assertEquals(token, response.getAccessToken());
  }

  @Test
  void getExpiresIn() {
    assertEquals(123456, response.getExpiresIn());
  }

  @Test
  void getScope() {
    assertEquals("scope value", response.getScope());
  }

  @Test
  void getTokenType() {
    assertEquals("token type value", response.getTokenType());
  }

  @Test
  void to_String() {
    assertFalse(response.toString().contains(token));
  }
}
