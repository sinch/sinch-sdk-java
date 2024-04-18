package com.sinch.sdk.domains.conversation.models.v1.messages.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  WhatsAppInteractiveTextHeaderInternalImpl.JSON_PROPERTY_TYPE,
  WhatsAppInteractiveTextHeaderInternalImpl.JSON_PROPERTY_TEXT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class WhatsAppInteractiveTextHeaderInternalImpl
    implements WhatsAppInteractiveTextHeaderInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_TEXT = "text";

  private OptionalValue<String> text;

  public WhatsAppInteractiveTextHeaderInternalImpl() {}

  protected WhatsAppInteractiveTextHeaderInternalImpl(
      OptionalValue<TypeEnum> type, OptionalValue<String> text) {
    this.type = type;
    this.text = text;
  }

  @JsonIgnore
  public TypeEnum getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<TypeEnum> type() {
    return type;
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

  /** Return true if this WhatsAppInteractiveTextHeader object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WhatsAppInteractiveTextHeaderInternalImpl whatsAppInteractiveTextHeader =
        (WhatsAppInteractiveTextHeaderInternalImpl) o;
    return Objects.equals(this.type, whatsAppInteractiveTextHeader.type)
        && Objects.equals(this.text, whatsAppInteractiveTextHeader.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, text);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WhatsAppInteractiveTextHeaderInternalImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
  static class Builder implements WhatsAppInteractiveTextHeaderInternal.Builder {
    OptionalValue<TypeEnum> type = OptionalValue.empty();
    OptionalValue<String> text = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TYPE)
    public Builder setType(TypeEnum type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TEXT)
    public Builder setText(String text) {
      this.text = OptionalValue.of(text);
      return this;
    }

    public WhatsAppInteractiveTextHeaderInternal build() {
      return new WhatsAppInteractiveTextHeaderInternalImpl(type, text);
    }
  }
}
