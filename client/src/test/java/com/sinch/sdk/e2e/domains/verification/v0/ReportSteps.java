package com.sinch.sdk.e2e.domains.verification.v0;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.verification.VerificationsService;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationReport;
import com.sinch.sdk.domains.verification.models.VerificationReportCallout;
import com.sinch.sdk.domains.verification.models.VerificationReportFlashCall;
import com.sinch.sdk.domains.verification.models.VerificationReportSMS;
import com.sinch.sdk.domains.verification.models.VerificationStatusType;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportCalloutRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportSMSRequestParameters;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReportSteps {

  VerificationsService service;
  VerificationReport reportSmsByIdResponse;
  VerificationReport reportSmsByIdentityResponse;
  VerificationReport reportPhoneCallByIdResponse;
  VerificationReport reportPhoneCallByIdentityResponse;
  VerificationReport reportFlashCallByIdResponse;
  VerificationReport reportFlashCallByIdentityResponse;

  @Given("^the Verification service \"Report\" is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().verification().verifications();
    ;
  }

  @When("^I send a request to report an SMS verification with the verification ID$")
  public void reportSmsById() {

    VerificationReportSMSRequestParameters request =
        VerificationReportSMSRequestParameters.builder().setCode("OQP1").build();

    reportSmsByIdResponse = service.reportSmsById(VerificationId.valueOf("id"), request);
  }

  @When("^I send a request to report an SMS verification with the phone number$")
  public void reportSmsByIdentity() {

    VerificationReportSMSRequestParameters request =
        VerificationReportSMSRequestParameters.builder().setCode("OQP1").build();

    reportSmsByIdentityResponse =
        service.reportSmsByIdentity(NumberIdentity.valueOf("+123456789"), request);
  }

  @When("^I send a request to report a Phone Call verification with the verification ID$")
  public void reportCalloutById() {

    VerificationReportCalloutRequestParameters request =
        VerificationReportCalloutRequestParameters.builder().setCode("123456").build();

    reportPhoneCallByIdResponse = service.reportCalloutById(VerificationId.valueOf("id"), request);
  }

  @When("^I send a request to report a Phone Call verification with the phone number$")
  public void reportPhoneCallByIdentity() {

    VerificationReportCalloutRequestParameters request =
        VerificationReportCalloutRequestParameters.builder().setCode("123456").build();

    reportPhoneCallByIdentityResponse =
        service.reportCalloutByIdentity(NumberIdentity.valueOf("+123456789"), request);
  }

  @When("^I send a request to report a Flash Call verification with the verification ID$")
  public void reportFlashCallById() {

    VerificationReportFlashCallRequestParameters request =
        VerificationReportFlashCallRequestParameters.builder().setCli("+18156540001").build();

    reportFlashCallByIdResponse =
        service.reportFlashCallById(VerificationId.valueOf("id"), request);
  }

  @When("^I send a request to report a Flash Call verification with the phone number$")
  public void reportFlashCallByIdentity() {

    VerificationReportFlashCallRequestParameters request =
        VerificationReportFlashCallRequestParameters.builder().setCli("+18156540001").build();

    reportFlashCallByIdentityResponse =
        service.reportFlashCallByIdentity(NumberIdentity.valueOf("+123456789"), request);
  }

  @Then("the response by {string} contains the details of an SMS verification report")
  public void reportSmsResult(String by) {
    VerificationReport expected = null;
    if (by.equals("ID")) {
      expected = reportSmsByIdResponse;
    } else if (by.equals("identity")) {
      expected = reportSmsByIdentityResponse;
    }
    TestHelpers.recursiveEquals(
        expected,
        VerificationReportSMS.builder()
            .setId(VerificationId.valueOf("1ce0ffee-c0de-5eed-d00d-f00dfeed1337"))
            .setStatus(VerificationStatusType.SUCCESSFUL)
            .build());
  }

  @Then("the response by {string} contains the details of a Phone Call verification report")
  public void reportPhoneCallResult(String by) {
    VerificationReport expected = null;
    if (by.equals("ID")) {
      expected = reportPhoneCallByIdResponse;
    } else if (by.equals("identity")) {
      expected = reportPhoneCallByIdentityResponse;
    }
    TestHelpers.recursiveEquals(
        expected,
        VerificationReportCallout.builder()
            .setId(VerificationId.valueOf("1ce0ffee-c0de-5eed-d11d-f00dfeed1337"))
            .setStatus(VerificationStatusType.SUCCESSFUL)
            .build());
  }

  @Then("the response by \"ID\" contains the details of a Flash Call verification report")
  public void reportFlashCallResult() {
    TestHelpers.recursiveEquals(
        reportFlashCallByIdResponse,
        VerificationReportFlashCall.builder()
            .setId(VerificationId.valueOf("1ce0ffee-c0de-5eed-d22d-f00dfeed1337"))
            .setStatus(VerificationStatusType.SUCCESSFUL)
            .build());
  }

  @Then(
      "the response by \"identity\" contains the details of a failed Flash Call verification"
          + " report")
  public void reportFlashCallFailedResult() {

    TestHelpers.recursiveEquals(
        reportFlashCallByIdentityResponse,
        VerificationReportFlashCall.builder()
            .setId(VerificationId.valueOf("1ce0ffee-c0de-5eed-d22d-f00dfeed1337"))
            .setStatus(VerificationStatusType.FAIL)
            .build());
  }
}
