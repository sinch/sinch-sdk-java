package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.domains.voice.models.DestinationNumber;
import com.sinch.sdk.domains.voice.models.DestinationNumberType;
import com.sinch.sdk.domains.voice.models.DestinationSip;
import com.sinch.sdk.domains.voice.models.DestinationUser;
import com.sinch.sdk.domains.voice.models.v1.calls.response.CallInformationFrom;
import com.sinch.sdk.domains.voice.models.v1.calls.response.CallInformationTo;
import com.sinch.sdk.domains.voice.models.v1.destination.Destination;
import com.sinch.sdk.domains.voice.models.v1.destination.DestinationDid;
import com.sinch.sdk.domains.voice.models.v1.destination.DestinationMxp;
import com.sinch.sdk.domains.voice.models.v1.destination.DestinationPstn;
import com.sinch.sdk.models.E164PhoneNumber;
import java.util.logging.Logger;

public class DestinationDtoConverter {

  private static final Logger LOGGER = Logger.getLogger(DestinationDtoConverter.class.getName());

  public static Destination convert(com.sinch.sdk.domains.voice.models.Destination client) {

    if (null == client) {
      return null;
    }

    if (client instanceof DestinationNumber) {
      DestinationNumber destination = (DestinationNumber) client;
      if (DestinationNumberType.DID.equals(destination.getType())) {
        return DestinationDid.from(
            null != destination.getPhoneNumber()
                ? destination.getPhoneNumber().stringValue()
                : null);
      }
      if (DestinationNumberType.PSTN.equals(destination.getType())) {
        return DestinationPstn.from(
            null != destination.getPhoneNumber()
                ? destination.getPhoneNumber().stringValue()
                : null);
      }
      LOGGER.severe(String.format("Unexpected type '%s': %s", destination.getType(), client));
      return null;
    }

    if (client instanceof DestinationUser) {
      return DestinationMxp.from(((DestinationUser) client).getUserName());
    }

    if (client instanceof DestinationSip) {
      return com.sinch.sdk.domains.voice.models.v1.destination.DestinationSip.from(
          ((DestinationSip) client).getSIPAddress());
    }

    LOGGER.severe(String.format("Unexpected class '%s': '%s'", client.getClass(), client));
    return null;
  }

  public static com.sinch.sdk.domains.voice.models.Destination convert(Destination dto) {
    if (null == dto) {
      return null;
    }
    if (dto instanceof DestinationPstn) {
      return new DestinationNumber(
          E164PhoneNumber.valueOf(((DestinationPstn) dto).getEndpoint()),
          DestinationNumberType.PSTN);
    }
    if (dto instanceof DestinationMxp) {
      return new DestinationUser(((DestinationMxp) dto).getEndpoint());
    }
    if (dto instanceof com.sinch.sdk.domains.voice.models.v1.destination.DestinationSip) {
      return new DestinationSip(
          ((com.sinch.sdk.domains.voice.models.v1.destination.DestinationSip) dto).getEndpoint());
    }
    if (dto instanceof DestinationDid) {
      return new DestinationNumber(
          E164PhoneNumber.valueOf(((DestinationDid) dto).getEndpoint()), DestinationNumberType.DID);
    }

    LOGGER.severe(String.format("Unexpected class '%s'", dto));
    return null;
  }

  public static com.sinch.sdk.domains.voice.models.Destination convert(CallInformationFrom dto) {
    if (null == dto) {
      return null;
    }
    if (!(dto instanceof Destination)) {
      LOGGER.severe(String.format("Unexpected class '%s'", dto));
      return null;
    }
    return convert((Destination) dto);
  }

  public static com.sinch.sdk.domains.voice.models.Destination convert(CallInformationTo dto) {
    if (null == dto) {
      return null;
    }
    if (!(dto instanceof Destination)) {
      LOGGER.severe(String.format("Unexpected class '%s'", dto));
      return null;
    }
    return convert((Destination) dto);
  }
}
