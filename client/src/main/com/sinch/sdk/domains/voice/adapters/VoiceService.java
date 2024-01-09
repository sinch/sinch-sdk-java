package com.sinch.sdk.domains.voice.adapters;

import com.sinch.sdk.auth.adapters.ApplicationAuthManager;
import com.sinch.sdk.core.exceptions.ApiAuthException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.voice.CalloutsService;
import com.sinch.sdk.models.Configuration;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class VoiceService implements com.sinch.sdk.domains.voice.VoiceService {

  private static final String SECURITY_SCHEME_KEYWORD = "Signed";

  private final Configuration configuration;
  private final HttpClient httpClient;
  private CalloutsService callouts;
  private ConferencesService conferences;
  private CallsService calls;

  private Map<String, AuthManager> clientAuthManagers;

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

    AuthManager applicationAuthManager = new ApplicationAuthManager(key, secret);

    clientAuthManagers = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    clientAuthManagers.put(SECURITY_SCHEME_KEYWORD, applicationAuthManager);
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

  private void checkCredentials() throws ApiAuthException {
    if (null == clientAuthManagers || clientAuthManagers.isEmpty()) {
      throw new ApiAuthException(
          String.format(
              "Service '%s' cannot be called without defined credentials",
              this.getClass().getSimpleName()));
    }
  }
}
