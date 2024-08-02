package com.sinch.sdk.domains.conversation.models.v1.messages.types.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceMessage;
import java.util.Objects;

@JsonPropertyOrder({ChoiceMessageFieldInternalImpl.JSON_PROPERTY_CHOICE_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ChoiceMessageFieldInternalImpl implements ChoiceMessageFieldInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CHOICE_MESSAGE = "choice_message";

  private OptionalValue<ChoiceMessage> choiceMessage;

  public ChoiceMessageFieldInternalImpl() {}

  protected ChoiceMessageFieldInternalImpl(OptionalValue<ChoiceMessage> choiceMessage) {
    this.choiceMessage = choiceMessage;
  }

  @JsonIgnore
  public ChoiceMessage getChoiceMessage() {
    return choiceMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHOICE_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ChoiceMessage> choiceMessage() {
    return choiceMessage;
  }

  /** Return true if this ChoiceMessageField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChoiceMessageFieldInternalImpl choiceMessageField = (ChoiceMessageFieldInternalImpl) o;
    return Objects.equals(this.choiceMessage, choiceMessageField.choiceMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(choiceMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChoiceMessageFieldInternalImpl {\n");
    sb.append("    choiceMessage: ").append(toIndentedString(choiceMessage)).append("\n");
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
  static class Builder implements ChoiceMessageFieldInternal.Builder {
    OptionalValue<ChoiceMessage> choiceMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CHOICE_MESSAGE)
    public Builder setChoiceMessage(ChoiceMessage choiceMessage) {
      this.choiceMessage = OptionalValue.of(choiceMessage);
      return this;
    }

    public ChoiceMessageFieldInternal build() {
      return new ChoiceMessageFieldInternalImpl(choiceMessage);
    }
  }
}
