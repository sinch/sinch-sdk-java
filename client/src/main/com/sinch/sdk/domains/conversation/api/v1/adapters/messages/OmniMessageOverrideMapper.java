package com.sinch.sdk.domains.conversation.api.v1.adapters.messages;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverride;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.OmniMessageOverrideInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.carousel.CarouselMessageMapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.CarouselMessageFieldInternal;
import java.io.IOException;

public class OmniMessageOverrideMapper {

  public static void initMapper() {
    SimpleModule module =
        new SimpleModule().addDeserializer(OmniMessageOverride.class, new Deserializer());
    Mapper.getInstance().registerModule(module);
  }

  static class Deserializer extends StdDeserializer<OmniMessageOverride> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<OmniMessageOverride> vc) {
      super(vc);
    }

    @Override
    public OmniMessageOverride deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      Object deserialized =
          jp.readValueAs(OmniMessageOverrideInternalImpl.class).getActualInstance();
      if (deserialized instanceof CarouselMessageFieldInternal) {
        deserialized =
            CarouselMessageMapper.convert(
                ((CarouselMessageFieldInternal) deserialized).getCarouselMessage());
      }
      return (OmniMessageOverride) deserialized;
    }
  }
}
