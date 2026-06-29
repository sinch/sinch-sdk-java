package com.sinch.sdk.e2e.domains.proxy;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.numberlookup.models.v2.request.NumberLookupRequest;
import com.sinch.sdk.domains.numberlookup.models.v2.response.Line;
import com.sinch.sdk.domains.numberlookup.models.v2.response.LineType;
import com.sinch.sdk.domains.numberlookup.models.v2.response.NumberLookupResponse;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ProxySteps {

  NumberLookupResponse response;

  @Given("the proxy server is available")
  public void proxyServerAvailable() {
    Assertions.assertNotNull(
        Config.getSinchClientProxyUnauthenticated(), "Unauthenticated proxy client");
    Assertions.assertNotNull(
        Config.getSinchClientProxyAuthenticated(), "Authenticated proxy client");
  }

  @When("I send a Number Lookup request through the unauthenticated proxy")
  public void lookupThroughUnauthenticatedProxy() {
    response = lookup(Config.getSinchClientProxyUnauthenticated());
  }

  @When("I send a Number Lookup request through the authenticated proxy")
  public void lookupThroughAuthenticatedProxy() {
    response = lookup(Config.getSinchClientProxyAuthenticated());
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
}
