package com.sinch.sdk.domains.conversation.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.conversation.adapters.api.v1.AppApi;
import com.sinch.sdk.domains.conversation.adapters.converters.AppConverterTest;
import com.sinch.sdk.domains.conversation.models.dto.v1.AppDtoTest;
import com.sinch.sdk.domains.conversation.models.responses.App;
import com.sinch.sdk.models.Configuration;
import java.util.Collection;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class AppServiceTest extends BaseTest {

  @Mock AppApi api;
  Configuration configuration = Configuration.builder().setProjectId("").build();
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;

  AppService service;

  @BeforeEach
  public void initMocks() {
    service = spy(new AppService(configuration, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void list() throws ApiException {

    when(api.appListApps(eq(configuration.getUnifiedCredentials().get().getProjectId())))
        .thenReturn(AppDtoTest.expectedListAppsResponseDto);

    Collection<App> response = service.list();

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(AppConverterTest.expectedAppList);
  }

  @Test
  void get() throws ApiException {

    when(api.appGetApp(
            eq(configuration.getUnifiedCredentials().get().getProjectId()),
            eq(AppDtoTest.expectedAppsResponseDto.getId())))
        .thenReturn(AppDtoTest.expectedAppsResponseDto);

    App response = service.get(AppDtoTest.expectedAppsResponseDto.getId());

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(AppConverterTest.expectedAPPResponse);
  }

  @Test
  void create() throws ApiException {

    when(api.appCreateApp(
            eq(configuration.getUnifiedCredentials().get().getProjectId()),
            eq(AppDtoTest.appCreateRequestDto)))
        .thenReturn(AppDtoTest.expectedAppsResponseDto);

    App response = service.create(AppConverterTest.appRequest);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(AppConverterTest.expectedAPPResponse);
  }

  @Test
  void update() throws ApiException {

    when(api.appUpdateApp(
            eq(configuration.getUnifiedCredentials().get().getProjectId()),
            eq(AppConverterTest.expectedAPPResponse.getId()),
            eq(AppDtoTest.appUpdateRequestDto),
            eq(null)))
        .thenReturn(AppDtoTest.expectedAppsResponseDto);

    App response =
        service.update(AppConverterTest.expectedAPPResponse.getId(), AppConverterTest.appRequest);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(AppConverterTest.expectedAPPResponse);
  }
}
