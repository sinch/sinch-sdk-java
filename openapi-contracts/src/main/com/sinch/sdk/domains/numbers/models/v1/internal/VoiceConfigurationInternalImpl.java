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
import com.sinch.sdk.domains.numbers.models.v1.VoiceConfigurationESTImpl;
import com.sinch.sdk.domains.numbers.models.v1.VoiceConfigurationFAXImpl;
import com.sinch.sdk.domains.numbers.models.v1.VoiceConfigurationRTCImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(
    using = VoiceConfigurationInternalImpl.VoiceConfigurationInternalImplDeserializer.class)
@JsonSerialize(
    using = VoiceConfigurationInternalImpl.VoiceConfigurationInternalImplSerializer.class)
public class VoiceConfigurationInternalImpl extends AbstractOpenApiSchema
    implements VoiceConfigurationInternal {
  private static final Logger log =
      Logger.getLogger(VoiceConfigurationInternalImpl.class.getName());

  public static final class VoiceConfigurationInternalImplSerializer
      extends StdSerializer<VoiceConfigurationInternalImpl> {
    private static final long serialVersionUID = 1L;

    public VoiceConfigurationInternalImplSerializer(Class<VoiceConfigurationInternalImpl> t) {
      super(t);
    }

    public VoiceConfigurationInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        VoiceConfigurationInternalImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class VoiceConfigurationInternalImplDeserializer
      extends StdDeserializer<VoiceConfigurationInternalImpl> {

    private static final long serialVersionUID = 1L;

    public VoiceConfigurationInternalImplDeserializer() {
      this(VoiceConfigurationInternalImpl.class);
    }

    public VoiceConfigurationInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public VoiceConfigurationInternalImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      VoiceConfigurationInternalImpl newVoiceConfigurationInternalImpl =
          new VoiceConfigurationInternalImpl();
      Map<String, Object> result2 =
          tree.traverse(jp.getCodec()).readValueAs(new TypeReference<Map<String, Object>>() {});
      String discriminatorValue = (String) result2.get("type");
      switch (discriminatorValue) {
        case "EST":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(VoiceConfigurationESTImpl.class);
          newVoiceConfigurationInternalImpl.setActualInstance(deserialized);
          return newVoiceConfigurationInternalImpl;
        case "FAX":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(VoiceConfigurationFAXImpl.class);
          newVoiceConfigurationInternalImpl.setActualInstance(deserialized);
          return newVoiceConfigurationInternalImpl;
        case "RTC":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(VoiceConfigurationRTCImpl.class);
          newVoiceConfigurationInternalImpl.setActualInstance(deserialized);
          return newVoiceConfigurationInternalImpl;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for VoiceConfigurationInternalImpl."
                      + " Possible values: EST FAX RTC",
                  discriminatorValue));
      }

      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize VoiceConfigurationESTImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VoiceConfigurationESTImpl.class.equals(Integer.class)
            || VoiceConfigurationESTImpl.class.equals(Long.class)
            || VoiceConfigurationESTImpl.class.equals(Float.class)
            || VoiceConfigurationESTImpl.class.equals(Double.class)
            || VoiceConfigurationESTImpl.class.equals(Boolean.class)
            || VoiceConfigurationESTImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VoiceConfigurationESTImpl.class.equals(Integer.class)
                        || VoiceConfigurationESTImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VoiceConfigurationESTImpl.class.equals(Float.class)
                        || VoiceConfigurationESTImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VoiceConfigurationESTImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VoiceConfigurationESTImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(VoiceConfigurationESTImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'VoiceConfigurationESTImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'VoiceConfigurationESTImpl'", e);
      }

      // deserialize VoiceConfigurationFAXImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VoiceConfigurationFAXImpl.class.equals(Integer.class)
            || VoiceConfigurationFAXImpl.class.equals(Long.class)
            || VoiceConfigurationFAXImpl.class.equals(Float.class)
            || VoiceConfigurationFAXImpl.class.equals(Double.class)
            || VoiceConfigurationFAXImpl.class.equals(Boolean.class)
            || VoiceConfigurationFAXImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VoiceConfigurationFAXImpl.class.equals(Integer.class)
                        || VoiceConfigurationFAXImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VoiceConfigurationFAXImpl.class.equals(Float.class)
                        || VoiceConfigurationFAXImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VoiceConfigurationFAXImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VoiceConfigurationFAXImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(VoiceConfigurationFAXImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'VoiceConfigurationFAXImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'VoiceConfigurationFAXImpl'", e);
      }

      // deserialize VoiceConfigurationRTCImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VoiceConfigurationRTCImpl.class.equals(Integer.class)
            || VoiceConfigurationRTCImpl.class.equals(Long.class)
            || VoiceConfigurationRTCImpl.class.equals(Float.class)
            || VoiceConfigurationRTCImpl.class.equals(Double.class)
            || VoiceConfigurationRTCImpl.class.equals(Boolean.class)
            || VoiceConfigurationRTCImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VoiceConfigurationRTCImpl.class.equals(Integer.class)
                        || VoiceConfigurationRTCImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VoiceConfigurationRTCImpl.class.equals(Float.class)
                        || VoiceConfigurationRTCImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VoiceConfigurationRTCImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VoiceConfigurationRTCImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(VoiceConfigurationRTCImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'VoiceConfigurationRTCImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'VoiceConfigurationRTCImpl'", e);
      }

      if (match == 1) {
        VoiceConfigurationInternalImpl ret = new VoiceConfigurationInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for VoiceConfigurationInternalImpl: %d classes match result,"
                  + " expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public VoiceConfigurationInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(
          ctxt.getParser(), "VoiceConfigurationInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public VoiceConfigurationInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public VoiceConfigurationInternalImpl(VoiceConfigurationESTImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VoiceConfigurationInternalImpl(VoiceConfigurationFAXImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VoiceConfigurationInternalImpl(VoiceConfigurationRTCImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("VoiceConfigurationESTImpl", VoiceConfigurationESTImpl.class);
    schemas.put("VoiceConfigurationFAXImpl", VoiceConfigurationFAXImpl.class);
    schemas.put("VoiceConfigurationRTCImpl", VoiceConfigurationRTCImpl.class);
    JSONNavigator.registerDescendants(
        VoiceConfigurationInternalImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("EST", VoiceConfigurationESTImpl.class);
    mappings.put("FAX", VoiceConfigurationFAXImpl.class);
    mappings.put("RTC", VoiceConfigurationRTCImpl.class);
    mappings.put("VoiceConfiguration", VoiceConfigurationInternalImpl.class);
    JSONNavigator.registerDiscriminator(VoiceConfigurationInternalImpl.class, "type", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return VoiceConfigurationInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: VoiceConfigurationESTImpl, VoiceConfigurationFAXImpl,
   * VoiceConfigurationRTCImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        VoiceConfigurationESTImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        VoiceConfigurationFAXImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        VoiceConfigurationRTCImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be VoiceConfigurationESTImpl, VoiceConfigurationFAXImpl,"
            + " VoiceConfigurationRTCImpl");
  }

  /**
   * Get the actual instance, which can be the following: VoiceConfigurationESTImpl,
   * VoiceConfigurationFAXImpl, VoiceConfigurationRTCImpl
   *
   * @return The actual instance (VoiceConfigurationESTImpl, VoiceConfigurationFAXImpl,
   *     VoiceConfigurationRTCImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `VoiceConfigurationESTImpl`. If the actual instance is not
   * `VoiceConfigurationESTImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VoiceConfigurationESTImpl`
   * @throws ClassCastException if the instance is not `VoiceConfigurationESTImpl`
   */
  public VoiceConfigurationESTImpl getVoiceConfigurationESTImpl() throws ClassCastException {
    return (VoiceConfigurationESTImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `VoiceConfigurationFAXImpl`. If the actual instance is not
   * `VoiceConfigurationFAXImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VoiceConfigurationFAXImpl`
   * @throws ClassCastException if the instance is not `VoiceConfigurationFAXImpl`
   */
  public VoiceConfigurationFAXImpl getVoiceConfigurationFAXImpl() throws ClassCastException {
    return (VoiceConfigurationFAXImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `VoiceConfigurationRTCImpl`. If the actual instance is not
   * `VoiceConfigurationRTCImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VoiceConfigurationRTCImpl`
   * @throws ClassCastException if the instance is not `VoiceConfigurationRTCImpl`
   */
  public VoiceConfigurationRTCImpl getVoiceConfigurationRTCImpl() throws ClassCastException {
    return (VoiceConfigurationRTCImpl) super.getActualInstance();
  }
}
