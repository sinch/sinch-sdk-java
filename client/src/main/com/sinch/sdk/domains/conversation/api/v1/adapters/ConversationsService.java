package com.sinch.sdk.domains.conversation.api.v1.adapters;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.core.models.pagination.TokenPageNavigator;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.conversation.api.v1.internal.ConversationApi;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.conversation.Conversation;
import com.sinch.sdk.domains.conversation.models.v1.conversation.internal.ListConversationsResponseInternal;
import com.sinch.sdk.domains.conversation.models.v1.conversation.internal.ListConversationsResponseInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.conversation.internal.ListRecentConversationsResponseInternal;
import com.sinch.sdk.domains.conversation.models.v1.conversation.internal.ListRecentConversationsResponseInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.ConversationsListRecentRequest;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.ConversationsListRecentRequest.OrderEnum;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.ConversationsListRequest;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.CreateConversationRequest;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.InjectMessageRequest;
import com.sinch.sdk.domains.conversation.models.v1.conversation.response.ConversationRecentMessage;
import com.sinch.sdk.domains.conversation.models.v1.conversation.response.ConversationsListRecentResponse;
import com.sinch.sdk.domains.conversation.models.v1.conversation.response.ConversationsListResponse;
import com.sinch.sdk.domains.conversation.models.v1.request.MetadataUpdateStrategy;
import com.sinch.sdk.models.ConversationContext;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class ConversationsService
    implements com.sinch.sdk.domains.conversation.api.v1.ConversationsService {

  private final String uriUUID;
  private final ConversationApi api;

  public ConversationsService(
      String uriUUID,
      ConversationContext context,
      HttpClient httpClient,
      Map<String, AuthManager> authManagers) {
    this.uriUUID = uriUUID;
    this.api = new ConversationApi(httpClient, context.getServer(), authManagers, new HttpMapper());
  }

  protected ConversationApi getApi() {
    return this.api;
  }

  public Conversation create(CreateConversationRequest request) {
    return getApi().conversationCreateConversation(uriUUID, request);
  }

  public Conversation get(String conversationId) {
    return getApi().conversationGetConversation(uriUUID, conversationId);
  }

  public ConversationsListResponse list(ConversationsListRequest parameters) {

    Boolean onlyActive = parameters.getOnlyActive().orElse(null);
    String contactId = parameters.getContactId().orElse(null);
    String appId = parameters.getAppId().orElse(null);

    Integer pageSize = parameters.getPageSize().orElse(null);
    String pageToken = parameters.getPageToken().orElse(null);
    ConversationChannel activeChannel = parameters.getActiveChannel().orElse(null);

    ListConversationsResponseInternal response =
        getApi()
            .conversationListConversations(
                uriUUID, onlyActive, appId, contactId, pageSize, pageToken, activeChannel);

    return mapForPaging(parameters, response);
  }

  public ConversationsListRecentResponse listRecent(ConversationsListRecentRequest parameters) {

    Boolean onlyActive = parameters.getOnlyActive().orElse(null);
    String appId = parameters.getAppId().orElse(null);

    Integer pageSize = parameters.getPageSize().orElse(null);
    String pageToken = parameters.getPageToken().orElse(null);
    String order = parameters.getOrder().map(OrderEnum::value).orElse(null);

    ListRecentConversationsResponseInternal response =
        getApi()
            .conversationListRecentConversations(
                uriUUID, appId, onlyActive, pageSize, pageToken, order);

    return mapForPaging(parameters, response);
  }

  public void stopActive(String conversationId) {
    getApi().conversationStopActiveConversation(uriUUID, conversationId);
  }

  public void delete(String conversationId) {
    getApi().conversationDeleteConversation(uriUUID, conversationId);
  }

  public Conversation update(
      String conversationId, MetadataUpdateStrategy updateStrategy, Conversation request) {
    return getApi()
        .conversationUpdateConversation(uriUUID, conversationId, request, null, updateStrategy);
  }

  public void injectMessage(String conversationId, InjectMessageRequest request) {
    getApi().conversationInjectMessage(uriUUID, conversationId, request);
  }

  private ConversationsListResponse mapForPaging(
      ConversationsListRequest parameters, ListConversationsResponseInternal _dto) {

    ListConversationsResponseInternalImpl dto = (ListConversationsResponseInternalImpl) _dto;

    String nextPageToken = dto.nextPageToken().orElse(null);
    Collection<Conversation> list = dto.conversations().orElse(Collections.emptyList());

    Pair<Collection<Conversation>, TokenPageNavigator> paginated =
        new Pair<>(list, new TokenPageNavigator(nextPageToken));

    return new ConversationsListResponse(
        this, new Page<>(parameters, paginated.getLeft(), paginated.getRight()));
  }

  private ConversationsListRecentResponse mapForPaging(
      ConversationsListRecentRequest parameters, ListRecentConversationsResponseInternal _dto) {

    ListRecentConversationsResponseInternalImpl dto =
        (ListRecentConversationsResponseInternalImpl) _dto;

    String nextPageToken = dto.nextPageToken().orElse(null);
    Collection<ConversationRecentMessage> list =
        dto.conversations().orElse(Collections.emptyList());

    Pair<Collection<ConversationRecentMessage>, TokenPageNavigator> paginated =
        new Pair<>(list, new TokenPageNavigator(nextPageToken));

    return new ConversationsListRecentResponse(
        this, new Page<>(parameters, paginated.getLeft(), paginated.getRight()));
  }
}
