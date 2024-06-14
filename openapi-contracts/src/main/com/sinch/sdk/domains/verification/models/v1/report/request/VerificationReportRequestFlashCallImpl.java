package com.sinch.sdk.domains.verification.models.v1.report.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.v1.report.request.internal.VerificationReportRequestFlashCallOptions;
import java.util.Objects;

@JsonPropertyOrder({
  VerificationReportRequestFlashCallImpl.JSON_PROPERTY_METHOD,
  VerificationReportRequestFlashCallImpl.JSON_PROPERTY_FLASH_CALL
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationReportRequestFlashCallImpl
    implements VerificationReportRequestFlashCall,
        com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<MethodEnum> method;

  public static final String JSON_PROPERTY_FLASH_CALL = "flashCall";

  private OptionalValue<VerificationReportRequestFlashCallOptions> flashCall;

  public VerificationReportRequestFlashCallImpl() {}

  protected VerificationReportRequestFlashCallImpl(
      OptionalValue<MethodEnum> method,
      OptionalValue<VerificationReportRequestFlashCallOptions> flashCall) {
    this.method = method;
    this.flashCall = flashCall;
  }

  @JsonIgnore
  public MethodEnum getMethod() {
    return method.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<MethodEnum> method() {
    return method;
  }

  @JsonIgnore
  public VerificationReportRequestFlashCallOptions getFlashCall() {
    return flashCall.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FLASH_CALL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<VerificationReportRequestFlashCallOptions> flashCall() {
    return flashCall;
  }

  @JsonIgnore
  public String getCli() {
    if (null == flashCall || !flashCall.isPresent() || null == flashCall.get().getCli()) {
      return null;
    }
    return flashCall.get().getCli();
  }

  public OptionalValue<String> cli() {
    return null != flashCall
        ? flashCall.map(VerificationReportRequestFlashCallOptions::getCli)
        : OptionalValue.empty();
  }

  /** Return true if this VerificationReportRequestFlashCall object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationReportRequestFlashCallImpl verificationReportRequestFlashCall =
        (VerificationReportRequestFlashCallImpl) o;
    return Objects.equals(this.method, verificationReportRequestFlashCall.method)
        && Objects.equals(this.flashCall, verificationReportRequestFlashCall.flashCall);
  }

  @Override
  public int hashCode() {
    return Objects.hash(method, flashCall);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationReportRequestFlashCallImpl {\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    flashCall: ").append(toIndentedString(flashCall)).append("\n");
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
  static class Builder implements VerificationReportRequestFlashCall.Builder {
    OptionalValue<MethodEnum> method = OptionalValue.of(MethodEnum.FLASH_CALL);
    OptionalValue<VerificationReportRequestFlashCallOptions> flashCall = OptionalValue.empty();

    VerificationReportRequestFlashCallOptions.Builder _delegatedBuilder = null;

    @JsonProperty(JSON_PROPERTY_FLASH_CALL)
    public Builder setFlashCall(VerificationReportRequestFlashCallOptions flashCall) {
      this.flashCall = OptionalValue.of(flashCall);
      return this;
    }

    @JsonIgnore
    public Builder setCli(String cli) {
      getDelegatedBuilder().setCli(cli);
      return this;
    }

    private VerificationReportRequestFlashCallOptions.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = VerificationReportRequestFlashCallOptions.builder();
      }
      return this._delegatedBuilder;
    }

    public VerificationReportRequestFlashCall build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.flashCall = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new VerificationReportRequestFlashCallImpl(method, flashCall);
    }
  }
}
