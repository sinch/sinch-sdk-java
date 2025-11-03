package com.sinch.sdk.domains.conversation.api.v1.adapters;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.conversation.api.v1.internal.ProjectSettingsApi;
import com.sinch.sdk.domains.conversation.models.v1.projectsettings.request.ProjectSettingsRequest;
import com.sinch.sdk.domains.conversation.models.v1.projectsettings.response.ProjectSettingsResponse;
import com.sinch.sdk.models.ConversationContext;
import java.util.Map;

public class ProjectSettingsService
    implements com.sinch.sdk.domains.conversation.api.v1.ProjectSettingsService {

  private final String uriUUID;
  private final ProjectSettingsApi api;

  public ProjectSettingsService(
      String uriUUID,
      ConversationContext context,
      HttpClient httpClient,
      Map<String, AuthManager> authManagers) {
    this.uriUUID = uriUUID;
    this.api =
        new ProjectSettingsApi(
            httpClient, context.getServer(), authManagers, HttpMapper.getInstance());
  }

  protected ProjectSettingsApi getApi() {
    return this.api;
  }

  @Override
  public ProjectSettingsResponse create(ProjectSettingsRequest projectSettingsRequest) {
    return getApi().create(uriUUID, projectSettingsRequest);
  }

  @Override
  public void delete() {
    getApi().delete(uriUUID);
  }

  @Override
  public ProjectSettingsResponse get() {
    return getApi().get(uriUUID);
  }

  @Override
  public ProjectSettingsResponse update(ProjectSettingsRequest projectSettingsRequest) {
    return getApi().update(uriUUID, projectSettingsRequest);
  }
}
