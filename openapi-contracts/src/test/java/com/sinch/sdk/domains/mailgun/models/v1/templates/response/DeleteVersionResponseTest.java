package com.sinch.sdk.domains.mailgun.models.v1.templates.response;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.junit.jupiter.api.Test;

@TestWithResources
public class DeleteVersionResponseTest extends BaseTest {

  @GivenJsonResource("/domains/mailgun/v1/templates/response/DeleteVersionResponseDto.json")
  UpdateResponse loadedResponseDto;

  public static UpdateResponse expectedResponse =
      UpdateResponse.builder()
          .setMessage("version has been deleted")
          .setTemplate(
              UpdatedTemplate.builder()
                  .setName("template created from java sdk")
                  .setVersion(UpdatedVersion.builder().setTag("a tag value").build())
                  .build())
          .build();

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(loadedResponseDto, expectedResponse);
  }
}
