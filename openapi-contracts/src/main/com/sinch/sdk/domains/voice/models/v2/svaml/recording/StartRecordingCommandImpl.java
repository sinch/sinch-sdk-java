package com.sinch.sdk.domains.voice.models.v2.svaml.recording;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import java.util.Arrays;
import java.util.Objects;

@JsonPropertyOrder({
  StartRecordingCommandImpl.JSON_PROPERTY_COMMAND,
  StartRecordingCommandImpl.JSON_PROPERTY_RECORDING_NAME,
  StartRecordingCommandImpl.JSON_PROPERTY_RECORDING_OPTIONS,
  StartRecordingCommandImpl.JSON_PROPERTY_EVENTS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StartRecordingCommandImpl implements StartRecordingCommand, SvamlCommand {
  private static final long serialVersionUID = 1L;

  /** The command property. Must have the value <code>startRecording</code>. */
  public static class CommandEnum extends EnumDynamic<String, CommandEnum> {
    /** The <code>startRecording</code> command. */
    public static final CommandEnum START_RECORDING = new CommandEnum("startRecording");

    private static final EnumSupportDynamic<String, CommandEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            CommandEnum.class, CommandEnum::new, Arrays.asList(START_RECORDING));

    private CommandEnum(String value) {
      super(value);
    }

    public static java.util.stream.Stream<CommandEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static CommandEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(CommandEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  public static final String JSON_PROPERTY_COMMAND = "command";

  private OptionalValue<CommandEnum> command;

  public static final String JSON_PROPERTY_RECORDING_NAME = "recordingName";

  private OptionalValue<String> recordingName;

  public static final String JSON_PROPERTY_RECORDING_OPTIONS = "recordingOptions";

  private OptionalValue<RecordingOptions> recordingOptions;

  public static final String JSON_PROPERTY_EVENTS = "events";

  private OptionalValue<RecordingEvents> events;

  public StartRecordingCommandImpl() {}

  protected StartRecordingCommandImpl(
      OptionalValue<CommandEnum> command,
      OptionalValue<String> recordingName,
      OptionalValue<RecordingOptions> recordingOptions,
      OptionalValue<RecordingEvents> events) {
    this.command = command;
    this.recordingName = recordingName;
    this.recordingOptions = recordingOptions;
    this.events = events;
  }

  @JsonIgnore
  public CommandEnum getCommand() {
    return command.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COMMAND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<CommandEnum> command() {
    return command;
  }

  @JsonIgnore
  public String getRecordingName() {
    return recordingName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RECORDING_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> recordingName() {
    return recordingName;
  }

  @JsonIgnore
  public RecordingOptions getRecordingOptions() {
    return recordingOptions.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RECORDING_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<RecordingOptions> recordingOptions() {
    return recordingOptions;
  }

  @JsonIgnore
  public RecordingEvents getEvents() {
    return events.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EVENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<RecordingEvents> events() {
    return events;
  }

  /** Return true if this StartRecordingCommand object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartRecordingCommandImpl startRecordingCommand = (StartRecordingCommandImpl) o;
    return Objects.equals(this.command, startRecordingCommand.command)
        && Objects.equals(this.recordingName, startRecordingCommand.recordingName)
        && Objects.equals(this.recordingOptions, startRecordingCommand.recordingOptions)
        && Objects.equals(this.events, startRecordingCommand.events);
  }

  @Override
  public int hashCode() {
    return Objects.hash(command, recordingName, recordingOptions, events);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartRecordingCommandImpl {\n");
    sb.append("    command: ").append(toIndentedString(command)).append("\n");
    sb.append("    recordingName: ").append(toIndentedString(recordingName)).append("\n");
    sb.append("    recordingOptions: ").append(toIndentedString(recordingOptions)).append("\n");
    sb.append("    events: ").append(toIndentedString(events)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements StartRecordingCommand.Builder {
    OptionalValue<CommandEnum> command = OptionalValue.of(CommandEnum.START_RECORDING);
    OptionalValue<String> recordingName = OptionalValue.empty();
    OptionalValue<RecordingOptions> recordingOptions = OptionalValue.empty();
    OptionalValue<RecordingEvents> events = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_COMMAND, required = true)
    Builder setCommand(CommandEnum command) {
      if (!Objects.equals(command, CommandEnum.START_RECORDING)) {
        throw new IllegalArgumentException(
            String.format(
                "'command' must be '%s' (is '%s')", CommandEnum.START_RECORDING, command));
      }
      return this;
    }

    @JsonProperty(JSON_PROPERTY_RECORDING_NAME)
    public Builder setRecordingName(String recordingName) {
      this.recordingName = OptionalValue.of(recordingName);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_RECORDING_OPTIONS, required = true)
    public Builder setRecordingOptions(RecordingOptions recordingOptions) {
      this.recordingOptions = OptionalValue.of(recordingOptions);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_EVENTS)
    public Builder setEvents(RecordingEvents events) {
      this.events = OptionalValue.of(events);
      return this;
    }

    public StartRecordingCommand build() {
      return new StartRecordingCommandImpl(command, recordingName, recordingOptions, events);
    }
  }
}
