package com.sinch.sdk.domains.conversation.models.v1.messages.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.MediaCardMessage;
import java.util.Objects;

@JsonPropertyOrder({MediaCardMessageFieldInternalImpl.JSON_PROPERTY_MEDIA_CARD_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MediaCardMessageFieldInternalImpl implements MediaCardMessageFieldInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_MEDIA_CARD_MESSAGE = "media_card_message";

  private OptionalValue<MediaCardMessage> mediaCardMessage;

  public MediaCardMessageFieldInternalImpl() {}

  protected MediaCardMessageFieldInternalImpl(OptionalValue<MediaCardMessage> mediaCardMessage) {
    this.mediaCardMessage = mediaCardMessage;
  }

  @JsonIgnore
  public MediaCardMessage getMediaCardMessage() {
    return mediaCardMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MEDIA_CARD_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MediaCardMessage> mediaCardMessage() {
    return mediaCardMessage;
  }

  /** Return true if this MediaCardMessageField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MediaCardMessageFieldInternalImpl mediaCardMessageField = (MediaCardMessageFieldInternalImpl) o;
    return Objects.equals(this.mediaCardMessage, mediaCardMessageField.mediaCardMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mediaCardMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MediaCardMessageFieldInternalImpl {\n");
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
  static class Builder implements MediaCardMessageFieldInternal.Builder {
    OptionalValue<MediaCardMessage> mediaCardMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_MEDIA_CARD_MESSAGE)
    public Builder setMediaCardMessage(MediaCardMessage mediaCardMessage) {
      this.mediaCardMessage = OptionalValue.of(mediaCardMessage);
      return this;
    }

    public MediaCardMessageFieldInternal build() {
      return new MediaCardMessageFieldInternalImpl(mediaCardMessage);
    }
  }
}
