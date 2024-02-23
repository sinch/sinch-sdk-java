package com.sinch.sdk.domains.numbers.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.domains.numbers.adapters.api.v1.AvailableNumberApi;
import com.sinch.sdk.domains.numbers.adapters.converters.ActiveNumberDtoConverter;
import com.sinch.sdk.domains.numbers.adapters.converters.AvailableNumberDtoConverter;
import com.sinch.sdk.domains.numbers.adapters.converters.AvailableRentAnyRequestParametersDtoConverter;
import com.sinch.sdk.domains.numbers.adapters.converters.AvailableRentRequestParametersDtoConverter;
import com.sinch.sdk.domains.numbers.models.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.AvailableNumber;
import com.sinch.sdk.domains.numbers.models.NumberPattern;
import com.sinch.sdk.domains.numbers.models.NumberType;
import com.sinch.sdk.domains.numbers.models.SearchPattern;
import com.sinch.sdk.domains.numbers.models.dto.v1.ActiveNumberDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.AvailableNumberDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.AvailableNumbersResponseDto;
import com.sinch.sdk.domains.numbers.models.requests.AvailableNumberListAllRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.AvailableNumberRentAnyRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.AvailableNumberRentRequestParameters;
import com.sinch.sdk.domains.numbers.models.responses.AvailableNumberListResponse;
import com.sinch.sdk.models.NumbersContext;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AvailableNumberService
    implements com.sinch.sdk.domains.numbers.AvailableNumberService {

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

  public AvailableNumberListResponse list(AvailableNumberListAllRequestParameters parameters)
      throws ApiException {
    String regionCode = parameters.getRegionCode().get();
    NumberType type = parameters.getType().get();

    OptionalValue<NumberPattern> pattern = parameters.getNumberPattern();
    String patternPattern = null;
    SearchPattern searchPattern = null;
    if (pattern.isPresent()) {
      NumberPattern p = pattern.get();
      patternPattern = p.getPattern();
      searchPattern = p.getSearchPattern();
    }

    List<String> capabilities = null;
    if (parameters.getCapabilities().isPresent()) {
      capabilities =
          parameters.getCapabilities().get().stream()
              .map(EnumDynamic::value)
              .collect(Collectors.toList());
    }

    Integer size = parameters.getSize().orElse(null);

    AvailableNumbersResponseDto response =
        getApi()
            .numberServiceListAvailableNumbers(
                uriUUID,
                regionCode,
                type.value(),
                patternPattern,
                null != searchPattern ? searchPattern.value() : null,
                capabilities,
                size);
    Collection<AvailableNumber> entities = AvailableNumberDtoConverter.convert(response);

    return new AvailableNumberListResponse(entities);
  }

  public AvailableNumber checkAvailability(String phoneNumber) throws ApiException {
    AvailableNumberDto response = getApi().numberServiceGetAvailableNumber(uriUUID, phoneNumber);
    return AvailableNumberDtoConverter.convert(response);
  }

  public ActiveNumber rent(String phoneNumber, AvailableNumberRentRequestParameters parameters)
      throws ApiException {

    AvailableNumberRentRequestParameters guardParameters =
        null != parameters ? parameters : AvailableNumberRentRequestParameters.builder().build();

    ActiveNumberDto response =
        getApi()
            .numberServiceRentNumber(
                uriUUID,
                phoneNumber,
                AvailableRentRequestParametersDtoConverter.convert(guardParameters));
    return ActiveNumberDtoConverter.convert(response);
  }

  public ActiveNumber rentAny(AvailableNumberRentAnyRequestParameters parameters)
      throws ApiException {

    ActiveNumberDto response =
        getApi()
            .numberServiceRentAnyNumber(
                uriUUID, AvailableRentAnyRequestParametersDtoConverter.convert(parameters));
    return ActiveNumberDtoConverter.convert(response);
  }
}
