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
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionAnswerImpl;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionPlayFilesImpl;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionSayImpl;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionSendDtmfImpl;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionSetCookieImpl;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionStartRecordingImpl;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionStopRecordingImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(
    using = SvamlInstructionInternalImpl.SvamlInstructionInternalImplDeserializer.class)
@JsonSerialize(using = SvamlInstructionInternalImpl.SvamlInstructionInternalImplSerializer.class)
public final class SvamlInstructionInternalImpl extends AbstractOpenApiSchema {
  private static final Logger log = Logger.getLogger(SvamlInstructionInternalImpl.class.getName());

  public static final class SvamlInstructionInternalImplSerializer
      extends StdSerializer<SvamlInstructionInternalImpl> {
    private static final long serialVersionUID = 1L;

    public SvamlInstructionInternalImplSerializer(Class<SvamlInstructionInternalImpl> t) {
      super(t);
    }

    public SvamlInstructionInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        SvamlInstructionInternalImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class SvamlInstructionInternalImplDeserializer
      extends StdDeserializer<SvamlInstructionInternalImpl> {
    private static final long serialVersionUID = 1L;

    public SvamlInstructionInternalImplDeserializer() {
      this(SvamlInstructionInternalImpl.class);
    }

    public SvamlInstructionInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public SvamlInstructionInternalImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();

      Object deserialized = null;
      Class<?> cls = JSONNavigator.getClassForElement(tree, SvamlInstructionInternalImpl.class);
      if (cls != null) {
        // When the OAS schema includes a discriminator, use the discriminator value to
        // discriminate the anyOf schemas.
        // Get the discriminator mapping value to get the class.
        deserialized = tree.traverse(jp.getCodec()).readValueAs(cls);
        SvamlInstructionInternalImpl ret = new SvamlInstructionInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      }
      // deserialize SvamlInstructionAnswerImpl
      try {
        deserialized = tree.traverse(jp.getCodec()).readValueAs(SvamlInstructionAnswerImpl.class);
        SvamlInstructionInternalImpl ret = new SvamlInstructionInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      } catch (Exception e) {
        // deserialization failed, continue, log to help debugging
        log.log(Level.FINER, "Input data does not match 'SvamlInstructionInternalImpl'", e);
      }

      // deserialize SvamlInstructionPlayFilesImpl
      try {
        deserialized =
            tree.traverse(jp.getCodec()).readValueAs(SvamlInstructionPlayFilesImpl.class);
        SvamlInstructionInternalImpl ret = new SvamlInstructionInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      } catch (Exception e) {
        // deserialization failed, continue, log to help debugging
        log.log(Level.FINER, "Input data does not match 'SvamlInstructionInternalImpl'", e);
      }

      // deserialize SvamlInstructionSayImpl
      try {
        deserialized = tree.traverse(jp.getCodec()).readValueAs(SvamlInstructionSayImpl.class);
        SvamlInstructionInternalImpl ret = new SvamlInstructionInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      } catch (Exception e) {
        // deserialization failed, continue, log to help debugging
        log.log(Level.FINER, "Input data does not match 'SvamlInstructionInternalImpl'", e);
      }

      // deserialize SvamlInstructionSendDtmfImpl
      try {
        deserialized = tree.traverse(jp.getCodec()).readValueAs(SvamlInstructionSendDtmfImpl.class);
        SvamlInstructionInternalImpl ret = new SvamlInstructionInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      } catch (Exception e) {
        // deserialization failed, continue, log to help debugging
        log.log(Level.FINER, "Input data does not match 'SvamlInstructionInternalImpl'", e);
      }

      // deserialize SvamlInstructionSetCookieImpl
      try {
        deserialized =
            tree.traverse(jp.getCodec()).readValueAs(SvamlInstructionSetCookieImpl.class);
        SvamlInstructionInternalImpl ret = new SvamlInstructionInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      } catch (Exception e) {
        // deserialization failed, continue, log to help debugging
        log.log(Level.FINER, "Input data does not match 'SvamlInstructionInternalImpl'", e);
      }

      // deserialize SvamlInstructionStartRecordingImpl
      try {
        deserialized =
            tree.traverse(jp.getCodec()).readValueAs(SvamlInstructionStartRecordingImpl.class);
        SvamlInstructionInternalImpl ret = new SvamlInstructionInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      } catch (Exception e) {
        // deserialization failed, continue, log to help debugging
        log.log(Level.FINER, "Input data does not match 'SvamlInstructionInternalImpl'", e);
      }

      // deserialize SvamlInstructionStopRecordingImpl
      try {
        deserialized =
            tree.traverse(jp.getCodec()).readValueAs(SvamlInstructionStopRecordingImpl.class);
        SvamlInstructionInternalImpl ret = new SvamlInstructionInternalImpl();
        ret.setActualInstance(deserialized);
        return ret;
      } catch (Exception e) {
        // deserialization failed, continue, log to help debugging
        log.log(Level.FINER, "Input data does not match 'SvamlInstructionInternalImpl'", e);
      }

      throw new IOException(
          String.format("Failed deserialization for SvamlInstructionInternalImpl: no match found"));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public SvamlInstructionInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(
          ctxt.getParser(), "SvamlInstructionInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in anyOf
  public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

  public SvamlInstructionInternalImpl() {
    super("anyOf", Boolean.FALSE);
  }

  public SvamlInstructionInternalImpl(SvamlInstructionAnswerImpl o) {
    super("anyOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public SvamlInstructionInternalImpl(SvamlInstructionPlayFilesImpl o) {
    super("anyOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public SvamlInstructionInternalImpl(SvamlInstructionSayImpl o) {
    super("anyOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public SvamlInstructionInternalImpl(SvamlInstructionSendDtmfImpl o) {
    super("anyOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public SvamlInstructionInternalImpl(SvamlInstructionSetCookieImpl o) {
    super("anyOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public SvamlInstructionInternalImpl(SvamlInstructionStartRecordingImpl o) {
    super("anyOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public SvamlInstructionInternalImpl(SvamlInstructionStopRecordingImpl o) {
    super("anyOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("SvamlInstructionAnswerImpl", SvamlInstructionAnswerImpl.class);
    schemas.put("SvamlInstructionPlayFilesImpl", SvamlInstructionPlayFilesImpl.class);
    schemas.put("SvamlInstructionSayImpl", SvamlInstructionSayImpl.class);
    schemas.put("SvamlInstructionSendDtmfImpl", SvamlInstructionSendDtmfImpl.class);
    schemas.put("SvamlInstructionSetCookieImpl", SvamlInstructionSetCookieImpl.class);
    schemas.put("SvamlInstructionStartRecordingImpl", SvamlInstructionStartRecordingImpl.class);
    schemas.put("SvamlInstructionStopRecordingImpl", SvamlInstructionStopRecordingImpl.class);
    JSONNavigator.registerDescendants(
        SvamlInstructionInternalImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("answer", SvamlInstructionAnswerImpl.class);
    mappings.put("playFiles", SvamlInstructionPlayFilesImpl.class);
    mappings.put("say", SvamlInstructionSayImpl.class);
    mappings.put("sendDtmf", SvamlInstructionSendDtmfImpl.class);
    mappings.put("setCookie", SvamlInstructionSetCookieImpl.class);
    mappings.put("startRecording", SvamlInstructionStartRecordingImpl.class);
    mappings.put("stopRecording", SvamlInstructionStopRecordingImpl.class);
    mappings.put("svaml.instruction.answer", SvamlInstructionAnswerImpl.class);
    mappings.put("svaml.instruction.playFiles", SvamlInstructionPlayFilesImpl.class);
    mappings.put("svaml.instruction.say", SvamlInstructionSayImpl.class);
    mappings.put("svaml.instruction.sendDtmf", SvamlInstructionSendDtmfImpl.class);
    mappings.put("svaml.instruction.setCookie", SvamlInstructionSetCookieImpl.class);
    mappings.put("svaml.instruction.startRecording", SvamlInstructionStartRecordingImpl.class);
    mappings.put("svaml.instruction.stopRecording", SvamlInstructionStopRecordingImpl.class);
    mappings.put("svaml.instruction", SvamlInstructionInternalImpl.class);
    JSONNavigator.registerDiscriminator(SvamlInstructionInternalImpl.class, "name", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return SvamlInstructionInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the anyOf child schema, check the instance parameter is valid
   * against the anyOf child schemas: SvamlInstructionAnswerImpl, SvamlInstructionPlayFilesImpl,
   * SvamlInstructionSayImpl, SvamlInstructionSendDtmfImpl, SvamlInstructionSetCookieImpl,
   * SvamlInstructionStartRecordingImpl, SvamlInstructionStopRecordingImpl
   *
   * <p>It could be an instance of the 'anyOf' schemas. The anyOf child schemas may themselves be a
   * composed schema (allOf, anyOf, anyOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        SvamlInstructionAnswerImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        SvamlInstructionPlayFilesImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        SvamlInstructionSayImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        SvamlInstructionSendDtmfImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        SvamlInstructionSetCookieImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        SvamlInstructionStartRecordingImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        SvamlInstructionStopRecordingImpl.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be SvamlInstructionAnswerImpl, SvamlInstructionPlayFilesImpl,"
            + " SvamlInstructionSayImpl, SvamlInstructionSendDtmfImpl,"
            + " SvamlInstructionSetCookieImpl, SvamlInstructionStartRecordingImpl,"
            + " SvamlInstructionStopRecordingImpl");
  }

  /**
   * Get the actual instance, which can be the following: SvamlInstructionAnswerImpl,
   * SvamlInstructionPlayFilesImpl, SvamlInstructionSayImpl, SvamlInstructionSendDtmfImpl,
   * SvamlInstructionSetCookieImpl, SvamlInstructionStartRecordingImpl,
   * SvamlInstructionStopRecordingImpl
   *
   * @return The actual instance (SvamlInstructionAnswerImpl, SvamlInstructionPlayFilesImpl,
   *     SvamlInstructionSayImpl, SvamlInstructionSendDtmfImpl, SvamlInstructionSetCookieImpl,
   *     SvamlInstructionStartRecordingImpl, SvamlInstructionStopRecordingImpl)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `SvamlInstructionAnswerImpl`. If the actual instance is not
   * `SvamlInstructionAnswerImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SvamlInstructionAnswerImpl`
   * @throws ClassCastException if the instance is not `SvamlInstructionAnswerImpl`
   */
  public SvamlInstructionAnswerImpl getSvamlInstructionAnswerImpl() throws ClassCastException {
    return (SvamlInstructionAnswerImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `SvamlInstructionPlayFilesImpl`. If the actual instance is not
   * `SvamlInstructionPlayFilesImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SvamlInstructionPlayFilesImpl`
   * @throws ClassCastException if the instance is not `SvamlInstructionPlayFilesImpl`
   */
  public SvamlInstructionPlayFilesImpl getSvamlInstructionPlayFilesImpl()
      throws ClassCastException {
    return (SvamlInstructionPlayFilesImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `SvamlInstructionSayImpl`. If the actual instance is not
   * `SvamlInstructionSayImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SvamlInstructionSayImpl`
   * @throws ClassCastException if the instance is not `SvamlInstructionSayImpl`
   */
  public SvamlInstructionSayImpl getSvamlInstructionSayImpl() throws ClassCastException {
    return (SvamlInstructionSayImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `SvamlInstructionSendDtmfImpl`. If the actual instance is not
   * `SvamlInstructionSendDtmfImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SvamlInstructionSendDtmfImpl`
   * @throws ClassCastException if the instance is not `SvamlInstructionSendDtmfImpl`
   */
  public SvamlInstructionSendDtmfImpl getSvamlInstructionSendDtmfImpl() throws ClassCastException {
    return (SvamlInstructionSendDtmfImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `SvamlInstructionSetCookieImpl`. If the actual instance is not
   * `SvamlInstructionSetCookieImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SvamlInstructionSetCookieImpl`
   * @throws ClassCastException if the instance is not `SvamlInstructionSetCookieImpl`
   */
  public SvamlInstructionSetCookieImpl getSvamlInstructionSetCookieImpl()
      throws ClassCastException {
    return (SvamlInstructionSetCookieImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `SvamlInstructionStartRecordingImpl`. If the actual instance is not
   * `SvamlInstructionStartRecordingImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SvamlInstructionStartRecordingImpl`
   * @throws ClassCastException if the instance is not `SvamlInstructionStartRecordingImpl`
   */
  public SvamlInstructionStartRecordingImpl getSvamlInstructionStartRecordingImpl()
      throws ClassCastException {
    return (SvamlInstructionStartRecordingImpl) super.getActualInstance();
  }

  /**
   * Get the actual instance of `SvamlInstructionStopRecordingImpl`. If the actual instance is not
   * `SvamlInstructionStopRecordingImpl`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SvamlInstructionStopRecordingImpl`
   * @throws ClassCastException if the instance is not `SvamlInstructionStopRecordingImpl`
   */
  public SvamlInstructionStopRecordingImpl getSvamlInstructionStopRecordingImpl()
      throws ClassCastException {
    return (SvamlInstructionStopRecordingImpl) super.getActualInstance();
  }
}
