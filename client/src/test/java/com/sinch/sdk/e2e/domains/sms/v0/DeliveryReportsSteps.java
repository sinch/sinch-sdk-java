package com.sinch.sdk.e2e.domains.sms.v0;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.sms.DeliveryReportsService;
import com.sinch.sdk.domains.sms.models.DeliveryReportBatch;
import com.sinch.sdk.domains.sms.models.DeliveryReportBatchSMS;
import com.sinch.sdk.domains.sms.models.DeliveryReportErrorCode;
import com.sinch.sdk.domains.sms.models.DeliveryReportRecipient;
import com.sinch.sdk.domains.sms.models.DeliveryReportRecipientSMS;
import com.sinch.sdk.domains.sms.models.DeliveryReportStatus;
import com.sinch.sdk.domains.sms.models.DeliveryReportStatusDetails;
import com.sinch.sdk.domains.sms.models.DeliveryReportType;
import com.sinch.sdk.domains.sms.models.requests.DeliveryReportBatchGetRequestParameters;
import com.sinch.sdk.domains.sms.models.requests.DeliveryReportListRequestParameters;
import com.sinch.sdk.domains.sms.models.responses.DeliveryReportsListResponse;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Assertions;

public class DeliveryReportsSteps {

  DeliveryReportsService service;

  DeliveryReportBatch summaryReport;
  DeliveryReportBatch fullReport;
  DeliveryReportRecipient recipientReport;
  DeliveryReportsListResponse listOnePageResponse;
  DeliveryReportsListResponse listAllResponse;
  DeliveryReportsListResponse listAllByPageResponse;

  @Given("^the SMS service \"Delivery Reports\" is available")
  public void serviceAvailable() {

    service = Config.getSinchClient().sms().deliveryReports();
  }

  @When("^I send a request to retrieve a summary SMS delivery report$")
  public void getSummary() {
    DeliveryReportBatchGetRequestParameters request =
        DeliveryReportBatchGetRequestParameters.builder()
            .setType(DeliveryReportType.SUMMARY)
            .setStatuses(Arrays.asList(DeliveryReportStatus.DELIVERED, DeliveryReportStatus.FAILED))
            .setCodes(Arrays.asList(15, 0))
            .build();

    summaryReport = service.get("foo", request);
  }

  @When("^I send a request to retrieve a full SMS delivery report$")
  public void getFull() {
    DeliveryReportBatchGetRequestParameters request =
        DeliveryReportBatchGetRequestParameters.builder().setType(DeliveryReportType.FULL).build();

    fullReport = service.get("foo", request);
  }

  @When("^I send a request to retrieve a recipient's delivery report$")
  public void getRecipient() {

    recipientReport = service.getForNumber("foo", "+12345678");
  }

  @When("^I send a request to list the SMS delivery reports$")
  public void listOnePage() {
    DeliveryReportListRequestParameters request =
        DeliveryReportListRequestParameters.builder().setPageSize(2).build();

    listOnePageResponse = service.list(request);
  }

  @When("^I send a request to list all the SMS delivery reports$")
  public void listAll() {
    DeliveryReportListRequestParameters request =
        DeliveryReportListRequestParameters.builder().setPageSize(2).build();

    listAllResponse = service.list(request);
  }

  @When("^I iterate manually over the SMS delivery reports pages$")
  public void listAllByPage() {
    DeliveryReportListRequestParameters request =
        DeliveryReportListRequestParameters.builder().setPageSize(2).build();

    listAllByPageResponse = service.list(request);
  }

  @Then("the response contains a summary SMS delivery report")
  public void getSummaryResult() {
    DeliveryReportBatch expected =
        DeliveryReportBatchSMS.builder()
            .setBatchId("01W4FFL35P4NC4K35SMSBATCH1")
            .setClientReference("reference_e2e")
            .setStatuses(
                Arrays.asList(
                    DeliveryReportStatusDetails.builder()
                        .setCode(15)
                        .setCount(1)
                        .setStatus(DeliveryReportStatus.FAILED)
                        .build(),
                    DeliveryReportStatusDetails.builder()
                        .setCode(0)
                        .setCount(1)
                        .setStatus(DeliveryReportStatus.DELIVERED)
                        .build()))
            .setTotalMessageCount(2)
            .build();
    TestHelpers.recursiveEquals(summaryReport, expected);
  }

  @Then("the response contains a full SMS delivery report")
  public void getFullResult() {
    DeliveryReportBatch expected =
        DeliveryReportBatchSMS.builder()
            .setBatchId("01W4FFL35P4NC4K35SMSBATCH1")
            .setClientReference("reference_e2e")
            .setStatuses(
                Arrays.asList(
                    DeliveryReportStatusDetails.builder()
                        .setCode(0)
                        .setCount(1)
                        .setStatus(DeliveryReportStatus.DELIVERED)
                        .setRecipients(Collections.singletonList("12017777777"))
                        .build(),
                    DeliveryReportStatusDetails.builder()
                        .setCode(15)
                        .setCount(1)
                        .setStatus(DeliveryReportStatus.FAILED)
                        .setRecipients(Collections.singletonList("12018888888"))
                        .build()))
            .setTotalMessageCount(2)
            .build();
    TestHelpers.recursiveEquals(fullReport, expected);
  }

  @Then("the response contains the recipient's delivery report details")
  public void getRecipientResult() {
    DeliveryReportRecipient expected =
        DeliveryReportRecipientSMS.builder()
            .setAt(Instant.parse("2024-06-06T13:06:27.833Z"))
            .setBatchId("01W4FFL35P4NC4K35SMSBATCH1")
            .setClientReference("reference_e2e")
            .setCode(DeliveryReportErrorCode.from(0))
            .setOperatorStatusAt(Instant.parse("2024-06-06T13:06:00Z"))
            .setRecipient("12017777777")
            .setStatus(DeliveryReportStatus.DELIVERED)
            .build();

    TestHelpers.recursiveEquals(recipientReport, expected);
  }

  @Then("the response contains \"{int}\" SMS delivery reports")
  public void onePageResult(int expected) {

    Assertions.assertEquals(listOnePageResponse.getContent().size(), expected);
  }

  @Then("the SMS delivery reports list contains \"{int}\" SMS delivery reports")
  public void listAllResult(int expected) {
    DeliveryReportsListResponse response =
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
