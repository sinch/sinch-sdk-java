package com.sinch.sdk.domains.voice.api.v1.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.voice.api.v1.internal.ApplicationsApi;
import com.sinch.sdk.domains.voice.models.v1.applications.Callbacks;
import com.sinch.sdk.domains.voice.models.v1.applications.request.UnAssignNumberRequest;
import com.sinch.sdk.domains.voice.models.v1.applications.request.UnAssignNumberRequestTest;
import com.sinch.sdk.domains.voice.models.v1.applications.request.UpdateCallbackUrlsRequestTest;
import com.sinch.sdk.domains.voice.models.v1.applications.request.UpdateNumbersRequest;
import com.sinch.sdk.domains.voice.models.v1.applications.request.UpdateNumbersRequestTest;
import com.sinch.sdk.domains.voice.models.v1.applications.response.GetCallbackUrlsResponseTest;
import com.sinch.sdk.domains.voice.models.v1.applications.response.OwnedNumbersResponse;
import com.sinch.sdk.domains.voice.models.v1.applications.response.OwnedNumbersResponseTest;
import com.sinch.sdk.models.VoiceContext;
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
  @Mock VoiceContext context;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;

  @Captor ArgumentCaptor<String> applicationKeyCaptor;
  @Captor ArgumentCaptor<Callbacks> callbacksDtoCaptor;
  @Captor ArgumentCaptor<UpdateNumbersRequest> updateNumbersDtoCaptor;
  @Captor ArgumentCaptor<UnAssignNumberRequest> unassignNumbersDtoCaptor;

  com.sinch.sdk.domains.voice.api.v1.adapters.ApplicationsService service;

  @BeforeEach
  public void initMocks() {
    service = spy(new ApplicationsService(context, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void getNumbers() throws ApiException {

    when(api.configurationGetNumbers()).thenReturn(OwnedNumbersResponseTest.expected);

    OwnedNumbersResponse response = service.listNumbers();

    TestHelpers.recursiveEquals(response, OwnedNumbersResponseTest.expected);
  }

  @Test
  void getCallbackUrls() throws ApiException {

    when(api.configurationGetCallbackURLs(eq("app id")))
        .thenReturn(GetCallbackUrlsResponseTest.expected);

    Callbacks response = service.getCallbackUrls("app id");

    TestHelpers.recursiveEquals(response, GetCallbackUrlsResponseTest.expected);
  }

  @Test
  void updateCallbackUrls() {

    service.updateCallbackUrls("app key", UpdateCallbackUrlsRequestTest.expected);

    verify(api)
        .configurationUpdateCallbackURLs(
            applicationKeyCaptor.capture(), callbacksDtoCaptor.capture());

    String appKey = applicationKeyCaptor.getValue();
    Assertions.assertThat(appKey).isEqualTo("app key");

    Callbacks body = callbacksDtoCaptor.getValue();
    TestHelpers.recursiveEquals(body, UpdateCallbackUrlsRequestTest.expected);
  }

  @Test
  void updateNumbers() {

    service.assignNumbers(UpdateNumbersRequestTest.updateNumbersDto);

    verify(api).configurationUpdateNumbers(updateNumbersDtoCaptor.capture());

    UpdateNumbersRequest body = updateNumbersDtoCaptor.getValue();
    TestHelpers.recursiveEquals(body, UpdateNumbersRequestTest.updateNumbersDto);
  }

  @Test
  void unAssignNumber() {

    service.unassignNumber(UnAssignNumberRequestTest.unAssignNumberDto);

    verify(api).configurationUnassignNumber(unassignNumbersDtoCaptor.capture());

    UnAssignNumberRequest body = unassignNumbersDtoCaptor.getValue();
    TestHelpers.recursiveEquals(body, UnAssignNumberRequestTest.unAssignNumberDto);
  }
}
