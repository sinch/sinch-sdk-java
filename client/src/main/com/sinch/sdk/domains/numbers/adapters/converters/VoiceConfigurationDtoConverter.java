package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.domains.numbers.models.VoiceConfiguration;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberUpdateVoiceConfigurationRequestParameters;
import com.sinch.sdk.domains.numbers.models.v1.VoiceConfigurationRTC;

public class VoiceConfigurationDtoConverter {

  public static VoiceConfiguration convert(
      com.sinch.sdk.domains.numbers.models.v1.VoiceConfiguration _dto) {

    if (null == _dto) {
      return null;
    }
    if (!(_dto instanceof VoiceConfigurationRTC)) {
      return null;
    }

    com.sinch.sdk.domains.numbers.models.v1.VoiceConfigurationRTC dto =
        (com.sinch.sdk.domains.numbers.models.v1.VoiceConfigurationRTC) _dto;
    return new VoiceConfiguration(
        dto.getAppId(),
        dto.getLastUpdatedTime(),
        ScheduledVoiceProvisioningDtoConverter.convert(dto.getScheduledProvisioning()));
  }

  public static com.sinch.sdk.domains.numbers.models.v1.VoiceConfigurationRTC convert(
      ActiveNumberUpdateVoiceConfigurationRequestParameters configuration) {

    if (null == configuration) {
      return null;
    }

    com.sinch.sdk.domains.numbers.models.v1.VoiceConfigurationRTC.Builder dto =
        com.sinch.sdk.domains.numbers.models.v1.VoiceConfigurationRTC.builder();
    configuration.getAppId().ifPresent(dto::setAppId);
    return dto.build();
  }
}
