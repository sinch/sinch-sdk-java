package com.sinch.sdk.domains.numbers.adapters;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.models.NumbersContext;
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.function.Supplier;

public class NumbersService implements com.sinch.sdk.domains.numbers.NumbersService {

  private final UnifiedCredentials credentials;
  private final NumbersContext context;
  private final ServerConfiguration oAuthServer;
  private final Supplier<HttpClient> httpClientSupplier;

  private volatile com.sinch.sdk.domains.numbers.api.v1.NumbersService v1;

  public NumbersService(
      UnifiedCredentials credentials,
      NumbersContext context,
      ServerConfiguration oAuthServer,
      Supplier<HttpClient> httpClientSupplier) {
    this.credentials = credentials;
    this.context = context;
    this.oAuthServer = oAuthServer;
    this.httpClientSupplier = httpClientSupplier;
  }

  public com.sinch.sdk.domains.numbers.api.v1.NumbersService v1() {
    if (null == this.v1) {
      synchronized (this) {
        if (null == this.v1) {
          this.v1 =
              new com.sinch.sdk.domains.numbers.api.v1.adapters.NumbersService(
                  credentials, context, oAuthServer, httpClientSupplier);
        }
      }
    }
    return this.v1;
  }
}
