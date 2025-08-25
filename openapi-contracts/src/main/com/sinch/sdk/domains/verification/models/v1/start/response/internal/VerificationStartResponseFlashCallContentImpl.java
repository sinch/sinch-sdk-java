package com.sinch.sdk.domains.verification.models.v1.start.response.internal;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({
  VerificationStartResponseFlashCallContentImpl.JSON_PROPERTY_CLI_FILTER,
  VerificationStartResponseFlashCallContentImpl.JSON_PROPERTY_INTERCEPTION_TIMEOUT,
  VerificationStartResponseFlashCallContentImpl.JSON_PROPERTY_REPORT_TIMEOUT,
  VerificationStartResponseFlashCallContentImpl.JSON_PROPERTY_DENY_CALL_AFTER
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationStartResponseFlashCallContentImpl
    implements VerificationStartResponseFlashCallContent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CLI_FILTER = "cliFilter";

  private OptionalValue<String> cliFilter;

  public static final String JSON_PROPERTY_INTERCEPTION_TIMEOUT = "interceptionTimeout";

  private OptionalValue<Integer> interceptionTimeout;

  public static final String JSON_PROPERTY_REPORT_TIMEOUT = "reportTimeout";

  private OptionalValue<Integer> reportTimeout;

  public static final String JSON_PROPERTY_DENY_CALL_AFTER = "denyCallAfter";

  private OptionalValue<Integer> denyCallAfter;

  /**
   * A container for additional, undeclared properties. This is a holder for any undeclared
   * properties as specified with the 'additionalProperties' keyword in the OAS document.
   */
  private OptionalValue<Map<String, Object>> additionalProperties;

  public VerificationStartResponseFlashCallContentImpl() {}

  protected VerificationStartResponseFlashCallContentImpl(
      OptionalValue<String> cliFilter,
      OptionalValue<Integer> interceptionTimeout,
      OptionalValue<Integer> reportTimeout,
      OptionalValue<Integer> denyCallAfter,
      OptionalValue<Map<String, Object>> additionalProperties) {
    this.cliFilter = cliFilter;
    this.interceptionTimeout = interceptionTimeout;
    this.reportTimeout = reportTimeout;
    this.denyCallAfter = denyCallAfter;
    this.additionalProperties = additionalProperties;
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

  @JsonIgnore
  public Object get(String key) {

    if (null == this.additionalProperties || !additionalProperties.isPresent()) {
      return null;
    }
    return this.additionalProperties.get().get(key);
  }

  @JsonAnyGetter
  public Map<String, Object> additionalProperties() {
    if (null == this.additionalProperties || !additionalProperties.isPresent()) {
      return null;
    }
    return additionalProperties.get();
  }

  /**
   * Return true if this VerificationStartResponseFlashCall_allOf_flashCall object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationStartResponseFlashCallContentImpl verificationStartResponseFlashCallAllOfFlashCall =
        (VerificationStartResponseFlashCallContentImpl) o;
    return Objects.equals(
            this.cliFilter, verificationStartResponseFlashCallAllOfFlashCall.cliFilter)
        && Objects.equals(
            this.interceptionTimeout,
            verificationStartResponseFlashCallAllOfFlashCall.interceptionTimeout)
        && Objects.equals(
            this.reportTimeout, verificationStartResponseFlashCallAllOfFlashCall.reportTimeout)
        && Objects.equals(
            this.denyCallAfter, verificationStartResponseFlashCallAllOfFlashCall.denyCallAfter)
        && Objects.equals(
            this.additionalProperties,
            verificationStartResponseFlashCallAllOfFlashCall.additionalProperties)
        && super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        cliFilter,
        interceptionTimeout,
        reportTimeout,
        denyCallAfter,
        super.hashCode(),
        additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationStartResponseFlashCallContentImpl {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    cliFilter: ").append(toIndentedString(cliFilter)).append("\n");
    sb.append("    interceptionTimeout: ")
        .append(toIndentedString(interceptionTimeout))
        .append("\n");
    sb.append("    reportTimeout: ").append(toIndentedString(reportTimeout)).append("\n");
    sb.append("    denyCallAfter: ").append(toIndentedString(denyCallAfter)).append("\n");
    sb.append("    additionalProperties: ")
        .append(toIndentedString(additionalProperties))
        .append("\n");
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
  static class Builder implements VerificationStartResponseFlashCallContent.Builder {
    OptionalValue<String> cliFilter = OptionalValue.empty();
    OptionalValue<Integer> interceptionTimeout = OptionalValue.empty();
    OptionalValue<Integer> reportTimeout = OptionalValue.empty();
    OptionalValue<Integer> denyCallAfter = OptionalValue.empty();
    OptionalValue<Map<String, Object>> additionalProperties = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_CLI_FILTER, required = true)
    public Builder setCliFilter(String cliFilter) {
      this.cliFilter = OptionalValue.of(cliFilter);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_INTERCEPTION_TIMEOUT, required = true)
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

    @JsonAnySetter
    public Builder put(String key, Object value) {
      if (!this.additionalProperties.isPresent()) {
        this.additionalProperties = OptionalValue.of(new HashMap<String, Object>());
      }
      this.additionalProperties.get().put(key, value);
      return this;
    }

    public VerificationStartResponseFlashCallContent build() {
      return new VerificationStartResponseFlashCallContentImpl(
          cliFilter, interceptionTimeout, reportTimeout, denyCallAfter, additionalProperties);
    }
  }
}
