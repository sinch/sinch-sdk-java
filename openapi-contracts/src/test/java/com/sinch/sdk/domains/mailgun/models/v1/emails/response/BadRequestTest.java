package com.sinch.sdk.domains.mailgun.models.v1.emails.response;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.junit.jupiter.api.Test;

@TestWithResources
public class BadRequestTest extends BaseTest {

  @GivenJsonResource("/domains/mailgun/v1/emails/response/BadRequestDto.json")
  BadRequest loadedBadRequestDto;

  public static BadRequest expectedBadRequest =
      BadRequest.builder().setMessage("from parameter is missing").build();

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(loadedBadRequestDto, expectedBadRequest);
  }
}
