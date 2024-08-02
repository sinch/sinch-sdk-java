package com.sinch.sdk.domains.conversation.models.v1.messages.types.mediacard;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.MediaCardMessageInternal;
import java.util.Objects;

@JsonPropertyOrder({MediaCardMessageImpl.JSON_PROPERTY_MEDIA_CARD_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MediaCardMessageImpl
    implements MediaCardMessage,
        com.sinch.sdk.domains.conversation.models.v1.messages.ContactMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_MEDIA_CARD_MESSAGE = "media_card_message";

  private OptionalValue<MediaCardMessageInternal> mediaCardMessage;

  public MediaCardMessageImpl() {}

  protected MediaCardMessageImpl(OptionalValue<MediaCardMessageInternal> mediaCardMessage) {
    this.mediaCardMessage = mediaCardMessage;
  }

  @JsonIgnore
  public MediaCardMessageInternal getMediaCardMessage() {
    return mediaCardMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MEDIA_CARD_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MediaCardMessageInternal> mediaCardMessage() {
    return mediaCardMessage;
  }

  @JsonIgnore
  public String getCaption() {
    if (null == mediaCardMessage
        || !mediaCardMessage.isPresent()
        || null == mediaCardMessage.get().getCaption()) {
      return null;
    }
    return mediaCardMessage.get().getCaption();
  }

  public OptionalValue<String> caption() {
    return null != mediaCardMessage
        ? mediaCardMessage.map(MediaCardMessageInternal::getCaption)
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getUrl() {
    if (null == mediaCardMessage
        || !mediaCardMessage.isPresent()
        || null == mediaCardMessage.get().getUrl()) {
      return null;
    }
    return mediaCardMessage.get().getUrl();
  }

  public OptionalValue<String> url() {
    return null != mediaCardMessage
        ? mediaCardMessage.map(MediaCardMessageInternal::getUrl)
        : OptionalValue.empty();
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
    MediaCardMessageImpl mediaCardMessageField = (MediaCardMessageImpl) o;
    return Objects.equals(this.mediaCardMessage, mediaCardMessageField.mediaCardMessage);
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
    OptionalValue<MediaCardMessageInternal> mediaCardMessage = OptionalValue.empty();

    MediaCardMessageInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_MEDIA_CARD_MESSAGE, required = true)
    public Builder setMediaCardMessage(MediaCardMessageInternal mediaCardMessage) {
      this.mediaCardMessage = OptionalValue.of(mediaCardMessage);
      return this;
    }

    @JsonIgnore
    public Builder setCaption(String caption) {
      getDelegatedBuilder().setCaption(caption);
      return this;
    }

    @JsonIgnore
    public Builder setUrl(String url) {
      getDelegatedBuilder().setUrl(url);
      return this;
    }

    private MediaCardMessageInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = MediaCardMessageInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public MediaCardMessage build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.mediaCardMessage = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new MediaCardMessageImpl(mediaCardMessage);
    }
  }
}
