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
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestDataImpl;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestFlashCallImpl;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestPhoneCallImpl;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestSmsImpl;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestWhatsAppImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(
    using =
        VerificationStartRequestInternalImpl.VerificationStartRequestInternalImplDeserializer.class)
@JsonSerialize(
    using =
        VerificationStartRequestInternalImpl.VerificationStartRequestInternalImplSerializer.class)
public class VerificationStartRequestInternalImpl extends AbstractOpenApiSchema
    implements VerificationStartRequestInternal {
  private static final Logger log =
      Logger.getLogger(VerificationStartRequestInternalImpl.class.getName());

  public static final class VerificationStartRequestInternalImplSerializer
      extends StdSerializer<VerificationStartRequestInternalImpl> {
    private static final long serialVersionUID = 1L;

    public VerificationStartRequestInternalImplSerializer(
        Class<VerificationStartRequestInternalImpl> t) {
      super(t);
    }

    public VerificationStartRequestInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        VerificationStartRequestInternalImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class VerificationStartRequestInternalImplDeserializer
      extends StdDeserializer<VerificationStartRequestInternalImpl> {

    private static final long serialVersionUID = 1L;

    public VerificationStartRequestInternalImplDeserializer() {
      this(VerificationStartRequestInternalImpl.class);
    }

    public VerificationStartRequestInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public VerificationStartRequestInternalImpl deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      VerificationStartRequestInternalImpl newVerificationStartRequestInternalImpl =
          new VerificationStartRequestInternalImpl();
      Map<String, Object> result2 =
          tree.traverse(jp.getCodec()).readValueAs(new TypeReference<Map<String, Object>>() {});
      String discriminatorValue = (String) result2.get("method");
      switch (discriminatorValue) {
        case "callout":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationStartRequestPhoneCallImpl.class);
          newVerificationStartRequestInternalImpl.setActualInstance(deserialized);
          return newVerificationStartRequestInternalImpl;
        case "flashcall":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationStartRequestFlashCallImpl.class);
          newVerificationStartRequestInternalImpl.setActualInstance(deserialized);
          return newVerificationStartRequestInternalImpl;
        case "seamless":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationStartRequestDataImpl.class);
          newVerificationStartRequestInternalImpl.setActualInstance(deserialized);
          return newVerificationStartRequestInternalImpl;
        case "sms":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationStartRequestSmsImpl.class);
          newVerificationStartRequestInternalImpl.setActualInstance(deserialized);
          return newVerificationStartRequestInternalImpl;
        case "whatsapp":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationStartRequestWhatsAppImpl.class);
          newVerificationStartRequestInternalImpl.setActualInstance(deserialized);
          return newVerificationStartRequestInternalImpl;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for"
                      + " VerificationStartRequestInternalImpl. Possible values: callout flashcall"
                      + " seamless sms whatsapp",
                  discriminatorValue));
      }

      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize VerificationStartRequestDataImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationStartRequestDataImpl.class.equals(Integer.class)
            || VerificationStartRequestDataImpl.class.equals(Long.class)
            || VerificationStartRequestDataImpl.class.equals(Float.class)
            || VerificationStartRequestDataImpl.class.equals(Double.class)
            || VerificationStartRequestDataImpl.class.equals(Boolean.class)
            || VerificationStartRequestDataImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationStartRequestDataImpl.class.equals(Integer.class)
                        || VerificationStartRequestDataImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationStartRequestDataImpl.class.equals(Float.class)
                        || VerificationStartRequestDataImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationStartRequestDataImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationStartRequestDataImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationStartRequestDataImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'VerificationStartRequestDataImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'VerificationStartRequestDataImpl'", e);
      }

      // deserialize VerificationStartRequestFlashCallImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationStartRequestFlashCallImpl.class.equals(Integer.class)
            || VerificationStartRequestFlashCallImpl.class.equals(Long.class)
            || VerificationStartRequestFlashCallImpl.class.equals(Float.class)
            || VerificationStartRequestFlashCallImpl.class.equals(Double.class)
            || VerificationStartRequestFlashCallImpl.class.equals(Boolean.class)
            || VerificationStartRequestFlashCallImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationStartRequestFlashCallImpl.class.equals(Integer.class)
                        || VerificationStartRequestFlashCallImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationStartRequestFlashCallImpl.class.equals(Float.class)
                        || VerificationStartRequestFlashCallImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationStartRequestFlashCallImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationStartRequestFlashCallImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationStartRequestFlashCallImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'VerificationStartRequestFlashCallImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'VerificationStartRequestFlashCallImpl'",
            e);
      }

      // deserialize VerificationStartRequestPhoneCallImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationStartRequestPhoneCallImpl.class.equals(Integer.class)
            || VerificationStartRequestPhoneCallImpl.class.equals(Long.class)
            || VerificationStartRequestPhoneCallImpl.class.equals(Float.class)
            || VerificationStartRequestPhoneCallImpl.class.equals(Double.class)
            || VerificationStartRequestPhoneCallImpl.class.equals(Boolean.class)
            || VerificationStartRequestPhoneCallImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationStartRequestPhoneCallImpl.class.equals(Integer.class)
                        || VerificationStartRequestPhoneCallImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationStartRequestPhoneCallImpl.class.equals(Float.class)
                        || VerificationStartRequestPhoneCallImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationStartRequestPhoneCallImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationStartRequestPhoneCallImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationStartRequestPhoneCallImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'VerificationStartRequestPhoneCallImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'VerificationStartRequestPhoneCallImpl'",
            e);
      }

      // deserialize VerificationStartRequestSmsImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationStartRequestSmsImpl.class.equals(Integer.class)
            || VerificationStartRequestSmsImpl.class.equals(Long.class)
            || VerificationStartRequestSmsImpl.class.equals(Float.class)
            || VerificationStartRequestSmsImpl.class.equals(Double.class)
            || VerificationStartRequestSmsImpl.class.equals(Boolean.class)
            || VerificationStartRequestSmsImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationStartRequestSmsImpl.class.equals(Integer.class)
                        || VerificationStartRequestSmsImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationStartRequestSmsImpl.class.equals(Float.class)
                        || VerificationStartRequestSmsImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationStartRequestSmsImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationStartRequestSmsImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationStartRequestSmsImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'VerificationStartRequestSmsImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'VerificationStartRequestSmsImpl'", e);
      }

      // deserialize VerificationStartRequestWhatsAppImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationStartRequestWhatsAppImpl.class.equals(Integer.class)
            || VerificationStartRequestWhatsAppImpl.class.equals(Long.class)
            || VerificationStartRequestWhatsAppImpl.class.equals(Float.class)
            || VerificationStartRequestWhatsAppImpl.class.equals(Double.class)
            || VerificationStartRequestWhatsAppImpl.class.equals(Boolean.class)
            || VerificationStartRequestWhatsAppImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationStartRequestWhatsAppImpl.class.equals(Integer.class)
                        || VerificationStartRequestWhatsAppImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationStartRequestWhatsAppImpl.class.equals(Float.class)
                        || VerificationStartRequestWhatsAppImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationStartRequestWhatsAppImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationStartRequestWhatsAppImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationStartRequestWhatsAppImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'VerificationStartRequestWhatsAppImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'VerificationStartRequestWhatsAppImpl'",
            e);
      }

      if (match == 1) {
        VerificationStartRequestInternalImpl ret = new VerificationStartRequestInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for VerificationStartRequestInternalImpl: %d classes match"
                  + " result, expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public VerificationStartRequestInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(
          ctxt.getParser(), "VerificationStartRequestInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public VerificationStartRequestInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public VerificationStartRequestInternalImpl(VerificationStartRequestDataImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VerificationStartRequestInternalImpl(VerificationStartRequestFlashCallImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VerificationStartRequestInternalImpl(VerificationStartRequestPhoneCallImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VerificationStartRequestInternalImpl(VerificationStartRequestSmsImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VerificationStartRequestInternalImpl(VerificationStartRequestWhatsAppImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("VerificationStartRequestDataImpl", VerificationStartRequestDataImpl.class);
    schemas.put(
        "VerificationStartRequestFlashCallImpl", VerificationStartRequestFlashCallImpl.class);
    schemas.put(
        "VerificationStartRequestPhoneCallImpl", VerificationStartRequestPhoneCallImpl.class);
    schemas.put("VerificationStartRequestSmsImpl", VerificationStartRequestSmsImpl.class);
    schemas.put("VerificationStartRequestWhatsAppImpl", VerificationStartRequestWhatsAppImpl.class);
    JSONNavigator.registerDescendants(
        VerificationStartRequestInternalImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("callout", VerificationStartRequestPhoneCallImpl.class);
    mappings.put("flashcall", VerificationStartRequestFlashCallImpl.class);
    mappings.put("seamless", VerificationStartRequestDataImpl.class);
    mappings.put("sms", VerificationStartRequestSmsImpl.class);
    mappings.put("whatsapp", VerificationStartRequestWhatsAppImpl.class);
    mappings.put("VerificationStartRequest", VerificationStartRequestInternalImpl.class);
    JSONNavigator.registerDiscriminator(
        VerificationStartRequestInternalImpl.class, "method", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return VerificationStartRequestInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: VerificationStartRequestDataImpl,
   * VerificationStartRequestFlashCallImpl, VerificationStartRequestPhoneCallImpl,
   * VerificationStartRequestSmsImpl, VerificationStartRequestWhatsAppImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        VerificationStartRequestDataImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        VerificationStartRequestFlashCallImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        VerificationStartRequestPhoneCallImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        VerificationStartRequestSmsImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        VerificationStartRequestWhatsAppImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be VerificationStartRequestDataImpl,"
            + " VerificationStartRequestFlashCallImpl, VerificationStartRequestPhoneCallImpl,"
            + " VerificationStartRequestSmsImpl, VerificationStartRequestWhatsAppImpl");
  }

  /**
   * Get the actual instance, which can be the following: VerificationStartRequestDataImpl,
   * VerificationStartRequestFlashCallImpl, VerificationStartRequestPhoneCallImpl,
   * VerificationStartRequestSmsImpl, VerificationStartRequestWhatsAppImpl
   *
   * @return The actual instance (VerificationStartRequestDataImpl,
   *     VerificationStartRequestFlashCallImpl, VerificationStartRequestPhoneCallImpl,
   *     VerificationStartRequestSmsImpl, VerificationStartRequestWhatsAppImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `VerificationStartRequestDataImpl`. If the actual instance is not
   * `VerificationStartRequestDataImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VerificationStartRequestDataImpl`
   * @throws ClassCastException if the instance is not `VerificationStartRequestDataImpl`
   */
  public VerificationStartRequestDataImpl getVerificationStartRequestDataImpl()
      throws ClassCastException {
    return (VerificationStartRequestDataImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `VerificationStartRequestFlashCallImpl`. If the actual instance is
   * not `VerificationStartRequestFlashCallImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VerificationStartRequestFlashCallImpl`
   * @throws ClassCastException if the instance is not `VerificationStartRequestFlashCallImpl`
   */
  public VerificationStartRequestFlashCallImpl getVerificationStartRequestFlashCallImpl()
      throws ClassCastException {
    return (VerificationStartRequestFlashCallImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `VerificationStartRequestPhoneCallImpl`. If the actual instance is
   * not `VerificationStartRequestPhoneCallImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VerificationStartRequestPhoneCallImpl`
   * @throws ClassCastException if the instance is not `VerificationStartRequestPhoneCallImpl`
   */
  public VerificationStartRequestPhoneCallImpl getVerificationStartRequestPhoneCallImpl()
      throws ClassCastException {
    return (VerificationStartRequestPhoneCallImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `VerificationStartRequestSmsImpl`. If the actual instance is not
   * `VerificationStartRequestSmsImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VerificationStartRequestSmsImpl`
   * @throws ClassCastException if the instance is not `VerificationStartRequestSmsImpl`
   */
  public VerificationStartRequestSmsImpl getVerificationStartRequestSmsImpl()
      throws ClassCastException {
    return (VerificationStartRequestSmsImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `VerificationStartRequestWhatsAppImpl`. If the actual instance is
   * not `VerificationStartRequestWhatsAppImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VerificationStartRequestWhatsAppImpl`
   * @throws ClassCastException if the instance is not `VerificationStartRequestWhatsAppImpl`
   */
  public VerificationStartRequestWhatsAppImpl getVerificationStartRequestWhatsAppImpl()
      throws ClassCastException {
    return (VerificationStartRequestWhatsAppImpl) super.getActualInstance();
  }
}
