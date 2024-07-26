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
import com.sinch.sdk.domains.conversation.models.v1.events.types.CommentEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.types.ComposingEndEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.types.ComposingEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.types.ConversationDeletedEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.types.GenericEventImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(using = ContactEventInternalImpl.ContactEventInternalImplDeserializer.class)
@JsonSerialize(using = ContactEventInternalImpl.ContactEventInternalImplSerializer.class)
public class ContactEventInternalImpl extends AbstractOpenApiSchema
    implements ContactEventInternal {
  private static final Logger log = Logger.getLogger(ContactEventInternalImpl.class.getName());

  public static final class ContactEventInternalImplSerializer
      extends StdSerializer<ContactEventInternalImpl> {
    private static final long serialVersionUID = 1L;

    public ContactEventInternalImplSerializer(Class<ContactEventInternalImpl> t) {
      super(t);
    }

    public ContactEventInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        ContactEventInternalImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class ContactEventInternalImplDeserializer
      extends StdDeserializer<ContactEventInternalImpl> {

    private static final long serialVersionUID = 1L;

    public ContactEventInternalImplDeserializer() {
      this(ContactEventInternalImpl.class);
    }

    public ContactEventInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public ContactEventInternalImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize CommentEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (CommentEventImpl.class.equals(Integer.class)
            || CommentEventImpl.class.equals(Long.class)
            || CommentEventImpl.class.equals(Float.class)
            || CommentEventImpl.class.equals(Double.class)
            || CommentEventImpl.class.equals(Boolean.class)
            || CommentEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((CommentEventImpl.class.equals(Integer.class)
                        || CommentEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((CommentEventImpl.class.equals(Float.class)
                        || CommentEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (CommentEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (CommentEventImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(CommentEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'CommentEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'CommentEventImpl'", e);
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

      // deserialize ConversationDeletedEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ConversationDeletedEventImpl.class.equals(Integer.class)
            || ConversationDeletedEventImpl.class.equals(Long.class)
            || ConversationDeletedEventImpl.class.equals(Float.class)
            || ConversationDeletedEventImpl.class.equals(Double.class)
            || ConversationDeletedEventImpl.class.equals(Boolean.class)
            || ConversationDeletedEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ConversationDeletedEventImpl.class.equals(Integer.class)
                        || ConversationDeletedEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ConversationDeletedEventImpl.class.equals(Float.class)
                        || ConversationDeletedEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ConversationDeletedEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ConversationDeletedEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(ConversationDeletedEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ConversationDeletedEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'ConversationDeletedEventImpl'", e);
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
        ContactEventInternalImpl ret = new ContactEventInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for ContactEventInternalImpl: %d classes match result,"
                  + " expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public ContactEventInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "ContactEventInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public ContactEventInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public ContactEventInternalImpl(CommentEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ContactEventInternalImpl(ComposingEndEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ContactEventInternalImpl(ComposingEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ContactEventInternalImpl(ConversationDeletedEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ContactEventInternalImpl(GenericEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("CommentEventImpl", CommentEventImpl.class);
    schemas.put("ComposingEndEventImpl", ComposingEndEventImpl.class);
    schemas.put("ComposingEventImpl", ComposingEventImpl.class);
    schemas.put("ConversationDeletedEventImpl", ConversationDeletedEventImpl.class);
    schemas.put("GenericEventImpl", GenericEventImpl.class);
    JSONNavigator.registerDescendants(
        ContactEventInternalImpl.class, Collections.unmodifiableMap(schemas));
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return ContactEventInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: CommentEventImpl, ComposingEndEventImpl, ComposingEventImpl,
   * ConversationDeletedEventImpl, GenericEventImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(CommentEventImpl.class, instance, new HashSet<Class<?>>())) {
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

    if (JSONNavigator.isInstanceOf(
        ConversationDeletedEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(GenericEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be CommentEventImpl, ComposingEndEventImpl,"
            + " ComposingEventImpl, ConversationDeletedEventImpl, GenericEventImpl");
  }

  /**
   * Get the actual instance, which can be the following: CommentEventImpl, ComposingEndEventImpl,
   * ComposingEventImpl, ConversationDeletedEventImpl, GenericEventImpl
   *
   * @return The actual instance (CommentEventImpl, ComposingEndEventImpl, ComposingEventImpl,
   *     ConversationDeletedEventImpl, GenericEventImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `CommentEventImpl`. If the actual instance is not
   * `CommentEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `CommentEventImpl`
   * @throws ClassCastException if the instance is not `CommentEventImpl`
   */
  public CommentEventImpl getCommentEventImpl() throws ClassCastException {
    return (CommentEventImpl) super.getActualInstance();
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
   * Get the actual instance of `ConversationDeletedEventImpl`. If the actual instance is not
   * `ConversationDeletedEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ConversationDeletedEventImpl`
   * @throws ClassCastException if the instance is not `ConversationDeletedEventImpl`
   */
  public ConversationDeletedEventImpl getConversationDeletedEventImpl() throws ClassCastException {
    return (ConversationDeletedEventImpl) super.getActualInstance();
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
