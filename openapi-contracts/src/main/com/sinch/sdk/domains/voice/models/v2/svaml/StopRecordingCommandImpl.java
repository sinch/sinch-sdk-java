package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  StopRecordingCommandImpl.JSON_PROPERTY_COMMAND,
  StopRecordingCommandImpl.JSON_PROPERTY_RECORDING_NAME
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StopRecordingCommandImpl implements StopRecordingCommand, SvamlCommand {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_COMMAND = "command";

  private OptionalValue<CommandEnum> command;

  public static final String JSON_PROPERTY_RECORDING_NAME = "recordingName";

  private OptionalValue<String> recordingName;

  public StopRecordingCommandImpl() {}

  protected StopRecordingCommandImpl(
      OptionalValue<CommandEnum> command, OptionalValue<String> recordingName) {
    this.command = command;
    this.recordingName = recordingName;
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
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> recordingName() {
    return recordingName;
  }

  /** Return true if this StopRecordingCommand object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StopRecordingCommandImpl stopRecordingCommand = (StopRecordingCommandImpl) o;
    return Objects.equals(this.command, stopRecordingCommand.command)
        && Objects.equals(this.recordingName, stopRecordingCommand.recordingName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(command, recordingName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StopRecordingCommandImpl {\n");
    sb.append("    command: ").append(toIndentedString(command)).append("\n");
    sb.append("    recordingName: ").append(toIndentedString(recordingName)).append("\n");
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
  static class Builder implements StopRecordingCommand.Builder {
    OptionalValue<CommandEnum> command = OptionalValue.of(CommandEnum.STOP_RECORDING);
    OptionalValue<String> recordingName = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_COMMAND, required = true)
    Builder setCommand(CommandEnum command) {
      if (!Objects.equals(command, CommandEnum.STOP_RECORDING)) {
        throw new IllegalArgumentException(
            String.format("'command' must be '%s' (is '%s')", CommandEnum.STOP_RECORDING, command));
      }
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_RECORDING_NAME, required = true)
    public Builder setRecordingName(String recordingName) {
      this.recordingName = OptionalValue.of(recordingName);
      return this;
    }

    public StopRecordingCommand build() {
      return new StopRecordingCommandImpl(command, recordingName);
    }
  }
}
