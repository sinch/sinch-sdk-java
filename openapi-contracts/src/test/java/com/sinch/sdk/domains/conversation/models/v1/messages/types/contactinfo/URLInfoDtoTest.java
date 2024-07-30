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
public class URLInfoDtoTest extends BaseTest {

  public static UrlInfo urlInfoDto =
      UrlInfo.builder().setUrl("url value").setType("type value").build();

  @GivenTextResource("/domains/conversation/v1/messages/types/contactinfo/URLInfoDto.json")
  String jsonURLInfoDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(urlInfoDto);

    JSONAssert.assertEquals(jsonURLInfoDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonURLInfoDto, urlInfoDto.getClass());

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(urlInfoDto);
  }
}
