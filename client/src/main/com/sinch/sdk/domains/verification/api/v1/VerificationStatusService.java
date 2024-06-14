package com.sinch.sdk.domains.verification.api.v1;

import com.sinch.sdk.domains.verification.models.v1.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponse;

public interface VerificationStatusService {

  VerificationStatusResponse getByIdentity(NumberIdentity identity, VerificationMethod method);

  VerificationStatusResponse getById(String id);

  VerificationStatusResponse getByReference(String reference);
}
