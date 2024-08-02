package com.sinch.sdk.domains.conversation.models.v1.messages.types.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.carousel.CarouselMessage;
import java.util.Objects;

@JsonPropertyOrder({CarouselMessageFieldInternalImpl.JSON_PROPERTY_CAROUSEL_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CarouselMessageFieldInternalImpl implements CarouselMessageFieldInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CAROUSEL_MESSAGE = "carousel_message";

  private OptionalValue<CarouselMessage> carouselMessage;

  public CarouselMessageFieldInternalImpl() {}

  protected CarouselMessageFieldInternalImpl(OptionalValue<CarouselMessage> carouselMessage) {
    this.carouselMessage = carouselMessage;
  }

  @JsonIgnore
  public CarouselMessage getCarouselMessage() {
    return carouselMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CAROUSEL_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CarouselMessage> carouselMessage() {
    return carouselMessage;
  }

  /** Return true if this CarouselMessageField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarouselMessageFieldInternalImpl carouselMessageField = (CarouselMessageFieldInternalImpl) o;
    return Objects.equals(this.carouselMessage, carouselMessageField.carouselMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(carouselMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CarouselMessageFieldInternalImpl {\n");
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
  static class Builder implements CarouselMessageFieldInternal.Builder {
    OptionalValue<CarouselMessage> carouselMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CAROUSEL_MESSAGE)
    public Builder setCarouselMessage(CarouselMessage carouselMessage) {
      this.carouselMessage = OptionalValue.of(carouselMessage);
      return this;
    }

    public CarouselMessageFieldInternal build() {
      return new CarouselMessageFieldInternalImpl(carouselMessage);
    }
  }
}
