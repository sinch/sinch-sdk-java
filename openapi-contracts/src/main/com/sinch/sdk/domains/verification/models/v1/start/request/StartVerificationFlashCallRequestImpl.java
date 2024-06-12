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
import com.sinch.sdk.domains.verification.models.v1.start.request.internal.StartVerificationFlashCallOptions;
import java.util.Objects;

@JsonPropertyOrder({
  StartVerificationFlashCallRequestImpl.JSON_PROPERTY_IDENTITY,
  StartVerificationFlashCallRequestImpl.JSON_PROPERTY_METHOD,
  StartVerificationFlashCallRequestImpl.JSON_PROPERTY_REFERENCE,
  StartVerificationFlashCallRequestImpl.JSON_PROPERTY_CUSTOM,
  StartVerificationFlashCallRequestImpl.JSON_PROPERTY_FLASH_CALL_OPTIONS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StartVerificationFlashCallRequestImpl
    implements StartVerificationFlashCallRequest,
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

  public static final String JSON_PROPERTY_FLASH_CALL_OPTIONS = "flashCallOptions";

  private OptionalValue<StartVerificationFlashCallOptions> flashCallOptions;

  public StartVerificationFlashCallRequestImpl() {}

  protected StartVerificationFlashCallRequestImpl(
      OptionalValue<Identity> identity,
      OptionalValue<VerificationMethod> method,
      OptionalValue<String> reference,
      OptionalValue<String> custom,
      OptionalValue<StartVerificationFlashCallOptions> flashCallOptions) {
    this.identity = identity;
    this.method = method;
    this.reference = reference;
    this.custom = custom;
    this.flashCallOptions = flashCallOptions;
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
  public StartVerificationFlashCallOptions getFlashCallOptions() {
    return flashCallOptions.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FLASH_CALL_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<StartVerificationFlashCallOptions> flashCallOptions() {
    return flashCallOptions;
  }

  @JsonIgnore
  public Integer getDialTimeout() {
    if (null == flashCallOptions
        || !flashCallOptions.isPresent()
        || null == flashCallOptions.get().getDialTimeout()) {
      return null;
    }
    return flashCallOptions.get().getDialTimeout();
  }

  public OptionalValue<Integer> dialTimeout() {
    return null != flashCallOptions
        ? flashCallOptions.map(StartVerificationFlashCallOptions::getDialTimeout)
        : OptionalValue.empty();
  }

  /** Return true if this StartVerificationFlashCallRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartVerificationFlashCallRequestImpl startVerificationFlashCallRequest =
        (StartVerificationFlashCallRequestImpl) o;
    return Objects.equals(this.identity, startVerificationFlashCallRequest.identity)
        && Objects.equals(this.method, startVerificationFlashCallRequest.method)
        && Objects.equals(this.reference, startVerificationFlashCallRequest.reference)
        && Objects.equals(this.custom, startVerificationFlashCallRequest.custom)
        && Objects.equals(
            this.flashCallOptions, startVerificationFlashCallRequest.flashCallOptions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identity, method, reference, custom, flashCallOptions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartVerificationFlashCallRequestImpl {\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    custom: ").append(toIndentedString(custom)).append("\n");
    sb.append("    flashCallOptions: ").append(toIndentedString(flashCallOptions)).append("\n");
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
  static class Builder implements StartVerificationFlashCallRequest.Builder {
    OptionalValue<Identity> identity = OptionalValue.empty();
    OptionalValue<VerificationMethod> method = OptionalValue.of(VerificationMethod.FLASHCALL);
    OptionalValue<String> reference = OptionalValue.empty();
    OptionalValue<String> custom = OptionalValue.empty();
    OptionalValue<StartVerificationFlashCallOptions> flashCallOptions = OptionalValue.empty();

    StartVerificationFlashCallOptions.Builder _delegatedBuilder = null;

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

    @JsonProperty(JSON_PROPERTY_FLASH_CALL_OPTIONS)
    public Builder setFlashCallOptions(StartVerificationFlashCallOptions flashCallOptions) {
      this.flashCallOptions = OptionalValue.of(flashCallOptions);
      return this;
    }

    @JsonIgnore
    public Builder setDialTimeout(Integer dialTimeout) {
      getDelegatedBuilder().setDialTimeout(dialTimeout);
      return this;
    }

    private StartVerificationFlashCallOptions.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = StartVerificationFlashCallOptions.builder();
      }
      return this._delegatedBuilder;
    }

    public StartVerificationFlashCallRequest build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.flashCallOptions = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new StartVerificationFlashCallRequestImpl(
          identity, method, reference, custom, flashCallOptions);
    }
  }
}
