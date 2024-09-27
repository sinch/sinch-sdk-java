package com.sinch.sdk.domains.conversation.models.v1.internal;

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
import com.sinch.sdk.domains.conversation.models.v1.ContactIdImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.IdentifiedByFieldInternalImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(using = RecipientInternalImpl.RecipientInternalImplDeserializer.class)
@JsonSerialize(using = RecipientInternalImpl.RecipientInternalImplSerializer.class)
public class RecipientInternalImpl extends AbstractOpenApiSchema implements RecipientInternal {
  private static final Logger log = Logger.getLogger(RecipientInternalImpl.class.getName());

  public static final class RecipientInternalImplSerializer
      extends StdSerializer<RecipientInternalImpl> {
    private static final long serialVersionUID = 1L;

    public RecipientInternalImplSerializer(Class<RecipientInternalImpl> t) {
      super(t);
    }

    public RecipientInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        RecipientInternalImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class RecipientInternalImplDeserializer
      extends StdDeserializer<RecipientInternalImpl> {

    private static final long serialVersionUID = 1L;

    public RecipientInternalImplDeserializer() {
      this(RecipientInternalImpl.class);
    }

    public RecipientInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public RecipientInternalImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize ContactIdImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ContactIdImpl.class.equals(Integer.class)
            || ContactIdImpl.class.equals(Long.class)
            || ContactIdImpl.class.equals(Float.class)
            || ContactIdImpl.class.equals(Double.class)
            || ContactIdImpl.class.equals(Boolean.class)
            || ContactIdImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ContactIdImpl.class.equals(Integer.class)
                        || ContactIdImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ContactIdImpl.class.equals(Float.class)
                        || ContactIdImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ContactIdImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ContactIdImpl.class.equals(String.class) && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized = tree.traverse(jp.getCodec()).readValueAs(ContactIdImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ContactIdImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'ContactIdImpl'", e);
      }

      // deserialize IdentifiedByFieldInternalImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (IdentifiedByFieldInternalImpl.class.equals(Integer.class)
            || IdentifiedByFieldInternalImpl.class.equals(Long.class)
            || IdentifiedByFieldInternalImpl.class.equals(Float.class)
            || IdentifiedByFieldInternalImpl.class.equals(Double.class)
            || IdentifiedByFieldInternalImpl.class.equals(Boolean.class)
            || IdentifiedByFieldInternalImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((IdentifiedByFieldInternalImpl.class.equals(Integer.class)
                        || IdentifiedByFieldInternalImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((IdentifiedByFieldInternalImpl.class.equals(Float.class)
                        || IdentifiedByFieldInternalImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (IdentifiedByFieldInternalImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (IdentifiedByFieldInternalImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(IdentifiedByFieldInternalImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'IdentifiedByFieldInternalImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(Level.FINER, "Input data does not match schema 'IdentifiedByFieldInternalImpl'", e);
      }

      if (match == 1) {
        RecipientInternalImpl ret = new RecipientInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for RecipientInternalImpl: %d classes match result, expected"
                  + " 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public RecipientInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "RecipientInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public RecipientInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  public RecipientInternalImpl(ContactIdImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public RecipientInternalImpl(IdentifiedByFieldInternalImpl o) {
    super("oneOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("ContactIdImpl", ContactIdImpl.class);
    schemas.put("IdentifiedByFieldInternalImpl", IdentifiedByFieldInternalImpl.class);
    JSONNavigator.registerDescendants(
        RecipientInternalImpl.class, Collections.unmodifiableMap(schemas));
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return RecipientInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: ContactIdImpl, IdentifiedByFieldInternalImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(ContactIdImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        IdentifiedByFieldInternalImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be ContactIdImpl, IdentifiedByFieldInternalImpl");
  }

  /**
   * Get the actual instance, which can be the following: ContactIdImpl,
   * IdentifiedByFieldInternalImpl
   *
   * @return The actual instance (ContactIdImpl, IdentifiedByFieldInternalImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `ContactIdImpl`. If the actual instance is not `ContactIdImpl`, the
   * ClassCastException will be thrown.
   *
   * @return The actual instance of `ContactIdImpl`
   * @throws ClassCastException if the instance is not `ContactIdImpl`
   */
  public ContactIdImpl getContactIdImpl() throws ClassCastException {
    return (ContactIdImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `IdentifiedByFieldInternalImpl`. If the actual instance is not
   * `IdentifiedByFieldInternalImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `IdentifiedByFieldInternalImpl`
   * @throws ClassCastException if the instance is not `IdentifiedByFieldInternalImpl`
   */
  public IdentifiedByFieldInternalImpl getIdentifiedByFieldInternalImpl()
      throws ClassCastException {
    return (IdentifiedByFieldInternalImpl) super.getActualInstance();
  }
}
