package com.sinch.sdk.domains.conversation.models.v1.messages.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({MediaCardMessageImpl.JSON_PROPERTY_MEDIA_CARD_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MediaCardMessageImpl implements MediaCardMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_MEDIA_CARD_MESSAGE = "media_card_message";

  private OptionalValue<MediaCardMessageMediaCardMessage> mediaCardMessage;

  public MediaCardMessageImpl() {}

  protected MediaCardMessageImpl(OptionalValue<MediaCardMessageMediaCardMessage> mediaCardMessage) {
    this.mediaCardMessage = mediaCardMessage;
  }

  @JsonIgnore
  public MediaCardMessageMediaCardMessage getMediaCardMessage() {
    return mediaCardMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MEDIA_CARD_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MediaCardMessageMediaCardMessage> mediaCardMessage() {
    return mediaCardMessage;
  }

  /** Return true if this MediaCardMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MediaCardMessageImpl mediaCardMessage = (MediaCardMessageImpl) o;
    return Objects.equals(this.mediaCardMessage, mediaCardMessage.mediaCardMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mediaCardMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MediaCardMessageImpl {\n");
    sb.append("    mediaCardMessage: ").append(toIndentedString(mediaCardMessage)).append("\n");
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
  static class Builder implements MediaCardMessage.Builder {
    OptionalValue<MediaCardMessageMediaCardMessage> mediaCardMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_MEDIA_CARD_MESSAGE)
    public Builder setMediaCardMessage(MediaCardMessageMediaCardMessage mediaCardMessage) {
      this.mediaCardMessage = OptionalValue.of(mediaCardMessage);
      return this;
    }

    public MediaCardMessage build() {
      return new MediaCardMessageImpl(mediaCardMessage);
    }
  }
}
