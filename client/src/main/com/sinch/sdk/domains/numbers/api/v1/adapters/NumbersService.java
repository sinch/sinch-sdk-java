package com.sinch.sdk.domains.numbers.api.v1.adapters;

import com.sinch.sdk.auth.adapters.BasicAuthManager;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.models.NumbersContext;
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumbersService implements com.sinch.sdk.domains.numbers.api.v1.NumbersService {

  private static final Logger LOGGER = Logger.getLogger(NumbersService.class.getName());
  private static final String SECURITY_SCHEME_KEYWORD_NUMBERS = "BasicAuth";

  private final String uriUUID;
  private final NumbersContext context;
  private final HttpClient httpClient;
  private AvailableNumberService available;
  private ActiveNumberService active;
  private AvailableRegionService regions;
  private CallbackConfigurationService callback;
  private WebHooksService webhooks;

  private final Map<String, AuthManager> authManagers;

  static {
    LocalLazyInit.init();
  }

  public NumbersService(
      UnifiedCredentials credentials, NumbersContext context, HttpClient httpClient) {

    Objects.requireNonNull(
        credentials, "Numbers service require unified credentials to be defined");
    Objects.requireNonNull(context, "Numbers service require context must be defined");
    StringUtil.requireNonEmpty(
        credentials.getKeyId(), "Numbers service require  'keyId' must be defined");
    StringUtil.requireNonEmpty(
        credentials.getKeySecret(), "Numbers service require  'keySecret' must be defined");
    StringUtil.requireNonEmpty(
        credentials.getProjectId(), "Numbers service require  'projectId' must be defined");
    StringUtil.requireNonEmpty(
        context.getNumbersUrl(), "'Numbers service require  numbersUrl' must be defined");

    LOGGER.fine("Activate numbers API with server='" + context.getNumbersServer().getUrl() + "'");

    this.uriUUID = credentials.getProjectId();
    this.context = context;
    this.httpClient = httpClient;

    AuthManager basicAuthManager =
        new BasicAuthManager(credentials.getKeyId(), credentials.getKeySecret());

    authManagers =
        Stream.of(new AbstractMap.SimpleEntry<>(SECURITY_SCHEME_KEYWORD_NUMBERS, basicAuthManager))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  public AvailableNumberService available() {
    if (null == this.available) {
      this.available = new AvailableNumberService(uriUUID, context, httpClient, authManagers);
    }
    return this.available;
  }

  public AvailableRegionService regions() {
    if (null == this.regions) {
      this.regions = new AvailableRegionService(uriUUID, context, httpClient, authManagers);
    }
    return this.regions;
  }

  public com.sinch.sdk.domains.numbers.api.v1.ActiveNumberService active() {
    if (null == this.active) {
      this.active = new ActiveNumberService(uriUUID, context, httpClient, authManagers);
    }
    return this.active;
  }

  public CallbackConfigurationService callback() {
    if (null == this.callback) {
      this.callback = new CallbackConfigurationService(uriUUID, context, httpClient, authManagers);
    }
    return this.callback;
  }

  public WebHooksService webhooks() {

    if (null == this.webhooks) {
      this.webhooks = new WebHooksService();
    }
    return this.webhooks;
  }

  static final class LocalLazyInit {

    private LocalLazyInit() {
      MoneyMapper.initMapper();
    }

    public static LocalLazyInit init() {
      return LocalLazyInit.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {

      public static final LocalLazyInit INSTANCE = new LocalLazyInit();
    }
  }
}
