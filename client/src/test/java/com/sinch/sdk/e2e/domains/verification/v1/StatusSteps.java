package com.sinch.sdk.e2e.domains.verification.v1;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.verification.api.v1.VerificationsStatusService;
import com.sinch.sdk.domains.verification.models.v1.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.Price;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import com.sinch.sdk.domains.verification.models.v1.VerificationStatus;
import com.sinch.sdk.domains.verification.models.v1.status.StatusCallResult;
import com.sinch.sdk.domains.verification.models.v1.status.StatusPrice;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponse;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponseSms;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponseSmsPrice;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Instant;

public class StatusSteps {

  VerificationsStatusService service;
  VerificationStatusResponse statusByIdResponse;
  VerificationStatusResponse statusByIdentityResponse;
  VerificationStatusResponse statusByReferenceResponse;

  @Given("^the Verification service \"Status\" is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().verification().v1().verificationStatus();
  }

  @When("^I send a request to retrieve a SMS verification status by its verification ID$")
  public void statusById() {

    statusByIdResponse = service.getById("123456789");
  }

  @When(
      "^I send a request to retrieve a Phone Call verification status by the phone number to"
          + " verify$")
  public void statusByIdentity() {

    statusByIdentityResponse =
        service.getByIdentity(NumberIdentity.valueOf("+123456789"), VerificationMethod.PHONE_CALL);
  }

  @When("^I send a request to retrieve a Flash Call verification status by its reference$")
  public void statusByReference() {

    statusByReferenceResponse = service.getByReference("flashcall-verification-test-e2e");
  }

  @Then("the response contains the details of the SMS verification status")
  public void statusByIdResult() {
    TestHelpers.recursiveEquals(
        statusByIdResponse,
        VerificationStatusResponseSms.builder()
            .setId("1ce0ffee-c0de-5eed-d00d-f00dfeed1337")
            .setStatus(VerificationStatus.SUCCESSFUL)
            .setPrice(
                VerificationStatusResponseSmsPrice.builder()
                    .setVerificationPrice(
                        Price.builder().setCurrencyId("EUR").setAmount(0.0453F).build())
                    .build())
            .setIdentity(NumberIdentity.valueOf("+33612345678"))
            .setCountryId("FR")
            .setVerificationTimestamp(Instant.parse("2024-06-06T09:08:41.4784877Z"))
            .build());
  }

  @Then("the response contains the details of the Phone Call verification status")
  public void statusByIdentityResult() {
    TestHelpers.recursiveEquals(
        statusByIdentityResponse,
        VerificationStatusResponsePhoneCall.builder()
            .setId("1ce0ffee-c0de-5eed-d11d-f00dfeed1337")
            .setStatus(VerificationStatus.SUCCESSFUL)
            .setPrice(
                StatusPrice.builder()
                    .setVerificationPrice(
                        Price.builder().setCurrencyId("EUR").setAmount(0.1852F).build())
                    .setTerminationPrice(
                        Price.builder().setCurrencyId("EUR").setAmount(0.0F).build())
                    .build())
            .setIdentity(NumberIdentity.valueOf("+33612345678"))
            .setCountryId("FR")
            .setVerificationTimestamp(Instant.parse("2024-06-06T09:10:27.7264837Z"))
            .setCallComplete(true)
            .setCallResult(StatusCallResult.ANSWERED)
            .build());
  }

  @Then("the response contains the details of the Flash Call verification status")
  public void statusByIReferenceResult() {
    TestHelpers.recursiveEquals(
        statusByReferenceResponse,
        VerificationStatusResponseFlashCall.builder()
            .setId("1ce0ffee-c0de-5eed-d22d-f00dfeed1337")
            .setStatus(VerificationStatus.SUCCESSFUL)
            .setPrice(
                StatusPrice.builder()
                    .setVerificationPrice(
                        Price.builder().setCurrencyId("EUR").setAmount(0.0205F).build())
                    .setTerminationPrice(
                        Price.builder().setCurrencyId("EUR").setAmount(0.0F).build())
                    .build())
            .setIdentity(NumberIdentity.valueOf("+33612345678"))
            .setCountryId("FR")
            .setVerificationTimestamp(Instant.parse("2024-06-06T09:07:32.3554646Z"))
            .setReference("flashcall-verification-test-e2e")
            .setCallComplete(true)
            .setCallResult(StatusCallResult.ANSWERED)
            .build());
  }
}
