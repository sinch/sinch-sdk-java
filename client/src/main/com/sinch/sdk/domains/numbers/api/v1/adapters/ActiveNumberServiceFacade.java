package com.sinch.sdk.domains.numbers.api.v1.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.numbers.api.v1.ActiveNumberService;
import com.sinch.sdk.domains.numbers.api.v1.NumbersService;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.v1.EmergencyAddress;
import com.sinch.sdk.domains.numbers.models.v1.request.ActiveNumberUpdateRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.ActiveNumbersListQueryParameters;
import com.sinch.sdk.domains.numbers.models.v1.request.EmergencyAddressRequest;
import com.sinch.sdk.domains.numbers.models.v1.response.ActiveNumbersListResponse;
import com.sinch.sdk.domains.numbers.models.v1.response.ValidateAddressResponse;
import com.sinch.sdk.models.NumbersContext;
import java.util.Map;
import java.util.function.Supplier;

public class ActiveNumberServiceFacade implements ActiveNumberService {

  private final ActiveNumberService activeNumberService;

  public ActiveNumberServiceFacade(
      String uriUUID,
      NumbersService numbersService,
      NumbersContext context,
      Supplier<HttpClient> httpClientSupplier,
      Map<String, AuthManager> authManagers) {
    this.activeNumberService =
        new ActiveNumberServiceImpl(
            httpClientSupplier.get(),
            context.getNumbersServer(),
            authManagers,
            HttpMapper.getInstance(),
            uriUUID,
            numbersService);
  }

  protected ActiveNumberService getService() {
    return this.activeNumberService;
  }

  @Override
  public ActiveNumber get(String phoneNumber) throws ApiException {
    return activeNumberService.get(phoneNumber);
  }

  @Override
  public ActiveNumber release(String phoneNumber) throws ApiException {
    return activeNumberService.release(phoneNumber);
  }

  @Override
  public ActiveNumber update(String phoneNumber, ActiveNumberUpdateRequest parameters)
      throws ApiException {
    return activeNumberService.update(phoneNumber, parameters);
  }

  @Override
  public ValidateAddressResponse validateEmergencyAddress(
      String phoneNumber, EmergencyAddressRequest emergencyAddressRequest) throws ApiException {
    return activeNumberService.validateEmergencyAddress(phoneNumber, emergencyAddressRequest);
  }

  @Override
  public EmergencyAddress provisionEmergencyAddress(
      String phoneNumber, EmergencyAddressRequest emergencyAddressRequest) throws ApiException {
    return activeNumberService.provisionEmergencyAddress(phoneNumber, emergencyAddressRequest);
  }

  @Override
  public void deprovisionEmergencyAddress(String phoneNumber) throws ApiException {
    activeNumberService.deprovisionEmergencyAddress(phoneNumber);
  }

  @Override
  public EmergencyAddress getEmergencyAddress(String phoneNumber) throws ApiException {
    return activeNumberService.getEmergencyAddress(phoneNumber);
  }

  @Override
  public ActiveNumbersListResponse list(ActiveNumbersListQueryParameters queryParameter)
      throws ApiException {
    return activeNumberService.list(queryParameter);
  }
}
