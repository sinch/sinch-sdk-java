package com.sinch.sdk.domains.conversation.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.conversation.adapters.api.v1.AppApi;
import com.sinch.sdk.domains.conversation.adapters.converters.AppDtoConverter;
import com.sinch.sdk.domains.conversation.models.requests.AppRequestParameters;
import com.sinch.sdk.domains.conversation.models.responses.App;
import com.sinch.sdk.models.ConversationContext;
import java.util.Collection;
import java.util.Map;

public class AppService implements com.sinch.sdk.domains.conversation.AppService {

  private final String uriUUID;
  private final AppApi api;

  public AppService(
      String uriUUID,
      ConversationContext context,
      HttpClient httpClient,
      Map<String, AuthManager> authManagers) {
    this.uriUUID = uriUUID;
    this.api = new AppApi(httpClient, context.getServer(), authManagers, new HttpMapper());
  }

  protected AppApi getApi() {
    return this.api;
  }

  public Collection<App> list() throws ApiException {
    return AppDtoConverter.convert(getApi().appListApps(uriUUID));
  }

  public App get(String appId) {
    return AppDtoConverter.convert(getApi().appGetApp(uriUUID, appId));
  }

  public void delete(String appId) {
    getApi().appDeleteApp(uriUUID, appId);
  }

  public App create(AppRequestParameters parameters) {

    return AppDtoConverter.convert(
        getApi().appCreateApp(uriUUID, AppDtoConverter.convertForCreate(parameters)));
  }

  public App update(String appId, AppRequestParameters parameters) {
    return AppDtoConverter.convert(
        getApi().appUpdateApp(uriUUID, appId, AppDtoConverter.convertForUpdate(parameters), null));
  }
}
