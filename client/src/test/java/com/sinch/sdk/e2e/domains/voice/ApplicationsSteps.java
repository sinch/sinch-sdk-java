package com.sinch.sdk.e2e.domains.voice;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.ApplicationsService;
import com.sinch.sdk.domains.voice.models.ApplicationAssignedNumber;
import com.sinch.sdk.domains.voice.models.ApplicationURL;
import com.sinch.sdk.domains.voice.models.CallbackUrls;
import com.sinch.sdk.domains.voice.models.CapabilityType;
import com.sinch.sdk.domains.voice.models.NumberInformation;
import com.sinch.sdk.domains.voice.models.NumberType;
import com.sinch.sdk.domains.voice.models.Price;
import com.sinch.sdk.domains.voice.models.requests.ApplicationsAssignNumbersRequestParameters;
import com.sinch.sdk.domains.voice.models.response.AssignedNumbers;
import com.sinch.sdk.e2e.Config;
import com.sinch.sdk.models.E164PhoneNumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;

public class ApplicationsSteps {

  ApplicationsService service;

  AssignedNumbers listNumbersResponse;
  Boolean assignNumbersPassed;
  Boolean unassignNumberPassed;
  NumberInformation queryNumberResult;
  CallbackUrls getCallbackUrlsResult;
  Boolean updateCallbackUrlsPassed;

  @Given("^the Voice service \"Applications\" is available")
  public void serviceAvailable() {

    service = Config.getSinchClient().voice().applications();
  }

  @When("^I send a request to get information about my owned numbers$")
  public void listNumbers() {

    listNumbersResponse = service.listNumbers();
  }

  @When("^I send a request to assign some numbers to a Voice Application$")
  public void assignNumbers() {

    ApplicationsAssignNumbersRequestParameters request =
        ApplicationsAssignNumbersRequestParameters.builder()
            .setNumbers(Collections.singletonList(E164PhoneNumber.valueOf("+12012222222")))
            .setApplicationKey("f00dcafe-abba-c0de-1dea-dabb1ed4caf3")
            .setCapability(CapabilityType.VOICE)
            .build();
    service.assignNumbers(request);
    assignNumbersPassed = true;
  }

  @When("^I send a request to unassign a number from a Voice Application$")
  public void unassignNumber() {

    service.unassignNumber(E164PhoneNumber.valueOf("+12012222222"), "");
    unassignNumberPassed = true;
  }

  @When("^I send a request to get information about a specific number$")
  public void queryNumber() {

    queryNumberResult = service.queryNumber(E164PhoneNumber.valueOf("+12015555555"));
  }

  @When("^I send a request to get the callback URLs associated to an application$")
  public void getCallbackUrls() {

    getCallbackUrlsResult = service.getCallbackUrls("f00dcafe-abba-c0de-1dea-dabb1ed4caf3");
  }

  @When("^I send a request to update the callback URLs associated to an application$")
  public void updateCallbackUrls() {
    CallbackUrls request =
        CallbackUrls.builder()
            .setUrl(
                ApplicationURL.builder()
                    .setPrimary("https://my-new.callback-server.com/voice")
                    .build())
            .build();
    service.updateCallbackUrls("f00dcafe-abba-c0de-1dea-dabb1ed4caf3", request);
    updateCallbackUrlsPassed = true;
  }

  @Then("the response contains details about the numbers that I own")
  public void listNumbersResult() {
    AssignedNumbers expected =
        AssignedNumbers.builder()
            .setNumbers(
                Arrays.asList(
                    ApplicationAssignedNumber.builder()
                        .setNumber(E164PhoneNumber.valueOf("+12012222222"))
                        .setCapability(CapabilityType.VOICE)
                        .build(),
                    ApplicationAssignedNumber.builder()
                        .setNumber(E164PhoneNumber.valueOf("+12013333333"))
                        .setCapability(CapabilityType.VOICE)
                        .setApplicationKey("ba5eba11-1dea-1337-babe-5a1ad00d1eaf")
                        .build(),
                    ApplicationAssignedNumber.builder()
                        .setNumber(E164PhoneNumber.valueOf("+12014444444"))
                        .setCapability(CapabilityType.VOICE)
                        .build(),
                    ApplicationAssignedNumber.builder()
                        .setNumber(E164PhoneNumber.valueOf("+12015555555"))
                        .setCapability(CapabilityType.VOICE)
                        .setApplicationKey("f00dcafe-abba-c0de-1dea-dabb1ed4caf3")
                        .build()))
            .build();
    TestHelpers.recursiveEquals(listNumbersResponse, expected);
  }

  @Then("the assign numbers response contains no data")
  public void assignNumbersResult() {
    Assertions.assertTrue(assignNumbersPassed);
  }

  @Then("the unassign number response contains no data")
  public void unassignNumberResult() {
    Assertions.assertTrue(unassignNumberPassed);
  }

  @Then("the response contains details about the specific number")
  public void queryNumberResult() {
    NumberInformation expected =
        NumberInformation.builder()
            .setCountryId("US")
            .setNumberType(NumberType.FIXED)
            .setNormalizedNumber(E164PhoneNumber.valueOf("+12015555555"))
            .setRestricted(true)
            .setRate(Price.builder().setCurrencyId("USD").setAmount(0.01F).build())
            .build();
    TestHelpers.recursiveEquals(queryNumberResult, expected);
  }

  @Then("the response contains callback URLs details")
  public void getCallbackUrlsResult() {
    CallbackUrls expected =
        CallbackUrls.builder()
            .setUrl(
                ApplicationURL.builder()
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
