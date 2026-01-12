package com.sinch.sdk.domains.numbers.api.v1.adapters;

import com.sinch.sdk.auth.adapters.OAuthManager;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.numbers.api.v1.AvailableRegionsService;
import com.sinch.sdk.domains.numbers.api.v1.CallbackConfigurationService;
import com.sinch.sdk.domains.numbers.api.v1.NumberOrderService;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.v1.EmergencyAddress;
import com.sinch.sdk.domains.numbers.models.v1.request.ActiveNumberUpdateRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.ActiveNumbersListQueryParameters;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberRentAnyRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberRentRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumbersListQueryParameters;
import com.sinch.sdk.domains.numbers.models.v1.request.EmergencyAddressRequest;
import com.sinch.sdk.domains.numbers.models.v1.response.ActiveNumbersListResponse;
import com.sinch.sdk.domains.numbers.models.v1.response.AvailableNumber;
import com.sinch.sdk.domains.numbers.models.v1.response.AvailableNumbersListResponse;
import com.sinch.sdk.domains.numbers.models.v1.response.ValidateAddressResponse;
import com.sinch.sdk.models.NumbersContext;
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumbersService implements com.sinch.sdk.domains.numbers.api.v1.NumbersService {

  private static final Logger LOGGER = Logger.getLogger(NumbersService.class.getName());
  private static final String SECURITY_SCHEME_KEYWORD_NUMBERS = "OAuth2.0";

  private final UnifiedCredentials credentials;
  private final NumbersContext context;
  private final ServerConfiguration oAuthServer;
  private final Supplier<HttpClient> httpClientSupplier;

  private volatile String uriUUID;
  private volatile Map<String, AuthManager> authManagers;
  private volatile AvailableNumberServiceFacade available;
  private volatile ActiveNumberServiceFacade active;
  private volatile AvailableRegionsService regions;
  private volatile CallbackConfigurationService callbackConfiguration;
  private volatile WebHooksService webhooks;
  private volatile NumberOrderService orders;

  static {
    LocalLazyInit.init();
  }

  public NumbersService(
      UnifiedCredentials credentials,
      NumbersContext context,
      ServerConfiguration oAuthServer,
      Supplier<HttpClient> httpClientSupplier) {
    this.credentials = credentials;
    this.context = context;
    this.oAuthServer = oAuthServer;
    this.httpClientSupplier = httpClientSupplier;
  }

  AvailableNumberServiceFacade available() {
    if (null == this.available) {
      instanceLazyInit();
      this.available =
          new AvailableNumberServiceFacade(uriUUID, context, httpClientSupplier, authManagers);
    }
    return this.available;
  }

  public AvailableRegionsService regions() {
    if (null == this.regions) {
      instanceLazyInit();
      this.regions =
          new AvailableRegionsServiceImpl(
              httpClientSupplier.get(),
              context.getNumbersServer(),
              authManagers,
              HttpMapper.getInstance(),
              uriUUID);
    }
    return this.regions;
  }

  ActiveNumberServiceFacade active() {
    if (null == this.active) {
      instanceLazyInit();
      this.active =
          new ActiveNumberServiceFacade(uriUUID, this, context, httpClientSupplier, authManagers);
    }
    return this.active;
  }

  public CallbackConfigurationService callbackConfiguration() {
    if (null == this.callbackConfiguration) {
      instanceLazyInit();
      this.callbackConfiguration =
          new CallbackConfigurationServiceImpl(
              httpClientSupplier.get(),
              context.getNumbersServer(),
              authManagers,
              HttpMapper.getInstance(),
              uriUUID);
    }
    return this.callbackConfiguration;
  }

  public WebHooksService webhooks() {

    if (null == this.webhooks) {
      this.webhooks = new WebHooksService(new NumbersWebhooksAuthenticationValidation());
    }
    return this.webhooks;
  }

  public NumberOrderService orders() {

    if (null == this.orders) {
      instanceLazyInit();
      this.orders =
          new NumberOrderServiceImpl(
              httpClientSupplier.get(),
              context.getNumbersServer(),
              authManagers,
              HttpMapper.getInstance(),
              uriUUID);
    }
    return this.orders;
  }

  @Override
  public AvailableNumbersListResponse searchForAvailableNumbers(
      AvailableNumbersListQueryParameters parameters) throws ApiException {
    return available().searchForAvailableNumbers(parameters);
  }

  @Override
  public AvailableNumber checkAvailability(String phoneNumber) throws ApiException {
    return available().checkAvailability(phoneNumber);
  }

  @Override
  public ActiveNumber rent(String phoneNumber) throws ApiException {
    return available().rent(phoneNumber);
  }

  @Override
  public ActiveNumber rent(String phoneNumber, AvailableNumberRentRequest parameters)
      throws ApiException {
    return available().rent(phoneNumber, parameters);
  }

  @Override
  public ActiveNumber rentAny(AvailableNumberRentAnyRequest parameters) throws ApiException {
    return available().rentAny(parameters);
  }

  @Override
  public ActiveNumbersListResponse list(ActiveNumbersListQueryParameters queryParameter)
      throws ApiException {
    return active().list(queryParameter);
  }

  @Override
  public ActiveNumber get(String phoneNumber) throws ApiException {
    return active().get(phoneNumber);
  }

  @Override
  public ActiveNumber update(String phoneNumber, ActiveNumberUpdateRequest parameters)
      throws ApiException {
    return active().update(phoneNumber, parameters);
  }

  @Override
  public ActiveNumber release(String phoneNumber) throws ApiException {
    return active().release(phoneNumber);
  }

  @Override
  public ValidateAddressResponse validateEmergencyAddress(
      String phoneNumber, EmergencyAddressRequest emergencyAddressRequest) throws ApiException {
    return active().validateEmergencyAddress(phoneNumber, emergencyAddressRequest);
  }

  @Override
  public EmergencyAddress provisionEmergencyAddress(
      String phoneNumber, EmergencyAddressRequest emergencyAddressRequest) throws ApiException {
    return active().provisionEmergencyAddress(phoneNumber, emergencyAddressRequest);
  }

  @Override
  public void deprovisionEmergencyAddress(String phoneNumber) throws ApiException {
    active().deprovisionEmergencyAddress(phoneNumber);
  }

  @Override
  public EmergencyAddress getEmergencyAddress(String phoneNumber) throws ApiException {
    return active().getEmergencyAddress(phoneNumber);
  }

  private void instanceLazyInit() {
    if (null != this.authManagers) {
      return;
    }
    synchronized (this) {
      if (null == this.authManagers) {
        Objects.requireNonNull(
            credentials, "Numbers service require unified credentials to be defined");
        Objects.requireNonNull(context, "Numbers service requires context to be defined");
        StringUtil.requireNonEmpty(
            credentials.getKeyId(), "Numbers service requires 'keyId' to be defined");
        StringUtil.requireNonEmpty(
            credentials.getKeySecret(), "Numbers service requires 'keySecret' to be defined");
        StringUtil.requireNonEmpty(
            credentials.getProjectId(), "Numbers service requires 'projectId' to be defined");
        StringUtil.requireNonEmpty(
            context.getNumbersUrl(), "'Numbers service requires numbersUrl' to be defined");

        LOGGER.fine(
            "Activate numbers API with server='" + context.getNumbersServer().getUrl() + "'");

        AuthManager authManager =
            new OAuthManager(
                credentials, oAuthServer, HttpMapper.getInstance(), httpClientSupplier);

        uriUUID = credentials.getProjectId();
        authManagers =
            Stream.of(new AbstractMap.SimpleEntry<>(SECURITY_SCHEME_KEYWORD_NUMBERS, authManager))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
      }
    }
  }

  static final class LocalLazyInit {

    private LocalLazyInit() {
      MoneyMapper.initMapper();
      ScheduledVoiceProvisioningMapper.initMapper();
      VoiceConfigurationMapper.initMapper();
    }

    public static LocalLazyInit init() {
      return LocalLazyInit.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {

      public static final LocalLazyInit INSTANCE = new LocalLazyInit();
    }
  }
}
