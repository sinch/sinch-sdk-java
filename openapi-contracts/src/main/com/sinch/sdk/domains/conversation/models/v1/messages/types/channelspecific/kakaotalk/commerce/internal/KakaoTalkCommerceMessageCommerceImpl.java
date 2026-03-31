package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.commerce.internal;

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
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.commerce.DiscountFixedCommerceImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.commerce.DiscountRateCommerceImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.commerce.RegularPriceCommerceImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(
    using =
        KakaoTalkCommerceMessageCommerceImpl.KakaoTalkCommerceMessageCommerceImplDeserializer.class)
@JsonSerialize(
    using =
        KakaoTalkCommerceMessageCommerceImpl.KakaoTalkCommerceMessageCommerceImplSerializer.class)
public class KakaoTalkCommerceMessageCommerceImpl extends AbstractOpenApiSchema
    implements KakaoTalkCommerceMessageCommerce {
  private static final Logger log =
      Logger.getLogger(KakaoTalkCommerceMessageCommerceImpl.class.getName());

  public static final class KakaoTalkCommerceMessageCommerceImplSerializer
      extends StdSerializer<KakaoTalkCommerceMessageCommerceImpl> {
    private static final long serialVersionUID = 1L;

    public KakaoTalkCommerceMessageCommerceImplSerializer(
        Class<KakaoTalkCommerceMessageCommerceImpl> t) {
      super(t);
    }

    public KakaoTalkCommerceMessageCommerceImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        KakaoTalkCommerceMessageCommerceImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class KakaoTalkCommerceMessageCommerceImplDeserializer
      extends StdDeserializer<KakaoTalkCommerceMessageCommerceImpl> {

    private static final long serialVersionUID = 1L;

    public KakaoTalkCommerceMessageCommerceImplDeserializer() {
      this(KakaoTalkCommerceMessageCommerceImpl.class);
    }

    public KakaoTalkCommerceMessageCommerceImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public KakaoTalkCommerceMessageCommerceImpl deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize DiscountFixedCommerceImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (DiscountFixedCommerceImpl.class.equals(Integer.class)
            || DiscountFixedCommerceImpl.class.equals(Long.class)
            || DiscountFixedCommerceImpl.class.equals(Float.class)
            || DiscountFixedCommerceImpl.class.equals(Double.class)
            || DiscountFixedCommerceImpl.class.equals(Boolean.class)
            || DiscountFixedCommerceImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((DiscountFixedCommerceImpl.class.equals(Integer.class)
                        || DiscountFixedCommerceImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((DiscountFixedCommerceImpl.class.equals(Float.class)
                        || DiscountFixedCommerceImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (DiscountFixedCommerceImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (DiscountFixedCommerceImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(DiscountFixedCommerceImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'DiscountFixedCommerceImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'DiscountFixedCommerceImpl'", e);
      }

      // deserialize DiscountRateCommerceImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (DiscountRateCommerceImpl.class.equals(Integer.class)
            || DiscountRateCommerceImpl.class.equals(Long.class)
            || DiscountRateCommerceImpl.class.equals(Float.class)
            || DiscountRateCommerceImpl.class.equals(Double.class)
            || DiscountRateCommerceImpl.class.equals(Boolean.class)
            || DiscountRateCommerceImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((DiscountRateCommerceImpl.class.equals(Integer.class)
                        || DiscountRateCommerceImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((DiscountRateCommerceImpl.class.equals(Float.class)
                        || DiscountRateCommerceImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (DiscountRateCommerceImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (DiscountRateCommerceImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(DiscountRateCommerceImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'DiscountRateCommerceImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'DiscountRateCommerceImpl'", e);
      }

      // deserialize RegularPriceCommerceImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (RegularPriceCommerceImpl.class.equals(Integer.class)
            || RegularPriceCommerceImpl.class.equals(Long.class)
            || RegularPriceCommerceImpl.class.equals(Float.class)
            || RegularPriceCommerceImpl.class.equals(Double.class)
            || RegularPriceCommerceImpl.class.equals(Boolean.class)
            || RegularPriceCommerceImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((RegularPriceCommerceImpl.class.equals(Integer.class)
                        || RegularPriceCommerceImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((RegularPriceCommerceImpl.class.equals(Float.class)
                        || RegularPriceCommerceImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (RegularPriceCommerceImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (RegularPriceCommerceImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(RegularPriceCommerceImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'RegularPriceCommerceImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'RegularPriceCommerceImpl'", e);
      }

      if (match == 1) {
        KakaoTalkCommerceMessageCommerceImpl ret = new KakaoTalkCommerceMessageCommerceImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for KakaoTalkCommerceMessageCommerceImpl: %d classes match"
                  + " result, expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public KakaoTalkCommerceMessageCommerceImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(
          ctxt.getParser(), "KakaoTalkCommerceMessageCommerceImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public KakaoTalkCommerceMessageCommerceImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public KakaoTalkCommerceMessageCommerceImpl(DiscountFixedCommerceImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public KakaoTalkCommerceMessageCommerceImpl(DiscountRateCommerceImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public KakaoTalkCommerceMessageCommerceImpl(RegularPriceCommerceImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("DiscountFixedCommerceImpl", DiscountFixedCommerceImpl.class);
    schemas.put("DiscountRateCommerceImpl", DiscountRateCommerceImpl.class);
    schemas.put("RegularPriceCommerceImpl", RegularPriceCommerceImpl.class);
    JSONNavigator.registerDescendants(
        KakaoTalkCommerceMessageCommerceImpl.class, Collections.unmodifiableMap(schemas));
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return KakaoTalkCommerceMessageCommerceImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: DiscountFixedCommerceImpl, DiscountRateCommerceImpl,
   * RegularPriceCommerceImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        DiscountFixedCommerceImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        DiscountRateCommerceImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        RegularPriceCommerceImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be DiscountFixedCommerceImpl, DiscountRateCommerceImpl,"
            + " RegularPriceCommerceImpl");
  }

  /**
   * Get the actual instance, which can be the following: DiscountFixedCommerceImpl,
   * DiscountRateCommerceImpl, RegularPriceCommerceImpl
   *
   * @return The actual instance (DiscountFixedCommerceImpl, DiscountRateCommerceImpl,
   *     RegularPriceCommerceImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `DiscountFixedCommerceImpl`. If the actual instance is not
   * `DiscountFixedCommerceImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `DiscountFixedCommerceImpl`
   * @throws ClassCastException if the instance is not `DiscountFixedCommerceImpl`
   */
  public DiscountFixedCommerceImpl getDiscountFixedCommerceImpl() throws ClassCastException {
    return (DiscountFixedCommerceImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `DiscountRateCommerceImpl`. If the actual instance is not
   * `DiscountRateCommerceImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `DiscountRateCommerceImpl`
   * @throws ClassCastException if the instance is not `DiscountRateCommerceImpl`
   */
  public DiscountRateCommerceImpl getDiscountRateCommerceImpl() throws ClassCastException {
    return (DiscountRateCommerceImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `RegularPriceCommerceImpl`. If the actual instance is not
   * `RegularPriceCommerceImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `RegularPriceCommerceImpl`
   * @throws ClassCastException if the instance is not `RegularPriceCommerceImpl`
   */
  public RegularPriceCommerceImpl getRegularPriceCommerceImpl() throws ClassCastException {
    return (RegularPriceCommerceImpl) super.getActualInstance();
  }
}
