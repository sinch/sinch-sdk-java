package com.sinch.sdk.domains.numberlookup.api.v2.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.numberlookup.api.v2.NumberLookupV2Service;
import com.sinch.sdk.domains.numberlookup.models.v2.request.NumberLookupRequest;
import com.sinch.sdk.domains.numberlookup.models.v2.response.NumberLookupResponse;
import com.sinch.sdk.models.NumberLookupContext;
import java.util.Map;
import java.util.function.Supplier;

final class NumberLookupServiceFacade
    implements com.sinch.sdk.domains.numberlookup.api.v2.NumberLookupService {

  private final NumberLookupV2Service lookup;

  NumberLookupServiceFacade(
      String uriUUID,
      NumberLookupContext context,
      Supplier<HttpClient> httpClientSupplier,
      Map<String, AuthManager> authManagers) {
    this.lookup =
        new NumberLookupV2ServiceImpl(
            httpClientSupplier.get(),
            context.getNumberLookupServer(),
            authManagers,
            HttpMapper.getInstance(),
            uriUUID);
  }

  @Override
  public NumberLookupResponse lookup(NumberLookupRequest numberLookupRequest) throws ApiException {
    return lookup.lookup(numberLookupRequest);
  }
}
