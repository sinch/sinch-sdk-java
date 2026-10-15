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
import com.sinch.sdk.domains.voice.models.v2.destination.SipFromImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(using = CallOriginInternalImpl.CallOriginInternalImplDeserializer.class)
@JsonSerialize(using = CallOriginInternalImpl.CallOriginInternalImplSerializer.class)
public class CallOriginInternalImpl extends AbstractOpenApiSchema implements CallOriginInternal {
  private static final Logger log = Logger.getLogger(CallOriginInternalImpl.class.getName());

  public static final class CallOriginInternalImplSerializer
      extends StdSerializer<CallOriginInternalImpl> {
    private static final long serialVersionUID = 1L;

    public CallOriginInternalImplSerializer(Class<CallOriginInternalImpl> t) {
      super(t);
    }

    public CallOriginInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        CallOriginInternalImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class CallOriginInternalImplDeserializer
      extends StdDeserializer<CallOriginInternalImpl> {

    private static final long serialVersionUID = 1L;

    public CallOriginInternalImplDeserializer() {
      this(CallOriginInternalImpl.class);
    }

    public CallOriginInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public CallOriginInternalImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      JsonNode discriminator = tree.get("type");
      String discriminatorValue = null != discriminator ? discriminator.asText() : null;
      Class<?> cls = null != discriminatorValue ? mappings.get(discriminatorValue) : null;
      if (null == cls) {
        throw new IOException(
            String.format(
                "Failed deserialization for CallOriginInternalImpl: unknown 'type' value '%s'."
                    + " Possible values: %s",
                discriminatorValue, mappings.keySet()));
      }
      Object deserialized = tree.traverse(jp.getCodec()).readValueAs(cls);
      CallOriginInternalImpl ret = new CallOriginInternalImpl();
      ret.setActualInstance(deserialized);
      return ret;
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public CallOriginInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "CallOriginInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  // discriminator value -> class
  private static final Map<String, Class<?>> mappings = new HashMap<>();

  public CallOriginInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  static {
    schemas.put("PhoneImpl", PhoneImpl.class);
    schemas.put("SipFromImpl", SipFromImpl.class);
    JSONNavigator.registerDescendants(
        CallOriginInternalImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    mappings.put("PHONE", PhoneImpl.class);
    mappings.put("SIP", SipFromImpl.class);
    JSONNavigator.registerDiscriminator(CallOriginInternalImpl.class, "type", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return CallOriginInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: PhoneImpl, SipFromImpl
   */
  @Override
  public void setActualInstance(Object instance) {
    for (Class<?> schema : schemas.values()) {
      if (JSONNavigator.isInstanceOf(schema, instance, new HashSet<Class<?>>())) {
        super.setActualInstance(instance);
        return;
      }
    }
    throw new RuntimeException("Invalid instance type. Must be PhoneImpl, SipFromImpl");
  }

  /**
   * Get the actual instance, which can be the following: PhoneImpl, SipFromImpl
   *
   * @return The actual instance
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  public static class Deserializer
      extends StdDeserializer<com.sinch.sdk.domains.voice.models.v2.destination.CallOrigin> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<com.sinch.sdk.domains.voice.models.v2.destination.CallOrigin> vc) {
      super(vc);
    }

    @Override
    public com.sinch.sdk.domains.voice.models.v2.destination.CallOrigin deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException {

      Object deserialized = jp.readValueAs(CallOriginInternalImpl.class).getActualInstance();
      if (null == deserialized) {
        return null;
      }
      if (!(deserialized instanceof com.sinch.sdk.domains.voice.models.v2.destination.CallOrigin)) {
        log.log(Level.SEVERE, "Input data does not match schema ", deserialized);
        return null;
      }

      return (com.sinch.sdk.domains.voice.models.v2.destination.CallOrigin) deserialized;
    }
  }
}
