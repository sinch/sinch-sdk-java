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
import com.sinch.sdk.models.NumbersContext;
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ActiveNumberService implements com.sinch.sdk.domains.numbers.ActiveNumberService {

  private final UnifiedCredentials credentials;
  private final ActiveNumberApi api;

  public ActiveNumberService(
      UnifiedCredentials credentials,
      NumbersContext context,
      HttpClient httpClient,
      Map<String, AuthManager> authManagers) {
    this.credentials = credentials;
    this.api =
        new ActiveNumberApi(httpClient, context.getNumbersServer(), authManagers, new HttpMapper());
  }

  protected ActiveNumberApi getApi() {
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
                credentials.getProjectId(),
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
        getApi().numberServiceGetActiveNumber(credentials.getProjectId(), phoneNumber);
    return ActiveNumberDtoConverter.convert(response);
  }

  public ActiveNumber release(String phoneNumber) throws ApiException {
    ActiveNumberDto response =
        getApi().numberServiceReleaseNumber(credentials.getProjectId(), phoneNumber);
    return ActiveNumberDtoConverter.convert(response);
  }

  public ActiveNumber update(String phoneNumber, ActiveNumberUpdateRequestParameters parameters)
      throws ApiException {
    ActiveNumberDto response =
        getApi()
            .numberServiceUpdateActiveNumber(
                credentials.getProjectId(),
                phoneNumber,
                ActiveNumberUpdateRequestParametersDtoConverter.convert(parameters));
    return ActiveNumberDtoConverter.convert(response);
  }
}
