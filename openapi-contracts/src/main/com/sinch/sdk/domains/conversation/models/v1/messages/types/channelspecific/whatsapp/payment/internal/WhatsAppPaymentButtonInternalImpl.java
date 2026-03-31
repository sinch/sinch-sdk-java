package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment.internal;

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
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment.OrderDetailsPaymentButtonBoletoImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment.OrderDetailsPaymentButtonDynamicPixImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment.OrderDetailsPaymentButtonPaymentLinkImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(
    using = WhatsAppPaymentButtonInternalImpl.WhatsAppPaymentButtonInternalImplDeserializer.class)
@JsonSerialize(
    using = WhatsAppPaymentButtonInternalImpl.WhatsAppPaymentButtonInternalImplSerializer.class)
public class WhatsAppPaymentButtonInternalImpl extends AbstractOpenApiSchema
    implements WhatsAppPaymentButtonInternal {
  private static final Logger log =
      Logger.getLogger(WhatsAppPaymentButtonInternalImpl.class.getName());

  public static final class WhatsAppPaymentButtonInternalImplSerializer
      extends StdSerializer<WhatsAppPaymentButtonInternalImpl> {
    private static final long serialVersionUID = 1L;

    public WhatsAppPaymentButtonInternalImplSerializer(Class<WhatsAppPaymentButtonInternalImpl> t) {
      super(t);
    }

    public WhatsAppPaymentButtonInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        WhatsAppPaymentButtonInternalImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class WhatsAppPaymentButtonInternalImplDeserializer
      extends StdDeserializer<WhatsAppPaymentButtonInternalImpl> {

    private static final long serialVersionUID = 1L;

    public WhatsAppPaymentButtonInternalImplDeserializer() {
      this(WhatsAppPaymentButtonInternalImpl.class);
    }

    public WhatsAppPaymentButtonInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public WhatsAppPaymentButtonInternalImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      WhatsAppPaymentButtonInternalImpl newWhatsAppPaymentButtonInternalImpl =
          new WhatsAppPaymentButtonInternalImpl();
      Map<String, Object> result2 =
          tree.traverse(jp.getCodec()).readValueAs(new TypeReference<Map<String, Object>>() {});
      String discriminatorValue = (String) result2.get("type");
      switch (discriminatorValue) {
        case "boleto":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(OrderDetailsPaymentButtonBoletoImpl.class);
          newWhatsAppPaymentButtonInternalImpl.setActualInstance(deserialized);
          return newWhatsAppPaymentButtonInternalImpl;
        case "payment_link":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(OrderDetailsPaymentButtonPaymentLinkImpl.class);
          newWhatsAppPaymentButtonInternalImpl.setActualInstance(deserialized);
          return newWhatsAppPaymentButtonInternalImpl;
        case "pix_dynamic_code":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(OrderDetailsPaymentButtonDynamicPixImpl.class);
          newWhatsAppPaymentButtonInternalImpl.setActualInstance(deserialized);
          return newWhatsAppPaymentButtonInternalImpl;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for WhatsAppPaymentButtonInternalImpl."
                      + " Possible values: boleto payment_link pix_dynamic_code",
                  discriminatorValue));
      }

      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize OrderDetailsPaymentButtonBoletoImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (OrderDetailsPaymentButtonBoletoImpl.class.equals(Integer.class)
            || OrderDetailsPaymentButtonBoletoImpl.class.equals(Long.class)
            || OrderDetailsPaymentButtonBoletoImpl.class.equals(Float.class)
            || OrderDetailsPaymentButtonBoletoImpl.class.equals(Double.class)
            || OrderDetailsPaymentButtonBoletoImpl.class.equals(Boolean.class)
            || OrderDetailsPaymentButtonBoletoImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((OrderDetailsPaymentButtonBoletoImpl.class.equals(Integer.class)
                        || OrderDetailsPaymentButtonBoletoImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((OrderDetailsPaymentButtonBoletoImpl.class.equals(Float.class)
                        || OrderDetailsPaymentButtonBoletoImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (OrderDetailsPaymentButtonBoletoImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (OrderDetailsPaymentButtonBoletoImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(OrderDetailsPaymentButtonBoletoImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'OrderDetailsPaymentButtonBoletoImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'OrderDetailsPaymentButtonBoletoImpl'",
            e);
      }

      // deserialize OrderDetailsPaymentButtonDynamicPixImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (OrderDetailsPaymentButtonDynamicPixImpl.class.equals(Integer.class)
            || OrderDetailsPaymentButtonDynamicPixImpl.class.equals(Long.class)
            || OrderDetailsPaymentButtonDynamicPixImpl.class.equals(Float.class)
            || OrderDetailsPaymentButtonDynamicPixImpl.class.equals(Double.class)
            || OrderDetailsPaymentButtonDynamicPixImpl.class.equals(Boolean.class)
            || OrderDetailsPaymentButtonDynamicPixImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((OrderDetailsPaymentButtonDynamicPixImpl.class.equals(Integer.class)
                        || OrderDetailsPaymentButtonDynamicPixImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((OrderDetailsPaymentButtonDynamicPixImpl.class.equals(Float.class)
                        || OrderDetailsPaymentButtonDynamicPixImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (OrderDetailsPaymentButtonDynamicPixImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (OrderDetailsPaymentButtonDynamicPixImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(OrderDetailsPaymentButtonDynamicPixImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER, "Input data matches schema 'OrderDetailsPaymentButtonDynamicPixImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'OrderDetailsPaymentButtonDynamicPixImpl'",
            e);
      }

      // deserialize OrderDetailsPaymentButtonPaymentLinkImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (OrderDetailsPaymentButtonPaymentLinkImpl.class.equals(Integer.class)
            || OrderDetailsPaymentButtonPaymentLinkImpl.class.equals(Long.class)
            || OrderDetailsPaymentButtonPaymentLinkImpl.class.equals(Float.class)
            || OrderDetailsPaymentButtonPaymentLinkImpl.class.equals(Double.class)
            || OrderDetailsPaymentButtonPaymentLinkImpl.class.equals(Boolean.class)
            || OrderDetailsPaymentButtonPaymentLinkImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((OrderDetailsPaymentButtonPaymentLinkImpl.class.equals(Integer.class)
                        || OrderDetailsPaymentButtonPaymentLinkImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((OrderDetailsPaymentButtonPaymentLinkImpl.class.equals(Float.class)
                        || OrderDetailsPaymentButtonPaymentLinkImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (OrderDetailsPaymentButtonPaymentLinkImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (OrderDetailsPaymentButtonPaymentLinkImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(OrderDetailsPaymentButtonPaymentLinkImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER, "Input data matches schema 'OrderDetailsPaymentButtonPaymentLinkImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'OrderDetailsPaymentButtonPaymentLinkImpl'",
            e);
      }

      if (match == 1) {
        WhatsAppPaymentButtonInternalImpl ret = new WhatsAppPaymentButtonInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for WhatsAppPaymentButtonInternalImpl: %d classes match"
                  + " result, expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public WhatsAppPaymentButtonInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(
          ctxt.getParser(), "WhatsAppPaymentButtonInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public WhatsAppPaymentButtonInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public WhatsAppPaymentButtonInternalImpl(OrderDetailsPaymentButtonBoletoImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public WhatsAppPaymentButtonInternalImpl(OrderDetailsPaymentButtonDynamicPixImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public WhatsAppPaymentButtonInternalImpl(OrderDetailsPaymentButtonPaymentLinkImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("OrderDetailsPaymentButtonBoletoImpl", OrderDetailsPaymentButtonBoletoImpl.class);
    schemas.put(
        "OrderDetailsPaymentButtonDynamicPixImpl", OrderDetailsPaymentButtonDynamicPixImpl.class);
    schemas.put(
        "OrderDetailsPaymentButtonPaymentLinkImpl", OrderDetailsPaymentButtonPaymentLinkImpl.class);
    JSONNavigator.registerDescendants(
        WhatsAppPaymentButtonInternalImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("boleto", OrderDetailsPaymentButtonBoletoImpl.class);
    mappings.put("payment_link", OrderDetailsPaymentButtonPaymentLinkImpl.class);
    mappings.put("pix_dynamic_code", OrderDetailsPaymentButtonDynamicPixImpl.class);
    mappings.put("WhatsAppPaymentButton", WhatsAppPaymentButtonInternalImpl.class);
    JSONNavigator.registerDiscriminator(WhatsAppPaymentButtonInternalImpl.class, "type", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return WhatsAppPaymentButtonInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: OrderDetailsPaymentButtonBoletoImpl,
   * OrderDetailsPaymentButtonDynamicPixImpl, OrderDetailsPaymentButtonPaymentLinkImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        OrderDetailsPaymentButtonBoletoImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        OrderDetailsPaymentButtonDynamicPixImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        OrderDetailsPaymentButtonPaymentLinkImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be OrderDetailsPaymentButtonBoletoImpl,"
            + " OrderDetailsPaymentButtonDynamicPixImpl, OrderDetailsPaymentButtonPaymentLinkImpl");
  }

  /**
   * Get the actual instance, which can be the following: OrderDetailsPaymentButtonBoletoImpl,
   * OrderDetailsPaymentButtonDynamicPixImpl, OrderDetailsPaymentButtonPaymentLinkImpl
   *
   * @return The actual instance (OrderDetailsPaymentButtonBoletoImpl,
   *     OrderDetailsPaymentButtonDynamicPixImpl, OrderDetailsPaymentButtonPaymentLinkImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `OrderDetailsPaymentButtonBoletoImpl`. If the actual instance is not
   * `OrderDetailsPaymentButtonBoletoImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `OrderDetailsPaymentButtonBoletoImpl`
   * @throws ClassCastException if the instance is not `OrderDetailsPaymentButtonBoletoImpl`
   */
  public OrderDetailsPaymentButtonBoletoImpl getOrderDetailsPaymentButtonBoletoImpl()
      throws ClassCastException {
    return (OrderDetailsPaymentButtonBoletoImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `OrderDetailsPaymentButtonDynamicPixImpl`. If the actual instance is
   * not `OrderDetailsPaymentButtonDynamicPixImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `OrderDetailsPaymentButtonDynamicPixImpl`
   * @throws ClassCastException if the instance is not `OrderDetailsPaymentButtonDynamicPixImpl`
   */
  public OrderDetailsPaymentButtonDynamicPixImpl getOrderDetailsPaymentButtonDynamicPixImpl()
      throws ClassCastException {
    return (OrderDetailsPaymentButtonDynamicPixImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `OrderDetailsPaymentButtonPaymentLinkImpl`. If the actual instance
   * is not `OrderDetailsPaymentButtonPaymentLinkImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `OrderDetailsPaymentButtonPaymentLinkImpl`
   * @throws ClassCastException if the instance is not `OrderDetailsPaymentButtonPaymentLinkImpl`
   */
  public OrderDetailsPaymentButtonPaymentLinkImpl getOrderDetailsPaymentButtonPaymentLinkImpl()
      throws ClassCastException {
    return (OrderDetailsPaymentButtonPaymentLinkImpl) super.getActualInstance();
  }
}
