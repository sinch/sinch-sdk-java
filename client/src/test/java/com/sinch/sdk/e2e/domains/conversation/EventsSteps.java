package com.sinch.sdk.e2e.domains.conversation;

import com.sinch.sdk.domains.conversation.api.v1.EventsService;
import com.sinch.sdk.domains.conversation.models.v1.ContactId;
import com.sinch.sdk.domains.conversation.models.v1.events.ConversationEvent;
import com.sinch.sdk.domains.conversation.models.v1.events.request.EventsListRequest;
import com.sinch.sdk.domains.conversation.models.v1.events.request.SendEventRequest;
import com.sinch.sdk.domains.conversation.models.v1.events.response.EventsListResponse;
import com.sinch.sdk.domains.conversation.models.v1.events.response.SendEventResponse;
import com.sinch.sdk.domains.conversation.models.v1.events.types.ComposingEvent;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class EventsSteps {

  static final String EVENT_ID = "01W4FFL35P4NC4K35CONVEVENT1";

  EventsService service;
  SendEventResponse sendResponse;
  EventsListResponse listPageResponse;
  EventsListResponse listAllResponse;
  EventsListResponse listPageIterateResponse;
  ConversationEvent getResponse;
  boolean deletePassed;

  @Given("^the Conversation service \"Events\" is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().conversation().v1().events();
  }

  @When("^I send a request to send a conversation event to a contact$")
  public void send() {

    SendEventRequest request =
        SendEventRequest.builder()
            .setAppId(AppsSteps.APP_ID)
            .setRecipient(ContactId.builder().setContactId(ContactsSteps.CONTACT_ID).build())
            .setEvent(ComposingEvent.EMPTY)
            .build();

    sendResponse = service.send(request);
  }

  @When("^I send a request to list the existing conversation events$")
  public void listPage() {

    EventsListRequest request = EventsListRequest.builder().setPageSize(2).build();
    listPageResponse = service.list(request);
  }

  @When("^I send a request to list all the conversation events$")
  public void listAll() {

    EventsListRequest request = EventsListRequest.builder().setPageSize(2).build();
    listAllResponse = service.list(request);
  }

  @When("^I iterate manually over the conversation events pages$")
  public void listPageIterate() {

    EventsListRequest request = EventsListRequest.builder().setPageSize(2).build();
    listPageIterateResponse = service.list(request);
  }

  @When("^I send a request to retrieve a conversation event$")
  public void get() {

    getResponse = service.get(EVENT_ID);
  }

  @When("^I send a request to delete a conversation event$")
  public void delete() {

    service.delete(EVENT_ID);
    deletePassed = true;
  }

  @Then("the response contains the id of the conversation event")
  public void sendResult() {
    Assertions.assertEquals(sendResponse.getEventId(), EVENT_ID);
  }

  @Then("the response contains \"{int}\" conversation events")
  public void listPageResult(int size) {

    Assertions.assertEquals(listPageResponse.getContent().size(), size);
  }

  @Then("the conversation events list contains \"{int}\" conversation events")
  public void listAllResult(int size) {

    // FIXME: to be thread-safe compliant we need to check which variables are set
    if (null != listAllResponse) Assertions.assertEquals(listAllResponse.stream().count(), size);
    if (null != listPageIterateResponse)
      Assertions.assertEquals(listPageIterateResponse.stream().count(), size);
  }

  @Then("the conversation events iteration result contains the data from \"{int}\" pages")
  public void listPageIterateResult(int size) {

    int pageCount = 0;

    EventsListResponse listPageIterateResponseThreadSafety = listPageIterateResponse;
    do {
      pageCount++;
      if (!listPageIterateResponseThreadSafety.hasNextPage()) {
        break;
      }
      listPageIterateResponseThreadSafety = listPageIterateResponseThreadSafety.nextPage();

    } while (true);

    Assertions.assertEquals(pageCount, size);
  }

  @Then("the response contains the conversation event details")
  public void getResult() {

    Assertions.assertEquals(getResponse.getId(), EVENT_ID);
  }

  @Then("the delete conversation event response contains no data")
  public void deleteResult() {

    Assertions.assertTrue(deletePassed);
  }
}
