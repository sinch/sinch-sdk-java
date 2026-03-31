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
  OrderDetailsPaymentButtonPaymentLinkImpl.JSON_PROPERTY_TYPE,
  OrderDetailsPaymentButtonPaymentLinkImpl.JSON_PROPERTY_URI
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class OrderDetailsPaymentButtonPaymentLinkImpl
    implements OrderDetailsPaymentButtonPaymentLink,
        com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment
            .WhatsAppPaymentButton {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_URI = "uri";

  private OptionalValue<String> uri;

  public OrderDetailsPaymentButtonPaymentLinkImpl() {}

  protected OrderDetailsPaymentButtonPaymentLinkImpl(
      OptionalValue<TypeEnum> type, OptionalValue<String> uri) {
    this.type = type;
    this.uri = uri;
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
  public String getUri() {
    return uri.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_URI)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> uri() {
    return uri;
  }

  /** Return true if this WhatsAppPaymentSettingsButtonPaymentLink object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderDetailsPaymentButtonPaymentLinkImpl whatsAppPaymentSettingsButtonPaymentLink =
        (OrderDetailsPaymentButtonPaymentLinkImpl) o;
    return Objects.equals(this.type, whatsAppPaymentSettingsButtonPaymentLink.type)
        && Objects.equals(this.uri, whatsAppPaymentSettingsButtonPaymentLink.uri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, uri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderDetailsPaymentButtonPaymentLinkImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
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
  static class Builder implements OrderDetailsPaymentButtonPaymentLink.Builder {
    OptionalValue<TypeEnum> type =
        OptionalValue.of(OrderDetailsPaymentButtonPaymentLink.TypeEnum.PAYMENT_LINK);
    OptionalValue<String> uri = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TYPE, required = true)
    Builder setType(TypeEnum type) {
      if (!Objects.equals(type, OrderDetailsPaymentButtonPaymentLink.TypeEnum.PAYMENT_LINK)) {
        throw new IllegalArgumentException(
            String.format(
                "'type' must be '%s' (is '%s')",
                OrderDetailsPaymentButtonPaymentLink.TypeEnum.PAYMENT_LINK, type));
      }
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_URI, required = true)
    public Builder setUri(String uri) {
      this.uri = OptionalValue.of(uri);
      return this;
    }

    public OrderDetailsPaymentButtonPaymentLink build() {
      return new OrderDetailsPaymentButtonPaymentLinkImpl(type, uri);
    }
  }
}
