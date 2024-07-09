package com.sinch.sdk.domains.numbers.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.adapters.converters.ActiveNumberDtoConverter;
import com.sinch.sdk.domains.numbers.adapters.converters.AvailableNumberDtoConverter;
import com.sinch.sdk.domains.numbers.adapters.converters.AvailableRentAnyRequestParametersDtoConverter;
import com.sinch.sdk.domains.numbers.adapters.converters.AvailableRentRequestParametersDtoConverter;
import com.sinch.sdk.domains.numbers.models.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.AvailableNumber;
import com.sinch.sdk.domains.numbers.models.requests.AvailableNumberListAllRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.AvailableNumberRentAnyRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.AvailableNumberRentRequestParameters;
import com.sinch.sdk.domains.numbers.models.responses.AvailableNumberListResponse;
import com.sinch.sdk.domains.numbers.models.v1.Capability;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.SearchPosition;
import com.sinch.sdk.domains.numbers.models.v1.available.request.AvailableNumberListRequest;
import java.util.Collection;
import java.util.stream.Collectors;

public class AvailableNumberService
    implements com.sinch.sdk.domains.numbers.AvailableNumberService {

  private final com.sinch.sdk.domains.numbers.api.v1.NumbersService v1;

  public AvailableNumberService(com.sinch.sdk.domains.numbers.api.v1.NumbersService v1) {
    this.v1 = v1;
  }

  public AvailableNumberListResponse list(AvailableNumberListAllRequestParameters parameters)
      throws ApiException {

    AvailableNumberListRequest.Builder builder = AvailableNumberListRequest.builder();

    parameters.getRegionCode().ifPresent(builder::setRegionCode);
    parameters.getType().ifPresent(f -> builder.setType(NumberType.from(f.value())));

    parameters
        .getNumberPattern()
        .ifPresent(
            f -> {
              com.sinch.sdk.domains.numbers.models.v1.SearchPattern.Builder spBuilder =
                  com.sinch.sdk.domains.numbers.models.v1.SearchPattern.builder();
              spBuilder.setPattern(f.getPattern());
              spBuilder.setPosition(
                  null != f.getSearchPattern()
                      ? SearchPosition.from(f.getSearchPattern().value())
                      : null);
              builder.setSearchPattern(spBuilder.build());
            });

    parameters
        .getCapabilities()
        .ifPresent(
            f ->
                builder.setCapabilities(
                    f.stream().map(c -> Capability.from(c.value())).collect(Collectors.toList())));

    parameters.getSize().ifPresent(builder::setSize);

    com.sinch.sdk.domains.numbers.models.v1.available.response.AvailableNumberListResponse
        response = v1.searchForAvailableNumbers(builder.build());

    Collection<AvailableNumber> entities = AvailableNumberDtoConverter.convert(response);

    return new AvailableNumberListResponse(entities);
  }

  public AvailableNumber checkAvailability(String phoneNumber) throws ApiException {

    com.sinch.sdk.domains.numbers.models.v1.available.response.AvailableNumber response =
        v1.checkAvailability(phoneNumber);
    return AvailableNumberDtoConverter.convert(response);
  }

  public ActiveNumber rent(String phoneNumber, AvailableNumberRentRequestParameters parameters)
      throws ApiException {

    AvailableNumberRentRequestParameters guardParameters =
        null != parameters ? parameters : AvailableNumberRentRequestParameters.builder().build();

    com.sinch.sdk.domains.numbers.models.v1.ActiveNumber response =
        v1.rent(phoneNumber, AvailableRentRequestParametersDtoConverter.convert(guardParameters));

    return ActiveNumberDtoConverter.convert(response);
  }

  public ActiveNumber rentAny(AvailableNumberRentAnyRequestParameters parameters)
      throws ApiException {

    AvailableNumberRentAnyRequestParameters guardParameters =
        null != parameters ? parameters : AvailableNumberRentAnyRequestParameters.builder().build();

    com.sinch.sdk.domains.numbers.models.v1.ActiveNumber response =
        v1.rentAny(AvailableRentAnyRequestParametersDtoConverter.convert(guardParameters));
    return ActiveNumberDtoConverter.convert(response);
  }
}
