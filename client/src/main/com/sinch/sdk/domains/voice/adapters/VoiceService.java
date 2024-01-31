package com.sinch.sdk.domains.voice.adapters;

import com.sinch.sdk.auth.adapters.ApplicationAuthManager;
import com.sinch.sdk.auth.adapters.BasicAuthManager;
import com.sinch.sdk.core.exceptions.ApiAuthException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.voice.ApplicationsService;
import com.sinch.sdk.domains.voice.CalloutsService;
import com.sinch.sdk.domains.voice.WebHooksService;
import com.sinch.sdk.models.Configuration;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class VoiceService implements com.sinch.sdk.domains.voice.VoiceService {

  private static final String SECURITY_SCHEME_KEYWORD = "Signed";

  private static final String BASIC_SECURITY_SCHEME_KEYWORD = "Basic";

  private static final String APPLICATION_SECURITY_SCHEME_KEYWORD = "Application";

  private final Configuration configuration;
  private final HttpClient httpClient;
  private CalloutsService callouts;
  private ConferencesService conferences;
  private CallsService calls;
  private ApplicationsService applications;
  private WebHooksService webhooks;

  private Map<String, AuthManager> clientAuthManagers;
  private Map<String, AuthManager> webhooksAuthManagers;

  public VoiceService(Configuration configuration, HttpClient httpClient) {

    // Currently, we are not supporting unified credentials: ensure application credentials are
    // defined
    Objects.requireNonNull(configuration.getApplicationKey(), "'applicationKey' cannot be null");
    Objects.requireNonNull(
        configuration.getApplicationSecret(), "'applicationSecret' cannot be null");

    this.configuration = configuration;
    this.httpClient = httpClient;
    setApplicationCredentials(
        configuration.getApplicationKey(), configuration.getApplicationSecret());
  }

  private void setApplicationCredentials(String key, String secret) {

    AuthManager basicAuthManager = new BasicAuthManager(key, secret);
    AuthManager applicationAuthManager = new ApplicationAuthManager(key, secret);

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
      this.callouts =
          new com.sinch.sdk.domains.voice.adapters.CalloutsService(
              configuration, httpClient, clientAuthManagers);
    }
    return this.callouts;
  }

  public ConferencesService conferences() {
    if (null == this.conferences) {
      checkCredentials();
      this.conferences =
          new com.sinch.sdk.domains.voice.adapters.ConferencesService(
              configuration, httpClient, clientAuthManagers);
    }
    return this.conferences;
  }

  public CallsService calls() {
    if (null == this.calls) {
      checkCredentials();
      this.calls =
          new com.sinch.sdk.domains.voice.adapters.CallsService(
              configuration, httpClient, clientAuthManagers);
    }
    return this.calls;
  }

  public ApplicationsService applications() {
    if (null == this.applications) {
      checkCredentials();
      this.applications =
          new com.sinch.sdk.domains.voice.adapters.ApplicationsService(
              configuration, httpClient, clientAuthManagers);
    }
    return this.applications;
  }

  public WebHooksService webhooks() {
    checkCredentials();
    if (null == this.webhooks) {
      this.webhooks =
          new com.sinch.sdk.domains.voice.adapters.WebHooksService(webhooksAuthManagers);
    }
    return this.webhooks;
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
