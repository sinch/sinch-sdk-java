package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.numbers.models.requests.AvailableNumberRentRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.RentSMSConfigurationRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.RentVoiceConfigurationRequestParameters;
import com.sinch.sdk.domains.numbers.models.v1.SmsConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.VoiceConfigurationRTC;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberRentRequest;
import org.junit.jupiter.api.Test;

class AvailableRentRequestParametersDtoConverterTest {

  @Test
  void convert() {
    AvailableNumberRentRequestParameters parameters =
        AvailableNumberRentRequestParameters.builder()
            .setSmsConfiguration(
                RentSMSConfigurationRequestParameters.builder()
                    .setCampaignId("campaign id")
                    .setServicePlanId("service plan")
                    .build())
            .setVoiceConfiguration(
                RentVoiceConfigurationRequestParameters.builder().setAppId("app id").build())
            .setCallbackUrl("callback url")
            .build();

    AvailableNumberRentRequest expected =
        AvailableNumberRentRequest.builder()
            .setSmsConfiguration(
                SmsConfiguration.builder()
                    .setCampaignId("campaign id")
                    .setServicePlanId("service plan")
                    .build())
            .setVoiceConfiguration(VoiceConfigurationRTC.builder().setAppId("app id").build())
            .setCallbackUrl("callback url")
            .build();
    AvailableNumberRentRequest converted =
        AvailableRentRequestParametersDtoConverter.convert(parameters);
    TestHelpers.recursiveEquals(converted, expected);
  }
}
