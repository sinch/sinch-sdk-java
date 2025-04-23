package com.sinch.sdk.domains.mailgun.models.v1.emails.response;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import java.time.Instant;
import org.junit.jupiter.api.Test;

@TestWithResources
public class SendingQueuesStatusResponseTest extends BaseTest {

  public static SendingQueuesStatusResponse expectedSendingQueuesStatusResponse =
      SendingQueuesStatusResponse.builder()
          .setRegular(
              ExceededQueueQuota.builder()
                  .setIsDisabled(true)
                  .setDetails(
                      QueueStatusDisabledDetails.builder()
                          .setUntil(Instant.parse("2025-01-30T04:14:04Z"))
                          .setReason("You have too many messages in regular queue")
                          .build())
                  .build())
          .setScheduled(
              ExceededQueueQuota.builder()
                  .setIsDisabled(true)
                  .setDetails(
                      QueueStatusDisabledDetails.builder()
                          .setUntil(Instant.parse("2025-01-30T15:14:04Z"))
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
