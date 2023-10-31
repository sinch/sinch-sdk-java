package com.sinch.sdk.domains.numbers.models.requests;

import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RentSMSConfigurationRequestParametersBuilderTest {
  RentSMSConfigurationRequestParameters value =
      RentSMSConfigurationRequestParameters.builder()
          .setServicePlanId("plan id")
          .setCampaignId("campaign id")
          .build();

  RentSMSConfigurationRequestParameters valueNoCampaign =
      RentSMSConfigurationRequestParameters.builder().setServicePlanId("plan id").build();

  @Test
  void getServicePlanId() {
    Assertions.assertThat(value.getServicePlanId()).isEqualTo("plan id");
  }

  @Test
  void getCampaignId() {
    Assertions.assertThat(value.getCampaignId()).isEqualTo(Optional.of("campaign id"));
  }

  @Test
  void geCampaignIdEmpty() {
    Assertions.assertThat(valueNoCampaign.getCampaignId()).isEqualTo(Optional.empty());
  }
}
