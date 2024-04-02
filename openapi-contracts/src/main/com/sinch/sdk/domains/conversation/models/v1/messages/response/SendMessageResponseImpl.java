package com.sinch.sdk.domains.conversation.models.v1.messages.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.time.Instant;
import java.util.Objects;

@JsonPropertyOrder({
  SendMessageResponseImpl.JSON_PROPERTY_ACCEPTED_TIME,
  SendMessageResponseImpl.JSON_PROPERTY_MESSAGE_ID
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SendMessageResponseImpl implements SendMessageResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ACCEPTED_TIME = "accepted_time";

  private OptionalValue<Instant> acceptedTime;

  public static final String JSON_PROPERTY_MESSAGE_ID = "message_id";

  private OptionalValue<String> messageId;

  public SendMessageResponseImpl() {}

  protected SendMessageResponseImpl(
      OptionalValue<Instant> acceptedTime, OptionalValue<String> messageId) {
    this.acceptedTime = acceptedTime;
    this.messageId = messageId;
  }

  @JsonIgnore
  public Instant getAcceptedTime() {
    return acceptedTime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ACCEPTED_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> acceptedTime() {
    return acceptedTime;
  }

  @JsonIgnore
  public String getMessageId() {
    return messageId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> messageId() {
    return messageId;
  }

  /** Return true if this SendMessageResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SendMessageResponseImpl sendMessageResponse = (SendMessageResponseImpl) o;
    return Objects.equals(this.acceptedTime, sendMessageResponse.acceptedTime)
        && Objects.equals(this.messageId, sendMessageResponse.messageId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(acceptedTime, messageId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendMessageResponseImpl {\n");
    sb.append("    acceptedTime: ").append(toIndentedString(acceptedTime)).append("\n");
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
  static class Builder implements SendMessageResponse.Builder {
    OptionalValue<Instant> acceptedTime = OptionalValue.empty();
    OptionalValue<String> messageId = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ACCEPTED_TIME)
    public Builder setAcceptedTime(Instant acceptedTime) {
      this.acceptedTime = OptionalValue.of(acceptedTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGE_ID)
    public Builder setMessageId(String messageId) {
      this.messageId = OptionalValue.of(messageId);
      return this;
    }

    public SendMessageResponse build() {
      return new SendMessageResponseImpl(acceptedTime, messageId);
    }
  }
}
