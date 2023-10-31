/*
 * API Overview | Sinch
 * Sinch SMS API is one of the easiest APIs we offer and enables you to add fast and reliable global SMS to your applications. Send single messages, scheduled batch messages, use available message templates and more.
 *
 * The version of the OpenAPI document: v1
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.sms.models.dto.v1;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
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

// @javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonDeserialize(using = DryRunRequestDto.DryRunRequestDtoDeserializer.class)
@JsonSerialize(using = DryRunRequestDto.DryRunRequestDtoSerializer.class)
public class DryRunRequestDto extends AbstractOpenApiSchema {
  private static final Logger log = Logger.getLogger(DryRunRequestDto.class.getName());

  public static class DryRunRequestDtoSerializer extends StdSerializer<DryRunRequestDto> {
    public DryRunRequestDtoSerializer(Class<DryRunRequestDto> t) {
      super(t);
    }

    public DryRunRequestDtoSerializer() {
      this(null);
    }

    @Override
    public void serialize(DryRunRequestDto value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static class DryRunRequestDtoDeserializer extends StdDeserializer<DryRunRequestDto> {
    public DryRunRequestDtoDeserializer() {
      this(DryRunRequestDto.class);
    }

    public DryRunRequestDtoDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public DryRunRequestDto deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize BinaryRequestDto
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (BinaryRequestDto.class.equals(Integer.class)
            || BinaryRequestDto.class.equals(Long.class)
            || BinaryRequestDto.class.equals(Float.class)
            || BinaryRequestDto.class.equals(Double.class)
            || BinaryRequestDto.class.equals(Boolean.class)
            || BinaryRequestDto.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((BinaryRequestDto.class.equals(Integer.class)
                        || BinaryRequestDto.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((BinaryRequestDto.class.equals(Float.class)
                        || BinaryRequestDto.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (BinaryRequestDto.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (BinaryRequestDto.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(BinaryRequestDto.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'BinaryRequestDto'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'BinaryRequestDto'", e);
      }

      // deserialize MediaRequestDto
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (MediaRequestDto.class.equals(Integer.class)
            || MediaRequestDto.class.equals(Long.class)
            || MediaRequestDto.class.equals(Float.class)
            || MediaRequestDto.class.equals(Double.class)
            || MediaRequestDto.class.equals(Boolean.class)
            || MediaRequestDto.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((MediaRequestDto.class.equals(Integer.class)
                        || MediaRequestDto.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((MediaRequestDto.class.equals(Float.class)
                        || MediaRequestDto.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (MediaRequestDto.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (MediaRequestDto.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(MediaRequestDto.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'MediaRequestDto'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'MediaRequestDto'", e);
      }

      // deserialize TextRequestDto
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (TextRequestDto.class.equals(Integer.class)
            || TextRequestDto.class.equals(Long.class)
            || TextRequestDto.class.equals(Float.class)
            || TextRequestDto.class.equals(Double.class)
            || TextRequestDto.class.equals(Boolean.class)
            || TextRequestDto.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((TextRequestDto.class.equals(Integer.class)
                        || TextRequestDto.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((TextRequestDto.class.equals(Float.class)
                        || TextRequestDto.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (TextRequestDto.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (TextRequestDto.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(TextRequestDto.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'TextRequestDto'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'TextRequestDto'", e);
      }

      if (match == 1) {
        DryRunRequestDto ret = new DryRunRequestDto();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for DryRunRequestDto: %d classes match result, expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public DryRunRequestDto getNullValue(DeserializationContext ctxt) throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "DryRunRequestDto cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public DryRunRequestDto() {
    super("oneOf", Boolean.FALSE);
  }

  public DryRunRequestDto(BinaryRequestDto o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public DryRunRequestDto(MediaRequestDto o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public DryRunRequestDto(TextRequestDto o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("BinaryRequestDto", BinaryRequestDto.class);
    schemas.put("MediaRequestDto", MediaRequestDto.class);
    schemas.put("TextRequestDto", TextRequestDto.class);
    JSONNavigator.registerDescendants(DryRunRequestDto.class, Collections.unmodifiableMap(schemas));
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return DryRunRequestDto.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: BinaryRequestDto, MediaRequestDto, TextRequestDto
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(BinaryRequestDto.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(MediaRequestDto.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(TextRequestDto.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be BinaryRequestDto, MediaRequestDto, TextRequestDto");
  }

  /**
   * Get the actual instance, which can be the following: BinaryRequestDto, MediaRequestDto,
   * TextRequestDto
   *
   * @return The actual instance (BinaryRequestDto, MediaRequestDto, TextRequestDto)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `BinaryRequestDto`. If the actual instance is not
   * `BinaryRequestDto`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `BinaryRequestDto`
   * @throws ClassCastException if the instance is not `BinaryRequestDto`
   */
  public BinaryRequestDto getBinaryRequestDto() throws ClassCastException {
    return (BinaryRequestDto) super.getActualInstance();
  }

  /**
   * Get the actual instance of `MediaRequestDto`. If the actual instance is not `MediaRequestDto`,
   * the ClassCastException will be thrown.
   *
   * @return The actual instance of `MediaRequestDto`
   * @throws ClassCastException if the instance is not `MediaRequestDto`
   */
  public MediaRequestDto getMediaRequestDto() throws ClassCastException {
    return (MediaRequestDto) super.getActualInstance();
  }

  /**
   * Get the actual instance of `TextRequestDto`. If the actual instance is not `TextRequestDto`,
   * the ClassCastException will be thrown.
   *
   * @return The actual instance of `TextRequestDto`
   * @throws ClassCastException if the instance is not `TextRequestDto`
   */
  public TextRequestDto getTextRequestDto() throws ClassCastException {
    return (TextRequestDto) super.getActualInstance();
  }
}
