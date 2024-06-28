package com.sinch.sdk.domains.numbers.api.v1.adapters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.numbers.models.v1.Money;
import com.sinch.sdk.domains.numbers.models.v1.MoneyImpl;
import java.io.IOException;

public class MoneyMapper {

  public static void initMapper() {
    Mapper.getInstance().addMixIn(Money.class, MoneyMapperMixin.class);
  }

  public static class MoneyMapperMixin extends MoneyImpl {

    @Override
    @JsonSerialize(using = AmountSerializer.class)
    public OptionalValue<Double> amount() {
      return super.amount();
    }

    static class AmountSerializer extends JsonSerializer<OptionalValue<Double>> {

      public AmountSerializer() {
        super();
      }

      @Override
      public void serialize(
          OptionalValue<Double> value, JsonGenerator jgen, SerializerProvider provider)
          throws IOException {
        if (value.isPresent()) {
          jgen.writeObject(value.get().toString());
        }
      }
    }
  }
}
