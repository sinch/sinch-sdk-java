package com.sinch.sdk.domains.numbers.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.domains.numbers.adapters.api.v1.AvailableRegionsApi;
import com.sinch.sdk.domains.numbers.adapters.converters.AvailableRegionsDtoConverter;
import com.sinch.sdk.domains.numbers.models.Region;
import com.sinch.sdk.domains.numbers.models.dto.v1.ListAvailableRegionsResponseDto;
import com.sinch.sdk.domains.numbers.models.requests.AvailableRegionListAllRequestParameters;
import com.sinch.sdk.domains.numbers.models.responses.AvailableRegionListResponse;
import com.sinch.sdk.models.Configuration;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AvailableRegionService
    implements com.sinch.sdk.domains.numbers.AvailableRegionService {

  private Configuration configuration;
  private AvailableRegionsApi api;

  public AvailableRegionService() {}

  public AvailableRegionService(Configuration configuration, HttpClient httpClient) {
    this.configuration = configuration;
    this.api =
        new AvailableRegionsApi(httpClient, configuration.getNumbersServer(), new HttpMapper());
  }

  public AvailableRegionListResponse list(AvailableRegionListAllRequestParameters parameters)
      throws ApiException {

    List<String> types = null;
    if (parameters.getTypes().isPresent()) {
      types =
          parameters.getTypes().get().stream().map(EnumDynamic::value).collect(Collectors.toList());
    }

    ListAvailableRegionsResponseDto response =
        api.numberServiceListAvailableRegions(configuration.getProjectId(), types);
    Collection<Region> entities = AvailableRegionsDtoConverter.convert(response);

    return new AvailableRegionListResponse(entities);
  }
}
