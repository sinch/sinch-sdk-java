package com.sinch.sdk.domains.numbers.models.v1.numberorder;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  OrderSmsConfigurationImpl.JSON_PROPERTY_SERVICE_PLAN_ID,
  OrderSmsConfigurationImpl.JSON_PROPERTY_CAMPAIGN_ID
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class OrderSmsConfigurationImpl implements OrderSmsConfiguration {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_SERVICE_PLAN_ID = "servicePlanId";

  private OptionalValue<String> servicePlanId;

  public static final String JSON_PROPERTY_CAMPAIGN_ID = "campaignId";

  private OptionalValue<String> campaignId;

  public OrderSmsConfigurationImpl() {}

  protected OrderSmsConfigurationImpl(
      OptionalValue<String> servicePlanId, OptionalValue<String> campaignId) {
    this.servicePlanId = servicePlanId;
    this.campaignId = campaignId;
  }

  @JsonIgnore
  public String getServicePlanId() {
    return servicePlanId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SERVICE_PLAN_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> servicePlanId() {
    return servicePlanId;
  }

  @JsonIgnore
  public String getCampaignId() {
    return campaignId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CAMPAIGN_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> campaignId() {
    return campaignId;
  }

  /** Return true if this OrderSmsConfiguration object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderSmsConfigurationImpl orderSmsConfiguration = (OrderSmsConfigurationImpl) o;
    return Objects.equals(this.servicePlanId, orderSmsConfiguration.servicePlanId)
        && Objects.equals(this.campaignId, orderSmsConfiguration.campaignId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(servicePlanId, campaignId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderSmsConfigurationImpl {\n");
    sb.append("    servicePlanId: ").append(toIndentedString(servicePlanId)).append("\n");
    sb.append("    campaignId: ").append(toIndentedString(campaignId)).append("\n");
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
  static class Builder implements OrderSmsConfiguration.Builder {
    OptionalValue<String> servicePlanId = OptionalValue.empty();
    OptionalValue<String> campaignId = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_SERVICE_PLAN_ID, required = true)
    public Builder setServicePlanId(String servicePlanId) {
      this.servicePlanId = OptionalValue.of(servicePlanId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CAMPAIGN_ID)
    public Builder setCampaignId(String campaignId) {
      this.campaignId = OptionalValue.of(campaignId);
      return this;
    }

    public OrderSmsConfiguration build() {
      return new OrderSmsConfigurationImpl(servicePlanId, campaignId);
    }
  }
}
