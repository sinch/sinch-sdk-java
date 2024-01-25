package com.sinch.sdk.domains.verification.adapters;

import com.sinch.sdk.auth.adapters.BasicAuthManager;
import com.sinch.sdk.auth.adapters.VerificationApplicationAuthManager;
import com.sinch.sdk.core.exceptions.ApiAuthException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.verification.StatusService;
import com.sinch.sdk.domains.verification.VerificationsService;
import com.sinch.sdk.domains.verification.WebHooksService;
import com.sinch.sdk.models.Configuration;
import java.util.Map;
import java.util.TreeMap;

public class VerificationService implements com.sinch.sdk.domains.verification.VerificationService {

  // FIXME: Verification OAS file claim it support "Basic" but miss the "Application" definition
  // trick to adapt the mapping of "Basic" keyword to the dedicated "Application" auth manager
  private static final String BASIC_SECURITY_SCHEME_KEYWORD_VERIFICATION = "Basic";

  private static final String APPLICATION_SECURITY_SCHEME_KEYWORD_VERIFICATION = "Application";

  private final Configuration configuration;
  private final HttpClient httpClient;
  private VerificationsService verifications;
  private StatusService status;
  private WebHooksService webhooks;
  private Map<String, AuthManager> clientAuthManagers;
  private Map<String, AuthManager> webhooksAuthManagers;

  public VerificationService(Configuration configuration, HttpClient httpClient) {

    // Currently, we are not supporting unified credentials: ensure application credentials are
    // defined
    StringUtil.requireNonEmpty(
        configuration.getApplicationKey(), "'applicationKey' must be defined");
    StringUtil.requireNonEmpty(
        configuration.getApplicationSecret(), "'applicationSecret' must be defined");

    this.configuration = configuration;
    this.httpClient = httpClient;
    setApplicationCredentials(
        configuration.getApplicationKey(), configuration.getApplicationSecret());
  }

  private void setApplicationCredentials(String key, String secret) {

    AuthManager basicAuthManager = new BasicAuthManager(key, secret);
    AuthManager applicationAuthManager = new VerificationApplicationAuthManager(key, secret);

    boolean useApplicationAuth = true;
    // to handle request from client we can only have "Basic" keyword behind the auth managers
    // because of the OAS file only contains it; so we need to trick the application auth manager
    // hidden behind the "Basic" keyword
    // we need both auth manager to handle webhooks because of customer will choose from his
    // dashboard which scheme to be used
    clientAuthManagers = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    clientAuthManagers.put(
        BASIC_SECURITY_SCHEME_KEYWORD_VERIFICATION,
        useApplicationAuth ? applicationAuthManager : basicAuthManager);

    // here we need both auth managers to handle webhooks because we are receiving an Authorization
    // header with "Application" keyword
    webhooksAuthManagers = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    webhooksAuthManagers.put(BASIC_SECURITY_SCHEME_KEYWORD_VERIFICATION, basicAuthManager);
    webhooksAuthManagers.put(
        APPLICATION_SECURITY_SCHEME_KEYWORD_VERIFICATION, applicationAuthManager);
  }

  public VerificationsService verifications() {
    if (null == this.verifications) {
      checkCredentials();
      this.verifications =
          new com.sinch.sdk.domains.verification.adapters.VerificationsService(
              configuration, httpClient, clientAuthManagers);
    }
    return this.verifications;
  }

  public StatusService status() {
    if (null == this.status) {
      checkCredentials();
      this.status =
          new com.sinch.sdk.domains.verification.adapters.StatusService(
              configuration, httpClient, clientAuthManagers);
    }
    return this.status;
  }

  public WebHooksService webhooks() {
    checkCredentials();
    if (null == this.webhooks) {
      this.webhooks =
          new com.sinch.sdk.domains.verification.adapters.WebHooksService(webhooksAuthManagers);
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
