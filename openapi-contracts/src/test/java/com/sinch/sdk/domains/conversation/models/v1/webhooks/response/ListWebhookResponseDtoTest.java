package com.sinch.sdk.domains.conversation.models.v1.webhooks.response;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.WebhookDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.internal.WebhooksListResponseInternal;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@TestWithResources
public class ListWebhookResponseDtoTest extends ConversationBaseTest {

  @GivenJsonResource("domains/conversation/v1/webhooks/response/ListWebhooksResponseDto.json")
  WebhooksListResponseInternal dto;

  public static WebhooksListResponseInternal expectedResponseDto =
      WebhooksListResponseInternal.builder()
          .setWebhooks(Arrays.asList(WebhookDtoTest.expectedResponseDto))
          .build();

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(dto, expectedResponseDto);
  }
}
