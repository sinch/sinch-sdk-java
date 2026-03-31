package com.sinch.sdk.domains.voice.models.v1.svaml.internal;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sinch.sdk.core.models.AbstractOpenApiSchema;
import com.sinch.sdk.core.utils.databind.JSONNavigator;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionConnectConferenceImpl;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionConnectMxpImpl;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionConnectPstnImpl;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionConnectSipImpl;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionConnectStreamImpl;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionContinueImpl;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionHangupImpl;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionParkImpl;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionRunMenuImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(using = SvamlActionInternalImpl.SvamlActionInternalImplDeserializer.class)
@JsonSerialize(using = SvamlActionInternalImpl.SvamlActionInternalImplSerializer.class)
public final class SvamlActionInternalImpl extends AbstractOpenApiSchema {
  private static final Logger log = Logger.getLogger(SvamlActionInternalImpl.class.getName());

  public static final class SvamlActionInternalImplSerializer
      extends StdSerializer<SvamlActionInternalImpl> {
    private static final long serialVersionUID = 1L;

    public SvamlActionInternalImplSerializer(Class<SvamlActionInternalImpl> t) {
      super(t);
    }

    public SvamlActionInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        SvamlActionInternalImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class SvamlActionInternalImplDeserializer
      extends StdDeserializer<SvamlActionInternalImpl> {
    private static final long serialVersionUID = 1L;

    public SvamlActionInternalImplDeserializer() {
      this(SvamlActionInternalImpl.class);
    }

    public SvamlActionInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public SvamlActionInternalImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();

      Object deserialized = null;
      Class<?> cls = JSONNavigator.getClassForElement(tree, SvamlActionInternalImpl.class);
      if (cls != null) {
        // When the OAS schema includes a discriminator, use the discriminator value to
        // discriminate the anyOf schemas.
        // Get the discriminator mapping value to get the class.
        deserialized = tree.traverse(jp.getCodec()).readValueAs(cls);
        SvamlActionInternalImpl ret = new SvamlActionInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      // deserialize SvamlActionConnectConferenceImpl
      try {
        deserialized =
            tree.traverse(jp.getCodec()).readValueAs(SvamlActionConnectConferenceImpl.class);
        SvamlActionInternalImpl ret = new SvamlActionInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      } catch (Exception e) {
        // deserialization failed, continue, log to help debugging
        log.log(Level.FINER, "Input data does not match 'SvamlActionInternalImpl'", e);
      }

      // deserialize SvamlActionConnectMxpImpl
      try {
        deserialized = tree.traverse(jp.getCodec()).readValueAs(SvamlActionConnectMxpImpl.class);
        SvamlActionInternalImpl ret = new SvamlActionInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      } catch (Exception e) {
        // deserialization failed, continue, log to help debugging
        log.log(Level.FINER, "Input data does not match 'SvamlActionInternalImpl'", e);
      }

      // deserialize SvamlActionConnectPstnImpl
      try {
        deserialized = tree.traverse(jp.getCodec()).readValueAs(SvamlActionConnectPstnImpl.class);
        SvamlActionInternalImpl ret = new SvamlActionInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      } catch (Exception e) {
        // deserialization failed, continue, log to help debugging
        log.log(Level.FINER, "Input data does not match 'SvamlActionInternalImpl'", e);
      }

      // deserialize SvamlActionConnectSipImpl
      try {
        deserialized = tree.traverse(jp.getCodec()).readValueAs(SvamlActionConnectSipImpl.class);
        SvamlActionInternalImpl ret = new SvamlActionInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      } catch (Exception e) {
        // deserialization failed, continue, log to help debugging
        log.log(Level.FINER, "Input data does not match 'SvamlActionInternalImpl'", e);
      }

      // deserialize SvamlActionConnectStreamImpl
      try {
        deserialized = tree.traverse(jp.getCodec()).readValueAs(SvamlActionConnectStreamImpl.class);
        SvamlActionInternalImpl ret = new SvamlActionInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      } catch (Exception e) {
        // deserialization failed, continue, log to help debugging
        log.log(Level.FINER, "Input data does not match 'SvamlActionInternalImpl'", e);
      }

      // deserialize SvamlActionContinueImpl
      try {
        deserialized = tree.traverse(jp.getCodec()).readValueAs(SvamlActionContinueImpl.class);
        SvamlActionInternalImpl ret = new SvamlActionInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      } catch (Exception e) {
        // deserialization failed, continue, log to help debugging
        log.log(Level.FINER, "Input data does not match 'SvamlActionInternalImpl'", e);
      }

      // deserialize SvamlActionHangupImpl
      try {
        deserialized = tree.traverse(jp.getCodec()).readValueAs(SvamlActionHangupImpl.class);
        SvamlActionInternalImpl ret = new SvamlActionInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      } catch (Exception e) {
        // deserialization failed, continue, log to help debugging
        log.log(Level.FINER, "Input data does not match 'SvamlActionInternalImpl'", e);
      }

      // deserialize SvamlActionParkImpl
      try {
        deserialized = tree.traverse(jp.getCodec()).readValueAs(SvamlActionParkImpl.class);
        SvamlActionInternalImpl ret = new SvamlActionInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      } catch (Exception e) {
        // deserialization failed, continue, log to help debugging
        log.log(Level.FINER, "Input data does not match 'SvamlActionInternalImpl'", e);
      }

      // deserialize SvamlActionRunMenuImpl
      try {
        deserialized = tree.traverse(jp.getCodec()).readValueAs(SvamlActionRunMenuImpl.class);
        SvamlActionInternalImpl ret = new SvamlActionInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      } catch (Exception e) {
        // deserialization failed, continue, log to help debugging
        log.log(Level.FINER, "Input data does not match 'SvamlActionInternalImpl'", e);
      }

      throw new IOException(
          String.format("Failed deserialization for SvamlActionInternalImpl: no match found"));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public SvamlActionInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "SvamlActionInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in anyOf
  public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

  public SvamlActionInternalImpl() {
    super("anyOf", Boolean.FALSE);
  }

  public SvamlActionInternalImpl(SvamlActionConnectConferenceImpl o) {
    super("anyOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public SvamlActionInternalImpl(SvamlActionConnectMxpImpl o) {
    super("anyOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public SvamlActionInternalImpl(SvamlActionConnectPstnImpl o) {
    super("anyOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public SvamlActionInternalImpl(SvamlActionConnectSipImpl o) {
    super("anyOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public SvamlActionInternalImpl(SvamlActionConnectStreamImpl o) {
    super("anyOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public SvamlActionInternalImpl(SvamlActionContinueImpl o) {
    super("anyOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public SvamlActionInternalImpl(SvamlActionHangupImpl o) {
    super("anyOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public SvamlActionInternalImpl(SvamlActionParkImpl o) {
    super("anyOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public SvamlActionInternalImpl(SvamlActionRunMenuImpl o) {
    super("anyOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("SvamlActionConnectConferenceImpl", SvamlActionConnectConferenceImpl.class);
    schemas.put("SvamlActionConnectMxpImpl", SvamlActionConnectMxpImpl.class);
    schemas.put("SvamlActionConnectPstnImpl", SvamlActionConnectPstnImpl.class);
    schemas.put("SvamlActionConnectSipImpl", SvamlActionConnectSipImpl.class);
    schemas.put("SvamlActionConnectStreamImpl", SvamlActionConnectStreamImpl.class);
    schemas.put("SvamlActionContinueImpl", SvamlActionContinueImpl.class);
    schemas.put("SvamlActionHangupImpl", SvamlActionHangupImpl.class);
    schemas.put("SvamlActionParkImpl", SvamlActionParkImpl.class);
    schemas.put("SvamlActionRunMenuImpl", SvamlActionRunMenuImpl.class);
    JSONNavigator.registerDescendants(
        SvamlActionInternalImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("connectConf", SvamlActionConnectConferenceImpl.class);
    mappings.put("connectMxp", SvamlActionConnectMxpImpl.class);
    mappings.put("connectPstn", SvamlActionConnectPstnImpl.class);
    mappings.put("connectSip", SvamlActionConnectSipImpl.class);
    mappings.put("connectStream", SvamlActionConnectStreamImpl.class);
    mappings.put("continue", SvamlActionContinueImpl.class);
    mappings.put("hangup", SvamlActionHangupImpl.class);
    mappings.put("park", SvamlActionParkImpl.class);
    mappings.put("runMenu", SvamlActionRunMenuImpl.class);
    mappings.put("svaml.action", SvamlActionInternalImpl.class);
    JSONNavigator.registerDiscriminator(SvamlActionInternalImpl.class, "name", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return SvamlActionInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the anyOf child schema, check the instance parameter is valid
   * against the anyOf child schemas: SvamlActionConnectConferenceImpl, SvamlActionConnectMxpImpl,
   * SvamlActionConnectPstnImpl, SvamlActionConnectSipImpl, SvamlActionConnectStreamImpl,
   * SvamlActionContinueImpl, SvamlActionHangupImpl, SvamlActionParkImpl, SvamlActionRunMenuImpl
   *
   * <p>It could be an instance of the 'anyOf' schemas. The anyOf child schemas may themselves be a
   * composed schema (allOf, anyOf, anyOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        SvamlActionConnectConferenceImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        SvamlActionConnectMxpImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        SvamlActionConnectPstnImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        SvamlActionConnectSipImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        SvamlActionConnectStreamImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        SvamlActionContinueImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        SvamlActionHangupImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(SvamlActionParkImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        SvamlActionRunMenuImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be SvamlActionConnectConferenceImpl,"
            + " SvamlActionConnectMxpImpl, SvamlActionConnectPstnImpl, SvamlActionConnectSipImpl,"
            + " SvamlActionConnectStreamImpl, SvamlActionContinueImpl, SvamlActionHangupImpl,"
            + " SvamlActionParkImpl, SvamlActionRunMenuImpl");
  }

  /**
   * Get the actual instance, which can be the following: SvamlActionConnectConferenceImpl,
   * SvamlActionConnectMxpImpl, SvamlActionConnectPstnImpl, SvamlActionConnectSipImpl,
   * SvamlActionConnectStreamImpl, SvamlActionContinueImpl, SvamlActionHangupImpl,
   * SvamlActionParkImpl, SvamlActionRunMenuImpl
   *
   * @return The actual instance (SvamlActionConnectConferenceImpl, SvamlActionConnectMxpImpl,
   *     SvamlActionConnectPstnImpl, SvamlActionConnectSipImpl, SvamlActionConnectStreamImpl,
   *     SvamlActionContinueImpl, SvamlActionHangupImpl, SvamlActionParkImpl,
   *     SvamlActionRunMenuImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `SvamlActionConnectConferenceImpl`. If the actual instance is not
   * `SvamlActionConnectConferenceImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SvamlActionConnectConferenceImpl`
   * @throws ClassCastException if the instance is not `SvamlActionConnectConferenceImpl`
   */
  public SvamlActionConnectConferenceImpl getSvamlActionConnectConferenceImpl()
      throws ClassCastException {
    return (SvamlActionConnectConferenceImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `SvamlActionConnectMxpImpl`. If the actual instance is not
   * `SvamlActionConnectMxpImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SvamlActionConnectMxpImpl`
   * @throws ClassCastException if the instance is not `SvamlActionConnectMxpImpl`
   */
  public SvamlActionConnectMxpImpl getSvamlActionConnectMxpImpl() throws ClassCastException {
    return (SvamlActionConnectMxpImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `SvamlActionConnectPstnImpl`. If the actual instance is not
   * `SvamlActionConnectPstnImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SvamlActionConnectPstnImpl`
   * @throws ClassCastException if the instance is not `SvamlActionConnectPstnImpl`
   */
  public SvamlActionConnectPstnImpl getSvamlActionConnectPstnImpl() throws ClassCastException {
    return (SvamlActionConnectPstnImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `SvamlActionConnectSipImpl`. If the actual instance is not
   * `SvamlActionConnectSipImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SvamlActionConnectSipImpl`
   * @throws ClassCastException if the instance is not `SvamlActionConnectSipImpl`
   */
  public SvamlActionConnectSipImpl getSvamlActionConnectSipImpl() throws ClassCastException {
    return (SvamlActionConnectSipImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `SvamlActionConnectStreamImpl`. If the actual instance is not
   * `SvamlActionConnectStreamImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SvamlActionConnectStreamImpl`
   * @throws ClassCastException if the instance is not `SvamlActionConnectStreamImpl`
   */
  public SvamlActionConnectStreamImpl getSvamlActionConnectStreamImpl() throws ClassCastException {
    return (SvamlActionConnectStreamImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `SvamlActionContinueImpl`. If the actual instance is not
   * `SvamlActionContinueImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SvamlActionContinueImpl`
   * @throws ClassCastException if the instance is not `SvamlActionContinueImpl`
   */
  public SvamlActionContinueImpl getSvamlActionContinueImpl() throws ClassCastException {
    return (SvamlActionContinueImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `SvamlActionHangupImpl`. If the actual instance is not
   * `SvamlActionHangupImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SvamlActionHangupImpl`
   * @throws ClassCastException if the instance is not `SvamlActionHangupImpl`
   */
  public SvamlActionHangupImpl getSvamlActionHangupImpl() throws ClassCastException {
    return (SvamlActionHangupImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `SvamlActionParkImpl`. If the actual instance is not
   * `SvamlActionParkImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SvamlActionParkImpl`
   * @throws ClassCastException if the instance is not `SvamlActionParkImpl`
   */
  public SvamlActionParkImpl getSvamlActionParkImpl() throws ClassCastException {
    return (SvamlActionParkImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `SvamlActionRunMenuImpl`. If the actual instance is not
   * `SvamlActionRunMenuImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SvamlActionRunMenuImpl`
   * @throws ClassCastException if the instance is not `SvamlActionRunMenuImpl`
   */
  public SvamlActionRunMenuImpl getSvamlActionRunMenuImpl() throws ClassCastException {
    return (SvamlActionRunMenuImpl) super.getActualInstance();
  }
}
