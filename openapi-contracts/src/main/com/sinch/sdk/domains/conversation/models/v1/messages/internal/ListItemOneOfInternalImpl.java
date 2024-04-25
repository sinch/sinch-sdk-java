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
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(using = ListItemOneOfInternalImpl.ListItemOneOfInternalImplDeserializer.class)
@JsonSerialize(using = ListItemOneOfInternalImpl.ListItemOneOfInternalImplSerializer.class)
public class ListItemOneOfInternalImpl extends AbstractOpenApiSchema {
  private static final Logger log = Logger.getLogger(ListItemOneOfInternalImpl.class.getName());

  public static final class ListItemOneOfInternalImplSerializer
      extends StdSerializer<ListItemOneOfInternalImpl> {
    private static final long serialVersionUID = 1L;

    public ListItemOneOfInternalImplSerializer(Class<ListItemOneOfInternalImpl> t) {
      super(t);
    }

    public ListItemOneOfInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        ListItemOneOfInternalImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class ListItemOneOfInternalImplDeserializer
      extends StdDeserializer<ListItemOneOfInternalImpl> {

    private static final long serialVersionUID = 1L;

    public ListItemOneOfInternalImplDeserializer() {
      this(ListItemOneOfInternalImpl.class);
    }

    public ListItemOneOfInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public ListItemOneOfInternalImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      Object deserialized = null;
      boolean typeCoercion = ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
      int match = 0;
      JsonToken token = tree.traverse(jp.getCodec()).nextToken();
      // deserialize ListItemOneOfChoiceInternalImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ListItemOneOfChoiceInternalImpl.class.equals(Integer.class)
            || ListItemOneOfChoiceInternalImpl.class.equals(Long.class)
            || ListItemOneOfChoiceInternalImpl.class.equals(Float.class)
            || ListItemOneOfChoiceInternalImpl.class.equals(Double.class)
            || ListItemOneOfChoiceInternalImpl.class.equals(Boolean.class)
            || ListItemOneOfChoiceInternalImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ListItemOneOfChoiceInternalImpl.class.equals(Integer.class)
                        || ListItemOneOfChoiceInternalImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ListItemOneOfChoiceInternalImpl.class.equals(Float.class)
                        || ListItemOneOfChoiceInternalImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ListItemOneOfChoiceInternalImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ListItemOneOfChoiceInternalImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
            attemptParsing |= (token == JsonToken.VALUE_NULL);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(ListItemOneOfChoiceInternalImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ListItemOneOfChoiceInternalImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'ListItemOneOfChoiceInternalImpl'", e);
      }

      // deserialize ListItemOneOfProductInternalImpl
      try {
        boolean attemptParsing = true;
        // ensure that we respect type coercion as set on the client ObjectMapper
        if (ListItemOneOfProductInternalImpl.class.equals(Integer.class)
            || ListItemOneOfProductInternalImpl.class.equals(Long.class)
            || ListItemOneOfProductInternalImpl.class.equals(Float.class)
            || ListItemOneOfProductInternalImpl.class.equals(Double.class)
            || ListItemOneOfProductInternalImpl.class.equals(Boolean.class)
            || ListItemOneOfProductInternalImpl.class.equals(String.class)) {
          attemptParsing = typeCoercion;
          if (!attemptParsing) {
            attemptParsing |=
                ((ListItemOneOfProductInternalImpl.class.equals(Integer.class)
                        || ListItemOneOfProductInternalImpl.class.equals(Long.class))
                    && token == JsonToken.VALUE_NUMBER_INT);
            attemptParsing |=
                ((ListItemOneOfProductInternalImpl.class.equals(Float.class)
                        || ListItemOneOfProductInternalImpl.class.equals(Double.class))
                    && token == JsonToken.VALUE_NUMBER_FLOAT);
            attemptParsing |=
                (ListItemOneOfProductInternalImpl.class.equals(Boolean.class)
                    && (token == JsonToken.VALUE_FALSE || token == JsonToken.VALUE_TRUE));
            attemptParsing |=
                (ListItemOneOfProductInternalImpl.class.equals(String.class)
                    && token == JsonToken.VALUE_STRING);
            attemptParsing |= (token == JsonToken.VALUE_NULL);
          }
        }
        if (attemptParsing) {
          deserialized =
              tree.traverse(jp.getCodec()).readValueAs(ListItemOneOfProductInternalImpl.class);
          // TODO: there is no validation against JSON schema constraints
          // (min, max, enum, pattern...), this does not perform a strict JSON
          // validation, which means the 'match' count may be higher than it should be.
          match++;
          log.log(Level.FINER, "Input data matches schema 'ListItemOneOfProductInternalImpl'");
        }
      } catch (Exception e) {
        // deserialization failed, continue
        log.log(
            Level.FINER, "Input data does not match schema 'ListItemOneOfProductInternalImpl'", e);
      }

      if (match == 1) {
        ListItemOneOfInternalImpl ret = new ListItemOneOfInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      throw new IOException(
          String.format(
              "Failed deserialization for ListItemOneOfInternalImpl: %d classes match result,"
                  + " expected 1",
              match));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public ListItemOneOfInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      return null;
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  public ListItemOneOfInternalImpl() {
    super("oneOf", Boolean.TRUE);
  }

  public ListItemOneOfInternalImpl(ListItemOneOfChoiceInternalImpl o) {
    super("oneOf", Boolean.TRUE);
    setActualInstance(o);
  }

  public ListItemOneOfInternalImpl(ListItemOneOfProductInternalImpl o) {
    super("oneOf", Boolean.TRUE);
    setActualInstance(o);
  }

  static {
    schemas.put("ListItemOneOfChoiceInternalImpl", ListItemOneOfChoiceInternalImpl.class);
    schemas.put("ListItemOneOfProductInternalImpl", ListItemOneOfProductInternalImpl.class);
    JSONNavigator.registerDescendants(
        ListItemOneOfInternalImpl.class, Collections.unmodifiableMap(schemas));
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return ListItemOneOfInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: ListItemOneOfChoiceInternalImpl,
   * ListItemOneOfProductInternalImpl
   *
   * <p>It could be an instance of the 'oneOf' schemas. The oneOf child schemas may themselves be a
   * composed schema (allOf, anyOf, oneOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (instance == null) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        ListItemOneOfChoiceInternalImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        ListItemOneOfProductInternalImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be ListItemOneOfChoiceInternalImpl,"
            + " ListItemOneOfProductInternalImpl");
  }

  /**
   * Get the actual instance, which can be the following: ListItemOneOfChoiceInternalImpl,
   * ListItemOneOfProductInternalImpl
   *
   * @return The actual instance (ListItemOneOfChoiceInternalImpl, ListItemOneOfProductInternalImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `ListItemOneOfChoiceInternalImpl`. If the actual instance is not
   * `ListItemOneOfChoiceInternalImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ListItemOneOfChoiceInternalImpl`
   * @throws ClassCastException if the instance is not `ListItemOneOfChoiceInternalImpl`
   */
  public ListItemOneOfChoiceInternalImpl getListItemOneOfChoiceInternalImpl()
      throws ClassCastException {
    return (ListItemOneOfChoiceInternalImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `ListItemOneOfProductInternalImpl`. If the actual instance is not
   * `ListItemOneOfProductInternalImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `ListItemOneOfProductInternalImpl`
   * @throws ClassCastException if the instance is not `ListItemOneOfProductInternalImpl`
   */
  public ListItemOneOfProductInternalImpl getListItemOneOfProductInternalImpl()
      throws ClassCastException {
    return (ListItemOneOfProductInternalImpl) super.getActualInstance();
  }
}
