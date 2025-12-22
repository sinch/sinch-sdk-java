package com.sinch.sdk.domains.conversation.api.v1.adapters;

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
import com.sinch.sdk.domains.conversation.api.v1.internal.ProjectSettingsApi;
import com.sinch.sdk.domains.conversation.models.v1.projectsettings.request.ProjectSettingsRequestDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.projectsettings.response.ProjectSettingsResponse;
import com.sinch.sdk.domains.conversation.models.v1.projectsettings.response.ProjectSettingsResponseDtoTest;
import com.sinch.sdk.models.ConversationContext;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;

@TestWithResources
class ProjectSettingsServiceTest extends BaseTest {

  @Mock ConversationContext context;
  @Mock ProjectSettingsApi api;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;

  @Captor ArgumentCaptor<String> projectIdCaptor;

  ProjectSettingsService service;
  String uriPartID = "foovalue";

  @BeforeEach
  public void initMocks() {
    service = spy(new ProjectSettingsService(uriPartID, context, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void create() throws ApiException {

    when(api.create(eq(uriPartID), eq(ProjectSettingsRequestDtoTest.expectedDto)))
        .thenReturn(ProjectSettingsResponseDtoTest.expectedDto);

    ProjectSettingsResponse response = service.create(ProjectSettingsRequestDtoTest.expectedDto);

    TestHelpers.recursiveEquals(response, ProjectSettingsResponseDtoTest.expectedDto);
  }

  @Test
  void get() throws ApiException {

    when(api.get(eq(uriPartID))).thenReturn(ProjectSettingsResponseDtoTest.expectedDto);

    ProjectSettingsResponse response = service.get();

    TestHelpers.recursiveEquals(response, ProjectSettingsResponseDtoTest.expectedDto);
  }

  @Test
  void update() throws ApiException {

    when(api.update(eq(uriPartID), eq(ProjectSettingsRequestDtoTest.expectedDto)))
        .thenReturn(ProjectSettingsResponseDtoTest.expectedDto);

    ProjectSettingsResponse response = service.update(ProjectSettingsRequestDtoTest.expectedDto);

    TestHelpers.recursiveEquals(response, ProjectSettingsResponseDtoTest.expectedDto);
  }

  @Test
  void delete() throws ApiException {

    service.delete();

    verify(api).delete(projectIdCaptor.capture());

    Assertions.assertThat(projectIdCaptor.getValue()).isEqualTo(uriPartID);
  }
}
