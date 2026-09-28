package com.sinch.sdk.e2e.domains.voice.v2;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.api.v2.BatchesService;
import com.sinch.sdk.domains.voice.models.v2.batches.request.BatchOptions;
import com.sinch.sdk.domains.voice.models.v2.batches.request.StartBatchRequest;
import com.sinch.sdk.domains.voice.models.v2.batches.response.StartBatchResponse;
import com.sinch.sdk.domains.voice.models.v2.destination.Phone;
import com.sinch.sdk.domains.voice.models.v2.destination.PhoneDetails;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.CallEvents;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.DialCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.HangupCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.MessageEvents;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.MessagesCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.Say;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.SayMessage;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;

public class BatchesSteps {

  BatchesService service;
  StartBatchResponse startResponse;

  @Given("^the Voice-V2 service \"Batches\" is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().voice().v2().batches();
    Assertions.assertNotNull(service, "Voice V2 Batches service is not available");
  }

  @When("^I send a request to start a batch of calls$")
  public void start() {
    MessagesCommand reminder =
        MessagesCommand.builder()
            .setMessages(
                Collections.singletonList(
                    SayMessage.builder()
                        .setSay(
                            Say.builder()
                                .setText(
                                    "Hello, this is an automated reminder from Sinch. Goodbye.")
                                .setVoiceName("Emma")
                                .build())
                        .build()))
            .setEvents(
                MessageEvents.builder()
                    .setOnFinish(Collections.singletonList(HangupCommand.builder().build()))
                    .build())
            .build();

    DialCommand dial =
        DialCommand.builder()
            .setCallName("batch-reminder")
            .setFrom(
                Phone.builder()
                    .setPhone(PhoneDetails.builder().setNumber("+12015555555").build())
                    .build())
            .setTo(
                Phone.builder()
                    .setPhone(PhoneDetails.builder().setNumber("@toNumber").build())
                    .build())
            .setDialTimeoutDurationSeconds(30)
            .setMaxCallDurationSeconds(120)
            .setEvents(
                CallEvents.builder()
                    .setOnAnswer(Collections.singletonList(reminder))
                    .setOnHangup(Collections.singletonList(HangupCommand.builder().build()))
                    .build())
            .build();

    // No Idempotency-Key set: the mock requires one, so this also checks the SDK generates it.
    startResponse =
        service.start(
            StartBatchRequest.builder()
                .setCommands(Collections.singletonList(dial))
                .setParameters(
                    Arrays.asList(
                        Collections.singletonMap("toNumber", "+12017777777"),
                        Collections.singletonMap("toNumber", "+12018888888")))
                .setBatchOptions(BatchOptions.builder().setMaxCps(5).setTtlSeconds(600).build())
                .build());
  }

  @Then("^the response contains the information about the batch started$")
  public void startResult() {
    StartBatchResponse expected =
        StartBatchResponse.builder()
            .setProjectId("b2c3d4e5-f6a7-4890-b123-c4d5e6f7a890")
            .setServiceId("0a1b2c3d-4e5f-4678-9abc-d1e2f3a4b5c6")
            .setBatchId("01HZXK9RSQNS9WE4KX0ZG3D5UC")
            .build();

    TestHelpers.recursiveEquals(startResponse, expected);
  }
}
