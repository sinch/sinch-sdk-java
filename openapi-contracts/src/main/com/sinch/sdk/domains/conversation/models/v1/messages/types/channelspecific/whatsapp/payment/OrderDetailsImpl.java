package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows.WhatsAppInteractiveBody;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows.WhatsAppInteractiveFooter;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows.WhatsAppInteractiveHeader;
import java.util.Objects;

@JsonPropertyOrder({
  OrderDetailsImpl.JSON_PROPERTY_HEADER,
  OrderDetailsImpl.JSON_PROPERTY_BODY,
  OrderDetailsImpl.JSON_PROPERTY_FOOTER,
  OrderDetailsImpl.JSON_PROPERTY_PAYMENT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class OrderDetailsImpl
    implements OrderDetails,
        com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific
            .ChannelSpecificMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_HEADER = "header";

  private OptionalValue<WhatsAppInteractiveHeader> header;

  public static final String JSON_PROPERTY_BODY = "body";

  private OptionalValue<WhatsAppInteractiveBody> body;

  public static final String JSON_PROPERTY_FOOTER = "footer";

  private OptionalValue<WhatsAppInteractiveFooter> footer;

  public static final String JSON_PROPERTY_PAYMENT = "payment";

  private OptionalValue<OrderDetailsPayment> payment;

  public OrderDetailsImpl() {}

  protected OrderDetailsImpl(
      OptionalValue<WhatsAppInteractiveHeader> header,
      OptionalValue<WhatsAppInteractiveBody> body,
      OptionalValue<WhatsAppInteractiveFooter> footer,
      OptionalValue<OrderDetailsPayment> payment) {
    this.header = header;
    this.body = body;
    this.footer = footer;
    this.payment = payment;
  }

  @JsonIgnore
  public WhatsAppInteractiveHeader getHeader() {
    return header.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_HEADER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<WhatsAppInteractiveHeader> header() {
    return header;
  }

  @JsonIgnore
  public WhatsAppInteractiveBody getBody() {
    return body.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BODY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<WhatsAppInteractiveBody> body() {
    return body;
  }

  @JsonIgnore
  public WhatsAppInteractiveFooter getFooter() {
    return footer.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FOOTER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<WhatsAppInteractiveFooter> footer() {
    return footer;
  }

  @JsonIgnore
  public OrderDetailsPayment getPayment() {
    return payment.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PAYMENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<OrderDetailsPayment> payment() {
    return payment;
  }

  /** Return true if this PaymentOrderDetailsChannelSpecificMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderDetailsImpl paymentOrderDetailsChannelSpecificMessage = (OrderDetailsImpl) o;
    return Objects.equals(this.header, paymentOrderDetailsChannelSpecificMessage.header)
        && Objects.equals(this.body, paymentOrderDetailsChannelSpecificMessage.body)
        && Objects.equals(this.footer, paymentOrderDetailsChannelSpecificMessage.footer)
        && Objects.equals(this.payment, paymentOrderDetailsChannelSpecificMessage.payment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(header, body, footer, payment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderDetailsImpl {\n");
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    footer: ").append(toIndentedString(footer)).append("\n");
    sb.append("    payment: ").append(toIndentedString(payment)).append("\n");
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
  static class Builder implements OrderDetails.Builder {
    OptionalValue<WhatsAppInteractiveHeader> header = OptionalValue.empty();
    OptionalValue<WhatsAppInteractiveBody> body = OptionalValue.empty();
    OptionalValue<WhatsAppInteractiveFooter> footer = OptionalValue.empty();
    OptionalValue<OrderDetailsPayment> payment = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_HEADER)
    public Builder setHeader(WhatsAppInteractiveHeader header) {
      this.header = OptionalValue.of(header);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_BODY)
    public Builder setBody(WhatsAppInteractiveBody body) {
      this.body = OptionalValue.of(body);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FOOTER)
    public Builder setFooter(WhatsAppInteractiveFooter footer) {
      this.footer = OptionalValue.of(footer);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_PAYMENT, required = true)
    public Builder setPayment(OrderDetailsPayment payment) {
      this.payment = OptionalValue.of(payment);
      return this;
    }

    public OrderDetails build() {
      return new OrderDetailsImpl(header, body, footer, payment);
    }
  }
}
