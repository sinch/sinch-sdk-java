package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.buttons.internal;

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
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.buttons.AppLinkButtonImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.buttons.BotKeywordButtonImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.buttons.WebLinkButtonImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(using = KakaoTalkButtonInternalImpl.KakaoTalkButtonInternalImplDeserializer.class)
@JsonSerialize(using = KakaoTalkButtonInternalImpl.KakaoTalkButtonInternalImplSerializer.class)
public class KakaoTalkButtonInternalImpl extends AbstractOpenApiSchema
    implements KakaoTalkButtonInternal {
  private static final Logger log = Logger.getLogger(KakaoTalkButtonInternalImpl.class.getName());

  public static final class KakaoTalkButtonInternalImplSerializer
      extends StdSerializer<KakaoTalkButtonInternalImpl> {
    private static final long serialVersionUID = 1L;

    public KakaoTalkButtonInternalImplSerializer(Class<KakaoTalkButtonInternalImpl> t) {
      super(t);
    }

    public KakaoTalkButtonInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        KakaoTalkButtonInternalImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class KakaoTalkButtonInternalImplDeserializer
      extends StdDeserializer<KakaoTalkButtonInternalImpl> {

    private static final long serialVersionUID = 1L;

    public KakaoTalkButtonInternalImplDeserializer() {
      this(KakaoTalkButtonInternalImpl.class);
    }

    public KakaoTalkButtonInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public KakaoTalkButtonInternalImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize AppLinkButtonImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (AppLinkButtonImpl.class.equals(Integer.class)
            || AppLinkButtonImpl.class.equals(Long.class)
            || AppLinkButtonImpl.class.equals(Float.class)
            || AppLinkButtonImpl.class.equals(Double.class)
            || AppLinkButtonImpl.class.equals(Boolean.class)
            || AppLinkButtonImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((AppLinkButtonImpl.class.equals(Integer.class)
                        || AppLinkButtonImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((AppLinkButtonImpl.class.equals(Float.class)
                        || AppLinkButtonImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (AppLinkButtonImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (AppLinkButtonImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(AppLinkButtonImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'AppLinkButtonImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'AppLinkButtonImpl'", e);
      }

      // deserialize BotKeywordButtonImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (BotKeywordButtonImpl.class.equals(Integer.class)
            || BotKeywordButtonImpl.class.equals(Long.class)
            || BotKeywordButtonImpl.class.equals(Float.class)
            || BotKeywordButtonImpl.class.equals(Double.class)
            || BotKeywordButtonImpl.class.equals(Boolean.class)
            || BotKeywordButtonImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((BotKeywordButtonImpl.class.equals(Integer.class)
                        || BotKeywordButtonImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((BotKeywordButtonImpl.class.equals(Float.class)
                        || BotKeywordButtonImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (BotKeywordButtonImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (BotKeywordButtonImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(BotKeywordButtonImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'BotKeywordButtonImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'BotKeywordButtonImpl'", e);
      }

      // deserialize WebLinkButtonImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (WebLinkButtonImpl.class.equals(Integer.class)
            || WebLinkButtonImpl.class.equals(Long.class)
            || WebLinkButtonImpl.class.equals(Float.class)
            || WebLinkButtonImpl.class.equals(Double.class)
            || WebLinkButtonImpl.class.equals(Boolean.class)
            || WebLinkButtonImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((WebLinkButtonImpl.class.equals(Integer.class)
                        || WebLinkButtonImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((WebLinkButtonImpl.class.equals(Float.class)
                        || WebLinkButtonImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (WebLinkButtonImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (WebLinkButtonImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(WebLinkButtonImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'WebLinkButtonImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'WebLinkButtonImpl'", e);
      }

      if (match == 1) {
        KakaoTalkButtonInternalImpl ret = new KakaoTalkButtonInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for KakaoTalkButtonInternalImpl: %d classes match result,"
                  + " expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public KakaoTalkButtonInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(
          ctxt.getParser(), "KakaoTalkButtonInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public KakaoTalkButtonInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public KakaoTalkButtonInternalImpl(AppLinkButtonImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public KakaoTalkButtonInternalImpl(BotKeywordButtonImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public KakaoTalkButtonInternalImpl(WebLinkButtonImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("AppLinkButtonImpl", AppLinkButtonImpl.class);
    schemas.put("BotKeywordButtonImpl", BotKeywordButtonImpl.class);
    schemas.put("WebLinkButtonImpl", WebLinkButtonImpl.class);
    JSONNavigator.registerDescendants(
        KakaoTalkButtonInternalImpl.class, Collections.unmodifiableMap(schemas));
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return KakaoTalkButtonInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: AppLinkButtonImpl, BotKeywordButtonImpl, WebLinkButtonImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(AppLinkButtonImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(BotKeywordButtonImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(WebLinkButtonImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be AppLinkButtonImpl, BotKeywordButtonImpl,"
            + " WebLinkButtonImpl");
  }

  /**
   * Get the actual instance, which can be the following: AppLinkButtonImpl, BotKeywordButtonImpl,
   * WebLinkButtonImpl
   *
   * @return The actual instance (AppLinkButtonImpl, BotKeywordButtonImpl, WebLinkButtonImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `AppLinkButtonImpl`. If the actual instance is not
   * `AppLinkButtonImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `AppLinkButtonImpl`
   * @throws ClassCastException if the instance is not `AppLinkButtonImpl`
   */
  public AppLinkButtonImpl getAppLinkButtonImpl() throws ClassCastException {
    return (AppLinkButtonImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `BotKeywordButtonImpl`. If the actual instance is not
   * `BotKeywordButtonImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `BotKeywordButtonImpl`
   * @throws ClassCastException if the instance is not `BotKeywordButtonImpl`
   */
  public BotKeywordButtonImpl getBotKeywordButtonImpl() throws ClassCastException {
    return (BotKeywordButtonImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `WebLinkButtonImpl`. If the actual instance is not
   * `WebLinkButtonImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `WebLinkButtonImpl`
   * @throws ClassCastException if the instance is not `WebLinkButtonImpl`
   */
  public WebLinkButtonImpl getWebLinkButtonImpl() throws ClassCastException {
    return (WebLinkButtonImpl) super.getActualInstance();
  }
}
