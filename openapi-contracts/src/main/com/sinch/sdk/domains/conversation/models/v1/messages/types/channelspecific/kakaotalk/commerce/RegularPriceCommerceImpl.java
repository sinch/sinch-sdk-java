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
  RegularPriceCommerceImpl.JSON_PROPERTY_TYPE,
  RegularPriceCommerceImpl.JSON_PROPERTY_TITLE,
  RegularPriceCommerceImpl.JSON_PROPERTY_REGULAR_PRICE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class RegularPriceCommerceImpl
    implements RegularPriceCommerce,
        com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk
            .commerce.KakaoTalkCommerce {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_TITLE = "title";

  private OptionalValue<String> title;

  public static final String JSON_PROPERTY_REGULAR_PRICE = "regular_price";

  private OptionalValue<Integer> regularPrice;

  public RegularPriceCommerceImpl() {}

  protected RegularPriceCommerceImpl(
      OptionalValue<TypeEnum> type,
      OptionalValue<String> title,
      OptionalValue<Integer> regularPrice) {
    this.type = type;
    this.title = title;
    this.regularPrice = regularPrice;
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

  /** Return true if this KakaoTalkRegularPriceCommerce object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegularPriceCommerceImpl kakaoTalkRegularPriceCommerce = (RegularPriceCommerceImpl) o;
    return Objects.equals(this.type, kakaoTalkRegularPriceCommerce.type)
        && Objects.equals(this.title, kakaoTalkRegularPriceCommerce.title)
        && Objects.equals(this.regularPrice, kakaoTalkRegularPriceCommerce.regularPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, title, regularPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegularPriceCommerceImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    regularPrice: ").append(toIndentedString(regularPrice)).append("\n");
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
  static class Builder implements RegularPriceCommerce.Builder {
    OptionalValue<TypeEnum> type = OptionalValue.of(TypeEnum.REGULAR_PRICE_COMMERCE);
    OptionalValue<String> title = OptionalValue.empty();
    OptionalValue<Integer> regularPrice = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TYPE, required = true)
    Builder setType(TypeEnum type) {
      if (!Objects.equals(type, TypeEnum.REGULAR_PRICE_COMMERCE)) {
        throw new IllegalArgumentException(
            String.format("'type' must be '%s' (is '%s')", TypeEnum.REGULAR_PRICE_COMMERCE, type));
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

    public RegularPriceCommerce build() {
      return new RegularPriceCommerceImpl(type, title, regularPrice);
    }
  }
}
