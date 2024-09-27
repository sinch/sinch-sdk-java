package com.sinch.sdk.domains.conversation.models.v1.messages.types.contactinfo;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class EmailInfoDtoTest extends BaseTest {

  public static EmailInfo emailInfoDto =
      EmailInfo.builder().setEmailAddress("email_address value").setType("type value").build();

  @GivenTextResource("/domains/conversation/v1/messages/types/contactinfo/EmailInfoDto.json")
  String jsonEmailInfoDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(emailInfoDto);

    JSONAssert.assertEquals(jsonEmailInfoDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonEmailInfoDto, EmailInfo.class);

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(emailInfoDto);
  }
}
