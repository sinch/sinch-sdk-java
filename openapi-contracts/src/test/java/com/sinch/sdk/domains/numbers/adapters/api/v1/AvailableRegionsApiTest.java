package com.sinch.sdk.domains.numbers.adapters.api.v1;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.numbers.models.dto.v1.AvailableRegionDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.ListAvailableRegionsResponseDto;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@TestWithResources
class AvailableRegionsApiTest extends BaseTest {

  @GivenTextResource("/domains/numbers/v1/available-regions-list.json")
  String availableListResponse;

  @Mock HttpClient httpClient;
  @Mock ServerConfiguration serverConfiguration;
  HttpMapper mapper = new HttpMapper();

  @InjectMocks
  AvailableRegionsApi service =
      new AvailableRegionsApi(httpClient, serverConfiguration, null, mapper);

  AvailableRegionDto expectedAvailableRegionDto =
      new AvailableRegionDto("AU", "Australia", Collections.singletonList("MOBILE"));

  @Test
  void listAll() {

    when(httpClient.invokeAPI(any(), any(), any()))
        .thenReturn(
            new HttpResponse(
                200, "foo message", null, availableListResponse.getBytes(StandardCharsets.UTF_8)));

    ListAvailableRegionsResponseDto response =
        service.numberServiceListAvailableRegions(
            "project", Collections.singletonList("capability"));

    ListAvailableRegionsResponseDto expected =
        new ListAvailableRegionsResponseDto()
            .availableRegions(Collections.singletonList(expectedAvailableRegionDto));

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expected);
  }
}
