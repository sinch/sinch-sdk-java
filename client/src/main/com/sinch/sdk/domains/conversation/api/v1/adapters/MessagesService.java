package com.sinch.sdk.domains.conversation.api.v1.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.core.models.pagination.TokenPageNavigator;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.conversation.api.v1.adapters.messages.ConversationMessageMapper;
import com.sinch.sdk.domains.conversation.api.v1.internal.MessagesApi;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ConversationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.ListMessagesResponseInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.ListMessagesResponseInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.ConversationMessagesView;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.MessagesListRequest;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.SendMessageRequest;
import com.sinch.sdk.domains.conversation.models.v1.messages.response.MessagesListResponse;
import com.sinch.sdk.domains.conversation.models.v1.messages.response.SendMessageResponse;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.card.CardMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.carousel.CarouselMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.contactinfo.ContactInfoMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.list.ListMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.LocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.template.TemplateMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import com.sinch.sdk.models.ConversationContext;
import java.time.Instant;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class MessagesService implements com.sinch.sdk.domains.conversation.api.v1.MessagesService {

  private final String uriUUID;
  private final MessagesApi api;

  public MessagesService(
      String uriUUID,
      ConversationContext context,
      HttpClient httpClient,
      Map<String, AuthManager> authManagers) {
    this.uriUUID = uriUUID;
    this.api = new MessagesApi(httpClient, context.getServer(), authManagers, new HttpMapper());
  }

  protected MessagesApi getApi() {
    return this.api;
  }

  public SendMessageResponse sendMessage(SendMessageRequest<? extends AppMessage> request)
      throws ApiException {
    return getApi().messagesSendMessage(uriUUID, request);
  }

  public SendMessageResponse sendCardMessage(SendMessageRequest<CardMessage> request) {
    return sendMessage(request);
  }

  public SendMessageResponse sendCarouselMessage(SendMessageRequest<CarouselMessage> request) {
    return sendMessage(request);
  }

  public SendMessageResponse sendChoiceMessage(SendMessageRequest<ChoiceMessage> request) {
    return sendMessage(request);
  }

  public SendMessageResponse sendContactInfoMessage(
      SendMessageRequest<ContactInfoMessage> request) {
    return sendMessage(request);
  }

  public SendMessageResponse sendListMessage(SendMessageRequest<ListMessage> request) {
    return sendMessage(request);
  }

  public SendMessageResponse sendLocationMessage(SendMessageRequest<LocationMessage> request) {
    return sendMessage(request);
  }

  public SendMessageResponse sendMediaMessage(SendMessageRequest<MediaMessage> request) {
    return sendMessage(request);
  }

  public SendMessageResponse sendTemplateMessage(SendMessageRequest<TemplateMessage> request) {
    return sendMessage(request);
  }

  public SendMessageResponse sendTextMessage(SendMessageRequest<TextMessage> request) {
    return sendMessage(request);
  }

  public ConversationMessage get(String messageId) {
    return get(messageId, null);
  }

  public ConversationMessage get(String messageId, MessageSource messageSource) {
    return ConversationMessageMapper.convert(
        getApi()
            .messagesGetMessage(
                uriUUID, messageId, null == messageSource ? null : messageSource.name()));
  }

  public MessagesListResponse list(MessagesListRequest parameters) {

    String conversationId = parameters.getConversationId().orElse(null);
    String contactId = parameters.getContactId().orElse(null);
    String appId = parameters.getAppId().orElse(null);
    String channelIdentity = parameters.getChannelIdentity().orElse(null);
    Instant startTime = parameters.getStartTime().orElse(null);
    Instant endTime = parameters.getEndTime().orElse(null);
    Integer pageSize = parameters.getPageSize().orElse(null);
    String pageToken = parameters.getPageToken().orElse(null);
    ConversationMessagesView view = parameters.getView().orElse(null);
    String messagesSource = parameters.getMessagesSource().map(Enum::name).orElse(null);
    Boolean onlyRecipientOriginated = parameters.getOnlyRecipientOriginated().orElse(null);
    ConversationChannel channel = parameters.getChannel().orElse(null);

    ListMessagesResponseInternal response =
        getApi()
            .messagesListMessages(
                uriUUID,
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

    return mapForPaging(parameters, response);
  }

  public void delete(String messageId) {
    delete(messageId, null);
  }

  public void delete(String messageId, MessageSource messageSource) {
    getApi()
        .messagesDeleteMessage(
            uriUUID, messageId, null == messageSource ? null : messageSource.name());
  }

  private MessagesListResponse mapForPaging(
      MessagesListRequest parameters, ListMessagesResponseInternal _dto) {

    ListMessagesResponseInternalImpl dto = (ListMessagesResponseInternalImpl) _dto;

    String nextPageToken = dto.nextPageToken().orElse(null);
    Collection<ConversationMessage> list = dto.messages().orElse(Collections.emptyList());

    Pair<Collection<ConversationMessage>, TokenPageNavigator> paginated =
        new Pair<>(list, new TokenPageNavigator(nextPageToken));

    return new MessagesListResponse(
        this, new Page<>(parameters, paginated.getLeft(), paginated.getRight()));
  }
}
