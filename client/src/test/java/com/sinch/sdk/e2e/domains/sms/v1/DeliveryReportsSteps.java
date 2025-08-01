package com.sinch.sdk.e2e.domains.sms.v1;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.sms.api.v1.DeliveryReportsService;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.BatchDeliveryReport;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.BatchDeliveryReportSMS;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.DeliveryReceiptStatusCode;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.DeliveryStatus;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.MessageDeliveryStatus;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.RecipientDeliveryReport;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.RecipientDeliveryReportSMS;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.request.BatchDeliveryReportQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.request.ListDeliveryReportsQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.request.QueryReportType;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.response.ListDeliveryReportsResponse;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Assertions;

public class DeliveryReportsSteps {

  DeliveryReportsService service;

  BatchDeliveryReport summaryReport;
  BatchDeliveryReport fullReport;
  RecipientDeliveryReport recipientReport;
  ListDeliveryReportsResponse listOnePageResponse;
  ListDeliveryReportsResponse listAllResponse;
  ListDeliveryReportsResponse listAllByPageResponse;

  @Given("^the SMS service \"Delivery Reports\" is available")
  public void serviceAvailable() {

    service = Config.getSinchClient().sms().v1().deliveryReports();
  }

  @When("^I send a request to retrieve a summary SMS delivery report$")
  public void getSummary() {
    BatchDeliveryReportQueryParameters request =
        BatchDeliveryReportQueryParameters.builder()
            .setType(QueryReportType.SUMMARY)
            .setStatus(Arrays.asList(DeliveryStatus.DELIVERED, DeliveryStatus.FAILED))
            .setCode(
                Arrays.asList(
                    DeliveryReceiptStatusCode.from(15), DeliveryReceiptStatusCode.from(0)))
            .build();

    summaryReport = service.get("foo", request);
  }

  @When("^I send a request to retrieve a full SMS delivery report$")
  public void getFull() {
    BatchDeliveryReportQueryParameters request =
        BatchDeliveryReportQueryParameters.builder().setType(QueryReportType.FULL).build();

    fullReport = service.get("foo", request);
  }

  @When("^I send a request to retrieve a recipient's delivery report$")
  public void getRecipient() {

    recipientReport = service.getForNumber("foo", "+12345678");
  }

  @When("^I send a request to list the SMS delivery reports$")
  public void listOnePage() {
    ListDeliveryReportsQueryParameters request =
        ListDeliveryReportsQueryParameters.builder().setPageSize(2).build();

    listOnePageResponse = service.list(request);
  }

  @When("^I send a request to list all the SMS delivery reports$")
  public void listAll() {
    ListDeliveryReportsQueryParameters request =
        ListDeliveryReportsQueryParameters.builder().setPageSize(2).build();

    listAllResponse = service.list(request);
  }

  @When("^I iterate manually over the SMS delivery reports pages$")
  public void listAllByPage() {
    ListDeliveryReportsQueryParameters request =
        ListDeliveryReportsQueryParameters.builder().setPageSize(2).build();

    listAllByPageResponse = service.list(request);
  }

  @Then("the response contains a summary SMS delivery report")
  public void getSummaryResult() {
    BatchDeliveryReport expected =
        BatchDeliveryReportSMS.builder()
            .setBatchId("01W4FFL35P4NC4K35SMSBATCH1")
            .setClientReference("reference_e2e")
            .setStatuses(
                Arrays.asList(
                    MessageDeliveryStatus.builder()
                        .setCode(DeliveryReceiptStatusCode.from(15))
                        .setCount(1)
                        .setStatus(DeliveryStatus.FAILED)
                        .build(),
                    MessageDeliveryStatus.builder()
                        .setCode(DeliveryReceiptStatusCode.from(0))
                        .setCount(1)
                        .setStatus(DeliveryStatus.DELIVERED)
                        .build()))
            .setTotalMessageCount(2)
            .build();
    TestHelpers.recursiveEquals(summaryReport, expected);
  }

  @Then("the response contains a full SMS delivery report")
  public void getFullResult() {
    BatchDeliveryReport expected =
        BatchDeliveryReportSMS.builder()
            .setBatchId("01W4FFL35P4NC4K35SMSBATCH1")
            .setClientReference("reference_e2e")
            .setStatuses(
                Arrays.asList(
                    MessageDeliveryStatus.builder()
                        .setCode(DeliveryReceiptStatusCode.from(0))
                        .setCount(1)
                        .setStatus(DeliveryStatus.DELIVERED)
                        .setRecipients(new HashSet<>(Collections.singletonList("12017777777")))
                        .build(),
                    MessageDeliveryStatus.builder()
                        .setCode(DeliveryReceiptStatusCode.from(15))
                        .setCount(1)
                        .setStatus(DeliveryStatus.FAILED)
                        .setRecipients(new HashSet<>(Collections.singletonList("12018888888")))
                        .build()))
            .setTotalMessageCount(2)
            .build();
    TestHelpers.recursiveEquals(fullReport, expected);
  }

  @Then("the response contains the recipient's delivery report details")
  public void getRecipientResult() {
    RecipientDeliveryReport expected =
        RecipientDeliveryReportSMS.builder()
            .setCreatedAt(Instant.parse("2024-06-06T13:06:27.833Z"))
            .setBatchId("01W4FFL35P4NC4K35SMSBATCH1")
            .setClientReference("reference_e2e")
            .setCode(DeliveryReceiptStatusCode.from(0))
            .setOperatorStatusAt(Instant.parse("2024-06-06T13:06:00Z"))
            .setRecipient("12017777777")
            .setStatus(DeliveryStatus.DELIVERED)
            .build();

    TestHelpers.recursiveEquals(recipientReport, expected);
  }

  @Then("the response contains \"{int}\" SMS delivery reports")
  public void onePageResult(int expected) {

    Assertions.assertEquals(listOnePageResponse.getContent().size(), expected);
  }

  @Then("the SMS delivery reports list contains \"{int}\" SMS delivery reports")
  public void listAllResult(int expected) {
    ListDeliveryReportsResponse response =
        null != listAllResponse ? listAllResponse : listAllByPageResponse;

    AtomicInteger count = new AtomicInteger();
    response.iterator().forEachRemaining(_unused -> count.getAndIncrement());

    Assertions.assertEquals(count.get(), expected);
  }

  @Then("the SMS delivery reports iteration result contains the data from \"{int}\" pages")
  public void listAllByPageResult(int expected) {

    int count = listAllByPageResponse.getContent().isEmpty() ? 0 : 1;
    while (listAllByPageResponse.hasNextPage()) {
      count++;
      listAllByPageResponse = listAllByPageResponse.nextPage();
    }
    Assertions.assertEquals(count, expected);
  }
}
