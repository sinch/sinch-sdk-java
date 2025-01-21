package com.sinch.sdk.domains.sms.models.v1.groups;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import org.junit.jupiter.api.Test;

@TestWithResources
public class GroupDtoTest extends BaseTest {

  @GivenJsonResource("/domains/sms/v1/groups/GroupDto.json")
  Group groupResponseDto;

  public static Group groupResponse =
      Group.builder()
          .setSize(2)
          .setCreatedAt(Instant.parse("2019-08-24T14:15:22Z"))
          .setModifiedAt(Instant.parse("2019-08-24T14:15:44Z"))
          .setId("01FC66621XXXXX119Z8PMV1QPU")
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
          .setChildGroups(
              new HashSet<>(
                  Arrays.asList("01FC66621XXXXX119Z8PMV1AHY", "01FC66621XXXXX119Z8PMV1A00")))
          .build();

  @Test
  void deserializeGroup() {

    TestHelpers.recursiveEquals(groupResponseDto, groupResponse);
  }
}
