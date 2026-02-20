package com.sinch.sdk.e2e.domains.conversation;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.MessagesService;
import com.sinch.sdk.domains.conversation.models.v1.ContactId;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ConversationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.MessageUpdateRequest;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.MessagesListQueryParameters;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.SendMessageRequest;
import com.sinch.sdk.domains.conversation.models.v1.messages.response.MessagesListResponse;
import com.sinch.sdk.domains.conversation.models.v1.messages.response.SendMessageResponse;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Instant;
import java.util.Iterator;
import org.junit.jupiter.api.Assertions;

public class MessagesSteps {

  static final String MESSAGE_ID = "01W4FFL35P4NC4K35MESSAGE001";

  MessagesService service;
  SendMessageResponse sendResponse;
  MessagesListResponse listPageResponse;
  MessagesListResponse listAllResponse;
  MessagesListResponse listPageIterateResponse;
  ConversationMessage getResponse;
  ConversationMessage updateResponse;
  boolean deletePassed;

  @Given("^the Conversation service \"Messages\" is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().conversation().v1().messages();
  }

  @When("^I send a request to send a message to a contact$")
  public void send() {

    SendMessageRequest<?> request =
        SendMessageRequest.builder()
            .setAppId(AppsSteps.APP_ID)
            .setRecipient(ContactId.builder().setContactId(ContactsSteps.CONTACT_ID).build())
            .setMessage(
                AppMessage.builder()
                    .setBody(TextMessage.builder().setText("Hello").build())
                    .build())
            .build();

    sendResponse = service.sendMessage(request);
  }

  @When("^I send a request to list the existing messages$")
  public void listPage() {

    MessagesListQueryParameters request =
        MessagesListQueryParameters.builder().setPageSize(2).build();
    listPageResponse = service.list(request);
  }

  @When("^I send a request to list all the messages$")
  public void listAll() {

    MessagesListQueryParameters request =
        MessagesListQueryParameters.builder().setPageSize(2).build();
    listAllResponse = service.list(request);
  }

  @When("^I iterate manually over the messages pages$")
  public void listPageIterate() {

    MessagesListQueryParameters request =
        MessagesListQueryParameters.builder().setPageSize(2).build();
    listPageIterateResponse = service.list(request);
  }

  @When("^I send a request to retrieve a message$")
  public void get() {

    getResponse = service.get(MESSAGE_ID);
  }

  @When("^I send a request to update a message$")
  public void update() {

    MessageUpdateRequest request =
        MessageUpdateRequest.builder().setMetadata("Updated metadata").build();
    updateResponse = service.update(MESSAGE_ID, request);
  }

  @When("^I send a request to delete a message$")
  public void delete() {

    service.delete(MESSAGE_ID);
    deletePassed = true;
  }

  @When("^I send a request to list the last messages sent to specified channel identities$")
  public void listLastMessagesByChannelIdentity() {

    // TODO: DEVEXP-1278
  }

  @When("^I send a request to list all the last messages sent to specified channel identities$")
  public void listAllLastMessagesByChannelIdentity() {

    // TODO: DEVEXP-1278
  }

  @When("^I iterate manually over the last messages sent to specified channel identities pages$")
  public void listLastMessagesByChannelIdentityPageIterator() {

    // TODO: DEVEXP-1278
  }

  @Then("the response contains the id of the message")
  public void sendResult() {

    Assertions.assertEquals(sendResponse.getMessageId(), MESSAGE_ID);
    Assertions.assertEquals(
        sendResponse.getAcceptedTime(), Instant.parse("2024-06-06T12:42:42.528Z"));
  }

  @Then("the response contains \"{int}\" messages")
  public void listPageResult(int size) {

    Assertions.assertEquals(listPageResponse.getContent().size(), size);
  }

  @Then("the messages list contains \"{int}\" messages")
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

  @Then("the result contains the data from \"{int}\" pages")
  public void listPageIterateResult(int size) {

    int pageCount = 0;

    MessagesListResponse listPageIterateResponseThreadSafety = listPageIterateResponse;
    do {
      pageCount++;
      if (!listPageIterateResponseThreadSafety.hasNextPage()) {
        break;
      }
      listPageIterateResponseThreadSafety = listPageIterateResponseThreadSafety.nextPage();

    } while (true);

    Assertions.assertEquals(pageCount, size);
  }

  @Then("the response contains the message details")
  public void getResult() {

    Assertions.assertEquals(getResponse.getId(), MESSAGE_ID);
  }

  @Then("the response contains the message details with updated metadata")
  public void updateResult() {

    Assertions.assertEquals(updateResponse.getId(), MESSAGE_ID);
    Assertions.assertEquals(updateResponse.getMetadata(), "Updated metadata");
  }

  @Then("the delete message response contains no data")
  public void deleteResult() {

    Assertions.assertTrue(deletePassed);
  }

  @Then("the response contains \"{int}\" last messages sent to specified channel identities")
  public void listLastMessagesByChannelIdentity(int size) {

    // TODO: DEVEXP-1278
  }

  @Then("the response list contains \"{int}\" last messages sent to specified channel identities")
  public void listAllLastMessagesByChannelIdentity(int size) {

    // TODO: DEVEXP-1278
  }

  @Then(
      "the result contains the data from \"{int}\" pages of last messages sent to specified channel"
          + " identities")
  public void listAllLastMessagesByChannelIdentityPageIterator(int size) {

    // TODO: DEVEXP-1278
  }
}
