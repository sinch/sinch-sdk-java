package com.sinch.sdk.domains.conversation.adapters;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.models.ConversationContext;
import com.sinch.sdk.models.UnifiedCredentials;

public class ConversationService implements com.sinch.sdk.domains.conversation.ConversationService {

  private final com.sinch.sdk.domains.conversation.api.v1.ConversationService v1;

  public ConversationService(
      UnifiedCredentials credentials,
      ConversationContext context,
      ServerConfiguration oAuthServer,
      HttpClient httpClient) {

    this.v1 =
        new com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationService(
            credentials, context, oAuthServer, httpClient);
  }

  public com.sinch.sdk.domains.conversation.api.v1.ConversationService v1() {
    return v1;
  }
}
