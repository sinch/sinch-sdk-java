package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.coupons.internal;

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
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.coupons.DiscountFixedCouponImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.coupons.DiscountRateCouponImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.coupons.DiscountShippingCouponImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.coupons.FreeCouponImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.coupons.UpCouponImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(using = KakaoTalkCouponInternalImpl.KakaoTalkCouponInternalImplDeserializer.class)
@JsonSerialize(using = KakaoTalkCouponInternalImpl.KakaoTalkCouponInternalImplSerializer.class)
public class KakaoTalkCouponInternalImpl extends AbstractOpenApiSchema
    implements KakaoTalkCouponInternal {
  private static final Logger log = Logger.getLogger(KakaoTalkCouponInternalImpl.class.getName());

  public static final class KakaoTalkCouponInternalImplSerializer
      extends StdSerializer<KakaoTalkCouponInternalImpl> {
    private static final long serialVersionUID = 1L;

    public KakaoTalkCouponInternalImplSerializer(Class<KakaoTalkCouponInternalImpl> t) {
      super(t);
    }

    public KakaoTalkCouponInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        KakaoTalkCouponInternalImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class KakaoTalkCouponInternalImplDeserializer
      extends StdDeserializer<KakaoTalkCouponInternalImpl> {

    private static final long serialVersionUID = 1L;

    public KakaoTalkCouponInternalImplDeserializer() {
      this(KakaoTalkCouponInternalImpl.class);
    }

    public KakaoTalkCouponInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public KakaoTalkCouponInternalImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize DiscountFixedCouponImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (DiscountFixedCouponImpl.class.equals(Integer.class)
            || DiscountFixedCouponImpl.class.equals(Long.class)
            || DiscountFixedCouponImpl.class.equals(Float.class)
            || DiscountFixedCouponImpl.class.equals(Double.class)
            || DiscountFixedCouponImpl.class.equals(Boolean.class)
            || DiscountFixedCouponImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((DiscountFixedCouponImpl.class.equals(Integer.class)
                        || DiscountFixedCouponImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((DiscountFixedCouponImpl.class.equals(Float.class)
                        || DiscountFixedCouponImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (DiscountFixedCouponImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (DiscountFixedCouponImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(DiscountFixedCouponImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'DiscountFixedCouponImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'DiscountFixedCouponImpl'", e);
      }

      // deserialize DiscountRateCouponImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (DiscountRateCouponImpl.class.equals(Integer.class)
            || DiscountRateCouponImpl.class.equals(Long.class)
            || DiscountRateCouponImpl.class.equals(Float.class)
            || DiscountRateCouponImpl.class.equals(Double.class)
            || DiscountRateCouponImpl.class.equals(Boolean.class)
            || DiscountRateCouponImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((DiscountRateCouponImpl.class.equals(Integer.class)
                        || DiscountRateCouponImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((DiscountRateCouponImpl.class.equals(Float.class)
                        || DiscountRateCouponImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (DiscountRateCouponImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (DiscountRateCouponImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(DiscountRateCouponImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'DiscountRateCouponImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'DiscountRateCouponImpl'", e);
      }

      // deserialize DiscountShippingCouponImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (DiscountShippingCouponImpl.class.equals(Integer.class)
            || DiscountShippingCouponImpl.class.equals(Long.class)
            || DiscountShippingCouponImpl.class.equals(Float.class)
            || DiscountShippingCouponImpl.class.equals(Double.class)
            || DiscountShippingCouponImpl.class.equals(Boolean.class)
            || DiscountShippingCouponImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((DiscountShippingCouponImpl.class.equals(Integer.class)
                        || DiscountShippingCouponImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((DiscountShippingCouponImpl.class.equals(Float.class)
                        || DiscountShippingCouponImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (DiscountShippingCouponImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (DiscountShippingCouponImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(DiscountShippingCouponImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'DiscountShippingCouponImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'DiscountShippingCouponImpl'", e);
      }

      // deserialize FreeCouponImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (FreeCouponImpl.class.equals(Integer.class)
            || FreeCouponImpl.class.equals(Long.class)
            || FreeCouponImpl.class.equals(Float.class)
            || FreeCouponImpl.class.equals(Double.class)
            || FreeCouponImpl.class.equals(Boolean.class)
            || FreeCouponImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((FreeCouponImpl.class.equals(Integer.class)
                        || FreeCouponImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((FreeCouponImpl.class.equals(Float.class)
                        || FreeCouponImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (FreeCouponImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (FreeCouponImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(FreeCouponImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'FreeCouponImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'FreeCouponImpl'", e);
      }

      // deserialize UpCouponImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (UpCouponImpl.class.equals(Integer.class)
            || UpCouponImpl.class.equals(Long.class)
            || UpCouponImpl.class.equals(Float.class)
            || UpCouponImpl.class.equals(Double.class)
            || UpCouponImpl.class.equals(Boolean.class)
            || UpCouponImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((UpCouponImpl.class.equals(Integer.class) || UpCouponImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((UpCouponImpl.class.equals(Float.class) || UpCouponImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (UpCouponImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (UpCouponImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(UpCouponImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'UpCouponImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'UpCouponImpl'", e);
      }

      if (match == 1) {
        KakaoTalkCouponInternalImpl ret = new KakaoTalkCouponInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for KakaoTalkCouponInternalImpl: %d classes match result,"
                  + " expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public KakaoTalkCouponInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(
          ctxt.getParser(), "KakaoTalkCouponInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public KakaoTalkCouponInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public KakaoTalkCouponInternalImpl(DiscountFixedCouponImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public KakaoTalkCouponInternalImpl(DiscountRateCouponImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public KakaoTalkCouponInternalImpl(DiscountShippingCouponImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public KakaoTalkCouponInternalImpl(FreeCouponImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public KakaoTalkCouponInternalImpl(UpCouponImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("DiscountFixedCouponImpl", DiscountFixedCouponImpl.class);
    schemas.put("DiscountRateCouponImpl", DiscountRateCouponImpl.class);
    schemas.put("DiscountShippingCouponImpl", DiscountShippingCouponImpl.class);
    schemas.put("FreeCouponImpl", FreeCouponImpl.class);
    schemas.put("UpCouponImpl", UpCouponImpl.class);
    JSONNavigator.registerDescendants(
        KakaoTalkCouponInternalImpl.class, Collections.unmodifiableMap(schemas));
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return KakaoTalkCouponInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: DiscountFixedCouponImpl, DiscountRateCouponImpl,
   * DiscountShippingCouponImpl, FreeCouponImpl, UpCouponImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        DiscountFixedCouponImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        DiscountRateCouponImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        DiscountShippingCouponImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(FreeCouponImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(UpCouponImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be DiscountFixedCouponImpl, DiscountRateCouponImpl,"
            + " DiscountShippingCouponImpl, FreeCouponImpl, UpCouponImpl");
  }

  /**
   * Get the actual instance, which can be the following: DiscountFixedCouponImpl,
   * DiscountRateCouponImpl, DiscountShippingCouponImpl, FreeCouponImpl, UpCouponImpl
   *
   * @return The actual instance (DiscountFixedCouponImpl, DiscountRateCouponImpl,
   *     DiscountShippingCouponImpl, FreeCouponImpl, UpCouponImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `DiscountFixedCouponImpl`. If the actual instance is not
   * `DiscountFixedCouponImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `DiscountFixedCouponImpl`
   * @throws ClassCastException if the instance is not `DiscountFixedCouponImpl`
   */
  public DiscountFixedCouponImpl getDiscountFixedCouponImpl() throws ClassCastException {
    return (DiscountFixedCouponImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `DiscountRateCouponImpl`. If the actual instance is not
   * `DiscountRateCouponImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `DiscountRateCouponImpl`
   * @throws ClassCastException if the instance is not `DiscountRateCouponImpl`
   */
  public DiscountRateCouponImpl getDiscountRateCouponImpl() throws ClassCastException {
    return (DiscountRateCouponImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `DiscountShippingCouponImpl`. If the actual instance is not
   * `DiscountShippingCouponImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `DiscountShippingCouponImpl`
   * @throws ClassCastException if the instance is not `DiscountShippingCouponImpl`
   */
  public DiscountShippingCouponImpl getDiscountShippingCouponImpl() throws ClassCastException {
    return (DiscountShippingCouponImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `FreeCouponImpl`. If the actual instance is not `FreeCouponImpl`,
   * the ClassCastException will be thrown.
   *
   * @return The actual instance of `FreeCouponImpl`
   * @throws ClassCastException if the instance is not `FreeCouponImpl`
   */
  public FreeCouponImpl getFreeCouponImpl() throws ClassCastException {
    return (FreeCouponImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `UpCouponImpl`. If the actual instance is not `UpCouponImpl`, the
   * ClassCastException will be thrown.
   *
   * @return The actual instance of `UpCouponImpl`
   * @throws ClassCastException if the instance is not `UpCouponImpl`
   */
  public UpCouponImpl getUpCouponImpl() throws ClassCastException {
    return (UpCouponImpl) super.getActualInstance();
  }
}
