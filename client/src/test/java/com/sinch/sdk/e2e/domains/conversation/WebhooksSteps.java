package com.sinch.sdk.e2e.domains.conversation;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.WebHooksService;
import com.sinch.sdk.domains.conversation.models.v1.contact.Contact;
import com.sinch.sdk.domains.conversation.models.v1.contact.ContactLanguage;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.ClientCredentials;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.Webhook;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.WebhookTargetType;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.WebhookTrigger;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;

public class WebhooksSteps {

  static final String WEBHOOK_ID = "01W4FFL35P4NC4K35WEBHOOK004";

  WebHooksService service;
  Webhook createResponse;
  Collection<Webhook> listResponse;
  Webhook getResponse;
  Webhook updateResponse;
  boolean deletePassed;

  @Given("^the Conversation service \"Webhooks\" is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().conversation().v1().webhooks();
  }

  @When("^I send a request to create a conversation webhook$")
  public void create() {

    Webhook request =
        Webhook.builder()
            .setAppId(AppsSteps.APP_ID)
            .setTarget("https://my-callback-server.com/capability")
            .setTriggers(Collections.singletonList(WebhookTrigger.CAPABILITY))
            .setSecret("CactusKnight_SurfsWaves")
            .setTargetType(WebhookTargetType.HTTP)
            .build();

    createResponse = service.create(request);
  }

  @When("^I send a request to list the conversation webhooks for an app$")
  public void list() {

    listResponse = service.list(AppsSteps.APP_ID);
  }

  @When("^I send a request to retrieve a conversation webhook$")
  public void get() {

    getResponse = service.get(WEBHOOK_ID);
  }

  @When("^I send a request to update a conversation webhook$")
  public void update() {

    Webhook request =
        Webhook.builder()
            .setAppId("01W4FFL35P4NC4K35CONVAPP002")
            .setTarget("https://my-callback-server.com/capability-optin-optout")
            .setTriggers(
                Arrays.asList(
                    WebhookTrigger.CAPABILITY, WebhookTrigger.OPT_IN, WebhookTrigger.OPT_OUT))
            .setSecret("SpacePanda_RidesUnicycle")
            .build();
    updateResponse = service.update(WEBHOOK_ID, request);
  }

  @When("^I send a request to delete a conversation webhook$")
  public void delete() {

    service.delete(WEBHOOK_ID);
    deletePassed = true;
  }

  @Then("the conversation webhook is created")
  public void createResult() {
    Assertions.assertEquals(createResponse.getId(), WEBHOOK_ID);
    Assertions.assertEquals(
        createResponse.getTarget(), "https://my-callback-server.com/capability");
    Assertions.assertEquals(createResponse.getSecret(), "CactusKnight_SurfsWaves");
    Assertions.assertEquals(createResponse.getTriggers().size(), 1);
    Assertions.assertEquals(createResponse.getTriggers().get(0), WebhookTrigger.CAPABILITY);
    Assertions.assertNull(createResponse.getClientCredentials());
  }

  @Then("the response contains the list of conversation webhooks")
  public void listResult() {

    Assertions.assertEquals(listResponse.size(), 4);
    Webhook entry =
        listResponse.stream()
            .filter(f -> f.getId().equals("01W4FFL35P4NC4K35WEBHOOK002"))
            .findFirst()
            .orElse(null);
    Assertions.assertEquals(
        entry.getTriggers(),
        Arrays.asList(
            WebhookTrigger.CONTACT_CREATE,
            WebhookTrigger.CONTACT_DELETE,
            WebhookTrigger.CONTACT_IDENTITIES_DUPLICATION,
            WebhookTrigger.CONTACT_MERGE,
            WebhookTrigger.CONTACT_UPDATE));
    Assertions.assertEquals(entry.getSecret(), "DiscoDragon_BuildsLego");
  }

  @Then("the response contains the conversation webhook details")
  public void getResult() {
    Webhook expected =
        Webhook.builder()
            .setId("01W4FFL35P4NC4K35WEBHOOK001")
            .setAppId(AppsSteps.APP_ID)
            .setTarget("https://my-callback-server.com/unsupported")
            .setTargetType(WebhookTargetType.HTTP)
            .setSecret("VeganVampire_SipsTea")
            .setTriggers(Collections.singletonList(WebhookTrigger.UNSUPPORTED))
            .setClientCredentials(
                ClientCredentials.builder()
                    .setEndpoint("https://my-auth-server.com/oauth2/token")
                    .setClientId("webhook-username")
                    .setClientSecret("webhook-password")
                    .build())
            .build();

    TestHelpers.recursiveEquals(getResponse, expected);
  }

  @Then("the response contains the conversation webhook details with updated data")
  public void updateResult() {

    Assertions.assertEquals(updateResponse.getId(), WEBHOOK_ID);
    Assertions.assertEquals(
        updateResponse.getTarget(), "https://my-callback-server.com/capability-optin-optout");
    Assertions.assertEquals(updateResponse.getTriggers().size(), 3);
  }

  @Then("the delete conversation webhook response contains no data")
  public void deleteResult() {

    Assertions.assertTrue(deletePassed);
  }

  void checkExpectedContactResponseCommonFields(Contact contactResponse) {
    Assertions.assertEquals(contactResponse.getLanguage(), ContactLanguage.EN_US);
  }
}
