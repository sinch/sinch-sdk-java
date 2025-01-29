package com.sinch.sdk.domains.mailgun.models.v1.templates.response;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.mailgun.models.v1.templates.TemplateTest;
import org.junit.jupiter.api.Test;

@TestWithResources
public class GetTemplateResponseTest extends BaseTest {

  @GivenJsonResource("/domains/mailgun/v1/templates/response/GetTemplateResponseDto.json")
  GetTemplateResponse loadedTemplateDto;

  @GivenJsonResource("/domains/mailgun/v1/templates/response/GetTemplateWithActiveResponseDto.json")
  GetTemplateResponse loadedTemplateWithActiveDto;

  public static GetTemplateResponse expectedTemplate =
      GetTemplateResponse.builder().setTemplate(TemplateTest.expectedTemplate).build();

  public static GetTemplateResponse expectedTemplateWithActive =
      GetTemplateResponse.builder()
          .setTemplate(TemplateTest.expectedTemplateResponseWithActive)
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
