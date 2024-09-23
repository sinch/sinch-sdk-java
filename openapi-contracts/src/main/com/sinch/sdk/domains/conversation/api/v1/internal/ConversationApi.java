/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
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
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.conversation.Conversation;
import com.sinch.sdk.domains.conversation.models.v1.conversation.internal.ListConversationsResponseInternal;
import com.sinch.sdk.domains.conversation.models.v1.conversation.internal.ListRecentConversationsResponseInternal;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.CreateConversationRequest;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.InjectEventRequest;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.InjectMessageRequestBase;
import com.sinch.sdk.domains.conversation.models.v1.conversation.response.InjectEventResponse;
import com.sinch.sdk.domains.conversation.models.v1.request.MetadataUpdateStrategy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ConversationApi {

  private static final Logger LOGGER = Logger.getLogger(ConversationApi.class.getName());
  private HttpClient httpClient;
  private ServerConfiguration serverConfiguration;
  private Map<String, AuthManager> authManagersByOasSecuritySchemes;
  private HttpMapper mapper;

  public ConversationApi(
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
   * Create a conversation Creates a new empty conversation. It is generally not needed to create a
   * conversation explicitly since sending or receiving a message automatically creates a new
   * conversation if it does not already exist between the given app and contact. Creating empty
   * conversation is useful if the metadata of the conversation should be populated when the first
   * message in the conversation is a contact message or the first message in the conversation comes
   * out-of-band and needs to be injected with InjectMessage endpoint.
   *
   * @param projectId The unique ID of the project. You can find this on the [Sinch
   *     Dashboard](https://dashboard.sinch.com/convapi/apps). (required)
   * @param createConversationRequest The conversation to create. ID will be generated for the
   *     conversation and any ID in the given conversation will be ignored. (required)
   * @return Conversation
   * @throws ApiException if fails to make API call
   */
  public Conversation conversationCreateConversation(
      String projectId, CreateConversationRequest createConversationRequest) throws ApiException {

    LOGGER.finest(
        "[conversationCreateConversation]"
            + " "
            + "projectId: "
            + projectId
            + ", "
            + "createConversationRequest: "
            + createConversationRequest);

    HttpRequest httpRequest =
        conversationCreateConversationRequestBuilder(projectId, createConversationRequest);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<Conversation> localVarReturnType = new TypeReference<Conversation>() {};
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

  private HttpRequest conversationCreateConversationRequestBuilder(
      String projectId, CreateConversationRequest createConversationRequest) throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'projectId' when calling conversationCreateConversation");
    }
    // verify the required parameter 'createConversationRequest' is set
    if (createConversationRequest == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'createConversationRequest' when calling"
              + " conversationCreateConversation");
    }

    String localVarPath =
        "/v1/projects/{project_id}/conversations"
            .replaceAll(
                "\\{" + "project_id" + "\\}", URLPathUtils.encodePathSegment(projectId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("Basic", "oAuth2");
    final String serializedBody = mapper.serialize(localVarContentTypes, createConversationRequest);

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
   * Delete a conversation Deletes a conversation together with all the messages sent as part of the
   * conversation.
   *
   * @param projectId The unique ID of the project. You can find this on the [Sinch
   *     Dashboard](https://dashboard.sinch.com/convapi/apps). (required)
   * @param conversationId The unique ID of the conversation. This is generated by the system.
   *     (required)
   * @throws ApiException if fails to make API call
   */
  public void conversationDeleteConversation(String projectId, String conversationId)
      throws ApiException {

    LOGGER.finest(
        "[conversationDeleteConversation]"
            + " "
            + "projectId: "
            + projectId
            + ", "
            + "conversationId: "
            + conversationId);

    HttpRequest httpRequest =
        conversationDeleteConversationRequestBuilder(projectId, conversationId);
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

  private HttpRequest conversationDeleteConversationRequestBuilder(
      String projectId, String conversationId) throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'projectId' when calling conversationDeleteConversation");
    }
    // verify the required parameter 'conversationId' is set
    if (conversationId == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'conversationId' when calling"
              + " conversationDeleteConversation");
    }

    String localVarPath =
        "/v1/projects/{project_id}/conversations/{conversation_id}"
            .replaceAll(
                "\\{" + "project_id" + "\\}", URLPathUtils.encodePathSegment(projectId.toString()))
            .replaceAll(
                "\\{" + "conversation_id" + "\\}",
                URLPathUtils.encodePathSegment(conversationId.toString()));

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
   * Get a conversation Retrieves a conversation by id. A conversation has two participating
   * entities, an app and a contact.
   *
   * @param projectId The unique ID of the project. You can find this on the [Sinch
   *     Dashboard](https://dashboard.sinch.com/convapi/apps). (required)
   * @param conversationId The unique ID of the conversation. This is generated by the system.
   *     (required)
   * @return Conversation
   * @throws ApiException if fails to make API call
   */
  public Conversation conversationGetConversation(String projectId, String conversationId)
      throws ApiException {

    LOGGER.finest(
        "[conversationGetConversation]"
            + " "
            + "projectId: "
            + projectId
            + ", "
            + "conversationId: "
            + conversationId);

    HttpRequest httpRequest = conversationGetConversationRequestBuilder(projectId, conversationId);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<Conversation> localVarReturnType = new TypeReference<Conversation>() {};
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

  private HttpRequest conversationGetConversationRequestBuilder(
      String projectId, String conversationId) throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'projectId' when calling conversationGetConversation");
    }
    // verify the required parameter 'conversationId' is set
    if (conversationId == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'conversationId' when calling"
              + " conversationGetConversation");
    }

    String localVarPath =
        "/v1/projects/{project_id}/conversations/{conversation_id}"
            .replaceAll(
                "\\{" + "project_id" + "\\}", URLPathUtils.encodePathSegment(projectId.toString()))
            .replaceAll(
                "\\{" + "conversation_id" + "\\}",
                URLPathUtils.encodePathSegment(conversationId.toString()));

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
   * Inject a message This operation injects a conversation message in to a specific conversation.
   *
   * @param projectId The unique ID of the project. You can find this on the [Sinch
   *     Dashboard](https://dashboard.sinch.com/convapi/apps). (required)
   * @param conversationId The ID of the conversation. (required)
   * @param injectMessageRequestBase Message to be injected. (required)
   * @throws ApiException if fails to make API call
   */
  public void conversationInjectMessage(
      String projectId, String conversationId, InjectMessageRequestBase injectMessageRequestBase)
      throws ApiException {

    LOGGER.finest(
        "[conversationInjectMessage]"
            + " "
            + "projectId: "
            + projectId
            + ", "
            + "conversationId: "
            + conversationId
            + ", "
            + "injectMessageRequestBase: "
            + injectMessageRequestBase);

    HttpRequest httpRequest =
        conversationInjectMessageRequestBuilder(
            projectId, conversationId, injectMessageRequestBase);
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

  private HttpRequest conversationInjectMessageRequestBuilder(
      String projectId, String conversationId, InjectMessageRequestBase injectMessageRequestBase)
      throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'projectId' when calling conversationInjectMessage");
    }
    // verify the required parameter 'conversationId' is set
    if (conversationId == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'conversationId' when calling conversationInjectMessage");
    }
    // verify the required parameter 'injectMessageRequestBase' is set
    if (injectMessageRequestBase == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'injectMessageRequestBase' when calling"
              + " conversationInjectMessage");
    }

    String localVarPath =
        "/v1/projects/{project_id}/conversations/{conversation_id}:inject-message"
            .replaceAll(
                "\\{" + "project_id" + "\\}", URLPathUtils.encodePathSegment(projectId.toString()))
            .replaceAll(
                "\\{" + "conversation_id" + "\\}",
                URLPathUtils.encodePathSegment(conversationId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("Basic", "oAuth2");
    final String serializedBody = mapper.serialize(localVarContentTypes, injectMessageRequestBase);

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
   * List conversations This operation lists all conversations that are associated with an app
   * and/or a contact.
   *
   * @param projectId The unique ID of the project. You can find this on the [Sinch
   *     Dashboard](https://dashboard.sinch.com/convapi/apps). (required)
   * @param appId The ID of the app involved in the conversations. Note that either
   *     &#x60;app_id&#x60; or &#x60;contact_id&#x60; is required in order for the operation to
   *     function correctly. (optional)
   * @param contactId Resource name (ID) of the contact. Note that either &#x60;app_id&#x60; or
   *     &#x60;contact_id&#x60; is required in order for the operation to function correctly.
   *     (optional)
   * @param onlyActive True if only active conversations should be listed. (optional)
   * @param pageSize The maximum number of conversations to fetch. Defaults to 10 and the maximum is
   *     20. (optional)
   * @param pageToken Next page token previously returned if any. (optional)
   * @param activeChannel Only fetch conversations from the &#x60;active_channel&#x60; (optional)
   * @return ListConversationsResponseInternal
   * @throws ApiException if fails to make API call
   */
  public ListConversationsResponseInternal conversationListConversations(
      String projectId,
      String appId,
      String contactId,
      Boolean onlyActive,
      Integer pageSize,
      String pageToken,
      ConversationChannel activeChannel)
      throws ApiException {

    LOGGER.finest(
        "[conversationListConversations]"
            + " "
            + "projectId: "
            + projectId
            + ", "
            + "appId: "
            + appId
            + ", "
            + "contactId: "
            + contactId
            + ", "
            + "onlyActive: "
            + onlyActive
            + ", "
            + "pageSize: "
            + pageSize
            + ", "
            + "pageToken: "
            + pageToken
            + ", "
            + "activeChannel: "
            + activeChannel);

    HttpRequest httpRequest =
        conversationListConversationsRequestBuilder(
            projectId, appId, contactId, onlyActive, pageSize, pageToken, activeChannel);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<ListConversationsResponseInternal> localVarReturnType =
          new TypeReference<ListConversationsResponseInternal>() {};
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

  private HttpRequest conversationListConversationsRequestBuilder(
      String projectId,
      String appId,
      String contactId,
      Boolean onlyActive,
      Integer pageSize,
      String pageToken,
      ConversationChannel activeChannel)
      throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'projectId' when calling conversationListConversations");
    }

    String localVarPath =
        "/v1/projects/{project_id}/conversations"
            .replaceAll(
                "\\{" + "project_id" + "\\}", URLPathUtils.encodePathSegment(projectId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();
    if (null != appId) {
      localVarQueryParams.add(
          new URLParameter(
              "app_id", appId, URLParameter.STYLE.valueOf("form".toUpperCase()), true));
    }
    if (null != contactId) {
      localVarQueryParams.add(
          new URLParameter(
              "contact_id", contactId, URLParameter.STYLE.valueOf("form".toUpperCase()), true));
    }
    if (null != onlyActive) {
      localVarQueryParams.add(
          new URLParameter(
              "only_active", onlyActive, URLParameter.STYLE.valueOf("form".toUpperCase()), true));
    }
    if (null != pageSize) {
      localVarQueryParams.add(
          new URLParameter(
              "page_size", pageSize, URLParameter.STYLE.valueOf("form".toUpperCase()), true));
    }
    if (null != pageToken) {
      localVarQueryParams.add(
          new URLParameter(
              "page_token", pageToken, URLParameter.STYLE.valueOf("form".toUpperCase()), true));
    }
    if (null != activeChannel) {
      localVarQueryParams.add(
          new URLParameter(
              "active_channel",
              activeChannel,
              URLParameter.STYLE.valueOf("form".toUpperCase()),
              true));
    }

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
   * List recent conversations This operation lists conversations and their most recent message,
   * ordered by when the most recent message was sent for that conversation.
   *
   * @param projectId The unique ID of the project. You can find this on the [Sinch
   *     Dashboard](https://dashboard.sinch.com/convapi/apps). (required)
   * @param appId The application ID (required)
   * @param onlyActive True if only active conversations should be listed. Default is false.
   *     (optional)
   * @param pageSize The maximum number of conversations to fetch. Defaults to 10 and the maximum
   *     value is 50. (optional)
   * @param pageToken Next page token previously returned if any. When specifying this token, make
   *     sure to use the same values for the other parameters from the request that originated the
   *     token, otherwise the paged results may be inconsistent. (optional)
   * @param order Whether to sort conversations by newest message first or oldest. Default is DESC
   *     (newest first) (optional)
   * @return ListRecentConversationsResponseInternal
   * @throws ApiException if fails to make API call
   */
  public ListRecentConversationsResponseInternal conversationListRecentConversations(
      String projectId,
      String appId,
      Boolean onlyActive,
      Integer pageSize,
      String pageToken,
      String order)
      throws ApiException {

    LOGGER.finest(
        "[conversationListRecentConversations]"
            + " "
            + "projectId: "
            + projectId
            + ", "
            + "appId: "
            + appId
            + ", "
            + "onlyActive: "
            + onlyActive
            + ", "
            + "pageSize: "
            + pageSize
            + ", "
            + "pageToken: "
            + pageToken
            + ", "
            + "order: "
            + order);

    HttpRequest httpRequest =
        conversationListRecentConversationsRequestBuilder(
            projectId, appId, onlyActive, pageSize, pageToken, order);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<ListRecentConversationsResponseInternal> localVarReturnType =
          new TypeReference<ListRecentConversationsResponseInternal>() {};
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

  private HttpRequest conversationListRecentConversationsRequestBuilder(
      String projectId,
      String appId,
      Boolean onlyActive,
      Integer pageSize,
      String pageToken,
      String order)
      throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'projectId' when calling"
              + " conversationListRecentConversations");
    }
    // verify the required parameter 'appId' is set
    if (appId == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'appId' when calling"
              + " conversationListRecentConversations");
    }

    String localVarPath =
        "/v1/projects/{project_id}/conversations:recent"
            .replaceAll(
                "\\{" + "project_id" + "\\}", URLPathUtils.encodePathSegment(projectId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();
    if (null != appId) {
      localVarQueryParams.add(
          new URLParameter(
              "app_id", appId, URLParameter.STYLE.valueOf("form".toUpperCase()), true));
    }
    if (null != onlyActive) {
      localVarQueryParams.add(
          new URLParameter(
              "only_active", onlyActive, URLParameter.STYLE.valueOf("form".toUpperCase()), true));
    }
    if (null != pageSize) {
      localVarQueryParams.add(
          new URLParameter(
              "page_size", pageSize, URLParameter.STYLE.valueOf("form".toUpperCase()), true));
    }
    if (null != pageToken) {
      localVarQueryParams.add(
          new URLParameter(
              "page_token", pageToken, URLParameter.STYLE.valueOf("form".toUpperCase()), true));
    }
    if (null != order) {
      localVarQueryParams.add(
          new URLParameter("order", order, URLParameter.STYLE.valueOf("form".toUpperCase()), true));
    }

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
   * Stop conversation This operation stops the referenced conversation, if the conversation is
   * still active. A new conversation will be created if a new message is exchanged between the app
   * or contact that was part of the stopped conversation.
   *
   * @param projectId The unique ID of the project. You can find this on the [Sinch
   *     Dashboard](https://dashboard.sinch.com/convapi/apps). (required)
   * @param conversationId The unique ID of the conversation. This is generated by the system.
   *     (required)
   * @throws ApiException if fails to make API call
   */
  public void conversationStopActiveConversation(String projectId, String conversationId)
      throws ApiException {

    LOGGER.finest(
        "[conversationStopActiveConversation]"
            + " "
            + "projectId: "
            + projectId
            + ", "
            + "conversationId: "
            + conversationId);

    HttpRequest httpRequest =
        conversationStopActiveConversationRequestBuilder(projectId, conversationId);
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

  private HttpRequest conversationStopActiveConversationRequestBuilder(
      String projectId, String conversationId) throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'projectId' when calling"
              + " conversationStopActiveConversation");
    }
    // verify the required parameter 'conversationId' is set
    if (conversationId == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'conversationId' when calling"
              + " conversationStopActiveConversation");
    }

    String localVarPath =
        "/v1/projects/{project_id}/conversations/{conversation_id}:stop"
            .replaceAll(
                "\\{" + "project_id" + "\\}", URLPathUtils.encodePathSegment(projectId.toString()))
            .replaceAll(
                "\\{" + "conversation_id" + "\\}",
                URLPathUtils.encodePathSegment(conversationId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList();

    final Collection<String> localVarAuthNames = Arrays.asList("Basic", "oAuth2");
    final String serializedBody = null;

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
   * Update a conversation This operation updates a conversation which can, for instance, be used to
   * update the metadata associated with a conversation.
   *
   * @param projectId The unique ID of the project. You can find this on the [Sinch
   *     Dashboard](https://dashboard.sinch.com/convapi/apps). (required)
   * @param conversationId The unique ID of the conversation. This is generated by the system.
   *     (required)
   * @param conversation The updated conversation. (required)
   * @param updateMask The set of field mask paths. (optional
   * @param metadataUpdateStrategy Update strategy for the &#x60;conversation_metadata&#x60; field.
   *     (optional, default to REPLACE)
   * @return Conversation
   * @throws ApiException if fails to make API call
   */
  public Conversation conversationUpdateConversation(
      String projectId,
      String conversationId,
      Conversation conversation,
      List<String> updateMask,
      MetadataUpdateStrategy metadataUpdateStrategy)
      throws ApiException {

    LOGGER.finest(
        "[conversationUpdateConversation]"
            + " "
            + "projectId: "
            + projectId
            + ", "
            + "conversationId: "
            + conversationId
            + ", "
            + "conversation: "
            + conversation
            + ", "
            + "updateMask: "
            + updateMask
            + ", "
            + "metadataUpdateStrategy: "
            + metadataUpdateStrategy);

    HttpRequest httpRequest =
        conversationUpdateConversationRequestBuilder(
            projectId, conversationId, conversation, updateMask, metadataUpdateStrategy);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<Conversation> localVarReturnType = new TypeReference<Conversation>() {};
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

  private HttpRequest conversationUpdateConversationRequestBuilder(
      String projectId,
      String conversationId,
      Conversation conversation,
      List<String> updateMask,
      MetadataUpdateStrategy metadataUpdateStrategy)
      throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'projectId' when calling conversationUpdateConversation");
    }
    // verify the required parameter 'conversationId' is set
    if (conversationId == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'conversationId' when calling"
              + " conversationUpdateConversation");
    }
    // verify the required parameter 'conversation' is set
    if (conversation == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'conversation' when calling"
              + " conversationUpdateConversation");
    }

    String localVarPath =
        "/v1/projects/{project_id}/conversations/{conversation_id}"
            .replaceAll(
                "\\{" + "project_id" + "\\}", URLPathUtils.encodePathSegment(projectId.toString()))
            .replaceAll(
                "\\{" + "conversation_id" + "\\}",
                URLPathUtils.encodePathSegment(conversationId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();
    if (null != updateMask) {
      localVarQueryParams.add(
          new URLParameter(
              "update_mask", updateMask, URLParameter.STYLE.valueOf("form".toUpperCase()), true));
    }
    if (null != metadataUpdateStrategy) {
      localVarQueryParams.add(
          new URLParameter(
              "metadata_update_strategy",
              metadataUpdateStrategy,
              URLParameter.STYLE.valueOf("form".toUpperCase()),
              true));
    }

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("Basic", "oAuth2");
    final String serializedBody = mapper.serialize(localVarContentTypes, conversation);

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
   * Inject an event This operation injects a conversation event into a specific conversation.
   *
   * @param projectId The unique ID of the project. You can find this on the [Sinch
   *     Dashboard](https://dashboard.sinch.com/convapi/apps). (required)
   * @param conversationId The unique ID of the conversation. This is generated by the system.
   *     (required)
   * @param injectEventRequest Inject event request (required)
   * @return InjectEventResponse
   * @throws ApiException if fails to make API call
   */
  public InjectEventResponse eventsInjectEvent(
      String projectId, String conversationId, InjectEventRequest injectEventRequest)
      throws ApiException {

    LOGGER.finest(
        "[eventsInjectEvent]"
            + " "
            + "projectId: "
            + projectId
            + ", "
            + "conversationId: "
            + conversationId
            + ", "
            + "injectEventRequest: "
            + injectEventRequest);

    HttpRequest httpRequest =
        eventsInjectEventRequestBuilder(projectId, conversationId, injectEventRequest);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<InjectEventResponse> localVarReturnType =
          new TypeReference<InjectEventResponse>() {};
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

  private HttpRequest eventsInjectEventRequestBuilder(
      String projectId, String conversationId, InjectEventRequest injectEventRequest)
      throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'projectId' when calling eventsInjectEvent");
    }
    // verify the required parameter 'conversationId' is set
    if (conversationId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'conversationId' when calling eventsInjectEvent");
    }
    // verify the required parameter 'injectEventRequest' is set
    if (injectEventRequest == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'injectEventRequest' when calling eventsInjectEvent");
    }

    String localVarPath =
        "/v1/projects/{project_id}/conversations/{conversation_id}:inject-event"
            .replaceAll(
                "\\{" + "project_id" + "\\}", URLPathUtils.encodePathSegment(projectId.toString()))
            .replaceAll(
                "\\{" + "conversation_id" + "\\}",
                URLPathUtils.encodePathSegment(conversationId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("Basic", "oAuth2");
    final String serializedBody = mapper.serialize(localVarContentTypes, injectEventRequest);

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