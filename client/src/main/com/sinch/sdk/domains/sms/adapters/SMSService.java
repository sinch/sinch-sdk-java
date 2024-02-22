package com.sinch.sdk.domains.sms.adapters;

import com.sinch.sdk.auth.adapters.BearerAuthManager;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.sms.BatchesService;
import com.sinch.sdk.domains.sms.DeliveryReportsService;
import com.sinch.sdk.domains.sms.InboundsService;
import com.sinch.sdk.domains.sms.WebHooksService;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SMSService implements com.sinch.sdk.domains.sms.SMSService {
  private static final String SECURITY_SCHEME_KEYWORD_SMS = "BearerAuth";

  private final Configuration configuration;
  private final HttpClient httpClient;
  private BatchesService batches;
  private WebHooksService webHooks;
  private DeliveryReportsService deliveryReports;
  private InboundsService inbounds;
  private GroupsService groups;
  private final Map<String, AuthManager> authManagers;

  public SMSService(Configuration configuration, HttpClient httpClient) {

    // Currently, we are only supporting  unified credentials: ensure credentials are
    // defined
    UnifiedCredentials credentials =
        configuration
            .getUnifiedCredentials()
            .orElseThrow(() -> new IllegalArgumentException("Unified credentials must be defined"));
    StringUtil.requireNonEmpty(credentials.getKeyId(), "'keyId' must be defined");
    StringUtil.requireNonEmpty(credentials.getKeySecret(), "'keySecret' must be defined");
    StringUtil.requireNonEmpty(credentials.getProjectId(), "'projectId' must be defined");

    this.configuration = configuration;
    this.httpClient = httpClient;

    BearerAuthManager bearerAuthManager =
        new BearerAuthManager(configuration, new HttpMapper(), httpClient);

    authManagers =
        Stream.of(new AbstractMap.SimpleEntry<>(SECURITY_SCHEME_KEYWORD_SMS, bearerAuthManager))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  @Override
  public BatchesService batches() {
    if (null == this.batches) {
      this.batches =
          new com.sinch.sdk.domains.sms.adapters.BatchesService(
              configuration, httpClient, authManagers);
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
              configuration, httpClient, authManagers);
    }
    return this.deliveryReports;
  }

  @Override
  public InboundsService inbounds() {
    if (null == this.inbounds) {
      this.inbounds =
          new com.sinch.sdk.domains.sms.adapters.InboundsService(
              configuration, httpClient, authManagers);
    }
    return this.inbounds;
  }

  @Override
  public GroupsService groups() {
    if (null == this.groups) {
      this.groups =
          new com.sinch.sdk.domains.sms.adapters.GroupsService(
              configuration, httpClient, authManagers);
    }
    return this.groups;
  }
}
