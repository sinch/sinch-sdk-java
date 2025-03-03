package com.sinch.sdk.domains.conversation.models.v1.messages.types.card;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessage.Builder;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessageImpl;

@Deprecated
public class CardMessageMediaImpl extends MediaMessageImpl implements CardMessageMedia {

  protected CardMessageMediaImpl(MediaMessageImpl mediaMessage) {
    super(OptionalValue.of(mediaMessage.getMediaMessage()));
  }

  static class Builder implements CardMessageMedia.Builder {

    MediaMessage.Builder builder = MediaMessage.builder();

    @Override
    public Builder setThumbnailUrl(String thumbnailUrl) {
      builder.setThumbnailUrl(thumbnailUrl);
      return this;
    }

    @Override
    public Builder setUrl(String url) {
      builder.setUrl(url);
      return this;
    }

    @Override
    public Builder setFilenameOverride(String filenameOverride) {
      builder.setFilenameOverride(filenameOverride);
      return this;
    }

    public CardMessageMedia build() {

      return new CardMessageMediaImpl((MediaMessageImpl) builder.build());
    }
  }
  /*
  public static class DelegatedSerializer extends JsonSerializer<OptionalValue<MediaMessage>> {
    @Override
    public void serialize(
        OptionalValue<MediaMessage> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      CardMessageMediaImpl impl = (CardMessageMediaImpl) value.get();
      jgen.writeObject(null != impl ? impl.getMediaMessage() : null);
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<MediaMessage> {
    @Override
    public MediaMessage deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {

      CardMessageMediaImpl.Builder builder = new CardMessageMediaImpl.Builder();
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
  }*/
}
