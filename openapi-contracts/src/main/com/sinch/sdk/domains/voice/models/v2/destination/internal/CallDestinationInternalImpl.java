package com.sinch.sdk.domains.voice.models.v2.destination.internal;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sinch.sdk.core.models.AbstractOpenApiSchema;
import com.sinch.sdk.core.utils.databind.JSONNavigator;
import com.sinch.sdk.domains.voice.models.v2.destination.PhoneImpl;
import com.sinch.sdk.domains.voice.models.v2.destination.SipImpl;
import com.sinch.sdk.domains.voice.models.v2.destination.StreamImpl;
import com.sinch.sdk.domains.voice.models.v2.destination.VoiceRelayImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(using = CallDestinationInternalImpl.CallDestinationInternalImplDeserializer.class)
@JsonSerialize(using = CallDestinationInternalImpl.CallDestinationInternalImplSerializer.class)
public class CallDestinationInternalImpl extends AbstractOpenApiSchema
    implements CallDestinationInternal {
  private static final Logger log = Logger.getLogger(CallDestinationInternalImpl.class.getName());

  public static final class CallDestinationInternalImplSerializer
      extends StdSerializer<CallDestinationInternalImpl> {
    private static final long serialVersionUID = 1L;

    public CallDestinationInternalImplSerializer(Class<CallDestinationInternalImpl> t) {
      super(t);
    }

    public CallDestinationInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        CallDestinationInternalImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class CallDestinationInternalImplDeserializer
      extends StdDeserializer<CallDestinationInternalImpl> {

    private static final long serialVersionUID = 1L;

    public CallDestinationInternalImplDeserializer() {
      this(CallDestinationInternalImpl.class);
    }

    public CallDestinationInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public CallDestinationInternalImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      JsonNode discriminator = tree.get("type");
      String discriminatorValue = null != discriminator ? discriminator.asText() : null;
      Class<?> cls = null != discriminatorValue ? mappings.get(discriminatorValue) : null;
      if (null == cls) {
        throw new IOException(
            String.format(
                "Failed deserialization for CallDestinationInternalImpl: unknown 'type' value '%s'."
                    + " Possible values: %s",
                discriminatorValue, mappings.keySet()));
      }
      Object deserialized = tree.traverse(jp.getCodec()).readValueAs(cls);
      CallDestinationInternalImpl ret = new CallDestinationInternalImpl();
      ret.setActualInstance(deserialized);
      return ret;
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public CallDestinationInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(
          ctxt.getParser(), "CallDestinationInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  // discriminator value -> class
  private static final Map<String, Class<?>> mappings = new HashMap<>();

  public CallDestinationInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  static {
    schemas.put("PhoneImpl", PhoneImpl.class);
    schemas.put("SipImpl", SipImpl.class);
    schemas.put("StreamImpl", StreamImpl.class);
    schemas.put("VoiceRelayImpl", VoiceRelayImpl.class);
    JSONNavigator.registerDescendants(
        CallDestinationInternalImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    mappings.put("PHONE", PhoneImpl.class);
    mappings.put("SIP", SipImpl.class);
    mappings.put("STREAM", StreamImpl.class);
    mappings.put("VOICE_RELAY", VoiceRelayImpl.class);
    JSONNavigator.registerDiscriminator(CallDestinationInternalImpl.class, "type", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return CallDestinationInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: PhoneImpl, SipImpl, StreamImpl, VoiceRelayImpl
   */
  @Override
  public void setActualInstance(Object instance) {
    for (Class<?> schema : schemas.values()) {
      if (JSONNavigator.isInstanceOf(schema, instance, new HashSet<Class<?>>())) {
        super.setActualInstance(instance);
        return;
      }
    }
    throw new RuntimeException(
        "Invalid instance type. Must be PhoneImpl, SipImpl, StreamImpl, VoiceRelayImpl");
  }

  /**
   * Get the actual instance, which can be the following: PhoneImpl, SipImpl, StreamImpl,
   * VoiceRelayImpl
   *
   * @return The actual instance
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  public static class Deserializer
      extends StdDeserializer<com.sinch.sdk.domains.voice.models.v2.destination.CallDestination> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(
        Class<com.sinch.sdk.domains.voice.models.v2.destination.CallDestination> vc) {
      super(vc);
    }

    @Override
    public com.sinch.sdk.domains.voice.models.v2.destination.CallDestination deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException {

      Object deserialized = jp.readValueAs(CallDestinationInternalImpl.class).getActualInstance();
      if (null == deserialized) {
        return null;
      }
      if (!(deserialized
          instanceof com.sinch.sdk.domains.voice.models.v2.destination.CallDestination)) {
        log.log(Level.SEVERE, "Input data does not match schema ", deserialized);
        return null;
      }

      return (com.sinch.sdk.domains.voice.models.v2.destination.CallDestination) deserialized;
    }
  }
}
