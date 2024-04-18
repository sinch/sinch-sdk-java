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
  WhatsAppInteractiveVideoHeaderInternalImpl.JSON_PROPERTY_TYPE,
  WhatsAppInteractiveVideoHeaderInternalImpl.JSON_PROPERTY_VIDEO
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class WhatsAppInteractiveVideoHeaderInternalImpl
    implements WhatsAppInteractiveVideoHeaderInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_VIDEO = "video";

  private OptionalValue<WhatsAppInteractiveHeaderMedia> video;

  public WhatsAppInteractiveVideoHeaderInternalImpl() {}

  protected WhatsAppInteractiveVideoHeaderInternalImpl(
      OptionalValue<TypeEnum> type, OptionalValue<WhatsAppInteractiveHeaderMedia> video) {
    this.type = type;
    this.video = video;
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
  public WhatsAppInteractiveHeaderMedia getVideo() {
    return video.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VIDEO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<WhatsAppInteractiveHeaderMedia> video() {
    return video;
  }

  /** Return true if this WhatsAppInteractiveVideoHeader object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WhatsAppInteractiveVideoHeaderInternalImpl whatsAppInteractiveVideoHeader =
        (WhatsAppInteractiveVideoHeaderInternalImpl) o;
    return Objects.equals(this.type, whatsAppInteractiveVideoHeader.type)
        && Objects.equals(this.video, whatsAppInteractiveVideoHeader.video);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, video);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WhatsAppInteractiveVideoHeaderInternalImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    video: ").append(toIndentedString(video)).append("\n");
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
  static class Builder implements WhatsAppInteractiveVideoHeaderInternal.Builder {
    OptionalValue<TypeEnum> type = OptionalValue.empty();
    OptionalValue<WhatsAppInteractiveHeaderMedia> video = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TYPE)
    public Builder setType(TypeEnum type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_VIDEO)
    public Builder setVideo(WhatsAppInteractiveHeaderMedia video) {
      this.video = OptionalValue.of(video);
      return this;
    }

    public WhatsAppInteractiveVideoHeaderInternal build() {
      return new WhatsAppInteractiveVideoHeaderInternalImpl(type, video);
    }
  }
}
