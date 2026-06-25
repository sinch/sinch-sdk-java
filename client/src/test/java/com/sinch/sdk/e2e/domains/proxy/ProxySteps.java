package com.sinch.sdk.e2e.domains.proxy;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.numberlookup.models.v2.request.NumberLookupRequest;
import com.sinch.sdk.domains.numberlookup.models.v2.response.Line;
import com.sinch.sdk.domains.numberlookup.models.v2.response.LineType;
import com.sinch.sdk.domains.numberlookup.models.v2.response.NumberLookupResponse;
import com.sinch.sdk.e2e.Config;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.HttpProxyConfiguration;
import com.sinch.sdk.models.NumberLookupContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ProxySteps {

  private static final String PROXY_HOST = "localhost";
  private static final String PROXY_USERNAME = "user";
  private static final String PROXY_PASSWORD = "password";
  private static final String PROXY_AUTH_URL = "http://authentication-server:1080/oauth2/token";
  private static final String PROXY_NUMBER_LOOKUP_HOST_NAME = "http://proxy-target-server:1080";

  private static final SinchClient clientProxyUnauthenticated =
      new SinchClient(
          proxyConfiguration(
              HttpProxyConfiguration.builder()
                  .setHostname(PROXY_HOST)
                  .setPort(Config.PROXY_UNAUTHENTICATED_PORT)
                  .build()));

  private static final SinchClient clientProxyAuthenticated =
      new SinchClient(
          proxyConfiguration(
              HttpProxyConfiguration.builder()
                  .setHostname(PROXY_HOST)
                  .setPort(Config.PROXY_AUTHENTICATED_PORT)
                  .setUsername(PROXY_USERNAME)
                  .setPassword(PROXY_PASSWORD)
                  .build()));

  NumberLookupResponse response;

  @Given("the proxy server is available")
  public void proxyServerAvailable() {
    Assertions.assertNotNull(clientProxyUnauthenticated, "Unauthenticated proxy client");
    Assertions.assertNotNull(clientProxyAuthenticated, "Authenticated proxy client");
  }

  @When("I send a Number Lookup request through the unauthenticated proxy")
  public void lookupThroughUnauthenticatedProxy() {
    response = lookup(clientProxyUnauthenticated);
  }

  @When("I send a Number Lookup request through the authenticated proxy")
  public void lookupThroughAuthenticatedProxy() {
    response = lookup(clientProxyAuthenticated);
  }

  @Then("the response is successfully returned through the unauthenticated proxy")
  public void responseReturnedThroughUnauthenticatedProxy() {
    assertResponse("a11a11a11a11a11a11a11a11a11unauth");
  }

  @Then("the response is successfully returned through the authenticated proxy")
  public void responseReturnedThroughAuthenticatedProxy() {
    assertResponse("b22b22b22b22b22b22b22b22b22b2auth");
  }

  private void assertResponse(String expectedTraceId) {
    NumberLookupResponse expected =
        NumberLookupResponse.builder()
            .setNumber("+12016666666")
            .setCountryCode("US")
            .setTraceId(expectedTraceId)
            .setLine(
                Line.builder()
                    .setCarrier("T-Mobile USA")
                    .setType(LineType.MOBILE)
                    .setMobileCountryCode("310")
                    .setMobileNetworkCode("260")
                    .build())
            .build();

    TestHelpers.recursiveEquals(response, expected);
  }

  private static NumberLookupResponse lookup(SinchClient client) {
    NumberLookupRequest request = NumberLookupRequest.builder().setNumber("+12016666666").build();
    return client.lookup().lookup().lookup(request);
  }

  private static Configuration proxyConfiguration(HttpProxyConfiguration proxy) {
    return Configuration.builder()
        .setOAuthUrl(PROXY_AUTH_URL)
        .setProjectId(Config.PROJECT_ID)
        .setKeyId(Config.KEY_ID)
        .setKeySecret(Config.KEY_SECRET)
        .setNumberLookupContext(
            NumberLookupContext.builder().setNumberLookupUrl(PROXY_NUMBER_LOOKUP_HOST_NAME).build())
        .setHttpProxyConfiguration(proxy)
        .build();
  }
}
