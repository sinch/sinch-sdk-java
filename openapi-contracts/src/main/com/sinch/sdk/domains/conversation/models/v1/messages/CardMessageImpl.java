package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({CardMessageImpl.JSON_PROPERTY_CARD_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CardMessageImpl implements CardMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CARD_MESSAGE = "card_message";

  private OptionalValue<CardMessageCardMessage> cardMessage;

  public CardMessageImpl() {}

  protected CardMessageImpl(OptionalValue<CardMessageCardMessage> cardMessage) {
    this.cardMessage = cardMessage;
  }

  @JsonIgnore
  public CardMessageCardMessage getCardMessage() {
    return cardMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CARD_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CardMessageCardMessage> cardMessage() {
    return cardMessage;
  }

  /** Return true if this CardMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardMessageImpl cardMessage = (CardMessageImpl) o;
    return Objects.equals(this.cardMessage, cardMessage.cardMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardMessageImpl {\n");
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
  static class Builder implements CardMessage.Builder {
    OptionalValue<CardMessageCardMessage> cardMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CARD_MESSAGE)
    public Builder setCardMessage(CardMessageCardMessage cardMessage) {
      this.cardMessage = OptionalValue.of(cardMessage);
      return this;
    }

    public CardMessage build() {
      return new CardMessageImpl(cardMessage);
    }
  }
}
