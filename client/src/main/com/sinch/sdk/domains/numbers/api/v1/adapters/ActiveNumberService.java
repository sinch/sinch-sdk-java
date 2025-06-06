package com.sinch.sdk.domains.numbers.api.v1.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.core.models.pagination.TokenPageNavigator;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.numbers.api.v1.NumbersService;
import com.sinch.sdk.domains.numbers.api.v1.internal.ActiveNumberApi;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.v1.request.ActiveNumberListRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.ActiveNumberListRequestImpl;
import com.sinch.sdk.domains.numbers.models.v1.request.ActiveNumberUpdateRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.SearchPattern;
import com.sinch.sdk.domains.numbers.models.v1.response.ActiveNumberListResponse;
import com.sinch.sdk.domains.numbers.models.v1.response.internal.ActiveNumberListResponseInternal;
import com.sinch.sdk.domains.numbers.models.v1.response.internal.ActiveNumberListResponseInternalImpl;
import com.sinch.sdk.models.NumbersContext;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ActiveNumberService {

  private final String uriUUID;
  private final ActiveNumberApi api;
  private final NumbersService numbersService;

  public ActiveNumberService(
      String uriUUID,
      NumbersService numbersService,
      NumbersContext context,
      Supplier<HttpClient> httpClientSupplier,
      Map<String, AuthManager> authManagers) {
    this.uriUUID = uriUUID;
    this.numbersService = numbersService;
    this.api =
        new ActiveNumberApi(
            httpClientSupplier.get(),
            context.getNumbersServer(),
            authManagers,
            HttpMapper.getInstance());
  }

  protected ActiveNumberApi getApi() {
    return this.api;
  }

  public ActiveNumberListResponse list(ActiveNumberListRequest _parameters) throws ApiException {

    ActiveNumberListRequestImpl parameters = (ActiveNumberListRequestImpl) _parameters;

    if (null == parameters) {
      parameters = (ActiveNumberListRequestImpl) ActiveNumberListRequest.builder().build();
    }
    String regionCode = parameters.getRegionCode();
    String type = null == parameters.getType() ? null : parameters.getType().value();

    String patternPattern = null;
    String searchPosition = null;

    if (parameters.searchPattern().isPresent()) {
      SearchPattern pattern = parameters.getSearchPattern();
      patternPattern = pattern.getPattern();
      searchPosition = null != pattern.getPosition() ? pattern.getPosition().value() : null;
    }

    List<String> capabilities = null;
    if (parameters.capabilities().isPresent()) {
      capabilities =
          parameters.getCapabilities().stream()
              .map(EnumDynamic::value)
              .collect(Collectors.toList());
    }

    Integer pageSize = parameters.pageSize().orElse(null);

    String orderBy = null;
    if (parameters.orderBy().isPresent()) {
      orderBy = parameters.getOrderBy().value();
    }

    String pageToken = parameters.pageToken().orElse(null);

    ActiveNumberListResponseInternal response =
        getApi()
            .numberServiceListActiveNumbers(
                uriUUID,
                regionCode,
                type,
                patternPattern,
                searchPosition,
                capabilities,
                pageSize,
                pageToken,
                orderBy);

    return mapForPaging(parameters, response);
  }

  public ActiveNumber get(String phoneNumber) throws ApiException {
    return getApi().numberServiceGetActiveNumber(uriUUID, phoneNumber);
  }

  public ActiveNumber release(String phoneNumber) throws ApiException {
    return getApi().numberServiceReleaseNumber(uriUUID, phoneNumber);
  }

  public ActiveNumber update(String phoneNumber, ActiveNumberUpdateRequest parameters)
      throws ApiException {
    return getApi().numberServiceUpdateActiveNumber(uriUUID, phoneNumber, parameters);
  }

  private ActiveNumberListResponse mapForPaging(
      ActiveNumberListRequest parameters, ActiveNumberListResponseInternal _dto) {

    ActiveNumberListResponseInternalImpl dto = (ActiveNumberListResponseInternalImpl) _dto;

    String nextPageToken = dto.nextPageToken().orElse(null);
    List<ActiveNumber> list = dto.activeNumbers().orElse(Collections.emptyList());

    Pair<Collection<ActiveNumber>, TokenPageNavigator> paginated =
        new Pair<>(list, new TokenPageNavigator(nextPageToken));

    return new ActiveNumberListResponse(
        this.numbersService, new Page<>(parameters, paginated.getLeft(), paginated.getRight()));
  }
}
