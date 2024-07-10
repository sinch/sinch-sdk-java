package com.sinch.sdk.domains.conversation.api.v1.adapters.messages;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceItemImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.MediaMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.MediaMessageFieldInternal;
import java.io.IOException;

public class ChoiceItemMapper {

  public static void initMapper() {
    Mapper.getInstance().addMixIn(ChoiceItemImpl.class, ChoiceItemMapperMixin.class);
    // trick to use not public Builder: a bridge
    com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceItemMapper.initMapper();
  }

  private static class ChoiceItemMapperMixin extends ChoiceItemImpl {

    public ChoiceItemMapperMixin() {
      super();
    }

    @Override
    @JsonSerialize(using = MediaMessageSerializer.class)
    public OptionalValue<MediaMessage> media() {
      return super.media();
    }

    static class MediaMessageSerializer extends JsonSerializer<OptionalValue<MediaMessage>> {

      public MediaMessageSerializer() {
        super();
      }

      @Override
      public void serialize(
          OptionalValue<MediaMessage> value, JsonGenerator jgen, SerializerProvider provider)
          throws IOException {
        if (value.isPresent()) {
          jgen.writeObject(
              MediaMessageFieldInternal.builder().setMediaMessage(value.get()).build());
        }
      }
    }
  }
}
