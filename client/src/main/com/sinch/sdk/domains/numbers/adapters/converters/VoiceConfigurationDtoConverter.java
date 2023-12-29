package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.domains.numbers.models.VoiceConfiguration;
import com.sinch.sdk.domains.numbers.models.dto.v1.VoiceConfigurationDto;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberUpdateVoiceConfigurationRequestParameters;

public class VoiceConfigurationDtoConverter {

  public static VoiceConfiguration convert(VoiceConfigurationDto dto) {

    if (null == dto) {
      return null;
    }
    return new VoiceConfiguration(
        dto.getAppId(),
        null != dto.getLastUpdatedTime() ? dto.getLastUpdatedTime().toInstant() : null,
        ScheduledVoiceProvisioningDtoConverter.convert(dto.getScheduledVoiceProvisioning()));
  }

  public static VoiceConfigurationDto convert(
      ActiveNumberUpdateVoiceConfigurationRequestParameters configuration) {

    if (null == configuration) {
      return null;
    }

    VoiceConfigurationDto dto = new VoiceConfigurationDto();
    configuration.getAppId().ifPresent(dto::appId);
    return dto;
  }
}
