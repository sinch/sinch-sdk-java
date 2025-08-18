package com.sinch.sdk.domains.conversation.templates.api.adapters;

import com.sinch.sdk.auth.adapters.OAuthManager;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationService;
import com.sinch.sdk.domains.conversation.templates.api.v2.TemplatesV2Service;
import com.sinch.sdk.domains.conversation.templates.api.v2.adapters.TemplatesV2ServiceImpl;
import com.sinch.sdk.domains.conversation.templates.models.v2.ChannelTemplateOverrideMapper;
import com.sinch.sdk.domains.conversation.templates.models.v2.TemplateTranslationMapper;
import com.sinch.sdk.models.ConversationContext;
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TemplatesService
    implements com.sinch.sdk.domains.conversation.templates.api.TemplatesService {

  private static final Logger LOGGER = Logger.getLogger(TemplatesService.class.getName());
  private static final String SECURITY_SCHEME_KEYWORD_ = "oAuth2";

  private final String uriUUID;
  private final UnifiedCredentials credentials;
  private final ServerConfiguration oAuthServer;

  private final ConversationContext context;
  private final Supplier<HttpClient> httpClientSupplier;

  private volatile Map<String, AuthManager> authManagers;
  private volatile TemplatesV2Service v2;

  static {
    LocalLazyInit.init();
  }

  public TemplatesService(
      UnifiedCredentials credentials,
      ConversationContext context,
      ServerConfiguration oAuthServer,
      Supplier<HttpClient> httpClientSupplier) {

    this.uriUUID = null != credentials ? credentials.getProjectId() : null;
    this.context = context;
    this.credentials = credentials;
    this.oAuthServer = oAuthServer;
    this.httpClientSupplier = httpClientSupplier;
  }

  public TemplatesV2Service v2() {
    if (null == this.v2) {
      instanceLazyInit();
      this.v2 =
          new TemplatesV2ServiceImpl(
              httpClientSupplier.get(),
              context.getTemplateManagementServer(),
              authManagers,
              HttpMapper.getInstance(),
              this.uriUUID);
    }
    return this.v2;
  }

  private void instanceLazyInit() {
    if (null != this.authManagers) {
      return;
    }
    synchronized (this) {
      if (null == this.authManagers) {
        Objects.requireNonNull(credentials, "Templates service requires credentials to be defined");
        Objects.requireNonNull(context, "Templates service requires context to be defined");
        StringUtil.requireNonEmpty(
            credentials.getKeyId(), "Templates service requires 'keyId' to be defined");
        StringUtil.requireNonEmpty(
            credentials.getKeySecret(), "Templates service requires 'keySecret' to be defined");
        StringUtil.requireNonEmpty(
            credentials.getProjectId(), "Templates service requires 'projectId' to be defined");

        StringUtil.requireNonEmpty(
            context.getTemplateManagementUrl(),
            "Templates service requires 'templateManagementUrl' to be defined");

        // To be deprecated with 2.0: no more defaulting to US region
        if (Boolean.TRUE == context.regionAsDefault()) {
          LOGGER.warning(
              String.format(
                  "Using default region for Conversation Template '%s'. This default fallback will"
                      + " be removed in next major release and will cause a runtime error. Please"
                      + " configure the region you want to be used (see"
                      + " https://www.javadoc.io/static/com.sinch.sdk/sinch-sdk-java/1.6.0/com/sinch/sdk/models/Configuration.Builder.html#setConversationRegion(com.sinch.sdk.models.ConversationRegion))",
                  context.getRegion()));
        }

        OAuthManager authManager =
            new OAuthManager(
                credentials, oAuthServer, HttpMapper.getInstance(), httpClientSupplier);
        authManagers =
            Stream.of(new AbstractMap.SimpleEntry<>(SECURITY_SCHEME_KEYWORD_, authManager))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        LOGGER.fine(
            String.format(
                "Activate templates API with template server: '%s",
                context.getTemplateManagementServer().getUrl()));
      }
    }
  }

  static final class LocalLazyInit {

    private LocalLazyInit() {
      // Because of templates classes are depending of Conversation classes we need to init for a
      // proper serialize/deserialize process
      ConversationService.LocalLazyInit.init();
      TemplateTranslationMapper.initMapper();
      ChannelTemplateOverrideMapper.initMapper();
    }

    public static LocalLazyInit init() {
      return LocalLazyInit.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {

      public static final LocalLazyInit INSTANCE = new LocalLazyInit();
    }
  }
}
