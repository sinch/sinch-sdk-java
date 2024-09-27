package com.sinch.sdk.domains.conversation.models.v1.capability.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentities;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class QueryCapabilityRequestDtoTest extends ConversationBaseTest {

  public static QueryCapabilityRequest queryCapabilityRequestDto =
      QueryCapabilityRequest.builder()
          .setAppId("an app id")
          .setRecipient(
              ChannelRecipientIdentities.of(
                  ChannelRecipientIdentity.builder()
                      .setChannel(ConversationChannel.MMS)
                      .setIdentity("+123456789")
                      .build()))
          .build();

  @GivenTextResource("/domains/conversation/v1/capability/request/QueryCapabilityRequestDto.json")
  static String jsonQueryCapabilityRequestDto;

  @Test
  void serializeDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(queryCapabilityRequestDto);

    JSONAssert.assertEquals(jsonQueryCapabilityRequestDto, serializedString, true);
  }
}
