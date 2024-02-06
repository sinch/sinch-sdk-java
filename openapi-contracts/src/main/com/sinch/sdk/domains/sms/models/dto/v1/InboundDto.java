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

@JsonDeserialize(using = InboundDto.InboundDtoDeserializer.class)
@JsonSerialize(using = InboundDto.InboundDtoSerializer.class)
public final class InboundDto extends AbstractOpenApiSchema {
  private static final Logger log = Logger.getLogger(InboundDto.class.getName());

  public static final class InboundDtoSerializer extends StdSerializer<InboundDto> {
    private static final long serialVersionUID = 1L;

    public InboundDtoSerializer(Class<InboundDto> t) {
      super(t);
    }

    public InboundDtoSerializer() {
      this(null);
    }

    @Override
    public void serialize(InboundDto value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class InboundDtoDeserializer extends StdDeserializer<InboundDto> {

    private static final long serialVersionUID = 1L;

    public InboundDtoDeserializer() {
      this(InboundDto.class);
    }

    public InboundDtoDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public InboundDto deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      InboundDto newInboundDto = new InboundDto();
      Map<String, Object> result2 =
          tree.traverse(jp.getCodec()).readValueAs(new TypeReference<Map<String, Object>>() {});
      String discriminatorValue = (String) result2.get("type");
      switch (discriminatorValue) {
        case "MOBinary":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(MOBinaryDto.class);
          newInboundDto.setActualInstance(deserialized);
          return newInboundDto;
        case "MOText":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(MOTextDto.class);
          newInboundDto.setActualInstance(deserialized);
          return newInboundDto;
        case "mo_binary":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(MOBinaryDto.class);
          newInboundDto.setActualInstance(deserialized);
          return newInboundDto;
        case "mo_text":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(MOTextDto.class);
          newInboundDto.setActualInstance(deserialized);
          return newInboundDto;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for InboundDto. Possible values:"
                      + " MOBinary MOText mo_binary mo_text",
                  discriminatorValue));
      }

      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize MOBinaryDto
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (MOBinaryDto.class.equals(Integer.class)
            || MOBinaryDto.class.equals(Long.class)
            || MOBinaryDto.class.equals(Float.class)
            || MOBinaryDto.class.equals(Double.class)
            || MOBinaryDto.class.equals(Boolean.class)
            || MOBinaryDto.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((MOBinaryDto.class.equals(Integer.class) || MOBinaryDto.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((MOBinaryDto.class.equals(Float.class) || MOBinaryDto.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (MOBinaryDto.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (MOBinaryDto.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(MOBinaryDto.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'MOBinaryDto'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'MOBinaryDto'", e);
      }

      // deserialize MOTextDto
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (MOTextDto.class.equals(Integer.class)
            || MOTextDto.class.equals(Long.class)
            || MOTextDto.class.equals(Float.class)
            || MOTextDto.class.equals(Double.class)
            || MOTextDto.class.equals(Boolean.class)
            || MOTextDto.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((MOTextDto.class.equals(Integer.class) || MOTextDto.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((MOTextDto.class.equals(Float.class) || MOTextDto.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (MOTextDto.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (MOTextDto.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(MOTextDto.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'MOTextDto'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'MOTextDto'", e);
      }

      if (match == 1) {
        InboundDto ret = new InboundDto();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for InboundDto: %d classes match result, expected 1", match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public InboundDto getNullValue(DeserializationContext ctxt) throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "InboundDto cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public InboundDto() {
    super("oneOf", Boolean.FALSE);
  }

  public InboundDto(MOBinaryDto o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public InboundDto(MOTextDto o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("MOBinaryDto", MOBinaryDto.class);
    schemas.put("MOTextDto", MOTextDto.class);
    JSONNavigator.registerDescendants(InboundDto.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("MOBinary", MOBinaryDto.class);
    mappings.put("MOText", MOTextDto.class);
    mappings.put("mo_binary", MOBinaryDto.class);
    mappings.put("mo_text", MOTextDto.class);
    mappings.put("Inbound", InboundDto.class);
    JSONNavigator.registerDiscriminator(InboundDto.class, "type", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return InboundDto.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: MOBinaryDto, MOTextDto
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(MOBinaryDto.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(MOTextDto.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException("Invalid instance type. Must be MOBinaryDto, MOTextDto");
  }

  /**
   * Get the actual instance, which can be the following: MOBinaryDto, MOTextDto
   *
   * @return The actual instance (MOBinaryDto, MOTextDto)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `MOBinaryDto`. If the actual instance is not `MOBinaryDto`, the
   * ClassCastException will be thrown.
   *
   * @return The actual instance of `MOBinaryDto`
   * @throws ClassCastException if the instance is not `MOBinaryDto`
   */
  public MOBinaryDto getMOBinaryDto() throws ClassCastException {
    return (MOBinaryDto) super.getActualInstance();
  }

  /**
   * Get the actual instance of `MOTextDto`. If the actual instance is not `MOTextDto`, the
   * ClassCastException will be thrown.
   *
   * @return The actual instance of `MOTextDto`
   * @throws ClassCastException if the instance is not `MOTextDto`
   */
  public MOTextDto getMOTextDto() throws ClassCastException {
    return (MOTextDto) super.getActualInstance();
  }
}
