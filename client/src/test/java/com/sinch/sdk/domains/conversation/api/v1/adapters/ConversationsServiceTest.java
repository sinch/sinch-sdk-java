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
import com.sinch.sdk.domains.conversation.api.v1.ConversationsService;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.conversations.Conversation;
import com.sinch.sdk.domains.conversation.models.v1.conversations.ConversationDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.conversations.request.ConversationsListQueryParameters;
import com.sinch.sdk.domains.conversation.models.v1.conversations.request.ConversationsUpdateQueryParameters;
import com.sinch.sdk.domains.conversation.models.v1.conversations.request.CreateConversationRequestTest;
import com.sinch.sdk.domains.conversation.models.v1.conversations.request.InjectEventDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.conversations.request.InjectMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.conversations.request.RecentConversationsListQueryParameters;
import com.sinch.sdk.domains.conversation.models.v1.conversations.request.RecentConversationsListQueryParameters.OrderEnum;
import com.sinch.sdk.domains.conversation.models.v1.conversations.response.ConversationRecentMessage;
import com.sinch.sdk.domains.conversation.models.v1.conversations.response.ConversationRecentMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.conversations.response.ConversationsListResponse;
import com.sinch.sdk.domains.conversation.models.v1.conversations.response.RecentConversationsListResponse;
import com.sinch.sdk.domains.conversation.models.v1.request.MetadataUpdateStrategy;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class ConversationsServiceTest extends ConversationBaseTest {
  @Mock HttpClient httpClient;
  @Mock ServerConfiguration serverConfiguration;
  @Mock Map<String, AuthManager> authManagers;

  static final String uriUUID = "foo";
  static final Collection<String> AUTH_NAMES = Arrays.asList("Basic", "oAuth2");

  ConversationsService service;

  @GivenTextResource(
      "/domains/conversation/v1/conversations/request/CreateConversationRequestDto.json")
  String jsonCreateConversationRequestDto;

  @GivenTextResource("domains/conversation/v1/conversations/ConversationRequestDto.json")
  String jsonConversationRequest;

  @GivenTextResource("domains/conversation/v1/conversations/ConversationResponseDto.json")
  String jsonConversationResponse;

  @GivenTextResource(
      "/domains/conversation/v1/conversations/response/ConversationsListResponse-page-0.json")
  String conversationsListPage0;

  @GivenTextResource(
      "/domains/conversation/v1/conversations/response/ConversationsListResponse-page-1.json")
  String conversationsListPage1;

  @GivenTextResource(
      "/domains/conversation/v1/conversations/response/ConversationsListResponse-page-2.json")
  String conversationsListPage2;

  @GivenTextResource(
      "/domains/conversation/v1/conversations/response/ConversationsListRecentResponse-page-0.json")
  String conversationsRecentListPage0;

  @GivenTextResource(
      "/domains/conversation/v1/conversations/response/ConversationsListRecentResponse-page-1.json")
  String conversationsRecentListPage1;

  @GivenTextResource(
      "/domains/conversation/v1/conversations/request/InjectContactMessageRequestDto.json")
  static String jsonInjectContactMessageRequestDto;

  @GivenTextResource("/domains/conversation/v1/conversations/request/InjectEventRequestDto.json")
  static String jsonInjectEventRequestDto;

  @BeforeEach
  public void initMocks() {
    service =
        new ConversationsServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance(), uriUUID);
  }

  @Test
  void create() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format("/v1/projects/%s/conversations", URLPathUtils.encodePathSegment(uriUUID)),
            HttpMethod.POST,
            Collections.emptyList(),
            jsonCreateConversationRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonConversationResponse.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    Conversation response =
        service.create(CreateConversationRequestTest.createConversationRequestDto);

    TestHelpers.recursiveEquals(response, ConversationDtoTest.conversationResponse);
  }

  @Test
  void get() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/conversations/%s",
                URLPathUtils.encodePathSegment(uriUUID),
                URLPathUtils.encodePathSegment(ConversationDtoTest.conversationRequest.getId())),
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonConversationResponse.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    Conversation response = service.get(ConversationDtoTest.conversationRequest.getId());

    TestHelpers.recursiveEquals(response, ConversationDtoTest.conversationResponse);
  }

  @Test
  void list() throws ApiException {

    HttpRequest httpRequest1 =
        new HttpRequest(
            String.format("/v1/projects/%s/conversations", URLPathUtils.encodePathSegment(uriUUID)),
            HttpMethod.GET,
            Arrays.asList(
                new URLParameter("app_id", "conversation app Id", STYLE.FORM, true),
                new URLParameter("contact_id", "contact id", STYLE.FORM, true),
                new URLParameter("page_size", 1, STYLE.FORM, true),
                new URLParameter(
                    "active_channel", ConversationChannel.MESSENGER, STYLE.FORM, true)),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpRequest httpRequest2 =
        new HttpRequest(
            String.format("/v1/projects/%s/conversations", URLPathUtils.encodePathSegment(uriUUID)),
            HttpMethod.GET,
            Arrays.asList(
                new URLParameter("app_id", "conversation app Id", STYLE.FORM, true),
                new URLParameter("contact_id", "contact id", STYLE.FORM, true),
                new URLParameter("page_size", 1, STYLE.FORM, true),
                new URLParameter(
                    "page_token",
                    "ChowMUo1NUVOVERUSFlGQVlKMFE1WFpaSktSVhIaMDFITkIzMzY0UFdCQkcyR1paV1ZWVDNERDI=",
                    STYLE.FORM,
                    true),
                new URLParameter(
                    "active_channel", ConversationChannel.MESSENGER, STYLE.FORM, true)),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpRequest httpRequest3 =
        new HttpRequest(
            String.format("/v1/projects/%s/conversations", URLPathUtils.encodePathSegment(uriUUID)),
            HttpMethod.GET,
            Arrays.asList(
                new URLParameter("app_id", "conversation app Id", STYLE.FORM, true),
                new URLParameter("contact_id", "contact id", STYLE.FORM, true),
                new URLParameter("page_size", 1, STYLE.FORM, true),
                new URLParameter(
                    "page_token",
                    "ChowMUo1NUVBSk1FNDZQMlI4SFIxRjVZRjYxWhIaMDFITkIzMzY0UFdCQkcyR1paV1ZWVDNERDI=",
                    STYLE.FORM,
                    true),
                new URLParameter(
                    "active_channel", ConversationChannel.MESSENGER, STYLE.FORM, true)),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse1 =
        new HttpResponse(200, null, Collections.emptyMap(), conversationsListPage0.getBytes());
    HttpResponse httpResponse2 =
        new HttpResponse(200, null, Collections.emptyMap(), conversationsListPage1.getBytes());
    HttpResponse httpResponse3 =
        new HttpResponse(200, null, Collections.emptyMap(), conversationsListPage2.getBytes());

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
    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest3))))
        .thenReturn(httpResponse3);

    ConversationsListQueryParameters request =
        ConversationsListQueryParameters.builder()
            .setAppId("conversation app Id")
            .setContactId("contact id")
            .setPageSize(1)
            .setActiveChannel(ConversationChannel.MESSENGER)
            .build();

    ConversationsListResponse response1 = service.list(request);
    Collection<Conversation> content = response1.getContent();
    Assertions.assertThat(content.size()).isEqualTo(1);
    TestHelpers.recursiveEquals(
        content.stream().findFirst().orElse(null), ConversationDtoTest.conversationResponse);
    Assertions.assertThat(response1.hasNextPage()).isEqualTo(true);

    ConversationsListResponse response2 = response1.nextPage();
    content = response2.getContent();
    Assertions.assertThat(content.size()).isEqualTo(1);
    TestHelpers.recursiveEquals(
        content.stream().findFirst().orElse(null), ConversationDtoTest.conversationResponse);
    Assertions.assertThat(response2.hasNextPage()).isEqualTo(true);

    ConversationsListResponse response3 = response2.nextPage();
    content = response3.getContent();
    Assertions.assertThat(content.size()).isEqualTo(0);
    Assertions.assertThat(response3.hasNextPage()).isEqualTo(false);
  }

  @Test
  void listRecent() throws ApiException {

    HttpRequest httpRequest1 =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/conversations:recent", URLPathUtils.encodePathSegment(uriUUID)),
            HttpMethod.GET,
            Arrays.asList(
                new URLParameter("app_id", "conversation app Id", STYLE.FORM, true),
                new URLParameter("only_active", true, STYLE.FORM, true),
                new URLParameter("page_size", 1, STYLE.FORM, true),
                new URLParameter("order", OrderEnum.ASC, STYLE.FORM, true)),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpRequest httpRequest2 =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/conversations:recent", URLPathUtils.encodePathSegment(uriUUID)),
            HttpMethod.GET,
            Arrays.asList(
                new URLParameter("app_id", "conversation app Id", STYLE.FORM, true),
                new URLParameter("only_active", true, STYLE.FORM, true),
                new URLParameter("page_size", 1, STYLE.FORM, true),
                new URLParameter("page_token", "1", STYLE.FORM, true),
                new URLParameter("order", OrderEnum.ASC, STYLE.FORM, true)),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse1 =
        new HttpResponse(
            200, null, Collections.emptyMap(), conversationsRecentListPage0.getBytes());
    HttpResponse httpResponse2 =
        new HttpResponse(
            200, null, Collections.emptyMap(), conversationsRecentListPage1.getBytes());

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

    RecentConversationsListQueryParameters request =
        RecentConversationsListQueryParameters.builder()
            .setAppId("conversation app Id")
            .setOnlyActive(true)
            .setPageSize(1)
            .setOrder(OrderEnum.ASC)
            .build();

    RecentConversationsListResponse response0 = service.listRecent(request);
    Collection<ConversationRecentMessage> content = response0.getContent();
    Assertions.assertThat(content.size()).isEqualTo(1);
    TestHelpers.recursiveEquals(
        content.stream().findFirst().orElse(null),
        ConversationRecentMessageDtoTest.conversationRecentMessage);
    Assertions.assertThat(response0.hasNextPage()).isEqualTo(true);

    RecentConversationsListResponse response1 = response0.nextPage();
    content = response1.getContent();
    Assertions.assertThat(content.size()).isEqualTo(1);
    TestHelpers.recursiveEquals(
        content.stream().findFirst().orElse(null),
        ConversationRecentMessageDtoTest.conversationRecentMessage);
    Assertions.assertThat(response1.hasNextPage()).isEqualTo(false);
  }

  @Test
  void delete() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/conversations/%s",
                URLPathUtils.encodePathSegment(uriUUID),
                URLPathUtils.encodePathSegment(ConversationDtoTest.conversationRequest.getId())),
            HttpMethod.DELETE,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse = new HttpResponse(200, null, Collections.emptyMap(), null);

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    service.delete(ConversationDtoTest.conversationRequest.getId());
  }

  @Test
  void stopActive() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/conversations/%s:stop",
                URLPathUtils.encodePathSegment(uriUUID),
                URLPathUtils.encodePathSegment(ConversationDtoTest.conversationRequest.getId())),
            HttpMethod.POST,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse = new HttpResponse(200, null, Collections.emptyMap(), null);

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    service.stopActive(ConversationDtoTest.conversationRequest.getId());
  }

  @Test
  void update() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/conversations/%s",
                URLPathUtils.encodePathSegment(uriUUID),
                URLPathUtils.encodePathSegment(ConversationDtoTest.conversationRequest.getId())),
            HttpMethod.PATCH,
            Arrays.asList(
                new URLParameter(
                    "metadata_update_strategy",
                    MetadataUpdateStrategy.MERGE_PATCH,
                    STYLE.FORM,
                    true)),
            jsonConversationRequest,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonConversationResponse.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    ConversationsUpdateQueryParameters queryParameters =
        ConversationsUpdateQueryParameters.builder()
            .setMetadataUpdateStrategy(MetadataUpdateStrategy.MERGE_PATCH)
            .build();
    Conversation response =
        service.update(
            ConversationDtoTest.conversationRequest.getId(),
            queryParameters,
            ConversationDtoTest.conversationRequest);

    TestHelpers.recursiveEquals(response, ConversationDtoTest.conversationResponse);
  }

  @Test
  void injectMessage() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/conversations/%s:inject-message",
                URLPathUtils.encodePathSegment(uriUUID),
                URLPathUtils.encodePathSegment(
                    InjectMessageDtoTest.injectContactMessage.getConversationId())),
            HttpMethod.POST,
            Collections.emptyList(),
            jsonInjectContactMessageRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse = new HttpResponse(200, null, Collections.emptyMap(), null);

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    service.injectMessage(
        InjectMessageDtoTest.injectContactMessage.getConversationId(),
        InjectMessageDtoTest.injectContactMessage);
  }

  @Test
  void injectEvent() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/conversations/%s:inject-event",
                URLPathUtils.encodePathSegment(uriUUID),
                URLPathUtils.encodePathSegment(InjectEventDtoTest.injectEvent.getConversationId())),
            HttpMethod.POST,
            Collections.emptyList(),
            jsonInjectEventRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);

    HttpResponse httpResponse = new HttpResponse(200, null, Collections.emptyMap(), null);

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    service.injectEvent(
        InjectEventDtoTest.injectEvent.getConversationId(), InjectEventDtoTest.injectEvent);
  }
}
