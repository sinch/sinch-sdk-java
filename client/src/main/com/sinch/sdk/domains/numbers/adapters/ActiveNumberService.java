package com.sinch.sdk.domains.numbers.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.core.models.pagination.TokenPageNavigator;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.numbers.adapters.api.v1.ActiveNumberApi;
import com.sinch.sdk.domains.numbers.adapters.converters.ActiveNumberDtoConverter;
import com.sinch.sdk.domains.numbers.adapters.converters.ActiveNumberUpdateRequestParametersDtoConverter;
import com.sinch.sdk.domains.numbers.models.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.NumberPattern;
import com.sinch.sdk.domains.numbers.models.NumberType;
import com.sinch.sdk.domains.numbers.models.SearchPattern;
import com.sinch.sdk.domains.numbers.models.dto.v1.ActiveNumberDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.ActiveNumbersResponseDto;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberListRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberUpdateRequestParameters;
import com.sinch.sdk.domains.numbers.models.responses.ActiveNumberListResponse;
import com.sinch.sdk.models.Configuration;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ActiveNumberService implements com.sinch.sdk.domains.numbers.ActiveNumberService {

  private Configuration configuration;
  private ActiveNumberApi api;

  public ActiveNumberService() {}

  public ActiveNumberService(
      Configuration configuration, HttpClient httpClient, Map<String, AuthManager> authManagers) {
    this.configuration = configuration;
    this.api =
        new ActiveNumberApi(
            httpClient, configuration.getNumbersServer(), authManagers, new HttpMapper());
  }

  private ActiveNumberApi getApi() {
    return this.api;
  }

  public ActiveNumberListResponse list(ActiveNumberListRequestParameters parameters)
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

    Integer pageSize = parameters.getPageSize().orElse(null);

    String orderBy = null;
    if (parameters.getOrderBy().isPresent()) {
      orderBy = parameters.getOrderBy().get().value();
    }

    String pageToken = parameters.getPageToken().orElse(null);
    ActiveNumbersResponseDto response =
        getApi()
            .numberServiceListActiveNumbers(
                configuration.getProjectId(),
                regionCode,
                type.value(),
                patternPattern,
                null != searchPattern ? searchPattern.value() : null,
                capabilities,
                pageSize,
                pageToken,
                orderBy);
    Pair<Collection<ActiveNumber>, TokenPageNavigator> content =
        ActiveNumberDtoConverter.convert(response);
    return new ActiveNumberListResponse(
        this, new Page<>(parameters, content.getLeft(), content.getRight()));
  }

  public ActiveNumber get(String phoneNumber) throws ApiException {
    ActiveNumberDto response =
        getApi().numberServiceGetActiveNumber(configuration.getProjectId(), phoneNumber);
    return ActiveNumberDtoConverter.convert(response);
  }

  public ActiveNumber release(String phoneNumber) throws ApiException {
    ActiveNumberDto response =
        getApi().numberServiceReleaseNumber(configuration.getProjectId(), phoneNumber);
    return ActiveNumberDtoConverter.convert(response);
  }

  public ActiveNumber update(String phoneNumber, ActiveNumberUpdateRequestParameters parameters)
      throws ApiException {
    ActiveNumberDto response =
        getApi()
            .numberServiceUpdateActiveNumber(
                configuration.getProjectId(),
                phoneNumber,
                ActiveNumberUpdateRequestParametersDtoConverter.convert(parameters));
    return ActiveNumberDtoConverter.convert(response);
  }
}
