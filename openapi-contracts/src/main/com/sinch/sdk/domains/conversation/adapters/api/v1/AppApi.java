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
import com.sinch.sdk.domains.conversation.models.dto.v1.AppCreateRequestDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.AppResponseDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.AppUpdateRequestDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.ListAppsResponseDto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class AppApi {

  private static final Logger LOGGER = Logger.getLogger(AppApi.class.getName());
  private HttpClient httpClient;
  private ServerConfiguration serverConfiguration;
  private Map<String, AuthManager> authManagersByOasSecuritySchemes;
  private HttpMapper mapper;

  public AppApi(
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
   * Create an app You can create a new Conversation API app using the API. You can create an app
   * for one or more channels at once. The ID of the app is generated at creation and will be
   * returned in the response.
   *
   * @param projectId The unique ID of the project. You can find this on the [Sinch
   *     Dashboard](https://dashboard.sinch.com/convapi/apps). (required)
   * @param appCreateRequestDto The app to create. (required)
   * @return AppResponseDto
   * @throws ApiException if fails to make API call
   */
  public AppResponseDto appCreateApp(String projectId, AppCreateRequestDto appCreateRequestDto)
      throws ApiException {

    LOGGER.finest(
        "[appCreateApp]"
            + " "
            + "projectId: "
            + projectId
            + ", "
            + "appCreateRequestDto: "
            + appCreateRequestDto);

    HttpRequest httpRequest = appCreateAppRequestBuilder(projectId, appCreateRequestDto);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<AppResponseDto> localVarReturnType = new TypeReference<AppResponseDto>() {};
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

  private HttpRequest appCreateAppRequestBuilder(
      String projectId, AppCreateRequestDto appCreateRequestDto) throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'projectId' when calling appCreateApp");
    }
    // verify the required parameter 'appCreateRequestDto' is set
    if (appCreateRequestDto == null) {
      throw new ApiException(
          400, "Missing the required parameter 'appCreateRequestDto' when calling appCreateApp");
    }

    String localVarPath =
        "/v1/projects/{project_id}/apps"
            .replaceAll(
                "\\{" + "project_id" + "\\}", URLPathUtils.encodePathSegment(projectId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("Basic", "oAuth2");
    final String serializedBody = mapper.serialize(localVarContentTypes, appCreateRequestDto);

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
   * Delete an app Deletes the app specified by the App ID. Note that this operation will not delete
   * contacts (which are stored at the project level) nor any channel-specific resources (for
   * example, WhatsApp Sender Identities will not be deleted).
   *
   * @param projectId The unique ID of the project. You can find this on the [Sinch
   *     Dashboard](https://dashboard.sinch.com/convapi/apps). (required)
   * @param appId The unique ID of the app. You can find this on the [Sinch
   *     Dashboard](https://dashboard.sinch.com/convapi/apps). (required)
   * @return Object
   * @throws ApiException if fails to make API call
   */
  public Object appDeleteApp(String projectId, String appId) throws ApiException {

    LOGGER.finest("[appDeleteApp]" + " " + "projectId: " + projectId + ", " + "appId: " + appId);

    HttpRequest httpRequest = appDeleteAppRequestBuilder(projectId, appId);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
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

  private HttpRequest appDeleteAppRequestBuilder(String projectId, String appId)
      throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'projectId' when calling appDeleteApp");
    }
    // verify the required parameter 'appId' is set
    if (appId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'appId' when calling appDeleteApp");
    }

    String localVarPath =
        "/v1/projects/{project_id}/apps/{app_id}"
            .replaceAll(
                "\\{" + "project_id" + "\\}", URLPathUtils.encodePathSegment(projectId.toString()))
            .replaceAll("\\{" + "app_id" + "\\}", URLPathUtils.encodePathSegment(appId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList();

    final Collection<String> localVarAuthNames = Arrays.asList("Basic", "oAuth2");
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
   * Get an app Returns a particular app as specified by the App ID.
   *
   * @param projectId The unique ID of the project. You can find this on the [Sinch
   *     Dashboard](https://dashboard.sinch.com/convapi/apps). (required)
   * @param appId The unique ID of the app. You can find this on the [Sinch
   *     Dashboard](https://dashboard.sinch.com/convapi/apps). (required)
   * @return AppResponseDto
   * @throws ApiException if fails to make API call
   */
  public AppResponseDto appGetApp(String projectId, String appId) throws ApiException {

    LOGGER.finest("[appGetApp]" + " " + "projectId: " + projectId + ", " + "appId: " + appId);

    HttpRequest httpRequest = appGetAppRequestBuilder(projectId, appId);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<AppResponseDto> localVarReturnType = new TypeReference<AppResponseDto>() {};
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

  private HttpRequest appGetAppRequestBuilder(String projectId, String appId) throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'projectId' when calling appGetApp");
    }
    // verify the required parameter 'appId' is set
    if (appId == null) {
      throw new ApiException(400, "Missing the required parameter 'appId' when calling appGetApp");
    }

    String localVarPath =
        "/v1/projects/{project_id}/apps/{app_id}"
            .replaceAll(
                "\\{" + "project_id" + "\\}", URLPathUtils.encodePathSegment(projectId.toString()))
            .replaceAll("\\{" + "app_id" + "\\}", URLPathUtils.encodePathSegment(appId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList();

    final Collection<String> localVarAuthNames = Arrays.asList("Basic", "oAuth2");
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
   * List all apps for a given project Get a list of all apps in the specified project.
   *
   * @param projectId The unique ID of the project. You can find this on the [Sinch
   *     Dashboard](https://dashboard.sinch.com/convapi/apps). (required)
   * @return ListAppsResponseDto
   * @throws ApiException if fails to make API call
   */
  public ListAppsResponseDto appListApps(String projectId) throws ApiException {

    LOGGER.finest("[appListApps]" + " " + "projectId: " + projectId);

    HttpRequest httpRequest = appListAppsRequestBuilder(projectId);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<ListAppsResponseDto> localVarReturnType =
          new TypeReference<ListAppsResponseDto>() {};
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

  private HttpRequest appListAppsRequestBuilder(String projectId) throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'projectId' when calling appListApps");
    }

    String localVarPath =
        "/v1/projects/{project_id}/apps"
            .replaceAll(
                "\\{" + "project_id" + "\\}", URLPathUtils.encodePathSegment(projectId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList();

    final Collection<String> localVarAuthNames = Arrays.asList("Basic", "oAuth2");
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
   * Update an app Updates a particular app as specified by the App ID. Note that this is a
   * &#x60;PATCH&#x60; operation, so any specified field values will replace existing values.
   * Therefore, **if you&#39;d like to add additional configurations to an existing Conversation API
   * app, ensure that you include existing values AND new values in the call**. For example, if
   * you&#39;d like to add new &#x60;channel_credentials&#x60;, you can
   * [get](/docs/conversation/api-reference/conversation/tag/App/#tag/App/operation/App_GetApp) your
   * existing Conversation API app, extract the existing &#x60;channel_credentials&#x60; list,
   * append your new configuration to that list, and include the updated
   * &#x60;channel_credentials&#x60; list in this update call.
   *
   * @param projectId The unique ID of the project. You can find this on the [Sinch
   *     Dashboard](https://dashboard.sinch.com/convapi/apps). (required)
   * @param appId The unique ID of the app. You can find this on the [Sinch
   *     Dashboard](https://dashboard.sinch.com/convapi/apps). (required)
   * @param appUpdateRequestDto The updated app. (required)
   * @param updateMask The set of field mask paths. (optional
   * @return AppResponseDto
   * @throws ApiException if fails to make API call
   */
  public AppResponseDto appUpdateApp(
      String projectId,
      String appId,
      AppUpdateRequestDto appUpdateRequestDto,
      List<String> updateMask)
      throws ApiException {

    LOGGER.finest(
        "[appUpdateApp]"
            + " "
            + "projectId: "
            + projectId
            + ", "
            + "appId: "
            + appId
            + ", "
            + "appUpdateRequestDto: "
            + appUpdateRequestDto
            + ", "
            + "updateMask: "
            + updateMask);

    HttpRequest httpRequest =
        appUpdateAppRequestBuilder(projectId, appId, appUpdateRequestDto, updateMask);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<AppResponseDto> localVarReturnType = new TypeReference<AppResponseDto>() {};
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

  private HttpRequest appUpdateAppRequestBuilder(
      String projectId,
      String appId,
      AppUpdateRequestDto appUpdateRequestDto,
      List<String> updateMask)
      throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'projectId' when calling appUpdateApp");
    }
    // verify the required parameter 'appId' is set
    if (appId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'appId' when calling appUpdateApp");
    }
    // verify the required parameter 'appUpdateRequestDto' is set
    if (appUpdateRequestDto == null) {
      throw new ApiException(
          400, "Missing the required parameter 'appUpdateRequestDto' when calling appUpdateApp");
    }

    String localVarPath =
        "/v1/projects/{project_id}/apps/{app_id}"
            .replaceAll(
                "\\{" + "project_id" + "\\}", URLPathUtils.encodePathSegment(projectId.toString()))
            .replaceAll("\\{" + "app_id" + "\\}", URLPathUtils.encodePathSegment(appId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();
    if (null != updateMask) {
      localVarQueryParams.add(
          new URLParameter(
              "update_mask", updateMask, URLParameter.STYLE.valueOf("form".toUpperCase()), true));
    }

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("Basic", "oAuth2");
    final String serializedBody = mapper.serialize(localVarContentTypes, appUpdateRequestDto);

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
}
