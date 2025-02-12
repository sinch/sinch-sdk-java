package com.sinch.sdk.e2e.domains.sms.v0;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.sms.BatchesService;
import com.sinch.sdk.domains.sms.models.BatchText;
import com.sinch.sdk.domains.sms.models.DeliveryReportType;
import com.sinch.sdk.domains.sms.models.DryRun;
import com.sinch.sdk.domains.sms.models.DryRunPerRecipientDetails;
import com.sinch.sdk.domains.sms.models.Parameters;
import com.sinch.sdk.domains.sms.models.requests.BatchesListRequestParameters;
import com.sinch.sdk.domains.sms.models.requests.SendSmsBatchTextRequest;
import com.sinch.sdk.domains.sms.models.requests.UpdateSmsBatchTextRequest;
import com.sinch.sdk.domains.sms.models.responses.BatchesListResponse;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Assertions;

public class BatchesSteps {

  BatchesService service;

  BatchText sendTextResponse;
  BatchText sendTextWithParametersResponse;
  DryRun dryRunResponse;
  BatchesListResponse listOnePageResponse;
  BatchesListResponse listAllResponse;
  BatchesListResponse listAllByPageResponse;
  BatchText getBatchResponse;
  BatchText updateResponse;
  BatchText replaceResponse;
  BatchText cancelResponse;
  Boolean sendDeliveryFeedbackPassed;

  @Given("^the SMS service \"Batches\" is available")
  public void serviceAvailable() {

    service = Config.getSinchClient().sms().batches();
  }

  @When("^I send a request to send a text message$")
  public void send() {
    SendSmsBatchTextRequest request =
        SendSmsBatchTextRequest.builder()
            .setBody("SMS body message")
            .setTo(Collections.singletonList("+12017777777"))
            .setFrom("+12015555555")
            .setSendAt(Instant.parse("2024-06-06T09:25:00Z"))
            .setDeliveryReport(DeliveryReportType.FULL)
            .setFeedbackEnabled(true)
            .build();

    sendTextResponse = service.send(request);
  }

  @When("^I send a request to send a text message with multiple parameters$")
  public void sendWithParameters() {
    SendSmsBatchTextRequest request =
        SendSmsBatchTextRequest.builder()
            .setBody("Hello ${name}! Get 20% off with this discount code ${code}")
            .setTo(Arrays.asList("+12017777777", "+12018888888"))
            .setFrom("+12015555555")
            .setParameters(
                new Parameters(
                    Arrays.asList(
                        new Parameters.Entry("name", new Pair<>("+12017777777", "John"), "there"),
                        new Parameters.Entry("name", new Pair<>("+12018888888", "Paul")),
                        new Parameters.Entry(
                            "code", new Pair<>("+12017777777", "HALLOWEEN20 \uD83C\uDF83")))))
            .setDeliveryReport(DeliveryReportType.FULL)
            .build();

    sendTextWithParametersResponse = service.send(request);
  }

  @When("^I send a request to perform a dry run of a batch$")
  public void dryRun() {
    SendSmsBatchTextRequest request =
        SendSmsBatchTextRequest.builder()
            .setBody("Hello ${name}!")
            .setTo(Arrays.asList("+12017777777", "+12018888888", "+12019999999"))
            .setFrom("+12015555555")
            .setParameters(
                new Parameters(
                    Arrays.asList(
                        new Parameters.Entry("name", new Pair<>("+12017777777", "John"), "there"))))
            .setDeliveryReport(DeliveryReportType.NONE)
            .build();

    dryRunResponse = service.dryRun(true, 3, request);
  }

  @When("^I send a request to list the SMS batches$")
  public void listOnePage() {
    BatchesListRequestParameters request =
        BatchesListRequestParameters.builder().setPageSize(2).build();

    listOnePageResponse = service.list(request);
  }

  @When("^I send a request to list all the SMS batches$")
  public void listAll() {
    BatchesListRequestParameters request =
        BatchesListRequestParameters.builder().setPageSize(2).build();

    listAllResponse = service.list(request);
  }

  @When("^I iterate manually over the SMS batches pages$")
  public void listAllByPage() {
    BatchesListRequestParameters request =
        BatchesListRequestParameters.builder().setPageSize(2).build();

    listAllByPageResponse = service.list(request);
  }

  @When("^I send a request to retrieve an SMS batch$")
  public void get() {

    getBatchResponse = service.get("foo");
  }

  @When("^I send a request to update an SMS batch$")
  public void update() {

    UpdateSmsBatchTextRequest request =
        UpdateSmsBatchTextRequest.builder()
            .setFrom("+12016666666")
            .setToAdd(Collections.singletonList("01W4FFL35P4NC4K35SMSGROUP1"))
            .setDeliveryReport(DeliveryReportType.SUMMARY)
            .build();
    updateResponse = service.update("foo", request);
  }

  @When("^I send a request to replace an SMS batch$")
  public void replace() {

    SendSmsBatchTextRequest request =
        SendSmsBatchTextRequest.builder()
            .setFrom("+12016666666")
            .setTo(Collections.singletonList("+12018888888"))
            .setBody("This is the replacement batch")
            .setSendAt(Instant.parse("2024-06-06T09:35:00Z"))
            .build();
    replaceResponse = service.replace("foo", request);
  }

  @When("^I send a request to cancel an SMS batch$")
  public void cancel() {

    cancelResponse = service.cancel("foo");
  }

  @When("^I send a request to send delivery feedbacks$")
  public void sendDeliveryFeedback() {

    service.sendDeliveryFeedback("foo", Arrays.asList("+12017777777"));
    sendDeliveryFeedbackPassed = true;
  }

  @Then("the response contains the text SMS details")
  public void sendResult() {
    BatchText expected =
        BatchText.builder()
            .setId("01W4FFL35P4NC4K35SMSBATCH1")
            .setTo(Collections.singletonList("12017777777"))
            .setFrom("12015555555")
            .setCanceled(false)
            .setBody("SMS body message")
            .setCreatedAt(Instant.parse("2024-06-06T09:22:14.304Z"))
            .setModifiedAt(Instant.parse("2024-06-06T09:22:14.304Z"))
            .setDeliveryReport(DeliveryReportType.FULL)
            .setSendAt(Instant.parse("2024-06-06T09:25:00Z"))
            .setExpireAt(Instant.parse("2024-06-09T09:25:00Z"))
            .setFeedbackEnabled(true)
            .setFlashMessage(false)
            .build();

    TestHelpers.recursiveEquals(sendTextResponse, expected);
  }

  @Then("the response contains the text SMS details with multiple parameters")
  public void sendWithParametersResult() {
    BatchText expected =
        BatchText.builder()
            .setId("01W4FFL35P4NC4K35SMSBATCH2")
            .setTo(Arrays.asList("12017777777", "12018888888"))
            .setFrom("12015555555")
            .setCanceled(false)
            .setParameters(
                new Parameters(
                    Arrays.asList(
                        new Parameters.Entry("name", new Pair<>("+12017777777", "John"), "there"),
                        new Parameters.Entry("name", new Pair<>("+12018888888", "Paul")),
                        new Parameters.Entry(
                            "code", new Pair<>("+12017777777", "HALLOWEEN20 \uD83C\uDF83")))))
            .setBody("Hello ${name}! Get 20% off with this discount code ${code}")
            .setCreatedAt(Instant.parse("2024-06-06T09:22:14.304Z"))
            .setModifiedAt(Instant.parse("2024-06-06T09:22:14.304Z"))
            .setDeliveryReport(DeliveryReportType.FULL)
            .setExpireAt(Instant.parse("2024-06-06T09:22:14.304Z"))
            .setFlashMessage(false)
            .build();

    TestHelpers.recursiveEquals(sendTextWithParametersResponse, expected);
  }

  @Then(
      "the response contains the calculated bodies and number of parts for all messages in the"
          + " batch")
  public void dryRunResult() {
    DryRun expected =
        DryRun.builder()
            .setNumberOfRecipients(3)
            .setNumberOfMessages(3)
            .setPerRecipient(
                Arrays.asList(
                    DryRunPerRecipientDetails.builder()
                        .setRecipient("12017777777")
                        .setNumberOfParts(1)
                        .setBody("Hello John!")
                        .setEncoding("text")
                        .build(),
                    DryRunPerRecipientDetails.builder()
                        .setRecipient("12019999999")
                        .setNumberOfParts(1)
                        .setBody("Hello there!")
                        .setEncoding("text")
                        .build(),
                    DryRunPerRecipientDetails.builder()
                        .setRecipient("12018888888")
                        .setNumberOfParts(1)
                        .setBody("Hello there!")
                        .setEncoding("text")
                        .build()))
            .build();

    TestHelpers.recursiveEquals(dryRunResponse, expected);
  }

  @Then("the response contains \"{int}\" SMS batches")
  public void onePageResult(int expected) {

    Assertions.assertEquals(listOnePageResponse.getContent().size(), expected);
  }

  @Then("the SMS batches list contains \"{int}\" SMS batches")
  public void listAllResult(int expected) {

    BatchesListResponse response =
        null != listAllResponse ? listAllResponse : listAllByPageResponse;

    AtomicInteger count = new AtomicInteger();
    response.iterator().forEachRemaining(_unused -> count.getAndIncrement());

    Assertions.assertEquals(count.get(), expected);
  }

  @Then("the SMS batches iteration result contains the data from \"{int}\" pages")
  public void listAllByPageResult(int expected) {

    int count = listAllByPageResponse.getContent().isEmpty() ? 0 : 1;
    while (listAllByPageResponse.hasNextPage()) {
      count++;
      listAllByPageResponse = listAllByPageResponse.nextPage();
    }
    Assertions.assertEquals(count, expected);
  }

  @Then("the response contains the SMS batch details")
  public void getResult() {

    BatchText expected =
        BatchText.builder()
            .setId("01W4FFL35P4NC4K35SMSBATCH1")
            .setTo(Collections.singletonList("12017777777"))
            .setFrom("12015555555")
            .setCanceled(false)
            .setBody("SMS body message")
            .setCreatedAt(Instant.parse("2024-06-06T09:22:14.304Z"))
            .setModifiedAt(Instant.parse("2024-06-06T09:22:14.304Z"))
            .setDeliveryReport(DeliveryReportType.FULL)
            .setSendAt(Instant.parse("2024-06-06T09:25:00Z"))
            .setExpireAt(Instant.parse("2024-06-09T09:25:00Z"))
            .setFeedbackEnabled(true)
            .setFlashMessage(false)
            .build();

    TestHelpers.recursiveEquals(getBatchResponse, expected);
  }

  @Then("the response contains the SMS batch details with updated data")
  public void updateResult() {

    BatchText expected =
        BatchText.builder()
            .setId("01W4FFL35P4NC4K35SMSBATCH1")
            .setTo(Arrays.asList("12017777777", "01W4FFL35P4NC4K35SMSGROUP1"))
            .setFrom("12016666666")
            .setCanceled(false)
            .setBody("SMS body message")
            .setCreatedAt(Instant.parse("2024-06-06T09:22:14.304Z"))
            .setModifiedAt(Instant.parse("2024-06-06T09:22:48.054Z"))
            .setDeliveryReport(DeliveryReportType.SUMMARY)
            .setSendAt(Instant.parse("2024-06-06T09:25:00Z"))
            .setExpireAt(Instant.parse("2024-06-09T09:25:00Z"))
            .setFeedbackEnabled(true)
            .setFlashMessage(false)
            .build();

    TestHelpers.recursiveEquals(updateResponse, expected);
  }

  @Then("the response contains the new SMS batch details with the provided data for replacement")
  public void replaceResult() {

    BatchText expected =
        BatchText.builder()
            .setId("01W4FFL35P4NC4K35SMSBATCH1")
            .setTo(Arrays.asList("12018888888"))
            .setFrom("12016666666")
            .setCanceled(false)
            .setBody("This is the replacement batch")
            .setCreatedAt(Instant.parse("2024-06-06T09:22:14.304Z"))
            .setModifiedAt(Instant.parse("2024-06-06T09:23:32.504Z"))
            .setDeliveryReport(DeliveryReportType.NONE)
            .setSendAt(Instant.parse("2024-06-06T09:35:00Z"))
            .setExpireAt(Instant.parse("2024-06-09T09:35:00Z"))
            .setFlashMessage(false)
            .build();

    TestHelpers.recursiveEquals(replaceResponse, expected);
  }

  @Then("the response contains the SMS batch details with a cancelled status")
  public void cancelResult() {

    BatchText expected =
        BatchText.builder()
            .setId("01W4FFL35P4NC4K35SMSBATCH1")
            .setTo(Arrays.asList("12017777777"))
            .setFrom("12015555555")
            .setCanceled(true)
            .setBody("SMS body message")
            .setCreatedAt(Instant.parse("2024-06-06T09:22:14.304Z"))
            .setModifiedAt(Instant.parse("2024-06-06T09:22:29.978Z"))
            .setDeliveryReport(DeliveryReportType.FULL)
            .setSendAt(Instant.parse("2024-06-06T09:25:00Z"))
            .setExpireAt(Instant.parse("2024-06-09T09:25:00Z"))
            .setFeedbackEnabled(true)
            .setFlashMessage(false)
            .build();

    TestHelpers.recursiveEquals(cancelResponse, expected);
  }

  @Then("the delivery feedback response contains no data")
  public void setSendDeliveryFeedbackResult() {
    Assertions.assertTrue(sendDeliveryFeedbackPassed);
  }
}
