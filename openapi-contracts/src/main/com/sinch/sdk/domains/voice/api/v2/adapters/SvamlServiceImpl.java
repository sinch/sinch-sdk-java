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
import com.sinch.sdk.core.http.URLPathUtils;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.voice.models.v2.svaml.request.DescribeSvamlRequest;
import com.sinch.sdk.domains.voice.models.v2.svaml.response.SvamlDescriptionResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class SvamlServiceImpl implements com.sinch.sdk.domains.voice.api.v2.SvamlService {

  private static final Logger LOGGER = Logger.getLogger(SvamlServiceImpl.class.getName());
  private final HttpClient httpClient;
  private final ServerConfiguration serverConfiguration;
  private final Map<String, AuthManager> authManagersByOasSecuritySchemes;
  private final HttpMapper mapper;

  private final String projectId;

  public SvamlServiceImpl(
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
  public SvamlDescriptionResponse describe(DescribeSvamlRequest describeSvamlRequest)
      throws ApiException {

    LOGGER.finest("[describe]" + " " + "describeSvamlRequest: " + describeSvamlRequest);

    HttpRequest httpRequest = describeRequestBuilder(describeSvamlRequest);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      return mapper.deserialize(response, new TypeReference<SvamlDescriptionResponse>() {});
    }
    // fallback to default errors handling:
    // all error cases definition are not required from specs: will try some "hardcoded" content
    // parsing
    throw ApiExceptionBuilder.build(
        response.getMessage(),
        response.getCode(),
        mapper.deserialize(response, new TypeReference<HashMap<String, ?>>() {}));
  }

  private HttpRequest describeRequestBuilder(DescribeSvamlRequest describeSvamlRequest)
      throws ApiException {
    // verify the required parameter 'this.projectId' is set
    if (this.projectId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'this.projectId' when calling describe");
    }
    // verify the required parameter 'describeSvamlRequest' is set
    if (describeSvamlRequest == null) {
      throw new ApiException(
          400, "Missing the required parameter 'describeSvamlRequest' when calling describe");
    }

    String localVarPath =
        "/v2/projects/{projectId}/svaml/describe"
            .replaceAll(
                "\\{" + "projectId" + "\\}",
                URLPathUtils.encodePathSegment(this.projectId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts =
        Arrays.asList("application/json", "application/problem+json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("BasicAuth", "SinchOAuth2");
    final String serializedBody = mapper.serialize(localVarContentTypes, describeSvamlRequest);

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
