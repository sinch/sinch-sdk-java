package com.sinch.sdk.domains.numbers.adapters.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sinch.sdk.domains.numbers.models.dto.v1.ActiveNumberRequestDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.SMSConfigurationDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.VoiceConfigurationDto;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberUpdateRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberUpdateSMSConfigurationRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberUpdateVoiceConfigurationRequestParameters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ActiveNumberUpdateRequestParametersDtoConverterTest {

  ActiveNumberUpdateRequestParameters item;

  public static void compareWithDto(
      ActiveNumberUpdateSMSConfigurationRequestParameters client, SMSConfigurationDto dto) {
    assertEquals(dto.getServicePlanIdDefined(), client.getServicePlanId().isPresent());
    assertEquals(dto.getServicePlanId(), client.getServicePlanId().get());
    assertEquals(dto.getCampaignIdDefined(), client.getCampaignId().isPresent());
    assertEquals(dto.getCampaignId(), client.getCampaignId().get());
  }

  public static void compareWithDto(
      ActiveNumberUpdateVoiceConfigurationRequestParameters client, VoiceConfigurationDto dto) {
    assertEquals(dto.getAppIdDefined(), client.getAppId().isPresent());
    assertEquals(dto.getAppId(), client.getAppId().get());
  }

  public static void compareWithDto(
      ActiveNumberUpdateRequestParameters client, ActiveNumberRequestDto dto) {
    assertEquals(dto.getDisplayName(), client.getDisplayName().get());
    compareWithDto(client.getSmsConfiguration().get(), dto.getSmsConfiguration());
    compareWithDto(client.getVoiceConfiguration().get(), dto.getVoiceConfiguration());
    assertEquals(dto.getCallbackUrl(), client.getCallback().get());
  }

  @Test
  void convert() {
    ActiveNumberRequestDto converted =
        ActiveNumberUpdateRequestParametersDtoConverter.convert(item);
    compareWithDto(item, converted);
  }

  @BeforeEach
  void setUp() {
    ActiveNumberUpdateSMSConfigurationRequestParameters smsConfiguration =
        ActiveNumberUpdateSMSConfigurationRequestParameters.builder()
            .setServicePlanId("service plan id")
            .setCampaignId("campaign id")
            .build();

    ActiveNumberUpdateVoiceConfigurationRequestParameters voiceConfiguration =
        ActiveNumberUpdateVoiceConfigurationRequestParameters.builder().setAppId("app id").build();
    item =
        ActiveNumberUpdateRequestParameters.builder()
            .setDisplayName("my display name")
            .setSmsConfiguration(smsConfiguration)
            .setVoiceConfiguration(voiceConfiguration)
            .setCallback("foo callback")
            .build();
  }
}
