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
import com.sinch.sdk.domains.voice.models.dto.v1.CalloutRequestDto;
import com.sinch.sdk.domains.voice.models.dto.v1.GetCalloutResponseObjDto;
import com.sinch.sdk.domains.voice.models.dto.v1.GetConferenceInfoResponseDto;
import com.sinch.sdk.domains.voice.models.dto.v1.ManageConferenceParticipantRequestDto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ConferencesApi {

  private static final Logger LOGGER = Logger.getLogger(ConferencesApi.class.getName());
  private HttpClient httpClient;
  private ServerConfiguration serverConfiguration;
  private Map<String, AuthManager> authManagersByOasSecuritySchemes;
  private HttpMapper mapper;

  public ConferencesApi(
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
   * Get Conference Info Returns information about a conference that matches the provided conference
   * ID.
   *
   * @param conferenceId The unique identifier of the conference. The user sets this value.
   *     (required)
   * @return GetConferenceInfoResponseDto
   * @throws ApiException if fails to make API call
   */
  public GetConferenceInfoResponseDto callingGetConferenceInfo(String conferenceId)
      throws ApiException {

    LOGGER.finest("[callingGetConferenceInfo]" + " " + "conferenceId: " + conferenceId);

    HttpRequest httpRequest = callingGetConferenceInfoRequestBuilder(conferenceId);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<GetConferenceInfoResponseDto> localVarReturnType =
          new TypeReference<GetConferenceInfoResponseDto>() {};
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

  private HttpRequest callingGetConferenceInfoRequestBuilder(String conferenceId)
      throws ApiException {
    // verify the required parameter 'conferenceId' is set
    if (conferenceId == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'conferenceId' when calling callingGetConferenceInfo");
    }

    String localVarPath =
        "/calling/v1/conferences/id/{conferenceId}"
            .replaceAll(
                "\\{" + "conferenceId" + "\\}",
                URLPathUtils.encodePathSegment(conferenceId.toString()));

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
   * Kick Conference All Removes all participants from a conference.
   *
   * @param conferenceId The unique identifier of the conference. The user sets this value.
   *     (required)
   * @throws ApiException if fails to make API call
   */
  public void callingKickConferenceAll(String conferenceId) throws ApiException {

    LOGGER.finest("[callingKickConferenceAll]" + " " + "conferenceId: " + conferenceId);

    HttpRequest httpRequest = callingKickConferenceAllRequestBuilder(conferenceId);
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

  private HttpRequest callingKickConferenceAllRequestBuilder(String conferenceId)
      throws ApiException {
    // verify the required parameter 'conferenceId' is set
    if (conferenceId == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'conferenceId' when calling callingKickConferenceAll");
    }

    String localVarPath =
        "/calling/v1/conferences/id/{conferenceId}"
            .replaceAll(
                "\\{" + "conferenceId" + "\\}",
                URLPathUtils.encodePathSegment(conferenceId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList();

    final Collection<String> localVarContentTypes = Arrays.asList();

    final Collection<String> localVarAuthNames = Arrays.asList("Basic", "Signed");
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

  /**
   * Kick Conference Participant Remove a specified conference participant from a specified
   * conference.
   *
   * @param callId The unique identifier of the call. This value is generated by the system.
   *     (required)
   * @param conferenceId The unique identifier of the conference. The user sets this value.
   *     (required)
   * @throws ApiException if fails to make API call
   */
  public void callingKickConferenceParticipant(String callId, String conferenceId)
      throws ApiException {

    LOGGER.finest(
        "[callingKickConferenceParticipant]"
            + " "
            + "callId: "
            + callId
            + ", "
            + "conferenceId: "
            + conferenceId);

    HttpRequest httpRequest = callingKickConferenceParticipantRequestBuilder(callId, conferenceId);
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

  private HttpRequest callingKickConferenceParticipantRequestBuilder(
      String callId, String conferenceId) throws ApiException {
    // verify the required parameter 'callId' is set
    if (callId == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'callId' when calling callingKickConferenceParticipant");
    }
    // verify the required parameter 'conferenceId' is set
    if (conferenceId == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'conferenceId' when calling"
              + " callingKickConferenceParticipant");
    }

    String localVarPath =
        "/calling/v1/conferences/id/{conferenceId}/{callId}"
            .replaceAll("\\{" + "callId" + "\\}", URLPathUtils.encodePathSegment(callId.toString()))
            .replaceAll(
                "\\{" + "conferenceId" + "\\}",
                URLPathUtils.encodePathSegment(conferenceId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList();

    final Collection<String> localVarAuthNames = Arrays.asList("Basic", "Signed");
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

  /**
   * Manage Conference Participant Manages conference participant in a specified conference: * mute
   * / unmute * put on hold / resume.
   *
   * @param callId The unique identifier of the call. This value is generated by the system.
   *     (required)
   * @param conferenceId The unique identifier of the conference. The user sets this value.
   *     (required)
   * @param manageConferenceParticipantRequestDto (optional)
   * @throws ApiException if fails to make API call
   */
  public void callingManageConferenceParticipant(
      String callId,
      String conferenceId,
      ManageConferenceParticipantRequestDto manageConferenceParticipantRequestDto)
      throws ApiException {

    LOGGER.finest(
        "[callingManageConferenceParticipant]"
            + " "
            + "callId: "
            + callId
            + ", "
            + "conferenceId: "
            + conferenceId
            + ", "
            + "manageConferenceParticipantRequestDto: "
            + manageConferenceParticipantRequestDto);

    HttpRequest httpRequest =
        callingManageConferenceParticipantRequestBuilder(
            callId, conferenceId, manageConferenceParticipantRequestDto);
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

  private HttpRequest callingManageConferenceParticipantRequestBuilder(
      String callId,
      String conferenceId,
      ManageConferenceParticipantRequestDto manageConferenceParticipantRequestDto)
      throws ApiException {
    // verify the required parameter 'callId' is set
    if (callId == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'callId' when calling"
              + " callingManageConferenceParticipant");
    }
    // verify the required parameter 'conferenceId' is set
    if (conferenceId == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'conferenceId' when calling"
              + " callingManageConferenceParticipant");
    }

    String localVarPath =
        "/calling/v1/conferences/id/{conferenceId}/{callId}"
            .replaceAll("\\{" + "callId" + "\\}", URLPathUtils.encodePathSegment(callId.toString()))
            .replaceAll(
                "\\{" + "conferenceId" + "\\}",
                URLPathUtils.encodePathSegment(conferenceId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("Basic", "Signed");
    final String serializedBody =
        mapper.serialize(localVarContentTypes, manageConferenceParticipantRequestDto);

    return new HttpRequest(
        localVarPath,
        HttpMethod.PATCH,
        localVarQueryParams,
        serializedBody,
        localVarHeaderParams,
        localVarAccepts,
        localVarContentTypes,
        localVarAuthNames);
  }

  /**
   * Callout Request Makes a call out to a phone number. The types of callouts currently supported
   * are conference callouts, text-to-speech callouts, and custom callouts. The custom callout is
   * the most flexible, but text-to-speech and conference callouts are more convenient.
   *
   * @param calloutRequestDto (optional)
   * @return GetCalloutResponseObjDto
   * @throws ApiException if fails to make API call
   */
  public GetCalloutResponseObjDto callouts(CalloutRequestDto calloutRequestDto)
      throws ApiException {

    LOGGER.finest("[callouts]" + " " + "calloutRequestDto: " + calloutRequestDto);

    HttpRequest httpRequest = calloutsRequestBuilder(calloutRequestDto);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<GetCalloutResponseObjDto> localVarReturnType =
          new TypeReference<GetCalloutResponseObjDto>() {};
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

  private HttpRequest calloutsRequestBuilder(CalloutRequestDto calloutRequestDto)
      throws ApiException {

    String localVarPath = "/calling/v1/callouts";

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("Basic", "Signed");
    final String serializedBody = mapper.serialize(localVarContentTypes, calloutRequestDto);

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
