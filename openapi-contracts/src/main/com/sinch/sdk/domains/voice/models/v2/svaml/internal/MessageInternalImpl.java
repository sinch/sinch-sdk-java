package com.sinch.sdk.domains.voice.models.v2.svaml.internal;

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
import com.sinch.sdk.domains.voice.models.v2.svaml.PlayMessageImpl;
import com.sinch.sdk.domains.voice.models.v2.svaml.SayMessageImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(using = MessageInternalImpl.MessageInternalImplDeserializer.class)
@JsonSerialize(using = MessageInternalImpl.MessageInternalImplSerializer.class)
public class MessageInternalImpl extends AbstractOpenApiSchema implements MessageInternal {
  private static final Logger log = Logger.getLogger(MessageInternalImpl.class.getName());

  public static final class MessageInternalImplSerializer
      extends StdSerializer<MessageInternalImpl> {
    private static final long serialVersionUID = 1L;

    public MessageInternalImplSerializer(Class<MessageInternalImpl> t) {
      super(t);
    }

    public MessageInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        MessageInternalImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class MessageInternalImplDeserializer
      extends StdDeserializer<MessageInternalImpl> {

    private static final long serialVersionUID = 1L;

    public MessageInternalImplDeserializer() {
      this(MessageInternalImpl.class);
    }

    public MessageInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public MessageInternalImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      JsonNode discriminator = tree.get("type");
      String discriminatorValue = null != discriminator ? discriminator.asText() : null;
      Class<?> cls = null != discriminatorValue ? mappings.get(discriminatorValue) : null;
      if (null == cls) {
        throw new IOException(
            String.format(
                "Failed deserialization for MessageInternalImpl: unknown 'type' value '%s'."
                    + " Possible values: %s",
                discriminatorValue, mappings.keySet()));
      }
      Object deserialized = tree.traverse(jp.getCodec()).readValueAs(cls);
      MessageInternalImpl ret = new MessageInternalImpl();
      ret.setActualInstance(deserialized);
      return ret;
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public MessageInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "MessageInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  // discriminator value -> class
  private static final Map<String, Class<?>> mappings = new HashMap<>();

  public MessageInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  static {
    schemas.put("PlayMessageImpl", PlayMessageImpl.class);
    schemas.put("SayMessageImpl", SayMessageImpl.class);
    JSONNavigator.registerDescendants(
        MessageInternalImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    mappings.put("PLAY", PlayMessageImpl.class);
    mappings.put("SAY", SayMessageImpl.class);
    JSONNavigator.registerDiscriminator(MessageInternalImpl.class, "type", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return MessageInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: PlayMessageImpl, SayMessageImpl
   */
  @Override
  public void setActualInstance(Object instance) {
    for (Class<?> schema : schemas.values()) {
      if (JSONNavigator.isInstanceOf(schema, instance, new HashSet<Class<?>>())) {
        super.setActualInstance(instance);
        return;
      }
    }
    throw new RuntimeException("Invalid instance type. Must be PlayMessageImpl, SayMessageImpl");
  }

  /**
   * Get the actual instance, which can be the following: PlayMessageImpl, SayMessageImpl
   *
   * @return The actual instance
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  public static class Deserializer
      extends StdDeserializer<com.sinch.sdk.domains.voice.models.v2.svaml.Message> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<com.sinch.sdk.domains.voice.models.v2.svaml.Message> vc) {
      super(vc);
    }

    @Override
    public com.sinch.sdk.domains.voice.models.v2.svaml.Message deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException {

      Object deserialized = jp.readValueAs(MessageInternalImpl.class).getActualInstance();
      if (null == deserialized) {
        return null;
      }
      if (!(deserialized instanceof com.sinch.sdk.domains.voice.models.v2.svaml.Message)) {
        log.log(Level.SEVERE, "Input data does not match schema ", deserialized);
        return null;
      }

      return (com.sinch.sdk.domains.voice.models.v2.svaml.Message) deserialized;
    }
  }
}
