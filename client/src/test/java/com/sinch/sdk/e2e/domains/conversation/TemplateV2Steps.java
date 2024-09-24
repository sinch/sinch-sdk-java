package com.sinch.sdk.e2e.domains.conversation;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.templates.v2.TemplatesServiceV2;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceItem;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.list.ListAdditionalProperties;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.list.ListMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.list.ListSection;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import com.sinch.sdk.domains.conversation.templates.models.TemplateVariable;
import com.sinch.sdk.domains.conversation.templates.models.v2.TemplateTranslation;
import com.sinch.sdk.domains.conversation.templates.models.v2.TemplateV2;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Assertions;

public class TemplateV2Steps {

  static final String TEMPLATE_V2_ID = "01HVN010MG3B9N6X323JAFN59P";

  TemplatesServiceV2 service;
  TemplateV2 createResponse;
  Collection<TemplateV2> listResponse;
  Collection<TemplateTranslation> listTranslationsResponse;
  TemplateV2 getResponse;
  TemplateV2 updateResponse;
  boolean deletePassed;

  TemplateTranslation enTranslation =
      TemplateTranslation.builder()
          .setCreateTime(Instant.parse("2024-06-06T14:42:42Z"))
          .setUpdateTime(Instant.parse("2024-06-06T14:42:42Z"))
          .setLanguageCode("en-US")
          .setVersion("3")
          .setMessage(
              TextMessage.builder()
                  .setText("Hello ${name}. Text message template created with V2 API")
                  .build())
          .setVariables(
              new ArrayList<>(
                  Arrays.asList(
                      TemplateVariable.builder()
                          .setKey("name")
                          .setPreviewValue("Professor Jones")
                          .build())))
          .setChannelTemplateOverrides(new LinkedHashMap<>())
          .build();

  TemplateV2 expectedCreateResult =
      TemplateV2.builder()
          .setId(TEMPLATE_V2_ID)
          .setCreateTime(Instant.parse("2024-06-06T14:42:42Z"))
          .setUpdateTime(Instant.parse("2024-06-06T14:42:42Z"))
          .setDescription("Text template V2")
          .setDefaultTranslation("en-US")
          .setVersion(1)
          .setTranslations(new ArrayList<>(Arrays.asList(enTranslation)))
          .build();

  TemplateV2 expectedGetResult =
      TemplateV2.builder()
          .setId(expectedCreateResult.getId())
          .setDescription(expectedCreateResult.getDescription())
          .setVersion(expectedCreateResult.getVersion())
          .setTranslations(
              Arrays.asList(
                  enTranslation,
                  TemplateTranslation.builder()
                      .setVersion("latest")
                      .setLanguageCode(enTranslation.getLanguageCode())
                      .setCreateTime(enTranslation.getCreateTime())
                      .setUpdateTime(enTranslation.getUpdateTime())
                      .setVariables(enTranslation.getVariables())
                      .setChannelTemplateOverrides(enTranslation.getChannelTemplateOverrides())
                      .setMessage(enTranslation.getMessage())
                      .build()))
          .setDefaultTranslation(expectedCreateResult.getDefaultTranslation())
          .setCreateTime(expectedCreateResult.getCreateTime())
          .setUpdateTime(expectedCreateResult.getUpdateTime())
          .build();

  @Given("^the Conversation service \"TemplatesV2\" is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().conversation().templates().v2();
  }

  @When("^I send a request to create a conversation template with the V2 API$")
  public void create() {

    TemplateV2 request =
        TemplateV2.builder()
            .setId(TEMPLATE_V2_ID)
            .setDefaultTranslation(enTranslation.getLanguageCode())
            .setDescription("Text template V2")
            .setTranslations(
                Arrays.asList(
                    TemplateTranslation.builder()
                        .setLanguageCode(enTranslation.getLanguageCode())
                        .setVersion(enTranslation.getVersion())
                        .setMessage(enTranslation.getMessage())
                        .setVariables(enTranslation.getVariables())
                        .build()))
            .build();

    createResponse = service.create(request);
  }

  @When("^I send a request to list the conversation templates with the V2 API$")
  public void list() {

    listResponse = service.list();
  }

  @When("^I send a request to list the translations for a template with the V2 API$")
  public void listTranslations() {

    listTranslationsResponse = service.listTranslations(TEMPLATE_V2_ID, null);
  }

  @When("^I send a request to retrieve a conversation template with the V2 API$")
  public void get() {

    getResponse = service.get(TEMPLATE_V2_ID);
  }

  @When("^I send a request to update a conversation template with the V2 API$")
  public void update() {

    TemplateV2 request =
        TemplateV2.builder()
            .setDescription("Updated description v2")
            .setVersion(1)
            .setDefaultTranslation("en-US")
            .setTranslations(
                Arrays.asList(
                    TemplateTranslation.builder()
                        .setLanguageCode("en-US")
                        .setVersion("1")
                        .setMessage(
                            ListMessage.builder()
                                .setTitle("Choose your icecream flavor")
                                .setDescription("The best icecream in town!")
                                .setSections(
                                    Arrays.asList(
                                        ListSection.<ChoiceItem>builder()
                                            .setTitle("Fruit flavors")
                                            .setItems(
                                                Arrays.asList(
                                                    ChoiceItem.builder()
                                                        .setTitle("Strawberry")
                                                        .setPostbackData("Strawberry postback")
                                                        .build(),
                                                    ChoiceItem.builder()
                                                        .setTitle("Blueberry")
                                                        .setPostbackData("Blueberry postback")
                                                        .build()))
                                            .build(),
                                        ListSection.<ChoiceItem>builder()
                                            .setTitle("Other flavors")
                                            .setItems(
                                                Arrays.asList(
                                                    ChoiceItem.builder()
                                                        .setTitle("Chocolate")
                                                        .setPostbackData("Chocolate postback")
                                                        .build(),
                                                    ChoiceItem.builder()
                                                        .setTitle("Vanilla")
                                                        .setPostbackData("Vanilla postback")
                                                        .build()))
                                            .build()))
                                .build())
                        .build()))
            .build();

    updateResponse = service.update(TEMPLATE_V2_ID, request);
  }

  @When("^I send a request to delete a conversation template with the V2 API$")
  public void delete() {

    service.delete(TEMPLATE_V2_ID);
    deletePassed = true;
  }

  @Then("the conversation template V2 is created")
  public void createResult() {

    TestHelpers.recursiveEquals(createResponse, expectedCreateResult);
  }

  @Then("the response contains the list of conversation templates with the V2 structure")
  public void listResult() {

    Assertions.assertEquals(listResponse.size(), 2);
    TestHelpers.recursiveEquals(
        expectedGetResult,
        listResponse.stream()
            .filter(f -> TEMPLATE_V2_ID.equals(f.getId()))
            .findFirst()
            .orElse(null));

    Assertions.assertNotNull(
        listResponse.stream()
            .filter(f -> "01W4FFL35P4NC4K35TEMPLATEV2".equals(f.getId()))
            .findFirst()
            .orElse(null));
  }

  @Then(
      "for each templateV2 in the templateV2 list response, it defines a translation with version"
          + " {string} on top of each current translation version")
  public void listResultLatest(String versionValue) {

    listResponse.forEach(
        template -> {
          AtomicInteger searchedValueCount = new AtomicInteger();
          AtomicInteger otherVersionCount = new AtomicInteger();
          template
              .getTranslations()
              .forEach(
                  translation -> {
                    if (translation.getVersion().equals(versionValue)) {
                      searchedValueCount.getAndIncrement();
                    } else {
                      otherVersionCount.getAndIncrement();
                    }
                  });
          Assertions.assertEquals(searchedValueCount.get(), otherVersionCount.get());
        });
  }

  @Then("the response contains the list of translations for a template with the V2 structure")
  public void listTranslationsResult() {

    Assertions.assertEquals(listTranslationsResponse.size(), 2);
    Assertions.assertEquals(
        listTranslationsResponse.stream().filter(f -> f.getVersion().equals("latest")).count(), 0);
  }

  @Then("the response contains the conversation template details with the V2 structure")
  public void getResult() {

    TestHelpers.recursiveEquals(getResponse, expectedGetResult);
  }

  @Then(
      "the response contains the conversation template details with updated data with the V2"
          + " structure")
  public void updateResult() {

    TemplateV2 expected =
        TemplateV2.builder()
            .setId(TEMPLATE_V2_ID)
            .setDescription("Updated description v2")
            .setVersion(2)
            .setDefaultTranslation("en-US")
            .setCreateTime(Instant.parse("2024-06-06T14:42:42Z"))
            .setUpdateTime(Instant.parse("2024-06-06T15:45:45Z"))
            .setTranslations(
                Arrays.asList(
                    TemplateTranslation.builder()
                        .setLanguageCode("en-US")
                        .setVersion("1")
                        .setCreateTime(Instant.parse("2024-06-06T15:45:45Z"))
                        .setUpdateTime(Instant.parse("2024-06-06T15:45:45Z"))
                        .setVariables(Collections.emptyList())
                        .setChannelTemplateOverrides(Collections.EMPTY_MAP)
                        .setMessage(
                            ListMessage.builder()
                                .setTitle("Choose your icecream flavor")
                                .setDescription("The best icecream in town!")
                                .setMessageProperties(ListAdditionalProperties.builder().build())
                                .setSections(
                                    Arrays.asList(
                                        ListSection.<ChoiceItem>builder()
                                            .setTitle("Fruit flavors")
                                            .setItems(
                                                Arrays.asList(
                                                    ChoiceItem.builder()
                                                        .setTitle("Strawberry")
                                                        .setPostbackData("Strawberry postback")
                                                        .setDescription("")
                                                        .setMedia(null)
                                                        .build(),
                                                    ChoiceItem.builder()
                                                        .setTitle("Blueberry")
                                                        .setPostbackData("Blueberry postback")
                                                        .setDescription("")
                                                        .setMedia(null)
                                                        .build()))
                                            .build(),
                                        ListSection.<ChoiceItem>builder()
                                            .setTitle("Other flavors")
                                            .setItems(
                                                Arrays.asList(
                                                    ChoiceItem.builder()
                                                        .setTitle("Chocolate")
                                                        .setPostbackData("Chocolate postback")
                                                        .setDescription("")
                                                        .setMedia(null)
                                                        .build(),
                                                    ChoiceItem.builder()
                                                        .setTitle("Vanilla")
                                                        .setPostbackData("Vanilla postback")
                                                        .setDescription("")
                                                        .setMedia(null)
                                                        .build()))
                                            .build()))
                                .build())
                        .build()))
            .build();
    TestHelpers.recursiveEquals(updateResponse, expected);
  }

  @Then("the delete conversation template response V2 contains no data")
  public void deleteResult() {

    Assertions.assertTrue(deletePassed);
  }
}
