package com.sinch.sdk.domains.conversation.api.v1.adapters.messages.type.channelspecific.kakaotalk.buttons;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.buttons.KakaoTalkButton;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.buttons.internal.KakaoTalkButtonInternalImpl;
import java.io.IOException;

public class KakaoTalkButtonMapper {

  public static void initMapper() {
    Mapper.getInstance()
        .registerModule(
            new SimpleModule().addDeserializer(KakaoTalkButton.class, new Deserializer()));
  }

  static class Deserializer extends StdDeserializer<KakaoTalkButton> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<KakaoTalkButton> vc) {
      super(vc);
    }

    @Override
    public KakaoTalkButton deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      KakaoTalkButtonInternalImpl deserialized = jp.readValueAs(KakaoTalkButtonInternalImpl.class);

      return (KakaoTalkButton) deserialized.getActualInstance();
    }
  }
}
