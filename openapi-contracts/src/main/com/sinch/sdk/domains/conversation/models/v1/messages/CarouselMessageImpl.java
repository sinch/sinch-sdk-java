package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({CarouselMessageImpl.JSON_PROPERTY_CAROUSEL_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CarouselMessageImpl implements CarouselMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CAROUSEL_MESSAGE = "carousel_message";

  private OptionalValue<CarouselMessageCarouselMessage> carouselMessage;

  public CarouselMessageImpl() {}

  protected CarouselMessageImpl(OptionalValue<CarouselMessageCarouselMessage> carouselMessage) {
    this.carouselMessage = carouselMessage;
  }

  @JsonIgnore
  public CarouselMessageCarouselMessage getCarouselMessage() {
    return carouselMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CAROUSEL_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CarouselMessageCarouselMessage> carouselMessage() {
    return carouselMessage;
  }

  /** Return true if this CarouselMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarouselMessageImpl carouselMessage = (CarouselMessageImpl) o;
    return Objects.equals(this.carouselMessage, carouselMessage.carouselMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(carouselMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CarouselMessageImpl {\n");
    sb.append("    carouselMessage: ").append(toIndentedString(carouselMessage)).append("\n");
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
  static class Builder implements CarouselMessage.Builder {
    OptionalValue<CarouselMessageCarouselMessage> carouselMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CAROUSEL_MESSAGE)
    public Builder setCarouselMessage(CarouselMessageCarouselMessage carouselMessage) {
      this.carouselMessage = OptionalValue.of(carouselMessage);
      return this;
    }

    public CarouselMessage build() {
      return new CarouselMessageImpl(carouselMessage);
    }
  }
}
