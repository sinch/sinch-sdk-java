package com.sinch.sdk.domains.conversation.api.v1.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.conversation.api.v1.internal.ConversationApi;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.conversation.Conversation;
import com.sinch.sdk.domains.conversation.models.v1.conversation.internal.ListConversationsResponseInternal;
import com.sinch.sdk.domains.conversation.models.v1.conversation.internal.ListRecentConversationsResponseInternal;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.ConversationsListRecentRequest;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.ConversationsListRecentRequest.OrderEnum;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.ConversationsListRequest;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.InjectEventRequest;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.InjectMessageRequestBase;
import com.sinch.sdk.domains.conversation.models.v1.conversation.response.ConversationRecentMessage;
import com.sinch.sdk.domains.conversation.models.v1.conversation.response.ConversationsListRecentResponse;
import com.sinch.sdk.domains.conversation.models.v1.conversation.response.ConversationsListResponse;
import com.sinch.sdk.domains.conversation.models.v1.conversations.ConversationDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.conversations.request.CreateConversationRequestTest;
import com.sinch.sdk.domains.conversation.models.v1.conversations.request.InjectEventDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.conversations.request.InjectMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.conversations.response.ConversationRecentMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.request.MetadataUpdateStrategy;
import com.sinch.sdk.models.ConversationContext;
import java.util.Collection;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;

@TestWithResources
public class ConversationsServiceTest extends ConversationBaseTest {

  @Mock ConversationContext context;
  @Mock ConversationApi api;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;
  @Captor ArgumentCaptor<String> projectIdCaptor;
  @Captor ArgumentCaptor<String> conversationIdCaptor;
  @Captor ArgumentCaptor<InjectMessageRequestBase> injectMessageCaptor;
  @Captor ArgumentCaptor<InjectEventRequest> injectEventCaptor;

  ConversationsService service;
  String uriPartID = "foovalue";

  @BeforeEach
  public void initMocks() {
    service = spy(new ConversationsService(uriPartID, context, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @GivenJsonResource(
      "/domains/conversation/v1/conversations/response/ConversationsListResponse-page-0.json")
  ListConversationsResponseInternal conversationsListPage0;

  @GivenJsonResource(
      "/domains/conversation/v1/conversations/response/ConversationsListResponse-page-1.json")
  ListConversationsResponseInternal conversationsListPage1;

  @GivenJsonResource(
      "/domains/conversation/v1/conversations/response/ConversationsListResponse-page-2.json")
  ListConversationsResponseInternal conversationsListPage2;

  @GivenJsonResource(
      "/domains/conversation/v1/conversations/response/ConversationsListRecentResponse-page-0.json")
  ListRecentConversationsResponseInternal conversationsRecentListPage0;

  @GivenJsonResource(
      "/domains/conversation/v1/conversations/response/ConversationsListRecentResponse-page-1.json")
  ListRecentConversationsResponseInternal conversationsRecentListPage1;

  @Test
  void create() throws ApiException {

    when(api.conversationCreateConversation(
            eq(uriPartID), eq(CreateConversationRequestTest.createConversationRequestDto)))
        .thenReturn(ConversationDtoTest.conversation);

    Conversation response =
        service.create(CreateConversationRequestTest.createConversationRequestDto);

    TestHelpers.recursiveEquals(response, ConversationDtoTest.conversation);
  }

  @Test
  void get() throws ApiException {

    when(api.conversationGetConversation(
            eq(uriPartID), eq(ConversationDtoTest.conversation.getId())))
        .thenReturn(ConversationDtoTest.conversation);

    Conversation response = service.get(ConversationDtoTest.conversation.getId());

    TestHelpers.recursiveEquals(response, ConversationDtoTest.conversation);
  }

  @Test
  void list() throws ApiException {

    when(api.conversationListConversations(
            eq(uriPartID),
            eq("conversation app Id"),
            eq("contact id"),
            eq(null),
            eq(1),
            eq(null),
            eq(ConversationChannel.MESSENGER)))
        .thenReturn(conversationsListPage0);

    when(api.conversationListConversations(
            eq(uriPartID),
            eq("conversation app Id"),
            eq("contact id"),
            eq(null),
            eq(1),
            eq("ChowMUo1NUVOVERUSFlGQVlKMFE1WFpaSktSVhIaMDFITkIzMzY0UFdCQkcyR1paV1ZWVDNERDI="),
            eq(ConversationChannel.MESSENGER)))
        .thenReturn(conversationsListPage1);

    when(api.conversationListConversations(
            eq(uriPartID),
            eq("conversation app Id"),
            eq("contact id"),
            eq(null),
            eq(1),
            eq("ChowMUo1NUVBSk1FNDZQMlI4SFIxRjVZRjYxWhIaMDFITkIzMzY0UFdCQkcyR1paV1ZWVDNERDI="),
            eq(ConversationChannel.MESSENGER)))
        .thenReturn(conversationsListPage2);
    ConversationsListRequest request =
        ConversationsListRequest.builder()
            .setAppId("conversation app Id")
            .setContactId("contact id")
            .setPageSize(1)
            .setActiveChannel(ConversationChannel.MESSENGER)
            .build();

    ConversationsListResponse response0 = service.list(request);
    Collection<Conversation> content = response0.getContent();
    Assertions.assertThat(content.size()).isEqualTo(1);
    TestHelpers.recursiveEquals(
        content.stream().findFirst().orElse(null), ConversationDtoTest.conversation);
    Assertions.assertThat(response0.hasNextPage()).isEqualTo(true);

    ConversationsListResponse response1 = response0.nextPage();
    content = response1.getContent();
    Assertions.assertThat(content.size()).isEqualTo(1);
    TestHelpers.recursiveEquals(
        content.stream().findFirst().orElse(null), ConversationDtoTest.conversation);
    Assertions.assertThat(response1.hasNextPage()).isEqualTo(true);

    ConversationsListResponse response2 = response1.nextPage();
    content = response2.getContent();
    Assertions.assertThat(content.size()).isEqualTo(0);
    Assertions.assertThat(response2.hasNextPage()).isEqualTo(false);
  }

  @Test
  void listRecent() throws ApiException {

    when(api.conversationListRecentConversations(
            eq(uriPartID), eq("conversation app Id"), eq(true), eq(1), eq(null), eq("ASC")))
        .thenReturn(conversationsRecentListPage0);

    when(api.conversationListRecentConversations(
            eq(uriPartID), eq("conversation app Id"), eq(true), eq(1), eq("1"), eq("ASC")))
        .thenReturn(conversationsRecentListPage1);

    ConversationsListRecentRequest request =
        ConversationsListRecentRequest.builder()
            .setAppId("conversation app Id")
            .setOnlyActive(true)
            .setPageSize(1)
            .setOrder(OrderEnum.ASC)
            .build();

    ConversationsListRecentResponse response0 = service.listRecent(request);
    Collection<ConversationRecentMessage> content = response0.getContent();
    Assertions.assertThat(content.size()).isEqualTo(1);
    TestHelpers.recursiveEquals(
        content.stream().findFirst().orElse(null),
        ConversationRecentMessageDtoTest.conversationRecentMessage);
    Assertions.assertThat(response0.hasNextPage()).isEqualTo(true);

    ConversationsListRecentResponse response1 = response0.nextPage();
    content = response1.getContent();
    Assertions.assertThat(content.size()).isEqualTo(1);
    TestHelpers.recursiveEquals(
        content.stream().findFirst().orElse(null),
        ConversationRecentMessageDtoTest.conversationRecentMessage);
    Assertions.assertThat(response1.hasNextPage()).isEqualTo(false);
  }

  @Test
  void stopActive() throws ApiException {

    service.stopActive(ConversationDtoTest.conversation.getId());

    verify(api)
        .conversationStopActiveConversation(
            projectIdCaptor.capture(), conversationIdCaptor.capture());

    Assertions.assertThat(projectIdCaptor.getValue()).isEqualTo(uriPartID);
    Assertions.assertThat(conversationIdCaptor.getValue())
        .isEqualTo(ConversationDtoTest.conversation.getId());
  }

  @Test
  void delete() throws ApiException {

    service.delete(ConversationDtoTest.conversation.getId());

    verify(api)
        .conversationDeleteConversation(projectIdCaptor.capture(), conversationIdCaptor.capture());

    Assertions.assertThat(projectIdCaptor.getValue()).isEqualTo(uriPartID);
    Assertions.assertThat(conversationIdCaptor.getValue())
        .isEqualTo(ConversationDtoTest.conversation.getId());
  }

  @Test
  void update() throws ApiException {
    when(api.conversationUpdateConversation(
            eq(uriPartID),
            eq(ConversationDtoTest.conversation.getId()),
            eq(ConversationDtoTest.conversation),
            eq(null),
            eq(MetadataUpdateStrategy.MERGE_PATCH)))
        .thenReturn(ConversationDtoTest.conversation);

    Conversation response =
        service.update(
            ConversationDtoTest.conversation.getId(),
            MetadataUpdateStrategy.MERGE_PATCH,
            ConversationDtoTest.conversation);

    TestHelpers.recursiveEquals(response, ConversationDtoTest.conversation);
  }

  @Test
  void injectMessage() throws ApiException {

    service.injectMessage(
        InjectMessageDtoTest.injectContactMessage.getConversationId(),
        InjectMessageDtoTest.injectContactMessage);

    verify(api)
        .conversationInjectMessage(
            projectIdCaptor.capture(),
            conversationIdCaptor.capture(),
            injectMessageCaptor.capture());

    Assertions.assertThat(projectIdCaptor.getValue()).isEqualTo(uriPartID);
    Assertions.assertThat(conversationIdCaptor.getValue())
        .isEqualTo(InjectMessageDtoTest.injectContactMessage.getConversationId());
    TestHelpers.recursiveEquals(
        injectMessageCaptor.getValue(), InjectMessageDtoTest.injectContactMessage);
  }

  @Test
  void injectEvent() throws ApiException {

    service.injectEvent(
        InjectEventDtoTest.injectEvent.getConversationId(), InjectEventDtoTest.injectEvent);

    verify(api)
        .eventsInjectEvent(
            projectIdCaptor.capture(), conversationIdCaptor.capture(), injectEventCaptor.capture());

    Assertions.assertThat(projectIdCaptor.getValue()).isEqualTo(uriPartID);
    Assertions.assertThat(conversationIdCaptor.getValue())
        .isEqualTo(InjectEventDtoTest.injectEvent.getConversationId());
    TestHelpers.recursiveEquals(injectEventCaptor.getValue(), InjectEventDtoTest.injectEvent);
  }
}
