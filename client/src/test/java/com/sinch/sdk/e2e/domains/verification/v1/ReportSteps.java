package com.sinch.sdk.e2e.domains.verification.v1;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.verification.api.v1.VerificationReportService;
import com.sinch.sdk.domains.verification.models.v1.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.VerificationStatus;
import com.sinch.sdk.domains.verification.models.v1.VerificationStatusReason;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestFlashCall;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestPhoneCall;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestSms;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestWhatsApp;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponse;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseSms;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseWhatsApp;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReportSteps {

  VerificationReportService service;
  VerificationReportResponse reportSmsByIdResponse;
  VerificationReportResponse reportSmsByIdentityResponse;
  VerificationReportResponse reportCalloutByIdResponse;
  VerificationReportResponse reportCalloutByIdentityResponse;
  VerificationReportResponse reportFlashCallByIdResponse;
  VerificationReportResponse reportFlashCallByIdentityResponse;
  VerificationReportResponse reportWhatsAppByIdResponse;
  VerificationReportResponse reportWhatsAppByIdentityResponse;

  @Given("^the Verification service \"Report\" is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().verification().v1().verificationReport();
  }

  @When(
      "I send a request to report an SMS verification by \"ID\" with the verification ID {string}")
  public void reportSmsById(String id) {

    VerificationReportRequestSms request =
        VerificationReportRequestSms.builder().setCode("OQP1").build();

    reportSmsByIdResponse = service.reportSmsById(id, request);
  }

  @When(
      "I send a request to report an SMS verification by \"identity\" with the phone number"
          + " {string}")
  public void reportSmsByIdentity(String phoneNumber) {

    VerificationReportRequestSms request =
        VerificationReportRequestSms.builder().setCode("OQP1").build();

    reportSmsByIdentityResponse =
        service.reportSmsByIdentity(NumberIdentity.valueOf(phoneNumber), request);
  }

  @When(
      "I send a request to report a Phone Call verification by \"ID\" with the verification ID"
          + " {string}")
  public void reportCalloutById(String id) {

    VerificationReportRequestPhoneCall request =
        VerificationReportRequestPhoneCall.builder().setCode("123456").build();

    reportCalloutByIdResponse = service.reportPhoneCallById(id, request);
  }

  @When(
      "I send a request to report a Phone Call verification by \"identity\" with the phone number"
          + " {string}")
  public void reportCalloutByIdentity(String phoneNumber) {

    VerificationReportRequestPhoneCall request =
        VerificationReportRequestPhoneCall.builder().setCode("123456").build();

    reportCalloutByIdentityResponse =
        service.reportPhoneCallByIdentity(NumberIdentity.valueOf(phoneNumber), request);
  }

  @When(
      "I send a request to report a Flash Call verification by \"ID\" with the verification ID"
          + " {string}")
  public void reportFlashCallById(String id) {

    VerificationReportRequestFlashCall request =
        VerificationReportRequestFlashCall.builder().setCli("+18156540001").build();

    reportFlashCallByIdResponse = service.reportFlashCallById(id, request);
  }

  @When(
      "I send a request to report a Flash Call verification by \"identity\" with the phone number"
          + " {string}")
  public void reportFlashCallByIdentity(String phoneNumber) {

    VerificationReportRequestFlashCall request =
        VerificationReportRequestFlashCall.builder().setCli("+18156540001").build();

    reportFlashCallByIdentityResponse =
        service.reportFlashCallByIdentity(NumberIdentity.valueOf(phoneNumber), request);
  }

  @When(
      "I send a request to report a WhatsApp verification by \"ID\" with the verification ID"
          + " {string}")
  public void reportWhatsAppById(String id) {

    VerificationReportRequestWhatsApp request =
        VerificationReportRequestWhatsApp.builder().setCode("1234").build();

    reportWhatsAppByIdResponse = service.reportWhatsAppById(id, request);
  }

  @When(
      "I send a request to report a WhatsApp verification by \"identity\" with the phone number"
          + " {string}")
  public void reportWhatsAppByIdentity(String phoneNumber) {

    VerificationReportRequestWhatsApp request =
        VerificationReportRequestWhatsApp.builder().setCode("5678").build();

    reportWhatsAppByIdentityResponse =
        service.reportWhatsAppByIdentity(NumberIdentity.valueOf(phoneNumber), request);
  }

  @Then("the response by {string} contains the details of an SMS verification report")
  public void reportSmsResult(String by) {
    VerificationReportResponse expected = null;
    if (by.equals("ID")) {
      expected = reportSmsByIdResponse;
    } else if (by.equals("identity")) {
      expected = reportSmsByIdentityResponse;
    }
    TestHelpers.recursiveEquals(
        expected,
        VerificationReportResponseSms.builder()
            .setId("1ce0ffee-c0de-5eed-d00d-f00dfeed1337")
            .setStatus(VerificationStatus.SUCCESSFUL)
            .build());
  }

  @Then("the response by {string} contains the details of a Phone Call verification report")
  public void reportPhoneCallResult(String by) {
    VerificationReportResponse expected = null;
    if (by.equals("ID")) {
      expected = reportCalloutByIdResponse;
    } else if (by.equals("identity")) {
      expected = reportCalloutByIdentityResponse;
    }
    TestHelpers.recursiveEquals(
        expected,
        VerificationReportResponsePhoneCall.builder()
            .setId("1ce0ffee-c0de-5eed-d11d-f00dfeed1337")
            .setStatus(VerificationStatus.SUCCESSFUL)
            .setCallComplete(true)
            .build());
  }

  @Then("the response by \"ID\" contains the details of a Flash Call verification report")
  public void reportFlashCallResult() {
    TestHelpers.recursiveEquals(
        reportFlashCallByIdResponse,
        VerificationReportResponseFlashCall.builder()
            .setId("1ce0ffee-c0de-5eed-d22d-f00dfeed1337")
            .setStatus(VerificationStatus.SUCCESSFUL)
            .setCallComplete(true)
            .build());
  }

  @Then(
      "the response by \"identity\" contains the details of a failed Flash Call verification"
          + " report")
  public void reportFlashCallFailedResult() {

    TestHelpers.recursiveEquals(
        reportFlashCallByIdentityResponse,
        VerificationReportResponseFlashCall.builder()
            .setId("1ce0ffee-c0de-5eed-d22d-f00dfeed1337")
            .setStatus(VerificationStatus.FAIL)
            .setCallComplete(true)
            .setReason(VerificationStatusReason.EXPIRED)
            .build());
  }

  @Then("the response by {string} contains the details of a WhatsApp verification report")
  public void reportWhatsAppResult(String by) {
    VerificationReportResponse expected = null;
    if (by.equals("ID")) {
      expected = reportWhatsAppByIdResponse;
    } else if (by.equals("identity")) {
      expected = reportWhatsAppByIdentityResponse;
    }
    TestHelpers.recursiveEquals(
        expected,
        VerificationReportResponseWhatsApp.builder()
            .setId("1ce0ffee-c0de-5eed-d33d-f00dfeed1337")
            .setStatus(VerificationStatus.SUCCESSFUL)
            .build());
  }
}
