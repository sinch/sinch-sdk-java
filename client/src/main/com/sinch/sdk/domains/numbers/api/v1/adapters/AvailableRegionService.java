package com.sinch.sdk.domains.numbers.api.v1.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.domains.numbers.api.v1.internal.AvailableRegionsApi;
import com.sinch.sdk.domains.numbers.models.v1.regions.available.request.AvailableRegionListRequest;
import com.sinch.sdk.domains.numbers.models.v1.regions.available.response.AvailableRegionListResponse;
import com.sinch.sdk.domains.numbers.models.v1.regions.available.response.internal.AvailableRegionListResponseInternal;
import com.sinch.sdk.models.NumbersContext;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AvailableRegionService
    implements com.sinch.sdk.domains.numbers.api.v1.AvailableRegionService {

  private final String uriUUID;
  private final AvailableRegionsApi api;

  public AvailableRegionService(
      String uriUUID,
      NumbersContext context,
      HttpClient httpClient,
      Map<String, AuthManager> authManagers) {
    this.uriUUID = uriUUID;
    this.api =
        new AvailableRegionsApi(
            httpClient, context.getNumbersServer(), authManagers, new HttpMapper());
  }

  protected AvailableRegionsApi getApi() {
    return this.api;
  }

  public AvailableRegionListResponse list(AvailableRegionListRequest parameters)
      throws ApiException {

    List<String> types = null;
    if (parameters.getTypes().isPresent()) {
      types =
          parameters.getTypes().get().stream().map(EnumDynamic::value).collect(Collectors.toList());
    }

    AvailableRegionListResponseInternal response =
        getApi().numberServiceListAvailableRegions(uriUUID, types);

    return new AvailableRegionListResponse(response.getAvailableRegions());
  }
}
