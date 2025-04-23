package com.sinch.sdk.domains.mailgun.models.v1.emails.response;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.junit.jupiter.api.Test;

@TestWithResources
public class SendEmailResponseTest extends BaseTest {

  @GivenJsonResource("/domains/mailgun/v1/emails/response/SendEmailResponseDto.json")
  SendEmailResponse loadedSendEmailResponseDto;

  public static SendEmailResponse expectedSendEmailResponse =
      SendEmailResponse.builder()
          .setId(
              "<20241120143457.abcdefada46fc312@sandbox7cebd4de7e914658a284dda3e6a845e2.mailgun.org>")
          .setMessage("Queued. Thank you.")
          .build();

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(loadedSendEmailResponseDto, expectedSendEmailResponse);
  }
}
