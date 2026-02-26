package com.sinch.sdk.domains.conversation.models.v1.messages.types.internal;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment.WhatsAppPaymentButton;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment.internal.WhatsAppPaymentButtonInternalImpl;
import java.io.IOException;

public class WhatsAppPaymentButtonMapper {

  public static void initMapper() {
    SimpleModule module =
        new SimpleModule().addDeserializer(WhatsAppPaymentButton.class, new Deserializer());
    Mapper.getInstance().registerModule(module);
  }

  static class Deserializer extends StdDeserializer<WhatsAppPaymentButton> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<WhatsAppPaymentButton> vc) {
      super(vc);
    }

    @Override
    public WhatsAppPaymentButton deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      WhatsAppPaymentButtonInternalImpl deserialized =
          jp.readValueAs(WhatsAppPaymentButtonInternalImpl.class);
      return (WhatsAppPaymentButton) deserialized.getActualInstance();
    }
  }
}
