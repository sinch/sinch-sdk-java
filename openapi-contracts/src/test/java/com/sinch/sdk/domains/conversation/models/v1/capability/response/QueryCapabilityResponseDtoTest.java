package com.sinch.sdk.domains.conversation.models.v1.capability.response;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentities;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import org.junit.jupiter.api.Test;

@TestWithResources
public class QueryCapabilityResponseDtoTest extends ConversationBaseTest {

  @GivenTextResource("domains/conversation/v1/capability/response/QueryCapabilityResponseDto.json")
  String jsonTranscodeMessageResponseDto;

  public static QueryCapabilityResponse expectedQueryCapabilityResponseDto =
      QueryCapabilityResponse.builder()
          .setAppId("an app id")
          .setRecipient(
              ChannelRecipientIdentities.of(
                  ChannelRecipientIdentity.builder()
                      .setChannel(ConversationChannel.MMS)
                      .setIdentity("+123456789")
                      .build()))
          .setRequestId("a request id")
          .build();

  @Test
  void deserializeDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonTranscodeMessageResponseDto, QueryCapabilityResponse.class);

    TestHelpers.recursiveEquals(deserialized, expectedQueryCapabilityResponseDto);
  }
}
