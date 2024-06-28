package com.sinch.sdk.domains.numbers.api.v1.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.numbers.api.v1.internal.CallbacksApi;
import com.sinch.sdk.domains.numbers.models.v1.CallbackConfigurationDtoTest;
import com.sinch.sdk.domains.numbers.models.v1.callbacks.request.CallbackConfigurationUpdateRequest;
import com.sinch.sdk.domains.numbers.models.v1.callbacks.response.CallbackConfigurationResponse;
import com.sinch.sdk.models.NumbersContext;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
class CallbackConfigurationServiceTest extends BaseTest {

  @GivenJsonResource("/domains/numbers/v1/callbacks/callback-get-response.json")
  CallbackConfigurationResponse getResponse;

  @GivenJsonResource("/domains/numbers/v1/callbacks/callback-update-request.json")
  CallbackConfigurationUpdateRequest updateRequest;

  @Mock NumbersContext context;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;
  @Mock CallbacksApi api;
  CallbackConfigurationService service;

  String uriUUID = "foo";

  @BeforeEach
  public void initMocks() {
    CallbackConfigurationService v1 =
        new CallbackConfigurationService(uriUUID, context, httpClient, authManagers);
    service = spy(v1);
    doReturn(api).when(service).getApi();
  }

  @Test
  void get() throws ApiException {

    when(api.getCallbackConfiguration(eq(uriUUID)))
        .thenReturn(CallbackConfigurationDtoTest.getResponse);

    CallbackConfigurationResponse response = service.get();

    TestHelpers.recursiveEquals(response, CallbackConfigurationDtoTest.getResponse);
  }

  @Test
  void update() {

    when(api.updateCallbackConfiguration(
            eq(uriUUID), eq(CallbackConfigurationDtoTest.updateRequest)))
        .thenReturn(CallbackConfigurationDtoTest.getResponse);

    CallbackConfigurationResponse response =
        service.update(CallbackConfigurationDtoTest.updateRequest);

    TestHelpers.recursiveEquals(response, CallbackConfigurationDtoTest.getResponse);
  }
}
