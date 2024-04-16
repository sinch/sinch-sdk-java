package com.sinch.sdk.domains.conversation.models.v1.messages.internal;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.ContactInfoMessageDtoTest;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ContactInfoMessageFieldInternalDtoTest extends BaseTest {

  public static ContactInfoMessageFieldInternal contactInfoMessageDto =
      ContactInfoMessageFieldInternal.builder()
          .setContactInfoMessage(ContactInfoMessageDtoTest.contactInfoMessageDto)
          .build();

  @GivenTextResource(
      "/domains/conversation/v1/messages/internal/ContactInfoMessageFieldInternalDto.json")
  String jsonContactInfoMessageDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(contactInfoMessageDto);

    JSONAssert.assertEquals(jsonContactInfoMessageDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonContactInfoMessageDto, contactInfoMessageDto.getClass());

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(contactInfoMessageDto);
  }
}
