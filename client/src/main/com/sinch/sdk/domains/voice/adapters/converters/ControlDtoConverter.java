package com.sinch.sdk.domains.voice.adapters.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.voice.models.requests.Control;
import com.sinch.sdk.domains.voice.models.requests.ControlUrl;
import com.sinch.sdk.domains.voice.models.svaml.SVAMLControl;
import java.util.logging.Logger;

public class ControlDtoConverter {

  private static final Logger LOGGER = Logger.getLogger(SVAMLActionDtoConverter.class.getName());

  public static String convert(Control client) {
    if (null == client) {
      return null;
    }
    String dto;
    if (client instanceof SVAMLControl) {
      SVAMLControl value = (SVAMLControl) client;
      dto = convertControlToEscapedJSON(value);
    } else if (client instanceof ControlUrl) {
      ControlUrl value = (ControlUrl) client;
      dto = value.getURL();
    } else {
      LOGGER.severe(String.format("Unexpected class '%s'", client.getClass()));
      dto = client.toString();
    }
    return dto;
  }

  private static String convertControlToEscapedJSON(SVAMLControl client) {
    try {
      return Mapper.getInstance().writeValueAsString(CallsDtoConverter.convert(client));
    } catch (JsonProcessingException e) {
      throw new ApiMappingException(client.toString(), e);
    }
  }
}
