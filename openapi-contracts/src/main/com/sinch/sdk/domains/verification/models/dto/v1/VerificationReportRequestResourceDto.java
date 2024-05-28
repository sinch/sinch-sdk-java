/*
 * Verification | Sinch
 * Verify users with SMS, flash calls (missed calls), a regular call, or data verification.
 *
 * The version of the OpenAPI document: 2.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.verification.models.dto.v1;

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
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(
    using =
        VerificationReportRequestResourceDto.VerificationReportRequestResourceDtoDeserializer.class)
@JsonSerialize(
    using =
        VerificationReportRequestResourceDto.VerificationReportRequestResourceDtoSerializer.class)
public final class VerificationReportRequestResourceDto extends AbstractOpenApiSchema {
  private static final Logger log =
      Logger.getLogger(VerificationReportRequestResourceDto.class.getName());

  public static final class VerificationReportRequestResourceDtoSerializer
      extends StdSerializer<VerificationReportRequestResourceDto> {
    private static final long serialVersionUID = 1L;

    public VerificationReportRequestResourceDtoSerializer(
        Class<VerificationReportRequestResourceDto> t) {
      super(t);
    }

    public VerificationReportRequestResourceDtoSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        VerificationReportRequestResourceDto value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class VerificationReportRequestResourceDtoDeserializer
      extends StdDeserializer<VerificationReportRequestResourceDto> {

    private static final long serialVersionUID = 1L;

    public VerificationReportRequestResourceDtoDeserializer() {
      this(VerificationReportRequestResourceDto.class);
    }

    public VerificationReportRequestResourceDtoDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public VerificationReportRequestResourceDto deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      VerificationReportRequestResourceDto newVerificationReportRequestResourceDto =
          new VerificationReportRequestResourceDto();
      Map<String, Object> result2 =
          tree.traverse(jp.getCodec()).readValueAs(new TypeReference<Map<String, Object>>() {});
      String discriminatorValue = (String) result2.get("method");
      switch (discriminatorValue) {
        case "CalloutVerificationReportRequest":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(CalloutVerificationReportRequestDto.class);
          newVerificationReportRequestResourceDto.setActualInstance(deserialized);
          return newVerificationReportRequestResourceDto;
        case "FlashcallVerificationReportRequest":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(FlashcallVerificationReportRequestDto.class);
          newVerificationReportRequestResourceDto.setActualInstance(deserialized);
          return newVerificationReportRequestResourceDto;
        case "SmsVerificationReportRequest":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(SmsVerificationReportRequestDto.class);
          newVerificationReportRequestResourceDto.setActualInstance(deserialized);
          return newVerificationReportRequestResourceDto;
        case "callout":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(CalloutVerificationReportRequestDto.class);
          newVerificationReportRequestResourceDto.setActualInstance(deserialized);
          return newVerificationReportRequestResourceDto;
        case "flashcall":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(FlashcallVerificationReportRequestDto.class);
          newVerificationReportRequestResourceDto.setActualInstance(deserialized);
          return newVerificationReportRequestResourceDto;
        case "sms":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(SmsVerificationReportRequestDto.class);
          newVerificationReportRequestResourceDto.setActualInstance(deserialized);
          return newVerificationReportRequestResourceDto;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for"
                      + " VerificationReportRequestResourceDto. Possible values:"
                      + " CalloutVerificationReportRequest FlashcallVerificationReportRequest"
                      + " SmsVerificationReportRequest callout flashcall sms",
                  discriminatorValue));
      }

      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize CalloutVerificationReportRequestDto
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (CalloutVerificationReportRequestDto.class.equals(Integer.class)
            || CalloutVerificationReportRequestDto.class.equals(Long.class)
            || CalloutVerificationReportRequestDto.class.equals(Float.class)
            || CalloutVerificationReportRequestDto.class.equals(Double.class)
            || CalloutVerificationReportRequestDto.class.equals(Boolean.class)
            || CalloutVerificationReportRequestDto.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((CalloutVerificationReportRequestDto.class.equals(Integer.class)
                        || CalloutVerificationReportRequestDto.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((CalloutVerificationReportRequestDto.class.equals(Float.class)
                        || CalloutVerificationReportRequestDto.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (CalloutVerificationReportRequestDto.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (CalloutVerificationReportRequestDto.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(CalloutVerificationReportRequestDto.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'CalloutVerificationReportRequestDto'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'CalloutVerificationReportRequestDto'",
            e);
      }

      // deserialize FlashcallVerificationReportRequestDto
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (FlashcallVerificationReportRequestDto.class.equals(Integer.class)
            || FlashcallVerificationReportRequestDto.class.equals(Long.class)
            || FlashcallVerificationReportRequestDto.class.equals(Float.class)
            || FlashcallVerificationReportRequestDto.class.equals(Double.class)
            || FlashcallVerificationReportRequestDto.class.equals(Boolean.class)
            || FlashcallVerificationReportRequestDto.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((FlashcallVerificationReportRequestDto.class.equals(Integer.class)
                        || FlashcallVerificationReportRequestDto.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((FlashcallVerificationReportRequestDto.class.equals(Float.class)
                        || FlashcallVerificationReportRequestDto.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (FlashcallVerificationReportRequestDto.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (FlashcallVerificationReportRequestDto.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(FlashcallVerificationReportRequestDto.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'FlashcallVerificationReportRequestDto'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'FlashcallVerificationReportRequestDto'",
            e);
      }

      // deserialize SmsVerificationReportRequestDto
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (SmsVerificationReportRequestDto.class.equals(Integer.class)
            || SmsVerificationReportRequestDto.class.equals(Long.class)
            || SmsVerificationReportRequestDto.class.equals(Float.class)
            || SmsVerificationReportRequestDto.class.equals(Double.class)
            || SmsVerificationReportRequestDto.class.equals(Boolean.class)
            || SmsVerificationReportRequestDto.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((SmsVerificationReportRequestDto.class.equals(Integer.class)
                        || SmsVerificationReportRequestDto.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((SmsVerificationReportRequestDto.class.equals(Float.class)
                        || SmsVerificationReportRequestDto.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (SmsVerificationReportRequestDto.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (SmsVerificationReportRequestDto.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(SmsVerificationReportRequestDto.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'SmsVerificationReportRequestDto'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'SmsVerificationReportRequestDto'", e);
      }

      if (match == 1) {
        VerificationReportRequestResourceDto ret = new VerificationReportRequestResourceDto();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for VerificationReportRequestResourceDto: %d classes match"
                  + " result, expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public VerificationReportRequestResourceDto getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(
          ctxt.getParser(), "VerificationReportRequestResourceDto cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public VerificationReportRequestResourceDto() {
    super("oneOf", Boolean.FALSE);
  }

  public VerificationReportRequestResourceDto(CalloutVerificationReportRequestDto o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VerificationReportRequestResourceDto(FlashcallVerificationReportRequestDto o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public VerificationReportRequestResourceDto(SmsVerificationReportRequestDto o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("CalloutVerificationReportRequestDto", CalloutVerificationReportRequestDto.class);
    schemas.put(
        "FlashcallVerificationReportRequestDto", FlashcallVerificationReportRequestDto.class);
    schemas.put("SmsVerificationReportRequestDto", SmsVerificationReportRequestDto.class);
    JSONNavigator.registerDescendants(
        VerificationReportRequestResourceDto.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("CalloutVerificationReportRequest", CalloutVerificationReportRequestDto.class);
    mappings.put("FlashcallVerificationReportRequest", FlashcallVerificationReportRequestDto.class);
    mappings.put("SmsVerificationReportRequest", SmsVerificationReportRequestDto.class);
    mappings.put("callout", CalloutVerificationReportRequestDto.class);
    mappings.put("flashcall", FlashcallVerificationReportRequestDto.class);
    mappings.put("sms", SmsVerificationReportRequestDto.class);
    mappings.put("VerificationReportRequestResource", VerificationReportRequestResourceDto.class);
    JSONNavigator.registerDiscriminator(
        VerificationReportRequestResourceDto.class, "method", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return VerificationReportRequestResourceDto.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: CalloutVerificationReportRequestDto,
   * FlashcallVerificationReportRequestDto, SmsVerificationReportRequestDto
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        CalloutVerificationReportRequestDto.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        FlashcallVerificationReportRequestDto.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        SmsVerificationReportRequestDto.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be CalloutVerificationReportRequestDto,"
            + " FlashcallVerificationReportRequestDto, SmsVerificationReportRequestDto");
  }

  /**
   * Get the actual instance, which can be the following: CalloutVerificationReportRequestDto,
   * FlashcallVerificationReportRequestDto, SmsVerificationReportRequestDto
   *
   * @return The actual instance (CalloutVerificationReportRequestDto,
   *     FlashcallVerificationReportRequestDto, SmsVerificationReportRequestDto)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `CalloutVerificationReportRequestDto`. If the actual instance is not
   * `CalloutVerificationReportRequestDto`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `CalloutVerificationReportRequestDto`
   * @throws ClassCastException if the instance is not `CalloutVerificationReportRequestDto`
   */
  public CalloutVerificationReportRequestDto getCalloutVerificationReportRequestDto()
      throws ClassCastException {
    return (CalloutVerificationReportRequestDto) super.getActualInstance();
  }

  /**
   * Get the actual instance of `FlashcallVerificationReportRequestDto`. If the actual instance is
   * not `FlashcallVerificationReportRequestDto`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `FlashcallVerificationReportRequestDto`
   * @throws ClassCastException if the instance is not `FlashcallVerificationReportRequestDto`
   */
  public FlashcallVerificationReportRequestDto getFlashcallVerificationReportRequestDto()
      throws ClassCastException {
    return (FlashcallVerificationReportRequestDto) super.getActualInstance();
  }

  /**
   * Get the actual instance of `SmsVerificationReportRequestDto`. If the actual instance is not
   * `SmsVerificationReportRequestDto`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SmsVerificationReportRequestDto`
   * @throws ClassCastException if the instance is not `SmsVerificationReportRequestDto`
   */
  public SmsVerificationReportRequestDto getSmsVerificationReportRequestDto()
      throws ClassCastException {
    return (SmsVerificationReportRequestDto) super.getActualInstance();
  }
}
