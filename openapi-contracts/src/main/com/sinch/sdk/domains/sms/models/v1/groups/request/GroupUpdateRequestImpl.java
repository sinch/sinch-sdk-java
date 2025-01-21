package com.sinch.sdk.domains.sms.models.v1.groups.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.sms.models.v1.groups.GroupAutoUpdate;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  GroupUpdateRequestImpl.JSON_PROPERTY_ADD,
  GroupUpdateRequestImpl.JSON_PROPERTY_REMOVE,
  GroupUpdateRequestImpl.JSON_PROPERTY_NAME,
  GroupUpdateRequestImpl.JSON_PROPERTY_ADD_FROM_GROUP,
  GroupUpdateRequestImpl.JSON_PROPERTY_REMOVE_FROM_GROUP,
  GroupUpdateRequestImpl.JSON_PROPERTY_AUTO_UPDATE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class GroupUpdateRequestImpl implements GroupUpdateRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ADD = "add";

  private OptionalValue<List<String>> add;

  public static final String JSON_PROPERTY_REMOVE = "remove";

  private OptionalValue<List<String>> remove;

  public static final String JSON_PROPERTY_NAME = "name";

  private OptionalValue<String> name;

  public static final String JSON_PROPERTY_ADD_FROM_GROUP = "add_from_group";

  private OptionalValue<String> addFromGroup;

  public static final String JSON_PROPERTY_REMOVE_FROM_GROUP = "remove_from_group";

  private OptionalValue<String> removeFromGroup;

  public static final String JSON_PROPERTY_AUTO_UPDATE = "auto_update";

  private OptionalValue<GroupAutoUpdate> autoUpdate;

  public GroupUpdateRequestImpl() {}

  protected GroupUpdateRequestImpl(
      OptionalValue<List<String>> add,
      OptionalValue<List<String>> remove,
      OptionalValue<String> name,
      OptionalValue<String> addFromGroup,
      OptionalValue<String> removeFromGroup,
      OptionalValue<GroupAutoUpdate> autoUpdate) {
    this.add = add;
    this.remove = remove;
    this.name = name;
    this.addFromGroup = addFromGroup;
    this.removeFromGroup = removeFromGroup;
    this.autoUpdate = autoUpdate;
  }

  @JsonIgnore
  public List<String> getAdd() {
    return add.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ADD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<String>> add() {
    return add;
  }

  @JsonIgnore
  public List<String> getRemove() {
    return remove.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REMOVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<String>> remove() {
    return remove;
  }

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> name() {
    return name;
  }

  @JsonIgnore
  public String getAddFromGroup() {
    return addFromGroup.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ADD_FROM_GROUP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> addFromGroup() {
    return addFromGroup;
  }

  @JsonIgnore
  public String getRemoveFromGroup() {
    return removeFromGroup.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REMOVE_FROM_GROUP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> removeFromGroup() {
    return removeFromGroup;
  }

  @JsonIgnore
  public GroupAutoUpdate getAutoUpdate() {
    return autoUpdate.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_AUTO_UPDATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<GroupAutoUpdate> autoUpdate() {
    return autoUpdate;
  }

  /** Return true if this ApiGroupUpdate object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GroupUpdateRequestImpl apiGroupUpdate = (GroupUpdateRequestImpl) o;
    return Objects.equals(this.add, apiGroupUpdate.add)
        && Objects.equals(this.remove, apiGroupUpdate.remove)
        && Objects.equals(this.name, apiGroupUpdate.name)
        && Objects.equals(this.addFromGroup, apiGroupUpdate.addFromGroup)
        && Objects.equals(this.removeFromGroup, apiGroupUpdate.removeFromGroup)
        && Objects.equals(this.autoUpdate, apiGroupUpdate.autoUpdate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(add, remove, name, addFromGroup, removeFromGroup, autoUpdate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GroupUpdateRequestImpl {\n");
    sb.append("    add: ").append(toIndentedString(add)).append("\n");
    sb.append("    remove: ").append(toIndentedString(remove)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    addFromGroup: ").append(toIndentedString(addFromGroup)).append("\n");
    sb.append("    removeFromGroup: ").append(toIndentedString(removeFromGroup)).append("\n");
    sb.append("    autoUpdate: ").append(toIndentedString(autoUpdate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements GroupUpdateRequest.Builder {
    OptionalValue<List<String>> add = OptionalValue.empty();
    OptionalValue<List<String>> remove = OptionalValue.empty();
    OptionalValue<String> name = OptionalValue.empty();
    OptionalValue<String> addFromGroup = OptionalValue.empty();
    OptionalValue<String> removeFromGroup = OptionalValue.empty();
    OptionalValue<GroupAutoUpdate> autoUpdate = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ADD)
    public Builder setAdd(List<String> add) {
      this.add = OptionalValue.of(add);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REMOVE)
    public Builder setRemove(List<String> remove) {
      this.remove = OptionalValue.of(remove);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    public Builder setName(String name) {
      this.name = OptionalValue.of(name);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ADD_FROM_GROUP)
    public Builder setAddFromGroup(String addFromGroup) {
      this.addFromGroup = OptionalValue.of(addFromGroup);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REMOVE_FROM_GROUP)
    public Builder setRemoveFromGroup(String removeFromGroup) {
      this.removeFromGroup = OptionalValue.of(removeFromGroup);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_AUTO_UPDATE)
    public Builder setAutoUpdate(GroupAutoUpdate autoUpdate) {
      this.autoUpdate = OptionalValue.of(autoUpdate);
      return this;
    }

    public GroupUpdateRequest build() {
      return new GroupUpdateRequestImpl(
          add, remove, name, addFromGroup, removeFromGroup, autoUpdate);
    }
  }
}
