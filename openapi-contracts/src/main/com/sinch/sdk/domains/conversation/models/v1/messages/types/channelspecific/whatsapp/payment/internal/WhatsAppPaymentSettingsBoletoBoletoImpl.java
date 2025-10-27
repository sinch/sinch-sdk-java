package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({WhatsAppPaymentSettingsBoletoBoletoImpl.JSON_PROPERTY_DIGITABLE_LINE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class WhatsAppPaymentSettingsBoletoBoletoImpl
    implements WhatsAppPaymentSettingsBoletoBoleto {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_DIGITABLE_LINE = "digitable_line";

  private OptionalValue<String> digitableLine;

  public WhatsAppPaymentSettingsBoletoBoletoImpl() {}

  protected WhatsAppPaymentSettingsBoletoBoletoImpl(OptionalValue<String> digitableLine) {
    this.digitableLine = digitableLine;
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

  /** Return true if this WhatsAppPaymentSettingsBoleto_boleto object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WhatsAppPaymentSettingsBoletoBoletoImpl whatsAppPaymentSettingsBoletoBoleto =
        (WhatsAppPaymentSettingsBoletoBoletoImpl) o;
    return Objects.equals(this.digitableLine, whatsAppPaymentSettingsBoletoBoleto.digitableLine);
  }

  @Override
  public int hashCode() {
    return Objects.hash(digitableLine);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WhatsAppPaymentSettingsBoletoBoletoImpl {\n");
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
  static class Builder implements WhatsAppPaymentSettingsBoletoBoleto.Builder {
    OptionalValue<String> digitableLine = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_DIGITABLE_LINE, required = true)
    public Builder setDigitableLine(String digitableLine) {
      this.digitableLine = OptionalValue.of(digitableLine);
      return this;
    }

    public WhatsAppPaymentSettingsBoletoBoleto build() {
      return new WhatsAppPaymentSettingsBoletoBoletoImpl(digitableLine);
    }
  }
}
