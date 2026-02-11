package com.sinch.sdk.domains.conversation.api.v1.adapters;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
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
import com.sinch.sdk.domains.conversation.api.v1.ContactsService;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentities;
import com.sinch.sdk.domains.conversation.models.v1.ContactId;
import com.sinch.sdk.domains.conversation.models.v1.contacts.Contact;
import com.sinch.sdk.domains.conversation.models.v1.contacts.ContactDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.contacts.request.ContactGetChannelProfileByChannelIdentityRequest;
import com.sinch.sdk.domains.conversation.models.v1.contacts.request.ContactGetChannelProfileByContactIdRequest;
import com.sinch.sdk.domains.conversation.models.v1.contacts.response.ContactsListResponse;
import com.sinch.sdk.domains.conversation.models.v1.contacts.response.GetChannelProfileResponse;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
class ContactsServiceTest extends BaseTest {

  @Mock HttpClient httpClient;
  @Mock ServerConfiguration serverConfiguration;
  @Mock Map<String, AuthManager> authManagers;

  static final String uriUUID = "foo";
  static final Collection<String> AUTH_NAMES = Arrays.asList("Basic", "oAuth2");

  ContactsService service;

  @GivenTextResource("/domains/conversation/v1/contacts/ContactListResponseDtoPage0.json")
  String jsonContactsListResponseDto1;

  @GivenTextResource("/domains/conversation/v1/contacts/ContactListResponseDtoPage1.json")
  String jsonContactsListResponseDto2;

  @GivenTextResource("/domains/conversation/v1/contacts/ContactCreateRequestDto.json")
  String jsonContactCreateRequestDto;

  @GivenTextResource("/domains/conversation/v1/contacts/ContactUpdateRequestDto.json")
  String jsonContactUpdateRequestDto;

  @GivenTextResource("/domains/conversation/v1/contacts/ContactDto.json")
  String jsonContactResponseDto;

  @GivenTextResource("/domains/conversation/v1/contacts/ContactGetChannelResponseDto.json")
  String jsonContactGetChannelResponseDto;

  @BeforeEach
  public void initMocks() {
    service =
        new ContactsServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance(), uriUUID);
  }

  @Test
  void list() throws ApiException {

    HttpRequest httpRequest1 =
        new HttpRequest(
            String.format("/v1/projects/%s/contacts", URLPathUtils.encodePathSegment(uriUUID)),
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpRequest httpRequest2 =
        new HttpRequest(
            String.format("/v1/projects/%s/contacts", URLPathUtils.encodePathSegment(uriUUID)),
            HttpMethod.GET,
            Arrays.asList(
                new URLParameter("page_token", "the next page token value", STYLE.FORM, true)),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse1 =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonContactsListResponseDto1.getBytes());
    HttpResponse httpResponse2 =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonContactsListResponseDto2.getBytes());

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

    ContactsListResponse response = service.list();

    Iterator<Contact> iterator = response.iterator();
    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);
    Contact item = iterator.next();
    TestHelpers.recursiveEquals(item, ContactDtoTest.expectedContactsListItemResponseDto);

    Assertions.assertThat(iterator.hasNext()).isEqualTo(false);
  }

  @Test
  void create() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format("/v1/projects/%s/contacts", URLPathUtils.encodePathSegment(uriUUID)),
            HttpMethod.POST,
            Collections.emptyList(),
            jsonContactCreateRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonContactResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    Contact response = service.create(ContactDtoTest.createContactRequestDto);

    TestHelpers.recursiveEquals(response, ContactDtoTest.expectedContactResponseDto);
  }

  @Test
  void get() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/contacts/%s",
                URLPathUtils.encodePathSegment(uriUUID),
                URLPathUtils.encodePathSegment(
                    ContactDtoTest.expectedContactsListItemResponseDto.getId())),
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonContactResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    Contact response = service.get(ContactDtoTest.expectedContactsListItemResponseDto.getId());

    TestHelpers.recursiveEquals(response, ContactDtoTest.expectedContactResponseDto);
  }

  @Test
  void update() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/contacts/%s",
                URLPathUtils.encodePathSegment(uriUUID),
                URLPathUtils.encodePathSegment(ContactDtoTest.expectedContactResponseDto.getId())),
            HttpMethod.PATCH,
            Collections.emptyList(),
            jsonContactUpdateRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonContactResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    Contact response =
        service.update(
            ContactDtoTest.expectedContactResponseDto.getId(),
            ContactDtoTest.updateContactRequestDto);

    TestHelpers.recursiveEquals(response, ContactDtoTest.expectedContactResponseDto);
  }

  @Test
  void merge() throws ApiException {
    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/contacts/%s:merge",
                URLPathUtils.encodePathSegment(uriUUID), URLPathUtils.encodePathSegment("foo 1")),
            HttpMethod.POST,
            Collections.emptyList(),
            HttpMapper.getInstance()
                .serialize(
                    Collections.singletonList(HttpContentType.APPLICATION_JSON),
                    ContactDtoTest.mergeContactRequestDto),
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonContactResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    Contact response = service.mergeContact("foo 1", ContactDtoTest.mergeContactRequestDto);

    TestHelpers.recursiveEquals(response, ContactDtoTest.expectedContactResponseDto);
  }

  @Test
  void channelProfileByContactId() throws ApiException {

    ContactId contactId =
        (ContactId) ContactDtoTest.contactGetChannelProfileByContactRequestDto.getRecipient();

    ContactGetChannelProfileByContactIdRequest request =
        ContactGetChannelProfileByContactIdRequest.builder()
            .setChannel(ContactDtoTest.contactGetChannelProfileByContactRequestDto.getChannel())
            .setContactId(contactId.getContactId())
            .setAppId(ContactDtoTest.contactGetChannelProfileByContactRequestDto.getAppId())
            .build();

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/contacts:getChannelProfile",
                URLPathUtils.encodePathSegment(uriUUID)),
            HttpMethod.POST,
            Collections.emptyList(),
            HttpMapper.getInstance()
                .serialize(Collections.singletonList(HttpContentType.APPLICATION_JSON), request),
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonContactGetChannelResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    GetChannelProfileResponse response = service.getChannelProfileByContactId(request);

    TestHelpers.recursiveEquals(response, ContactDtoTest.expectedChannelProfileResponseDto);
  }

  @Test
  void channelProfileByChannelIdentity() throws ApiException {

    ChannelRecipientIdentities channelIdentities =
        (ChannelRecipientIdentities)
            ContactDtoTest.contactGetChannelProfileByChannelRequestDto.getRecipient();

    ContactGetChannelProfileByChannelIdentityRequest request =
        ContactGetChannelProfileByChannelIdentityRequest.builder()
            .setChannelIdentities(channelIdentities)
            .setChannel(ContactDtoTest.contactGetChannelProfileByChannelRequestDto.getChannel())
            .setAppId(ContactDtoTest.contactGetChannelProfileByChannelRequestDto.getAppId())
            .build();

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/contacts:getChannelProfile",
                URLPathUtils.encodePathSegment(uriUUID)),
            HttpMethod.POST,
            Collections.emptyList(),
            HttpMapper.getInstance()
                .serialize(Collections.singletonList(HttpContentType.APPLICATION_JSON), request),
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonContactGetChannelResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    GetChannelProfileResponse response = service.getChannelProfileByChannelIdentity(request);

    TestHelpers.recursiveEquals(response, ContactDtoTest.expectedChannelProfileResponseDto);
  }

  @Test
  void delete() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/contacts/%s",
                URLPathUtils.encodePathSegment(uriUUID),
                URLPathUtils.encodePathSegment(ContactDtoTest.expectedContactResponseDto.getId())),
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

    service.delete(ContactDtoTest.expectedContactResponseDto.getId());
  }
}
