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
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.voice.models.v2.batches.request.StartBatchRequest;
import com.sinch.sdk.domains.voice.models.v2.batches.response.StartBatchResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

public class BatchesServiceImpl implements com.sinch.sdk.domains.voice.api.v2.BatchesService {

  private static final Logger LOGGER = Logger.getLogger(BatchesServiceImpl.class.getName());
  private final HttpClient httpClient;
  private final ServerConfiguration serverConfiguration;
  private final Map<String, AuthManager> authManagersByOasSecuritySchemes;
  private final HttpMapper mapper;

  private final String projectId;

  public BatchesServiceImpl(
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
  public StartBatchResponse start(StartBatchRequest startBatchRequest) throws ApiException {

    LOGGER.finest("[start]" + " " + "startBatchRequest: " + startBatchRequest);

    HttpRequest httpRequest = startRequestBuilder(startBatchRequest);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      return mapper.deserialize(response, new TypeReference<StartBatchResponse>() {});
    }
    // fallback to default errors handling:
    // all error cases definition are not required from specs: will try some "hardcoded" content
    // parsing
    throw ApiExceptionBuilder.build(
        response.getMessage(),
        response.getCode(),
        mapper.deserialize(response, new TypeReference<HashMap<String, ?>>() {}));
  }

  private HttpRequest startRequestBuilder(StartBatchRequest startBatchRequest) throws ApiException {
    // verify the required parameter 'this.projectId' is set
    if (this.projectId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'this.projectId' when calling start");
    }
    // verify the required parameter 'startBatchRequest' is set
    if (startBatchRequest == null) {
      throw new ApiException(
          400, "Missing the required parameter 'startBatchRequest' when calling start");
    }

    String localVarPath =
        "/v2/projects/{projectId}/calls"
            .replaceAll(
                "\\{" + "projectId" + "\\}",
                URLPathUtils.encodePathSegment(this.projectId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();
    if (null != startBatchRequest.getServiceId()) {
      URLParameterUtils.addQueryParam(
          OptionalValue.of(startBatchRequest.getServiceId()),
          "serviceId",
          URLParameter.form,
          null,
          localVarQueryParams,
          true);
    }

    // Without a key from the caller, one is generated here, once per call. The HTTP client
    // re-sends this same request on every retry, so the key does not change between attempts.
    String idempotencyKey = startBatchRequest.getIdempotencyKey();
    if (StringUtil.isEmpty(idempotencyKey)) {
      idempotencyKey = UUID.randomUUID().toString();
    }
    Map<String, String> localVarHeaderParams = new HashMap<>();
    localVarHeaderParams.put("Idempotency-Key", idempotencyKey);

    final Collection<String> localVarAccepts =
        Arrays.asList("application/json", "application/problem+json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("BasicAuth", "SinchOAuth2");
    final String serializedBody = mapper.serialize(localVarContentTypes, startBatchRequest);

    return new HttpRequest(
        localVarPath,
        HttpMethod.POST,
        localVarQueryParams,
        serializedBody,
        localVarHeaderParams,
        localVarAccepts,
        localVarContentTypes,
        localVarAuthNames);
  }
}
