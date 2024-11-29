package com.sinch.sdk.domains.mailgun.models.v1.emails.response;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@TestWithResources
public class GetStoredEmailResponseTest extends BaseTest {

  @GivenJsonResource("/domains/mailgun/v1/emails/response/GetStoredEmailResponseDto.json")
  GetStoredEmailResponse loadedGetEmailResponseDto;

  public static GetStoredEmailResponse expectedGetEmailResponse =
      GetStoredEmailResponse.builder()
          .setTo("SinchSdkJava@sinch.com")
          .setSender("Excited User <mailgun@sandboxABCDE.mailgun.org>")
          .setRecipients("SinchSdkJava@sinch.com")
          .setFrom("Excited User <mailgun@sandboxABCDE.mailgun.org>")
          .setSubject("📧 Hello from Sinch SDK Java")
          .setBodyHtml("&#128231; HTML sent with <bold>Sinch SDK Java</bold>")
          .setBodyPlain("📧 Text sent with Sinch SDK Java")
          .setStrippedHtml("&#128231; HTML sent with <bold>Sinch SDK Java</bold>")
          .setStrippedText("📧 Text sent with Sinch SDK Java")
          .setStrippedSignature("a signature")
          .setMessageHeaders(
              Arrays.asList(
                  Arrays.asList("Mime-Version", "1.0"),
                  Arrays.asList(
                      "Content-Type",
                      "multipart/mixed;"
                          + " boundary=\"12fbc3b931c5f35e57a508a0daaa479e1fce01151c18d31d385e3586ec05\""),
                  Arrays.asList("Subject", "📧 Hello from Sinch SDK Java"),
                  Arrays.asList("From", "Excited User <mailgun@sandboxABCDE.mailgun.org>"),
                  Arrays.asList("To", "SinchSdkJava@sinch.com"),
                  Arrays.asList("X-Mailgun-Tag", "my tag 1"),
                  Arrays.asList("X-Mailgun-Tag", "my tag 2"),
                  Arrays.asList(
                      "Message-Id",
                      "<20241120145053.ABCDE8abde764661c8@sandboxABCDE.mailgun.org>")))
          .build();

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(loadedGetEmailResponseDto, expectedGetEmailResponse);
  }
}
