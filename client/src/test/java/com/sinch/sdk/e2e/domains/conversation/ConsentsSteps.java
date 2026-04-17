package com.sinch.sdk.e2e.domains.conversation;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.ConsentsService;
import com.sinch.sdk.domains.conversation.models.v1.consents.ConsentsListType;
import com.sinch.sdk.domains.conversation.models.v1.consents.request.ConsentsListQueryParameters;
import com.sinch.sdk.domains.conversation.models.v1.consents.response.AuditRecord;
import com.sinch.sdk.domains.conversation.models.v1.consents.response.AuditRecordsResponse;
import com.sinch.sdk.domains.conversation.models.v1.consents.response.ConsentsListResponse;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Instant;
import java.util.Iterator;
import org.junit.jupiter.api.Assertions;

public class ConsentsSteps {

  static final String APP_ID = AppsSteps.APP_ID;
  static final String IDENTITY = "33612345678";

  ConsentsService service;
  ConsentsListResponse listPageResponse;
  AuditRecordsResponse listAuditRecordsResponse;

  @Given("^the Conversation service \"Consents\" is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().conversation().v1().consents();
  }

  @When("^I send a request to list the existing Consent Identities$")
  public void listPage() {
    ConsentsListQueryParameters queryParams =
        ConsentsListQueryParameters.builder().setPageSize(10).build();
    listPageResponse = service.listIdentities(APP_ID, ConsentsListType.OPT_OUT_ALL, queryParams);
  }

  @When("^I send a request to list all the Consent Identities$")
  public void listAll() {
    ConsentsListQueryParameters queryParams =
        ConsentsListQueryParameters.builder().setPageSize(10).build();
    listPageResponse = service.listIdentities(APP_ID, ConsentsListType.OPT_OUT_ALL, queryParams);
  }

  @When("^I iterate manually over the Consent Identities pages$")
  public void listIterateManually() {
    ConsentsListQueryParameters queryParams =
        ConsentsListQueryParameters.builder().setPageSize(10).build();
    listPageResponse = service.listIdentities(APP_ID, ConsentsListType.OPT_OUT_ALL, queryParams);
  }

  @When("^I send a request to list the Audit Records associated with an identity$")
  public void listAuditRecords() {
    listAuditRecordsResponse = service.listAuditRecords(APP_ID, IDENTITY);
  }

  @Then("the response contains \"{int}\" Consent Identities")
  public void listPageResult(int count) {
    Assertions.assertEquals(count, listPageResponse.getContent().size());
  }

  @Then("the Consent Identities list contains \"{int}\" Consent Identities")
  public void listAllResult(int count) {
    Iterator<?> iterator = listPageResponse.iterator();
    TestHelpers.checkIteratorItems(iterator, count);
  }

  @Then("the Consent Identities iteration result contains the data from \"{int}\" pages")
  public void listPageIterateResult(int count) {
    int pageCount = 0;
    ConsentsListResponse currentPage = listPageResponse;
    do {
      pageCount++;
      if (!currentPage.hasNextPage()) {
        break;
      }
      currentPage = currentPage.nextPage();
    } while (true);

    Assertions.assertEquals(pageCount, count);
  }

  @Then("the response contains list of the Audit Records associated with an identity")
  public void listAuditRecordsResult() {
    Assertions.assertNotNull(listAuditRecordsResponse);
    Assertions.assertNotNull(listAuditRecordsResponse.getIdentity());
    Assertions.assertEquals("33612345678", listAuditRecordsResponse.getIdentity().getIdentity());

    Assertions.assertNotNull(listAuditRecordsResponse.getAuditRecords());
    Assertions.assertEquals(1, listAuditRecordsResponse.getAuditRecords().size());

    AuditRecord record = listAuditRecordsResponse.getAuditRecords().get(0);
    Assertions.assertEquals(AuditRecord.OriginEnum.ORIGIN_MO, record.getOrigin());
    Assertions.assertEquals(AuditRecord.OperationEnum.OPERATION_INSERT, record.getOperation());
    Assertions.assertEquals(ConsentsListType.OPT_OUT_ALL, record.getListType());
    Assertions.assertEquals("123coffee-dada-beef-cafe-baadc0de5678", record.getProjectId());
    Assertions.assertEquals(APP_ID, record.getAppId());
    Assertions.assertEquals(Instant.parse("2025-06-06T14:42:56.031323Z"), record.getDatetime());
  }
}
