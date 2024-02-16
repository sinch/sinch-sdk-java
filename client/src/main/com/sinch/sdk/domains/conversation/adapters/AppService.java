package com.sinch.sdk.domains.conversation.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.conversation.adapters.api.v1.AppApi;
import com.sinch.sdk.domains.conversation.adapters.converters.AppDtoConverter;
import com.sinch.sdk.domains.conversation.models.requests.AppRequestParameters;
import com.sinch.sdk.domains.conversation.models.responses.App;
import com.sinch.sdk.models.Configuration;
import java.util.Collection;
import java.util.Map;

public class AppService implements com.sinch.sdk.domains.conversation.AppService {

  private final Configuration configuration;
  private final AppApi api;

  public AppService(
      Configuration configuration, HttpClient httpClient, Map<String, AuthManager> authManagers) {
    this.configuration = configuration;
    this.api =
        new AppApi(
            httpClient, configuration.getConversationServer(), authManagers, new HttpMapper());
  }

  protected AppApi getApi() {
    return this.api;
  }

  public Collection<App> list() throws ApiException {
    return AppDtoConverter.convert(getApi().appListApps(configuration.getProjectId()));
  }

  public App get(String appId) {
    return AppDtoConverter.convert(getApi().appGetApp(configuration.getProjectId(), appId));
  }

  public void delete(String appId) {
    getApi().appDeleteApp(configuration.getProjectId(), appId);
  }

  public App create(AppRequestParameters parameters) {

    return AppDtoConverter.convert(
        getApi()
            .appCreateApp(
                this.configuration.getProjectId(), AppDtoConverter.convertForCreate(parameters)));
  }

  public App update(String appId, AppRequestParameters parameters) {
    return AppDtoConverter.convert(
        getApi()
            .appUpdateApp(
                this.configuration.getProjectId(),
                appId,
                AppDtoConverter.convertForUpdate(parameters),
                null));
  }
}
