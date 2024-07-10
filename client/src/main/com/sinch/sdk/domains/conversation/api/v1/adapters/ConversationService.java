package com.sinch.sdk.domains.conversation.api.v1.adapters;

import com.sinch.sdk.auth.adapters.OAuthManager;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.models.ConversationContext;
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConversationService
    implements com.sinch.sdk.domains.conversation.api.v1.ConversationService {

  private static final Logger LOGGER = Logger.getLogger(ConversationService.class.getName());
  private static final String SECURITY_SCHEME_KEYWORD_ = "oAuth2";

  private final String uriUUID;
  private final ConversationContext context;
  private final HttpClient httpClient;
  private final Map<String, AuthManager> authManagers;
  private AppService app;
  private ContactService contact;
  private MessagesService messages;

  static {
    LocalLazyInit.init();
  }

  public ConversationService(
      UnifiedCredentials credentials,
      ConversationContext context,
      ServerConfiguration oAuthServer,
      HttpClient httpClient) {

    Objects.requireNonNull(credentials, "Credentials must be defined");
    Objects.requireNonNull(context, "Context must be defined");
    StringUtil.requireNonEmpty(credentials.getKeyId(), "'keyId' must be defined");
    StringUtil.requireNonEmpty(credentials.getKeySecret(), "'keySecret' must be defined");
    StringUtil.requireNonEmpty(credentials.getProjectId(), "'projectId' must be defined");
    StringUtil.requireNonEmpty(context.getUrl(), "'url' must be defined");
    StringUtil.requireNonEmpty(
        context.getTemplateManagementUrl(), "'templateManagementUrl' must be defined");

    LOGGER.fine(
        String.format(
            "Activate conversation API with server: '%s', template server: '%s",
            context.getServer().getUrl(), context.getTemplateManagementServer().getUrl()));

    this.uriUUID = credentials.getProjectId();
    this.context = context;
    this.httpClient = httpClient;

    OAuthManager bearerAuthManager =
        new OAuthManager(credentials, oAuthServer, new HttpMapper(), httpClient);
    authManagers =
        Stream.of(new AbstractMap.SimpleEntry<>(SECURITY_SCHEME_KEYWORD_, bearerAuthManager))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  public AppService app() {
    if (null == this.app) {
      this.app = new AppService(uriUUID, context, httpClient, authManagers);
    }
    return this.app;
  }

  public ContactService contact() {
    if (null == this.contact) {
      this.contact = new ContactService(uriUUID, context, httpClient, authManagers);
    }
    return this.contact;
  }

  public MessagesService messages() {
    if (null == this.messages) {
      this.messages = new MessagesService(uriUUID, context, httpClient, authManagers);
    }
    return this.messages;
  }

  static final class LocalLazyInit {

    private LocalLazyInit() {
      RecipientMapper.initMapper();
    }

    public static LocalLazyInit init() {
      return LocalLazyInit.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {

      public static final LocalLazyInit INSTANCE = new LocalLazyInit();
    }
  }
}
