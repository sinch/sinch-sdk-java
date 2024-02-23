package com.sinch.sdk.domains.numbers.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.numbers.adapters.api.v1.CallbacksApi;
import com.sinch.sdk.domains.numbers.models.CallbackConfiguration;
import com.sinch.sdk.domains.numbers.models.dto.v1.CallbackConfigurationDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.CallbackConfigurationUpdateDto;
import com.sinch.sdk.domains.numbers.models.requests.CallbackConfigurationUpdateRequestParameters;
import com.sinch.sdk.models.NumbersContext;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
class CallbackConfigurationServiceTest extends BaseTest {

  @GivenJsonResource("/domains/numbers/v1/callback-configuration.json")
  CallbackConfigurationDto callbackConfigurationDto;

  @Mock NumbersContext context;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;
  @Mock CallbacksApi api;
  CallbackConfigurationService service;

  String uriUUID = "foo";

  @BeforeEach
  public void initMocks() {
    service = spy(new CallbackConfigurationService(uriUUID, context, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void get() throws ApiException {

    when(api.getCallbackConfiguration(eq(uriUUID))).thenReturn(callbackConfigurationDto);

    CallbackConfiguration response = service.get();

    CallbackConfiguration expected =
        CallbackConfiguration.builder()
            .setProjectId("The project ID")
            .setHMACSecret("The secret HMAC")
            .build();

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expected);
  }

  @Test
  void update() throws ApiException {

    CallbackConfigurationUpdateDto dtoParameters =
        new CallbackConfigurationUpdateDto().hmacSecret("hmac value");
    CallbackConfigurationUpdateRequestParameters parameters =
        CallbackConfigurationUpdateRequestParameters.builder().setHMACSecret("hmac value").build();

    when(api.updateCallbackConfiguration(eq(uriUUID), eq(dtoParameters)))
        .thenReturn(callbackConfigurationDto);

    CallbackConfiguration response = service.update(parameters);

    CallbackConfiguration expected =
        CallbackConfiguration.builder()
            .setProjectId("The project ID")
            .setHMACSecret("The secret HMAC")
            .build();

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expected);
  }
}
