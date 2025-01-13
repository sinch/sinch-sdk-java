package com.sinch.sdk.domains.sms.api.v1.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.sms.api.v1.internal.GroupsApi;
import com.sinch.sdk.domains.sms.models.v1.groups.AddKeyword;
import com.sinch.sdk.domains.sms.models.v1.groups.Group;
import com.sinch.sdk.domains.sms.models.v1.groups.GroupAutoUpdate;
import com.sinch.sdk.domains.sms.models.v1.groups.RemoveKeyword;
import com.sinch.sdk.domains.sms.models.v1.groups.request.GroupRequest;
import com.sinch.sdk.domains.sms.models.v1.groups.request.GroupUpdateRequest;
import com.sinch.sdk.domains.sms.models.v1.groups.request.ListGroupsQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.groups.response.ListGroupsResponse;
import com.sinch.sdk.domains.sms.models.v1.groups.response.internal.ApiGroupList;
import com.sinch.sdk.models.SmsContext;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;

@TestWithResources
class GroupsServiceTest extends BaseTest {

  @Mock SmsContext context;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;
  @Mock GroupsApi api;
  GroupsService service;
  String uriPartID = "foovalue";

  @Captor ArgumentCaptor<String> groupIdCaptor;

  @GivenJsonResource("/domains/sms/v1/groups/GroupDto.json")
  Group groupResponseDto;

  @GivenJsonResource("/domains/sms/v1/groups/response/ListGroupsResponseDtoPage0.json")
  ApiGroupList groupsListResponseDtoPage0;

  @GivenJsonResource("/domains/sms/v1/groups/response/ListGroupsResponseDtoPage1.json")
  ApiGroupList groupsListResponseDtoPage1;

  @GivenJsonResource("/domains/sms/v1/groups/response/ListGroupsResponseDtoPage2.json")
  ApiGroupList groupsListResponseDtoPage2;

  @BeforeEach
  public void initMocks() {
    service = spy(new GroupsService(uriPartID, context, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void get() throws ApiException {

    when(api.retrieveGroup(eq("foo group ID"))).thenReturn(groupResponseDto);

    Group response = service.get("foo group ID");

    TestHelpers.recursiveEquals(response, groupResponseDto);
  }

  @Test
  void create() throws ApiException {

    when(api.createGroup(eq(null))).thenReturn(groupResponseDto);

    Group response = service.create(null);

    TestHelpers.recursiveEquals(response, groupResponseDto);
  }

  @Test
  void list() throws ApiException {

    ListGroupsQueryParameters page1 = ListGroupsQueryParameters.builder().setPage(1).build();
    ListGroupsQueryParameters page2 = ListGroupsQueryParameters.builder().setPage(2).build();

    when(api.listGroups(eq(null))).thenReturn(groupsListResponseDtoPage0);
    when(api.listGroups(page1)).thenReturn(groupsListResponseDtoPage1);
    when(api.listGroups(page2)).thenReturn(groupsListResponseDtoPage2);

    ListGroupsResponse response = service.list(null);

    Iterator<Group> iterator = response.iterator();
    Group item = iterator.next();
    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);

    TestHelpers.recursiveEquals(
        item,
        Group.builder()
            .setId("01FC66621XXXXX119Z8PMV1QPU")
            .setName("My new customers")
            .setSize(2)
            .setCreatedAt(Instant.parse("2019-08-24T14:15:22Z"))
            .setModifiedAt(Instant.parse("2019-08-24T14:15:44Z"))
            .setAutoUpdate(
                GroupAutoUpdate.builder()
                    .setTo("15551231234")
                    .setAdd(AddKeyword.builder().setFirstWord("Add 1st keyword").build())
                    .setRemove(
                        RemoveKeyword.builder()
                            .setFirstWord("remove 1st keyword")
                            .setSecondWord("remove 2nd keyword")
                            .build())
                    .build())
            .setChildGroups(
                new HashSet<>(
                    Arrays.asList("01FC66621XXXXX119Z8PMV1AHY", "01FC66621XXXXX119Z8PMV1A00")))
            .build());

    item = iterator.next();
    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);
    TestHelpers.recursiveEquals(item, Group.builder().setId("foo id").build());

    item = iterator.next();
    Assertions.assertThat(iterator.hasNext()).isEqualTo(false);
    TestHelpers.recursiveEquals(
        item,
        Group.builder()
            .setId("01FC66621XXXXX119Z8PMV1QPU")
            .setName("My new customers")
            .setSize(2)
            .setCreatedAt(Instant.parse("2019-08-24T14:15:22Z"))
            .setModifiedAt(Instant.parse("2019-08-24T14:15:44Z"))
            .setAutoUpdate(
                GroupAutoUpdate.builder()
                    .setTo("15551231234")
                    .setAdd(AddKeyword.builder().setFirstWord("Add 1st keyword").build())
                    .setRemove(
                        RemoveKeyword.builder()
                            .setFirstWord("remove 1st keyword")
                            .setSecondWord("remove 2nd keyword")
                            .build())
                    .build())
            .setChildGroups(
                new HashSet<>(
                    Arrays.asList("01FC66621XXXXX119Z8PMV1AHY", "01FC66621XXXXX119Z8PMV1A00")))
            .build());
  }

  @Test
  void replace() throws ApiException {

    when(api.replaceGroup(
            eq("group id"),
            eq(
                GroupRequest.builder()
                    .setName("foo name")
                    .setMembers(Collections.singleton("foo member"))
                    .build())))
        .thenReturn(groupResponseDto);

    Group response =
        service.replace(
            "group id",
            GroupRequest.builder()
                .setName("foo name")
                .setMembers(Collections.singleton("foo member"))
                .build());

    TestHelpers.recursiveEquals(response, groupResponseDto);
  }

  @Test
  void update() throws ApiException {

    when(api.updateGroup(
            eq("group id"), eq(GroupUpdateRequest.builder().setName("foo name").build())))
        .thenReturn(groupResponseDto);

    Group response =
        service.update("group id", GroupUpdateRequest.builder().setName("foo name").build());

    TestHelpers.recursiveEquals(response, groupResponseDto);
  }

  @Test
  void delete() throws ApiException {

    service.delete("foo group id");

    verify(api).deleteGroup(groupIdCaptor.capture());

    String parameter = groupIdCaptor.getValue();
    Assertions.assertThat(parameter).isEqualTo("foo group id");
  }

  @Test
  void listMembers() throws ApiException {

    when(api.getMembers(eq("group id"))).thenReturn(Arrays.asList("entry 1", "entry 2"));

    Collection<String> response = service.listMembers("group id");

    TestHelpers.recursiveEquals(response, Arrays.asList("entry 1", "entry 2"));
  }
}
