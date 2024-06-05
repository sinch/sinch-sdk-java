package com.sinch.sdk.domains.verification.models.v1.report.request.internal;

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
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersFlashCallImpl;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersPhoneCallImpl;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersSmsImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(
    using =
        VerificationReportRequestParametersInternalImpl
            .VerificationReportRequestParametersInternalImplDeserializer.class)
@JsonSerialize(
    using =
        VerificationReportRequestParametersInternalImpl
            .VerificationReportRequestParametersInternalImplSerializer.class)
public class VerificationReportRequestParametersInternalImpl extends AbstractOpenApiSchema
    implements VerificationReportRequestParametersInternal {
  private static final Logger log =
      Logger.getLogger(VerificationReportRequestParametersInternalImpl.class.getName());

  public static final class VerificationReportRequestParametersInternalImplSerializer
      extends StdSerializer<VerificationReportRequestParametersInternalImpl> {
    private static final long serialVersionUID = 1L;

    public VerificationReportRequestParametersInternalImplSerializer(
        Class<VerificationReportRequestParametersInternalImpl> t) {
      super(t);
    }

    public VerificationReportRequestParametersInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        VerificationReportRequestParametersInternalImpl value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class VerificationReportRequestParametersInternalImplDeserializer
      extends StdDeserializer<VerificationReportRequestParametersInternalImpl> {

    private static final long serialVersionUID = 1L;

    public VerificationReportRequestParametersInternalImplDeserializer() {
      this(VerificationReportRequestParametersInternalImpl.class);
    }

    public VerificationReportRequestParametersInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public VerificationReportRequestParametersInternalImpl deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      VerificationReportRequestParametersInternalImpl
          newVerificationReportRequestParametersInternalImpl =
              new VerificationReportRequestParametersInternalImpl();
      Map<String, Object> result2 =
          tree.traverse(jp.getCodec()).readValueAs(new TypeReference<Map<String, Object>>() {});
      String discriminatorValue = (String) result2.get("method");
      switch (discriminatorValue) {
        case "callout":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationReportRequestParametersPhoneCallImpl.class);
          newVerificationReportRequestParametersInternalImpl.setActualInstance(deserialized);
          return newVerificationReportRequestParametersInternalImpl;
        case "flashcall":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationReportRequestParametersFlashCallImpl.class);
          newVerificationReportRequestParametersInternalImpl.setActualInstance(deserialized);
          return newVerificationReportRequestParametersInternalImpl;
        case "sms":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationReportRequestParametersSmsImpl.class);
          newVerificationReportRequestParametersInternalImpl.setActualInstance(deserialized);
          return newVerificationReportRequestParametersInternalImpl;
        case "FlashCallVerificationReportRequest":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationReportRequestParametersFlashCallImpl.class);
          newVerificationReportRequestParametersInternalImpl.setActualInstance(deserialized);
          return newVerificationReportRequestParametersInternalImpl;
        case "PhoneCallVerificationReportRequest":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationReportRequestParametersPhoneCallImpl.class);
          newVerificationReportRequestParametersInternalImpl.setActualInstance(deserialized);
          return newVerificationReportRequestParametersInternalImpl;
        case "SmsVerificationReportRequest":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationReportRequestParametersSmsImpl.class);
          newVerificationReportRequestParametersInternalImpl.setActualInstance(deserialized);
          return newVerificationReportRequestParametersInternalImpl;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for"
                      + " VerificationReportRequestParametersInternalImpl. Possible values: callout"
                      + " flashcall sms FlashCallVerificationReportRequest"
                      + " PhoneCallVerificationReportRequest SmsVerificationReportRequest",
                  discriminatorValue));
      }

      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize VerificationReportRequestParametersFlashCallImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationReportRequestParametersFlashCallImpl.class.equals(Integer.class)
            || VerificationReportRequestParametersFlashCallImpl.class.equals(Long.class)
            || VerificationReportRequestParametersFlashCallImpl.class.equals(Float.class)
            || VerificationReportRequestParametersFlashCallImpl.class.equals(Double.class)
            || VerificationReportRequestParametersFlashCallImpl.class.equals(Boolean.class)
            || VerificationReportRequestParametersFlashCallImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationReportRequestParametersFlashCallImpl.class.equals(Integer.class)
                        || VerificationReportRequestParametersFlashCallImpl.class.equals(
                            Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationReportRequestParametersFlashCallImpl.class.equals(Float.class)
                        || VerificationReportRequestParametersFlashCallImpl.class.equals(
                            Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationReportRequestParametersFlashCallImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationReportRequestParametersFlashCallImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationReportRequestParametersFlashCallImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER,
              "Input data matches schema 'VerificationReportRequestParametersFlashCallImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'VerificationReportRequestParametersFlashCallImpl'",
            e);
      }

      // deserialize VerificationReportRequestParametersPhoneCallImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationReportRequestParametersPhoneCallImpl.class.equals(Integer.class)
            || VerificationReportRequestParametersPhoneCallImpl.class.equals(Long.class)
            || VerificationReportRequestParametersPhoneCallImpl.class.equals(Float.class)
            || VerificationReportRequestParametersPhoneCallImpl.class.equals(Double.class)
            || VerificationReportRequestParametersPhoneCallImpl.class.equals(Boolean.class)
            || VerificationReportRequestParametersPhoneCallImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationReportRequestParametersPhoneCallImpl.class.equals(Integer.class)
                        || VerificationReportRequestParametersPhoneCallImpl.class.equals(
                            Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationReportRequestParametersPhoneCallImpl.class.equals(Float.class)
                        || VerificationReportRequestParametersPhoneCallImpl.class.equals(
                            Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationReportRequestParametersPhoneCallImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationReportRequestParametersPhoneCallImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationReportRequestParametersPhoneCallImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER,
              "Input data matches schema 'VerificationReportRequestParametersPhoneCallImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'VerificationReportRequestParametersPhoneCallImpl'",
            e);
      }

      // deserialize VerificationReportRequestParametersSmsImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationReportRequestParametersSmsImpl.class.equals(Integer.class)
            || VerificationReportRequestParametersSmsImpl.class.equals(Long.class)
            || VerificationReportRequestParametersSmsImpl.class.equals(Float.class)
            || VerificationReportRequestParametersSmsImpl.class.equals(Double.class)
            || VerificationReportRequestParametersSmsImpl.class.equals(Boolean.class)
            || VerificationReportRequestParametersSmsImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationReportRequestParametersSmsImpl.class.equals(Integer.class)
                        || VerificationReportRequestParametersSmsImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationReportRequestParametersSmsImpl.class.equals(Float.class)
                        || VerificationReportRequestParametersSmsImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationReportRequestParametersSmsImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationReportRequestParametersSmsImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationReportRequestParametersSmsImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER,
              "Input data matches schema 'VerificationReportRequestParametersSmsImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'VerificationReportRequestParametersSmsImpl'",
            e);
      }

      if (match == 1) {
        VerificationReportRequestParametersInternalImpl ret =
            new VerificationReportRequestParametersInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for VerificationReportRequestParametersInternalImpl: %d"
                  + " classes match result, expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public VerificationReportRequestParametersInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(
          ctxt.getParser(), "VerificationReportRequestParametersInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public VerificationReportRequestParametersInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public VerificationReportRequestParametersInternalImpl(
      VerificationReportRequestParametersFlashCallImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VerificationReportRequestParametersInternalImpl(
      VerificationReportRequestParametersPhoneCallImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VerificationReportRequestParametersInternalImpl(
      VerificationReportRequestParametersSmsImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put(
        "VerificationReportRequestParametersFlashCallImpl",
        VerificationReportRequestParametersFlashCallImpl.class);
    schemas.put(
        "VerificationReportRequestParametersPhoneCallImpl",
        VerificationReportRequestParametersPhoneCallImpl.class);
    schemas.put(
        "VerificationReportRequestParametersSmsImpl",
        VerificationReportRequestParametersSmsImpl.class);
    JSONNavigator.registerDescendants(
        VerificationReportRequestParametersInternalImpl.class,
        Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("callout", VerificationReportRequestParametersPhoneCallImpl.class);
    mappings.put("flashcall", VerificationReportRequestParametersFlashCallImpl.class);
    mappings.put("sms", VerificationReportRequestParametersSmsImpl.class);
    mappings.put(
        "FlashCallVerificationReportRequest",
        VerificationReportRequestParametersFlashCallImpl.class);
    mappings.put(
        "PhoneCallVerificationReportRequest",
        VerificationReportRequestParametersPhoneCallImpl.class);
    mappings.put("SmsVerificationReportRequest", VerificationReportRequestParametersSmsImpl.class);
    mappings.put(
        "VerificationReportRequestResource", VerificationReportRequestParametersInternalImpl.class);
    JSONNavigator.registerDiscriminator(
        VerificationReportRequestParametersInternalImpl.class, "method", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return VerificationReportRequestParametersInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: VerificationReportRequestParametersFlashCallImpl,
   * VerificationReportRequestParametersPhoneCallImpl, VerificationReportRequestParametersSmsImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        VerificationReportRequestParametersFlashCallImpl.class,
        instance,
        new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        VerificationReportRequestParametersPhoneCallImpl.class,
        instance,
        new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        VerificationReportRequestParametersSmsImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be VerificationReportRequestParametersFlashCallImpl,"
            + " VerificationReportRequestParametersPhoneCallImpl,"
            + " VerificationReportRequestParametersSmsImpl");
  }

  /**
   * Get the actual instance, which can be the following:
   * VerificationReportRequestParametersFlashCallImpl,
   * VerificationReportRequestParametersPhoneCallImpl, VerificationReportRequestParametersSmsImpl
   *
   * @return The actual instance (VerificationReportRequestParametersFlashCallImpl,
   *     VerificationReportRequestParametersPhoneCallImpl,
   *     VerificationReportRequestParametersSmsImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `VerificationReportRequestParametersFlashCallImpl`. If the actual
   * instance is not `VerificationReportRequestParametersFlashCallImpl`, the ClassCastException will
   * be thrown.
   *
   * @return The actual instance of `VerificationReportRequestParametersFlashCallImpl`
   * @throws ClassCastException if the instance is not
   *     `VerificationReportRequestParametersFlashCallImpl`
   */
  public VerificationReportRequestParametersFlashCallImpl
      getVerificationReportRequestParametersFlashCallImpl() throws ClassCastException {
    return (VerificationReportRequestParametersFlashCallImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `VerificationReportRequestParametersPhoneCallImpl`. If the actual
   * instance is not `VerificationReportRequestParametersPhoneCallImpl`, the ClassCastException will
   * be thrown.
   *
   * @return The actual instance of `VerificationReportRequestParametersPhoneCallImpl`
   * @throws ClassCastException if the instance is not
   *     `VerificationReportRequestParametersPhoneCallImpl`
   */
  public VerificationReportRequestParametersPhoneCallImpl
      getVerificationReportRequestParametersPhoneCallImpl() throws ClassCastException {
    return (VerificationReportRequestParametersPhoneCallImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `VerificationReportRequestParametersSmsImpl`. If the actual instance
   * is not `VerificationReportRequestParametersSmsImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VerificationReportRequestParametersSmsImpl`
   * @throws ClassCastException if the instance is not `VerificationReportRequestParametersSmsImpl`
   */
  public VerificationReportRequestParametersSmsImpl getVerificationReportRequestParametersSmsImpl()
      throws ClassCastException {
    return (VerificationReportRequestParametersSmsImpl) super.getActualInstance();
  }
}
