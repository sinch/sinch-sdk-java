package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.domains.voice.models.requests.Control;
import com.sinch.sdk.domains.voice.models.requests.ControlUrl;
import com.sinch.sdk.domains.voice.models.svaml.SVAMLControl;
import com.sinch.sdk.domains.voice.models.v1.svaml.SvamlControl;

public class ControlDtoConverter {

  public static com.sinch.sdk.domains.voice.models.v1.svaml.SvamlControl convertControl(
      SVAMLControl _client) {
    return (com.sinch.sdk.domains.voice.models.v1.svaml.SvamlControl)
        convertControl((Control) _client);
  }

  public static com.sinch.sdk.domains.voice.models.v1.svaml.Control convertControl(
      Control _client) {
    if (null == _client) {
      return null;
    }

    if (_client instanceof SVAMLControl) {
      SVAMLControl client = (SVAMLControl) _client;
      SvamlControl.Builder dto = SvamlControl.builder();
      client
          .getInstructions()
          .ifPresent(f -> dto.setInstructions(SVAMLInstructionDtoConverter.convert(f)));
      client.getAction().ifPresent(f -> dto.setAction(SVAMLActionDtoConverter.convert(f)));
      return dto.build();
    }

    if (_client instanceof ControlUrl) {
      ControlUrl client = (ControlUrl) _client;
      return com.sinch.sdk.domains.voice.models.v1.svaml.ControlUrl.from(client.getURL());
    }
    return null;
  }
}
