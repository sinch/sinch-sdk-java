package com.sinch.sdk.domains.verification.models.v1.report.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  VerificationReportRequestParametersFlashCallImpl.JSON_PROPERTY_METHOD,
  VerificationReportRequestParametersFlashCallImpl.JSON_PROPERTY_FLASH_CALL
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationReportRequestParametersFlashCallImpl
    implements VerificationReportRequestParametersFlashCall {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<MethodEnum> method;

  public static final String JSON_PROPERTY_FLASH_CALL = "flashCall";

  private OptionalValue<VerificationReportRequestParametersFlashCallOptions> flashCall;

  public VerificationReportRequestParametersFlashCallImpl() {}

  protected VerificationReportRequestParametersFlashCallImpl(
      OptionalValue<MethodEnum> method,
      OptionalValue<VerificationReportRequestParametersFlashCallOptions> flashCall) {
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
  public VerificationReportRequestParametersFlashCallOptions getFlashCall() {
    return flashCall.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FLASH_CALL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<VerificationReportRequestParametersFlashCallOptions> flashCall() {
    return flashCall;
  }

  /** Return true if this FlashcallVerificationReportRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationReportRequestParametersFlashCallImpl flashcallVerificationReportRequest =
        (VerificationReportRequestParametersFlashCallImpl) o;
    return Objects.equals(this.method, flashcallVerificationReportRequest.method)
        && Objects.equals(this.flashCall, flashcallVerificationReportRequest.flashCall);
  }

  @Override
  public int hashCode() {
    return Objects.hash(method, flashCall);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationReportRequestParametersFlashCallImpl {\n");
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
  static class Builder implements VerificationReportRequestParametersFlashCall.Builder {
    OptionalValue<MethodEnum> method = OptionalValue.empty();
    OptionalValue<VerificationReportRequestParametersFlashCallOptions> flashCall =
        OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_METHOD)
    public Builder setMethod(MethodEnum method) {
      this.method = OptionalValue.of(method);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FLASH_CALL)
    public Builder setFlashCall(VerificationReportRequestParametersFlashCallOptions flashCall) {
      this.flashCall = OptionalValue.of(flashCall);
      return this;
    }

    public VerificationReportRequestParametersFlashCall build() {
      return new VerificationReportRequestParametersFlashCallImpl(method, flashCall);
    }
  }
}
