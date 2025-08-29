package com.sinch.sdk.domains.numbers.models.v1.internal;

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
import com.sinch.sdk.domains.numbers.models.v1.ScheduledVoiceProvisioningESTImpl;
import com.sinch.sdk.domains.numbers.models.v1.ScheduledVoiceProvisioningFAXImpl;
import com.sinch.sdk.domains.numbers.models.v1.ScheduledVoiceProvisioningRTCImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(
    using =
        ScheduledVoiceProvisioningInternalImpl.ScheduledVoiceProvisioningInternalImplDeserializer
            .class)
@JsonSerialize(
    using =
        ScheduledVoiceProvisioningInternalImpl.ScheduledVoiceProvisioningInternalImplSerializer
            .class)
public class ScheduledVoiceProvisioningInternalImpl extends AbstractOpenApiSchema
    implements ScheduledVoiceProvisioningInternal {
  private static final Logger log =
      Logger.getLogger(ScheduledVoiceProvisioningInternalImpl.class.getName());

  public static final class ScheduledVoiceProvisioningInternalImplSerializer
      extends StdSerializer<ScheduledVoiceProvisioningInternalImpl> {
    private static final long serialVersionUID = 1L;

    public ScheduledVoiceProvisioningInternalImplSerializer(
        Class<ScheduledVoiceProvisioningInternalImpl> t) {
      super(t);
    }

    public ScheduledVoiceProvisioningInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        ScheduledVoiceProvisioningInternalImpl value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class ScheduledVoiceProvisioningInternalImplDeserializer
      extends StdDeserializer<ScheduledVoiceProvisioningInternalImpl> {

    private static final long serialVersionUID = 1L;

    public ScheduledVoiceProvisioningInternalImplDeserializer() {
      this(ScheduledVoiceProvisioningInternalImpl.class);
    }

    public ScheduledVoiceProvisioningInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public ScheduledVoiceProvisioningInternalImpl deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      ScheduledVoiceProvisioningInternalImpl newScheduledVoiceProvisioningInternalImpl =
          new ScheduledVoiceProvisioningInternalImpl();
      Map<String, Object> result2 =
          tree.traverse(jp.getCodec()).readValueAs(new TypeReference<Map<String, Object>>() {});
      String discriminatorValue = (String) result2.get("type");
      switch (discriminatorValue) {
        case "EST":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(ScheduledVoiceProvisioningESTImpl.class);
          newScheduledVoiceProvisioningInternalImpl.setActualInstance(deserialized);
          return newScheduledVoiceProvisioningInternalImpl;
        case "FAX":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(ScheduledVoiceProvisioningFAXImpl.class);
          newScheduledVoiceProvisioningInternalImpl.setActualInstance(deserialized);
          return newScheduledVoiceProvisioningInternalImpl;
        case "RTC":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(ScheduledVoiceProvisioningRTCImpl.class);
          newScheduledVoiceProvisioningInternalImpl.setActualInstance(deserialized);
          return newScheduledVoiceProvisioningInternalImpl;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for"
                      + " ScheduledVoiceProvisioningInternalImpl. Possible values: EST FAX RTC",
                  discriminatorValue));
      }

      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize ScheduledVoiceProvisioningESTImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ScheduledVoiceProvisioningESTImpl.class.equals(Integer.class)
            || ScheduledVoiceProvisioningESTImpl.class.equals(Long.class)
            || ScheduledVoiceProvisioningESTImpl.class.equals(Float.class)
            || ScheduledVoiceProvisioningESTImpl.class.equals(Double.class)
            || ScheduledVoiceProvisioningESTImpl.class.equals(Boolean.class)
            || ScheduledVoiceProvisioningESTImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ScheduledVoiceProvisioningESTImpl.class.equals(Integer.class)
                        || ScheduledVoiceProvisioningESTImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ScheduledVoiceProvisioningESTImpl.class.equals(Float.class)
                        || ScheduledVoiceProvisioningESTImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ScheduledVoiceProvisioningESTImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ScheduledVoiceProvisioningESTImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(ScheduledVoiceProvisioningESTImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ScheduledVoiceProvisioningESTImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'ScheduledVoiceProvisioningESTImpl'", e);
      }

      // deserialize ScheduledVoiceProvisioningFAXImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ScheduledVoiceProvisioningFAXImpl.class.equals(Integer.class)
            || ScheduledVoiceProvisioningFAXImpl.class.equals(Long.class)
            || ScheduledVoiceProvisioningFAXImpl.class.equals(Float.class)
            || ScheduledVoiceProvisioningFAXImpl.class.equals(Double.class)
            || ScheduledVoiceProvisioningFAXImpl.class.equals(Boolean.class)
            || ScheduledVoiceProvisioningFAXImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ScheduledVoiceProvisioningFAXImpl.class.equals(Integer.class)
                        || ScheduledVoiceProvisioningFAXImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ScheduledVoiceProvisioningFAXImpl.class.equals(Float.class)
                        || ScheduledVoiceProvisioningFAXImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ScheduledVoiceProvisioningFAXImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ScheduledVoiceProvisioningFAXImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(ScheduledVoiceProvisioningFAXImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ScheduledVoiceProvisioningFAXImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'ScheduledVoiceProvisioningFAXImpl'", e);
      }

      // deserialize ScheduledVoiceProvisioningRTCImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ScheduledVoiceProvisioningRTCImpl.class.equals(Integer.class)
            || ScheduledVoiceProvisioningRTCImpl.class.equals(Long.class)
            || ScheduledVoiceProvisioningRTCImpl.class.equals(Float.class)
            || ScheduledVoiceProvisioningRTCImpl.class.equals(Double.class)
            || ScheduledVoiceProvisioningRTCImpl.class.equals(Boolean.class)
            || ScheduledVoiceProvisioningRTCImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ScheduledVoiceProvisioningRTCImpl.class.equals(Integer.class)
                        || ScheduledVoiceProvisioningRTCImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ScheduledVoiceProvisioningRTCImpl.class.equals(Float.class)
                        || ScheduledVoiceProvisioningRTCImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ScheduledVoiceProvisioningRTCImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ScheduledVoiceProvisioningRTCImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(ScheduledVoiceProvisioningRTCImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ScheduledVoiceProvisioningRTCImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'ScheduledVoiceProvisioningRTCImpl'", e);
      }

      if (match == 1) {
        ScheduledVoiceProvisioningInternalImpl ret = new ScheduledVoiceProvisioningInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for ScheduledVoiceProvisioningInternalImpl: %d classes match"
                  + " result, expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public ScheduledVoiceProvisioningInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(
          ctxt.getParser(), "ScheduledVoiceProvisioningInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public ScheduledVoiceProvisioningInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public ScheduledVoiceProvisioningInternalImpl(ScheduledVoiceProvisioningESTImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ScheduledVoiceProvisioningInternalImpl(ScheduledVoiceProvisioningFAXImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ScheduledVoiceProvisioningInternalImpl(ScheduledVoiceProvisioningRTCImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("ScheduledVoiceProvisioningESTImpl", ScheduledVoiceProvisioningESTImpl.class);
    schemas.put("ScheduledVoiceProvisioningFAXImpl", ScheduledVoiceProvisioningFAXImpl.class);
    schemas.put("ScheduledVoiceProvisioningRTCImpl", ScheduledVoiceProvisioningRTCImpl.class);
    JSONNavigator.registerDescendants(
        ScheduledVoiceProvisioningInternalImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("EST", ScheduledVoiceProvisioningESTImpl.class);
    mappings.put("FAX", ScheduledVoiceProvisioningFAXImpl.class);
    mappings.put("RTC", ScheduledVoiceProvisioningRTCImpl.class);
    mappings.put("ScheduledVoiceProvisioning", ScheduledVoiceProvisioningInternalImpl.class);
    JSONNavigator.registerDiscriminator(
        ScheduledVoiceProvisioningInternalImpl.class, "type", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return ScheduledVoiceProvisioningInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: ScheduledVoiceProvisioningESTImpl,
   * ScheduledVoiceProvisioningFAXImpl, ScheduledVoiceProvisioningRTCImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        ScheduledVoiceProvisioningESTImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        ScheduledVoiceProvisioningFAXImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        ScheduledVoiceProvisioningRTCImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be ScheduledVoiceProvisioningESTImpl,"
            + " ScheduledVoiceProvisioningFAXImpl, ScheduledVoiceProvisioningRTCImpl");
  }

  /**
   * Get the actual instance, which can be the following: ScheduledVoiceProvisioningESTImpl,
   * ScheduledVoiceProvisioningFAXImpl, ScheduledVoiceProvisioningRTCImpl
   *
   * @return The actual instance (ScheduledVoiceProvisioningESTImpl,
   *     ScheduledVoiceProvisioningFAXImpl, ScheduledVoiceProvisioningRTCImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `ScheduledVoiceProvisioningESTImpl`. If the actual instance is not
   * `ScheduledVoiceProvisioningESTImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ScheduledVoiceProvisioningESTImpl`
   * @throws ClassCastException if the instance is not `ScheduledVoiceProvisioningESTImpl`
   */
  public ScheduledVoiceProvisioningESTImpl getScheduledVoiceProvisioningESTImpl()
      throws ClassCastException {
    return (ScheduledVoiceProvisioningESTImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `ScheduledVoiceProvisioningFAXImpl`. If the actual instance is not
   * `ScheduledVoiceProvisioningFAXImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ScheduledVoiceProvisioningFAXImpl`
   * @throws ClassCastException if the instance is not `ScheduledVoiceProvisioningFAXImpl`
   */
  public ScheduledVoiceProvisioningFAXImpl getScheduledVoiceProvisioningFAXImpl()
      throws ClassCastException {
    return (ScheduledVoiceProvisioningFAXImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `ScheduledVoiceProvisioningRTCImpl`. If the actual instance is not
   * `ScheduledVoiceProvisioningRTCImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ScheduledVoiceProvisioningRTCImpl`
   * @throws ClassCastException if the instance is not `ScheduledVoiceProvisioningRTCImpl`
   */
  public ScheduledVoiceProvisioningRTCImpl getScheduledVoiceProvisioningRTCImpl()
      throws ClassCastException {
    return (ScheduledVoiceProvisioningRTCImpl) super.getActualInstance();
  }
}
