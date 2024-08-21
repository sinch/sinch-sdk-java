package com.sinch.sdk.domains.conversation.api.v1.adapters;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.conversation.api.v1.internal.CapabilityApi;
import com.sinch.sdk.domains.conversation.models.v1.capability.request.QueryCapabilityRequest;
import com.sinch.sdk.domains.conversation.models.v1.capability.response.QueryCapabilityResponse;
import com.sinch.sdk.models.ConversationContext;
import java.util.Map;

public class CapabilityService
    implements com.sinch.sdk.domains.conversation.api.v1.CapabilityService {

  private final String uriUUID;
  private final CapabilityApi api;

  public CapabilityService(
      String uriUUID,
      ConversationContext context,
      HttpClient httpClient,
      Map<String, AuthManager> authManagers) {
    this.uriUUID = uriUUID;
    this.api = new CapabilityApi(httpClient, context.getServer(), authManagers, new HttpMapper());
  }

  protected CapabilityApi getApi() {
    return this.api;
  }

  public QueryCapabilityResponse lookup(QueryCapabilityRequest request) {
    return getApi().capabilityQueryCapability(uriUUID, request);
  }
}
