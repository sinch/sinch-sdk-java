package com.sinch.sdk.domains.numbers.api.v1.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.domains.numbers.api.v1.internal.AvailableNumberApi;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.SearchPattern;
import com.sinch.sdk.domains.numbers.models.v1.available.request.AvailableNumberListRequest;
import com.sinch.sdk.domains.numbers.models.v1.available.request.AvailableNumberListRequestImpl;
import com.sinch.sdk.domains.numbers.models.v1.available.request.AvailableNumberRentAnyRequest;
import com.sinch.sdk.domains.numbers.models.v1.available.request.AvailableNumberRentRequest;
import com.sinch.sdk.domains.numbers.models.v1.available.response.AvailableNumber;
import com.sinch.sdk.domains.numbers.models.v1.available.response.AvailableNumberListResponse;
import com.sinch.sdk.domains.numbers.models.v1.available.response.internal.AvailableNumberListResponseInternal;
import com.sinch.sdk.domains.numbers.models.v1.available.response.internal.AvailableNumberListResponseInternalImpl;
import com.sinch.sdk.models.NumbersContext;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AvailableNumberService
    implements com.sinch.sdk.domains.numbers.api.v1.AvailableNumberService {

  private final String uriUUID;
  private final AvailableNumberApi api;

  public AvailableNumberService(
      String uriUUID,
      NumbersContext context,
      HttpClient httpClient,
      Map<String, AuthManager> authManagers) {
    this.uriUUID = uriUUID;
    this.api =
        new AvailableNumberApi(
            httpClient, context.getNumbersServer(), authManagers, new HttpMapper());
  }

  protected AvailableNumberApi getApi() {
    return this.api;
  }

  public AvailableNumberListResponse list(AvailableNumberListRequest _parameters)
      throws ApiException {

    AvailableNumberListRequestImpl parameters = (AvailableNumberListRequestImpl) _parameters;

    if (null == parameters) {
      parameters = (AvailableNumberListRequestImpl) AvailableNumberListRequest.builder().build();
    }

    String regionCode = parameters.regionCode().orElse(null);
    String type = parameters.type().map(NumberType::value).orElse(null);

    String pattern = null;
    String position = null;
    if (parameters.searchPattern().isPresent()) {
      SearchPattern search = parameters.getSearchPattern();
      pattern = search.getPattern();
      position = null == search.getPosition() ? null : search.getPosition().value();
    }

    List<String> capabilities = null;
    if (parameters.capabilities().isPresent()) {
      capabilities =
          parameters.capabilities().get().stream()
              .map(EnumDynamic::value)
              .collect(Collectors.toList());
    }

    Integer size = parameters.size().orElse(null);

    AvailableNumberListResponseInternal response =
        getApi()
            .numberServiceListAvailableNumbers(
                uriUUID, regionCode, type, pattern, position, capabilities, size);

    return mapForPaging(response);
  }

  public AvailableNumber checkAvailability(String phoneNumber) throws ApiException {
    return getApi().numberServiceGetAvailableNumber(uriUUID, phoneNumber);
  }

  public ActiveNumber rent(String phoneNumber, AvailableNumberRentRequest parameters)
      throws ApiException {

    return getApi().numberServiceRentNumber(uriUUID, phoneNumber, parameters);
  }

  public ActiveNumber rentAny(AvailableNumberRentAnyRequest parameters) throws ApiException {

    return getApi().numberServiceRentAnyNumber(uriUUID, parameters);
  }

  private AvailableNumberListResponse mapForPaging(AvailableNumberListResponseInternal _dto) {

    AvailableNumberListResponseInternalImpl dto = (AvailableNumberListResponseInternalImpl) _dto;
    return new AvailableNumberListResponse(dto.availableNumbers().orElse(Collections.emptyList()));
  }
}
