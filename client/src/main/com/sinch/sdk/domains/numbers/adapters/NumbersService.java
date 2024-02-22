package com.sinch.sdk.domains.numbers.adapters;

import com.sinch.sdk.auth.adapters.BasicAuthManager;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.NumbersContext;
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.AbstractMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumbersService implements com.sinch.sdk.domains.numbers.NumbersService {
  private static final Logger LOGGER = Logger.getLogger(NumbersService.class.getName());
  private static final String SECURITY_SCHEME_KEYWORD_NUMBERS = "BasicAuth";

  private final UnifiedCredentials credentials;
  private final NumbersContext context;
  private final HttpClient httpClient;
  private AvailableNumberService available;
  private ActiveNumberService active;
  private AvailableRegionService regions;
  private CallbackConfigurationService callback;
  private WebHooksService webhooks;

  private final Map<String, AuthManager> authManagers;

  public NumbersService(Configuration configuration, HttpClient httpClient) {

    credentials =
        configuration
            .getUnifiedCredentials()
            .orElseThrow(() -> new IllegalArgumentException("Unified credentials must be defined"));
    context =
        configuration
            .getNumbersContext()
            .orElseThrow(() -> new IllegalArgumentException("Numbers context must be defined"));
    StringUtil.requireNonEmpty(credentials.getKeyId(), "'keyId' must be defined");
    StringUtil.requireNonEmpty(credentials.getKeySecret(), "'keySecret' must be defined");
    StringUtil.requireNonEmpty(credentials.getProjectId(), "'projectId' must be defined");
    StringUtil.requireNonEmpty(context.getNumbersUrl(), "'numbersUrl' must be defined");

    this.httpClient = httpClient;
    AuthManager basicAuthManager = new BasicAuthManager(configuration);

    authManagers =
        Stream.of(new AbstractMap.SimpleEntry<>(SECURITY_SCHEME_KEYWORD_NUMBERS, basicAuthManager))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    LOGGER.fine("Activate numbers API with server='" + context.getNumbersServer().getUrl() + "'");
  }

  public AvailableNumberService available() {
    if (null == this.available) {
      this.available = new AvailableNumberService(credentials, context, httpClient, authManagers);
    }
    return this.available;
  }

  public AvailableRegionService regions() {
    if (null == this.regions) {
      this.regions = new AvailableRegionService(credentials, context, httpClient, authManagers);
    }
    return this.regions;
  }

  public ActiveNumberService active() {
    if (null == this.active) {
      this.active = new ActiveNumberService(credentials, context, httpClient, authManagers);
    }
    return this.active;
  }

  public CallbackConfigurationService callback() {
    if (null == this.callback) {
      this.callback =
          new CallbackConfigurationService(credentials, context, httpClient, authManagers);
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
