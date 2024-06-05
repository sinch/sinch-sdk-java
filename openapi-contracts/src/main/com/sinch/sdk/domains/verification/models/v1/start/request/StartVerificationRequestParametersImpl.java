package com.sinch.sdk.domains.verification.models.v1.start.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import com.sinch.sdk.domains.verification.models.v1.internal.IdentityInternal;
import java.util.Objects;

@JsonPropertyOrder({
  StartVerificationRequestParametersImpl.JSON_PROPERTY_IDENTITY,
  StartVerificationRequestParametersImpl.JSON_PROPERTY_METHOD,
  StartVerificationRequestParametersImpl.JSON_PROPERTY_REFERENCE,
  StartVerificationRequestParametersImpl.JSON_PROPERTY_CUSTOM,
  StartVerificationRequestParametersImpl.JSON_PROPERTY_FLASH_CALL_OPTIONS,
  StartVerificationRequestParametersImpl.JSON_PROPERTY_SMS_OPTIONS,
  StartVerificationRequestParametersImpl.JSON_PROPERTY_CALLOUT_OPTIONS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StartVerificationRequestParametersImpl implements StartVerificationRequestParameters {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_IDENTITY = "identity";

  private OptionalValue<IdentityInternal> identity;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<VerificationMethod> method;

  public static final String JSON_PROPERTY_REFERENCE = "reference";

  private OptionalValue<String> reference;

  public static final String JSON_PROPERTY_CUSTOM = "custom";

  private OptionalValue<String> custom;

  public static final String JSON_PROPERTY_FLASH_CALL_OPTIONS = "flashCallOptions";

  private OptionalValue<StartVerificationFlashCallOptions> flashCallOptions;

  public static final String JSON_PROPERTY_SMS_OPTIONS = "smsOptions";

  private OptionalValue<StartVerificationSmsOptions> smsOptions;

  public static final String JSON_PROPERTY_CALLOUT_OPTIONS = "calloutOptions";

  private OptionalValue<StartVerificationPhoneCallOptions> calloutOptions;

  public StartVerificationRequestParametersImpl() {}

  protected StartVerificationRequestParametersImpl(
      OptionalValue<IdentityInternal> identity,
      OptionalValue<VerificationMethod> method,
      OptionalValue<String> reference,
      OptionalValue<String> custom,
      OptionalValue<StartVerificationFlashCallOptions> flashCallOptions,
      OptionalValue<StartVerificationSmsOptions> smsOptions,
      OptionalValue<StartVerificationPhoneCallOptions> calloutOptions) {
    this.identity = identity;
    this.method = method;
    this.reference = reference;
    this.custom = custom;
    this.flashCallOptions = flashCallOptions;
    this.smsOptions = smsOptions;
    this.calloutOptions = calloutOptions;
  }

  @JsonIgnore
  public IdentityInternal getIdentity() {
    return identity.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<IdentityInternal> identity() {
    return identity;
  }

  @JsonIgnore
  public VerificationMethod getMethod() {
    return method.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<VerificationMethod> method() {
    return method;
  }

  @JsonIgnore
  public String getReference() {
    return reference.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> reference() {
    return reference;
  }

  @JsonIgnore
  public String getCustom() {
    return custom.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CUSTOM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> custom() {
    return custom;
  }

  @JsonIgnore
  public StartVerificationFlashCallOptions getFlashCallOptions() {
    return flashCallOptions.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FLASH_CALL_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<StartVerificationFlashCallOptions> flashCallOptions() {
    return flashCallOptions;
  }

  @JsonIgnore
  public StartVerificationSmsOptions getSmsOptions() {
    return smsOptions.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SMS_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<StartVerificationSmsOptions> smsOptions() {
    return smsOptions;
  }

  @JsonIgnore
  public StartVerificationPhoneCallOptions getCalloutOptions() {
    return calloutOptions.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALLOUT_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<StartVerificationPhoneCallOptions> calloutOptions() {
    return calloutOptions;
  }

  /** Return true if this InitiateVerificationResource object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartVerificationRequestParametersImpl initiateVerificationResource =
        (StartVerificationRequestParametersImpl) o;
    return Objects.equals(this.identity, initiateVerificationResource.identity)
        && Objects.equals(this.method, initiateVerificationResource.method)
        && Objects.equals(this.reference, initiateVerificationResource.reference)
        && Objects.equals(this.custom, initiateVerificationResource.custom)
        && Objects.equals(this.flashCallOptions, initiateVerificationResource.flashCallOptions)
        && Objects.equals(this.smsOptions, initiateVerificationResource.smsOptions)
        && Objects.equals(this.calloutOptions, initiateVerificationResource.calloutOptions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        identity, method, reference, custom, flashCallOptions, smsOptions, calloutOptions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartVerificationRequestParametersImpl {\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    custom: ").append(toIndentedString(custom)).append("\n");
    sb.append("    flashCallOptions: ").append(toIndentedString(flashCallOptions)).append("\n");
    sb.append("    smsOptions: ").append(toIndentedString(smsOptions)).append("\n");
    sb.append("    calloutOptions: ").append(toIndentedString(calloutOptions)).append("\n");
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
  static class Builder implements StartVerificationRequestParameters.Builder {
    OptionalValue<IdentityInternal> identity = OptionalValue.empty();
    OptionalValue<VerificationMethod> method = OptionalValue.empty();
    OptionalValue<String> reference = OptionalValue.empty();
    OptionalValue<String> custom = OptionalValue.empty();
    OptionalValue<StartVerificationFlashCallOptions> flashCallOptions = OptionalValue.empty();
    OptionalValue<StartVerificationSmsOptions> smsOptions = OptionalValue.empty();
    OptionalValue<StartVerificationPhoneCallOptions> calloutOptions = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_IDENTITY)
    public Builder setIdentity(IdentityInternal identity) {
      this.identity = OptionalValue.of(identity);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_METHOD)
    public Builder setMethod(VerificationMethod method) {
      this.method = OptionalValue.of(method);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REFERENCE)
    public Builder setReference(String reference) {
      this.reference = OptionalValue.of(reference);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CUSTOM)
    public Builder setCustom(String custom) {
      this.custom = OptionalValue.of(custom);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FLASH_CALL_OPTIONS)
    public Builder setFlashCallOptions(StartVerificationFlashCallOptions flashCallOptions) {
      this.flashCallOptions = OptionalValue.of(flashCallOptions);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SMS_OPTIONS)
    public Builder setSmsOptions(StartVerificationSmsOptions smsOptions) {
      this.smsOptions = OptionalValue.of(smsOptions);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALLOUT_OPTIONS)
    public Builder setCalloutOptions(StartVerificationPhoneCallOptions calloutOptions) {
      this.calloutOptions = OptionalValue.of(calloutOptions);
      return this;
    }

    public StartVerificationRequestParameters build() {
      return new StartVerificationRequestParametersImpl(
          identity, method, reference, custom, flashCallOptions, smsOptions, calloutOptions);
    }
  }
}
