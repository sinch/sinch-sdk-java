package com.sinch.sdk.domains.mailgun.models.v1.emails.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.time.Instant;
import java.util.Objects;

@JsonPropertyOrder({
  QueueStatusDisabledDetailsImpl.JSON_PROPERTY_UNTIL,
  QueueStatusDisabledDetailsImpl.JSON_PROPERTY_REASON
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class QueueStatusDisabledDetailsImpl implements QueueStatusDisabledDetails {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_UNTIL = "until";

  private OptionalValue<Instant> until;

  public static final String JSON_PROPERTY_REASON = "reason";

  private OptionalValue<String> reason;

  public QueueStatusDisabledDetailsImpl() {}

  protected QueueStatusDisabledDetailsImpl(
      OptionalValue<Instant> until, OptionalValue<String> reason) {
    this.until = until;
    this.reason = reason;
  }

  @JsonIgnore
  public Instant getUntil() {
    return until.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_UNTIL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Instant> until() {
    return until;
  }

  @JsonIgnore
  public String getReason() {
    return reason.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> reason() {
    return reason;
  }

  /**
   * Return true if this github.com-mailgun-domains-httpapi-ExceededQueueQuotaDisabledJSON object is
   * equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QueueStatusDisabledDetailsImpl githubComMailgunDomainsHttpapiExceededQueueQuotaDisabledJSON =
        (QueueStatusDisabledDetailsImpl) o;
    return Objects.equals(
            this.until, githubComMailgunDomainsHttpapiExceededQueueQuotaDisabledJSON.until)
        && Objects.equals(
            this.reason, githubComMailgunDomainsHttpapiExceededQueueQuotaDisabledJSON.reason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(until, reason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QueueStatusDisabledDetailsImpl {\n");
    sb.append("    until: ").append(toIndentedString(until)).append("\n");
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
  static class Builder implements QueueStatusDisabledDetails.Builder {
    OptionalValue<Instant> until = OptionalValue.empty();
    OptionalValue<String> reason = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_UNTIL, required = true)
    public Builder setUntil(Instant until) {
      this.until = OptionalValue.of(until);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_REASON, required = true)
    public Builder setReason(String reason) {
      this.reason = OptionalValue.of(reason);
      return this;
    }

    public QueueStatusDisabledDetails build() {
      return new QueueStatusDisabledDetailsImpl(until, reason);
    }
  }
}
