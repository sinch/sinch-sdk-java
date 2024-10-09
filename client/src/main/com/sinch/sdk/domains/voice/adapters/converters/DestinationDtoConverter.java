package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.domains.voice.models.DestinationNumber;
import com.sinch.sdk.domains.voice.models.DestinationNumberType;
import com.sinch.sdk.domains.voice.models.DestinationSip;
import com.sinch.sdk.domains.voice.models.DestinationUser;
import com.sinch.sdk.domains.voice.models.v1.Destination;
import com.sinch.sdk.domains.voice.models.v1.DestinationType;
import com.sinch.sdk.models.E164PhoneNumber;
import java.util.Objects;
import java.util.logging.Logger;

public class DestinationDtoConverter {

  private static final Logger LOGGER = Logger.getLogger(DestinationDtoConverter.class.getName());

  public static Destination convert(com.sinch.sdk.domains.voice.models.Destination client) {

    if (null == client) {
      return null;
    }
    Destination.Builder dto = Destination.builder();
    DestinationType type = null;
    String endpoint = null;
    if (client instanceof DestinationNumber) {
      DestinationNumber destination = (DestinationNumber) client;
      if (DestinationNumberType.DID.equals(destination.getType())) {
        type = DestinationType.DID;
      } else if (DestinationNumberType.PSTN.equals(destination.getType())) {
        type = DestinationType.NUMBER;
      } else {
        LOGGER.severe(String.format("Unexpected type '%s'", destination.getType()));
      }
      endpoint = destination.getPhoneNumber().stringValue();
    } else if (client instanceof DestinationUser) {
      DestinationUser destination = (DestinationUser) client;
      type = DestinationType.USERNAME;
      endpoint = destination.getUserName();
    } else if (client instanceof DestinationSip) {
      DestinationSip destination = (DestinationSip) client;
      type = DestinationType.SIP;
      endpoint = destination.getSIPAddress();
    } else {
      LOGGER.severe(String.format("Unexpected class '%s'", client.getClass()));
    }
    if (null != type) {
      dto.setType(type);
    }
    if (null != endpoint) {
      dto.setEndpoint(endpoint);
    }

    return dto.build();
  }

  public static com.sinch.sdk.domains.voice.models.Destination convert(Destination dto) {
    if (null == dto) {
      return null;
    }
    com.sinch.sdk.domains.voice.models.Destination destination = null;
    if (Objects.equals(dto.getType(), DestinationType.NUMBER)
        || Objects.equals(dto.getType(), DestinationType.NUMBER2)) {
      destination =
          new DestinationNumber(
              E164PhoneNumber.valueOf(dto.getEndpoint()), DestinationNumberType.PSTN);
    } else if (Objects.equals(dto.getType(), DestinationType.USERNAME)
        || Objects.equals(dto.getType(), DestinationType.USERNAME2)) {
      destination = new DestinationUser(dto.getEndpoint());
    } else if (Objects.equals(dto.getType(), DestinationType.SIP)) {
      destination = new DestinationSip(dto.getEndpoint());
    } else if (Objects.equals(dto.getType(), DestinationType.DID)) {
      destination =
          new DestinationNumber(
              E164PhoneNumber.valueOf(dto.getEndpoint()), DestinationNumberType.DID);
    } else {
      LOGGER.severe(String.format("Unexpected type value '%s'", dto.getType()));
    }
    return destination;
  }
}
