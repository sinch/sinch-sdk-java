package com.sinch.sdk.domains.verification.models.v1.report.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import com.sinch.sdk.domains.verification.models.v1.VerificationStatus;
import com.sinch.sdk.domains.verification.models.v1.VerificationStatusReason;
import java.util.Objects;

@JsonPropertyOrder({
  VerificationReportResponseFlashCallImpl.JSON_PROPERTY_ID,
  VerificationReportResponseFlashCallImpl.JSON_PROPERTY_METHOD,
  VerificationReportResponseFlashCallImpl.JSON_PROPERTY_STATUS,
  VerificationReportResponseFlashCallImpl.JSON_PROPERTY_REASON,
  VerificationReportResponseFlashCallImpl.JSON_PROPERTY_CALL_COMPLETE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationReportResponseFlashCallImpl
    implements VerificationReportResponseFlashCall,
        com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<VerificationMethod> method;

  public static final String JSON_PROPERTY_STATUS = "status";

  private OptionalValue<VerificationStatus> status;

  public static final String JSON_PROPERTY_REASON = "reason";

  private OptionalValue<VerificationStatusReason> reason;

  public static final String JSON_PROPERTY_CALL_COMPLETE = "callComplete";

  private OptionalValue<Boolean> callComplete;

  public VerificationReportResponseFlashCallImpl() {}

  protected VerificationReportResponseFlashCallImpl(
      OptionalValue<String> id,
      OptionalValue<VerificationMethod> method,
      OptionalValue<VerificationStatus> status,
      OptionalValue<VerificationStatusReason> reason,
      OptionalValue<Boolean> callComplete) {
    this.id = id;
    this.method = method;
    this.status = status;
    this.reason = reason;
    this.callComplete = callComplete;
  }

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> id() {
    return id;
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
  public VerificationStatus getStatus() {
    return status.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<VerificationStatus> status() {
    return status;
  }

  @JsonIgnore
  public VerificationStatusReason getReason() {
    return reason.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<VerificationStatusReason> reason() {
    return reason;
  }

  @JsonIgnore
  public Boolean getCallComplete() {
    return callComplete.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALL_COMPLETE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> callComplete() {
    return callComplete;
  }

  /** Return true if this VerificationReportResponseFlashCall object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationReportResponseFlashCallImpl verificationReportResponseFlashCall =
        (VerificationReportResponseFlashCallImpl) o;
    return Objects.equals(this.id, verificationReportResponseFlashCall.id)
        && Objects.equals(this.method, verificationReportResponseFlashCall.method)
        && Objects.equals(this.status, verificationReportResponseFlashCall.status)
        && Objects.equals(this.reason, verificationReportResponseFlashCall.reason)
        && Objects.equals(this.callComplete, verificationReportResponseFlashCall.callComplete);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, method, status, reason, callComplete);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationReportResponseFlashCallImpl {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    callComplete: ").append(toIndentedString(callComplete)).append("\n");
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
  static class Builder implements VerificationReportResponseFlashCall.Builder {
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<VerificationMethod> method = OptionalValue.of(VerificationMethod.FLASH_CALL);
    OptionalValue<VerificationStatus> status = OptionalValue.empty();
    OptionalValue<VerificationStatusReason> reason = OptionalValue.empty();
    OptionalValue<Boolean> callComplete = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ID)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_METHOD, required = true)
    Builder setMethod(VerificationMethod method) {
      if (!Objects.equals(method, VerificationMethod.FLASH_CALL)) {
        throw new IllegalArgumentException(
            String.format(
                "'method' must be '%s' (is '%s')", VerificationMethod.FLASH_CALL, method));
      }
      return this;
    }

    @JsonProperty(JSON_PROPERTY_STATUS)
    public Builder setStatus(VerificationStatus status) {
      this.status = OptionalValue.of(status);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REASON)
    public Builder setReason(VerificationStatusReason reason) {
      this.reason = OptionalValue.of(reason);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALL_COMPLETE)
    public Builder setCallComplete(Boolean callComplete) {
      this.callComplete = OptionalValue.of(callComplete);
      return this;
    }

    public VerificationReportResponseFlashCall build() {
      return new VerificationReportResponseFlashCallImpl(id, method, status, reason, callComplete);
    }
  }
}
