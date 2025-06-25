package com.sinch.sdk.domains.numbers.api.v1.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.numbers.api.v1.AvailableNumberService;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberRentAnyRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberRentRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumbersListQueryParameters;
import com.sinch.sdk.domains.numbers.models.v1.response.AvailableNumber;
import com.sinch.sdk.domains.numbers.models.v1.response.AvailableNumbersListResponse;
import com.sinch.sdk.models.NumbersContext;
import java.util.Map;
import java.util.function.Supplier;

public class AvailableNumberServiceFacade implements AvailableNumberService {

  private final AvailableNumberService availableNumberService;

  public AvailableNumberServiceFacade(
      String uriUUID,
      NumbersContext context,
      Supplier<HttpClient> httpClientSupplier,
      Map<String, AuthManager> authManagers) {
    this.availableNumberService =
        new AvailableNumberServiceImpl(
            httpClientSupplier.get(),
            context.getNumbersServer(),
            authManagers,
            HttpMapper.getInstance(),
            uriUUID);
  }

  protected AvailableNumberService getService() {
    return this.availableNumberService;
  }

  @Override
  public AvailableNumbersListResponse searchForAvailableNumbers(
      AvailableNumbersListQueryParameters queryParameter) throws ApiException {
    return availableNumberService.searchForAvailableNumbers(queryParameter);
  }

  @Override
  public AvailableNumber checkAvailability(String phoneNumber) throws ApiException {
    return availableNumberService.checkAvailability(phoneNumber);
  }

  public ActiveNumber rent(String phoneNumber) throws ApiException {
    return availableNumberService.rent(phoneNumber, AvailableNumberRentRequest.builder().build());
  }

  @Override
  public ActiveNumber rent(String phoneNumber, AvailableNumberRentRequest parameters)
      throws ApiException {
    return availableNumberService.rent(phoneNumber, parameters);
  }

  @Override
  public ActiveNumber rentAny(AvailableNumberRentAnyRequest parameters) throws ApiException {
    return availableNumberService.rentAny(parameters);
  }
}
