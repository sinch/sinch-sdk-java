package com.sinch.sdk.domains.voice.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.voice.adapters.converters.ApplicationsDtoConverter;
import com.sinch.sdk.domains.voice.adapters.converters.ApplicationsDtoConverterTest;
import com.sinch.sdk.domains.voice.models.CallbackUrls;
import com.sinch.sdk.domains.voice.models.response.AssignedNumbers;
import com.sinch.sdk.domains.voice.models.v1.applications.Callbacks;
import com.sinch.sdk.domains.voice.models.v1.applications.request.UnAssignNumberRequest;
import com.sinch.sdk.domains.voice.models.v1.applications.request.UpdateNumbersRequest;
import com.sinch.sdk.domains.voice.models.v1.applications.response.GetCallbackUrlsResponseTest;
import com.sinch.sdk.domains.voice.models.v1.applications.response.OwnedNumbersResponseTest;
import com.sinch.sdk.models.E164PhoneNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;

@TestWithResources
public class ApplicationsServiceTest extends BaseTest {

  @Mock com.sinch.sdk.domains.voice.api.v1.ApplicationsService v1;

  @Captor ArgumentCaptor<String> applicationKeyCaptor;
  @Captor ArgumentCaptor<Callbacks> callbacksDtoCaptor;
  @Captor ArgumentCaptor<UpdateNumbersRequest> updateNumbersRequestDtoCaptor;
  @Captor ArgumentCaptor<UnAssignNumberRequest> unAssignNumberRequestDtoCaptor;

  ApplicationsService service;

  @BeforeEach
  public void initMocks() {
    service = spy(new ApplicationsService(v1));
  }

  @Test
  void getNumbers() throws ApiException {

    when(v1.listNumbers()).thenReturn(OwnedNumbersResponseTest.expected);

    AssignedNumbers response = service.listNumbers();

    TestHelpers.recursiveEquals(
        response, ApplicationsDtoConverterTest.expectedAssignedNumbersResponse);
  }

  @Test
  void getCallbackUrls() throws ApiException {
    when(v1.getCallbackUrls(eq("app id"))).thenReturn(GetCallbackUrlsResponseTest.expected);

    CallbackUrls response = service.getCallbackUrls("app id");

    TestHelpers.recursiveEquals(
        response, ApplicationsDtoConverterTest.expectedApplicationsCallbackUrls);
  }

  @Test
  void updateCallbackUrls() {

    service.updateCallbackUrls(
        "app key", ApplicationsDtoConverterTest.expectedApplicationsCallbackUrls);

    verify(v1).updateCallbackUrls(applicationKeyCaptor.capture(), callbacksDtoCaptor.capture());

    String appKey = applicationKeyCaptor.getValue();
    Assertions.assertThat(appKey).isEqualTo("app key");

    Callbacks body = callbacksDtoCaptor.getValue();
    TestHelpers.recursiveEquals(
        body,
        ApplicationsDtoConverter.convert(
            ApplicationsDtoConverterTest.expectedApplicationsCallbackUrls));
  }

  @Test
  void updateNumbers() {
    service.assignNumbers(
        ApplicationsDtoConverterTest.expectedApplicationsAssignNumbersRequestParameters);

    verify(v1).assignNumbers(updateNumbersRequestDtoCaptor.capture());

    UpdateNumbersRequest body = updateNumbersRequestDtoCaptor.getValue();
    TestHelpers.recursiveEquals(
        body,
        ApplicationsDtoConverter.convert(
            ApplicationsDtoConverterTest.expectedApplicationsAssignNumbersRequestParameters));
  }

  @Test
  void unassignNumber() {
    service.unassignNumber(E164PhoneNumber.valueOf("+12345678"), "application key");

    verify(v1).unassignNumber(unAssignNumberRequestDtoCaptor.capture());

    UnAssignNumberRequest body = unAssignNumberRequestDtoCaptor.getValue();
    TestHelpers.recursiveEquals(
        body,
        ApplicationsDtoConverter.convert(E164PhoneNumber.valueOf("+12345678"), "application key"));
  }
}
