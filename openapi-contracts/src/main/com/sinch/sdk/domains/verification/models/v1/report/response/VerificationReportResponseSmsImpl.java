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
  VerificationReportResponseSmsImpl.JSON_PROPERTY_ID,
  VerificationReportResponseSmsImpl.JSON_PROPERTY_METHOD,
  VerificationReportResponseSmsImpl.JSON_PROPERTY_STATUS,
  VerificationReportResponseSmsImpl.JSON_PROPERTY_REASON
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationReportResponseSmsImpl
    implements VerificationReportResponseSms,
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

  public VerificationReportResponseSmsImpl() {}

  protected VerificationReportResponseSmsImpl(
      OptionalValue<String> id,
      OptionalValue<VerificationMethod> method,
      OptionalValue<VerificationStatus> status,
      OptionalValue<VerificationStatusReason> reason) {
    this.id = id;
    this.method = method;
    this.status = status;
    this.reason = reason;
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

  /** Return true if this VerificationReportResponseSms object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationReportResponseSmsImpl verificationReportResponseSms =
        (VerificationReportResponseSmsImpl) o;
    return Objects.equals(this.id, verificationReportResponseSms.id)
        && Objects.equals(this.method, verificationReportResponseSms.method)
        && Objects.equals(this.status, verificationReportResponseSms.status)
        && Objects.equals(this.reason, verificationReportResponseSms.reason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, method, status, reason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationReportResponseSmsImpl {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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
  static class Builder implements VerificationReportResponseSms.Builder {
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<VerificationMethod> method = OptionalValue.of(VerificationMethod.SMS);
    OptionalValue<VerificationStatus> status = OptionalValue.empty();
    OptionalValue<VerificationStatusReason> reason = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ID)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
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

    public VerificationReportResponseSms build() {
      return new VerificationReportResponseSmsImpl(id, method, status, reason);
    }
  }
}
