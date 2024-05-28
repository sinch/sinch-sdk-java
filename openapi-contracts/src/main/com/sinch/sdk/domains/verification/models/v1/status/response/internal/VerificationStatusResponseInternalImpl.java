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
import com.sinch.sdk.domains.verification.models.v1.status.response.CalloutVerificationStatusResponseImpl;
import com.sinch.sdk.domains.verification.models.v1.status.response.FlashcallVerificationStatusResponseImpl;
import com.sinch.sdk.domains.verification.models.v1.status.response.SMSVerificationStatusResponseImpl;
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
              tree.traverse(jp.getCodec()).readValueAs(CalloutVerificationStatusResponseImpl.class);
          newVerificationStatusResponseInternalImpl.setActualInstance(deserialized);
          return newVerificationStatusResponseInternalImpl;
        case "flashcall":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(FlashcallVerificationStatusResponseImpl.class);
          newVerificationStatusResponseInternalImpl.setActualInstance(deserialized);
          return newVerificationStatusResponseInternalImpl;
        case "sms":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(SMSVerificationStatusResponseImpl.class);
          newVerificationStatusResponseInternalImpl.setActualInstance(deserialized);
          return newVerificationStatusResponseInternalImpl;
        case "CalloutVerificationStatusResponse":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(CalloutVerificationStatusResponseImpl.class);
          newVerificationStatusResponseInternalImpl.setActualInstance(deserialized);
          return newVerificationStatusResponseInternalImpl;
        case "FlashcallVerificationStatusResponse":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(FlashcallVerificationStatusResponseImpl.class);
          newVerificationStatusResponseInternalImpl.setActualInstance(deserialized);
          return newVerificationStatusResponseInternalImpl;
        case "SMSVerificationStatusResponse":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(SMSVerificationStatusResponseImpl.class);
          newVerificationStatusResponseInternalImpl.setActualInstance(deserialized);
          return newVerificationStatusResponseInternalImpl;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for"
                      + " VerificationStatusResponseInternalImpl. Possible values: callout"
                      + " flashcall sms CalloutVerificationStatusResponse"
                      + " FlashcallVerificationStatusResponse SMSVerificationStatusResponse",
                  discriminatorValue));
      }

      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize CalloutVerificationStatusResponseImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (CalloutVerificationStatusResponseImpl.class.equals(Integer.class)
            || CalloutVerificationStatusResponseImpl.class.equals(Long.class)
            || CalloutVerificationStatusResponseImpl.class.equals(Float.class)
            || CalloutVerificationStatusResponseImpl.class.equals(Double.class)
            || CalloutVerificationStatusResponseImpl.class.equals(Boolean.class)
            || CalloutVerificationStatusResponseImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((CalloutVerificationStatusResponseImpl.class.equals(Integer.class)
                        || CalloutVerificationStatusResponseImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((CalloutVerificationStatusResponseImpl.class.equals(Float.class)
                        || CalloutVerificationStatusResponseImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (CalloutVerificationStatusResponseImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (CalloutVerificationStatusResponseImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(CalloutVerificationStatusResponseImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'CalloutVerificationStatusResponseImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'CalloutVerificationStatusResponseImpl'",
            e);
      }

      // deserialize FlashcallVerificationStatusResponseImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (FlashcallVerificationStatusResponseImpl.class.equals(Integer.class)
            || FlashcallVerificationStatusResponseImpl.class.equals(Long.class)
            || FlashcallVerificationStatusResponseImpl.class.equals(Float.class)
            || FlashcallVerificationStatusResponseImpl.class.equals(Double.class)
            || FlashcallVerificationStatusResponseImpl.class.equals(Boolean.class)
            || FlashcallVerificationStatusResponseImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((FlashcallVerificationStatusResponseImpl.class.equals(Integer.class)
                        || FlashcallVerificationStatusResponseImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((FlashcallVerificationStatusResponseImpl.class.equals(Float.class)
                        || FlashcallVerificationStatusResponseImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (FlashcallVerificationStatusResponseImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (FlashcallVerificationStatusResponseImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(FlashcallVerificationStatusResponseImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER, "Input data matches schema 'FlashcallVerificationStatusResponseImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'FlashcallVerificationStatusResponseImpl'",
            e);
      }

      // deserialize SMSVerificationStatusResponseImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (SMSVerificationStatusResponseImpl.class.equals(Integer.class)
            || SMSVerificationStatusResponseImpl.class.equals(Long.class)
            || SMSVerificationStatusResponseImpl.class.equals(Float.class)
            || SMSVerificationStatusResponseImpl.class.equals(Double.class)
            || SMSVerificationStatusResponseImpl.class.equals(Boolean.class)
            || SMSVerificationStatusResponseImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((SMSVerificationStatusResponseImpl.class.equals(Integer.class)
                        || SMSVerificationStatusResponseImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((SMSVerificationStatusResponseImpl.class.equals(Float.class)
                        || SMSVerificationStatusResponseImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (SMSVerificationStatusResponseImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (SMSVerificationStatusResponseImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(SMSVerificationStatusResponseImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'SMSVerificationStatusResponseImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'SMSVerificationStatusResponseImpl'", e);
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

  public VerificationStatusResponseInternalImpl(CalloutVerificationStatusResponseImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VerificationStatusResponseInternalImpl(FlashcallVerificationStatusResponseImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VerificationStatusResponseInternalImpl(SMSVerificationStatusResponseImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put(
        "CalloutVerificationStatusResponseImpl", CalloutVerificationStatusResponseImpl.class);
    schemas.put(
        "FlashcallVerificationStatusResponseImpl", FlashcallVerificationStatusResponseImpl.class);
    schemas.put("SMSVerificationStatusResponseImpl", SMSVerificationStatusResponseImpl.class);
    JSONNavigator.registerDescendants(
        VerificationStatusResponseInternalImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("callout", CalloutVerificationStatusResponseImpl.class);
    mappings.put("flashcall", FlashcallVerificationStatusResponseImpl.class);
    mappings.put("sms", SMSVerificationStatusResponseImpl.class);
    mappings.put("CalloutVerificationStatusResponse", CalloutVerificationStatusResponseImpl.class);
    mappings.put(
        "FlashcallVerificationStatusResponse", FlashcallVerificationStatusResponseImpl.class);
    mappings.put("SMSVerificationStatusResponse", SMSVerificationStatusResponseImpl.class);
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
   * against the oneOf child schemas: CalloutVerificationStatusResponseImpl,
   * FlashcallVerificationStatusResponseImpl, SMSVerificationStatusResponseImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        CalloutVerificationStatusResponseImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        FlashcallVerificationStatusResponseImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        SMSVerificationStatusResponseImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be CalloutVerificationStatusResponseImpl,"
            + " FlashcallVerificationStatusResponseImpl, SMSVerificationStatusResponseImpl");
  }

  /**
   * Get the actual instance, which can be the following: CalloutVerificationStatusResponseImpl,
   * FlashcallVerificationStatusResponseImpl, SMSVerificationStatusResponseImpl
   *
   * @return The actual instance (CalloutVerificationStatusResponseImpl,
   *     FlashcallVerificationStatusResponseImpl, SMSVerificationStatusResponseImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `CalloutVerificationStatusResponseImpl`. If the actual instance is
   * not `CalloutVerificationStatusResponseImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `CalloutVerificationStatusResponseImpl`
   * @throws ClassCastException if the instance is not `CalloutVerificationStatusResponseImpl`
   */
  public CalloutVerificationStatusResponseImpl getCalloutVerificationStatusResponseImpl()
      throws ClassCastException {
    return (CalloutVerificationStatusResponseImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `FlashcallVerificationStatusResponseImpl`. If the actual instance is
   * not `FlashcallVerificationStatusResponseImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `FlashcallVerificationStatusResponseImpl`
   * @throws ClassCastException if the instance is not `FlashcallVerificationStatusResponseImpl`
   */
  public FlashcallVerificationStatusResponseImpl getFlashcallVerificationStatusResponseImpl()
      throws ClassCastException {
    return (FlashcallVerificationStatusResponseImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `SMSVerificationStatusResponseImpl`. If the actual instance is not
   * `SMSVerificationStatusResponseImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SMSVerificationStatusResponseImpl`
   * @throws ClassCastException if the instance is not `SMSVerificationStatusResponseImpl`
   */
  public SMSVerificationStatusResponseImpl getSMSVerificationStatusResponseImpl()
      throws ClassCastException {
    return (SMSVerificationStatusResponseImpl) super.getActualInstance();
  }
}
