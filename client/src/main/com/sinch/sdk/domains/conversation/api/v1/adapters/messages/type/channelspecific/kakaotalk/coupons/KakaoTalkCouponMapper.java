package com.sinch.sdk.domains.conversation.api.v1.adapters.messages.type.channelspecific.kakaotalk.coupons;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.coupons.KakaoTalkCoupon;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.coupons.internal.KakaoTalkCouponInternalImpl;
import java.io.IOException;

public class KakaoTalkCouponMapper {

  public static void initMapper() {
    Mapper.getInstance()
        .registerModule(
            new SimpleModule().addDeserializer(KakaoTalkCoupon.class, new Deserializer()));
  }

  static class Deserializer extends StdDeserializer<KakaoTalkCoupon> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<KakaoTalkCoupon> vc) {
      super(vc);
    }

    @Override
    public KakaoTalkCoupon deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      KakaoTalkCouponInternalImpl deserialized = jp.readValueAs(KakaoTalkCouponInternalImpl.class);

      return (KakaoTalkCoupon) deserialized.getActualInstance();
    }
  }
}
