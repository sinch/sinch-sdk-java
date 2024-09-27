package com.sinch.sdk.domains.conversation.adapters;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.conversation.api.templates.adapters.TemplatesService;
import com.sinch.sdk.models.ConversationContext;
import com.sinch.sdk.models.UnifiedCredentials;

public class ConversationService implements com.sinch.sdk.domains.conversation.ConversationService {

  private final UnifiedCredentials credentials;
  private final ConversationContext context;
  private final ServerConfiguration oAuthServer;
  private final HttpClient httpClient;

  private com.sinch.sdk.domains.conversation.api.v1.ConversationService conversationV1;
  private TemplatesService templates;

  public ConversationService(
      UnifiedCredentials credentials,
      ConversationContext context,
      ServerConfiguration oAuthServer,
      HttpClient httpClient) {
    this.credentials = credentials;
    this.context = context;
    this.oAuthServer = oAuthServer;
    this.httpClient = httpClient;
  }

  public com.sinch.sdk.domains.conversation.api.v1.ConversationService v1() {
    if (null == this.conversationV1) {
      this.conversationV1 =
          new com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationService(
              credentials, context, oAuthServer, httpClient);
    }
    return this.conversationV1;
  }

  public TemplatesService templates() {
    if (null == this.templates) {
      this.templates = new TemplatesService(credentials, context, oAuthServer, httpClient);
    }
    return this.templates;
  }
}
