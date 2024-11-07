package com.sinch.sdk.domains.voice.api.v1.adapters.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.voice.models.v1.calls.response.CallInformationFrom;
import com.sinch.sdk.domains.voice.models.v1.calls.response.CallInformationTo;
import com.sinch.sdk.domains.voice.models.v1.destination.internal.DestinationInternalImpl;
import java.io.IOException;
import java.util.logging.Logger;

public class CallInformationMapper {

  private static final Logger LOGGER = Logger.getLogger(CallInformationMapper.class.getName());

  public static void initMapper() {

    SimpleModule module = new SimpleModule();
    module.addDeserializer(CallInformationFrom.class, new CallInformationFromDeserializer());
    module.addDeserializer(CallInformationTo.class, new CallInformationToDeserializer());
    Mapper.getInstance().registerModule(module);
  }

  static class CallInformationFromDeserializer extends StdDeserializer<CallInformationFrom> {

    public CallInformationFromDeserializer() {
      this(null);
    }

    public CallInformationFromDeserializer(Class<CallInformationFrom> vc) {
      super(vc);
    }

    @Override
    public CallInformationFrom deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      DestinationInternalImpl read = jp.readValueAs(DestinationInternalImpl.class);

      if (null == read) {
        return null;
      }
      Object instance = read.getActualInstance();
      if (!(instance instanceof CallInformationFrom)) {
        LOGGER.severe("Unexpected class: " + instance);
        return null;
      }
      return (CallInformationFrom) instance;
    }
  }

  static class CallInformationToDeserializer extends StdDeserializer<CallInformationTo> {

    public CallInformationToDeserializer() {
      this(null);
    }

    public CallInformationToDeserializer(Class<CallInformationFrom> vc) {
      super(vc);
    }

    @Override
    public CallInformationTo deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      DestinationInternalImpl read = jp.readValueAs(DestinationInternalImpl.class);

      if (null == read) {
        return null;
      }
      Object instance = read.getActualInstance();
      if (!(instance instanceof CallInformationTo)) {
        LOGGER.severe("Unexpected class: " + instance);
        return null;
      }
      return (CallInformationTo) instance;
    }
  }
}
