package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessageImpl;

public class ChoiceItemMapper {

  public static void initMapper() {

    Mapper.getInstance()
        .addMixIn(ChoiceItem.class, ChoiceItemMixinSerializer.class)
        .addMixIn(ChoiceItem.Builder.class, ChoiceItemBuilderMapperMixin.class);
  }

  static class ChoiceItemMixinSerializer extends ChoiceItemImpl {

    @Override
    @JsonSerialize(using = MediaMessageImpl.DelegatedSerializer.class)
    public OptionalValue<MediaMessage> media() {
      return super.media();
    }
  }

  static class ChoiceItemBuilderMapperMixin extends ChoiceItemImpl.Builder {

    @Override
    @JsonDeserialize(using = MediaMessageImpl.DelegatedDeSerializer.class)
    public ChoiceItemImpl.Builder setMedia(MediaMessage media) {
      return super.setMedia(media);
    }
  }
}
