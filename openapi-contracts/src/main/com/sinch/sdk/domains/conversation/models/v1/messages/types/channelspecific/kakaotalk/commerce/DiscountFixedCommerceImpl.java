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
  DiscountFixedCommerceImpl.JSON_PROPERTY_TYPE,
  DiscountFixedCommerceImpl.JSON_PROPERTY_TITLE,
  DiscountFixedCommerceImpl.JSON_PROPERTY_REGULAR_PRICE,
  DiscountFixedCommerceImpl.JSON_PROPERTY_DISCOUNT_PRICE,
  DiscountFixedCommerceImpl.JSON_PROPERTY_DISCOUNT_FIXED
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class DiscountFixedCommerceImpl
    implements DiscountFixedCommerce,
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

  public static final String JSON_PROPERTY_DISCOUNT_FIXED = "discount_fixed";

  private OptionalValue<Integer> discountFixed;

  public DiscountFixedCommerceImpl() {}

  protected DiscountFixedCommerceImpl(
      OptionalValue<TypeEnum> type,
      OptionalValue<String> title,
      OptionalValue<Integer> regularPrice,
      OptionalValue<Integer> discountPrice,
      OptionalValue<Integer> discountFixed) {
    this.type = type;
    this.title = title;
    this.regularPrice = regularPrice;
    this.discountPrice = discountPrice;
    this.discountFixed = discountFixed;
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
  public Integer getDiscountFixed() {
    return discountFixed.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DISCOUNT_FIXED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Integer> discountFixed() {
    return discountFixed;
  }

  /** Return true if this KakaoTalkDiscountFixedCommerce object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DiscountFixedCommerceImpl kakaoTalkDiscountFixedCommerce = (DiscountFixedCommerceImpl) o;
    return Objects.equals(this.type, kakaoTalkDiscountFixedCommerce.type)
        && Objects.equals(this.title, kakaoTalkDiscountFixedCommerce.title)
        && Objects.equals(this.regularPrice, kakaoTalkDiscountFixedCommerce.regularPrice)
        && Objects.equals(this.discountPrice, kakaoTalkDiscountFixedCommerce.discountPrice)
        && Objects.equals(this.discountFixed, kakaoTalkDiscountFixedCommerce.discountFixed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, title, regularPrice, discountPrice, discountFixed);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DiscountFixedCommerceImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    regularPrice: ").append(toIndentedString(regularPrice)).append("\n");
    sb.append("    discountPrice: ").append(toIndentedString(discountPrice)).append("\n");
    sb.append("    discountFixed: ").append(toIndentedString(discountFixed)).append("\n");
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
  static class Builder implements DiscountFixedCommerce.Builder {
    OptionalValue<TypeEnum> type = OptionalValue.of(TypeEnum.FIXED_DISCOUNT_COMMERCE);
    OptionalValue<String> title = OptionalValue.empty();
    OptionalValue<Integer> regularPrice = OptionalValue.empty();
    OptionalValue<Integer> discountPrice = OptionalValue.empty();
    OptionalValue<Integer> discountFixed = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TYPE, required = true)
    Builder setType(TypeEnum type) {
      if (!Objects.equals(type, TypeEnum.FIXED_DISCOUNT_COMMERCE)) {
        throw new IllegalArgumentException(
            String.format("'type' must be '%s' (is '%s')", TypeEnum.FIXED_DISCOUNT_COMMERCE, type));
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

    @JsonProperty(value = JSON_PROPERTY_DISCOUNT_FIXED, required = true)
    public Builder setDiscountFixed(Integer discountFixed) {
      this.discountFixed = OptionalValue.of(discountFixed);
      return this;
    }

    public DiscountFixedCommerce build() {
      return new DiscountFixedCommerceImpl(type, title, regularPrice, discountPrice, discountFixed);
    }
  }
}
