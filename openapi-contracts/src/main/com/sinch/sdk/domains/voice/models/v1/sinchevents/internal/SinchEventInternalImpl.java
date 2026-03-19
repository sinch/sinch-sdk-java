package com.sinch.sdk.domains.voice.models.v1.sinchevents.internal;

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
import com.sinch.sdk.domains.voice.models.v1.sinchevents.AnsweredCallEventImpl;
import com.sinch.sdk.domains.voice.models.v1.sinchevents.DisconnectedCallEventImpl;
import com.sinch.sdk.domains.voice.models.v1.sinchevents.IncomingCallEventImpl;
import com.sinch.sdk.domains.voice.models.v1.sinchevents.NotificationEventImpl;
import com.sinch.sdk.domains.voice.models.v1.sinchevents.PromptInputEventImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(using = SinchEventInternalImpl.SinchEventInternalImplDeserializer.class)
@JsonSerialize(using = SinchEventInternalImpl.SinchEventInternalImplSerializer.class)
public class SinchEventInternalImpl extends AbstractOpenApiSchema implements SinchEventInternal {
  private static final Logger log = Logger.getLogger(SinchEventInternalImpl.class.getName());

  public static final class SinchEventInternalImplSerializer
      extends StdSerializer<SinchEventInternalImpl> {
    private static final long serialVersionUID = 1L;

    public SinchEventInternalImplSerializer(Class<SinchEventInternalImpl> t) {
      super(t);
    }

    public SinchEventInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        SinchEventInternalImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class SinchEventInternalImplDeserializer
      extends StdDeserializer<SinchEventInternalImpl> {

    private static final long serialVersionUID = 1L;

    public SinchEventInternalImplDeserializer() {
      this(SinchEventInternalImpl.class);
    }

    public SinchEventInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public SinchEventInternalImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      SinchEventInternalImpl newSinchEventInternalImpl = new SinchEventInternalImpl();
      Map<String, Object> result2 =
          tree.traverse(jp.getCodec()).readValueAs(new TypeReference<Map<String, Object>>() {});
      String discriminatorValue = (String) result2.get("event");
      switch (discriminatorValue) {
        case "ace":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(AnsweredCallEventImpl.class);
          newSinchEventInternalImpl.setActualInstance(deserialized);
          return newSinchEventInternalImpl;
        case "dice":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(DisconnectedCallEventImpl.class);
          newSinchEventInternalImpl.setActualInstance(deserialized);
          return newSinchEventInternalImpl;
        case "ice":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(IncomingCallEventImpl.class);
          newSinchEventInternalImpl.setActualInstance(deserialized);
          return newSinchEventInternalImpl;
        case "notify":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(NotificationEventImpl.class);
          newSinchEventInternalImpl.setActualInstance(deserialized);
          return newSinchEventInternalImpl;
        case "pie":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(PromptInputEventImpl.class);
          newSinchEventInternalImpl.setActualInstance(deserialized);
          return newSinchEventInternalImpl;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for SinchEventInternalImpl. Possible"
                      + " values: ace dice ice notify pie",
                  discriminatorValue));
      }

      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize AnsweredCallEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (AnsweredCallEventImpl.class.equals(Integer.class)
            || AnsweredCallEventImpl.class.equals(Long.class)
            || AnsweredCallEventImpl.class.equals(Float.class)
            || AnsweredCallEventImpl.class.equals(Double.class)
            || AnsweredCallEventImpl.class.equals(Boolean.class)
            || AnsweredCallEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((AnsweredCallEventImpl.class.equals(Integer.class)
                        || AnsweredCallEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((AnsweredCallEventImpl.class.equals(Float.class)
                        || AnsweredCallEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (AnsweredCallEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (AnsweredCallEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(AnsweredCallEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'AnsweredCallEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'AnsweredCallEventImpl'", e);
      }

      // deserialize DisconnectedCallEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (DisconnectedCallEventImpl.class.equals(Integer.class)
            || DisconnectedCallEventImpl.class.equals(Long.class)
            || DisconnectedCallEventImpl.class.equals(Float.class)
            || DisconnectedCallEventImpl.class.equals(Double.class)
            || DisconnectedCallEventImpl.class.equals(Boolean.class)
            || DisconnectedCallEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((DisconnectedCallEventImpl.class.equals(Integer.class)
                        || DisconnectedCallEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((DisconnectedCallEventImpl.class.equals(Float.class)
                        || DisconnectedCallEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (DisconnectedCallEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (DisconnectedCallEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(DisconnectedCallEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'DisconnectedCallEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'DisconnectedCallEventImpl'", e);
      }

      // deserialize IncomingCallEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (IncomingCallEventImpl.class.equals(Integer.class)
            || IncomingCallEventImpl.class.equals(Long.class)
            || IncomingCallEventImpl.class.equals(Float.class)
            || IncomingCallEventImpl.class.equals(Double.class)
            || IncomingCallEventImpl.class.equals(Boolean.class)
            || IncomingCallEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((IncomingCallEventImpl.class.equals(Integer.class)
                        || IncomingCallEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((IncomingCallEventImpl.class.equals(Float.class)
                        || IncomingCallEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (IncomingCallEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (IncomingCallEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(IncomingCallEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'IncomingCallEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'IncomingCallEventImpl'", e);
      }

      // deserialize NotificationEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (NotificationEventImpl.class.equals(Integer.class)
            || NotificationEventImpl.class.equals(Long.class)
            || NotificationEventImpl.class.equals(Float.class)
            || NotificationEventImpl.class.equals(Double.class)
            || NotificationEventImpl.class.equals(Boolean.class)
            || NotificationEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((NotificationEventImpl.class.equals(Integer.class)
                        || NotificationEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((NotificationEventImpl.class.equals(Float.class)
                        || NotificationEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (NotificationEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (NotificationEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(NotificationEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'NotificationEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'NotificationEventImpl'", e);
      }

      // deserialize PromptInputEventImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (PromptInputEventImpl.class.equals(Integer.class)
            || PromptInputEventImpl.class.equals(Long.class)
            || PromptInputEventImpl.class.equals(Float.class)
            || PromptInputEventImpl.class.equals(Double.class)
            || PromptInputEventImpl.class.equals(Boolean.class)
            || PromptInputEventImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((PromptInputEventImpl.class.equals(Integer.class)
                        || PromptInputEventImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((PromptInputEventImpl.class.equals(Float.class)
                        || PromptInputEventImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (PromptInputEventImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (PromptInputEventImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(PromptInputEventImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'PromptInputEventImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'PromptInputEventImpl'", e);
      }

      if (match == 1) {
        SinchEventInternalImpl ret = new SinchEventInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for SinchEventInternalImpl: %d classes match result, expected"
                  + " 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public SinchEventInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "SinchEventInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public SinchEventInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public SinchEventInternalImpl(AnsweredCallEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public SinchEventInternalImpl(DisconnectedCallEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public SinchEventInternalImpl(IncomingCallEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public SinchEventInternalImpl(NotificationEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public SinchEventInternalImpl(PromptInputEventImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("AnsweredCallEventImpl", AnsweredCallEventImpl.class);
    schemas.put("DisconnectedCallEventImpl", DisconnectedCallEventImpl.class);
    schemas.put("IncomingCallEventImpl", IncomingCallEventImpl.class);
    schemas.put("NotificationEventImpl", NotificationEventImpl.class);
    schemas.put("PromptInputEventImpl", PromptInputEventImpl.class);
    JSONNavigator.registerDescendants(
        SinchEventInternalImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("ace", AnsweredCallEventImpl.class);
    mappings.put("dice", DisconnectedCallEventImpl.class);
    mappings.put("ice", IncomingCallEventImpl.class);
    mappings.put("notify", NotificationEventImpl.class);
    mappings.put("pie", PromptInputEventImpl.class);
    mappings.put("webhooksEvent", SinchEventInternalImpl.class);
    JSONNavigator.registerDiscriminator(SinchEventInternalImpl.class, "event", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return SinchEventInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: AnsweredCallEventImpl, DisconnectedCallEventImpl,
   * IncomingCallEventImpl, NotificationEventImpl, PromptInputEventImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        AnsweredCallEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        DisconnectedCallEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        IncomingCallEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        NotificationEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(PromptInputEventImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be AnsweredCallEventImpl, DisconnectedCallEventImpl,"
            + " IncomingCallEventImpl, NotificationEventImpl, PromptInputEventImpl");
  }

  /**
   * Get the actual instance, which can be the following: AnsweredCallEventImpl,
   * DisconnectedCallEventImpl, IncomingCallEventImpl, NotificationEventImpl, PromptInputEventImpl
   *
   * @return The actual instance (AnsweredCallEventImpl, DisconnectedCallEventImpl,
   *     IncomingCallEventImpl, NotificationEventImpl, PromptInputEventImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `AnsweredCallEventImpl`. If the actual instance is not
   * `AnsweredCallEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `AnsweredCallEventImpl`
   * @throws ClassCastException if the instance is not `AnsweredCallEventImpl`
   */
  public AnsweredCallEventImpl getAnsweredCallEventImpl() throws ClassCastException {
    return (AnsweredCallEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `DisconnectedCallEventImpl`. If the actual instance is not
   * `DisconnectedCallEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `DisconnectedCallEventImpl`
   * @throws ClassCastException if the instance is not `DisconnectedCallEventImpl`
   */
  public DisconnectedCallEventImpl getDisconnectedCallEventImpl() throws ClassCastException {
    return (DisconnectedCallEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `IncomingCallEventImpl`. If the actual instance is not
   * `IncomingCallEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `IncomingCallEventImpl`
   * @throws ClassCastException if the instance is not `IncomingCallEventImpl`
   */
  public IncomingCallEventImpl getIncomingCallEventImpl() throws ClassCastException {
    return (IncomingCallEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `NotificationEventImpl`. If the actual instance is not
   * `NotificationEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `NotificationEventImpl`
   * @throws ClassCastException if the instance is not `NotificationEventImpl`
   */
  public NotificationEventImpl getNotificationEventImpl() throws ClassCastException {
    return (NotificationEventImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `PromptInputEventImpl`. If the actual instance is not
   * `PromptInputEventImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `PromptInputEventImpl`
   * @throws ClassCastException if the instance is not `PromptInputEventImpl`
   */
  public PromptInputEventImpl getPromptInputEventImpl() throws ClassCastException {
    return (PromptInputEventImpl) super.getActualInstance();
  }
}
