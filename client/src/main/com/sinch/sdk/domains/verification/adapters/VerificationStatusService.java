package com.sinch.sdk.domains.verification.adapters;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.verification.adapters.api.v1.QueryVerificationsApi;
import com.sinch.sdk.domains.verification.adapters.converters.VerificationsDtoConverter;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReference;
import com.sinch.sdk.domains.verification.models.VerificationReport;
import com.sinch.sdk.models.VerificationContext;
import java.util.Map;

public class VerificationStatusService
    implements com.sinch.sdk.domains.verification.VerificationStatusService {

  private final QueryVerificationsApi api;

  public VerificationStatusService(
      VerificationContext context, HttpClient httpClient, Map<String, AuthManager> authManagers) {
    this.api =
        new QueryVerificationsApi(
            httpClient, context.getVerificationServer(), authManagers, new HttpMapper());
  }

  protected QueryVerificationsApi getApi() {
    return this.api;
  }

  public VerificationReport get(NumberIdentity identity, VerificationMethodType method) {

    return VerificationsDtoConverter.convert(
        getApi().verificationStatusByIdentity("number", identity.getEndpoint(), method.value()));
  }

  public VerificationReport get(VerificationId id) {

    return VerificationsDtoConverter.convert(getApi().verificationStatusById(id.getId()));
  }

  public VerificationReport get(VerificationReference reference) {

    return VerificationsDtoConverter.convert(
        getApi().verificationStatusByReference(reference.getReference()));
  }
}
