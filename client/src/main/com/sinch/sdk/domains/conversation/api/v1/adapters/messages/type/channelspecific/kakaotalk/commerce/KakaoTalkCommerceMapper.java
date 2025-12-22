package com.sinch.sdk.domains.conversation.api.v1.adapters.messages.type.channelspecific.kakaotalk.commerce;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.commerce.KakaoTalkCommerce;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.commerce.internal.KakaoTalkCommerceMessageCommerceImpl;
import java.io.IOException;

public class KakaoTalkCommerceMapper {

  public static void initMapper() {
    Mapper.getInstance()
        .registerModule(
            new SimpleModule().addDeserializer(KakaoTalkCommerce.class, new Deserializer()));
  }

  static class Deserializer extends StdDeserializer<KakaoTalkCommerce> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<KakaoTalkCommerce> vc) {
      super(vc);
    }

    @Override
    public KakaoTalkCommerce deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      KakaoTalkCommerceMessageCommerceImpl deserialized =
          jp.readValueAs(KakaoTalkCommerceMessageCommerceImpl.class);

      return (KakaoTalkCommerce) deserialized.getActualInstance();
    }
  }
}
