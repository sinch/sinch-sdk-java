package com.sinch.sdk.domains.sms.models.v1.batches.response.internal;

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
import com.sinch.sdk.domains.sms.models.v1.batches.response.BinaryResponseImpl;
import com.sinch.sdk.domains.sms.models.v1.batches.response.MediaResponseImpl;
import com.sinch.sdk.domains.sms.models.v1.batches.response.TextResponseImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(using = BatchResponseInternalImpl.BatchResponseInternalImplDeserializer.class)
@JsonSerialize(using = BatchResponseInternalImpl.BatchResponseInternalImplSerializer.class)
public class BatchResponseInternalImpl extends AbstractOpenApiSchema
    implements BatchResponseInternal {
  private static final Logger log = Logger.getLogger(BatchResponseInternalImpl.class.getName());

  public static final class BatchResponseInternalImplSerializer
      extends StdSerializer<BatchResponseInternalImpl> {
    private static final long serialVersionUID = 1L;

    public BatchResponseInternalImplSerializer(Class<BatchResponseInternalImpl> t) {
      super(t);
    }

    public BatchResponseInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        BatchResponseInternalImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class BatchResponseInternalImplDeserializer
      extends StdDeserializer<BatchResponseInternalImpl> {

    private static final long serialVersionUID = 1L;

    public BatchResponseInternalImplDeserializer() {
      this(BatchResponseInternalImpl.class);
    }

    public BatchResponseInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public BatchResponseInternalImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      BatchResponseInternalImpl newBatchResponseInternalImpl = new BatchResponseInternalImpl();
      Map<String, Object> result2 =
          tree.traverse(jp.getCodec()).readValueAs(new TypeReference<Map<String, Object>>() {});
      String discriminatorValue = (String) result2.get("type");
      switch (discriminatorValue) {
        case "mt_binary":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(BinaryResponseImpl.class);
          newBatchResponseInternalImpl.setActualInstance(deserialized);
          return newBatchResponseInternalImpl;
        case "mt_media":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(MediaResponseImpl.class);
          newBatchResponseInternalImpl.setActualInstance(deserialized);
          return newBatchResponseInternalImpl;
        case "mt_text":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(TextResponseImpl.class);
          newBatchResponseInternalImpl.setActualInstance(deserialized);
          return newBatchResponseInternalImpl;
        case "BinaryResponse":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(BinaryResponseImpl.class);
          newBatchResponseInternalImpl.setActualInstance(deserialized);
          return newBatchResponseInternalImpl;
        case "MediaResponse":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(MediaResponseImpl.class);
          newBatchResponseInternalImpl.setActualInstance(deserialized);
          return newBatchResponseInternalImpl;
        case "TextResponse":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(TextResponseImpl.class);
          newBatchResponseInternalImpl.setActualInstance(deserialized);
          return newBatchResponseInternalImpl;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for BatchResponseInternalImpl."
                      + " Possible values: mt_binary mt_media mt_text BinaryResponse MediaResponse"
                      + " TextResponse",
                  discriminatorValue));
      }

      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize BinaryResponseImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (BinaryResponseImpl.class.equals(Integer.class)
            || BinaryResponseImpl.class.equals(Long.class)
            || BinaryResponseImpl.class.equals(Float.class)
            || BinaryResponseImpl.class.equals(Double.class)
            || BinaryResponseImpl.class.equals(Boolean.class)
            || BinaryResponseImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((BinaryResponseImpl.class.equals(Integer.class)
                        || BinaryResponseImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((BinaryResponseImpl.class.equals(Float.class)
                        || BinaryResponseImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (BinaryResponseImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (BinaryResponseImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(BinaryResponseImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'BinaryResponseImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'BinaryResponseImpl'", e);
      }

      // deserialize MediaResponseImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (MediaResponseImpl.class.equals(Integer.class)
            || MediaResponseImpl.class.equals(Long.class)
            || MediaResponseImpl.class.equals(Float.class)
            || MediaResponseImpl.class.equals(Double.class)
            || MediaResponseImpl.class.equals(Boolean.class)
            || MediaResponseImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((MediaResponseImpl.class.equals(Integer.class)
                        || MediaResponseImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((MediaResponseImpl.class.equals(Float.class)
                        || MediaResponseImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (MediaResponseImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (MediaResponseImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(MediaResponseImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'MediaResponseImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'MediaResponseImpl'", e);
      }

      // deserialize TextResponseImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (TextResponseImpl.class.equals(Integer.class)
            || TextResponseImpl.class.equals(Long.class)
            || TextResponseImpl.class.equals(Float.class)
            || TextResponseImpl.class.equals(Double.class)
            || TextResponseImpl.class.equals(Boolean.class)
            || TextResponseImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((TextResponseImpl.class.equals(Integer.class)
                        || TextResponseImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((TextResponseImpl.class.equals(Float.class)
                        || TextResponseImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (TextResponseImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (TextResponseImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(TextResponseImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'TextResponseImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'TextResponseImpl'", e);
      }

      if (match == 1) {
        BatchResponseInternalImpl ret = new BatchResponseInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for BatchResponseInternalImpl: %d classes match result,"
                  + " expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public BatchResponseInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "BatchResponseInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public BatchResponseInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public BatchResponseInternalImpl(BinaryResponseImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public BatchResponseInternalImpl(MediaResponseImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public BatchResponseInternalImpl(TextResponseImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("BinaryResponseImpl", BinaryResponseImpl.class);
    schemas.put("MediaResponseImpl", MediaResponseImpl.class);
    schemas.put("TextResponseImpl", TextResponseImpl.class);
    JSONNavigator.registerDescendants(
        BatchResponseInternalImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("mt_binary", BinaryResponseImpl.class);
    mappings.put("mt_media", MediaResponseImpl.class);
    mappings.put("mt_text", TextResponseImpl.class);
    mappings.put("BinaryResponse", BinaryResponseImpl.class);
    mappings.put("MediaResponse", MediaResponseImpl.class);
    mappings.put("TextResponse", TextResponseImpl.class);
    mappings.put("Batch", BatchResponseInternalImpl.class);
    JSONNavigator.registerDiscriminator(BatchResponseInternalImpl.class, "type", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return BatchResponseInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: BinaryResponseImpl, MediaResponseImpl, TextResponseImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(BinaryResponseImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(MediaResponseImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(TextResponseImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be BinaryResponseImpl, MediaResponseImpl, TextResponseImpl");
  }

  /**
   * Get the actual instance, which can be the following: BinaryResponseImpl, MediaResponseImpl,
   * TextResponseImpl
   *
   * @return The actual instance (BinaryResponseImpl, MediaResponseImpl, TextResponseImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `BinaryResponseImpl`. If the actual instance is not
   * `BinaryResponseImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `BinaryResponseImpl`
   * @throws ClassCastException if the instance is not `BinaryResponseImpl`
   */
  public BinaryResponseImpl getBinaryResponseImpl() throws ClassCastException {
    return (BinaryResponseImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `MediaResponseImpl`. If the actual instance is not
   * `MediaResponseImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `MediaResponseImpl`
   * @throws ClassCastException if the instance is not `MediaResponseImpl`
   */
  public MediaResponseImpl getMediaResponseImpl() throws ClassCastException {
    return (MediaResponseImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `TextResponseImpl`. If the actual instance is not
   * `TextResponseImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `TextResponseImpl`
   * @throws ClassCastException if the instance is not `TextResponseImpl`
   */
  public TextResponseImpl getTextResponseImpl() throws ClassCastException {
    return (TextResponseImpl) super.getActualInstance();
  }

  public static class Deserializer
      extends StdDeserializer<com.sinch.sdk.domains.sms.models.v1.batches.response.BatchResponse> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(
        Class<com.sinch.sdk.domains.sms.models.v1.batches.response.BatchResponse> vc) {
      super(vc);
    }

    @Override
    public com.sinch.sdk.domains.sms.models.v1.batches.response.BatchResponse deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException {

      Object deserialized = jp.readValueAs(BatchResponseInternalImpl.class).getActualInstance();
      if (null == deserialized) {
        return null;
      }
      if (!(deserialized
          instanceof com.sinch.sdk.domains.sms.models.v1.batches.response.BatchResponse)) {
        log.log(Level.SEVERE, "Input data does not match schema ", deserialized);
        return null;
      }

      return (com.sinch.sdk.domains.sms.models.v1.batches.response.BatchResponse) deserialized;
    }
  }
}
