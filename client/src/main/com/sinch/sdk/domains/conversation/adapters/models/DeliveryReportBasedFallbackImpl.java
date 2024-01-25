package com.sinch.sdk.domains.conversation.adapters.models;

import com.sinch.sdk.domains.conversation.models.DeliveryReportBasedFallback;

public class DeliveryReportBasedFallbackImpl implements DeliveryReportBasedFallback {
  private final Boolean enabled;
  private final Integer deliveryReportWaitingTime;

  private DeliveryReportBasedFallbackImpl(Boolean enabled, Integer deliveryReportWaitingTime) {
    this.enabled = enabled;
    this.deliveryReportWaitingTime = deliveryReportWaitingTime;
  }

  public Boolean getEnabled() {
    return enabled;
  }

  public Integer getDeliveryReportWaitingTime() {
    return deliveryReportWaitingTime;
  }

  @Override
  public String toString() {
    return "DeliveryReportBasedFallback{"
        + "enabled="
        + enabled
        + ", deliveryReportWaitingTime='"
        + deliveryReportWaitingTime
        + '\''
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder implements DeliveryReportBasedFallback.Builder {

    Boolean enabled;
    Integer deliveryReportWaitingTime;

    public Builder setEnabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    public Builder setDeliveryReportWaitingTime(Integer deliveryReportWaitingTime) {
      this.deliveryReportWaitingTime = deliveryReportWaitingTime;
      return this;
    }

    public DeliveryReportBasedFallbackImpl build() {
      return new DeliveryReportBasedFallbackImpl(enabled, deliveryReportWaitingTime);
    }
  }
}
