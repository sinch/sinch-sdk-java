package com.sinch.sdk.e2e.domains.sms.v1;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.sms.api.v1.SinchEventsService;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.BatchDeliveryReportSMS;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.DeliveryReceiptStatusCode;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.DeliveryStatus;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.MessageDeliveryStatus;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.RecipientDeliveryReportSMS;
import com.sinch.sdk.domains.sms.models.v1.inbounds.TextMessage;
import com.sinch.sdk.domains.sms.models.v1.sinchevents.SmsSinchEvent;
import com.sinch.sdk.e2e.Config;
import com.sinch.sdk.e2e.domains.WebhooksHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import org.junit.jupiter.api.Assertions;

public class WebhooksSteps {

  static final String WEBHOOKS_PATH_PREFIX = "/webhooks/sms";
  static final String WEBHOOKS_URL = Config.SMS_HOST_NAME + WEBHOOKS_PATH_PREFIX;

  static final String SECRET = "KayakingTheSwell";

  SinchEventsService service;
  WebhooksHelper.Response<SmsSinchEvent> incoming;
  WebhooksHelper.Response<SmsSinchEvent> deliveryReport;
  WebhooksHelper.Response<SmsSinchEvent> deliveryReportRecipientDelivered;
  WebhooksHelper.Response<SmsSinchEvent> deliveryReportRecipientAborted;

  @Given("^the SMS Webhooks handler is available")
  public void serviceAvailable() {

    service = Config.getSinchClient().sms().v1().sinchEvents();
  }

  @When("^I send a request to trigger an \"incoming SMS\" event")
  public void incoming() throws IOException {

    incoming = WebhooksHelper.callURL(new URL(WEBHOOKS_URL + "/incoming-sms"), service::parseEvent);
  }

  @When("^I send a request to trigger an \"SMS delivery report\" event")
  public void deliveryReport() throws IOException {

    deliveryReport =
        WebhooksHelper.callURL(new URL(WEBHOOKS_URL + "/delivery-report-sms"), service::parseEvent);
  }

  @When(
      "^I send a request to trigger an \"SMS recipient delivery report\" event with the status"
          + " \"Delivered\"")
  public void deliveryReportRecipientDelivered() throws IOException {

    deliveryReportRecipientDelivered =
        WebhooksHelper.callURL(
            new URL(WEBHOOKS_URL + "/recipient-delivery-report-sms-delivered"),
            service::parseEvent);
  }

  @When(
      "^I send a request to trigger an \"SMS recipient delivery report\" event with the status"
          + " \"Aborted\"")
  public void deliveryReportRecipientAborted() throws IOException {

    deliveryReportRecipientAborted =
        WebhooksHelper.callURL(
            new URL(WEBHOOKS_URL + "/recipient-delivery-report-sms-aborted"), service::parseEvent);
  }

  @Then("the SMS event describes an \"incoming SMS\" event")
  public void incomingResult() {
    SmsSinchEvent expected =
        TextMessage.builder()
            .setBody("Hello John! 👋")
            .setFrom("12015555555")
            .setId("01W4FFL35P4NC4K35SMSBATCH8")
            .setOperatorId("311071")
            .setReceivedAt(Instant.parse("2024-06-06T07:52:37.386Z"))
            .setTo("12017777777")
            .build();

    TestHelpers.recursiveEquals(incoming.event, expected);
  }

  @Then("the SMS event describes an \"SMS delivery report\" event")
  public void deliveryReportResult() {
    SmsSinchEvent expected =
        BatchDeliveryReportSMS.builder()
            .setBatchId("01W4FFL35P4NC4K35SMSBATCH8")
            .setClientReference("client-ref")
            .setStatuses(
                Arrays.asList(
                    MessageDeliveryStatus.builder()
                        .setCode(DeliveryReceiptStatusCode.from(0))
                        .setCount(2)
                        .setRecipients(new HashSet<>(Arrays.asList("12017777777", "33612345678")))
                        .setStatus(DeliveryStatus.DELIVERED)
                        .build()))
            .setTotalMessageCount(2)
            .build();

    TestHelpers.recursiveEquals(deliveryReport.event, expected);
  }

  @Then(
      "the SMS event describes an SMS recipient delivery report event with the status"
          + " \"Delivered\"")
  public void deliveryReportRecipientDeliveredResult() {
    SmsSinchEvent expected =
        RecipientDeliveryReportSMS.builder()
            .setCreatedAt(Instant.parse("2024-06-06T08:17:19.210Z"))
            .setBatchId("01W4FFL35P4NC4K35SMSBATCH9")
            .setClientReference("client-ref")
            .setCode(DeliveryReceiptStatusCode.from(0))
            .setOperatorStatusAt(Instant.parse("2024-06-06T08:17:00Z"))
            .setRecipient("12017777777")
            .setStatus(DeliveryStatus.DELIVERED)
            .build();

    TestHelpers.recursiveEquals(deliveryReportRecipientDelivered.event, expected);
  }

  @Then(
      "the SMS event describes an SMS recipient delivery report event with the status \"Aborted\"")
  public void deliveryReportRecipientAbortedResult() {
    SmsSinchEvent expected =
        RecipientDeliveryReportSMS.builder()
            .setCreatedAt(Instant.parse("2024-06-06T08:17:15.603Z"))
            .setBatchId("01W4FFL35P4NC4K35SMSBATCH9")
            .setClientReference("client-ref")
            .setCode(DeliveryReceiptStatusCode.UNPROVISIONED_REGION)
            .setRecipient("12010000000")
            .setStatus(DeliveryStatus.ABORTED)
            .build();

    TestHelpers.recursiveEquals(deliveryReportRecipientAborted.event, expected);
  }

  @Then("the header of the event {string} contains a valid signature")
  public void validateHeader(String event) {

    WebhooksHelper.Response<SmsSinchEvent> response = null;
    if (event.equals("IncomingSMS")) {
      response = incoming;
    } else if (event.equals("DeliveryReport")) {
      response = deliveryReport;
    }

    boolean validated =
        service.validateAuthenticationHeader(SECRET, response.headers, response.rawPayload);
    Assertions.assertTrue(validated);
  }

  @Then("the header of the event {string} with the status {string} contains a valid signature")
  public void validateHeader(String _unused, String status) {

    WebhooksHelper.Response<SmsSinchEvent> response = null;
    if (status.equals("Delivered")) {
      response = deliveryReportRecipientDelivered;
    } else if (status.equals("Aborted")) {
      response = deliveryReportRecipientAborted;
    }

    boolean validated =
        service.validateAuthenticationHeader(SECRET, response.headers, response.rawPayload);
    Assertions.assertTrue(validated);
  }
}
