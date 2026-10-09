package com.sinch.sdk.domains.voice.api.v2.adapters;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sinch.sdk.core.databind.query_parameter.InstantToIso8601Serializer;
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
import com.sinch.sdk.domains.voice.models.v2.Call;
import com.sinch.sdk.domains.voice.models.v2.calls.request.CallPatchRequest;
import com.sinch.sdk.domains.voice.models.v2.calls.request.ListCallsQueryParameters;
import com.sinch.sdk.domains.voice.models.v2.calls.request.StartCallQueryParameters;
import com.sinch.sdk.domains.voice.models.v2.calls.request.StartCallRequest;
import com.sinch.sdk.domains.voice.models.v2.calls.response.CallsListResponse;
import com.sinch.sdk.domains.voice.models.v2.calls.response.StartCallResponse;
import com.sinch.sdk.domains.voice.models.v2.calls.response.internal.CallsListResponseInternal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class CallsServiceImpl implements com.sinch.sdk.domains.voice.api.v2.CallsService {

  private static final Logger LOGGER = Logger.getLogger(CallsServiceImpl.class.getName());
  private final HttpClient httpClient;
  private final ServerConfiguration serverConfiguration;
  private final Map<String, AuthManager> authManagersByOasSecuritySchemes;
  private final HttpMapper mapper;

  private final String projectId;

  public CallsServiceImpl(
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
  public StartCallResponse start(StartCallRequest startCallRequest) throws ApiException {

    return start((StartCallQueryParameters) null, startCallRequest);
  }

  @Override
  public StartCallResponse start(
      StartCallQueryParameters queryParameter, StartCallRequest startCallRequest)
      throws ApiException {

    LOGGER.finest(
        "[start]"
            + " "
            + "queryParameter: "
            + queryParameter
            + ", "
            + "startCallRequest: "
            + startCallRequest);

    HttpRequest httpRequest = startRequestBuilder(queryParameter, startCallRequest);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      return mapper.deserialize(response, new TypeReference<StartCallResponse>() {});
    }
    // fallback to default errors handling:
    // all error cases definition are not required from specs: will try some "hardcoded" content
    // parsing
    throw ApiExceptionBuilder.build(
        response.getMessage(),
        response.getCode(),
        mapper.deserialize(response, new TypeReference<HashMap<String, ?>>() {}));
  }

  private HttpRequest startRequestBuilder(
      StartCallQueryParameters queryParameter, StartCallRequest startCallRequest)
      throws ApiException {
    // verify the required parameter 'this.projectId' is set
    if (this.projectId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'this.projectId' when calling start");
    }
    // verify the required parameter 'startCallRequest' is set
    if (startCallRequest == null) {
      throw new ApiException(
          400, "Missing the required parameter 'startCallRequest' when calling start");
    }

    String localVarPath =
        "/v2/projects/{projectId}/calls"
            .replaceAll(
                "\\{" + "projectId" + "\\}",
                URLPathUtils.encodePathSegment(this.projectId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();
    if (null != queryParameter) {
      URLParameterUtils.addQueryParam(
          queryParameter.getServiceId(),
          "serviceId",
          URLParameter.form,
          null,
          localVarQueryParams,
          true);
    }

    Map<String, String> localVarHeaderParams = new HashMap<>();
    if (startCallRequest.getIdempotencyKey() != null)
      localVarHeaderParams.put("Idempotency-Key", startCallRequest.getIdempotencyKey());

    final Collection<String> localVarAccepts =
        Arrays.asList("application/json", "application/problem+json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("BasicAuth", "SinchOAuth2");
    final String serializedBody = mapper.serialize(localVarContentTypes, startCallRequest);

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
  public Call get(String callId) throws ApiException {

    LOGGER.finest("[get]" + " " + "callId: " + callId);

    HttpRequest httpRequest = getRequestBuilder(callId);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      return mapper.deserialize(response, new TypeReference<Call>() {});
    }
    // fallback to default errors handling:
    // all error cases definition are not required from specs: will try some "hardcoded" content
    // parsing
    throw ApiExceptionBuilder.build(
        response.getMessage(),
        response.getCode(),
        mapper.deserialize(response, new TypeReference<HashMap<String, ?>>() {}));
  }

  private HttpRequest getRequestBuilder(String callId) throws ApiException {
    // verify the required parameter 'this.projectId' is set
    if (this.projectId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'this.projectId' when calling get");
    }
    // verify the required parameter 'callId' is set
    if (callId == null) {
      throw new ApiException(400, "Missing the required parameter 'callId' when calling get");
    }

    String localVarPath =
        "/v2/projects/{projectId}/calls/{callId}"
            .replaceAll(
                "\\{" + "projectId" + "\\}",
                URLPathUtils.encodePathSegment(this.projectId.toString()))
            .replaceAll(
                "\\{" + "callId" + "\\}", URLPathUtils.encodePathSegment(callId.toString()));

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
  public CallsListResponse list() throws ApiException {

    return list((ListCallsQueryParameters) null);
  }

  @Override
  public CallsListResponse list(ListCallsQueryParameters queryParameter) throws ApiException {

    LOGGER.finest("[list]" + " " + "queryParameter: " + queryParameter);

    HttpRequest httpRequest = listRequestBuilder(queryParameter);
    return _fetchListPage(httpRequest);
  }

  private CallsListResponse _fetchListPage(HttpRequest httpRequest) throws ApiException {
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {

      CallsListResponseInternal deserialized =
          mapper.deserialize(response, new TypeReference<CallsListResponseInternal>() {});

      final HttpRequest nextHttpRequest =
          PaginationLinksHelper.nextPageRequest(this.serverConfiguration, deserialized.getLinks());

      return new CallsListResponse(
          () -> _fetchListPage(nextHttpRequest),
          new Page<>(deserialized.getCalls(), new PageNavigator<>(nextHttpRequest)));
    }
    // fallback to default errors handling:
    // all error cases definition are not required from specs: will try some "hardcoded" content
    // parsing
    throw ApiExceptionBuilder.build(
        response.getMessage(),
        response.getCode(),
        mapper.deserialize(response, new TypeReference<HashMap<String, ?>>() {}));
  }

  private HttpRequest listRequestBuilder(ListCallsQueryParameters queryParameter)
      throws ApiException {
    // verify the required parameter 'this.projectId' is set
    if (this.projectId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'this.projectId' when calling list");
    }

    String localVarPath =
        "/v2/projects/{projectId}/calls"
            .replaceAll(
                "\\{" + "projectId" + "\\}",
                URLPathUtils.encodePathSegment(this.projectId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();
    if (null != queryParameter) {

      URLParameterUtils.addQueryParam(
          queryParameter.getServiceId(),
          "serviceId",
          URLParameter.form,
          null,
          localVarQueryParams,
          true);

      URLParameterUtils.addQueryParam(
          queryParameter.getFrom(), "from", URLParameter.form, null, localVarQueryParams, true);

      URLParameterUtils.addQueryParam(
          queryParameter.getTo(), "to", URLParameter.form, null, localVarQueryParams, true);

      URLParameterUtils.addQueryParam(
          queryParameter.getCallType(),
          "callType",
          URLParameter.form,
          null,
          localVarQueryParams,
          true);

      URLParameterUtils.addQueryParam(
          queryParameter.getStartTime(),
          "startTime",
          URLParameter.form,
          InstantToIso8601Serializer.getInstance(),
          localVarQueryParams,
          true);

      URLParameterUtils.addQueryParam(
          queryParameter.getEndTime(),
          "endTime",
          URLParameter.form,
          InstantToIso8601Serializer.getInstance(),
          localVarQueryParams,
          true);

      URLParameterUtils.addQueryParam(
          queryParameter.getCallResult(),
          "callResult",
          URLParameter.form,
          null,
          localVarQueryParams,
          true);

      URLParameterUtils.addQueryParam(
          queryParameter.getCallReason(),
          "callReason",
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
  public void interactByCallId(String callId, CallPatchRequest callPatchRequest)
      throws ApiException {

    LOGGER.finest(
        "[interactByCallId]"
            + " "
            + "callId: "
            + callId
            + ", "
            + "callPatchRequest: "
            + callPatchRequest);

    HttpRequest httpRequest = interactByCallIdRequestBuilder(callId, callPatchRequest);
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

  private HttpRequest interactByCallIdRequestBuilder(
      String callId, CallPatchRequest callPatchRequest) throws ApiException {
    // verify the required parameter 'this.projectId' is set
    if (this.projectId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'this.projectId' when calling interactByCallId");
    }
    // verify the required parameter 'callId' is set
    if (callId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'callId' when calling interactByCallId");
    }
    // verify the required parameter 'callPatchRequest' is set
    if (callPatchRequest == null) {
      throw new ApiException(
          400, "Missing the required parameter 'callPatchRequest' when calling interactByCallId");
    }

    String localVarPath =
        "/v2/projects/{projectId}/calls/{callId}"
            .replaceAll(
                "\\{" + "projectId" + "\\}",
                URLPathUtils.encodePathSegment(this.projectId.toString()))
            .replaceAll(
                "\\{" + "callId" + "\\}", URLPathUtils.encodePathSegment(callId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();
    if (callPatchRequest.getIdempotencyKey() != null)
      localVarHeaderParams.put("Idempotency-Key", callPatchRequest.getIdempotencyKey());

    final Collection<String> localVarAccepts =
        Arrays.asList("application/json", "application/problem+json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("BasicAuth", "SinchOAuth2");
    final String serializedBody = mapper.serialize(localVarContentTypes, callPatchRequest);

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

  @Override
  public void interactByCallName(
      String sessionId, String callName, CallPatchRequest callPatchRequest) throws ApiException {

    LOGGER.finest(
        "[interactByCallName]"
            + " "
            + "sessionId: "
            + sessionId
            + ", "
            + "callName: "
            + callName
            + ", "
            + "callPatchRequest: "
            + callPatchRequest);

    HttpRequest httpRequest =
        interactByCallNameRequestBuilder(sessionId, callName, callPatchRequest);
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

  private HttpRequest interactByCallNameRequestBuilder(
      String sessionId, String callName, CallPatchRequest callPatchRequest) throws ApiException {
    // verify the required parameter 'this.projectId' is set
    if (this.projectId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'this.projectId' when calling interactByCallName");
    }
    // verify the required parameter 'sessionId' is set
    if (sessionId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'sessionId' when calling interactByCallName");
    }
    // verify the required parameter 'callName' is set
    if (callName == null) {
      throw new ApiException(
          400, "Missing the required parameter 'callName' when calling interactByCallName");
    }
    // verify the required parameter 'callPatchRequest' is set
    if (callPatchRequest == null) {
      throw new ApiException(
          400, "Missing the required parameter 'callPatchRequest' when calling interactByCallName");
    }

    String localVarPath =
        "/v2/projects/{projectId}/sessions/{sessionId}/calls/{callName}"
            .replaceAll(
                "\\{" + "projectId" + "\\}",
                URLPathUtils.encodePathSegment(this.projectId.toString()))
            .replaceAll(
                "\\{" + "sessionId" + "\\}", URLPathUtils.encodePathSegment(sessionId.toString()))
            .replaceAll(
                "\\{" + "callName" + "\\}", URLPathUtils.encodePathSegment(callName.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();
    if (callPatchRequest.getIdempotencyKey() != null)
      localVarHeaderParams.put("Idempotency-Key", callPatchRequest.getIdempotencyKey());

    final Collection<String> localVarAccepts =
        Arrays.asList("application/json", "application/problem+json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("BasicAuth", "SinchOAuth2");
    final String serializedBody = mapper.serialize(localVarContentTypes, callPatchRequest);

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
