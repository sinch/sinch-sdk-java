package com.sinch.sdk.domains.conversation.api.v1.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.conversation.api.v1.MessagesService.MessageSource;
import com.sinch.sdk.domains.conversation.api.v1.adapters.messages.ConversationMessageMapper;
import com.sinch.sdk.domains.conversation.api.v1.internal.MessagesApi;
import com.sinch.sdk.domains.conversation.models.v1.internal.ConversationMessageInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.ConversationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.ListMessagesResponseInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.MessageUpdateRequest;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.MessagesListRequest;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.SendMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.response.MessagesListResponse;
import com.sinch.sdk.domains.conversation.models.v1.messages.response.SendMessageResponse;
import com.sinch.sdk.domains.conversation.models.v1.response.ConversationMessageDtoTest;
import com.sinch.sdk.models.ConversationContext;
import java.time.Instant;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;

@TestWithResources
public class MessagesServiceTest extends ConversationBaseTest {

  @Mock ConversationContext context;
  @Mock MessagesApi api;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;
  @Captor ArgumentCaptor<String> projectIdCaptor;
  @Captor ArgumentCaptor<String> messageIdCaptor;
  @Captor ArgumentCaptor<String> messageSourceCaptor;

  MessagesService service;
  String uriPartID = "foovalue";

  @BeforeEach
  public void initMocks() {
    service = spy(new MessagesService(uriPartID, context, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  SendMessageResponse expectedResponse =
      SendMessageResponse.builder()
          .setMessageId("message id")
          .setAcceptedTime(Instant.now())
          .build();

  @GivenTextResource("/domains/conversation/v1/messages/ConversationMessageAppTextDto.json")
  static String jsonConversationMessageAppTextDto;

  @GivenJsonResource("/domains/conversation/v1/messages/response/MessagesListResponse-page-0.json")
  ListMessagesResponseInternal messageListPage0;

  @GivenJsonResource("/domains/conversation/v1/messages/response/MessagesListResponse-page-1.json")
  ListMessagesResponseInternal messageListPage1;

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

    when(api.messagesSendMessage(
            eq(uriPartID), eq(SendMessageDtoTest.sendTemplateMessageRequestDto)))
        .thenReturn(expectedResponse);

    SendMessageResponse response =
        service.sendMessage(SendMessageDtoTest.sendTemplateMessageRequestDto);

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expectedResponse);
  }

  @Test
  void sendCardMessage() throws ApiException {

    when(api.messagesSendMessage(eq(uriPartID), eq(SendMessageDtoTest.sendCardMessageRequestDto)))
        .thenReturn(expectedResponse);

    SendMessageResponse response =
        service.sendCardMessage(SendMessageDtoTest.sendCardMessageRequestDto);

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expectedResponse);
  }

  @Test
  void sendCarouselMessage() throws ApiException {

    when(api.messagesSendMessage(
            eq(uriPartID), eq(SendMessageDtoTest.sendCarouselMessageRequestDto)))
        .thenReturn(expectedResponse);

    SendMessageResponse response =
        service.sendCarouselMessage(SendMessageDtoTest.sendCarouselMessageRequestDto);

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expectedResponse);
  }

  @Test
  void sendChoiceMessage() throws ApiException {

    when(api.messagesSendMessage(eq(uriPartID), eq(SendMessageDtoTest.sendChoiceMessageRequestDto)))
        .thenReturn(expectedResponse);

    SendMessageResponse response =
        service.sendChoiceMessage(SendMessageDtoTest.sendChoiceMessageRequestDto);

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expectedResponse);
  }

  @Test
  void sendContactInfoMessage() throws ApiException {

    when(api.messagesSendMessage(
            eq(uriPartID), eq(SendMessageDtoTest.sendContactInfoMessageRequestDto)))
        .thenReturn(expectedResponse);

    SendMessageResponse response =
        service.sendContactInfoMessage(SendMessageDtoTest.sendContactInfoMessageRequestDto);

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expectedResponse);
  }

  @Test
  void sendListMessage() throws ApiException {

    when(api.messagesSendMessage(eq(uriPartID), eq(SendMessageDtoTest.sendListMessageRequestDto)))
        .thenReturn(expectedResponse);

    SendMessageResponse response =
        service.sendListMessage(SendMessageDtoTest.sendListMessageRequestDto);

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expectedResponse);
  }

  @Test
  void sendLocationMessage() throws ApiException {

    when(api.messagesSendMessage(
            eq(uriPartID), eq(SendMessageDtoTest.sendLocationMessageRequestDto)))
        .thenReturn(expectedResponse);

    SendMessageResponse response =
        service.sendLocationMessage(SendMessageDtoTest.sendLocationMessageRequestDto);

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expectedResponse);
  }

  @Test
  void sendMediaMessage() throws ApiException {

    when(api.messagesSendMessage(eq(uriPartID), eq(SendMessageDtoTest.sendMediaMessageRequestDto)))
        .thenReturn(expectedResponse);

    SendMessageResponse response =
        service.sendMediaMessage(SendMessageDtoTest.sendMediaMessageRequestDto);

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expectedResponse);
  }

  @Test
  void sendTemplateMessage() throws ApiException {

    when(api.messagesSendMessage(
            eq(uriPartID), eq(SendMessageDtoTest.sendTemplateMessageRequestDto)))
        .thenReturn(expectedResponse);

    SendMessageResponse response =
        service.sendTemplateMessage(SendMessageDtoTest.sendTemplateMessageRequestDto);

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expectedResponse);
  }

  @Test
  void sendTextMessage() throws ApiException {

    when(api.messagesSendMessage(eq(uriPartID), eq(SendMessageDtoTest.sendTextMessageRequestDto)))
        .thenReturn(expectedResponse);

    SendMessageResponse response =
        service.sendTextMessage(SendMessageDtoTest.sendTextMessageRequestDto);

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expectedResponse);
  }

  @Test
  void deleteDefault() throws ApiException {

    service.delete(ConversationMessageDtoTest.appConversationMessage.getId());

    verify(api)
        .messagesDeleteMessage(
            projectIdCaptor.capture(), messageIdCaptor.capture(), messageSourceCaptor.capture());

    Assertions.assertThat(projectIdCaptor.getValue()).isEqualTo(uriPartID);
    Assertions.assertThat(messageIdCaptor.getValue())
        .isEqualTo(ConversationMessageDtoTest.appConversationMessage.getId());
    Assertions.assertThat(messageSourceCaptor.getValue()).isNull();
  }

  @Test
  void deleteBySource() throws ApiException {

    service.delete(
        ConversationMessageDtoTest.appConversationMessage.getId(), MessageSource.DISPATCH_SOURCE);

    verify(api)
        .messagesDeleteMessage(
            projectIdCaptor.capture(), messageIdCaptor.capture(), messageSourceCaptor.capture());

    Assertions.assertThat(projectIdCaptor.getValue()).isEqualTo(uriPartID);
    Assertions.assertThat(messageIdCaptor.getValue())
        .isEqualTo(ConversationMessageDtoTest.appConversationMessage.getId());
    Assertions.assertThat(messageSourceCaptor.getValue()).isEqualTo("DISPATCH_SOURCE");
  }

  @Test
  void updateDefault() throws ApiException, JsonProcessingException {

    MessageUpdateRequest request =
        MessageUpdateRequest.builder().setMetadata("metadata value").build();

    ConversationMessageInternal deserialized =
        objectMapper.readValue(
            jsonConversationMessageAppTextDto, ConversationMessageInternal.class);

    when(api.messagesUpdateMessageMetadata(
            eq(uriPartID),
            eq(ConversationMessageDtoTest.appConversationMessage.getId()),
            eq(request),
            eq(null)))
        .thenReturn(deserialized);

    ConversationMessage response =
        service.update(ConversationMessageDtoTest.appConversationMessage.getId(), request);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(ConversationMessageDtoTest.appConversationMessage);
  }

  @Test
  void updateBySource() throws ApiException, JsonProcessingException {

    MessageUpdateRequest request =
        MessageUpdateRequest.builder().setMetadata("metadata value").build();

    ConversationMessageInternal deserialized =
        objectMapper.readValue(
            jsonConversationMessageAppTextDto, ConversationMessageInternal.class);

    when(api.messagesUpdateMessageMetadata(
            eq(uriPartID),
            eq(ConversationMessageDtoTest.appConversationMessage.getId()),
            eq(request),
            eq("DISPATCH_SOURCE")))
        .thenReturn(deserialized);

    ConversationMessage response =
        service.update(
            ConversationMessageDtoTest.appConversationMessage.getId(),
            MessageSource.DISPATCH_SOURCE,
            request);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(ConversationMessageDtoTest.appConversationMessage);
  }

  @Test
  void list() throws ApiException, JsonProcessingException {

    when(api.messagesListMessages(
            eq(uriPartID),
            eq(null),
            eq(null),
            eq(null),
            eq(null),
            eq(null),
            eq(null),
            eq(null),
            eq(null),
            eq(null),
            eq(null),
            eq(null),
            eq(null)))
        .thenReturn(messageListPage0);

    when(api.messagesListMessages(
            eq(uriPartID),
            eq(null),
            eq(null),
            eq(null),
            eq(null),
            eq(null),
            eq(null),
            eq(null),
            eq(messageListPage0.getNextPageToken()),
            eq(null),
            eq(null),
            eq(null),
            eq(null)))
        .thenReturn(messageListPage1);

    MessagesListRequest request = MessagesListRequest.builder().build();

    MessagesListResponse response0 = service.list(request);

    Assertions.assertThat(response0.getContent().size()).isEqualTo(1);
    Assertions.assertThat(response0.hasNextPage()).isEqualTo(true);

    MessagesListResponse response1 = response0.nextPage();
    Assertions.assertThat(response1.getContent().size()).isEqualTo(1);
    Assertions.assertThat(response1.hasNextPage()).isEqualTo(false);
  }
}
