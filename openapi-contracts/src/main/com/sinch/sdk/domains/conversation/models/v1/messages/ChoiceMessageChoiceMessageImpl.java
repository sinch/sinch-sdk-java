package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  ChoiceMessageChoiceMessageImpl.JSON_PROPERTY_CHOICES,
  ChoiceMessageChoiceMessageImpl.JSON_PROPERTY_TEXT_MESSAGE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ChoiceMessageChoiceMessageImpl implements ChoiceMessageChoiceMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CHOICES = "choices";

  private OptionalValue<List<Choice>> choices;

  public static final String JSON_PROPERTY_TEXT_MESSAGE = "text_message";

  private OptionalValue<TextMessageTextMessage> textMessage;

  public ChoiceMessageChoiceMessageImpl() {}

  protected ChoiceMessageChoiceMessageImpl(
      OptionalValue<List<Choice>> choices, OptionalValue<TextMessageTextMessage> textMessage) {
    this.choices = choices;
    this.textMessage = textMessage;
  }

  @JsonIgnore
  public List<Choice> getChoices() {
    return choices.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHOICES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<Choice>> choices() {
    return choices;
  }

  @JsonIgnore
  public TextMessageTextMessage getTextMessage() {
    return textMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEXT_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TextMessageTextMessage> textMessage() {
    return textMessage;
  }

  /** Return true if this ChoiceMessage_choice_message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChoiceMessageChoiceMessageImpl choiceMessageChoiceMessage = (ChoiceMessageChoiceMessageImpl) o;
    return Objects.equals(this.choices, choiceMessageChoiceMessage.choices)
        && Objects.equals(this.textMessage, choiceMessageChoiceMessage.textMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(choices, textMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChoiceMessageChoiceMessageImpl {\n");
    sb.append("    choices: ").append(toIndentedString(choices)).append("\n");
    sb.append("    textMessage: ").append(toIndentedString(textMessage)).append("\n");
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
  static class Builder implements ChoiceMessageChoiceMessage.Builder {
    OptionalValue<List<Choice>> choices = OptionalValue.empty();
    OptionalValue<TextMessageTextMessage> textMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CHOICES)
    public Builder setChoices(List<Choice> choices) {
      this.choices = OptionalValue.of(choices);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TEXT_MESSAGE)
    public Builder setTextMessage(TextMessageTextMessage textMessage) {
      this.textMessage = OptionalValue.of(textMessage);
      return this;
    }

    public ChoiceMessageChoiceMessage build() {
      return new ChoiceMessageChoiceMessageImpl(choices, textMessage);
    }
  }
}
