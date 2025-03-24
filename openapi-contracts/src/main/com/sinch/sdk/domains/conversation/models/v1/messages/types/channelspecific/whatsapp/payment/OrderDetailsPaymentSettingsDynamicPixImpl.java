package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  OrderDetailsPaymentSettingsDynamicPixImpl.JSON_PROPERTY_CODE,
  OrderDetailsPaymentSettingsDynamicPixImpl.JSON_PROPERTY_MERCHANT_NAME,
  OrderDetailsPaymentSettingsDynamicPixImpl.JSON_PROPERTY_KEY,
  OrderDetailsPaymentSettingsDynamicPixImpl.JSON_PROPERTY_KEY_TYPE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class OrderDetailsPaymentSettingsDynamicPixImpl
    implements OrderDetailsPaymentSettingsDynamicPix {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CODE = "code";

  private OptionalValue<String> code;

  public static final String JSON_PROPERTY_MERCHANT_NAME = "merchant_name";

  private OptionalValue<String> merchantName;

  public static final String JSON_PROPERTY_KEY = "key";

  private OptionalValue<String> key;

  public static final String JSON_PROPERTY_KEY_TYPE = "key_type";

  private OptionalValue<KeyTypeEnum> keyType;

  public OrderDetailsPaymentSettingsDynamicPixImpl() {}

  protected OrderDetailsPaymentSettingsDynamicPixImpl(
      OptionalValue<String> code,
      OptionalValue<String> merchantName,
      OptionalValue<String> key,
      OptionalValue<KeyTypeEnum> keyType) {
    this.code = code;
    this.merchantName = merchantName;
    this.key = key;
    this.keyType = keyType;
  }

  @JsonIgnore
  public String getCode() {
    return code.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> code() {
    return code;
  }

  @JsonIgnore
  public String getMerchantName() {
    return merchantName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MERCHANT_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> merchantName() {
    return merchantName;
  }

  @JsonIgnore
  public String getKey() {
    return key.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> key() {
    return key;
  }

  @JsonIgnore
  public KeyTypeEnum getKeyType() {
    return keyType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_KEY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<KeyTypeEnum> keyType() {
    return keyType;
  }

  /**
   * Return true if this
   * Payment_Order_Details_channel_specific_message__payment_payment_settings_dynamic_pix object is
   * equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderDetailsPaymentSettingsDynamicPixImpl
        paymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsDynamicPix =
            (OrderDetailsPaymentSettingsDynamicPixImpl) o;
    return Objects.equals(
            this.code,
            paymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsDynamicPix.code)
        && Objects.equals(
            this.merchantName,
            paymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsDynamicPix.merchantName)
        && Objects.equals(
            this.key, paymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsDynamicPix.key)
        && Objects.equals(
            this.keyType,
            paymentOrderDetailsChannelSpecificMessagePaymentPaymentSettingsDynamicPix.keyType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, merchantName, key, keyType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderDetailsPaymentSettingsDynamicPixImpl {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    merchantName: ").append(toIndentedString(merchantName)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    keyType: ").append(toIndentedString(keyType)).append("\n");
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
  static class Builder implements OrderDetailsPaymentSettingsDynamicPix.Builder {
    OptionalValue<String> code = OptionalValue.empty();
    OptionalValue<String> merchantName = OptionalValue.empty();
    OptionalValue<String> key = OptionalValue.empty();
    OptionalValue<KeyTypeEnum> keyType = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_CODE, required = true)
    public Builder setCode(String code) {
      this.code = OptionalValue.of(code);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_MERCHANT_NAME, required = true)
    public Builder setMerchantName(String merchantName) {
      this.merchantName = OptionalValue.of(merchantName);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_KEY, required = true)
    public Builder setKey(String key) {
      this.key = OptionalValue.of(key);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_KEY_TYPE, required = true)
    public Builder setKeyType(KeyTypeEnum keyType) {
      this.keyType = OptionalValue.of(keyType);
      return this;
    }

    public OrderDetailsPaymentSettingsDynamicPix build() {
      return new OrderDetailsPaymentSettingsDynamicPixImpl(code, merchantName, key, keyType);
    }
  }
}
