package com.sinch.sdk.domains.mailgun.models.v1.templates.response;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.mailgun.models.v1.templates.VersionTest;
import org.junit.jupiter.api.Test;

@TestWithResources
public class CreateVersionResponseTest extends BaseTest {

  @GivenJsonResource("/domains/mailgun/v1/templates/response/CreateVersionResponseDto.json")
  CreateResponse loadedVersionDto;

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(loadedVersionDto, VersionTest.expectedCreatedVersion);
  }
}
