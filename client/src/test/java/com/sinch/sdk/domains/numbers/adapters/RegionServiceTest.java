package com.sinch.sdk.domains.numbers.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.adapters.api.v1.AvailableRegionsApi;
import com.sinch.sdk.domains.numbers.models.NumberType;
import com.sinch.sdk.domains.numbers.models.Region;
import com.sinch.sdk.domains.numbers.models.dto.v1.ListAvailableRegionsResponseDto;
import com.sinch.sdk.domains.numbers.models.requests.AvailableRegionListAllRequestParameters;
import com.sinch.sdk.domains.numbers.models.responses.AvailableRegionListResponse;
import com.sinch.sdk.models.Configuration;
import java.util.Collection;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@TestWithResources
class RegionServiceTest extends BaseTest {

  @GivenJsonResource("/domains/numbers/v1/available-regions-list.json")
  ListAvailableRegionsResponseDto availableRegionsListDto;

  @Mock Configuration configuration;
  @Mock AvailableRegionsApi api;
  @InjectMocks AvailableRegionService service;

  @Test
  void list() throws ApiException {

    when(api.numberServiceListAvailableRegions(
            eq(configuration.getProjectId()), eq(Collections.singletonList("MOBILE"))))
        .thenReturn(availableRegionsListDto);

    AvailableRegionListResponse response =
        service.list(
            AvailableRegionListAllRequestParameters.builder()
                .setTypes(Collections.singletonList(NumberType.MOBILE))
                .build());

    Collection<Region> expected =
        Collections.singletonList(
            Region.builder()
                .setRegionName("Australia")
                .setRegionCode("AU")
                .setTypes(Collections.singletonList(NumberType.MOBILE))
                .build());

    Assertions.assertThat(response.getContent()).usingRecursiveComparison().isEqualTo(expected);
  }
}
