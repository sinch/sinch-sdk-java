package com.sinch.sdk.domains.conversation.models.v1.messages.internal;

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
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows.WhatsAppInteractiveHeaderDocumentImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows.WhatsAppInteractiveHeaderImageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows.WhatsAppInteractiveHeaderTextImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows.WhatsAppInteractiveHeaderVideoImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(
    using =
        FlowChannelSpecificMessageHeaderInternalImpl
            .FlowChannelSpecificMessageHeaderInternalImplDeserializer.class)
@JsonSerialize(
    using =
        FlowChannelSpecificMessageHeaderInternalImpl
            .FlowChannelSpecificMessageHeaderInternalImplSerializer.class)
public class FlowChannelSpecificMessageHeaderInternalImpl extends AbstractOpenApiSchema
    implements FlowChannelSpecificMessageHeaderInternal {
  private static final Logger log =
      Logger.getLogger(FlowChannelSpecificMessageHeaderInternalImpl.class.getName());

  public static final class FlowChannelSpecificMessageHeaderInternalImplSerializer
      extends StdSerializer<FlowChannelSpecificMessageHeaderInternalImpl> {
    private static final long serialVersionUID = 1L;

    public FlowChannelSpecificMessageHeaderInternalImplSerializer(
        Class<FlowChannelSpecificMessageHeaderInternalImpl> t) {
      super(t);
    }

    public FlowChannelSpecificMessageHeaderInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        FlowChannelSpecificMessageHeaderInternalImpl value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class FlowChannelSpecificMessageHeaderInternalImplDeserializer
      extends StdDeserializer<FlowChannelSpecificMessageHeaderInternalImpl> {

    private static final long serialVersionUID = 1L;

    public FlowChannelSpecificMessageHeaderInternalImplDeserializer() {
      this(FlowChannelSpecificMessageHeaderInternalImpl.class);
    }

    public FlowChannelSpecificMessageHeaderInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public FlowChannelSpecificMessageHeaderInternalImpl deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      FlowChannelSpecificMessageHeaderInternalImpl newFlowChannelSpecificMessageHeaderInternalImpl =
          new FlowChannelSpecificMessageHeaderInternalImpl();
      Map<String, Object> result2 =
          tree.traverse(jp.getCodec()).readValueAs(new TypeReference<Map<String, Object>>() {});
      String discriminatorValue = (String) result2.get("type");
      switch (discriminatorValue) {
        case "document":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(WhatsAppInteractiveHeaderDocumentImpl.class);
          newFlowChannelSpecificMessageHeaderInternalImpl.setActualInstance(deserialized);
          return newFlowChannelSpecificMessageHeaderInternalImpl;
        case "image":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(WhatsAppInteractiveHeaderImageImpl.class);
          newFlowChannelSpecificMessageHeaderInternalImpl.setActualInstance(deserialized);
          return newFlowChannelSpecificMessageHeaderInternalImpl;
        case "text":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(WhatsAppInteractiveHeaderTextImpl.class);
          newFlowChannelSpecificMessageHeaderInternalImpl.setActualInstance(deserialized);
          return newFlowChannelSpecificMessageHeaderInternalImpl;
        case "video":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(WhatsAppInteractiveHeaderVideoImpl.class);
          newFlowChannelSpecificMessageHeaderInternalImpl.setActualInstance(deserialized);
          return newFlowChannelSpecificMessageHeaderInternalImpl;
        case "WhatsAppInteractiveDocumentHeader":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(WhatsAppInteractiveHeaderDocumentImpl.class);
          newFlowChannelSpecificMessageHeaderInternalImpl.setActualInstance(deserialized);
          return newFlowChannelSpecificMessageHeaderInternalImpl;
        case "WhatsAppInteractiveImageHeader":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(WhatsAppInteractiveHeaderImageImpl.class);
          newFlowChannelSpecificMessageHeaderInternalImpl.setActualInstance(deserialized);
          return newFlowChannelSpecificMessageHeaderInternalImpl;
        case "WhatsAppInteractiveTextHeader":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(WhatsAppInteractiveHeaderTextImpl.class);
          newFlowChannelSpecificMessageHeaderInternalImpl.setActualInstance(deserialized);
          return newFlowChannelSpecificMessageHeaderInternalImpl;
        case "WhatsAppInteractiveVideoHeader":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(WhatsAppInteractiveHeaderVideoImpl.class);
          newFlowChannelSpecificMessageHeaderInternalImpl.setActualInstance(deserialized);
          return newFlowChannelSpecificMessageHeaderInternalImpl;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for"
                      + " FlowChannelSpecificMessageHeaderInternalImpl. Possible values: document"
                      + " image text video WhatsAppInteractiveDocumentHeader"
                      + " WhatsAppInteractiveImageHeader WhatsAppInteractiveTextHeader"
                      + " WhatsAppInteractiveVideoHeader",
                  discriminatorValue));
      }

      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize WhatsAppInteractiveHeaderDocumentImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (WhatsAppInteractiveHeaderDocumentImpl.class.equals(Integer.class)
            || WhatsAppInteractiveHeaderDocumentImpl.class.equals(Long.class)
            || WhatsAppInteractiveHeaderDocumentImpl.class.equals(Float.class)
            || WhatsAppInteractiveHeaderDocumentImpl.class.equals(Double.class)
            || WhatsAppInteractiveHeaderDocumentImpl.class.equals(Boolean.class)
            || WhatsAppInteractiveHeaderDocumentImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((WhatsAppInteractiveHeaderDocumentImpl.class.equals(Integer.class)
                        || WhatsAppInteractiveHeaderDocumentImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((WhatsAppInteractiveHeaderDocumentImpl.class.equals(Float.class)
                        || WhatsAppInteractiveHeaderDocumentImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (WhatsAppInteractiveHeaderDocumentImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (WhatsAppInteractiveHeaderDocumentImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(WhatsAppInteractiveHeaderDocumentImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'WhatsAppInteractiveHeaderDocumentImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'WhatsAppInteractiveHeaderDocumentImpl'",
            e);
      }

      // deserialize WhatsAppInteractiveHeaderImageImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (WhatsAppInteractiveHeaderImageImpl.class.equals(Integer.class)
            || WhatsAppInteractiveHeaderImageImpl.class.equals(Long.class)
            || WhatsAppInteractiveHeaderImageImpl.class.equals(Float.class)
            || WhatsAppInteractiveHeaderImageImpl.class.equals(Double.class)
            || WhatsAppInteractiveHeaderImageImpl.class.equals(Boolean.class)
            || WhatsAppInteractiveHeaderImageImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((WhatsAppInteractiveHeaderImageImpl.class.equals(Integer.class)
                        || WhatsAppInteractiveHeaderImageImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((WhatsAppInteractiveHeaderImageImpl.class.equals(Float.class)
                        || WhatsAppInteractiveHeaderImageImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (WhatsAppInteractiveHeaderImageImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (WhatsAppInteractiveHeaderImageImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(WhatsAppInteractiveHeaderImageImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'WhatsAppInteractiveHeaderImageImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'WhatsAppInteractiveHeaderImageImpl'",
            e);
      }

      // deserialize WhatsAppInteractiveHeaderTextImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (WhatsAppInteractiveHeaderTextImpl.class.equals(Integer.class)
            || WhatsAppInteractiveHeaderTextImpl.class.equals(Long.class)
            || WhatsAppInteractiveHeaderTextImpl.class.equals(Float.class)
            || WhatsAppInteractiveHeaderTextImpl.class.equals(Double.class)
            || WhatsAppInteractiveHeaderTextImpl.class.equals(Boolean.class)
            || WhatsAppInteractiveHeaderTextImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((WhatsAppInteractiveHeaderTextImpl.class.equals(Integer.class)
                        || WhatsAppInteractiveHeaderTextImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((WhatsAppInteractiveHeaderTextImpl.class.equals(Float.class)
                        || WhatsAppInteractiveHeaderTextImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (WhatsAppInteractiveHeaderTextImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (WhatsAppInteractiveHeaderTextImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(WhatsAppInteractiveHeaderTextImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'WhatsAppInteractiveHeaderTextImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'WhatsAppInteractiveHeaderTextImpl'", e);
      }

      // deserialize WhatsAppInteractiveHeaderVideoImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (WhatsAppInteractiveHeaderVideoImpl.class.equals(Integer.class)
            || WhatsAppInteractiveHeaderVideoImpl.class.equals(Long.class)
            || WhatsAppInteractiveHeaderVideoImpl.class.equals(Float.class)
            || WhatsAppInteractiveHeaderVideoImpl.class.equals(Double.class)
            || WhatsAppInteractiveHeaderVideoImpl.class.equals(Boolean.class)
            || WhatsAppInteractiveHeaderVideoImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((WhatsAppInteractiveHeaderVideoImpl.class.equals(Integer.class)
                        || WhatsAppInteractiveHeaderVideoImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((WhatsAppInteractiveHeaderVideoImpl.class.equals(Float.class)
                        || WhatsAppInteractiveHeaderVideoImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (WhatsAppInteractiveHeaderVideoImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (WhatsAppInteractiveHeaderVideoImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(WhatsAppInteractiveHeaderVideoImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'WhatsAppInteractiveHeaderVideoImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'WhatsAppInteractiveHeaderVideoImpl'",
            e);
      }

      if (match == 1) {
        FlowChannelSpecificMessageHeaderInternalImpl ret =
            new FlowChannelSpecificMessageHeaderInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for FlowChannelSpecificMessageHeaderInternalImpl: %d classes"
                  + " match result, expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public FlowChannelSpecificMessageHeaderInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(
          ctxt.getParser(), "FlowChannelSpecificMessageHeaderInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public FlowChannelSpecificMessageHeaderInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public FlowChannelSpecificMessageHeaderInternalImpl(WhatsAppInteractiveHeaderDocumentImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public FlowChannelSpecificMessageHeaderInternalImpl(WhatsAppInteractiveHeaderImageImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public FlowChannelSpecificMessageHeaderInternalImpl(WhatsAppInteractiveHeaderTextImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public FlowChannelSpecificMessageHeaderInternalImpl(WhatsAppInteractiveHeaderVideoImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put(
        "WhatsAppInteractiveHeaderDocumentImpl", WhatsAppInteractiveHeaderDocumentImpl.class);
    schemas.put("WhatsAppInteractiveHeaderImageImpl", WhatsAppInteractiveHeaderImageImpl.class);
    schemas.put("WhatsAppInteractiveHeaderTextImpl", WhatsAppInteractiveHeaderTextImpl.class);
    schemas.put("WhatsAppInteractiveHeaderVideoImpl", WhatsAppInteractiveHeaderVideoImpl.class);
    JSONNavigator.registerDescendants(
        FlowChannelSpecificMessageHeaderInternalImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("document", WhatsAppInteractiveHeaderDocumentImpl.class);
    mappings.put("image", WhatsAppInteractiveHeaderImageImpl.class);
    mappings.put("text", WhatsAppInteractiveHeaderTextImpl.class);
    mappings.put("video", WhatsAppInteractiveHeaderVideoImpl.class);
    mappings.put("WhatsAppInteractiveDocumentHeader", WhatsAppInteractiveHeaderDocumentImpl.class);
    mappings.put("WhatsAppInteractiveImageHeader", WhatsAppInteractiveHeaderImageImpl.class);
    mappings.put("WhatsAppInteractiveTextHeader", WhatsAppInteractiveHeaderTextImpl.class);
    mappings.put("WhatsAppInteractiveVideoHeader", WhatsAppInteractiveHeaderVideoImpl.class);
    mappings.put(
        "FlowChannelSpecificMessage_header", FlowChannelSpecificMessageHeaderInternalImpl.class);
    JSONNavigator.registerDiscriminator(
        FlowChannelSpecificMessageHeaderInternalImpl.class, "type", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return FlowChannelSpecificMessageHeaderInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: WhatsAppInteractiveHeaderDocumentImpl,
   * WhatsAppInteractiveHeaderImageImpl, WhatsAppInteractiveHeaderTextImpl,
   * WhatsAppInteractiveHeaderVideoImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        WhatsAppInteractiveHeaderDocumentImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        WhatsAppInteractiveHeaderImageImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        WhatsAppInteractiveHeaderTextImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        WhatsAppInteractiveHeaderVideoImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be WhatsAppInteractiveHeaderDocumentImpl,"
            + " WhatsAppInteractiveHeaderImageImpl, WhatsAppInteractiveHeaderTextImpl,"
            + " WhatsAppInteractiveHeaderVideoImpl");
  }

  /**
   * Get the actual instance, which can be the following: WhatsAppInteractiveHeaderDocumentImpl,
   * WhatsAppInteractiveHeaderImageImpl, WhatsAppInteractiveHeaderTextImpl,
   * WhatsAppInteractiveHeaderVideoImpl
   *
   * @return The actual instance (WhatsAppInteractiveHeaderDocumentImpl,
   *     WhatsAppInteractiveHeaderImageImpl, WhatsAppInteractiveHeaderTextImpl,
   *     WhatsAppInteractiveHeaderVideoImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `WhatsAppInteractiveHeaderDocumentImpl`. If the actual instance is
   * not `WhatsAppInteractiveHeaderDocumentImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `WhatsAppInteractiveHeaderDocumentImpl`
   * @throws ClassCastException if the instance is not `WhatsAppInteractiveHeaderDocumentImpl`
   */
  public WhatsAppInteractiveHeaderDocumentImpl getWhatsAppInteractiveHeaderDocumentImpl()
      throws ClassCastException {
    return (WhatsAppInteractiveHeaderDocumentImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `WhatsAppInteractiveHeaderImageImpl`. If the actual instance is not
   * `WhatsAppInteractiveHeaderImageImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `WhatsAppInteractiveHeaderImageImpl`
   * @throws ClassCastException if the instance is not `WhatsAppInteractiveHeaderImageImpl`
   */
  public WhatsAppInteractiveHeaderImageImpl getWhatsAppInteractiveHeaderImageImpl()
      throws ClassCastException {
    return (WhatsAppInteractiveHeaderImageImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `WhatsAppInteractiveHeaderTextImpl`. If the actual instance is not
   * `WhatsAppInteractiveHeaderTextImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `WhatsAppInteractiveHeaderTextImpl`
   * @throws ClassCastException if the instance is not `WhatsAppInteractiveHeaderTextImpl`
   */
  public WhatsAppInteractiveHeaderTextImpl getWhatsAppInteractiveHeaderTextImpl()
      throws ClassCastException {
    return (WhatsAppInteractiveHeaderTextImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `WhatsAppInteractiveHeaderVideoImpl`. If the actual instance is not
   * `WhatsAppInteractiveHeaderVideoImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `WhatsAppInteractiveHeaderVideoImpl`
   * @throws ClassCastException if the instance is not `WhatsAppInteractiveHeaderVideoImpl`
   */
  public WhatsAppInteractiveHeaderVideoImpl getWhatsAppInteractiveHeaderVideoImpl()
      throws ClassCastException {
    return (WhatsAppInteractiveHeaderVideoImpl) super.getActualInstance();
  }
}
