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
  ExceededQueueQuotaRegularImpl.JSON_PROPERTY_DISABLED,
  ExceededQueueQuotaRegularImpl.JSON_PROPERTY_IS_DISABLED
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ExceededQueueQuotaRegularImpl implements ExceededQueueQuotaRegular {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_DISABLED = "disabled";

  private OptionalValue<QueueStatusDisabledDetails> disabled;

  public static final String JSON_PROPERTY_IS_DISABLED = "is_disabled";

  private OptionalValue<Boolean> isDisabled;

  public ExceededQueueQuotaRegularImpl() {}

  protected ExceededQueueQuotaRegularImpl(
      OptionalValue<QueueStatusDisabledDetails> disabled, OptionalValue<Boolean> isDisabled) {
    this.disabled = disabled;
    this.isDisabled = isDisabled;
  }

  @JsonIgnore
  public QueueStatusDisabledDetails getDisabled() {
    return disabled.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DISABLED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<QueueStatusDisabledDetails> disabled() {
    return disabled;
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
    ExceededQueueQuotaRegularImpl githubComMailgunDomainsHttpapiExceededQueueQuotaJSON =
        (ExceededQueueQuotaRegularImpl) o;
    return Objects.equals(
            this.disabled, githubComMailgunDomainsHttpapiExceededQueueQuotaJSON.disabled)
        && Objects.equals(
            this.isDisabled, githubComMailgunDomainsHttpapiExceededQueueQuotaJSON.isDisabled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(disabled, isDisabled);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExceededQueueQuotaRegularImpl {\n");
    sb.append("    disabled: ").append(toIndentedString(disabled)).append("\n");
    sb.append("    isDisabled: ").append(toIndentedString(isDisabled)).append("\n");
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
  static class Builder implements ExceededQueueQuotaRegular.Builder {
    OptionalValue<QueueStatusDisabledDetails> disabled = OptionalValue.empty();
    OptionalValue<Boolean> isDisabled = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_DISABLED)
    public Builder setDisabled(QueueStatusDisabledDetails disabled) {
      this.disabled = OptionalValue.of(disabled);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_IS_DISABLED)
    public Builder setIsDisabled(Boolean isDisabled) {
      this.isDisabled = OptionalValue.of(isDisabled);
      return this;
    }

    public ExceededQueueQuotaRegular build() {
      return new ExceededQueueQuotaRegularImpl(disabled, isDisabled);
    }
  }
}
