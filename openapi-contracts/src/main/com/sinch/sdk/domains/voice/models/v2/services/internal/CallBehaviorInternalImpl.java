package com.sinch.sdk.domains.voice.models.v2.services.internal;

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
import com.sinch.sdk.domains.voice.models.v2.services.EventDestinationCallBehaviorImpl;
import com.sinch.sdk.domains.voice.models.v2.services.NoneCallBehaviorImpl;
import com.sinch.sdk.domains.voice.models.v2.services.StaticCallBehaviorImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(using = CallBehaviorInternalImpl.CallBehaviorInternalImplDeserializer.class)
@JsonSerialize(using = CallBehaviorInternalImpl.CallBehaviorInternalImplSerializer.class)
public class CallBehaviorInternalImpl extends AbstractOpenApiSchema
    implements CallBehaviorInternal {
  private static final Logger log = Logger.getLogger(CallBehaviorInternalImpl.class.getName());

  public static final class CallBehaviorInternalImplSerializer
      extends StdSerializer<CallBehaviorInternalImpl> {
    private static final long serialVersionUID = 1L;

    public CallBehaviorInternalImplSerializer(Class<CallBehaviorInternalImpl> t) {
      super(t);
    }

    public CallBehaviorInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        CallBehaviorInternalImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class CallBehaviorInternalImplDeserializer
      extends StdDeserializer<CallBehaviorInternalImpl> {

    private static final long serialVersionUID = 1L;

    public CallBehaviorInternalImplDeserializer() {
      this(CallBehaviorInternalImpl.class);
    }

    public CallBehaviorInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public CallBehaviorInternalImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      JsonNode discriminator = tree.get("type");
      String discriminatorValue = null != discriminator ? discriminator.asText() : null;
      Class<?> cls = null != discriminatorValue ? mappings.get(discriminatorValue) : null;
      if (null == cls) {
        throw new IOException(
            String.format(
                "Failed deserialization for CallBehaviorInternalImpl: unknown 'type' value '%s'."
                    + " Possible values: %s",
                discriminatorValue, mappings.keySet()));
      }
      Object deserialized = tree.traverse(jp.getCodec()).readValueAs(cls);
      CallBehaviorInternalImpl ret = new CallBehaviorInternalImpl();
      ret.setActualInstance(deserialized);
      return ret;
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public CallBehaviorInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "CallBehaviorInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  // discriminator value -> class
  private static final Map<String, Class<?>> mappings = new HashMap<>();

  public CallBehaviorInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  static {
    schemas.put("NoneCallBehaviorImpl", NoneCallBehaviorImpl.class);
    schemas.put("EventDestinationCallBehaviorImpl", EventDestinationCallBehaviorImpl.class);
    schemas.put("StaticCallBehaviorImpl", StaticCallBehaviorImpl.class);
    JSONNavigator.registerDescendants(
        CallBehaviorInternalImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    mappings.put("NONE", NoneCallBehaviorImpl.class);
    mappings.put("WEBHOOK", EventDestinationCallBehaviorImpl.class);
    mappings.put("STATIC", StaticCallBehaviorImpl.class);
    JSONNavigator.registerDiscriminator(CallBehaviorInternalImpl.class, "type", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return CallBehaviorInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: NoneCallBehaviorImpl, EventDestinationCallBehaviorImpl,
   * StaticCallBehaviorImpl
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
        "Invalid instance type. Must be NoneCallBehaviorImpl, EventDestinationCallBehaviorImpl,"
            + " StaticCallBehaviorImpl");
  }

  /**
   * Get the actual instance, which can be the following: NoneCallBehaviorImpl,
   * EventDestinationCallBehaviorImpl, StaticCallBehaviorImpl
   *
   * @return The actual instance
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  public static class Deserializer
      extends StdDeserializer<com.sinch.sdk.domains.voice.models.v2.services.CallBehavior> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<com.sinch.sdk.domains.voice.models.v2.services.CallBehavior> vc) {
      super(vc);
    }

    @Override
    public com.sinch.sdk.domains.voice.models.v2.services.CallBehavior deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException {

      Object deserialized = jp.readValueAs(CallBehaviorInternalImpl.class).getActualInstance();
      if (null == deserialized) {
        return null;
      }
      if (!(deserialized instanceof com.sinch.sdk.domains.voice.models.v2.services.CallBehavior)) {
        log.log(Level.SEVERE, "Input data does not match schema ", deserialized);
        return null;
      }

      return (com.sinch.sdk.domains.voice.models.v2.services.CallBehavior) deserialized;
    }
  }
}
