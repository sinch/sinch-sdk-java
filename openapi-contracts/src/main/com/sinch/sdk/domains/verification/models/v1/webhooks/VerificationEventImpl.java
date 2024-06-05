package com.sinch.sdk.domains.verification.models.v1.webhooks;

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
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(using = VerificationEventImpl.VerificationEventImplDeserializer.class)
@JsonSerialize(using = VerificationEventImpl.VerificationEventImplSerializer.class)
public class VerificationEventImpl extends AbstractOpenApiSchema implements VerificationEvent {
  private static final Logger log = Logger.getLogger(VerificationEventImpl.class.getName());

  public static final class VerificationEventImplSerializer
      extends StdSerializer<VerificationEventImpl> {
    private static final long serialVersionUID = 1L;

    public VerificationEventImplSerializer(Class<VerificationEventImpl> t) {
      super(t);
    }

    public VerificationEventImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        VerificationEventImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class VerificationEventImplDeserializer
      extends StdDeserializer<VerificationEventImpl> {

    private static final long serialVersionUID = 1L;

    public VerificationEventImplDeserializer() {
      this(VerificationEventImpl.class);
    }

    public VerificationEventImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public VerificationEventImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      VerificationEventImpl newVerificationEventImpl = new VerificationEventImpl();
      Map<String, Object> result2 =
          tree.traverse(jp.getCodec()).readValueAs(new TypeReference<Map<String, Object>>() {});
      String discriminatorValue = (String) result2.get("event");
      switch (discriminatorValue) {
        case "VerificationRequestEvent":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationRequestEventImpl.class);
          newVerificationEventImpl.setActualInstance(deserialized);
          return newVerificationEventImpl;
        case "VerificationResultEvent":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationResultEventImpl.class);
          newVerificationEventImpl.setActualInstance(deserialized);
          return newVerificationEventImpl;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for VerificationEventImpl. Possible"
                      + " values: VerificationRequestEvent VerificationResultEvent",
                  discriminatorValue));
      }

      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize VerificationRequestEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationRequestEventImpl.class.equals(Integer.class)
            || VerificationRequestEventImpl.class.equals(Long.class)
            || VerificationRequestEventImpl.class.equals(Float.class)
            || VerificationRequestEventImpl.class.equals(Double.class)
            || VerificationRequestEventImpl.class.equals(Boolean.class)
            || VerificationRequestEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationRequestEventImpl.class.equals(Integer.class)
                        || VerificationRequestEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationRequestEventImpl.class.equals(Float.class)
                        || VerificationRequestEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationRequestEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationRequestEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationRequestEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'VerificationRequestEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'VerificationRequestEventImpl'", e);
      }

      // deserialize VerificationResultEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationResultEventImpl.class.equals(Integer.class)
            || VerificationResultEventImpl.class.equals(Long.class)
            || VerificationResultEventImpl.class.equals(Float.class)
            || VerificationResultEventImpl.class.equals(Double.class)
            || VerificationResultEventImpl.class.equals(Boolean.class)
            || VerificationResultEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationResultEventImpl.class.equals(Integer.class)
                        || VerificationResultEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationResultEventImpl.class.equals(Float.class)
                        || VerificationResultEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationResultEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationResultEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationResultEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'VerificationResultEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'VerificationResultEventImpl'", e);
      }

      if (match == 1) {
        VerificationEventImpl ret = new VerificationEventImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for VerificationEventImpl: %d classes match result, expected"
                  + " 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public VerificationEventImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "VerificationEventImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public VerificationEventImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public VerificationEventImpl(VerificationRequestEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VerificationEventImpl(VerificationResultEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("VerificationRequestEventImpl", VerificationRequestEventImpl.class);
    schemas.put("VerificationResultEventImpl", VerificationResultEventImpl.class);
    JSONNavigator.registerDescendants(
        VerificationEventImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("VerificationRequestEvent", VerificationRequestEventImpl.class);
    mappings.put("VerificationResultEvent", VerificationResultEventImpl.class);
    mappings.put("VerificationEvent", VerificationEventImpl.class);
    JSONNavigator.registerDiscriminator(VerificationEventImpl.class, "event", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return VerificationEventImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: VerificationRequestEventImpl, VerificationResultEventImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        VerificationRequestEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        VerificationResultEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be VerificationRequestEventImpl, VerificationResultEventImpl");
  }

  /**
   * Get the actual instance, which can be the following: VerificationRequestEventImpl,
   * VerificationResultEventImpl
   *
   * @return The actual instance (VerificationRequestEventImpl, VerificationResultEventImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `VerificationRequestEventImpl`. If the actual instance is not
   * `VerificationRequestEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VerificationRequestEventImpl`
   * @throws ClassCastException if the instance is not `VerificationRequestEventImpl`
   */
  public VerificationRequestEventImpl getVerificationRequestEventImpl() throws ClassCastException {
    return (VerificationRequestEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `VerificationResultEventImpl`. If the actual instance is not
   * `VerificationResultEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VerificationResultEventImpl`
   * @throws ClassCastException if the instance is not `VerificationResultEventImpl`
   */
  public VerificationResultEventImpl getVerificationResultEventImpl() throws ClassCastException {
    return (VerificationResultEventImpl) super.getActualInstance();
  }
}
