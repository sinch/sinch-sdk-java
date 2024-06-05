package com.sinch.sdk.domains.verification.models.v1.start.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  StartVerificationResponseFlashCallContentImpl.JSON_PROPERTY_CLI_FILTER,
  StartVerificationResponseFlashCallContentImpl.JSON_PROPERTY_INTERCEPTION_TIMEOUT,
  StartVerificationResponseFlashCallContentImpl.JSON_PROPERTY_REPORT_TIMEOUT,
  StartVerificationResponseFlashCallContentImpl.JSON_PROPERTY_DENY_CALL_AFTER
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StartVerificationResponseFlashCallContentImpl
    implements StartVerificationResponseFlashCallContent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CLI_FILTER = "cliFilter";

  private OptionalValue<String> cliFilter;

  public static final String JSON_PROPERTY_INTERCEPTION_TIMEOUT = "interceptionTimeout";

  private OptionalValue<Integer> interceptionTimeout;

  public static final String JSON_PROPERTY_REPORT_TIMEOUT = "reportTimeout";

  private OptionalValue<Integer> reportTimeout;

  public static final String JSON_PROPERTY_DENY_CALL_AFTER = "denyCallAfter";

  private OptionalValue<Integer> denyCallAfter;

  public StartVerificationResponseFlashCallContentImpl() {}

  protected StartVerificationResponseFlashCallContentImpl(
      OptionalValue<String> cliFilter,
      OptionalValue<Integer> interceptionTimeout,
      OptionalValue<Integer> reportTimeout,
      OptionalValue<Integer> denyCallAfter) {
    this.cliFilter = cliFilter;
    this.interceptionTimeout = interceptionTimeout;
    this.reportTimeout = reportTimeout;
    this.denyCallAfter = denyCallAfter;
  }

  @JsonIgnore
  public String getCliFilter() {
    return cliFilter.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CLI_FILTER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> cliFilter() {
    return cliFilter;
  }

  @JsonIgnore
  public Integer getInterceptionTimeout() {
    return interceptionTimeout.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_INTERCEPTION_TIMEOUT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Integer> interceptionTimeout() {
    return interceptionTimeout;
  }

  @JsonIgnore
  public Integer getReportTimeout() {
    return reportTimeout.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REPORT_TIMEOUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> reportTimeout() {
    return reportTimeout;
  }

  @JsonIgnore
  public Integer getDenyCallAfter() {
    return denyCallAfter.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DENY_CALL_AFTER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> denyCallAfter() {
    return denyCallAfter;
  }

  /** Return true if this FlashCallInitiateVerificationResponse_flashCall object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartVerificationResponseFlashCallContentImpl flashCallInitiateVerificationResponseFlashCall =
        (StartVerificationResponseFlashCallContentImpl) o;
    return Objects.equals(this.cliFilter, flashCallInitiateVerificationResponseFlashCall.cliFilter)
        && Objects.equals(
            this.interceptionTimeout,
            flashCallInitiateVerificationResponseFlashCall.interceptionTimeout)
        && Objects.equals(
            this.reportTimeout, flashCallInitiateVerificationResponseFlashCall.reportTimeout)
        && Objects.equals(
            this.denyCallAfter, flashCallInitiateVerificationResponseFlashCall.denyCallAfter);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cliFilter, interceptionTimeout, reportTimeout, denyCallAfter);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartVerificationResponseFlashCallContentImpl {\n");
    sb.append("    cliFilter: ").append(toIndentedString(cliFilter)).append("\n");
    sb.append("    interceptionTimeout: ")
        .append(toIndentedString(interceptionTimeout))
        .append("\n");
    sb.append("    reportTimeout: ").append(toIndentedString(reportTimeout)).append("\n");
    sb.append("    denyCallAfter: ").append(toIndentedString(denyCallAfter)).append("\n");
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
  static class Builder implements StartVerificationResponseFlashCallContent.Builder {
    OptionalValue<String> cliFilter = OptionalValue.empty();
    OptionalValue<Integer> interceptionTimeout = OptionalValue.empty();
    OptionalValue<Integer> reportTimeout = OptionalValue.empty();
    OptionalValue<Integer> denyCallAfter = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CLI_FILTER)
    public Builder setCliFilter(String cliFilter) {
      this.cliFilter = OptionalValue.of(cliFilter);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_INTERCEPTION_TIMEOUT)
    public Builder setInterceptionTimeout(Integer interceptionTimeout) {
      this.interceptionTimeout = OptionalValue.of(interceptionTimeout);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REPORT_TIMEOUT)
    public Builder setReportTimeout(Integer reportTimeout) {
      this.reportTimeout = OptionalValue.of(reportTimeout);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DENY_CALL_AFTER)
    public Builder setDenyCallAfter(Integer denyCallAfter) {
      this.denyCallAfter = OptionalValue.of(denyCallAfter);
      return this;
    }

    public StartVerificationResponseFlashCallContent build() {
      return new StartVerificationResponseFlashCallContentImpl(
          cliFilter, interceptionTimeout, reportTimeout, denyCallAfter);
    }
  }
}
