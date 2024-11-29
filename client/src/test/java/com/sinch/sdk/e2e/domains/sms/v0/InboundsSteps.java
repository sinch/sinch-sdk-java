package com.sinch.sdk.e2e.domains.sms.v0;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.sms.InboundsService;
import com.sinch.sdk.domains.sms.models.InboundText;
import com.sinch.sdk.domains.sms.models.requests.InboundsListRequestParameters;
import com.sinch.sdk.domains.sms.models.responses.InboundsListResponse;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Assertions;

public class InboundsSteps {

  InboundsService service;
  InboundText getResponse;
  InboundsListResponse listOnePageResponse;
  InboundsListResponse listAllResponse;
  InboundsListResponse listAllByPageResponse;

  @Given("^the SMS service \"Inbounds\" is available")
  public void serviceAvailable() {

    service = Config.getSinchClient().sms().inbounds();
  }

  @When("^I send a request to retrieve an inbound message")
  public void get() {

    getResponse = (InboundText) service.get("inboundid");
  }

  @When("^I send a request to list the inbound messages$")
  public void listOnePage() {
    InboundsListRequestParameters request =
        InboundsListRequestParameters.builder()
            .setTo(Arrays.asList("12017777777", "12018888888"))
            .setPageSize(2)
            .build();

    listOnePageResponse = service.list(request);
  }

  @When("^I send a request to list all the inbound messages$")
  public void listAll() {
    InboundsListRequestParameters request =
        InboundsListRequestParameters.builder()
            .setTo(Arrays.asList("12017777777", "12018888888"))
            .setPageSize(2)
            .build();

    listAllResponse = service.list(request);
  }

  @When("^I iterate manually over the inbound messages pages$")
  public void listAllByPage() {
    InboundsListRequestParameters request =
        InboundsListRequestParameters.builder()
            .setTo(Arrays.asList("12017777777", "12018888888"))
            .setPageSize(2)
            .build();

    listAllByPageResponse = service.list(request);
  }

  @Then("the response contains the inbound message details")
  public void getResult() {
    InboundText expected =
        InboundText.builder()
            .setBody("Hello John!")
            .setFrom("12015555555")
            .setId("01W4FFL35P4NC4K35INBOUND01")
            .setOperatorId("311071")
            .setReceivedAt(Instant.parse("2024-06-06T14:16:54.777Z"))
            .setTo("12017777777")
            .build();

    TestHelpers.recursiveEquals(getResponse, expected);
  }

  @Then("the response contains \"{int}\" inbound messages")
  public void onePageResult(int expected) {

    Assertions.assertEquals(listOnePageResponse.getContent().size(), expected);
  }

  @Then("the inbound messages list contains \"{int}\" inbound messages")
  public void listAllResult(int expected) {
    InboundsListResponse response =
        null != listAllResponse ? listAllResponse : listAllByPageResponse;

    AtomicInteger count = new AtomicInteger();
    response.iterator().forEachRemaining(_unused -> count.getAndIncrement());

    Assertions.assertEquals(count.get(), expected);
  }

  @Then("the inbound messages iteration result contains the data from \"{int}\" pages")
  public void listAllByPageResult(int expected) {

    int count = listAllByPageResponse.getContent().isEmpty() ? 0 : 1;
    while (listAllByPageResponse.hasNextPage()) {
      count++;
      listAllByPageResponse = listAllByPageResponse.nextPage();
    }
    Assertions.assertEquals(count, expected);
  }
}
