/*
 * Verification | Sinch
 * Verify users with SMS, flash calls (missed calls), a regular call, or data verification.
 *
 * The version of the OpenAPI document: 2.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.verification.api.v1.internal;

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
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationRequestParameters;
import com.sinch.sdk.domains.verification.models.v1.start.response.internal.StartVerificationResponseInternal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class VerificationsStartApi {

  private static final Logger LOGGER = Logger.getLogger(VerificationsStartApi.class.getName());
  private HttpClient httpClient;
  private ServerConfiguration serverConfiguration;
  private Map<String, AuthManager> authManagersByOasSecuritySchemes;
  private HttpMapper mapper;

  public VerificationsStartApi(
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
   * Start verification This method is used by the mobile and web Verification SDKs to start a
   * verification. It can also be used to request a verification from your backend, by making an
   * request.
   *
   * @param startVerificationRequestParameters (required)
   * @param acceptLanguage In SMS Verification, value of
   *     [Accept-Language](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Accept-Language)
   *     header is used to determine the languge of an SMS message. (optional)
   * @return StartVerificationResponseInternal
   * @throws ApiException if fails to make API call
   */
  public StartVerificationResponseInternal startVerification(
      StartVerificationRequestParameters startVerificationRequestParameters, String acceptLanguage)
      throws ApiException {

    LOGGER.finest(
        "[startVerification]"
            + " "
            + "startVerificationRequestParameters: "
            + startVerificationRequestParameters
            + ", "
            + "acceptLanguage: "
            + acceptLanguage);

    HttpRequest httpRequest =
        startVerificationRequestBuilder(startVerificationRequestParameters, acceptLanguage);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<StartVerificationResponseInternal> localVarReturnType =
          new TypeReference<StartVerificationResponseInternal>() {};
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

  private HttpRequest startVerificationRequestBuilder(
      StartVerificationRequestParameters startVerificationRequestParameters, String acceptLanguage)
      throws ApiException {
    // verify the required parameter 'startVerificationRequestParameters' is set
    if (startVerificationRequestParameters == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'startVerificationRequestParameters' when calling"
              + " startVerification");
    }

    String localVarPath = "/verification/v1/verifications";

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();
    if (acceptLanguage != null) localVarHeaderParams.put("Accept-Language", acceptLanguage);

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("Basic", "Application");
    final String serializedBody =
        mapper.serialize(localVarContentTypes, startVerificationRequestParameters);

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
