package com.sinch.sdk.domains.conversation.models.v1.credentials;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  AppleBusinessChatCredentialsImpl.JSON_PROPERTY_BUSINESS_CHAT_ACCOUNT_ID,
  AppleBusinessChatCredentialsImpl.JSON_PROPERTY_MERCHANT_ID,
  AppleBusinessChatCredentialsImpl.JSON_PROPERTY_APPLE_PAY_CERTIFICATE_REFERENCE,
  AppleBusinessChatCredentialsImpl.JSON_PROPERTY_APPLE_PAY_CERTIFICATE_PASSWORD
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AppleBusinessChatCredentialsImpl implements AppleBusinessChatCredentials {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_BUSINESS_CHAT_ACCOUNT_ID = "business_chat_account_id";

  private OptionalValue<String> businessChatAccountId;

  public static final String JSON_PROPERTY_MERCHANT_ID = "merchant_id";

  private OptionalValue<String> merchantId;

  public static final String JSON_PROPERTY_APPLE_PAY_CERTIFICATE_REFERENCE =
      "apple_pay_certificate_reference";

  private OptionalValue<String> applePayCertificateReference;

  public static final String JSON_PROPERTY_APPLE_PAY_CERTIFICATE_PASSWORD =
      "apple_pay_certificate_password";

  private OptionalValue<String> applePayCertificatePassword;

  public AppleBusinessChatCredentialsImpl() {}

  protected AppleBusinessChatCredentialsImpl(
      OptionalValue<String> businessChatAccountId,
      OptionalValue<String> merchantId,
      OptionalValue<String> applePayCertificateReference,
      OptionalValue<String> applePayCertificatePassword) {
    this.businessChatAccountId = businessChatAccountId;
    this.merchantId = merchantId;
    this.applePayCertificateReference = applePayCertificateReference;
    this.applePayCertificatePassword = applePayCertificatePassword;
  }

  @JsonIgnore
  public String getBusinessChatAccountId() {
    return businessChatAccountId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BUSINESS_CHAT_ACCOUNT_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> businessChatAccountId() {
    return businessChatAccountId;
  }

  @JsonIgnore
  public String getMerchantId() {
    return merchantId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MERCHANT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> merchantId() {
    return merchantId;
  }

  @JsonIgnore
  public String getApplePayCertificateReference() {
    return applePayCertificateReference.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_APPLE_PAY_CERTIFICATE_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> applePayCertificateReference() {
    return applePayCertificateReference;
  }

  @JsonIgnore
  public String getApplePayCertificatePassword() {
    return applePayCertificatePassword.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_APPLE_PAY_CERTIFICATE_PASSWORD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> applePayCertificatePassword() {
    return applePayCertificatePassword;
  }

  /** Return true if this Apple_Business_Chat_Credentials object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppleBusinessChatCredentialsImpl appleBusinessChatCredentials =
        (AppleBusinessChatCredentialsImpl) o;
    return Objects.equals(
            this.businessChatAccountId, appleBusinessChatCredentials.businessChatAccountId)
        && Objects.equals(this.merchantId, appleBusinessChatCredentials.merchantId)
        && Objects.equals(
            this.applePayCertificateReference,
            appleBusinessChatCredentials.applePayCertificateReference)
        && Objects.equals(
            this.applePayCertificatePassword,
            appleBusinessChatCredentials.applePayCertificatePassword);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        businessChatAccountId,
        merchantId,
        applePayCertificateReference,
        applePayCertificatePassword);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppleBusinessChatCredentialsImpl {\n");
    sb.append("    businessChatAccountId: ")
        .append(toIndentedString(businessChatAccountId))
        .append("\n");
    sb.append("    merchantId: ").append(toIndentedString(merchantId)).append("\n");
    sb.append("    applePayCertificateReference: ")
        .append(toIndentedString(applePayCertificateReference))
        .append("\n");
    sb.append("    applePayCertificatePassword: ")
        .append(toIndentedString(applePayCertificatePassword))
        .append("\n");
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
  static class Builder implements AppleBusinessChatCredentials.Builder {
    OptionalValue<String> businessChatAccountId = OptionalValue.empty();
    OptionalValue<String> merchantId = OptionalValue.empty();
    OptionalValue<String> applePayCertificateReference = OptionalValue.empty();
    OptionalValue<String> applePayCertificatePassword = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_BUSINESS_CHAT_ACCOUNT_ID)
    public Builder setBusinessChatAccountId(String businessChatAccountId) {
      this.businessChatAccountId = OptionalValue.of(businessChatAccountId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MERCHANT_ID)
    public Builder setMerchantId(String merchantId) {
      this.merchantId = OptionalValue.of(merchantId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_APPLE_PAY_CERTIFICATE_REFERENCE)
    public Builder setApplePayCertificateReference(String applePayCertificateReference) {
      this.applePayCertificateReference = OptionalValue.of(applePayCertificateReference);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_APPLE_PAY_CERTIFICATE_PASSWORD)
    public Builder setApplePayCertificatePassword(String applePayCertificatePassword) {
      this.applePayCertificatePassword = OptionalValue.of(applePayCertificatePassword);
      return this;
    }

    public AppleBusinessChatCredentials build() {
      return new AppleBusinessChatCredentialsImpl(
          businessChatAccountId,
          merchantId,
          applePayCertificateReference,
          applePayCertificatePassword);
    }
  }
}
