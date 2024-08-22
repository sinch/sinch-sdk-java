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

package com.sinch.sdk.domains.conversation.api.v1.internal;

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
import com.sinch.sdk.domains.conversation.models.v1.webhooks.Webhook;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.response.ListWebhooksResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class WebhooksApi {

  private static final Logger LOGGER = Logger.getLogger(WebhooksApi.class.getName());
  private HttpClient httpClient;
  private ServerConfiguration serverConfiguration;
  private Map<String, AuthManager> authManagersByOasSecuritySchemes;
  private HttpMapper mapper;

  public WebhooksApi(
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
   * Create a new webhook Creates a webhook for receiving callbacks on specific triggers. You can
   * create up to 5 webhooks per app.
   *
   * @param projectId The unique ID of the project. You can find this on the [Sinch
   *     Dashboard](https://dashboard.sinch.com/convapi/apps). (required)
   * @param webhook Required. The Webhook to create (required)
   * @return Webhook
   * @throws ApiException if fails to make API call
   */
  public Webhook webhooksCreateWebhook(String projectId, Webhook webhook) throws ApiException {

    LOGGER.finest(
        "[webhooksCreateWebhook]" + " " + "projectId: " + projectId + ", " + "webhook: " + webhook);

    HttpRequest httpRequest = webhooksCreateWebhookRequestBuilder(projectId, webhook);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<Webhook> localVarReturnType = new TypeReference<Webhook>() {};
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

  private HttpRequest webhooksCreateWebhookRequestBuilder(String projectId, Webhook webhook)
      throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'projectId' when calling webhooksCreateWebhook");
    }
    // verify the required parameter 'webhook' is set
    if (webhook == null) {
      throw new ApiException(
          400, "Missing the required parameter 'webhook' when calling webhooksCreateWebhook");
    }

    String localVarPath =
        "/v1/projects/{project_id}/webhooks"
            .replaceAll(
                "\\{" + "project_id" + "\\}", URLPathUtils.encodePathSegment(projectId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("Basic", "oAuth2");
    final String serializedBody = mapper.serialize(localVarContentTypes, webhook);

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
   * Delete an existing webhook Deletes a webhook as specified by the webhook ID.
   *
   * @param projectId The unique ID of the project. You can find this on the [Sinch
   *     Dashboard](https://dashboard.sinch.com/convapi/apps). (required)
   * @param webhookId The unique ID of the webhook. (required)
   * @throws ApiException if fails to make API call
   */
  public void webhooksDeleteWebhook(String projectId, String webhookId) throws ApiException {

    LOGGER.finest(
        "[webhooksDeleteWebhook]"
            + " "
            + "projectId: "
            + projectId
            + ", "
            + "webhookId: "
            + webhookId);

    HttpRequest httpRequest = webhooksDeleteWebhookRequestBuilder(projectId, webhookId);
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

  private HttpRequest webhooksDeleteWebhookRequestBuilder(String projectId, String webhookId)
      throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'projectId' when calling webhooksDeleteWebhook");
    }
    // verify the required parameter 'webhookId' is set
    if (webhookId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'webhookId' when calling webhooksDeleteWebhook");
    }

    String localVarPath =
        "/v1/projects/{project_id}/webhooks/{webhook_id}"
            .replaceAll(
                "\\{" + "project_id" + "\\}", URLPathUtils.encodePathSegment(projectId.toString()))
            .replaceAll(
                "\\{" + "webhook_id" + "\\}", URLPathUtils.encodePathSegment(webhookId.toString()));

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
   * Get a webhook Get a webhook as specified by the webhook ID.
   *
   * @param projectId The unique ID of the project. You can find this on the [Sinch
   *     Dashboard](https://dashboard.sinch.com/convapi/apps). (required)
   * @param webhookId The unique ID of the webhook. (required)
   * @return Webhook
   * @throws ApiException if fails to make API call
   */
  public Webhook webhooksGetWebhook(String projectId, String webhookId) throws ApiException {

    LOGGER.finest(
        "[webhooksGetWebhook]"
            + " "
            + "projectId: "
            + projectId
            + ", "
            + "webhookId: "
            + webhookId);

    HttpRequest httpRequest = webhooksGetWebhookRequestBuilder(projectId, webhookId);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<Webhook> localVarReturnType = new TypeReference<Webhook>() {};
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

  private HttpRequest webhooksGetWebhookRequestBuilder(String projectId, String webhookId)
      throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'projectId' when calling webhooksGetWebhook");
    }
    // verify the required parameter 'webhookId' is set
    if (webhookId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'webhookId' when calling webhooksGetWebhook");
    }

    String localVarPath =
        "/v1/projects/{project_id}/webhooks/{webhook_id}"
            .replaceAll(
                "\\{" + "project_id" + "\\}", URLPathUtils.encodePathSegment(projectId.toString()))
            .replaceAll(
                "\\{" + "webhook_id" + "\\}", URLPathUtils.encodePathSegment(webhookId.toString()));

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
   * List webhooks List all webhooks for a given app as specified by the App ID.
   *
   * @param projectId The unique ID of the project. You can find this on the [Sinch
   *     Dashboard](https://dashboard.sinch.com/convapi/apps). (required)
   * @param appId The unique ID of the app. You can find this on the [Sinch
   *     Dashboard](https://dashboard.sinch.com/convapi/apps). (required)
   * @return ListWebhooksResponse
   * @throws ApiException if fails to make API call
   */
  public ListWebhooksResponse webhooksListWebhooks(String projectId, String appId)
      throws ApiException {

    LOGGER.finest(
        "[webhooksListWebhooks]" + " " + "projectId: " + projectId + ", " + "appId: " + appId);

    HttpRequest httpRequest = webhooksListWebhooksRequestBuilder(projectId, appId);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<ListWebhooksResponse> localVarReturnType =
          new TypeReference<ListWebhooksResponse>() {};
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

  private HttpRequest webhooksListWebhooksRequestBuilder(String projectId, String appId)
      throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'projectId' when calling webhooksListWebhooks");
    }
    // verify the required parameter 'appId' is set
    if (appId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'appId' when calling webhooksListWebhooks");
    }

    String localVarPath =
        "/v1/projects/{project_id}/apps/{app_id}/webhooks"
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
   * Update an existing webhook Updates an existing webhook as specified by the webhook ID.
   *
   * @param projectId The unique ID of the project. You can find this on the [Sinch
   *     Dashboard](https://dashboard.sinch.com/convapi/apps). (required)
   * @param webhookId The unique ID of the webhook. (required)
   * @param webhook Required. The Webhook to update (required)
   * @param updateMask The set of field mask paths. (optional
   * @return Webhook
   * @throws ApiException if fails to make API call
   */
  public Webhook webhooksUpdateWebhook(
      String projectId, String webhookId, Webhook webhook, List<String> updateMask)
      throws ApiException {

    LOGGER.finest(
        "[webhooksUpdateWebhook]"
            + " "
            + "projectId: "
            + projectId
            + ", "
            + "webhookId: "
            + webhookId
            + ", "
            + "webhook: "
            + webhook
            + ", "
            + "updateMask: "
            + updateMask);

    HttpRequest httpRequest =
        webhooksUpdateWebhookRequestBuilder(projectId, webhookId, webhook, updateMask);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<Webhook> localVarReturnType = new TypeReference<Webhook>() {};
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

  private HttpRequest webhooksUpdateWebhookRequestBuilder(
      String projectId, String webhookId, Webhook webhook, List<String> updateMask)
      throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'projectId' when calling webhooksUpdateWebhook");
    }
    // verify the required parameter 'webhookId' is set
    if (webhookId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'webhookId' when calling webhooksUpdateWebhook");
    }
    // verify the required parameter 'webhook' is set
    if (webhook == null) {
      throw new ApiException(
          400, "Missing the required parameter 'webhook' when calling webhooksUpdateWebhook");
    }

    String localVarPath =
        "/v1/projects/{project_id}/webhooks/{webhook_id}"
            .replaceAll(
                "\\{" + "project_id" + "\\}", URLPathUtils.encodePathSegment(projectId.toString()))
            .replaceAll(
                "\\{" + "webhook_id" + "\\}", URLPathUtils.encodePathSegment(webhookId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();
    if (null != updateMask) {
      localVarQueryParams.add(
          new URLParameter(
              "update_mask", updateMask, URLParameter.STYLE.valueOf("form".toUpperCase()), false));
    }

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("Basic", "oAuth2");
    final String serializedBody = mapper.serialize(localVarContentTypes, webhook);

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
