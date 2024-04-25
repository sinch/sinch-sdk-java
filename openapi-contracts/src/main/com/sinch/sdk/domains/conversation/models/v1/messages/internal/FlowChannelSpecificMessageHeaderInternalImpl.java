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
public class FlowChannelSpecificMessageHeaderInternalImpl extends AbstractOpenApiSchema {
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
              tree.traverse(jp.getCodec())
                  .readValueAs(WhatsAppInteractiveDocumentHeaderInternalImpl.class);
          newFlowChannelSpecificMessageHeaderInternalImpl.setActualInstance(deserialized);
          return newFlowChannelSpecificMessageHeaderInternalImpl;
        case "image":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(WhatsAppInteractiveImageHeaderInternalImpl.class);
          newFlowChannelSpecificMessageHeaderInternalImpl.setActualInstance(deserialized);
          return newFlowChannelSpecificMessageHeaderInternalImpl;
        case "text":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(WhatsAppInteractiveTextHeaderInternalImpl.class);
          newFlowChannelSpecificMessageHeaderInternalImpl.setActualInstance(deserialized);
          return newFlowChannelSpecificMessageHeaderInternalImpl;
        case "video":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(WhatsAppInteractiveVideoHeaderInternalImpl.class);
          newFlowChannelSpecificMessageHeaderInternalImpl.setActualInstance(deserialized);
          return newFlowChannelSpecificMessageHeaderInternalImpl;
        case "WhatsAppInteractiveDocumentHeader":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(WhatsAppInteractiveDocumentHeaderInternalImpl.class);
          newFlowChannelSpecificMessageHeaderInternalImpl.setActualInstance(deserialized);
          return newFlowChannelSpecificMessageHeaderInternalImpl;
        case "WhatsAppInteractiveImageHeader":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(WhatsAppInteractiveImageHeaderInternalImpl.class);
          newFlowChannelSpecificMessageHeaderInternalImpl.setActualInstance(deserialized);
          return newFlowChannelSpecificMessageHeaderInternalImpl;
        case "WhatsAppInteractiveTextHeader":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(WhatsAppInteractiveTextHeaderInternalImpl.class);
          newFlowChannelSpecificMessageHeaderInternalImpl.setActualInstance(deserialized);
          return newFlowChannelSpecificMessageHeaderInternalImpl;
        case "WhatsAppInteractiveVideoHeader":
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(WhatsAppInteractiveVideoHeaderInternalImpl.class);
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
      // deserialize WhatsAppInteractiveDocumentHeaderInternalImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (WhatsAppInteractiveDocumentHeaderInternalImpl.class.equals(Integer.class)
            || WhatsAppInteractiveDocumentHeaderInternalImpl.class.equals(Long.class)
            || WhatsAppInteractiveDocumentHeaderInternalImpl.class.equals(Float.class)
            || WhatsAppInteractiveDocumentHeaderInternalImpl.class.equals(Double.class)
            || WhatsAppInteractiveDocumentHeaderInternalImpl.class.equals(Boolean.class)
            || WhatsAppInteractiveDocumentHeaderInternalImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((WhatsAppInteractiveDocumentHeaderInternalImpl.class.equals(Integer.class)
                        || WhatsAppInteractiveDocumentHeaderInternalImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((WhatsAppInteractiveDocumentHeaderInternalImpl.class.equals(Float.class)
                        || WhatsAppInteractiveDocumentHeaderInternalImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (WhatsAppInteractiveDocumentHeaderInternalImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (WhatsAppInteractiveDocumentHeaderInternalImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(WhatsAppInteractiveDocumentHeaderInternalImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER,
              "Input data matches schema 'WhatsAppInteractiveDocumentHeaderInternalImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'WhatsAppInteractiveDocumentHeaderInternalImpl'",
            e);
      }

      // deserialize WhatsAppInteractiveImageHeaderInternalImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (WhatsAppInteractiveImageHeaderInternalImpl.class.equals(Integer.class)
            || WhatsAppInteractiveImageHeaderInternalImpl.class.equals(Long.class)
            || WhatsAppInteractiveImageHeaderInternalImpl.class.equals(Float.class)
            || WhatsAppInteractiveImageHeaderInternalImpl.class.equals(Double.class)
            || WhatsAppInteractiveImageHeaderInternalImpl.class.equals(Boolean.class)
            || WhatsAppInteractiveImageHeaderInternalImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((WhatsAppInteractiveImageHeaderInternalImpl.class.equals(Integer.class)
                        || WhatsAppInteractiveImageHeaderInternalImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((WhatsAppInteractiveImageHeaderInternalImpl.class.equals(Float.class)
                        || WhatsAppInteractiveImageHeaderInternalImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (WhatsAppInteractiveImageHeaderInternalImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (WhatsAppInteractiveImageHeaderInternalImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(WhatsAppInteractiveImageHeaderInternalImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER,
              "Input data matches schema 'WhatsAppInteractiveImageHeaderInternalImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'WhatsAppInteractiveImageHeaderInternalImpl'",
            e);
      }

      // deserialize WhatsAppInteractiveTextHeaderInternalImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (WhatsAppInteractiveTextHeaderInternalImpl.class.equals(Integer.class)
            || WhatsAppInteractiveTextHeaderInternalImpl.class.equals(Long.class)
            || WhatsAppInteractiveTextHeaderInternalImpl.class.equals(Float.class)
            || WhatsAppInteractiveTextHeaderInternalImpl.class.equals(Double.class)
            || WhatsAppInteractiveTextHeaderInternalImpl.class.equals(Boolean.class)
            || WhatsAppInteractiveTextHeaderInternalImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((WhatsAppInteractiveTextHeaderInternalImpl.class.equals(Integer.class)
                        || WhatsAppInteractiveTextHeaderInternalImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((WhatsAppInteractiveTextHeaderInternalImpl.class.equals(Float.class)
                        || WhatsAppInteractiveTextHeaderInternalImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (WhatsAppInteractiveTextHeaderInternalImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (WhatsAppInteractiveTextHeaderInternalImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(WhatsAppInteractiveTextHeaderInternalImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER, "Input data matches schema 'WhatsAppInteractiveTextHeaderInternalImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'WhatsAppInteractiveTextHeaderInternalImpl'",
            e);
      }

      // deserialize WhatsAppInteractiveVideoHeaderInternalImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (WhatsAppInteractiveVideoHeaderInternalImpl.class.equals(Integer.class)
            || WhatsAppInteractiveVideoHeaderInternalImpl.class.equals(Long.class)
            || WhatsAppInteractiveVideoHeaderInternalImpl.class.equals(Float.class)
            || WhatsAppInteractiveVideoHeaderInternalImpl.class.equals(Double.class)
            || WhatsAppInteractiveVideoHeaderInternalImpl.class.equals(Boolean.class)
            || WhatsAppInteractiveVideoHeaderInternalImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((WhatsAppInteractiveVideoHeaderInternalImpl.class.equals(Integer.class)
                        || WhatsAppInteractiveVideoHeaderInternalImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((WhatsAppInteractiveVideoHeaderInternalImpl.class.equals(Float.class)
                        || WhatsAppInteractiveVideoHeaderInternalImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (WhatsAppInteractiveVideoHeaderInternalImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (WhatsAppInteractiveVideoHeaderInternalImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec())
                  .readValueAs(WhatsAppInteractiveVideoHeaderInternalImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(
              Level.FINER,
              "Input data matches schema 'WhatsAppInteractiveVideoHeaderInternalImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER,
            "Input data does not match schema 'WhatsAppInteractiveVideoHeaderInternalImpl'",
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

  public FlowChannelSpecificMessageHeaderInternalImpl(
      WhatsAppInteractiveDocumentHeaderInternalImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public FlowChannelSpecificMessageHeaderInternalImpl(
      WhatsAppInteractiveImageHeaderInternalImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public FlowChannelSpecificMessageHeaderInternalImpl(WhatsAppInteractiveTextHeaderInternalImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public FlowChannelSpecificMessageHeaderInternalImpl(
      WhatsAppInteractiveVideoHeaderInternalImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put(
        "WhatsAppInteractiveDocumentHeaderInternalImpl",
        WhatsAppInteractiveDocumentHeaderInternalImpl.class);
    schemas.put(
        "WhatsAppInteractiveImageHeaderInternalImpl",
        WhatsAppInteractiveImageHeaderInternalImpl.class);
    schemas.put(
        "WhatsAppInteractiveTextHeaderInternalImpl",
        WhatsAppInteractiveTextHeaderInternalImpl.class);
    schemas.put(
        "WhatsAppInteractiveVideoHeaderInternalImpl",
        WhatsAppInteractiveVideoHeaderInternalImpl.class);
    JSONNavigator.registerDescendants(
        FlowChannelSpecificMessageHeaderInternalImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("document", WhatsAppInteractiveDocumentHeaderInternalImpl.class);
    mappings.put("image", WhatsAppInteractiveImageHeaderInternalImpl.class);
    mappings.put("text", WhatsAppInteractiveTextHeaderInternalImpl.class);
    mappings.put("video", WhatsAppInteractiveVideoHeaderInternalImpl.class);
    mappings.put(
        "WhatsAppInteractiveDocumentHeader", WhatsAppInteractiveDocumentHeaderInternalImpl.class);
    mappings.put(
        "WhatsAppInteractiveImageHeader", WhatsAppInteractiveImageHeaderInternalImpl.class);
    mappings.put("WhatsAppInteractiveTextHeader", WhatsAppInteractiveTextHeaderInternalImpl.class);
    mappings.put(
        "WhatsAppInteractiveVideoHeader", WhatsAppInteractiveVideoHeaderInternalImpl.class);
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
   * against the oneOf child schemas: WhatsAppInteractiveDocumentHeaderInternalImpl,
   * WhatsAppInteractiveImageHeaderInternalImpl, WhatsAppInteractiveTextHeaderInternalImpl,
   * WhatsAppInteractiveVideoHeaderInternalImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        WhatsAppInteractiveDocumentHeaderInternalImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        WhatsAppInteractiveImageHeaderInternalImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        WhatsAppInteractiveTextHeaderInternalImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        WhatsAppInteractiveVideoHeaderInternalImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be WhatsAppInteractiveDocumentHeaderInternalImpl,"
            + " WhatsAppInteractiveImageHeaderInternalImpl,"
            + " WhatsAppInteractiveTextHeaderInternalImpl,"
            + " WhatsAppInteractiveVideoHeaderInternalImpl");
  }

  /**
   * Get the actual instance, which can be the following:
   * WhatsAppInteractiveDocumentHeaderInternalImpl, WhatsAppInteractiveImageHeaderInternalImpl,
   * WhatsAppInteractiveTextHeaderInternalImpl, WhatsAppInteractiveVideoHeaderInternalImpl
   *
   * @return The actual instance (WhatsAppInteractiveDocumentHeaderInternalImpl,
   *     WhatsAppInteractiveImageHeaderInternalImpl, WhatsAppInteractiveTextHeaderInternalImpl,
   *     WhatsAppInteractiveVideoHeaderInternalImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `WhatsAppInteractiveDocumentHeaderInternalImpl`. If the actual
   * instance is not `WhatsAppInteractiveDocumentHeaderInternalImpl`, the ClassCastException will be
   * thrown.
   *
   * @return The actual instance of `WhatsAppInteractiveDocumentHeaderInternalImpl`
   * @throws ClassCastException if the instance is not
   *     `WhatsAppInteractiveDocumentHeaderInternalImpl`
   */
  public WhatsAppInteractiveDocumentHeaderInternalImpl
      getWhatsAppInteractiveDocumentHeaderInternalImpl() throws ClassCastException {
    return (WhatsAppInteractiveDocumentHeaderInternalImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `WhatsAppInteractiveImageHeaderInternalImpl`. If the actual instance
   * is not `WhatsAppInteractiveImageHeaderInternalImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `WhatsAppInteractiveImageHeaderInternalImpl`
   * @throws ClassCastException if the instance is not `WhatsAppInteractiveImageHeaderInternalImpl`
   */
  public WhatsAppInteractiveImageHeaderInternalImpl getWhatsAppInteractiveImageHeaderInternalImpl()
      throws ClassCastException {
    return (WhatsAppInteractiveImageHeaderInternalImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `WhatsAppInteractiveTextHeaderInternalImpl`. If the actual instance
   * is not `WhatsAppInteractiveTextHeaderInternalImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `WhatsAppInteractiveTextHeaderInternalImpl`
   * @throws ClassCastException if the instance is not `WhatsAppInteractiveTextHeaderInternalImpl`
   */
  public WhatsAppInteractiveTextHeaderInternalImpl getWhatsAppInteractiveTextHeaderInternalImpl()
      throws ClassCastException {
    return (WhatsAppInteractiveTextHeaderInternalImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `WhatsAppInteractiveVideoHeaderInternalImpl`. If the actual instance
   * is not `WhatsAppInteractiveVideoHeaderInternalImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `WhatsAppInteractiveVideoHeaderInternalImpl`
   * @throws ClassCastException if the instance is not `WhatsAppInteractiveVideoHeaderInternalImpl`
   */
  public WhatsAppInteractiveVideoHeaderInternalImpl getWhatsAppInteractiveVideoHeaderInternalImpl()
      throws ClassCastException {
    return (WhatsAppInteractiveVideoHeaderInternalImpl) super.getActualInstance();
  }
}
