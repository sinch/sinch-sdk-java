package com.sinch.sdk.domains.conversation.models.v1.messages.types.carousel;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.card.CardMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.card.CardMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.CardMessageInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.CarouselMessageFieldInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.CarouselMessageFieldInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.CarouselMessageInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.CarouselMessageInternalImpl;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarouselMessageMapper {

  public static void initMapper() {
    Mapper.getInstance()
        .registerModule(
            new SimpleModule()
                .addSerializer(CarouselMessage.class, new Serializer())
                .addDeserializer(CarouselMessage.class, new Deserializer()));
  }

  static class Serializer extends StdSerializer<CarouselMessage> {

    public Serializer() {
      this(null);
    }

    public Serializer(Class<CarouselMessage> vc) {
      super(vc);
    }

    @Override
    public void serialize(CarouselMessage raw, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      CarouselMessageImpl value = (CarouselMessageImpl) raw;
      OptionalValue<List<CardMessageInternal>> cards =
          value
              .cards()
              .map(
                  list ->
                      list.stream()
                          .map(CarouselMessageMapper::convert)
                          .collect(Collectors.toList()));
      CarouselMessageInternal.Builder carouselMessageBuilder = CarouselMessageInternal.builder();
      cards.ifPresent(carouselMessageBuilder::setCards);
      value.choices().ifPresent(carouselMessageBuilder::setChoices);

      CarouselMessageFieldInternal field =
          CarouselMessageFieldInternal.builder()
              .setCarouselMessage(carouselMessageBuilder.build())
              .build();
      jgen.writeObject(field);
    }
  }

  static class Deserializer extends StdDeserializer<CarouselMessageImpl> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<CarouselMessageImpl> vc) {
      super(vc);
    }

    @Override
    public CarouselMessageImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      CarouselMessageFieldInternalImpl deserialized =
          jp.readValueAs(CarouselMessageFieldInternalImpl.class);

      return deserialized.carouselMessage().map(CarouselMessageMapper::convert).orElse(null);
    }
  }

  private static CardMessageInternal convert(CardMessage _from) {
    return ((CardMessageImpl) _from).getCardMessage();
  }

  public static CarouselMessageImpl convert(CarouselMessageInternal _message) {
    CarouselMessageInternalImpl message = (CarouselMessageInternalImpl) _message;
    CarouselMessageImpl.Builder builder = new CarouselMessageImpl.Builder();
    message
        .cards()
        .ifPresent(
            list ->
                builder.setCards(
                    list.stream()
                        .map(CardMessageImpl::delegatedConverter)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList())));
    message.choices().ifPresent(builder::setChoices);
    return builder.build();
  }

  private static CarouselMessageInternal convert(CarouselMessage _message) {
    CarouselMessageImpl value = (CarouselMessageImpl) _message;
    OptionalValue<List<CardMessageInternal>> cards =
        value
            .cards()
            .map(
                list ->
                    list.stream().map(CarouselMessageMapper::convert).collect(Collectors.toList()));
    CarouselMessageInternal.Builder carouselMessageBuilder = CarouselMessageInternal.builder();
    cards.ifPresent(carouselMessageBuilder::setCards);
    value.choices().ifPresent(carouselMessageBuilder::setChoices);

    return carouselMessageBuilder.build();
  }

  public static class DelegatedSerializer extends JsonSerializer<OptionalValue<CarouselMessage>> {

    @Override
    public void serialize(
        OptionalValue<CarouselMessage> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      jgen.writeObject(convert(value.get()));
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<CarouselMessage> {
    @Override
    public CarouselMessage deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {
      CarouselMessageInternalImpl deserialized = jp.readValueAs(CarouselMessageInternalImpl.class);
      return convert(deserialized);
    }
  }
}
