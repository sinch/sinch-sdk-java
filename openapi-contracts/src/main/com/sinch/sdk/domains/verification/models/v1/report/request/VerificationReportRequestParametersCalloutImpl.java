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
  VerificationReportRequestParametersCalloutImpl.JSON_PROPERTY_METHOD,
  VerificationReportRequestParametersCalloutImpl.JSON_PROPERTY_CALLOUT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationReportRequestParametersCalloutImpl
    implements VerificationReportRequestParametersCallout {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<MethodEnum> method;

  public static final String JSON_PROPERTY_CALLOUT = "callout";

  private OptionalValue<VerificationReportRequestParametersCalloutOptions> callout;

  public VerificationReportRequestParametersCalloutImpl() {}

  protected VerificationReportRequestParametersCalloutImpl(
      OptionalValue<MethodEnum> method,
      OptionalValue<VerificationReportRequestParametersCalloutOptions> callout) {
    this.method = method;
    this.callout = callout;
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
  public VerificationReportRequestParametersCalloutOptions getCallout() {
    return callout.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALLOUT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<VerificationReportRequestParametersCalloutOptions> callout() {
    return callout;
  }

  /** Return true if this CalloutVerificationReportRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationReportRequestParametersCalloutImpl calloutVerificationReportRequest =
        (VerificationReportRequestParametersCalloutImpl) o;
    return Objects.equals(this.method, calloutVerificationReportRequest.method)
        && Objects.equals(this.callout, calloutVerificationReportRequest.callout);
  }

  @Override
  public int hashCode() {
    return Objects.hash(method, callout);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationReportRequestParametersCalloutImpl {\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    callout: ").append(toIndentedString(callout)).append("\n");
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
  static class Builder implements VerificationReportRequestParametersCallout.Builder {
    OptionalValue<MethodEnum> method = OptionalValue.empty();
    OptionalValue<VerificationReportRequestParametersCalloutOptions> callout =
        OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_METHOD)
    public Builder setMethod(MethodEnum method) {
      this.method = OptionalValue.of(method);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALLOUT)
    public Builder setCallout(VerificationReportRequestParametersCalloutOptions callout) {
      this.callout = OptionalValue.of(callout);
      return this;
    }

    public VerificationReportRequestParametersCallout build() {
      return new VerificationReportRequestParametersCalloutImpl(method, callout);
    }
  }
}
