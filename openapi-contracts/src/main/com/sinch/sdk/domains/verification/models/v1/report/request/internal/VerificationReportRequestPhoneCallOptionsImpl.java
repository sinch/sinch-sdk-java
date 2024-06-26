package com.sinch.sdk.domains.verification.models.v1.report.request.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({VerificationReportRequestPhoneCallOptionsImpl.JSON_PROPERTY_CODE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationReportRequestPhoneCallOptionsImpl
    implements VerificationReportRequestPhoneCallOptions {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CODE = "code";

  private OptionalValue<String> code;

  public VerificationReportRequestPhoneCallOptionsImpl() {}

  protected VerificationReportRequestPhoneCallOptionsImpl(OptionalValue<String> code) {
    this.code = code;
  }

  @JsonIgnore
  public String getCode() {
    return code.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> code() {
    return code;
  }

  /** Return true if this VerificationReportRequestPhoneCall_callout object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationReportRequestPhoneCallOptionsImpl verificationReportRequestPhoneCallCallout =
        (VerificationReportRequestPhoneCallOptionsImpl) o;
    return Objects.equals(this.code, verificationReportRequestPhoneCallCallout.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationReportRequestPhoneCallOptionsImpl {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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
  static class Builder implements VerificationReportRequestPhoneCallOptions.Builder {
    OptionalValue<String> code = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CODE)
    public Builder setCode(String code) {
      this.code = OptionalValue.of(code);
      return this;
    }

    public VerificationReportRequestPhoneCallOptions build() {
      return new VerificationReportRequestPhoneCallOptionsImpl(code);
    }
  }
}
