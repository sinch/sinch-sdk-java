package com.sinch.sdk.domains.conversation.models.v1.messages.types.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({TextMessageInternalImpl.JSON_PROPERTY_TEXT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class TextMessageInternalImpl implements TextMessageInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TEXT = "text";

  private OptionalValue<String> text;

  public TextMessageInternalImpl() {}

  protected TextMessageInternalImpl(OptionalValue<String> text) {
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

  /** Return true if this Text_Message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TextMessageInternalImpl textMessage = (TextMessageInternalImpl) o;
    return Objects.equals(this.text, textMessage.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TextMessageInternalImpl {\n");
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
  static class Builder implements TextMessageInternal.Builder {
    OptionalValue<String> text = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TEXT)
    public Builder setText(String text) {
      this.text = OptionalValue.of(text);
      return this;
    }

    public TextMessageInternal build() {
      return new TextMessageInternalImpl(text);
    }
  }
}
