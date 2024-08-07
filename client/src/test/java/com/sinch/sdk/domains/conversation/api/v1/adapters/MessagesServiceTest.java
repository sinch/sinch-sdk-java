package com.sinch.sdk.domains.conversation.api.v1.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.conversation.api.v1.MessagesService.MessageSource;
import com.sinch.sdk.domains.conversation.api.v1.adapters.messages.ConversationMessageMapper;
import com.sinch.sdk.domains.conversation.api.v1.internal.MessagesApi;
import com.sinch.sdk.domains.conversation.models.v1.messages.ConversationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.SendMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.response.SendMessageResponse;
import com.sinch.sdk.domains.conversation.models.v1.response.ConversationMessageDtoTest;
import com.sinch.sdk.models.ConversationContext;
import java.time.Instant;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class MessagesServiceTest extends BaseTest {

  @Mock ConversationContext context;
  @Mock MessagesApi api;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;

  MessagesService service;
  String uriPartID = "foovalue";

  @BeforeEach
  public void initMocks() {
    service = spy(new MessagesService(uriPartID, context, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void getDefault() throws ApiException {

    when(api.messagesGetMessage(
            eq(uriPartID), eq(ConversationMessageDtoTest.appConversationMessage.getId()), eq(null)))
        .thenReturn(
            ConversationMessageMapper.convert(ConversationMessageDtoTest.appConversationMessage));

    ConversationMessage response =
        service.get(ConversationMessageDtoTest.appConversationMessage.getId());

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(ConversationMessageDtoTest.appConversationMessage);
  }

  @Test
  void getBySource() throws ApiException {

    when(api.messagesGetMessage(
            eq(uriPartID),
            eq(ConversationMessageDtoTest.appConversationMessage.getId()),
            eq("CONVERSATION_SOURCE")))
        .thenReturn(
            ConversationMessageMapper.convert(ConversationMessageDtoTest.appConversationMessage));

    ConversationMessage response =
        service.get(
            ConversationMessageDtoTest.appConversationMessage.getId(),
            MessageSource.CONVERSATION_SOURCE);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(ConversationMessageDtoTest.appConversationMessage);
  }

  @Test
  void send() throws ApiException {
    SendMessageResponse expectedResponse =
        SendMessageResponse.builder()
            .setMessageId("message id")
            .setAcceptedTime(Instant.now())
            .build();
    when(api.messagesSendMessage(
            eq(uriPartID), eq(SendMessageDtoTest.sendTemplateMessageRequestDto)))
        .thenReturn(expectedResponse);

    SendMessageResponse response =
        service.sendMessage(SendMessageDtoTest.sendTemplateMessageRequestDto);

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expectedResponse);
  }
}
