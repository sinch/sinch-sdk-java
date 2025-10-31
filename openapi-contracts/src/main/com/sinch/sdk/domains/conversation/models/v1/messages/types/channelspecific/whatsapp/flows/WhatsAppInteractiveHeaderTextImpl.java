package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  WhatsAppInteractiveHeaderTextImpl.JSON_PROPERTY_TYPE,
  WhatsAppInteractiveHeaderTextImpl.JSON_PROPERTY_TEXT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class WhatsAppInteractiveHeaderTextImpl
    implements WhatsAppInteractiveHeaderText,
        com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows
            .WhatsAppInteractiveHeader {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_TEXT = "text";

  private OptionalValue<String> text;

  public WhatsAppInteractiveHeaderTextImpl() {}

  protected WhatsAppInteractiveHeaderTextImpl(
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
    WhatsAppInteractiveHeaderTextImpl whatsAppInteractiveTextHeader =
        (WhatsAppInteractiveHeaderTextImpl) o;
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
    sb.append("class WhatsAppInteractiveHeaderTextImpl {\n");
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
  static class Builder implements WhatsAppInteractiveHeaderText.Builder {
    OptionalValue<TypeEnum> type = OptionalValue.of(WhatsAppInteractiveHeaderText.TypeEnum.TEXT);
    OptionalValue<String> text = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TYPE, required = true)
    Builder setType(TypeEnum type) {
      if (!Objects.equals(type, WhatsAppInteractiveHeaderText.TypeEnum.TEXT)) {
        throw new IllegalArgumentException(
            String.format(
                "'type' must be '%s' (is '%s')",
                WhatsAppInteractiveHeaderText.TypeEnum.TEXT, type));
      }
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_TEXT, required = true)
    public Builder setText(String text) {
      this.text = OptionalValue.of(text);
      return this;
    }

    public WhatsAppInteractiveHeaderText build() {
      return new WhatsAppInteractiveHeaderTextImpl(type, text);
    }
  }
}
