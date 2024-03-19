package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({TextMessageImpl.JSON_PROPERTY_TEXT_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class TextMessageImpl implements TextMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TEXT_MESSAGE = "text_message";

  private OptionalValue<TextMessageTextMessage> textMessage;

  public TextMessageImpl() {}

  protected TextMessageImpl(OptionalValue<TextMessageTextMessage> textMessage) {
    this.textMessage = textMessage;
  }

  @JsonIgnore
  public TextMessageTextMessage getTextMessage() {
    return textMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEXT_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TextMessageTextMessage> textMessage() {
    return textMessage;
  }

  /** Return true if this TextMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TextMessageImpl textMessage = (TextMessageImpl) o;
    return Objects.equals(this.textMessage, textMessage.textMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(textMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TextMessageImpl {\n");
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
  static class Builder implements TextMessage.Builder {
    OptionalValue<TextMessageTextMessage> textMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TEXT_MESSAGE)
    public Builder setTextMessage(TextMessageTextMessage textMessage) {
      this.textMessage = OptionalValue.of(textMessage);
      return this;
    }

    public TextMessage build() {
      return new TextMessageImpl(textMessage);
    }
  }
}
