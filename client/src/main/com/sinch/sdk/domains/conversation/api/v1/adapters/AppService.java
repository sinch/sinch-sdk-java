package com.sinch.sdk.domains.conversation.api.v1.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.conversation.api.v1.internal.AppApi;
import com.sinch.sdk.domains.conversation.models.v1.app.request.AppCreateRequest;
import com.sinch.sdk.domains.conversation.models.v1.app.request.AppUpdateRequest;
import com.sinch.sdk.domains.conversation.models.v1.app.response.AppResponse;
import com.sinch.sdk.models.ConversationContext;
import java.util.Collection;
import java.util.Map;

public class AppService implements com.sinch.sdk.domains.conversation.api.v1.AppService {

  private final String uriUUID;
  private final AppApi api;

  public AppService(
      String uriUUID,
      ConversationContext context,
      HttpClient httpClient,
      Map<String, AuthManager> authManagers) {
    this.uriUUID = uriUUID;
    this.api = new AppApi(httpClient, context.getServer(), authManagers, HttpMapper.getInstance());
  }

  protected AppApi getApi() {
    return this.api;
  }

  public Collection<AppResponse> list() throws ApiException {
    return getApi().appListApps(uriUUID).getApps();
  }

  public AppResponse get(String appId) {
    return getApi().appGetApp(uriUUID, appId);
  }

  public void delete(String appId) {
    getApi().appDeleteApp(uriUUID, appId);
  }

  public AppResponse create(AppCreateRequest parameters) {

    return getApi().appCreateApp(uriUUID, parameters);
  }

  public AppResponse update(String appId, AppUpdateRequest parameters) {
    return getApi().appUpdateApp(uriUUID, appId, parameters, null);
  }
}
