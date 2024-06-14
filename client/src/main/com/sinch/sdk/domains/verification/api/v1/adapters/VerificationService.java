package com.sinch.sdk.domains.verification.api.v1.adapters;

import com.sinch.sdk.auth.adapters.ApplicationAuthManager;
import com.sinch.sdk.auth.adapters.BasicAuthManager;
import com.sinch.sdk.core.exceptions.ApiAuthException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.verification.adapters.IdentityMapper;
import com.sinch.sdk.models.ApplicationCredentials;
import com.sinch.sdk.models.VerificationContext;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.logging.Logger;

public class VerificationService
    implements com.sinch.sdk.domains.verification.api.v1.VerificationService {

  private static final Logger LOGGER = Logger.getLogger(VerificationService.class.getName());
  // FIXME: Verification OAS file claim it support "Basic" but miss the "Application" definition
  // trick to adapt the mapping of "Basic" keyword to the dedicated "Application" auth manager
  private static final String BASIC_SECURITY_SCHEME_KEYWORD_VERIFICATION = "Basic";

  private static final String APPLICATION_SECURITY_SCHEME_KEYWORD_VERIFICATION = "Application";

  private final VerificationContext context;
  private final HttpClient httpClient;
  private VerificationStartService startService;
  private VerificationReportService reportService;
  private VerificationStatusService statusService;
  private WebHooksService webhooks;

  private Map<String, AuthManager> clientAuthManagers;
  private Map<String, AuthManager> webhooksAuthManagers;

  static {
    LocalLazyInit.init();
  }

  public VerificationService(
      ApplicationCredentials credentials, VerificationContext context, HttpClient httpClient) {

    // Currently, we are not supporting unified credentials: ensure application credentials are
    // defined
    Objects.requireNonNull(
        credentials, "Verification service require application credentials to be defined");
    Objects.requireNonNull(context, "Verification service require context to be defined");
    StringUtil.requireNonEmpty(
        credentials.getApplicationKey(),
        "Verification service require 'applicationKey' to be defined");
    StringUtil.requireNonEmpty(
        credentials.getApplicationSecret(),
        "Verification service require 'applicationSecret' to be defined");
    StringUtil.requireNonEmpty(
        context.getVerificationUrl(),
        "Verification service require 'verificationUrl' to be defined");

    LOGGER.fine(
        "Activate verification API with server='" + context.getVerificationServer().getUrl() + "'");

    this.context = context;
    this.httpClient = httpClient;
    setApplicationCredentials(credentials);
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

  public VerificationStartService verificationStart() {
    if (null == this.startService) {
      checkCredentials();
      this.startService = new VerificationStartService(context, httpClient, clientAuthManagers);
    }
    return this.startService;
  }

  public VerificationReportService verificationReport() {
    if (null == this.reportService) {
      checkCredentials();
      this.reportService = new VerificationReportService(context, httpClient, clientAuthManagers);
    }
    return this.reportService;
  }

  public VerificationStatusService verificationStatus() {
    if (null == this.statusService) {
      checkCredentials();
      this.statusService = new VerificationStatusService(context, httpClient, clientAuthManagers);
    }
    return this.statusService;
  }

  public WebHooksService webhooks() {
    checkCredentials();
    if (null == this.webhooks) {
      this.webhooks = new WebHooksService(webhooksAuthManagers);
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

  static final class LocalLazyInit {

    private LocalLazyInit() {
      IdentityMapper.initMapper();
    }

    public static LocalLazyInit init() {
      return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {

      public static final LocalLazyInit INSTANCE = new LocalLazyInit();
    }
  }
}
