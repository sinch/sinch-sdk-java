package com.sinch.sdk.domains.conversation.models.v1.messages.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({ChoiceResponseMessageImpl.JSON_PROPERTY_CHOICE_RESPONSE_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ChoiceResponseMessageImpl implements ChoiceResponseMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CHOICE_RESPONSE_MESSAGE = "choice_response_message";

  private OptionalValue<ChoiceResponseMessageChoiceResponseMessage> choiceResponseMessage;

  public ChoiceResponseMessageImpl() {}

  protected ChoiceResponseMessageImpl(
      OptionalValue<ChoiceResponseMessageChoiceResponseMessage> choiceResponseMessage) {
    this.choiceResponseMessage = choiceResponseMessage;
  }

  @JsonIgnore
  public ChoiceResponseMessageChoiceResponseMessage getChoiceResponseMessage() {
    return choiceResponseMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHOICE_RESPONSE_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ChoiceResponseMessageChoiceResponseMessage> choiceResponseMessage() {
    return choiceResponseMessage;
  }

  /** Return true if this ChoiceResponseMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChoiceResponseMessageImpl choiceResponseMessage = (ChoiceResponseMessageImpl) o;
    return Objects.equals(this.choiceResponseMessage, choiceResponseMessage.choiceResponseMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(choiceResponseMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChoiceResponseMessageImpl {\n");
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
  static class Builder implements ChoiceResponseMessage.Builder {
    OptionalValue<ChoiceResponseMessageChoiceResponseMessage> choiceResponseMessage =
        OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CHOICE_RESPONSE_MESSAGE)
    public Builder setChoiceResponseMessage(
        ChoiceResponseMessageChoiceResponseMessage choiceResponseMessage) {
      this.choiceResponseMessage = OptionalValue.of(choiceResponseMessage);
      return this;
    }

    public ChoiceResponseMessage build() {
      return new ChoiceResponseMessageImpl(choiceResponseMessage);
    }
  }
}
