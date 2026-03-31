package com.sinch.sdk.domains.verification.models.v1.report.response.internal;

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
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseFlashCallImpl;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponsePhoneCallImpl;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseSmsImpl;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseWhatsAppImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(
    using =
        VerificationReportResponseInternalImpl.VerificationReportResponseInternalImplDeserializer
            .class)
@JsonSerialize(
    using =
        VerificationReportResponseInternalImpl.VerificationReportResponseInternalImplSerializer
            .class)
public class VerificationReportResponseInternalImpl extends AbstractOpenApiSchema
    implements VerificationReportResponseInternal {
  private static final Logger log =
      Logger.getLogger(VerificationReportResponseInternalImpl.class.getName());

  public static final class VerificationReportResponseInternalImplSerializer
      extends StdSerializer<VerificationReportResponseInternalImpl> {
    private static final long serialVersionUID = 1L;

    public VerificationReportResponseInternalImplSerializer(
        Class<VerificationReportResponseInternalImpl> t) {
      super(t);
    }

    public VerificationReportResponseInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        VerificationReportResponseInternalImpl value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class VerificationReportResponseInternalImplDeserializer
      extends StdDeserializer<VerificationReportResponseInternalImpl> {

    private static final long serialVersionUID = 1L;

    public VerificationReportResponseInternalImplDeserializer() {
      this(VerificationReportResponseInternalImpl.class);
    }

    public VerificationReportResponseInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public VerificationReportResponseInternalImpl deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      VerificationReportResponseInternalImpl newVerificationReportResponseInternalImpl =
          new VerificationReportResponseInternalImpl();
      Map<String, Object> result2 =
          tree.traverse(jp.getCodec()).readValueAs(new TypeReference<Map<String, Object>>() {});
      String discriminatorValue = (String) result2.get("method");
      switch (discriminatorValue) {
        case "callout":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationReportResponsePhoneCallImpl.class);
          newVerificationReportResponseInternalImpl.setActualInstance(deserialized);
          return newVerificationReportResponseInternalImpl;
        case "flashcall":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationReportResponseFlashCallImpl.class);
          newVerificationReportResponseInternalImpl.setActualInstance(deserialized);
          return newVerificationReportResponseInternalImpl;
        case "sms":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationReportResponseSmsImpl.class);
          newVerificationReportResponseInternalImpl.setActualInstance(deserialized);
          return newVerificationReportResponseInternalImpl;
        case "whatsapp":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationReportResponseWhatsAppImpl.class);
          newVerificationReportResponseInternalImpl.setActualInstance(deserialized);
          return newVerificationReportResponseInternalImpl;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for"
                      + " VerificationReportResponseInternalImpl. Possible values: callout"
                      + " flashcall sms whatsapp",
                  discriminatorValue));
      }

      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize VerificationReportResponseFlashCallImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationReportResponseFlashCallImpl.class.equals(Integer.class)
            || VerificationReportResponseFlashCallImpl.class.equals(Long.class)
            || VerificationReportResponseFlashCallImpl.class.equals(Float.class)
            || VerificationReportResponseFlashCallImpl.class.equals(Double.class)
            || VerificationReportResponseFlashCallImpl.class.equals(Boolean.class)
            || VerificationReportResponseFlashCallImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationReportResponseFlashCallImpl.class.equals(Integer.class)
                        || VerificationReportResponseFlashCallImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationReportResponseFlashCallImpl.class.equals(Float.class)
                        || VerificationReportResponseFlashCallImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationReportResponseFlashCallImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationReportResponseFlashCallImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationReportResponseFlashCallImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER, "Input data matches schema 'VerificationReportResponseFlashCallImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'VerificationReportResponseFlashCallImpl'",
            e);
      }

      // deserialize VerificationReportResponsePhoneCallImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationReportResponsePhoneCallImpl.class.equals(Integer.class)
            || VerificationReportResponsePhoneCallImpl.class.equals(Long.class)
            || VerificationReportResponsePhoneCallImpl.class.equals(Float.class)
            || VerificationReportResponsePhoneCallImpl.class.equals(Double.class)
            || VerificationReportResponsePhoneCallImpl.class.equals(Boolean.class)
            || VerificationReportResponsePhoneCallImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationReportResponsePhoneCallImpl.class.equals(Integer.class)
                        || VerificationReportResponsePhoneCallImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationReportResponsePhoneCallImpl.class.equals(Float.class)
                        || VerificationReportResponsePhoneCallImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationReportResponsePhoneCallImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationReportResponsePhoneCallImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationReportResponsePhoneCallImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER, "Input data matches schema 'VerificationReportResponsePhoneCallImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'VerificationReportResponsePhoneCallImpl'",
            e);
      }

      // deserialize VerificationReportResponseSmsImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationReportResponseSmsImpl.class.equals(Integer.class)
            || VerificationReportResponseSmsImpl.class.equals(Long.class)
            || VerificationReportResponseSmsImpl.class.equals(Float.class)
            || VerificationReportResponseSmsImpl.class.equals(Double.class)
            || VerificationReportResponseSmsImpl.class.equals(Boolean.class)
            || VerificationReportResponseSmsImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationReportResponseSmsImpl.class.equals(Integer.class)
                        || VerificationReportResponseSmsImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationReportResponseSmsImpl.class.equals(Float.class)
                        || VerificationReportResponseSmsImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationReportResponseSmsImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationReportResponseSmsImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(VerificationReportResponseSmsImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'VerificationReportResponseSmsImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'VerificationReportResponseSmsImpl'", e);
      }

      // deserialize VerificationReportResponseWhatsAppImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (VerificationReportResponseWhatsAppImpl.class.equals(Integer.class)
            || VerificationReportResponseWhatsAppImpl.class.equals(Long.class)
            || VerificationReportResponseWhatsAppImpl.class.equals(Float.class)
            || VerificationReportResponseWhatsAppImpl.class.equals(Double.class)
            || VerificationReportResponseWhatsAppImpl.class.equals(Boolean.class)
            || VerificationReportResponseWhatsAppImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((VerificationReportResponseWhatsAppImpl.class.equals(Integer.class)
                        || VerificationReportResponseWhatsAppImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((VerificationReportResponseWhatsAppImpl.class.equals(Float.class)
                        || VerificationReportResponseWhatsAppImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (VerificationReportResponseWhatsAppImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (VerificationReportResponseWhatsAppImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(VerificationReportResponseWhatsAppImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER, "Input data matches schema 'VerificationReportResponseWhatsAppImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'VerificationReportResponseWhatsAppImpl'",
            e);
      }

      if (match == 1) {
        VerificationReportResponseInternalImpl ret = new VerificationReportResponseInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for VerificationReportResponseInternalImpl: %d classes match"
                  + " result, expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public VerificationReportResponseInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(
          ctxt.getParser(), "VerificationReportResponseInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public VerificationReportResponseInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public VerificationReportResponseInternalImpl(VerificationReportResponseFlashCallImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VerificationReportResponseInternalImpl(VerificationReportResponsePhoneCallImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VerificationReportResponseInternalImpl(VerificationReportResponseSmsImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VerificationReportResponseInternalImpl(VerificationReportResponseWhatsAppImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put(
        "VerificationReportResponseFlashCallImpl", VerificationReportResponseFlashCallImpl.class);
    schemas.put(
        "VerificationReportResponsePhoneCallImpl", VerificationReportResponsePhoneCallImpl.class);
    schemas.put("VerificationReportResponseSmsImpl", VerificationReportResponseSmsImpl.class);
    schemas.put(
        "VerificationReportResponseWhatsAppImpl", VerificationReportResponseWhatsAppImpl.class);
    JSONNavigator.registerDescendants(
        VerificationReportResponseInternalImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("callout", VerificationReportResponsePhoneCallImpl.class);
    mappings.put("flashcall", VerificationReportResponseFlashCallImpl.class);
    mappings.put("sms", VerificationReportResponseSmsImpl.class);
    mappings.put("whatsapp", VerificationReportResponseWhatsAppImpl.class);
    mappings.put("VerificationReportResponse", VerificationReportResponseInternalImpl.class);
    JSONNavigator.registerDiscriminator(
        VerificationReportResponseInternalImpl.class, "method", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return VerificationReportResponseInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: VerificationReportResponseFlashCallImpl,
   * VerificationReportResponsePhoneCallImpl, VerificationReportResponseSmsImpl,
   * VerificationReportResponseWhatsAppImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        VerificationReportResponseFlashCallImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        VerificationReportResponsePhoneCallImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        VerificationReportResponseSmsImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        VerificationReportResponseWhatsAppImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be VerificationReportResponseFlashCallImpl,"
            + " VerificationReportResponsePhoneCallImpl, VerificationReportResponseSmsImpl,"
            + " VerificationReportResponseWhatsAppImpl");
  }

  /**
   * Get the actual instance, which can be the following: VerificationReportResponseFlashCallImpl,
   * VerificationReportResponsePhoneCallImpl, VerificationReportResponseSmsImpl,
   * VerificationReportResponseWhatsAppImpl
   *
   * @return The actual instance (VerificationReportResponseFlashCallImpl,
   *     VerificationReportResponsePhoneCallImpl, VerificationReportResponseSmsImpl,
   *     VerificationReportResponseWhatsAppImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `VerificationReportResponseFlashCallImpl`. If the actual instance is
   * not `VerificationReportResponseFlashCallImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VerificationReportResponseFlashCallImpl`
   * @throws ClassCastException if the instance is not `VerificationReportResponseFlashCallImpl`
   */
  public VerificationReportResponseFlashCallImpl getVerificationReportResponseFlashCallImpl()
      throws ClassCastException {
    return (VerificationReportResponseFlashCallImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `VerificationReportResponsePhoneCallImpl`. If the actual instance is
   * not `VerificationReportResponsePhoneCallImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VerificationReportResponsePhoneCallImpl`
   * @throws ClassCastException if the instance is not `VerificationReportResponsePhoneCallImpl`
   */
  public VerificationReportResponsePhoneCallImpl getVerificationReportResponsePhoneCallImpl()
      throws ClassCastException {
    return (VerificationReportResponsePhoneCallImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `VerificationReportResponseSmsImpl`. If the actual instance is not
   * `VerificationReportResponseSmsImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VerificationReportResponseSmsImpl`
   * @throws ClassCastException if the instance is not `VerificationReportResponseSmsImpl`
   */
  public VerificationReportResponseSmsImpl getVerificationReportResponseSmsImpl()
      throws ClassCastException {
    return (VerificationReportResponseSmsImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `VerificationReportResponseWhatsAppImpl`. If the actual instance is
   * not `VerificationReportResponseWhatsAppImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `VerificationReportResponseWhatsAppImpl`
   * @throws ClassCastException if the instance is not `VerificationReportResponseWhatsAppImpl`
   */
  public VerificationReportResponseWhatsAppImpl getVerificationReportResponseWhatsAppImpl()
      throws ClassCastException {
    return (VerificationReportResponseWhatsAppImpl) super.getActualInstance();
  }
}
