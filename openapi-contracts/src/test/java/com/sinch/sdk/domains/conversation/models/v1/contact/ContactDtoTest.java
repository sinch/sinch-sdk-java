package com.sinch.sdk.domains.conversation.models.v1.contact;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentities;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ContactId;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.ContactCreateRequest;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.GetChannelProfileConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.GetChannelProfileRequest;
import com.sinch.sdk.domains.conversation.models.v1.contact.response.GetChannelProfileResponse;
import com.sinch.sdk.domains.conversation.models.v1.contact.response.IdentityConflicts;
import com.sinch.sdk.domains.conversation.models.v1.contact.response.ListContactsResponse;
import com.sinch.sdk.domains.conversation.models.v1.contact.response.ListIdentityConflictsResponse;
import java.util.Arrays;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ContactDtoTest extends ConversationBaseTest {

  public static Contact updateContactRequestDto =
      Contact.builder()
          .setChannelIdentities(
              Collections.singletonList(
                  ChannelIdentity.builder()
                      .setChannel(ConversationChannel.SMS)
                      .setIdentity("a channel identity")
                      .setAppId("an app id")
                      .build()))
          .setChannelPriority(Collections.singletonList(ConversationChannel.SMS))
          .setDisplayName("a display name")
          .setEmail("an email")
          .setExternalId("an external id")
          .setMetadata("metadata value")
          .setLanguage(ContactLanguage.from("UNSPECIFIED"))
          .build();
  public static Contact expectedContactResponseDto =
      Contact.builder()
          .setId("a contact id")
          .setChannelIdentities(
              Collections.singletonList(
                  ChannelIdentity.builder()
                      .setChannel(ConversationChannel.SMS)
                      .setIdentity("a channel identity")
                      .setAppId("an app id")
                      .build()))
          .setChannelPriority(Collections.singletonList(ConversationChannel.SMS))
          .setDisplayName("a display name")
          .setEmail("an email")
          .setExternalId("an external id")
          .setMetadata("metadata value")
          .setLanguage(ContactLanguage.from("UNSPECIFIED"))
          .build();
  public static ContactCreateRequest createContactRequestDto =
      ContactCreateRequest.builder()
          .setChannelIdentities(
              Arrays.asList(
                  ChannelIdentity.builder()
                      .setChannel(ConversationChannel.MMS)
                      .setIdentity("+33987654321")
                      .build(),
                  ChannelIdentity.builder()
                      .setChannel(ConversationChannel.MESSENGER)
                      .setIdentity("+33987654321")
                      .setAppId("my MESSENGER app id")
                      .build()))
          .setChannelPriority(Arrays.asList(ConversationChannel.MMS, ConversationChannel.MESSENGER))
          .setDisplayName("created from Java SDK")
          .setEmail("foo@foo.com")
          .setExternalId("external id value")
          .setMetadata("metadata value")
          .setLanguage(ContactLanguage.AR)
          .build();
  public static Contact expectedCreatedContactResponseDto =
      Contact.builder()
          .setId("my created contact ID")
          .setChannelIdentities(
              Arrays.asList(
                  ChannelIdentity.builder()
                      .setChannel(ConversationChannel.MMS)
                      .setIdentity("33987654321")
                      .build(),
                  ChannelIdentity.builder()
                      .setChannel(ConversationChannel.MESSENGER)
                      .setIdentity("+33987654321")
                      .setAppId("my MESSENGER app id")
                      .build()))
          .setChannelPriority(Arrays.asList(ConversationChannel.MMS, ConversationChannel.MESSENGER))
          .setDisplayName("created from Java SDK")
          .setEmail("foo@foo.com")
          .setExternalId("external id value")
          .setMetadata("metadata value")
          .setLanguage(ContactLanguage.AR)
          .build();
  public static ListContactsResponse expectedContactListResponseDtoPage0 =
      ListContactsResponse.builder()
          .setContacts(Collections.singletonList(expectedContactResponseDto))
          .setNextPageToken("the next page token value")
          .build();
  public static ListContactsResponse expectedContactListResponseDtoPage1 =
      ListContactsResponse.builder()
          .setContacts(Collections.emptyList())
          .setNextPageToken("")
          .build();
  public static GetChannelProfileRequest contactGetChannelProfileByChannelRequestDto =
      GetChannelProfileRequest.builder()
          .setAppId("an app id")
          .setChannel(GetChannelProfileConversationChannel.MESSENGER)
          .setRecipient(
              ChannelRecipientIdentities.of(
                  ChannelRecipientIdentity.builder()
                      .setChannel(ConversationChannel.MESSENGER)
                      .setIdentity("an identity")
                      .build()))
          .build();
  public static GetChannelProfileRequest contactGetChannelProfileByContactRequestDto =
      GetChannelProfileRequest.builder()
          .setAppId("an app id")
          .setChannel(GetChannelProfileConversationChannel.MESSENGER)
          .setRecipient(ContactId.builder().setContactId("a contact ID").build())
          .build();
  public static GetChannelProfileResponse expectedChannelProfileResponseDto =
      GetChannelProfileResponse.builder().setProfileName("a profile name").build();

  public static IdentityConflicts expectedIdentityConflictsDto0 =
      IdentityConflicts.builder()
          .setIdentity("12015555555")
          .setChannels(Arrays.asList(ConversationChannel.RCS, ConversationChannel.SMS))
          .setContactIds(
              Arrays.asList("01W4FFL35P4NC4K35CONTACT001", "01W4FFL35P4NC4K35CONTACT002"))
          .build();

  public static ListIdentityConflictsResponse expectedListIdentityConflictsResponseDtoPage0 =
      ListIdentityConflictsResponse.builder()
          .setConflicts(Collections.singletonList(expectedIdentityConflictsDto0))
          .setNextPageToken("the next page token value")
          .build();
  public static ListIdentityConflictsResponse expectedListIdentityConflictsResponseDtoPage1 =
      ListIdentityConflictsResponse.builder()
          .setConflicts(Collections.emptyList())
          .setNextPageToken("")
          .build();

  @GivenJsonResource("/domains/conversation/v1/contact/ContactListResponseDtoPage0.json")
  ListContactsResponse loadedContactListResponseDtoPage0;

  @GivenJsonResource("/domains/conversation/v1/contact/ContactListResponseDtoPage1.json")
  ListContactsResponse loadedContactListResponseDtoPage1;

  @GivenTextResource("/domains/conversation/v1/contact/ContactCreateRequestDto.json")
  String jsonContactCreateRequestDto;

  @GivenJsonResource("/domains/conversation/v1/contact/ContactDto.json")
  Contact loadedContactCreateResponseDto;

  @GivenTextResource(
      "/domains/conversation/v1/contact/ContactGetChannelProfileByChannelRequestDto.json")
  String jsonContactGetChannelProfileByChannelRequestDto;

  @GivenTextResource(
      "/domains/conversation/v1/contact/ContactGetChannelProfileByContactRequestDto.json")
  String jsonContactGetChannelProfileByContactRequestDto;

  @GivenJsonResource("/domains/conversation/v1/contact/ContactGetChannelResponseDto.json")
  GetChannelProfileResponse loadedContactGetChannelResponseDto;

  @GivenJsonResource("/domains/conversation/v1/contact/IdentityConflictsDto.json")
  IdentityConflicts loadedIdentityConflictsDto0;

  @GivenJsonResource("/domains/conversation/v1/contact/ListIdentityConflictsResponseDtoPage0.json")
  ListIdentityConflictsResponse loadedListIdentityConflictsResponseDtoPage0;

  @GivenJsonResource("/domains/conversation/v1/contact/ListIdentityConflictsResponseDtoPage1.json")
  ListIdentityConflictsResponse loadedListIdentityConflictsResponseDtoPage1;

  @Test
  void deserializeContactListResponseDtoPage0() {
    TestHelpers.recursiveEquals(
        loadedContactListResponseDtoPage0, expectedContactListResponseDtoPage0);
  }

  @Test
  void deserializeContactListResponseDtoPage1() {
    TestHelpers.recursiveEquals(
        loadedContactListResponseDtoPage1, expectedContactListResponseDtoPage1);
  }

  @Test
  void deserializeContactCreateResponseDto() {
    TestHelpers.recursiveEquals(loadedContactCreateResponseDto, expectedCreatedContactResponseDto);
  }

  @Test
  void serializeContactCreateRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(createContactRequestDto);

    JSONAssert.assertEquals(jsonContactCreateRequestDto, serializedString, true);
  }

  @Test
  void serializeContactGetChannelProfileByChannelRequestDto()
      throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(contactGetChannelProfileByChannelRequestDto);

    JSONAssert.assertEquals(
        jsonContactGetChannelProfileByChannelRequestDto, serializedString, true);
  }

  @Test
  void serializeContactGetChannelProfileByContactRequestDto()
      throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(contactGetChannelProfileByContactRequestDto);

    JSONAssert.assertEquals(
        jsonContactGetChannelProfileByContactRequestDto, serializedString, true);
  }

  @Test
  void deserializeChannelProfileResponseDto() {
    TestHelpers.recursiveEquals(
        loadedContactGetChannelResponseDto, expectedChannelProfileResponseDto);
  }

  @Test
  void deserializeIdentityConflicts() {
    TestHelpers.recursiveEquals(loadedIdentityConflictsDto0, expectedIdentityConflictsDto0);
  }

  @Test
  void deserializeListIdentityConflictsResponseDtoPage0() {
    TestHelpers.recursiveEquals(
        loadedListIdentityConflictsResponseDtoPage0, expectedListIdentityConflictsResponseDtoPage0);
  }

  @Test
  void deserializeListIdentityConflictsResponseDtoPage1() {
    TestHelpers.recursiveEquals(
        loadedListIdentityConflictsResponseDtoPage1, expectedListIdentityConflictsResponseDtoPage1);
  }
}
