package com.sinch.sdk.e2e.domains.sms.v1;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.sms.api.v1.BatchesService;
import com.sinch.sdk.domains.sms.models.v1.batches.DeliveryReportType;
import com.sinch.sdk.domains.sms.models.v1.batches.request.ListBatchesRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.request.SendDeliveryFeedbackRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.request.TextRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.request.UpdateTextRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.response.BatchResponse;
import com.sinch.sdk.domains.sms.models.v1.batches.response.DryRunPerRecipientDetails;
import com.sinch.sdk.domains.sms.models.v1.batches.response.DryRunResponse;
import com.sinch.sdk.domains.sms.models.v1.batches.response.ListBatchesResponse;
import com.sinch.sdk.domains.sms.models.v1.batches.response.TextResponse;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Instant;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;

public class BatchesSteps {

  BatchesService service;

  BatchResponse sendTextResponse;
  BatchResponse sendTextWithParametersResponse;
  DryRunResponse dryRunResponse;
  ListBatchesResponse listOnePageResponse;
  ListBatchesResponse listAllResponse;
  ListBatchesResponse listAllByPageResponse;
  BatchResponse getBatchResponse;
  BatchResponse updateResponse;
  BatchResponse replaceResponse;
  BatchResponse cancelResponse;
  Boolean sendDeliveryFeedbackPassed;

  @Given("^the SMS service \"Batches\" is available")
  public void serviceAvailable() {

    service = Config.getSinchClient().sms().v1().batches();
  }

  @When("^I send a request to send a text message$")
  public void send() {
    TextRequest request =
        TextRequest.builder()
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

    Map<String, String> nameParameters =
        Stream.of(
                new AbstractMap.SimpleEntry<>("+12017777777", "John"),
                new AbstractMap.SimpleEntry<>("+12018888888", "Paul"),
                new AbstractMap.SimpleEntry<>("default", "there"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    Map<String, String> codeParameters =
        Stream.of(new AbstractMap.SimpleEntry<>("+12017777777", "HALLOWEEN20 \uD83C\uDF83"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    Map<String, Map<String, String>> parameters =
        Stream.of(
                new AbstractMap.SimpleEntry<>("name", nameParameters),
                new AbstractMap.SimpleEntry<>("code", codeParameters))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    TextRequest request =
        TextRequest.builder()
            .setBody("Hello ${name}! Get 20% off with this discount code ${code}")
            .setTo(Arrays.asList("+12017777777", "+12018888888"))
            .setFrom("+12015555555")
            .setParameters(parameters)
            .setDeliveryReport(DeliveryReportType.FULL)
            .build();

    sendTextWithParametersResponse = service.send(request);
  }

  @When("^I send a request to perform a dry run of a batch$")
  public void dryRun() {

    Map<String, String> nameParameters =
        Stream.of(
                new AbstractMap.SimpleEntry<>("+12017777777", "John"),
                new AbstractMap.SimpleEntry<>("default", "there"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    Map<String, Map<String, String>> parameters =
        Stream.of(new AbstractMap.SimpleEntry<>("name", nameParameters))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    TextRequest request =
        TextRequest.builder()
            .setBody("Hello ${name}!")
            .setTo(Arrays.asList("+12017777777", "+12018888888", "+12019999999"))
            .setFrom("+12015555555")
            .setParameters(parameters)
            .setDeliveryReport(DeliveryReportType.NONE)
            .build();

    dryRunResponse = service.dryRun(true, 3, request);
  }

  @When("^I send a request to list the SMS batches$")
  public void listOnePage() {
    ListBatchesRequest request = ListBatchesRequest.builder().setPageSize(2).build();

    listOnePageResponse = service.list(request);
  }

  @When("^I send a request to list all the SMS batches$")
  public void listAll() {
    ListBatchesRequest request = ListBatchesRequest.builder().setPageSize(2).build();

    listAllResponse = service.list(request);
  }

  @When("^I iterate manually over the SMS batches pages$")
  public void listAllByPage() {
    ListBatchesRequest request = ListBatchesRequest.builder().setPageSize(2).build();

    listAllByPageResponse = service.list(request);
  }

  @When("^I send a request to retrieve an SMS batch$")
  public void get() {

    getBatchResponse = service.get("foo");
  }

  @When("^I send a request to update an SMS batch$")
  public void update() {

    UpdateTextRequest request =
        UpdateTextRequest.builder()
            .setFrom("+12016666666")
            .setToAdd(Collections.singletonList("01W4FFL35P4NC4K35SMSGROUP1"))
            .setDeliveryReport(DeliveryReportType.SUMMARY)
            .build();
    updateResponse = service.update("foo", request);
  }

  @When("^I send a request to replace an SMS batch$")
  public void replace() {

    TextRequest request =
        TextRequest.builder()
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

    SendDeliveryFeedbackRequest request =
        SendDeliveryFeedbackRequest.builder()
            .setRecipients(Collections.singletonList("+12017777777"))
            .build();
    service.sendDeliveryFeedback("foo", request);
    sendDeliveryFeedbackPassed = true;
  }

  @Then("the response contains the text SMS details")
  public void sendResult() {
    TextResponse expected =
        TextResponse.builder()
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

    Map<String, String> nameParameters =
        Stream.of(
                new AbstractMap.SimpleEntry<>("+12017777777", "John"),
                new AbstractMap.SimpleEntry<>("+12018888888", "Paul"),
                new AbstractMap.SimpleEntry<>("default", "there"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    Map<String, String> codeParameters =
        Stream.of(new AbstractMap.SimpleEntry<>("+12017777777", "HALLOWEEN20 \uD83C\uDF83"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    Map<String, Map<String, String>> parameters =
        Stream.of(
                new AbstractMap.SimpleEntry<>("name", nameParameters),
                new AbstractMap.SimpleEntry<>("code", codeParameters))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    TextResponse expected =
        TextResponse.builder()
            .setId("01W4FFL35P4NC4K35SMSBATCH2")
            .setTo(Arrays.asList("12017777777", "12018888888"))
            .setFrom("12015555555")
            .setCanceled(false)
            .setParameters(parameters)
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
    DryRunResponse expected =
        DryRunResponse.builder()
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

    ListBatchesResponse response =
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

    TextResponse expected =
        TextResponse.builder()
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

    TextResponse expected =
        TextResponse.builder()
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

    TextResponse expected =
        TextResponse.builder()
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

    TextResponse expected =
        TextResponse.builder()
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
