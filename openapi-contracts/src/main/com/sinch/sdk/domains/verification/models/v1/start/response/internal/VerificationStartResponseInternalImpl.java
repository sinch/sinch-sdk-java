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
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseDataImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseFlashCallImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponsePhoneCallImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseSmsImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseWhatsAppImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(
    using =
        VerificationStartResponseInternalImpl.VerificationStartResponseInternalImplDeserializer
            .class)
@JsonSerialize(
    using =
        VerificationStartResponseInternalImpl.VerificationStartResponseInternalImplSerializer.class)
public class VerificationStartResponseInternalImpl extends AbstractOpenApiSchema
    implements VerificationStartResponseInternal {
  private static final Logger log =
      Logger.getLogger(VerificationStartResponseInternalImpl.class.getName());

  public static final class VerificationStartResponseInternalImplSerializer
      extends StdSerializer<VerificationStartResponseInternalImpl> {
    private static final long serialVersionUID = 1L;

    public VerificationStartResponseInternalImplSerializer(
        Class<VerificationStartResponseInternalImpl> t) {
      super(t);
    }

    public VerificationStartResponseInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        VerificationStartResponseInternalImpl value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class VerificationStartResponseInternalImplDeserializer
      extends StdDeserializer<VerificationStartResponseInternalImpl> {

    private static final long serialVersionUID = 1L;

    public VerificationStartResponseInternalImplDeserializer() {
      this(VerificationStartResponseInternalImpl.class);
    }

    public VerificationStartResponseInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public VerificationStartResponseInternalImpl deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      VerificationStartResponseInternalImpl newVerificationStartResponseInternalImpl =
          new VerificationStartResponseInternalImpl();
      Map<String, Object> result2 =
          tree.traverse(jp.getCodec()).readValueAs(new TypeReference<Map<String, Object>>() {});
      String discriminatorValue = (String) result2.get("method");
      switch (discriminatorValue) {
        case "callout":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationStartResponsePhoneCallImpl.class);
          newVerificationStartResponseInternalImpl.setActualInstance(deserialized);
          return newVerificationStartResponseInternalImpl;
        case "flashcall":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationStartResponseFlashCallImpl.class);
          newVerificationStartResponseInternalImpl.setActualInstance(deserialized);
          return newVerificationStartResponseInternalImpl;
        case "seamless":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationStartResponseDataImpl.class);
          newVerificationStartResponseInternalImpl.setActualInstance(deserialized);
          return newVerificationStartResponseInternalImpl;
        case "sms":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationStartResponseSmsImpl.class);
          newVerificationStartResponseInternalImpl.setActualInstance(deserialized);
          return newVerificationStartResponseInternalImpl;
        case "whatsapp":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationStartResponseWhatsAppImpl.class);
          newVerificationStartResponseInternalImpl.setActualInstance(deserialized);
          return newVerificationStartResponseInternalImpl;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for"
                      + " VerificationStartResponseInternalImpl. Possible values: callout flashcall"
                      + " seamless sms whatsapp",
                  discriminatorValue));
      }

      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize VerificationStartResponseDataImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationStartResponseDataImpl.class.equals(Integer.class)
            || VerificationStartResponseDataImpl.class.equals(Long.class)
            || VerificationStartResponseDataImpl.class.equals(Float.class)
            || VerificationStartResponseDataImpl.class.equals(Double.class)
            || VerificationStartResponseDataImpl.class.equals(Boolean.class)
            || VerificationStartResponseDataImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationStartResponseDataImpl.class.equals(Integer.class)
                        || VerificationStartResponseDataImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationStartResponseDataImpl.class.equals(Float.class)
                        || VerificationStartResponseDataImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationStartResponseDataImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationStartResponseDataImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationStartResponseDataImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'VerificationStartResponseDataImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'VerificationStartResponseDataImpl'", e);
      }

      // deserialize VerificationStartResponseFlashCallImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationStartResponseFlashCallImpl.class.equals(Integer.class)
            || VerificationStartResponseFlashCallImpl.class.equals(Long.class)
            || VerificationStartResponseFlashCallImpl.class.equals(Float.class)
            || VerificationStartResponseFlashCallImpl.class.equals(Double.class)
            || VerificationStartResponseFlashCallImpl.class.equals(Boolean.class)
            || VerificationStartResponseFlashCallImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationStartResponseFlashCallImpl.class.equals(Integer.class)
                        || VerificationStartResponseFlashCallImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationStartResponseFlashCallImpl.class.equals(Float.class)
                        || VerificationStartResponseFlashCallImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationStartResponseFlashCallImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationStartResponseFlashCallImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationStartResponseFlashCallImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER, "Input data matches schema 'VerificationStartResponseFlashCallImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'VerificationStartResponseFlashCallImpl'",
            e);
      }

      // deserialize VerificationStartResponsePhoneCallImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationStartResponsePhoneCallImpl.class.equals(Integer.class)
            || VerificationStartResponsePhoneCallImpl.class.equals(Long.class)
            || VerificationStartResponsePhoneCallImpl.class.equals(Float.class)
            || VerificationStartResponsePhoneCallImpl.class.equals(Double.class)
            || VerificationStartResponsePhoneCallImpl.class.equals(Boolean.class)
            || VerificationStartResponsePhoneCallImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationStartResponsePhoneCallImpl.class.equals(Integer.class)
                        || VerificationStartResponsePhoneCallImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationStartResponsePhoneCallImpl.class.equals(Float.class)
                        || VerificationStartResponsePhoneCallImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationStartResponsePhoneCallImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationStartResponsePhoneCallImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationStartResponsePhoneCallImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER, "Input data matches schema 'VerificationStartResponsePhoneCallImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'VerificationStartResponsePhoneCallImpl'",
            e);
      }

      // deserialize VerificationStartResponseSmsImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationStartResponseSmsImpl.class.equals(Integer.class)
            || VerificationStartResponseSmsImpl.class.equals(Long.class)
            || VerificationStartResponseSmsImpl.class.equals(Float.class)
            || VerificationStartResponseSmsImpl.class.equals(Double.class)
            || VerificationStartResponseSmsImpl.class.equals(Boolean.class)
            || VerificationStartResponseSmsImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationStartResponseSmsImpl.class.equals(Integer.class)
                        || VerificationStartResponseSmsImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationStartResponseSmsImpl.class.equals(Float.class)
                        || VerificationStartResponseSmsImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationStartResponseSmsImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationStartResponseSmsImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationStartResponseSmsImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'VerificationStartResponseSmsImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'VerificationStartResponseSmsImpl'", e);
      }

      // deserialize VerificationStartResponseWhatsAppImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationStartResponseWhatsAppImpl.class.equals(Integer.class)
            || VerificationStartResponseWhatsAppImpl.class.equals(Long.class)
            || VerificationStartResponseWhatsAppImpl.class.equals(Float.class)
            || VerificationStartResponseWhatsAppImpl.class.equals(Double.class)
            || VerificationStartResponseWhatsAppImpl.class.equals(Boolean.class)
            || VerificationStartResponseWhatsAppImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationStartResponseWhatsAppImpl.class.equals(Integer.class)
                        || VerificationStartResponseWhatsAppImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationStartResponseWhatsAppImpl.class.equals(Float.class)
                        || VerificationStartResponseWhatsAppImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationStartResponseWhatsAppImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationStartResponseWhatsAppImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationStartResponseWhatsAppImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'VerificationStartResponseWhatsAppImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'VerificationStartResponseWhatsAppImpl'",
            e);
      }

      if (match == 1) {
        VerificationStartResponseInternalImpl ret = new VerificationStartResponseInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for VerificationStartResponseInternalImpl: %d classes match"
                  + " result, expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public VerificationStartResponseInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(
          ctxt.getParser(), "VerificationStartResponseInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public VerificationStartResponseInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public VerificationStartResponseInternalImpl(VerificationStartResponseDataImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VerificationStartResponseInternalImpl(VerificationStartResponseFlashCallImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VerificationStartResponseInternalImpl(VerificationStartResponsePhoneCallImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VerificationStartResponseInternalImpl(VerificationStartResponseSmsImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VerificationStartResponseInternalImpl(VerificationStartResponseWhatsAppImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("VerificationStartResponseDataImpl", VerificationStartResponseDataImpl.class);
    schemas.put(
        "VerificationStartResponseFlashCallImpl", VerificationStartResponseFlashCallImpl.class);
    schemas.put(
        "VerificationStartResponsePhoneCallImpl", VerificationStartResponsePhoneCallImpl.class);
    schemas.put("VerificationStartResponseSmsImpl", VerificationStartResponseSmsImpl.class);
    schemas.put(
        "VerificationStartResponseWhatsAppImpl", VerificationStartResponseWhatsAppImpl.class);
    JSONNavigator.registerDescendants(
        VerificationStartResponseInternalImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("callout", VerificationStartResponsePhoneCallImpl.class);
    mappings.put("flashcall", VerificationStartResponseFlashCallImpl.class);
    mappings.put("seamless", VerificationStartResponseDataImpl.class);
    mappings.put("sms", VerificationStartResponseSmsImpl.class);
    mappings.put("whatsapp", VerificationStartResponseWhatsAppImpl.class);
    mappings.put("VerificationStartResponse", VerificationStartResponseInternalImpl.class);
    JSONNavigator.registerDiscriminator(
        VerificationStartResponseInternalImpl.class, "method", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return VerificationStartResponseInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: VerificationStartResponseDataImpl,
   * VerificationStartResponseFlashCallImpl, VerificationStartResponsePhoneCallImpl,
   * VerificationStartResponseSmsImpl, VerificationStartResponseWhatsAppImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        VerificationStartResponseDataImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        VerificationStartResponseFlashCallImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        VerificationStartResponsePhoneCallImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        VerificationStartResponseSmsImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        VerificationStartResponseWhatsAppImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be VerificationStartResponseDataImpl,"
            + " VerificationStartResponseFlashCallImpl, VerificationStartResponsePhoneCallImpl,"
            + " VerificationStartResponseSmsImpl, VerificationStartResponseWhatsAppImpl");
  }

  /**
   * Get the actual instance, which can be the following: VerificationStartResponseDataImpl,
   * VerificationStartResponseFlashCallImpl, VerificationStartResponsePhoneCallImpl,
   * VerificationStartResponseSmsImpl, VerificationStartResponseWhatsAppImpl
   *
   * @return The actual instance (VerificationStartResponseDataImpl,
   *     VerificationStartResponseFlashCallImpl, VerificationStartResponsePhoneCallImpl,
   *     VerificationStartResponseSmsImpl, VerificationStartResponseWhatsAppImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `VerificationStartResponseDataImpl`. If the actual instance is not
   * `VerificationStartResponseDataImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VerificationStartResponseDataImpl`
   * @throws ClassCastException if the instance is not `VerificationStartResponseDataImpl`
   */
  public VerificationStartResponseDataImpl getVerificationStartResponseDataImpl()
      throws ClassCastException {
    return (VerificationStartResponseDataImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `VerificationStartResponseFlashCallImpl`. If the actual instance is
   * not `VerificationStartResponseFlashCallImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VerificationStartResponseFlashCallImpl`
   * @throws ClassCastException if the instance is not `VerificationStartResponseFlashCallImpl`
   */
  public VerificationStartResponseFlashCallImpl getVerificationStartResponseFlashCallImpl()
      throws ClassCastException {
    return (VerificationStartResponseFlashCallImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `VerificationStartResponsePhoneCallImpl`. If the actual instance is
   * not `VerificationStartResponsePhoneCallImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VerificationStartResponsePhoneCallImpl`
   * @throws ClassCastException if the instance is not `VerificationStartResponsePhoneCallImpl`
   */
  public VerificationStartResponsePhoneCallImpl getVerificationStartResponsePhoneCallImpl()
      throws ClassCastException {
    return (VerificationStartResponsePhoneCallImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `VerificationStartResponseSmsImpl`. If the actual instance is not
   * `VerificationStartResponseSmsImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VerificationStartResponseSmsImpl`
   * @throws ClassCastException if the instance is not `VerificationStartResponseSmsImpl`
   */
  public VerificationStartResponseSmsImpl getVerificationStartResponseSmsImpl()
      throws ClassCastException {
    return (VerificationStartResponseSmsImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `VerificationStartResponseWhatsAppImpl`. If the actual instance is
   * not `VerificationStartResponseWhatsAppImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VerificationStartResponseWhatsAppImpl`
   * @throws ClassCastException if the instance is not `VerificationStartResponseWhatsAppImpl`
   */
  public VerificationStartResponseWhatsAppImpl getVerificationStartResponseWhatsAppImpl()
      throws ClassCastException {
    return (VerificationStartResponseWhatsAppImpl) super.getActualInstance();
  }
}
