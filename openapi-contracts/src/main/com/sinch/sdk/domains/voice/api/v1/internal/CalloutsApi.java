/*
 * Voice API | Sinch
 *
 * OpenAPI document version: 1.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.voice.api.v1.internal;

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
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.internal.CalloutRequestInternal;
import com.sinch.sdk.domains.voice.models.v1.callouts.response.CalloutResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class CalloutsApi {

  private static final Logger LOGGER = Logger.getLogger(CalloutsApi.class.getName());
  private HttpClient httpClient;
  private ServerConfiguration serverConfiguration;
  private Map<String, AuthManager> authManagersByOasSecuritySchemes;
  private HttpMapper mapper;

  public CalloutsApi(
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
   * Callout Request Makes a call out to a phone number. The types of callouts currently supported
   * are conference callouts, text-to-speech callouts, and custom callouts. The custom callout is
   * the most flexible, but text-to-speech and conference callouts are more convenient.
   *
   * @param calloutRequestInternal (optional)
   * @return CalloutResponse
   * @throws ApiException if fails to make API call
   */
  public CalloutResponse callouts(CalloutRequestInternal calloutRequestInternal)
      throws ApiException {

    LOGGER.finest("[callouts]" + " " + "calloutRequestInternal: " + calloutRequestInternal);

    HttpRequest httpRequest = calloutsRequestBuilder(calloutRequestInternal);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<CalloutResponse> localVarReturnType = new TypeReference<CalloutResponse>() {};
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

  private HttpRequest calloutsRequestBuilder(CalloutRequestInternal calloutRequestInternal)
      throws ApiException {

    String localVarPath = "/calling/v1/callouts";

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("Basic", "Signed");
    final String serializedBody = mapper.serialize(localVarContentTypes, calloutRequestInternal);

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
