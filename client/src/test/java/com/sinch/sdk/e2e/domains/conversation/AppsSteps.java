package com.sinch.sdk.e2e.domains.conversation;

import com.sinch.sdk.domains.conversation.api.v1.AppService;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.app.ConversationMetadataReportView;
import com.sinch.sdk.domains.conversation.models.v1.app.request.AppCreateRequest;
import com.sinch.sdk.domains.conversation.models.v1.app.request.AppUpdateRequest;
import com.sinch.sdk.domains.conversation.models.v1.app.response.AppResponse;
import com.sinch.sdk.domains.conversation.models.v1.credentials.ChannelIntegrationStatus;
import com.sinch.sdk.domains.conversation.models.v1.credentials.ConversationChannelCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.ConversationChannelCredentialsBuilderFactory;
import com.sinch.sdk.domains.conversation.models.v1.credentials.StaticBearerCredentials;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.api.Assertions;

public class AppsSteps {

  static final String APP_ID = "01W4FFL35P4NC4K35CONVAPP001";

  AppService service;
  AppResponse createResponse;
  Collection<AppResponse> listResponse;
  AppResponse getResponse;
  AppResponse updateResponse;
  boolean deletePassed;

  @Given("^the Conversation service \"Apps\" is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().conversation().v1().app();
  }

  @When("^I send a request to create an app$")
  public void create() {

    String identity = "SpaceMonkeySquadron";
    String token = "00112233445566778899aabbccddeeff";
    String displayName = "E2E Conversation App";

    ConversationChannelCredentials credentials =
        ConversationChannelCredentialsBuilderFactory.sms(
                StaticBearerCredentials.builder()
                    .setClaimedIdentity(identity)
                    .setToken(token)
                    .build())
            .build();

    AppCreateRequest request =
        AppCreateRequest.builder()
            .setChannelCredentials(Arrays.asList(credentials))
            .setDisplayName(displayName)
            .build();

    createResponse = service.create(request);
  }

  @When("^I send a request to list all the apps$")
  public void list() {

    listResponse = service.list();
  }

  @When("^I send a request to retrieve an app$")
  public void get() {

    getResponse = service.get(APP_ID);
  }

  @When("^I send a request to update an app$")
  public void update() {

    AppUpdateRequest request =
        AppUpdateRequest.builder().setDisplayName(" a new display name").build();
    updateResponse = service.update(APP_ID, request);
  }

  @When("^I send a request to delete an app$")
  public void delete() {

    service.delete(APP_ID);
    deletePassed = true;
  }

  @Then("the conversation app is created")
  public void createResult() {
    checkExpectedAppResponseCommonFields(createResponse);
    Assertions.assertEquals(
        createResponse.getChannelCredentials().get(0).getState().getStatus(),
        ChannelIntegrationStatus.PENDING);
  }

  @Then("the apps list contains {int} apps")
  public void listResult(int size) {

    Assertions.assertEquals(listResponse.size(), size);
    AppResponse item = listResponse.stream().findFirst().orElse(null);

    checkExpectedAppResponseCommonFields(item);
    Assertions.assertEquals(item.getDisplayName(), "E2E Conversation App");
    Assertions.assertEquals(
        item.getChannelCredentials().get(0).getState().getStatus(),
        ChannelIntegrationStatus.ACTIVE);
    item = listResponse.stream().reduce((first, second) -> second).orElse(null);
    Assertions.assertEquals(item.getId(), "01W4FFL35P4NC4K35CONVAPP002");
  }

  @Then("the response contains the app details")
  public void getResult() {
    checkExpectedAppResponseCommonFields(getResponse);
    Assertions.assertEquals(getResponse.getDisplayName(), "E2E Conversation App");
    Assertions.assertEquals(
        getResponse.getChannelCredentials().get(0).getState().getStatus(),
        ChannelIntegrationStatus.ACTIVE);
  }

  @Then("the response contains the app details with updated properties")
  public void updateResult() {
    checkExpectedAppResponseCommonFields(updateResponse);
    Assertions.assertEquals(updateResponse.getDisplayName(), "Updated name");
    Assertions.assertEquals(
        updateResponse.getChannelCredentials().get(0).getState().getStatus(),
        ChannelIntegrationStatus.ACTIVE);
  }

  @Then("the delete app response contains no data")
  public void deleteResult() {

    Assertions.assertTrue(deletePassed);
  }

  void checkExpectedAppResponseCommonFields(AppResponse appResponse) {
    Assertions.assertEquals(appResponse.getId(), "01W4FFL35P4NC4K35CONVAPP001");
    Assertions.assertEquals(appResponse.getChannelCredentials().size(), 1);
    Assertions.assertEquals(
        appResponse.getConversationMetadataReportView(), ConversationMetadataReportView.NONE);
    Assertions.assertEquals(appResponse.getProcessingMode(), ProcessingMode.CONVERSATION);
  }
}
