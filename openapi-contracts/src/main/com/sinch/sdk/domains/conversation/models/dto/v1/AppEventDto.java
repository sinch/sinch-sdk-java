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

@JsonDeserialize(using = AppEventDto.AppEventDtoDeserializer.class)
@JsonSerialize(using = AppEventDto.AppEventDtoSerializer.class)
public class AppEventDto extends AbstractOpenApiSchema {
  private static final Logger log = Logger.getLogger(AppEventDto.class.getName());

  public static class AppEventDtoSerializer extends StdSerializer<AppEventDto> {
    public AppEventDtoSerializer(Class<AppEventDto> t) {
      super(t);
    }

    public AppEventDtoSerializer() {
      this(null);
    }

    @Override
    public void serialize(AppEventDto value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static class AppEventDtoDeserializer extends StdDeserializer<AppEventDto> {
    public AppEventDtoDeserializer() {
      this(AppEventDto.class);
    }

    public AppEventDtoDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public AppEventDto deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize AgentJoinedEventDto
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (AgentJoinedEventDto.class.equals(Integer.class)
            || AgentJoinedEventDto.class.equals(Long.class)
            || AgentJoinedEventDto.class.equals(Float.class)
            || AgentJoinedEventDto.class.equals(Double.class)
            || AgentJoinedEventDto.class.equals(Boolean.class)
            || AgentJoinedEventDto.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((AgentJoinedEventDto.class.equals(Integer.class)
                        || AgentJoinedEventDto.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((AgentJoinedEventDto.class.equals(Float.class)
                        || AgentJoinedEventDto.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (AgentJoinedEventDto.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (AgentJoinedEventDto.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(AgentJoinedEventDto.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'AgentJoinedEventDto'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'AgentJoinedEventDto'", e);
      }

      // deserialize AgentLeftEventDto
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (AgentLeftEventDto.class.equals(Integer.class)
            || AgentLeftEventDto.class.equals(Long.class)
            || AgentLeftEventDto.class.equals(Float.class)
            || AgentLeftEventDto.class.equals(Double.class)
            || AgentLeftEventDto.class.equals(Boolean.class)
            || AgentLeftEventDto.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((AgentLeftEventDto.class.equals(Integer.class)
                        || AgentLeftEventDto.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((AgentLeftEventDto.class.equals(Float.class)
                        || AgentLeftEventDto.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (AgentLeftEventDto.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (AgentLeftEventDto.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(AgentLeftEventDto.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'AgentLeftEventDto'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'AgentLeftEventDto'", e);
      }

      // deserialize CommentReplyEventDto
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (CommentReplyEventDto.class.equals(Integer.class)
            || CommentReplyEventDto.class.equals(Long.class)
            || CommentReplyEventDto.class.equals(Float.class)
            || CommentReplyEventDto.class.equals(Double.class)
            || CommentReplyEventDto.class.equals(Boolean.class)
            || CommentReplyEventDto.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((CommentReplyEventDto.class.equals(Integer.class)
                        || CommentReplyEventDto.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((CommentReplyEventDto.class.equals(Float.class)
                        || CommentReplyEventDto.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (CommentReplyEventDto.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (CommentReplyEventDto.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(CommentReplyEventDto.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'CommentReplyEventDto'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'CommentReplyEventDto'", e);
      }

      // deserialize ComposingEndEventDto
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ComposingEndEventDto.class.equals(Integer.class)
            || ComposingEndEventDto.class.equals(Long.class)
            || ComposingEndEventDto.class.equals(Float.class)
            || ComposingEndEventDto.class.equals(Double.class)
            || ComposingEndEventDto.class.equals(Boolean.class)
            || ComposingEndEventDto.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ComposingEndEventDto.class.equals(Integer.class)
                        || ComposingEndEventDto.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ComposingEndEventDto.class.equals(Float.class)
                        || ComposingEndEventDto.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ComposingEndEventDto.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ComposingEndEventDto.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(ComposingEndEventDto.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ComposingEndEventDto'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'ComposingEndEventDto'", e);
      }

      // deserialize ComposingEventDto
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ComposingEventDto.class.equals(Integer.class)
            || ComposingEventDto.class.equals(Long.class)
            || ComposingEventDto.class.equals(Float.class)
            || ComposingEventDto.class.equals(Double.class)
            || ComposingEventDto.class.equals(Boolean.class)
            || ComposingEventDto.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ComposingEventDto.class.equals(Integer.class)
                        || ComposingEventDto.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ComposingEventDto.class.equals(Float.class)
                        || ComposingEventDto.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ComposingEventDto.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ComposingEventDto.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(ComposingEventDto.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ComposingEventDto'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'ComposingEventDto'", e);
      }

      // deserialize GenericEventDto
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (GenericEventDto.class.equals(Integer.class)
            || GenericEventDto.class.equals(Long.class)
            || GenericEventDto.class.equals(Float.class)
            || GenericEventDto.class.equals(Double.class)
            || GenericEventDto.class.equals(Boolean.class)
            || GenericEventDto.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((GenericEventDto.class.equals(Integer.class)
                        || GenericEventDto.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((GenericEventDto.class.equals(Float.class)
                        || GenericEventDto.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (GenericEventDto.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (GenericEventDto.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(GenericEventDto.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'GenericEventDto'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'GenericEventDto'", e);
      }

      if (match == 1) {
        AppEventDto ret = new AppEventDto();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for AppEventDto: %d classes match result, expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public AppEventDto getNullValue(DeserializationContext ctxt) throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "AppEventDto cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public AppEventDto() {
    super("oneOf", Boolean.FALSE);
  }

  public AppEventDto(AgentJoinedEventDto o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public AppEventDto(AgentLeftEventDto o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public AppEventDto(CommentReplyEventDto o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public AppEventDto(ComposingEndEventDto o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public AppEventDto(ComposingEventDto o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public AppEventDto(GenericEventDto o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("AgentJoinedEventDto", AgentJoinedEventDto.class);
    schemas.put("AgentLeftEventDto", AgentLeftEventDto.class);
    schemas.put("CommentReplyEventDto", CommentReplyEventDto.class);
    schemas.put("ComposingEndEventDto", ComposingEndEventDto.class);
    schemas.put("ComposingEventDto", ComposingEventDto.class);
    schemas.put("GenericEventDto", GenericEventDto.class);
    JSONNavigator.registerDescendants(AppEventDto.class, Collections.unmodifiableMap(schemas));
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return AppEventDto.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: AgentJoinedEventDto, AgentLeftEventDto, CommentReplyEventDto,
   * ComposingEndEventDto, ComposingEventDto, GenericEventDto
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(AgentJoinedEventDto.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(AgentLeftEventDto.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(CommentReplyEventDto.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(ComposingEndEventDto.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(ComposingEventDto.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(GenericEventDto.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be AgentJoinedEventDto, AgentLeftEventDto,"
            + " CommentReplyEventDto, ComposingEndEventDto, ComposingEventDto, GenericEventDto");
  }

  /**
   * Get the actual instance, which can be the following: AgentJoinedEventDto, AgentLeftEventDto,
   * CommentReplyEventDto, ComposingEndEventDto, ComposingEventDto, GenericEventDto
   *
   * @return The actual instance (AgentJoinedEventDto, AgentLeftEventDto, CommentReplyEventDto,
   *     ComposingEndEventDto, ComposingEventDto, GenericEventDto)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `AgentJoinedEventDto`. If the actual instance is not
   * `AgentJoinedEventDto`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `AgentJoinedEventDto`
   * @throws ClassCastException if the instance is not `AgentJoinedEventDto`
   */
  public AgentJoinedEventDto getAgentJoinedEventDto() throws ClassCastException {
    return (AgentJoinedEventDto) super.getActualInstance();
  }

  /**
   * Get the actual instance of `AgentLeftEventDto`. If the actual instance is not
   * `AgentLeftEventDto`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `AgentLeftEventDto`
   * @throws ClassCastException if the instance is not `AgentLeftEventDto`
   */
  public AgentLeftEventDto getAgentLeftEventDto() throws ClassCastException {
    return (AgentLeftEventDto) super.getActualInstance();
  }

  /**
   * Get the actual instance of `CommentReplyEventDto`. If the actual instance is not
   * `CommentReplyEventDto`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `CommentReplyEventDto`
   * @throws ClassCastException if the instance is not `CommentReplyEventDto`
   */
  public CommentReplyEventDto getCommentReplyEventDto() throws ClassCastException {
    return (CommentReplyEventDto) super.getActualInstance();
  }

  /**
   * Get the actual instance of `ComposingEndEventDto`. If the actual instance is not
   * `ComposingEndEventDto`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ComposingEndEventDto`
   * @throws ClassCastException if the instance is not `ComposingEndEventDto`
   */
  public ComposingEndEventDto getComposingEndEventDto() throws ClassCastException {
    return (ComposingEndEventDto) super.getActualInstance();
  }

  /**
   * Get the actual instance of `ComposingEventDto`. If the actual instance is not
   * `ComposingEventDto`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ComposingEventDto`
   * @throws ClassCastException if the instance is not `ComposingEventDto`
   */
  public ComposingEventDto getComposingEventDto() throws ClassCastException {
    return (ComposingEventDto) super.getActualInstance();
  }

  /**
   * Get the actual instance of `GenericEventDto`. If the actual instance is not `GenericEventDto`,
   * the ClassCastException will be thrown.
   *
   * @return The actual instance of `GenericEventDto`
   * @throws ClassCastException if the instance is not `GenericEventDto`
   */
  public GenericEventDto getGenericEventDto() throws ClassCastException {
    return (GenericEventDto) super.getActualInstance();
  }
}
