package com.sinch.sdk.domains.conversation.models.v1;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.conversation.models.v1.contact.Contact;
import com.sinch.sdk.domains.conversation.models.v1.contact.ContactLanguage;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.ContactCreateRequest;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.GetChannelProfileConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.GetChannelProfileRequest;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.GetChannelProfileRequestRecipient;
import com.sinch.sdk.domains.conversation.models.v1.contact.response.GetChannelProfileResponse;
import com.sinch.sdk.domains.conversation.models.v1.contact.response.ListContactsResponse;
import com.sinch.sdk.domains.conversation.models.v1.request.ChannelRecipientIdentity;
import com.sinch.sdk.domains.conversation.models.v1.request.IdentifiedBy;
import java.util.Arrays;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ContactDtoTest extends BaseTest {

  @GivenJsonResource("/domains/conversation/v1/ContactListResponseDtoPage0.json")
  ListContactsResponse loadedContactListResponseDtoPage0;

  @GivenJsonResource("/domains/conversation/v1/ContactListResponseDtoPage1.json")
  ListContactsResponse loadedContactListResponseDtoPage1;

  @GivenTextResource("/domains/conversation/v1/ContactCreateRequestDto.json")
  String jsonContactCreateRequestDto;

  @GivenJsonResource("/domains/conversation/v1/ContactCreateResponseDto.json")
  Contact loadedContactCreateResponseDto;

  @GivenTextResource("/domains/conversation/v1/ContactGetChannelProfileByChannelRequestDto.json")
  String jsonContactGetChannelProfileByChannelRequestDto;

  @GivenTextResource("/domains/conversation/v1/ContactGetChannelProfileByContactRequestDto.json")
  String jsonContactGetChannelProfileByContactRequestDto;

  @GivenJsonResource("/domains/conversation/v1/ContactGetChannelResponseDto.json")
  GetChannelProfileResponse loadedContactGetChannelResponseDto;

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
              GetChannelProfileRequestRecipient.builder()
                  .setIdentifiedBy(
                      IdentifiedBy.builder()
                          .setChannelIdentities(
                              Collections.singletonList(
                                  ChannelRecipientIdentity.builder()
                                      .setChannel(ConversationChannel.MESSENGER)
                                      .setIdentity("an identity")
                                      .build()))
                          .build())
                  .build())
          .build();

  public static GetChannelProfileRequest contactGetChannelProfileByContactRequestDto =
      GetChannelProfileRequest.builder()
          .setAppId("an app id")
          .setChannel(GetChannelProfileConversationChannel.MESSENGER)
          .setRecipient(
              GetChannelProfileRequestRecipient.builder().setContactId("a contact ID").build())
          .build();

  public static GetChannelProfileResponse expectedChannelProfileResponseDto =
      GetChannelProfileResponse.builder().setProfileName("a profile name").build();

  @Test
  void deserializeContactListResponseDtoPage0() {
    Assertions.assertThat(loadedContactListResponseDtoPage0)
        .usingRecursiveComparison()
        .isEqualTo(expectedContactListResponseDtoPage0);
  }

  @Test
  void deserializeContactListResponseDtoPage1() {
    Assertions.assertThat(loadedContactListResponseDtoPage1)
        .usingRecursiveComparison()
        .isEqualTo(expectedContactListResponseDtoPage1);
  }

  @Test
  void deserializeContactCreateResponseDto() {
    Assertions.assertThat(loadedContactCreateResponseDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedCreatedContactResponseDto);
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
    Assertions.assertThat(loadedContactGetChannelResponseDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedChannelProfileResponseDto);
  }
}
