/*
 * Voice API | Sinch
 * The Voice API exposes calling- and conference-related functionality in the Sinch Voice Platform.
 *
 * The version of the OpenAPI document: 1.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.voice.adapters.api.v1;

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
import com.sinch.sdk.domains.voice.models.dto.v1.GetCallbacksDto;
import com.sinch.sdk.domains.voice.models.dto.v1.GetNumbersResponseObjDto;
import com.sinch.sdk.domains.voice.models.dto.v1.GetQueryNumberDto;
import com.sinch.sdk.domains.voice.models.dto.v1.UnassignNumbersDto;
import com.sinch.sdk.domains.voice.models.dto.v1.UpdateCallbacksDto;
import com.sinch.sdk.domains.voice.models.dto.v1.UpdateNumbersDto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ApplicationsApi {

  private static final Logger LOGGER = Logger.getLogger(ApplicationsApi.class.getName());
  private HttpClient httpClient;
  private ServerConfiguration serverConfiguration;
  private Map<String, AuthManager> authManagersByOasSecuritySchemes;
  private HttpMapper mapper;

  public ApplicationsApi(
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
   * Query number Returns information about the requested number.
   *
   * @param number The phone number you want to query. (required)
   * @return GetQueryNumberDto
   * @throws ApiException if fails to make API call
   */
  public GetQueryNumberDto callingQueryNumber(String number) throws ApiException {

    LOGGER.finest("[callingQueryNumber]" + " " + "number: " + number);

    HttpRequest httpRequest = callingQueryNumberRequestBuilder(number);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<GetQueryNumberDto> localVarReturnType =
          new TypeReference<GetQueryNumberDto>() {};
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

  private HttpRequest callingQueryNumberRequestBuilder(String number) throws ApiException {
    // verify the required parameter 'number' is set
    if (number == null) {
      throw new ApiException(
          400, "Missing the required parameter 'number' when calling callingQueryNumber");
    }

    String localVarPath =
        "/v1/calling/query/number/{number}"
            .replaceAll(
                "\\{" + "number" + "\\}", URLPathUtils.encodePathSegment(number.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList();

    final Collection<String> localVarAuthNames = Arrays.asList("Basic", "Signed");
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

  /**
   * Get Callback URLs Returns any callback URLs configured for the specified application.
   *
   * @param applicationkey The unique identifying key of the application. (required)
   * @return GetCallbacksDto
   * @throws ApiException if fails to make API call
   */
  public GetCallbacksDto configurationGetCallbackURLs(String applicationkey) throws ApiException {

    LOGGER.finest("[configurationGetCallbackURLs]" + " " + "applicationkey: " + applicationkey);

    HttpRequest httpRequest = configurationGetCallbackURLsRequestBuilder(applicationkey);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<GetCallbacksDto> localVarReturnType = new TypeReference<GetCallbacksDto>() {};
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

  private HttpRequest configurationGetCallbackURLsRequestBuilder(String applicationkey)
      throws ApiException {
    // verify the required parameter 'applicationkey' is set
    if (applicationkey == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'applicationkey' when calling"
              + " configurationGetCallbackURLs");
    }

    String localVarPath =
        "/v1/configuration/callbacks/applications/{applicationkey}"
            .replaceAll(
                "\\{" + "applicationkey" + "\\}",
                URLPathUtils.encodePathSegment(applicationkey.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList();

    final Collection<String> localVarAuthNames = Arrays.asList("Basic", "Signed");
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

  /**
   * Get Numbers Get information about your numbers. It returns a list of numbers that you own, as
   * well as their capability (voice or SMS). For the ones that are assigned to an app, it returns
   * the application key of the app.
   *
   * @return GetNumbersResponseObjDto
   * @throws ApiException if fails to make API call
   */
  public GetNumbersResponseObjDto configurationGetNumbers() throws ApiException {

    LOGGER.finest("[configurationGetNumbers]");

    HttpRequest httpRequest = configurationGetNumbersRequestBuilder();
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<GetNumbersResponseObjDto> localVarReturnType =
          new TypeReference<GetNumbersResponseObjDto>() {};
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

  private HttpRequest configurationGetNumbersRequestBuilder() throws ApiException {

    String localVarPath = "/v1/configuration/numbers";

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList();

    final Collection<String> localVarAuthNames = Arrays.asList("Basic", "Signed");
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

  /**
   * Un-assign number Un-assign a number from an application.
   *
   * @param unassignNumbersDto (optional)
   * @throws ApiException if fails to make API call
   */
  public void configurationUnassignNumber(UnassignNumbersDto unassignNumbersDto)
      throws ApiException {

    LOGGER.finest(
        "[configurationUnassignNumber]" + " " + "unassignNumbersDto: " + unassignNumbersDto);

    HttpRequest httpRequest = configurationUnassignNumberRequestBuilder(unassignNumbersDto);
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

  private HttpRequest configurationUnassignNumberRequestBuilder(
      UnassignNumbersDto unassignNumbersDto) throws ApiException {

    String localVarPath = "/v1/configuration/numbers";

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList();

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("Basic", "Signed");
    final String serializedBody = mapper.serialize(localVarContentTypes, unassignNumbersDto);

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

  /**
   * Update Callbacks Update the configured callback URLs for the specified application.
   *
   * @param applicationkey The unique identifying key of the application. (required)
   * @param updateCallbacksDto (optional)
   * @throws ApiException if fails to make API call
   */
  public void configurationUpdateCallbackURLs(
      String applicationkey, UpdateCallbacksDto updateCallbacksDto) throws ApiException {

    LOGGER.finest(
        "[configurationUpdateCallbackURLs]"
            + " "
            + "applicationkey: "
            + applicationkey
            + ", "
            + "updateCallbacksDto: "
            + updateCallbacksDto);

    HttpRequest httpRequest =
        configurationUpdateCallbackURLsRequestBuilder(applicationkey, updateCallbacksDto);
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

  private HttpRequest configurationUpdateCallbackURLsRequestBuilder(
      String applicationkey, UpdateCallbacksDto updateCallbacksDto) throws ApiException {
    // verify the required parameter 'applicationkey' is set
    if (applicationkey == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'applicationkey' when calling"
              + " configurationUpdateCallbackURLs");
    }

    String localVarPath =
        "/v1/configuration/callbacks/applications/{applicationkey}"
            .replaceAll(
                "\\{" + "applicationkey" + "\\}",
                URLPathUtils.encodePathSegment(applicationkey.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList();

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("Basic", "Signed");
    final String serializedBody = mapper.serialize(localVarContentTypes, updateCallbacksDto);

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

  /**
   * Update Numbers Assign a number or a list of numbers to an application.
   *
   * @param updateNumbersDto (optional)
   * @throws ApiException if fails to make API call
   */
  public void configurationUpdateNumbers(UpdateNumbersDto updateNumbersDto) throws ApiException {

    LOGGER.finest("[configurationUpdateNumbers]" + " " + "updateNumbersDto: " + updateNumbersDto);

    HttpRequest httpRequest = configurationUpdateNumbersRequestBuilder(updateNumbersDto);
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

  private HttpRequest configurationUpdateNumbersRequestBuilder(UpdateNumbersDto updateNumbersDto)
      throws ApiException {

    String localVarPath = "/v1/configuration/numbers";

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList();

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("Basic", "Signed");
    final String serializedBody = mapper.serialize(localVarContentTypes, updateNumbersDto);

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
