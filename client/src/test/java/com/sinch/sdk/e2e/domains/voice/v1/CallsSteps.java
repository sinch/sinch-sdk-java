package com.sinch.sdk.e2e.domains.voice.v1;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.voice.api.v1.CallsService;
import com.sinch.sdk.domains.voice.models.v1.Price;
import com.sinch.sdk.domains.voice.models.v1.calls.request.CallLeg;
import com.sinch.sdk.domains.voice.models.v1.calls.response.CallInformation;
import com.sinch.sdk.domains.voice.models.v1.calls.response.CallInformation.DomainEnum;
import com.sinch.sdk.domains.voice.models.v1.calls.response.CallInformation.ReasonEnum;
import com.sinch.sdk.domains.voice.models.v1.calls.response.CallInformation.StatusEnum;
import com.sinch.sdk.domains.voice.models.v1.calls.response.CallResult;
import com.sinch.sdk.domains.voice.models.v1.destination.DestinationPstn;
import com.sinch.sdk.domains.voice.models.v1.svaml.SvamlControl;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionContinue;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionHangup;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionPlayFiles;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionSay;
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
    service = Config.getSinchClient().voice().v1().calls();
  }

  @When("^I send a request to get a call's information$")
  public void getCall() {

    getResponse = service.get("1ce0ffee-ca11-ca11-ca11-abcdef000003");
  }

  @When("^I send a request to update a call$")
  public void updateCall() {

    SvamlControl request =
        SvamlControl.builder()
            .setInstructions(
                Arrays.asList(
                    SvamlInstructionSay.builder()
                        .setText("Sorry, the conference has been cancelled. The call will end now.")
                        .setLocale("en-US")
                        .build()))
            .setAction(SvamlActionHangup.SVAML_ACTION_HANGUP)
            .build();
    service.update("1ce0ffee-ca11-ca11-ca11-abcdef000022", request);
    updatePassed = true;
  }

  @When("^I send a request to update a call that doesn't exist$")
  public void updateCallNotExits() {

    SvamlControl request =
        SvamlControl.builder()
            .setInstructions(
                Arrays.asList(
                    SvamlInstructionSay.builder()
                        .setText("Sorry, the conference has been cancelled. The call will end now.")
                        .setLocale("en-US")
                        .build()))
            .setAction(SvamlActionHangup.SVAML_ACTION_HANGUP)
            .build();
    try {
      service.update("not-existing-callId", request);
    } catch (ApiException ae) {
      updateNotFoundException = ae;
    }
  }

  @When("^I send a request to manage a call with callLeg$")
  public void manageCallWithCallLeg() {

    SvamlControl request =
        SvamlControl.builder()
            .setInstructions(
                Arrays.asList(
                    SvamlInstructionPlayFiles.builder()
                        .setIds(
                            Arrays.asList(
                                "https://samples-files.com/samples/Audio/mp3/sample-file-4.mp3"))
                        .build()))
            .setAction(SvamlActionContinue.SVAML_ACTION_CONTINUE)
            .build();
    service.manageWithCallLeg("1ce0ffee-ca11-ca11-ca11-abcdef000022", CallLeg.CALLEE, request);
    manageWithCallLegPassed = true;
  }

  @Then("the response contains the information about the call")
  public void getCallResult() {
    CallInformation information =
        CallInformation.builder()
            .setTo(DestinationPstn.from("+12017777777"))
            .setDomain(DomainEnum.PSTN)
            .setCallId("1ce0ffee-ca11-ca11-ca11-abcdef000003")
            .setDuration(14)
            .setStatus(StatusEnum.FINAL)
            .setResult(CallResult.ANSWERED)
            .setReason(ReasonEnum.MANAGERHANGUP)
            .setTimestamp(Instant.parse("2024-06-06T17:36:00Z"))
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
