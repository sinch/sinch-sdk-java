package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({ChoiceMessageImpl.JSON_PROPERTY_CHOICE_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ChoiceMessageImpl implements ChoiceMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CHOICE_MESSAGE = "choice_message";

  private OptionalValue<ChoiceMessageChoiceMessage> choiceMessage;

  public ChoiceMessageImpl() {}

  protected ChoiceMessageImpl(OptionalValue<ChoiceMessageChoiceMessage> choiceMessage) {
    this.choiceMessage = choiceMessage;
  }

  @JsonIgnore
  public ChoiceMessageChoiceMessage getChoiceMessage() {
    return choiceMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHOICE_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ChoiceMessageChoiceMessage> choiceMessage() {
    return choiceMessage;
  }

  /** Return true if this ChoiceMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChoiceMessageImpl choiceMessage = (ChoiceMessageImpl) o;
    return Objects.equals(this.choiceMessage, choiceMessage.choiceMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(choiceMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChoiceMessageImpl {\n");
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
  static class Builder implements ChoiceMessage.Builder {
    OptionalValue<ChoiceMessageChoiceMessage> choiceMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CHOICE_MESSAGE)
    public Builder setChoiceMessage(ChoiceMessageChoiceMessage choiceMessage) {
      this.choiceMessage = OptionalValue.of(choiceMessage);
      return this;
    }

    public ChoiceMessage build() {
      return new ChoiceMessageImpl(choiceMessage);
    }
  }
}
