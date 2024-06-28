package com.sinch.sdk.domains.numbers.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.core.models.pagination.TokenPageNavigator;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.numbers.adapters.converters.ActiveNumberDtoConverter;
import com.sinch.sdk.domains.numbers.adapters.converters.ActiveNumberUpdateRequestParametersDtoConverter;
import com.sinch.sdk.domains.numbers.models.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberListRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberUpdateRequestParameters;
import com.sinch.sdk.domains.numbers.models.responses.ActiveNumberListResponse;
import com.sinch.sdk.domains.numbers.models.v1.Capability;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.SearchPosition;
import com.sinch.sdk.domains.numbers.models.v1.active.request.ActiveNumberListRequest;
import com.sinch.sdk.domains.numbers.models.v1.active.request.OrderBy;
import java.util.Collection;
import java.util.stream.Collectors;

public class ActiveNumberService implements com.sinch.sdk.domains.numbers.ActiveNumberService {

  private final com.sinch.sdk.domains.numbers.api.v1.ActiveNumberService v1;

  public ActiveNumberService(com.sinch.sdk.domains.numbers.api.v1.ActiveNumberService v1) {
    this.v1 = v1;
  }

  public ActiveNumberListResponse list(ActiveNumberListRequestParameters parameters)
      throws ApiException {

    ActiveNumberListRequest.Builder builder = ActiveNumberListRequest.builder();

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

    parameters.getPageSize().ifPresent(builder::setPageSize);
    parameters.getOrderBy().ifPresent(f -> builder.setOrderBy(OrderBy.from(f.value())));

    parameters.getPageToken().ifPresent(builder::setPageToken);

    com.sinch.sdk.domains.numbers.models.v1.active.response.ActiveNumberListResponse response =
        v1.list(builder.build());
    Pair<Collection<ActiveNumber>, TokenPageNavigator> content =
        ActiveNumberDtoConverter.convert(response);
    return new ActiveNumberListResponse(
        this, new Page<>(parameters, content.getLeft(), content.getRight()));
  }

  public ActiveNumber get(String phoneNumber) throws ApiException {
    return ActiveNumberDtoConverter.convert(v1.get(phoneNumber));
  }

  public ActiveNumber release(String phoneNumber) throws ApiException {
    return ActiveNumberDtoConverter.convert(v1.release(phoneNumber));
  }

  public ActiveNumber update(String phoneNumber, ActiveNumberUpdateRequestParameters parameters)
      throws ApiException {

    return ActiveNumberDtoConverter.convert(
        v1.update(
            phoneNumber, ActiveNumberUpdateRequestParametersDtoConverter.convert(parameters)));
  }
}
