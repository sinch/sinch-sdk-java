package com.sinch.sdk.domains.numbers.adapters;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.models.NumberType;
import com.sinch.sdk.domains.numbers.models.Region;
import com.sinch.sdk.domains.numbers.models.requests.AvailableRegionListAllRequestParameters;
import com.sinch.sdk.domains.numbers.models.responses.AvailableRegionListResponse;
import com.sinch.sdk.domains.numbers.models.v1.AvailableRegionsDtoTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
class RegionServiceTest extends BaseTest {

  AvailableRegionService service;

  @Mock com.sinch.sdk.domains.numbers.api.v1.AvailableRegionService v1;

  @BeforeEach
  public void initMocks() {
    service = spy(new AvailableRegionService(v1));
  }

  @Test
  void list() throws ApiException {

    when(v1.list(any()))
        .thenReturn(
            new com.sinch.sdk.domains.numbers.models.v1.regions.available.response
                .AvailableRegionListResponse(
                AvailableRegionsDtoTest.availableRegionList.getAvailableRegions()));

    AvailableRegionListResponse response =
        service.list(
            AvailableRegionListAllRequestParameters.builder()
                .setTypes(Collections.singletonList(NumberType.MOBILE))
                .build());

    Collection<Region> expected =
        new ArrayList<>(
            Collections.singletonList(
                Region.builder()
                    .setRegionName("Australia")
                    .setRegionCode("AU")
                    .setTypes(new ArrayList<>(Collections.singletonList(NumberType.MOBILE)))
                    .build()));

    assertFalse(response.hasNextPage(), "Has no next page");
    assertThrows(NoSuchElementException.class, response::nextPage);
    TestHelpers.recursiveEquals(response.getContent(), expected);
  }
}
