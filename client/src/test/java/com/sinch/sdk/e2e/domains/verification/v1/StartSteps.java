package com.sinch.sdk.e2e.domains.verification.v1;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.verification.api.v1.VerificationStartService;
import com.sinch.sdk.domains.verification.models.v1.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.start.request.PhoneCallSpeech;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestData;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestFlashCall;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestPhoneCall;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestSms;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestSms.CodeTypeEnum;
import com.sinch.sdk.domains.verification.models.v1.start.response.Link;
import com.sinch.sdk.domains.verification.models.v1.start.response.Link.RelEnum;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponse;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseSms;
import com.sinch.sdk.e2e.Config;
import com.sinch.sdk.models.E164PhoneNumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public class StartSteps {

  VerificationStartService service;
  VerificationStartResponse startVerificationBySmsResponse;
  VerificationStartResponse startVerificationByPhoneCallResponse;
  VerificationStartResponse startVerificationByFlashCallResponse;
  ApiException startSeamlessException;

  @Given("^the Verification service \"Start\" is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().verification().v1().verificationStart();
  }

  @When("^I send a request to start a verification with a SMS$")
  public void startSms() {

    VerificationStartRequestSms request =
        VerificationStartRequestSms.builder()
            .setIdentity(NumberIdentity.valueOf("+46123456789"))
            .setCodeType(CodeTypeEnum.ALPHANUMERIC)
            .setAcceptLanguage("sv-SE")
            .build();

    startVerificationBySmsResponse = service.startSms(request);
  }

  @When("^I send a request to start a verification with a Phone Call$")
  public void startPhoneCall() {

    VerificationStartRequestPhoneCall request =
        VerificationStartRequestPhoneCall.builder()
            .setIdentity(NumberIdentity.valueOf("+33612345678"))
            .setSpeech(PhoneCallSpeech.builder().setLocale("fr-FR").build())
            .build();

    startVerificationByPhoneCallResponse = service.startPhoneCall(request);
  }

  @When("^I send a request to start a verification with a Flash Call$")
  public void startFlashCall() {

    VerificationStartRequestFlashCall request =
        VerificationStartRequestFlashCall.builder()
            .setIdentity(NumberIdentity.valueOf(E164PhoneNumber.valueOf("+33612345678")))
            .setDialTimeout(10)
            .setReference("flashcall-verification-test-e2e")
            .build();

    startVerificationByFlashCallResponse = service.startFlashCall(request);
  }

  @When("^I send a request to start a Data verification for a not available destination$")
  public void startData() {

    VerificationStartRequestData request =
        VerificationStartRequestData.builder()
            .setIdentity(NumberIdentity.valueOf("+17818880008"))
            .build();
    try {
      service.startData(request);
    } catch (ApiException e) {
      startSeamlessException = e;
    }
  }

  @Then("the response contains the details of a verification started with a SMS")
  public void startSmsResult() {

    TestHelpers.recursiveEquals(
        startVerificationBySmsResponse,
        VerificationStartResponseSms.builder()
            .setId("1ce0ffee-c0de-5eed-d00d-f00dfeed1337")
            .setInterceptionTimeout(198)
            .setTemplate("Din verifieringskod är {{CODE}}.")
            .setLinks(
                Arrays.asList(
                    Link.builder()
                        .setRel(RelEnum.STATUS)
                        .setHref(
                            "http://localhost:3018/verification/v1/verifications/id/1ce0ffee-c0de-5eed-d00d-f00dfeed1337")
                        .setMethod("GET")
                        .build(),
                    Link.builder()
                        .setRel(RelEnum.REPORT)
                        .setHref(
                            "http://localhost:3018/verification/v1/verifications/id/1ce0ffee-c0de-5eed-d00d-f00dfeed1337")
                        .setMethod("PUT")
                        .build()))
            .build());
  }

  @Then("the response contains the details of a verification started with a Phone Call")
  public void startPhoneCallResult() {

    TestHelpers.recursiveEquals(
        startVerificationByPhoneCallResponse,
        VerificationStartResponsePhoneCall.builder()
            .setId("1ce0ffee-c0de-5eed-d11d-f00dfeed1337")
            .setLinks(
                Arrays.asList(
                    Link.builder()
                        .setRel(RelEnum.STATUS)
                        .setHref(
                            "http://localhost:3018/verification/v1/verifications/id/1ce0ffee-c0de-5eed-d11d-f00dfeed1337")
                        .setMethod("GET")
                        .build(),
                    Link.builder()
                        .setRel(RelEnum.REPORT)
                        .setHref(
                            "http://localhost:3018/verification/v1/verifications/id/1ce0ffee-c0de-5eed-d11d-f00dfeed1337")
                        .setMethod("PUT")
                        .build()))
            .build());
  }

  @Then("the response contains the details of a verification started with a Flash Call")
  public void startFlashCallResult() {

    TestHelpers.recursiveEquals(
        startVerificationByFlashCallResponse,
        VerificationStartResponseFlashCall.builder()
            .setId("1ce0ffee-c0de-5eed-d22d-f00dfeed1337")
            .setCliFilter("(.*)8156(.*)")
            .setInterceptionTimeout(45)
            .setReportTimeout(75)
            .setDenyCallAfter(0)
            .setLinks(
                Arrays.asList(
                    Link.builder()
                        .setRel(RelEnum.STATUS)
                        .setHref(
                            "http://localhost:3018/verification/v1/verifications/id/1ce0ffee-c0de-5eed-d22d-f00dfeed1337")
                        .setMethod("GET")
                        .build(),
                    Link.builder()
                        .setRel(RelEnum.REPORT)
                        .setHref(
                            "http://localhost:3018/verification/v1/verifications/id/1ce0ffee-c0de-5eed-d22d-f00dfeed1337")
                        .setMethod("PUT")
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
