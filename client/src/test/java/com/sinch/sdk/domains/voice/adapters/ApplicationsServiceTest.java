package com.sinch.sdk.domains.voice.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.voice.adapters.api.v1.ApplicationsApi;
import com.sinch.sdk.domains.voice.adapters.converters.ApplicationsDtoConverter;
import com.sinch.sdk.domains.voice.adapters.converters.ApplicationsDtoConverterTest;
import com.sinch.sdk.domains.voice.models.CallbackUrls;
import com.sinch.sdk.domains.voice.models.dto.v1.ApplicationsCallbackUrlsDtoTest;
import com.sinch.sdk.domains.voice.models.dto.v1.ApplicationsGetNumbersResponseDtoTest;
import com.sinch.sdk.domains.voice.models.dto.v1.CallbacksDto;
import com.sinch.sdk.domains.voice.models.dto.v1.UnassignNumbersDto;
import com.sinch.sdk.domains.voice.models.dto.v1.UpdateNumbersDto;
import com.sinch.sdk.domains.voice.models.response.AssignedNumbers;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.E164PhoneNumber;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;

@TestWithResources
public class ApplicationsServiceTest extends BaseTest {

  @Mock ApplicationsApi api;
  @Mock Configuration configuration;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;

  @Captor ArgumentCaptor<String> applicationKeyCaptor;
  @Captor ArgumentCaptor<CallbacksDto> callbacksDtoCaptor;
  @Captor ArgumentCaptor<UpdateNumbersDto> updateNumbersDtoCaptor;
  @Captor ArgumentCaptor<UnassignNumbersDto> unassignNumbersDtoCaptor;

  ApplicationsService service;

  @BeforeEach
  public void initMocks() {
    service = spy(new ApplicationsService(configuration, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void getNumbers() throws ApiException {

    when(api.configurationGetNumbers()).thenReturn(ApplicationsGetNumbersResponseDtoTest.expected);

    AssignedNumbers response = service.getNumbers();

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(ApplicationsDtoConverterTest.expectedAssignedNumbersResponse);
  }

  @Test
  void getCallbackUrls() throws ApiException {

    when(api.configurationGetCallbackURLs(eq("app id")))
        .thenReturn(ApplicationsCallbackUrlsDtoTest.expected);

    CallbackUrls response = service.getCallbackUrls("app id");

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(ApplicationsDtoConverterTest.expectedApplicationsCallbackUrls);
  }

  @Test
  void updateCallbackUrls() {

    service.updateCallbackUrls(
        "app key", ApplicationsDtoConverterTest.expectedApplicationsCallbackUrls);

    verify(api)
        .configurationUpdateCallbackURLs(
            applicationKeyCaptor.capture(), callbacksDtoCaptor.capture());

    String appKey = applicationKeyCaptor.getValue();
    Assertions.assertThat(appKey).isEqualTo("app key");

    CallbacksDto body = callbacksDtoCaptor.getValue();
    Assertions.assertThat(body)
        .isEqualTo(
            ApplicationsDtoConverter.convert(
                ApplicationsDtoConverterTest.expectedApplicationsCallbackUrls));
  }

  @Test
  void updateNumbers() {
    service.updateNumbers(
        ApplicationsDtoConverterTest.expectedApplicationsUpdateNumbersRequestParameters);

    verify(api).configurationUpdateNumbers(updateNumbersDtoCaptor.capture());

    UpdateNumbersDto body = updateNumbersDtoCaptor.getValue();
    Assertions.assertThat(body)
        .isEqualTo(
            ApplicationsDtoConverter.convert(
                ApplicationsDtoConverterTest.expectedApplicationsUpdateNumbersRequestParameters));
  }

  @Test
  void unassignNumber() {
    service.unassignNumber(E164PhoneNumber.valueOf("+12345678"), "application key");

    verify(api).configurationUnassignNumber(unassignNumbersDtoCaptor.capture());

    UnassignNumbersDto body = unassignNumbersDtoCaptor.getValue();
    Assertions.assertThat(body)
        .isEqualTo(
            ApplicationsDtoConverter.convert(
                E164PhoneNumber.valueOf("+12345678"), "application key"));
  }
}
