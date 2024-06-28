package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.numbers.models.Capability;
import com.sinch.sdk.domains.numbers.models.NumberPattern;
import com.sinch.sdk.domains.numbers.models.NumberType;
import com.sinch.sdk.domains.numbers.models.SearchPattern;
import com.sinch.sdk.domains.numbers.models.requests.AvailableNumberRentAnyRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.RentSMSConfigurationRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.RentVoiceConfigurationRequestParameters;
import com.sinch.sdk.domains.numbers.models.v1.SearchPosition;
import com.sinch.sdk.domains.numbers.models.v1.SmsConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.VoiceConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.available.request.AvailableNumberRentAnyRequest;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class AvailableRentAnyRequestParametersDtoConverterTest {

  @Test
  void convert() {
    AvailableNumberRentAnyRequestParameters parameters =
        AvailableNumberRentAnyRequestParameters.builder()
            .setRegionCode("region code")
            .setType(NumberType.from("foo type"))
            .setNumberPattern(
                NumberPattern.builder()
                    .setPattern("pattern")
                    .setSearchPattern(SearchPattern.CONTAINS)
                    .build())
            .setCapabilities(Collections.singletonList(Capability.SMS))
            .setSmsConfiguration(
                RentSMSConfigurationRequestParameters.builder()
                    .setCampaignId("campaign id")
                    .setServicePlanId("service plan")
                    .build())
            .setVoiceConfiguration(
                RentVoiceConfigurationRequestParameters.builder().setAppId("app id").build())
            .setCallbackUrl("callback url")
            .build();

    AvailableNumberRentAnyRequest expected =
        AvailableNumberRentAnyRequest.builder()
            .setRegionCode("region code")
            .setType(com.sinch.sdk.domains.numbers.models.v1.NumberType.from("foo type"))
            .setNumberPattern(
                com.sinch.sdk.domains.numbers.models.v1.SearchPattern.builder()
                    .setPattern("pattern")
                    .setPosition(SearchPosition.CONTAINS)
                    .build())
            .setCapabilities(
                Collections.singletonList(com.sinch.sdk.domains.numbers.models.v1.Capability.SMS))
            .setSmsConfiguration(
                SmsConfiguration.builder()
                    .setCampaignId("campaign id")
                    .setServicePlanId("service plan")
                    .build())
            .setVoiceConfiguration(VoiceConfiguration.builder().setAppId("app id").build())
            .setCallbackUrl("callback url")
            .build();

    AvailableNumberRentAnyRequest converted =
        AvailableRentAnyRequestParametersDtoConverter.convert(parameters);

    TestHelpers.recursiveEquals(converted, expected);
  }
}
