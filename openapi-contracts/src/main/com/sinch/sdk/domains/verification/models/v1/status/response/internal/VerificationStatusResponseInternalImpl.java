package com.sinch.sdk.domains.verification.models.v1.status.response.internal;

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
import com.sinch.sdk.domains.verification.models.v1.status.response.FlashCallVerificationStatusResponseImpl;
import com.sinch.sdk.domains.verification.models.v1.status.response.PhoneCallVerificationStatusResponseImpl;
import com.sinch.sdk.domains.verification.models.v1.status.response.SmsVerificationStatusResponseImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(
    using =
        VerificationStatusResponseInternalImpl.VerificationStatusResponseInternalImplDeserializer
            .class)
@JsonSerialize(
    using =
        VerificationStatusResponseInternalImpl.VerificationStatusResponseInternalImplSerializer
            .class)
public class VerificationStatusResponseInternalImpl extends AbstractOpenApiSchema
    implements VerificationStatusResponseInternal {
  private static final Logger log =
      Logger.getLogger(VerificationStatusResponseInternalImpl.class.getName());

  public static final class VerificationStatusResponseInternalImplSerializer
      extends StdSerializer<VerificationStatusResponseInternalImpl> {
    private static final long serialVersionUID = 1L;

    public VerificationStatusResponseInternalImplSerializer(
        Class<VerificationStatusResponseInternalImpl> t) {
      super(t);
    }

    public VerificationStatusResponseInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        VerificationStatusResponseInternalImpl value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class VerificationStatusResponseInternalImplDeserializer
      extends StdDeserializer<VerificationStatusResponseInternalImpl> {

    private static final long serialVersionUID = 1L;

    public VerificationStatusResponseInternalImplDeserializer() {
      this(VerificationStatusResponseInternalImpl.class);
    }

    public VerificationStatusResponseInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public VerificationStatusResponseInternalImpl deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      VerificationStatusResponseInternalImpl newVerificationStatusResponseInternalImpl =
          new VerificationStatusResponseInternalImpl();
      Map<String, Object> result2 =
          tree.traverse(jp.getCodec()).readValueAs(new TypeReference<Map<String, Object>>() {});
      String discriminatorValue = (String) result2.get("method");
      switch (discriminatorValue) {
        case "callout":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(PhoneCallVerificationStatusResponseImpl.class);
          newVerificationStatusResponseInternalImpl.setActualInstance(deserialized);
          return newVerificationStatusResponseInternalImpl;
        case "flashcall":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(FlashCallVerificationStatusResponseImpl.class);
          newVerificationStatusResponseInternalImpl.setActualInstance(deserialized);
          return newVerificationStatusResponseInternalImpl;
        case "sms":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(SmsVerificationStatusResponseImpl.class);
          newVerificationStatusResponseInternalImpl.setActualInstance(deserialized);
          return newVerificationStatusResponseInternalImpl;
        case "FlashCallVerificationStatusResponse":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(FlashCallVerificationStatusResponseImpl.class);
          newVerificationStatusResponseInternalImpl.setActualInstance(deserialized);
          return newVerificationStatusResponseInternalImpl;
        case "PhoneCallVerificationStatusResponse":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(PhoneCallVerificationStatusResponseImpl.class);
          newVerificationStatusResponseInternalImpl.setActualInstance(deserialized);
          return newVerificationStatusResponseInternalImpl;
        case "SmsVerificationStatusResponse":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(SmsVerificationStatusResponseImpl.class);
          newVerificationStatusResponseInternalImpl.setActualInstance(deserialized);
          return newVerificationStatusResponseInternalImpl;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for"
                      + " VerificationStatusResponseInternalImpl. Possible values: callout"
                      + " flashcall sms FlashCallVerificationStatusResponse"
                      + " PhoneCallVerificationStatusResponse SmsVerificationStatusResponse",
                  discriminatorValue));
      }

      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize FlashCallVerificationStatusResponseImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (FlashCallVerificationStatusResponseImpl.class.equals(Integer.class)
            || FlashCallVerificationStatusResponseImpl.class.equals(Long.class)
            || FlashCallVerificationStatusResponseImpl.class.equals(Float.class)
            || FlashCallVerificationStatusResponseImpl.class.equals(Double.class)
            || FlashCallVerificationStatusResponseImpl.class.equals(Boolean.class)
            || FlashCallVerificationStatusResponseImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((FlashCallVerificationStatusResponseImpl.class.equals(Integer.class)
                        || FlashCallVerificationStatusResponseImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((FlashCallVerificationStatusResponseImpl.class.equals(Float.class)
                        || FlashCallVerificationStatusResponseImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (FlashCallVerificationStatusResponseImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (FlashCallVerificationStatusResponseImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(FlashCallVerificationStatusResponseImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER, "Input data matches schema 'FlashCallVerificationStatusResponseImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'FlashCallVerificationStatusResponseImpl'",
            e);
      }

      // deserialize PhoneCallVerificationStatusResponseImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (PhoneCallVerificationStatusResponseImpl.class.equals(Integer.class)
            || PhoneCallVerificationStatusResponseImpl.class.equals(Long.class)
            || PhoneCallVerificationStatusResponseImpl.class.equals(Float.class)
            || PhoneCallVerificationStatusResponseImpl.class.equals(Double.class)
            || PhoneCallVerificationStatusResponseImpl.class.equals(Boolean.class)
            || PhoneCallVerificationStatusResponseImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((PhoneCallVerificationStatusResponseImpl.class.equals(Integer.class)
                        || PhoneCallVerificationStatusResponseImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((PhoneCallVerificationStatusResponseImpl.class.equals(Float.class)
                        || PhoneCallVerificationStatusResponseImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (PhoneCallVerificationStatusResponseImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (PhoneCallVerificationStatusResponseImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(PhoneCallVerificationStatusResponseImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER, "Input data matches schema 'PhoneCallVerificationStatusResponseImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'PhoneCallVerificationStatusResponseImpl'",
            e);
      }

      // deserialize SmsVerificationStatusResponseImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (SmsVerificationStatusResponseImpl.class.equals(Integer.class)
            || SmsVerificationStatusResponseImpl.class.equals(Long.class)
            || SmsVerificationStatusResponseImpl.class.equals(Float.class)
            || SmsVerificationStatusResponseImpl.class.equals(Double.class)
            || SmsVerificationStatusResponseImpl.class.equals(Boolean.class)
            || SmsVerificationStatusResponseImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((SmsVerificationStatusResponseImpl.class.equals(Integer.class)
                        || SmsVerificationStatusResponseImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((SmsVerificationStatusResponseImpl.class.equals(Float.class)
                        || SmsVerificationStatusResponseImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (SmsVerificationStatusResponseImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (SmsVerificationStatusResponseImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(SmsVerificationStatusResponseImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'SmsVerificationStatusResponseImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'SmsVerificationStatusResponseImpl'", e);
      }

      if (match == 1) {
        VerificationStatusResponseInternalImpl ret = new VerificationStatusResponseInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for VerificationStatusResponseInternalImpl: %d classes match"
                  + " result, expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public VerificationStatusResponseInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(
          ctxt.getParser(), "VerificationStatusResponseInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public VerificationStatusResponseInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public VerificationStatusResponseInternalImpl(FlashCallVerificationStatusResponseImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VerificationStatusResponseInternalImpl(PhoneCallVerificationStatusResponseImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VerificationStatusResponseInternalImpl(SmsVerificationStatusResponseImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put(
        "FlashCallVerificationStatusResponseImpl", FlashCallVerificationStatusResponseImpl.class);
    schemas.put(
        "PhoneCallVerificationStatusResponseImpl", PhoneCallVerificationStatusResponseImpl.class);
    schemas.put("SmsVerificationStatusResponseImpl", SmsVerificationStatusResponseImpl.class);
    JSONNavigator.registerDescendants(
        VerificationStatusResponseInternalImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("callout", PhoneCallVerificationStatusResponseImpl.class);
    mappings.put("flashcall", FlashCallVerificationStatusResponseImpl.class);
    mappings.put("sms", SmsVerificationStatusResponseImpl.class);
    mappings.put(
        "FlashCallVerificationStatusResponse", FlashCallVerificationStatusResponseImpl.class);
    mappings.put(
        "PhoneCallVerificationStatusResponse", PhoneCallVerificationStatusResponseImpl.class);
    mappings.put("SmsVerificationStatusResponse", SmsVerificationStatusResponseImpl.class);
    mappings.put("VerificationResponse", VerificationStatusResponseInternalImpl.class);
    JSONNavigator.registerDiscriminator(
        VerificationStatusResponseInternalImpl.class, "method", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return VerificationStatusResponseInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: FlashCallVerificationStatusResponseImpl,
   * PhoneCallVerificationStatusResponseImpl, SmsVerificationStatusResponseImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        FlashCallVerificationStatusResponseImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        PhoneCallVerificationStatusResponseImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        SmsVerificationStatusResponseImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be FlashCallVerificationStatusResponseImpl,"
            + " PhoneCallVerificationStatusResponseImpl, SmsVerificationStatusResponseImpl");
  }

  /**
   * Get the actual instance, which can be the following: FlashCallVerificationStatusResponseImpl,
   * PhoneCallVerificationStatusResponseImpl, SmsVerificationStatusResponseImpl
   *
   * @return The actual instance (FlashCallVerificationStatusResponseImpl,
   *     PhoneCallVerificationStatusResponseImpl, SmsVerificationStatusResponseImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `FlashCallVerificationStatusResponseImpl`. If the actual instance is
   * not `FlashCallVerificationStatusResponseImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `FlashCallVerificationStatusResponseImpl`
   * @throws ClassCastException if the instance is not `FlashCallVerificationStatusResponseImpl`
   */
  public FlashCallVerificationStatusResponseImpl getFlashCallVerificationStatusResponseImpl()
      throws ClassCastException {
    return (FlashCallVerificationStatusResponseImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `PhoneCallVerificationStatusResponseImpl`. If the actual instance is
   * not `PhoneCallVerificationStatusResponseImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `PhoneCallVerificationStatusResponseImpl`
   * @throws ClassCastException if the instance is not `PhoneCallVerificationStatusResponseImpl`
   */
  public PhoneCallVerificationStatusResponseImpl getPhoneCallVerificationStatusResponseImpl()
      throws ClassCastException {
    return (PhoneCallVerificationStatusResponseImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `SmsVerificationStatusResponseImpl`. If the actual instance is not
   * `SmsVerificationStatusResponseImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SmsVerificationStatusResponseImpl`
   * @throws ClassCastException if the instance is not `SmsVerificationStatusResponseImpl`
   */
  public SmsVerificationStatusResponseImpl getSmsVerificationStatusResponseImpl()
      throws ClassCastException {
    return (SmsVerificationStatusResponseImpl) super.getActualInstance();
  }
}
