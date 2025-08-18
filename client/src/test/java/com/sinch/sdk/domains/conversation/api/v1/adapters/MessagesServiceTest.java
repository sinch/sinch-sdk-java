package com.sinch.sdk.domains.conversation.api.v1.adapters;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpContentType;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpRequestTest.HttpRequestMatcher;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.http.URLParameter;
import com.sinch.sdk.core.http.URLParameter.STYLE;
import com.sinch.sdk.core.http.URLPathUtils;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.conversation.api.v1.MessagesService;
import com.sinch.sdk.domains.conversation.models.v1.messages.ConversationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ConversationMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.MessagesDeleteQueryParameters;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.MessagesGetQueryParameters;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.MessagesSource;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.MessagesUpdateQueryParameters;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.SendMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.UpdateMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.response.MessagesListResponse;
import com.sinch.sdk.domains.conversation.models.v1.messages.response.SendMessageResponse;
import com.sinch.sdk.domains.conversation.models.v1.messages.response.SendMessageResponseDtoTest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class MessagesServiceTest extends ConversationBaseTest {
  @Mock HttpClient httpClient;
  @Mock ServerConfiguration serverConfiguration;
  @Mock Map<String, AuthManager> authManagers;

  static final String uriUUID = "foo";
  static final Collection<String> AUTH_NAMES = Arrays.asList("Basic", "oAuth2");

  MessagesService service;

  @BeforeEach
  public void initMocks() {
    service =
        new MessagesServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance(), uriUUID);
  }

  @GivenTextResource("/domains/conversation/v1/messages/ConversationMessageAppTextResponseDto.json")
  String jsonConversationMessageAppTextResponseDto;

  @GivenTextResource("domains/conversation/v1/messages/response/SendMessageResponseDto.json")
  String sendMessageResponseDto;

  @GivenTextResource("/domains/conversation/v1/messages/request/SendTemplateMessageRequestDto.json")
  String jsonSendTemplateMessageRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/request/SendCardMessageRequestDto.json")
  String jsonSendCardMessageRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/request/SendCarouselMessageRequestDto.json")
  String jsonSendCarouselMessageRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/request/SendChoiceMessageRequestDto.json")
  String jsonSendChoiceMessageRequestDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/request/SendContactInfoMessageRequestDto.json")
  String jsonSendContactInfoMessageRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/request/SendListMessageRequestDto.json")
  String jsonSendListMessageRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/request/SendLocationMessageRequestDto.json")
  String jsonSendLocationMessageRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/request/SendMediaMessageRequestDto.json")
  String jsonSendMediaMessageRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/request/SendTextMessageRequestDto.json")
  String jsonSendTextMessageRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/request/MessageUpdateRequestDto.json")
  String jsonMessageUpdateRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/response/MessagesListResponse-page-0.json")
  String messageListPage0;

  @GivenTextResource("/domains/conversation/v1/messages/response/MessagesListResponse-page-1.json")
  String messageListPage1;

  @Test
  void getDefault() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/messages/%s",
                URLPathUtils.encodePathSegment(uriUUID),
                URLPathUtils.encodePathSegment(
                    ConversationMessageDtoTest.appConversationMessageRequest.getId())),
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200,
            null,
            Collections.emptyMap(),
            jsonConversationMessageAppTextResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    ConversationMessage response =
        service.get(ConversationMessageDtoTest.appConversationMessageRequest.getId());

    TestHelpers.recursiveEquals(
        response, ConversationMessageDtoTest.appConversationMessageResponse);
  }

  @Test
  void getBySource() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/messages/%s",
                URLPathUtils.encodePathSegment(uriUUID),
                URLPathUtils.encodePathSegment(
                    ConversationMessageDtoTest.appConversationMessageRequest.getId())),
            HttpMethod.GET,
            Arrays.asList(
                new URLParameter(
                    "messages_source", MessagesSource.CONVERSATION_SOURCE, STYLE.FORM, true)),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200,
            null,
            Collections.emptyMap(),
            jsonConversationMessageAppTextResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    MessagesGetQueryParameters queryParameters =
        MessagesGetQueryParameters.builder()
            .setMessagesSource(MessagesSource.CONVERSATION_SOURCE)
            .build();
    ConversationMessage response =
        service.get(
            ConversationMessageDtoTest.appConversationMessageRequest.getId(), queryParameters);

    TestHelpers.recursiveEquals(
        response, ConversationMessageDtoTest.appConversationMessageResponse);
  }

  @Test
  void send() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format("/v1/projects/%s/messages:send", URLPathUtils.encodePathSegment(uriUUID)),
            HttpMethod.POST,
            Collections.emptyList(),
            jsonSendTemplateMessageRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), sendMessageResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    SendMessageResponse response =
        service.sendMessage(SendMessageDtoTest.sendTemplateMessageRequestDto);

    TestHelpers.recursiveEquals(response, SendMessageResponseDtoTest.expectedResponse);
  }

  @Test
  void sendCardMessage() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format("/v1/projects/%s/messages:send", URLPathUtils.encodePathSegment(uriUUID)),
            HttpMethod.POST,
            Collections.emptyList(),
            jsonSendCardMessageRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), sendMessageResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    SendMessageResponse response =
        service.sendCardMessage(SendMessageDtoTest.sendCardMessageRequestDto);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(SendMessageResponseDtoTest.expectedResponse);
  }

  @Test
  void sendCarouselMessage() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format("/v1/projects/%s/messages:send", URLPathUtils.encodePathSegment(uriUUID)),
            HttpMethod.POST,
            Collections.emptyList(),
            jsonSendCarouselMessageRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), sendMessageResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    SendMessageResponse response =
        service.sendCarouselMessage(SendMessageDtoTest.sendCarouselMessageRequestDto);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(SendMessageResponseDtoTest.expectedResponse);
  }

  @Test
  void sendChoiceMessage() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format("/v1/projects/%s/messages:send", URLPathUtils.encodePathSegment(uriUUID)),
            HttpMethod.POST,
            Collections.emptyList(),
            jsonSendChoiceMessageRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), sendMessageResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    SendMessageResponse response =
        service.sendChoiceMessage(SendMessageDtoTest.sendChoiceMessageRequestDto);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(SendMessageResponseDtoTest.expectedResponse);
  }

  @Test
  void sendContactInfoMessage() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format("/v1/projects/%s/messages:send", URLPathUtils.encodePathSegment(uriUUID)),
            HttpMethod.POST,
            Collections.emptyList(),
            jsonSendContactInfoMessageRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), sendMessageResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    SendMessageResponse response =
        service.sendContactInfoMessage(SendMessageDtoTest.sendContactInfoMessageRequestDto);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(SendMessageResponseDtoTest.expectedResponse);
  }

  @Test
  void sendListMessage() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format("/v1/projects/%s/messages:send", URLPathUtils.encodePathSegment(uriUUID)),
            HttpMethod.POST,
            Collections.emptyList(),
            jsonSendListMessageRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), sendMessageResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);
    SendMessageResponse response =
        service.sendListMessage(SendMessageDtoTest.sendListMessageRequestDto);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(SendMessageResponseDtoTest.expectedResponse);
  }

  @Test
  void sendLocationMessage() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format("/v1/projects/%s/messages:send", URLPathUtils.encodePathSegment(uriUUID)),
            HttpMethod.POST,
            Collections.emptyList(),
            jsonSendLocationMessageRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), sendMessageResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);
    SendMessageResponse response =
        service.sendLocationMessage(SendMessageDtoTest.sendLocationMessageRequestDto);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(SendMessageResponseDtoTest.expectedResponse);
  }

  @Test
  void sendMediaMessage() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format("/v1/projects/%s/messages:send", URLPathUtils.encodePathSegment(uriUUID)),
            HttpMethod.POST,
            Collections.emptyList(),
            jsonSendMediaMessageRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), sendMessageResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);
    SendMessageResponse response =
        service.sendMediaMessage(SendMessageDtoTest.sendMediaMessageRequestDto);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(SendMessageResponseDtoTest.expectedResponse);
  }

  @Test
  void sendTemplateMessage() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format("/v1/projects/%s/messages:send", URLPathUtils.encodePathSegment(uriUUID)),
            HttpMethod.POST,
            Collections.emptyList(),
            jsonSendTemplateMessageRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), sendMessageResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    SendMessageResponse response =
        service.sendTemplateMessage(SendMessageDtoTest.sendTemplateMessageRequestDto);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(SendMessageResponseDtoTest.expectedResponse);
  }

  @Test
  void sendTextMessage() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format("/v1/projects/%s/messages:send", URLPathUtils.encodePathSegment(uriUUID)),
            HttpMethod.POST,
            Collections.emptyList(),
            jsonSendTextMessageRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), sendMessageResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    SendMessageResponse response =
        service.sendTextMessage(SendMessageDtoTest.sendTextMessageRequestDto);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(SendMessageResponseDtoTest.expectedResponse);
  }

  @Test
  void deleteDefault() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/messages/%s",
                URLPathUtils.encodePathSegment(uriUUID),
                URLPathUtils.encodePathSegment(
                    ConversationMessageDtoTest.appConversationMessageRequest.getId())),
            HttpMethod.DELETE,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200,
            null,
            Collections.emptyMap(),
            jsonConversationMessageAppTextResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    service.delete(ConversationMessageDtoTest.appConversationMessageRequest.getId());
  }

  @Test
  void deleteBySource() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/messages/%s",
                URLPathUtils.encodePathSegment(uriUUID),
                URLPathUtils.encodePathSegment(
                    ConversationMessageDtoTest.appConversationMessageRequest.getId())),
            HttpMethod.DELETE,
            Arrays.asList(
                new URLParameter(
                    "messages_source", MessagesSource.DISPATCH_SOURCE, STYLE.FORM, true)),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200,
            null,
            Collections.emptyMap(),
            jsonConversationMessageAppTextResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    MessagesDeleteQueryParameters queryParameters =
        MessagesDeleteQueryParameters.builder()
            .setMessagesSource(MessagesSource.DISPATCH_SOURCE)
            .build();

    service.delete(
        ConversationMessageDtoTest.appConversationMessageRequest.getId(), queryParameters);
  }

  @Test
  void updateDefault() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/messages/%s",
                URLPathUtils.encodePathSegment(uriUUID),
                URLPathUtils.encodePathSegment(
                    ConversationMessageDtoTest.appConversationMessageRequest.getId())),
            HttpMethod.PATCH,
            Collections.emptyList(),
            jsonMessageUpdateRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200,
            null,
            Collections.emptyMap(),
            jsonConversationMessageAppTextResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    ConversationMessage response =
        service.update(
            ConversationMessageDtoTest.appConversationMessageRequest.getId(),
            UpdateMessageDtoTest.updateMessageRequestDto);

    TestHelpers.recursiveEquals(
        response, ConversationMessageDtoTest.appConversationMessageResponse);
  }

  @Test
  void updateBySource() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/messages/%s",
                URLPathUtils.encodePathSegment(uriUUID),
                URLPathUtils.encodePathSegment(
                    ConversationMessageDtoTest.appConversationMessageRequest.getId())),
            HttpMethod.PATCH,
            Arrays.asList(
                new URLParameter(
                    "messages_source", MessagesSource.DISPATCH_SOURCE, STYLE.FORM, true)),
            jsonMessageUpdateRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200,
            null,
            Collections.emptyMap(),
            jsonConversationMessageAppTextResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    MessagesUpdateQueryParameters queryParameters =
        MessagesUpdateQueryParameters.builder()
            .setMessagesSource(MessagesSource.DISPATCH_SOURCE)
            .build();

    ConversationMessage response =
        service.update(
            ConversationMessageDtoTest.appConversationMessageRequest.getId(),
            queryParameters,
            UpdateMessageDtoTest.updateMessageRequestDto);

    TestHelpers.recursiveEquals(
        response, ConversationMessageDtoTest.appConversationMessageResponse);
  }

  @Test
  void list() throws ApiException {

    HttpRequest httpRequest1 =
        new HttpRequest(
            String.format("/v1/projects/%s/messages", URLPathUtils.encodePathSegment(uriUUID)),
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpRequest httpRequest2 =
        new HttpRequest(
            String.format("/v1/projects/%s/messages", URLPathUtils.encodePathSegment(uriUUID)),
            HttpMethod.GET,
            Arrays.asList(
                new URLParameter(
                    "page_token",
                    "ChowMUhRN1c0WjFSMTI2N0RCQlI4UzQ3TlZQOEoGCP70264G",
                    STYLE.FORM,
                    true)),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse1 =
        new HttpResponse(200, null, Collections.emptyMap(), messageListPage0.getBytes());
    HttpResponse httpResponse2 =
        new HttpResponse(200, null, Collections.emptyMap(), messageListPage1.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest1))))
        .thenReturn(httpResponse1);
    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest2))))
        .thenReturn(httpResponse2);

    MessagesListResponse response0 = service.list();

    Assertions.assertThat(response0.getContent().size()).isEqualTo(1);
    Assertions.assertThat(response0.hasNextPage()).isEqualTo(true);

    MessagesListResponse response1 = response0.nextPage();
    Assertions.assertThat(response1.getContent().size()).isEqualTo(1);
    Assertions.assertThat(response1.hasNextPage()).isEqualTo(false);
  }
}
