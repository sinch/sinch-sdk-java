package com.sinch.sdk.domains.conversation.api.v1.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.conversation.api.v1.internal.AppApi;
import com.sinch.sdk.domains.conversation.models.v1.AppDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.app.response.AppResponse;
import com.sinch.sdk.models.ConversationContext;
import java.util.Collection;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class AppServiceTest extends BaseTest {

  @Mock ConversationContext context;
  @Mock AppApi api;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;

  AppService service;
  String uriPartID = "foovalue";

  @BeforeEach
  public void initMocks() {
    service = spy(new AppService(uriPartID, context, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void list() throws ApiException {

    when(api.appListApps(eq(uriPartID))).thenReturn(AppDtoTest.expectedListAppsResponseDto);

    Collection<AppResponse> response = service.list();

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(AppDtoTest.expectedListAppsResponseDto.getApps());
  }

  @Test
  void get() throws ApiException {

    when(api.appGetApp(eq(uriPartID), eq(AppDtoTest.expectedAppResponseDto.getId())))
        .thenReturn(AppDtoTest.expectedAppResponseDto);

    AppResponse response = service.get(AppDtoTest.expectedAppResponseDto.getId());

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(AppDtoTest.expectedAppResponseDto);
  }

  @Test
  void create() throws ApiException {

    when(api.appCreateApp(eq(uriPartID), eq(AppDtoTest.appCreateRequestDto)))
        .thenReturn(AppDtoTest.expectedAppResponseDto);

    AppResponse response = service.create(AppDtoTest.appCreateRequestDto);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(AppDtoTest.expectedAppResponseDto);
  }

  @Test
  void update() throws ApiException {

    when(api.appUpdateApp(
            eq(uriPartID),
            eq(AppDtoTest.expectedAppResponseDto.getId()),
            eq(AppDtoTest.appUpdateRequestDto),
            eq(null)))
        .thenReturn(AppDtoTest.expectedAppResponseDto);

    AppResponse response =
        service.update(AppDtoTest.expectedAppResponseDto.getId(), AppDtoTest.appUpdateRequestDto);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(AppDtoTest.expectedAppResponseDto);
  }
}
