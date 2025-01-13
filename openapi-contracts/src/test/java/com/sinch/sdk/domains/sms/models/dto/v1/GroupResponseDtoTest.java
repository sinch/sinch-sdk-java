package com.sinch.sdk.domains.sms.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.HashSet;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
class GroupResponseDtoTest extends BaseTest {

  @GivenJsonResource("/domains/sms/v1/groups/GroupDto.json")
  CreateGroupResponseDto createGroupResponseDto;

  Integer size = 2;
  OffsetDateTime createdAt = OffsetDateTime.parse("2019-08-24T14:15:22Z");
  OffsetDateTime modifiedAt = OffsetDateTime.parse("2019-08-24T14:15:44Z");
  CreateGroupResponseDto groupResponse =
      new CreateGroupResponseDto(size, createdAt, modifiedAt)
          .id("01FC66621XXXXX119Z8PMV1QPU")
          .name("My new customers")
          .childGroups(
              new HashSet<>(
                  Arrays.asList("01FC66621XXXXX119Z8PMV1AHY", "01FC66621XXXXX119Z8PMV1A00")))
          .autoUpdate(
              new GroupAutoUpdateDto()
                  .to("15551231234")
                  .add(
                      new AddKeywordDto()
                          .firstWord("Add 1st keyword")
                          .secondWord("Add 2nd keyword"))
                  .remove(
                      new RemoveKeywordDto()
                          .firstWord("remove 1st keyword")
                          .secondWord("remove 2nd keyword")));

  @Test
  void deserializeGroup() {

    Assertions.assertThat(createGroupResponseDto)
        .usingRecursiveComparison()
        .isEqualTo(groupResponse);
  }
}
