package com.sinch.sdk.domains.verification.adapters;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.models.ApplicationCredentials;
import com.sinch.sdk.models.VerificationContext;
import java.util.function.Supplier;

public class VerificationService implements com.sinch.sdk.domains.verification.VerificationService {

  private final ApplicationCredentials credentials;
  private final VerificationContext context;
  private final Supplier<HttpClient> httpClientSupplier;

  private volatile com.sinch.sdk.domains.verification.api.v1.VerificationService v1;

  public VerificationService(
      ApplicationCredentials credentials,
      VerificationContext context,
      Supplier<HttpClient> httpClientSupplier) {
    this.credentials = credentials;
    this.context = context;
    this.httpClientSupplier = httpClientSupplier;
  }

  public com.sinch.sdk.domains.verification.api.v1.VerificationService v1() {
    if (null == this.v1) {
      synchronized (this) {
        if (null == this.v1) {
          this.v1 =
              new com.sinch.sdk.domains.verification.api.v1.adapters.VerificationService(
                  credentials, context, httpClientSupplier);
        }
      }
    }
    return this.v1;
  }
}
