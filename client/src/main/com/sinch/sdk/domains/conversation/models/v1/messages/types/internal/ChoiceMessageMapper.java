package com.sinch.sdk.domains.conversation.models.v1.messages.types.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.ChoiceMessageInternalImpl.Builder;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessageImpl;

public class ChoiceMessageMapper {

  public static void initMapper() {

    Mapper.getInstance()
        .addMixIn(ChoiceMessageInternal.class, ChoiceMessageMixinSerializer.class)
        .addMixIn(ChoiceMessageInternal.Builder.class, ChoiceMessageMixinDeserializer.class);
  }

  static class ChoiceMessageMixinSerializer extends ChoiceMessageInternalImpl {

    @Override
    @JsonSerialize(using = TextMessageImpl.DelegatedSerializer.class)
    public OptionalValue<TextMessage> textMessage() {
      return super.textMessage();
    }
  }

  static class ChoiceMessageMixinDeserializer extends ChoiceMessageInternalImpl.Builder {

    @Override
    @JsonDeserialize(using = TextMessageImpl.DelegatedDeSerializer.class)
    public Builder setTextMessage(TextMessage message) {
      return super.setTextMessage(message);
    }
  }
}
