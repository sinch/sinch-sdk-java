package com.sinch.sdk.domains.voice.api.v1.adapters.mapper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.internal.CustomCalloutInternal;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.internal.CustomCalloutInternalImpl;
import com.sinch.sdk.domains.voice.models.v1.svaml.Control;
import com.sinch.sdk.domains.voice.models.v1.svaml.SvamlControl;
import java.io.IOException;

public class CalloutRequestCustomMapper {

  public static void initMapper() {
    Mapper.getInstance()
        .addMixIn(CustomCalloutInternal.class, CalloutRequestCustomMapperMixin.class);
  }

  public static class CalloutRequestCustomMapperMixin extends CustomCalloutInternalImpl {

    @Override
    @JsonSerialize(using = InlineControlSerializer.class)
    public OptionalValue<Control> ace() {
      return super.ace();
    }

    @Override
    @JsonSerialize(using = InlineControlSerializer.class)
    public OptionalValue<Control> ice() {
      return super.ice();
    }

    @Override
    @JsonSerialize(using = InlineControlSerializer.class)
    public OptionalValue<Control> pie() {
      return super.pie();
    }
  }

  static class InlineControlSerializer extends JsonSerializer<OptionalValue<Control>> {

    public InlineControlSerializer() {
      super();
    }

    @Override
    public void serialize(
        OptionalValue<Control> _value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!_value.isPresent()) {
        return;
      }

      Control value = _value.get();

      ObjectMapper mapper = (ObjectMapper) jgen.getCodec();
      String serialized = null;
      if (value instanceof SvamlControl) {
        serialized = mapper.writeValueAsString(value);
      }

      if (value instanceof com.sinch.sdk.domains.voice.models.v1.svaml.ControlUrl) {
        com.sinch.sdk.domains.voice.models.v1.svaml.ControlUrl url =
            (com.sinch.sdk.domains.voice.models.v1.svaml.ControlUrl) value;
        serialized = url.getUrl();
      }

      jgen.writeString(serialized);
    }
  }
}
