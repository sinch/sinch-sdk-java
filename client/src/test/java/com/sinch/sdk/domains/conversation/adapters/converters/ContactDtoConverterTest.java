package com.sinch.sdk.domains.conversation.adapters.converters;

import com.sinch.sdk.core.models.pagination.TokenPageNavigator;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.conversation.adapters.models.ChannelIdentityImpl;
import com.sinch.sdk.domains.conversation.adapters.models.ContactImpl;
import com.sinch.sdk.domains.conversation.adapters.models.requests.ContactCreateRequestParametersImpl;
import com.sinch.sdk.domains.conversation.adapters.models.requests.GetChannelProfileByChannelRequestParametersImpl;
import com.sinch.sdk.domains.conversation.adapters.models.requests.GetChannelProfileByContactRequestParametersImpl;
import com.sinch.sdk.domains.conversation.models.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.ChannelIdentityRecipient;
import com.sinch.sdk.domains.conversation.models.ChannelType;
import com.sinch.sdk.domains.conversation.models.Contact;
import com.sinch.sdk.domains.conversation.models.LanguageType;
import com.sinch.sdk.domains.conversation.models.dto.v1.ContactDtoTest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactDtoConverterTest {

  public static final ContactImpl contact =
      ContactImpl.builder()
          .setId("a contact id")
          .setChannelIdentities(
              Collections.singletonList(
                  ChannelIdentityImpl.builder()
                      .setChannel(ChannelType.SMS)
                      .setIdentity("a channel identity")
                      .setAppId("an app id")
                      .build()))
          .setChannelPriority(Collections.singletonList(ChannelType.SMS))
          .setDisplayName("a display name")
          .setEmail("an email")
          .setExternalId("an external id")
          .setMetadata("metadata value")
          .setLanguage(LanguageType.from("UNSPECIFIED"))
          .build();

  public static final Pair<Collection<ContactImpl>, TokenPageNavigator> contactListPage0 =
      new Pair<>(
          Collections.singletonList(contact), new TokenPageNavigator("the next page token value"));

  public static final Pair<Collection<Contact>, TokenPageNavigator> contactListPage1 =
      new Pair<>(Collections.emptyList(), new TokenPageNavigator(""));

  public static final ContactCreateRequestParametersImpl contactCreateRequest =
      ContactCreateRequestParametersImpl.builder()
          .setChannelIdentities(
              Arrays.asList(
                  ChannelIdentity.builder()
                      .setChannel(ChannelType.MMS)
                      .setIdentity("+33987654321")
                      .build(),
                  ChannelIdentity.builder()
                      .setChannel(ChannelType.MESSENGER)
                      .setIdentity("+33987654321")
                      .setAppId("my MESSENGER app id")
                      .build()))
          .setLanguage(LanguageType.AR)
          .setChannelPriority(Arrays.asList(ChannelType.MMS, ChannelType.MESSENGER))
          .setDisplayName("created from Java SDK")
          .setEmail("foo@foo.com")
          .setExternalId("external id value")
          .setMetadata("metadata value")
          .build();

  public static final Contact contactCreateResponse =
      ContactImpl.builder()
          .setId("my created contact ID")
          .setChannelIdentities(
              Arrays.asList(
                  ChannelIdentity.builder()
                      .setChannel(ChannelType.MMS)
                      .setIdentity("33987654321")
                      .build(),
                  ChannelIdentity.builder()
                      .setChannel(ChannelType.MESSENGER)
                      .setIdentity("+33987654321")
                      .setAppId("my MESSENGER app id")
                      .build()))
          .setLanguage(LanguageType.AR)
          .setChannelPriority(Arrays.asList(ChannelType.MMS, ChannelType.MESSENGER))
          .setDisplayName("created from Java SDK")
          .setEmail("foo@foo.com")
          .setExternalId("external id value")
          .setMetadata("metadata value")
          .build();

  public static final GetChannelProfileByChannelRequestParametersImpl
      contactGetChannelProfileByChannelRequest =
          GetChannelProfileByChannelRequestParametersImpl.builder()
              .setAppId("an app id")
              .setChannel(ChannelType.MESSENGER)
              .setChannelIdentities(
                  Collections.singletonList(
                      ChannelIdentityRecipient.builder()
                          .setChannel(ChannelType.MESSENGER)
                          .setIdentity("an identity")
                          .build()))
              .build();

  public static final GetChannelProfileByContactRequestParametersImpl
      contactGetChannelProfileByContactRequest =
          GetChannelProfileByContactRequestParametersImpl.builder()
              .setAppId("an app id")
              .setChannel(ChannelType.MESSENGER)
              .setContactId("a contact ID")
              .build();

  @Test
  void convertContactResponseListPage0() {

    Assertions.assertThat(
            ContactDtoConverter.convert(ContactDtoTest.expectedContactListResponseDtoPage0))
        .usingRecursiveComparison()
        .isEqualTo(contactListPage0);
  }

  @Test
  void convertContactResponseListPage1() {

    Assertions.assertThat(
            ContactDtoConverter.convert(ContactDtoTest.expectedContactListResponseDtoPage1))
        .usingRecursiveComparison()
        .isEqualTo(contactListPage1);
  }

  @Test
  void convertContactCreateRequest() {

    Assertions.assertThat(ContactDtoConverter.convertForCreate(contactCreateRequest))
        .usingRecursiveComparison()
        .isEqualTo(ContactDtoTest.createContactRequestDto);
  }

  @Test
  void convertContactCreateResponse() {

    Assertions.assertThat(
            ContactDtoConverter.convert(ContactDtoTest.expectedCreatedContactResponseDto))
        .usingRecursiveComparison()
        .isEqualTo(contactCreateResponse);
  }

  @Test
  void convertContactGetChannelProfileByChannelRequest() {

    Assertions.assertThat(ContactDtoConverter.convert(contactGetChannelProfileByChannelRequest))
        .usingRecursiveComparison()
        .isEqualTo(ContactDtoTest.contactGetChannelProfileByChannelRequestDto);
  }

  @Test
  void convertContactGetChannelProfileByContactRequest() {

    Assertions.assertThat(ContactDtoConverter.convert(contactGetChannelProfileByContactRequest))
        .usingRecursiveComparison()
        .isEqualTo(ContactDtoTest.contactGetChannelProfileByContactRequestDto);
  }

  @Test
  void convertContactGetChannelProfileResponse() {

    Assertions.assertThat(
            ContactDtoConverter.convert(ContactDtoTest.expectedChannelProfileResponseDto))
        .isEqualTo("a profile name");
  }
}
