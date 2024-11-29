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
  SendingQueuesStatusResponseImpl.JSON_PROPERTY_SCHEDULED,
  SendingQueuesStatusResponseImpl.JSON_PROPERTY_REGULAR
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SendingQueuesStatusResponseImpl implements SendingQueuesStatusResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_SCHEDULED = "scheduled";

  private OptionalValue<ExceededQueueQuotaScheduled> scheduled;

  public static final String JSON_PROPERTY_REGULAR = "regular";

  private OptionalValue<ExceededQueueQuotaRegular> regular;

  public SendingQueuesStatusResponseImpl() {}

  protected SendingQueuesStatusResponseImpl(
      OptionalValue<ExceededQueueQuotaScheduled> scheduled,
      OptionalValue<ExceededQueueQuotaRegular> regular) {
    this.scheduled = scheduled;
    this.regular = regular;
  }

  @JsonIgnore
  public ExceededQueueQuotaScheduled getScheduled() {
    return scheduled.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SCHEDULED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<ExceededQueueQuotaScheduled> scheduled() {
    return scheduled;
  }

  @JsonIgnore
  public ExceededQueueQuotaRegular getRegular() {
    return regular.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REGULAR)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<ExceededQueueQuotaRegular> regular() {
    return regular;
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
            this.scheduled, githubComMailgunDomainsHttpapiGetDomainSendingQueuesResp.scheduled)
        && Objects.equals(
            this.regular, githubComMailgunDomainsHttpapiGetDomainSendingQueuesResp.regular);
  }

  @Override
  public int hashCode() {
    return Objects.hash(scheduled, regular);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendingQueuesStatusResponseImpl {\n");
    sb.append("    scheduled: ").append(toIndentedString(scheduled)).append("\n");
    sb.append("    regular: ").append(toIndentedString(regular)).append("\n");
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
    OptionalValue<ExceededQueueQuotaScheduled> scheduled = OptionalValue.empty();
    OptionalValue<ExceededQueueQuotaRegular> regular = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_SCHEDULED)
    public Builder setScheduled(ExceededQueueQuotaScheduled scheduled) {
      this.scheduled = OptionalValue.of(scheduled);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REGULAR)
    public Builder setRegular(ExceededQueueQuotaRegular regular) {
      this.regular = OptionalValue.of(regular);
      return this;
    }

    public SendingQueuesStatusResponse build() {
      return new SendingQueuesStatusResponseImpl(scheduled, regular);
    }
  }
}
