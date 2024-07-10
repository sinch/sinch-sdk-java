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
import com.sinch.sdk.domains.conversation.models.v1.messages.ProductResponseMessageImpl;
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
      // deserialize ChannelSpecificContactMessageInternalImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ChannelSpecificContactMessageInternalImpl.class.equals(Integer.class)
            || ChannelSpecificContactMessageInternalImpl.class.equals(Long.class)
            || ChannelSpecificContactMessageInternalImpl.class.equals(Float.class)
            || ChannelSpecificContactMessageInternalImpl.class.equals(Double.class)
            || ChannelSpecificContactMessageInternalImpl.class.equals(Boolean.class)
            || ChannelSpecificContactMessageInternalImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ChannelSpecificContactMessageInternalImpl.class.equals(Integer.class)
                        || ChannelSpecificContactMessageInternalImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ChannelSpecificContactMessageInternalImpl.class.equals(Float.class)
                        || ChannelSpecificContactMessageInternalImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ChannelSpecificContactMessageInternalImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ChannelSpecificContactMessageInternalImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(ChannelSpecificContactMessageInternalImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER, "Input data matches schema 'ChannelSpecificContactMessageInternalImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'ChannelSpecificContactMessageInternalImpl'",
            e);
      }

      // deserialize ChoiceResponseMessageFieldInternalImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ChoiceResponseMessageFieldInternalImpl.class.equals(Integer.class)
            || ChoiceResponseMessageFieldInternalImpl.class.equals(Long.class)
            || ChoiceResponseMessageFieldInternalImpl.class.equals(Float.class)
            || ChoiceResponseMessageFieldInternalImpl.class.equals(Double.class)
            || ChoiceResponseMessageFieldInternalImpl.class.equals(Boolean.class)
            || ChoiceResponseMessageFieldInternalImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ChoiceResponseMessageFieldInternalImpl.class.equals(Integer.class)
                        || ChoiceResponseMessageFieldInternalImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ChoiceResponseMessageFieldInternalImpl.class.equals(Float.class)
                        || ChoiceResponseMessageFieldInternalImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ChoiceResponseMessageFieldInternalImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ChoiceResponseMessageFieldInternalImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(ChoiceResponseMessageFieldInternalImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER, "Input data matches schema 'ChoiceResponseMessageFieldInternalImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'ChoiceResponseMessageFieldInternalImpl'",
            e);
      }

      // deserialize FallbackMessageFieldInternalImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (FallbackMessageFieldInternalImpl.class.equals(Integer.class)
            || FallbackMessageFieldInternalImpl.class.equals(Long.class)
            || FallbackMessageFieldInternalImpl.class.equals(Float.class)
            || FallbackMessageFieldInternalImpl.class.equals(Double.class)
            || FallbackMessageFieldInternalImpl.class.equals(Boolean.class)
            || FallbackMessageFieldInternalImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((FallbackMessageFieldInternalImpl.class.equals(Integer.class)
                        || FallbackMessageFieldInternalImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((FallbackMessageFieldInternalImpl.class.equals(Float.class)
                        || FallbackMessageFieldInternalImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (FallbackMessageFieldInternalImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (FallbackMessageFieldInternalImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(FallbackMessageFieldInternalImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'FallbackMessageFieldInternalImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'FallbackMessageFieldInternalImpl'", e);
      }

      // deserialize LocationMessageFieldInternalImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (LocationMessageFieldInternalImpl.class.equals(Integer.class)
            || LocationMessageFieldInternalImpl.class.equals(Long.class)
            || LocationMessageFieldInternalImpl.class.equals(Float.class)
            || LocationMessageFieldInternalImpl.class.equals(Double.class)
            || LocationMessageFieldInternalImpl.class.equals(Boolean.class)
            || LocationMessageFieldInternalImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((LocationMessageFieldInternalImpl.class.equals(Integer.class)
                        || LocationMessageFieldInternalImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((LocationMessageFieldInternalImpl.class.equals(Float.class)
                        || LocationMessageFieldInternalImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (LocationMessageFieldInternalImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (LocationMessageFieldInternalImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(LocationMessageFieldInternalImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'LocationMessageFieldInternalImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'LocationMessageFieldInternalImpl'", e);
      }

      // deserialize MediaCardMessageFieldInternalImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (MediaCardMessageFieldInternalImpl.class.equals(Integer.class)
            || MediaCardMessageFieldInternalImpl.class.equals(Long.class)
            || MediaCardMessageFieldInternalImpl.class.equals(Float.class)
            || MediaCardMessageFieldInternalImpl.class.equals(Double.class)
            || MediaCardMessageFieldInternalImpl.class.equals(Boolean.class)
            || MediaCardMessageFieldInternalImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((MediaCardMessageFieldInternalImpl.class.equals(Integer.class)
                        || MediaCardMessageFieldInternalImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((MediaCardMessageFieldInternalImpl.class.equals(Float.class)
                        || MediaCardMessageFieldInternalImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (MediaCardMessageFieldInternalImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (MediaCardMessageFieldInternalImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(MediaCardMessageFieldInternalImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'MediaCardMessageFieldInternalImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'MediaCardMessageFieldInternalImpl'", e);
      }

      // deserialize MediaMessageFieldInternalImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (MediaMessageFieldInternalImpl.class.equals(Integer.class)
            || MediaMessageFieldInternalImpl.class.equals(Long.class)
            || MediaMessageFieldInternalImpl.class.equals(Float.class)
            || MediaMessageFieldInternalImpl.class.equals(Double.class)
            || MediaMessageFieldInternalImpl.class.equals(Boolean.class)
            || MediaMessageFieldInternalImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((MediaMessageFieldInternalImpl.class.equals(Integer.class)
                        || MediaMessageFieldInternalImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((MediaMessageFieldInternalImpl.class.equals(Float.class)
                        || MediaMessageFieldInternalImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (MediaMessageFieldInternalImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (MediaMessageFieldInternalImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(MediaMessageFieldInternalImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'MediaMessageFieldInternalImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'MediaMessageFieldInternalImpl'", e);
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

      // deserialize ReplyToMessageFieldInternalImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ReplyToMessageFieldInternalImpl.class.equals(Integer.class)
            || ReplyToMessageFieldInternalImpl.class.equals(Long.class)
            || ReplyToMessageFieldInternalImpl.class.equals(Float.class)
            || ReplyToMessageFieldInternalImpl.class.equals(Double.class)
            || ReplyToMessageFieldInternalImpl.class.equals(Boolean.class)
            || ReplyToMessageFieldInternalImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ReplyToMessageFieldInternalImpl.class.equals(Integer.class)
                        || ReplyToMessageFieldInternalImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ReplyToMessageFieldInternalImpl.class.equals(Float.class)
                        || ReplyToMessageFieldInternalImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ReplyToMessageFieldInternalImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ReplyToMessageFieldInternalImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(ReplyToMessageFieldInternalImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ReplyToMessageFieldInternalImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'ReplyToMessageFieldInternalImpl'", e);
      }

      // deserialize TextMessageFieldInternalImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (TextMessageFieldInternalImpl.class.equals(Integer.class)
            || TextMessageFieldInternalImpl.class.equals(Long.class)
            || TextMessageFieldInternalImpl.class.equals(Float.class)
            || TextMessageFieldInternalImpl.class.equals(Double.class)
            || TextMessageFieldInternalImpl.class.equals(Boolean.class)
            || TextMessageFieldInternalImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((TextMessageFieldInternalImpl.class.equals(Integer.class)
                        || TextMessageFieldInternalImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((TextMessageFieldInternalImpl.class.equals(Float.class)
                        || TextMessageFieldInternalImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (TextMessageFieldInternalImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (TextMessageFieldInternalImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(TextMessageFieldInternalImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'TextMessageFieldInternalImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'TextMessageFieldInternalImpl'", e);
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

  public ContactMessageInternalImpl(ChannelSpecificContactMessageInternalImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ContactMessageInternalImpl(ChoiceResponseMessageFieldInternalImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ContactMessageInternalImpl(FallbackMessageFieldInternalImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ContactMessageInternalImpl(LocationMessageFieldInternalImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ContactMessageInternalImpl(MediaCardMessageFieldInternalImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ContactMessageInternalImpl(MediaMessageFieldInternalImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ContactMessageInternalImpl(ProductResponseMessageImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ContactMessageInternalImpl(ReplyToMessageFieldInternalImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ContactMessageInternalImpl(TextMessageFieldInternalImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put(
        "ChannelSpecificContactMessageInternalImpl",
        ChannelSpecificContactMessageInternalImpl.class);
    schemas.put(
        "ChoiceResponseMessageFieldInternalImpl", ChoiceResponseMessageFieldInternalImpl.class);
    schemas.put("FallbackMessageFieldInternalImpl", FallbackMessageFieldInternalImpl.class);
    schemas.put("LocationMessageFieldInternalImpl", LocationMessageFieldInternalImpl.class);
    schemas.put("MediaCardMessageFieldInternalImpl", MediaCardMessageFieldInternalImpl.class);
    schemas.put("MediaMessageFieldInternalImpl", MediaMessageFieldInternalImpl.class);
    schemas.put("ProductResponseMessageImpl", ProductResponseMessageImpl.class);
    schemas.put("ReplyToMessageFieldInternalImpl", ReplyToMessageFieldInternalImpl.class);
    schemas.put("TextMessageFieldInternalImpl", TextMessageFieldInternalImpl.class);
    JSONNavigator.registerDescendants(
        ContactMessageInternalImpl.class, Collections.unmodifiableMap(schemas));
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return ContactMessageInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: ChannelSpecificContactMessageInternalImpl,
   * ChoiceResponseMessageFieldInternalImpl, FallbackMessageFieldInternalImpl,
   * LocationMessageFieldInternalImpl, MediaCardMessageFieldInternalImpl,
   * MediaMessageFieldInternalImpl, ProductResponseMessageImpl, ReplyToMessageFieldInternalImpl,
   * TextMessageFieldInternalImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        ChannelSpecificContactMessageInternalImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        ChoiceResponseMessageFieldInternalImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        FallbackMessageFieldInternalImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        LocationMessageFieldInternalImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        MediaCardMessageFieldInternalImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        MediaMessageFieldInternalImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        ProductResponseMessageImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        ReplyToMessageFieldInternalImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        TextMessageFieldInternalImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be ChannelSpecificContactMessageInternalImpl,"
            + " ChoiceResponseMessageFieldInternalImpl, FallbackMessageFieldInternalImpl,"
            + " LocationMessageFieldInternalImpl, MediaCardMessageFieldInternalImpl,"
            + " MediaMessageFieldInternalImpl, ProductResponseMessageImpl,"
            + " ReplyToMessageFieldInternalImpl, TextMessageFieldInternalImpl");
  }

  /**
   * Get the actual instance, which can be the following: ChannelSpecificContactMessageInternalImpl,
   * ChoiceResponseMessageFieldInternalImpl, FallbackMessageFieldInternalImpl,
   * LocationMessageFieldInternalImpl, MediaCardMessageFieldInternalImpl,
   * MediaMessageFieldInternalImpl, ProductResponseMessageImpl, ReplyToMessageFieldInternalImpl,
   * TextMessageFieldInternalImpl
   *
   * @return The actual instance (ChannelSpecificContactMessageInternalImpl,
   *     ChoiceResponseMessageFieldInternalImpl, FallbackMessageFieldInternalImpl,
   *     LocationMessageFieldInternalImpl, MediaCardMessageFieldInternalImpl,
   *     MediaMessageFieldInternalImpl, ProductResponseMessageImpl, ReplyToMessageFieldInternalImpl,
   *     TextMessageFieldInternalImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `ChannelSpecificContactMessageInternalImpl`. If the actual instance
   * is not `ChannelSpecificContactMessageInternalImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ChannelSpecificContactMessageInternalImpl`
   * @throws ClassCastException if the instance is not `ChannelSpecificContactMessageInternalImpl`
   */
  public ChannelSpecificContactMessageInternalImpl getChannelSpecificContactMessageInternalImpl()
      throws ClassCastException {
    return (ChannelSpecificContactMessageInternalImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `ChoiceResponseMessageFieldInternalImpl`. If the actual instance is
   * not `ChoiceResponseMessageFieldInternalImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ChoiceResponseMessageFieldInternalImpl`
   * @throws ClassCastException if the instance is not `ChoiceResponseMessageFieldInternalImpl`
   */
  public ChoiceResponseMessageFieldInternalImpl getChoiceResponseMessageFieldInternalImpl()
      throws ClassCastException {
    return (ChoiceResponseMessageFieldInternalImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `FallbackMessageFieldInternalImpl`. If the actual instance is not
   * `FallbackMessageFieldInternalImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `FallbackMessageFieldInternalImpl`
   * @throws ClassCastException if the instance is not `FallbackMessageFieldInternalImpl`
   */
  public FallbackMessageFieldInternalImpl getFallbackMessageFieldInternalImpl()
      throws ClassCastException {
    return (FallbackMessageFieldInternalImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `LocationMessageFieldInternalImpl`. If the actual instance is not
   * `LocationMessageFieldInternalImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `LocationMessageFieldInternalImpl`
   * @throws ClassCastException if the instance is not `LocationMessageFieldInternalImpl`
   */
  public LocationMessageFieldInternalImpl getLocationMessageFieldInternalImpl()
      throws ClassCastException {
    return (LocationMessageFieldInternalImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `MediaCardMessageFieldInternalImpl`. If the actual instance is not
   * `MediaCardMessageFieldInternalImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `MediaCardMessageFieldInternalImpl`
   * @throws ClassCastException if the instance is not `MediaCardMessageFieldInternalImpl`
   */
  public MediaCardMessageFieldInternalImpl getMediaCardMessageFieldInternalImpl()
      throws ClassCastException {
    return (MediaCardMessageFieldInternalImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `MediaMessageFieldInternalImpl`. If the actual instance is not
   * `MediaMessageFieldInternalImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `MediaMessageFieldInternalImpl`
   * @throws ClassCastException if the instance is not `MediaMessageFieldInternalImpl`
   */
  public MediaMessageFieldInternalImpl getMediaMessageFieldInternalImpl()
      throws ClassCastException {
    return (MediaMessageFieldInternalImpl) super.getActualInstance();
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
   * Get the actual instance of `ReplyToMessageFieldInternalImpl`. If the actual instance is not
   * `ReplyToMessageFieldInternalImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ReplyToMessageFieldInternalImpl`
   * @throws ClassCastException if the instance is not `ReplyToMessageFieldInternalImpl`
   */
  public ReplyToMessageFieldInternalImpl getReplyToMessageFieldInternalImpl()
      throws ClassCastException {
    return (ReplyToMessageFieldInternalImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `TextMessageFieldInternalImpl`. If the actual instance is not
   * `TextMessageFieldInternalImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `TextMessageFieldInternalImpl`
   * @throws ClassCastException if the instance is not `TextMessageFieldInternalImpl`
   */
  public TextMessageFieldInternalImpl getTextMessageFieldInternalImpl() throws ClassCastException {
    return (TextMessageFieldInternalImpl) super.getActualInstance();
  }
}
