package com.sinch.sdk.domains.sms.models.v1.deliveryreports.internal;

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
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.BatchDeliveryReportMMSImpl;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.BatchDeliveryReportSMSImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(
    using = BatchDeliveryReportOneOfImpl.BatchDeliveryReportOneOfImplDeserializer.class)
@JsonSerialize(using = BatchDeliveryReportOneOfImpl.BatchDeliveryReportOneOfImplSerializer.class)
public class BatchDeliveryReportOneOfImpl extends AbstractOpenApiSchema
    implements BatchDeliveryReportOneOf {
  private static final Logger log = Logger.getLogger(BatchDeliveryReportOneOfImpl.class.getName());

  public static final class BatchDeliveryReportOneOfImplSerializer
      extends StdSerializer<BatchDeliveryReportOneOfImpl> {
    private static final long serialVersionUID = 1L;

    public BatchDeliveryReportOneOfImplSerializer(Class<BatchDeliveryReportOneOfImpl> t) {
      super(t);
    }

    public BatchDeliveryReportOneOfImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        BatchDeliveryReportOneOfImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class BatchDeliveryReportOneOfImplDeserializer
      extends StdDeserializer<BatchDeliveryReportOneOfImpl> {

    private static final long serialVersionUID = 1L;

    public BatchDeliveryReportOneOfImplDeserializer() {
      this(BatchDeliveryReportOneOfImpl.class);
    }

    public BatchDeliveryReportOneOfImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public BatchDeliveryReportOneOfImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      BatchDeliveryReportOneOfImpl newBatchDeliveryReportOneOfImpl =
          new BatchDeliveryReportOneOfImpl();
      Map<String, Object> result2 =
          tree.traverse(jp.getCodec()).readValueAs(new TypeReference<Map<String, Object>>() {});
      String discriminatorValue = (String) result2.get("type");
      switch (discriminatorValue) {
        case "delivery_report_mms":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(BatchDeliveryReportMMSImpl.class);
          newBatchDeliveryReportOneOfImpl.setActualInstance(deserialized);
          return newBatchDeliveryReportOneOfImpl;
        case "delivery_report_sms":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(BatchDeliveryReportSMSImpl.class);
          newBatchDeliveryReportOneOfImpl.setActualInstance(deserialized);
          return newBatchDeliveryReportOneOfImpl;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for BatchDeliveryReportOneOfImpl."
                      + " Possible values: delivery_report_mms delivery_report_sms",
                  discriminatorValue));
      }

      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize BatchDeliveryReportMMSImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (BatchDeliveryReportMMSImpl.class.equals(Integer.class)
            || BatchDeliveryReportMMSImpl.class.equals(Long.class)
            || BatchDeliveryReportMMSImpl.class.equals(Float.class)
            || BatchDeliveryReportMMSImpl.class.equals(Double.class)
            || BatchDeliveryReportMMSImpl.class.equals(Boolean.class)
            || BatchDeliveryReportMMSImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((BatchDeliveryReportMMSImpl.class.equals(Integer.class)
                        || BatchDeliveryReportMMSImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((BatchDeliveryReportMMSImpl.class.equals(Float.class)
                        || BatchDeliveryReportMMSImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (BatchDeliveryReportMMSImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (BatchDeliveryReportMMSImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(BatchDeliveryReportMMSImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'BatchDeliveryReportMMSImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'BatchDeliveryReportMMSImpl'", e);
      }

      // deserialize BatchDeliveryReportSMSImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (BatchDeliveryReportSMSImpl.class.equals(Integer.class)
            || BatchDeliveryReportSMSImpl.class.equals(Long.class)
            || BatchDeliveryReportSMSImpl.class.equals(Float.class)
            || BatchDeliveryReportSMSImpl.class.equals(Double.class)
            || BatchDeliveryReportSMSImpl.class.equals(Boolean.class)
            || BatchDeliveryReportSMSImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((BatchDeliveryReportSMSImpl.class.equals(Integer.class)
                        || BatchDeliveryReportSMSImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((BatchDeliveryReportSMSImpl.class.equals(Float.class)
                        || BatchDeliveryReportSMSImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (BatchDeliveryReportSMSImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (BatchDeliveryReportSMSImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(BatchDeliveryReportSMSImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'BatchDeliveryReportSMSImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'BatchDeliveryReportSMSImpl'", e);
      }

      if (match == 1) {
        BatchDeliveryReportOneOfImpl ret = new BatchDeliveryReportOneOfImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for BatchDeliveryReportOneOfImpl: %d classes match result,"
                  + " expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public BatchDeliveryReportOneOfImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(
          ctxt.getParser(), "BatchDeliveryReportOneOfImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public BatchDeliveryReportOneOfImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public BatchDeliveryReportOneOfImpl(BatchDeliveryReportMMSImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public BatchDeliveryReportOneOfImpl(BatchDeliveryReportSMSImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("BatchDeliveryReportMMSImpl", BatchDeliveryReportMMSImpl.class);
    schemas.put("BatchDeliveryReportSMSImpl", BatchDeliveryReportSMSImpl.class);
    JSONNavigator.registerDescendants(
        BatchDeliveryReportOneOfImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("delivery_report_mms", BatchDeliveryReportMMSImpl.class);
    mappings.put("delivery_report_sms", BatchDeliveryReportSMSImpl.class);
    mappings.put("BatchDeliveryReportOneOf", BatchDeliveryReportOneOfImpl.class);
    JSONNavigator.registerDiscriminator(BatchDeliveryReportOneOfImpl.class, "type", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return BatchDeliveryReportOneOfImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: BatchDeliveryReportMMSImpl, BatchDeliveryReportSMSImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        BatchDeliveryReportMMSImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        BatchDeliveryReportSMSImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be BatchDeliveryReportMMSImpl, BatchDeliveryReportSMSImpl");
  }

  /**
   * Get the actual instance, which can be the following: BatchDeliveryReportMMSImpl,
   * BatchDeliveryReportSMSImpl
   *
   * @return The actual instance (BatchDeliveryReportMMSImpl, BatchDeliveryReportSMSImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `BatchDeliveryReportMMSImpl`. If the actual instance is not
   * `BatchDeliveryReportMMSImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `BatchDeliveryReportMMSImpl`
   * @throws ClassCastException if the instance is not `BatchDeliveryReportMMSImpl`
   */
  public BatchDeliveryReportMMSImpl getBatchDeliveryReportMMSImpl() throws ClassCastException {
    return (BatchDeliveryReportMMSImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `BatchDeliveryReportSMSImpl`. If the actual instance is not
   * `BatchDeliveryReportSMSImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `BatchDeliveryReportSMSImpl`
   * @throws ClassCastException if the instance is not `BatchDeliveryReportSMSImpl`
   */
  public BatchDeliveryReportSMSImpl getBatchDeliveryReportSMSImpl() throws ClassCastException {
    return (BatchDeliveryReportSMSImpl) super.getActualInstance();
  }

  public static class Deserializer
      extends StdDeserializer<
          com.sinch.sdk.domains.sms.models.v1.deliveryreports.BatchDeliveryReport> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(
        Class<com.sinch.sdk.domains.sms.models.v1.deliveryreports.BatchDeliveryReport> vc) {
      super(vc);
    }

    @Override
    public com.sinch.sdk.domains.sms.models.v1.deliveryreports.BatchDeliveryReport deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException {

      Object deserialized = jp.readValueAs(BatchDeliveryReportOneOfImpl.class).getActualInstance();
      if (null == deserialized) {
        return null;
      }
      if (!(deserialized
          instanceof com.sinch.sdk.domains.sms.models.v1.deliveryreports.BatchDeliveryReport)) {
        log.log(Level.SEVERE, "Input data does not match schema ", deserialized);
        return null;
      }

      return (com.sinch.sdk.domains.sms.models.v1.deliveryreports.BatchDeliveryReport) deserialized;
    }
  }
}
