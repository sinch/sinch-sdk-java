package com.sinch.sdk.domains.sms.api.v1.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.domains.sms.api.v1.internal.GroupsApi;
import com.sinch.sdk.domains.sms.models.v1.groups.Group;
import com.sinch.sdk.domains.sms.models.v1.groups.request.GroupRequest;
import com.sinch.sdk.domains.sms.models.v1.groups.request.GroupUpdateRequest;
import com.sinch.sdk.domains.sms.models.v1.groups.request.ListGroupsQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.groups.response.ListGroupsResponse;
import com.sinch.sdk.domains.sms.models.v1.groups.response.internal.ApiGroupList;
import com.sinch.sdk.domains.sms.models.v1.internal.SMSCursorPageNavigator;
import com.sinch.sdk.models.SmsContext;
import java.util.Collection;
import java.util.Map;

public class GroupsService implements com.sinch.sdk.domains.sms.api.v1.GroupsService {

  private final GroupsApi api;

  protected GroupsApi getApi() {
    return this.api;
  }

  public GroupsService(
      String uriUUID,
      SmsContext context,
      HttpClient httpClient,
      Map<String, AuthManager> authManagers) {
    this.api =
        new GroupsApi(httpClient, context.getSmsServer(), authManagers, new HttpMapper(), uriUUID);
  }

  public Group get(String groupId) throws ApiException {

    return getApi().retrieveGroup(groupId);
  }

  public Group create(GroupRequest parameters) throws ApiException {

    return getApi().createGroup(parameters);
  }

  public Group replace(String groupId, GroupRequest parameters) throws ApiException {

    return getApi().replaceGroup(groupId, parameters);
  }

  public Group update(String groupId, GroupUpdateRequest parameters) throws ApiException {
    return getApi().updateGroup(groupId, parameters);
  }

  public void delete(String groupId) throws ApiException {
    getApi().deleteGroup(groupId);
  }

  public Collection<String> listMembers(String groupId) throws ApiException {
    return getApi().getMembers(groupId);
  }

  public ListGroupsResponse list(ListGroupsQueryParameters parameters) throws ApiException {
    ApiGroupList response = getApi().listGroups(parameters);

    SMSCursorPageNavigator navigator =
        new SMSCursorPageNavigator(response.getPage(), response.getPageSize());

    return new ListGroupsResponse(this, new Page<>(parameters, response.getGroups(), navigator));
  }

  public ListGroupsResponse list() throws ApiException {
    return list(null);
  }
}
