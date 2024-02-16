package com.sinch.sdk.domains.conversation.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.conversation.adapters.api.v1.ContactApi;
import com.sinch.sdk.domains.conversation.adapters.converters.ContactDtoConverterTest;
import com.sinch.sdk.domains.conversation.models.Contact;
import com.sinch.sdk.domains.conversation.models.dto.v1.ContactDtoTest;
import com.sinch.sdk.domains.conversation.models.dto.v1.MergeContactRequestDto;
import com.sinch.sdk.domains.conversation.models.responses.ContactListResponse;
import com.sinch.sdk.models.Configuration;
import java.util.Iterator;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
class ContactServiceTest extends BaseTest {

  Configuration configuration = Configuration.builder().setProjectId("").build();
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;
  @Mock ContactApi api;

  ContactService service;

  @BeforeEach
  public void initMocks() {
    service = spy(new ContactService(configuration, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void list() throws ApiException {

    when(api.contactListContacts(
            eq(configuration.getUnifiedCredentials().get().getProjectId()),
            eq(null),
            eq(null),
            eq(null),
            eq(null),
            eq(null)))
        .thenReturn(ContactDtoTest.expectedContactListResponseDtoPage0);

    when(api.contactListContacts(
            eq(configuration.getUnifiedCredentials().get().getProjectId()),
            eq(null),
            eq("the next page token value"),
            eq(null),
            eq(null),
            eq(null)))
        .thenReturn(ContactDtoTest.expectedContactListResponseDtoPage1);

    ContactListResponse response = service.list(null);

    Iterator<Contact> iterator = response.iterator();
    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);
    Contact item = iterator.next();
    Assertions.assertThat(item)
        .usingRecursiveComparison()
        .isEqualTo(ContactDtoConverterTest.contact);

    Assertions.assertThat(iterator.hasNext()).isEqualTo(false);
  }

  @Test
  void create() throws ApiException {

    when(api.contactCreateContact(
            eq(configuration.getUnifiedCredentials().get().getProjectId()),
            eq(ContactDtoTest.createContactRequestDto)))
        .thenReturn(ContactDtoTest.expectedCreatedContactResponseDto);

    Contact response = service.create(ContactDtoConverterTest.contactCreateRequest);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(ContactDtoConverterTest.contactCreateResponse);
  }

  @Test
  void get() throws ApiException {

    when(api.contactGetContact(
            eq(configuration.getUnifiedCredentials().get().getProjectId()),
            eq(ContactDtoTest.expectedContactResponseDto.getId())))
        .thenReturn(ContactDtoTest.expectedContactResponseDto);

    Contact response = service.get(ContactDtoConverterTest.contact.getId());

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(ContactDtoConverterTest.contact);
  }

  @Test
  void update() throws ApiException {

    when(api.contactUpdateContact(
            eq(configuration.getUnifiedCredentials().get().getProjectId()),
            eq(ContactDtoTest.expectedContactResponseDto.getId()),
            eq(ContactDtoTest.expectedContactUpdateRequestDto),
            eq(null)))
        .thenReturn(ContactDtoTest.expectedContactResponseDto);

    Contact response = service.update(ContactDtoConverterTest.contact);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(ContactDtoConverterTest.contact);
  }

  @Test
  void merge() throws ApiException {

    when(api.contactMergeContact(
            eq(configuration.getUnifiedCredentials().get().getProjectId()),
            eq("foo 1"),
            eq(new MergeContactRequestDto().sourceId("foo 2"))))
        .thenReturn(ContactDtoTest.expectedContactResponseDto);

    Contact response = service.mergeContact("foo 1", "foo 2");

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(ContactDtoConverterTest.contact);
  }

  @Test
  void channelProfileByContact() throws ApiException {

    when(api.contactGetChannelProfile(
            eq(configuration.getUnifiedCredentials().get().getProjectId()),
            eq(ContactDtoTest.contactGetChannelProfileByContactRequestDto)))
        .thenReturn(ContactDtoTest.expectedChannelProfileResponseDto);

    String response =
        service.getChannelProfileByContactId(
            ContactDtoConverterTest.contactGetChannelProfileByContactRequest);

    Assertions.assertThat(response)
        .isEqualTo(ContactDtoTest.expectedChannelProfileResponseDto.getProfileName());
  }

  @Test
  void channelProfileByChannel() throws ApiException {

    when(api.contactGetChannelProfile(
            eq(configuration.getUnifiedCredentials().get().getProjectId()),
            eq(ContactDtoTest.contactGetChannelProfileByChannelRequestDto)))
        .thenReturn(ContactDtoTest.expectedChannelProfileResponseDto);

    String response =
        service.getChannelProfileByChannelIdentity(
            ContactDtoConverterTest.contactGetChannelProfileByChannelRequest);

    Assertions.assertThat(response)
        .isEqualTo(ContactDtoTest.expectedChannelProfileResponseDto.getProfileName());
  }
}
