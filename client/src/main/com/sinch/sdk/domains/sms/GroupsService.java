package com.sinch.sdk.domains.sms;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.sms.models.Group;
import com.sinch.sdk.domains.sms.models.requests.GroupCreateRequestParameters;
import com.sinch.sdk.domains.sms.models.requests.GroupReplaceRequestParameters;
import com.sinch.sdk.domains.sms.models.requests.GroupUpdateRequestParameters;
import com.sinch.sdk.domains.sms.models.requests.GroupsListRequestParameters;
import com.sinch.sdk.domains.sms.models.responses.GroupsListResponse;
import com.sinch.sdk.domains.sms.models.v1.groups.request.GroupRequest;
import com.sinch.sdk.domains.sms.models.v1.groups.request.GroupUpdateRequest;
import com.sinch.sdk.domains.sms.models.v1.groups.request.ListGroupsQueryParameters;
import java.util.Collection;

/**
 * Groups Service
 *
 * <p>A group is a set of phone numbers (or MSISDNs) that can be used as a target when sending an
 * SMS. An phone number (MSISDN) can only occur once in a group and any attempts to add a duplicate
 * are ignored but not rejected.
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups</a>
 * @since 1.0
 * @deprecated use {@link com.sinch.sdk.domains.sms.api.v1.GroupsService} instead.
 */
@Deprecated
public interface GroupsService {

  /**
   * Retrieve a group.
   *
   * <p>This operation retrieves a specific group with the provided group ID.
   *
   * @param groupId The inbound ID found when listing inbound messages
   * @return Group associated to groupId
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/RetrieveGroup">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/RetrieveGroup</a>
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.sms.api.v1.GroupsService#get(String)} instead.
   */
  @Deprecated
  Group get(String groupId) throws ApiException;

  /**
   * Create a group.
   *
   * <p>A group is a set of phone numbers (MSISDNs) that can be used as a target in the <code>
   * send_batch_msg</code> operation. An MSISDN can only occur once in a group and any attempts to
   * add a duplicate would be ignored but not rejected.
   *
   * @param parameters Parameters to be used to define group onto creation
   * @return Created group
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/CreateGroup">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/CreateGroup</a>
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.sms.api.v1.GroupsService#create(GroupRequest)}
   *     instead.
   */
  @Deprecated
  Group create(GroupCreateRequestParameters parameters) throws ApiException;

  /**
   * Create an unnamed and empty group
   *
   * @return See {@link #create(GroupCreateRequestParameters)}
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.sms.api.v1.GroupsService#create(GroupRequest)}
   *     instead.
   */
  @Deprecated
  Group create() throws ApiException;

  /**
   * List Groups
   *
   * <p>With the list operation you can list all groups that you have created. This operation
   * supports pagination.
   *
   * <p>Groups are returned in reverse chronological order.
   *
   * @param parameters Filtering parameters
   * @return group list
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/ListGroups">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/ListGroups</a>
   * @since 1.0
   * @deprecated use {@link
   *     com.sinch.sdk.domains.sms.api.v1.GroupsService#list(ListGroupsQueryParameters)} instead.
   */
  @Deprecated
  GroupsListResponse list(GroupsListRequestParameters parameters) throws ApiException;

  /**
   * List groups with default parameters
   *
   * @return See {@link #list(GroupsListRequestParameters)}
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.sms.api.v1.GroupsService#list()} instead.
   */
  @Deprecated
  GroupsListResponse list() throws ApiException;

  /**
   * Replace a group
   *
   * <p>The replace operation will replace all parameters, including members, of an existing group
   * with new values.
   *
   * <p>Replacing a group targeted by a batch message scheduled in the future is allowed and changes
   * will be reflected when the batch is sent.
   *
   * @param groupId ID of a group that you are interested in getting.
   * @param parameters Parameters to be replaced for group
   * @return Group associated to groupId
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/ReplaceGroup">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/ReplaceGroup</a>
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.sms.api.v1.GroupsService#replace(String,
   *     GroupRequest)} instead.
   */
  @Deprecated
  Group replace(String groupId, GroupReplaceRequestParameters parameters) throws ApiException;

  /**
   * Update a group
   *
   * @param groupId ID of a group that you are interested in getting.
   * @param parameters Parameters to be used to update group
   * @return Modified group associated to groupId
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/UpdateGroup">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/UpdateGroup</a>
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.sms.api.v1.GroupsService#update(String,
   *     GroupUpdateRequest)} instead.
   */
  @Deprecated
  Group update(String groupId, GroupUpdateRequestParameters parameters) throws ApiException;

  /**
   * Delete a group
   *
   * @param groupId ID of a group that you are interested in getting.
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/deleteGroup">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/deleteGroup</a>
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.sms.api.v1.GroupsService#delete(String)} instead.
   */
  @Deprecated
  void delete(String groupId) throws ApiException;

  /**
   * Get phone numbers for a group
   *
   * @param groupId ID of a group that you are interested in getting.
   * @return A list of phone numbers in E.164 format.
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/deleteGroup">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/deleteGroup</a>
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.sms.api.v1.GroupsService#listMembers(String)}
   *     instead.
   */
  @Deprecated
  Collection<String> listMembers(String groupId) throws ApiException;
}
