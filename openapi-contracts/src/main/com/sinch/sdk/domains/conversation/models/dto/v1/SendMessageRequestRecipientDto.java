/*
 * Conversation API | Sinch
 * Send and receive messages globally over SMS, RCS, WhatsApp, Viber Business, Facebook messenger and other popular channels using the Sinch Conversation API.  The Conversation API endpoint uses built-in transcoding to give you the power of conversation across all supported channels and, if required, full control over channel specific features.
 *
 * The version of the OpenAPI document: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.dto.v1;

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

@JsonDeserialize(
    using = SendMessageRequestRecipientDto.SendMessageRequestRecipientDtoDeserializer.class)
@JsonSerialize(
    using = SendMessageRequestRecipientDto.SendMessageRequestRecipientDtoSerializer.class)
public class SendMessageRequestRecipientDto extends AbstractOpenApiSchema {
  private static final Logger log =
      Logger.getLogger(SendMessageRequestRecipientDto.class.getName());

  public static class SendMessageRequestRecipientDtoSerializer
      extends StdSerializer<SendMessageRequestRecipientDto> {
    public SendMessageRequestRecipientDtoSerializer(Class<SendMessageRequestRecipientDto> t) {
      super(t);
    }

    public SendMessageRequestRecipientDtoSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        SendMessageRequestRecipientDto value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static class SendMessageRequestRecipientDtoDeserializer
      extends StdDeserializer<SendMessageRequestRecipientDto> {
    public SendMessageRequestRecipientDtoDeserializer() {
      this(SendMessageRequestRecipientDto.class);
    }

    public SendMessageRequestRecipientDtoDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public SendMessageRequestRecipientDto deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize ContactIdDto
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ContactIdDto.class.equals(Integer.class)
            || ContactIdDto.class.equals(Long.class)
            || ContactIdDto.class.equals(Float.class)
            || ContactIdDto.class.equals(Double.class)
            || ContactIdDto.class.equals(Boolean.class)
            || ContactIdDto.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ContactIdDto.class.equals(Integer.class) || ContactIdDto.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ContactIdDto.class.equals(Float.class) || ContactIdDto.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ContactIdDto.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ContactIdDto.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(ContactIdDto.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ContactIdDto'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'ContactIdDto'", e);
      }

      // deserialize IdentifiedByDto
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (IdentifiedByDto.class.equals(Integer.class)
            || IdentifiedByDto.class.equals(Long.class)
            || IdentifiedByDto.class.equals(Float.class)
            || IdentifiedByDto.class.equals(Double.class)
            || IdentifiedByDto.class.equals(Boolean.class)
            || IdentifiedByDto.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((IdentifiedByDto.class.equals(Integer.class)
                        || IdentifiedByDto.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((IdentifiedByDto.class.equals(Float.class)
                        || IdentifiedByDto.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (IdentifiedByDto.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (IdentifiedByDto.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(IdentifiedByDto.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'IdentifiedByDto'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'IdentifiedByDto'", e);
      }

      if (match == 1) {
        SendMessageRequestRecipientDto ret = new SendMessageRequestRecipientDto();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for SendMessageRequestRecipientDto: %d classes match result,"
                  + " expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public SendMessageRequestRecipientDto getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(
          ctxt.getParser(), "SendMessageRequestRecipientDto cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public SendMessageRequestRecipientDto() {
    super("oneOf", Boolean.FALSE);
  }

  public SendMessageRequestRecipientDto(ContactIdDto o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public SendMessageRequestRecipientDto(IdentifiedByDto o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("ContactIdDto", ContactIdDto.class);
    schemas.put("IdentifiedByDto", IdentifiedByDto.class);
    JSONNavigator.registerDescendants(
        SendMessageRequestRecipientDto.class, Collections.unmodifiableMap(schemas));
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return SendMessageRequestRecipientDto.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: ContactIdDto, IdentifiedByDto
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(ContactIdDto.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(IdentifiedByDto.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException("Invalid instance type. Must be ContactIdDto, IdentifiedByDto");
  }

  /**
   * Get the actual instance, which can be the following: ContactIdDto, IdentifiedByDto
   *
   * @return The actual instance (ContactIdDto, IdentifiedByDto)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `ContactIdDto`. If the actual instance is not `ContactIdDto`, the
   * ClassCastException will be thrown.
   *
   * @return The actual instance of `ContactIdDto`
   * @throws ClassCastException if the instance is not `ContactIdDto`
   */
  public ContactIdDto getContactIdDto() throws ClassCastException {
    return (ContactIdDto) super.getActualInstance();
  }

  /**
   * Get the actual instance of `IdentifiedByDto`. If the actual instance is not `IdentifiedByDto`,
   * the ClassCastException will be thrown.
   *
   * @return The actual instance of `IdentifiedByDto`
   * @throws ClassCastException if the instance is not `IdentifiedByDto`
   */
  public IdentifiedByDto getIdentifiedByDto() throws ClassCastException {
    return (IdentifiedByDto) super.getActualInstance();
  }
}
