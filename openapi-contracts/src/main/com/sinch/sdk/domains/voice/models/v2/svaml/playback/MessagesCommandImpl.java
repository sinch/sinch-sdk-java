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
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  MessagesCommandImpl.JSON_PROPERTY_COMMAND,
  MessagesCommandImpl.JSON_PROPERTY_MESSAGES_NAME,
  MessagesCommandImpl.JSON_PROPERTY_MESSAGES,
  MessagesCommandImpl.JSON_PROPERTY_EVENTS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MessagesCommandImpl implements MessagesCommand, SvamlCommand {
  private static final long serialVersionUID = 1L;

  /** The command property. Must have the value <code>messages</code>. */
  public static class CommandEnum extends EnumDynamic<String, CommandEnum> {
    /** The <code>messages</code> command. */
    public static final CommandEnum MESSAGES = new CommandEnum("messages");

    private static final EnumSupportDynamic<String, CommandEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(CommandEnum.class, CommandEnum::new, Arrays.asList(MESSAGES));

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

  public static final String JSON_PROPERTY_MESSAGES = "messages";

  private OptionalValue<List<Message>> messages;

  public static final String JSON_PROPERTY_EVENTS = "events";

  private OptionalValue<MessageEvents> events;

  public MessagesCommandImpl() {}

  protected MessagesCommandImpl(
      OptionalValue<CommandEnum> command,
      OptionalValue<String> messagesName,
      OptionalValue<List<Message>> messages,
      OptionalValue<MessageEvents> events) {
    this.command = command;
    this.messagesName = messagesName;
    this.messages = messages;
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
  public String getMessagesName() {
    return messagesName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGES_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> messagesName() {
    return messagesName;
  }

  @JsonIgnore
  public List<Message> getMessages() {
    return messages.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<Message>> messages() {
    return messages;
  }

  @JsonIgnore
  public MessageEvents getEvents() {
    return events.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EVENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MessageEvents> events() {
    return events;
  }

  /** Return true if this MessagesCommand object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MessagesCommandImpl messagesCommand = (MessagesCommandImpl) o;
    return Objects.equals(this.command, messagesCommand.command)
        && Objects.equals(this.messagesName, messagesCommand.messagesName)
        && Objects.equals(this.messages, messagesCommand.messages)
        && Objects.equals(this.events, messagesCommand.events);
  }

  @Override
  public int hashCode() {
    return Objects.hash(command, messagesName, messages, events);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MessagesCommandImpl {\n");
    sb.append("    command: ").append(toIndentedString(command)).append("\n");
    sb.append("    messagesName: ").append(toIndentedString(messagesName)).append("\n");
    sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
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
  static class Builder implements MessagesCommand.Builder {
    OptionalValue<CommandEnum> command = OptionalValue.of(CommandEnum.MESSAGES);
    OptionalValue<String> messagesName = OptionalValue.empty();
    OptionalValue<List<Message>> messages = OptionalValue.empty();
    OptionalValue<MessageEvents> events = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_COMMAND, required = true)
    Builder setCommand(CommandEnum command) {
      if (!Objects.equals(command, CommandEnum.MESSAGES)) {
        throw new IllegalArgumentException(
            String.format("'command' must be '%s' (is '%s')", CommandEnum.MESSAGES, command));
      }
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGES_NAME)
    public Builder setMessagesName(String messagesName) {
      this.messagesName = OptionalValue.of(messagesName);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_MESSAGES, required = true)
    public Builder setMessages(List<Message> messages) {
      this.messages = OptionalValue.of(messages);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_EVENTS)
    public Builder setEvents(MessageEvents events) {
      this.events = OptionalValue.of(events);
      return this;
    }

    public MessagesCommand build() {
      return new MessagesCommandImpl(command, messagesName, messages, events);
    }
  }
}
