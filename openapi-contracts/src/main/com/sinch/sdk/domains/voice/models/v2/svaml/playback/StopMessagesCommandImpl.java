package com.sinch.sdk.domains.voice.models.v2.svaml.playback;

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
  StopMessagesCommandImpl.JSON_PROPERTY_COMMAND,
  StopMessagesCommandImpl.JSON_PROPERTY_MESSAGES_NAME
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StopMessagesCommandImpl implements StopMessagesCommand, SvamlCommand {
  private static final long serialVersionUID = 1L;

  /** The command property. Must have the value <code>stopMessages</code>. */
  public static class CommandEnum extends EnumDynamic<String, CommandEnum> {
    /** The <code>stopMessages</code> command. */
    public static final CommandEnum STOP_MESSAGES = new CommandEnum("stopMessages");

    private static final EnumSupportDynamic<String, CommandEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(CommandEnum.class, CommandEnum::new, Arrays.asList(STOP_MESSAGES));

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

  public static final String JSON_PROPERTY_MESSAGES_NAME = "messagesName";

  private OptionalValue<String> messagesName;

  public StopMessagesCommandImpl() {}

  protected StopMessagesCommandImpl(
      OptionalValue<CommandEnum> command, OptionalValue<String> messagesName) {
    this.command = command;
    this.messagesName = messagesName;
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
  public String getMessagesName() {
    return messagesName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGES_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> messagesName() {
    return messagesName;
  }

  /** Return true if this StopMessagesCommand object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StopMessagesCommandImpl stopMessagesCommand = (StopMessagesCommandImpl) o;
    return Objects.equals(this.command, stopMessagesCommand.command)
        && Objects.equals(this.messagesName, stopMessagesCommand.messagesName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(command, messagesName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StopMessagesCommandImpl {\n");
    sb.append("    command: ").append(toIndentedString(command)).append("\n");
    sb.append("    messagesName: ").append(toIndentedString(messagesName)).append("\n");
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
  static class Builder implements StopMessagesCommand.Builder {
    OptionalValue<CommandEnum> command = OptionalValue.of(CommandEnum.STOP_MESSAGES);
    OptionalValue<String> messagesName = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_COMMAND, required = true)
    Builder setCommand(CommandEnum command) {
      if (!Objects.equals(command, CommandEnum.STOP_MESSAGES)) {
        throw new IllegalArgumentException(
            String.format("'command' must be '%s' (is '%s')", CommandEnum.STOP_MESSAGES, command));
      }
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_MESSAGES_NAME, required = true)
    public Builder setMessagesName(String messagesName) {
      this.messagesName = OptionalValue.of(messagesName);
      return this;
    }

    public StopMessagesCommand build() {
      return new StopMessagesCommandImpl(command, messagesName);
    }
  }
}
