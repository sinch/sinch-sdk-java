package com.sinch.sdk.domains.sms.models.v1.groups.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.sms.models.v1.groups.GroupAutoUpdate;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

@JsonPropertyOrder({
  GroupRequestImpl.JSON_PROPERTY_ID,
  GroupRequestImpl.JSON_PROPERTY_NAME,
  GroupRequestImpl.JSON_PROPERTY_SIZE,
  GroupRequestImpl.JSON_PROPERTY_CREATED_AT,
  GroupRequestImpl.JSON_PROPERTY_MODIFIED_AT,
  GroupRequestImpl.JSON_PROPERTY_CHILD_GROUPS,
  GroupRequestImpl.JSON_PROPERTY_AUTO_UPDATE,
  GroupRequestImpl.JSON_PROPERTY_MEMBERS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class GroupRequestImpl implements GroupRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_NAME = "name";

  private OptionalValue<String> name;

  public static final String JSON_PROPERTY_SIZE = "size";

  private OptionalValue<Integer> size;

  public static final String JSON_PROPERTY_CREATED_AT = "created_at";

  private OptionalValue<Instant> createdAt;

  public static final String JSON_PROPERTY_MODIFIED_AT = "modified_at";

  private OptionalValue<Instant> modifiedAt;

  public static final String JSON_PROPERTY_CHILD_GROUPS = "child_groups";

  private OptionalValue<Set<String>> childGroups;

  public static final String JSON_PROPERTY_AUTO_UPDATE = "auto_update";

  private OptionalValue<GroupAutoUpdate> autoUpdate;

  public static final String JSON_PROPERTY_MEMBERS = "members";

  private OptionalValue<Set<String>> members;

  public GroupRequestImpl() {}

  protected GroupRequestImpl(
      OptionalValue<String> id,
      OptionalValue<String> name,
      OptionalValue<Integer> size,
      OptionalValue<Instant> createdAt,
      OptionalValue<Instant> modifiedAt,
      OptionalValue<Set<String>> childGroups,
      OptionalValue<GroupAutoUpdate> autoUpdate,
      OptionalValue<Set<String>> members) {
    this.id = id;
    this.name = name;
    this.size = size;
    this.createdAt = createdAt;
    this.modifiedAt = modifiedAt;
    this.childGroups = childGroups;
    this.autoUpdate = autoUpdate;
    this.members = members;
  }

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<String> id() {
    return id;
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
  public Integer getSize() {
    return size.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<Integer> size() {
    return size;
  }

  @JsonIgnore
  public Instant getCreatedAt() {
    return createdAt.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<Instant> createdAt() {
    return createdAt;
  }

  @JsonIgnore
  public Instant getModifiedAt() {
    return modifiedAt.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<Instant> modifiedAt() {
    return modifiedAt;
  }

  @JsonIgnore
  public Set<String> getChildGroups() {
    return childGroups.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHILD_GROUPS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Set<String>> childGroups() {
    return childGroups;
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

  @JsonIgnore
  public Set<String> getMembers() {
    return members.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MEMBERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Set<String>> members() {
    return members;
  }

  /** Return true if this ApiGroupRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GroupRequestImpl apiGroupRequest = (GroupRequestImpl) o;
    return Objects.equals(this.id, apiGroupRequest.id)
        && Objects.equals(this.name, apiGroupRequest.name)
        && Objects.equals(this.size, apiGroupRequest.size)
        && Objects.equals(this.createdAt, apiGroupRequest.createdAt)
        && Objects.equals(this.modifiedAt, apiGroupRequest.modifiedAt)
        && Objects.equals(this.childGroups, apiGroupRequest.childGroups)
        && Objects.equals(this.autoUpdate, apiGroupRequest.autoUpdate)
        && Objects.equals(this.members, apiGroupRequest.members);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, size, createdAt, modifiedAt, childGroups, autoUpdate, members);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GroupRequestImpl {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    modifiedAt: ").append(toIndentedString(modifiedAt)).append("\n");
    sb.append("    childGroups: ").append(toIndentedString(childGroups)).append("\n");
    sb.append("    autoUpdate: ").append(toIndentedString(autoUpdate)).append("\n");
    sb.append("    members: ").append(toIndentedString(members)).append("\n");
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
  static class Builder implements GroupRequest.Builder {
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<String> name = OptionalValue.empty();
    OptionalValue<Integer> size = OptionalValue.empty();
    OptionalValue<Instant> createdAt = OptionalValue.empty();
    OptionalValue<Instant> modifiedAt = OptionalValue.empty();
    OptionalValue<Set<String>> childGroups = OptionalValue.empty();
    OptionalValue<GroupAutoUpdate> autoUpdate = OptionalValue.empty();
    OptionalValue<Set<String>> members = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ID)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    public Builder setName(String name) {
      this.name = OptionalValue.of(name);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SIZE)
    public Builder setSize(Integer size) {
      this.size = OptionalValue.of(size);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    public Builder setCreatedAt(Instant createdAt) {
      this.createdAt = OptionalValue.of(createdAt);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MODIFIED_AT)
    public Builder setModifiedAt(Instant modifiedAt) {
      this.modifiedAt = OptionalValue.of(modifiedAt);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CHILD_GROUPS)
    public Builder setChildGroups(Set<String> childGroups) {
      this.childGroups = OptionalValue.of(childGroups);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_AUTO_UPDATE)
    public Builder setAutoUpdate(GroupAutoUpdate autoUpdate) {
      this.autoUpdate = OptionalValue.of(autoUpdate);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MEMBERS)
    public Builder setMembers(Set<String> members) {
      this.members = OptionalValue.of(members);
      return this;
    }

    public GroupRequest build() {
      return new GroupRequestImpl(
          id, name, size, createdAt, modifiedAt, childGroups, autoUpdate, members);
    }
  }
}
