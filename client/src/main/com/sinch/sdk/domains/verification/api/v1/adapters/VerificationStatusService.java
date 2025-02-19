package com.sinch.sdk.domains.verification.api.v1.adapters;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.verification.api.v1.internal.VerificationStatusApi;
import com.sinch.sdk.domains.verification.models.v1.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponse;
import com.sinch.sdk.domains.verification.models.v1.status.response.internal.VerificationStatusResponseInternalImpl;
import com.sinch.sdk.models.VerificationContext;
import java.util.Map;

public class VerificationStatusService
    implements com.sinch.sdk.domains.verification.api.v1.VerificationStatusService {

  private final VerificationStatusApi api;

  public VerificationStatusService(
      VerificationContext context, HttpClient httpClient, Map<String, AuthManager> authManagers) {
    this.api =
        new VerificationStatusApi(
            httpClient, context.getVerificationServer(), authManagers, HttpMapper.getInstance());
  }

  protected VerificationStatusApi getApi() {
    return this.api;
  }

  public VerificationStatusResponse getByIdentity(
      NumberIdentity identity, VerificationMethod method) {

    VerificationStatusResponseInternalImpl response =
        (VerificationStatusResponseInternalImpl)
            getApi().verificationStatusByIdentity(identity.getEndpoint(), method.value());
    if (null == response) {
      return null;
    }
    return (VerificationStatusResponse) response.getActualInstance();
  }

  public VerificationStatusResponse getById(String id) {

    VerificationStatusResponseInternalImpl response =
        (VerificationStatusResponseInternalImpl) getApi().verificationStatusById(id);
    if (null == response) {
      return null;
    }
    return (VerificationStatusResponse) response.getActualInstance();
  }

  public VerificationStatusResponse getByReference(String reference) {

    VerificationStatusResponseInternalImpl response =
        (VerificationStatusResponseInternalImpl) getApi().verificationStatusByReference(reference);
    if (null == response) {
      return null;
    }
    return (VerificationStatusResponse) response.getActualInstance();
  }
}
