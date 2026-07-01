package com.sinch.sdk.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HttpProxyConfigurationTest {

  static final String HOST = "proxy.corp.example.com";
  static final int PORT = 3128;
  static final String USERNAME = "proxyUser";
  static final String PASSWORD = "proxyPass";

  static final HttpProxyConfiguration fullSettings =
      HttpProxyConfiguration.builder()
          .setHostname(HOST)
          .setPort(PORT)
          .setUsername(USERNAME)
          .setPassword(PASSWORD)
          .build();

  static final HttpProxyConfiguration minimalSettings =
      HttpProxyConfiguration.builder().setHostname(HOST).setPort(PORT).build();

  @Test
  void getHostname() {
    assertEquals(HOST, fullSettings.getHostname());
  }

  @Test
  void getPort() {
    assertEquals(PORT, fullSettings.getPort());
  }

  @Test
  void getUsernameWhenConfigured() {
    assertTrue(fullSettings.getUsername().isPresent());
    assertEquals(USERNAME, fullSettings.getUsername().get());
  }

  @Test
  void getUsernameAbsentWhenNotConfigured() {
    assertFalse(minimalSettings.getUsername().isPresent());
  }

  @Test
  void getPasswordWhenConfigured() {
    assertTrue(fullSettings.getPassword().isPresent());
    assertArrayEquals(PASSWORD.toCharArray(), fullSettings.getPassword().get());
  }

  @Test
  void getPasswordAbsentWhenNotConfigured() {
    assertFalse(minimalSettings.getPassword().isPresent());
  }

  @Test
  void setPasswordCharArrayOverload() {
    char[] pwd = PASSWORD.toCharArray();
    HttpProxyConfiguration config =
        HttpProxyConfiguration.builder()
            .setHostname(HOST)
            .setPort(PORT)
            .setUsername(USERNAME)
            .setPassword(pwd)
            .build();
    assertTrue(config.getPassword().isPresent());
    assertArrayEquals(PASSWORD.toCharArray(), config.getPassword().get());
  }

  @Test
  void getPasswordReturnsDefensiveCopy() {
    char[] first = fullSettings.getPassword().get();
    first[0] = 'X';
    char[] second = fullSettings.getPassword().get();
    assertEquals(
        PASSWORD.charAt(0),
        second[0],
        "Mutating the returned array must not affect internal state");
  }

  @Test
  void setPasswordCharArrayInputMutationDoesNotAffectConfig() {
    char[] pwd = PASSWORD.toCharArray();
    HttpProxyConfiguration config =
        HttpProxyConfiguration.builder()
            .setHostname(HOST)
            .setPort(PORT)
            .setUsername(USERNAME)
            .setPassword(pwd)
            .build();
    pwd[0] = 'X';
    assertArrayEquals(
        PASSWORD.toCharArray(),
        config.getPassword().get(),
        "Mutating the original char[] after build must not affect stored password");
  }

  @Test
  void toStringSensitiveDataMasked() {
    String value = fullSettings.toString();
    assertFalse(value.contains(USERNAME), "username must not appear in toString output");
    assertFalse(value.contains(PASSWORD), "password must not appear in toString output");
    assertTrue(value.contains(HOST), "hostname should be visible in toString output");
  }

  @Test
  void builderCopyPreservesAllFields() {
    HttpProxyConfiguration copy = HttpProxyConfiguration.builder(fullSettings).build();
    assertEquals(fullSettings.getHostname(), copy.getHostname());
    assertEquals(fullSettings.getPort(), copy.getPort());
    assertEquals(fullSettings.getUsername(), copy.getUsername());
    assertArrayEquals(fullSettings.getPassword().orElse(null), copy.getPassword().orElse(null));
  }

  @Test
  void buildNullHostnameThrows() {
    assertThrows(
        IllegalArgumentException.class,
        () -> HttpProxyConfiguration.builder().setPort(PORT).build());
  }

  @Test
  void buildEmptyHostnameThrows() {
    assertThrows(
        IllegalArgumentException.class,
        () -> HttpProxyConfiguration.builder().setHostname("").setPort(PORT).build());
  }

  @Test
  void buildPortZeroThrows() {
    assertThrows(
        IllegalArgumentException.class,
        () -> HttpProxyConfiguration.builder().setHostname(HOST).setPort(0).build());
  }

  @Test
  void buildPortNegativeThrows() {
    assertThrows(
        IllegalArgumentException.class,
        () -> HttpProxyConfiguration.builder().setHostname(HOST).setPort(-1).build());
  }

  @Test
  void buildPortAboveMaxThrows() {
    assertThrows(
        IllegalArgumentException.class,
        () -> HttpProxyConfiguration.builder().setHostname(HOST).setPort(65536).build());
  }

  @Test
  void buildPortAtBoundaryAccepted() {
    assertDoesNotThrow(() -> HttpProxyConfiguration.builder().setHostname(HOST).setPort(1).build());
    assertDoesNotThrow(
        () -> HttpProxyConfiguration.builder().setHostname(HOST).setPort(65535).build());
  }

  @Test
  void buildPasswordWithoutUsernameThrows() {
    assertThrows(
        IllegalArgumentException.class,
        () ->
            HttpProxyConfiguration.builder()
                .setHostname(HOST)
                .setPort(PORT)
                .setPassword(PASSWORD)
                .build());
  }

  @Test
  void buildUsernameWithoutPasswordThrows() {
    assertThrows(
        IllegalArgumentException.class,
        () ->
            HttpProxyConfiguration.builder()
                .setHostname(HOST)
                .setPort(PORT)
                .setUsername(USERNAME)
                .build());
  }

  @Test
  void buildHostnameWithWhitespaceOnlyThrows() {
    assertThrows(
        IllegalArgumentException.class,
        () -> HttpProxyConfiguration.builder().setHostname("   ").setPort(PORT).build());
  }

  @Test
  void buildHostnameWithLeadingTrailingSpacesIsTrimmed() {
    HttpProxyConfiguration config =
        HttpProxyConfiguration.builder().setHostname("  " + HOST + "  ").setPort(PORT).build();
    assertEquals(HOST, config.getHostname(), "Hostname should be trimmed");
  }

  @Test
  void builderCopyAllowsOverride() {
    HttpProxyConfiguration modified =
        HttpProxyConfiguration.builder(fullSettings).setHostname("other-proxy.example.com").build();
    assertEquals("other-proxy.example.com", modified.getHostname());
    assertEquals(PORT, modified.getPort());
    assertEquals(fullSettings.getUsername(), modified.getUsername());
  }
}
