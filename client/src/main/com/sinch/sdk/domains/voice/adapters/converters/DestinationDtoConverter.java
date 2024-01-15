package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.domains.voice.models.Destination;
import com.sinch.sdk.domains.voice.models.DestinationNumber;
import com.sinch.sdk.domains.voice.models.DestinationSip;
import com.sinch.sdk.domains.voice.models.DestinationUser;
import com.sinch.sdk.domains.voice.models.dto.v1.DestinationDto;
import com.sinch.sdk.domains.voice.models.dto.v1.DestinationTypeDto;
import com.sinch.sdk.models.E164PhoneNumber;
import java.util.Objects;
import java.util.logging.Logger;

public class DestinationDtoConverter {
  private static final Logger LOGGER = Logger.getLogger(DestinationDtoConverter.class.getName());

  public static DestinationDto convert(Destination client) {
    DestinationDto dto = new DestinationDto();
    if (null == client) {
      return null;
    }
    if (client instanceof DestinationNumber) {
      DestinationNumber destination = (DestinationNumber) client;
      dto.type(DestinationTypeDto.NUMBER).endpoint(destination.getPhoneNumber().stringValue());
    } else if (client instanceof DestinationUser) {
      DestinationUser destination = (DestinationUser) client;
      dto.type(DestinationTypeDto.USERNAME).endpoint(destination.getUserName());
    } else if (client instanceof DestinationSip) {
      DestinationSip destination = (DestinationSip) client;
      dto.type(DestinationTypeDto.SIP).endpoint(destination.getSIPAddress());
    } else {
      LOGGER.severe(String.format("Unexpected class '%s'", client.getClass()));
    }
    return dto;
  }

  public static Destination convert(DestinationDto dto) {
    if (null == dto) {
      return null;
    }
    Destination destination = null;
    if (Objects.equals(dto.getType(), DestinationTypeDto.NUMBER2)) {
      destination = new DestinationNumber(E164PhoneNumber.valueOf(dto.getEndpoint()));
    } else if (Objects.equals(dto.getType(), DestinationTypeDto.USERNAME2)) {
      destination = new DestinationUser(dto.getEndpoint());
    } else {
      LOGGER.severe(String.format("Unexpected type value '%s'", dto.getType()));
    }
    return destination;
  }
}
