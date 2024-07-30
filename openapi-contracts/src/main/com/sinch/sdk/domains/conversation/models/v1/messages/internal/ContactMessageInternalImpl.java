package com.sinch.sdk.domains.conversation.models.v1.messages.internal;

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
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.ChannelSpecificContactMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choiceresponse.ChoiceResponseMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.fallback.FallbackMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.LocationMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.mediacard.MediaCardMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.productresponse.ProductResponseMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.replyto.ReplyToMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessageImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(using = ContactMessageInternalImpl.ContactMessageInternalImplDeserializer.class)
@JsonSerialize(using = ContactMessageInternalImpl.ContactMessageInternalImplSerializer.class)
public class ContactMessageInternalImpl extends AbstractOpenApiSchema
    implements ContactMessageInternal {
  private static final Logger log = Logger.getLogger(ContactMessageInternalImpl.class.getName());

  public static final class ContactMessageInternalImplSerializer
      extends StdSerializer<ContactMessageInternalImpl> {
    private static final long serialVersionUID = 1L;

    public ContactMessageInternalImplSerializer(Class<ContactMessageInternalImpl> t) {
      super(t);
    }

    public ContactMessageInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        ContactMessageInternalImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class ContactMessageInternalImplDeserializer
      extends StdDeserializer<ContactMessageInternalImpl> {

    private static final long serialVersionUID = 1L;

    public ContactMessageInternalImplDeserializer() {
      this(ContactMessageInternalImpl.class);
    }

    public ContactMessageInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public ContactMessageInternalImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize ChannelSpecificContactMessageImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ChannelSpecificContactMessageImpl.class.equals(Integer.class)
            || ChannelSpecificContactMessageImpl.class.equals(Long.class)
            || ChannelSpecificContactMessageImpl.class.equals(Float.class)
            || ChannelSpecificContactMessageImpl.class.equals(Double.class)
            || ChannelSpecificContactMessageImpl.class.equals(Boolean.class)
            || ChannelSpecificContactMessageImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ChannelSpecificContactMessageImpl.class.equals(Integer.class)
                        || ChannelSpecificContactMessageImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ChannelSpecificContactMessageImpl.class.equals(Float.class)
                        || ChannelSpecificContactMessageImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ChannelSpecificContactMessageImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ChannelSpecificContactMessageImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(ChannelSpecificContactMessageImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ChannelSpecificContactMessageImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'ChannelSpecificContactMessageImpl'", e);
      }

      // deserialize ChoiceResponseMessageImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ChoiceResponseMessageImpl.class.equals(Integer.class)
            || ChoiceResponseMessageImpl.class.equals(Long.class)
            || ChoiceResponseMessageImpl.class.equals(Float.class)
            || ChoiceResponseMessageImpl.class.equals(Double.class)
            || ChoiceResponseMessageImpl.class.equals(Boolean.class)
            || ChoiceResponseMessageImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ChoiceResponseMessageImpl.class.equals(Integer.class)
                        || ChoiceResponseMessageImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ChoiceResponseMessageImpl.class.equals(Float.class)
                        || ChoiceResponseMessageImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ChoiceResponseMessageImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ChoiceResponseMessageImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(ChoiceResponseMessageImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ChoiceResponseMessageImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'ChoiceResponseMessageImpl'", e);
      }

      // deserialize FallbackMessageImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (FallbackMessageImpl.class.equals(Integer.class)
            || FallbackMessageImpl.class.equals(Long.class)
            || FallbackMessageImpl.class.equals(Float.class)
            || FallbackMessageImpl.class.equals(Double.class)
            || FallbackMessageImpl.class.equals(Boolean.class)
            || FallbackMessageImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((FallbackMessageImpl.class.equals(Integer.class)
                        || FallbackMessageImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((FallbackMessageImpl.class.equals(Float.class)
                        || FallbackMessageImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (FallbackMessageImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (FallbackMessageImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(FallbackMessageImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'FallbackMessageImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'FallbackMessageImpl'", e);
      }

      // deserialize LocationMessageImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (LocationMessageImpl.class.equals(Integer.class)
            || LocationMessageImpl.class.equals(Long.class)
            || LocationMessageImpl.class.equals(Float.class)
            || LocationMessageImpl.class.equals(Double.class)
            || LocationMessageImpl.class.equals(Boolean.class)
            || LocationMessageImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((LocationMessageImpl.class.equals(Integer.class)
                        || LocationMessageImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((LocationMessageImpl.class.equals(Float.class)
                        || LocationMessageImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (LocationMessageImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (LocationMessageImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(LocationMessageImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'LocationMessageImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'LocationMessageImpl'", e);
      }

      // deserialize MediaCardMessageImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (MediaCardMessageImpl.class.equals(Integer.class)
            || MediaCardMessageImpl.class.equals(Long.class)
            || MediaCardMessageImpl.class.equals(Float.class)
            || MediaCardMessageImpl.class.equals(Double.class)
            || MediaCardMessageImpl.class.equals(Boolean.class)
            || MediaCardMessageImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((MediaCardMessageImpl.class.equals(Integer.class)
                        || MediaCardMessageImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((MediaCardMessageImpl.class.equals(Float.class)
                        || MediaCardMessageImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (MediaCardMessageImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (MediaCardMessageImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(MediaCardMessageImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'MediaCardMessageImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'MediaCardMessageImpl'", e);
      }

      // deserialize MediaMessageImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (MediaMessageImpl.class.equals(Integer.class)
            || MediaMessageImpl.class.equals(Long.class)
            || MediaMessageImpl.class.equals(Float.class)
            || MediaMessageImpl.class.equals(Double.class)
            || MediaMessageImpl.class.equals(Boolean.class)
            || MediaMessageImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((MediaMessageImpl.class.equals(Integer.class)
                        || MediaMessageImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((MediaMessageImpl.class.equals(Float.class)
                        || MediaMessageImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (MediaMessageImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (MediaMessageImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(MediaMessageImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'MediaMessageImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'MediaMessageImpl'", e);
      }

      // deserialize ProductResponseMessageImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ProductResponseMessageImpl.class.equals(Integer.class)
            || ProductResponseMessageImpl.class.equals(Long.class)
            || ProductResponseMessageImpl.class.equals(Float.class)
            || ProductResponseMessageImpl.class.equals(Double.class)
            || ProductResponseMessageImpl.class.equals(Boolean.class)
            || ProductResponseMessageImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ProductResponseMessageImpl.class.equals(Integer.class)
                        || ProductResponseMessageImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ProductResponseMessageImpl.class.equals(Float.class)
                        || ProductResponseMessageImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ProductResponseMessageImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ProductResponseMessageImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(ProductResponseMessageImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ProductResponseMessageImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'ProductResponseMessageImpl'", e);
      }

      // deserialize ReplyToMessageImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ReplyToMessageImpl.class.equals(Integer.class)
            || ReplyToMessageImpl.class.equals(Long.class)
            || ReplyToMessageImpl.class.equals(Float.class)
            || ReplyToMessageImpl.class.equals(Double.class)
            || ReplyToMessageImpl.class.equals(Boolean.class)
            || ReplyToMessageImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ReplyToMessageImpl.class.equals(Integer.class)
                        || ReplyToMessageImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ReplyToMessageImpl.class.equals(Float.class)
                        || ReplyToMessageImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ReplyToMessageImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ReplyToMessageImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(ReplyToMessageImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ReplyToMessageImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'ReplyToMessageImpl'", e);
      }

      // deserialize TextMessageImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (TextMessageImpl.class.equals(Integer.class)
            || TextMessageImpl.class.equals(Long.class)
            || TextMessageImpl.class.equals(Float.class)
            || TextMessageImpl.class.equals(Double.class)
            || TextMessageImpl.class.equals(Boolean.class)
            || TextMessageImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((TextMessageImpl.class.equals(Integer.class)
                        || TextMessageImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((TextMessageImpl.class.equals(Float.class)
                        || TextMessageImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (TextMessageImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (TextMessageImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(TextMessageImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'TextMessageImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'TextMessageImpl'", e);
      }

      if (match == 1) {
        ContactMessageInternalImpl ret = new ContactMessageInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for ContactMessageInternalImpl: %d classes match result,"
                  + " expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public ContactMessageInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "ContactMessageInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public ContactMessageInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public ContactMessageInternalImpl(ChannelSpecificContactMessageImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ContactMessageInternalImpl(ChoiceResponseMessageImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ContactMessageInternalImpl(FallbackMessageImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ContactMessageInternalImpl(LocationMessageImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ContactMessageInternalImpl(MediaCardMessageImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ContactMessageInternalImpl(MediaMessageImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ContactMessageInternalImpl(ProductResponseMessageImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ContactMessageInternalImpl(ReplyToMessageImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ContactMessageInternalImpl(TextMessageImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("ChannelSpecificContactMessageImpl", ChannelSpecificContactMessageImpl.class);
    schemas.put("ChoiceResponseMessageImpl", ChoiceResponseMessageImpl.class);
    schemas.put("FallbackMessageImpl", FallbackMessageImpl.class);
    schemas.put("LocationMessageImpl", LocationMessageImpl.class);
    schemas.put("MediaCardMessageImpl", MediaCardMessageImpl.class);
    schemas.put("MediaMessageImpl", MediaMessageImpl.class);
    schemas.put("ProductResponseMessageImpl", ProductResponseMessageImpl.class);
    schemas.put("ReplyToMessageImpl", ReplyToMessageImpl.class);
    schemas.put("TextMessageImpl", TextMessageImpl.class);
    JSONNavigator.registerDescendants(
        ContactMessageInternalImpl.class, Collections.unmodifiableMap(schemas));
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return ContactMessageInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: ChannelSpecificContactMessageImpl, ChoiceResponseMessageImpl,
   * FallbackMessageImpl, LocationMessageImpl, MediaCardMessageImpl, MediaMessageImpl,
   * ProductResponseMessageImpl, ReplyToMessageImpl, TextMessageImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        ChannelSpecificContactMessageImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        ChoiceResponseMessageImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(FallbackMessageImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(LocationMessageImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(MediaCardMessageImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(MediaMessageImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        ProductResponseMessageImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(ReplyToMessageImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(TextMessageImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be ChannelSpecificContactMessageImpl,"
            + " ChoiceResponseMessageImpl, FallbackMessageImpl, LocationMessageImpl,"
            + " MediaCardMessageImpl, MediaMessageImpl, ProductResponseMessageImpl,"
            + " ReplyToMessageImpl, TextMessageImpl");
  }

  /**
   * Get the actual instance, which can be the following: ChannelSpecificContactMessageImpl,
   * ChoiceResponseMessageImpl, FallbackMessageImpl, LocationMessageImpl, MediaCardMessageImpl,
   * MediaMessageImpl, ProductResponseMessageImpl, ReplyToMessageImpl, TextMessageImpl
   *
   * @return The actual instance (ChannelSpecificContactMessageImpl, ChoiceResponseMessageImpl,
   *     FallbackMessageImpl, LocationMessageImpl, MediaCardMessageImpl, MediaMessageImpl,
   *     ProductResponseMessageImpl, ReplyToMessageImpl, TextMessageImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `ChannelSpecificContactMessageImpl`. If the actual instance is not
   * `ChannelSpecificContactMessageImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ChannelSpecificContactMessageImpl`
   * @throws ClassCastException if the instance is not `ChannelSpecificContactMessageImpl`
   */
  public ChannelSpecificContactMessageImpl getChannelSpecificContactMessageImpl()
      throws ClassCastException {
    return (ChannelSpecificContactMessageImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `ChoiceResponseMessageImpl`. If the actual instance is not
   * `ChoiceResponseMessageImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ChoiceResponseMessageImpl`
   * @throws ClassCastException if the instance is not `ChoiceResponseMessageImpl`
   */
  public ChoiceResponseMessageImpl getChoiceResponseMessageImpl() throws ClassCastException {
    return (ChoiceResponseMessageImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `FallbackMessageImpl`. If the actual instance is not
   * `FallbackMessageImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `FallbackMessageImpl`
   * @throws ClassCastException if the instance is not `FallbackMessageImpl`
   */
  public FallbackMessageImpl getFallbackMessageImpl() throws ClassCastException {
    return (FallbackMessageImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `LocationMessageImpl`. If the actual instance is not
   * `LocationMessageImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `LocationMessageImpl`
   * @throws ClassCastException if the instance is not `LocationMessageImpl`
   */
  public LocationMessageImpl getLocationMessageImpl() throws ClassCastException {
    return (LocationMessageImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `MediaCardMessageImpl`. If the actual instance is not
   * `MediaCardMessageImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `MediaCardMessageImpl`
   * @throws ClassCastException if the instance is not `MediaCardMessageImpl`
   */
  public MediaCardMessageImpl getMediaCardMessageImpl() throws ClassCastException {
    return (MediaCardMessageImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `MediaMessageImpl`. If the actual instance is not
   * `MediaMessageImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `MediaMessageImpl`
   * @throws ClassCastException if the instance is not `MediaMessageImpl`
   */
  public MediaMessageImpl getMediaMessageImpl() throws ClassCastException {
    return (MediaMessageImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `ProductResponseMessageImpl`. If the actual instance is not
   * `ProductResponseMessageImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ProductResponseMessageImpl`
   * @throws ClassCastException if the instance is not `ProductResponseMessageImpl`
   */
  public ProductResponseMessageImpl getProductResponseMessageImpl() throws ClassCastException {
    return (ProductResponseMessageImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `ReplyToMessageImpl`. If the actual instance is not
   * `ReplyToMessageImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ReplyToMessageImpl`
   * @throws ClassCastException if the instance is not `ReplyToMessageImpl`
   */
  public ReplyToMessageImpl getReplyToMessageImpl() throws ClassCastException {
    return (ReplyToMessageImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `TextMessageImpl`. If the actual instance is not `TextMessageImpl`,
   * the ClassCastException will be thrown.
   *
   * @return The actual instance of `TextMessageImpl`
   * @throws ClassCastException if the instance is not `TextMessageImpl`
   */
  public TextMessageImpl getTextMessageImpl() throws ClassCastException {
    return (TextMessageImpl) super.getActualInstance();
  }
}
