package com.sinch.sdk.domains.verification.models.v1.start.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.Identity;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import com.sinch.sdk.domains.verification.models.v1.start.request.internal.StartVerificationPhoneCallOptions;
import java.util.Objects;

@JsonPropertyOrder({
  StartVerificationPhoneCallRequestImpl.JSON_PROPERTY_IDENTITY,
  StartVerificationPhoneCallRequestImpl.JSON_PROPERTY_METHOD,
  StartVerificationPhoneCallRequestImpl.JSON_PROPERTY_REFERENCE,
  StartVerificationPhoneCallRequestImpl.JSON_PROPERTY_CUSTOM,
  StartVerificationPhoneCallRequestImpl.JSON_PROPERTY_CALLOUT_OPTIONS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StartVerificationPhoneCallRequestImpl
    implements StartVerificationPhoneCallRequest,
        com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_IDENTITY = "identity";

  private OptionalValue<Identity> identity;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<VerificationMethod> method;

  public static final String JSON_PROPERTY_REFERENCE = "reference";

  private OptionalValue<String> reference;

  public static final String JSON_PROPERTY_CUSTOM = "custom";

  private OptionalValue<String> custom;

  public static final String JSON_PROPERTY_CALLOUT_OPTIONS = "calloutOptions";

  private OptionalValue<StartVerificationPhoneCallOptions> calloutOptions;

  public StartVerificationPhoneCallRequestImpl() {}

  protected StartVerificationPhoneCallRequestImpl(
      OptionalValue<Identity> identity,
      OptionalValue<VerificationMethod> method,
      OptionalValue<String> reference,
      OptionalValue<String> custom,
      OptionalValue<StartVerificationPhoneCallOptions> calloutOptions) {
    this.identity = identity;
    this.method = method;
    this.reference = reference;
    this.custom = custom;
    this.calloutOptions = calloutOptions;
  }

  @JsonIgnore
  public Identity getIdentity() {
    return identity.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Identity> identity() {
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
  public StartVerificationPhoneCallOptions getCalloutOptions() {
    return calloutOptions.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALLOUT_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<StartVerificationPhoneCallOptions> calloutOptions() {
    return calloutOptions;
  }

  @JsonIgnore
  public PhoneCallSpeech getSpeech() {
    if (null == calloutOptions
        || !calloutOptions.isPresent()
        || null == calloutOptions.get().getSpeech()) {
      return null;
    }
    return calloutOptions.get().getSpeech();
  }

  public OptionalValue<PhoneCallSpeech> speech() {
    return null != calloutOptions
        ? calloutOptions.map(StartVerificationPhoneCallOptions::getSpeech)
        : OptionalValue.empty();
  }

  /** Return true if this StartVerificationPhoneCallRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartVerificationPhoneCallRequestImpl startVerificationPhoneCallRequest =
        (StartVerificationPhoneCallRequestImpl) o;
    return Objects.equals(this.identity, startVerificationPhoneCallRequest.identity)
        && Objects.equals(this.method, startVerificationPhoneCallRequest.method)
        && Objects.equals(this.reference, startVerificationPhoneCallRequest.reference)
        && Objects.equals(this.custom, startVerificationPhoneCallRequest.custom)
        && Objects.equals(this.calloutOptions, startVerificationPhoneCallRequest.calloutOptions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identity, method, reference, custom, calloutOptions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartVerificationPhoneCallRequestImpl {\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    custom: ").append(toIndentedString(custom)).append("\n");
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
  static class Builder implements StartVerificationPhoneCallRequest.Builder {
    OptionalValue<Identity> identity = OptionalValue.empty();
    OptionalValue<VerificationMethod> method = OptionalValue.of(VerificationMethod.PHONE_CALL);
    OptionalValue<String> reference = OptionalValue.empty();
    OptionalValue<String> custom = OptionalValue.empty();
    OptionalValue<StartVerificationPhoneCallOptions> calloutOptions = OptionalValue.empty();

    StartVerificationPhoneCallOptions.Builder _delegatedBuilder = null;

    @JsonProperty(JSON_PROPERTY_IDENTITY)
    public Builder setIdentity(Identity identity) {
      this.identity = OptionalValue.of(identity);
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

    @JsonProperty(JSON_PROPERTY_CALLOUT_OPTIONS)
    public Builder setCalloutOptions(StartVerificationPhoneCallOptions calloutOptions) {
      this.calloutOptions = OptionalValue.of(calloutOptions);
      return this;
    }

    @JsonIgnore
    public Builder setSpeech(PhoneCallSpeech speech) {
      getDelegatedBuilder().setSpeech(speech);
      return this;
    }

    private StartVerificationPhoneCallOptions.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = StartVerificationPhoneCallOptions.builder();
      }
      return this._delegatedBuilder;
    }

    public StartVerificationPhoneCallRequest build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.calloutOptions = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new StartVerificationPhoneCallRequestImpl(
          identity, method, reference, custom, calloutOptions);
    }
  }
}
