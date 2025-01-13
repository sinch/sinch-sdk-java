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
class GroupUpdateRequestDtoTest extends BaseTest {
  @GivenTextResource("/domains/sms/v1/groups/request/GroupUpdateRequestDto.json")
  String jsonGroupUpdateRequestDto;

  @Test
  void serialize() throws JsonProcessingException, JSONException {

    GroupUpdateRequest requestDTO =
        GroupUpdateRequest.builder()
            .setName("My new customers")
            .setAdd(Arrays.asList("foo"))
            .setRemove(Arrays.asList("01FC66621XXXXX119Z8PMV1AHY", "01FC66621XXXXX119Z8PMV1A00"))
            .setAddFromGroup("add from group string")
            .setRemoveFromGroup("remove from group string")
            .setAutoUpdate(GroupDtoTest.groupResponse.getAutoUpdate())
            .build();

    String serializedString = objectMapper.writeValueAsString(requestDTO);

    JSONAssert.assertEquals(jsonGroupUpdateRequestDto, serializedString, true);
  }
}
