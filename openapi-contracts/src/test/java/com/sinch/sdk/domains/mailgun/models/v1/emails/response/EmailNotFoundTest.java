package com.sinch.sdk.domains.mailgun.models.v1.emails.response;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.junit.jupiter.api.Test;

@TestWithResources
public class EmailNotFoundTest extends BaseTest {

  @GivenJsonResource("/domains/mailgun/v1/emails/response/EmailNotFoundDto.json")
  EmailNotFound loadedEmailNotFoundDto;

  public static EmailNotFound expectedEmailNotFound =
      EmailNotFound.builder().setMessage("Message not found").build();

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(loadedEmailNotFoundDto, expectedEmailNotFound);
  }
}
