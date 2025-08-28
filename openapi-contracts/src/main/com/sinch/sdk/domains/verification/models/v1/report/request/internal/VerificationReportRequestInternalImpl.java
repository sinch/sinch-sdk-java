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
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestFlashCallImpl;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestPhoneCallImpl;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestSmsImpl;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestWhatsAppImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(
    using =
        VerificationReportRequestInternalImpl.VerificationReportRequestInternalImplDeserializer
            .class)
@JsonSerialize(
    using =
        VerificationReportRequestInternalImpl.VerificationReportRequestInternalImplSerializer.class)
public class VerificationReportRequestInternalImpl extends AbstractOpenApiSchema
    implements VerificationReportRequestInternal {
  private static final Logger log =
      Logger.getLogger(VerificationReportRequestInternalImpl.class.getName());

  public static final class VerificationReportRequestInternalImplSerializer
      extends StdSerializer<VerificationReportRequestInternalImpl> {
    private static final long serialVersionUID = 1L;

    public VerificationReportRequestInternalImplSerializer(
        Class<VerificationReportRequestInternalImpl> t) {
      super(t);
    }

    public VerificationReportRequestInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        VerificationReportRequestInternalImpl value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class VerificationReportRequestInternalImplDeserializer
      extends StdDeserializer<VerificationReportRequestInternalImpl> {

    private static final long serialVersionUID = 1L;

    public VerificationReportRequestInternalImplDeserializer() {
      this(VerificationReportRequestInternalImpl.class);
    }

    public VerificationReportRequestInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public VerificationReportRequestInternalImpl deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      VerificationReportRequestInternalImpl newVerificationReportRequestInternalImpl =
          new VerificationReportRequestInternalImpl();
      Map<String, Object> result2 =
          tree.traverse(jp.getCodec()).readValueAs(new TypeReference<Map<String, Object>>() {});
      String discriminatorValue = (String) result2.get("method");
      switch (discriminatorValue) {
        case "callout":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationReportRequestPhoneCallImpl.class);
          newVerificationReportRequestInternalImpl.setActualInstance(deserialized);
          return newVerificationReportRequestInternalImpl;
        case "flashcall":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationReportRequestFlashCallImpl.class);
          newVerificationReportRequestInternalImpl.setActualInstance(deserialized);
          return newVerificationReportRequestInternalImpl;
        case "sms":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationReportRequestSmsImpl.class);
          newVerificationReportRequestInternalImpl.setActualInstance(deserialized);
          return newVerificationReportRequestInternalImpl;
        case "whatsapp":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationReportRequestWhatsAppImpl.class);
          newVerificationReportRequestInternalImpl.setActualInstance(deserialized);
          return newVerificationReportRequestInternalImpl;
        case "VerificationReportRequestFlashCall":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationReportRequestFlashCallImpl.class);
          newVerificationReportRequestInternalImpl.setActualInstance(deserialized);
          return newVerificationReportRequestInternalImpl;
        case "VerificationReportRequestPhoneCall":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationReportRequestPhoneCallImpl.class);
          newVerificationReportRequestInternalImpl.setActualInstance(deserialized);
          return newVerificationReportRequestInternalImpl;
        case "VerificationReportRequestSms":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationReportRequestSmsImpl.class);
          newVerificationReportRequestInternalImpl.setActualInstance(deserialized);
          return newVerificationReportRequestInternalImpl;
        case "VerificationReportRequestWhatsApp":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationReportRequestWhatsAppImpl.class);
          newVerificationReportRequestInternalImpl.setActualInstance(deserialized);
          return newVerificationReportRequestInternalImpl;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for"
                      + " VerificationReportRequestInternalImpl. Possible values: callout flashcall"
                      + " sms whatsapp VerificationReportRequestFlashCall"
                      + " VerificationReportRequestPhoneCall VerificationReportRequestSms"
                      + " VerificationReportRequestWhatsApp",
                  discriminatorValue));
      }

      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize VerificationReportRequestFlashCallImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationReportRequestFlashCallImpl.class.equals(Integer.class)
            || VerificationReportRequestFlashCallImpl.class.equals(Long.class)
            || VerificationReportRequestFlashCallImpl.class.equals(Float.class)
            || VerificationReportRequestFlashCallImpl.class.equals(Double.class)
            || VerificationReportRequestFlashCallImpl.class.equals(Boolean.class)
            || VerificationReportRequestFlashCallImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationReportRequestFlashCallImpl.class.equals(Integer.class)
                        || VerificationReportRequestFlashCallImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationReportRequestFlashCallImpl.class.equals(Float.class)
                        || VerificationReportRequestFlashCallImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationReportRequestFlashCallImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationReportRequestFlashCallImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationReportRequestFlashCallImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER, "Input data matches schema 'VerificationReportRequestFlashCallImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'VerificationReportRequestFlashCallImpl'",
            e);
      }

      // deserialize VerificationReportRequestPhoneCallImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationReportRequestPhoneCallImpl.class.equals(Integer.class)
            || VerificationReportRequestPhoneCallImpl.class.equals(Long.class)
            || VerificationReportRequestPhoneCallImpl.class.equals(Float.class)
            || VerificationReportRequestPhoneCallImpl.class.equals(Double.class)
            || VerificationReportRequestPhoneCallImpl.class.equals(Boolean.class)
            || VerificationReportRequestPhoneCallImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationReportRequestPhoneCallImpl.class.equals(Integer.class)
                        || VerificationReportRequestPhoneCallImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationReportRequestPhoneCallImpl.class.equals(Float.class)
                        || VerificationReportRequestPhoneCallImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationReportRequestPhoneCallImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationReportRequestPhoneCallImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationReportRequestPhoneCallImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER, "Input data matches schema 'VerificationReportRequestPhoneCallImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'VerificationReportRequestPhoneCallImpl'",
            e);
      }

      // deserialize VerificationReportRequestSmsImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationReportRequestSmsImpl.class.equals(Integer.class)
            || VerificationReportRequestSmsImpl.class.equals(Long.class)
            || VerificationReportRequestSmsImpl.class.equals(Float.class)
            || VerificationReportRequestSmsImpl.class.equals(Double.class)
            || VerificationReportRequestSmsImpl.class.equals(Boolean.class)
            || VerificationReportRequestSmsImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationReportRequestSmsImpl.class.equals(Integer.class)
                        || VerificationReportRequestSmsImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationReportRequestSmsImpl.class.equals(Float.class)
                        || VerificationReportRequestSmsImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationReportRequestSmsImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationReportRequestSmsImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationReportRequestSmsImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'VerificationReportRequestSmsImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'VerificationReportRequestSmsImpl'", e);
      }

      // deserialize VerificationReportRequestWhatsAppImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationReportRequestWhatsAppImpl.class.equals(Integer.class)
            || VerificationReportRequestWhatsAppImpl.class.equals(Long.class)
            || VerificationReportRequestWhatsAppImpl.class.equals(Float.class)
            || VerificationReportRequestWhatsAppImpl.class.equals(Double.class)
            || VerificationReportRequestWhatsAppImpl.class.equals(Boolean.class)
            || VerificationReportRequestWhatsAppImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationReportRequestWhatsAppImpl.class.equals(Integer.class)
                        || VerificationReportRequestWhatsAppImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationReportRequestWhatsAppImpl.class.equals(Float.class)
                        || VerificationReportRequestWhatsAppImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationReportRequestWhatsAppImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationReportRequestWhatsAppImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationReportRequestWhatsAppImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'VerificationReportRequestWhatsAppImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'VerificationReportRequestWhatsAppImpl'",
            e);
      }

      if (match == 1) {
        VerificationReportRequestInternalImpl ret = new VerificationReportRequestInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for VerificationReportRequestInternalImpl: %d classes match"
                  + " result, expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public VerificationReportRequestInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(
          ctxt.getParser(), "VerificationReportRequestInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public VerificationReportRequestInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public VerificationReportRequestInternalImpl(VerificationReportRequestFlashCallImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VerificationReportRequestInternalImpl(VerificationReportRequestPhoneCallImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VerificationReportRequestInternalImpl(VerificationReportRequestSmsImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VerificationReportRequestInternalImpl(VerificationReportRequestWhatsAppImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put(
        "VerificationReportRequestFlashCallImpl", VerificationReportRequestFlashCallImpl.class);
    schemas.put(
        "VerificationReportRequestPhoneCallImpl", VerificationReportRequestPhoneCallImpl.class);
    schemas.put("VerificationReportRequestSmsImpl", VerificationReportRequestSmsImpl.class);
    schemas.put(
        "VerificationReportRequestWhatsAppImpl", VerificationReportRequestWhatsAppImpl.class);
    JSONNavigator.registerDescendants(
        VerificationReportRequestInternalImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("callout", VerificationReportRequestPhoneCallImpl.class);
    mappings.put("flashcall", VerificationReportRequestFlashCallImpl.class);
    mappings.put("sms", VerificationReportRequestSmsImpl.class);
    mappings.put("whatsapp", VerificationReportRequestWhatsAppImpl.class);
    mappings.put(
        "VerificationReportRequestFlashCall", VerificationReportRequestFlashCallImpl.class);
    mappings.put(
        "VerificationReportRequestPhoneCall", VerificationReportRequestPhoneCallImpl.class);
    mappings.put("VerificationReportRequestSms", VerificationReportRequestSmsImpl.class);
    mappings.put("VerificationReportRequestWhatsApp", VerificationReportRequestWhatsAppImpl.class);
    mappings.put("VerificationReportRequest", VerificationReportRequestInternalImpl.class);
    JSONNavigator.registerDiscriminator(
        VerificationReportRequestInternalImpl.class, "method", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return VerificationReportRequestInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: VerificationReportRequestFlashCallImpl,
   * VerificationReportRequestPhoneCallImpl, VerificationReportRequestSmsImpl,
   * VerificationReportRequestWhatsAppImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        VerificationReportRequestFlashCallImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        VerificationReportRequestPhoneCallImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        VerificationReportRequestSmsImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        VerificationReportRequestWhatsAppImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be VerificationReportRequestFlashCallImpl,"
            + " VerificationReportRequestPhoneCallImpl, VerificationReportRequestSmsImpl,"
            + " VerificationReportRequestWhatsAppImpl");
  }

  /**
   * Get the actual instance, which can be the following: VerificationReportRequestFlashCallImpl,
   * VerificationReportRequestPhoneCallImpl, VerificationReportRequestSmsImpl,
   * VerificationReportRequestWhatsAppImpl
   *
   * @return The actual instance (VerificationReportRequestFlashCallImpl,
   *     VerificationReportRequestPhoneCallImpl, VerificationReportRequestSmsImpl,
   *     VerificationReportRequestWhatsAppImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `VerificationReportRequestFlashCallImpl`. If the actual instance is
   * not `VerificationReportRequestFlashCallImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VerificationReportRequestFlashCallImpl`
   * @throws ClassCastException if the instance is not `VerificationReportRequestFlashCallImpl`
   */
  public VerificationReportRequestFlashCallImpl getVerificationReportRequestFlashCallImpl()
      throws ClassCastException {
    return (VerificationReportRequestFlashCallImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `VerificationReportRequestPhoneCallImpl`. If the actual instance is
   * not `VerificationReportRequestPhoneCallImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VerificationReportRequestPhoneCallImpl`
   * @throws ClassCastException if the instance is not `VerificationReportRequestPhoneCallImpl`
   */
  public VerificationReportRequestPhoneCallImpl getVerificationReportRequestPhoneCallImpl()
      throws ClassCastException {
    return (VerificationReportRequestPhoneCallImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `VerificationReportRequestSmsImpl`. If the actual instance is not
   * `VerificationReportRequestSmsImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VerificationReportRequestSmsImpl`
   * @throws ClassCastException if the instance is not `VerificationReportRequestSmsImpl`
   */
  public VerificationReportRequestSmsImpl getVerificationReportRequestSmsImpl()
      throws ClassCastException {
    return (VerificationReportRequestSmsImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `VerificationReportRequestWhatsAppImpl`. If the actual instance is
   * not `VerificationReportRequestWhatsAppImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VerificationReportRequestWhatsAppImpl`
   * @throws ClassCastException if the instance is not `VerificationReportRequestWhatsAppImpl`
   */
  public VerificationReportRequestWhatsAppImpl getVerificationReportRequestWhatsAppImpl()
      throws ClassCastException {
    return (VerificationReportRequestWhatsAppImpl) super.getActualInstance();
  }
}
