package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({AnswerCommandImpl.JSON_PROPERTY_COMMAND})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AnswerCommandImpl implements AnswerCommand, SvamlCommand {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_COMMAND = "command";

  private OptionalValue<CommandEnum> command;

  public AnswerCommandImpl() {}

  protected AnswerCommandImpl(OptionalValue<CommandEnum> command) {
    this.command = command;
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

  /** Return true if this AnswerCommand object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnswerCommandImpl answerCommand = (AnswerCommandImpl) o;
    return Objects.equals(this.command, answerCommand.command);
  }

  @Override
  public int hashCode() {
    return Objects.hash(command);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnswerCommandImpl {\n");
    sb.append("    command: ").append(toIndentedString(command)).append("\n");
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
  static class Builder implements AnswerCommand.Builder {
    OptionalValue<CommandEnum> command = OptionalValue.of(CommandEnum.ANSWER);

    @JsonProperty(value = JSON_PROPERTY_COMMAND, required = true)
    Builder setCommand(CommandEnum command) {
      if (!Objects.equals(command, CommandEnum.ANSWER)) {
        throw new IllegalArgumentException(
            String.format("'command' must be '%s' (is '%s')", CommandEnum.ANSWER, command));
      }
      return this;
    }

    public AnswerCommand build() {
      return new AnswerCommandImpl(command);
    }
  }
}
