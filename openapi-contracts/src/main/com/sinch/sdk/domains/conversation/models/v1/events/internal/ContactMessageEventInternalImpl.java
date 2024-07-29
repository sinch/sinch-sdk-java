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
import com.sinch.sdk.domains.conversation.models.v1.events.types.PaymentStatusUpdateEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.types.ReactionEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.types.ShortLinkActivatedEventImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(
    using = ContactMessageEventInternalImpl.ContactMessageEventInternalImplDeserializer.class)
@JsonSerialize(
    using = ContactMessageEventInternalImpl.ContactMessageEventInternalImplSerializer.class)
public class ContactMessageEventInternalImpl extends AbstractOpenApiSchema
    implements ContactMessageEventInternal {
  private static final Logger log =
      Logger.getLogger(ContactMessageEventInternalImpl.class.getName());

  public static final class ContactMessageEventInternalImplSerializer
      extends StdSerializer<ContactMessageEventInternalImpl> {
    private static final long serialVersionUID = 1L;

    public ContactMessageEventInternalImplSerializer(Class<ContactMessageEventInternalImpl> t) {
      super(t);
    }

    public ContactMessageEventInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        ContactMessageEventInternalImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class ContactMessageEventInternalImplDeserializer
      extends StdDeserializer<ContactMessageEventInternalImpl> {

    private static final long serialVersionUID = 1L;

    public ContactMessageEventInternalImplDeserializer() {
      this(ContactMessageEventInternalImpl.class);
    }

    public ContactMessageEventInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public ContactMessageEventInternalImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize PaymentStatusUpdateEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (PaymentStatusUpdateEventImpl.class.equals(Integer.class)
            || PaymentStatusUpdateEventImpl.class.equals(Long.class)
            || PaymentStatusUpdateEventImpl.class.equals(Float.class)
            || PaymentStatusUpdateEventImpl.class.equals(Double.class)
            || PaymentStatusUpdateEventImpl.class.equals(Boolean.class)
            || PaymentStatusUpdateEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((PaymentStatusUpdateEventImpl.class.equals(Integer.class)
                        || PaymentStatusUpdateEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((PaymentStatusUpdateEventImpl.class.equals(Float.class)
                        || PaymentStatusUpdateEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (PaymentStatusUpdateEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (PaymentStatusUpdateEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(PaymentStatusUpdateEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'PaymentStatusUpdateEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'PaymentStatusUpdateEventImpl'", e);
      }

      // deserialize ReactionEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ReactionEventImpl.class.equals(Integer.class)
            || ReactionEventImpl.class.equals(Long.class)
            || ReactionEventImpl.class.equals(Float.class)
            || ReactionEventImpl.class.equals(Double.class)
            || ReactionEventImpl.class.equals(Boolean.class)
            || ReactionEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ReactionEventImpl.class.equals(Integer.class)
                        || ReactionEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ReactionEventImpl.class.equals(Float.class)
                        || ReactionEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ReactionEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ReactionEventImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(ReactionEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ReactionEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'ReactionEventImpl'", e);
      }

      // deserialize ShortLinkActivatedEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ShortLinkActivatedEventImpl.class.equals(Integer.class)
            || ShortLinkActivatedEventImpl.class.equals(Long.class)
            || ShortLinkActivatedEventImpl.class.equals(Float.class)
            || ShortLinkActivatedEventImpl.class.equals(Double.class)
            || ShortLinkActivatedEventImpl.class.equals(Boolean.class)
            || ShortLinkActivatedEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ShortLinkActivatedEventImpl.class.equals(Integer.class)
                        || ShortLinkActivatedEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ShortLinkActivatedEventImpl.class.equals(Float.class)
                        || ShortLinkActivatedEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ShortLinkActivatedEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ShortLinkActivatedEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(ShortLinkActivatedEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ShortLinkActivatedEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'ShortLinkActivatedEventImpl'", e);
      }

      if (match == 1) {
        ContactMessageEventInternalImpl ret = new ContactMessageEventInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for ContactMessageEventInternalImpl: %d classes match result,"
                  + " expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public ContactMessageEventInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(
          ctxt.getParser(), "ContactMessageEventInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public ContactMessageEventInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public ContactMessageEventInternalImpl(PaymentStatusUpdateEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ContactMessageEventInternalImpl(ReactionEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public ContactMessageEventInternalImpl(ShortLinkActivatedEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("PaymentStatusUpdateEventImpl", PaymentStatusUpdateEventImpl.class);
    schemas.put("ReactionEventImpl", ReactionEventImpl.class);
    schemas.put("ShortLinkActivatedEventImpl", ShortLinkActivatedEventImpl.class);
    JSONNavigator.registerDescendants(
        ContactMessageEventInternalImpl.class, Collections.unmodifiableMap(schemas));
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return ContactMessageEventInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: PaymentStatusUpdateEventImpl, ReactionEventImpl,
   * ShortLinkActivatedEventImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        PaymentStatusUpdateEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(ReactionEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        ShortLinkActivatedEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be PaymentStatusUpdateEventImpl, ReactionEventImpl,"
            + " ShortLinkActivatedEventImpl");
  }

  /**
   * Get the actual instance, which can be the following: PaymentStatusUpdateEventImpl,
   * ReactionEventImpl, ShortLinkActivatedEventImpl
   *
   * @return The actual instance (PaymentStatusUpdateEventImpl, ReactionEventImpl,
   *     ShortLinkActivatedEventImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `PaymentStatusUpdateEventImpl`. If the actual instance is not
   * `PaymentStatusUpdateEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `PaymentStatusUpdateEventImpl`
   * @throws ClassCastException if the instance is not `PaymentStatusUpdateEventImpl`
   */
  public PaymentStatusUpdateEventImpl getPaymentStatusUpdateEventImpl() throws ClassCastException {
    return (PaymentStatusUpdateEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `ReactionEventImpl`. If the actual instance is not
   * `ReactionEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ReactionEventImpl`
   * @throws ClassCastException if the instance is not `ReactionEventImpl`
   */
  public ReactionEventImpl getReactionEventImpl() throws ClassCastException {
    return (ReactionEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `ShortLinkActivatedEventImpl`. If the actual instance is not
   * `ShortLinkActivatedEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ShortLinkActivatedEventImpl`
   * @throws ClassCastException if the instance is not `ShortLinkActivatedEventImpl`
   */
  public ShortLinkActivatedEventImpl getShortLinkActivatedEventImpl() throws ClassCastException {
    return (ShortLinkActivatedEventImpl) super.getActualInstance();
  }
}
