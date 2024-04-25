package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.MediaMessageFieldInternal;
import java.io.IOException;

// internal purpose only: do not use it directly
public class ChoiceItemMapper {

  public static void initMapper() {
    Mapper.getInstance().addMixIn(ChoiceItemImpl.Builder.class, ChoiceItemBuilderMapper.class);
  }

  static class ChoiceItemBuilderMapper extends ChoiceItemImpl.Builder {

    public ChoiceItemBuilderMapper() {
      super();
    }

    @Override
    @JsonDeserialize(using = MediaMessageDeserializer.class)
    public ChoiceItemImpl.Builder setMedia(MediaMessage media) {
      return super.setMedia(media);
    }

    static class MediaMessageDeserializer extends JsonDeserializer<MediaMessage> {

      public MediaMessageDeserializer() {
        super();
      }

      @Override
      public MediaMessage deserialize(
          JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        MediaMessageFieldInternal deserialized =
            jsonParser.readValueAs(MediaMessageFieldInternal.class);
        if (null == deserialized) {
          return null;
        }
        return deserialized.getMediaMessage();
      }
    }
  }
}
