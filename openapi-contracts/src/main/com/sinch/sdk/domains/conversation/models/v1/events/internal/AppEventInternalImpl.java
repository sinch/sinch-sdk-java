package com.sinch.sdk.domains.conversation.models.v1.events.internal;

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
import com.sinch.sdk.domains.conversation.models.v1.events.types.AgentJoinedEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.types.AgentLeftEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.types.CommentReplyEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.types.ComposingEndEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.types.ComposingEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.types.GenericEventImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(using = AppEventInternalImpl.AppEventInternalImplDeserializer.class)
@JsonSerialize(using = AppEventInternalImpl.AppEventInternalImplSerializer.class)
public class AppEventInternalImpl extends AbstractOpenApiSchema implements AppEventInternal {
  private static final Logger log = Logger.getLogger(AppEventInternalImpl.class.getName());

  public static final class AppEventInternalImplSerializer
      extends StdSerializer<AppEventInternalImpl> {
    private static final long serialVersionUID = 1L;

    public AppEventInternalImplSerializer(Class<AppEventInternalImpl> t) {
      super(t);
    }

    public AppEventInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        AppEventInternalImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class AppEventInternalImplDeserializer
      extends StdDeserializer<AppEventInternalImpl> {

    private static final long serialVersionUID = 1L;

    public AppEventInternalImplDeserializer() {
      this(AppEventInternalImpl.class);
    }

    public AppEventInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public AppEventInternalImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize AgentJoinedEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (AgentJoinedEventImpl.class.equals(Integer.class)
            || AgentJoinedEventImpl.class.equals(Long.class)
            || AgentJoinedEventImpl.class.equals(Float.class)
            || AgentJoinedEventImpl.class.equals(Double.class)
            || AgentJoinedEventImpl.class.equals(Boolean.class)
            || AgentJoinedEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((AgentJoinedEventImpl.class.equals(Integer.class)
                        || AgentJoinedEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((AgentJoinedEventImpl.class.equals(Float.class)
                        || AgentJoinedEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (AgentJoinedEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (AgentJoinedEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(AgentJoinedEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'AgentJoinedEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'AgentJoinedEventImpl'", e);
      }

      // deserialize AgentLeftEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (AgentLeftEventImpl.class.equals(Integer.class)
            || AgentLeftEventImpl.class.equals(Long.class)
            || AgentLeftEventImpl.class.equals(Float.class)
            || AgentLeftEventImpl.class.equals(Double.class)
            || AgentLeftEventImpl.class.equals(Boolean.class)
            || AgentLeftEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((AgentLeftEventImpl.class.equals(Integer.class)
                        || AgentLeftEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((AgentLeftEventImpl.class.equals(Float.class)
                        || AgentLeftEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (AgentLeftEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (AgentLeftEventImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(AgentLeftEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'AgentLeftEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'AgentLeftEventImpl'", e);
      }

      // deserialize CommentReplyEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (CommentReplyEventImpl.class.equals(Integer.class)
            || CommentReplyEventImpl.class.equals(Long.class)
            || CommentReplyEventImpl.class.equals(Float.class)
            || CommentReplyEventImpl.class.equals(Double.class)
            || CommentReplyEventImpl.class.equals(Boolean.class)
            || CommentReplyEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((CommentReplyEventImpl.class.equals(Integer.class)
                        || CommentReplyEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((CommentReplyEventImpl.class.equals(Float.class)
                        || CommentReplyEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (CommentReplyEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (CommentReplyEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(CommentReplyEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'CommentReplyEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'CommentReplyEventImpl'", e);
      }

      // deserialize ComposingEndEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ComposingEndEventImpl.class.equals(Integer.class)
            || ComposingEndEventImpl.class.equals(Long.class)
            || ComposingEndEventImpl.class.equals(Float.class)
            || ComposingEndEventImpl.class.equals(Double.class)
            || ComposingEndEventImpl.class.equals(Boolean.class)
            || ComposingEndEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ComposingEndEventImpl.class.equals(Integer.class)
                        || ComposingEndEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ComposingEndEventImpl.class.equals(Float.class)
                        || ComposingEndEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ComposingEndEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ComposingEndEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(ComposingEndEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ComposingEndEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'ComposingEndEventImpl'", e);
      }

      // deserialize ComposingEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ComposingEventImpl.class.equals(Integer.class)
            || ComposingEventImpl.class.equals(Long.class)
            || ComposingEventImpl.class.equals(Float.class)
            || ComposingEventImpl.class.equals(Double.class)
            || ComposingEventImpl.class.equals(Boolean.class)
            || ComposingEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ComposingEventImpl.class.equals(Integer.class)
                        || ComposingEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ComposingEventImpl.class.equals(Float.class)
                        || ComposingEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ComposingEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ComposingEventImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(ComposingEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ComposingEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'ComposingEventImpl'", e);
      }

      // deserialize GenericEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (GenericEventImpl.class.equals(Integer.class)
            || GenericEventImpl.class.equals(Long.class)
            || GenericEventImpl.class.equals(Float.class)
            || GenericEventImpl.class.equals(Double.class)
            || GenericEventImpl.class.equals(Boolean.class)
            || GenericEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((GenericEventImpl.class.equals(Integer.class)
                        || GenericEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((GenericEventImpl.class.equals(Float.class)
                        || GenericEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (GenericEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (GenericEventImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(GenericEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'GenericEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'GenericEventImpl'", e);
      }

      if (match == 1) {
        AppEventInternalImpl ret = new AppEventInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for AppEventInternalImpl: %d classes match result, expected"
                  + " 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public AppEventInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "AppEventInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public AppEventInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public AppEventInternalImpl(AgentJoinedEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public AppEventInternalImpl(AgentLeftEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public AppEventInternalImpl(CommentReplyEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public AppEventInternalImpl(ComposingEndEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public AppEventInternalImpl(ComposingEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public AppEventInternalImpl(GenericEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("AgentJoinedEventImpl", AgentJoinedEventImpl.class);
    schemas.put("AgentLeftEventImpl", AgentLeftEventImpl.class);
    schemas.put("CommentReplyEventImpl", CommentReplyEventImpl.class);
    schemas.put("ComposingEndEventImpl", ComposingEndEventImpl.class);
    schemas.put("ComposingEventImpl", ComposingEventImpl.class);
    schemas.put("GenericEventImpl", GenericEventImpl.class);
    JSONNavigator.registerDescendants(
        AppEventInternalImpl.class, Collections.unmodifiableMap(schemas));
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return AppEventInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: AgentJoinedEventImpl, AgentLeftEventImpl,
   * CommentReplyEventImpl, ComposingEndEventImpl, ComposingEventImpl, GenericEventImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(AgentJoinedEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(AgentLeftEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        CommentReplyEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        ComposingEndEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(ComposingEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(GenericEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be AgentJoinedEventImpl, AgentLeftEventImpl,"
            + " CommentReplyEventImpl, ComposingEndEventImpl, ComposingEventImpl,"
            + " GenericEventImpl");
  }

  /**
   * Get the actual instance, which can be the following: AgentJoinedEventImpl, AgentLeftEventImpl,
   * CommentReplyEventImpl, ComposingEndEventImpl, ComposingEventImpl, GenericEventImpl
   *
   * @return The actual instance (AgentJoinedEventImpl, AgentLeftEventImpl, CommentReplyEventImpl,
   *     ComposingEndEventImpl, ComposingEventImpl, GenericEventImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `AgentJoinedEventImpl`. If the actual instance is not
   * `AgentJoinedEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `AgentJoinedEventImpl`
   * @throws ClassCastException if the instance is not `AgentJoinedEventImpl`
   */
  public AgentJoinedEventImpl getAgentJoinedEventImpl() throws ClassCastException {
    return (AgentJoinedEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `AgentLeftEventImpl`. If the actual instance is not
   * `AgentLeftEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `AgentLeftEventImpl`
   * @throws ClassCastException if the instance is not `AgentLeftEventImpl`
   */
  public AgentLeftEventImpl getAgentLeftEventImpl() throws ClassCastException {
    return (AgentLeftEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `CommentReplyEventImpl`. If the actual instance is not
   * `CommentReplyEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `CommentReplyEventImpl`
   * @throws ClassCastException if the instance is not `CommentReplyEventImpl`
   */
  public CommentReplyEventImpl getCommentReplyEventImpl() throws ClassCastException {
    return (CommentReplyEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `ComposingEndEventImpl`. If the actual instance is not
   * `ComposingEndEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ComposingEndEventImpl`
   * @throws ClassCastException if the instance is not `ComposingEndEventImpl`
   */
  public ComposingEndEventImpl getComposingEndEventImpl() throws ClassCastException {
    return (ComposingEndEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `ComposingEventImpl`. If the actual instance is not
   * `ComposingEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ComposingEventImpl`
   * @throws ClassCastException if the instance is not `ComposingEventImpl`
   */
  public ComposingEventImpl getComposingEventImpl() throws ClassCastException {
    return (ComposingEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `GenericEventImpl`. If the actual instance is not
   * `GenericEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `GenericEventImpl`
   * @throws ClassCastException if the instance is not `GenericEventImpl`
   */
  public GenericEventImpl getGenericEventImpl() throws ClassCastException {
    return (GenericEventImpl) super.getActualInstance();
  }
}
