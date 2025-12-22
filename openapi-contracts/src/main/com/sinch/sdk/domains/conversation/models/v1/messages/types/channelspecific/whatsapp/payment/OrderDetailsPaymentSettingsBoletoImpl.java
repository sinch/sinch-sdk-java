package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment.internal.WhatsAppPaymentSettingsBoletoBoleto;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment.internal.WhatsAppPaymentSettingsBoletoBoletoImpl;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({OrderDetailsPaymentSettingsBoletoImpl.JSON_PROPERTY_BOLETO})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class OrderDetailsPaymentSettingsBoletoImpl
    implements OrderDetailsPaymentSettingsBoleto,
        com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment
            .OrderDetailsSettings {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_BOLETO = "boleto";

  private OptionalValue<WhatsAppPaymentSettingsBoletoBoleto> boleto;

  public OrderDetailsPaymentSettingsBoletoImpl() {}

  protected OrderDetailsPaymentSettingsBoletoImpl(
      OptionalValue<WhatsAppPaymentSettingsBoletoBoleto> boleto) {
    this.boleto = boleto;
  }

  @JsonIgnore
  public WhatsAppPaymentSettingsBoletoBoleto getBoleto() {
    return boleto.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BOLETO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<WhatsAppPaymentSettingsBoletoBoleto> boleto() {
    return boleto;
  }

  @JsonIgnore
  public String getDigitableLine() {
    if (null == boleto || !boleto.isPresent() || null == boleto.get().getDigitableLine()) {
      return null;
    }
    return boleto.get().getDigitableLine();
  }

  public OptionalValue<String> digitableLine() {
    return null != boleto && boleto.isPresent()
        ? boleto
            .map(f -> ((WhatsAppPaymentSettingsBoletoBoletoImpl) f).digitableLine())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this WhatsAppPaymentSettingsBoleto object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderDetailsPaymentSettingsBoletoImpl whatsAppPaymentSettingsBoleto =
        (OrderDetailsPaymentSettingsBoletoImpl) o;
    return Objects.equals(this.boleto, whatsAppPaymentSettingsBoleto.boleto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(boleto);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderDetailsPaymentSettingsBoletoImpl {\n");
    sb.append("    boleto: ").append(toIndentedString(boleto)).append("\n");
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
  static class Builder implements OrderDetailsPaymentSettingsBoleto.Builder {
    OptionalValue<WhatsAppPaymentSettingsBoletoBoleto> boleto = OptionalValue.empty();

    WhatsAppPaymentSettingsBoletoBoleto.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_BOLETO, required = true)
    public Builder setBoleto(WhatsAppPaymentSettingsBoletoBoleto boleto) {
      this.boleto = OptionalValue.of(boleto);
      return this;
    }

    @JsonIgnore
    public Builder setDigitableLine(String digitableLine) {
      getDelegatedBuilder().setDigitableLine(digitableLine);
      return this;
    }

    private WhatsAppPaymentSettingsBoletoBoleto.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = WhatsAppPaymentSettingsBoletoBoleto.builder();
      }
      return this._delegatedBuilder;
    }

    public OrderDetailsPaymentSettingsBoleto build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.boleto = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new OrderDetailsPaymentSettingsBoletoImpl(boleto);
    }
  }

  public static class DelegatedSerializer
      extends JsonSerializer<OptionalValue<OrderDetailsPaymentSettingsBoleto>> {
    @Override
    public void serialize(
        OptionalValue<OrderDetailsPaymentSettingsBoleto> value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      OrderDetailsPaymentSettingsBoletoImpl impl =
          (OrderDetailsPaymentSettingsBoletoImpl) value.get();
      jgen.writeObject(null != impl ? impl.getBoleto() : null);
    }
  }

  public static class DelegatedDeSerializer
      extends JsonDeserializer<OrderDetailsPaymentSettingsBoleto> {
    @Override
    public OrderDetailsPaymentSettingsBoleto deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      OrderDetailsPaymentSettingsBoletoImpl.Builder builder =
          new OrderDetailsPaymentSettingsBoletoImpl.Builder();
      WhatsAppPaymentSettingsBoletoBoletoImpl deserialized =
          jp.readValueAs(WhatsAppPaymentSettingsBoletoBoletoImpl.class);
      builder.setBoleto(deserialized);
      return builder.build();
    }
  }

  public static Optional<OrderDetailsPaymentSettingsBoleto> delegatedConverter(
      WhatsAppPaymentSettingsBoletoBoleto internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setBoleto(internal).build());
  }
}
