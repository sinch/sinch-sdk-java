package com.sinch.sdk.domains.conversation.adapters;

import com.sinch.sdk.auth.adapters.OAuthManager;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.models.Configuration;
import java.util.AbstractMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConversationService implements com.sinch.sdk.domains.conversation.ConversationService {
  private static final Logger LOGGER = Logger.getLogger(ConversationService.class.getName());
  private static final String SECURITY_SCHEME_KEYWORD_ = "oAuth2";

  private final Configuration configuration;
  private final HttpClient httpClient;
  private AppService app;

  private final Map<String, AuthManager> authManagers;

  public ConversationService(Configuration configuration, HttpClient httpClient) {

    LOGGER.fine(
        String.format(
            "Activate conversation API with server: '%s', template server: '%s",
            configuration.getConversationServer().getUrl(),
            configuration.getConversationTemplateManagementUrlServer().getUrl()));

    this.configuration = configuration;
    this.httpClient = httpClient;

    OAuthManager bearerAuthManager =
        new OAuthManager(
            configuration.getUnifiedCredentials().get(),
            configuration.getOAuthServer(),
            new HttpMapper(),
            httpClient);
    authManagers =
        Stream.of(new AbstractMap.SimpleEntry<>(SECURITY_SCHEME_KEYWORD_, bearerAuthManager))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  public AppService app() {
    if (null == this.app) {
      this.app = new AppService(configuration, httpClient, authManagers);
    }
    return this.app;
  }
}
