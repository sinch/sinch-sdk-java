package com.sinch.sdk.domains.conversation.api.templates.adapters;

import com.sinch.sdk.auth.adapters.OAuthManager;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.conversation.api.templates.adapters.v1.TemplatesServiceV1;
import com.sinch.sdk.domains.conversation.api.templates.adapters.v2.TemplatesServiceV2;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationService;
import com.sinch.sdk.domains.conversation.templates.models.v2.ChannelTemplateOverrideMapper;
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
    implements com.sinch.sdk.domains.conversation.api.templates.TemplatesService {

  private static final Logger LOGGER = Logger.getLogger(TemplatesService.class.getName());
  private static final String SECURITY_SCHEME_KEYWORD_ = "oAuth2";

  private final String uriUUID;
  private final UnifiedCredentials credentials;
  private final ServerConfiguration oAuthServer;

  private final ConversationContext context;
  private final Supplier<HttpClient> httpClientSupplier;

  private volatile Map<String, AuthManager> authManagers;
  private volatile TemplatesServiceV1 v1;
  private volatile TemplatesServiceV2 v2;

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

  public TemplatesServiceV1 v1() {
    if (null == this.v1) {
      instanceLazyInit();
      this.v1 = new TemplatesServiceV1(uriUUID, context, httpClientSupplier.get(), authManagers);
    }
    return this.v1;
  }

  public TemplatesServiceV2 v2() {
    if (null == this.v2) {
      instanceLazyInit();
      this.v2 = new TemplatesServiceV2(uriUUID, context, httpClientSupplier.get(), authManagers);
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
