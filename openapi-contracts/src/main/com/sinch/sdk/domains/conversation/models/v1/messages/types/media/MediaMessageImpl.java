package com.sinch.sdk.domains.conversation.models.v1.messages.types.media;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.MediaPropertiesInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.MediaPropertiesInternalImpl;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({MediaMessageImpl.JSON_PROPERTY_MEDIA_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MediaMessageImpl
    implements MediaMessage,
        com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverride,
        com.sinch.sdk.domains.conversation.models.v1.messages.AppMessageBody,
        com.sinch.sdk.domains.conversation.models.v1.messages.ContactMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_MEDIA_MESSAGE = "media_message";

  private OptionalValue<MediaPropertiesInternal> mediaMessage;

  public MediaMessageImpl() {}

  protected MediaMessageImpl(OptionalValue<MediaPropertiesInternal> mediaMessage) {
    this.mediaMessage = mediaMessage;
  }

  @JsonIgnore
  public MediaPropertiesInternal getMediaMessage() {
    return mediaMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MEDIA_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MediaPropertiesInternal> mediaMessage() {
    return mediaMessage;
  }

  @JsonIgnore
  public String getThumbnailUrl() {
    if (null == mediaMessage
        || !mediaMessage.isPresent()
        || null == mediaMessage.get().getThumbnailUrl()) {
      return null;
    }
    return mediaMessage.get().getThumbnailUrl();
  }

  public OptionalValue<String> thumbnailUrl() {
    return null != mediaMessage && mediaMessage.isPresent()
        ? mediaMessage
            .map(f -> ((MediaPropertiesInternalImpl) f).thumbnailUrl())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getUrl() {
    if (null == mediaMessage || !mediaMessage.isPresent() || null == mediaMessage.get().getUrl()) {
      return null;
    }
    return mediaMessage.get().getUrl();
  }

  public OptionalValue<String> url() {
    return null != mediaMessage && mediaMessage.isPresent()
        ? mediaMessage
            .map(f -> ((MediaPropertiesInternalImpl) f).url())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getFilenameOverride() {
    if (null == mediaMessage
        || !mediaMessage.isPresent()
        || null == mediaMessage.get().getFilenameOverride()) {
      return null;
    }
    return mediaMessage.get().getFilenameOverride();
  }

  public OptionalValue<String> filenameOverride() {
    return null != mediaMessage && mediaMessage.isPresent()
        ? mediaMessage
            .map(f -> ((MediaPropertiesInternalImpl) f).filenameOverride())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this MediaMessageField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MediaMessageImpl mediaMessageField = (MediaMessageImpl) o;
    return Objects.equals(this.mediaMessage, mediaMessageField.mediaMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mediaMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MediaMessageImpl {\n");
    sb.append("    mediaMessage: ").append(toIndentedString(mediaMessage)).append("\n");
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
  static class Builder implements MediaMessage.Builder {
    OptionalValue<MediaPropertiesInternal> mediaMessage = OptionalValue.empty();

    MediaPropertiesInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_MEDIA_MESSAGE, required = true)
    public Builder setMediaMessage(MediaPropertiesInternal mediaMessage) {
      this.mediaMessage = OptionalValue.of(mediaMessage);
      return this;
    }

    @JsonIgnore
    public Builder setThumbnailUrl(String thumbnailUrl) {
      getDelegatedBuilder().setThumbnailUrl(thumbnailUrl);
      return this;
    }

    @JsonIgnore
    public Builder setUrl(String url) {
      getDelegatedBuilder().setUrl(url);
      return this;
    }

    @JsonIgnore
    public Builder setFilenameOverride(String filenameOverride) {
      getDelegatedBuilder().setFilenameOverride(filenameOverride);
      return this;
    }

    private MediaPropertiesInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = MediaPropertiesInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public MediaMessage build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.mediaMessage = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new MediaMessageImpl(mediaMessage);
    }
  }

  public static class DelegatedSerializer extends JsonSerializer<OptionalValue<MediaMessage>> {
    @Override
    public void serialize(
        OptionalValue<MediaMessage> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      MediaMessageImpl impl = (MediaMessageImpl) value.get();
      jgen.writeObject(impl.getMediaMessage());
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<MediaMessage> {
    @Override
    public MediaMessage deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {

      MediaMessageImpl.Builder builder = new MediaMessageImpl.Builder();
      MediaPropertiesInternalImpl deserialized = jp.readValueAs(MediaPropertiesInternalImpl.class);
      builder.setMediaMessage(deserialized);
      return builder.build();
    }
  }

  public static Optional<MediaMessage> delegatedConverter(MediaPropertiesInternal internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setMediaMessage(internal).build());
  }
}
