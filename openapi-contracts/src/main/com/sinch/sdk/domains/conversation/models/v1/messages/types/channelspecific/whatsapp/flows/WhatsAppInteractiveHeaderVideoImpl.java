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
  WhatsAppInteractiveHeaderVideoImpl.JSON_PROPERTY_TYPE,
  WhatsAppInteractiveHeaderVideoImpl.JSON_PROPERTY_VIDEO
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class WhatsAppInteractiveHeaderVideoImpl
    implements WhatsAppInteractiveHeaderVideo,
        com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows
            .WhatsAppInteractiveHeader {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_VIDEO = "video";

  private OptionalValue<WhatsAppInteractiveHeaderMedia> video;

  public WhatsAppInteractiveHeaderVideoImpl() {}

  protected WhatsAppInteractiveHeaderVideoImpl(
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
    WhatsAppInteractiveHeaderVideoImpl whatsAppInteractiveVideoHeader =
        (WhatsAppInteractiveHeaderVideoImpl) o;
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
    sb.append("class WhatsAppInteractiveHeaderVideoImpl {\n");
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
  static class Builder implements WhatsAppInteractiveHeaderVideo.Builder {
    OptionalValue<TypeEnum> type = OptionalValue.of(WhatsAppInteractiveHeaderVideo.TypeEnum.VIDEO);
    OptionalValue<WhatsAppInteractiveHeaderMedia> video = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TYPE, required = true)
    Builder setType(TypeEnum type) {
      if (!Objects.equals(type, WhatsAppInteractiveHeaderVideo.TypeEnum.VIDEO)) {
        throw new IllegalArgumentException(
            String.format(
                "'type' must be '%s' (is '%s')",
                WhatsAppInteractiveHeaderVideo.TypeEnum.VIDEO, type));
      }
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_VIDEO, required = true)
    public Builder setVideo(WhatsAppInteractiveHeaderMedia video) {
      this.video = OptionalValue.of(video);
      return this;
    }

    public WhatsAppInteractiveHeaderVideo build() {
      return new WhatsAppInteractiveHeaderVideoImpl(type, video);
    }
  }
}
