package com.sinch.sdk.domains.sms.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.core.models.pagination.PageToken;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.sms.adapters.api.v1.GroupsApi;
import com.sinch.sdk.domains.sms.adapters.converters.GroupsDtoConverter;
import com.sinch.sdk.domains.sms.models.Group;
import com.sinch.sdk.domains.sms.models.dto.v1.ApiGroupListDto;
import com.sinch.sdk.domains.sms.models.dto.v1.CreateGroupResponseDto;
import com.sinch.sdk.domains.sms.models.requests.GroupCreateRequestParameters;
import com.sinch.sdk.domains.sms.models.requests.GroupReplaceRequestParameters;
import com.sinch.sdk.domains.sms.models.requests.GroupUpdateRequestParameters;
import com.sinch.sdk.domains.sms.models.requests.GroupsListRequestParameters;
import com.sinch.sdk.domains.sms.models.responses.GroupsListResponse;
import com.sinch.sdk.models.Configuration;
import java.util.Collection;

public class GroupsService implements com.sinch.sdk.domains.sms.GroupsService {

  private Configuration configuration;
  private GroupsApi api;

  public GroupsService() {}

  private GroupsApi getApi() {
    return this.api;
  }

  public GroupsService(Configuration configuration, HttpClient httpClient) {
    this.configuration = configuration;
    this.api = new GroupsApi(httpClient, configuration.getSmsServer(), new HttpMapper());
  }

  public Group get(String groupId) throws ApiException {

    CreateGroupResponseDto response = getApi().retrieveGroup(configuration.getProjectId(), groupId);
    return GroupsDtoConverter.convert(response);
  }

  public Group create() throws ApiException {
    return this.create(null);
  }

  public Group create(GroupCreateRequestParameters parameters) throws ApiException {
    GroupCreateRequestParameters guardParameters =
        null != parameters ? parameters : GroupCreateRequestParameters.builder().build();

    CreateGroupResponseDto response =
        getApi()
            .createGroup(configuration.getProjectId(), GroupsDtoConverter.convert(guardParameters));
    return GroupsDtoConverter.convert(response);
  }

  public GroupsListResponse list() throws ApiException {
    return this.list(null);
  }

  public GroupsListResponse list(GroupsListRequestParameters parameters) throws ApiException {
    GroupsListRequestParameters guardParameters =
        null != parameters ? parameters : GroupsListRequestParameters.builder().build();

    ApiGroupListDto response =
        getApi()
            .listGroups(
                configuration.getProjectId(),
                guardParameters.getPage().orElse(null),
                guardParameters.getPageSize().orElse(null));

    Pair<Collection<Group>, PageToken<Integer>> content = GroupsDtoConverter.convert(response);

    return new GroupsListResponse(
        this, new Page<>(guardParameters, content.getLeft(), content.getRight()));
  }

  public Group replace(String groupId, GroupReplaceRequestParameters parameters)
      throws ApiException {
    GroupReplaceRequestParameters guardParameters =
        null != parameters ? parameters : GroupReplaceRequestParameters.builder().build();

    CreateGroupResponseDto response =
        getApi()
            .replaceGroup(
                configuration.getProjectId(), groupId, GroupsDtoConverter.convert(guardParameters));
    return GroupsDtoConverter.convert(response);
  }

  public Group update(String groupId, GroupUpdateRequestParameters parameters) throws ApiException {
    GroupUpdateRequestParameters guardParameters =
        null != parameters ? parameters : GroupUpdateRequestParameters.builder().build();

    CreateGroupResponseDto response =
        getApi()
            .updateGroup(
                configuration.getProjectId(), groupId, GroupsDtoConverter.convert(guardParameters));
    return GroupsDtoConverter.convert(response);
  }

  public void delete(String groupId) throws ApiException {
    getApi().deleteGroup(configuration.getProjectId(), groupId);
  }

  public Collection<String> listMembers(String groupId) throws ApiException {
    return getApi().getMembers(configuration.getProjectId(), groupId);
  }
}
