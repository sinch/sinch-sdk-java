package com.sinch.sdk.domains.conversation.models.v1;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;

@TestWithResources
public class ContactDtoTest extends BaseTest {
  /*
  @GivenJsonResource("/domains/conversation/v1/ContactListResponseDtoPage0.json")
  ListContactsResponseDto loadedContactListResponseDtoPage0;

  @GivenJsonResource("/domains/conversation/v1/ContactListResponseDtoPage1.json")
  ListContactsResponseDto loadedContactListResponseDtoPage1;

  @GivenTextResource("/domains/conversation/v1/ContactCreateRequestDto.json")
  String jsonContactCreateRequestDto;

  @GivenJsonResource("/domains/conversation/v1/ContactCreateResponseDto.json")
  ContactDto loadedContactCreateResponseDto;

  @GivenTextResource("/domains/conversation/v1/ContactGetChannelProfileByChannelRequestDto.json")
  String jsonContactGetChannelProfileByChannelRequestDto;

  @GivenTextResource("/domains/conversation/v1/ContactGetChannelProfileByContactRequestDto.json")
  String jsonContactGetChannelProfileByContactRequestDto;

  @GivenJsonResource("/domains/conversation/v1/ContactGetChannelResponseDto.json")
  GetChannelProfileResponseDto loadedContactGetChannelResponseDto;

  public static ContactDto expectedContactUpdateRequestDto =
      new ContactDto()
          .channelIdentities(
              Collections.singletonList(
                  new ChannelIdentityDto()
                      .channel(ConversationChannelDto.SMS)
                      .identity("a channel identity")
                      .appId("an app id")))
          .channelPriority(Collections.singletonList(ConversationChannelDto.SMS))
          .displayName("a display name")
          .email("an email")
          .externalId("an external id")
          .metadata("metadata value")
          .language("UNSPECIFIED");
  public static ContactDto expectedContactResponseDto =
      new ContactDto()
          .id("a contact id")
          .channelIdentities(
              Collections.singletonList(
                  new ChannelIdentityDto()
                      .channel(ConversationChannelDto.SMS)
                      .identity("a channel identity")
                      .appId("an app id")))
          .channelPriority(Collections.singletonList(ConversationChannelDto.SMS))
          .displayName("a display name")
          .email("an email")
          .externalId("an external id")
          .metadata("metadata value")
          .language("UNSPECIFIED");

  public static ContactCreateRequestDto createContactRequestDto =
      new ContactCreateRequestDto()
          .channelIdentities(
              Arrays.asList(
                  new ChannelIdentityDto()
                      .channel(ConversationChannelDto.MMS)
                      .identity("+33987654321"),
                  new ChannelIdentityDto()
                      .channel(ConversationChannelDto.MESSENGER)
                      .identity("+33987654321")
                      .appId("my MESSENGER app id")))
          .channelPriority(
              Arrays.asList(ConversationChannelDto.MMS, ConversationChannelDto.MESSENGER))
          .displayName("created from Java SDK")
          .email("foo@foo.com")
          .externalId("external id value")
          .metadata("metadata value")
          .language("AR");
  public static ContactDto expectedCreatedContactResponseDto =
      new ContactDto()
          .id("my created contact ID")
          .channelIdentities(
              Arrays.asList(
                  new ChannelIdentityDto()
                      .channel(ConversationChannelDto.MMS)
                      .identity("33987654321"),
                  new ChannelIdentityDto()
                      .channel(ConversationChannelDto.MESSENGER)
                      .identity("+33987654321")
                      .appId("my MESSENGER app id")))
          .channelPriority(
              Arrays.asList(ConversationChannelDto.MMS, ConversationChannelDto.MESSENGER))
          .displayName("created from Java SDK")
          .email("foo@foo.com")
          .externalId("external id value")
          .metadata("metadata value")
          .language("AR");

  public static ListContactsResponseDto expectedContactListResponseDtoPage0 =
      new ListContactsResponseDto()
          .contacts(Collections.singletonList(expectedContactResponseDto))
          .nextPageToken("the next page token value");

  public static ListContactsResponseDto expectedContactListResponseDtoPage1 =
      new ListContactsResponseDto().contacts(Collections.emptyList()).nextPageToken("");

  public static GetChannelProfileRequestDto contactGetChannelProfileByChannelRequestDto =
      new GetChannelProfileRequestDto()
          .appId("an app id")
          .channel(GetChannelProfileConversationChannelDto.MESSENGER)
          .recipient(
              new GetChannelProfileRequestRecipientDto(
                  new IdentifiedByDto()
                      .identifiedBy(
                          new ChannelIdentitiesDto()
                              .channelIdentities(
                                  Collections.singletonList(
                                      new ChannelRecipientIdentityDto()
                                          .channel(ConversationChannelDto.MESSENGER)
                                          .identity("an identity"))))));

  public static GetChannelProfileRequestDto contactGetChannelProfileByContactRequestDto =
      new GetChannelProfileRequestDto()
          .appId("an app id")
          .channel(GetChannelProfileConversationChannelDto.MESSENGER)
          .recipient(
              new GetChannelProfileRequestRecipientDto(
                  new ContactIdDto().contactId("a contact ID")));

  public static GetChannelProfileResponseDto expectedChannelProfileResponseDto =
      new GetChannelProfileResponseDto().profileName("a profile name");

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
  }*/
}
