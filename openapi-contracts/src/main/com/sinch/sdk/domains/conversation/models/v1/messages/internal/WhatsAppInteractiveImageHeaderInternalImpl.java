package com.sinch.sdk.domains.conversation.models.v1.messages.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.WhatsAppInteractiveHeaderMedia;
import java.util.Objects;

@JsonPropertyOrder({
  WhatsAppInteractiveImageHeaderInternalImpl.JSON_PROPERTY_TYPE,
  WhatsAppInteractiveImageHeaderInternalImpl.JSON_PROPERTY_IMAGE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class WhatsAppInteractiveImageHeaderInternalImpl
    implements WhatsAppInteractiveImageHeaderInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_IMAGE = "image";

  private OptionalValue<WhatsAppInteractiveHeaderMedia> image;

  public WhatsAppInteractiveImageHeaderInternalImpl() {}

  protected WhatsAppInteractiveImageHeaderInternalImpl(
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
    WhatsAppInteractiveImageHeaderInternalImpl whatsAppInteractiveImageHeader =
        (WhatsAppInteractiveImageHeaderInternalImpl) o;
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
    sb.append("class WhatsAppInteractiveImageHeaderInternalImpl {\n");
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
  static class Builder implements WhatsAppInteractiveImageHeaderInternal.Builder {
    OptionalValue<TypeEnum> type = OptionalValue.empty();
    OptionalValue<WhatsAppInteractiveHeaderMedia> image = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TYPE)
    public Builder setType(TypeEnum type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_IMAGE)
    public Builder setImage(WhatsAppInteractiveHeaderMedia image) {
      this.image = OptionalValue.of(image);
      return this;
    }

    public WhatsAppInteractiveImageHeaderInternal build() {
      return new WhatsAppInteractiveImageHeaderInternalImpl(type, image);
    }
  }
}
