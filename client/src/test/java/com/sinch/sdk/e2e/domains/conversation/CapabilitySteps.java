package com.sinch.sdk.e2e.domains.conversation;

import com.sinch.sdk.domains.conversation.api.v1.CapabilityService;
import com.sinch.sdk.domains.conversation.models.v1.ContactId;
import com.sinch.sdk.domains.conversation.models.v1.Recipient;
import com.sinch.sdk.domains.conversation.models.v1.capability.request.QueryCapabilityRequest;
import com.sinch.sdk.domains.conversation.models.v1.capability.response.QueryCapabilityResponse;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CapabilitySteps {

  CapabilityService service;
  QueryCapabilityResponse lookupResponse;

  @Given("^the Conversation service \"Capability\" is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().conversation().v1().capability();
  }

  @When("^I send a request to query a capability lookup$")
  public void lookup() {

    QueryCapabilityRequest request =
        QueryCapabilityRequest.builder()
            .setAppId(AppsSteps.APP_ID)
            .setRecipient(ContactId.builder().setContactId(ContactsSteps.CONTACT_ID).build())
            .build();

    lookupResponse = service.lookup(request);
  }

  @Then("the response contains the id of the capability lookup query")
  public void lookupResult() {

    Assertions.assertEquals(lookupResponse.getAppId(), AppsSteps.APP_ID);
    Recipient recipient = lookupResponse.getRecipient();
    Assertions.assertInstanceOf(ContactId.class, recipient);
    Assertions.assertEquals(((ContactId) recipient).getContactId(), ContactsSteps.CONTACT_ID);
    Assertions.assertEquals(lookupResponse.getRequestId(), "01W4FFL35P4NC4K35CAPABILITY");
  }
}
