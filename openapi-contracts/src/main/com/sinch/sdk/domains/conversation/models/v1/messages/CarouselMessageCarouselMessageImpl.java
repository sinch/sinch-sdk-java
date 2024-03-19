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
  CarouselMessageCarouselMessageImpl.JSON_PROPERTY_CARDS,
  CarouselMessageCarouselMessageImpl.JSON_PROPERTY_CHOICES
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CarouselMessageCarouselMessageImpl implements CarouselMessageCarouselMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CARDS = "cards";

  private OptionalValue<List<CardMessage>> cards;

  public static final String JSON_PROPERTY_CHOICES = "choices";

  private OptionalValue<List<Choice>> choices;

  public CarouselMessageCarouselMessageImpl() {}

  protected CarouselMessageCarouselMessageImpl(
      OptionalValue<List<CardMessage>> cards, OptionalValue<List<Choice>> choices) {
    this.cards = cards;
    this.choices = choices;
  }

  @JsonIgnore
  public List<CardMessage> getCards() {
    return cards.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CARDS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<CardMessage>> cards() {
    return cards;
  }

  @JsonIgnore
  public List<Choice> getChoices() {
    return choices.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHOICES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<Choice>> choices() {
    return choices;
  }

  /** Return true if this CarouselMessage_carousel_message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarouselMessageCarouselMessageImpl carouselMessageCarouselMessage =
        (CarouselMessageCarouselMessageImpl) o;
    return Objects.equals(this.cards, carouselMessageCarouselMessage.cards)
        && Objects.equals(this.choices, carouselMessageCarouselMessage.choices);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cards, choices);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CarouselMessageCarouselMessageImpl {\n");
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

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements CarouselMessageCarouselMessage.Builder {
    OptionalValue<List<CardMessage>> cards = OptionalValue.empty();
    OptionalValue<List<Choice>> choices = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CARDS)
    public Builder setCards(List<CardMessage> cards) {
      this.cards = OptionalValue.of(cards);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CHOICES)
    public Builder setChoices(List<Choice> choices) {
      this.choices = OptionalValue.of(choices);
      return this;
    }

    public CarouselMessageCarouselMessage build() {
      return new CarouselMessageCarouselMessageImpl(cards, choices);
    }
  }
}
