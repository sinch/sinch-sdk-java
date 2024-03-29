/*
 * Voice API | Sinch
 * The Voice API exposes calling- and conference-related functionality in the Sinch Voice Platform.
 *
 * The version of the OpenAPI document: 1.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.voice.models.dto.v1;

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
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(using = SvamlInstructionDto.SvamlInstructionDtoDeserializer.class)
@JsonSerialize(using = SvamlInstructionDto.SvamlInstructionDtoSerializer.class)
public final class SvamlInstructionDto extends AbstractOpenApiSchema {
  private static final Logger log = Logger.getLogger(SvamlInstructionDto.class.getName());

  public static final class SvamlInstructionDtoSerializer
      extends StdSerializer<SvamlInstructionDto> {
    private static final long serialVersionUID = 1L;

    public SvamlInstructionDtoSerializer(Class<SvamlInstructionDto> t) {
      super(t);
    }

    public SvamlInstructionDtoSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        SvamlInstructionDto value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class SvamlInstructionDtoDeserializer
      extends StdDeserializer<SvamlInstructionDto> {
    private static final long serialVersionUID = 1L;

    public SvamlInstructionDtoDeserializer() {
      this(SvamlInstructionDto.class);
    }

    public SvamlInstructionDtoDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public SvamlInstructionDto deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();

      Object deserialized = null;
      Class<?> cls = JSONNavigator.getClassForElement(tree, SvamlInstructionDto.class);
      if (cls != null) {
        // When the OAS schema includes a discriminator, use the discriminator value to
        // discriminate the anyOf schemas.
        // Get the discriminator mapping value to get the class.
        deserialized = tree.traverse(jp.getCodec()).readValueAs(cls);
        SvamlInstructionDto ret = new SvamlInstructionDto();
        ret.setActualInstance(deserialized);
        return ret;
      }
      // deserialize SvamlInstructionAnswerDto
      try {
        deserialized = tree.traverse(jp.getCodec()).readValueAs(SvamlInstructionAnswerDto.class);
        SvamlInstructionDto ret = new SvamlInstructionDto();
        ret.setActualInstance(deserialized);
        return ret;
      } catch (Exception e) {
        // deserialization failed, continue, log to help debugging
        log.log(Level.FINER, "Input data does not match 'SvamlInstructionDto'", e);
      }

      // deserialize SvamlInstructionPlayFilesDto
      try {
        deserialized = tree.traverse(jp.getCodec()).readValueAs(SvamlInstructionPlayFilesDto.class);
        SvamlInstructionDto ret = new SvamlInstructionDto();
        ret.setActualInstance(deserialized);
        return ret;
      } catch (Exception e) {
        // deserialization failed, continue, log to help debugging
        log.log(Level.FINER, "Input data does not match 'SvamlInstructionDto'", e);
      }

      // deserialize SvamlInstructionSayDto
      try {
        deserialized = tree.traverse(jp.getCodec()).readValueAs(SvamlInstructionSayDto.class);
        SvamlInstructionDto ret = new SvamlInstructionDto();
        ret.setActualInstance(deserialized);
        return ret;
      } catch (Exception e) {
        // deserialization failed, continue, log to help debugging
        log.log(Level.FINER, "Input data does not match 'SvamlInstructionDto'", e);
      }

      // deserialize SvamlInstructionSendDtmfDto
      try {
        deserialized = tree.traverse(jp.getCodec()).readValueAs(SvamlInstructionSendDtmfDto.class);
        SvamlInstructionDto ret = new SvamlInstructionDto();
        ret.setActualInstance(deserialized);
        return ret;
      } catch (Exception e) {
        // deserialization failed, continue, log to help debugging
        log.log(Level.FINER, "Input data does not match 'SvamlInstructionDto'", e);
      }

      // deserialize SvamlInstructionSetCookieDto
      try {
        deserialized = tree.traverse(jp.getCodec()).readValueAs(SvamlInstructionSetCookieDto.class);
        SvamlInstructionDto ret = new SvamlInstructionDto();
        ret.setActualInstance(deserialized);
        return ret;
      } catch (Exception e) {
        // deserialization failed, continue, log to help debugging
        log.log(Level.FINER, "Input data does not match 'SvamlInstructionDto'", e);
      }

      // deserialize SvamlInstructionStartRecordingDto
      try {
        deserialized =
            tree.traverse(jp.getCodec()).readValueAs(SvamlInstructionStartRecordingDto.class);
        SvamlInstructionDto ret = new SvamlInstructionDto();
        ret.setActualInstance(deserialized);
        return ret;
      } catch (Exception e) {
        // deserialization failed, continue, log to help debugging
        log.log(Level.FINER, "Input data does not match 'SvamlInstructionDto'", e);
      }

      // deserialize SvamlInstructionStopRecordingDto
      try {
        deserialized =
            tree.traverse(jp.getCodec()).readValueAs(SvamlInstructionStopRecordingDto.class);
        SvamlInstructionDto ret = new SvamlInstructionDto();
        ret.setActualInstance(deserialized);
        return ret;
      } catch (Exception e) {
        // deserialization failed, continue, log to help debugging
        log.log(Level.FINER, "Input data does not match 'SvamlInstructionDto'", e);
      }

      throw new IOException(
          String.format("Failed deserialization for SvamlInstructionDto: no match found"));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public SvamlInstructionDto getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "SvamlInstructionDto cannot be null");
    }
  }

  // store a list of schema names defined in anyOf
  public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

  public SvamlInstructionDto() {
    super("anyOf", Boolean.FALSE);
  }

  public SvamlInstructionDto(SvamlInstructionAnswerDto o) {
    super("anyOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public SvamlInstructionDto(SvamlInstructionPlayFilesDto o) {
    super("anyOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public SvamlInstructionDto(SvamlInstructionSayDto o) {
    super("anyOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public SvamlInstructionDto(SvamlInstructionSendDtmfDto o) {
    super("anyOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public SvamlInstructionDto(SvamlInstructionSetCookieDto o) {
    super("anyOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public SvamlInstructionDto(SvamlInstructionStartRecordingDto o) {
    super("anyOf", Boolean.FALSE);
    setActualInstance(o);
  }

  public SvamlInstructionDto(SvamlInstructionStopRecordingDto o) {
    super("anyOf", Boolean.FALSE);
    setActualInstance(o);
  }

  static {
    schemas.put("SvamlInstructionAnswerDto", SvamlInstructionAnswerDto.class);
    schemas.put("SvamlInstructionPlayFilesDto", SvamlInstructionPlayFilesDto.class);
    schemas.put("SvamlInstructionSayDto", SvamlInstructionSayDto.class);
    schemas.put("SvamlInstructionSendDtmfDto", SvamlInstructionSendDtmfDto.class);
    schemas.put("SvamlInstructionSetCookieDto", SvamlInstructionSetCookieDto.class);
    schemas.put("SvamlInstructionStartRecordingDto", SvamlInstructionStartRecordingDto.class);
    schemas.put("SvamlInstructionStopRecordingDto", SvamlInstructionStopRecordingDto.class);
    JSONNavigator.registerDescendants(
        SvamlInstructionDto.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("answer", SvamlInstructionAnswerDto.class);
    mappings.put("playFiles", SvamlInstructionPlayFilesDto.class);
    mappings.put("say", SvamlInstructionSayDto.class);
    mappings.put("sendDtmf", SvamlInstructionSendDtmfDto.class);
    mappings.put("setCookie", SvamlInstructionSetCookieDto.class);
    mappings.put("startRecording", SvamlInstructionStartRecordingDto.class);
    mappings.put("stopRecording", SvamlInstructionStopRecordingDto.class);
    mappings.put("svaml.instruction.answer", SvamlInstructionAnswerDto.class);
    mappings.put("svaml.instruction.playFiles", SvamlInstructionPlayFilesDto.class);
    mappings.put("svaml.instruction.say", SvamlInstructionSayDto.class);
    mappings.put("svaml.instruction.sendDtmf", SvamlInstructionSendDtmfDto.class);
    mappings.put("svaml.instruction.setCookie", SvamlInstructionSetCookieDto.class);
    mappings.put("svaml.instruction.startRecording", SvamlInstructionStartRecordingDto.class);
    mappings.put("svaml.instruction.stopRecording", SvamlInstructionStopRecordingDto.class);
    mappings.put("svaml.instruction", SvamlInstructionDto.class);
    JSONNavigator.registerDiscriminator(SvamlInstructionDto.class, "name", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return SvamlInstructionDto.schemas;
  }

  /**
   * Set the instance that matches the anyOf child schema, check the instance parameter is valid
   * against the anyOf child schemas: SvamlInstructionAnswerDto, SvamlInstructionPlayFilesDto,
   * SvamlInstructionSayDto, SvamlInstructionSendDtmfDto, SvamlInstructionSetCookieDto,
   * SvamlInstructionStartRecordingDto, SvamlInstructionStopRecordingDto
   *
   * <p>It could be an instance of the 'anyOf' schemas. The anyOf child schemas may themselves be a
   * composed schema (allOf, anyOf, anyOf).
   */
  @Override
  public void setActualInstance(Object instance) {
    if (JSONNavigator.isInstanceOf(
        SvamlInstructionAnswerDto.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        SvamlInstructionPlayFilesDto.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        SvamlInstructionSayDto.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        SvamlInstructionSendDtmfDto.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        SvamlInstructionSetCookieDto.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        SvamlInstructionStartRecordingDto.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    if (JSONNavigator.isInstanceOf(
        SvamlInstructionStopRecordingDto.class, instance, new HashSet<Class<?>>())) {
      super.setActualInstance(instance);
      return;
    }

    throw new RuntimeException(
        "Invalid instance type. Must be SvamlInstructionAnswerDto, SvamlInstructionPlayFilesDto,"
            + " SvamlInstructionSayDto, SvamlInstructionSendDtmfDto, SvamlInstructionSetCookieDto,"
            + " SvamlInstructionStartRecordingDto, SvamlInstructionStopRecordingDto");
  }

  /**
   * Get the actual instance, which can be the following: SvamlInstructionAnswerDto,
   * SvamlInstructionPlayFilesDto, SvamlInstructionSayDto, SvamlInstructionSendDtmfDto,
   * SvamlInstructionSetCookieDto, SvamlInstructionStartRecordingDto,
   * SvamlInstructionStopRecordingDto
   *
   * @return The actual instance (SvamlInstructionAnswerDto, SvamlInstructionPlayFilesDto,
   *     SvamlInstructionSayDto, SvamlInstructionSendDtmfDto, SvamlInstructionSetCookieDto,
   *     SvamlInstructionStartRecordingDto, SvamlInstructionStopRecordingDto)
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  /**
   * Get the actual instance of `SvamlInstructionAnswerDto`. If the actual instance is not
   * `SvamlInstructionAnswerDto`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SvamlInstructionAnswerDto`
   * @throws ClassCastException if the instance is not `SvamlInstructionAnswerDto`
   */
  public SvamlInstructionAnswerDto getSvamlInstructionAnswerDto() throws ClassCastException {
    return (SvamlInstructionAnswerDto) super.getActualInstance();
  }

  /**
   * Get the actual instance of `SvamlInstructionPlayFilesDto`. If the actual instance is not
   * `SvamlInstructionPlayFilesDto`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SvamlInstructionPlayFilesDto`
   * @throws ClassCastException if the instance is not `SvamlInstructionPlayFilesDto`
   */
  public SvamlInstructionPlayFilesDto getSvamlInstructionPlayFilesDto() throws ClassCastException {
    return (SvamlInstructionPlayFilesDto) super.getActualInstance();
  }

  /**
   * Get the actual instance of `SvamlInstructionSayDto`. If the actual instance is not
   * `SvamlInstructionSayDto`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SvamlInstructionSayDto`
   * @throws ClassCastException if the instance is not `SvamlInstructionSayDto`
   */
  public SvamlInstructionSayDto getSvamlInstructionSayDto() throws ClassCastException {
    return (SvamlInstructionSayDto) super.getActualInstance();
  }

  /**
   * Get the actual instance of `SvamlInstructionSendDtmfDto`. If the actual instance is not
   * `SvamlInstructionSendDtmfDto`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SvamlInstructionSendDtmfDto`
   * @throws ClassCastException if the instance is not `SvamlInstructionSendDtmfDto`
   */
  public SvamlInstructionSendDtmfDto getSvamlInstructionSendDtmfDto() throws ClassCastException {
    return (SvamlInstructionSendDtmfDto) super.getActualInstance();
  }

  /**
   * Get the actual instance of `SvamlInstructionSetCookieDto`. If the actual instance is not
   * `SvamlInstructionSetCookieDto`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SvamlInstructionSetCookieDto`
   * @throws ClassCastException if the instance is not `SvamlInstructionSetCookieDto`
   */
  public SvamlInstructionSetCookieDto getSvamlInstructionSetCookieDto() throws ClassCastException {
    return (SvamlInstructionSetCookieDto) super.getActualInstance();
  }

  /**
   * Get the actual instance of `SvamlInstructionStartRecordingDto`. If the actual instance is not
   * `SvamlInstructionStartRecordingDto`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SvamlInstructionStartRecordingDto`
   * @throws ClassCastException if the instance is not `SvamlInstructionStartRecordingDto`
   */
  public SvamlInstructionStartRecordingDto getSvamlInstructionStartRecordingDto()
      throws ClassCastException {
    return (SvamlInstructionStartRecordingDto) super.getActualInstance();
  }

  /**
   * Get the actual instance of `SvamlInstructionStopRecordingDto`. If the actual instance is not
   * `SvamlInstructionStopRecordingDto`, the ClassCastException will be thrown.
   *
   * @return The actual instance of `SvamlInstructionStopRecordingDto`
   * @throws ClassCastException if the instance is not `SvamlInstructionStopRecordingDto`
   */
  public SvamlInstructionStopRecordingDto getSvamlInstructionStopRecordingDto()
      throws ClassCastException {
    return (SvamlInstructionStopRecordingDto) super.getActualInstance();
  }
}
