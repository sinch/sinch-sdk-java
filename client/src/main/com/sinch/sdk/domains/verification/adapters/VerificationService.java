package com.sinch.sdk.domains.verification.adapters;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.models.ApplicationCredentials;
import com.sinch.sdk.models.VerificationContext;
import java.util.function.Supplier;

public class VerificationService implements com.sinch.sdk.domains.verification.VerificationService {

  private final com.sinch.sdk.domains.verification.api.v1.VerificationService v1;

  public VerificationService(
      ApplicationCredentials credentials,
      VerificationContext context,
      Supplier<HttpClient> httpClientSupplier) {

    this.v1 =
        new com.sinch.sdk.domains.verification.api.v1.adapters.VerificationService(
            credentials, context, httpClientSupplier);
  }

  public com.sinch.sdk.domains.verification.api.v1.VerificationService v1() {
    return this.v1;
  }
}
