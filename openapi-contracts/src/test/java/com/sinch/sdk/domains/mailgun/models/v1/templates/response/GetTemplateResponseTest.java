package com.sinch.sdk.domains.mailgun.models.v1.templates.response;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.mailgun.models.v1.templates.TemplateTest;
import com.sinch.sdk.domains.mailgun.models.v1.templates.internal.GetTemplateResponseInternal;
import org.junit.jupiter.api.Test;

@TestWithResources
public class GetTemplateResponseTest extends BaseTest {

  @GivenJsonResource("/domains/mailgun/v1/templates/response/GetTemplateResponseDto.json")
  GetTemplateResponseInternal loadedTemplateDto;

  @GivenJsonResource("/domains/mailgun/v1/templates/response/GetTemplateWithActiveResponseDto.json")
  GetTemplateResponseInternal loadedTemplateWithActiveDto;

  public static GetTemplateResponseInternal expectedTemplate =
      GetTemplateResponseInternal.builder().setTemplate(TemplateTest.expectedTemplate).build();

  public static GetTemplateResponseInternal expectedTemplateWithActive =
      GetTemplateResponseInternal.builder()
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
