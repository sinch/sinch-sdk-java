package com.sinch.sdk.e2e.domains.verification.v0;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.domains.verification.VerificationsService;
import com.sinch.sdk.domains.verification.models.Link;
import com.sinch.sdk.domains.verification.models.LinkRelType;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationReference;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationCalloutOptions;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationCalloutRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationCalloutSpeechOptions;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationSeamlessRequestParameters;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponse;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseCallout;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseFlashCall;
import com.sinch.sdk.e2e.Config;
import com.sinch.sdk.models.E164PhoneNumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public class StartSteps {

  VerificationsService service;
  StartVerificationResponse startVerificationBySmsResponse;
  StartVerificationResponse startVerificationByPhoneCallResponse;
  StartVerificationResponse startVerificationByFlashCallResponse;
  ApiException startSeamlessException;

  @Given("^the Verification service \"Start\" is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().verification().verifications();
  }

  @When("^I send a request to start a verification with a SMS$")
  public void startSms() {

    // "accept-languages" was added after v0 service was marked as deprecated
    // so cannot test it against mockserver conditions

    // DO NOTHING
    /*StartVerificationSMSRequestParameters request =
        StartVerificationSMSRequestParameters.builder()

            .setIdentity(NumberIdentity.valueOf("+46123456789"))
            .setOptions(StartVerificationSMSOptions.builder().setCodeType( SMSCodeType.ALPHANUMERIC).build()).build();

    startVerificationBySmsResponse = service.startSms(request);*/
  }

  @When("^I send a request to start a verification with a Phone Call$")
  public void startPhoneCall() {

    StartVerificationCalloutRequestParameters request =
        StartVerificationCalloutRequestParameters.builder()
            .setIdentity(NumberIdentity.valueOf("+33612345678"))
            .setOptions(
                StartVerificationCalloutOptions.builder()
                    .setSpeech(
                        StartVerificationCalloutSpeechOptions.builder().setLocale("fr-FR").build())
                    .build())
            .build();

    startVerificationByPhoneCallResponse = service.startCallout(request);
  }

  @When("^I send a request to start a verification with a Flash Call$")
  public void startFlashCall() {

    StartVerificationFlashCallRequestParameters request =
        StartVerificationFlashCallRequestParameters.builder()
            .setIdentity(NumberIdentity.valueOf(E164PhoneNumber.valueOf("+33612345678")))
            .setDialTimeOut(10)
            .setReference(VerificationReference.valueOf("flashcall-verification-test-e2e"))
            .build();

    startVerificationByFlashCallResponse = service.startFlashCall(request);
  }

  @When("^I send a request to start a Data verification for a not available destination$")
  public void startData() {

    StartVerificationSeamlessRequestParameters request =
        StartVerificationSeamlessRequestParameters.builder()
            .setIdentity(NumberIdentity.valueOf("+17818880008"))
            .build();
    try {
      service.startSeamless(request);
    } catch (ApiException e) {
      startSeamlessException = e;
    }
  }

  @Then("the response contains the details of a verification started with a SMS")
  public void startSmsResult() {

    // "accept-languages" was added after v0 service was marked as deprecated
    // so cannot test it against mockserver conditions

    // DO NOTHING
    Assertions.assertTrue(true);
  }

  @Then("the response contains the details of a verification started with a Phone Call")
  public void startPhoneCallResult() {

    TestHelpers.recursiveEquals(
        startVerificationByPhoneCallResponse,
        StartVerificationResponseCallout.builder()
            .setId(VerificationId.valueOf("1ce0ffee-c0de-5eed-d11d-f00dfeed1337"))
            .setLinks(
                Arrays.asList(
                    Link.builder()
                        .setRel(LinkRelType.STATUS)
                        .setHref(
                            "http://localhost:3018/verification/v1/verifications/id/1ce0ffee-c0de-5eed-d11d-f00dfeed1337")
                        .setMethod(HttpMethod.GET)
                        .build(),
                    Link.builder()
                        .setRel(LinkRelType.REPORT)
                        .setHref(
                            "http://localhost:3018/verification/v1/verifications/id/1ce0ffee-c0de-5eed-d11d-f00dfeed1337")
                        .setMethod(HttpMethod.PUT)
                        .build()))
            .build());
  }

  @Then("the response contains the details of a verification started with a Flash Call")
  public void startFlashCallResult() {

    TestHelpers.recursiveEquals(
        startVerificationByFlashCallResponse,
        StartVerificationResponseFlashCall.builder()
            .setId(VerificationId.valueOf("1ce0ffee-c0de-5eed-d22d-f00dfeed1337"))
            .setCliFilter("(.*)8156(.*)")
            .setInterceptionTimeOut(45)
            .setReportTimeout(75)
            .setDenyCallAfter(0)
            .setLinks(
                Arrays.asList(
                    Link.builder()
                        .setRel(LinkRelType.STATUS)
                        .setHref(
                            "http://localhost:3018/verification/v1/verifications/id/1ce0ffee-c0de-5eed-d22d-f00dfeed1337")
                        .setMethod(HttpMethod.GET)
                        .build(),
                    Link.builder()
                        .setRel(LinkRelType.REPORT)
                        .setHref(
                            "http://localhost:3018/verification/v1/verifications/id/1ce0ffee-c0de-5eed-d22d-f00dfeed1337")
                        .setMethod(HttpMethod.PUT)
                        .build()))
            .build());
  }

  @Then("the response contains the error details of a Data verification")
  public void startDataResult() {

    Assertions.assertEquals(startSeamlessException.getCode(), 40300);
    Assertions.assertTrue(
        startSeamlessException
            .getMessage()
            .equals(
                "Seamless verification not available for given destination."
                    + " (reference=c01dc0de-c4db-44f1-5ca1-da9159d21c191)"));
  }
}
