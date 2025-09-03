package com.sinch.sdk.domains.sms.models.v1.webhooks.internal;

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
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.RecipientDeliveryReportMMSImpl;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.RecipientDeliveryReportSMSImpl;
import com.sinch.sdk.domains.sms.models.v1.inbounds.BinaryMessageImpl;
import com.sinch.sdk.domains.sms.models.v1.inbounds.MediaMessageImpl;
import com.sinch.sdk.domains.sms.models.v1.inbounds.TextMessageImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(using = WebhookEventOneOfImpl.WebhookEventOneOfImplDeserializer.class)
@JsonSerialize(using = WebhookEventOneOfImpl.WebhookEventOneOfImplSerializer.class)
public class WebhookEventOneOfImpl extends AbstractOpenApiSchema implements WebhookEventOneOf {
  private static final Logger log = Logger.getLogger(WebhookEventOneOfImpl.class.getName());

  public static final class WebhookEventOneOfImplSerializer
      extends StdSerializer<WebhookEventOneOfImpl> {
    private static final long serialVersionUID = 1L;

    public WebhookEventOneOfImplSerializer(Class<WebhookEventOneOfImpl> t) {
      super(t);
    }

    public WebhookEventOneOfImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        WebhookEventOneOfImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class WebhookEventOneOfImplDeserializer
      extends StdDeserializer<WebhookEventOneOfImpl> {

    private static final long serialVersionUID = 1L;

    public WebhookEventOneOfImplDeserializer() {
      this(WebhookEventOneOfImpl.class);
    }

    public WebhookEventOneOfImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public WebhookEventOneOfImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      WebhookEventOneOfImpl newWebhookEventOneOfImpl = new WebhookEventOneOfImpl();
      Map<String, Object> result2 =
          tree.traverse(jp.getCodec()).readValueAs(new TypeReference<Map<String, Object>>() {});
      String discriminatorValue = (String) result2.get("type");
      switch (discriminatorValue) {
        case "delivery_report_mms":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(BatchDeliveryReportMMSImpl.class);
          newWebhookEventOneOfImpl.setActualInstance(deserialized);
          return newWebhookEventOneOfImpl;
        case "delivery_report_sms":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(BatchDeliveryReportSMSImpl.class);
          newWebhookEventOneOfImpl.setActualInstance(deserialized);
          return newWebhookEventOneOfImpl;
        case "mo_binary":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(BinaryMessageImpl.class);
          newWebhookEventOneOfImpl.setActualInstance(deserialized);
          return newWebhookEventOneOfImpl;
        case "mo_media":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(MediaMessageImpl.class);
          newWebhookEventOneOfImpl.setActualInstance(deserialized);
          return newWebhookEventOneOfImpl;
        case "mo_text":
          deserialized = tree.traverse(jp.getCodec()).readValueAs(TextMessageImpl.class);
          newWebhookEventOneOfImpl.setActualInstance(deserialized);
          return newWebhookEventOneOfImpl;
        case "recipient_delivery_report_mms":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(RecipientDeliveryReportMMSImpl.class);
          newWebhookEventOneOfImpl.setActualInstance(deserialized);
          return newWebhookEventOneOfImpl;
        case "recipient_delivery_report_sms":
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(RecipientDeliveryReportSMSImpl.class);
          newWebhookEventOneOfImpl.setActualInstance(deserialized);
          return newWebhookEventOneOfImpl;
        default:
          log.log(
              Level.WARNING,
              String.format(
                  "Failed to lookup discriminator value `%s` for WebhookEventOneOfImpl. Possible"
                      + " values: delivery_report_mms delivery_report_sms mo_binary mo_media"
                      + " mo_text recipient_delivery_report_mms recipient_delivery_report_sms",
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

      // deserialize BinaryMessageImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (BinaryMessageImpl.class.equals(Integer.class)
            || BinaryMessageImpl.class.equals(Long.class)
            || BinaryMessageImpl.class.equals(Float.class)
            || BinaryMessageImpl.class.equals(Double.class)
            || BinaryMessageImpl.class.equals(Boolean.class)
            || BinaryMessageImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((BinaryMessageImpl.class.equals(Integer.class)
                        || BinaryMessageImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((BinaryMessageImpl.class.equals(Float.class)
                        || BinaryMessageImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (BinaryMessageImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (BinaryMessageImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(BinaryMessageImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'BinaryMessageImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'BinaryMessageImpl'", e);
      }

      // deserialize MediaMessageImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (MediaMessageImpl.class.equals(Integer.class)
            || MediaMessageImpl.class.equals(Long.class)
            || MediaMessageImpl.class.equals(Float.class)
            || MediaMessageImpl.class.equals(Double.class)
            || MediaMessageImpl.class.equals(Boolean.class)
            || MediaMessageImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((MediaMessageImpl.class.equals(Integer.class)
                        || MediaMessageImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((MediaMessageImpl.class.equals(Float.class)
                        || MediaMessageImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (MediaMessageImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (MediaMessageImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(MediaMessageImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'MediaMessageImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'MediaMessageImpl'", e);
      }

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

      // deserialize TextMessageImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (TextMessageImpl.class.equals(Integer.class)
            || TextMessageImpl.class.equals(Long.class)
            || TextMessageImpl.class.equals(Float.class)
            || TextMessageImpl.class.equals(Double.class)
            || TextMessageImpl.class.equals(Boolean.class)
            || TextMessageImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((TextMessageImpl.class.equals(Integer.class)
                        || TextMessageImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((TextMessageImpl.class.equals(Float.class)
                        || TextMessageImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (TextMessageImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (TextMessageImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(TextMessageImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'TextMessageImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'TextMessageImpl'", e);
      }

      if (match == 1) {
        WebhookEventOneOfImpl ret = new WebhookEventOneOfImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for WebhookEventOneOfImpl: %d classes match result, expected"
                  + " 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public WebhookEventOneOfImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "WebhookEventOneOfImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public WebhookEventOneOfImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public WebhookEventOneOfImpl(BatchDeliveryReportMMSImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public WebhookEventOneOfImpl(BatchDeliveryReportSMSImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public WebhookEventOneOfImpl(BinaryMessageImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public WebhookEventOneOfImpl(MediaMessageImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public WebhookEventOneOfImpl(RecipientDeliveryReportMMSImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public WebhookEventOneOfImpl(RecipientDeliveryReportSMSImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public WebhookEventOneOfImpl(TextMessageImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("BatchDeliveryReportMMSImpl", BatchDeliveryReportMMSImpl.class);
    schemas.put("BatchDeliveryReportSMSImpl", BatchDeliveryReportSMSImpl.class);
    schemas.put("BinaryMessageImpl", BinaryMessageImpl.class);
    schemas.put("MediaMessageImpl", MediaMessageImpl.class);
    schemas.put("RecipientDeliveryReportMMSImpl", RecipientDeliveryReportMMSImpl.class);
    schemas.put("RecipientDeliveryReportSMSImpl", RecipientDeliveryReportSMSImpl.class);
    schemas.put("TextMessageImpl", TextMessageImpl.class);
    JSONNavigator.registerDescendants(
        WebhookEventOneOfImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("delivery_report_mms", BatchDeliveryReportMMSImpl.class);
    mappings.put("delivery_report_sms", BatchDeliveryReportSMSImpl.class);
    mappings.put("mo_binary", BinaryMessageImpl.class);
    mappings.put("mo_media", MediaMessageImpl.class);
    mappings.put("mo_text", TextMessageImpl.class);
    mappings.put("recipient_delivery_report_mms", RecipientDeliveryReportMMSImpl.class);
    mappings.put("recipient_delivery_report_sms", RecipientDeliveryReportSMSImpl.class);
    mappings.put("WebhookEventOneOf", WebhookEventOneOfImpl.class);
    JSONNavigator.registerDiscriminator(WebhookEventOneOfImpl.class, "type", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return WebhookEventOneOfImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: BatchDeliveryReportMMSImpl, BatchDeliveryReportSMSImpl,
   * BinaryMessageImpl, MediaMessageImpl, RecipientDeliveryReportMMSImpl,
   * RecipientDeliveryReportSMSImpl, TextMessageImpl
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

    if (JSONNavigator.isInstanceOf(BinaryMessageImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(MediaMessageImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

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

    if (JSONNavigator.isInstanceOf(TextMessageImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be BatchDeliveryReportMMSImpl, BatchDeliveryReportSMSImpl,"
            + " BinaryMessageImpl, MediaMessageImpl, RecipientDeliveryReportMMSImpl,"
            + " RecipientDeliveryReportSMSImpl, TextMessageImpl");
  }

  /**
   * Get the actual instance, which can be the following: BatchDeliveryReportMMSImpl,
   * BatchDeliveryReportSMSImpl, BinaryMessageImpl, MediaMessageImpl,
   * RecipientDeliveryReportMMSImpl, RecipientDeliveryReportSMSImpl, TextMessageImpl
   *
   * @return The actual instance (BatchDeliveryReportMMSImpl, BatchDeliveryReportSMSImpl,
   *     BinaryMessageImpl, MediaMessageImpl, RecipientDeliveryReportMMSImpl,
   *     RecipientDeliveryReportSMSImpl, TextMessageImpl)
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

  /**
   * Get the actual instance of `BinaryMessageImpl`. If the actual instance is not
   * `BinaryMessageImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `BinaryMessageImpl`
   * @throws ClassCastException if the instance is not `BinaryMessageImpl`
   */
  public BinaryMessageImpl getBinaryMessageImpl() throws ClassCastException {
    return (BinaryMessageImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `MediaMessageImpl`. If the actual instance is not
   * `MediaMessageImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `MediaMessageImpl`
   * @throws ClassCastException if the instance is not `MediaMessageImpl`
   */
  public MediaMessageImpl getMediaMessageImpl() throws ClassCastException {
    return (MediaMessageImpl) super.getActualInstance();
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

  /**
   * Get the actual instance of `TextMessageImpl`. If the actual instance is not `TextMessageImpl`,
   * the ClassCastException will be thrown.
   *
   * @return The actual instance of `TextMessageImpl`
   * @throws ClassCastException if the instance is not `TextMessageImpl`
   */
  public TextMessageImpl getTextMessageImpl() throws ClassCastException {
    return (TextMessageImpl) super.getActualInstance();
  }

  public static class Deserializer
      extends StdDeserializer<com.sinch.sdk.domains.sms.models.v1.webhooks.SmsEvent> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<com.sinch.sdk.domains.sms.models.v1.webhooks.SmsEvent> vc) {
      super(vc);
    }

    @Override
    public com.sinch.sdk.domains.sms.models.v1.webhooks.SmsEvent deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException {

      Object deserialized = jp.readValueAs(WebhookEventOneOfImpl.class).getActualInstance();
      if (null == deserialized) {
        return null;
      }
      if (!(deserialized instanceof com.sinch.sdk.domains.sms.models.v1.webhooks.SmsEvent)) {
        log.log(Level.SEVERE, "Input data does not match schema ", deserialized);
        return null;
      }

      return (com.sinch.sdk.domains.sms.models.v1.webhooks.SmsEvent) deserialized;
    }
  }
}
