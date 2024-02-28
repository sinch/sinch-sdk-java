/*
 * Conversation API | Sinch
 * Send and receive messages globally over SMS, RCS, WhatsApp, Viber Business, Facebook messenger and other popular channels using the Sinch Conversation API.  The Conversation API endpoint uses built-in transcoding to give you the power of conversation across all supported channels and, if required, full control over channel specific features.
 *
 * The version of the OpenAPI document: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.adapters.api.v1;

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
import com.sinch.sdk.domains.conversation.models.dto.v1.TranscodeMessageRequestDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.TranscodeMessageResponseDto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class TranscodingApi {

  private static final Logger LOGGER = Logger.getLogger(TranscodingApi.class.getName());
  private HttpClient httpClient;
  private ServerConfiguration serverConfiguration;
  private Map<String, AuthManager> authManagersByOasSecuritySchemes;
  private HttpMapper mapper;

  public TranscodingApi(
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
   * Transcode a message Transcodes the message from the Conversation API format to the
   * channel-specific formats for the requested channels. No message is sent to the contact.
   *
   * @param projectId The unique ID of the project. You can find this on the [Sinch
   *     Dashboard](https://dashboard.sinch.com/convapi/apps). (required)
   * @param transcodeMessageRequestDto The message to be transcoded, and the app and channels for
   *     which the message is to be transcoded. (required)
   * @return TranscodeMessageResponseDto
   * @throws ApiException if fails to make API call
   */
  public TranscodeMessageResponseDto transcodingTranscodeMessage(
      String projectId, TranscodeMessageRequestDto transcodeMessageRequestDto) throws ApiException {

    LOGGER.finest(
        "[transcodingTranscodeMessage]"
            + " "
            + "projectId: "
            + projectId
            + ", "
            + "transcodeMessageRequestDto: "
            + transcodeMessageRequestDto);

    HttpRequest httpRequest =
        transcodingTranscodeMessageRequestBuilder(projectId, transcodeMessageRequestDto);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<TranscodeMessageResponseDto> localVarReturnType =
          new TypeReference<TranscodeMessageResponseDto>() {};
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

  private HttpRequest transcodingTranscodeMessageRequestBuilder(
      String projectId, TranscodeMessageRequestDto transcodeMessageRequestDto) throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'projectId' when calling transcodingTranscodeMessage");
    }
    // verify the required parameter 'transcodeMessageRequestDto' is set
    if (transcodeMessageRequestDto == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'transcodeMessageRequestDto' when calling"
              + " transcodingTranscodeMessage");
    }

    String localVarPath =
        "/v1/projects/{project_id}/messages:transcode"
            .replaceAll(
                "\\{" + "project_id" + "\\}", URLPathUtils.encodePathSegment(projectId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("Basic", "oAuth2");
    final String serializedBody =
        mapper.serialize(localVarContentTypes, transcodeMessageRequestDto);

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