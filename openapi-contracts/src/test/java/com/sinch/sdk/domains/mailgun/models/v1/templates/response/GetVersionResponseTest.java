package com.sinch.sdk.domains.mailgun.models.v1.templates.response;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.mailgun.models.v1.templates.TemplateTest;
import com.sinch.sdk.domains.mailgun.models.v1.templates.internal.GetTemplateResponseInternal;
import org.junit.jupiter.api.Test;

@TestWithResources
public class GetVersionResponseTest extends BaseTest {

  @GivenJsonResource("/domains/mailgun/v1/templates/response/GetVersionResponseDto.json")
  GetTemplateResponseInternal loadedVersionDto;

  public static GetTemplateResponseInternal expectedVersion =
      GetTemplateResponseInternal.builder()
          .setTemplate(TemplateTest.expectedTemplateResponseWithInactive)
          .build();

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(loadedVersionDto, expectedVersion);
  }
}
