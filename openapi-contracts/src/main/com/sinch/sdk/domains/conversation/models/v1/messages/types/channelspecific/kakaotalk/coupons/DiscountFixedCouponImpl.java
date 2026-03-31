package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.coupons;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  DiscountFixedCouponImpl.JSON_PROPERTY_TYPE,
  DiscountFixedCouponImpl.JSON_PROPERTY_DESCRIPTION,
  DiscountFixedCouponImpl.JSON_PROPERTY_LINK_MO,
  DiscountFixedCouponImpl.JSON_PROPERTY_LINK_PC,
  DiscountFixedCouponImpl.JSON_PROPERTY_SCHEME_ANDROID,
  DiscountFixedCouponImpl.JSON_PROPERTY_SCHEME_IOS,
  DiscountFixedCouponImpl.JSON_PROPERTY_DISCOUNT_FIXED
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class DiscountFixedCouponImpl
    implements DiscountFixedCoupon,
        com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk
            .coupons.KakaoTalkCoupon {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";

  private OptionalValue<String> description;

  public static final String JSON_PROPERTY_LINK_MO = "link_mo";

  private OptionalValue<String> linkMo;

  public static final String JSON_PROPERTY_LINK_PC = "link_pc";

  private OptionalValue<String> linkPc;

  public static final String JSON_PROPERTY_SCHEME_ANDROID = "scheme_android";

  private OptionalValue<String> schemeAndroid;

  public static final String JSON_PROPERTY_SCHEME_IOS = "scheme_ios";

  private OptionalValue<String> schemeIos;

  public static final String JSON_PROPERTY_DISCOUNT_FIXED = "discount_fixed";

  private OptionalValue<Integer> discountFixed;

  public DiscountFixedCouponImpl() {}

  protected DiscountFixedCouponImpl(
      OptionalValue<TypeEnum> type,
      OptionalValue<String> description,
      OptionalValue<String> linkMo,
      OptionalValue<String> linkPc,
      OptionalValue<String> schemeAndroid,
      OptionalValue<String> schemeIos,
      OptionalValue<Integer> discountFixed) {
    this.type = type;
    this.description = description;
    this.linkMo = linkMo;
    this.linkPc = linkPc;
    this.schemeAndroid = schemeAndroid;
    this.schemeIos = schemeIos;
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
  public String getDescription() {
    return description.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> description() {
    return description;
  }

  @JsonIgnore
  public String getLinkMo() {
    return linkMo.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LINK_MO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> linkMo() {
    return linkMo;
  }

  @JsonIgnore
  public String getLinkPc() {
    return linkPc.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LINK_PC)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> linkPc() {
    return linkPc;
  }

  @JsonIgnore
  public String getSchemeAndroid() {
    return schemeAndroid.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SCHEME_ANDROID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> schemeAndroid() {
    return schemeAndroid;
  }

  @JsonIgnore
  public String getSchemeIos() {
    return schemeIos.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SCHEME_IOS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> schemeIos() {
    return schemeIos;
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

  /** Return true if this KakaoTalkFixedDiscountCoupon object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DiscountFixedCouponImpl kakaoTalkFixedDiscountCoupon = (DiscountFixedCouponImpl) o;
    return Objects.equals(this.type, kakaoTalkFixedDiscountCoupon.type)
        && Objects.equals(this.description, kakaoTalkFixedDiscountCoupon.description)
        && Objects.equals(this.linkMo, kakaoTalkFixedDiscountCoupon.linkMo)
        && Objects.equals(this.linkPc, kakaoTalkFixedDiscountCoupon.linkPc)
        && Objects.equals(this.schemeAndroid, kakaoTalkFixedDiscountCoupon.schemeAndroid)
        && Objects.equals(this.schemeIos, kakaoTalkFixedDiscountCoupon.schemeIos)
        && Objects.equals(this.discountFixed, kakaoTalkFixedDiscountCoupon.discountFixed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, description, linkMo, linkPc, schemeAndroid, schemeIos, discountFixed);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DiscountFixedCouponImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    linkMo: ").append(toIndentedString(linkMo)).append("\n");
    sb.append("    linkPc: ").append(toIndentedString(linkPc)).append("\n");
    sb.append("    schemeAndroid: ").append(toIndentedString(schemeAndroid)).append("\n");
    sb.append("    schemeIos: ").append(toIndentedString(schemeIos)).append("\n");
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
  static class Builder implements DiscountFixedCoupon.Builder {
    OptionalValue<TypeEnum> type = OptionalValue.of(TypeEnum.FIXED_DISCOUNT_COUPON);
    OptionalValue<String> description = OptionalValue.empty();
    OptionalValue<String> linkMo = OptionalValue.empty();
    OptionalValue<String> linkPc = OptionalValue.empty();
    OptionalValue<String> schemeAndroid = OptionalValue.empty();
    OptionalValue<String> schemeIos = OptionalValue.empty();
    OptionalValue<Integer> discountFixed = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TYPE, required = true)
    Builder setType(TypeEnum type) {
      if (!Objects.equals(type, TypeEnum.FIXED_DISCOUNT_COUPON)) {
        throw new IllegalArgumentException(
            String.format("'type' must be '%s' (is '%s')", TypeEnum.FIXED_DISCOUNT_COUPON, type));
      }
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    public Builder setDescription(String description) {
      this.description = OptionalValue.of(description);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LINK_MO)
    public Builder setLinkMo(String linkMo) {
      this.linkMo = OptionalValue.of(linkMo);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LINK_PC)
    public Builder setLinkPc(String linkPc) {
      this.linkPc = OptionalValue.of(linkPc);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SCHEME_ANDROID)
    public Builder setSchemeAndroid(String schemeAndroid) {
      this.schemeAndroid = OptionalValue.of(schemeAndroid);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SCHEME_IOS)
    public Builder setSchemeIos(String schemeIos) {
      this.schemeIos = OptionalValue.of(schemeIos);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_DISCOUNT_FIXED, required = true)
    public Builder setDiscountFixed(Integer discountFixed) {
      this.discountFixed = OptionalValue.of(discountFixed);
      return this;
    }

    public DiscountFixedCoupon build() {
      return new DiscountFixedCouponImpl(
          type, description, linkMo, linkPc, schemeAndroid, schemeIos, discountFixed);
    }
  }
}
