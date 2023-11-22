package com.sinch.sdk.domains.verification.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.verification.adapters.api.v1.QueryVerificationsApi;
import com.sinch.sdk.domains.verification.adapters.converters.VerificationsDtoConverter;
import com.sinch.sdk.domains.verification.models.Identity;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReference;
import com.sinch.sdk.domains.verification.models.VerificationReport;
import com.sinch.sdk.models.Configuration;
import java.util.Map;
import java.util.function.Supplier;

public class StatusService implements com.sinch.sdk.domains.verification.StatusService {

  private final Configuration configuration;
  private final HttpClient httpClient;
  private final Supplier<Map<String, AuthManager>> authManagerSupplier;

  public StatusService(
      Configuration configuration,
      HttpClient httpClient,
      Supplier<Map<String, AuthManager>> authManagerSupplier) {
    this.configuration = configuration;
    this.httpClient = httpClient;
    this.authManagerSupplier = authManagerSupplier;
  }

  protected QueryVerificationsApi getApi() {
    return new QueryVerificationsApi(
        httpClient,
        configuration.getVerificationServer(),
        authManagerSupplier.get(),
        new HttpMapper());
  }

  public VerificationReport get(Identity identity, VerificationMethodType method) {
    if (!(identity instanceof NumberIdentity)) {
      throw new ApiException("Unexpected entity: " + identity);
    }
    NumberIdentity numberIdentity = (NumberIdentity) identity;

    return VerificationsDtoConverter.convert(
        getApi()
            .verificationStatusByIdentity(
                numberIdentity.getType(), numberIdentity.getEndpoint(), method.value()));
  }

  public VerificationReport get(VerificationId id) {

    return VerificationsDtoConverter.convert(getApi().verificationStatusById(id.getId()));
  }

  public VerificationReport get(VerificationReference reference) {

    return VerificationsDtoConverter.convert(
        getApi().verificationStatusByReference(reference.getReference()));
  }
}
