package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class OrganizationInfoDtoTest extends BaseTest {

  public static OrganizationInfo organizationInfoDto =
      OrganizationInfo.builder()
          .setCompany("company value")
          .setDepartment("department value")
          .setTitle("title value")
          .build();

  @GivenTextResource("/domains/conversation/v1/messages/OrganizationInfoDto.json")
  String jsonOrganizationInfoDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(organizationInfoDto);

    JSONAssert.assertEquals(jsonOrganizationInfoDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonOrganizationInfoDto, organizationInfoDto.getClass());

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(organizationInfoDto);
  }
}
