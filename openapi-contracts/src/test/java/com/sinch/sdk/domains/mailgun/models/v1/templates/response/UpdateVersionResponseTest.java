package com.sinch.sdk.domains.mailgun.models.v1.templates.response;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.mailgun.models.v1.templates.response.internal.UpdateResponseInternal;
import com.sinch.sdk.domains.mailgun.models.v1.templates.response.internal.UpdatedTemplateInternal;
import com.sinch.sdk.domains.mailgun.models.v1.templates.response.internal.UpdatedVersionInternal;
import org.junit.jupiter.api.Test;

@TestWithResources
public class UpdateVersionResponseTest extends BaseTest {

  @GivenJsonResource("/domains/mailgun/v1/templates/response/UpdateVersionResponseDto.json")
  UpdateResponseInternal loadedResponseDto;

  public static UpdateResponseInternal expectedResponse =
      UpdateResponseInternal.builder()
          .setMessage("version has been updated")
          .setTemplate(
              UpdatedTemplateInternal.builder()
                  .setName("template created from java sdk")
                  .setVersion(UpdatedVersionInternal.builder().setTag("a tag value").build())
                  .build())
          .build();

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(loadedResponseDto, expectedResponse);
  }
}
