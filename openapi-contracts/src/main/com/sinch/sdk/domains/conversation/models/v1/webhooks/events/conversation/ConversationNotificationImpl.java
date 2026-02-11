package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.conversation;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.conversations.Conversation;
import java.util.Objects;

@JsonPropertyOrder({ConversationNotificationImpl.JSON_PROPERTY_CONVERSATION})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ConversationNotificationImpl implements ConversationNotification {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CONVERSATION = "conversation";

  private OptionalValue<Conversation> conversation;

  public ConversationNotificationImpl() {}

  protected ConversationNotificationImpl(OptionalValue<Conversation> conversation) {
    this.conversation = conversation;
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

  /** Return true if this ConversationNotification object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConversationNotificationImpl conversationNotification = (ConversationNotificationImpl) o;
    return Objects.equals(this.conversation, conversationNotification.conversation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conversation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConversationNotificationImpl {\n");
    sb.append("    conversation: ").append(toIndentedString(conversation)).append("\n");
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
  static class Builder implements ConversationNotification.Builder {
    OptionalValue<Conversation> conversation = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CONVERSATION)
    public Builder setConversation(Conversation conversation) {
      this.conversation = OptionalValue.of(conversation);
      return this;
    }

    public ConversationNotification build() {
      return new ConversationNotificationImpl(conversation);
    }
  }
}
