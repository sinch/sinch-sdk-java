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
}
