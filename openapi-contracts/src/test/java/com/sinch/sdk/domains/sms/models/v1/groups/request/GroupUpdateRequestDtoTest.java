package com.sinch.sdk.domains.sms.models.v1.groups.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.sms.models.v1.groups.GroupDtoTest;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class GroupUpdateRequestDtoTest extends BaseTest {
  @GivenTextResource("/domains/sms/v1/groups/request/GroupUpdateRequestDto.json")
  String jsonGroupUpdateRequestDto;

  public static GroupUpdateRequest requestDTO =
      GroupUpdateRequest.builder()
          .setName("My new customers")
          .setAdd(Arrays.asList("+12345674890"))
          .setRemove(Arrays.asList("+0987654321", "+3456789123"))
          .setAddFromGroup("01FC66621XXXXX119Z8PMV1AHY")
          .setRemoveFromGroup("01FC66621XXXXX119Z8PMV1A00")
          .setAutoUpdate(GroupDtoTest.groupResponse.getAutoUpdate())
          .build();

  @Test
  void serialize() throws JsonProcessingException, JSONException {

    String serializedString = objectMapper.writeValueAsString(requestDTO);

    JSONAssert.assertEquals(jsonGroupUpdateRequestDto, serializedString, true);
  }
}
