package com.sinch.sdk.domains.voice.api.v2.adapters;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.exceptions.ApiExceptionBuilder;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.http.HttpStatus;
import com.sinch.sdk.core.http.URLParameter;
import com.sinch.sdk.core.http.URLParameterUtils;
import com.sinch.sdk.core.http.URLPathUtils;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.core.models.pagination.PageNavigator;
import com.sinch.sdk.domains.voice.models.v2.services.request.CreateServiceRequest;
import com.sinch.sdk.domains.voice.models.v2.services.request.ListServicesQueryParameters;
import com.sinch.sdk.domains.voice.models.v2.services.request.UpdateServiceRequest;
import com.sinch.sdk.domains.voice.models.v2.services.response.ServiceResponse;
import com.sinch.sdk.domains.voice.models.v2.services.response.ServicesListResponse;
import com.sinch.sdk.domains.voice.models.v2.services.response.internal.ServicesListResponseInternal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ServicesServiceImpl implements com.sinch.sdk.domains.voice.api.v2.ServicesService {

  private static final Logger LOGGER = Logger.getLogger(ServicesServiceImpl.class.getName());
  private final HttpClient httpClient;
  private final ServerConfiguration serverConfiguration;
  private final Map<String, AuthManager> authManagersByOasSecuritySchemes;
  private final HttpMapper mapper;

  private final String projectId;

  public ServicesServiceImpl(
      HttpClient httpClient,
      ServerConfiguration serverConfiguration,
      Map<String, AuthManager> authManagersByOasSecuritySchemes,
      HttpMapper mapper,
      String projectId) {
    this.httpClient = httpClient;
    this.serverConfiguration = serverConfiguration;
    this.authManagersByOasSecuritySchemes = authManagersByOasSecuritySchemes;
    this.mapper = mapper;
    this.projectId = projectId;
  }

  @Override
  public ServiceResponse create(CreateServiceRequest createServiceRequest) throws ApiException {

    LOGGER.finest("[create]" + " " + "createServiceRequest: " + createServiceRequest);

    HttpRequest httpRequest = createRequestBuilder(createServiceRequest);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      return mapper.deserialize(response, new TypeReference<ServiceResponse>() {});
    }
    // fallback to default errors handling:
    // all error cases definition are not required from specs: will try some "hardcoded" content
    // parsing
    throw ApiExceptionBuilder.build(
        response.getMessage(),
        response.getCode(),
        mapper.deserialize(response, new TypeReference<HashMap<String, ?>>() {}));
  }

  private HttpRequest createRequestBuilder(CreateServiceRequest createServiceRequest)
      throws ApiException {
    // verify the required parameter 'this.projectId' is set
    if (this.projectId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'this.projectId' when calling create");
    }
    // verify the required parameter 'createServiceRequest' is set
    if (createServiceRequest == null) {
      throw new ApiException(
          400, "Missing the required parameter 'createServiceRequest' when calling create");
    }

    String localVarPath =
        "/v2/projects/{projectId}/services"
            .replaceAll(
                "\\{" + "projectId" + "\\}",
                URLPathUtils.encodePathSegment(this.projectId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();
    if (createServiceRequest.getIdempotencyKey() != null)
      localVarHeaderParams.put("Idempotency-Key", createServiceRequest.getIdempotencyKey());

    final Collection<String> localVarAccepts =
        Arrays.asList("application/json", "application/problem+json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("BasicAuth", "SinchOAuth2");
    final String serializedBody = mapper.serialize(localVarContentTypes, createServiceRequest);

    return new HttpRequest(
        localVarPath,
        HttpMethod.POST,
        localVarQueryParams,
        serializedBody,
        localVarHeaderParams,
        localVarAccepts,
        localVarContentTypes,
        localVarAuthNames,
        true);
  }

  @Override
  public void delete(String serviceId) throws ApiException {

    LOGGER.finest("[delete]" + " " + "serviceId: " + serviceId);

    HttpRequest httpRequest = deleteRequestBuilder(serviceId);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      return;
    }
    // fallback to default errors handling:
    // all error cases definition are not required from specs: will try some "hardcoded" content
    // parsing
    throw ApiExceptionBuilder.build(
        response.getMessage(),
        response.getCode(),
        mapper.deserialize(response, new TypeReference<HashMap<String, ?>>() {}));
  }

  private HttpRequest deleteRequestBuilder(String serviceId) throws ApiException {
    // verify the required parameter 'this.projectId' is set
    if (this.projectId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'this.projectId' when calling delete");
    }
    // verify the required parameter 'serviceId' is set
    if (serviceId == null) {
      throw new ApiException(400, "Missing the required parameter 'serviceId' when calling delete");
    }

    String localVarPath =
        "/v2/projects/{projectId}/services/{serviceId}"
            .replaceAll(
                "\\{" + "projectId" + "\\}",
                URLPathUtils.encodePathSegment(this.projectId.toString()))
            .replaceAll(
                "\\{" + "serviceId" + "\\}", URLPathUtils.encodePathSegment(serviceId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts =
        Arrays.asList("application/json", "application/problem+json");

    final Collection<String> localVarContentTypes = Arrays.asList();

    final Collection<String> localVarAuthNames = Arrays.asList("BasicAuth", "SinchOAuth2");
    final String serializedBody = null;

    return new HttpRequest(
        localVarPath,
        HttpMethod.DELETE,
        localVarQueryParams,
        serializedBody,
        localVarHeaderParams,
        localVarAccepts,
        localVarContentTypes,
        localVarAuthNames);
  }

  @Override
  public ServiceResponse get(String serviceId) throws ApiException {

    LOGGER.finest("[get]" + " " + "serviceId: " + serviceId);

    HttpRequest httpRequest = getRequestBuilder(serviceId);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      return mapper.deserialize(response, new TypeReference<ServiceResponse>() {});
    }
    // fallback to default errors handling:
    // all error cases definition are not required from specs: will try some "hardcoded" content
    // parsing
    throw ApiExceptionBuilder.build(
        response.getMessage(),
        response.getCode(),
        mapper.deserialize(response, new TypeReference<HashMap<String, ?>>() {}));
  }

  private HttpRequest getRequestBuilder(String serviceId) throws ApiException {
    // verify the required parameter 'this.projectId' is set
    if (this.projectId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'this.projectId' when calling get");
    }
    // verify the required parameter 'serviceId' is set
    if (serviceId == null) {
      throw new ApiException(400, "Missing the required parameter 'serviceId' when calling get");
    }

    String localVarPath =
        "/v2/projects/{projectId}/services/{serviceId}"
            .replaceAll(
                "\\{" + "projectId" + "\\}",
                URLPathUtils.encodePathSegment(this.projectId.toString()))
            .replaceAll(
                "\\{" + "serviceId" + "\\}", URLPathUtils.encodePathSegment(serviceId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts =
        Arrays.asList("application/json", "application/problem+json");

    final Collection<String> localVarContentTypes = Arrays.asList();

    final Collection<String> localVarAuthNames = Arrays.asList("BasicAuth", "SinchOAuth2");
    final String serializedBody = null;

    return new HttpRequest(
        localVarPath,
        HttpMethod.GET,
        localVarQueryParams,
        serializedBody,
        localVarHeaderParams,
        localVarAccepts,
        localVarContentTypes,
        localVarAuthNames);
  }

  @Override
  public ServicesListResponse list() throws ApiException {

    return list((ListServicesQueryParameters) null);
  }

  @Override
  public ServicesListResponse list(ListServicesQueryParameters queryParameter) throws ApiException {

    LOGGER.finest("[list]" + " " + "queryParameter: " + queryParameter);

    HttpRequest httpRequest = listRequestBuilder(queryParameter);
    return _fetchListPage(httpRequest);
  }

  private ServicesListResponse _fetchListPage(HttpRequest httpRequest) throws ApiException {
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {

      ServicesListResponseInternal deserialized =
          mapper.deserialize(response, new TypeReference<ServicesListResponseInternal>() {});

      final HttpRequest nextHttpRequest =
          PaginationLinksHelper.nextPageRequest(this.serverConfiguration, deserialized.getLinks());

      return new ServicesListResponse(
          () -> _fetchListPage(nextHttpRequest),
          new Page<>(deserialized.getServices(), new PageNavigator<>(nextHttpRequest)));
    }
    // fallback to default errors handling:
    // all error cases definition are not required from specs: will try some "hardcoded" content
    // parsing
    throw ApiExceptionBuilder.build(
        response.getMessage(),
        response.getCode(),
        mapper.deserialize(response, new TypeReference<HashMap<String, ?>>() {}));
  }

  private HttpRequest listRequestBuilder(ListServicesQueryParameters queryParameter)
      throws ApiException {
    // verify the required parameter 'this.projectId' is set
    if (this.projectId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'this.projectId' when calling list");
    }

    String localVarPath =
        "/v2/projects/{projectId}/services"
            .replaceAll(
                "\\{" + "projectId" + "\\}",
                URLPathUtils.encodePathSegment(this.projectId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();
    if (null != queryParameter) {

      URLParameterUtils.addQueryParam(
          queryParameter.getFilter(), "filter", URLParameter.form, null, localVarQueryParams, true);

      URLParameterUtils.addQueryParam(
          queryParameter.getIsDefault(),
          "isDefault",
          URLParameter.form,
          null,
          localVarQueryParams,
          true);

      URLParameterUtils.addQueryParam(
          queryParameter.getPageSize(),
          "pageSize",
          URLParameter.form,
          null,
          localVarQueryParams,
          true);

      URLParameterUtils.addQueryParam(
          queryParameter.getPage(), "page", URLParameter.form, null, localVarQueryParams, true);
    }

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts =
        Arrays.asList("application/json", "application/problem+json");

    final Collection<String> localVarContentTypes = Arrays.asList();

    final Collection<String> localVarAuthNames = Arrays.asList("BasicAuth", "SinchOAuth2");
    final String serializedBody = null;

    return new HttpRequest(
        localVarPath,
        HttpMethod.GET,
        localVarQueryParams,
        serializedBody,
        localVarHeaderParams,
        localVarAccepts,
        localVarContentTypes,
        localVarAuthNames);
  }

  @Override
  public ServiceResponse update(String serviceId, UpdateServiceRequest updateServiceRequest)
      throws ApiException {

    LOGGER.finest(
        "[update]"
            + " "
            + "serviceId: "
            + serviceId
            + ", "
            + "updateServiceRequest: "
            + updateServiceRequest);

    HttpRequest httpRequest = updateRequestBuilder(serviceId, updateServiceRequest);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      return mapper.deserialize(response, new TypeReference<ServiceResponse>() {});
    }
    // fallback to default errors handling:
    // all error cases definition are not required from specs: will try some "hardcoded" content
    // parsing
    throw ApiExceptionBuilder.build(
        response.getMessage(),
        response.getCode(),
        mapper.deserialize(response, new TypeReference<HashMap<String, ?>>() {}));
  }

  private HttpRequest updateRequestBuilder(
      String serviceId, UpdateServiceRequest updateServiceRequest) throws ApiException {
    // verify the required parameter 'this.projectId' is set
    if (this.projectId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'this.projectId' when calling update");
    }
    // verify the required parameter 'serviceId' is set
    if (serviceId == null) {
      throw new ApiException(400, "Missing the required parameter 'serviceId' when calling update");
    }
    // verify the required parameter 'updateServiceRequest' is set
    if (updateServiceRequest == null) {
      throw new ApiException(
          400, "Missing the required parameter 'updateServiceRequest' when calling update");
    }

    String localVarPath =
        "/v2/projects/{projectId}/services/{serviceId}"
            .replaceAll(
                "\\{" + "projectId" + "\\}",
                URLPathUtils.encodePathSegment(this.projectId.toString()))
            .replaceAll(
                "\\{" + "serviceId" + "\\}", URLPathUtils.encodePathSegment(serviceId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();
    if (updateServiceRequest.getIdempotencyKey() != null)
      localVarHeaderParams.put("Idempotency-Key", updateServiceRequest.getIdempotencyKey());

    final Collection<String> localVarAccepts =
        Arrays.asList("application/json", "application/problem+json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("BasicAuth", "SinchOAuth2");
    final String serializedBody = mapper.serialize(localVarContentTypes, updateServiceRequest);

    return new HttpRequest(
        localVarPath,
        HttpMethod.PATCH,
        localVarQueryParams,
        serializedBody,
        localVarHeaderParams,
        localVarAccepts,
        localVarContentTypes,
        localVarAuthNames,
        true);
  }
}
