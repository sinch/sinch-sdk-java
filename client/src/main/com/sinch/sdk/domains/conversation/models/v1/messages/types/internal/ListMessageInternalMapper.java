package com.sinch.sdk.domains.conversation.models.v1.messages.types.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessageImpl;

public class ListMessageInternalMapper {

  public static void initMapper() {

    Mapper.getInstance()
        .addMixIn(ListMessageInternal.class, ListMessageInternalMixinSerializer.class)
        .addMixIn(ListMessageInternal.Builder.class, ListMessageInternalBuilderMapperMixin.class);
  }

  static class ListMessageInternalMixinSerializer extends ListMessageInternalImpl {

    @Override
    @JsonSerialize(using = MediaMessageImpl.DelegatedSerializer.class)
    public OptionalValue<MediaMessage> media() {
      return super.media();
    }
  }

  static class ListMessageInternalBuilderMapperMixin extends ListMessageInternalImpl.Builder {

    @Override
    @JsonDeserialize(using = MediaMessageImpl.DelegatedDeSerializer.class)
    public ListMessageInternalImpl.Builder setMedia(MediaMessage media) {
      return super.setMedia(media);
    }
  }
}
