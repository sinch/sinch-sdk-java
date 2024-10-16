package com.sinch.sdk.e2e.domains.voice.v0;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.voice.CallsService;
import com.sinch.sdk.domains.voice.models.CallLegType;
import com.sinch.sdk.domains.voice.models.CallReasonType;
import com.sinch.sdk.domains.voice.models.CallResultType;
import com.sinch.sdk.domains.voice.models.DestinationNumber;
import com.sinch.sdk.domains.voice.models.DomainType;
import com.sinch.sdk.domains.voice.models.Price;
import com.sinch.sdk.domains.voice.models.response.CallInformation;
import com.sinch.sdk.domains.voice.models.response.CallStatusType;
import com.sinch.sdk.domains.voice.models.svaml.ActionContinue;
import com.sinch.sdk.domains.voice.models.svaml.ActionHangUp;
import com.sinch.sdk.domains.voice.models.svaml.InstructionPlayFiles;
import com.sinch.sdk.domains.voice.models.svaml.InstructionSay;
import com.sinch.sdk.domains.voice.models.svaml.SVAMLControl;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public class CallsSteps {

  CallsService service;
  CallInformation getResponse;
  Boolean updatePassed;
  ApiException updateNotFoundException;
  Boolean manageWithCallLegPassed;

  @Given("^the Voice service \"Calls\" is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().voice().calls();
  }

  @When("^I send a request to get a call's information$")
  public void getCall() {

    getResponse = service.get("1ce0ffee-ca11-ca11-ca11-abcdef000003");
  }

  @When("^I send a request to update a call$")
  public void updateCall() {

    SVAMLControl request =
        SVAMLControl.builder()
            .setInstructions(
                Arrays.asList(
                    InstructionSay.builder()
                        .setText("Sorry, the conference has been cancelled. The call will end now.")
                        .setLocale("en-US")
                        .build()))
            .setAction(ActionHangUp.builder().build())
            .build();
    service.update("1ce0ffee-ca11-ca11-ca11-abcdef000022", request);
    updatePassed = true;
  }

  @When("^I send a request to update a call that doesn't exist$")
  public void updateCallNotExits() {

    SVAMLControl request =
        SVAMLControl.builder()
            .setInstructions(
                Arrays.asList(
                    InstructionSay.builder()
                        .setText("Sorry, the conference has been cancelled. The call will end now.")
                        .setLocale("en-US")
                        .build()))
            .setAction(ActionHangUp.builder().build())
            .build();
    try {
      service.update("not-existing-callId", request);
    } catch (ApiException ae) {
      updateNotFoundException = ae;
    }
  }

  @When("^I send a request to manage a call with callLeg$")
  public void manageCallWithCallLeg() {

    SVAMLControl request =
        SVAMLControl.builder()
            .setInstructions(
                Arrays.asList(
                    InstructionPlayFiles.builder()
                        .setIds(
                            Arrays.asList(
                                "https://samples-files.com/samples/Audio/mp3/sample-file-4.mp3"))
                        .build()))
            .setAction(ActionContinue.builder().build())
            .build();
    service.manageWithCallLeg("1ce0ffee-ca11-ca11-ca11-abcdef000022", CallLegType.CALLEE, request);
    manageWithCallLegPassed = true;
  }

  @Then("the response contains the information about the call")
  public void getCallResult() {
    CallInformation information =
        CallInformation.builder()
            .setTo(DestinationNumber.valueOf("+12017777777"))
            .setDomain(DomainType.PSTN)
            .setCallId("1ce0ffee-ca11-ca11-ca11-abcdef000003")
            .setDuration(14)
            .setStatus(CallStatusType.FINAL)
            .setResult(CallResultType.ANSWERED)
            .setReason(CallReasonType.MANAGER_HANGUP)
            .setTimeStamp(Instant.parse("2024-06-06T17:36:00Z"))
            .setCustom("Custom text")
            .setUserRate(Price.builder().setCurrencyId("EUR").setAmount(0.1758F).build())
            .setDebit(Price.builder().setCurrencyId("EUR").setAmount(0.1758F).build())
            .build();
    TestHelpers.recursiveEquals(getResponse, information);
  }

  @Then("the update call response contains no data")
  public void updateCallResult() {
    Assertions.assertEquals(true, updatePassed);
  }

  @Then("the update call response contains a \"not found\" error")
  public void updateCallNotFoundResult() {
    Assertions.assertTrue(updateNotFoundException.getMessage().contains("not found"));
  }

  @Then("the manage a call with callLeg response contains no data")
  public void manageCallWithCallLegResult() {
    Assertions.assertEquals(true, manageWithCallLegPassed);
  }
}
