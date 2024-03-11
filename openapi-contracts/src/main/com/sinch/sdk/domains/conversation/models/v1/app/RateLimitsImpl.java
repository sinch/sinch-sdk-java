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
  RateLimitsImpl.JSON_PROPERTY_INBOUND,
  RateLimitsImpl.JSON_PROPERTY_OUTBOUND,
  RateLimitsImpl.JSON_PROPERTY_WEBHOOKS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class RateLimitsImpl implements RateLimits {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_INBOUND = "inbound";

  private OptionalValue<Long> inbound;

  public static final String JSON_PROPERTY_OUTBOUND = "outbound";

  private OptionalValue<Long> outbound;

  public static final String JSON_PROPERTY_WEBHOOKS = "webhooks";

  private OptionalValue<Long> webhooks;

  public RateLimitsImpl() {}

  protected RateLimitsImpl(
      OptionalValue<Long> inbound, OptionalValue<Long> outbound, OptionalValue<Long> webhooks) {
    this.inbound = inbound;
    this.outbound = outbound;
    this.webhooks = webhooks;
  }

  @JsonIgnore
  public Long getInbound() {
    return inbound.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_INBOUND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Long> inbound() {
    return inbound;
  }

  @JsonIgnore
  public Long getOutbound() {
    return outbound.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_OUTBOUND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Long> outbound() {
    return outbound;
  }

  @JsonIgnore
  public Long getWebhooks() {
    return webhooks.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_WEBHOOKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Long> webhooks() {
    return webhooks;
  }

  /** Return true if this RateLimits object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RateLimitsImpl rateLimits = (RateLimitsImpl) o;
    return Objects.equals(this.inbound, rateLimits.inbound)
        && Objects.equals(this.outbound, rateLimits.outbound)
        && Objects.equals(this.webhooks, rateLimits.webhooks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inbound, outbound, webhooks);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RateLimitsImpl {\n");
    sb.append("    inbound: ").append(toIndentedString(inbound)).append("\n");
    sb.append("    outbound: ").append(toIndentedString(outbound)).append("\n");
    sb.append("    webhooks: ").append(toIndentedString(webhooks)).append("\n");
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
  static class Builder implements RateLimits.Builder {
    OptionalValue<Long> inbound = OptionalValue.empty();
    OptionalValue<Long> outbound = OptionalValue.empty();
    OptionalValue<Long> webhooks = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_INBOUND)
    public Builder setInbound(Long inbound) {
      this.inbound = OptionalValue.of(inbound);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_OUTBOUND)
    public Builder setOutbound(Long outbound) {
      this.outbound = OptionalValue.of(outbound);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_WEBHOOKS)
    public Builder setWebhooks(Long webhooks) {
      this.webhooks = OptionalValue.of(webhooks);
      return this;
    }

    public RateLimits build() {
      return new RateLimitsImpl(inbound, outbound, webhooks);
    }
  }
}
