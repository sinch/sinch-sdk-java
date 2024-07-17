package com.sinch.sdk.domains.conversation.models.v1.messages;

// internal purpose only: do not use it directly
public class ChoiceItemMapper {

  public static void initMapper() {
    //   Mapper.getInstance().addMixIn(ChoiceItemImpl.Builder.class, ChoiceItemBuilderMapper.class);
  }

  /*static class ChoiceItemBuilderMapper extends ChoiceItemImpl.Builder {

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
  }*/
}
