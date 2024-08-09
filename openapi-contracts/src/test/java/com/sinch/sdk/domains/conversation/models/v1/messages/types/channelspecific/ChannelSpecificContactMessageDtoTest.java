package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.ChannelSpecificContactMessage.MessageTypeEnum;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.nfmreply.WhatsAppInteractiveNfmReply;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.nfmreply.WhatsAppInteractiveNfmReply.NameEnum;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.nfmreply.WhatsAppInteractiveNfmReplyChannelSpecificContactMessage;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ChannelSpecificContactMessageDtoTest extends ConversationBaseTest {

  public static ChannelSpecificContactMessage channelSpecificContactMessageNfmReply =
      ChannelSpecificContactMessage.builder()
          .setMessageType(MessageTypeEnum.NFM_REPLY)
          .setMessage(
              WhatsAppInteractiveNfmReplyChannelSpecificContactMessage.builder()
                  .setNfmReply(
                      WhatsAppInteractiveNfmReply.builder()
                          .setBody("nfm reply body value")
                          .setName(NameEnum.ADDRESS_MESSAGE)
                          .setResponseJson("{\"key\": \"value\"}")
                          .build())
                  .build())
          .build();

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/whatsapp/nfmreply/ChannelSpecificContactMessageNfmReply.json")
  static String jsonChannelSpecificContactMessageNfmReply;

  @Test
  void serializeChannelSpecificContactMessageNfmReply()
      throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(channelSpecificContactMessageNfmReply);

    JSONAssert.assertEquals(jsonChannelSpecificContactMessageNfmReply, serializedString, true);
  }

  @Test
  void deserializeChannelSpecificContactMessageNfmReply() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(
            jsonChannelSpecificContactMessageNfmReply, ChannelSpecificContactMessage.class);

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(channelSpecificContactMessageNfmReply);
  }
}
