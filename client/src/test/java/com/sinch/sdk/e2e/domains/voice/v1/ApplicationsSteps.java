package com.sinch.sdk.e2e.domains.voice.v1;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.api.v1.ApplicationsService;
import com.sinch.sdk.domains.voice.models.v1.applications.Callbacks;
import com.sinch.sdk.domains.voice.models.v1.applications.CallbacksUrl;
import com.sinch.sdk.domains.voice.models.v1.applications.Capability;
import com.sinch.sdk.domains.voice.models.v1.applications.request.UnAssignNumberRequest;
import com.sinch.sdk.domains.voice.models.v1.applications.request.UpdateNumbersRequest;
import com.sinch.sdk.domains.voice.models.v1.applications.response.OwnedNumberInformation;
import com.sinch.sdk.domains.voice.models.v1.applications.response.OwnedNumbersListResponse;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;

public class ApplicationsSteps {

  ApplicationsService service;

  OwnedNumbersListResponse listNumbersResponse;
  Boolean assignNumbersPassed;
  Boolean unassignNumberPassed;

  Callbacks getCallbackUrlsResult;
  Boolean updateCallbackUrlsPassed;

  @Given("^the Voice service \"Applications\" is available")
  public void serviceAvailable() {

    service = Config.getSinchClient().voice().v1().applications();
  }

  @When("^I send a request to get information about my owned numbers$")
  public void listNumbers() {

    listNumbersResponse = service.listNumbers();
  }

  @When("^I send a request to assign some numbers to a Voice Application$")
  public void assignNumbers() {

    UpdateNumbersRequest request =
        UpdateNumbersRequest.builder()
            .setNumbers(Collections.singletonList("+12012222222"))
            .setApplicationKey("f00dcafe-abba-c0de-1dea-dabb1ed4caf3")
            .setCapability(Capability.VOICE)
            .build();
    service.assignNumbers(request);
    assignNumbersPassed = true;
  }

  @When("^I send a request to unassign a number from a Voice Application$")
  public void unassignNumber() {

    UnAssignNumberRequest request =
        UnAssignNumberRequest.builder().setNumber("+12012222222").build();
    service.unassignNumber(request);
    unassignNumberPassed = true;
  }

  @When("^I send a request to get the callback URLs associated to an application$")
  public void getCallbackUrls() {

    getCallbackUrlsResult = service.getCallbackUrls("f00dcafe-abba-c0de-1dea-dabb1ed4caf3");
  }

  @When("^I send a request to update the callback URLs associated to an application$")
  public void updateCallbackUrls() {
    Callbacks request =
        Callbacks.builder()
            .setUrl(
                CallbacksUrl.builder()
                    .setPrimary("https://my-new.callback-server.com/voice")
                    .build())
            .build();
    service.updateCallbackUrls("f00dcafe-abba-c0de-1dea-dabb1ed4caf3", request);
    updateCallbackUrlsPassed = true;
  }

  @Then("the response contains details about the numbers that I own")
  public void listNumbersResult() {
    Collection<OwnedNumberInformation> expected =
        new ArrayList<>(
            Arrays.asList(
                OwnedNumberInformation.builder()
                    .setNumber("+12012222222")
                    .setCapability(Capability.VOICE)
                    .build(),
                OwnedNumberInformation.builder()
                    .setNumber("+12013333333")
                    .setCapability(Capability.VOICE)
                    .setApplicationKey("ba5eba11-1dea-1337-babe-5a1ad00d1eaf")
                    .build(),
                OwnedNumberInformation.builder()
                    .setNumber("+12014444444")
                    .setCapability(Capability.VOICE)
                    .build(),
                OwnedNumberInformation.builder()
                    .setNumber("+12015555555")
                    .setCapability(Capability.VOICE)
                    .setApplicationKey("f00dcafe-abba-c0de-1dea-dabb1ed4caf3")
                    .build()));
    TestHelpers.recursiveEquals(listNumbersResponse.getContent(), expected);
    Assertions.assertFalse(listNumbersResponse.hasNextPage());
  }

  @Then("the assign numbers response contains no data")
  public void assignNumbersResult() {
    Assertions.assertTrue(assignNumbersPassed);
  }

  @Then("the unassign number response contains no data")
  public void unassignNumberResult() {
    Assertions.assertTrue(unassignNumberPassed);
  }

  @Then("the response contains callback URLs details")
  public void getCallbackUrlsResult() {
    Callbacks expected =
        Callbacks.builder()
            .setUrl(
                CallbacksUrl.builder()
                    .setPrimary("https://my.callback-server.com/voice")
                    .setFallback("https://my.fallback-server.com/voice")
                    .build())
            .build();
    TestHelpers.recursiveEquals(getCallbackUrlsResult, expected);
  }

  @Then("the update callback URLs response contains no data")
  public void updateCallbackUrlsResult() {
    Assertions.assertTrue(updateCallbackUrlsPassed);
  }
}
