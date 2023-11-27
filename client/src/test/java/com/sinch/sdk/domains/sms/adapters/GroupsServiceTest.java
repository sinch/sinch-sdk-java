package com.sinch.sdk.domains.sms.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.sms.adapters.api.v1.GroupsApi;
import com.sinch.sdk.domains.sms.adapters.converters.GroupsDtoConverter;
import com.sinch.sdk.domains.sms.models.Group;
import com.sinch.sdk.domains.sms.models.GroupAutoUpdate;
import com.sinch.sdk.domains.sms.models.GroupAutoUpdateKeyword;
import com.sinch.sdk.domains.sms.models.dto.v1.ApiGroupListDto;
import com.sinch.sdk.domains.sms.models.dto.v1.CreateGroupResponseDto;
import com.sinch.sdk.domains.sms.models.dto.v1.GroupObjectDto;
import com.sinch.sdk.domains.sms.models.dto.v1.ReplaceGroupRequestDto;
import com.sinch.sdk.domains.sms.models.dto.v1.UpdateGroupRequestDto;
import com.sinch.sdk.domains.sms.models.requests.GroupReplaceRequestParameters;
import com.sinch.sdk.domains.sms.models.requests.GroupUpdateRequestParameters;
import com.sinch.sdk.domains.sms.models.responses.GroupsListResponse;
import com.sinch.sdk.models.Configuration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@TestWithResources
class GroupsServiceTest extends BaseTest {

  @Mock Configuration configuration;
  @Mock GroupsApi api;
  @InjectMocks GroupsService service;

  @Captor ArgumentCaptor<String> groupIdCaptor;

  @GivenJsonResource("/domains/sms/v1/GroupResponseDto.json")
  CreateGroupResponseDto createGroupResponseDto;

  @GivenJsonResource("/domains/sms/v1/GroupsListResponseDtoPage0.json")
  ApiGroupListDto groupsListResponseDtoPage0;

  @GivenJsonResource("/domains/sms/v1/GroupsListResponseDtoPage1.json")
  ApiGroupListDto groupsListResponseDtoPage1;

  @Test
  void get() throws ApiException {

    when(api.retrieveGroup(eq(configuration.getProjectId()), eq("foo group ID")))
        .thenReturn(createGroupResponseDto);

    Group response = service.get("foo group ID");

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(GroupsDtoConverter.convert(createGroupResponseDto));
  }

  @Test
  void create() throws ApiException {

    when(api.createGroup(eq(configuration.getProjectId()), eq(new GroupObjectDto())))
        .thenReturn(createGroupResponseDto);

    Group response = service.create(null);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(GroupsDtoConverter.convert(createGroupResponseDto));
  }

  @Test
  void list() throws ApiException {

    when(api.listGroups(eq(configuration.getProjectId()), eq(null), eq(null)))
        .thenReturn(groupsListResponseDtoPage0);
    when(api.listGroups(eq(configuration.getProjectId()), eq(1), eq(null)))
        .thenReturn(groupsListResponseDtoPage1);

    GroupsListResponse response = service.list(null);

    Iterator<Group> iterator = response.iterator();
    Group item = iterator.next();
    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);

    Assertions.assertThat(item)
        .usingRecursiveComparison()
        .isEqualTo(
            Group.builder()
                .setId("01FC66621XXXXX119Z8PMV1QPU")
                .setName("My new customers")
                .setSize(2)
                .setCreatedAt(Instant.parse("2019-08-24T14:15:22Z"))
                .setModifiedAt(Instant.parse("2019-08-24T14:15:44Z"))
                .setChildGroupIds(
                    Arrays.asList("01FC66621XXXXX119Z8PMV1AHY", "01FC66621XXXXX119Z8PMV1A00"))
                .setAutoUpdate(
                    GroupAutoUpdate.builder()
                        .setTo("15551231234")
                        .setAdd(
                            GroupAutoUpdateKeyword.builder()
                                .setFirstWord("Add 1st keyword")
                                .build())
                        .setRemove(
                            GroupAutoUpdateKeyword.builder()
                                .setFirstWord("remove 1st keyword")
                                .setSecondWord("remove 2nd keyword")
                                .build())
                        .build())
                .build());

    item = iterator.next();
    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);
    Assertions.assertThat(item)
        .usingRecursiveComparison()
        .isEqualTo(Group.builder().setId("foo id").build());

    item = iterator.next();
    Assertions.assertThat(iterator.hasNext()).isEqualTo(false);
    Assertions.assertThat(item)
        .usingRecursiveComparison()
        .isEqualTo(
            Group.builder()
                .setId("01FC66621XXXXX119Z8PMV1QPU")
                .setName("My new customers")
                .setSize(2)
                .setCreatedAt(Instant.parse("2019-08-24T14:15:22Z"))
                .setModifiedAt(Instant.parse("2019-08-24T14:15:44Z"))
                .setChildGroupIds(
                    Arrays.asList("01FC66621XXXXX119Z8PMV1AHY", "01FC66621XXXXX119Z8PMV1A00"))
                .setAutoUpdate(
                    GroupAutoUpdate.builder()
                        .setTo("15551231234")
                        .setAdd(
                            GroupAutoUpdateKeyword.builder()
                                .setFirstWord("Add 1st keyword")
                                .build())
                        .setRemove(
                            GroupAutoUpdateKeyword.builder()
                                .setFirstWord("remove 1st keyword")
                                .setSecondWord("remove 2nd keyword")
                                .build())
                        .build())
                .build());
  }

  @Test
  void replace() throws ApiException {

    when(api.replaceGroup(
            eq(configuration.getProjectId()),
            eq("group id"),
            eq(
                new ReplaceGroupRequestDto()
                    .name("foo name")
                    .members(Collections.singletonList("foo member")))))
        .thenReturn(createGroupResponseDto);

    Group response =
        service.replace(
            "group id",
            GroupReplaceRequestParameters.builder()
                .setName("foo name")
                .setMembers(Collections.singletonList("foo member"))
                .build());

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(GroupsDtoConverter.convert(createGroupResponseDto));
  }

  @Test
  void update() throws ApiException {

    when(api.updateGroup(
            eq(configuration.getProjectId()),
            eq("group id"),
            eq(new UpdateGroupRequestDto().name("foo name"))))
        .thenReturn(createGroupResponseDto);

    Group response =
        service.update(
            "group id", GroupUpdateRequestParameters.builder().setName("foo name").build());

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(GroupsDtoConverter.convert(createGroupResponseDto));
  }

  @Test
  void delete() throws ApiException {

    service.delete("foo group id");

    verify(api).deleteGroup(eq(configuration.getProjectId()), groupIdCaptor.capture());

    String parameter = groupIdCaptor.getValue();
    Assertions.assertThat(parameter).isEqualTo("foo group id");
  }

  @Test
  void listMembers() throws ApiException {

    when(api.getMembers(eq(configuration.getProjectId()), eq("group id")))
        .thenReturn(Arrays.asList("entry 1", "entry 2"));

    Collection<String> response = service.listMembers("group id");

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(Arrays.asList("entry 1", "entry 2"));
  }
}
