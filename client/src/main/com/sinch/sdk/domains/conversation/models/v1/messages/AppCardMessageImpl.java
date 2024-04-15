package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.Agent;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import java.util.Map;

public class AppCardMessageImpl extends AppMessageImpl<CardMessage> implements AppCardMessage {

  private AppCardMessageImpl(
      OptionalValue<CardMessage> message,
      OptionalValue<Map<ConversationChannel, Object>> explicitChannelMessage,
      OptionalValue<Map<ConversationChannel, OmniMessageOverride>> explicitChannelOmniMessage,
      OptionalValue<Map<ConversationChannel, ChannelSpecificMessage>> channelSpecificMessage,
      OptionalValue<Agent> agent) {
    super(
        message, explicitChannelMessage, explicitChannelOmniMessage, channelSpecificMessage, agent);
  }

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  public static Builder builder() {
    return new Builder();
  }

  /** Dedicated Builder */
  public static class Builder extends AppMessageImpl.Builder<CardMessage>
      implements AppCardMessage.Builder {}
}