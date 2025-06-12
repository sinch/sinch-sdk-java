package com.sinch.sdk.domains.numbers.api.v1.adapters;

import com.sinch.sdk.auth.adapters.BasicAuthManager;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.numbers.api.v1.AvailableRegionsService;
import com.sinch.sdk.domains.numbers.api.v1.CallbackConfigurationService;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.v1.EmergencyAddress;
import com.sinch.sdk.domains.numbers.models.v1.request.ActiveNumberListRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.ActiveNumberUpdateRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.ActiveNumbersListQueryParameters;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberListRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberRentAnyRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberRentRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumbersListQueryParameters;
import com.sinch.sdk.domains.numbers.models.v1.request.EmergencyAddressRequest;
import com.sinch.sdk.domains.numbers.models.v1.response.ActiveNumberListResponse;
import com.sinch.sdk.domains.numbers.models.v1.response.AvailableNumber;
import com.sinch.sdk.domains.numbers.models.v1.response.AvailableNumberListResponse;
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
  private static final String SECURITY_SCHEME_KEYWORD_NUMBERS = "Basic";

  private final UnifiedCredentials credentials;
  private final NumbersContext context;
  private final Supplier<HttpClient> httpClientSupplier;

  private volatile String uriUUID;
  private volatile Map<String, AuthManager> authManagers;
  private volatile AvailableNumberServiceFacade available;
  private volatile ActiveNumberServiceFacade active;
  private volatile AvailableRegionsService regions;
  private volatile CallbackConfigurationService callback;
  private volatile WebHooksService webhooks;

  static {
    LocalLazyInit.init();
  }

  public NumbersService(
      UnifiedCredentials credentials,
      NumbersContext context,
      Supplier<HttpClient> httpClientSupplier) {
    this.credentials = credentials;
    this.context = context;
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

  public CallbackConfigurationService callback() {
    if (null == this.callback) {
      instanceLazyInit();
      this.callback =
          new CallbackConfigurationServiceImpl(
              httpClientSupplier.get(),
              context.getNumbersServer(),
              authManagers,
              HttpMapper.getInstance(),
              uriUUID);
    }
    return this.callback;
  }

  public WebHooksService webhooks() {

    if (null == this.webhooks) {
      this.webhooks = new WebHooksService(new NumbersWebhooksAuthenticationValidation());
    }
    return this.webhooks;
  }

  public AvailableNumberListResponse searchForAvailableNumbers(
      AvailableNumbersListQueryParameters parameters) throws ApiException {
    return available().searchForAvailableNumbers(parameters);
  }

  @Deprecated
  public AvailableNumberListResponse searchForAvailableNumbers(
      AvailableNumberListRequest parameters) throws ApiException {
    return available().searchForAvailableNumbers(parameters);
  }

  public AvailableNumber checkAvailability(String phoneNumber) throws ApiException {
    return available().checkAvailability(phoneNumber);
  }

  public ActiveNumber rent(String phoneNumber) throws ApiException {
    return available().rent(phoneNumber);
  }

  public ActiveNumber rent(String phoneNumber, AvailableNumberRentRequest parameters)
      throws ApiException {
    return available().rent(phoneNumber, parameters);
  }

  public ActiveNumber rentAny(AvailableNumberRentAnyRequest parameters) throws ApiException {
    return available().rentAny(parameters);
  }

  @Deprecated
  public ActiveNumberListResponse list(ActiveNumberListRequest parameters) throws ApiException {
    return active().list(parameters);
  }

  @Override
  public ActiveNumberListResponse list(ActiveNumbersListQueryParameters queryParameter)
      throws ApiException {
    return active().list(queryParameter);
  }

  public ActiveNumber get(String phoneNumber) throws ApiException {
    return active().get(phoneNumber);
  }

  public ActiveNumber update(String phoneNumber, ActiveNumberUpdateRequest parameters)
      throws ApiException {
    return active().update(phoneNumber, parameters);
  }

  public ActiveNumber release(String phoneNumber) throws ApiException {
    return active().release(phoneNumber);
  }

  public ValidateAddressResponse validateEmergencyAddress(
      String phoneNumber, EmergencyAddressRequest emergencyAddressRequest) throws ApiException {
    return active().validateEmergencyAddress(phoneNumber, emergencyAddressRequest);
  }

  public EmergencyAddress provisionEmergencyAddress(
      String phoneNumber, EmergencyAddressRequest emergencyAddressRequest) throws ApiException {
    return active().provisionEmergencyAddress(phoneNumber, emergencyAddressRequest);
  }

  public void deprovisionEmergencyAddress(String phoneNumber) throws ApiException {
    active().deprovisionEmergencyAddress(phoneNumber);
  }

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

        AuthManager basicAuthManager =
            new BasicAuthManager(credentials.getKeyId(), credentials.getKeySecret());

        uriUUID = credentials.getProjectId();
        authManagers =
            Stream.of(
                    new AbstractMap.SimpleEntry<>(
                        SECURITY_SCHEME_KEYWORD_NUMBERS, basicAuthManager))
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
