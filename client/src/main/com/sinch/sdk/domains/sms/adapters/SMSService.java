package com.sinch.sdk.domains.sms.adapters;

import com.sinch.sdk.auth.adapters.BearerAuthManager;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.sms.BatchesService;
import com.sinch.sdk.domains.sms.DeliveryReportsService;
import com.sinch.sdk.domains.sms.InboundsService;
import com.sinch.sdk.domains.sms.WebHooksService;
import com.sinch.sdk.models.SmsContext;
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SMSService implements com.sinch.sdk.domains.sms.SMSService {

  private static final Logger LOGGER = Logger.getLogger(SMSService.class.getName());

  private static final String SECURITY_SCHEME_KEYWORD_SMS = "BearerAuth";
  private final UnifiedCredentials credentials;
  private final SmsContext context;
  private final HttpClient httpClient;
  private BatchesService batches;
  private WebHooksService webHooks;
  private DeliveryReportsService deliveryReports;
  private InboundsService inbounds;
  private GroupsService groups;
  private final Map<String, AuthManager> authManagers;

  public SMSService(
      UnifiedCredentials credentials,
      SmsContext context,
      ServerConfiguration oAuthServer,
      HttpClient httpClient) {

    // Currently, we are only supporting  unified credentials: ensure credentials are
    // defined
    Objects.requireNonNull(credentials, "Credentials must be defined");
    Objects.requireNonNull(context, "Context must be defined");
    StringUtil.requireNonEmpty(credentials.getKeyId(), "'keyId' must be defined");
    StringUtil.requireNonEmpty(credentials.getKeySecret(), "'keySecret' must be defined");
    StringUtil.requireNonEmpty(credentials.getProjectId(), "'projectId' must be defined");
    StringUtil.requireNonEmpty(context.getSmsUrl(), "'smsUrl' must be defined");

    LOGGER.fine("Activate SMS API with server='" + context.getSmsServer().getUrl() + "'");

    this.credentials = credentials;
    this.context = context;
    this.httpClient = httpClient;

    BearerAuthManager bearerAuthManager =
        new BearerAuthManager(credentials, oAuthServer, new HttpMapper(), httpClient);

    authManagers =
        Stream.of(new AbstractMap.SimpleEntry<>(SECURITY_SCHEME_KEYWORD_SMS, bearerAuthManager))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  @Override
  public BatchesService batches() {
    if (null == this.batches) {
      this.batches =
          new com.sinch.sdk.domains.sms.adapters.BatchesService(
              credentials, context, httpClient, authManagers);
    }
    return this.batches;
  }

  @Override
  public WebHooksService webHooks() {
    if (null == this.webHooks) {
      this.webHooks = new com.sinch.sdk.domains.sms.adapters.WebHooksService();
    }
    return this.webHooks;
  }

  @Override
  public DeliveryReportsService deliveryReports() {
    if (null == this.deliveryReports) {
      this.deliveryReports =
          new com.sinch.sdk.domains.sms.adapters.DeliveryReportsService(
              credentials, context, httpClient, authManagers);
    }
    return this.deliveryReports;
  }

  @Override
  public InboundsService inbounds() {
    if (null == this.inbounds) {
      this.inbounds =
          new com.sinch.sdk.domains.sms.adapters.InboundsService(
              credentials, context, httpClient, authManagers);
    }
    return this.inbounds;
  }

  @Override
  public GroupsService groups() {
    if (null == this.groups) {
      this.groups =
          new com.sinch.sdk.domains.sms.adapters.GroupsService(
              credentials, context, httpClient, authManagers);
    }
    return this.groups;
  }
}
