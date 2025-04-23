package com.sinch.sdk.domains.conversation.models.v1.messages.types.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.Choice;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  CarouselMessageInternalImpl.JSON_PROPERTY_CARDS,
  CarouselMessageInternalImpl.JSON_PROPERTY_CHOICES
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CarouselMessageInternalImpl implements CarouselMessageInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CARDS = "cards";

  private OptionalValue<List<CardMessageInternal>> cards;

  public static final String JSON_PROPERTY_CHOICES = "choices";

  private OptionalValue<List<Choice<?>>> choices;

  public CarouselMessageInternalImpl() {}

  protected CarouselMessageInternalImpl(
      OptionalValue<List<CardMessageInternal>> cards, OptionalValue<List<Choice<?>>> choices) {
    this.cards = cards;
    this.choices = choices;
  }

  @JsonIgnore
  public List<CardMessageInternal> getCards() {
    return cards.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CARDS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<CardMessageInternal>> cards() {
    return cards;
  }

  @JsonIgnore
  public List<Choice<?>> getChoices() {
    return choices.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHOICES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
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
    CarouselMessageInternalImpl carouselMessage = (CarouselMessageInternalImpl) o;
    return Objects.equals(this.cards, carouselMessage.cards)
        && Objects.equals(this.choices, carouselMessage.choices);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cards, choices);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CarouselMessageInternalImpl {\n");
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
  static class Builder implements CarouselMessageInternal.Builder {
    OptionalValue<List<CardMessageInternal>> cards = OptionalValue.empty();
    OptionalValue<List<Choice<?>>> choices = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_CARDS, required = true)
    public Builder setCards(List<CardMessageInternal> cards) {
      this.cards = OptionalValue.of(cards);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CHOICES)
    public Builder setChoices(List<Choice<?>> choices) {
      this.choices = OptionalValue.of(choices);
      return this;
    }

    public CarouselMessageInternal build() {
      return new CarouselMessageInternalImpl(cards, choices);
    }
  }
}
