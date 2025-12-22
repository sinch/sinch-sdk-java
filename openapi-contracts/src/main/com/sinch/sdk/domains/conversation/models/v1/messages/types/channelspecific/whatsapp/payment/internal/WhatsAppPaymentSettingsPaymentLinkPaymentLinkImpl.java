package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({WhatsAppPaymentSettingsPaymentLinkPaymentLinkImpl.JSON_PROPERTY_URI})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class WhatsAppPaymentSettingsPaymentLinkPaymentLinkImpl
    implements WhatsAppPaymentSettingsPaymentLinkPaymentLink {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_URI = "uri";

  private OptionalValue<String> uri;

  public WhatsAppPaymentSettingsPaymentLinkPaymentLinkImpl() {}

  protected WhatsAppPaymentSettingsPaymentLinkPaymentLinkImpl(OptionalValue<String> uri) {
    this.uri = uri;
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

  /** Return true if this WhatsAppPaymentSettingsPaymentLink_payment_link object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WhatsAppPaymentSettingsPaymentLinkPaymentLinkImpl
        whatsAppPaymentSettingsPaymentLinkPaymentLink =
            (WhatsAppPaymentSettingsPaymentLinkPaymentLinkImpl) o;
    return Objects.equals(this.uri, whatsAppPaymentSettingsPaymentLinkPaymentLink.uri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WhatsAppPaymentSettingsPaymentLinkPaymentLinkImpl {\n");
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
  static class Builder implements WhatsAppPaymentSettingsPaymentLinkPaymentLink.Builder {
    OptionalValue<String> uri = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_URI, required = true)
    public Builder setUri(String uri) {
      this.uri = OptionalValue.of(uri);
      return this;
    }

    public WhatsAppPaymentSettingsPaymentLinkPaymentLink build() {
      return new WhatsAppPaymentSettingsPaymentLinkPaymentLinkImpl(uri);
    }
  }
}
