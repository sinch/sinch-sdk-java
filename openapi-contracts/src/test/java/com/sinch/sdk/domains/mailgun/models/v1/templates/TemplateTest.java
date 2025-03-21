package com.sinch.sdk.domains.mailgun.models.v1.templates;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
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
          .setVersion(VersionTest.expectedVersion)
          .build();

  public static Template expectedTemplateResponseWithInactive =
      // 'version' field is hidden, so we need direct access to 'Impl'
      new TemplateImpl.Builder()
          .setName("template.test")
          .setDescription("my description value")
          .setCreatedAt(Instant.parse("2025-01-10T14:17:05Z"))
          .setCreatedBy("creator")
          .setId("5427eb2f-bf68-4f4e-abfb-647f9b924772")
          .setVersion(VersionTest.expectedInactiveVersion)
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
