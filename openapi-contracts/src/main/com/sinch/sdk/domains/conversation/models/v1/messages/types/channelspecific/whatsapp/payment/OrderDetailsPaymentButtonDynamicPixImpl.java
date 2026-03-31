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
  OrderDetailsPaymentButtonDynamicPixImpl.JSON_PROPERTY_TYPE,
  OrderDetailsPaymentButtonDynamicPixImpl.JSON_PROPERTY_CODE,
  OrderDetailsPaymentButtonDynamicPixImpl.JSON_PROPERTY_MERCHANT_NAME,
  OrderDetailsPaymentButtonDynamicPixImpl.JSON_PROPERTY_KEY,
  OrderDetailsPaymentButtonDynamicPixImpl.JSON_PROPERTY_KEY_TYPE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class OrderDetailsPaymentButtonDynamicPixImpl
    implements OrderDetailsPaymentButtonDynamicPix,
        com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment
            .WhatsAppPaymentButton {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_CODE = "code";

  private OptionalValue<String> code;

  public static final String JSON_PROPERTY_MERCHANT_NAME = "merchant_name";

  private OptionalValue<String> merchantName;

  public static final String JSON_PROPERTY_KEY = "key";

  private OptionalValue<String> key;

  public static final String JSON_PROPERTY_KEY_TYPE = "key_type";

  private OptionalValue<KeyTypeEnum> keyType;

  public OrderDetailsPaymentButtonDynamicPixImpl() {}

  protected OrderDetailsPaymentButtonDynamicPixImpl(
      OptionalValue<TypeEnum> type,
      OptionalValue<String> code,
      OptionalValue<String> merchantName,
      OptionalValue<String> key,
      OptionalValue<KeyTypeEnum> keyType) {
    this.type = type;
    this.code = code;
    this.merchantName = merchantName;
    this.key = key;
    this.keyType = keyType;
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

  /** Return true if this WhatsAppPaymentSettingsButtonPix object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderDetailsPaymentButtonDynamicPixImpl whatsAppPaymentSettingsButtonPix =
        (OrderDetailsPaymentButtonDynamicPixImpl) o;
    return Objects.equals(this.type, whatsAppPaymentSettingsButtonPix.type)
        && Objects.equals(this.code, whatsAppPaymentSettingsButtonPix.code)
        && Objects.equals(this.merchantName, whatsAppPaymentSettingsButtonPix.merchantName)
        && Objects.equals(this.key, whatsAppPaymentSettingsButtonPix.key)
        && Objects.equals(this.keyType, whatsAppPaymentSettingsButtonPix.keyType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, code, merchantName, key, keyType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderDetailsPaymentButtonDynamicPixImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
  static class Builder implements OrderDetailsPaymentButtonDynamicPix.Builder {
    OptionalValue<TypeEnum> type =
        OptionalValue.of(OrderDetailsPaymentButtonDynamicPix.TypeEnum.PIX_DYNAMIC_CODE);
    OptionalValue<String> code = OptionalValue.empty();
    OptionalValue<String> merchantName = OptionalValue.empty();
    OptionalValue<String> key = OptionalValue.empty();
    OptionalValue<KeyTypeEnum> keyType = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TYPE, required = true)
    Builder setType(TypeEnum type) {
      if (!Objects.equals(type, OrderDetailsPaymentButtonDynamicPix.TypeEnum.PIX_DYNAMIC_CODE)) {
        throw new IllegalArgumentException(
            String.format(
                "'type' must be '%s' (is '%s')",
                OrderDetailsPaymentButtonDynamicPix.TypeEnum.PIX_DYNAMIC_CODE, type));
      }
      return this;
    }

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

    public OrderDetailsPaymentButtonDynamicPix build() {
      return new OrderDetailsPaymentButtonDynamicPixImpl(type, code, merchantName, key, keyType);
    }
  }
}
