package com.sinch.sdk.domains.conversation.models.v1.messages.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  ChoiceResponseMessageChoiceResponseMessageImpl.JSON_PROPERTY_MESSAGE_ID,
  ChoiceResponseMessageChoiceResponseMessageImpl.JSON_PROPERTY_POSTBACK_DATA
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ChoiceResponseMessageChoiceResponseMessageImpl
    implements ChoiceResponseMessageChoiceResponseMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_MESSAGE_ID = "message_id";

  private OptionalValue<String> messageId;

  public static final String JSON_PROPERTY_POSTBACK_DATA = "postback_data";

  private OptionalValue<String> postbackData;

  public ChoiceResponseMessageChoiceResponseMessageImpl() {}

  protected ChoiceResponseMessageChoiceResponseMessageImpl(
      OptionalValue<String> messageId, OptionalValue<String> postbackData) {
    this.messageId = messageId;
    this.postbackData = postbackData;
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

  @JsonIgnore
  public String getPostbackData() {
    return postbackData.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_POSTBACK_DATA)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> postbackData() {
    return postbackData;
  }

  /** Return true if this ChoiceResponseMessage_choice_response_message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChoiceResponseMessageChoiceResponseMessageImpl choiceResponseMessageChoiceResponseMessage =
        (ChoiceResponseMessageChoiceResponseMessageImpl) o;
    return Objects.equals(this.messageId, choiceResponseMessageChoiceResponseMessage.messageId)
        && Objects.equals(
            this.postbackData, choiceResponseMessageChoiceResponseMessage.postbackData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messageId, postbackData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChoiceResponseMessageChoiceResponseMessageImpl {\n");
    sb.append("    messageId: ").append(toIndentedString(messageId)).append("\n");
    sb.append("    postbackData: ").append(toIndentedString(postbackData)).append("\n");
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
  static class Builder implements ChoiceResponseMessageChoiceResponseMessage.Builder {
    OptionalValue<String> messageId = OptionalValue.empty();
    OptionalValue<String> postbackData = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_MESSAGE_ID)
    public Builder setMessageId(String messageId) {
      this.messageId = OptionalValue.of(messageId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_POSTBACK_DATA)
    public Builder setPostbackData(String postbackData) {
      this.postbackData = OptionalValue.of(postbackData);
      return this;
    }

    public ChoiceResponseMessageChoiceResponseMessage build() {
      return new ChoiceResponseMessageChoiceResponseMessageImpl(messageId, postbackData);
    }
  }
}
