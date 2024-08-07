package com.sinch.sdk.domains.conversation.models.v1.messages.types.internal;

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
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.nfmreply.WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(
    using =
        ChannelSpecificContactMessageMessageMessageInternalImpl
            .ChannelSpecificContactMessageMessageMessageInternalImplDeserializer.class)
@JsonSerialize(
    using =
        ChannelSpecificContactMessageMessageMessageInternalImpl
            .ChannelSpecificContactMessageMessageMessageInternalImplSerializer.class)
public class ChannelSpecificContactMessageMessageMessageInternalImpl extends AbstractOpenApiSchema
    implements ChannelSpecificContactMessageMessageMessageInternal {
  private static final Logger log =
      Logger.getLogger(ChannelSpecificContactMessageMessageMessageInternalImpl.class.getName());

  public static final class ChannelSpecificContactMessageMessageMessageInternalImplSerializer
      extends StdSerializer<ChannelSpecificContactMessageMessageMessageInternalImpl> {
    private static final long serialVersionUID = 1L;

    public ChannelSpecificContactMessageMessageMessageInternalImplSerializer(
        Class<ChannelSpecificContactMessageMessageMessageInternalImpl> t) {
      super(t);
    }

    public ChannelSpecificContactMessageMessageMessageInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        ChannelSpecificContactMessageMessageMessageInternalImpl value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class ChannelSpecificContactMessageMessageMessageInternalImplDeserializer
      extends StdDeserializer<ChannelSpecificContactMessageMessageMessageInternalImpl> {

    private static final long serialVersionUID = 1L;

    public ChannelSpecificContactMessageMessageMessageInternalImplDeserializer() {
      this(ChannelSpecificContactMessageMessageMessageInternalImpl.class);
    }

    public ChannelSpecificContactMessageMessageMessageInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public ChannelSpecificContactMessageMessageMessageInternalImpl deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl.class.equals(Integer.class)
            || WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl.class.equals(Long.class)
            || WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl.class.equals(
                Float.class)
            || WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl.class.equals(
                Double.class)
            || WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl.class.equals(
                Boolean.class)
            || WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl.class.equals(
                String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl.class.equals(
                            Integer.class)
                        || WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl.class
                            .equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl.class.equals(
                            Float.class)
                        || WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl.class
                            .equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl.class.equals(
                        Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl.class.equals(
                        String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER,
              "Input data matches schema"
                  + " 'WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema"
                + " 'WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl'",
            e);
      }

      if (match == 1) {
        ChannelSpecificContactMessageMessageMessageInternalImpl ret =
            new ChannelSpecificContactMessageMessageMessageInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for ChannelSpecificContactMessageMessageMessageInternalImpl:"
                  + " %d classes match result, expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public ChannelSpecificContactMessageMessageMessageInternalImpl getNullValue(
        DeserializationContext ctxt) throws JsonMappingException {
      throw new JsonMappingException(
          ctxt.getParser(),
          "ChannelSpecificContactMessageMessageMessageInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public ChannelSpecificContactMessageMessageMessageInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public ChannelSpecificContactMessageMessageMessageInternalImpl(
      WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put(
        "WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl",
        WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl.class);
    JSONNavigator.registerDescendants(
        ChannelSpecificContactMessageMessageMessageInternalImpl.class,
        Collections.unmodifiableMap(schemas));
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return ChannelSpecificContactMessageMessageMessageInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl.class,
        instance,
        new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be"
            + " WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl");
  }

  /**
   * Get the actual instance, which can be the following:
   * WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl
   *
   * @return The actual instance (WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl`. If
   * the actual instance is not `WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl`, the
   * ClassCastException will be thrown.
   *
   * @return The actual instance of `WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl`
   * @throws ClassCastException if the instance is not
   *     `WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl`
   */
  public WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl
      getWhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl() throws ClassCastException {
    return (WhatsAppInteractiveNfmReplyChannelSpecificContactMessageImpl) super.getActualInstance();
  }
}
