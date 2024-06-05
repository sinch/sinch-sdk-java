package com.sinch.sdk.domains.verification.models.v1.webhooks;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  FlashCallRequestEventResponseFlashCallContentImpl.JSON_PROPERTY_CLI,
  FlashCallRequestEventResponseFlashCallContentImpl.JSON_PROPERTY_DIAL_TIMEOUT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class FlashCallRequestEventResponseFlashCallContentImpl
    implements FlashCallRequestEventResponseFlashCallContent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CLI = "cli";

  private OptionalValue<String> cli;

  public static final String JSON_PROPERTY_DIAL_TIMEOUT = "dialTimeout";

  private OptionalValue<Integer> dialTimeout;

  public FlashCallRequestEventResponseFlashCallContentImpl() {}

  protected FlashCallRequestEventResponseFlashCallContentImpl(
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

  /** Return true if this FlashCallRequestEventResponse_flashCall object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FlashCallRequestEventResponseFlashCallContentImpl flashCallRequestEventResponseFlashCall =
        (FlashCallRequestEventResponseFlashCallContentImpl) o;
    return Objects.equals(this.cli, flashCallRequestEventResponseFlashCall.cli)
        && Objects.equals(this.dialTimeout, flashCallRequestEventResponseFlashCall.dialTimeout);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cli, dialTimeout);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FlashCallRequestEventResponseFlashCallContentImpl {\n");
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
  static class Builder implements FlashCallRequestEventResponseFlashCallContent.Builder {
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

    public FlashCallRequestEventResponseFlashCallContent build() {
      return new FlashCallRequestEventResponseFlashCallContentImpl(cli, dialTimeout);
    }
  }
}
