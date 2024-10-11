package com.sinch.sdk.e2e.domains.voice.v1;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.api.v1.ConferencesService;
import com.sinch.sdk.domains.voice.models.v1.Destination;
import com.sinch.sdk.domains.voice.models.v1.DestinationType;
import com.sinch.sdk.domains.voice.models.v1.MusicOnHold;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestConference;
import com.sinch.sdk.domains.voice.models.v1.conferences.ConferenceParticipant;
import com.sinch.sdk.domains.voice.models.v1.conferences.request.ManageConferenceParticipant;
import com.sinch.sdk.domains.voice.models.v1.conferences.request.ManageConferenceParticipant.CommandEnum;
import com.sinch.sdk.domains.voice.models.v1.conferences.response.GetConferenceInfoResponse;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public class ConferenceSteps {

  ConferencesService service;
  String callResponse;
  GetConferenceInfoResponse getResponse;
  Boolean manageParticipantPassed;
  Boolean kickParticipantPassed;
  Boolean kickAllParticipantPassed;

  @Given("^the Voice service \"Conferences\" is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().voice().v1().conferences();
  }

  @When("^I send a request to make a Conference call with the \"Conferences\" service$")
  public void createCall() {

    CalloutRequestConference request =
        CalloutRequestConference.builder()
            .setLocale("en-US")
            .setDestination(
                Destination.builder()
                    .setType(DestinationType.NUMBER)
                    .setEndpoint("+12017777777")
                    .build())
            .setCli("+12015555555")
            .setConferenceId("myConferenceId-E2E")
            .setGreeting("Welcome to this conference call.")
            .setMusicOnHold(MusicOnHold.MUSIC1)
            .build();

    callResponse = service.call(request);
  }

  @When("^I send a request to get the conference information$")
  public void getCall() {

    getResponse = service.get("myConferenceId-E2E");
  }

  @When("^I send a request to put a participant on hold$")
  public void manageParticipant() {

    ManageConferenceParticipant request =
        ManageConferenceParticipant.builder()
            .setCommand(CommandEnum.ONHOLD)
            .setMoh(MusicOnHold.MUSIC2)
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
    GetConferenceInfoResponse reponse =
        GetConferenceInfoResponse.builder()
            .setParticipants(
                new ArrayList<>(
                    Arrays.asList(
                        ConferenceParticipant.builder()
                            .setCli("+12015555555")
                            .setId("1ce0ffee-ca11-ca11-ca11-abcdef000012")
                            .setDuration(35)
                            .setMuted(true)
                            .setOnHold(true)
                            .build(),
                        ConferenceParticipant.builder()
                            .setCli("+12015555555")
                            .setId("1ce0ffee-ca11-ca11-ca11-abcdef000022")
                            .setDuration(6)
                            .setMuted(false)
                            .setOnHold(false)
                            .build())))
            .build();
    TestHelpers.recursiveEquals(getResponse, reponse);
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
