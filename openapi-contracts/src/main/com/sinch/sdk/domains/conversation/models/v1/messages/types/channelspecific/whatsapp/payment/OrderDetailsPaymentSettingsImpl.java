package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({OrderDetailsPaymentSettingsImpl.JSON_PROPERTY_DYNAMIC_PIX})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class OrderDetailsPaymentSettingsImpl implements OrderDetailsPaymentSettings {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_DYNAMIC_PIX = "dynamic_pix";

  private OptionalValue<OrderDetailsPaymentSettingsDynamicPix> dynamicPix;

  public OrderDetailsPaymentSettingsImpl() {}

  protected OrderDetailsPaymentSettingsImpl(
      OptionalValue<OrderDetailsPaymentSettingsDynamicPix> dynamicPix) {
    this.dynamicPix = dynamicPix;
  }

  @JsonIgnore
  public OrderDetailsPaymentSettingsDynamicPix getDynamicPix() {
    return dynamicPix.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DYNAMIC_PIX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<OrderDetailsPaymentSettingsDynamicPix> dynamicPix() {
    return dynamicPix;
  }

  /**
   * Return true if this Payment_Order_Details_channel_specific_message__payment_payment_settings
   * object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderDetailsPaymentSettingsImpl
        paymentOrderDetailsChannelSpecificMessagePaymentPaymentSettings =
            (OrderDetailsPaymentSettingsImpl) o;
    return Objects.equals(
        this.dynamicPix,
        paymentOrderDetailsChannelSpecificMessagePaymentPaymentSettings.dynamicPix);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dynamicPix);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderDetailsPaymentSettingsImpl {\n");
    sb.append("    dynamicPix: ").append(toIndentedString(dynamicPix)).append("\n");
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
  static class Builder implements OrderDetailsPaymentSettings.Builder {
    OptionalValue<OrderDetailsPaymentSettingsDynamicPix> dynamicPix = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_DYNAMIC_PIX, required = true)
    public Builder setDynamicPix(OrderDetailsPaymentSettingsDynamicPix dynamicPix) {
      this.dynamicPix = OptionalValue.of(dynamicPix);
      return this;
    }

    public OrderDetailsPaymentSettings build() {
      return new OrderDetailsPaymentSettingsImpl(dynamicPix);
    }
  }
}
