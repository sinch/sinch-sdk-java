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
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AvailableRegionService
    implements com.sinch.sdk.domains.numbers.AvailableRegionService {

  private final UnifiedCredentials credentials;
  private final AvailableRegionsApi api;

  public AvailableRegionService(
      UnifiedCredentials credentials,
      NumbersContext context,
      HttpClient httpClient,
      Map<String, AuthManager> authManagers) {
    this.credentials = credentials;
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
        getApi().numberServiceListAvailableRegions(credentials.getProjectId(), types);
    Collection<Region> entities = AvailableRegionsDtoConverter.convert(response);

    return new AvailableRegionListResponse(entities);
  }
}
