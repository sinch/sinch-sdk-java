package com.sinch.sdk.domains.mailgun.models.v1.templates.response;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.mailgun.models.v1.templates.Template;
import com.sinch.sdk.domains.mailgun.models.v1.templates.TemplateTest;
import com.sinch.sdk.domains.mailgun.models.v1.templates.response.internal.CreateResponseInternal;
import java.time.Instant;
import org.junit.jupiter.api.Test;

@TestWithResources
public class CreateTemplateResponseTest extends BaseTest {

  @GivenJsonResource("/domains/mailgun/v1/templates/response/CreateTemplateResponseDto.json")
  CreateResponseInternal loadedTemplateDto;

  @GivenJsonResource(
      "/domains/mailgun/v1/templates/response/CreateTemplateWithActiveResponseDto.json")
  CreateResponseInternal loadedTemplateWithVersionDto;

  public static CreateResponseInternal expectedTemplate =
      CreateResponseInternal.builder()
          .setMessage("template has been stored")
          .setTemplate(
              Template.builder()
                  .setName("created template")
                  .setCreatedAt(Instant.parse("2025-03-19T14:19:28Z"))
                  .setId("8bf39b8d-650e-4706-a510-aaaaaaaaaaaa")
                  .build())
          .build();

  public static CreateResponseInternal expectedTemplateWithVersion =
      CreateResponseInternal.builder()
          .setMessage("template has been stored")
          .setTemplate(TemplateTest.expectedTemplateResponseWithActive)
          .build();

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(loadedTemplateDto, expectedTemplate);
  }

  @Test
  void deserializeWithVersion() {
    TestHelpers.recursiveEquals(loadedTemplateWithVersionDto, expectedTemplateWithVersion);
  }
}
