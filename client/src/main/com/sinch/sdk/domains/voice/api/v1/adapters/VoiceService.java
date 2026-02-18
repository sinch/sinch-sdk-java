package com.sinch.sdk.domains.voice.api.v1.adapters;

import com.sinch.sdk.auth.adapters.ApplicationAuthManager;
import com.sinch.sdk.auth.adapters.BasicAuthManager;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.voice.api.v1.ApplicationsService;
import com.sinch.sdk.domains.voice.api.v1.CalloutsService;
import com.sinch.sdk.domains.voice.api.v1.CallsService;
import com.sinch.sdk.domains.voice.api.v1.ConferencesService;
import com.sinch.sdk.domains.voice.api.v1.adapters.mapper.CallInformationMapper;
import com.sinch.sdk.domains.voice.api.v1.adapters.mapper.CalloutRequestCustomMapper;
import com.sinch.sdk.domains.voice.api.v1.adapters.mapper.DestinationMapper;
import com.sinch.sdk.models.ApplicationCredentials;
import com.sinch.sdk.models.VoiceContext;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.Supplier;
import java.util.logging.Logger;

public class VoiceService implements com.sinch.sdk.domains.voice.api.v1.VoiceService {
  private static final Logger LOGGER = Logger.getLogger(VoiceService.class.getName());

  private static final String SECURITY_SCHEME_KEYWORD = "Signed";

  private static final String BASIC_SECURITY_SCHEME_KEYWORD = "Basic";

  private static final String APPLICATION_SECURITY_SCHEME_KEYWORD = "Application";

  private final ApplicationCredentials credentials;
  private final VoiceContext context;
  private final Supplier<HttpClient> httpClientSupplier;
  private volatile CalloutsService callouts;
  private volatile ConferencesService conferences;
  private volatile CallsService calls;
  private volatile ApplicationsService applications;
  private volatile WebHooksService webhooks;

  private volatile Map<String, AuthManager> clientAuthManagers;
  private volatile Map<String, AuthManager> webhooksAuthManagers;

  static {
    LocalLazyInit.init();
  }

  public VoiceService(
      ApplicationCredentials credentials,
      VoiceContext context,
      Supplier<HttpClient> httpClientSupplier) {

    this.credentials = credentials;
    this.context = context;
    this.httpClientSupplier = httpClientSupplier;
  }

  private void createAuthManagers(ApplicationCredentials credentials) {

    AuthManager basicAuthManager =
        new BasicAuthManager(credentials.getApplicationKey(), credentials.getApplicationSecret());
    AuthManager applicationAuthManager =
        new ApplicationAuthManager(
            credentials.getApplicationKey(), credentials.getApplicationSecret());

    clientAuthManagers = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    clientAuthManagers.put(SECURITY_SCHEME_KEYWORD, applicationAuthManager);

    // here we need both auth managers to handle webhooks because we are receiving an Authorization
    // header with "Application" keyword
    webhooksAuthManagers = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    webhooksAuthManagers.put(BASIC_SECURITY_SCHEME_KEYWORD, basicAuthManager);
    webhooksAuthManagers.put(APPLICATION_SECURITY_SCHEME_KEYWORD, applicationAuthManager);
  }

  public CalloutsService callouts() {
    if (null == this.callouts) {
      instanceLazyInit();
      this.callouts =
          new CalloutsServiceImpl(
              httpClientSupplier.get(),
              context.getVoiceServer(),
              clientAuthManagers,
              HttpMapper.getInstance());
    }
    return this.callouts;
  }

  public ConferencesService conferences() {
    if (null == this.conferences) {
      instanceLazyInit();
      this.conferences =
          new ConferencesServiceImpl(
              httpClientSupplier.get(),
              context.getVoiceServer(),
              clientAuthManagers,
              HttpMapper.getInstance());
    }
    return this.conferences;
  }

  public CallsService calls() {
    if (null == this.calls) {
      instanceLazyInit();
      this.calls =
          new CallsServiceImpl(
              httpClientSupplier.get(),
              context.getVoiceServer(),
              clientAuthManagers,
              HttpMapper.getInstance());
    }
    return this.calls;
  }

  public ApplicationsService applications() {
    if (null == this.applications) {
      instanceLazyInit();
      this.applications =
          new ApplicationsServiceImpl(
              httpClientSupplier.get(),
              context.getVoiceApplicationManagementServer(),
              clientAuthManagers,
              HttpMapper.getInstance());
    }
    return this.applications;
  }

  public WebHooksService webhooks() {
    if (null == this.webhooks) {
      instanceLazyInit();
      this.webhooks = new WebHooksService(webhooksAuthManagers);
    }
    return this.webhooks;
  }

  private void instanceLazyInit() {
    if (null != this.clientAuthManagers && null != this.webhooksAuthManagers) {
      return;
    }
    synchronized (this) {
      if (null == this.clientAuthManagers || null == this.webhooksAuthManagers) {

        // Currently, we are not supporting unified credentials: ensure application credentials are
        // defined
        Objects.requireNonNull(
            credentials, "Voice service requires application credentials to be defined");
        Objects.requireNonNull(context, "Voice service requires context to be defined");
        StringUtil.requireNonEmpty(
            credentials.getApplicationKey(),
            "Voice service requires 'applicationKey' to be defined");
        StringUtil.requireNonEmpty(
            credentials.getApplicationSecret(),
            "Voice service requires 'applicationSecret' to be defined");
        StringUtil.requireNonEmpty(
            context.getVoiceUrl(), "Voice service requires 'verificationUrl' to be defined");

        LOGGER.fine("Activate voice API with server='" + context.getVoiceServer().getUrl() + "'");
        createAuthManagers(credentials);
      }
    }
  }

  public static final class LocalLazyInit {

    private LocalLazyInit() {

      DestinationMapper.initMapper();
      CallInformationMapper.initMapper();
      CalloutRequestCustomMapper.initMapper();
    }

    public static LocalLazyInit init() {
      return LocalLazyInit.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {

      public static final LocalLazyInit INSTANCE = new LocalLazyInit();
    }
  }
}
