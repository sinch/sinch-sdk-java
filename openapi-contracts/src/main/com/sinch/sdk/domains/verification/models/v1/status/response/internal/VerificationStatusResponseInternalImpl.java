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
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponseFlashCallImpl;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponsePhoneCallImpl;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponseSmsImpl;
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
                  .readValueAs(VerificationStatusResponsePhoneCallImpl.class);
          newVerificationStatusResponseInternalImpl.setActualInstance(deserialized);
          return newVerificationStatusResponseInternalImpl;
        case "flashcall":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationStatusResponseFlashCallImpl.class);
          newVerificationStatusResponseInternalImpl.setActualInstance(deserialized);
          return newVerificationStatusResponseInternalImpl;
        case "sms":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationStatusResponseSmsImpl.class);
          newVerificationStatusResponseInternalImpl.setActualInstance(deserialized);
          return newVerificationStatusResponseInternalImpl;
        case "VerificationStatusResponseFlashCall":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationStatusResponseFlashCallImpl.class);
          newVerificationStatusResponseInternalImpl.setActualInstance(deserialized);
          return newVerificationStatusResponseInternalImpl;
        case "VerificationStatusResponsePhoneCall":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationStatusResponsePhoneCallImpl.class);
          newVerificationStatusResponseInternalImpl.setActualInstance(deserialized);
          return newVerificationStatusResponseInternalImpl;
        case "VerificationStatusResponseSms":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationStatusResponseSmsImpl.class);
          newVerificationStatusResponseInternalImpl.setActualInstance(deserialized);
          return newVerificationStatusResponseInternalImpl;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for"
                      + " VerificationStatusResponseInternalImpl. Possible values: callout"
                      + " flashcall sms VerificationStatusResponseFlashCall"
                      + " VerificationStatusResponsePhoneCall VerificationStatusResponseSms",
                  discriminatorValue));
      }

      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize VerificationStatusResponseFlashCallImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationStatusResponseFlashCallImpl.class.equals(Integer.class)
            || VerificationStatusResponseFlashCallImpl.class.equals(Long.class)
            || VerificationStatusResponseFlashCallImpl.class.equals(Float.class)
            || VerificationStatusResponseFlashCallImpl.class.equals(Double.class)
            || VerificationStatusResponseFlashCallImpl.class.equals(Boolean.class)
            || VerificationStatusResponseFlashCallImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationStatusResponseFlashCallImpl.class.equals(Integer.class)
                        || VerificationStatusResponseFlashCallImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationStatusResponseFlashCallImpl.class.equals(Float.class)
                        || VerificationStatusResponseFlashCallImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationStatusResponseFlashCallImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationStatusResponseFlashCallImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationStatusResponseFlashCallImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER, "Input data matches schema 'VerificationStatusResponseFlashCallImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'VerificationStatusResponseFlashCallImpl'",
            e);
      }

      // deserialize VerificationStatusResponsePhoneCallImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationStatusResponsePhoneCallImpl.class.equals(Integer.class)
            || VerificationStatusResponsePhoneCallImpl.class.equals(Long.class)
            || VerificationStatusResponsePhoneCallImpl.class.equals(Float.class)
            || VerificationStatusResponsePhoneCallImpl.class.equals(Double.class)
            || VerificationStatusResponsePhoneCallImpl.class.equals(Boolean.class)
            || VerificationStatusResponsePhoneCallImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationStatusResponsePhoneCallImpl.class.equals(Integer.class)
                        || VerificationStatusResponsePhoneCallImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationStatusResponsePhoneCallImpl.class.equals(Float.class)
                        || VerificationStatusResponsePhoneCallImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationStatusResponsePhoneCallImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationStatusResponsePhoneCallImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationStatusResponsePhoneCallImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER, "Input data matches schema 'VerificationStatusResponsePhoneCallImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'VerificationStatusResponsePhoneCallImpl'",
            e);
      }

      // deserialize VerificationStatusResponseSmsImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationStatusResponseSmsImpl.class.equals(Integer.class)
            || VerificationStatusResponseSmsImpl.class.equals(Long.class)
            || VerificationStatusResponseSmsImpl.class.equals(Float.class)
            || VerificationStatusResponseSmsImpl.class.equals(Double.class)
            || VerificationStatusResponseSmsImpl.class.equals(Boolean.class)
            || VerificationStatusResponseSmsImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationStatusResponseSmsImpl.class.equals(Integer.class)
                        || VerificationStatusResponseSmsImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationStatusResponseSmsImpl.class.equals(Float.class)
                        || VerificationStatusResponseSmsImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationStatusResponseSmsImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationStatusResponseSmsImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationStatusResponseSmsImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'VerificationStatusResponseSmsImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'VerificationStatusResponseSmsImpl'", e);
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

  public VerificationStatusResponseInternalImpl(VerificationStatusResponseFlashCallImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VerificationStatusResponseInternalImpl(VerificationStatusResponsePhoneCallImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VerificationStatusResponseInternalImpl(VerificationStatusResponseSmsImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put(
        "VerificationStatusResponseFlashCallImpl", VerificationStatusResponseFlashCallImpl.class);
    schemas.put(
        "VerificationStatusResponsePhoneCallImpl", VerificationStatusResponsePhoneCallImpl.class);
    schemas.put("VerificationStatusResponseSmsImpl", VerificationStatusResponseSmsImpl.class);
    JSONNavigator.registerDescendants(
        VerificationStatusResponseInternalImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("callout", VerificationStatusResponsePhoneCallImpl.class);
    mappings.put("flashcall", VerificationStatusResponseFlashCallImpl.class);
    mappings.put("sms", VerificationStatusResponseSmsImpl.class);
    mappings.put(
        "VerificationStatusResponseFlashCall", VerificationStatusResponseFlashCallImpl.class);
    mappings.put(
        "VerificationStatusResponsePhoneCall", VerificationStatusResponsePhoneCallImpl.class);
    mappings.put("VerificationStatusResponseSms", VerificationStatusResponseSmsImpl.class);
    mappings.put("VerificationStatusResponse", VerificationStatusResponseInternalImpl.class);
    JSONNavigator.registerDiscriminator(
        VerificationStatusResponseInternalImpl.class, "method", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return VerificationStatusResponseInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: VerificationStatusResponseFlashCallImpl,
   * VerificationStatusResponsePhoneCallImpl, VerificationStatusResponseSmsImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        VerificationStatusResponseFlashCallImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        VerificationStatusResponsePhoneCallImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        VerificationStatusResponseSmsImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be VerificationStatusResponseFlashCallImpl,"
            + " VerificationStatusResponsePhoneCallImpl, VerificationStatusResponseSmsImpl");
  }

  /**
   * Get the actual instance, which can be the following: VerificationStatusResponseFlashCallImpl,
   * VerificationStatusResponsePhoneCallImpl, VerificationStatusResponseSmsImpl
   *
   * @return The actual instance (VerificationStatusResponseFlashCallImpl,
   *     VerificationStatusResponsePhoneCallImpl, VerificationStatusResponseSmsImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `VerificationStatusResponseFlashCallImpl`. If the actual instance is
   * not `VerificationStatusResponseFlashCallImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VerificationStatusResponseFlashCallImpl`
   * @throws ClassCastException if the instance is not `VerificationStatusResponseFlashCallImpl`
   */
  public VerificationStatusResponseFlashCallImpl getVerificationStatusResponseFlashCallImpl()
      throws ClassCastException {
    return (VerificationStatusResponseFlashCallImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `VerificationStatusResponsePhoneCallImpl`. If the actual instance is
   * not `VerificationStatusResponsePhoneCallImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VerificationStatusResponsePhoneCallImpl`
   * @throws ClassCastException if the instance is not `VerificationStatusResponsePhoneCallImpl`
   */
  public VerificationStatusResponsePhoneCallImpl getVerificationStatusResponsePhoneCallImpl()
      throws ClassCastException {
    return (VerificationStatusResponsePhoneCallImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `VerificationStatusResponseSmsImpl`. If the actual instance is not
   * `VerificationStatusResponseSmsImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VerificationStatusResponseSmsImpl`
   * @throws ClassCastException if the instance is not `VerificationStatusResponseSmsImpl`
   */
  public VerificationStatusResponseSmsImpl getVerificationStatusResponseSmsImpl()
      throws ClassCastException {
    return (VerificationStatusResponseSmsImpl) super.getActualInstance();
  }
}
