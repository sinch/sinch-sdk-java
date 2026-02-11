package com.sinch.sdk.e2e.domains.conversation;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.ConversationsService;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.ConversationDirection;
import com.sinch.sdk.domains.conversation.models.v1.conversations.Conversation;
import com.sinch.sdk.domains.conversation.models.v1.conversations.request.ConversationsListQueryParameters;
import com.sinch.sdk.domains.conversation.models.v1.conversations.request.ConversationsUpdateQueryParameters;
import com.sinch.sdk.domains.conversation.models.v1.conversations.request.CreateConversationRequest;
import com.sinch.sdk.domains.conversation.models.v1.conversations.request.InjectEventRequest;
import com.sinch.sdk.domains.conversation.models.v1.conversations.request.InjectMessageRequest;
import com.sinch.sdk.domains.conversation.models.v1.conversations.request.RecentConversationsListQueryParameters;
import com.sinch.sdk.domains.conversation.models.v1.conversations.response.ConversationsListResponse;
import com.sinch.sdk.domains.conversation.models.v1.conversations.response.InjectEventResponse;
import com.sinch.sdk.domains.conversation.models.v1.conversations.response.RecentConversationsListResponse;
import com.sinch.sdk.domains.conversation.models.v1.events.types.ComposingEvent;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import com.sinch.sdk.domains.conversation.models.v1.request.MetadataUpdateStrategy;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Instant;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;

public class ConversationsSteps {

  static final String CONVERSATION_ID = "01W4FFL35P4NC4K35CONVERS001";

  ConversationsService service;
  Conversation createResponse;
  ConversationsListResponse listPageResponse;
  ConversationsListResponse listAllResponse;
  ConversationsListResponse listPageIterateResponse;
  RecentConversationsListResponse listRecentPageResponse;
  RecentConversationsListResponse listRecentAllResponse;
  RecentConversationsListResponse listRecentPageIterateResponse;
  Conversation getResponse;
  Conversation updateResponse;
  boolean deletePassed;
  InjectEventResponse injectEventResponse;
  boolean injectMessagePassed;
  boolean stopConversationPassed;

  @Given("^the Conversation service \"Conversations\" is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().conversation().v1().conversations();
  }

  @When("^I send a request to create a conversation$")
  public void create() {

    CreateConversationRequest request =
        CreateConversationRequest.builder()
            .setAppId(AppsSteps.APP_ID)
            .setContactId(ContactsSteps.CONTACT_ID)
            .setActive(true)
            .setActiveChannel(ConversationChannel.MESSENGER)
            .setMetadata("e2e tests")
            .setMetadataJson(
                Stream.of(
                        new AbstractMap.SimpleEntry<>("prop1", "value1"),
                        new AbstractMap.SimpleEntry<>("prop2", "value2"))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)))
            .build();

    createResponse = service.create(request);
  }

  @When("^I send a request to list the existing conversations$")
  public void listPage() {

    ConversationsListQueryParameters request =
        ConversationsListQueryParameters.builder().setAppId(AppsSteps.APP_ID).build();
    listPageResponse = service.list(request);
  }

  @When("^I send a request to list all the conversations$")
  public void listAll() {

    ConversationsListQueryParameters request =
        ConversationsListQueryParameters.builder().setAppId(AppsSteps.APP_ID).build();
    listAllResponse = service.list(request);
  }

  @When("^I iterate manually over the conversations pages$")
  public void listPageIterate() {

    ConversationsListQueryParameters request =
        ConversationsListQueryParameters.builder().setAppId(AppsSteps.APP_ID).build();
    listPageIterateResponse = service.list(request);
  }

  @When("^I send a request to list the recent conversations$")
  public void listRecentPage() {

    RecentConversationsListQueryParameters request =
        RecentConversationsListQueryParameters.builder().setAppId(AppsSteps.APP_ID).build();
    listRecentPageResponse = service.listRecent(request);
  }

  @When("^I send a request to list all the recent conversations$")
  public void listRecentAll() {

    RecentConversationsListQueryParameters request =
        RecentConversationsListQueryParameters.builder().setAppId(AppsSteps.APP_ID).build();
    listRecentAllResponse = service.listRecent(request);
  }

  @When("^I iterate manually over the recent conversations pages$")
  public void listRecentPageIterate() {

    RecentConversationsListQueryParameters request =
        RecentConversationsListQueryParameters.builder().setAppId(AppsSteps.APP_ID).build();
    listRecentPageIterateResponse = service.listRecent(request);
  }

  @When("^I send a request to retrieve a conversation$")
  public void get() {

    getResponse = service.get(CONVERSATION_ID);
  }

  @When("^I send a request to update a conversation$")
  public void update() {

    Conversation request =
        Conversation.builder()
            .setAppId("01W4FFL35P4NC4K35CONVAPP002")
            .setActive(false)
            .setMetadata("Transferred conversation")
            .setCorrelationId("my-correlator")
            .build();
    updateResponse =
        service.update(
            CONVERSATION_ID,
            ConversationsUpdateQueryParameters.builder()
                .setMetadataUpdateStrategy(MetadataUpdateStrategy.REPLACE)
                .build(),
            request);
  }

  @When("^I send a request to delete a conversation$")
  public void delete() {

    service.delete(CONVERSATION_ID);
    deletePassed = true;
  }

  @When("^I send a request to inject an event into a conversation$")
  public void injectEvent() {
    InjectEventRequest request =
        InjectEventRequest.builder()
            .setAppEvent(ComposingEvent.COMPOSING_EVENT)
            .setAcceptTime(Instant.now())
            .build();
    injectEventResponse = service.injectEvent(CONVERSATION_ID, request);
  }

  @When("^I send a request to inject a message into a conversation$")
  public void injectMessage() {
    InjectMessageRequest request =
        InjectMessageRequest.builder()
            .setContactId("01W4FFL35P4NC4K35CONTACT002")
            .setChannelIdentity(
                ChannelIdentity.builder()
                    .setChannel(ConversationChannel.MESSENGER)
                    .setIdentity("7968425018576406")
                    .setAppId(AppsSteps.APP_ID)
                    .build())
            .setBody(
                AppMessage.builder()
                    .setBody(TextMessage.builder().setText("Injected text message").build())
                    .build())
            .setDirection(ConversationDirection.TO_CONTACT)
            .setAcceptTime(Instant.now())
            .build();
    service.injectMessage(CONVERSATION_ID, request);
    injectMessagePassed = true;
  }

  @When("^I send a request to stop a conversation$")
  public void stopConversation() {
    service.stopActive(CONVERSATION_ID);
    stopConversationPassed = true;
  }

  @Then("the conversation is created")
  public void createResult() {
    Assertions.assertEquals(createResponse.getId(), CONVERSATION_ID);
  }

  @Then("the response contains \"{int}\" conversations")
  public void listPageResult(int size) {

    Assertions.assertEquals(listPageResponse.getContent().size(), size);
  }

  @Then("the conversations list contains \"{int}\" conversations")
  public void listAllResult(int size) {

    // FIXME: to be thread-safe compliant we need to check which variables are set
    Iterator<?> iterator = null;
    if (null != listAllResponse) {
      iterator = listAllResponse.iterator();
    }

    if (null != listPageIterateResponse) {
      iterator = listPageIterateResponse.iterator();
    }
    TestHelpers.checkIteratorItems(iterator, size);
  }

  @Then("the conversations iteration result contains the data from \"{int}\" pages")
  public void listPageIterateResult(int size) {

    int pageCount = 0;

    ConversationsListResponse listPageIterateResponseThreadSafety = listPageIterateResponse;
    do {
      pageCount++;
      if (!listPageIterateResponseThreadSafety.hasNextPage()) {
        break;
      }
      listPageIterateResponseThreadSafety = listPageIterateResponseThreadSafety.nextPage();

    } while (true);

    Assertions.assertEquals(pageCount, size);
  }

  @Then("the response contains \"{int}\" recent conversations")
  public void listRecentPageResult(int size) {

    Assertions.assertEquals(listRecentPageResponse.getContent().size(), size);
  }

  @Then("the recent conversations list contains \"{int}\" recent conversations")
  public void listRecentAllResult(int size) {

    Iterator<?> iterator = null;
    if (null != listRecentAllResponse) {
      iterator = listRecentAllResponse.iterator();
    }

    if (null != listRecentPageIterateResponse) {
      iterator = listRecentPageIterateResponse.iterator();
    }
    TestHelpers.checkIteratorItems(iterator, size);
  }

  @Then("the recent conversations iteration result contains the data from \"{int}\" pages")
  public void listRecentPageIterateResult(int size) {

    int pageCount = 0;

    RecentConversationsListResponse listPageIterateResponseThreadSafety =
        listRecentPageIterateResponse;
    do {
      pageCount++;
      if (!listPageIterateResponseThreadSafety.hasNextPage()) {
        break;
      }
      listPageIterateResponseThreadSafety = listPageIterateResponseThreadSafety.nextPage();

    } while (true);

    Assertions.assertEquals(pageCount, size);
  }

  @Then("the response contains the conversation details")
  public void getResult() {
    checkExpectedResponseCommonFields(getResponse);
  }

  @Then("the response contains the conversation details with updated data")
  public void updateResult() {

    Assertions.assertEquals(updateResponse.getId(), CONVERSATION_ID);
    Assertions.assertEquals(updateResponse.getAppId(), "01W4FFL35P4NC4K35CONVAPP002");
    Assertions.assertEquals(updateResponse.getContactId(), ContactsSteps.CONTACT_ID);
    Assertions.assertEquals(updateResponse.getMetadata(), "Transferred conversation");
    Assertions.assertEquals(updateResponse.getCorrelationId(), "my-correlator");
  }

  @Then("the delete conversation response contains no data")
  public void deleteResult() {

    Assertions.assertTrue(deletePassed);
  }

  @Then("the event is created and injected in the conversation")
  public void injectEventResult() {

    Assertions.assertEquals(injectEventResponse.getEventId(), "01W4FFL35P4NC4K35CONVEVENT1");
    Assertions.assertEquals(
        injectEventResponse.getAcceptedTime(), Instant.parse("2024-06-06T15:15:15.000Z"));
  }

  @Then("the message is created and injected in the conversation")
  public void injectMessageResult() {

    Assertions.assertTrue(injectMessagePassed);
  }

  @Then("the stop conversation response contains no data")
  public void stopConversationResult() {

    Assertions.assertTrue(stopConversationPassed);
  }

  void checkExpectedResponseCommonFields(Conversation contactResponse) {
    Assertions.assertEquals(contactResponse.getId(), CONVERSATION_ID);
    Assertions.assertEquals(contactResponse.getAppId(), AppsSteps.APP_ID);
    Assertions.assertEquals(contactResponse.getContactId(), "01W4FFL35P4NC4K35CONTACT002");
    Assertions.assertEquals(
        contactResponse.getLastReceived(), Instant.parse("2024-06-06T14:42:42Z"));
    Assertions.assertEquals(contactResponse.getActiveChannel(), ConversationChannel.MESSENGER);
    Assertions.assertEquals(contactResponse.getActive(), true);
    Assertions.assertEquals(contactResponse.getMetadata(), "e2e tests");
    Assertions.assertEquals(
        contactResponse.getMetadataJson(),
        Stream.of(
                new AbstractMap.SimpleEntry<>("prop1", "value1"),
                new AbstractMap.SimpleEntry<>("prop2", "value2"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    Assertions.assertEquals(contactResponse.getCorrelationId(), "");
  }
}
