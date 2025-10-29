package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.carousel;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  KakaoTalkCarouselCommerceChannelSpecificMessageImpl.JSON_PROPERTY_PUSH_ALARM,
  KakaoTalkCarouselCommerceChannelSpecificMessageImpl.JSON_PROPERTY_ADULT,
  KakaoTalkCarouselCommerceChannelSpecificMessageImpl.JSON_PROPERTY_CAROUSEL
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class KakaoTalkCarouselCommerceChannelSpecificMessageImpl
    implements KakaoTalkCarouselCommerceChannelSpecificMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PUSH_ALARM = "push_alarm";

  private OptionalValue<Boolean> pushAlarm;

  public static final String JSON_PROPERTY_ADULT = "adult";

  private OptionalValue<Boolean> adult;

  public static final String JSON_PROPERTY_CAROUSEL = "carousel";

  private OptionalValue<Carousel> carousel;

  public KakaoTalkCarouselCommerceChannelSpecificMessageImpl() {}

  protected KakaoTalkCarouselCommerceChannelSpecificMessageImpl(
      OptionalValue<Boolean> pushAlarm,
      OptionalValue<Boolean> adult,
      OptionalValue<Carousel> carousel) {
    this.pushAlarm = pushAlarm;
    this.adult = adult;
    this.carousel = carousel;
  }

  @JsonIgnore
  public Boolean getPushAlarm() {
    return pushAlarm.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PUSH_ALARM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> pushAlarm() {
    return pushAlarm;
  }

  @JsonIgnore
  public Boolean getAdult() {
    return adult.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ADULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> adult() {
    return adult;
  }

  @JsonIgnore
  public Carousel getCarousel() {
    return carousel.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CAROUSEL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Carousel> carousel() {
    return carousel;
  }

  /** Return true if this KakaoTalkCarouselCommerceChannelSpecificMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KakaoTalkCarouselCommerceChannelSpecificMessageImpl
        kakaoTalkCarouselCommerceChannelSpecificMessage =
            (KakaoTalkCarouselCommerceChannelSpecificMessageImpl) o;
    return Objects.equals(this.pushAlarm, kakaoTalkCarouselCommerceChannelSpecificMessage.pushAlarm)
        && Objects.equals(this.adult, kakaoTalkCarouselCommerceChannelSpecificMessage.adult)
        && Objects.equals(this.carousel, kakaoTalkCarouselCommerceChannelSpecificMessage.carousel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pushAlarm, adult, carousel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KakaoTalkCarouselCommerceChannelSpecificMessageImpl {\n");
    sb.append("    pushAlarm: ").append(toIndentedString(pushAlarm)).append("\n");
    sb.append("    adult: ").append(toIndentedString(adult)).append("\n");
    sb.append("    carousel: ").append(toIndentedString(carousel)).append("\n");
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
  static class Builder implements KakaoTalkCarouselCommerceChannelSpecificMessage.Builder {
    OptionalValue<Boolean> pushAlarm = OptionalValue.empty();
    OptionalValue<Boolean> adult = OptionalValue.empty();
    OptionalValue<Carousel> carousel = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_PUSH_ALARM)
    public Builder setPushAlarm(Boolean pushAlarm) {
      this.pushAlarm = OptionalValue.of(pushAlarm);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ADULT)
    public Builder setAdult(Boolean adult) {
      this.adult = OptionalValue.of(adult);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_CAROUSEL, required = true)
    public Builder setCarousel(Carousel carousel) {
      this.carousel = OptionalValue.of(carousel);
      return this;
    }

    public KakaoTalkCarouselCommerceChannelSpecificMessage build() {
      return new KakaoTalkCarouselCommerceChannelSpecificMessageImpl(pushAlarm, adult, carousel);
    }
  }
}
