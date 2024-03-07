package com.sinch.sdk.domains.conversation.adapters;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;

// import com.sinch.sdk.domains.conversation.models.dto.v1.MergeContactRequestDto;

@TestWithResources
class ContactServiceTest extends BaseTest {
  /*
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
        .isEqualTo(ContactDtoConverterTest.contact);

    Assertions.assertThat(iterator.hasNext()).isEqualTo(false);
  }

  @Test
  void create() throws ApiException {

    when(api.contactCreateContact(eq(uriPartID), eq(ContactDtoTest.createContactRequestDto)))
        .thenReturn(ContactDtoTest.expectedCreatedContactResponseDto);

    Contact response = service.create(ContactDtoConverterTest.contactCreateRequest);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(ContactDtoConverterTest.contactCreateResponse);
  }

  @Test
  void get() throws ApiException {

    when(api.contactGetContact(
            eq(uriPartID), eq(ContactDtoTest.expectedContactResponseDto.getId())))
        .thenReturn(ContactDtoTest.expectedContactResponseDto);

    Contact response = service.get(ContactDtoConverterTest.contact.getId());

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(ContactDtoConverterTest.contact);
  }

  @Test
  void update() throws ApiException {

    when(api.contactUpdateContact(
            eq(uriPartID),
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
            eq(uriPartID), eq("foo 1"), eq(new MergeContactRequestDto().sourceId("foo 2"))))
        .thenReturn(ContactDtoTest.expectedContactResponseDto);

    Contact response = service.mergeContact("foo 1", "foo 2");

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(ContactDtoConverterTest.contact);
  }

  @Test
  void channelProfileByContact() throws ApiException {

    when(api.contactGetChannelProfile(
            eq(uriPartID), eq(ContactDtoTest.contactGetChannelProfileByContactRequestDto)))
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
            eq(uriPartID), eq(ContactDtoTest.contactGetChannelProfileByChannelRequestDto)))
        .thenReturn(ContactDtoTest.expectedChannelProfileResponseDto);

    String response =
        service.getChannelProfileByChannelIdentity(
            ContactDtoConverterTest.contactGetChannelProfileByChannelRequest);

    Assertions.assertThat(response)
        .isEqualTo(ContactDtoTest.expectedChannelProfileResponseDto.getProfileName());
  }*/
}
