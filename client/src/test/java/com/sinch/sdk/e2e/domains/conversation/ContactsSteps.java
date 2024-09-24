package com.sinch.sdk.e2e.domains.conversation;

import com.sinch.sdk.domains.conversation.api.v1.ContactService;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.contact.Contact;
import com.sinch.sdk.domains.conversation.models.v1.contact.ContactLanguage;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.ContactCreateRequest;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.ContactGetChannelProfileByContactIdRequest;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.ContactListRequest;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.GetChannelProfileConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.contact.response.ContactListResponse;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public class ContactsSteps {

  static final String CONTACT_ID = "01W4FFL35P4NC4K35CONTACT001";

  ContactService service;
  Contact createResponse;
  ContactListResponse listPageResponse;
  ContactListResponse listAllResponse;
  ContactListResponse listPageIterateResponse;
  Contact getResponse;
  Contact updateResponse;
  Contact mergeResponse;
  boolean deletePassed;
  String channelProfileByContactIdResponse;

  @Given("^the Conversation service \"Contacts\" is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().conversation().v1().contact();
  }

  @When("^I send a request to create a contact$")
  public void create() {

    ContactCreateRequest request =
        ContactCreateRequest.builder()
            .setChannelIdentities(
                Arrays.asList(
                    ChannelIdentity.builder()
                        .setChannel(ConversationChannel.SMS)
                        .setIdentity("+12015555555")
                        .build()))
            .setLanguage(ContactLanguage.EN_US)
            .setDisplayName("Marty McFly")
            .setEmail("time.traveler@delorean.com")
            .build();

    createResponse = service.create(request);
  }

  @When("^I send a request to list the existing contacts$")
  public void listPage() {

    ContactListRequest request = ContactListRequest.builder().setPageSize(2).build();
    listPageResponse = service.list(request);
  }

  @When("^I send a request to list all the contacts$")
  public void listAll() {

    ContactListRequest request = ContactListRequest.builder().setPageSize(2).build();
    listAllResponse = service.list(request);
  }

  @When("^I iterate manually over the contacts pages$")
  public void listPageIterate() {

    ContactListRequest request = ContactListRequest.builder().setPageSize(2).build();
    listPageIterateResponse = service.list(request);
  }

  @When("^I send a request to retrieve a contact$")
  public void get() {

    getResponse = service.get(CONTACT_ID);
  }

  @When("^I send a request to update a contact$")
  public void update() {

    Contact request =
        Contact.builder()
            .setChannelIdentities(
                Arrays.asList(
                    ChannelIdentity.builder()
                        .setChannel(ConversationChannel.from("MESSENGER"))
                        .setIdentity("7968425018576406")
                        .setAppId(AppsSteps.APP_ID)
                        .build(),
                    ChannelIdentity.builder()
                        .setChannel(ConversationChannel.SMS)
                        .setIdentity("12015555555")
                        .build()))
            .setChannelPriority(Arrays.asList(ConversationChannel.MESSENGER))
            .build();
    updateResponse = service.update(CONTACT_ID, request);
  }

  @When("^I send a request to delete a contact$")
  public void delete() {

    service.delete(CONTACT_ID);
    deletePassed = true;
  }

  @When("^I send a request to merge a source contact to a destination contact$")
  public void merge() {

    mergeResponse = service.mergeContact("destinationId", CONTACT_ID);
  }

  @When("^I send a request to get the channel profile of a contact ID$")
  public void channelProfileByContactId() {

    channelProfileByContactIdResponse =
        service.getChannelProfileByContactId(
            ContactGetChannelProfileByContactIdRequest.builder()
                .setChannel(GetChannelProfileConversationChannel.MESSENGER)
                .setAppId(AppsSteps.APP_ID)
                .setContactId(CONTACT_ID)
                .build());
  }

  @Then("the contact is created")
  public void createResult() {
    Assertions.assertEquals(createResponse.getId(), CONTACT_ID);
  }

  @Then("the response contains \"{int}\" contacts")
  public void listExistingResult(int size) {

    Assertions.assertEquals(listPageResponse.getContent().size(), size);
  }

  @Then("the contacts list contains \"{int}\" contacts")
  public void listAllResult(int size) {

    // FIXME: to be thread-safe compliant we need to check which variables are set
    if (null != listAllResponse) Assertions.assertEquals(listAllResponse.stream().count(), size);
    if (null != listPageIterateResponse)
      Assertions.assertEquals(listPageIterateResponse.stream().count(), size);
  }

  @Then("the contacts iteration result contains the data from \"{int}\" pages")
  public void listPageIterateResult(int size) {

    int pageCount = 0;

    ContactListResponse listPageIterateResponseThreadSafety = listPageIterateResponse;
    do {
      pageCount++;
      if (!listPageIterateResponseThreadSafety.hasNextPage()) {
        break;
      }
      listPageIterateResponseThreadSafety = listPageIterateResponseThreadSafety.nextPage();

    } while (true);

    Assertions.assertEquals(pageCount, size);
  }

  @Then("the response contains the contact details")
  public void getResult() {
    checkExpectedContactResponseCommonFields(getResponse);
    Assertions.assertEquals(getResponse.getId(), CONTACT_ID);
    Assertions.assertEquals(getResponse.getEmail(), "time.traveler@delorean.com");
    Assertions.assertEquals(
        getResponse.getChannelIdentities(),
        Arrays.asList(
            ChannelIdentity.builder()
                .setChannel(ConversationChannel.SMS)
                .setIdentity("12015555555")
                .setAppId("")
                .build()));
    Assertions.assertEquals(getResponse.getChannelPriority().size(), 0);
  }

  @Then("the response contains the contact details with updated data")
  public void updateResult() {
    checkExpectedContactResponseCommonFields(updateResponse);
    Assertions.assertEquals(updateResponse.getId(), CONTACT_ID);
    Assertions.assertEquals(updateResponse.getEmail(), "time.traveler@delorean.com");
    Assertions.assertEquals(
        updateResponse.getChannelIdentities(),
        Arrays.asList(
            ChannelIdentity.builder()
                .setChannel(ConversationChannel.MESSENGER)
                .setIdentity("7968425018576406")
                .setAppId("01W4FFL35P4NC4K35CONVAPP001")
                .build(),
            ChannelIdentity.builder()
                .setChannel(ConversationChannel.SMS)
                .setIdentity("12015555555")
                .setAppId("")
                .build()));
    Assertions.assertEquals(
        updateResponse.getChannelPriority(), Arrays.asList(ConversationChannel.MESSENGER));
  }

  @Then("the delete contact response contains no data")
  public void deleteResult() {

    Assertions.assertTrue(deletePassed);
  }

  @Then("the response contains data from the destination contact and from the source contact")
  public void mergeResult() {

    checkExpectedContactResponseCommonFields(mergeResponse);
    Assertions.assertEquals(mergeResponse.getId(), "01W4FFL35P4NC4K35CONTACT002");
    Assertions.assertEquals(mergeResponse.getChannelIdentities().size(), 3);
    Assertions.assertEquals(mergeResponse.getChannelPriority().size(), 2);
    Assertions.assertEquals(mergeResponse.getEmail(), "pikachu@poke.mon");
  }

  @Then("the response contains the profile of the contact on the requested channel")
  public void channelProfileByContactIdResult() {
    Assertions.assertEquals(channelProfileByContactIdResponse, "Marty McFly FB");
  }

  void checkExpectedContactResponseCommonFields(Contact contactResponse) {
    Assertions.assertEquals(contactResponse.getLanguage(), ContactLanguage.EN_US);
  }
}
