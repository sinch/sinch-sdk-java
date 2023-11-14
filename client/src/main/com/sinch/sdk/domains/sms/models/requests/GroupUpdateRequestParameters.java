package com.sinch.sdk.domains.sms.models.requests;

import com.sinch.sdk.domains.sms.models.GroupAutoUpdate;
import java.util.Collection;
import java.util.Optional;

/**
 * Parameters request to updat" a group
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/UpdateGroup">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/UpdateGroup</a>
 * @since 1.0
 */
public class GroupUpdateRequestParameters {

  private final String name;
  private final Collection<String> add;
  private final Collection<String> remove;
  private final String addFromGroup;
  private final String removeFromGroup;
  private final GroupAutoUpdate autoUpdate;

  public GroupUpdateRequestParameters(
      String name,
      Collection<String> add,
      Collection<String> remove,
      String addFromGroup,
      String removeFromGroup,
      GroupAutoUpdate autoUpdate) {
    this.name = name;
    this.add = add;
    this.remove = remove;
    this.addFromGroup = addFromGroup;
    this.removeFromGroup = removeFromGroup;
    this.autoUpdate = autoUpdate;
  }

  public Optional<String> getName() {
    return Optional.ofNullable(name);
  }

  public Optional<Collection<String>> getAdd() {
    return Optional.ofNullable(add);
  }

  public Optional<Collection<String>> getRemove() {
    return Optional.ofNullable(remove);
  }

  public Optional<String> getAddFromGroup() {
    return Optional.ofNullable(addFromGroup);
  }

  public Optional<String> getRemoveFromGroup() {
    return Optional.ofNullable(removeFromGroup);
  }

  public Optional<GroupAutoUpdate> getAutoUpdate() {
    return Optional.ofNullable(autoUpdate);
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

    String name;

    Collection<String> add;

    Collection<String> remove;

    String addFromGroup;

    String removeFromGroup;

    GroupAutoUpdate autoUpdate;

    private Builder() {}

    private Builder(GroupUpdateRequestParameters parameters) {
      this.name = parameters.getName().orElse(null);

      this.add = parameters.getAdd().orElse(null);

      this.remove = parameters.getRemove().orElse(null);

      this.addFromGroup = parameters.getAddFromGroup().orElse(null);

      this.removeFromGroup = parameters.getRemoveFromGroup().orElse(null);

      this.autoUpdate = parameters.getAutoUpdate().orElse(null);
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setAdd(Collection<String> add) {
      this.add = add;
      return this;
    }

    public Builder setRemove(Collection<String> remove) {
      this.remove = remove;
      return this;
    }

    public Builder setAddFromGroup(String addFromGroup) {
      this.addFromGroup = addFromGroup;
      return this;
    }

    public Builder setRemoveFromGroup(String removeFromGroup) {
      this.removeFromGroup = removeFromGroup;
      return this;
    }

    public Builder setAutoUpdate(GroupAutoUpdate autoUpdate) {
      this.autoUpdate = autoUpdate;
      return this;
    }

    public GroupUpdateRequestParameters build() {
      return new GroupUpdateRequestParameters(
          name, add, remove, addFromGroup, removeFromGroup, autoUpdate);
    }
  }
}
