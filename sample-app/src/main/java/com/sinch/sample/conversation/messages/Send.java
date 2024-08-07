package com.sinch.sample.conversation.messages;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.MessagesService;
import com.sinch.sdk.domains.conversation.models.v1.Agent;
import com.sinch.sdk.domains.conversation.models.v1.AgentType;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentities;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessageWithExtensions;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.SendMessageRequest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.call.CallMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.Choice;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Send extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Send.class.getName());

  public Send() throws IOException {}

  public static void main(String[] args) {
    try {
      new Send().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    MessagesService service = client.conversation().v1().messages();

    LOGGER.info("Send message with Conversation");

    var parameters = createRCSSendMessage();

    var result = service.sendMessage(parameters);

    LOGGER.info("Response: " + result);
  }

  SendMessageRequest<?> createRCSSendMessage() {
    var textMessage =
        TextMessage.builder()
            .setText("[Java SDK: Conversation Message] Please select a phone number to be called")
            .build();

    var choices = new ArrayList<Choice<?>>();
    for (int i = 0; i < 4; i++) {
      choices.add(
          Choice.<CallMessage>builder()
              .setMessage(
                  CallMessage.builder()
                      .setTitle("Phone call choice " + (i + 1))
                      .setPhoneNumber(phoneNumber)
                      .build())
              .setPostbackData("postback call_message data value " + (i + 1))
              .build());
    }

    return SendMessageRequest.<ChoiceMessage>builder()
        .setAppId(conversationAppId)
        .setMessage(
            AppMessageWithExtensions.<ChoiceMessage>builder()
                .setMessage(
                    ChoiceMessage.builder().setChoices(choices).setTextMessage(textMessage).build())
                .setAgent(
                    Agent.builder().setType(AgentType.HUMAN).setDisplayName("Agent Name").build())
                .build())
        .setRecipient(
            ChannelRecipientIdentities.of(
                ChannelRecipientIdentity.builder()
                    .setChannel(ConversationChannel.RCS)
                    .setIdentity(phoneNumber)
                    .build()))
        .setTtl(25)
        .build();
  }

  SendMessageRequest<?> createSMSSendMessage() {
    return SendMessageRequest.<TextMessage>builder()
        .setAppId(conversationAppId)
        .setMessage(
            AppMessageWithExtensions.<TextMessage>builder()
                .setMessage(
                    TextMessage.builder()
                        .setText("[Java SDK: Conversation Message] Sample text message")
                        .build())
                .setAgent(
                    Agent.builder().setType(AgentType.HUMAN).setDisplayName("Agent Name").build())
                .build())
        .setRecipient(
            ChannelRecipientIdentities.of(
                ChannelRecipientIdentity.builder()
                    .setChannel(ConversationChannel.SMS)
                    .setIdentity(phoneNumber)
                    .build()))
        .setTtl(25)
        .build();
  }
}
