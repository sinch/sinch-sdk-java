package com.sinch.sdk.domains.conversation.models.v1.transcoding.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({TranscodeMessageResponseImpl.JSON_PROPERTY_TRANSCODED_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class TranscodeMessageResponseImpl implements TranscodeMessageResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TRANSCODED_MESSAGE = "transcoded_message";

  private OptionalValue<Map<ConversationChannel, String>> transcodedMessage;

  public TranscodeMessageResponseImpl() {}

  protected TranscodeMessageResponseImpl(
      OptionalValue<Map<ConversationChannel, String>> transcodedMessage) {
    this.transcodedMessage = transcodedMessage;
  }

  @JsonIgnore
  public Map<ConversationChannel, String> getTranscodedMessage() {
    return transcodedMessage.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<Map<ConversationChannel, String>> transcodedMessage() {
    return transcodedMessage;
  }

  /** Return true if this TranscodeMessageResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TranscodeMessageResponseImpl transcodeMessageResponse = (TranscodeMessageResponseImpl) o;
    return Objects.equals(this.transcodedMessage, transcodeMessageResponse.transcodedMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transcodedMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TranscodeMessageResponseImpl {\n");
    sb.append("    transcodedMessage: ").append(toIndentedString(transcodedMessage)).append("\n");
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
  static class Builder implements TranscodeMessageResponse.Builder {
    OptionalValue<Map<ConversationChannel, String>> transcodedMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TRANSCODED_MESSAGE)
    public Builder setTranscodedMessage(Map<ConversationChannel, String> transcodedMessage) {
      this.transcodedMessage = OptionalValue.of(transcodedMessage);
      return this;
    }

    public TranscodeMessageResponse build() {
      return new TranscodeMessageResponseImpl(transcodedMessage);
    }
  }
}
