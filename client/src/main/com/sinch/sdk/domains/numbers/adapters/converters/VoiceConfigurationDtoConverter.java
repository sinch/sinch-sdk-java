package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.domains.numbers.models.VoiceConfiguration;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberUpdateVoiceConfigurationRequestParameters;
import com.sinch.sdk.domains.numbers.models.v1.VoiceApplicationType;

public class VoiceConfigurationDtoConverter {

  public static VoiceConfiguration convert(
      com.sinch.sdk.domains.numbers.models.v1.VoiceConfiguration dto) {

    if (null == dto) {
      return null;
    }
    return new VoiceConfiguration(
        dto.getAppId(),
        dto.getLastUpdatedTime(),
        ScheduledVoiceProvisioningDtoConverter.convert(dto.getScheduledProvisioning()));
  }

  public static com.sinch.sdk.domains.numbers.models.v1.VoiceConfiguration convert(
      ActiveNumberUpdateVoiceConfigurationRequestParameters configuration) {

    if (null == configuration) {
      return null;
    }

    com.sinch.sdk.domains.numbers.models.v1.VoiceConfiguration.Builder dto =
        com.sinch.sdk.domains.numbers.models.v1.VoiceConfiguration.builder();
    dto.setType(VoiceApplicationType.RTC);
    configuration.getAppId().ifPresent(dto::setAppId);
    return dto.build();
  }
}
