package com.sinch.sdk.domains.verification.models.v1.start.request.internal;

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
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationDataRequestImpl;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationFlashCallRequestImpl;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationPhoneCallRequestImpl;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationSmsRequestImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(
    using =
        StartVerificationRequestInternalImpl.StartVerificationRequestInternalImplDeserializer.class)
@JsonSerialize(
    using =
        StartVerificationRequestInternalImpl.StartVerificationRequestInternalImplSerializer.class)
public class StartVerificationRequestInternalImpl extends AbstractOpenApiSchema
    implements StartVerificationRequestInternal {
  private static final Logger log =
      Logger.getLogger(StartVerificationRequestInternalImpl.class.getName());

  public static final class StartVerificationRequestInternalImplSerializer
      extends StdSerializer<StartVerificationRequestInternalImpl> {
    private static final long serialVersionUID = 1L;

    public StartVerificationRequestInternalImplSerializer(
        Class<StartVerificationRequestInternalImpl> t) {
      super(t);
    }

    public StartVerificationRequestInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        StartVerificationRequestInternalImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class StartVerificationRequestInternalImplDeserializer
      extends StdDeserializer<StartVerificationRequestInternalImpl> {

    private static final long serialVersionUID = 1L;

    public StartVerificationRequestInternalImplDeserializer() {
      this(StartVerificationRequestInternalImpl.class);
    }

    public StartVerificationRequestInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public StartVerificationRequestInternalImpl deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      StartVerificationRequestInternalImpl newStartVerificationRequestInternalImpl =
          new StartVerificationRequestInternalImpl();
      Map<String, Object> result2 =
          tree.traverse(jp.getCodec()).readValueAs(new TypeReference<Map<String, Object>>() {});
      String discriminatorValue = (String) result2.get("method");
      switch (discriminatorValue) {
        case "callout":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(StartVerificationPhoneCallRequestImpl.class);
          newStartVerificationRequestInternalImpl.setActualInstance(deserialized);
          return newStartVerificationRequestInternalImpl;
        case "flashcall":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(StartVerificationFlashCallRequestImpl.class);
          newStartVerificationRequestInternalImpl.setActualInstance(deserialized);
          return newStartVerificationRequestInternalImpl;
        case "seamless":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(StartVerificationDataRequestImpl.class);
          newStartVerificationRequestInternalImpl.setActualInstance(deserialized);
          return newStartVerificationRequestInternalImpl;
        case "sms":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(StartVerificationSmsRequestImpl.class);
          newStartVerificationRequestInternalImpl.setActualInstance(deserialized);
          return newStartVerificationRequestInternalImpl;
        case "StartVerificationDataRequest":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(StartVerificationDataRequestImpl.class);
          newStartVerificationRequestInternalImpl.setActualInstance(deserialized);
          return newStartVerificationRequestInternalImpl;
        case "StartVerificationFlashCallRequest":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(StartVerificationFlashCallRequestImpl.class);
          newStartVerificationRequestInternalImpl.setActualInstance(deserialized);
          return newStartVerificationRequestInternalImpl;
        case "StartVerificationPhoneCallRequest":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(StartVerificationPhoneCallRequestImpl.class);
          newStartVerificationRequestInternalImpl.setActualInstance(deserialized);
          return newStartVerificationRequestInternalImpl;
        case "StartVerificationSmsRequest":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(StartVerificationSmsRequestImpl.class);
          newStartVerificationRequestInternalImpl.setActualInstance(deserialized);
          return newStartVerificationRequestInternalImpl;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for"
                      + " StartVerificationRequestInternalImpl. Possible values: callout flashcall"
                      + " seamless sms StartVerificationDataRequest"
                      + " StartVerificationFlashCallRequest StartVerificationPhoneCallRequest"
                      + " StartVerificationSmsRequest",
                  discriminatorValue));
      }

      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize StartVerificationDataRequestImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (StartVerificationDataRequestImpl.class.equals(Integer.class)
            || StartVerificationDataRequestImpl.class.equals(Long.class)
            || StartVerificationDataRequestImpl.class.equals(Float.class)
            || StartVerificationDataRequestImpl.class.equals(Double.class)
            || StartVerificationDataRequestImpl.class.equals(Boolean.class)
            || StartVerificationDataRequestImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((StartVerificationDataRequestImpl.class.equals(Integer.class)
                        || StartVerificationDataRequestImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((StartVerificationDataRequestImpl.class.equals(Float.class)
                        || StartVerificationDataRequestImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (StartVerificationDataRequestImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (StartVerificationDataRequestImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(StartVerificationDataRequestImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'StartVerificationDataRequestImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'StartVerificationDataRequestImpl'", e);
      }

      // deserialize StartVerificationFlashCallRequestImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (StartVerificationFlashCallRequestImpl.class.equals(Integer.class)
            || StartVerificationFlashCallRequestImpl.class.equals(Long.class)
            || StartVerificationFlashCallRequestImpl.class.equals(Float.class)
            || StartVerificationFlashCallRequestImpl.class.equals(Double.class)
            || StartVerificationFlashCallRequestImpl.class.equals(Boolean.class)
            || StartVerificationFlashCallRequestImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((StartVerificationFlashCallRequestImpl.class.equals(Integer.class)
                        || StartVerificationFlashCallRequestImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((StartVerificationFlashCallRequestImpl.class.equals(Float.class)
                        || StartVerificationFlashCallRequestImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (StartVerificationFlashCallRequestImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (StartVerificationFlashCallRequestImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(StartVerificationFlashCallRequestImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'StartVerificationFlashCallRequestImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'StartVerificationFlashCallRequestImpl'",
            e);
      }

      // deserialize StartVerificationPhoneCallRequestImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (StartVerificationPhoneCallRequestImpl.class.equals(Integer.class)
            || StartVerificationPhoneCallRequestImpl.class.equals(Long.class)
            || StartVerificationPhoneCallRequestImpl.class.equals(Float.class)
            || StartVerificationPhoneCallRequestImpl.class.equals(Double.class)
            || StartVerificationPhoneCallRequestImpl.class.equals(Boolean.class)
            || StartVerificationPhoneCallRequestImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((StartVerificationPhoneCallRequestImpl.class.equals(Integer.class)
                        || StartVerificationPhoneCallRequestImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((StartVerificationPhoneCallRequestImpl.class.equals(Float.class)
                        || StartVerificationPhoneCallRequestImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (StartVerificationPhoneCallRequestImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (StartVerificationPhoneCallRequestImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(StartVerificationPhoneCallRequestImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'StartVerificationPhoneCallRequestImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'StartVerificationPhoneCallRequestImpl'",
            e);
      }

      // deserialize StartVerificationSmsRequestImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (StartVerificationSmsRequestImpl.class.equals(Integer.class)
            || StartVerificationSmsRequestImpl.class.equals(Long.class)
            || StartVerificationSmsRequestImpl.class.equals(Float.class)
            || StartVerificationSmsRequestImpl.class.equals(Double.class)
            || StartVerificationSmsRequestImpl.class.equals(Boolean.class)
            || StartVerificationSmsRequestImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((StartVerificationSmsRequestImpl.class.equals(Integer.class)
                        || StartVerificationSmsRequestImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((StartVerificationSmsRequestImpl.class.equals(Float.class)
                        || StartVerificationSmsRequestImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (StartVerificationSmsRequestImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (StartVerificationSmsRequestImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(StartVerificationSmsRequestImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'StartVerificationSmsRequestImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'StartVerificationSmsRequestImpl'", e);
      }

      if (match == 1) {
        StartVerificationRequestInternalImpl ret = new StartVerificationRequestInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for StartVerificationRequestInternalImpl: %d classes match"
                  + " result, expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public StartVerificationRequestInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(
          ctxt.getParser(), "StartVerificationRequestInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public StartVerificationRequestInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public StartVerificationRequestInternalImpl(StartVerificationDataRequestImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public StartVerificationRequestInternalImpl(StartVerificationFlashCallRequestImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public StartVerificationRequestInternalImpl(StartVerificationPhoneCallRequestImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public StartVerificationRequestInternalImpl(StartVerificationSmsRequestImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("StartVerificationDataRequestImpl", StartVerificationDataRequestImpl.class);
    schemas.put(
        "StartVerificationFlashCallRequestImpl", StartVerificationFlashCallRequestImpl.class);
    schemas.put(
        "StartVerificationPhoneCallRequestImpl", StartVerificationPhoneCallRequestImpl.class);
    schemas.put("StartVerificationSmsRequestImpl", StartVerificationSmsRequestImpl.class);
    JSONNavigator.registerDescendants(
        StartVerificationRequestInternalImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("callout", StartVerificationPhoneCallRequestImpl.class);
    mappings.put("flashcall", StartVerificationFlashCallRequestImpl.class);
    mappings.put("seamless", StartVerificationDataRequestImpl.class);
    mappings.put("sms", StartVerificationSmsRequestImpl.class);
    mappings.put("StartVerificationDataRequest", StartVerificationDataRequestImpl.class);
    mappings.put("StartVerificationFlashCallRequest", StartVerificationFlashCallRequestImpl.class);
    mappings.put("StartVerificationPhoneCallRequest", StartVerificationPhoneCallRequestImpl.class);
    mappings.put("StartVerificationSmsRequest", StartVerificationSmsRequestImpl.class);
    mappings.put("StartVerificationRequest", StartVerificationRequestInternalImpl.class);
    JSONNavigator.registerDiscriminator(
        StartVerificationRequestInternalImpl.class, "method", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return StartVerificationRequestInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: StartVerificationDataRequestImpl,
   * StartVerificationFlashCallRequestImpl, StartVerificationPhoneCallRequestImpl,
   * StartVerificationSmsRequestImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        StartVerificationDataRequestImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        StartVerificationFlashCallRequestImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        StartVerificationPhoneCallRequestImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        StartVerificationSmsRequestImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be StartVerificationDataRequestImpl,"
            + " StartVerificationFlashCallRequestImpl, StartVerificationPhoneCallRequestImpl,"
            + " StartVerificationSmsRequestImpl");
  }

  /**
   * Get the actual instance, which can be the following: StartVerificationDataRequestImpl,
   * StartVerificationFlashCallRequestImpl, StartVerificationPhoneCallRequestImpl,
   * StartVerificationSmsRequestImpl
   *
   * @return The actual instance (StartVerificationDataRequestImpl,
   *     StartVerificationFlashCallRequestImpl, StartVerificationPhoneCallRequestImpl,
   *     StartVerificationSmsRequestImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `StartVerificationDataRequestImpl`. If the actual instance is not
   * `StartVerificationDataRequestImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `StartVerificationDataRequestImpl`
   * @throws ClassCastException if the instance is not `StartVerificationDataRequestImpl`
   */
  public StartVerificationDataRequestImpl getStartVerificationDataRequestImpl()
      throws ClassCastException {
    return (StartVerificationDataRequestImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `StartVerificationFlashCallRequestImpl`. If the actual instance is
   * not `StartVerificationFlashCallRequestImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `StartVerificationFlashCallRequestImpl`
   * @throws ClassCastException if the instance is not `StartVerificationFlashCallRequestImpl`
   */
  public StartVerificationFlashCallRequestImpl getStartVerificationFlashCallRequestImpl()
      throws ClassCastException {
    return (StartVerificationFlashCallRequestImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `StartVerificationPhoneCallRequestImpl`. If the actual instance is
   * not `StartVerificationPhoneCallRequestImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `StartVerificationPhoneCallRequestImpl`
   * @throws ClassCastException if the instance is not `StartVerificationPhoneCallRequestImpl`
   */
  public StartVerificationPhoneCallRequestImpl getStartVerificationPhoneCallRequestImpl()
      throws ClassCastException {
    return (StartVerificationPhoneCallRequestImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `StartVerificationSmsRequestImpl`. If the actual instance is not
   * `StartVerificationSmsRequestImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `StartVerificationSmsRequestImpl`
   * @throws ClassCastException if the instance is not `StartVerificationSmsRequestImpl`
   */
  public StartVerificationSmsRequestImpl getStartVerificationSmsRequestImpl()
      throws ClassCastException {
    return (StartVerificationSmsRequestImpl) super.getActualInstance();
  }
}
