package com.sinch.sdk.domains.sms;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.sms.models.Group;
import com.sinch.sdk.domains.sms.models.requests.GroupCreateRequestParameters;
import com.sinch.sdk.domains.sms.models.requests.GroupReplaceRequestParameters;
import com.sinch.sdk.domains.sms.models.requests.GroupUpdateRequestParameters;
import com.sinch.sdk.domains.sms.models.requests.GroupsListRequestParameters;
import com.sinch.sdk.domains.sms.models.responses.GroupsListResponse;
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
 */
public interface GroupsService {

  /**
   * Retrieve a group
   *
   * <p>This operation retrieves a specific group with the provided group ID.
   *
   * @param groupId The inbound ID found when listing inbound messages
   * @return Group associated to groupId
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/RetrieveGroup">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/RetrieveGroup</a>
   * @since 1.0
   */
  Group get(String groupId) throws ApiException;

  /**
   * Create a group
   *
   * <p>A group is a set of phone numbers (MSISDNs) that can be used as a target in the <code>
   * send_batch_msg</code> operation. An MSISDN can only occur once in a group and any attempts to
   * add a duplicate would be ignored but not rejected.
   *
   * @param parameters Parameters t be used to define group onto creation
   * @return Created group
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/CreateGroup">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/CreateGroup</a>
   * @since 1.0
   */
  Group create(GroupCreateRequestParameters parameters) throws ApiException;

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
   */
  GroupsListResponse list(GroupsListRequestParameters parameters) throws ApiException;

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
   */
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
   */
  Group update(String groupId, GroupUpdateRequestParameters parameters) throws ApiException;

  /**
   * Delete a group
   *
   * @param groupId ID of a group that you are interested in getting.
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/deleteGroup">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/deleteGroup</a>
   * @since 1.0
   */
  void delete(String groupId) throws ApiException;

  /**
   * Get phone numbers for a group
   *
   * @param groupId ID of a group that you are interested in getting.
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/deleteGroup">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/deleteGroup</a>
   * @since 1.0
   */
  Collection<String> listMembers(String groupId) throws ApiException;
}
