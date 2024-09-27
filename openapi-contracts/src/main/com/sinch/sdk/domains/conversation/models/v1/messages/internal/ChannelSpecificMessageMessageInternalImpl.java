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
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows.FlowChannelSpecificMessageImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(
    using =
        ChannelSpecificMessageMessageInternalImpl
            .ChannelSpecificMessageMessageInternalImplDeserializer.class)
@JsonSerialize(
    using =
        ChannelSpecificMessageMessageInternalImpl
            .ChannelSpecificMessageMessageInternalImplSerializer.class)
public class ChannelSpecificMessageMessageInternalImpl extends AbstractOpenApiSchema
    implements ChannelSpecificMessageMessageInternal {
  private static final Logger log =
      Logger.getLogger(ChannelSpecificMessageMessageInternalImpl.class.getName());

  public static final class ChannelSpecificMessageMessageInternalImplSerializer
      extends StdSerializer<ChannelSpecificMessageMessageInternalImpl> {
    private static final long serialVersionUID = 1L;

    public ChannelSpecificMessageMessageInternalImplSerializer(
        Class<ChannelSpecificMessageMessageInternalImpl> t) {
      super(t);
    }

    public ChannelSpecificMessageMessageInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        ChannelSpecificMessageMessageInternalImpl value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class ChannelSpecificMessageMessageInternalImplDeserializer
      extends StdDeserializer<ChannelSpecificMessageMessageInternalImpl> {

    private static final long serialVersionUID = 1L;

    public ChannelSpecificMessageMessageInternalImplDeserializer() {
      this(ChannelSpecificMessageMessageInternalImpl.class);
    }

    public ChannelSpecificMessageMessageInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public ChannelSpecificMessageMessageInternalImpl deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize FlowChannelSpecificMessageImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (FlowChannelSpecificMessageImpl.class.equals(Integer.class)
            || FlowChannelSpecificMessageImpl.class.equals(Long.class)
            || FlowChannelSpecificMessageImpl.class.equals(Float.class)
            || FlowChannelSpecificMessageImpl.class.equals(Double.class)
            || FlowChannelSpecificMessageImpl.class.equals(Boolean.class)
            || FlowChannelSpecificMessageImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((FlowChannelSpecificMessageImpl.class.equals(Integer.class)
                        || FlowChannelSpecificMessageImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((FlowChannelSpecificMessageImpl.class.equals(Float.class)
                        || FlowChannelSpecificMessageImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (FlowChannelSpecificMessageImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (FlowChannelSpecificMessageImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(FlowChannelSpecificMessageImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'FlowChannelSpecificMessageImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'FlowChannelSpecificMessageImpl'", e);
      }

      if (match == 1) {
        ChannelSpecificMessageMessageInternalImpl ret =
            new ChannelSpecificMessageMessageInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for ChannelSpecificMessageMessageInternalImpl: %d classes"
                  + " match result, expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public ChannelSpecificMessageMessageInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(
          ctxt.getParser(), "ChannelSpecificMessageMessageInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public ChannelSpecificMessageMessageInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public ChannelSpecificMessageMessageInternalImpl(FlowChannelSpecificMessageImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("FlowChannelSpecificMessageImpl", FlowChannelSpecificMessageImpl.class);
    JSONNavigator.registerDescendants(
        ChannelSpecificMessageMessageInternalImpl.class, Collections.unmodifiableMap(schemas));
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return ChannelSpecificMessageMessageInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: FlowChannelSpecificMessageImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        FlowChannelSpecificMessageImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException("Invalid instance type. Must be FlowChannelSpecificMessageImpl");
  }

  /**
   * Get the actual instance, which can be the following: FlowChannelSpecificMessageImpl
   *
   * @return The actual instance (FlowChannelSpecificMessageImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `FlowChannelSpecificMessageImpl`. If the actual instance is not
   * `FlowChannelSpecificMessageImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `FlowChannelSpecificMessageImpl`
   * @throws ClassCastException if the instance is not `FlowChannelSpecificMessageImpl`
   */
  public FlowChannelSpecificMessageImpl getFlowChannelSpecificMessageImpl()
      throws ClassCastException {
    return (FlowChannelSpecificMessageImpl) super.getActualInstance();
  }
}
