package com.sinch.sdk.domains.sms.models;

import java.time.Instant;
import java.util.Collection;

public class Group {

  private final String id;
  private final String name;
  private final Integer size;
  private final Instant createdAt;
  private final Instant modifiedAt;
  private final Collection<String> childGroupIds;
  private final GroupAutoUpdate autoUpdate;

  /**
   * @param id Unique identifier for the group
   * @param name Name of group if set
   * @param size The number of members currently in the group
   * @param createdAt Timestamp for when the group was created
   * @param modifiedAt Timestamp for when the group was created
   * @param childGroupIds MSISDNs of child group will be included in this group. If present then
   *     this group will be auto populated. Constraints: Elements must be group IDs
   * @param autoUpdate Describes how this group is auto updated through user interaction. Is <code>
   *     null</code> if the group is not auto updated.
   */
  public Group(
      String id,
      String name,
      Integer size,
      Instant createdAt,
      Instant modifiedAt,
      Collection<String> childGroupIds,
      GroupAutoUpdate autoUpdate) {
    this.id = id;
    this.name = name;
    this.size = size;
    this.createdAt = createdAt;
    this.modifiedAt = modifiedAt;
    this.childGroupIds = childGroupIds;
    this.autoUpdate = autoUpdate;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Integer getSize() {
    return size;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getModifiedAt() {
    return modifiedAt;
  }

  public Collection<String> getChildGroupIds() {
    return childGroupIds;
  }

  public GroupAutoUpdate getAutoUpdate() {
    return autoUpdate;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "Group{"
        + "id='"
        + id
        + '\''
        + ", name='"
        + name
        + '\''
        + ", size="
        + size
        + ", createdAt="
        + createdAt
        + ", modifiedAt="
        + modifiedAt
        + ", childGroupIds="
        + childGroupIds
        + ", autoUpdate="
        + autoUpdate
        + '}';
  }

  public static class Builder {

    String id;
    String name;
    Integer size;
    Instant createdAt;
    Instant modifiedAt;
    Collection<String> childGroupIds;
    GroupAutoUpdate autoUpdate;

    private Builder() {}

    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setSize(Integer size) {
      this.size = size;
      return this;
    }

    public Builder setCreatedAt(Instant createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    public Builder setModifiedAt(Instant modifiedAt) {
      this.modifiedAt = modifiedAt;
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

    public Group build() {
      return new Group(id, name, size, createdAt, modifiedAt, childGroupIds, autoUpdate);
    }
  }
}
