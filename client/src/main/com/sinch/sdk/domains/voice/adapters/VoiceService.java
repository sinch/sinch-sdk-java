package com.sinch.sdk.domains.voice.adapters;

import com.sinch.sdk.auth.adapters.ApplicationAuthManager;
import com.sinch.sdk.auth.adapters.BasicAuthManager;
import com.sinch.sdk.core.exceptions.ApiAuthException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.voice.ApplicationsService;
import com.sinch.sdk.domains.voice.CalloutsService;
import com.sinch.sdk.domains.voice.WebHooksService;
import com.sinch.sdk.models.ApplicationCredentials;
import com.sinch.sdk.models.VoiceContext;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.logging.Logger;

public class VoiceService implements com.sinch.sdk.domains.voice.VoiceService {
  private static final Logger LOGGER = Logger.getLogger(VoiceService.class.getName());

  private static final String SECURITY_SCHEME_KEYWORD = "Signed";

  private static final String BASIC_SECURITY_SCHEME_KEYWORD = "Basic";

  private static final String APPLICATION_SECURITY_SCHEME_KEYWORD = "Application";

  private final VoiceContext context;
  private final HttpClient httpClient;
  private CalloutsService callouts;
  private ConferencesService conferences;
  private CallsService calls;
  private ApplicationsService applications;
  private WebHooksService webhooks;

  private Map<String, AuthManager> clientAuthManagers;
  private Map<String, AuthManager> webhooksAuthManagers;

  private final com.sinch.sdk.domains.voice.api.v1.VoiceService v1;

  public VoiceService(
      ApplicationCredentials credentials, VoiceContext context, HttpClient httpClient) {

    // Currently, we are not supporting unified credentials: ensure application credentials are
    // defined
    Objects.requireNonNull(credentials, "Credentials must be defined");
    Objects.requireNonNull(context, "Context must be defined");
    StringUtil.requireNonEmpty(credentials.getApplicationKey(), "'applicationKey' must be defined");
    StringUtil.requireNonEmpty(
        credentials.getApplicationSecret(), "'applicationSecret' must be defined");

    LOGGER.fine("Activate voice API with server='" + context.getVoiceServer().getUrl() + "'");

    this.context = context;
    this.httpClient = httpClient;
    setApplicationCredentials(credentials);

    this.v1 =
        new com.sinch.sdk.domains.voice.api.v1.adapters.VoiceService(
            credentials, context, httpClient);
  }

  private void setApplicationCredentials(ApplicationCredentials credentials) {

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
      checkCredentials();
      this.callouts = new com.sinch.sdk.domains.voice.adapters.CalloutsService(v1().callouts());
    }
    return this.callouts;
  }

  public ConferencesService conferences() {
    if (null == this.conferences) {
      checkCredentials();
      this.conferences =
          new com.sinch.sdk.domains.voice.adapters.ConferencesService(v1.conferences());
    }
    return this.conferences;
  }

  public CallsService calls() {
    if (null == this.calls) {
      checkCredentials();
      this.calls = new com.sinch.sdk.domains.voice.adapters.CallsService(v1.calls());
    }
    return this.calls;
  }

  public ApplicationsService applications() {
    if (null == this.applications) {
      checkCredentials();
      this.applications =
          new com.sinch.sdk.domains.voice.adapters.ApplicationsService(v1.applications());
    }
    return this.applications;
  }

  public WebHooksService webhooks() {
    checkCredentials();
    if (null == this.webhooks) {
      this.webhooks = new com.sinch.sdk.domains.voice.adapters.WebHooksService(v1.webhooks());
    }
    return this.webhooks;
  }

  public com.sinch.sdk.domains.voice.api.v1.VoiceService v1() {
    return this.v1;
  }

  private void checkCredentials() throws ApiAuthException {
    if (null == clientAuthManagers || clientAuthManagers.isEmpty()) {
      throw new ApiAuthException(
          String.format(
              "Service '%s' cannot be called without defined credentials",
              this.getClass().getSimpleName()));
    }
  }
}
