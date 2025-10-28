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
  WhatsAppInteractiveHeaderImageImpl.JSON_PROPERTY_TYPE,
  WhatsAppInteractiveHeaderImageImpl.JSON_PROPERTY_IMAGE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class WhatsAppInteractiveHeaderImageImpl
    implements WhatsAppInteractiveHeaderImage,
        com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows
            .WhatsAppInteractiveHeader {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_IMAGE = "image";

  private OptionalValue<WhatsAppInteractiveHeaderMedia> image;

  public WhatsAppInteractiveHeaderImageImpl() {}

  protected WhatsAppInteractiveHeaderImageImpl(
      OptionalValue<TypeEnum> type, OptionalValue<WhatsAppInteractiveHeaderMedia> image) {
    this.type = type;
    this.image = image;
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
  public WhatsAppInteractiveHeaderMedia getImage() {
    return image.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IMAGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<WhatsAppInteractiveHeaderMedia> image() {
    return image;
  }

  /** Return true if this WhatsAppInteractiveImageHeader object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WhatsAppInteractiveHeaderImageImpl whatsAppInteractiveImageHeader =
        (WhatsAppInteractiveHeaderImageImpl) o;
    return Objects.equals(this.type, whatsAppInteractiveImageHeader.type)
        && Objects.equals(this.image, whatsAppInteractiveImageHeader.image);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, image);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WhatsAppInteractiveHeaderImageImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
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
  static class Builder implements WhatsAppInteractiveHeaderImage.Builder {
    OptionalValue<TypeEnum> type = OptionalValue.of(WhatsAppInteractiveHeaderImage.TypeEnum.IMAGE);
    OptionalValue<WhatsAppInteractiveHeaderMedia> image = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TYPE, required = true)
    Builder setType(TypeEnum type) {
      if (!Objects.equals(type, WhatsAppInteractiveHeaderImage.TypeEnum.IMAGE)) {
        throw new IllegalArgumentException(
            String.format(
                "'type' must be '%s' (is '%s')",
                WhatsAppInteractiveHeaderImage.TypeEnum.IMAGE, type));
      }
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_IMAGE, required = true)
    public Builder setImage(WhatsAppInteractiveHeaderMedia image) {
      this.image = OptionalValue.of(image);
      return this;
    }

    public WhatsAppInteractiveHeaderImage build() {
      return new WhatsAppInteractiveHeaderImageImpl(type, image);
    }
  }
}
