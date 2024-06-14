package com.sinch.sdk.domains.verification.adapters.converters;

import com.sinch.sdk.domains.verification.models.Identity;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.internal.IdentityInternal;
import java.util.logging.Logger;

public class IdentityDtoConverter {
  private static final Logger LOGGER = Logger.getLogger(IdentityDtoConverter.class.getName());

  public static Identity convert(IdentityInternal dto) {
    Identity identity = null;
    if (IdentityInternal.TypeEnum.NUMBER.equals(dto.getType())) {
      identity = NumberIdentity.valueOf(dto.getEndpoint());
    } else {
      LOGGER.severe(String.format("Unexpected '%s'", dto));
    }
    return identity;
  }

  public static com.sinch.sdk.domains.verification.models.v1.Identity convert(
      com.sinch.sdk.domains.verification.models.Identity client) {
    com.sinch.sdk.domains.verification.models.v1.Identity identity = null;
    if (client instanceof com.sinch.sdk.domains.verification.models.NumberIdentity) {
      identity =
          com.sinch.sdk.domains.verification.models.v1.NumberIdentity.valueOf(
              ((com.sinch.sdk.domains.verification.models.NumberIdentity) client).getEndpoint());
    } else {
      LOGGER.severe(String.format("Unexpected '%s'", client));
    }
    return identity;
  }
}
