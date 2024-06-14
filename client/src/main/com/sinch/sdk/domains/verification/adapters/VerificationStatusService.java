package com.sinch.sdk.domains.verification.adapters;

import com.sinch.sdk.domains.verification.adapters.converters.StatusDtoConverter;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReference;
import com.sinch.sdk.domains.verification.models.VerificationStatus;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;

public class VerificationStatusService
    implements com.sinch.sdk.domains.verification.VerificationStatusService {

  private final com.sinch.sdk.domains.verification.api.v1.VerificationStatusService v1;

  public VerificationStatusService(
      com.sinch.sdk.domains.verification.api.v1.VerificationStatusService v1) {
    this.v1 = v1;
    ;
  }

  public VerificationStatus getByIdentity(NumberIdentity identity, VerificationMethodType method) {

    return StatusDtoConverter.convert(
        v1.getByIdentity(
            com.sinch.sdk.domains.verification.models.v1.NumberIdentity.valueOf(
                identity.getEndpoint()),
            VerificationMethod.from(method.value())));
  }

  public VerificationStatus getById(VerificationId id) {

    return StatusDtoConverter.convert(v1.getById(id.getId()));
  }

  public VerificationStatus getByReference(VerificationReference reference) {

    return StatusDtoConverter.convert(v1.getByReference(reference.getReference()));
  }
}
