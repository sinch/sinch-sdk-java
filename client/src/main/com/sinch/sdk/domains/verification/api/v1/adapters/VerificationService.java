package com.sinch.sdk.domains.verification.api.v1.adapters;

import com.sinch.sdk.auth.adapters.ApplicationAuthManager;
import com.sinch.sdk.auth.adapters.BasicAuthManager;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.verification.adapters.IdentityMapper;
import com.sinch.sdk.domains.verification.api.v1.VerificationsReportService;
import com.sinch.sdk.domains.verification.api.v1.VerificationsStartService;
import com.sinch.sdk.domains.verification.api.v1.VerificationsStatusService;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseMapper;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseMapper;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponseMapper;
import com.sinch.sdk.models.ApplicationCredentials;
import com.sinch.sdk.models.VerificationContext;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.Supplier;
import java.util.logging.Logger;

public class VerificationService
    implements com.sinch.sdk.domains.verification.api.v1.VerificationService {

  private static final Logger LOGGER = Logger.getLogger(VerificationService.class.getName());
  // FIXME: Verification OAS file claim it support "Basic" but miss the "Application" definition
  // trick to adapt the mapping of "Basic" keyword to the dedicated "Application" auth manager
  private static final String BASIC_SECURITY_SCHEME_KEYWORD_VERIFICATION = "Basic";

  private static final String APPLICATION_SECURITY_SCHEME_KEYWORD_VERIFICATION = "Application";

  private final ApplicationCredentials credentials;

  private final VerificationContext context;
  private final Supplier<HttpClient> httpClientSupplier;
  private volatile VerificationsStartService startService;
  private volatile VerificationsReportService reportService;
  private volatile VerificationsStatusService statusService;
  private volatile WebhooksService webhooks;

  private volatile Map<String, AuthManager> clientAuthManagers;
  private volatile Map<String, AuthManager> webhooksAuthManagers;

  static {
    LocalLazyInit.init();
  }

  public VerificationService(
      ApplicationCredentials credentials,
      VerificationContext context,
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

  public VerificationsStartService verificationStart() {
    if (null == this.startService) {
      instanceLazyInit();
      this.startService =
          new VerificationsStartServiceImpl(
              httpClientSupplier.get(),
              context.getVerificationServer(),
              clientAuthManagers,
              HttpMapper.getInstance());
    }
    return this.startService;
  }

  public VerificationsReportService verificationReport() {
    if (null == this.reportService) {
      instanceLazyInit();
      this.reportService =
          new VerificationsReportServiceImpl(
              httpClientSupplier.get(),
              context.getVerificationServer(),
              clientAuthManagers,
              HttpMapper.getInstance());
    }
    return this.reportService;
  }

  public VerificationsStatusService verificationStatus() {
    if (null == this.statusService) {
      instanceLazyInit();
      this.statusService =
          new VerificationsStatusServiceImpl(
              httpClientSupplier.get(),
              context.getVerificationServer(),
              clientAuthManagers,
              HttpMapper.getInstance());
    }
    return this.statusService;
  }

  public WebhooksService webhooks() {
    if (null == this.webhooks) {
      instanceLazyInit();
      this.webhooks = new WebhooksService(webhooksAuthManagers);
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
            credentials, "Verification service requires application credentials to be defined");
        Objects.requireNonNull(context, "Verification service requires context to be defined");
        StringUtil.requireNonEmpty(
            credentials.getApplicationKey(),
            "Verification service requires 'applicationKey' to be defined");
        StringUtil.requireNonEmpty(
            credentials.getApplicationSecret(),
            "Verification service requires 'applicationSecret' to be defined");
        StringUtil.requireNonEmpty(
            context.getVerificationUrl(),
            "Verification service requires 'verificationUrl' to be defined");

        LOGGER.fine(
            "Activate verification API with server='"
                + context.getVerificationServer().getUrl()
                + "'");
        createAuthManagers(credentials);
      }
    }
  }

  static final class LocalLazyInit {

    private LocalLazyInit() {
      IdentityMapper.initMapper();
      VerificationStartResponseMapper.initMapper();
      VerificationStatusResponseMapper.initMapper();
      VerificationReportResponseMapper.initMapper();
    }

    public static LocalLazyInit init() {
      return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {

      public static final LocalLazyInit INSTANCE = new LocalLazyInit();
    }
  }
}
