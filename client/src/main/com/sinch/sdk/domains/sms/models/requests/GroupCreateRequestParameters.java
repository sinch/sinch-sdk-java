package com.sinch.sdk.domains.sms.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import java.util.Collection;

/**
 * Parameters request to create a group
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/CreateGroup">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/CreateGroup</a>
 * @since 1.0
 */
public class GroupCreateRequestParameters {

  private final OptionalValue<String> name;
  private final OptionalValue<Collection<String>> members;
  private final OptionalValue<Collection<String>> childGroupIds;
  private final OptionalValue<GroupAutoUpdateRequestParameters> autoUpdate;

  private GroupCreateRequestParameters(
      OptionalValue<String> name,
      OptionalValue<Collection<String>> members,
      OptionalValue<Collection<String>> childGroupIds,
      OptionalValue<GroupAutoUpdateRequestParameters> autoUpdate) {
    this.name = name;
    this.members = members;
    this.childGroupIds = childGroupIds;
    this.autoUpdate = autoUpdate;
  }

  public OptionalValue<String> getName() {
    return name;
  }

  public OptionalValue<Collection<String>> getMembers() {
    return members;
  }

  public OptionalValue<Collection<String>> getChildGroupIds() {
    return childGroupIds;
  }

  public OptionalValue<GroupAutoUpdateRequestParameters> getAutoUpdate() {
    return autoUpdate;
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

    OptionalValue<String> name = OptionalValue.empty();
    OptionalValue<Collection<String>> members = OptionalValue.empty();
    OptionalValue<Collection<String>> childGroupIds = OptionalValue.empty();
    OptionalValue<GroupAutoUpdateRequestParameters> autoUpdate = OptionalValue.empty();

    private Builder() {}

    private Builder(GroupCreateRequestParameters parameters) {
      this.name = parameters.getName();
      this.members = parameters.getMembers();
      this.childGroupIds = parameters.getChildGroupIds();
      this.autoUpdate = parameters.getAutoUpdate();
    }

    /**
     * @param name Name of the group
     * @return current builder
     */
    public Builder setName(String name) {
      this.name = OptionalValue.of(name);
      return this;
    }

    /**
     * @param members Initial list of phone numbers in E.164 format MSISDNs for the group
     * @return current builder
     */
    public Builder setMembers(Collection<String> members) {
      this.members = OptionalValue.of(members);
      return this;
    }

    /**
     * @param childGroupIds Child group IDs
     * @return current builder
     */
    public Builder setChildGroupIds(Collection<String> childGroupIds) {
      this.childGroupIds = OptionalValue.of(childGroupIds);
      return this;
    }

    /**
     * @param autoUpdate Auto update settings
     * @return current builder
     */
    public Builder setAutoUpdate(GroupAutoUpdateRequestParameters autoUpdate) {
      this.autoUpdate = OptionalValue.of(autoUpdate);
      return this;
    }

    public GroupCreateRequestParameters build() {
      return new GroupCreateRequestParameters(name, members, childGroupIds, autoUpdate);
    }
  }
}
