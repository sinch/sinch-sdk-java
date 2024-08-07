package com.sinch.sdk.domains.conversation.models.v1.messages.types.mediacard;

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
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.MediaCardMessageInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.MediaCardMessageInternalImpl;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

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
    return null != mediaCardMessage && mediaCardMessage.isPresent()
        ? mediaCardMessage
            .map(f -> ((MediaCardMessageInternalImpl) f).caption())
            .orElse(OptionalValue.empty())
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
    return null != mediaCardMessage && mediaCardMessage.isPresent()
        ? mediaCardMessage
            .map(f -> ((MediaCardMessageInternalImpl) f).url())
            .orElse(OptionalValue.empty())
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

  public static class DelegatedSerializer extends JsonSerializer<OptionalValue<MediaCardMessage>> {
    @Override
    public void serialize(
        OptionalValue<MediaCardMessage> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      MediaCardMessageImpl impl = (MediaCardMessageImpl) value.get();
      jgen.writeObject(impl.getMediaCardMessage());
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<MediaCardMessage> {
    @Override
    public MediaCardMessage deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      MediaCardMessageImpl.Builder builder = new MediaCardMessageImpl.Builder();
      MediaCardMessageInternalImpl deserialized =
          jp.readValueAs(MediaCardMessageInternalImpl.class);
      builder.setMediaCardMessage(deserialized);
      return builder.build();
    }
  }

  public static Optional<MediaCardMessage> delegatedConverter(MediaCardMessageInternal internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setMediaCardMessage(internal).build());
  }
}
