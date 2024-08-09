package com.sinch.sdk.domains.conversation.api.v1.adapters;

import com.sinch.sdk.auth.adapters.OAuthManager;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.conversation.api.v1.adapters.events.app.AppEventMapper;
import com.sinch.sdk.domains.conversation.api.v1.adapters.events.contactmessage.internal.ContactMessageEventMapper;
import com.sinch.sdk.domains.conversation.api.v1.adapters.events.contacts.internal.ContactEventMapper;
import com.sinch.sdk.domains.conversation.api.v1.adapters.messages.AppMessageMapper;
import com.sinch.sdk.domains.conversation.api.v1.adapters.messages.ChannelSpecificContactMessageMapper;
import com.sinch.sdk.domains.conversation.api.v1.adapters.messages.ContactMessageMapper;
import com.sinch.sdk.domains.conversation.api.v1.adapters.messages.ConversationMessageMapper;
import com.sinch.sdk.domains.conversation.api.v1.adapters.messages.ListSectionMapper;
import com.sinch.sdk.domains.conversation.api.v1.adapters.messages.OmniMessageOverrideMapper;
import com.sinch.sdk.domains.conversation.api.v1.adapters.messages.SendMessageRequestMapper;
import com.sinch.sdk.domains.conversation.api.v1.adapters.messages.WhatsAppInteractiveHeaderMapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.AppMessageInternalMapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.ChannelSpecificMessageInternalMapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.carousel.CarouselMessageMapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.ChoiceMessageMapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.template.TemplateMessageMapper;
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
  private WebHooksService webhooks;

  static {
    LocalLazyInit.init();
  }

  public ConversationService(
      UnifiedCredentials credentials,
      ConversationContext context,
      ServerConfiguration oAuthServer,
      HttpClient httpClient) {

    Objects.requireNonNull(credentials, "Conversation service requires credentials to be defined");
    Objects.requireNonNull(context, "Conversation service requires context to be defined");
    StringUtil.requireNonEmpty(
        credentials.getKeyId(), "Conversation service requires 'keyId' to be defined");
    StringUtil.requireNonEmpty(
        credentials.getKeySecret(), "Conversation service requires 'keySecret' to be defined");
    StringUtil.requireNonEmpty(
        credentials.getProjectId(), "Conversation service requires 'projectId' to be defined");
    StringUtil.requireNonEmpty(
        context.getUrl(), "Conversation service requires 'url' to be defined");
    StringUtil.requireNonEmpty(
        context.getTemplateManagementUrl(),
        "Conversation service requires  'templateManagementUrl' to be defined");

    LOGGER.fine(
        String.format(
            "Activate conversation API with server: '%s', template server: '%s",
            context.getServer().getUrl(), context.getTemplateManagementServer().getUrl()));

    this.uriUUID = credentials.getProjectId();
    this.context = context;
    this.httpClient = httpClient;

    OAuthManager authManager =
        new OAuthManager(credentials, oAuthServer, new HttpMapper(), httpClient);
    authManagers =
        Stream.of(new AbstractMap.SimpleEntry<>(SECURITY_SCHEME_KEYWORD_, authManager))
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

  public WebHooksService webhooks() {
    if (null == this.webhooks) {
      this.webhooks = new WebHooksService(new ConversationWebhooksAuthenticationValidation());
    }
    return this.webhooks;
  }

  static final class LocalLazyInit {

    private LocalLazyInit() {
      AppEventMapper.initMapper();
      AppMessageMapper.initMapper();
      AppMessageInternalMapper.initMapper();
      CarouselMessageMapper.initMapper();
      ChannelSpecificContactMessageMapper.initMapper();
      ChannelSpecificMessageInternalMapper.initMapper();
      ChoiceMessageMapper.initMapper();
      ContactEventMapper.initMapper();
      ContactMessageEventMapper.initMapper();
      ContactMessageMapper.initMapper();
      ConversationMessageMapper.initMapper();
      ListSectionMapper.initMapper();
      OmniMessageOverrideMapper.initMapper();
      RecipientMapper.initMapper();
      SendMessageRequestMapper.initMapper();
      TemplateMessageMapper.initMapper();
      WhatsAppInteractiveHeaderMapper.initMapper();
    }

    public static LocalLazyInit init() {
      return LocalLazyInit.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {

      public static final LocalLazyInit INSTANCE = new LocalLazyInit();
    }
  }
}
