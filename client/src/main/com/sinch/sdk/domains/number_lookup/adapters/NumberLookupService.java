package com.sinch.sdk.domains.number_lookup.adapters;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.models.NumberLookupContext;
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.function.Supplier;

public class NumberLookupService
    implements com.sinch.sdk.domains.number_lookup.NumberLookupService {

  private final UnifiedCredentials credentials;
  private final NumberLookupContext context;
  private final ServerConfiguration oAuthServer;
  private final Supplier<HttpClient> httpClientSupplier;

  private volatile com.sinch.sdk.domains.number_lookup.api.v2.NumberLookupService v2;

  public NumberLookupService(
      UnifiedCredentials credentials,
      NumberLookupContext context,
      ServerConfiguration oAuthServer,
      Supplier<HttpClient> httpClientSupplier) {
    this.credentials = credentials;
    this.context = context;
    this.oAuthServer = oAuthServer;
    this.httpClientSupplier = httpClientSupplier;
  }

  @Override
  public com.sinch.sdk.domains.number_lookup.api.v2.NumberLookupService v2() {
    if (null == this.v2) {
      synchronized (this) {
        if (null == this.v2) {
          this.v2 =
              new com.sinch.sdk.domains.number_lookup.api.v2.adapters.NumberLookupService(
                  credentials, context, oAuthServer, httpClientSupplier);
        }
      }
    }
    return this.v2;
  }
}
