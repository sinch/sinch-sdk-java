package com.sinch.sdk.domains.conversation.models.v1.messages.types.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.Choice;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  ChoiceMessageInternalImpl.JSON_PROPERTY_CHOICES,
  ChoiceMessageInternalImpl.JSON_PROPERTY_TEXT_MESSAGE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ChoiceMessageInternalImpl implements ChoiceMessageInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CHOICES = "choices";

  private OptionalValue<List<Choice<?>>> choices;

  public static final String JSON_PROPERTY_TEXT_MESSAGE = "text_message";

  private OptionalValue<TextMessage> textMessage;

  public ChoiceMessageInternalImpl() {}

  protected ChoiceMessageInternalImpl(
      OptionalValue<List<Choice<?>>> choices, OptionalValue<TextMessage> textMessage) {
    this.choices = choices;
    this.textMessage = textMessage;
  }

  @JsonIgnore
  public List<Choice<?>> getChoices() {
    return choices.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHOICES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<Choice<?>>> choices() {
    return choices;
  }

  @JsonIgnore
  public TextMessage getTextMessage() {
    return textMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEXT_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TextMessage> textMessage() {
    return textMessage;
  }

  /** Return true if this Choice_Message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChoiceMessageInternalImpl choiceMessage = (ChoiceMessageInternalImpl) o;
    return Objects.equals(this.choices, choiceMessage.choices)
        && Objects.equals(this.textMessage, choiceMessage.textMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(choices, textMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChoiceMessageInternalImpl {\n");
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
  static class Builder implements ChoiceMessageInternal.Builder {
    OptionalValue<List<Choice<?>>> choices = OptionalValue.empty();
    OptionalValue<TextMessage> textMessage = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_CHOICES, required = true)
    public Builder setChoices(List<Choice<?>> choices) {
      this.choices = OptionalValue.of(choices);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TEXT_MESSAGE)
    public Builder setTextMessage(TextMessage textMessage) {
      this.textMessage = OptionalValue.of(textMessage);
      return this;
    }

    public ChoiceMessageInternal build() {
      return new ChoiceMessageInternalImpl(choices, textMessage);
    }
  }
}
