package com.sinch.sdk.domains.conversation.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.adapters.messages.ChoiceItemMapper;
import com.sinch.sdk.domains.conversation.adapters.messages.ListSectionMapper;
import com.sinch.sdk.domains.conversation.adapters.messages.SendMessageRequestMapper;
import com.sinch.sdk.domains.conversation.api.v1.MessagesApi;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.SendMessageRequest;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.SendMessageRequestImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.response.SendMessageResponse;
import com.sinch.sdk.domains.conversation.models.v1.response.ConversationMessage;
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

  public SendMessageResponse send(SendMessageRequest request) throws ApiException {
    return getApi().messagesSendMessage(uriUUID, request);
  }

  public ConversationMessage get(String messageId) {
    return getApi().messagesGetMessage(uriUUID, messageId, null);
  }

  static final class LocalLazyInit {

    private LocalLazyInit() {
      Mapper.getInstance().addMixIn(SendMessageRequestImpl.class, SendMessageRequestMapper.class);
      ChoiceItemMapper.initMapper();
      ListSectionMapper.initMapper();
    }

    public static LocalLazyInit init() {
      return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {

      public static final LocalLazyInit INSTANCE = new LocalLazyInit();
    }
  }
}
