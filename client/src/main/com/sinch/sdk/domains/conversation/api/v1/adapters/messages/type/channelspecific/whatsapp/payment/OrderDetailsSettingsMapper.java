package com.sinch.sdk.domains.conversation.api.v1.adapters.messages.type.channelspecific.whatsapp.payment;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.carousel.CarouselMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment.OrderDetailsSettings;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment.internal.WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImpl;
import java.io.IOException;

public class OrderDetailsSettingsMapper {

  public static void initMapper() {
    Mapper.getInstance()
        .registerModule(
            new SimpleModule().addDeserializer(OrderDetailsSettings.class, new Deserializer()));
  }

  static class Deserializer extends StdDeserializer<OrderDetailsSettings> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<CarouselMessageImpl> vc) {
      super(vc);
    }

    @Override
    public OrderDetailsSettings deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImpl deserialized =
          jp.readValueAs(
              WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImpl.class);

      return (OrderDetailsSettings) deserialized.getActualInstance();
    }
  }
}
