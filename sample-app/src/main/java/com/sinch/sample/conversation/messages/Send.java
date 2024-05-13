package com.sinch.sample.conversation.messages;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.models.v1.Agent;
import com.sinch.sdk.domains.conversation.models.v1.AgentType;
import com.sinch.sdk.domains.conversation.models.v1.ContactId;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.TextMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.SendMessageRequest;
import java.io.IOException;
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

    LOGGER.info("Send message with Conversation");

    var parameters =
        SendMessageRequest.<TextMessage>builder()
            .setAppId(conversationAppId)
            .setMessage(
                AppMessage.<TextMessage>builder()
                    .setMessage(
                        TextMessage.builder()
                            .setText("[Java SDK: Conversation Message] Sample text message")
                            .build())
                    .setAgent(
                        Agent.builder()
                            .setType(AgentType.HUMAN)
                            .setDisplayName("Agent Name")
                            .build())
                    .build())
            .setRecipient(ContactId.builder().setContactId(conversationContactId).build())
            .setTtl(25)
            .build();

    var result = client.conversation().messages().sendTextMessage(parameters);

    LOGGER.info("Response: " + result);
  }
}