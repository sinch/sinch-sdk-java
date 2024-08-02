package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.Agent;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.ChannelSpecificMessage;
import java.util.Map;

public class AppMessageWithExtensionsImpl<T extends AppMessage>
    implements AppMessageWithExtensions<T> {

  private final OptionalValue<T> message;
  private final OptionalValue<Map<ConversationChannel, Object>> explicitChannelMessage;
  private final OptionalValue<Map<OmniMessageOverride.ChannelSpecificTemplate, OmniMessageOverride>>
      explicitChannelOmniMessage;
  private final OptionalValue<Map<ConversationChannel, ChannelSpecificMessage>>
      channelSpecificMessage;
  private final OptionalValue<Agent> agent;

  public AppMessageWithExtensionsImpl(
      OptionalValue<T> message,
      OptionalValue<Map<ConversationChannel, Object>> explicitChannelMessage,
      OptionalValue<Map<OmniMessageOverride.ChannelSpecificTemplate, OmniMessageOverride>>
          explicitChannelOmniMessage,
      OptionalValue<Map<ConversationChannel, ChannelSpecificMessage>> channelSpecificMessage,
      OptionalValue<Agent> agent) {
    this.message = message;
    this.explicitChannelMessage = explicitChannelMessage;
    this.explicitChannelOmniMessage = explicitChannelOmniMessage;
    this.channelSpecificMessage = channelSpecificMessage;
    this.agent = agent;
  }

  public T getMessage() {
    return message.orElse(null);
  }

  public OptionalValue<T> message() {
    return message;
  }

  public Map<ConversationChannel, Object> getExplicitChannelMessage() {
    return explicitChannelMessage.orElse(null);
  }

  public OptionalValue<Map<ConversationChannel, Object>> explicitChannelMessage() {
    return explicitChannelMessage;
  }

  public Map<OmniMessageOverride.ChannelSpecificTemplate, OmniMessageOverride>
      getExplicitChannelOmniMessage() {
    return explicitChannelOmniMessage.orElse(null);
  }

  public OptionalValue<Map<OmniMessageOverride.ChannelSpecificTemplate, OmniMessageOverride>>
      explicitChannelOmniMessage() {
    return explicitChannelOmniMessage;
  }

  public Map<ConversationChannel, ChannelSpecificMessage> getChannelSpecificMessage() {
    return channelSpecificMessage.orElse(null);
  }

  public OptionalValue<Map<ConversationChannel, ChannelSpecificMessage>> channelSpecificMessage() {
    return channelSpecificMessage;
  }

  public Agent getAgent() {
    return agent.orElse(null);
  }

  public OptionalValue<Agent> agent() {
    return agent;
  }

  @Override
  public String toString() {
    return "AppMessageWithExtensionsImpl{"
        + "message="
        + message
        + ", explicitChannelMessage="
        + explicitChannelMessage
        + ", explicitChannelOmniMessage="
        + explicitChannelOmniMessage
        + ", channelSpecificMessage="
        + channelSpecificMessage
        + ", agent="
        + agent
        + '}';
  }

  /** Dedicated Builder */
  static class Builder<T extends AppMessage> implements AppMessageWithExtensions.Builder<T> {

    OptionalValue<T> message = OptionalValue.empty();
    OptionalValue<Map<ConversationChannel, Object>> explicitChannelMessage = OptionalValue.empty();
    OptionalValue<Map<OmniMessageOverride.ChannelSpecificTemplate, OmniMessageOverride>>
        explicitChannelOmniMessage = OptionalValue.empty();
    OptionalValue<Map<ConversationChannel, ChannelSpecificMessage>> channelSpecificMessage =
        OptionalValue.empty();
    OptionalValue<Agent> agent = OptionalValue.empty();

    public Builder<T> setMessage(T message) {
      this.message = OptionalValue.of(message);
      return this;
    }

    public Builder<T> setExplicitChannelMessage(
        Map<ConversationChannel, Object> explicitChannelMessage) {
      this.explicitChannelMessage = OptionalValue.of(explicitChannelMessage);
      return this;
    }

    public Builder<T> setExplicitChannelOmniMessage(
        Map<OmniMessageOverride.ChannelSpecificTemplate, OmniMessageOverride>
            explicitChannelOmniMessage) {
      this.explicitChannelOmniMessage = OptionalValue.of(explicitChannelOmniMessage);
      return this;
    }

    public Builder<T> setChannelSpecificMessage(
        Map<ConversationChannel, ChannelSpecificMessage> channelSpecificMessage) {
      this.channelSpecificMessage = OptionalValue.of(channelSpecificMessage);
      return this;
    }

    public Builder<T> setAgent(Agent agent) {
      this.agent = OptionalValue.of(agent);
      return this;
    }

    public AppMessageWithExtensions<T> build() {
      return new AppMessageWithExtensionsImpl<>(
          message,
          explicitChannelMessage,
          explicitChannelOmniMessage,
          channelSpecificMessage,
          agent);
    }
  }
}
