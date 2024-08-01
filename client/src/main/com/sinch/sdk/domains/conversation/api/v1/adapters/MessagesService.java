package com.sinch.sdk.domains.conversation.api.v1.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.conversation.api.v1.internal.MessagesApi;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.SendMessageRequest;
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
import com.sinch.sdk.domains.conversation.models.v1.response.ConversationMessage;
import com.sinch.sdk.models.ConversationContext;
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
    return getApi().messagesGetMessage(uriUUID, messageId, null);
  }
}
