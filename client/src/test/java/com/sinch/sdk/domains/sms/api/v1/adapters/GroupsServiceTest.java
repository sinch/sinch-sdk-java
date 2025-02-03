package com.sinch.sdk.domains.sms.api.v1.adapters;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpContentType;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpRequestTest.HttpRequestMatcher;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.http.URLParameter;
import com.sinch.sdk.core.http.URLParameter.STYLE;
import com.sinch.sdk.core.http.URLPathUtils;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.PaginationFillerHelper;
import com.sinch.sdk.domains.sms.api.v1.GroupsService;
import com.sinch.sdk.domains.sms.models.v1.groups.Group;
import com.sinch.sdk.domains.sms.models.v1.groups.request.GroupRequest;
import com.sinch.sdk.domains.sms.models.v1.groups.request.GroupUpdateRequestDtoTest;
import com.sinch.sdk.domains.sms.models.v1.groups.request.ListGroupsQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.groups.response.ListGroupsResponse;
import com.sinch.sdk.domains.sms.models.v1.groups.response.internal.ApiGroupList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
class GroupsServiceTest extends BaseTest {

  static final String SMS_AUTH_NAMES = "BearerAuth";

  static final String SERVICE_PLAN_ID = "foo value";
  static final String GROUP_ID = "foo groupID";

  @GivenTextResource("/domains/sms/v1/groups/GroupDto.json")
  String jsonGroupDto;

  @GivenJsonResource("/domains/sms/v1/groups/GroupDto.json")
  Group groupDto;

  @GivenTextResource("/domains/sms/v1/groups/response/ListGroupsResponseDtoPage0.json")
  String jsonListGroupsResponseDtoPage0;

  @GivenJsonResource("/domains/sms/v1/groups/response/ListGroupsResponseDtoPage0.json")
  ApiGroupList listGroupsResponseDtoPage0;

  @GivenTextResource("/domains/sms/v1/groups/response/ListGroupsResponseDtoPage1.json")
  String jsonListGroupsResponseDtoPage1;

  @GivenJsonResource("/domains/sms/v1/groups/response/ListGroupsResponseDtoPage1.json")
  ApiGroupList listGroupsResponseDtoPage1;

  @GivenTextResource("/domains/sms/v1/groups/response/ListGroupsResponseDtoPage2.json")
  String jsonListGroupsResponseDtoPage2;

  @Mock ServerConfiguration serverConfiguration;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;
  GroupsService service;

  @BeforeEach
  public void initMocks() {
    service =
        new GroupsServiceImpl(
            httpClient,
            serverConfiguration,
            authManagers,
            HttpMapper.getInstance(),
            SERVICE_PLAN_ID);
  }

  @Test
  void get() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/"
                + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID)
                + "/groups/"
                + URLPathUtils.encodePathSegment(GROUP_ID),
            HttpMethod.GET,
            Collections.emptyList(),
            null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonGroupDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    Group response = service.get(GROUP_ID);

    TestHelpers.recursiveEquals(response, groupDto);
  }

  @Test
  void createDefault() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/" + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID) + "/groups",
            HttpMethod.POST,
            Collections.emptyList(),
            // SMS is expecting an empty body but do not accept a NULL one
            "{}",
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonGroupDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    Group response = service.create();

    TestHelpers.recursiveEquals(response, groupDto);
  }

  @Test
  void create() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/" + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID) + "/groups",
            HttpMethod.POST,
            Collections.emptyList(),
            HttpMapper.getInstance()
                .serialize(
                    Collections.singletonList(HttpContentType.APPLICATION_JSON),
                    GroupRequest.builder().setName("foo").build()),
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonGroupDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    Group response = service.create(GroupRequest.builder().setName("foo").build());

    TestHelpers.recursiveEquals(response, groupDto);
  }

  @Test
  void listDefault() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/" + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID) + "/groups",
            HttpMethod.GET,
            Collections.emptyList(),
            null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonListGroupsResponseDtoPage0.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    ListGroupsResponse response = service.list();
    TestHelpers.recursiveEquals(response.getContent(), listGroupsResponseDtoPage0.getItems());
  }

  @Test
  void list() throws ApiException {

    List<Object> commonParameters = Arrays.asList("page_size", 2, STYLE.FORM, true);

    Collection<URLParameter> urlParameters0 =
        PaginationFillerHelper.parametersFiller("page", 0, STYLE.FORM, true, commonParameters);
    Collection<URLParameter> urlParameters1 =
        PaginationFillerHelper.parametersFiller("page", 1, STYLE.FORM, true, commonParameters);
    Collection<URLParameter> urlParameters2 =
        PaginationFillerHelper.parametersFiller("page", 2, STYLE.FORM, true, commonParameters);

    HttpRequest httpRequest0 =
        new HttpRequest(
            "/xms/v1/" + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID) + "/groups",
            HttpMethod.GET,
            urlParameters0,
            null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpRequest httpRequest1 =
        new HttpRequest(
            "/xms/v1/" + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID) + "/groups",
            HttpMethod.GET,
            urlParameters1,
            null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpRequest httpRequest2 =
        new HttpRequest(
            "/xms/v1/" + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID) + "/groups",
            HttpMethod.GET,
            urlParameters2,
            null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpResponse httpResponse0 =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonListGroupsResponseDtoPage0.getBytes());
    HttpResponse httpResponse1 =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonListGroupsResponseDtoPage1.getBytes());
    HttpResponse httpResponse2 =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonListGroupsResponseDtoPage2.getBytes());
    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest0))))
        .thenReturn(httpResponse0);
    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest1))))
        .thenReturn(httpResponse1);
    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest2))))
        .thenReturn(httpResponse2);

    ListGroupsQueryParameters initialRequest =
        ListGroupsQueryParameters.builder().setPage(0).setPageSize(2).build();

    ListGroupsResponse response = service.list(initialRequest);

    Iterator<Group> iterator = response.iterator();

    Group item = iterator.next();
    TestHelpers.recursiveEquals(item, listGroupsResponseDtoPage0.getItems().get(0));
    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);

    item = iterator.next();
    TestHelpers.recursiveEquals(item, listGroupsResponseDtoPage0.getItems().get(1));
    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);

    item = iterator.next();
    TestHelpers.recursiveEquals(item, listGroupsResponseDtoPage1.getItems().get(0));

    Assertions.assertThat(iterator.hasNext()).isEqualTo(false);
  }

  @Test
  void replace() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/"
                + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID)
                + "/groups/"
                + URLPathUtils.encodePathSegment(GROUP_ID),
            HttpMethod.PUT,
            Collections.emptyList(),
            HttpMapper.getInstance()
                .serialize(
                    Collections.singletonList(HttpContentType.APPLICATION_JSON),
                    GroupRequest.builder().setName("foo").build()),
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonGroupDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    Group response = service.replace(GROUP_ID, GroupRequest.builder().setName("foo").build());

    TestHelpers.recursiveEquals(response, groupDto);
  }

  @Test
  void update() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/"
                + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID)
                + "/groups/"
                + URLPathUtils.encodePathSegment(GROUP_ID),
            HttpMethod.POST,
            Collections.emptyList(),
            HttpMapper.getInstance()
                .serialize(
                    Collections.singletonList(HttpContentType.APPLICATION_JSON),
                    GroupUpdateRequestDtoTest.requestDTO),
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonGroupDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    Group response = service.update(GROUP_ID, GroupUpdateRequestDtoTest.requestDTO);

    TestHelpers.recursiveEquals(response, groupDto);
  }

  @Test
  void delete() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/"
                + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID)
                + "/groups/"
                + URLPathUtils.encodePathSegment(GROUP_ID),
            HttpMethod.DELETE,
            Collections.emptyList(),
            null,
            Collections.emptyMap(),
            Collections.emptyList(),
            Collections.emptyList(),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpResponse httpResponse = new HttpResponse(200, null, Collections.emptyMap(), null);

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    service.delete(GROUP_ID);
  }

  @Test
  void listMembers() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/"
                + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID)
                + "/groups/"
                + URLPathUtils.encodePathSegment(GROUP_ID)
                + "/members",
            HttpMethod.GET,
            Collections.emptyList(),
            null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), "[\"entry 1\", \"entry 2\"]".getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    Collection<String> members = service.listMembers(GROUP_ID);
    TestHelpers.recursiveEquals(members, new ArrayList<>(Arrays.asList("entry 1", "entry 2")));
  }
}
