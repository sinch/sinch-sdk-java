package com.sinch.sdk.domains.voice.models.v2.svaml.internal;

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
import com.sinch.sdk.domains.voice.models.v2.svaml.AmdCommandImpl;
import com.sinch.sdk.domains.voice.models.v2.svaml.AnswerCommandImpl;
import com.sinch.sdk.domains.voice.models.v2.svaml.BridgeCallCommandImpl;
import com.sinch.sdk.domains.voice.models.v2.svaml.CustomEventCommandImpl;
import com.sinch.sdk.domains.voice.models.v2.svaml.DialCommandImpl;
import com.sinch.sdk.domains.voice.models.v2.svaml.GotoMenuCommandImpl;
import com.sinch.sdk.domains.voice.models.v2.svaml.HangupCommandImpl;
import com.sinch.sdk.domains.voice.models.v2.svaml.MenuCommandImpl;
import com.sinch.sdk.domains.voice.models.v2.svaml.MessagesCommandImpl;
import com.sinch.sdk.domains.voice.models.v2.svaml.PauseCommandImpl;
import com.sinch.sdk.domains.voice.models.v2.svaml.StartRecordingCommandImpl;
import com.sinch.sdk.domains.voice.models.v2.svaml.StopMessagesCommandImpl;
import com.sinch.sdk.domains.voice.models.v2.svaml.StopRecordingCommandImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@JsonDeserialize(using = SvamlCommandInternalImpl.SvamlCommandInternalImplDeserializer.class)
@JsonSerialize(using = SvamlCommandInternalImpl.SvamlCommandInternalImplSerializer.class)
public class SvamlCommandInternalImpl extends AbstractOpenApiSchema
    implements SvamlCommandInternal {
  private static final Logger log = Logger.getLogger(SvamlCommandInternalImpl.class.getName());

  public static final class SvamlCommandInternalImplSerializer
      extends StdSerializer<SvamlCommandInternalImpl> {
    private static final long serialVersionUID = 1L;

    public SvamlCommandInternalImplSerializer(Class<SvamlCommandInternalImpl> t) {
      super(t);
    }

    public SvamlCommandInternalImplSerializer() {
      this(null);
    }

    @Override
    public void serialize(
        SvamlCommandInternalImpl value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeObject(value.getActualInstance());
    }
  }

  public static final class SvamlCommandInternalImplDeserializer
      extends StdDeserializer<SvamlCommandInternalImpl> {

    private static final long serialVersionUID = 1L;

    public SvamlCommandInternalImplDeserializer() {
      this(SvamlCommandInternalImpl.class);
    }

    public SvamlCommandInternalImplDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public SvamlCommandInternalImpl deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      JsonNode tree = jp.readValueAsTree();
      JsonNode discriminator = tree.get("command");
      String discriminatorValue = null != discriminator ? discriminator.asText() : null;
      Class<?> cls = null != discriminatorValue ? mappings.get(discriminatorValue) : null;
      if (null == cls) {
        throw new IOException(
            String.format(
                "Failed deserialization for SvamlCommandInternalImpl: unknown 'command' value '%s'."
                    + " Possible values: %s",
                discriminatorValue, mappings.keySet()));
      }
      Object deserialized = tree.traverse(jp.getCodec()).readValueAs(cls);
      SvamlCommandInternalImpl ret = new SvamlCommandInternalImpl();
      ret.setActualInstance(deserialized);
      return ret;
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public SvamlCommandInternalImpl getNullValue(DeserializationContext ctxt)
        throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "SvamlCommandInternalImpl cannot be null");
    }
  }

  // store a list of schema names defined in oneOf
  public static final Map<String, Class<?>> schemas = new HashMap<>();

  // discriminator value -> class
  private static final Map<String, Class<?>> mappings = new HashMap<>();

  public SvamlCommandInternalImpl() {
    super("oneOf", Boolean.FALSE);
  }

  static {
    schemas.put("AmdCommandImpl", AmdCommandImpl.class);
    schemas.put("AnswerCommandImpl", AnswerCommandImpl.class);
    schemas.put("BridgeCallCommandImpl", BridgeCallCommandImpl.class);
    schemas.put("DialCommandImpl", DialCommandImpl.class);
    schemas.put("GotoMenuCommandImpl", GotoMenuCommandImpl.class);
    schemas.put("HangupCommandImpl", HangupCommandImpl.class);
    schemas.put("MenuCommandImpl", MenuCommandImpl.class);
    schemas.put("MessagesCommandImpl", MessagesCommandImpl.class);
    schemas.put("PauseCommandImpl", PauseCommandImpl.class);
    schemas.put("StartRecordingCommandImpl", StartRecordingCommandImpl.class);
    schemas.put("StopMessagesCommandImpl", StopMessagesCommandImpl.class);
    schemas.put("StopRecordingCommandImpl", StopRecordingCommandImpl.class);
    schemas.put("CustomEventCommandImpl", CustomEventCommandImpl.class);
    JSONNavigator.registerDescendants(
        SvamlCommandInternalImpl.class, Collections.unmodifiableMap(schemas));
    // Initialize and register the discriminator mappings.
    mappings.put("amd", AmdCommandImpl.class);
    mappings.put("answer", AnswerCommandImpl.class);
    mappings.put("bridgeCall", BridgeCallCommandImpl.class);
    mappings.put("dial", DialCommandImpl.class);
    mappings.put("gotoMenu", GotoMenuCommandImpl.class);
    mappings.put("hangup", HangupCommandImpl.class);
    mappings.put("menu", MenuCommandImpl.class);
    mappings.put("messages", MessagesCommandImpl.class);
    mappings.put("pause", PauseCommandImpl.class);
    mappings.put("startRecording", StartRecordingCommandImpl.class);
    mappings.put("stopMessages", StopMessagesCommandImpl.class);
    mappings.put("stopRecording", StopRecordingCommandImpl.class);
    mappings.put("webhook", CustomEventCommandImpl.class);
    JSONNavigator.registerDiscriminator(SvamlCommandInternalImpl.class, "command", mappings);
  }

  @Override
  public Map<String, Class<?>> getSchemas() {
    return SvamlCommandInternalImpl.schemas;
  }

  /**
   * Set the instance that matches the oneOf child schema, check the instance parameter is valid
   * against the oneOf child schemas: AmdCommandImpl, AnswerCommandImpl, BridgeCallCommandImpl,
   * DialCommandImpl, GotoMenuCommandImpl, HangupCommandImpl, MenuCommandImpl, MessagesCommandImpl,
   * PauseCommandImpl, StartRecordingCommandImpl, StopMessagesCommandImpl, StopRecordingCommandImpl,
   * CustomEventCommandImpl
   */
  @Override
  public void setActualInstance(Object instance) {
    for (Class<?> schema : schemas.values()) {
      if (JSONNavigator.isInstanceOf(schema, instance, new HashSet<Class<?>>())) {
        super.setActualInstance(instance);
        return;
      }
    }
    throw new RuntimeException(
        "Invalid instance type. Must be AmdCommandImpl, AnswerCommandImpl, BridgeCallCommandImpl,"
            + " DialCommandImpl, GotoMenuCommandImpl, HangupCommandImpl, MenuCommandImpl,"
            + " MessagesCommandImpl, PauseCommandImpl, StartRecordingCommandImpl,"
            + " StopMessagesCommandImpl, StopRecordingCommandImpl, CustomEventCommandImpl");
  }

  /**
   * Get the actual instance, which can be the following: AmdCommandImpl, AnswerCommandImpl,
   * BridgeCallCommandImpl, DialCommandImpl, GotoMenuCommandImpl, HangupCommandImpl,
   * MenuCommandImpl, MessagesCommandImpl, PauseCommandImpl, StartRecordingCommandImpl,
   * StopMessagesCommandImpl, StopRecordingCommandImpl, CustomEventCommandImpl
   *
   * @return The actual instance
   */
  @Override
  public Object getActualInstance() {
    return super.getActualInstance();
  }

  public static class Deserializer
      extends StdDeserializer<com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand> vc) {
      super(vc);
    }

    @Override
    public com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException {

      Object deserialized = jp.readValueAs(SvamlCommandInternalImpl.class).getActualInstance();
      if (null == deserialized) {
        return null;
      }
      if (!(deserialized instanceof com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand)) {
        log.log(Level.SEVERE, "Input data does not match schema ", deserialized);
        return null;
      }

      return (com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand) deserialized;
    }
  }
}
