package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.commerce;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.buttons.KakaoTalkButton;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.coupons.KakaoTalkCoupon;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.image.Image;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  KakaoTalkCommerceChannelSpecificMessageImpl.JSON_PROPERTY_PUSH_ALARM,
  KakaoTalkCommerceChannelSpecificMessageImpl.JSON_PROPERTY_ADULT,
  KakaoTalkCommerceChannelSpecificMessageImpl.JSON_PROPERTY_BUTTONS,
  KakaoTalkCommerceChannelSpecificMessageImpl.JSON_PROPERTY_ADDITIONAL_CONTENT,
  KakaoTalkCommerceChannelSpecificMessageImpl.JSON_PROPERTY_IMAGE,
  KakaoTalkCommerceChannelSpecificMessageImpl.JSON_PROPERTY_COMMERCE,
  KakaoTalkCommerceChannelSpecificMessageImpl.JSON_PROPERTY_COUPON
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class KakaoTalkCommerceChannelSpecificMessageImpl
    implements KakaoTalkCommerceChannelSpecificMessage,
        com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific
            .ChannelSpecificMessage,
        com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk
            .commerce.KakaoTalkCommerceMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PUSH_ALARM = "push_alarm";

  private OptionalValue<Boolean> pushAlarm;

  public static final String JSON_PROPERTY_ADULT = "adult";

  private OptionalValue<Boolean> adult;

  public static final String JSON_PROPERTY_BUTTONS = "buttons";

  private OptionalValue<List<KakaoTalkButton>> buttons;

  public static final String JSON_PROPERTY_ADDITIONAL_CONTENT = "additional_content";

  private OptionalValue<String> additionalContent;

  public static final String JSON_PROPERTY_IMAGE = "image";

  private OptionalValue<Image> image;

  public static final String JSON_PROPERTY_COMMERCE = "commerce";

  private OptionalValue<KakaoTalkCommerce> commerce;

  public static final String JSON_PROPERTY_COUPON = "coupon";

  private OptionalValue<KakaoTalkCoupon> coupon;

  public KakaoTalkCommerceChannelSpecificMessageImpl() {}

  protected KakaoTalkCommerceChannelSpecificMessageImpl(
      OptionalValue<Boolean> pushAlarm,
      OptionalValue<Boolean> adult,
      OptionalValue<List<KakaoTalkButton>> buttons,
      OptionalValue<String> additionalContent,
      OptionalValue<Image> image,
      OptionalValue<KakaoTalkCommerce> commerce,
      OptionalValue<KakaoTalkCoupon> coupon) {
    this.pushAlarm = pushAlarm;
    this.adult = adult;
    this.buttons = buttons;
    this.additionalContent = additionalContent;
    this.image = image;
    this.commerce = commerce;
    this.coupon = coupon;
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
  public List<KakaoTalkButton> getButtons() {
    return buttons.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BUTTONS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<KakaoTalkButton>> buttons() {
    return buttons;
  }

  @JsonIgnore
  public String getAdditionalContent() {
    return additionalContent.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ADDITIONAL_CONTENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> additionalContent() {
    return additionalContent;
  }

  @JsonIgnore
  public Image getImage() {
    return image.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IMAGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Image> image() {
    return image;
  }

  @JsonIgnore
  public KakaoTalkCommerce getCommerce() {
    return commerce.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COMMERCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<KakaoTalkCommerce> commerce() {
    return commerce;
  }

  @JsonIgnore
  public KakaoTalkCoupon getCoupon() {
    return coupon.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COUPON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<KakaoTalkCoupon> coupon() {
    return coupon;
  }

  /** Return true if this KakaoTalkCommerceChannelSpecificMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KakaoTalkCommerceChannelSpecificMessageImpl kakaoTalkCommerceChannelSpecificMessage =
        (KakaoTalkCommerceChannelSpecificMessageImpl) o;
    return Objects.equals(this.pushAlarm, kakaoTalkCommerceChannelSpecificMessage.pushAlarm)
        && Objects.equals(this.adult, kakaoTalkCommerceChannelSpecificMessage.adult)
        && Objects.equals(this.buttons, kakaoTalkCommerceChannelSpecificMessage.buttons)
        && Objects.equals(
            this.additionalContent, kakaoTalkCommerceChannelSpecificMessage.additionalContent)
        && Objects.equals(this.image, kakaoTalkCommerceChannelSpecificMessage.image)
        && Objects.equals(this.commerce, kakaoTalkCommerceChannelSpecificMessage.commerce)
        && Objects.equals(this.coupon, kakaoTalkCommerceChannelSpecificMessage.coupon);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pushAlarm, adult, buttons, additionalContent, image, commerce, coupon);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KakaoTalkCommerceChannelSpecificMessageImpl {\n");
    sb.append("    pushAlarm: ").append(toIndentedString(pushAlarm)).append("\n");
    sb.append("    adult: ").append(toIndentedString(adult)).append("\n");
    sb.append("    buttons: ").append(toIndentedString(buttons)).append("\n");
    sb.append("    additionalContent: ").append(toIndentedString(additionalContent)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    commerce: ").append(toIndentedString(commerce)).append("\n");
    sb.append("    coupon: ").append(toIndentedString(coupon)).append("\n");
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
  static class Builder implements KakaoTalkCommerceChannelSpecificMessage.Builder {
    OptionalValue<Boolean> pushAlarm = OptionalValue.empty();
    OptionalValue<Boolean> adult = OptionalValue.empty();
    OptionalValue<List<KakaoTalkButton>> buttons = OptionalValue.empty();
    OptionalValue<String> additionalContent = OptionalValue.empty();
    OptionalValue<Image> image = OptionalValue.empty();
    OptionalValue<KakaoTalkCommerce> commerce = OptionalValue.empty();
    OptionalValue<KakaoTalkCoupon> coupon = OptionalValue.empty();

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

    @JsonProperty(value = JSON_PROPERTY_BUTTONS, required = true)
    public Builder setButtons(List<KakaoTalkButton> buttons) {
      this.buttons = OptionalValue.of(buttons);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ADDITIONAL_CONTENT)
    public Builder setAdditionalContent(String additionalContent) {
      this.additionalContent = OptionalValue.of(additionalContent);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_IMAGE, required = true)
    public Builder setImage(Image image) {
      this.image = OptionalValue.of(image);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_COMMERCE, required = true)
    public Builder setCommerce(KakaoTalkCommerce commerce) {
      this.commerce = OptionalValue.of(commerce);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_COUPON)
    public Builder setCoupon(KakaoTalkCoupon coupon) {
      this.coupon = OptionalValue.of(coupon);
      return this;
    }

    public KakaoTalkCommerceChannelSpecificMessage build() {
      return new KakaoTalkCommerceChannelSpecificMessageImpl(
          pushAlarm, adult, buttons, additionalContent, image, commerce, coupon);
    }
  }
}
