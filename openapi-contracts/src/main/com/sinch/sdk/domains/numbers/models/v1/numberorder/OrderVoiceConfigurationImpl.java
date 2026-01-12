package com.sinch.sdk.domains.numbers.models.v1.numberorder;

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
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(using = OrderVoiceConfigurationImpl.OrderVoiceConfigurationImplDeserializer.class)
@JsonSerialize(using = OrderVoiceConfigurationImpl.OrderVoiceConfigurationImplSerializer.class)
public class OrderVoiceConfigurationImpl extends AbstractOpenApiSchema
    implements OrderVoiceConfiguration {
  private static final Logger log = Logger.getLogger(OrderVoiceConfigurationImpl.class.getName());

  public static final class OrderVoiceConfigurationImplSerializer
      extends StdSerializer<OrderVoiceConfigurationImpl> {
    private static final long serialVersionUID = 1L;

    public OrderVoiceConfigurationImplSerializer(Class<OrderVoiceConfigurationImpl> t) {
      super(t);
    }

    public OrderVoiceConfigurationImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        OrderVoiceConfigurationImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class OrderVoiceConfigurationImplDeserializer
      extends StdDeserializer<OrderVoiceConfigurationImpl> {

    private static final long serialVersionUID = 1L;

    public OrderVoiceConfigurationImplDeserializer() {
      this(OrderVoiceConfigurationImpl.class);
    }

    public OrderVoiceConfigurationImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public OrderVoiceConfigurationImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      OrderVoiceConfigurationImpl newOrderVoiceConfigurationImpl =
          new OrderVoiceConfigurationImpl();
      Map<String, Object> result2 =
          tree.traverse(jp.getCodec()).readValueAs(new TypeReference<Map<String, Object>>() {});
      String discriminatorValue = (String) result2.get("type");
      switch (discriminatorValue) {
        case "EST":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(OrderVoiceConfigurationESTImpl.class);
          newOrderVoiceConfigurationImpl.setActualInstance(deserialized);
          return newOrderVoiceConfigurationImpl;
        case "FAX":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(OrderVoiceConfigurationFAXImpl.class);
          newOrderVoiceConfigurationImpl.setActualInstance(deserialized);
          return newOrderVoiceConfigurationImpl;
        case "RTC":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(OrderVoiceConfigurationRTCImpl.class);
          newOrderVoiceConfigurationImpl.setActualInstance(deserialized);
          return newOrderVoiceConfigurationImpl;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for OrderVoiceConfigurationImpl."
                      + " Possible values: EST FAX RTC",
                  discriminatorValue));
      }

      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize OrderVoiceConfigurationESTImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (OrderVoiceConfigurationESTImpl.class.equals(Integer.class)
            || OrderVoiceConfigurationESTImpl.class.equals(Long.class)
            || OrderVoiceConfigurationESTImpl.class.equals(Float.class)
            || OrderVoiceConfigurationESTImpl.class.equals(Double.class)
            || OrderVoiceConfigurationESTImpl.class.equals(Boolean.class)
            || OrderVoiceConfigurationESTImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((OrderVoiceConfigurationESTImpl.class.equals(Integer.class)
                        || OrderVoiceConfigurationESTImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((OrderVoiceConfigurationESTImpl.class.equals(Float.class)
                        || OrderVoiceConfigurationESTImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (OrderVoiceConfigurationESTImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (OrderVoiceConfigurationESTImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(OrderVoiceConfigurationESTImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'OrderVoiceConfigurationESTImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'OrderVoiceConfigurationESTImpl'", e);
      }

      // deserialize OrderVoiceConfigurationFAXImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (OrderVoiceConfigurationFAXImpl.class.equals(Integer.class)
            || OrderVoiceConfigurationFAXImpl.class.equals(Long.class)
            || OrderVoiceConfigurationFAXImpl.class.equals(Float.class)
            || OrderVoiceConfigurationFAXImpl.class.equals(Double.class)
            || OrderVoiceConfigurationFAXImpl.class.equals(Boolean.class)
            || OrderVoiceConfigurationFAXImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((OrderVoiceConfigurationFAXImpl.class.equals(Integer.class)
                        || OrderVoiceConfigurationFAXImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((OrderVoiceConfigurationFAXImpl.class.equals(Float.class)
                        || OrderVoiceConfigurationFAXImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (OrderVoiceConfigurationFAXImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (OrderVoiceConfigurationFAXImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(OrderVoiceConfigurationFAXImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'OrderVoiceConfigurationFAXImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'OrderVoiceConfigurationFAXImpl'", e);
      }

      // deserialize OrderVoiceConfigurationRTCImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (OrderVoiceConfigurationRTCImpl.class.equals(Integer.class)
            || OrderVoiceConfigurationRTCImpl.class.equals(Long.class)
            || OrderVoiceConfigurationRTCImpl.class.equals(Float.class)
            || OrderVoiceConfigurationRTCImpl.class.equals(Double.class)
            || OrderVoiceConfigurationRTCImpl.class.equals(Boolean.class)
            || OrderVoiceConfigurationRTCImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((OrderVoiceConfigurationRTCImpl.class.equals(Integer.class)
                        || OrderVoiceConfigurationRTCImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((OrderVoiceConfigurationRTCImpl.class.equals(Float.class)
                        || OrderVoiceConfigurationRTCImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (OrderVoiceConfigurationRTCImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (OrderVoiceConfigurationRTCImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(OrderVoiceConfigurationRTCImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'OrderVoiceConfigurationRTCImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'OrderVoiceConfigurationRTCImpl'", e);
      }

      if (match == 1) {
        OrderVoiceConfigurationImpl ret = new OrderVoiceConfigurationImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for OrderVoiceConfigurationImpl: %d classes match result,"
                  + " expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public OrderVoiceConfigurationImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(
          ctxt.getParser(), "OrderVoiceConfigurationImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public OrderVoiceConfigurationImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public OrderVoiceConfigurationImpl(OrderVoiceConfigurationESTImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public OrderVoiceConfigurationImpl(OrderVoiceConfigurationFAXImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public OrderVoiceConfigurationImpl(OrderVoiceConfigurationRTCImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("OrderVoiceConfigurationESTImpl", OrderVoiceConfigurationESTImpl.class);
    schemas.put("OrderVoiceConfigurationFAXImpl", OrderVoiceConfigurationFAXImpl.class);
    schemas.put("OrderVoiceConfigurationRTCImpl", OrderVoiceConfigurationRTCImpl.class);
    JSONNavigator.registerDescendants(
        OrderVoiceConfigurationImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("EST", OrderVoiceConfigurationESTImpl.class);
    mappings.put("FAX", OrderVoiceConfigurationFAXImpl.class);
    mappings.put("RTC", OrderVoiceConfigurationRTCImpl.class);
    mappings.put("OrderVoiceConfiguration", OrderVoiceConfigurationImpl.class);
    JSONNavigator.registerDiscriminator(OrderVoiceConfigurationImpl.class, "type", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return OrderVoiceConfigurationImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: OrderVoiceConfigurationESTImpl,
   * OrderVoiceConfigurationFAXImpl, OrderVoiceConfigurationRTCImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        OrderVoiceConfigurationESTImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        OrderVoiceConfigurationFAXImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        OrderVoiceConfigurationRTCImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be OrderVoiceConfigurationESTImpl,"
            + " OrderVoiceConfigurationFAXImpl, OrderVoiceConfigurationRTCImpl");
  }

  /**
   * Get the actual instance, which can be the following: OrderVoiceConfigurationESTImpl,
   * OrderVoiceConfigurationFAXImpl, OrderVoiceConfigurationRTCImpl
   *
   * @return The actual instance (OrderVoiceConfigurationESTImpl, OrderVoiceConfigurationFAXImpl,
   *     OrderVoiceConfigurationRTCImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `OrderVoiceConfigurationESTImpl`. If the actual instance is not
   * `OrderVoiceConfigurationESTImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `OrderVoiceConfigurationESTImpl`
   * @throws ClassCastException if the instance is not `OrderVoiceConfigurationESTImpl`
   */
  public OrderVoiceConfigurationESTImpl getOrderVoiceConfigurationESTImpl()
      throws ClassCastException {
    return (OrderVoiceConfigurationESTImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `OrderVoiceConfigurationFAXImpl`. If the actual instance is not
   * `OrderVoiceConfigurationFAXImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `OrderVoiceConfigurationFAXImpl`
   * @throws ClassCastException if the instance is not `OrderVoiceConfigurationFAXImpl`
   */
  public OrderVoiceConfigurationFAXImpl getOrderVoiceConfigurationFAXImpl()
      throws ClassCastException {
    return (OrderVoiceConfigurationFAXImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `OrderVoiceConfigurationRTCImpl`. If the actual instance is not
   * `OrderVoiceConfigurationRTCImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `OrderVoiceConfigurationRTCImpl`
   * @throws ClassCastException if the instance is not `OrderVoiceConfigurationRTCImpl`
   */
  public OrderVoiceConfigurationRTCImpl getOrderVoiceConfigurationRTCImpl()
      throws ClassCastException {
    return (OrderVoiceConfigurationRTCImpl) super.getActualInstance();
  }
}
