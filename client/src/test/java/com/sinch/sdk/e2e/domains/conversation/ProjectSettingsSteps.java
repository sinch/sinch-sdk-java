package com.sinch.sdk.e2e.domains.conversation;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.ProjectSettingsService;
import com.sinch.sdk.domains.conversation.models.v1.projectsettings.ContactSettings;
import com.sinch.sdk.domains.conversation.models.v1.projectsettings.ProjectSettings;
import com.sinch.sdk.domains.conversation.models.v1.projectsettings.request.ProjectSettingsRequest;
import com.sinch.sdk.domains.conversation.models.v1.projectsettings.response.ProjectSettingsResponse;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ProjectSettingsSteps {

  ProjectSettingsService service;

  ProjectSettingsResponse createResponse;
  ProjectSettingsResponse getResponse;
  ProjectSettingsResponse updateResponse;
  boolean deletePassed;

  @Given("^the Conversation service \"ProjectSettings\" is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().conversation().v1().projectSettings();
  }

  @When("^I send a request to create project settings$")
  public void create() {

    ContactSettings contactSettings =
        ContactSettings.builder().setUnifiedContactIdEnabled(false).build();

    ProjectSettingsRequest parameters =
        ProjectSettingsRequest.builder().setContactSettings(contactSettings).build();
    createResponse = service.create(parameters);
  }

  @When("^I send a request to retrieve project settings$")
  public void get() {

    getResponse = service.get();
  }

  @When("^I send a request to update project settings$")
  public void update() {

    ContactSettings contactSettings =
        ContactSettings.builder().setUnifiedContactIdEnabled(true).build();

    ProjectSettingsRequest parameters =
        ProjectSettingsRequest.builder().setContactSettings(contactSettings).build();
    updateResponse = service.update(parameters);
  }

  @When("^I send a request to delete project settings$")
  public void delete() {

    service.delete();
    deletePassed = true;
  }

  @Then("the project settings are created")
  public void createResult() {

    TestHelpers.recursiveEquals(
        createResponse,
        ProjectSettingsResponse.builder()
            .setProjectId("123coffee-dada-beef-cafe-baadc0de5678")
            .setSettings(
                ProjectSettings.builder()
                    .setContactSettings(
                        ContactSettings.builder().setUnifiedContactIdEnabled(false).build())
                    .build())
            .build());
  }

  @Then("the response contains the project settings details")
  public void getResult() {
    TestHelpers.recursiveEquals(
        getResponse,
        ProjectSettingsResponse.builder()
            .setProjectId("123coffee-dada-beef-cafe-baadc0de5678")
            .setSettings(
                ProjectSettings.builder()
                    .setContactSettings(
                        ContactSettings.builder().setUnifiedContactIdEnabled(false).build())
                    .build())
            .build());
  }

  @Then("the response contains the project settings details with updated properties")
  public void updateResult() {
    TestHelpers.recursiveEquals(
        updateResponse,
        ProjectSettingsResponse.builder()
            .setProjectId("123coffee-dada-beef-cafe-baadc0de5678")
            .setSettings(
                ProjectSettings.builder()
                    .setContactSettings(
                        ContactSettings.builder().setUnifiedContactIdEnabled(true).build())
                    .build())
            .build());
  }

  @Then("the delete project settings response contains no data")
  public void deleteResult() {
    Assertions.assertTrue(deletePassed);
  }
}
