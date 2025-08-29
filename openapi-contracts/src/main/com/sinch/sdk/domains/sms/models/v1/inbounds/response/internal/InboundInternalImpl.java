package com.sinch.sdk.domains.sms.models.v1.inbounds.response.internal;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sinch.sdk.core.models.AbstractOpenApiSchema;
import com.sinch.sdk.core.utils.databind.JSONNavigator;
import com.sinch.sdk.domains.sms.models.v1.inbounds.BinaryMessageImpl;
import com.sinch.sdk.domains.sms.models.v1.inbounds.MediaMessageImpl;
import com.sinch.sdk.domains.sms.models.v1.inbounds.TextMessageImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(using = InboundInternalImpl.InboundInternalImplDeserializer.class)
@JsonSerialize(using = InboundInternalImpl.InboundInternalImplSerializer.class)
public class InboundInternalImpl extends AbstractOpenApiSchema implements InboundInternal {
  private static final Logger log = Logger.getLogger(InboundInternalImpl.class.getName());

  public static final class InboundInternalImplSerializer
      extends StdSerializer<InboundInternalImpl> {
    private static final long serialVersionUID = 1L;

    public InboundInternalImplSerializer(Class<InboundInternalImpl> t) {
      super(t);
    }

    public InboundInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        InboundInternalImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class InboundInternalImplDeserializer
      extends StdDeserializer<InboundInternalImpl> {

    private static final long serialVersionUID = 1L;

    public InboundInternalImplDeserializer() {
      this(InboundInternalImpl.class);
    }

    public InboundInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public InboundInternalImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      InboundInternalImpl newInboundInternalImpl = new InboundInternalImpl();
      Map<String, Object> result2 =
          tree.traverse(jp.getCodec()).readValueAs(new TypeReference<Map<String, Object>>() {});
      String discriminatorValue = (String) result2.get("type");
      switch (discriminatorValue) {
        case "mo_binary":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(BinaryMessageImpl.class);
          newInboundInternalImpl.setActualInstance(deserialized);
          return newInboundInternalImpl;
        case "mo_media":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(MediaMessageImpl.class);
          newInboundInternalImpl.setActualInstance(deserialized);
          return newInboundInternalImpl;
        case "mo_text":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(TextMessageImpl.class);
          newInboundInternalImpl.setActualInstance(deserialized);
          return newInboundInternalImpl;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for InboundInternalImpl. Possible"
                      + " values: mo_binary mo_media mo_text",
                  discriminatorValue));
      }

      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize BinaryMessageImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (BinaryMessageImpl.class.equals(Integer.class)
            || BinaryMessageImpl.class.equals(Long.class)
            || BinaryMessageImpl.class.equals(Float.class)
            || BinaryMessageImpl.class.equals(Double.class)
            || BinaryMessageImpl.class.equals(Boolean.class)
            || BinaryMessageImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((BinaryMessageImpl.class.equals(Integer.class)
                        || BinaryMessageImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((BinaryMessageImpl.class.equals(Float.class)
                        || BinaryMessageImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (BinaryMessageImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (BinaryMessageImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(BinaryMessageImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'BinaryMessageImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'BinaryMessageImpl'", e);
      }

      // deserialize MediaMessageImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (MediaMessageImpl.class.equals(Integer.class)
            || MediaMessageImpl.class.equals(Long.class)
            || MediaMessageImpl.class.equals(Float.class)
            || MediaMessageImpl.class.equals(Double.class)
            || MediaMessageImpl.class.equals(Boolean.class)
            || MediaMessageImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((MediaMessageImpl.class.equals(Integer.class)
                        || MediaMessageImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((MediaMessageImpl.class.equals(Float.class)
                        || MediaMessageImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (MediaMessageImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (MediaMessageImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(MediaMessageImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'MediaMessageImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'MediaMessageImpl'", e);
      }

      // deserialize TextMessageImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (TextMessageImpl.class.equals(Integer.class)
            || TextMessageImpl.class.equals(Long.class)
            || TextMessageImpl.class.equals(Float.class)
            || TextMessageImpl.class.equals(Double.class)
            || TextMessageImpl.class.equals(Boolean.class)
            || TextMessageImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((TextMessageImpl.class.equals(Integer.class)
                        || TextMessageImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((TextMessageImpl.class.equals(Float.class)
                        || TextMessageImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (TextMessageImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (TextMessageImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(TextMessageImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'TextMessageImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'TextMessageImpl'", e);
      }

      if (match == 1) {
        InboundInternalImpl ret = new InboundInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for InboundInternalImpl: %d classes match result, expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public InboundInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "InboundInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public InboundInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public InboundInternalImpl(BinaryMessageImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public InboundInternalImpl(MediaMessageImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public InboundInternalImpl(TextMessageImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("BinaryMessageImpl", BinaryMessageImpl.class);
    schemas.put("MediaMessageImpl", MediaMessageImpl.class);
    schemas.put("TextMessageImpl", TextMessageImpl.class);
    JSONNavigator.registerDescendants(
        InboundInternalImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("mo_binary", BinaryMessageImpl.class);
    mappings.put("mo_media", MediaMessageImpl.class);
    mappings.put("mo_text", TextMessageImpl.class);
    mappings.put("inbound", InboundInternalImpl.class);
    JSONNavigator.registerDiscriminator(InboundInternalImpl.class, "type", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return InboundInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: BinaryMessageImpl, MediaMessageImpl, TextMessageImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(BinaryMessageImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(MediaMessageImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(TextMessageImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be BinaryMessageImpl, MediaMessageImpl, TextMessageImpl");
  }

  /**
   * Get the actual instance, which can be the following: BinaryMessageImpl, MediaMessageImpl,
   * TextMessageImpl
   *
   * @return The actual instance (BinaryMessageImpl, MediaMessageImpl, TextMessageImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `BinaryMessageImpl`. If the actual instance is not
   * `BinaryMessageImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `BinaryMessageImpl`
   * @throws ClassCastException if the instance is not `BinaryMessageImpl`
   */
  public BinaryMessageImpl getBinaryMessageImpl() throws ClassCastException {
    return (BinaryMessageImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `MediaMessageImpl`. If the actual instance is not
   * `MediaMessageImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `MediaMessageImpl`
   * @throws ClassCastException if the instance is not `MediaMessageImpl`
   */
  public MediaMessageImpl getMediaMessageImpl() throws ClassCastException {
    return (MediaMessageImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `TextMessageImpl`. If the actual instance is not `TextMessageImpl`,
   * the ClassCastException will be thrown.
   *
   * @return The actual instance of `TextMessageImpl`
   * @throws ClassCastException if the instance is not `TextMessageImpl`
   */
  public TextMessageImpl getTextMessageImpl() throws ClassCastException {
    return (TextMessageImpl) super.getActualInstance();
  }

  public static class Deserializer
      extends StdDeserializer<com.sinch.sdk.domains.sms.models.v1.inbounds.InboundMessage> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<com.sinch.sdk.domains.sms.models.v1.inbounds.InboundMessage> vc) {
      super(vc);
    }

    @Override
    public com.sinch.sdk.domains.sms.models.v1.inbounds.InboundMessage deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException {

      Object deserialized = jp.readValueAs(InboundInternalImpl.class).getActualInstance();
      if (null == deserialized) {
        return null;
      }
      if (!(deserialized instanceof com.sinch.sdk.domains.sms.models.v1.inbounds.InboundMessage)) {
        log.log(Level.SEVERE, "Input data does not match schema ", deserialized);
        return null;
      }

      return (com.sinch.sdk.domains.sms.models.v1.inbounds.InboundMessage) deserialized;
    }
  }
}
