package com.sinch.sdk.domains.verification.adapters;

import com.sinch.sdk.auth.adapters.ApplicationAuthManager;
import com.sinch.sdk.auth.adapters.BasicAuthManager;
import com.sinch.sdk.core.exceptions.ApiAuthException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.verification.VerificationStatusService;
import com.sinch.sdk.domains.verification.VerificationsService;
import com.sinch.sdk.domains.verification.WebHooksService;
import com.sinch.sdk.models.ApplicationCredentials;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.VerificationContext;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

public class VerificationService implements com.sinch.sdk.domains.verification.VerificationService {

  private static final Logger LOGGER = Logger.getLogger(VerificationService.class.getName());
  // FIXME: Verification OAS file claim it support "Basic" but miss the "Application" definition
  // trick to adapt the mapping of "Basic" keyword to the dedicated "Application" auth manager
  private static final String BASIC_SECURITY_SCHEME_KEYWORD_VERIFICATION = "Basic";

  private static final String APPLICATION_SECURITY_SCHEME_KEYWORD_VERIFICATION = "Application";

  private final VerificationContext context;
  private final HttpClient httpClient;
  private VerificationsService verifications;
  private VerificationStatusService verificationStatus;
  private WebHooksService webhooks;
  private Map<String, AuthManager> clientAuthManagers;
  private Map<String, AuthManager> webhooksAuthManagers;

  public VerificationService(Configuration configuration, HttpClient httpClient) {

    // Currently, we are not supporting unified credentials: ensure application credentials are
    // defined
    ApplicationCredentials credentials =
        configuration
            .getApplicationCredentials()
            .orElseThrow(
                () -> new IllegalArgumentException("Application credentials must be defined"));
    context =
        configuration
            .getVerificationContext()
            .orElseThrow(
                () -> new IllegalArgumentException("Verification context must be defined"));
    StringUtil.requireNonEmpty(credentials.getApplicationKey(), "'applicationKey' must be defined");
    StringUtil.requireNonEmpty(
        credentials.getApplicationSecret(), "'applicationSecret' must be defined");
    StringUtil.requireNonEmpty(context.getVerificationUrl(), "'verificationUrl' must be defined");

    this.httpClient = httpClient;
    setApplicationCredentials(credentials);
    LOGGER.fine(
        "Activate verification API with server='" + context.getVerificationServer().getUrl() + "'");
  }

  private void setApplicationCredentials(ApplicationCredentials credentials) {

    AuthManager basicAuthManager =
        new BasicAuthManager(credentials.getApplicationKey(), credentials.getApplicationSecret());
    AuthManager applicationAuthManager =
        new ApplicationAuthManager(
            credentials.getApplicationKey(), credentials.getApplicationSecret());

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
              context, httpClient, clientAuthManagers);
    }
    return this.verifications;
  }

  public VerificationStatusService verificationStatus() {
    if (null == this.verificationStatus) {
      checkCredentials();
      this.verificationStatus =
          new com.sinch.sdk.domains.verification.adapters.VerificationStatusService(
              context, httpClient, clientAuthManagers);
    }
    return this.verificationStatus;
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
