package com.sinch.sdk.domains.conversation.models.v1.messages.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({ReplyToReplyToImpl.JSON_PROPERTY_MESSAGE_ID})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ReplyToReplyToImpl implements ReplyToReplyTo {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_MESSAGE_ID = "message_id";

  private OptionalValue<String> messageId;

  public ReplyToReplyToImpl() {}

  protected ReplyToReplyToImpl(OptionalValue<String> messageId) {
    this.messageId = messageId;
  }

  @JsonIgnore
  public String getMessageId() {
    return messageId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> messageId() {
    return messageId;
  }

  /** Return true if this ReplyTo_reply_to object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReplyToReplyToImpl replyToReplyTo = (ReplyToReplyToImpl) o;
    return Objects.equals(this.messageId, replyToReplyTo.messageId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messageId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReplyToReplyToImpl {\n");
    sb.append("    messageId: ").append(toIndentedString(messageId)).append("\n");
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
  static class Builder implements ReplyToReplyTo.Builder {
    OptionalValue<String> messageId = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_MESSAGE_ID)
    public Builder setMessageId(String messageId) {
      this.messageId = OptionalValue.of(messageId);
      return this;
    }

    public ReplyToReplyTo build() {
      return new ReplyToReplyToImpl(messageId);
    }
  }
}
