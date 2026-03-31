package com.sinch.sdk.domains.verification.models.v1.sinchevents.internal;

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
import com.sinch.sdk.domains.verification.models.v1.sinchevents.VerificationResultEventImpl;
import com.sinch.sdk.domains.verification.models.v1.sinchevents.VerificationSmsDeliveredEventImpl;
import com.sinch.sdk.domains.verification.models.v1.sinchevents.VerificationStartEventImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(
    using = VerificationEventInternalImpl.VerificationEventInternalImplDeserializer.class)
@JsonSerialize(using = VerificationEventInternalImpl.VerificationEventInternalImplSerializer.class)
public class VerificationEventInternalImpl extends AbstractOpenApiSchema
    implements VerificationEventInternal {
  private static final Logger log = Logger.getLogger(VerificationEventInternalImpl.class.getName());

  public static final class VerificationEventInternalImplSerializer
      extends StdSerializer<VerificationEventInternalImpl> {
    private static final long serialVersionUID = 1L;

    public VerificationEventInternalImplSerializer(Class<VerificationEventInternalImpl> t) {
      super(t);
    }

    public VerificationEventInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        VerificationEventInternalImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class VerificationEventInternalImplDeserializer
      extends StdDeserializer<VerificationEventInternalImpl> {

    private static final long serialVersionUID = 1L;

    public VerificationEventInternalImplDeserializer() {
      this(VerificationEventInternalImpl.class);
    }

    public VerificationEventInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public VerificationEventInternalImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      VerificationEventInternalImpl newVerificationEventInternalImpl =
          new VerificationEventInternalImpl();
      Map<String, Object> result2 =
          tree.traverse(jp.getCodec()).readValueAs(new TypeReference<Map<String, Object>>() {});
      String discriminatorValue = (String) result2.get("event");
      switch (discriminatorValue) {
        case "VerificationRequestEvent":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(VerificationStartEventImpl.class);
          newVerificationEventInternalImpl.setActualInstance(deserialized);
          return newVerificationEventInternalImpl;
        case "VerificationResultEvent":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationResultEventImpl.class);
          newVerificationEventInternalImpl.setActualInstance(deserialized);
          return newVerificationEventInternalImpl;
        case "VerificationSmsDeliveredEvent":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationSmsDeliveredEventImpl.class);
          newVerificationEventInternalImpl.setActualInstance(deserialized);
          return newVerificationEventInternalImpl;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for VerificationEventInternalImpl."
                      + " Possible values: VerificationRequestEvent VerificationResultEvent"
                      + " VerificationSmsDeliveredEvent",
                  discriminatorValue));
      }

      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
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

      // deserialize VerificationSmsDeliveredEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationSmsDeliveredEventImpl.class.equals(Integer.class)
            || VerificationSmsDeliveredEventImpl.class.equals(Long.class)
            || VerificationSmsDeliveredEventImpl.class.equals(Float.class)
            || VerificationSmsDeliveredEventImpl.class.equals(Double.class)
            || VerificationSmsDeliveredEventImpl.class.equals(Boolean.class)
            || VerificationSmsDeliveredEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationSmsDeliveredEventImpl.class.equals(Integer.class)
                        || VerificationSmsDeliveredEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationSmsDeliveredEventImpl.class.equals(Float.class)
                        || VerificationSmsDeliveredEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationSmsDeliveredEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationSmsDeliveredEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationSmsDeliveredEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'VerificationSmsDeliveredEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'VerificationSmsDeliveredEventImpl'", e);
      }

      // deserialize VerificationStartEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationStartEventImpl.class.equals(Integer.class)
            || VerificationStartEventImpl.class.equals(Long.class)
            || VerificationStartEventImpl.class.equals(Float.class)
            || VerificationStartEventImpl.class.equals(Double.class)
            || VerificationStartEventImpl.class.equals(Boolean.class)
            || VerificationStartEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationStartEventImpl.class.equals(Integer.class)
                        || VerificationStartEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationStartEventImpl.class.equals(Float.class)
                        || VerificationStartEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationStartEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationStartEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(VerificationStartEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'VerificationStartEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'VerificationStartEventImpl'", e);
      }

      if (match == 1) {
        VerificationEventInternalImpl ret = new VerificationEventInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for VerificationEventInternalImpl: %d classes match result,"
                  + " expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public VerificationEventInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(
          ctxt.getParser(), "VerificationEventInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public VerificationEventInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public VerificationEventInternalImpl(VerificationResultEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VerificationEventInternalImpl(VerificationSmsDeliveredEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VerificationEventInternalImpl(VerificationStartEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("VerificationResultEventImpl", VerificationResultEventImpl.class);
    schemas.put("VerificationSmsDeliveredEventImpl", VerificationSmsDeliveredEventImpl.class);
    schemas.put("VerificationStartEventImpl", VerificationStartEventImpl.class);
    JSONNavigator.registerDescendants(
        VerificationEventInternalImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("VerificationRequestEvent", VerificationStartEventImpl.class);
    mappings.put("VerificationResultEvent", VerificationResultEventImpl.class);
    mappings.put("VerificationSmsDeliveredEvent", VerificationSmsDeliveredEventImpl.class);
    mappings.put("VerificationEvent", VerificationEventInternalImpl.class);
    JSONNavigator.registerDiscriminator(VerificationEventInternalImpl.class, "event", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return VerificationEventInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: VerificationResultEventImpl,
   * VerificationSmsDeliveredEventImpl, VerificationStartEventImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        VerificationResultEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        VerificationSmsDeliveredEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        VerificationStartEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be VerificationResultEventImpl,"
            + " VerificationSmsDeliveredEventImpl, VerificationStartEventImpl");
  }

  /**
   * Get the actual instance, which can be the following: VerificationResultEventImpl,
   * VerificationSmsDeliveredEventImpl, VerificationStartEventImpl
   *
   * @return The actual instance (VerificationResultEventImpl, VerificationSmsDeliveredEventImpl,
   *     VerificationStartEventImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
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

  /**
   * Get the actual instance of `VerificationSmsDeliveredEventImpl`. If the actual instance is not
   * `VerificationSmsDeliveredEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VerificationSmsDeliveredEventImpl`
   * @throws ClassCastException if the instance is not `VerificationSmsDeliveredEventImpl`
   */
  public VerificationSmsDeliveredEventImpl getVerificationSmsDeliveredEventImpl()
      throws ClassCastException {
    return (VerificationSmsDeliveredEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `VerificationStartEventImpl`. If the actual instance is not
   * `VerificationStartEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VerificationStartEventImpl`
   * @throws ClassCastException if the instance is not `VerificationStartEventImpl`
   */
  public VerificationStartEventImpl getVerificationStartEventImpl() throws ClassCastException {
    return (VerificationStartEventImpl) super.getActualInstance();
  }
}
