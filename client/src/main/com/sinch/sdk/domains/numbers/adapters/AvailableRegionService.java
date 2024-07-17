package com.sinch.sdk.domains.numbers.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.adapters.converters.AvailableRegionsDtoConverter;
import com.sinch.sdk.domains.numbers.models.Region;
import com.sinch.sdk.domains.numbers.models.requests.AvailableRegionListAllRequestParameters;
import com.sinch.sdk.domains.numbers.models.responses.AvailableRegionListResponse;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.regions.available.request.AvailableRegionListRequest;
import java.util.Collection;
import java.util.stream.Collectors;

public class AvailableRegionService
    implements com.sinch.sdk.domains.numbers.AvailableRegionService {

  private final com.sinch.sdk.domains.numbers.api.v1.AvailableRegionService v1;

  public AvailableRegionService(com.sinch.sdk.domains.numbers.api.v1.AvailableRegionService v1) {
    this.v1 = v1;
  }

  public AvailableRegionListResponse list(AvailableRegionListAllRequestParameters parameters)
      throws ApiException {

    AvailableRegionListRequest dto = null;
    if (null != parameters && parameters.getTypes().isPresent()) {
      dto =
          AvailableRegionListRequest.builder()
              .setTypes(
                  parameters.getTypes().get().stream()
                      .map(f -> NumberType.from(f.value()))
                      .collect(Collectors.toList()))
              .build();
    }

    com.sinch.sdk.domains.numbers.models.v1.regions.available.response.AvailableRegionListResponse
        response = v1.list(dto);
    Collection<Region> entities = AvailableRegionsDtoConverter.convert(response);

    return new AvailableRegionListResponse(entities);
  }
}
