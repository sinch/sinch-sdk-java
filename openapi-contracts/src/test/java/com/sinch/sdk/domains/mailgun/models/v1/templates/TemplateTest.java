package com.sinch.sdk.domains.mailgun.models.v1.templates;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import java.time.Instant;
import org.junit.jupiter.api.Test;

@TestWithResources
public class TemplateTest extends BaseTest {

  @GivenJsonResource("/domains/mailgun/v1/templates/TemplateDto.json")
  Template loadedTemplateDto;

  @GivenJsonResource("/domains/mailgun/v1/templates/TemplateWithActiveDto.json")
  Template loadedTemplateWithActiveDto;

  public static Template expectedTemplate =
      Template.builder()
          .setName("template.test")
          .setDescription("my description value")
          .setCreatedAt(Instant.parse("2025-01-10T14:17:05Z"))
          .setCreatedBy("creator")
          .setId("5427eb2f-bf68-4f4e-abfb-647f9b924772")
          .build();

  public static Template expectedTemplateWithActive =
      Template.builder()
          .setName("template.test")
          .setDescription("my description value")
          .setCreatedAt(Instant.parse("2025-01-10T14:17:05Z"))
          .setCreatedBy("creator")
          .setId("5427eb2f-bf68-4f4e-abfb-647f9b924772")
          .setVersion(VersionTest.expectedVersion)
          .build();

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(loadedTemplateDto, expectedTemplate);
  }

  @Test
  void deserializeWithActive() {
    TestHelpers.recursiveEquals(loadedTemplateWithActiveDto, expectedTemplateWithActive);
  }
}
