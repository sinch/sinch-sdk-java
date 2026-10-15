package com.sinch.sdk.e2e.domains.voice.v2;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.api.v2.SessionsService;
import com.sinch.sdk.domains.voice.models.v2.Call;
import com.sinch.sdk.domains.voice.models.v2.CallDirection;
import com.sinch.sdk.domains.voice.models.v2.CallReason;
import com.sinch.sdk.domains.voice.models.v2.CallResult;
import com.sinch.sdk.domains.voice.models.v2.CallType;
import com.sinch.sdk.domains.voice.models.v2.Money;
import com.sinch.sdk.domains.voice.models.v2.OriginationType;
import com.sinch.sdk.domains.voice.models.v2.SessionState;
import com.sinch.sdk.domains.voice.models.v2.destination.Phone;
import com.sinch.sdk.domains.voice.models.v2.sessions.response.Session;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Instant;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;

public class SessionsSteps {

  SessionsService service;
  Session getResponse;

  @Given("^the Voice-V2 service \"Sessions\" is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().voice().v2().sessions();
    Assertions.assertNotNull(service, "Voice V2 Sessions service is not available");
  }

  @When("^I send a request to get a session$")
  public void get() {
    getResponse = service.get("01J7K3X9M2P5R8V0W4Y6Z1A3B5");
  }

  @Then("^the response contains the session details$")
  public void getResult() {
    Call call =
        Call.builder()
            .setCallId("01J7K3Y2N4Q6S9W1X5Z7A2B4C6")
            .setServiceId("e52d19b4-03fa-4e89-a901-d78b12f6a9e2")
            .setProjectId("a8f3b91c-4e2d-4190-883a-71b5c92e31d4")
            .setSessionId("01J7K3X9M2P5R8V0W4Y6Z1A3B5")
            .setBatchId("01J7K3Z5P6R8T0X2Y7A9B3C5D7")
            .setFrom(Phone.builder().setNumber("+12015555555").build())
            .setTo(Phone.builder().setNumber("+12017777777").build())
            .setDirection(CallDirection.OUTBOUND)
            .setCallResult(CallResult.NO_ANSWER)
            .setCallType(CallType.PHONE)
            .setOriginationType(OriginationType.SERVER)
            .setStartTime(Instant.parse("2026-08-28T12:17:18Z"))
            .setEndTime(Instant.parse("2026-08-28T12:17:49Z"))
            .setUpdateTime(Instant.parse("2026-08-28T12:17:49Z"))
            .setCallDurationSeconds(0)
            .setCallRate(Money.builder().setCurrencyCode("EUR").setAmount("0.4085").build())
            .setCallReason(CallReason.NOT_AVAILABLE)
            .setCallResourceUrl(
                "https://eu1.voice.api.sinch.com/v2/projects/a8f3b91c-4e2d-4190-883a-71b5c92e31d4/calls/01J7K3Y2N4Q6S9W1X5Z7A2B4C6")
            .build();

    Session expected =
        Session.builder()
            .setSessionId("01J7K3X9M2P5R8V0W4Y6Z1A3B5")
            .setServiceId("e52d19b4-03fa-4e89-a901-d78b12f6a9e2")
            .setProjectId("a8f3b91c-4e2d-4190-883a-71b5c92e31d4")
            .setCalls(Collections.singletonList(call))
            .setState(SessionState.COMPLETED)
            .setCreateTime(Instant.parse("2026-08-28T12:17:18Z"))
            .setEndTime(Instant.parse("2026-08-28T12:17:49Z"))
            .setUpdateTime(Instant.parse("2026-08-28T12:17:49Z"))
            .build();

    TestHelpers.recursiveEquals(getResponse, expected);
  }
}
