package com.sinch.sdk.domains.verification.models.v1.start.response.internal;

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
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseCalloutImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseFlashCallImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseSMSImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseSeamlessImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(
    using =
        StartVerificationResponseInternalImpl.StartVerificationResponseInternalImplDeserializer
            .class)
@JsonSerialize(
    using =
        StartVerificationResponseInternalImpl.StartVerificationResponseInternalImplSerializer.class)
public class StartVerificationResponseInternalImpl extends AbstractOpenApiSchema
    implements StartVerificationResponseInternal {
  private static final Logger log =
      Logger.getLogger(StartVerificationResponseInternalImpl.class.getName());

  public static final class StartVerificationResponseInternalImplSerializer
      extends StdSerializer<StartVerificationResponseInternalImpl> {
    private static final long serialVersionUID = 1L;

    public StartVerificationResponseInternalImplSerializer(
        Class<StartVerificationResponseInternalImpl> t) {
      super(t);
    }

    public StartVerificationResponseInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        StartVerificationResponseInternalImpl value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class StartVerificationResponseInternalImplDeserializer
      extends StdDeserializer<StartVerificationResponseInternalImpl> {

    private static final long serialVersionUID = 1L;

    public StartVerificationResponseInternalImplDeserializer() {
      this(StartVerificationResponseInternalImpl.class);
    }

    public StartVerificationResponseInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public StartVerificationResponseInternalImpl deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      StartVerificationResponseInternalImpl newStartVerificationResponseInternalImpl =
          new StartVerificationResponseInternalImpl();
      Map<String, Object> result2 =
          tree.traverse(jp.getCodec()).readValueAs(new TypeReference<Map<String, Object>>() {});
      String discriminatorValue = (String) result2.get("method");
      switch (discriminatorValue) {
        case "callout":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(StartVerificationResponseCalloutImpl.class);
          newStartVerificationResponseInternalImpl.setActualInstance(deserialized);
          return newStartVerificationResponseInternalImpl;
        case "flashcall":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(StartVerificationResponseFlashCallImpl.class);
          newStartVerificationResponseInternalImpl.setActualInstance(deserialized);
          return newStartVerificationResponseInternalImpl;
        case "seamless":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(StartVerificationResponseSeamlessImpl.class);
          newStartVerificationResponseInternalImpl.setActualInstance(deserialized);
          return newStartVerificationResponseInternalImpl;
        case "sms":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(StartVerificationResponseSMSImpl.class);
          newStartVerificationResponseInternalImpl.setActualInstance(deserialized);
          return newStartVerificationResponseInternalImpl;
        case "CalloutInitiateVerificationResponse":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(StartVerificationResponseCalloutImpl.class);
          newStartVerificationResponseInternalImpl.setActualInstance(deserialized);
          return newStartVerificationResponseInternalImpl;
        case "DataInitiateVerificationResponse":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(StartVerificationResponseSeamlessImpl.class);
          newStartVerificationResponseInternalImpl.setActualInstance(deserialized);
          return newStartVerificationResponseInternalImpl;
        case "FlashCallInitiateVerificationResponse":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(StartVerificationResponseFlashCallImpl.class);
          newStartVerificationResponseInternalImpl.setActualInstance(deserialized);
          return newStartVerificationResponseInternalImpl;
        case "SMSInitiateVerificationResponse":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(StartVerificationResponseSMSImpl.class);
          newStartVerificationResponseInternalImpl.setActualInstance(deserialized);
          return newStartVerificationResponseInternalImpl;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for"
                      + " StartVerificationResponseInternalImpl. Possible values: callout flashcall"
                      + " seamless sms CalloutInitiateVerificationResponse"
                      + " DataInitiateVerificationResponse FlashCallInitiateVerificationResponse"
                      + " SMSInitiateVerificationResponse",
                  discriminatorValue));
      }

      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize StartVerificationResponseCalloutImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (StartVerificationResponseCalloutImpl.class.equals(Integer.class)
            || StartVerificationResponseCalloutImpl.class.equals(Long.class)
            || StartVerificationResponseCalloutImpl.class.equals(Float.class)
            || StartVerificationResponseCalloutImpl.class.equals(Double.class)
            || StartVerificationResponseCalloutImpl.class.equals(Boolean.class)
            || StartVerificationResponseCalloutImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((StartVerificationResponseCalloutImpl.class.equals(Integer.class)
                        || StartVerificationResponseCalloutImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((StartVerificationResponseCalloutImpl.class.equals(Float.class)
                        || StartVerificationResponseCalloutImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (StartVerificationResponseCalloutImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (StartVerificationResponseCalloutImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(StartVerificationResponseCalloutImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'StartVerificationResponseCalloutImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'StartVerificationResponseCalloutImpl'",
            e);
      }

      // deserialize StartVerificationResponseFlashCallImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (StartVerificationResponseFlashCallImpl.class.equals(Integer.class)
            || StartVerificationResponseFlashCallImpl.class.equals(Long.class)
            || StartVerificationResponseFlashCallImpl.class.equals(Float.class)
            || StartVerificationResponseFlashCallImpl.class.equals(Double.class)
            || StartVerificationResponseFlashCallImpl.class.equals(Boolean.class)
            || StartVerificationResponseFlashCallImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((StartVerificationResponseFlashCallImpl.class.equals(Integer.class)
                        || StartVerificationResponseFlashCallImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((StartVerificationResponseFlashCallImpl.class.equals(Float.class)
                        || StartVerificationResponseFlashCallImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (StartVerificationResponseFlashCallImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (StartVerificationResponseFlashCallImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(StartVerificationResponseFlashCallImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER, "Input data matches schema 'StartVerificationResponseFlashCallImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'StartVerificationResponseFlashCallImpl'",
            e);
      }

      // deserialize StartVerificationResponseSMSImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (StartVerificationResponseSMSImpl.class.equals(Integer.class)
            || StartVerificationResponseSMSImpl.class.equals(Long.class)
            || StartVerificationResponseSMSImpl.class.equals(Float.class)
            || StartVerificationResponseSMSImpl.class.equals(Double.class)
            || StartVerificationResponseSMSImpl.class.equals(Boolean.class)
            || StartVerificationResponseSMSImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((StartVerificationResponseSMSImpl.class.equals(Integer.class)
                        || StartVerificationResponseSMSImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((StartVerificationResponseSMSImpl.class.equals(Float.class)
                        || StartVerificationResponseSMSImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (StartVerificationResponseSMSImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (StartVerificationResponseSMSImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(StartVerificationResponseSMSImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'StartVerificationResponseSMSImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'StartVerificationResponseSMSImpl'", e);
      }

      // deserialize StartVerificationResponseSeamlessImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (StartVerificationResponseSeamlessImpl.class.equals(Integer.class)
            || StartVerificationResponseSeamlessImpl.class.equals(Long.class)
            || StartVerificationResponseSeamlessImpl.class.equals(Float.class)
            || StartVerificationResponseSeamlessImpl.class.equals(Double.class)
            || StartVerificationResponseSeamlessImpl.class.equals(Boolean.class)
            || StartVerificationResponseSeamlessImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((StartVerificationResponseSeamlessImpl.class.equals(Integer.class)
                        || StartVerificationResponseSeamlessImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((StartVerificationResponseSeamlessImpl.class.equals(Float.class)
                        || StartVerificationResponseSeamlessImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (StartVerificationResponseSeamlessImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (StartVerificationResponseSeamlessImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(StartVerificationResponseSeamlessImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'StartVerificationResponseSeamlessImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'StartVerificationResponseSeamlessImpl'",
            e);
      }

      if (match == 1) {
        StartVerificationResponseInternalImpl ret = new StartVerificationResponseInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for StartVerificationResponseInternalImpl: %d classes match"
                  + " result, expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public StartVerificationResponseInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(
          ctxt.getParser(), "StartVerificationResponseInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public StartVerificationResponseInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public StartVerificationResponseInternalImpl(StartVerificationResponseCalloutImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public StartVerificationResponseInternalImpl(StartVerificationResponseFlashCallImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public StartVerificationResponseInternalImpl(StartVerificationResponseSMSImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public StartVerificationResponseInternalImpl(StartVerificationResponseSeamlessImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("StartVerificationResponseCalloutImpl", StartVerificationResponseCalloutImpl.class);
    schemas.put(
        "StartVerificationResponseFlashCallImpl", StartVerificationResponseFlashCallImpl.class);
    schemas.put("StartVerificationResponseSMSImpl", StartVerificationResponseSMSImpl.class);
    schemas.put(
        "StartVerificationResponseSeamlessImpl", StartVerificationResponseSeamlessImpl.class);
    JSONNavigator.registerDescendants(
        StartVerificationResponseInternalImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("callout", StartVerificationResponseCalloutImpl.class);
    mappings.put("flashcall", StartVerificationResponseFlashCallImpl.class);
    mappings.put("seamless", StartVerificationResponseSeamlessImpl.class);
    mappings.put("sms", StartVerificationResponseSMSImpl.class);
    mappings.put("CalloutInitiateVerificationResponse", StartVerificationResponseCalloutImpl.class);
    mappings.put("DataInitiateVerificationResponse", StartVerificationResponseSeamlessImpl.class);
    mappings.put(
        "FlashCallInitiateVerificationResponse", StartVerificationResponseFlashCallImpl.class);
    mappings.put("SMSInitiateVerificationResponse", StartVerificationResponseSMSImpl.class);
    mappings.put("InitiateVerificationResponse", StartVerificationResponseInternalImpl.class);
    JSONNavigator.registerDiscriminator(
        StartVerificationResponseInternalImpl.class, "method", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return StartVerificationResponseInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: StartVerificationResponseCalloutImpl,
   * StartVerificationResponseFlashCallImpl, StartVerificationResponseSMSImpl,
   * StartVerificationResponseSeamlessImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        StartVerificationResponseCalloutImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        StartVerificationResponseFlashCallImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        StartVerificationResponseSMSImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        StartVerificationResponseSeamlessImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be StartVerificationResponseCalloutImpl,"
            + " StartVerificationResponseFlashCallImpl, StartVerificationResponseSMSImpl,"
            + " StartVerificationResponseSeamlessImpl");
  }

  /**
   * Get the actual instance, which can be the following: StartVerificationResponseCalloutImpl,
   * StartVerificationResponseFlashCallImpl, StartVerificationResponseSMSImpl,
   * StartVerificationResponseSeamlessImpl
   *
   * @return The actual instance (StartVerificationResponseCalloutImpl,
   *     StartVerificationResponseFlashCallImpl, StartVerificationResponseSMSImpl,
   *     StartVerificationResponseSeamlessImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `StartVerificationResponseCalloutImpl`. If the actual instance is
   * not `StartVerificationResponseCalloutImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `StartVerificationResponseCalloutImpl`
   * @throws ClassCastException if the instance is not `StartVerificationResponseCalloutImpl`
   */
  public StartVerificationResponseCalloutImpl getStartVerificationResponseCalloutImpl()
      throws ClassCastException {
    return (StartVerificationResponseCalloutImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `StartVerificationResponseFlashCallImpl`. If the actual instance is
   * not `StartVerificationResponseFlashCallImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `StartVerificationResponseFlashCallImpl`
   * @throws ClassCastException if the instance is not `StartVerificationResponseFlashCallImpl`
   */
  public StartVerificationResponseFlashCallImpl getStartVerificationResponseFlashCallImpl()
      throws ClassCastException {
    return (StartVerificationResponseFlashCallImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `StartVerificationResponseSMSImpl`. If the actual instance is not
   * `StartVerificationResponseSMSImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `StartVerificationResponseSMSImpl`
   * @throws ClassCastException if the instance is not `StartVerificationResponseSMSImpl`
   */
  public StartVerificationResponseSMSImpl getStartVerificationResponseSMSImpl()
      throws ClassCastException {
    return (StartVerificationResponseSMSImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `StartVerificationResponseSeamlessImpl`. If the actual instance is
   * not `StartVerificationResponseSeamlessImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `StartVerificationResponseSeamlessImpl`
   * @throws ClassCastException if the instance is not `StartVerificationResponseSeamlessImpl`
   */
  public StartVerificationResponseSeamlessImpl getStartVerificationResponseSeamlessImpl()
      throws ClassCastException {
    return (StartVerificationResponseSeamlessImpl) super.getActualInstance();
  }
}
