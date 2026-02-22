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
  OrderDetailsPaymentButtonBoletoImpl.JSON_PROPERTY_TYPE,
  OrderDetailsPaymentButtonBoletoImpl.JSON_PROPERTY_DIGITABLE_LINE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class OrderDetailsPaymentButtonBoletoImpl
    implements OrderDetailsPaymentButtonBoleto,
        com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment
            .WhatsAppPaymentButton {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_DIGITABLE_LINE = "digitable_line";

  private OptionalValue<String> digitableLine;

  public OrderDetailsPaymentButtonBoletoImpl() {}

  protected OrderDetailsPaymentButtonBoletoImpl(
      OptionalValue<TypeEnum> type, OptionalValue<String> digitableLine) {
    this.type = type;
    this.digitableLine = digitableLine;
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
  public String getDigitableLine() {
    return digitableLine.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DIGITABLE_LINE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> digitableLine() {
    return digitableLine;
  }

  /** Return true if this WhatsAppPaymentSettingsButtonBoleto object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderDetailsPaymentButtonBoletoImpl whatsAppPaymentSettingsButtonBoleto =
        (OrderDetailsPaymentButtonBoletoImpl) o;
    return Objects.equals(this.type, whatsAppPaymentSettingsButtonBoleto.type)
        && Objects.equals(this.digitableLine, whatsAppPaymentSettingsButtonBoleto.digitableLine);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, digitableLine);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderDetailsPaymentButtonBoletoImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    digitableLine: ").append(toIndentedString(digitableLine)).append("\n");
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
  static class Builder implements OrderDetailsPaymentButtonBoleto.Builder {
    OptionalValue<TypeEnum> type =
        OptionalValue.of(OrderDetailsPaymentButtonBoleto.TypeEnum.BOLETO);
    OptionalValue<String> digitableLine = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TYPE, required = true)
    Builder setType(TypeEnum type) {
      if (!Objects.equals(type, OrderDetailsPaymentButtonBoleto.TypeEnum.BOLETO)) {
        throw new IllegalArgumentException(
            String.format(
                "'type' must be '%s' (is '%s')",
                OrderDetailsPaymentButtonBoleto.TypeEnum.BOLETO, type));
      }
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_DIGITABLE_LINE, required = true)
    public Builder setDigitableLine(String digitableLine) {
      this.digitableLine = OptionalValue.of(digitableLine);
      return this;
    }

    public OrderDetailsPaymentButtonBoleto build() {
      return new OrderDetailsPaymentButtonBoletoImpl(type, digitableLine);
    }
  }
}
