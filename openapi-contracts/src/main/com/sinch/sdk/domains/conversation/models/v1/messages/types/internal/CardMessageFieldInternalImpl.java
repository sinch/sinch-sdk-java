package com.sinch.sdk.domains.conversation.models.v1.messages.types.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.card.CardMessage;
import java.util.Objects;

@JsonPropertyOrder({CardMessageFieldInternalImpl.JSON_PROPERTY_CARD_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CardMessageFieldInternalImpl implements CardMessageFieldInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CARD_MESSAGE = "card_message";

  private OptionalValue<CardMessage> cardMessage;

  public CardMessageFieldInternalImpl() {}

  protected CardMessageFieldInternalImpl(OptionalValue<CardMessage> cardMessage) {
    this.cardMessage = cardMessage;
  }

  @JsonIgnore
  public CardMessage getCardMessage() {
    return cardMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CARD_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CardMessage> cardMessage() {
    return cardMessage;
  }

  /** Return true if this CardMessageField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardMessageFieldInternalImpl cardMessageField = (CardMessageFieldInternalImpl) o;
    return Objects.equals(this.cardMessage, cardMessageField.cardMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardMessageFieldInternalImpl {\n");
    sb.append("    cardMessage: ").append(toIndentedString(cardMessage)).append("\n");
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
  static class Builder implements CardMessageFieldInternal.Builder {
    OptionalValue<CardMessage> cardMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CARD_MESSAGE)
    public Builder setCardMessage(CardMessage cardMessage) {
      this.cardMessage = OptionalValue.of(cardMessage);
      return this;
    }

    public CardMessageFieldInternal build() {
      return new CardMessageFieldInternalImpl(cardMessage);
    }
  }
}
