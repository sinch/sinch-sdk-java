package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.domains.voice.models.Destination;
import com.sinch.sdk.domains.voice.models.DestinationNumber;
import com.sinch.sdk.domains.voice.models.DestinationNumberType;
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
    DestinationTypeDto type = null;
    String endpoint = null;
    if (client instanceof DestinationNumber) {
      DestinationNumber destination = (DestinationNumber) client;
      DestinationNumberType clientType = destination.getType();
      if (clientType == DestinationNumberType.DID) {
        type = DestinationTypeDto.DID;
      } else if (clientType == DestinationNumberType.PSTN) {
        type = DestinationTypeDto.NUMBER;
      } else {
        LOGGER.severe(String.format("Unexpected type '%s'", destination.getType()));
        return dto;
      }
      endpoint = destination.getPhoneNumber().stringValue();
    } else if (client instanceof DestinationUser) {
      DestinationUser destination = (DestinationUser) client;
      type = DestinationTypeDto.USERNAME;
      endpoint = destination.getUserName();
    } else if (client instanceof DestinationSip) {
      DestinationSip destination = (DestinationSip) client;
      type = DestinationTypeDto.SIP;
      endpoint = destination.getSIPAddress();
    } else {
      LOGGER.severe(String.format("Unexpected class '%s'", client.getClass()));
    }
    if (null != type && endpoint != null) {
      dto.type(type).endpoint(endpoint);
    }
    return dto;
  }

  public static Destination convert(DestinationDto dto) {
    if (null == dto) {
      return null;
    }
    Destination destination = null;
    if (Objects.equals(dto.getType(), DestinationTypeDto.NUMBER)
        || Objects.equals(dto.getType(), DestinationTypeDto.NUMBER2)) {
      destination =
          new DestinationNumber(
              E164PhoneNumber.valueOf(dto.getEndpoint()), DestinationNumberType.PSTN);
    } else if (Objects.equals(dto.getType(), DestinationTypeDto.USERNAME)
        || Objects.equals(dto.getType(), DestinationTypeDto.USERNAME2)) {
      destination = new DestinationUser(dto.getEndpoint());
    } else if (Objects.equals(dto.getType(), DestinationTypeDto.SIP)) {
      destination = new DestinationSip(dto.getEndpoint());
    } else if (Objects.equals(dto.getType(), DestinationTypeDto.DID)) {
      destination =
          new DestinationNumber(
              E164PhoneNumber.valueOf(dto.getEndpoint()), DestinationNumberType.DID);
    } else {
      LOGGER.severe(String.format("Unexpected type value '%s'", dto.getType()));
    }
    return destination;
  }
}
