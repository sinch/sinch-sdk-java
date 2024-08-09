package com.sinch.sdk.domains.conversation.models.v1.conversation.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.conversation.Conversation;
import com.sinch.sdk.domains.conversation.models.v1.internal.ConversationMessageInternal;
import java.util.Objects;

@JsonPropertyOrder({
  ConversationRecentMessageImpl.JSON_PROPERTY_CONVERSATION,
  ConversationRecentMessageImpl.JSON_PROPERTY_LAST_MESSAGE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ConversationRecentMessageImpl implements ConversationRecentMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CONVERSATION = "conversation";

  private OptionalValue<Conversation> conversation;

  public static final String JSON_PROPERTY_LAST_MESSAGE = "last_message";

  private OptionalValue<ConversationMessageInternal> lastMessage;

  public ConversationRecentMessageImpl() {}

  protected ConversationRecentMessageImpl(
      OptionalValue<Conversation> conversation,
      OptionalValue<ConversationMessageInternal> lastMessage) {
    this.conversation = conversation;
    this.lastMessage = lastMessage;
  }

  @JsonIgnore
  public Conversation getConversation() {
    return conversation.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONVERSATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Conversation> conversation() {
    return conversation;
  }

  @JsonIgnore
  public ConversationMessageInternal getLastMessage() {
    return lastMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LAST_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ConversationMessageInternal> lastMessage() {
    return lastMessage;
  }

  /** Return true if this ConversationRecentMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConversationRecentMessageImpl conversationRecentMessage = (ConversationRecentMessageImpl) o;
    return Objects.equals(this.conversation, conversationRecentMessage.conversation)
        && Objects.equals(this.lastMessage, conversationRecentMessage.lastMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conversation, lastMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConversationRecentMessageImpl {\n");
    sb.append("    conversation: ").append(toIndentedString(conversation)).append("\n");
    sb.append("    lastMessage: ").append(toIndentedString(lastMessage)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements ConversationRecentMessage.Builder {
    OptionalValue<Conversation> conversation = OptionalValue.empty();
    OptionalValue<ConversationMessageInternal> lastMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CONVERSATION)
    public Builder setConversation(Conversation conversation) {
      this.conversation = OptionalValue.of(conversation);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LAST_MESSAGE)
    public Builder setLastMessage(ConversationMessageInternal lastMessage) {
      this.lastMessage = OptionalValue.of(lastMessage);
      return this;
    }

    public ConversationRecentMessage build() {
      return new ConversationRecentMessageImpl(conversation, lastMessage);
    }
  }
}
