package com.sinch.sdk.domains.numbers.adapters.api.v1;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.numbers.models.dto.v1.CallbackConfigurationDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.CallbackConfigurationUpdateDto;
import java.nio.charset.StandardCharsets;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@TestWithResources
class CallbackConfigurationApiTest extends BaseTest {

  @GivenTextResource("/domains/numbers/v1/callback-configuration.json")
  String callbackConfiguration;

  @Mock HttpClient httpClient;
  @Mock ServerConfiguration serverConfiguration;
  HttpMapper mapper = new HttpMapper();

  @InjectMocks
  CallbackConfigurationApi service =
      new CallbackConfigurationApi(httpClient, serverConfiguration, null, mapper);

  CallbackConfigurationDto expectedDto =
      new CallbackConfigurationDto().projectId("The project ID").hmacSecret("The secret HMAC");

  @Test
  void get() {

    when(httpClient.invokeAPI(eq(serverConfiguration), any(), any()))
        .thenReturn(
            new HttpResponse(
                200, "foo message", null, callbackConfiguration.getBytes(StandardCharsets.UTF_8)));

    CallbackConfigurationDto response = service.getCallbackConfiguration("project");

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expectedDto);
  }

  @Test
  void update() {

    when(httpClient.invokeAPI(eq(serverConfiguration), any(), any()))
        .thenReturn(
            new HttpResponse(
                200, "foo message", null, callbackConfiguration.getBytes(StandardCharsets.UTF_8)));

    CallbackConfigurationUpdateDto parameters =
        new CallbackConfigurationUpdateDto().hmacSecret("HMAC value");

    CallbackConfigurationDto response = service.updateCallbackConfiguration("project", parameters);

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expectedDto);
  }
}
