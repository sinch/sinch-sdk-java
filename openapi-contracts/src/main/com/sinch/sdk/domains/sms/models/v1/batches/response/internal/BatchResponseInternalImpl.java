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
import com.sinch.sdk.domains.sms.models.v1.batches.response.BatchBinaryImpl;
import com.sinch.sdk.domains.sms.models.v1.batches.response.BatchMediaImpl;
import com.sinch.sdk.domains.sms.models.v1.batches.response.BatchTextImpl;
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
          deserialized = tree.traverse(jp.getCodec()).readValueAs(BatchBinaryImpl.class);
          newBatchResponseInternalImpl.setActualInstance(deserialized);
          return newBatchResponseInternalImpl;
        case "mt_media":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(BatchMediaImpl.class);
          newBatchResponseInternalImpl.setActualInstance(deserialized);
          return newBatchResponseInternalImpl;
        case "mt_text":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(BatchTextImpl.class);
          newBatchResponseInternalImpl.setActualInstance(deserialized);
          return newBatchResponseInternalImpl;
        case "BinaryResponse":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(BatchBinaryImpl.class);
          newBatchResponseInternalImpl.setActualInstance(deserialized);
          return newBatchResponseInternalImpl;
        case "MediaResponse":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(BatchMediaImpl.class);
          newBatchResponseInternalImpl.setActualInstance(deserialized);
          return newBatchResponseInternalImpl;
        case "TextResponse":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(BatchTextImpl.class);
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
      // deserialize BatchBinaryImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (BatchBinaryImpl.class.equals(Integer.class)
            || BatchBinaryImpl.class.equals(Long.class)
            || BatchBinaryImpl.class.equals(Float.class)
            || BatchBinaryImpl.class.equals(Double.class)
            || BatchBinaryImpl.class.equals(Boolean.class)
            || BatchBinaryImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((BatchBinaryImpl.class.equals(Integer.class)
                        || BatchBinaryImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((BatchBinaryImpl.class.equals(Float.class)
                        || BatchBinaryImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (BatchBinaryImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (BatchBinaryImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(BatchBinaryImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'BatchBinaryImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'BatchBinaryImpl'", e);
      }

      // deserialize BatchMediaImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (BatchMediaImpl.class.equals(Integer.class)
            || BatchMediaImpl.class.equals(Long.class)
            || BatchMediaImpl.class.equals(Float.class)
            || BatchMediaImpl.class.equals(Double.class)
            || BatchMediaImpl.class.equals(Boolean.class)
            || BatchMediaImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((BatchMediaImpl.class.equals(Integer.class)
                        || BatchMediaImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((BatchMediaImpl.class.equals(Float.class)
                        || BatchMediaImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (BatchMediaImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (BatchMediaImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(BatchMediaImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'BatchMediaImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'BatchMediaImpl'", e);
      }

      // deserialize BatchTextImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (BatchTextImpl.class.equals(Integer.class)
            || BatchTextImpl.class.equals(Long.class)
            || BatchTextImpl.class.equals(Float.class)
            || BatchTextImpl.class.equals(Double.class)
            || BatchTextImpl.class.equals(Boolean.class)
            || BatchTextImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((BatchTextImpl.class.equals(Integer.class)
                        || BatchTextImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((BatchTextImpl.class.equals(Float.class)
                        || BatchTextImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (BatchTextImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (BatchTextImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(BatchTextImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'BatchTextImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'BatchTextImpl'", e);
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

  public BatchResponseInternalImpl(BatchBinaryImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public BatchResponseInternalImpl(BatchMediaImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public BatchResponseInternalImpl(BatchTextImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("BatchBinaryImpl", BatchBinaryImpl.class);
    schemas.put("BatchMediaImpl", BatchMediaImpl.class);
    schemas.put("BatchTextImpl", BatchTextImpl.class);
    JSONNavigator.registerDescendants(
        BatchResponseInternalImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("mt_binary", BatchBinaryImpl.class);
    mappings.put("mt_media", BatchMediaImpl.class);
    mappings.put("mt_text", BatchTextImpl.class);
    mappings.put("BinaryResponse", BatchBinaryImpl.class);
    mappings.put("MediaResponse", BatchMediaImpl.class);
    mappings.put("TextResponse", BatchTextImpl.class);
    mappings.put("Batch", BatchResponseInternalImpl.class);
    JSONNavigator.registerDiscriminator(BatchResponseInternalImpl.class, "type", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return BatchResponseInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: BatchBinaryImpl, BatchMediaImpl, BatchTextImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(BatchBinaryImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(BatchMediaImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(BatchTextImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be BatchBinaryImpl, BatchMediaImpl, BatchTextImpl");
  }

  /**
   * Get the actual instance, which can be the following: BatchBinaryImpl, BatchMediaImpl,
   * BatchTextImpl
   *
   * @return The actual instance (BatchBinaryImpl, BatchMediaImpl, BatchTextImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `BatchBinaryImpl`. If the actual instance is not `BatchBinaryImpl`,
   * the ClassCastException will be thrown.
   *
   * @return The actual instance of `BatchBinaryImpl`
   * @throws ClassCastException if the instance is not `BatchBinaryImpl`
   */
  public BatchBinaryImpl getBatchBinaryImpl() throws ClassCastException {
    return (BatchBinaryImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `BatchMediaImpl`. If the actual instance is not `BatchMediaImpl`,
   * the ClassCastException will be thrown.
   *
   * @return The actual instance of `BatchMediaImpl`
   * @throws ClassCastException if the instance is not `BatchMediaImpl`
   */
  public BatchMediaImpl getBatchMediaImpl() throws ClassCastException {
    return (BatchMediaImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `BatchTextImpl`. If the actual instance is not `BatchTextImpl`, the
   * ClassCastException will be thrown.
   *
   * @return The actual instance of `BatchTextImpl`
   * @throws ClassCastException if the instance is not `BatchTextImpl`
   */
  public BatchTextImpl getBatchTextImpl() throws ClassCastException {
    return (BatchTextImpl) super.getActualInstance();
  }

  public static class Deserializer
      extends StdDeserializer<com.sinch.sdk.domains.sms.models.v1.batches.response.Batch> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<com.sinch.sdk.domains.sms.models.v1.batches.response.Batch> vc) {
      super(vc);
    }

    @Override
    public com.sinch.sdk.domains.sms.models.v1.batches.response.Batch deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException {

      Object deserialized = jp.readValueAs(BatchResponseInternalImpl.class).getActualInstance();
      if (null == deserialized) {
        return null;
      }
      if (!(deserialized instanceof com.sinch.sdk.domains.sms.models.v1.batches.response.Batch)) {
        log.log(Level.SEVERE, "Input data does not match schema ", deserialized);
        return null;
      }

      return (com.sinch.sdk.domains.sms.models.v1.batches.response.Batch) deserialized;
    }
  }
}
