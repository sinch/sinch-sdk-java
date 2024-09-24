package com.sinch.sdk.e2e.domains.conversation;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.templates.v1.TemplatesServiceV1;
import com.sinch.sdk.domains.conversation.templates.models.TemplateVariable;
import com.sinch.sdk.domains.conversation.templates.models.v1.TemplateChannel;
import com.sinch.sdk.domains.conversation.templates.models.v1.TemplateTranslation;
import com.sinch.sdk.domains.conversation.templates.models.v1.TemplateV1;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;

public class TemplateV1Steps {

  static final String TEMPLATE_V1_ID = "01W4FFL35P4NC4K35TEMPLATE01";

  TemplatesServiceV1 service;
  TemplateV1 createResponse;
  Collection<TemplateV1> listResponse;
  TemplateV1 getResponse;
  TemplateV1 updateResponse;
  boolean deletePassed;

  TemplateTranslation frTranslation =
      TemplateTranslation.builder()
          .setCreateTime(Instant.parse("2024-06-06T14:45:45Z"))
          .setUpdateTime(Instant.parse("2024-06-06T14:45:45Z"))
          .setLanguageCode("fr-FR")
          .setVersion("1")
          .setContent(
              "{\"text_message\":{\"text\":\"Bonjour ${name}. Ce message texte provient d'un"
                  + " template V1\"}}")
          .setVariables(
              Arrays.asList(
                  TemplateVariable.builder()
                      .setKey("name")
                      .setPreviewValue("Professeur Jones")
                      .build()))
          .build();

  TemplateTranslation enTranslation =
      TemplateTranslation.builder()
          .setCreateTime(Instant.parse("2024-06-06T14:45:45Z"))
          .setUpdateTime(Instant.parse("2024-06-06T14:45:45Z"))
          .setLanguageCode("en-US")
          .setVersion("1")
          .setContent(
              "{\"text_message\":{\"text\":\"Hello ${name}. Text message template created with V1"
                  + " API\"}}")
          .setVariables(
              Arrays.asList(
                  TemplateVariable.builder()
                      .setKey("name")
                      .setPreviewValue("Professor Jones")
                      .build()))
          .build();

  TemplateV1 expectedCreateGetResult =
      TemplateV1.builder()
          .setId(TEMPLATE_V1_ID)
          .setCreateTime(Instant.parse("2024-06-06T14:42:42Z"))
          .setUpdateTime(Instant.parse("2024-06-06T14:42:42Z"))
          .setDescription("Text template V1")
          .setChannel(TemplateChannel.UNSPECIFIED)
          .setDefaultTranslation("en-US")
          .setTranslations(
              Arrays.asList(
                  TemplateTranslation.builder()
                      .setCreateTime(Instant.parse("2024-06-06T14:42:42Z"))
                      .setUpdateTime(Instant.parse("2024-06-06T14:42:42Z"))
                      .setLanguageCode(enTranslation.getLanguageCode())
                      .setVersion(enTranslation.getVersion())
                      .setContent(enTranslation.getContent())
                      .setVariables(enTranslation.getVariables())
                      .build()))
          .build();

  @Given("^the Conversation service \"TemplatesV1\" is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().conversation().templates().v1();
  }

  @When("^I send a request to create a conversation template with the V1 API$")
  public void create() {

    TemplateV1 request =
        TemplateV1.builder()
            .setDefaultTranslation(enTranslation.getLanguageCode())
            .setChannel(TemplateChannel.MESSENGER)
            .setDescription("Text template V1")
            .setTranslations(Arrays.asList(enTranslation))
            .build();

    createResponse = service.create(request);
  }

  @When("^I send a request to list the conversation templates with the V1 API$")
  public void list() {

    listResponse = service.list();
  }

  @When("^I send a request to retrieve a conversation template with the V1 API$")
  public void get() {

    getResponse = service.get(TEMPLATE_V1_ID);
  }

  @When("^I send a request to update a conversation template with the V1 API$")
  public void update() {

    TemplateV1 request =
        TemplateV1.builder()
            .setDescription("Updated text template V1")
            .setChannel(TemplateChannel.SMS)
            .setDefaultTranslation("fr-FR")
            .setTranslations(
                Arrays.asList(
                    TemplateTranslation.builder()
                        .setLanguageCode(enTranslation.getLanguageCode())
                        .setVersion("2")
                        .setContent(
                            "{\"text_message\":{\"text\":\"Hello ${name}. This text message"
                                + " template has been created with V1 API\"}}")
                        .setVariables(enTranslation.getVariables())
                        .build(),
                    frTranslation))
            .build();

    updateResponse = service.update(TEMPLATE_V1_ID, request);
  }

  @When("^I send a request to delete a conversation template with the V1 API$")
  public void delete() {

    service.delete(TEMPLATE_V1_ID);
    deletePassed = true;
  }

  @Then("the conversation template V1 is created")
  public void createResult() {

    TestHelpers.recursiveEquals(createResponse, expectedCreateGetResult);
  }

  @Then("the response contains the list of conversation templates with the V1 structure")
  public void listResult() {

    Assertions.assertEquals(listResponse.size(), 2);
    TestHelpers.recursiveEquals(
        expectedCreateGetResult,
        listResponse.stream()
            .filter(f -> TEMPLATE_V1_ID.equals(f.getId()))
            .findFirst()
            .orElse(null));

    TemplateV1 expectedDoom =
        TemplateV1.builder()
            .setId("01W4FFL35P4NC4K35TEMPLATE02")
            .setDescription("Temple of Doom location")
            .setTranslations(
                Arrays.asList(
                    TemplateTranslation.builder()
                        .setLanguageCode("en-US")
                        .setContent(
                            "{\"location_message\":{\"title\":\"Temple of Doom\",\"label\":\"The"
                                + " temple may be"
                                + " here\",\"coordinates\":{\"longitude\":78.8613,\"latitude\":30.2884}}}")
                        .setVersion("4")
                        .setCreateTime(Instant.parse("2024-06-06T15:52:52Z"))
                        .setUpdateTime(Instant.parse("2024-06-06T15:52:52Z"))
                        .setVariables(Collections.emptyList())
                        .build()))
            .setDefaultTranslation("en-US")
            .setCreateTime(Instant.parse("2024-06-06T15:50:00Z"))
            .setUpdateTime(Instant.parse("2024-06-06T15:52:52Z"))
            .setChannel(TemplateChannel.UNSPECIFIED)
            .build();

    TestHelpers.recursiveEquals(
        expectedDoom,
        listResponse.stream()
            .filter(f -> expectedDoom.getId().equals(f.getId()))
            .findFirst()
            .orElse(null));
  }

  @Then("the response contains the conversation template details with the V1 structure")
  public void getResult() {

    TestHelpers.recursiveEquals(getResponse, expectedCreateGetResult);
  }

  @Then(
      "the response contains the conversation template details with updated data with the V1"
          + " structure")
  public void updateResult() {
    TemplateV1 expected =
        TemplateV1.builder()
            .setId(TEMPLATE_V1_ID)
            .setCreateTime(Instant.parse("2024-06-06T14:42:42Z"))
            .setUpdateTime(Instant.parse("2024-06-06T14:45:45Z"))
            .setDescription("Updated text template V1")
            .setChannel(TemplateChannel.UNSPECIFIED)
            .setDefaultTranslation("fr-FR")
            .setTranslations(
                Arrays.asList(
                    TemplateTranslation.builder()
                        .setCreateTime(Instant.parse("2024-06-06T14:45:45Z"))
                        .setUpdateTime(Instant.parse("2024-06-06T14:45:45Z"))
                        .setLanguageCode(frTranslation.getLanguageCode())
                        .setVersion(frTranslation.getVersion())
                        .setContent(frTranslation.getContent())
                        .setVariables(frTranslation.getVariables())
                        .build(),
                    TemplateTranslation.builder()
                        .setCreateTime(Instant.parse("2024-06-06T14:45:45Z"))
                        .setUpdateTime(Instant.parse("2024-06-06T14:45:45Z"))
                        .setLanguageCode("en-US")
                        .setVersion("2")
                        .setContent(
                            "{\"text_message\":{\"text\":\"Hello ${name}. This text message"
                                + " template has been created with V1 API\"}}")
                        .setVariables(enTranslation.getVariables())
                        .build()))
            .build();
    TestHelpers.recursiveEquals(updateResponse, expected);
  }

  @Then("the delete conversation template response V1 contains no data")
  public void deleteResult() {

    Assertions.assertTrue(deletePassed);
  }
}
