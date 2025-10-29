package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.commerce;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  DiscountRateCommerceImpl.JSON_PROPERTY_TYPE,
  DiscountRateCommerceImpl.JSON_PROPERTY_TITLE,
  DiscountRateCommerceImpl.JSON_PROPERTY_REGULAR_PRICE,
  DiscountRateCommerceImpl.JSON_PROPERTY_DISCOUNT_PRICE,
  DiscountRateCommerceImpl.JSON_PROPERTY_DISCOUNT_RATE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class DiscountRateCommerceImpl
    implements DiscountRateCommerce,
        com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk
            .commerce.KakaoTalkCommerce {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_TITLE = "title";

  private OptionalValue<String> title;

  public static final String JSON_PROPERTY_REGULAR_PRICE = "regular_price";

  private OptionalValue<Integer> regularPrice;

  public static final String JSON_PROPERTY_DISCOUNT_PRICE = "discount_price";

  private OptionalValue<Integer> discountPrice;

  public static final String JSON_PROPERTY_DISCOUNT_RATE = "discount_rate";

  private OptionalValue<Integer> discountRate;

  public DiscountRateCommerceImpl() {}

  protected DiscountRateCommerceImpl(
      OptionalValue<TypeEnum> type,
      OptionalValue<String> title,
      OptionalValue<Integer> regularPrice,
      OptionalValue<Integer> discountPrice,
      OptionalValue<Integer> discountRate) {
    this.type = type;
    this.title = title;
    this.regularPrice = regularPrice;
    this.discountPrice = discountPrice;
    this.discountRate = discountRate;
  }

  @JsonIgnore
  public TypeEnum getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<TypeEnum> type() {
    return type;
  }

  @JsonIgnore
  public String getTitle() {
    return title.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> title() {
    return title;
  }

  @JsonIgnore
  public Integer getRegularPrice() {
    return regularPrice.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REGULAR_PRICE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Integer> regularPrice() {
    return regularPrice;
  }

  @JsonIgnore
  public Integer getDiscountPrice() {
    return discountPrice.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DISCOUNT_PRICE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Integer> discountPrice() {
    return discountPrice;
  }

  @JsonIgnore
  public Integer getDiscountRate() {
    return discountRate.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DISCOUNT_RATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Integer> discountRate() {
    return discountRate;
  }

  /** Return true if this KakaoTalkDiscountRateCommerce object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DiscountRateCommerceImpl kakaoTalkDiscountRateCommerce = (DiscountRateCommerceImpl) o;
    return Objects.equals(this.type, kakaoTalkDiscountRateCommerce.type)
        && Objects.equals(this.title, kakaoTalkDiscountRateCommerce.title)
        && Objects.equals(this.regularPrice, kakaoTalkDiscountRateCommerce.regularPrice)
        && Objects.equals(this.discountPrice, kakaoTalkDiscountRateCommerce.discountPrice)
        && Objects.equals(this.discountRate, kakaoTalkDiscountRateCommerce.discountRate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, title, regularPrice, discountPrice, discountRate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DiscountRateCommerceImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    regularPrice: ").append(toIndentedString(regularPrice)).append("\n");
    sb.append("    discountPrice: ").append(toIndentedString(discountPrice)).append("\n");
    sb.append("    discountRate: ").append(toIndentedString(discountRate)).append("\n");
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
  static class Builder implements DiscountRateCommerce.Builder {
    OptionalValue<TypeEnum> type = OptionalValue.of(TypeEnum.PERCENTAGE_DISCOUNT_COMMERCE);
    OptionalValue<String> title = OptionalValue.empty();
    OptionalValue<Integer> regularPrice = OptionalValue.empty();
    OptionalValue<Integer> discountPrice = OptionalValue.empty();
    OptionalValue<Integer> discountRate = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TYPE, required = true)
    Builder setType(TypeEnum type) {
      if (!Objects.equals(type, TypeEnum.PERCENTAGE_DISCOUNT_COMMERCE)) {
        throw new IllegalArgumentException(
            String.format(
                "'type' must be '%s' (is '%s')", TypeEnum.PERCENTAGE_DISCOUNT_COMMERCE, type));
      }
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_TITLE, required = true)
    public Builder setTitle(String title) {
      this.title = OptionalValue.of(title);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_REGULAR_PRICE, required = true)
    public Builder setRegularPrice(Integer regularPrice) {
      this.regularPrice = OptionalValue.of(regularPrice);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_DISCOUNT_PRICE, required = true)
    public Builder setDiscountPrice(Integer discountPrice) {
      this.discountPrice = OptionalValue.of(discountPrice);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_DISCOUNT_RATE, required = true)
    public Builder setDiscountRate(Integer discountRate) {
      this.discountRate = OptionalValue.of(discountRate);
      return this;
    }

    public DiscountRateCommerce build() {
      return new DiscountRateCommerceImpl(type, title, regularPrice, discountPrice, discountRate);
    }
  }
}
