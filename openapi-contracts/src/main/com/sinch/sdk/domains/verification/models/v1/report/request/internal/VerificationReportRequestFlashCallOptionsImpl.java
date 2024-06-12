package com.sinch.sdk.domains.verification.models.v1.report.request.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({VerificationReportRequestFlashCallOptionsImpl.JSON_PROPERTY_CLI})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationReportRequestFlashCallOptionsImpl
    implements VerificationReportRequestFlashCallOptions {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CLI = "cli";

  private OptionalValue<String> cli;

  public VerificationReportRequestFlashCallOptionsImpl() {}

  protected VerificationReportRequestFlashCallOptionsImpl(OptionalValue<String> cli) {
    this.cli = cli;
  }

  @JsonIgnore
  public String getCli() {
    return cli.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CLI)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> cli() {
    return cli;
  }

  /** Return true if this VerificationReportRequestFlashCall_flashCall object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationReportRequestFlashCallOptionsImpl verificationReportRequestFlashCallFlashCall =
        (VerificationReportRequestFlashCallOptionsImpl) o;
    return Objects.equals(this.cli, verificationReportRequestFlashCallFlashCall.cli);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cli);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationReportRequestFlashCallOptionsImpl {\n");
    sb.append("    cli: ").append(toIndentedString(cli)).append("\n");
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
  static class Builder implements VerificationReportRequestFlashCallOptions.Builder {
    OptionalValue<String> cli = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CLI)
    public Builder setCli(String cli) {
      this.cli = OptionalValue.of(cli);
      return this;
    }

    public VerificationReportRequestFlashCallOptions build() {
      return new VerificationReportRequestFlashCallOptionsImpl(cli);
    }
  }
}
