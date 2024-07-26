package com.sinch.sdk.domains.conversation.models.v1.events.types;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({ConversationDeletedEventImpl.JSON_PROPERTY_CONVERSATION_DELETED_EVENT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ConversationDeletedEventImpl
    implements ConversationDeletedEvent,
        com.sinch.sdk.domains.conversation.models.v1.events.ContactEvent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CONVERSATION_DELETED_EVENT =
      "conversation_deleted_event";

  private OptionalValue<Object> conversationDeletedEvent;

  public ConversationDeletedEventImpl() {}

  protected ConversationDeletedEventImpl(OptionalValue<Object> conversationDeletedEvent) {
    this.conversationDeletedEvent = conversationDeletedEvent;
  }

  @JsonIgnore
  public Object getConversationDeletedEvent() {
    return conversationDeletedEvent.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONVERSATION_DELETED_EVENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Object> conversationDeletedEvent() {
    return conversationDeletedEvent;
  }

  /** Return true if this ConversationDeletedEventField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConversationDeletedEventImpl conversationDeletedEventField = (ConversationDeletedEventImpl) o;
    return Objects.equals(
        this.conversationDeletedEvent, conversationDeletedEventField.conversationDeletedEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conversationDeletedEvent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConversationDeletedEventImpl {\n");
    sb.append("    conversationDeletedEvent: ")
        .append(toIndentedString(conversationDeletedEvent))
        .append("\n");
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
  static class Builder implements ConversationDeletedEvent.Builder {
    OptionalValue<Object> conversationDeletedEvent = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_CONVERSATION_DELETED_EVENT, required = true)
    public Builder setConversationDeletedEvent(Object conversationDeletedEvent) {
      this.conversationDeletedEvent = OptionalValue.of(conversationDeletedEvent);
      return this;
    }

    public ConversationDeletedEvent build() {
      return new ConversationDeletedEventImpl(conversationDeletedEvent);
    }
  }
}
