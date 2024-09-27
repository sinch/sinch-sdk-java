package com.sinch.sdk.domains.conversation.models.v1.messages.types.contactinfo;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import java.time.LocalDate;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ContactInfoMessageDtoTest extends BaseTest {

  public static ContactInfoMessage contactInfoMessageDto =
      ContactInfoMessage.builder()
          .setName(NameInfoDtoTest.nameInfoDto)
          .setPhoneNumbers(Collections.singletonList(PhoneNumberInfoDtoTest.phoneNumberInfoDto))
          .setAddresses(Collections.singletonList(AddressInfoDtoTest.addressInfoDto))
          .setEmailAddresses(Collections.singletonList(EmailInfoDtoTest.emailInfoDto))
          .setOrganization(OrganizationInfoDtoTest.organizationInfoDto)
          .setUrls(Collections.singletonList(URLInfoDtoTest.urlInfoDto))
          .setBirthday(LocalDate.of(1968, 7, 7))
          .build();

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/contactinfo/ContactInfoMessageDto.json")
  String jsonContactInfoMessageDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(contactInfoMessageDto);

    JSONAssert.assertEquals(jsonContactInfoMessageDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonContactInfoMessageDto, ContactInfoMessage.class);

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(contactInfoMessageDto);
  }
}
