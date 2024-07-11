package com.sinch.sdk.domains.conversation.api.v1.adapters;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.conversation.api.v1.internal.ContactApi;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentities;
import com.sinch.sdk.domains.conversation.models.v1.ContactId;
import com.sinch.sdk.domains.conversation.models.v1.contact.Contact;
import com.sinch.sdk.domains.conversation.models.v1.contact.ContactDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.ContactGetChannelProfileByChannelIdentityRequest;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.ContactGetChannelProfileByContactIdRequest;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.MergeContactRequest;
import com.sinch.sdk.domains.conversation.models.v1.contact.response.ContactListResponse;
import com.sinch.sdk.models.ConversationContext;
import java.util.Iterator;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
class ContactServiceTest extends BaseTest {

  @Mock ConversationContext context;
  @Mock ContactApi api;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;

  ContactService service;
  String uriPartID = "foovalue";

  @BeforeEach
  public void initMocks() {
    service = spy(new ContactService(uriPartID, context, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void list() throws ApiException {

    when(api.contactListContacts(eq(uriPartID), eq(null), eq(null), eq(null), eq(null), eq(null)))
        .thenReturn(ContactDtoTest.expectedContactListResponseDtoPage0);

    when(api.contactListContacts(
            eq(uriPartID), eq(null), eq("the next page token value"), eq(null), eq(null), eq(null)))
        .thenReturn(ContactDtoTest.expectedContactListResponseDtoPage1);

    ContactListResponse response = service.list(null);

    Iterator<Contact> iterator = response.iterator();
    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);
    Contact item = iterator.next();
    Assertions.assertThat(item)
        .usingRecursiveComparison()
        .isEqualTo(ContactDtoTest.expectedContactResponseDto);

    Assertions.assertThat(iterator.hasNext()).isEqualTo(false);
  }

  @Test
  void create() throws ApiException {

    when(api.contactCreateContact(eq(uriPartID), eq(ContactDtoTest.createContactRequestDto)))
        .thenReturn(ContactDtoTest.expectedCreatedContactResponseDto);

    Contact response = service.create(ContactDtoTest.createContactRequestDto);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(ContactDtoTest.expectedCreatedContactResponseDto);
  }

  @Test
  void get() throws ApiException {

    when(api.contactGetContact(
            eq(uriPartID), eq(ContactDtoTest.expectedContactResponseDto.getId())))
        .thenReturn(ContactDtoTest.expectedContactResponseDto);

    Contact response = service.get(ContactDtoTest.expectedContactResponseDto.getId());

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(ContactDtoTest.expectedContactResponseDto);
  }

  @Test
  void update() throws ApiException {

    when(api.contactUpdateContact(
            eq(uriPartID),
            eq(ContactDtoTest.expectedContactResponseDto.getId()),
            eq(ContactDtoTest.expectedContactResponseDto),
            eq(null)))
        .thenReturn(ContactDtoTest.expectedContactResponseDto);

    Contact response = service.update(ContactDtoTest.expectedContactResponseDto);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(ContactDtoTest.expectedContactResponseDto);
  }

  @Test
  void merge() throws ApiException {

    when(api.contactMergeContact(
            eq(uriPartID),
            eq("foo 1"),
            eq(MergeContactRequest.builder().setSourceId("foo 2").build())))
        .thenReturn(ContactDtoTest.expectedContactResponseDto);

    Contact response = service.mergeContact("foo 1", "foo 2");

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(ContactDtoTest.expectedContactResponseDto);
  }

  @Test
  void channelProfileByContactId() throws ApiException {

    when(api.contactGetChannelProfile(eq(uriPartID), any()))
        .thenReturn(ContactDtoTest.expectedChannelProfileResponseDto);

    ContactId contactId =
        (ContactId) ContactDtoTest.contactGetChannelProfileByContactRequestDto.getRecipient();
    String response =
        service.getChannelProfileByContactId(
            ContactGetChannelProfileByContactIdRequest.builder()
                .setChannel(ContactDtoTest.contactGetChannelProfileByContactRequestDto.getChannel())
                .setContactId(contactId.getContactId())
                .setAppId(ContactDtoTest.contactGetChannelProfileByContactRequestDto.getAppId())
                .build());

    Assertions.assertThat(response)
        .isEqualTo(ContactDtoTest.expectedChannelProfileResponseDto.getProfileName());
  }

  @Test
  void channelProfileByChannelIdentity() throws ApiException {

    when(api.contactGetChannelProfile(eq(uriPartID), any()))
        .thenReturn(ContactDtoTest.expectedChannelProfileResponseDto);

    ChannelRecipientIdentities channelIdentities =
        (ChannelRecipientIdentities)
            ContactDtoTest.contactGetChannelProfileByChannelRequestDto.getRecipient();
    String response =
        service.getChannelProfileByChannelIdentity(
            ContactGetChannelProfileByChannelIdentityRequest.builder()
                .setChannelIdentities(channelIdentities)
                .setChannel(ContactDtoTest.contactGetChannelProfileByChannelRequestDto.getChannel())
                .setAppId(ContactDtoTest.contactGetChannelProfileByChannelRequestDto.getAppId())
                .build());

    Assertions.assertThat(response)
        .isEqualTo(ContactDtoTest.expectedChannelProfileResponseDto.getProfileName());
  }
}
