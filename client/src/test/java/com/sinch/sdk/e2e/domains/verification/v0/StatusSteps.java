package com.sinch.sdk.e2e.domains.verification.v0;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.verification.VerificationStatusService;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.Price;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReference;
import com.sinch.sdk.domains.verification.models.VerificationStatus;
import com.sinch.sdk.domains.verification.models.VerificationStatusCallout;
import com.sinch.sdk.domains.verification.models.VerificationStatusFlashCall;
import com.sinch.sdk.domains.verification.models.VerificationStatusSMS;
import com.sinch.sdk.domains.verification.models.VerificationStatusType;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Instant;

public class StatusSteps {

  VerificationStatusService service;
  VerificationStatus statusByIdResponse;
  VerificationStatus statusByIdentityResponse;
  VerificationStatus statusByReferenceResponse;

  @Given("^the Verification service \"Status\" is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().verification().verificationStatus();
  }

  @When("^I send a request to retrieve a SMS verification status by its verification ID$")
  public void statusById() {

    statusByIdResponse = service.getById(VerificationId.valueOf("123456789"));
  }

  @When(
      "^I send a request to retrieve a Phone Call verification status by the phone number to"
          + " verify$")
  public void statusByIdentity() {

    statusByIdentityResponse =
        service.getByIdentity(NumberIdentity.valueOf("+123456789"), VerificationMethodType.CALLOUT);
  }

  @When("^I send a request to retrieve a Flash Call verification status by its reference$")
  public void statusByReference() {

    statusByReferenceResponse =
        service.getByReference(VerificationReference.valueOf("flashcall-verification-test-e2e"));
  }

  @Then("the response contains the details of the SMS verification status")
  public void statusByIdResult() {
    TestHelpers.recursiveEquals(
        statusByIdResponse,
        VerificationStatusSMS.builder()
            .setId(VerificationId.valueOf("1ce0ffee-c0de-5eed-d00d-f00dfeed1337"))
            .setStatus(VerificationStatusType.SUCCESSFUL)
            .setVerificationPrice(Price.builder().setCurrencyId("EUR").setAmount(0.0453F).build())
            .setIdentity(NumberIdentity.valueOf("+33612345678"))
            .setCountryId("FR")
            .setVerificationTimeStamp(Instant.parse("2024-06-06T09:08:41.4784877Z"))
            .build());
  }

  @Then("the response contains the details of the Phone Call verification status")
  public void statusByIdentityResult() {
    TestHelpers.recursiveEquals(
        statusByIdentityResponse,
        VerificationStatusCallout.builder()
            .setId(VerificationId.valueOf("1ce0ffee-c0de-5eed-d11d-f00dfeed1337"))
            .setStatus(VerificationStatusType.SUCCESSFUL)
            .setVerificationPrice(Price.builder().setCurrencyId("EUR").setAmount(0.1852F).build())
            .setTerminationPrice(Price.builder().setCurrencyId("EUR").setAmount(0.0F).build())
            .setIdentity(NumberIdentity.valueOf("+33612345678"))
            .setCountryId("FR")
            .setVerificationTimeStamp(Instant.parse("2024-06-06T09:10:27.7264837Z"))
            .setCallComplete(true)
            .build());
  }

  @Then("the response contains the details of the Flash Call verification status")
  public void statusByIReferenceResult() {
    TestHelpers.recursiveEquals(
        statusByReferenceResponse,
        VerificationStatusFlashCall.builder()
            .setId(VerificationId.valueOf("1ce0ffee-c0de-5eed-d22d-f00dfeed1337"))
            .setStatus(VerificationStatusType.SUCCESSFUL)
            .setVerificationPrice(Price.builder().setCurrencyId("EUR").setAmount(0.0205F).build())
            .setTerminationPrice(Price.builder().setCurrencyId("EUR").setAmount(0.0F).build())
            .setIdentity(NumberIdentity.valueOf("+33612345678"))
            .setCountryId("FR")
            .setVerificationTimeStamp(Instant.parse("2024-06-06T09:07:32.3554646Z"))
            .setReference(VerificationReference.valueOf("flashcall-verification-test-e2e"))
            .build());
  }
}
