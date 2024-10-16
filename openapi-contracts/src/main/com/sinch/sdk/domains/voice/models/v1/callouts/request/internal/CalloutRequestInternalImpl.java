package com.sinch.sdk.domains.voice.models.v1.callouts.request.internal;

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
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestConferenceImpl;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestCustomImpl;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestTTSImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(using = CalloutRequestInternalImpl.CalloutRequestInternalImplDeserializer.class)
@JsonSerialize(using = CalloutRequestInternalImpl.CalloutRequestInternalImplSerializer.class)
public class CalloutRequestInternalImpl extends AbstractOpenApiSchema
    implements CalloutRequestInternal {
  private static final Logger log = Logger.getLogger(CalloutRequestInternalImpl.class.getName());

  public static final class CalloutRequestInternalImplSerializer
      extends StdSerializer<CalloutRequestInternalImpl> {
    private static final long serialVersionUID = 1L;

    public CalloutRequestInternalImplSerializer(Class<CalloutRequestInternalImpl> t) {
      super(t);
    }

    public CalloutRequestInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        CalloutRequestInternalImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class CalloutRequestInternalImplDeserializer
      extends StdDeserializer<CalloutRequestInternalImpl> {

    private static final long serialVersionUID = 1L;

    public CalloutRequestInternalImplDeserializer() {
      this(CalloutRequestInternalImpl.class);
    }

    public CalloutRequestInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public CalloutRequestInternalImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      CalloutRequestInternalImpl newCalloutRequestInternalImpl = new CalloutRequestInternalImpl();
      Map<String, Object> result2 =
          tree.traverse(jp.getCodec()).readValueAs(new TypeReference<Map<String, Object>>() {});
      String discriminatorValue = (String) result2.get("method");
      switch (discriminatorValue) {
        case "conferenceCallout":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(CalloutRequestConferenceImpl.class);
          newCalloutRequestInternalImpl.setActualInstance(deserialized);
          return newCalloutRequestInternalImpl;
        case "customCallout":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(CalloutRequestCustomImpl.class);
          newCalloutRequestInternalImpl.setActualInstance(deserialized);
          return newCalloutRequestInternalImpl;
        case "ttsCallout":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(CalloutRequestTTSImpl.class);
          newCalloutRequestInternalImpl.setActualInstance(deserialized);
          return newCalloutRequestInternalImpl;
        case "conferenceCalloutRequest":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(CalloutRequestConferenceImpl.class);
          newCalloutRequestInternalImpl.setActualInstance(deserialized);
          return newCalloutRequestInternalImpl;
        case "customCalloutRequest":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(CalloutRequestCustomImpl.class);
          newCalloutRequestInternalImpl.setActualInstance(deserialized);
          return newCalloutRequestInternalImpl;
        case "ttsCalloutRequest":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(CalloutRequestTTSImpl.class);
          newCalloutRequestInternalImpl.setActualInstance(deserialized);
          return newCalloutRequestInternalImpl;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for CalloutRequestInternalImpl."
                      + " Possible values: conferenceCallout customCallout ttsCallout"
                      + " conferenceCalloutRequest customCalloutRequest ttsCalloutRequest",
                  discriminatorValue));
      }

      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize CalloutRequestConferenceImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (CalloutRequestConferenceImpl.class.equals(Integer.class)
            || CalloutRequestConferenceImpl.class.equals(Long.class)
            || CalloutRequestConferenceImpl.class.equals(Float.class)
            || CalloutRequestConferenceImpl.class.equals(Double.class)
            || CalloutRequestConferenceImpl.class.equals(Boolean.class)
            || CalloutRequestConferenceImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((CalloutRequestConferenceImpl.class.equals(Integer.class)
                        || CalloutRequestConferenceImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((CalloutRequestConferenceImpl.class.equals(Float.class)
                        || CalloutRequestConferenceImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (CalloutRequestConferenceImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (CalloutRequestConferenceImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(CalloutRequestConferenceImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'CalloutRequestConferenceImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'CalloutRequestConferenceImpl'", e);
      }

      // deserialize CalloutRequestCustomImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (CalloutRequestCustomImpl.class.equals(Integer.class)
            || CalloutRequestCustomImpl.class.equals(Long.class)
            || CalloutRequestCustomImpl.class.equals(Float.class)
            || CalloutRequestCustomImpl.class.equals(Double.class)
            || CalloutRequestCustomImpl.class.equals(Boolean.class)
            || CalloutRequestCustomImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((CalloutRequestCustomImpl.class.equals(Integer.class)
                        || CalloutRequestCustomImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((CalloutRequestCustomImpl.class.equals(Float.class)
                        || CalloutRequestCustomImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (CalloutRequestCustomImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (CalloutRequestCustomImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(CalloutRequestCustomImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'CalloutRequestCustomImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'CalloutRequestCustomImpl'", e);
      }

      // deserialize CalloutRequestTTSImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (CalloutRequestTTSImpl.class.equals(Integer.class)
            || CalloutRequestTTSImpl.class.equals(Long.class)
            || CalloutRequestTTSImpl.class.equals(Float.class)
            || CalloutRequestTTSImpl.class.equals(Double.class)
            || CalloutRequestTTSImpl.class.equals(Boolean.class)
            || CalloutRequestTTSImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((CalloutRequestTTSImpl.class.equals(Integer.class)
                        || CalloutRequestTTSImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((CalloutRequestTTSImpl.class.equals(Float.class)
                        || CalloutRequestTTSImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (CalloutRequestTTSImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (CalloutRequestTTSImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(CalloutRequestTTSImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'CalloutRequestTTSImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'CalloutRequestTTSImpl'", e);
      }

      if (match == 1) {
        CalloutRequestInternalImpl ret = new CalloutRequestInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for CalloutRequestInternalImpl: %d classes match result,"
                  + " expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public CalloutRequestInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "CalloutRequestInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public CalloutRequestInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public CalloutRequestInternalImpl(CalloutRequestConferenceImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public CalloutRequestInternalImpl(CalloutRequestCustomImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public CalloutRequestInternalImpl(CalloutRequestTTSImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("CalloutRequestConferenceImpl", CalloutRequestConferenceImpl.class);
    schemas.put("CalloutRequestCustomImpl", CalloutRequestCustomImpl.class);
    schemas.put("CalloutRequestTTSImpl", CalloutRequestTTSImpl.class);
    JSONNavigator.registerDescendants(
        CalloutRequestInternalImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("conferenceCallout", CalloutRequestConferenceImpl.class);
    mappings.put("customCallout", CalloutRequestCustomImpl.class);
    mappings.put("ttsCallout", CalloutRequestTTSImpl.class);
    mappings.put("conferenceCalloutRequest", CalloutRequestConferenceImpl.class);
    mappings.put("customCalloutRequest", CalloutRequestCustomImpl.class);
    mappings.put("ttsCalloutRequest", CalloutRequestTTSImpl.class);
    mappings.put("CalloutRequest", CalloutRequestInternalImpl.class);
    JSONNavigator.registerDiscriminator(CalloutRequestInternalImpl.class, "method", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return CalloutRequestInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: CalloutRequestConferenceImpl, CalloutRequestCustomImpl,
   * CalloutRequestTTSImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        CalloutRequestConferenceImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        CalloutRequestCustomImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        CalloutRequestTTSImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be CalloutRequestConferenceImpl, CalloutRequestCustomImpl,"
            + " CalloutRequestTTSImpl");
  }

  /**
   * Get the actual instance, which can be the following: CalloutRequestConferenceImpl,
   * CalloutRequestCustomImpl, CalloutRequestTTSImpl
   *
   * @return The actual instance (CalloutRequestConferenceImpl, CalloutRequestCustomImpl,
   *     CalloutRequestTTSImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `CalloutRequestConferenceImpl`. If the actual instance is not
   * `CalloutRequestConferenceImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `CalloutRequestConferenceImpl`
   * @throws ClassCastException if the instance is not `CalloutRequestConferenceImpl`
   */
  public CalloutRequestConferenceImpl getCalloutRequestConferenceImpl() throws ClassCastException {
    return (CalloutRequestConferenceImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `CalloutRequestCustomImpl`. If the actual instance is not
   * `CalloutRequestCustomImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `CalloutRequestCustomImpl`
   * @throws ClassCastException if the instance is not `CalloutRequestCustomImpl`
   */
  public CalloutRequestCustomImpl getCalloutRequestCustomImpl() throws ClassCastException {
    return (CalloutRequestCustomImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `CalloutRequestTTSImpl`. If the actual instance is not
   * `CalloutRequestTTSImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `CalloutRequestTTSImpl`
   * @throws ClassCastException if the instance is not `CalloutRequestTTSImpl`
   */
  public CalloutRequestTTSImpl getCalloutRequestTTSImpl() throws ClassCastException {
    return (CalloutRequestTTSImpl) super.getActualInstance();
  }
}
