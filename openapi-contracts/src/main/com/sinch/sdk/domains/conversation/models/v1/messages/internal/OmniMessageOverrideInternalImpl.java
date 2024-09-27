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
import com.sinch.sdk.domains.conversation.models.v1.TemplateReferenceImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.card.CardMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.contactinfo.ContactInfoMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.CarouselMessageFieldInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.list.ListMessageImpl;
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
      // deserialize CardMessageImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (CardMessageImpl.class.equals(Integer.class)
            || CardMessageImpl.class.equals(Long.class)
            || CardMessageImpl.class.equals(Float.class)
            || CardMessageImpl.class.equals(Double.class)
            || CardMessageImpl.class.equals(Boolean.class)
            || CardMessageImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((CardMessageImpl.class.equals(Integer.class)
                        || CardMessageImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((CardMessageImpl.class.equals(Float.class)
                        || CardMessageImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (CardMessageImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (CardMessageImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(CardMessageImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'CardMessageImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'CardMessageImpl'", e);
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

      // deserialize ChoiceMessageImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ChoiceMessageImpl.class.equals(Integer.class)
            || ChoiceMessageImpl.class.equals(Long.class)
            || ChoiceMessageImpl.class.equals(Float.class)
            || ChoiceMessageImpl.class.equals(Double.class)
            || ChoiceMessageImpl.class.equals(Boolean.class)
            || ChoiceMessageImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ChoiceMessageImpl.class.equals(Integer.class)
                        || ChoiceMessageImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ChoiceMessageImpl.class.equals(Float.class)
                        || ChoiceMessageImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ChoiceMessageImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ChoiceMessageImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(ChoiceMessageImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ChoiceMessageImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'ChoiceMessageImpl'", e);
      }

      // deserialize ContactInfoMessageImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ContactInfoMessageImpl.class.equals(Integer.class)
            || ContactInfoMessageImpl.class.equals(Long.class)
            || ContactInfoMessageImpl.class.equals(Float.class)
            || ContactInfoMessageImpl.class.equals(Double.class)
            || ContactInfoMessageImpl.class.equals(Boolean.class)
            || ContactInfoMessageImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ContactInfoMessageImpl.class.equals(Integer.class)
                        || ContactInfoMessageImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ContactInfoMessageImpl.class.equals(Float.class)
                        || ContactInfoMessageImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ContactInfoMessageImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ContactInfoMessageImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(ContactInfoMessageImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ContactInfoMessageImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'ContactInfoMessageImpl'", e);
      }

      // deserialize ListMessageImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ListMessageImpl.class.equals(Integer.class)
            || ListMessageImpl.class.equals(Long.class)
            || ListMessageImpl.class.equals(Float.class)
            || ListMessageImpl.class.equals(Double.class)
            || ListMessageImpl.class.equals(Boolean.class)
            || ListMessageImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ListMessageImpl.class.equals(Integer.class)
                        || ListMessageImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ListMessageImpl.class.equals(Float.class)
                        || ListMessageImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ListMessageImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ListMessageImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(ListMessageImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ListMessageImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'ListMessageImpl'", e);
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

      // deserialize TemplateReferenceImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (TemplateReferenceImpl.class.equals(Integer.class)
            || TemplateReferenceImpl.class.equals(Long.class)
            || TemplateReferenceImpl.class.equals(Float.class)
            || TemplateReferenceImpl.class.equals(Double.class)
            || TemplateReferenceImpl.class.equals(Boolean.class)
            || TemplateReferenceImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((TemplateReferenceImpl.class.equals(Integer.class)
                        || TemplateReferenceImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((TemplateReferenceImpl.class.equals(Float.class)
                        || TemplateReferenceImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (TemplateReferenceImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (TemplateReferenceImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(TemplateReferenceImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'TemplateReferenceImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'TemplateReferenceImpl'", e);
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

  public OmniMessageOverrideInternalImpl(CardMessageImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public OmniMessageOverrideInternalImpl(CarouselMessageFieldInternalImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public OmniMessageOverrideInternalImpl(ChoiceMessageImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public OmniMessageOverrideInternalImpl(ContactInfoMessageImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public OmniMessageOverrideInternalImpl(ListMessageImpl o) {
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

  public OmniMessageOverrideInternalImpl(TemplateReferenceImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public OmniMessageOverrideInternalImpl(TextMessageImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("CardMessageImpl", CardMessageImpl.class);
    schemas.put("CarouselMessageFieldInternalImpl", CarouselMessageFieldInternalImpl.class);
    schemas.put("ChoiceMessageImpl", ChoiceMessageImpl.class);
    schemas.put("ContactInfoMessageImpl", ContactInfoMessageImpl.class);
    schemas.put("ListMessageImpl", ListMessageImpl.class);
    schemas.put("LocationMessageImpl", LocationMessageImpl.class);
    schemas.put("MediaMessageImpl", MediaMessageImpl.class);
    schemas.put("TemplateReferenceImpl", TemplateReferenceImpl.class);
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
   * against the oneOf child schemas: CardMessageImpl, CarouselMessageFieldInternalImpl,
   * ChoiceMessageImpl, ContactInfoMessageImpl, ListMessageImpl, LocationMessageImpl,
   * MediaMessageImpl, TemplateReferenceImpl, TextMessageImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(CardMessageImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        CarouselMessageFieldInternalImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(ChoiceMessageImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        ContactInfoMessageImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(ListMessageImpl.class, instance, new HashSet<Class<?>>())) {
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
        TemplateReferenceImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(TextMessageImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be CardMessageImpl, CarouselMessageFieldInternalImpl,"
            + " ChoiceMessageImpl, ContactInfoMessageImpl, ListMessageImpl, LocationMessageImpl,"
            + " MediaMessageImpl, TemplateReferenceImpl, TextMessageImpl");
  }

  /**
   * Get the actual instance, which can be the following: CardMessageImpl,
   * CarouselMessageFieldInternalImpl, ChoiceMessageImpl, ContactInfoMessageImpl, ListMessageImpl,
   * LocationMessageImpl, MediaMessageImpl, TemplateReferenceImpl, TextMessageImpl
   *
   * @return The actual instance (CardMessageImpl, CarouselMessageFieldInternalImpl,
   *     ChoiceMessageImpl, ContactInfoMessageImpl, ListMessageImpl, LocationMessageImpl,
   *     MediaMessageImpl, TemplateReferenceImpl, TextMessageImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `CardMessageImpl`. If the actual instance is not `CardMessageImpl`,
   * the ClassCastException will be thrown.
   *
   * @return The actual instance of `CardMessageImpl`
   * @throws ClassCastException if the instance is not `CardMessageImpl`
   */
  public CardMessageImpl getCardMessageImpl() throws ClassCastException {
    return (CardMessageImpl) super.getActualInstance();
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
   * Get the actual instance of `ChoiceMessageImpl`. If the actual instance is not
   * `ChoiceMessageImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ChoiceMessageImpl`
   * @throws ClassCastException if the instance is not `ChoiceMessageImpl`
   */
  public ChoiceMessageImpl getChoiceMessageImpl() throws ClassCastException {
    return (ChoiceMessageImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `ContactInfoMessageImpl`. If the actual instance is not
   * `ContactInfoMessageImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ContactInfoMessageImpl`
   * @throws ClassCastException if the instance is not `ContactInfoMessageImpl`
   */
  public ContactInfoMessageImpl getContactInfoMessageImpl() throws ClassCastException {
    return (ContactInfoMessageImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `ListMessageImpl`. If the actual instance is not `ListMessageImpl`,
   * the ClassCastException will be thrown.
   *
   * @return The actual instance of `ListMessageImpl`
   * @throws ClassCastException if the instance is not `ListMessageImpl`
   */
  public ListMessageImpl getListMessageImpl() throws ClassCastException {
    return (ListMessageImpl) super.getActualInstance();
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
   * Get the actual instance of `TemplateReferenceImpl`. If the actual instance is not
   * `TemplateReferenceImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `TemplateReferenceImpl`
   * @throws ClassCastException if the instance is not `TemplateReferenceImpl`
   */
  public TemplateReferenceImpl getTemplateReferenceImpl() throws ClassCastException {
    return (TemplateReferenceImpl) super.getActualInstance();
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
