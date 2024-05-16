package com.sinch.sdk.domains.conversation.models.v1;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.adapters.ConversationBaseTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class RecipientDtoTest extends ConversationBaseTest {

  public static Recipient contactId = ContactId.builder().setContactId("+12345676").build();

  public static Recipient channelRecipientIdentities =
      ChannelRecipientIdentities.of(
          ChannelRecipientIdentity.builder()
              .setChannel(ConversationChannel.SMS)
              .setIdentity("a channel identity")
              .build());

  @GivenTextResource("/domains/conversation/v1/RecipientContactIdDto.json")
  String jsonContactIdDto;

  @GivenTextResource("/domains/conversation/v1/RecipientChannelRecipientIdentitiesDto.json")
  String jsonChannelRecipientIdentitiesDto;

  @Test
  void serializeContactIdDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(contactId);

    JSONAssert.assertEquals(jsonContactIdDto, serializedString, true);
  }

  @Test
  void serializeChannelRecipientIdentities() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(channelRecipientIdentities);

    JSONAssert.assertEquals(jsonChannelRecipientIdentitiesDto, serializedString, true);
  }
}
