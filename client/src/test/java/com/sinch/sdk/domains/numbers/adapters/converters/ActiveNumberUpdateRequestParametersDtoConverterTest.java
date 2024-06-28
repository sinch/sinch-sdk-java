package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberUpdateRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberUpdateSMSConfigurationRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberUpdateVoiceConfigurationRequestParameters;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumberDtoTest;
import com.sinch.sdk.domains.numbers.models.v1.active.request.ActiveNumberUpdateRequest;
import org.junit.jupiter.api.Test;

class ActiveNumberUpdateRequestParametersDtoConverterTest {

  @Test
  void convert() {

    ActiveNumberUpdateSMSConfigurationRequestParameters smsConfiguration =
        ActiveNumberUpdateSMSConfigurationRequestParameters.builder()
            .setServicePlanId("service plan id")
            .setCampaignId("campaign id")
            .build();

    ActiveNumberUpdateVoiceConfigurationRequestParameters voiceConfiguration =
        ActiveNumberUpdateVoiceConfigurationRequestParameters.builder()
            .setAppId("AAAAAAAA-BBBB-CCCC-DDDD-EEEEEEEEEE")
            .build();
    ActiveNumberUpdateRequestParameters item =
        ActiveNumberUpdateRequestParameters.builder()
            .setDisplayName("a display")
            .setSmsConfiguration(smsConfiguration)
            .setVoiceConfiguration(voiceConfiguration)
            .setCallback("foo callback")
            .build();

    ActiveNumberUpdateRequest converted =
        ActiveNumberUpdateRequestParametersDtoConverter.convert(item);
    TestHelpers.recursiveEquals(converted, ActiveNumberDtoTest.activeNumberUpdateRequest);
  }
}
