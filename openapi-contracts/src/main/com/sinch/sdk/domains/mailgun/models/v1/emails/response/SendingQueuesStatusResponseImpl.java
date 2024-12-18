package com.sinch.sdk.domains.mailgun.models.v1.emails.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  SendingQueuesStatusResponseImpl.JSON_PROPERTY_REGULAR,
  SendingQueuesStatusResponseImpl.JSON_PROPERTY_SCHEDULED
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SendingQueuesStatusResponseImpl implements SendingQueuesStatusResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_REGULAR = "regular";

  private OptionalValue<ExceededQueueQuota> regular;

  public static final String JSON_PROPERTY_SCHEDULED = "scheduled";

  private OptionalValue<ExceededQueueQuota> scheduled;

  public SendingQueuesStatusResponseImpl() {}

  protected SendingQueuesStatusResponseImpl(
      OptionalValue<ExceededQueueQuota> regular, OptionalValue<ExceededQueueQuota> scheduled) {
    this.regular = regular;
    this.scheduled = scheduled;
  }

  @JsonIgnore
  public ExceededQueueQuota getRegular() {
    return regular.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REGULAR)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<ExceededQueueQuota> regular() {
    return regular;
  }

  @JsonIgnore
  public ExceededQueueQuota getScheduled() {
    return scheduled.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SCHEDULED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<ExceededQueueQuota> scheduled() {
    return scheduled;
  }

  /**
   * Return true if this github.com-mailgun-domains-httpapi-GetDomainSendingQueuesResp object is
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
    SendingQueuesStatusResponseImpl githubComMailgunDomainsHttpapiGetDomainSendingQueuesResp =
        (SendingQueuesStatusResponseImpl) o;
    return Objects.equals(
            this.regular, githubComMailgunDomainsHttpapiGetDomainSendingQueuesResp.regular)
        && Objects.equals(
            this.scheduled, githubComMailgunDomainsHttpapiGetDomainSendingQueuesResp.scheduled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(regular, scheduled);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendingQueuesStatusResponseImpl {\n");
    sb.append("    regular: ").append(toIndentedString(regular)).append("\n");
    sb.append("    scheduled: ").append(toIndentedString(scheduled)).append("\n");
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
  static class Builder implements SendingQueuesStatusResponse.Builder {
    OptionalValue<ExceededQueueQuota> regular = OptionalValue.empty();
    OptionalValue<ExceededQueueQuota> scheduled = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_REGULAR)
    public Builder setRegular(ExceededQueueQuota regular) {
      this.regular = OptionalValue.of(regular);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SCHEDULED)
    public Builder setScheduled(ExceededQueueQuota scheduled) {
      this.scheduled = OptionalValue.of(scheduled);
      return this;
    }

    public SendingQueuesStatusResponse build() {
      return new SendingQueuesStatusResponseImpl(regular, scheduled);
    }
  }
}
