package com.sinch.sdk.domains.conversation.models.v1.messages.types.carousel;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessageBody;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.card.CardMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.Choice;
import java.util.List;
import java.util.Objects;

public class CarouselMessageImpl
    implements CarouselMessage,
        com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverride,
        AppMessageBody {

  private final OptionalValue<List<CardMessage>> cards;

  private final OptionalValue<List<Choice<?>>> choices;

  protected CarouselMessageImpl(
      OptionalValue<List<CardMessage>> cards, OptionalValue<List<Choice<?>>> choices) {
    this.cards = cards;
    this.choices = choices;
  }

  public List<CardMessage> getCards() {
    return cards.orElse(null);
  }

  public OptionalValue<List<CardMessage>> cards() {
    return cards;
  }

  public List<Choice<?>> getChoices() {
    return choices.orElse(null);
  }

  public OptionalValue<List<Choice<?>>> choices() {
    return choices;
  }

  /** Return true if this Carousel_Message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarouselMessage carouselMessage = (CarouselMessage) o;
    return Objects.equals(this.cards, carouselMessage.getCards())
        && Objects.equals(this.choices, carouselMessage.getChoices());
  }

  @Override
  public int hashCode() {
    return Objects.hash(cards, choices);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CarouselMessage {\n");
    sb.append("    cards: ").append(toIndentedString(cards)).append("\n");
    sb.append("    choices: ").append(toIndentedString(choices)).append("\n");
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

  static class Builder implements CarouselMessage.Builder {
    OptionalValue<List<CardMessage>> cards = OptionalValue.empty();
    OptionalValue<List<Choice<?>>> choices = OptionalValue.empty();

    public Builder setCards(List<CardMessage> cards) {
      this.cards = OptionalValue.of(cards);
      return this;
    }

    public Builder setChoices(List<Choice<?>> choices) {
      this.choices = OptionalValue.of(choices);
      return this;
    }

    public CarouselMessageImpl build() {
      return new CarouselMessageImpl(cards, choices);
    }
  }
}
