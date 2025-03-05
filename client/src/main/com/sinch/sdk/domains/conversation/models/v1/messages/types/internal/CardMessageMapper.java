package com.sinch.sdk.domains.conversation.models.v1.messages.types.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.card.CardMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessageImpl;

public class CardMessageMapper {

  public static void initMapper() {

    Mapper.getInstance()
        .addMixIn(CardMessageInternal.class, CardMessageMixinSerializer.class)
        .addMixIn(CardMessageInternalImpl.Builder.class, CardMessageBuilderMapperMixin.class);
  }

  static class CardMessageMixinSerializer extends CardMessageImpl {

    @Override
    @JsonSerialize(using = MediaMessageImpl.DelegatedSerializer.class)
    public OptionalValue<MediaMessage> media() {
      return super.media();
    }
  }

  static class CardMessageBuilderMapperMixin extends CardMessageInternalImpl.Builder {

    @Override
    @JsonDeserialize(using = MediaMessageImpl.DelegatedDeSerializer.class)
    public CardMessageInternalImpl.Builder setMedia(MediaMessage media) {
      return super.setMedia(media);
    }
  }
}
