package com.sinch.sdk.domains.verification.models.v1.webhooks.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  VerificationRequestEventResponseFlashCallContentImpl.JSON_PROPERTY_CLI,
  VerificationRequestEventResponseFlashCallContentImpl.JSON_PROPERTY_DIAL_TIMEOUT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationRequestEventResponseFlashCallContentImpl
    implements VerificationRequestEventResponseFlashCallContent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CLI = "cli";

  private OptionalValue<String> cli;

  public static final String JSON_PROPERTY_DIAL_TIMEOUT = "dialTimeout";

  private OptionalValue<Integer> dialTimeout;

  public VerificationRequestEventResponseFlashCallContentImpl() {}

  protected VerificationRequestEventResponseFlashCallContentImpl(
      OptionalValue<String> cli, OptionalValue<Integer> dialTimeout) {
    this.cli = cli;
    this.dialTimeout = dialTimeout;
  }

  @JsonIgnore
  public String getCli() {
    return cli.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CLI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> cli() {
    return cli;
  }

  @JsonIgnore
  public Integer getDialTimeout() {
    return dialTimeout.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DIAL_TIMEOUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> dialTimeout() {
    return dialTimeout;
  }

  /**
   * Return true if this VerificationRequestEventResponseFlashCall_allOf_flashCall object is equal
   * to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationRequestEventResponseFlashCallContentImpl
        verificationRequestEventResponseFlashCallAllOfFlashCall =
            (VerificationRequestEventResponseFlashCallContentImpl) o;
    return Objects.equals(this.cli, verificationRequestEventResponseFlashCallAllOfFlashCall.cli)
        && Objects.equals(
            this.dialTimeout, verificationRequestEventResponseFlashCallAllOfFlashCall.dialTimeout);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cli, dialTimeout);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationRequestEventResponseFlashCallContentImpl {\n");
    sb.append("    cli: ").append(toIndentedString(cli)).append("\n");
    sb.append("    dialTimeout: ").append(toIndentedString(dialTimeout)).append("\n");
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
  static class Builder implements VerificationRequestEventResponseFlashCallContent.Builder {
    OptionalValue<String> cli = OptionalValue.empty();
    OptionalValue<Integer> dialTimeout = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CLI)
    public Builder setCli(String cli) {
      this.cli = OptionalValue.of(cli);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DIAL_TIMEOUT)
    public Builder setDialTimeout(Integer dialTimeout) {
      this.dialTimeout = OptionalValue.of(dialTimeout);
      return this;
    }

    public VerificationRequestEventResponseFlashCallContent build() {
      return new VerificationRequestEventResponseFlashCallContentImpl(cli, dialTimeout);
    }
  }
}
