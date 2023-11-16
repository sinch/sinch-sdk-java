package com.sinch.sdk.domains.sms.adapters.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.sms.models.Group;
import com.sinch.sdk.domains.sms.models.GroupAutoUpdate;
import com.sinch.sdk.domains.sms.models.GroupAutoUpdateKeyword;
import com.sinch.sdk.domains.sms.models.dto.v1.CreateGroupResponseDto;
import com.sinch.sdk.domains.sms.models.dto.v1.GroupAutoUpdateDto;
import com.sinch.sdk.domains.sms.models.dto.v1.GroupObjectDto;
import com.sinch.sdk.domains.sms.models.dto.v1.ReplaceGroupRequestDto;
import com.sinch.sdk.domains.sms.models.dto.v1.UpdateGroupRequestDto;
import com.sinch.sdk.domains.sms.models.requests.GroupCreateRequestParameters;
import com.sinch.sdk.domains.sms.models.requests.GroupReplaceRequestParameters;
import com.sinch.sdk.domains.sms.models.requests.GroupUpdateRequestParameters;
import java.rmi.UnexpectedException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
class GroupsDtoConverterTest extends BaseTest {

  @GivenJsonResource("/domains/sms/v1/GroupResponseDto.json")
  CreateGroupResponseDto createGroupResponseDto;

  @GivenJsonResource("/domains/sms/v1/GroupCreateRequestParametersDto.json")
  GroupObjectDto createGroupRequestParametersDto;

  @GivenJsonResource("/domains/sms/v1/GroupUpdateRequestParametersDto.json")
  UpdateGroupRequestDto groupUpdateRequestParametersDto;

  @GivenJsonResource("/domains/sms/v1/GroupReplaceRequestParametersDto.json")
  ReplaceGroupRequestDto groupReplaceRequestParametersDto;

  static void compareWithDto(Group client, CreateGroupResponseDto dto) {
    assertEquals(dto.getSize(), client.getSize());
    assertEquals(dto.getCreatedAt().toInstant(), client.getCreatedAt());
    assertEquals(dto.getModifiedAt().toInstant(), client.getModifiedAt());
    assertEquals(dto.getId(), client.getId());
    assertEquals(dto.getName(), client.getName());
    Iterator<?> dtoIterator = dto.getChildGroups().iterator();
    Iterator<?> clientIterator = client.getChildGroupIds().iterator();
    dtoIterator.forEachRemaining(dtoItem -> assertEquals(clientIterator.next(), dtoItem));
    compareWithDto(client.getAutoUpdate(), dto.getAutoUpdate());
  }

  static void compareWithDto(GroupAutoUpdate client, GroupAutoUpdateDto dto) {
    assertEquals(dto.getTo(), client.getTo());
    assertEquals(dto.getAdd().getFirstWord(), client.getAdd().getFirstWord());
    assertEquals(dto.getAdd().getSecondWord(), client.getAdd().getSecondWord());
    assertEquals(dto.getRemove().getFirstWord(), client.getRemove().getFirstWord());
    assertEquals(dto.getRemove().getSecondWord(), client.getRemove().getSecondWord());
  }

  @Test
  void convertCreateGroupResponse() throws UnexpectedException {
    compareWithDto(GroupsDtoConverter.convert(createGroupResponseDto), createGroupResponseDto);
  }

  @Test
  void convertCreateRequestParameters() throws UnexpectedException {
    GroupCreateRequestParameters client =
        GroupCreateRequestParameters.builder()
            .setName("My new customers")
            .setMembers(Collections.singletonList("foo"))
            .setChildGroupIds(
                Arrays.asList("01FC66621XXXXX119Z8PMV1AHY", "01FC66621XXXXX119Z8PMV1A00"))
            .setAutoUpdate(
                GroupAutoUpdate.builder()
                    .setTo("15551231234")
                    .setAdd(
                        GroupAutoUpdateKeyword.builder().setFirstWord("Add 1st keyword").build())
                    .setRemove(
                        GroupAutoUpdateKeyword.builder()
                            .setFirstWord("remove 1st keyword")
                            .setSecondWord("remove 2nd keyword")
                            .build())
                    .build())
            .build();

    Assertions.assertThat(createGroupRequestParametersDto)
        .usingRecursiveComparison()
        .isEqualTo(GroupsDtoConverter.convert(client));
  }

  @Test
  void convertUpdateRequestParameters() throws UnexpectedException {
    GroupUpdateRequestParameters client =
        GroupUpdateRequestParameters.builder()
            .setName("My new customers")
            .setAdd(Collections.singletonList("foo"))
            .setRemove(Arrays.asList("01FC66621XXXXX119Z8PMV1AHY", "01FC66621XXXXX119Z8PMV1A00"))
            .setAddFromGroup("add from group string")
            .setRemoveFromGroup("remove from group string")
            .setAutoUpdate(
                GroupAutoUpdate.builder()
                    .setTo("15551231234")
                    .setAdd(
                        GroupAutoUpdateKeyword.builder().setFirstWord("Add 1st keyword").build())
                    .setRemove(
                        GroupAutoUpdateKeyword.builder()
                            .setFirstWord("remove 1st keyword")
                            .setSecondWord("remove 2nd keyword")
                            .build())
                    .build())
            .build();

    Assertions.assertThat(groupUpdateRequestParametersDto)
        .usingRecursiveComparison()
        .isEqualTo(GroupsDtoConverter.convert(client));
  }

  @Test
  void convertReplaceRequestParameters() throws UnexpectedException {
    GroupReplaceRequestParameters client =
        GroupReplaceRequestParameters.builder()
            .setName("My new customers")
            .setMembers(Collections.singletonList("foo"))
            .build();

    Assertions.assertThat(groupReplaceRequestParametersDto)
        .usingRecursiveComparison()
        .isEqualTo(GroupsDtoConverter.convert(client));
  }
}