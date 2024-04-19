package com.sinch.sdk.domains.conversation.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.conversation.adapters.messages.AppMessageRequestMapper;
import com.sinch.sdk.domains.conversation.adapters.messages.ChoiceItemMapper;
import com.sinch.sdk.domains.conversation.adapters.messages.ChoiceMapper;
import com.sinch.sdk.domains.conversation.adapters.messages.ListSectionMapper;
import com.sinch.sdk.domains.conversation.adapters.messages.SendMessageRequestMapper;
import com.sinch.sdk.domains.conversation.adapters.messages.WhatsAppInteractiveHeaderMapper;
import com.sinch.sdk.domains.conversation.api.v1.MessagesApi;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessageMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.CardMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.CarouselMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ContactInfoMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ListMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.LocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.MediaMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.TextMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.SendMessageRequest;
import com.sinch.sdk.domains.conversation.models.v1.messages.response.SendMessageResponse;
import com.sinch.sdk.domains.conversation.models.v1.response.ConversationMessage;
import com.sinch.sdk.domains.conversation.models.v1.templates.TemplateMessage;
import com.sinch.sdk.models.ConversationContext;
import java.util.Map;

public class MessagesService implements com.sinch.sdk.domains.conversation.MessagesService {

  static {
    LocalLazyInit.init();
  }

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

  <T extends AppMessageMessage> SendMessageResponse send(SendMessageRequest<T> request)
      throws ApiException {
    return getApi().messagesSendMessage(uriUUID, request);
  }

  public SendMessageResponse sendCardMessage(SendMessageRequest<CardMessage> request) {
    return send(request);
  }

  public SendMessageResponse sendCarouselMessage(SendMessageRequest<CarouselMessage> request) {
    return send(request);
  }

  public SendMessageResponse sendChoiceMessage(SendMessageRequest<ChoiceMessage> request) {
    return send(request);
  }

  public SendMessageResponse sendCContactInfoMessage(
      SendMessageRequest<ContactInfoMessage> request) {
    return send(request);
  }

  public SendMessageResponse sendListMessage(SendMessageRequest<ListMessage> request) {
    return send(request);
  }

  public SendMessageResponse sendLocationMessage(SendMessageRequest<LocationMessage> request) {
    return send(request);
  }

  public SendMessageResponse sendMediaMessage(SendMessageRequest<MediaMessage> request) {
    return send(request);
  }

  public SendMessageResponse sendTemplateMessage(SendMessageRequest<TemplateMessage> request) {
    return send(request);
  }

  public SendMessageResponse sendTextMessage(SendMessageRequest<TextMessage> request) {
    return send(request);
  }

  public ConversationMessage get(String messageId) {
    return getApi().messagesGetMessage(uriUUID, messageId, null);
  }

  static final class LocalLazyInit {

    private LocalLazyInit() {
      AppMessageRequestMapper.initMapper();
      ChoiceItemMapper.initMapper();
      ChoiceMapper.initMapper();
      ListSectionMapper.initMapper();
      SendMessageRequestMapper.initMapper();
      WhatsAppInteractiveHeaderMapper.initMapper();
    }

    public static LocalLazyInit init() {
      return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {

      public static final LocalLazyInit INSTANCE = new LocalLazyInit();
    }
  }
}
