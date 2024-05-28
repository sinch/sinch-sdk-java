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
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersCalloutImpl;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersFlashCallImpl;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersSMSImpl;
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
                  .readValueAs(VerificationReportRequestParametersCalloutImpl.class);
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
                  .readValueAs(VerificationReportRequestParametersSMSImpl.class);
          newVerificationReportRequestParametersInternalImpl.setActualInstance(deserialized);
          return newVerificationReportRequestParametersInternalImpl;
        case "CalloutVerificationReportRequest":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationReportRequestParametersCalloutImpl.class);
          newVerificationReportRequestParametersInternalImpl.setActualInstance(deserialized);
          return newVerificationReportRequestParametersInternalImpl;
        case "FlashcallVerificationReportRequest":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationReportRequestParametersFlashCallImpl.class);
          newVerificationReportRequestParametersInternalImpl.setActualInstance(deserialized);
          return newVerificationReportRequestParametersInternalImpl;
        case "SmsVerificationReportRequest":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationReportRequestParametersSMSImpl.class);
          newVerificationReportRequestParametersInternalImpl.setActualInstance(deserialized);
          return newVerificationReportRequestParametersInternalImpl;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for"
                      + " VerificationReportRequestParametersInternalImpl. Possible values: callout"
                      + " flashcall sms CalloutVerificationReportRequest"
                      + " FlashcallVerificationReportRequest SmsVerificationReportRequest",
                  discriminatorValue));
      }

      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize VerificationReportRequestParametersCalloutImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationReportRequestParametersCalloutImpl.class.equals(Integer.class)
            || VerificationReportRequestParametersCalloutImpl.class.equals(Long.class)
            || VerificationReportRequestParametersCalloutImpl.class.equals(Float.class)
            || VerificationReportRequestParametersCalloutImpl.class.equals(Double.class)
            || VerificationReportRequestParametersCalloutImpl.class.equals(Boolean.class)
            || VerificationReportRequestParametersCalloutImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationReportRequestParametersCalloutImpl.class.equals(Integer.class)
                        || VerificationReportRequestParametersCalloutImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationReportRequestParametersCalloutImpl.class.equals(Float.class)
                        || VerificationReportRequestParametersCalloutImpl.class.equals(
                            Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationReportRequestParametersCalloutImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationReportRequestParametersCalloutImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationReportRequestParametersCalloutImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER,
              "Input data matches schema 'VerificationReportRequestParametersCalloutImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'VerificationReportRequestParametersCalloutImpl'",
            e);
      }

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

      // deserialize VerificationReportRequestParametersSMSImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationReportRequestParametersSMSImpl.class.equals(Integer.class)
            || VerificationReportRequestParametersSMSImpl.class.equals(Long.class)
            || VerificationReportRequestParametersSMSImpl.class.equals(Float.class)
            || VerificationReportRequestParametersSMSImpl.class.equals(Double.class)
            || VerificationReportRequestParametersSMSImpl.class.equals(Boolean.class)
            || VerificationReportRequestParametersSMSImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationReportRequestParametersSMSImpl.class.equals(Integer.class)
                        || VerificationReportRequestParametersSMSImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationReportRequestParametersSMSImpl.class.equals(Float.class)
                        || VerificationReportRequestParametersSMSImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationReportRequestParametersSMSImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationReportRequestParametersSMSImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationReportRequestParametersSMSImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER,
              "Input data matches schema 'VerificationReportRequestParametersSMSImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'VerificationReportRequestParametersSMSImpl'",
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
      VerificationReportRequestParametersCalloutImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VerificationReportRequestParametersInternalImpl(
      VerificationReportRequestParametersFlashCallImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VerificationReportRequestParametersInternalImpl(
      VerificationReportRequestParametersSMSImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put(
        "VerificationReportRequestParametersCalloutImpl",
        VerificationReportRequestParametersCalloutImpl.class);
    schemas.put(
        "VerificationReportRequestParametersFlashCallImpl",
        VerificationReportRequestParametersFlashCallImpl.class);
    schemas.put(
        "VerificationReportRequestParametersSMSImpl",
        VerificationReportRequestParametersSMSImpl.class);
    JSONNavigator.registerDescendants(
        VerificationReportRequestParametersInternalImpl.class,
        Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("callout", VerificationReportRequestParametersCalloutImpl.class);
    mappings.put("flashcall", VerificationReportRequestParametersFlashCallImpl.class);
    mappings.put("sms", VerificationReportRequestParametersSMSImpl.class);
    mappings.put(
        "CalloutVerificationReportRequest", VerificationReportRequestParametersCalloutImpl.class);
    mappings.put(
        "FlashcallVerificationReportRequest",
        VerificationReportRequestParametersFlashCallImpl.class);
    mappings.put("SmsVerificationReportRequest", VerificationReportRequestParametersSMSImpl.class);
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
   * against the oneOf child schemas: VerificationReportRequestParametersCalloutImpl,
   * VerificationReportRequestParametersFlashCallImpl, VerificationReportRequestParametersSMSImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        VerificationReportRequestParametersCalloutImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        VerificationReportRequestParametersFlashCallImpl.class,
        instance,
        new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        VerificationReportRequestParametersSMSImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be VerificationReportRequestParametersCalloutImpl,"
            + " VerificationReportRequestParametersFlashCallImpl,"
            + " VerificationReportRequestParametersSMSImpl");
  }

  /**
   * Get the actual instance, which can be the following:
   * VerificationReportRequestParametersCalloutImpl,
   * VerificationReportRequestParametersFlashCallImpl, VerificationReportRequestParametersSMSImpl
   *
   * @return The actual instance (VerificationReportRequestParametersCalloutImpl,
   *     VerificationReportRequestParametersFlashCallImpl,
   *     VerificationReportRequestParametersSMSImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `VerificationReportRequestParametersCalloutImpl`. If the actual
   * instance is not `VerificationReportRequestParametersCalloutImpl`, the ClassCastException will
   * be thrown.
   *
   * @return The actual instance of `VerificationReportRequestParametersCalloutImpl`
   * @throws ClassCastException if the instance is not
   *     `VerificationReportRequestParametersCalloutImpl`
   */
  public VerificationReportRequestParametersCalloutImpl
      getVerificationReportRequestParametersCalloutImpl() throws ClassCastException {
    return (VerificationReportRequestParametersCalloutImpl) super.getActualInstance();
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
   * Get the actual instance of `VerificationReportRequestParametersSMSImpl`. If the actual instance
   * is not `VerificationReportRequestParametersSMSImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VerificationReportRequestParametersSMSImpl`
   * @throws ClassCastException if the instance is not `VerificationReportRequestParametersSMSImpl`
   */
  public VerificationReportRequestParametersSMSImpl getVerificationReportRequestParametersSMSImpl()
      throws ClassCastException {
    return (VerificationReportRequestParametersSMSImpl) super.getActualInstance();
  }
}
