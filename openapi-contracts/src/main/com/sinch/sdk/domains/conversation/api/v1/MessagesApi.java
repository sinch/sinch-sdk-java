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

package com.sinch.sdk.domains.conversation.api.v1;

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
import com.sinch.sdk.domains.conversation.models.v1.messages.request.ConversationMessagesView;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.SendMessageRequest;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.UpdateMessageMetadataRequest;
import com.sinch.sdk.domains.conversation.models.v1.messages.response.ListMessagesResponse;
import com.sinch.sdk.domains.conversation.models.v1.messages.response.SendMessageResponse;
import com.sinch.sdk.domains.conversation.models.v1.response.ConversationMessage;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class MessagesApi {

  private static final Logger LOGGER = Logger.getLogger(MessagesApi.class.getName());
  private HttpClient httpClient;
  private ServerConfiguration serverConfiguration;
  private Map<String, AuthManager> authManagersByOasSecuritySchemes;
  private HttpMapper mapper;

  public MessagesApi(
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
   * Delete a message Delete a specific message by its ID. Note: Removing all messages of a
   * conversation will not automatically delete the conversation.
   *
   * @param projectId The unique ID of the project. You can find this on the [Sinch
   *     Dashboard](https://dashboard.sinch.com/convapi/apps). (required)
   * @param messageId The unique ID of the message. (required)
   * @param messagesSource Specifies the message source for which the request will be processed.
   *     Used for operations on messages in Dispatch Mode. For more information, see [Processing
   *     Modes](../../../../../conversation/processing-modes/). (optional, default to
   *     CONVERSATION_SOURCE)
   * @throws ApiException if fails to make API call
   */
  public void messagesDeleteMessage(String projectId, String messageId, String messagesSource)
      throws ApiException {

    LOGGER.finest(
        "[messagesDeleteMessage]"
            + " "
            + "projectId: "
            + projectId
            + ", "
            + "messageId: "
            + messageId
            + ", "
            + "messagesSource: "
            + messagesSource);

    HttpRequest httpRequest =
        messagesDeleteMessageRequestBuilder(projectId, messageId, messagesSource);
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

  private HttpRequest messagesDeleteMessageRequestBuilder(
      String projectId, String messageId, String messagesSource) throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'projectId' when calling messagesDeleteMessage");
    }
    // verify the required parameter 'messageId' is set
    if (messageId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'messageId' when calling messagesDeleteMessage");
    }

    String localVarPath =
        "/v1/projects/{project_id}/messages/{message_id}"
            .replaceAll(
                "\\{" + "project_id" + "\\}", URLPathUtils.encodePathSegment(projectId.toString()))
            .replaceAll(
                "\\{" + "message_id" + "\\}", URLPathUtils.encodePathSegment(messageId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();
    if (null != messagesSource) {
      localVarQueryParams.add(
          new URLParameter(
              "messages_source",
              messagesSource,
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
        HttpMethod.DELETE,
        localVarQueryParams,
        serializedBody,
        localVarHeaderParams,
        localVarAccepts,
        localVarContentTypes,
        localVarAuthNames);
  }

  /**
   * Get a message Retrieves a specific message by its ID.
   *
   * @param projectId The unique ID of the project. You can find this on the [Sinch
   *     Dashboard](https://dashboard.sinch.com/convapi/apps). (required)
   * @param messageId The unique ID of the message. (required)
   * @param messagesSource Specifies the message source for which the request will be processed.
   *     Used for operations on messages in Dispatch Mode. For more information, see [Processing
   *     Modes](../../../../../conversation/processing-modes/). (optional, default to
   *     CONVERSATION_SOURCE)
   * @return ConversationMessage
   * @throws ApiException if fails to make API call
   */
  public ConversationMessage messagesGetMessage(
      String projectId, String messageId, String messagesSource) throws ApiException {

    LOGGER.finest(
        "[messagesGetMessage]"
            + " "
            + "projectId: "
            + projectId
            + ", "
            + "messageId: "
            + messageId
            + ", "
            + "messagesSource: "
            + messagesSource);

    HttpRequest httpRequest =
        messagesGetMessageRequestBuilder(projectId, messageId, messagesSource);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<ConversationMessage> localVarReturnType =
          new TypeReference<ConversationMessage>() {};
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

  private HttpRequest messagesGetMessageRequestBuilder(
      String projectId, String messageId, String messagesSource) throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'projectId' when calling messagesGetMessage");
    }
    // verify the required parameter 'messageId' is set
    if (messageId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'messageId' when calling messagesGetMessage");
    }

    String localVarPath =
        "/v1/projects/{project_id}/messages/{message_id}"
            .replaceAll(
                "\\{" + "project_id" + "\\}", URLPathUtils.encodePathSegment(projectId.toString()))
            .replaceAll(
                "\\{" + "message_id" + "\\}", URLPathUtils.encodePathSegment(messageId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();
    if (null != messagesSource) {
      localVarQueryParams.add(
          new URLParameter(
              "messages_source",
              messagesSource,
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
   * List messages This operation lists all messages sent or received via particular [Processing
   * Modes](../../../../../conversation/processing-modes/). Setting the &#x60;messages_source&#x60;
   * parameter to &#x60;CONVERSATION_SOURCE&#x60; allows for querying messages in
   * &#x60;CONVERSATION&#x60; mode, and setting it to &#x60;DISPATCH_SOURCE&#x60; will allow for
   * queries of messages in &#x60;DISPATCH&#x60; mode. Combining multiple parameters is supported
   * for more detailed filtering of messages, but some of them are not supported depending on the
   * value specified for &#x60;messages_source&#x60;. The description for each field will inform if
   * that field may not be supported. The messages are ordered by their &#x60;accept_time&#x60;
   * property in descending order, where &#x60;accept_time&#x60; is a timestamp of when the message
   * was enqueued by the Conversation API. This means messages received most recently will be listed
   * first.
   *
   * @param projectId The unique ID of the project. You can find this on the [Sinch
   *     Dashboard](https://dashboard.sinch.com/convapi/apps). (required)
   * @param conversationId Resource name (ID) of the conversation. (optional)
   * @param contactId Resource name (ID) of the contact. Note that either &#x60;app_id&#x60; or
   *     &#x60;contact_id&#x60; is required in order for the operation to function correctly.
   *     (optional)
   * @param appId Id of the app. (optional)
   * @param channelIdentity Channel identity of the contact. (optional)
   * @param startTime Filter messages with &#x60;accept_time&#x60; after this timestamp. Must be
   *     before &#x60;end_time&#x60; if that is specified. (optional)
   * @param endTime Filter messages with &#x60;accept_time&#x60; before this timestamp. (optional)
   * @param pageSize Maximum number of messages to fetch. Defaults to 10 and the maximum is 1000.
   *     (optional)
   * @param pageToken Next page token previously returned if any. When specifying this token, make
   *     sure to use the same values for the other parameters from the request that originated the
   *     token, otherwise the paged results may be inconsistent. (optional)
   * @param view (optional, default to WITH_METADATA)
   * @param messagesSource Specifies the message source for which the request will be processed.
   *     Used for operations on messages in Dispatch Mode. For more information, see [Processing
   *     Modes](../../../../../conversation/processing-modes/). (optional, default to
   *     CONVERSATION_SOURCE)
   * @param onlyRecipientOriginated If true, fetch only recipient originated messages. Available
   *     only when &#x60;messages_source&#x60; is &#x60;DISPATCH_SOURCE&#x60;. (optional)
   * @param channel Only fetch messages from the &#x60;channel&#x60;. (optional)
   * @return ListMessagesResponse
   * @throws ApiException if fails to make API call
   */
  public ListMessagesResponse messagesListMessages(
      String projectId,
      String conversationId,
      String contactId,
      String appId,
      String channelIdentity,
      Instant startTime,
      Instant endTime,
      Integer pageSize,
      String pageToken,
      ConversationMessagesView view,
      String messagesSource,
      Boolean onlyRecipientOriginated,
      ConversationChannel channel)
      throws ApiException {

    LOGGER.finest(
        "[messagesListMessages]"
            + " "
            + "projectId: "
            + projectId
            + ", "
            + "conversationId: "
            + conversationId
            + ", "
            + "contactId: "
            + contactId
            + ", "
            + "appId: "
            + appId
            + ", "
            + "channelIdentity: "
            + channelIdentity
            + ", "
            + "startTime: "
            + startTime
            + ", "
            + "endTime: "
            + endTime
            + ", "
            + "pageSize: "
            + pageSize
            + ", "
            + "pageToken: "
            + pageToken
            + ", "
            + "view: "
            + view
            + ", "
            + "messagesSource: "
            + messagesSource
            + ", "
            + "onlyRecipientOriginated: "
            + onlyRecipientOriginated
            + ", "
            + "channel: "
            + channel);

    HttpRequest httpRequest =
        messagesListMessagesRequestBuilder(
            projectId,
            conversationId,
            contactId,
            appId,
            channelIdentity,
            startTime,
            endTime,
            pageSize,
            pageToken,
            view,
            messagesSource,
            onlyRecipientOriginated,
            channel);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<ListMessagesResponse> localVarReturnType =
          new TypeReference<ListMessagesResponse>() {};
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

  private HttpRequest messagesListMessagesRequestBuilder(
      String projectId,
      String conversationId,
      String contactId,
      String appId,
      String channelIdentity,
      Instant startTime,
      Instant endTime,
      Integer pageSize,
      String pageToken,
      ConversationMessagesView view,
      String messagesSource,
      Boolean onlyRecipientOriginated,
      ConversationChannel channel)
      throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'projectId' when calling messagesListMessages");
    }

    String localVarPath =
        "/v1/projects/{project_id}/messages"
            .replaceAll(
                "\\{" + "project_id" + "\\}", URLPathUtils.encodePathSegment(projectId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();
    if (null != conversationId) {
      localVarQueryParams.add(
          new URLParameter(
              "conversation_id",
              conversationId,
              URLParameter.STYLE.valueOf("form".toUpperCase()),
              true));
    }
    if (null != contactId) {
      localVarQueryParams.add(
          new URLParameter(
              "contact_id", contactId, URLParameter.STYLE.valueOf("form".toUpperCase()), true));
    }
    if (null != appId) {
      localVarQueryParams.add(
          new URLParameter(
              "app_id", appId, URLParameter.STYLE.valueOf("form".toUpperCase()), true));
    }
    if (null != channelIdentity) {
      localVarQueryParams.add(
          new URLParameter(
              "channel_identity",
              channelIdentity,
              URLParameter.STYLE.valueOf("form".toUpperCase()),
              true));
    }
    if (null != startTime) {
      localVarQueryParams.add(
          new URLParameter(
              "start_time", startTime, URLParameter.STYLE.valueOf("form".toUpperCase()), true));
    }
    if (null != endTime) {
      localVarQueryParams.add(
          new URLParameter(
              "end_time", endTime, URLParameter.STYLE.valueOf("form".toUpperCase()), true));
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
    if (null != view) {
      localVarQueryParams.add(
          new URLParameter("view", view, URLParameter.STYLE.valueOf("form".toUpperCase()), true));
    }
    if (null != messagesSource) {
      localVarQueryParams.add(
          new URLParameter(
              "messages_source",
              messagesSource,
              URLParameter.STYLE.valueOf("form".toUpperCase()),
              true));
    }
    if (null != onlyRecipientOriginated) {
      localVarQueryParams.add(
          new URLParameter(
              "only_recipient_originated",
              onlyRecipientOriginated,
              URLParameter.STYLE.valueOf("form".toUpperCase()),
              true));
    }
    if (null != channel) {
      localVarQueryParams.add(
          new URLParameter(
              "channel", channel, URLParameter.STYLE.valueOf("form".toUpperCase()), true));
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
   * Send a message You can send a message from a Conversation app to a contact associated with that
   * app. If the recipient is not associated with an existing contact, a new contact will be
   * created. The message is added to the active conversation with the contact if a conversation
   * already exists. If no active conversation exists a new one is started automatically. You can
   * find all of your IDs and authentication credentials on the [Sinch Customer
   * Dashboard](https://dashboard.sinch.com/settings/access-keys).
   *
   * @param projectId The unique ID of the project. You can find this on the [Sinch
   *     Dashboard](https://dashboard.sinch.com/convapi/apps). (required)
   * @param sendMessageRequest This is the request body for sending a message. &#x60;app_id&#x60;,
   *     &#x60;recipient&#x60;, and &#x60;message&#x60; are all required fields. (required)
   * @return SendMessageResponse
   * @throws ApiException if fails to make API call
   */
  public SendMessageResponse messagesSendMessage(
      String projectId, SendMessageRequest sendMessageRequest) throws ApiException {

    LOGGER.finest(
        "[messagesSendMessage]"
            + " "
            + "projectId: "
            + projectId
            + ", "
            + "sendMessageRequest: "
            + sendMessageRequest);

    HttpRequest httpRequest = messagesSendMessageRequestBuilder(projectId, sendMessageRequest);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<SendMessageResponse> localVarReturnType =
          new TypeReference<SendMessageResponse>() {};
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

  private HttpRequest messagesSendMessageRequestBuilder(
      String projectId, SendMessageRequest sendMessageRequest) throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'projectId' when calling messagesSendMessage");
    }
    // verify the required parameter 'sendMessageRequest' is set
    if (sendMessageRequest == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'sendMessageRequest' when calling messagesSendMessage");
    }

    String localVarPath =
        "/v1/projects/{project_id}/messages:send"
            .replaceAll(
                "\\{" + "project_id" + "\\}", URLPathUtils.encodePathSegment(projectId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("Basic", "oAuth2");
    final String serializedBody = mapper.serialize(localVarContentTypes, sendMessageRequest);

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
   * Update message metadata Update a specific message metadata by its ID.
   *
   * @param projectId The unique ID of the project. You can find this on the [Sinch
   *     Dashboard](https://dashboard.sinch.com/convapi/apps). (required)
   * @param messageId The unique ID of the message. (required)
   * @param updateMessageMetadataRequest Update message metadata request. (required)
   * @param messagesSource Specifies the message source for which the request will be processed.
   *     Used for operations on messages in Dispatch Mode. For more information, see [Processing
   *     Modes](../../../../../conversation/processing-modes/). (optional, default to
   *     CONVERSATION_SOURCE)
   * @return ConversationMessage
   * @throws ApiException if fails to make API call
   */
  public ConversationMessage messagesUpdateMessageMetadata(
      String projectId,
      String messageId,
      UpdateMessageMetadataRequest updateMessageMetadataRequest,
      String messagesSource)
      throws ApiException {

    LOGGER.finest(
        "[messagesUpdateMessageMetadata]"
            + " "
            + "projectId: "
            + projectId
            + ", "
            + "messageId: "
            + messageId
            + ", "
            + "updateMessageMetadataRequest: "
            + updateMessageMetadataRequest
            + ", "
            + "messagesSource: "
            + messagesSource);

    HttpRequest httpRequest =
        messagesUpdateMessageMetadataRequestBuilder(
            projectId, messageId, updateMessageMetadataRequest, messagesSource);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<ConversationMessage> localVarReturnType =
          new TypeReference<ConversationMessage>() {};
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

  private HttpRequest messagesUpdateMessageMetadataRequestBuilder(
      String projectId,
      String messageId,
      UpdateMessageMetadataRequest updateMessageMetadataRequest,
      String messagesSource)
      throws ApiException {
    // verify the required parameter 'projectId' is set
    if (projectId == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'projectId' when calling messagesUpdateMessageMetadata");
    }
    // verify the required parameter 'messageId' is set
    if (messageId == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'messageId' when calling messagesUpdateMessageMetadata");
    }
    // verify the required parameter 'updateMessageMetadataRequest' is set
    if (updateMessageMetadataRequest == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'updateMessageMetadataRequest' when calling"
              + " messagesUpdateMessageMetadata");
    }

    String localVarPath =
        "/v1/projects/{project_id}/messages/{message_id}"
            .replaceAll(
                "\\{" + "project_id" + "\\}", URLPathUtils.encodePathSegment(projectId.toString()))
            .replaceAll(
                "\\{" + "message_id" + "\\}", URLPathUtils.encodePathSegment(messageId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();
    if (null != messagesSource) {
      localVarQueryParams.add(
          new URLParameter(
              "messages_source",
              messagesSource,
              URLParameter.STYLE.valueOf("form".toUpperCase()),
              true));
    }

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("Basic", "oAuth2");
    final String serializedBody =
        mapper.serialize(localVarContentTypes, updateMessageMetadataRequest);

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
