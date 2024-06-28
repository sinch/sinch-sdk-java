package com.sinch.sdk.domains.numbers.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.models.CallbackConfiguration;
import com.sinch.sdk.domains.numbers.models.requests.CallbackConfigurationUpdateRequestParameters;
import com.sinch.sdk.domains.numbers.models.v1.CallbackConfigurationDtoTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
class CallbackConfigurationServiceTest extends BaseTest {

  @Mock com.sinch.sdk.domains.numbers.api.v1.CallbackConfigurationService v1;

  CallbackConfigurationService service;

  @BeforeEach
  public void initMocks() {
    service = spy(new CallbackConfigurationService(v1));
  }

  @Test
  void get() throws ApiException {

    when(v1.get()).thenReturn(CallbackConfigurationDtoTest.getResponse);

    CallbackConfiguration response = service.get();

    CallbackConfiguration expected =
        CallbackConfiguration.builder()
            .setProjectId("Project ID value")
            .setHMACSecret("HMAC value")
            .build();

    TestHelpers.recursiveEquals(response, expected);
  }

  @Test
  void update() throws ApiException {

    when(v1.update(eq(CallbackConfigurationDtoTest.updateRequest)))
        .thenReturn(CallbackConfigurationDtoTest.getResponse);

    CallbackConfigurationUpdateRequestParameters parameters =
        CallbackConfigurationUpdateRequestParameters.builder().setHMACSecret("HMAC value").build();
    CallbackConfiguration response = service.update(parameters);

    CallbackConfiguration expected =
        CallbackConfiguration.builder()
            .setProjectId("Project ID value")
            .setHMACSecret("HMAC value")
            .build();

    TestHelpers.recursiveEquals(response, expected);
  }
}
