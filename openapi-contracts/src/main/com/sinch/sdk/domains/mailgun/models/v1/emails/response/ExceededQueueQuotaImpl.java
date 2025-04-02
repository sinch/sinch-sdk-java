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
  ExceededQueueQuotaImpl.JSON_PROPERTY_IS_DISABLED,
  ExceededQueueQuotaImpl.JSON_PROPERTY_DISABLED
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ExceededQueueQuotaImpl implements ExceededQueueQuota {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_IS_DISABLED = "is_disabled";

  private OptionalValue<Boolean> isDisabled;

  public static final String JSON_PROPERTY_DISABLED = "disabled";

  private OptionalValue<QueueStatusDisabledDetails> details;

  public ExceededQueueQuotaImpl() {}

  protected ExceededQueueQuotaImpl(
      OptionalValue<Boolean> isDisabled, OptionalValue<QueueStatusDisabledDetails> details) {
    this.isDisabled = isDisabled;
    this.details = details;
  }

  @JsonIgnore
  public Boolean getIsDisabled() {
    return isDisabled.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IS_DISABLED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Boolean> isDisabled() {
    return isDisabled;
  }

  @JsonIgnore
  public QueueStatusDisabledDetails getDetails() {
    return details.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DISABLED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<QueueStatusDisabledDetails> details() {
    return details;
  }

  /**
   * Return true if this github.com-mailgun-domains-httpapi-ExceededQueueQuotaJSON object is equal
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
    ExceededQueueQuotaImpl githubComMailgunDomainsHttpapiExceededQueueQuotaJSON =
        (ExceededQueueQuotaImpl) o;
    return Objects.equals(
            this.isDisabled, githubComMailgunDomainsHttpapiExceededQueueQuotaJSON.isDisabled)
        && Objects.equals(
            this.details, githubComMailgunDomainsHttpapiExceededQueueQuotaJSON.details);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isDisabled, details);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExceededQueueQuotaImpl {\n");
    sb.append("    isDisabled: ").append(toIndentedString(isDisabled)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
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
  static class Builder implements ExceededQueueQuota.Builder {
    OptionalValue<Boolean> isDisabled = OptionalValue.empty();
    OptionalValue<QueueStatusDisabledDetails> details = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_IS_DISABLED, required = true)
    public Builder setIsDisabled(Boolean isDisabled) {
      this.isDisabled = OptionalValue.of(isDisabled);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DISABLED)
    public Builder setDetails(QueueStatusDisabledDetails details) {
      this.details = OptionalValue.of(details);
      return this;
    }

    public ExceededQueueQuota build() {
      return new ExceededQueueQuotaImpl(isDisabled, details);
    }
  }
}
