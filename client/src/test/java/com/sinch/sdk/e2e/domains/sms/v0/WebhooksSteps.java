package com.sinch.sdk.e2e.domains.sms.v0;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.sms.WebHooksService;
import com.sinch.sdk.domains.sms.models.DeliveryReportBatchSMS;
import com.sinch.sdk.domains.sms.models.DeliveryReportErrorCode;
import com.sinch.sdk.domains.sms.models.DeliveryReportRecipient;
import com.sinch.sdk.domains.sms.models.DeliveryReportRecipientSMS;
import com.sinch.sdk.domains.sms.models.DeliveryReportStatus;
import com.sinch.sdk.domains.sms.models.DeliveryReportStatusDetails;
import com.sinch.sdk.domains.sms.models.InboundText;
import com.sinch.sdk.domains.sms.models.webhooks.WebhooksEvent;
import com.sinch.sdk.e2e.Config;
import com.sinch.sdk.e2e.domains.WebhooksHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.util.Arrays;

public class WebhooksSteps {

  static final String WEBHOOKS_PATH_PREFIX = "/webhooks/sms";
  static final String WEBHOOKS_URL = Config.SMS_HOST_NAME + WEBHOOKS_PATH_PREFIX;

  WebHooksService service;
  WebhooksHelper.Response<WebhooksEvent> incoming;
  WebhooksHelper.Response<WebhooksEvent> deliveryReport;
  WebhooksHelper.Response<WebhooksEvent> deliveryReportRecipientDelivered;
  WebhooksHelper.Response<WebhooksEvent> deliveryReportRecipientAborted;

  @Given("^the SMS Webhooks handler is available")
  public void serviceAvailable() {

    service = Config.getSinchClient().sms().webHooks();
  }

  @When("^I send a request to trigger an \"incoming SMS\" event")
  public void incoming() throws IOException {

    incoming = WebhooksHelper.callURL(new URL(WEBHOOKS_URL + "/incoming-sms"), service::parse);
  }

  @When("^I send a request to trigger an \"SMS delivery report\" event")
  public void deliveryReport() throws IOException {

    deliveryReport =
        WebhooksHelper.callURL(new URL(WEBHOOKS_URL + "/delivery-report-sms"), service::parse);
  }

  @When(
      "^I send a request to trigger an \"SMS recipient delivery report\" event with the status"
          + " \"Delivered\"")
  public void deliveryReportRecipientDelivered() throws IOException {

    deliveryReportRecipientDelivered =
        WebhooksHelper.callURL(
            new URL(WEBHOOKS_URL + "/recipient-delivery-report-sms-delivered"), service::parse);
  }

  @When(
      "^I send a request to trigger an \"SMS recipient delivery report\" event with the status"
          + " \"Aborted\"")
  public void deliveryReportRecipientAborted() throws IOException {

    deliveryReportRecipientAborted =
        WebhooksHelper.callURL(
            new URL(WEBHOOKS_URL + "/recipient-delivery-report-sms-aborted"), service::parse);
  }

  @Then("the SMS event describes an \"incoming SMS\" event")
  public void incomingResult() {
    InboundText expected =
        InboundText.builder()
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
    DeliveryReportBatchSMS expected =
        DeliveryReportBatchSMS.builder()
            .setBatchId("01W4FFL35P4NC4K35SMSBATCH8")
            .setClientReference("client-ref")
            .setStatuses(
                Arrays.asList(
                    DeliveryReportStatusDetails.builder()
                        .setCode(0)
                        .setCount(2)
                        .setRecipients(Arrays.asList("12017777777", "33612345678"))
                        .setStatus(DeliveryReportStatus.DELIVERED)
                        .build()))
            .setTotalMessageCount(2)
            .build();

    TestHelpers.recursiveEquals(deliveryReport.event, expected);
  }

  @Then(
      "the SMS event describes an SMS recipient delivery report event with the status"
          + " \"Delivered\"")
  public void deliveryReportRecipientDeliveredResult() {
    DeliveryReportRecipient expected =
        DeliveryReportRecipientSMS.builder()
            .setAt(Instant.parse("2024-06-06T08:17:19.210Z"))
            .setBatchId("01W4FFL35P4NC4K35SMSBATCH9")
            .setClientReference("client-ref")
            .setCode(DeliveryReportErrorCode.from(0))
            .setOperatorStatusAt(Instant.parse("2024-06-06T08:17:00Z"))
            .setRecipient("12017777777")
            .setStatus(DeliveryReportStatus.DELIVERED)
            .build();

    TestHelpers.recursiveEquals(deliveryReportRecipientDelivered.event, expected);
  }

  @Then(
      "the SMS event describes an SMS recipient delivery report event with the status \"Aborted\"")
  public void deliveryReportRecipientAbortedResult() {
    DeliveryReportRecipient expected =
        DeliveryReportRecipientSMS.builder()
            .setAt(Instant.parse("2024-06-06T08:17:15.603Z"))
            .setBatchId("01W4FFL35P4NC4K35SMSBATCH9")
            .setClientReference("client-ref")
            .setCode(DeliveryReportErrorCode.UNPROVISIONED_REGION)
            .setRecipient("12010000000")
            .setStatus(DeliveryReportStatus.ABORTED)
            .build();

    TestHelpers.recursiveEquals(deliveryReportRecipientAborted.event, expected);
  }
}
