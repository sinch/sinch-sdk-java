package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment.internal;

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
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment.OrderDetailsPaymentSettingsBoletoImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment.OrderDetailsPaymentSettingsDynamicPixImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment.OrderDetailsPaymentSettingsPaymentLinkImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(
    using =
        WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImpl
            .WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImplDeserializer
            .class)
@JsonSerialize(
    using =
        WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImpl
            .WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImplSerializer
            .class)
public class WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImpl
    extends AbstractOpenApiSchema
    implements WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettings {
  private static final Logger log =
      Logger.getLogger(
          WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImpl.class
              .getName());

  public static final
  class WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImplSerializer
      extends StdSerializer<
          WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImpl> {
    private static final long serialVersionUID = 1L;

    public WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImplSerializer(
        Class<WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImpl> t) {
      super(t);
    }

    public WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImpl value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final
  class WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImplDeserializer
      extends StdDeserializer<
          WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImpl> {

    private static final long serialVersionUID = 1L;

    public
    WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImplDeserializer() {
      this(WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImpl.class);
    }

    public WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImplDeserializer(
        Class<?> vc) {
      super(vc);
    }

    @Override
    public WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImpl deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize OrderDetailsPaymentSettingsBoletoImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (OrderDetailsPaymentSettingsBoletoImpl.class.equals(Integer.class)
            || OrderDetailsPaymentSettingsBoletoImpl.class.equals(Long.class)
            || OrderDetailsPaymentSettingsBoletoImpl.class.equals(Float.class)
            || OrderDetailsPaymentSettingsBoletoImpl.class.equals(Double.class)
            || OrderDetailsPaymentSettingsBoletoImpl.class.equals(Boolean.class)
            || OrderDetailsPaymentSettingsBoletoImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((OrderDetailsPaymentSettingsBoletoImpl.class.equals(Integer.class)
                        || OrderDetailsPaymentSettingsBoletoImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((OrderDetailsPaymentSettingsBoletoImpl.class.equals(Float.class)
                        || OrderDetailsPaymentSettingsBoletoImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (OrderDetailsPaymentSettingsBoletoImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (OrderDetailsPaymentSettingsBoletoImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(OrderDetailsPaymentSettingsBoletoImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'OrderDetailsPaymentSettingsBoletoImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'OrderDetailsPaymentSettingsBoletoImpl'",
            e);
      }

      // deserialize OrderDetailsPaymentSettingsDynamicPixImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (OrderDetailsPaymentSettingsDynamicPixImpl.class.equals(Integer.class)
            || OrderDetailsPaymentSettingsDynamicPixImpl.class.equals(Long.class)
            || OrderDetailsPaymentSettingsDynamicPixImpl.class.equals(Float.class)
            || OrderDetailsPaymentSettingsDynamicPixImpl.class.equals(Double.class)
            || OrderDetailsPaymentSettingsDynamicPixImpl.class.equals(Boolean.class)
            || OrderDetailsPaymentSettingsDynamicPixImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((OrderDetailsPaymentSettingsDynamicPixImpl.class.equals(Integer.class)
                        || OrderDetailsPaymentSettingsDynamicPixImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((OrderDetailsPaymentSettingsDynamicPixImpl.class.equals(Float.class)
                        || OrderDetailsPaymentSettingsDynamicPixImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (OrderDetailsPaymentSettingsDynamicPixImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (OrderDetailsPaymentSettingsDynamicPixImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(OrderDetailsPaymentSettingsDynamicPixImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER, "Input data matches schema 'OrderDetailsPaymentSettingsDynamicPixImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'OrderDetailsPaymentSettingsDynamicPixImpl'",
            e);
      }

      // deserialize OrderDetailsPaymentSettingsPaymentLinkImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (OrderDetailsPaymentSettingsPaymentLinkImpl.class.equals(Integer.class)
            || OrderDetailsPaymentSettingsPaymentLinkImpl.class.equals(Long.class)
            || OrderDetailsPaymentSettingsPaymentLinkImpl.class.equals(Float.class)
            || OrderDetailsPaymentSettingsPaymentLinkImpl.class.equals(Double.class)
            || OrderDetailsPaymentSettingsPaymentLinkImpl.class.equals(Boolean.class)
            || OrderDetailsPaymentSettingsPaymentLinkImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((OrderDetailsPaymentSettingsPaymentLinkImpl.class.equals(Integer.class)
                        || OrderDetailsPaymentSettingsPaymentLinkImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((OrderDetailsPaymentSettingsPaymentLinkImpl.class.equals(Float.class)
                        || OrderDetailsPaymentSettingsPaymentLinkImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (OrderDetailsPaymentSettingsPaymentLinkImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (OrderDetailsPaymentSettingsPaymentLinkImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(OrderDetailsPaymentSettingsPaymentLinkImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER,
              "Input data matches schema 'OrderDetailsPaymentSettingsPaymentLinkImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'OrderDetailsPaymentSettingsPaymentLinkImpl'",
            e);
      }

      if (match == 1) {
        WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImpl ret =
            new WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for"
                  + " WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImpl:"
                  + " %d classes match result, expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImpl getNullValue(
        DeserializationContext ctxt) throws JsonMappingException {
      throw new JsonMappingException(
          ctxt.getParser(),
          "WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImpl cannot be"
              + " null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImpl(
      OrderDetailsPaymentSettingsBoletoImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImpl(
      OrderDetailsPaymentSettingsDynamicPixImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImpl(
      OrderDetailsPaymentSettingsPaymentLinkImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put(
        "OrderDetailsPaymentSettingsBoletoImpl", OrderDetailsPaymentSettingsBoletoImpl.class);
    schemas.put(
        "OrderDetailsPaymentSettingsDynamicPixImpl",
        OrderDetailsPaymentSettingsDynamicPixImpl.class);
    schemas.put(
        "OrderDetailsPaymentSettingsPaymentLinkImpl",
        OrderDetailsPaymentSettingsPaymentLinkImpl.class);
    JSONNavigator.registerDescendants(
        WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImpl.class,
        Collections.unmodifiableMap(schemas));
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return WhatsAppPaymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: OrderDetailsPaymentSettingsBoletoImpl,
   * OrderDetailsPaymentSettingsDynamicPixImpl, OrderDetailsPaymentSettingsPaymentLinkImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        OrderDetailsPaymentSettingsBoletoImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        OrderDetailsPaymentSettingsDynamicPixImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        OrderDetailsPaymentSettingsPaymentLinkImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be OrderDetailsPaymentSettingsBoletoImpl,"
            + " OrderDetailsPaymentSettingsDynamicPixImpl,"
            + " OrderDetailsPaymentSettingsPaymentLinkImpl");
  }

  /**
   * Get the actual instance, which can be the following: OrderDetailsPaymentSettingsBoletoImpl,
   * OrderDetailsPaymentSettingsDynamicPixImpl, OrderDetailsPaymentSettingsPaymentLinkImpl
   *
   * @return The actual instance (OrderDetailsPaymentSettingsBoletoImpl,
   *     OrderDetailsPaymentSettingsDynamicPixImpl, OrderDetailsPaymentSettingsPaymentLinkImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `OrderDetailsPaymentSettingsBoletoImpl`. If the actual instance is
   * not `OrderDetailsPaymentSettingsBoletoImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `OrderDetailsPaymentSettingsBoletoImpl`
   * @throws ClassCastException if the instance is not `OrderDetailsPaymentSettingsBoletoImpl`
   */
  public OrderDetailsPaymentSettingsBoletoImpl getOrderDetailsPaymentSettingsBoletoImpl()
      throws ClassCastException {
    return (OrderDetailsPaymentSettingsBoletoImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `OrderDetailsPaymentSettingsDynamicPixImpl`. If the actual instance
   * is not `OrderDetailsPaymentSettingsDynamicPixImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `OrderDetailsPaymentSettingsDynamicPixImpl`
   * @throws ClassCastException if the instance is not `OrderDetailsPaymentSettingsDynamicPixImpl`
   */
  public OrderDetailsPaymentSettingsDynamicPixImpl getOrderDetailsPaymentSettingsDynamicPixImpl()
      throws ClassCastException {
    return (OrderDetailsPaymentSettingsDynamicPixImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `OrderDetailsPaymentSettingsPaymentLinkImpl`. If the actual instance
   * is not `OrderDetailsPaymentSettingsPaymentLinkImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `OrderDetailsPaymentSettingsPaymentLinkImpl`
   * @throws ClassCastException if the instance is not `OrderDetailsPaymentSettingsPaymentLinkImpl`
   */
  public OrderDetailsPaymentSettingsPaymentLinkImpl getOrderDetailsPaymentSettingsPaymentLinkImpl()
      throws ClassCastException {
    return (OrderDetailsPaymentSettingsPaymentLinkImpl) super.getActualInstance();
  }
}
