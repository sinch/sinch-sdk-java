package com.sinch.sdk.domains.sms.models.requests;

import com.sinch.sdk.domains.sms.models.GroupAutoUpdate;
import java.util.Collection;
import java.util.Optional;

/**
 * Parameters request to create a group
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/CreateGroup">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/CreateGroup</a>
 * @since 1.0
 */
public class GroupCreateRequestParameters {

  private final String name;
  private final Collection<String> members;
  private final Collection<String> childGroupIds;
  private final GroupAutoUpdate autoUpdate;

  /**
   * @param name Name of the group
   * @param members Initial list of phone numbers in E.164 format MSISDNs for the group
   * @param childGroupIds Child group IDs
   * @param autoUpdate Auto update settings
   */
  public GroupCreateRequestParameters(
      String name,
      Collection<String> members,
      Collection<String> childGroupIds,
      GroupAutoUpdate autoUpdate) {
    this.name = name;
    this.members = members;
    this.childGroupIds = childGroupIds;
    this.autoUpdate = autoUpdate;
  }

  public Optional<String> getName() {
    return Optional.ofNullable(name);
  }

  public Optional<Collection<String>> getMembers() {
    return Optional.ofNullable(members);
  }

  public Optional<Collection<String>> getChildGroupIds() {
    return Optional.ofNullable(childGroupIds);
  }

  public Optional<GroupAutoUpdate> getAutoUpdate() {
    return Optional.ofNullable(autoUpdate);
  }

  @Override
  public String toString() {
    return "GroupCreateRequestParameters{"
        + "name='"
        + name
        + '\''
        + ", members="
        + members
        + ", childGroupIds="
        + childGroupIds
        + ", autoUpdate="
        + autoUpdate
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(GroupCreateRequestParameters parameters) {
    return new Builder(parameters);
  }

  public static class Builder {

    String name;
    Collection<String> members;
    Collection<String> childGroupIds;
    GroupAutoUpdate autoUpdate;

    private Builder() {}

    private Builder(GroupCreateRequestParameters parameters) {
      this.name = parameters.getName().orElse(null);
      this.members = parameters.getMembers().orElse(null);
      this.childGroupIds = parameters.getChildGroupIds().orElse(null);
      this.autoUpdate = parameters.getAutoUpdate().orElse(null);
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setMembers(Collection<String> members) {
      this.members = members;
      return this;
    }

    public Builder setChildGroupIds(Collection<String> childGroupIds) {
      this.childGroupIds = childGroupIds;
      return this;
    }

    public Builder setAutoUpdate(GroupAutoUpdate autoUpdate) {
      this.autoUpdate = autoUpdate;
      return this;
    }

    public GroupCreateRequestParameters build() {
      return new GroupCreateRequestParameters(name, members, childGroupIds, autoUpdate);
    }
  }
}
