package com.sinch.sdk.domains.voice.models.v1.destination.internal;

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
import com.sinch.sdk.domains.voice.models.v1.destination.DestinationDidImpl;
import com.sinch.sdk.domains.voice.models.v1.destination.DestinationMxpImpl;
import com.sinch.sdk.domains.voice.models.v1.destination.DestinationPstnImpl;
import com.sinch.sdk.domains.voice.models.v1.destination.DestinationSipImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(using = DestinationInternalImpl.DestinationInternalImplDeserializer.class)
@JsonSerialize(using = DestinationInternalImpl.DestinationInternalImplSerializer.class)
public class DestinationInternalImpl extends AbstractOpenApiSchema implements DestinationInternal {
  private static final Logger log = Logger.getLogger(DestinationInternalImpl.class.getName());

  public static final class DestinationInternalImplSerializer
      extends StdSerializer<DestinationInternalImpl> {
    private static final long serialVersionUID = 1L;

    public DestinationInternalImplSerializer(Class<DestinationInternalImpl> t) {
      super(t);
    }

    public DestinationInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        DestinationInternalImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class DestinationInternalImplDeserializer
      extends StdDeserializer<DestinationInternalImpl> {

    private static final long serialVersionUID = 1L;

    public DestinationInternalImplDeserializer() {
      this(DestinationInternalImpl.class);
    }

    public DestinationInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public DestinationInternalImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      DestinationInternalImpl newDestinationInternalImpl = new DestinationInternalImpl();
      Map<String, Object> result2 =
          tree.traverse(jp.getCodec()).readValueAs(new TypeReference<Map<String, Object>>() {});
      String discriminatorValue = (String) result2.get("type");
      switch (discriminatorValue) {
        case "Number":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(DestinationPstnImpl.class);
          newDestinationInternalImpl.setActualInstance(deserialized);
          return newDestinationInternalImpl;
        case "Username":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(DestinationMxpImpl.class);
          newDestinationInternalImpl.setActualInstance(deserialized);
          return newDestinationInternalImpl;
        case "did":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(DestinationDidImpl.class);
          newDestinationInternalImpl.setActualInstance(deserialized);
          return newDestinationInternalImpl;
        case "number":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(DestinationPstnImpl.class);
          newDestinationInternalImpl.setActualInstance(deserialized);
          return newDestinationInternalImpl;
        case "sip":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(DestinationSipImpl.class);
          newDestinationInternalImpl.setActualInstance(deserialized);
          return newDestinationInternalImpl;
        case "username":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(DestinationMxpImpl.class);
          newDestinationInternalImpl.setActualInstance(deserialized);
          return newDestinationInternalImpl;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for DestinationInternalImpl. Possible"
                      + " values: Number Username did number sip username",
                  discriminatorValue));
      }

      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize DestinationDidImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (DestinationDidImpl.class.equals(Integer.class)
            || DestinationDidImpl.class.equals(Long.class)
            || DestinationDidImpl.class.equals(Float.class)
            || DestinationDidImpl.class.equals(Double.class)
            || DestinationDidImpl.class.equals(Boolean.class)
            || DestinationDidImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((DestinationDidImpl.class.equals(Integer.class)
                        || DestinationDidImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((DestinationDidImpl.class.equals(Float.class)
                        || DestinationDidImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (DestinationDidImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (DestinationDidImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(DestinationDidImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'DestinationDidImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'DestinationDidImpl'", e);
      }

      // deserialize DestinationMxpImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (DestinationMxpImpl.class.equals(Integer.class)
            || DestinationMxpImpl.class.equals(Long.class)
            || DestinationMxpImpl.class.equals(Float.class)
            || DestinationMxpImpl.class.equals(Double.class)
            || DestinationMxpImpl.class.equals(Boolean.class)
            || DestinationMxpImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((DestinationMxpImpl.class.equals(Integer.class)
                        || DestinationMxpImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((DestinationMxpImpl.class.equals(Float.class)
                        || DestinationMxpImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (DestinationMxpImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (DestinationMxpImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(DestinationMxpImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'DestinationMxpImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'DestinationMxpImpl'", e);
      }

      // deserialize DestinationPstnImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (DestinationPstnImpl.class.equals(Integer.class)
            || DestinationPstnImpl.class.equals(Long.class)
            || DestinationPstnImpl.class.equals(Float.class)
            || DestinationPstnImpl.class.equals(Double.class)
            || DestinationPstnImpl.class.equals(Boolean.class)
            || DestinationPstnImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((DestinationPstnImpl.class.equals(Integer.class)
                        || DestinationPstnImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((DestinationPstnImpl.class.equals(Float.class)
                        || DestinationPstnImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (DestinationPstnImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (DestinationPstnImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(DestinationPstnImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'DestinationPstnImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'DestinationPstnImpl'", e);
      }

      // deserialize DestinationSipImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (DestinationSipImpl.class.equals(Integer.class)
            || DestinationSipImpl.class.equals(Long.class)
            || DestinationSipImpl.class.equals(Float.class)
            || DestinationSipImpl.class.equals(Double.class)
            || DestinationSipImpl.class.equals(Boolean.class)
            || DestinationSipImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((DestinationSipImpl.class.equals(Integer.class)
                        || DestinationSipImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((DestinationSipImpl.class.equals(Float.class)
                        || DestinationSipImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (DestinationSipImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (DestinationSipImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(DestinationSipImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'DestinationSipImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'DestinationSipImpl'", e);
      }

      if (match == 1) {
        DestinationInternalImpl ret = new DestinationInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for DestinationInternalImpl: %d classes match result,"
                  + " expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public DestinationInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "DestinationInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public DestinationInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public DestinationInternalImpl(DestinationDidImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public DestinationInternalImpl(DestinationMxpImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public DestinationInternalImpl(DestinationPstnImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public DestinationInternalImpl(DestinationSipImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("DestinationDidImpl", DestinationDidImpl.class);
    schemas.put("DestinationMxpImpl", DestinationMxpImpl.class);
    schemas.put("DestinationPstnImpl", DestinationPstnImpl.class);
    schemas.put("DestinationSipImpl", DestinationSipImpl.class);
    JSONNavigator.registerDescendants(
        DestinationInternalImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("Number", DestinationPstnImpl.class);
    mappings.put("Username", DestinationMxpImpl.class);
    mappings.put("did", DestinationDidImpl.class);
    mappings.put("number", DestinationPstnImpl.class);
    mappings.put("sip", DestinationSipImpl.class);
    mappings.put("username", DestinationMxpImpl.class);
    mappings.put("destination", DestinationInternalImpl.class);
    JSONNavigator.registerDiscriminator(DestinationInternalImpl.class, "type", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return DestinationInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: DestinationDidImpl, DestinationMxpImpl, DestinationPstnImpl,
   * DestinationSipImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(DestinationDidImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(DestinationMxpImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(DestinationPstnImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(DestinationSipImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be DestinationDidImpl, DestinationMxpImpl,"
            + " DestinationPstnImpl, DestinationSipImpl");
  }

  /**
   * Get the actual instance, which can be the following: DestinationDidImpl, DestinationMxpImpl,
   * DestinationPstnImpl, DestinationSipImpl
   *
   * @return The actual instance (DestinationDidImpl, DestinationMxpImpl, DestinationPstnImpl,
   *     DestinationSipImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `DestinationDidImpl`. If the actual instance is not
   * `DestinationDidImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `DestinationDidImpl`
   * @throws ClassCastException if the instance is not `DestinationDidImpl`
   */
  public DestinationDidImpl getDestinationDidImpl() throws ClassCastException {
    return (DestinationDidImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `DestinationMxpImpl`. If the actual instance is not
   * `DestinationMxpImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `DestinationMxpImpl`
   * @throws ClassCastException if the instance is not `DestinationMxpImpl`
   */
  public DestinationMxpImpl getDestinationMxpImpl() throws ClassCastException {
    return (DestinationMxpImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `DestinationPstnImpl`. If the actual instance is not
   * `DestinationPstnImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `DestinationPstnImpl`
   * @throws ClassCastException if the instance is not `DestinationPstnImpl`
   */
  public DestinationPstnImpl getDestinationPstnImpl() throws ClassCastException {
    return (DestinationPstnImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `DestinationSipImpl`. If the actual instance is not
   * `DestinationSipImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `DestinationSipImpl`
   * @throws ClassCastException if the instance is not `DestinationSipImpl`
   */
  public DestinationSipImpl getDestinationSipImpl() throws ClassCastException {
    return (DestinationSipImpl) super.getActualInstance();
  }
}
