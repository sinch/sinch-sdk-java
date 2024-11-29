package com.sinch.sdk.domains.mailgun.models.v1.emails.response;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.junit.jupiter.api.Test;

@TestWithResources
public class SendingQueuesStatusResponseTest extends BaseTest {

  public static SendingQueuesStatusResponse expectedSendingQueuesStatusResponse =
      SendingQueuesStatusResponse.builder()
          .setRegular(
              ExceededQueueQuotaRegular.builder()
                  .setIsDisabled(true)
                  .setDisabled(
                      QueueStatusDisabledDetails.builder()
                          .setUntil("Mon, 24 Jan 2006 16:00:00 MST")
                          .setReason("You have too many messages in regular queue")
                          .build())
                  .build())
          .setScheduled(
              ExceededQueueQuotaScheduled.builder()
                  .setIsDisabled(true)
                  .setDisabled(
                      QueueStatusDisabledDetails.builder()
                          .setUntil("Mon, 12 Jan 2006 15:04:05 MST")
                          .setReason("You have too many messages in scheduled queue")
                          .build())
                  .build())
          .build();

  @GivenJsonResource("/domains/mailgun/v1/emails/response/SendingQueuesStatusResponseDto.json")
  SendingQueuesStatusResponse loadedSendingQueuesStatusResponseDto;

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(
        loadedSendingQueuesStatusResponseDto, expectedSendingQueuesStatusResponse);
  }
}
