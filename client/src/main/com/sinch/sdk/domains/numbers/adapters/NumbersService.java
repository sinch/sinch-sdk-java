package com.sinch.sdk.domains.numbers.adapters;

import com.sinch.sdk.auth.adapters.BasicAuthManager;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.models.Configuration;
import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumbersService implements com.sinch.sdk.domains.numbers.NumbersService {
  private static final String SECURITY_SCHEME_KEYWORD_NUMBERS = "BasicAuth";

  private final Configuration configuration;
  private final HttpClient httpClient;
  private AvailableNumberService available;
  private ActiveNumberService active;
  private AvailableRegionService regions;
  private CallbackConfigurationService callback;
  private WebHooksService webhooks;

  private final Map<String, AuthManager> authManagers;

  public NumbersService(Configuration configuration, HttpClient httpClient) {

    StringUtil.requireNonEmpty(configuration.getKeyId(), "'keyId' must be defined");
    StringUtil.requireNonEmpty(configuration.getKeySecret(), "'keySecret' must be defined");
    StringUtil.requireNonEmpty(configuration.getProjectId(), "'projectId' must be defined");

    this.configuration = configuration;
    this.httpClient = httpClient;
    AuthManager basicAuthManager = new BasicAuthManager(configuration);

    authManagers =
        Stream.of(new AbstractMap.SimpleEntry<>(SECURITY_SCHEME_KEYWORD_NUMBERS, basicAuthManager))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  public AvailableNumberService available() {
    if (null == this.available) {
      this.available = new AvailableNumberService(configuration, httpClient, authManagers);
    }
    return this.available;
  }

  public AvailableRegionService regions() {
    if (null == this.regions) {
      this.regions = new AvailableRegionService(configuration, httpClient, authManagers);
    }
    return this.regions;
  }

  public ActiveNumberService active() {
    if (null == this.active) {
      this.active = new ActiveNumberService(configuration, httpClient, authManagers);
    }
    return this.active;
  }

  public CallbackConfigurationService callback() {
    if (null == this.callback) {
      this.callback = new CallbackConfigurationService(configuration, httpClient, authManagers);
    }
    return this.callback;
  }

  public WebHooksService webhooks() {

    if (null == this.webhooks) {
      this.webhooks = new WebHooksService();
    }
    return this.webhooks;
  }
}
