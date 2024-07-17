/*
 * Numbers | Sinch
 * An API service for getting, listing and managing Sinch virtual numbers.
 *
 * The version of the OpenAPI document: 1.0.2
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.numbers.api.v1.internal;

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
import com.sinch.sdk.domains.numbers.models.v1.regions.available.response.internal.AvailableRegionListResponseInternal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class AvailableRegionsApi {

  private static final Logger LOGGER = Logger.getLogger(AvailableRegionsApi.class.getName());
  private HttpClient httpClient;
  private ServerConfiguration serverConfiguration;
  private Map<String, AuthManager> authManagersByOasSecuritySchemes;
  private HttpMapper mapper;

  public AvailableRegionsApi(
      HttpClient httpClient,
      ServerConfiguration serverConfiguration,
      Map<String, AuthManager> authManagersByOasSecuritySchemes,
      HttpMapper mapper) {
    this.httpClient = httpClient;
    this.serverConfiguration = serverConfiguration;
    this.authManagersByOasSecuritySchemes = authManagersByOasSecuritySchemes;
    this.mapper = mapper;
  }

  /**
   * List available regions Lists all regions for numbers provided for the project ID.
   *
   * @param projectId Found on your [Sinch Customer
   *     Dashboard](https://dashboard.sinch.com/settings/project-management). (required)
   * @param types Only returns regions for which numbers are provided with the given types v1:
   *     &#x60;MOBILE&#x60;, &#x60;LOCAL&#x60; or &#x60;TOLL_FREE&#x60;. However, you can indicate
   *     &#x60;NUMBER_TYPE_UNSPECIFIED: null&#x60; when searching. - NUMBER_TYPE_UNSPECIFIED: Null
   *     value - MOBILE: Numbers that belong to a specific range. - LOCAL: Numbers that are assigned
   *     to a specific geographic region. - TOLL_FREE: Number that are free of charge for the
   *     calling party but billed for all arriving calls. (optional
   * @return AvailableRegionListResponseInternal
   * @throws ApiException if fails to make API call
   */
  public AvailableRegionListResponseInternal numberServiceListAvailableRegions(
      String projectId, List<String> types) throws ApiException {

    LOGGER.finest(
        "[numberServiceListAvailableRegions]"
            + " "
            + "projectId: "
            + projectId
            + ", "
            + "types: "
            + types);

    HttpRequest httpRequest = numberServiceListAvailableRegionsRequestBuilder(projectId, types);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<AvailableRegionListResponseInternal> localVarReturnType =
          new TypeReference<AvailableRegionListResponseInternal>() {};
      return mapper.deserialize(response, localVarReturnType);
    }
    // fallback to default errors handling:
    // all error cases definition are not required from specs: will try some "hardcoded" content
    // parsing
    throw ApiExceptionBuilder.build(
        response.getMessage(),
        response.getCode(),
        mapper.deserialize(response, new TypeReference<HashMap<String, ?>>() {}));
  }

  private HttpRequest numberServiceListAvailableRegionsRequestBuilder(
      String projectId, List<String> types) throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'projectId' when calling"
              + " numberServiceListAvailableRegions");
    }

    String localVarPath =
        "/v1/projects/{projectId}/availableRegions"
            .replaceAll(
                "\\{" + "projectId" + "\\}", URLPathUtils.encodePathSegment(projectId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();
    if (null != types) {
      localVarQueryParams.add(
          new URLParameter("types", types, URLParameter.STYLE.valueOf("form".toUpperCase()), true));
    }

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList();

    final Collection<String> localVarAuthNames = Arrays.asList("BasicAuth");
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
}
