package com.sinch.sdk.domains.sms.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import java.util.Collection;

/**
 * Parameters request to update" a group
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/UpdateGroup">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/UpdateGroup</a>
 * @since 1.0
 */
public class GroupUpdateRequestParameters {

  private final OptionalValue<String> name;
  private final OptionalValue<Collection<String>> add;
  private final OptionalValue<Collection<String>> remove;
  private final OptionalValue<String> addFromGroup;
  private final OptionalValue<String> removeFromGroup;
  private final OptionalValue<GroupAutoUpdateRequestParameters> autoUpdate;

  private GroupUpdateRequestParameters(
      OptionalValue<String> name,
      OptionalValue<Collection<String>> add,
      OptionalValue<Collection<String>> remove,
      OptionalValue<String> addFromGroup,
      OptionalValue<String> removeFromGroup,
      OptionalValue<GroupAutoUpdateRequestParameters> autoUpdate) {
    this.name = name;
    this.add = add;
    this.remove = remove;
    this.addFromGroup = addFromGroup;
    this.removeFromGroup = removeFromGroup;
    this.autoUpdate = autoUpdate;
  }

  public OptionalValue<String> getName() {
    return name;
  }

  public OptionalValue<Collection<String>> getAdd() {
    return add;
  }

  public OptionalValue<Collection<String>> getRemove() {
    return remove;
  }

  public OptionalValue<String> getAddFromGroup() {
    return addFromGroup;
  }

  public OptionalValue<String> getRemoveFromGroup() {
    return removeFromGroup;
  }

  public OptionalValue<GroupAutoUpdateRequestParameters> getAutoUpdate() {
    return autoUpdate;
  }

  @Override
  public String toString() {
    return "GroupUpdateRequestParameters{"
        + "name='"
        + name
        + '\''
        + ", add="
        + add
        + ", remove="
        + remove
        + ", addFromGroup='"
        + addFromGroup
        + '\''
        + ", removeFromGroup='"
        + removeFromGroup
        + '\''
        + ", autoUpdate="
        + autoUpdate
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(GroupUpdateRequestParameters parameters) {
    return new Builder(parameters);
  }

  public static class Builder {

    OptionalValue<String> name = OptionalValue.empty();

    OptionalValue<Collection<String>> add = OptionalValue.empty();

    OptionalValue<Collection<String>> remove = OptionalValue.empty();

    OptionalValue<String> addFromGroup = OptionalValue.empty();

    OptionalValue<String> removeFromGroup = OptionalValue.empty();

    OptionalValue<GroupAutoUpdateRequestParameters> autoUpdate = OptionalValue.empty();

    private Builder() {}

    private Builder(GroupUpdateRequestParameters parameters) {
      this.name = parameters.getName();
      this.add = parameters.getAdd();
      this.remove = parameters.getRemove();
      this.addFromGroup = parameters.getAddFromGroup();
      this.removeFromGroup = parameters.getRemoveFromGroup();
      this.autoUpdate = parameters.getAutoUpdate();
    }

    /**
     * @param name The name of the group. Omitting name from the JSON body will leave the name
     *     unchanged. To remove an existing name set, name explicitly to the JSON value null.
     * @return current builder
     */
    public Builder setName(String name) {
      this.name = OptionalValue.of(name);
      return this;
    }

    /**
     * @param add Add a list of phone numbers (MSISDNs) to this group. The phone numbers are a
     *     strings within an array and must be in E.164 format.
     * @return current builder
     */
    public Builder setAdd(Collection<String> add) {
      this.add = OptionalValue.of(add);
      return this;
    }

    /**
     * @param remove Remove a list of phone numbers (MSISDNs) to this group.The phone numbers are a
     *     strings within an array and must be in E.164 format.
     * @return current builder
     */
    public Builder setRemove(Collection<String> remove) {
      this.remove = OptionalValue.of(remove);
      return this;
    }

    /**
     * @param addFromGroup Copy the members from the another group into this group. Constraints:
     *     Must be valid group ID
     * @return current builder
     */
    public Builder setAddFromGroup(String addFromGroup) {
      this.addFromGroup = OptionalValue.of(addFromGroup);
      return this;
    }

    /**
     * @param removeFromGroup Remove the members in a specified group from this group.
     *     <p>Constraints: Must be valid group ID
     * @return current builder
     */
    public Builder setRemoveFromGroup(String removeFromGroup) {
      this.removeFromGroup = OptionalValue.of(removeFromGroup);
      return this;
    }

    /**
     * @param autoUpdate auto update settings
     * @return current builder
     */
    public Builder setAutoUpdate(GroupAutoUpdateRequestParameters autoUpdate) {
      this.autoUpdate = OptionalValue.of(autoUpdate);
      return this;
    }

    public GroupUpdateRequestParameters build() {
      return new GroupUpdateRequestParameters(
          name, add, remove, addFromGroup, removeFromGroup, autoUpdate);
    }
  }
}
