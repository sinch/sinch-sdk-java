package com.sinch.sdk.domains.conversation.api.v1.adapters;

import com.sinch.sdk.auth.adapters.OAuthManager;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.conversation.api.templates.adapters.TemplatesService;
import com.sinch.sdk.domains.conversation.api.v1.WebHooksService;
import com.sinch.sdk.domains.conversation.api.v1.adapters.credentials.LineEnterpriseCredentialsMapper;
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
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceItemMapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.AppMessageInternalMapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.ChannelSpecificMessageInternalMapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.ContactMessageInternalMapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.carousel.CarouselMessageMapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.CardMessageMapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.ChoiceMessageMapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.ListMessageInternalMapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.template.TemplateMessageMapper;
import com.sinch.sdk.models.ConversationContext;
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConversationService
    implements com.sinch.sdk.domains.conversation.api.v1.ConversationService {

  private static final Logger LOGGER = Logger.getLogger(ConversationService.class.getName());
  private static final String SECURITY_SCHEME_KEYWORD_ = "oAuth2";

  private final String uriUUID;
  private final UnifiedCredentials credentials;
  private final ServerConfiguration oAuthServer;
  private final ConversationContext context;
  private final Supplier<HttpClient> httpClientSupplier;

  private volatile Map<String, AuthManager> authManagers;
  private volatile AppService app;
  private volatile ContactService contact;
  private volatile MessagesService messages;
  private volatile ConversationsService conversations;
  private volatile EventsService events;
  private volatile TranscodingService transcoding;
  private volatile CapabilityService capability;
  private volatile WebHooksService webhooks;
  private volatile TemplatesService templates;

  static {
    LocalLazyInit.init();
  }

  public ConversationService(
      UnifiedCredentials credentials,
      ConversationContext context,
      ServerConfiguration oAuthServer,
      Supplier<HttpClient> httpClientSupplier) {

    this.uriUUID = null != credentials ? credentials.getProjectId() : null;
    this.credentials = credentials;
    this.context = context;
    this.httpClientSupplier = httpClientSupplier;
    this.oAuthServer = oAuthServer;
  }

  public AppService app() {
    if (null == this.app) {
      instanceLazyInit();
      this.app = new AppService(uriUUID, context, httpClientSupplier.get(), authManagers);
    }
    return this.app;
  }

  public ContactService contact() {
    if (null == this.contact) {
      instanceLazyInit();
      this.contact = new ContactService(uriUUID, context, httpClientSupplier.get(), authManagers);
    }
    return this.contact;
  }

  public MessagesService messages() {
    if (null == this.messages) {
      instanceLazyInit();
      this.messages = new MessagesService(uriUUID, context, httpClientSupplier.get(), authManagers);
    }
    return this.messages;
  }

  public ConversationsService conversations() {
    if (null == this.conversations) {
      instanceLazyInit();
      this.conversations =
          new ConversationsService(uriUUID, context, httpClientSupplier.get(), authManagers);
    }
    return this.conversations;
  }

  public EventsService events() {
    if (null == this.events) {
      instanceLazyInit();
      this.events = new EventsService(uriUUID, context, httpClientSupplier.get(), authManagers);
    }
    return this.events;
  }

  public TranscodingService transcoding() {
    if (null == this.transcoding) {
      instanceLazyInit();
      this.transcoding =
          new TranscodingService(uriUUID, context, httpClientSupplier.get(), authManagers);
    }
    return this.transcoding;
  }

  public CapabilityService capability() {
    if (null == this.capability) {
      instanceLazyInit();
      this.capability =
          new CapabilityService(uriUUID, context, httpClientSupplier.get(), authManagers);
    }
    return this.capability;
  }

  public TemplatesService templates() {
    if (null == this.templates) {
      this.templates = new TemplatesService(credentials, context, oAuthServer, httpClientSupplier);
    }
    return this.templates;
  }

  public WebHooksService webhooks() {
    if (null == this.webhooks) {
      this.webhooks =
          new WebHooksAdaptorService(
              uriUUID, context, this::instanceLazyInit, httpClientSupplier, () -> authManagers);
    }
    return this.webhooks;
  }

  private void instanceLazyInit() {
    if (null != this.authManagers) {
      return;
    }
    synchronized (this) {
      if (null == this.authManagers) {
        Objects.requireNonNull(
            credentials, "Conversation service requires credentials to be defined");
        Objects.requireNonNull(context, "Conversation service requires context to be defined");
        StringUtil.requireNonEmpty(
            credentials.getKeyId(), "Conversation service requires 'keyId' to be defined");
        StringUtil.requireNonEmpty(
            credentials.getKeySecret(), "Conversation service requires 'keySecret' to be defined");
        StringUtil.requireNonEmpty(
            credentials.getProjectId(), "Conversation service requires 'projectId' to be defined");
        StringUtil.requireNonEmpty(
            context.getUrl(), "Conversation service requires 'url' to be defined");

        OAuthManager authManager =
            new OAuthManager(
                credentials, oAuthServer, HttpMapper.getInstance(), httpClientSupplier);
        authManagers =
            Stream.of(new AbstractMap.SimpleEntry<>(SECURITY_SCHEME_KEYWORD_, authManager))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        LOGGER.fine(
            String.format(
                "Activate conversation API with server: '%s'", context.getServer().getUrl()));
      }
    }
  }

  public static final class LocalLazyInit {

    private LocalLazyInit() {
      AppEventMapper.initMapper();
      AppMessageMapper.initMapper();
      AppMessageInternalMapper.initMapper();
      CardMessageMapper.initMapper();
      CarouselMessageMapper.initMapper();
      ChoiceItemMapper.initMapper();
      ChannelSpecificContactMessageMapper.initMapper();
      ChannelSpecificMessageInternalMapper.initMapper();
      ChoiceMessageMapper.initMapper();
      ContactEventMapper.initMapper();
      ContactMessageEventMapper.initMapper();
      ContactMessageMapper.initMapper();
      ContactMessageInternalMapper.initMapper();
      ConversationMessageMapper.initMapper();
      LineEnterpriseCredentialsMapper.initMapper();
      ListMessageInternalMapper.initMapper();
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
