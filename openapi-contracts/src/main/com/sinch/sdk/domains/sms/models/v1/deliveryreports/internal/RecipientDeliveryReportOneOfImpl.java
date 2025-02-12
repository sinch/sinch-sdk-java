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
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.RecipientDeliveryReportMMSImpl;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.RecipientDeliveryReportSMSImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(
    using = RecipientDeliveryReportOneOfImpl.RecipientDeliveryReportOneOfImplDeserializer.class)
@JsonSerialize(
    using = RecipientDeliveryReportOneOfImpl.RecipientDeliveryReportOneOfImplSerializer.class)
public class RecipientDeliveryReportOneOfImpl extends AbstractOpenApiSchema
    implements RecipientDeliveryReportOneOf {
  private static final Logger log =
      Logger.getLogger(RecipientDeliveryReportOneOfImpl.class.getName());

  public static final class RecipientDeliveryReportOneOfImplSerializer
      extends StdSerializer<RecipientDeliveryReportOneOfImpl> {
    private static final long serialVersionUID = 1L;

    public RecipientDeliveryReportOneOfImplSerializer(Class<RecipientDeliveryReportOneOfImpl> t) {
      super(t);
    }

    public RecipientDeliveryReportOneOfImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        RecipientDeliveryReportOneOfImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class RecipientDeliveryReportOneOfImplDeserializer
      extends StdDeserializer<RecipientDeliveryReportOneOfImpl> {

    private static final long serialVersionUID = 1L;

    public RecipientDeliveryReportOneOfImplDeserializer() {
      this(RecipientDeliveryReportOneOfImpl.class);
    }

    public RecipientDeliveryReportOneOfImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public RecipientDeliveryReportOneOfImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      RecipientDeliveryReportOneOfImpl newRecipientDeliveryReportOneOfImpl =
          new RecipientDeliveryReportOneOfImpl();
      Map<String, Object> result2 =
          tree.traverse(jp.getCodec()).readValueAs(new TypeReference<Map<String, Object>>() {});
      String discriminatorValue = (String) result2.get("type");
      switch (discriminatorValue) {
        case "recipient_delivery_report_mms":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(RecipientDeliveryReportMMSImpl.class);
          newRecipientDeliveryReportOneOfImpl.setActualInstance(deserialized);
          return newRecipientDeliveryReportOneOfImpl;
        case "recipient_delivery_report_sms":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(RecipientDeliveryReportSMSImpl.class);
          newRecipientDeliveryReportOneOfImpl.setActualInstance(deserialized);
          return newRecipientDeliveryReportOneOfImpl;
        case "RecipientDeliveryReportMMS":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(RecipientDeliveryReportMMSImpl.class);
          newRecipientDeliveryReportOneOfImpl.setActualInstance(deserialized);
          return newRecipientDeliveryReportOneOfImpl;
        case "RecipientDeliveryReportSMS":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(RecipientDeliveryReportSMSImpl.class);
          newRecipientDeliveryReportOneOfImpl.setActualInstance(deserialized);
          return newRecipientDeliveryReportOneOfImpl;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for RecipientDeliveryReportOneOfImpl."
                      + " Possible values: recipient_delivery_report_mms"
                      + " recipient_delivery_report_sms RecipientDeliveryReportMMS"
                      + " RecipientDeliveryReportSMS",
                  discriminatorValue));
      }

      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize RecipientDeliveryReportMMSImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (RecipientDeliveryReportMMSImpl.class.equals(Integer.class)
            || RecipientDeliveryReportMMSImpl.class.equals(Long.class)
            || RecipientDeliveryReportMMSImpl.class.equals(Float.class)
            || RecipientDeliveryReportMMSImpl.class.equals(Double.class)
            || RecipientDeliveryReportMMSImpl.class.equals(Boolean.class)
            || RecipientDeliveryReportMMSImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((RecipientDeliveryReportMMSImpl.class.equals(Integer.class)
                        || RecipientDeliveryReportMMSImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((RecipientDeliveryReportMMSImpl.class.equals(Float.class)
                        || RecipientDeliveryReportMMSImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (RecipientDeliveryReportMMSImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (RecipientDeliveryReportMMSImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(RecipientDeliveryReportMMSImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'RecipientDeliveryReportMMSImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'RecipientDeliveryReportMMSImpl'", e);
      }

      // deserialize RecipientDeliveryReportSMSImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (RecipientDeliveryReportSMSImpl.class.equals(Integer.class)
            || RecipientDeliveryReportSMSImpl.class.equals(Long.class)
            || RecipientDeliveryReportSMSImpl.class.equals(Float.class)
            || RecipientDeliveryReportSMSImpl.class.equals(Double.class)
            || RecipientDeliveryReportSMSImpl.class.equals(Boolean.class)
            || RecipientDeliveryReportSMSImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((RecipientDeliveryReportSMSImpl.class.equals(Integer.class)
                        || RecipientDeliveryReportSMSImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((RecipientDeliveryReportSMSImpl.class.equals(Float.class)
                        || RecipientDeliveryReportSMSImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (RecipientDeliveryReportSMSImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (RecipientDeliveryReportSMSImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(RecipientDeliveryReportSMSImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'RecipientDeliveryReportSMSImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'RecipientDeliveryReportSMSImpl'", e);
      }

      if (match == 1) {
        RecipientDeliveryReportOneOfImpl ret = new RecipientDeliveryReportOneOfImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for RecipientDeliveryReportOneOfImpl: %d classes match"
                  + " result, expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public RecipientDeliveryReportOneOfImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(
          ctxt.getParser(), "RecipientDeliveryReportOneOfImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public RecipientDeliveryReportOneOfImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public RecipientDeliveryReportOneOfImpl(RecipientDeliveryReportMMSImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public RecipientDeliveryReportOneOfImpl(RecipientDeliveryReportSMSImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("RecipientDeliveryReportMMSImpl", RecipientDeliveryReportMMSImpl.class);
    schemas.put("RecipientDeliveryReportSMSImpl", RecipientDeliveryReportSMSImpl.class);
    JSONNavigator.registerDescendants(
        RecipientDeliveryReportOneOfImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("recipient_delivery_report_mms", RecipientDeliveryReportMMSImpl.class);
    mappings.put("recipient_delivery_report_sms", RecipientDeliveryReportSMSImpl.class);
    mappings.put("RecipientDeliveryReportMMS", RecipientDeliveryReportMMSImpl.class);
    mappings.put("RecipientDeliveryReportSMS", RecipientDeliveryReportSMSImpl.class);
    mappings.put("RecipientDeliveryReportOneOf", RecipientDeliveryReportOneOfImpl.class);
    JSONNavigator.registerDiscriminator(RecipientDeliveryReportOneOfImpl.class, "type", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return RecipientDeliveryReportOneOfImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: RecipientDeliveryReportMMSImpl, RecipientDeliveryReportSMSImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        RecipientDeliveryReportMMSImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        RecipientDeliveryReportSMSImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be RecipientDeliveryReportMMSImpl,"
            + " RecipientDeliveryReportSMSImpl");
  }

  /**
   * Get the actual instance, which can be the following: RecipientDeliveryReportMMSImpl,
   * RecipientDeliveryReportSMSImpl
   *
   * @return The actual instance (RecipientDeliveryReportMMSImpl, RecipientDeliveryReportSMSImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `RecipientDeliveryReportMMSImpl`. If the actual instance is not
   * `RecipientDeliveryReportMMSImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `RecipientDeliveryReportMMSImpl`
   * @throws ClassCastException if the instance is not `RecipientDeliveryReportMMSImpl`
   */
  public RecipientDeliveryReportMMSImpl getRecipientDeliveryReportMMSImpl()
      throws ClassCastException {
    return (RecipientDeliveryReportMMSImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `RecipientDeliveryReportSMSImpl`. If the actual instance is not
   * `RecipientDeliveryReportSMSImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `RecipientDeliveryReportSMSImpl`
   * @throws ClassCastException if the instance is not `RecipientDeliveryReportSMSImpl`
   */
  public RecipientDeliveryReportSMSImpl getRecipientDeliveryReportSMSImpl()
      throws ClassCastException {
    return (RecipientDeliveryReportSMSImpl) super.getActualInstance();
  }

  public static class Deserializer
      extends StdDeserializer<
          com.sinch.sdk.domains.sms.models.v1.deliveryreports.RecipientDeliveryReport> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(
        Class<com.sinch.sdk.domains.sms.models.v1.deliveryreports.RecipientDeliveryReport> vc) {
      super(vc);
    }

    @Override
    public com.sinch.sdk.domains.sms.models.v1.deliveryreports.RecipientDeliveryReport deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException {

      Object deserialized =
          jp.readValueAs(RecipientDeliveryReportOneOfImpl.class).getActualInstance();
      if (null == deserialized) {
        return null;
      }
      if (!(deserialized
          instanceof com.sinch.sdk.domains.sms.models.v1.deliveryreports.RecipientDeliveryReport)) {
        log.log(Level.SEVERE, "Input data does not match schema ", deserialized);
        return null;
      }

      return (com.sinch.sdk.domains.sms.models.v1.deliveryreports.RecipientDeliveryReport)
          deserialized;
    }
  }
}
