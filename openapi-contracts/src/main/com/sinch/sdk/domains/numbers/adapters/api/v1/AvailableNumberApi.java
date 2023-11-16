/*
 * Numbers | Sinch
 * An API service for getting, listing and managing Sinch virtual numbers.
 *
 * The version of the OpenAPI document: 1.0
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.numbers.adapters.api.v1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.exceptions.ApiExceptionBuilder;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.http.HttpStatus;
import com.sinch.sdk.core.http.URLParameter;
import com.sinch.sdk.core.http.URLParameterUtils;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.numbers.models.dto.v1.ActiveNumberDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.AvailableNumberDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.AvailableNumbersResponseDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.RentAnyNumberRequestDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.RentNumberRequestDto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

// @javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class AvailableNumberApi {

  private static final Logger LOGGER = Logger.getLogger(AvailableNumberApi.class.getName());
  private HttpClient httpClient;
  private ServerConfiguration serverConfiguration;
  private HttpMapper mapper;

  public AvailableNumberApi(
      HttpClient httpClient, ServerConfiguration serverConfiguration, HttpMapper mapper) {
    this.httpClient = httpClient;
    this.serverConfiguration = serverConfiguration;
    this.mapper = mapper;
  }

  /**
   * Get available number This endpoint allows you to enter a specific phone number to check if
   * it&#39;s available for use. A 200 response will return the number&#39;s capability, setup
   * costs, monthly costs and if supporting documentation is required.
   *
   * @param projectId Found on your &lt;a
   *     href&#x3D;\&quot;https://dashboard.sinch.com/settings/project-management\&quot;
   *     target&#x3D;\&quot;_blank\&quot;&gt;Sinch Customer Dashboard&lt;/a&gt;. (required)
   * @param phoneNumber Output only. The phone number in &lt;a
   *     href&#x3D;\&quot;https://community.sinch.com/t5/Glossary/E-164/ta-p/7537\&quot;
   *     target&#x3D;\&quot;_blank\&quot;&gt;E.164&lt;/a&gt; format with leading &#x60;+&#x60;.
   *     (required)
   * @return AvailableNumberDto
   * @throws ApiException if fails to make API call
   */
  public AvailableNumberDto numberServiceGetAvailableNumber(String projectId, String phoneNumber)
      throws ApiException {

    LOGGER.finest(
        "[numberServiceGetAvailableNumber] "
            + "projectId: "
            + projectId
            + ", "
            + "phoneNumber: "
            + phoneNumber);

    HttpRequest httpRequest = numberServiceGetAvailableNumberRequestBuilder(projectId, phoneNumber);
    HttpResponse response = httpClient.invokeAPI(this.serverConfiguration, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<AvailableNumberDto> localVarReturnType =
          new TypeReference<AvailableNumberDto>() {};
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

  private HttpRequest numberServiceGetAvailableNumberRequestBuilder(
      String projectId, String phoneNumber) throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'projectId' when calling"
              + " numberServiceGetAvailableNumber");
    }
    // verify the required parameter 'phoneNumber' is set
    if (phoneNumber == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'phoneNumber' when calling"
              + " numberServiceGetAvailableNumber");
    }

    String localVarPath =
        "/v1/projects/{projectId}/availableNumbers/{phoneNumber}"
            .replaceAll(
                "\\{" + "projectId" + "\\}",
                URLParameterUtils.encodeParameterValue(projectId.toString()))
            .replaceAll(
                "\\{" + "phoneNumber" + "\\}",
                URLParameterUtils.encodeParameterValue(phoneNumber.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

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
  /**
   * List available numbers Search for virtual numbers that are available for you to activate. You
   * can filter by any property on the available number resource.
   *
   * @param projectId Found on your &lt;a
   *     href&#x3D;\&quot;https://dashboard.sinch.com/settings/project-management\&quot;
   *     target&#x3D;\&quot;_blank\&quot;&gt;Sinch Customer Dashboard&lt;/a&gt;. (required)
   * @param regionCode Region code to filter by. ISO 3166-1 alpha-2 country code of the phone
   *     number. Example: &#x60;US&#x60;, &#x60;GB&#x60; or &#x60;SE&#x60;. (required)
   * @param type Number type to filter by. Options include, &#x60;MOBILE&#x60;, &#x60;LOCAL&#x60; or
   *     &#x60;TOLL_FREE&#x60;. (required)
   * @param numberPatternPattern Sequence of digits to search for. If you prefer or need certain
   *     digits in sequential order, you can enter the sequence of numbers here. For example,
   *     &#x60;2020&#x60;. (optional)
   * @param numberPatternSearchPattern Search pattern to apply. The options are, &#x60;START&#x60;,
   *     &#x60;CONTAIN&#x60;, and &#x60;END&#x60;. (optional)
   * @param capabilities Number capabilities to filter by SMS and/or VOICE. When searching, indicate
   *     the &#x60;capabilities&#x60; of the number as &#x60;SMS&#x60; and/or &#x60;VOICE&#x60;. To
   *     search for a number capable of both, list both &#x60;SMS&#x60; and &#x60;VOICE&#x60;.
   *     (optional
   * @param size Optional. The maximum number of items to return. (optional)
   * @return AvailableNumbersResponseDto
   * @throws ApiException if fails to make API call
   */
  public AvailableNumbersResponseDto numberServiceListAvailableNumbers(
      String projectId,
      String regionCode,
      String type,
      String numberPatternPattern,
      String numberPatternSearchPattern,
      List<String> capabilities,
      Integer size)
      throws ApiException {

    LOGGER.finest(
        "[numberServiceListAvailableNumbers] "
            + "projectId: "
            + projectId
            + ", "
            + "regionCode: "
            + regionCode
            + ", "
            + "type: "
            + type
            + ", "
            + "numberPatternPattern: "
            + numberPatternPattern
            + ", "
            + "numberPatternSearchPattern: "
            + numberPatternSearchPattern
            + ", "
            + "capabilities: "
            + capabilities
            + ", "
            + "size: "
            + size);

    HttpRequest httpRequest =
        numberServiceListAvailableNumbersRequestBuilder(
            projectId,
            regionCode,
            type,
            numberPatternPattern,
            numberPatternSearchPattern,
            capabilities,
            size);
    HttpResponse response = httpClient.invokeAPI(this.serverConfiguration, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<AvailableNumbersResponseDto> localVarReturnType =
          new TypeReference<AvailableNumbersResponseDto>() {};
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

  private HttpRequest numberServiceListAvailableNumbersRequestBuilder(
      String projectId,
      String regionCode,
      String type,
      String numberPatternPattern,
      String numberPatternSearchPattern,
      List<String> capabilities,
      Integer size)
      throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'projectId' when calling"
              + " numberServiceListAvailableNumbers");
    }
    // verify the required parameter 'regionCode' is set
    if (regionCode == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'regionCode' when calling"
              + " numberServiceListAvailableNumbers");
    }
    // verify the required parameter 'type' is set
    if (type == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'type' when calling numberServiceListAvailableNumbers");
    }

    String localVarPath =
        "/v1/projects/{projectId}/availableNumbers"
            .replaceAll(
                "\\{" + "projectId" + "\\}",
                URLParameterUtils.encodeParameterValue(projectId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();
    if (null != numberPatternPattern) {
      localVarQueryParams.add(
          new URLParameter(
              "numberPattern.pattern",
              numberPatternPattern,
              URLParameter.STYLE.valueOf("form".toUpperCase()),
              true));
    }
    if (null != numberPatternSearchPattern) {
      localVarQueryParams.add(
          new URLParameter(
              "numberPattern.searchPattern",
              numberPatternSearchPattern,
              URLParameter.STYLE.valueOf("form".toUpperCase()),
              true));
    }
    if (null != regionCode) {
      localVarQueryParams.add(
          new URLParameter(
              "regionCode", regionCode, URLParameter.STYLE.valueOf("form".toUpperCase()), true));
    }
    if (null != type) {
      localVarQueryParams.add(
          new URLParameter("type", type, URLParameter.STYLE.valueOf("form".toUpperCase()), true));
    }
    if (null != capabilities) {
      localVarQueryParams.add(
          new URLParameter(
              "capabilities",
              capabilities,
              URLParameter.STYLE.valueOf("form".toUpperCase()),
              true));
    }
    if (null != size) {
      localVarQueryParams.add(
          new URLParameter("size", size, URLParameter.STYLE.valueOf("form".toUpperCase()), true));
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
  /**
   * Rent any number that matches the criteria Search for and activate an available Sinch virtual
   * number all in one API call. Currently the rentAny operation works only for US 10DLC numbers
   *
   * @param projectId Found on your &lt;a
   *     href&#x3D;\&quot;https://dashboard.sinch.com/settings/project-management\&quot;
   *     target&#x3D;\&quot;_blank\&quot;&gt;Sinch Customer Dashboard&lt;/a&gt;. (required)
   * @param rentAnyNumberRequestDto The request to search and rent a number that matches the
   *     criteria. (required)
   * @return ActiveNumberDto
   * @throws ApiException if fails to make API call
   */
  public ActiveNumberDto numberServiceRentAnyNumber(
      String projectId, RentAnyNumberRequestDto rentAnyNumberRequestDto) throws ApiException {

    LOGGER.finest(
        "[numberServiceRentAnyNumber] "
            + "projectId: "
            + projectId
            + ", "
            + "rentAnyNumberRequestDto: "
            + rentAnyNumberRequestDto);

    HttpRequest httpRequest =
        numberServiceRentAnyNumberRequestBuilder(projectId, rentAnyNumberRequestDto);
    HttpResponse response = httpClient.invokeAPI(this.serverConfiguration, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<ActiveNumberDto> localVarReturnType = new TypeReference<ActiveNumberDto>() {};
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

  private HttpRequest numberServiceRentAnyNumberRequestBuilder(
      String projectId, RentAnyNumberRequestDto rentAnyNumberRequestDto) throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'projectId' when calling numberServiceRentAnyNumber");
    }
    // verify the required parameter 'rentAnyNumberRequestDto' is set
    if (rentAnyNumberRequestDto == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'rentAnyNumberRequestDto' when calling"
              + " numberServiceRentAnyNumber");
    }

    String localVarPath =
        "/v1/projects/{projectId}/availableNumbers:rentAny"
            .replaceAll(
                "\\{" + "projectId" + "\\}",
                URLParameterUtils.encodeParameterValue(projectId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("BasicAuth");
    final String serializedBody = mapper.serialize(localVarContentTypes, rentAnyNumberRequestDto);

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
   * Rent an available number Activate a virtual number to use with SMS products, Voice products, or
   * both. You&#39;ll use &#x60;smsConfiguration&#x60; to setup your number for SMS and
   * &#x60;voiceConfiguration&#x60; for Voice.
   *
   * @param projectId Found on your &lt;a
   *     href&#x3D;\&quot;https://dashboard.sinch.com/settings/project-management\&quot;
   *     target&#x3D;\&quot;_blank\&quot;&gt;Sinch Customer Dashboard&lt;/a&gt;. (required)
   * @param phoneNumber Output only. The phone number in &lt;a
   *     href&#x3D;\&quot;https://community.sinch.com/t5/Glossary/E-164/ta-p/7537\&quot;
   *     target&#x3D;\&quot;_blank\&quot;&gt;E.164&lt;/a&gt; format with leading &#x60;+&#x60;.
   *     (required)
   * @param rentNumberRequestDto The request to rent a number. (required)
   * @return ActiveNumberDto
   * @throws ApiException if fails to make API call
   */
  public ActiveNumberDto numberServiceRentNumber(
      String projectId, String phoneNumber, RentNumberRequestDto rentNumberRequestDto)
      throws ApiException {

    LOGGER.finest(
        "[numberServiceRentNumber] "
            + "projectId: "
            + projectId
            + ", "
            + "phoneNumber: "
            + phoneNumber
            + ", "
            + "rentNumberRequestDto: "
            + rentNumberRequestDto);

    HttpRequest httpRequest =
        numberServiceRentNumberRequestBuilder(projectId, phoneNumber, rentNumberRequestDto);
    HttpResponse response = httpClient.invokeAPI(this.serverConfiguration, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<ActiveNumberDto> localVarReturnType = new TypeReference<ActiveNumberDto>() {};
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

  private HttpRequest numberServiceRentNumberRequestBuilder(
      String projectId, String phoneNumber, RentNumberRequestDto rentNumberRequestDto)
      throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'projectId' when calling numberServiceRentNumber");
    }
    // verify the required parameter 'phoneNumber' is set
    if (phoneNumber == null) {
      throw new ApiException(
          400, "Missing the required parameter 'phoneNumber' when calling numberServiceRentNumber");
    }
    // verify the required parameter 'rentNumberRequestDto' is set
    if (rentNumberRequestDto == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'rentNumberRequestDto' when calling"
              + " numberServiceRentNumber");
    }

    String localVarPath =
        "/v1/projects/{projectId}/availableNumbers/{phoneNumber}:rent"
            .replaceAll(
                "\\{" + "projectId" + "\\}",
                URLParameterUtils.encodeParameterValue(projectId.toString()))
            .replaceAll(
                "\\{" + "phoneNumber" + "\\}",
                URLParameterUtils.encodeParameterValue(phoneNumber.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("BasicAuth");
    final String serializedBody = mapper.serialize(localVarContentTypes, rentNumberRequestDto);

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
