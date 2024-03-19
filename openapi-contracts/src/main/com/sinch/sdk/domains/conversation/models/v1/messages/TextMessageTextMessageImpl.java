package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({TextMessageTextMessageImpl.JSON_PROPERTY_TEXT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class TextMessageTextMessageImpl implements TextMessageTextMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TEXT = "text";

  private OptionalValue<String> text;

  public TextMessageTextMessageImpl() {}

  protected TextMessageTextMessageImpl(OptionalValue<String> text) {
    this.text = text;
  }

  @JsonIgnore
  public String getText() {
    return text.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEXT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> text() {
    return text;
  }

  /** Return true if this TextMessage_text_message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TextMessageTextMessageImpl textMessageTextMessage = (TextMessageTextMessageImpl) o;
    return Objects.equals(this.text, textMessageTextMessage.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TextMessageTextMessageImpl {\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
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
  static class Builder implements TextMessageTextMessage.Builder {
    OptionalValue<String> text = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TEXT)
    public Builder setText(String text) {
      this.text = OptionalValue.of(text);
      return this;
    }

    public TextMessageTextMessage build() {
      return new TextMessageTextMessageImpl(text);
    }
  }
}
