package com.sinch.sdk.domains.conversation.models;

public interface DeliveryReportBasedFallback {

  Boolean getEnabled();

  Integer getDeliveryReportWaitingTime();

  static Builder builder() {
    return BuildersDelegation.DeliveryReportBasedFallbackBuilder();
  }

  interface Builder {

    Builder setEnabled(Boolean enabled);

    Builder setDeliveryReportWaitingTime(Integer deliveryReportWaitingTime);

    DeliveryReportBasedFallback build();
  }
}
