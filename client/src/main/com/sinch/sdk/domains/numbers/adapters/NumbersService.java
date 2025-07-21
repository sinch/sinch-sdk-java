package com.sinch.sdk.domains.numbers.adapters;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.models.NumbersContext;
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.function.Supplier;

public class NumbersService implements com.sinch.sdk.domains.numbers.NumbersService {

  private final com.sinch.sdk.domains.numbers.api.v1.NumbersService v1;

  public NumbersService(
      UnifiedCredentials credentials,
      NumbersContext context,
      ServerConfiguration oAuthServer,
      Supplier<HttpClient> httpClientSupplier) {

    this.v1 =
        new com.sinch.sdk.domains.numbers.api.v1.adapters.NumbersService(
            credentials, context, oAuthServer, httpClientSupplier);
  }

  public com.sinch.sdk.domains.numbers.api.v1.NumbersService v1() {
    return v1;
  }
}
