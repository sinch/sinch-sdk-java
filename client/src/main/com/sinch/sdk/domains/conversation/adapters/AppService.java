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

  private final String uriPathID;
  private final AppApi api;

  public AppService(
      String uriPathID,
      ConversationContext context,
      HttpClient httpClient,
      Map<String, AuthManager> authManagers) {
    this.uriPathID = uriPathID;
    this.api = new AppApi(httpClient, context.getServer(), authManagers, new HttpMapper());
  }

  protected AppApi getApi() {
    return this.api;
  }

  public Collection<App> list() throws ApiException {
    return AppDtoConverter.convert(getApi().appListApps(uriPathID));
  }

  public App get(String appId) {
    return AppDtoConverter.convert(getApi().appGetApp(uriPathID, appId));
  }

  public void delete(String appId) {
    getApi().appDeleteApp(uriPathID, appId);
  }

  public App create(AppRequestParameters parameters) {

    return AppDtoConverter.convert(
        getApi().appCreateApp(uriPathID, AppDtoConverter.convertForCreate(parameters)));
  }

  public App update(String appId, AppRequestParameters parameters) {
    return AppDtoConverter.convert(
        getApi()
            .appUpdateApp(uriPathID, appId, AppDtoConverter.convertForUpdate(parameters), null));
  }
}
