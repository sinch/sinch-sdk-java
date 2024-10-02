package com.sinch.sdk.e2e.domains.voice;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.ConferencesService;
import com.sinch.sdk.domains.voice.models.DestinationNumber;
import com.sinch.sdk.domains.voice.models.MusicOnHoldType;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersConference;
import com.sinch.sdk.domains.voice.models.requests.ConferenceManageParticipantCommandType;
import com.sinch.sdk.domains.voice.models.requests.ConferenceManageParticipantRequestParameters;
import com.sinch.sdk.domains.voice.models.response.ConferenceParticipant;
import com.sinch.sdk.e2e.Config;
import com.sinch.sdk.models.E164PhoneNumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.api.Assertions;

public class ConferenceSteps {

  ConferencesService service;
  String callResponse;
  Collection<ConferenceParticipant> getResponse;
  Boolean manageParticipantPassed;
  Boolean kickParticipantPassed;
  Boolean kickAllParticipantPassed;

  @Given("^the Voice service \"Conferences\" is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().voice().conferences();
  }

  @When("^I send a request to make a Conference call with the \"Conferences\" service$")
  public void createCall() {

    CalloutRequestParametersConference request =
        CalloutRequestParametersConference.builder()
            .setLocale("en-US")
            .setDestination(DestinationNumber.valueOf("+12017777777"))
            .setCli(E164PhoneNumber.valueOf("+12015555555"))
            .setConferenceId("myConferenceId-E2E")
            .setGreeting("Welcome to this conference call.")
            .setMusicOnHold(MusicOnHoldType.MUSIC1)
            .build();

    callResponse = service.call(request);
  }

  @When("^I send a request to get the conference information$")
  public void getCall() {

    getResponse = service.get("myConferenceId-E2E");
  }

  @When("^I send a request to put a participant on hold$")
  public void manageParticipant() {

    ConferenceManageParticipantRequestParameters request =
        ConferenceManageParticipantRequestParameters.builder()
            .setCommand(ConferenceManageParticipantCommandType.ONHOLD)
            .setMusicOnHold(MusicOnHoldType.MUSIC2)
            .build();

    service.manageParticipant(
        "myConferenceId-E2E", "1ce0ffee-ca11-ca11-ca11-abcdef000012", request);
    manageParticipantPassed = true;
  }

  @When("^I send a request to kick a participant from a conference$")
  public void kickParticipant() {

    service.kickParticipant("myConferenceId-E2E", "1ce0ffee-ca11-ca11-ca11-abcdef000012");
    kickParticipantPassed = true;
  }

  @When("^I send a request to kick all the participants from a conference$")
  public void kickAllParticipant() {

    service.kickAll("myConferenceId-E2E");
    kickAllParticipantPassed = true;
  }

  @Then("the callout response from the \"Conferences\" service contains the Conference call ID")
  public void createCallResult() {
    Assertions.assertEquals(callResponse, "1ce0ffee-ca11-ca11-ca11-abcdef000002");
  }

  @Then("the response contains the information about the conference participants")
  public void getCallResult() {
    Collection<ConferenceParticipant> participants =
        new ArrayList<>(
            Arrays.asList(
                ConferenceParticipant.builder()
                    .setCli("+12015555555")
                    .setId("1ce0ffee-ca11-ca11-ca11-abcdef000012")
                    .setDuration(35)
                    .setMuted(true)
                    .setOnhold(true)
                    .build(),
                ConferenceParticipant.builder()
                    .setCli("+12015555555")
                    .setId("1ce0ffee-ca11-ca11-ca11-abcdef000022")
                    .setDuration(6)
                    .setMuted(false)
                    .setOnhold(false)
                    .build()));
    TestHelpers.recursiveEquals(getResponse, participants);
  }

  @Then("the manage participant response contains no data")
  public void manageParticipantResult() {
    Assertions.assertTrue(manageParticipantPassed);
  }

  @Then("the kick participant response contains no data")
  public void kickParticipantPassedResult() {
    Assertions.assertTrue(kickParticipantPassed);
  }

  @Then("the kick all participants response contains no data")
  public void kickAllParticipantPassedResult() {
    Assertions.assertTrue(kickAllParticipantPassed);
  }
}
