package com.sinch.sdk.domains.conversation.models.v1.messages.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceResponseMessage;
import java.util.Objects;

@JsonPropertyOrder({ChoiceResponseMessageFieldInternalImpl.JSON_PROPERTY_CHOICE_RESPONSE_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ChoiceResponseMessageFieldInternalImpl implements ChoiceResponseMessageFieldInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CHOICE_RESPONSE_MESSAGE = "choice_response_message";

  private OptionalValue<ChoiceResponseMessage> choiceResponseMessage;

  public ChoiceResponseMessageFieldInternalImpl() {}

  protected ChoiceResponseMessageFieldInternalImpl(
      OptionalValue<ChoiceResponseMessage> choiceResponseMessage) {
    this.choiceResponseMessage = choiceResponseMessage;
  }

  @JsonIgnore
  public ChoiceResponseMessage getChoiceResponseMessage() {
    return choiceResponseMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHOICE_RESPONSE_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ChoiceResponseMessage> choiceResponseMessage() {
    return choiceResponseMessage;
  }

  /** Return true if this ChoiceResponseMessageField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChoiceResponseMessageFieldInternalImpl choiceResponseMessageField =
        (ChoiceResponseMessageFieldInternalImpl) o;
    return Objects.equals(
        this.choiceResponseMessage, choiceResponseMessageField.choiceResponseMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(choiceResponseMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChoiceResponseMessageFieldInternalImpl {\n");
    sb.append("    choiceResponseMessage: ")
        .append(toIndentedString(choiceResponseMessage))
        .append("\n");
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
  static class Builder implements ChoiceResponseMessageFieldInternal.Builder {
    OptionalValue<ChoiceResponseMessage> choiceResponseMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CHOICE_RESPONSE_MESSAGE)
    public Builder setChoiceResponseMessage(ChoiceResponseMessage choiceResponseMessage) {
      this.choiceResponseMessage = OptionalValue.of(choiceResponseMessage);
      return this;
    }

    public ChoiceResponseMessageFieldInternal build() {
      return new ChoiceResponseMessageFieldInternalImpl(choiceResponseMessage);
    }
  }
}
