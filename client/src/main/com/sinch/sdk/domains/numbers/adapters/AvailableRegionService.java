package com.sinch.sdk.domains.numbers.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.domains.numbers.adapters.api.v1.AvailableRegionsApi;
import com.sinch.sdk.domains.numbers.adapters.converters.AvailableRegionsDtoConverter;
import com.sinch.sdk.domains.numbers.models.Region;
import com.sinch.sdk.domains.numbers.models.dto.v1.ListAvailableRegionsResponseDto;
import com.sinch.sdk.domains.numbers.models.requests.AvailableRegionListAllRequestParameters;
import com.sinch.sdk.domains.numbers.models.responses.AvailableRegionListResponse;
import com.sinch.sdk.models.NumbersContext;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AvailableRegionService
    implements com.sinch.sdk.domains.numbers.AvailableRegionService {

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

  public AvailableRegionListResponse list(AvailableRegionListAllRequestParameters parameters)
      throws ApiException {

    List<String> types = null;
    if (parameters.getTypes().isPresent()) {
      types =
          parameters.getTypes().get().stream().map(EnumDynamic::value).collect(Collectors.toList());
    }

    ListAvailableRegionsResponseDto response =
        getApi().numberServiceListAvailableRegions(uriUUID, types);
    Collection<Region> entities = AvailableRegionsDtoConverter.convert(response);

    return new AvailableRegionListResponse(entities);
  }
}
