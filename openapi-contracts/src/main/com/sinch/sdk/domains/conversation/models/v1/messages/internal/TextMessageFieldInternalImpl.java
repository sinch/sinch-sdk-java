package com.sinch.sdk.domains.conversation.models.v1.messages.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.TextMessage;
import java.util.Objects;

@JsonPropertyOrder({TextMessageFieldInternalImpl.JSON_PROPERTY_TEXT_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class TextMessageFieldInternalImpl implements TextMessageFieldInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TEXT_MESSAGE = "text_message";

  private OptionalValue<TextMessage> textMessage;

  public TextMessageFieldInternalImpl() {}

  protected TextMessageFieldInternalImpl(OptionalValue<TextMessage> textMessage) {
    this.textMessage = textMessage;
  }

  @JsonIgnore
  public TextMessage getTextMessage() {
    return textMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEXT_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TextMessage> textMessage() {
    return textMessage;
  }

  /** Return true if this TextMessageField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TextMessageFieldInternalImpl textMessageField = (TextMessageFieldInternalImpl) o;
    return Objects.equals(this.textMessage, textMessageField.textMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(textMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TextMessageFieldInternalImpl {\n");
    sb.append("    textMessage: ").append(toIndentedString(textMessage)).append("\n");
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
  static class Builder implements TextMessageFieldInternal.Builder {
    OptionalValue<TextMessage> textMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TEXT_MESSAGE)
    public Builder setTextMessage(TextMessage textMessage) {
      this.textMessage = OptionalValue.of(textMessage);
      return this;
    }

    public TextMessageFieldInternal build() {
      return new TextMessageFieldInternalImpl(textMessage);
    }
  }
}
