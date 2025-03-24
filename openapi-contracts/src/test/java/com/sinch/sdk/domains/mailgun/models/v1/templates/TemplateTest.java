package com.sinch.sdk.domains.mailgun.models.v1.templates;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.mailgun.models.v1.templates.TemplateImpl.Builder;
import java.time.Instant;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class TemplateTest extends BaseTest {

  @GivenJsonResource("/domains/mailgun/v1/templates/TemplateResponseDto.json")
  Template loadedTemplateResponseDto;

  @GivenTextResource("//domains/mailgun/v1/templates/TemplateRequestDto.json")
  static String jsonTemplateRequestDto;

  @GivenJsonResource("/domains/mailgun/v1/templates/TemplateResponseWithActiveDto.json")
  Template loadedTemplateResponseWithActiveDto;

  @GivenJsonResource("/domains/mailgun/v1/templates/TemplateResponseWithVersionsDto.json")
  Template loadedTemplateResponseWithVersionsDto;

  public static Template expectedTemplate =
      Template.builder()
          .setName("template.test")
          .setDescription("my description value")
          .setCreatedAt(Instant.parse("2025-01-10T14:17:05Z"))
          .setCreatedBy("creator")
          .setId("5427eb2f-bf68-4f4e-abfb-647f9b924772")
          .build();

  public static Template expectedTemplateResponseWithActive =
      // 'version' field is hidden, so we need direct access to 'Impl'
      new TemplateImpl.Builder()
          .setName("template.test")
          .setDescription("my description value")
          .setCreatedAt(Instant.parse("2025-01-10T14:17:05Z"))
          .setCreatedBy("creator")
          .setId("5427eb2f-bf68-4f4e-abfb-647f9b924772")
          .setVersion(VersionTest.expectedVersionDetailsActive)
          .build();

  public static Template expectedTemplateResponseWithInactive =
      // 'version' field is hidden, so we need direct access to 'Impl'
      new TemplateImpl.Builder()
          .setName("template.test")
          .setDescription("my description value")
          .setCreatedAt(Instant.parse("2025-01-10T14:17:05Z"))
          .setCreatedBy("creator")
          .setId("5427eb2f-bf68-4f4e-abfb-647f9b924772")
          .setVersion(VersionTest.expectedVersionDetailsInactive)
          .build();

  public static Template expectedTemplateResponseWithVersions =
      // 'version' field is hidden, so we need direct access to 'Impl'
      new TemplateImpl.Builder()
          .setName("template.test")
          .setDescription("my description value")
          .setCreatedAt(Instant.parse("2025-01-10T14:17:05Z"))
          .setCreatedBy("creator")
          .setId("5427eb2f-bf68-4f4e-abfb-647f9b924772")
          .setVersions(Arrays.asList(VersionTest.expectedVersion))
          .build();

  public static Template expectedTemplatePage0 =
      ((Builder) Template.builder())
          .setName("my-template")
          .setDescription("my description value")
          .setCreatedAt(Instant.parse("2025-03-22T16:52:29Z"))
          .setCreatedBy("html")
          .setId("a1d695c7-4d8b-4e84-a1f9-aaaaaaaaaaaa")
          .setVersions(
              Arrays.asList(
                  Version.builder()
                      .setTag("version 1")
                      .setEngine("handlebars")
                      .setMjml("")
                      .setCreatedAt(Instant.parse("2025-03-22T16:52:29Z"))
                      .setComment("a comment value")
                      .setActive(false)
                      .setId("a1d695c7-4d8b-4e84-a1f9-bbbbbbbbbbbb")
                      .build(),
                  Version.builder()
                      .setTag("version 2")
                      .setEngine("handlebars")
                      .setMjml("")
                      .setCreatedAt(Instant.parse("2025-03-22T16:53:03Z"))
                      .setComment("a second comment value")
                      .setActive(true)
                      .setId("a1d695c7-4d8b-4e84-a1f9-cccccccccccc")
                      .build()))
          .build();

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(loadedTemplateResponseDto, expectedTemplate);
  }

  @Test
  void serialize() throws JsonProcessingException, JSONException {

    String serializedString = objectMapper.writeValueAsString(expectedTemplate);

    JSONAssert.assertEquals(jsonTemplateRequestDto, serializedString, true);
  }

  @Test
  void deserializeWithActive() {
    TestHelpers.recursiveEquals(
        loadedTemplateResponseWithActiveDto, expectedTemplateResponseWithActive);
  }

  @Test
  void deserializeWithVersions() {
    TestHelpers.recursiveEquals(
        loadedTemplateResponseWithVersionsDto, expectedTemplateResponseWithVersions);
  }
}
