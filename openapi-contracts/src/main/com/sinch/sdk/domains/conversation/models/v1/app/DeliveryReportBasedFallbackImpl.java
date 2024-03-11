package com.sinch.sdk.domains.conversation.models.v1.app;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  DeliveryReportBasedFallbackImpl.JSON_PROPERTY_ENABLED,
  DeliveryReportBasedFallbackImpl.JSON_PROPERTY_DELIVERY_REPORT_WAITING_TIME
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class DeliveryReportBasedFallbackImpl implements DeliveryReportBasedFallback {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ENABLED = "enabled";

  private OptionalValue<Boolean> enabled;

  public static final String JSON_PROPERTY_DELIVERY_REPORT_WAITING_TIME =
      "delivery_report_waiting_time";

  private OptionalValue<Integer> deliveryReportWaitingTime;

  public DeliveryReportBasedFallbackImpl() {}

  protected DeliveryReportBasedFallbackImpl(
      OptionalValue<Boolean> enabled, OptionalValue<Integer> deliveryReportWaitingTime) {
    this.enabled = enabled;
    this.deliveryReportWaitingTime = deliveryReportWaitingTime;
  }

  @JsonIgnore
  public Boolean getEnabled() {
    return enabled.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ENABLED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> enabled() {
    return enabled;
  }

  @JsonIgnore
  public Integer getDeliveryReportWaitingTime() {
    return deliveryReportWaitingTime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DELIVERY_REPORT_WAITING_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> deliveryReportWaitingTime() {
    return deliveryReportWaitingTime;
  }

  /** Return true if this DeliveryReportBasedFallback object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeliveryReportBasedFallbackImpl deliveryReportBasedFallback =
        (DeliveryReportBasedFallbackImpl) o;
    return Objects.equals(this.enabled, deliveryReportBasedFallback.enabled)
        && Objects.equals(
            this.deliveryReportWaitingTime, deliveryReportBasedFallback.deliveryReportWaitingTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(enabled, deliveryReportWaitingTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeliveryReportBasedFallbackImpl {\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    deliveryReportWaitingTime: ")
        .append(toIndentedString(deliveryReportWaitingTime))
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
  static class Builder implements DeliveryReportBasedFallback.Builder {
    OptionalValue<Boolean> enabled = OptionalValue.empty();
    OptionalValue<Integer> deliveryReportWaitingTime = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ENABLED)
    public Builder setEnabled(Boolean enabled) {
      this.enabled = OptionalValue.of(enabled);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DELIVERY_REPORT_WAITING_TIME)
    public Builder setDeliveryReportWaitingTime(Integer deliveryReportWaitingTime) {
      this.deliveryReportWaitingTime = OptionalValue.of(deliveryReportWaitingTime);
      return this;
    }

    public DeliveryReportBasedFallback build() {
      return new DeliveryReportBasedFallbackImpl(enabled, deliveryReportWaitingTime);
    }
  }
}
