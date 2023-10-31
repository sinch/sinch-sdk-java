/*
 * API Overview | Sinch
 * Sinch SMS API is one of the easiest APIs we offer and enables you to add fast and reliable global SMS to your applications. Send single messages, scheduled batch messages, use available message templates and more.
 *
 * The version of the OpenAPI document: v1
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.sms.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/** CreateGroupResponseDto */
@JsonPropertyOrder({
  CreateGroupResponseDto.JSON_PROPERTY_ID,
  CreateGroupResponseDto.JSON_PROPERTY_NAME,
  CreateGroupResponseDto.JSON_PROPERTY_SIZE,
  CreateGroupResponseDto.JSON_PROPERTY_CREATED_AT,
  CreateGroupResponseDto.JSON_PROPERTY_MODIFIED_AT,
  CreateGroupResponseDto.JSON_PROPERTY_CHILD_GROUPS,
  CreateGroupResponseDto.JSON_PROPERTY_AUTO_UPDATE
})
// @javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class CreateGroupResponseDto {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_SIZE = "size";
  private Integer size;

  public static final String JSON_PROPERTY_CREATED_AT = "created_at";
  private OffsetDateTime createdAt;

  public static final String JSON_PROPERTY_MODIFIED_AT = "modified_at";
  private OffsetDateTime modifiedAt;

  public static final String JSON_PROPERTY_CHILD_GROUPS = "child_groups";
  private Set<Object> childGroups;

  public static final String JSON_PROPERTY_AUTO_UPDATE = "auto_update";
  private GroupAutoUpdateDto autoUpdate;

  public CreateGroupResponseDto() {}

  @JsonCreator
  public CreateGroupResponseDto(
      @JsonProperty(JSON_PROPERTY_SIZE) Integer size,
      @JsonProperty(JSON_PROPERTY_CREATED_AT) OffsetDateTime createdAt,
      @JsonProperty(JSON_PROPERTY_MODIFIED_AT) OffsetDateTime modifiedAt) {
    this();
    this.size = size;
    this.createdAt = createdAt;
    this.modifiedAt = modifiedAt;
  }

  public CreateGroupResponseDto id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The ID used to reference this group.
   *
   * @return id
   */
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getId() {
    return id;
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(String id) {
    this.id = id;
  }

  public CreateGroupResponseDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of group, if set.
   *
   * @return name
   */
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getName() {
    return name;
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setName(String name) {
    this.name = name;
  }

  /**
   * The number of members currently in the group.
   *
   * @return size
   */
  @JsonProperty(JSON_PROPERTY_SIZE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getSize() {
    return size;
  }

  /**
   * Timestamp for group creation. Format: YYYY-MM-DDThh:mm:ss.SSSZ
   *
   * @return createdAt
   */
  @JsonProperty(JSON_PROPERTY_CREATED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  /**
   * Timestamp for when the group was last updated. Format: YYYY-MM-DDThh:mm:ss.SSSZ
   *
   * @return modifiedAt
   */
  @JsonProperty(JSON_PROPERTY_MODIFIED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OffsetDateTime getModifiedAt() {
    return modifiedAt;
  }

  public CreateGroupResponseDto childGroups(Set<Object> childGroups) {
    this.childGroups = childGroups;
    return this;
  }

  public CreateGroupResponseDto addChildGroupsItem(Object childGroupsItem) {
    if (this.childGroups == null) {
      this.childGroups = new LinkedHashSet<>();
    }
    this.childGroups.add(childGroupsItem);
    return this;
  }

  /**
   * Phone numbers (MSISDNs) of child group will be included in this group. If present, this group
   * will be auto populated. Constraints: Elements must be group IDs.
   *
   * @return childGroups
   */
  @JsonProperty(JSON_PROPERTY_CHILD_GROUPS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Set<Object> getChildGroups() {
    return childGroups;
  }

  @JsonDeserialize(as = LinkedHashSet.class)
  @JsonProperty(JSON_PROPERTY_CHILD_GROUPS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setChildGroups(Set<Object> childGroups) {
    this.childGroups = childGroups;
  }

  public CreateGroupResponseDto autoUpdate(GroupAutoUpdateDto autoUpdate) {
    this.autoUpdate = autoUpdate;
    return this;
  }

  /**
   * Get autoUpdate
   *
   * @return autoUpdate
   */
  @JsonProperty(JSON_PROPERTY_AUTO_UPDATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public GroupAutoUpdateDto getAutoUpdate() {
    return autoUpdate;
  }

  @JsonProperty(JSON_PROPERTY_AUTO_UPDATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAutoUpdate(GroupAutoUpdateDto autoUpdate) {
    this.autoUpdate = autoUpdate;
  }

  /** Return true if this createGroupResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateGroupResponseDto createGroupResponse = (CreateGroupResponseDto) o;
    return Objects.equals(this.id, createGroupResponse.id)
        && Objects.equals(this.name, createGroupResponse.name)
        && Objects.equals(this.size, createGroupResponse.size)
        && Objects.equals(this.createdAt, createGroupResponse.createdAt)
        && Objects.equals(this.modifiedAt, createGroupResponse.modifiedAt)
        && Objects.equals(this.childGroups, createGroupResponse.childGroups)
        && Objects.equals(this.autoUpdate, createGroupResponse.autoUpdate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, size, createdAt, modifiedAt, childGroups, autoUpdate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateGroupResponseDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    modifiedAt: ").append(toIndentedString(modifiedAt)).append("\n");
    sb.append("    childGroups: ").append(toIndentedString(childGroups)).append("\n");
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
}
