package com.sinch.sdk.domains.numbers.api.v1.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.numbers.api.v1.internal.AvailableRegionsApi;
import com.sinch.sdk.domains.numbers.models.v1.AvailableRegionsDtoTest;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.regions.available.request.AvailableRegionListRequest;
import com.sinch.sdk.domains.numbers.models.v1.regions.available.response.AvailableRegionListResponse;
import com.sinch.sdk.models.NumbersContext;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
class AvailableRegionServiceTest extends BaseTest {

  @Mock NumbersContext context;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;
  @Mock AvailableRegionsApi api;
  AvailableRegionService service;

  String uriUUID = "foo";

  @BeforeEach
  public void initMocks() {
    AvailableRegionService v1 =
        new AvailableRegionService(uriUUID, context, () -> httpClient, authManagers);
    service = spy(v1);
    doReturn(api).when(service).getApi();
  }

  @Test
  void list() throws ApiException {

    when(api.numberServiceListAvailableRegions(eq("foo"), eq(Arrays.asList("MOBILE"))))
        .thenReturn(AvailableRegionsDtoTest.availableRegionList);

    AvailableRegionListResponse expected =
        new AvailableRegionListResponse(
            AvailableRegionsDtoTest.availableRegionList.getAvailableRegions());

    AvailableRegionListResponse response =
        service.list(
            AvailableRegionListRequest.builder()
                .setTypes(Arrays.asList(NumberType.MOBILE))
                .build());

    TestHelpers.recursiveEquals(response, expected);
  }
}
