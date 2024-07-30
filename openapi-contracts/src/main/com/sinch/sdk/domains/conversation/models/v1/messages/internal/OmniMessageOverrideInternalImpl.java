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
import com.sinch.sdk.domains.conversation.models.v1.internal.TemplateReferenceFieldInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.CardMessageFieldInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.CarouselMessageFieldInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.ChoiceMessageFieldInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.ContactInfoMessageFieldInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.ListMessageFieldInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.LocationMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessageImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(
    using = OmniMessageOverrideInternalImpl.OmniMessageOverrideInternalImplDeserializer.class)
@JsonSerialize(
    using = OmniMessageOverrideInternalImpl.OmniMessageOverrideInternalImplSerializer.class)
public class OmniMessageOverrideInternalImpl extends AbstractOpenApiSchema
    implements OmniMessageOverrideInternal {
  private static final Logger log =
      Logger.getLogger(OmniMessageOverrideInternalImpl.class.getName());

  public static final class OmniMessageOverrideInternalImplSerializer
      extends StdSerializer<OmniMessageOverrideInternalImpl> {
    private static final long serialVersionUID = 1L;

    public OmniMessageOverrideInternalImplSerializer(Class<OmniMessageOverrideInternalImpl> t) {
      super(t);
    }

    public OmniMessageOverrideInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        OmniMessageOverrideInternalImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class OmniMessageOverrideInternalImplDeserializer
      extends StdDeserializer<OmniMessageOverrideInternalImpl> {

    private static final long serialVersionUID = 1L;

    public OmniMessageOverrideInternalImplDeserializer() {
      this(OmniMessageOverrideInternalImpl.class);
    }

    public OmniMessageOverrideInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public OmniMessageOverrideInternalImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize CardMessageFieldInternalImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (CardMessageFieldInternalImpl.class.equals(Integer.class)
            || CardMessageFieldInternalImpl.class.equals(Long.class)
            || CardMessageFieldInternalImpl.class.equals(Float.class)
            || CardMessageFieldInternalImpl.class.equals(Double.class)
            || CardMessageFieldInternalImpl.class.equals(Boolean.class)
            || CardMessageFieldInternalImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((CardMessageFieldInternalImpl.class.equals(Integer.class)
                        || CardMessageFieldInternalImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((CardMessageFieldInternalImpl.class.equals(Float.class)
                        || CardMessageFieldInternalImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (CardMessageFieldInternalImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (CardMessageFieldInternalImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(CardMessageFieldInternalImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'CardMessageFieldInternalImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'CardMessageFieldInternalImpl'", e);
      }

      // deserialize CarouselMessageFieldInternalImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (CarouselMessageFieldInternalImpl.class.equals(Integer.class)
            || CarouselMessageFieldInternalImpl.class.equals(Long.class)
            || CarouselMessageFieldInternalImpl.class.equals(Float.class)
            || CarouselMessageFieldInternalImpl.class.equals(Double.class)
            || CarouselMessageFieldInternalImpl.class.equals(Boolean.class)
            || CarouselMessageFieldInternalImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((CarouselMessageFieldInternalImpl.class.equals(Integer.class)
                        || CarouselMessageFieldInternalImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((CarouselMessageFieldInternalImpl.class.equals(Float.class)
                        || CarouselMessageFieldInternalImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (CarouselMessageFieldInternalImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (CarouselMessageFieldInternalImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(CarouselMessageFieldInternalImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'CarouselMessageFieldInternalImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'CarouselMessageFieldInternalImpl'", e);
      }

      // deserialize ChoiceMessageFieldInternalImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ChoiceMessageFieldInternalImpl.class.equals(Integer.class)
            || ChoiceMessageFieldInternalImpl.class.equals(Long.class)
            || ChoiceMessageFieldInternalImpl.class.equals(Float.class)
            || ChoiceMessageFieldInternalImpl.class.equals(Double.class)
            || ChoiceMessageFieldInternalImpl.class.equals(Boolean.class)
            || ChoiceMessageFieldInternalImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ChoiceMessageFieldInternalImpl.class.equals(Integer.class)
                        || ChoiceMessageFieldInternalImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ChoiceMessageFieldInternalImpl.class.equals(Float.class)
                        || ChoiceMessageFieldInternalImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ChoiceMessageFieldInternalImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ChoiceMessageFieldInternalImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(ChoiceMessageFieldInternalImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ChoiceMessageFieldInternalImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'ChoiceMessageFieldInternalImpl'", e);
      }

      // deserialize ContactInfoMessageFieldInternalImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ContactInfoMessageFieldInternalImpl.class.equals(Integer.class)
            || ContactInfoMessageFieldInternalImpl.class.equals(Long.class)
            || ContactInfoMessageFieldInternalImpl.class.equals(Float.class)
            || ContactInfoMessageFieldInternalImpl.class.equals(Double.class)
            || ContactInfoMessageFieldInternalImpl.class.equals(Boolean.class)
            || ContactInfoMessageFieldInternalImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ContactInfoMessageFieldInternalImpl.class.equals(Integer.class)
                        || ContactInfoMessageFieldInternalImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ContactInfoMessageFieldInternalImpl.class.equals(Float.class)
                        || ContactInfoMessageFieldInternalImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ContactInfoMessageFieldInternalImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ContactInfoMessageFieldInternalImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(ContactInfoMessageFieldInternalImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ContactInfoMessageFieldInternalImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'ContactInfoMessageFieldInternalImpl'",
            e);
      }

      // deserialize ListMessageFieldInternalImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ListMessageFieldInternalImpl.class.equals(Integer.class)
            || ListMessageFieldInternalImpl.class.equals(Long.class)
            || ListMessageFieldInternalImpl.class.equals(Float.class)
            || ListMessageFieldInternalImpl.class.equals(Double.class)
            || ListMessageFieldInternalImpl.class.equals(Boolean.class)
            || ListMessageFieldInternalImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ListMessageFieldInternalImpl.class.equals(Integer.class)
                        || ListMessageFieldInternalImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ListMessageFieldInternalImpl.class.equals(Float.class)
                        || ListMessageFieldInternalImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ListMessageFieldInternalImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ListMessageFieldInternalImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(ListMessageFieldInternalImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ListMessageFieldInternalImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'ListMessageFieldInternalImpl'", e);
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

      // deserialize TemplateReferenceFieldInternalImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (TemplateReferenceFieldInternalImpl.class.equals(Integer.class)
            || TemplateReferenceFieldInternalImpl.class.equals(Long.class)
            || TemplateReferenceFieldInternalImpl.class.equals(Float.class)
            || TemplateReferenceFieldInternalImpl.class.equals(Double.class)
            || TemplateReferenceFieldInternalImpl.class.equals(Boolean.class)
            || TemplateReferenceFieldInternalImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((TemplateReferenceFieldInternalImpl.class.equals(Integer.class)
                        || TemplateReferenceFieldInternalImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((TemplateReferenceFieldInternalImpl.class.equals(Float.class)
                        || TemplateReferenceFieldInternalImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (TemplateReferenceFieldInternalImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (TemplateReferenceFieldInternalImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(TemplateReferenceFieldInternalImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'TemplateReferenceFieldInternalImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'TemplateReferenceFieldInternalImpl'",
            e);
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
        OmniMessageOverrideInternalImpl ret = new OmniMessageOverrideInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for OmniMessageOverrideInternalImpl: %d classes match result,"
                  + " expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public OmniMessageOverrideInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(
          ctxt.getParser(), "OmniMessageOverrideInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public OmniMessageOverrideInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public OmniMessageOverrideInternalImpl(CardMessageFieldInternalImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public OmniMessageOverrideInternalImpl(CarouselMessageFieldInternalImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public OmniMessageOverrideInternalImpl(ChoiceMessageFieldInternalImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public OmniMessageOverrideInternalImpl(ContactInfoMessageFieldInternalImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public OmniMessageOverrideInternalImpl(ListMessageFieldInternalImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public OmniMessageOverrideInternalImpl(LocationMessageImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public OmniMessageOverrideInternalImpl(MediaMessageImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public OmniMessageOverrideInternalImpl(TemplateReferenceFieldInternalImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public OmniMessageOverrideInternalImpl(TextMessageImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("CardMessageFieldInternalImpl", CardMessageFieldInternalImpl.class);
    schemas.put("CarouselMessageFieldInternalImpl", CarouselMessageFieldInternalImpl.class);
    schemas.put("ChoiceMessageFieldInternalImpl", ChoiceMessageFieldInternalImpl.class);
    schemas.put("ContactInfoMessageFieldInternalImpl", ContactInfoMessageFieldInternalImpl.class);
    schemas.put("ListMessageFieldInternalImpl", ListMessageFieldInternalImpl.class);
    schemas.put("LocationMessageImpl", LocationMessageImpl.class);
    schemas.put("MediaMessageImpl", MediaMessageImpl.class);
    schemas.put("TemplateReferenceFieldInternalImpl", TemplateReferenceFieldInternalImpl.class);
    schemas.put("TextMessageImpl", TextMessageImpl.class);
    JSONNavigator.registerDescendants(
        OmniMessageOverrideInternalImpl.class, Collections.unmodifiableMap(schemas));
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return OmniMessageOverrideInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: CardMessageFieldInternalImpl,
   * CarouselMessageFieldInternalImpl, ChoiceMessageFieldInternalImpl,
   * ContactInfoMessageFieldInternalImpl, ListMessageFieldInternalImpl, LocationMessageImpl,
   * MediaMessageImpl, TemplateReferenceFieldInternalImpl, TextMessageImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        CardMessageFieldInternalImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        CarouselMessageFieldInternalImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        ChoiceMessageFieldInternalImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        ContactInfoMessageFieldInternalImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        ListMessageFieldInternalImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(LocationMessageImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(MediaMessageImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        TemplateReferenceFieldInternalImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(TextMessageImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be CardMessageFieldInternalImpl,"
            + " CarouselMessageFieldInternalImpl, ChoiceMessageFieldInternalImpl,"
            + " ContactInfoMessageFieldInternalImpl, ListMessageFieldInternalImpl,"
            + " LocationMessageImpl, MediaMessageImpl, TemplateReferenceFieldInternalImpl,"
            + " TextMessageImpl");
  }

  /**
   * Get the actual instance, which can be the following: CardMessageFieldInternalImpl,
   * CarouselMessageFieldInternalImpl, ChoiceMessageFieldInternalImpl,
   * ContactInfoMessageFieldInternalImpl, ListMessageFieldInternalImpl, LocationMessageImpl,
   * MediaMessageImpl, TemplateReferenceFieldInternalImpl, TextMessageImpl
   *
   * @return The actual instance (CardMessageFieldInternalImpl, CarouselMessageFieldInternalImpl,
   *     ChoiceMessageFieldInternalImpl, ContactInfoMessageFieldInternalImpl,
   *     ListMessageFieldInternalImpl, LocationMessageImpl, MediaMessageImpl,
   *     TemplateReferenceFieldInternalImpl, TextMessageImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `CardMessageFieldInternalImpl`. If the actual instance is not
   * `CardMessageFieldInternalImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `CardMessageFieldInternalImpl`
   * @throws ClassCastException if the instance is not `CardMessageFieldInternalImpl`
   */
  public CardMessageFieldInternalImpl getCardMessageFieldInternalImpl() throws ClassCastException {
    return (CardMessageFieldInternalImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `CarouselMessageFieldInternalImpl`. If the actual instance is not
   * `CarouselMessageFieldInternalImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `CarouselMessageFieldInternalImpl`
   * @throws ClassCastException if the instance is not `CarouselMessageFieldInternalImpl`
   */
  public CarouselMessageFieldInternalImpl getCarouselMessageFieldInternalImpl()
      throws ClassCastException {
    return (CarouselMessageFieldInternalImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `ChoiceMessageFieldInternalImpl`. If the actual instance is not
   * `ChoiceMessageFieldInternalImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ChoiceMessageFieldInternalImpl`
   * @throws ClassCastException if the instance is not `ChoiceMessageFieldInternalImpl`
   */
  public ChoiceMessageFieldInternalImpl getChoiceMessageFieldInternalImpl()
      throws ClassCastException {
    return (ChoiceMessageFieldInternalImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `ContactInfoMessageFieldInternalImpl`. If the actual instance is not
   * `ContactInfoMessageFieldInternalImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ContactInfoMessageFieldInternalImpl`
   * @throws ClassCastException if the instance is not `ContactInfoMessageFieldInternalImpl`
   */
  public ContactInfoMessageFieldInternalImpl getContactInfoMessageFieldInternalImpl()
      throws ClassCastException {
    return (ContactInfoMessageFieldInternalImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `ListMessageFieldInternalImpl`. If the actual instance is not
   * `ListMessageFieldInternalImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ListMessageFieldInternalImpl`
   * @throws ClassCastException if the instance is not `ListMessageFieldInternalImpl`
   */
  public ListMessageFieldInternalImpl getListMessageFieldInternalImpl() throws ClassCastException {
    return (ListMessageFieldInternalImpl) super.getActualInstance();
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
   * Get the actual instance of `TemplateReferenceFieldInternalImpl`. If the actual instance is not
   * `TemplateReferenceFieldInternalImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `TemplateReferenceFieldInternalImpl`
   * @throws ClassCastException if the instance is not `TemplateReferenceFieldInternalImpl`
   */
  public TemplateReferenceFieldInternalImpl getTemplateReferenceFieldInternalImpl()
      throws ClassCastException {
    return (TemplateReferenceFieldInternalImpl) super.getActualInstance();
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
