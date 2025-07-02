package com.sinch.sdk.domains.numbers.api.v1.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.numbers.api.v1.AvailableNumberService;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberListRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberListRequestImpl;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberRentAnyRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberRentRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumbersListQueryParameters;
import com.sinch.sdk.domains.numbers.models.v1.request.SearchPattern;
import com.sinch.sdk.domains.numbers.models.v1.response.AvailableNumber;
import com.sinch.sdk.domains.numbers.models.v1.response.AvailableNumberListResponse;
import com.sinch.sdk.models.NumbersContext;
import java.util.ArrayList;
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

  @Override
  public AvailableNumberListResponse searchForAvailableNumbers(
      AvailableNumbersListQueryParameters queryParameter) throws ApiException {
    return availableNumberService.searchForAvailableNumbers(queryParameter);
  }

  @Deprecated
  public AvailableNumberListResponse searchForAvailableNumbers(
      AvailableNumberListRequest _parameters) throws ApiException {
    return searchForAvailableNumbers(convert(_parameters));
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

  @Deprecated
  public static AvailableNumbersListQueryParameters convert(AvailableNumberListRequest _parameters)
      throws ApiException {

    if (null == _parameters) {
      return null;
    }
    AvailableNumberListRequestImpl parameters = (AvailableNumberListRequestImpl) _parameters;
    AvailableNumbersListQueryParameters.Builder builder =
        AvailableNumbersListQueryParameters.builder();

    parameters.regionCode().ifPresent(builder::setRegionCode);
    parameters.type().ifPresent(builder::setType);
    parameters.capabilities().ifPresent(f -> builder.setCapabilities(new ArrayList<>(f)));
    parameters.size().ifPresent(builder::setSize);

    if (parameters.searchPattern().isPresent()) {
      SearchPattern search = parameters.getSearchPattern();
      builder.setSearchPattern(search.getPattern());
      builder.setSearchPosition(search.getPosition());
    }
    return builder.build();
  }
}
