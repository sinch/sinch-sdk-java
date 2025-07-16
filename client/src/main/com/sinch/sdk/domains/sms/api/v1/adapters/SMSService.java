package com.sinch.sdk.domains.sms.api.v1.adapters;

import com.sinch.sdk.auth.HmacAuthenticationValidation;
import com.sinch.sdk.auth.adapters.BearerAuthManager;
import com.sinch.sdk.auth.adapters.OAuthManager;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.sms.api.v1.BatchesService;
import com.sinch.sdk.domains.sms.api.v1.DeliveryReportsService;
import com.sinch.sdk.domains.sms.api.v1.GroupsService;
import com.sinch.sdk.domains.sms.api.v1.InboundsService;
import com.sinch.sdk.models.Credentials;
import com.sinch.sdk.models.SmsContext;
import com.sinch.sdk.models.SmsServicePlanCredentials;
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SMSService implements com.sinch.sdk.domains.sms.api.v1.SMSService {

  private static final Logger LOGGER = Logger.getLogger(SMSService.class.getName());

  private static final String SECURITY_SCHEME_KEYWORD_SMS = "BearerAuth";
  private final Credentials credentials;
  private final SmsContext context;
  private final ServerConfiguration oAuthServer;
  private final Supplier<HttpClient> httpClientSupplier;
  private volatile String uriUUID;
  private volatile Map<String, AuthManager> authManagers;

  private volatile BatchesService batches;
  private volatile InboundsService inbounds;
  private volatile DeliveryReportsService deliveryReports;
  private volatile GroupsService groups;
  private volatile WebHooksService webhooks;

  public SMSService(
      UnifiedCredentials credentials,
      SmsContext context,
      ServerConfiguration oAuthServer,
      Supplier<HttpClient> httpClientSupplier) {
    this.credentials = credentials;
    this.oAuthServer = oAuthServer;
    this.context = context;
    this.httpClientSupplier = httpClientSupplier;
  }

  public SMSService(
      SmsServicePlanCredentials credentials,
      SmsContext context,
      Supplier<HttpClient> httpClientSupplier) {
    this.credentials = credentials;
    this.context = context;
    this.httpClientSupplier = httpClientSupplier;
    this.oAuthServer = null;
  }

  @Override
  public BatchesService batches() {
    if (null == this.batches) {
      instanceLazyInit();
      this.batches =
          new BatchesServiceImpl(
              httpClientSupplier.get(),
              context.getSmsServer(),
              authManagers,
              HttpMapper.getInstance(),
              uriUUID);
    }
    return this.batches;
  }

  @Override
  public InboundsService inbounds() {
    if (null == this.inbounds) {
      instanceLazyInit();
      this.inbounds =
          new InboundsServiceImpl(
              httpClientSupplier.get(),
              context.getSmsServer(),
              authManagers,
              HttpMapper.getInstance(),
              uriUUID);
    }
    return this.inbounds;
  }

  @Override
  public DeliveryReportsService deliveryReports() {
    if (null == this.deliveryReports) {
      instanceLazyInit();
      this.deliveryReports =
          new DeliveryReportsServiceImpl(
              httpClientSupplier.get(),
              context.getSmsServer(),
              authManagers,
              HttpMapper.getInstance(),
              uriUUID);
    }
    return this.deliveryReports;
  }

  @Override
  public GroupsService groups() {
    if (null == this.groups) {
      instanceLazyInit();
      this.groups =
          new GroupsServiceImpl(
              httpClientSupplier.get(),
              context.getSmsServer(),
              authManagers,
              HttpMapper.getInstance(),
              uriUUID);
    }
    return this.groups;
  }

  @Override
  public WebHooksService webhooks() {
    if (null == this.webhooks) {
      this.webhooks = new WebHooksService(new HmacAuthenticationValidation());
    }
    return this.webhooks;
  }

  private void instanceLazyInit() {
    if (null != this.authManagers) {
      return;
    }
    synchronized (this) {
      if (null == this.authManagers) {
        AuthManager oAuthManager = null;
        Objects.requireNonNull(credentials, "Credentials must be defined");
        Objects.requireNonNull(context, "Context must be defined");
        StringUtil.requireNonEmpty(context.getSmsUrl(), "'smsUrl' must be defined");

        // To be deprecated with 2.0: no more defaulting to US region
        if (Boolean.TRUE == context.regionAsDefault()) {
          LOGGER.warning(
              String.format(
                  "Using default region for SMS '%s'. This default fallback will be removed in next"
                      + " major release and will cause a runtime error. Please configure the region"
                      + " you want to be used (see"
                      + " https://www.javadoc.io/static/com.sinch.sdk/sinch-sdk-java/1.6.0/com/sinch/sdk/models/Configuration.Builder.html#setSmsRegion(com.sinch.sdk.models.SMSRegion))",
                  context.getSmsRegion()));
        }

        if (credentials instanceof UnifiedCredentials) {
          UnifiedCredentials unifiedCredentials = (UnifiedCredentials) credentials;
          StringUtil.requireNonEmpty(unifiedCredentials.getKeyId(), "'keyId' must be defined");
          StringUtil.requireNonEmpty(
              unifiedCredentials.getKeySecret(), "'keySecret' must be defined");
          StringUtil.requireNonEmpty(
              unifiedCredentials.getProjectId(), "'projectId' must be defined");
          LOGGER.fine("Activate SMS API with server='" + context.getSmsServer().getUrl() + "'");

          uriUUID = unifiedCredentials.getProjectId();
          oAuthManager =
              new OAuthManager(
                  unifiedCredentials, oAuthServer, HttpMapper.getInstance(), httpClientSupplier);

        } else if (credentials instanceof SmsServicePlanCredentials) {
          SmsServicePlanCredentials servicePlanCredentials =
              (SmsServicePlanCredentials) credentials;
          StringUtil.requireNonEmpty(
              servicePlanCredentials.getServicePlanId(), "'servicePlanId' must be defined");
          StringUtil.requireNonEmpty(
              servicePlanCredentials.getApiToken(), "'apiToken' must be defined");
          LOGGER.fine(
              "Activate SMS API with service plan ID support and server='"
                  + context.getSmsServer().getUrl()
                  + "'");
          uriUUID = servicePlanCredentials.getServicePlanId();
          oAuthManager = new BearerAuthManager(servicePlanCredentials.getApiToken());
        }

        this.authManagers =
            Stream.of(new AbstractMap.SimpleEntry<>(SECURITY_SCHEME_KEYWORD_SMS, oAuthManager))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
      }
    }
  }
}
