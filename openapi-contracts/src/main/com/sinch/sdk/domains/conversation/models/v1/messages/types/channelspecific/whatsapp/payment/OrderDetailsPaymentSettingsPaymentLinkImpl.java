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
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment.internal.WhatsAppPaymentSettingsPaymentLinkPaymentLink;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment.internal.WhatsAppPaymentSettingsPaymentLinkPaymentLinkImpl;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({OrderDetailsPaymentSettingsPaymentLinkImpl.JSON_PROPERTY_PAYMENT_LINK})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class OrderDetailsPaymentSettingsPaymentLinkImpl
    implements OrderDetailsPaymentSettingsPaymentLink,
        com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment
            .OrderDetailsSettings {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PAYMENT_LINK = "payment_link";

  private OptionalValue<WhatsAppPaymentSettingsPaymentLinkPaymentLink> paymentLink;

  public OrderDetailsPaymentSettingsPaymentLinkImpl() {}

  protected OrderDetailsPaymentSettingsPaymentLinkImpl(
      OptionalValue<WhatsAppPaymentSettingsPaymentLinkPaymentLink> paymentLink) {
    this.paymentLink = paymentLink;
  }

  @JsonIgnore
  public WhatsAppPaymentSettingsPaymentLinkPaymentLink getPaymentLink() {
    return paymentLink.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PAYMENT_LINK)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<WhatsAppPaymentSettingsPaymentLinkPaymentLink> paymentLink() {
    return paymentLink;
  }

  @JsonIgnore
  public String getUri() {
    if (null == paymentLink || !paymentLink.isPresent() || null == paymentLink.get().getUri()) {
      return null;
    }
    return paymentLink.get().getUri();
  }

  public OptionalValue<String> uri() {
    return null != paymentLink && paymentLink.isPresent()
        ? paymentLink
            .map(f -> ((WhatsAppPaymentSettingsPaymentLinkPaymentLinkImpl) f).uri())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this WhatsAppPaymentSettingsPaymentLink object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderDetailsPaymentSettingsPaymentLinkImpl whatsAppPaymentSettingsPaymentLink =
        (OrderDetailsPaymentSettingsPaymentLinkImpl) o;
    return Objects.equals(this.paymentLink, whatsAppPaymentSettingsPaymentLink.paymentLink);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentLink);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderDetailsPaymentSettingsPaymentLinkImpl {\n");
    sb.append("    paymentLink: ").append(toIndentedString(paymentLink)).append("\n");
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
  static class Builder implements OrderDetailsPaymentSettingsPaymentLink.Builder {
    OptionalValue<WhatsAppPaymentSettingsPaymentLinkPaymentLink> paymentLink =
        OptionalValue.empty();

    WhatsAppPaymentSettingsPaymentLinkPaymentLink.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_PAYMENT_LINK, required = true)
    public Builder setPaymentLink(WhatsAppPaymentSettingsPaymentLinkPaymentLink paymentLink) {
      this.paymentLink = OptionalValue.of(paymentLink);
      return this;
    }

    @JsonIgnore
    public Builder setUri(String uri) {
      getDelegatedBuilder().setUri(uri);
      return this;
    }

    private WhatsAppPaymentSettingsPaymentLinkPaymentLink.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = WhatsAppPaymentSettingsPaymentLinkPaymentLink.builder();
      }
      return this._delegatedBuilder;
    }

    public OrderDetailsPaymentSettingsPaymentLink build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.paymentLink = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new OrderDetailsPaymentSettingsPaymentLinkImpl(paymentLink);
    }
  }

  public static class DelegatedSerializer
      extends JsonSerializer<OptionalValue<OrderDetailsPaymentSettingsPaymentLink>> {
    @Override
    public void serialize(
        OptionalValue<OrderDetailsPaymentSettingsPaymentLink> value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      OrderDetailsPaymentSettingsPaymentLinkImpl impl =
          (OrderDetailsPaymentSettingsPaymentLinkImpl) value.get();
      jgen.writeObject(null != impl ? impl.getPaymentLink() : null);
    }
  }

  public static class DelegatedDeSerializer
      extends JsonDeserializer<OrderDetailsPaymentSettingsPaymentLink> {
    @Override
    public OrderDetailsPaymentSettingsPaymentLink deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException {

      OrderDetailsPaymentSettingsPaymentLinkImpl.Builder builder =
          new OrderDetailsPaymentSettingsPaymentLinkImpl.Builder();
      WhatsAppPaymentSettingsPaymentLinkPaymentLinkImpl deserialized =
          jp.readValueAs(WhatsAppPaymentSettingsPaymentLinkPaymentLinkImpl.class);
      builder.setPaymentLink(deserialized);
      return builder.build();
    }
  }

  public static Optional<OrderDetailsPaymentSettingsPaymentLink> delegatedConverter(
      WhatsAppPaymentSettingsPaymentLinkPaymentLink internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setPaymentLink(internal).build());
  }
}
