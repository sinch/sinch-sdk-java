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
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseFlashCallImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponsePhoneCallImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseSeamlessImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseSmsImpl;
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
              tree.traverse(jp.getCodec())
                  .readValueAs(StartVerificationResponsePhoneCallImpl.class);
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
              tree.traverse(jp.getCodec()).readValueAs(StartVerificationResponseSmsImpl.class);
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
        case "PhoneCallInitiateVerificationResponse":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(StartVerificationResponsePhoneCallImpl.class);
          newStartVerificationResponseInternalImpl.setActualInstance(deserialized);
          return newStartVerificationResponseInternalImpl;
        case "SmsInitiateVerificationResponse":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(StartVerificationResponseSmsImpl.class);
          newStartVerificationResponseInternalImpl.setActualInstance(deserialized);
          return newStartVerificationResponseInternalImpl;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for"
                      + " StartVerificationResponseInternalImpl. Possible values: callout flashcall"
                      + " seamless sms DataInitiateVerificationResponse"
                      + " FlashCallInitiateVerificationResponse"
                      + " PhoneCallInitiateVerificationResponse SmsInitiateVerificationResponse",
                  discriminatorValue));
      }

      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
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

      // deserialize StartVerificationResponsePhoneCallImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (StartVerificationResponsePhoneCallImpl.class.equals(Integer.class)
            || StartVerificationResponsePhoneCallImpl.class.equals(Long.class)
            || StartVerificationResponsePhoneCallImpl.class.equals(Float.class)
            || StartVerificationResponsePhoneCallImpl.class.equals(Double.class)
            || StartVerificationResponsePhoneCallImpl.class.equals(Boolean.class)
            || StartVerificationResponsePhoneCallImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((StartVerificationResponsePhoneCallImpl.class.equals(Integer.class)
                        || StartVerificationResponsePhoneCallImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((StartVerificationResponsePhoneCallImpl.class.equals(Float.class)
                        || StartVerificationResponsePhoneCallImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (StartVerificationResponsePhoneCallImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (StartVerificationResponsePhoneCallImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(StartVerificationResponsePhoneCallImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER, "Input data matches schema 'StartVerificationResponsePhoneCallImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'StartVerificationResponsePhoneCallImpl'",
            e);
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

      // deserialize StartVerificationResponseSmsImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (StartVerificationResponseSmsImpl.class.equals(Integer.class)
            || StartVerificationResponseSmsImpl.class.equals(Long.class)
            || StartVerificationResponseSmsImpl.class.equals(Float.class)
            || StartVerificationResponseSmsImpl.class.equals(Double.class)
            || StartVerificationResponseSmsImpl.class.equals(Boolean.class)
            || StartVerificationResponseSmsImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((StartVerificationResponseSmsImpl.class.equals(Integer.class)
                        || StartVerificationResponseSmsImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((StartVerificationResponseSmsImpl.class.equals(Float.class)
                        || StartVerificationResponseSmsImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (StartVerificationResponseSmsImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (StartVerificationResponseSmsImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(StartVerificationResponseSmsImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'StartVerificationResponseSmsImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'StartVerificationResponseSmsImpl'", e);
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

  public StartVerificationResponseInternalImpl(StartVerificationResponseFlashCallImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public StartVerificationResponseInternalImpl(StartVerificationResponsePhoneCallImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public StartVerificationResponseInternalImpl(StartVerificationResponseSeamlessImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public StartVerificationResponseInternalImpl(StartVerificationResponseSmsImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put(
        "StartVerificationResponseFlashCallImpl", StartVerificationResponseFlashCallImpl.class);
    schemas.put(
        "StartVerificationResponsePhoneCallImpl", StartVerificationResponsePhoneCallImpl.class);
    schemas.put(
        "StartVerificationResponseSeamlessImpl", StartVerificationResponseSeamlessImpl.class);
    schemas.put("StartVerificationResponseSmsImpl", StartVerificationResponseSmsImpl.class);
    JSONNavigator.registerDescendants(
        StartVerificationResponseInternalImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("callout", StartVerificationResponsePhoneCallImpl.class);
    mappings.put("flashcall", StartVerificationResponseFlashCallImpl.class);
    mappings.put("seamless", StartVerificationResponseSeamlessImpl.class);
    mappings.put("sms", StartVerificationResponseSmsImpl.class);
    mappings.put("DataInitiateVerificationResponse", StartVerificationResponseSeamlessImpl.class);
    mappings.put(
        "FlashCallInitiateVerificationResponse", StartVerificationResponseFlashCallImpl.class);
    mappings.put(
        "PhoneCallInitiateVerificationResponse", StartVerificationResponsePhoneCallImpl.class);
    mappings.put("SmsInitiateVerificationResponse", StartVerificationResponseSmsImpl.class);
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
   * against the oneOf child schemas: StartVerificationResponseFlashCallImpl,
   * StartVerificationResponsePhoneCallImpl, StartVerificationResponseSeamlessImpl,
   * StartVerificationResponseSmsImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        StartVerificationResponseFlashCallImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        StartVerificationResponsePhoneCallImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        StartVerificationResponseSeamlessImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        StartVerificationResponseSmsImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be StartVerificationResponseFlashCallImpl,"
            + " StartVerificationResponsePhoneCallImpl, StartVerificationResponseSeamlessImpl,"
            + " StartVerificationResponseSmsImpl");
  }

  /**
   * Get the actual instance, which can be the following: StartVerificationResponseFlashCallImpl,
   * StartVerificationResponsePhoneCallImpl, StartVerificationResponseSeamlessImpl,
   * StartVerificationResponseSmsImpl
   *
   * @return The actual instance (StartVerificationResponseFlashCallImpl,
   *     StartVerificationResponsePhoneCallImpl, StartVerificationResponseSeamlessImpl,
   *     StartVerificationResponseSmsImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
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
   * Get the actual instance of `StartVerificationResponsePhoneCallImpl`. If the actual instance is
   * not `StartVerificationResponsePhoneCallImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `StartVerificationResponsePhoneCallImpl`
   * @throws ClassCastException if the instance is not `StartVerificationResponsePhoneCallImpl`
   */
  public StartVerificationResponsePhoneCallImpl getStartVerificationResponsePhoneCallImpl()
      throws ClassCastException {
    return (StartVerificationResponsePhoneCallImpl) super.getActualInstance();
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

  /**
   * Get the actual instance of `StartVerificationResponseSmsImpl`. If the actual instance is not
   * `StartVerificationResponseSmsImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `StartVerificationResponseSmsImpl`
   * @throws ClassCastException if the instance is not `StartVerificationResponseSmsImpl`
   */
  public StartVerificationResponseSmsImpl getStartVerificationResponseSmsImpl()
      throws ClassCastException {
    return (StartVerificationResponseSmsImpl) super.getActualInstance();
  }
}
