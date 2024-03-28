package com.sinch.sdk.domains.conversation.models.v1.messages.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.conversation.adapters.messages.SendMessageRequestMapper;
import com.sinch.sdk.domains.conversation.models.v1.AgentDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.Recipient;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.CardMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChannelSpecificMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChannelSpecificMessage.MessageTypeEnum;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChannelSpecificMessageMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverride;
import com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverrideMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.TextMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.request.MessageQueue;
import com.sinch.sdk.domains.conversation.models.v1.request.MetadataUpdateStrategy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class SendMessageDtoTest extends BaseTest {

  public static SendMessageRequest sendMessageRequestDto =
      SendMessageRequest.builder()
          .setAppId("my app ID")
          .setRecipient(Recipient.builder().setContactId("my contact ID").build())
          .setMessage(
              AppMessage.builder()
                  .setTextMessage(TextMessageDtoTest.textMessageDto)
                  .setExplicitChannelMessage(createExplicitChannelMessage())
                  .setExplicitChannelOmniMessage(createExplicitChannelOmniMessage())
                  // TODO .setChannelSpecificMessage(createChannelSpecificMessage())
                  .setAgent(AgentDtoTest.agentDto)
                  .build())
          .setCallbackUrl("callback URL value")
          .setChannelPriorityOrder(Collections.singletonList(ConversationChannel.LINE))
          .setChannelProperties(createChannelProperties())
          .setMessageMetadata("message metadata value")
          .setConversationMetadata("conversation metadata")
          .setQueue(MessageQueue.HIGH_PRIORITY)
          .setTtl(2)
          .setProcessingStrategy(ProcessingStrategy.DISPATCH_ONLY)
          .setCorrelationId("correlation ID value")
          .setConversationMetadataUpdateStrategy(MetadataUpdateStrategy.REPLACE)
          .build();

  static {
    // register mixin
    SendMessageRequestMapper unnused = new SendMessageRequestMapper();
  }

  @GivenTextResource("/domains/conversation/v1/messages/request/SendTextMessageRequestDto.json")
  String jsonSendMessageRequestDto;

  private static Map<ConversationChannel, Object> createExplicitChannelMessage() {
    Map<ConversationChannel, Object> map = new HashMap<>();
    map.put(ConversationChannel.KAKAOTALK, "foo value");
    return Collections.unmodifiableMap(map);
  }

  private static Map<ConversationChannel, OmniMessageOverride> createExplicitChannelOmniMessage() {
    Map<ConversationChannel, OmniMessageOverride> map = new HashMap<>();
    map.put(
        ConversationChannel.MESSENGER,
        OmniMessageOverride.builder()
            .setMessage(
                OmniMessageOverrideMessage.builder()
                    .setCardMessage(CardMessageDtoTest.cardMessageDto)
                    .build())
            .build());
    return Collections.unmodifiableMap(map);
  }

  private static Map<ConversationChannel, ChannelSpecificMessage> createChannelSpecificMessage() {
    Map<ConversationChannel, ChannelSpecificMessage> map = new HashMap<>();
    map.put(
        ConversationChannel.MESSENGER,
        ChannelSpecificMessage.builder()
            .setMessageType(MessageTypeEnum.FLOWS)
            .setMessage(ChannelSpecificMessageMessage.builder().build())
            .build());
    return Collections.unmodifiableMap(map);
  }

  private static Map<String, String> createChannelProperties() {
    Map<String, String> map = new HashMap<>();
    map.put("a property key", "a property value");
    return Collections.unmodifiableMap(map);
  }

  @Test
  void serializeSendMessageRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(sendMessageRequestDto);

    JSONAssert.assertEquals(jsonSendMessageRequestDto, serializedString, true);
  }
}
