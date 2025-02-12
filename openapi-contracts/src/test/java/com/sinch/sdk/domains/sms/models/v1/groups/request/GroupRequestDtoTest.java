package com.sinch.sdk.domains.sms.models.v1.groups.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.sms.models.v1.groups.AddKeyword;
import com.sinch.sdk.domains.sms.models.v1.groups.GroupAutoUpdate;
import com.sinch.sdk.domains.sms.models.v1.groups.RemoveKeyword;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
class GroupRequestDtoTest extends BaseTest {
  @GivenTextResource("/domains/sms/v1/groups/request/GroupRequestDto.json")
  String jsonGroupRequestDto;

  @Test
  void serialize() throws JsonProcessingException, JSONException {

    GroupRequest requestDTO =
        GroupRequest.builder()
            .setName("My new customers")
            .setAutoUpdate(
                GroupAutoUpdate.builder()
                    .setTo("15551231234")
                    .setAdd(
                        AddKeyword.builder()
                            .setFirstWord("Add 1st keyword")
                            .setSecondWord("Add 2nd keyword")
                            .build())
                    .setRemove(
                        RemoveKeyword.builder()
                            .setFirstWord("remove 1st keyword")
                            .setSecondWord("remove 2nd keyword")
                            .build())
                    .build())
            .setMembers(Collections.singleton("+15551231234"))
            .setChildGroups(
                new HashSet<>(
                    Arrays.asList("01FC66621XXXXX119Z8PMV1AHY", "01FC66621XXXXX119Z8PMV1A00")))
            .build();

    String serializedString = objectMapper.writeValueAsString(requestDTO);

    JSONAssert.assertEquals(jsonGroupRequestDto, serializedString, true);
  }
}
