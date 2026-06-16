package com.sinch.sdk.domains.voice.models.v1.calls.request;

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
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionContinueImpl;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionHangupImpl;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionParkImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(using = SvamlActionPatchImpl.SvamlActionPatchImplDeserializer.class)
@JsonSerialize(using = SvamlActionPatchImpl.SvamlActionPatchImplSerializer.class)
public class SvamlActionPatchImpl extends AbstractOpenApiSchema implements SvamlActionPatch {
  private static final Logger log = Logger.getLogger(SvamlActionPatchImpl.class.getName());

  public static final class SvamlActionPatchImplSerializer
      extends StdSerializer<SvamlActionPatchImpl> {
    private static final long serialVersionUID = 1L;

    public SvamlActionPatchImplSerializer(Class<SvamlActionPatchImpl> t) {
      super(t);
    }

    public SvamlActionPatchImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        SvamlActionPatchImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class SvamlActionPatchImplDeserializer
      extends StdDeserializer<SvamlActionPatchImpl> {

    private static final long serialVersionUID = 1L;

    public SvamlActionPatchImplDeserializer() {
      this(SvamlActionPatchImpl.class);
    }

    public SvamlActionPatchImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public SvamlActionPatchImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      SvamlActionPatchImpl newSvamlActionPatchImpl = new SvamlActionPatchImpl();
      Map<String, Object> result2 =
          tree.traverse(jp.getCodec()).readValueAs(new TypeReference<Map<String, Object>>() {});
      String discriminatorValue = (String) result2.get("name");
      switch (discriminatorValue) {
        case "continue":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(SvamlActionContinueImpl.class);
          newSvamlActionPatchImpl.setActualInstance(deserialized);
          return newSvamlActionPatchImpl;
        case "hangup":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(SvamlActionHangupImpl.class);
          newSvamlActionPatchImpl.setActualInstance(deserialized);
          return newSvamlActionPatchImpl;
        case "park":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(SvamlActionParkImpl.class);
          newSvamlActionPatchImpl.setActualInstance(deserialized);
          return newSvamlActionPatchImpl;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for SvamlActionPatchImpl. Possible"
                      + " values: continue hangup park",
                  discriminatorValue));
      }

      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize SvamlActionContinueImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (SvamlActionContinueImpl.class.equals(Integer.class)
            || SvamlActionContinueImpl.class.equals(Long.class)
            || SvamlActionContinueImpl.class.equals(Float.class)
            || SvamlActionContinueImpl.class.equals(Double.class)
            || SvamlActionContinueImpl.class.equals(Boolean.class)
            || SvamlActionContinueImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((SvamlActionContinueImpl.class.equals(Integer.class)
                        || SvamlActionContinueImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((SvamlActionContinueImpl.class.equals(Float.class)
                        || SvamlActionContinueImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (SvamlActionContinueImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (SvamlActionContinueImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(SvamlActionContinueImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'SvamlActionContinueImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'SvamlActionContinueImpl'", e);
      }

      // deserialize SvamlActionHangupImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (SvamlActionHangupImpl.class.equals(Integer.class)
            || SvamlActionHangupImpl.class.equals(Long.class)
            || SvamlActionHangupImpl.class.equals(Float.class)
            || SvamlActionHangupImpl.class.equals(Double.class)
            || SvamlActionHangupImpl.class.equals(Boolean.class)
            || SvamlActionHangupImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((SvamlActionHangupImpl.class.equals(Integer.class)
                        || SvamlActionHangupImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((SvamlActionHangupImpl.class.equals(Float.class)
                        || SvamlActionHangupImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (SvamlActionHangupImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (SvamlActionHangupImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(SvamlActionHangupImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'SvamlActionHangupImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'SvamlActionHangupImpl'", e);
      }

      // deserialize SvamlActionParkImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (SvamlActionParkImpl.class.equals(Integer.class)
            || SvamlActionParkImpl.class.equals(Long.class)
            || SvamlActionParkImpl.class.equals(Float.class)
            || SvamlActionParkImpl.class.equals(Double.class)
            || SvamlActionParkImpl.class.equals(Boolean.class)
            || SvamlActionParkImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((SvamlActionParkImpl.class.equals(Integer.class)
                        || SvamlActionParkImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((SvamlActionParkImpl.class.equals(Float.class)
                        || SvamlActionParkImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (SvamlActionParkImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (SvamlActionParkImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(SvamlActionParkImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'SvamlActionParkImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'SvamlActionParkImpl'", e);
      }

      if (match == 1) {
        SvamlActionPatchImpl ret = new SvamlActionPatchImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for SvamlActionPatchImpl: %d classes match result, expected"
                  + " 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public SvamlActionPatchImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "SvamlActionPatchImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public SvamlActionPatchImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public SvamlActionPatchImpl(SvamlActionContinueImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public SvamlActionPatchImpl(SvamlActionHangupImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public SvamlActionPatchImpl(SvamlActionParkImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("SvamlActionContinueImpl", SvamlActionContinueImpl.class);
    schemas.put("SvamlActionHangupImpl", SvamlActionHangupImpl.class);
    schemas.put("SvamlActionParkImpl", SvamlActionParkImpl.class);
    JSONNavigator.registerDescendants(
        SvamlActionPatchImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("continue", SvamlActionContinueImpl.class);
    mappings.put("hangup", SvamlActionHangupImpl.class);
    mappings.put("park", SvamlActionParkImpl.class);
    mappings.put("svaml.action.patch", SvamlActionPatchImpl.class);
    JSONNavigator.registerDiscriminator(SvamlActionPatchImpl.class, "name", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return SvamlActionPatchImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: SvamlActionContinueImpl, SvamlActionHangupImpl,
   * SvamlActionParkImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        SvamlActionContinueImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        SvamlActionHangupImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(SvamlActionParkImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be SvamlActionContinueImpl, SvamlActionHangupImpl,"
            + " SvamlActionParkImpl");
  }

  /**
   * Get the actual instance, which can be the following: SvamlActionContinueImpl,
   * SvamlActionHangupImpl, SvamlActionParkImpl
   *
   * @return The actual instance (SvamlActionContinueImpl, SvamlActionHangupImpl,
   *     SvamlActionParkImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `SvamlActionContinueImpl`. If the actual instance is not
   * `SvamlActionContinueImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SvamlActionContinueImpl`
   * @throws ClassCastException if the instance is not `SvamlActionContinueImpl`
   */
  public SvamlActionContinueImpl getSvamlActionContinueImpl() throws ClassCastException {
    return (SvamlActionContinueImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `SvamlActionHangupImpl`. If the actual instance is not
   * `SvamlActionHangupImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SvamlActionHangupImpl`
   * @throws ClassCastException if the instance is not `SvamlActionHangupImpl`
   */
  public SvamlActionHangupImpl getSvamlActionHangupImpl() throws ClassCastException {
    return (SvamlActionHangupImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `SvamlActionParkImpl`. If the actual instance is not
   * `SvamlActionParkImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SvamlActionParkImpl`
   * @throws ClassCastException if the instance is not `SvamlActionParkImpl`
   */
  public SvamlActionParkImpl getSvamlActionParkImpl() throws ClassCastException {
    return (SvamlActionParkImpl) super.getActualInstance();
  }
}
