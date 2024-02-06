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

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/** UpdateGroupRequestAutoUpdateDto */
@JsonPropertyOrder({
  UpdateGroupRequestAutoUpdateDto.JSON_PROPERTY_TO,
  UpdateGroupRequestAutoUpdateDto.JSON_PROPERTY_ADD,
  UpdateGroupRequestAutoUpdateDto.JSON_PROPERTY_REMOVE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class UpdateGroupRequestAutoUpdateDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_TO = "to";
  private String to;
  private boolean toDefined = false;

  public static final String JSON_PROPERTY_ADD = "add";
  private UpdateGroupRequestAutoUpdateAddDto add;
  private boolean addDefined = false;

  public static final String JSON_PROPERTY_REMOVE = "remove";
  private UpdateGroupRequestAutoUpdateRemoveDto remove;
  private boolean removeDefined = false;

  public UpdateGroupRequestAutoUpdateDto() {}

  public UpdateGroupRequestAutoUpdateDto to(String to) {
    this.to = to;
    this.toDefined = true;
    return this;
  }

  /**
   * Short code or long number addressed in &lt;a
   * href&#x3D;\&quot;https://community.sinch.com/t5/Glossary/MO-Mobile-Originated/ta-p/7618\&quot;
   * target&#x3D;\&quot;_blank\&quot;&gt;MO&lt;/a&gt;. Constraints: Must be a valid phone number or
   * short code.
   *
   * @return to
   */
  @JsonProperty(JSON_PROPERTY_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getTo() {
    return to;
  }

  @JsonIgnore
  public boolean getToDefined() {
    return toDefined;
  }

  @JsonProperty(JSON_PROPERTY_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTo(String to) {
    this.to = to;
    this.toDefined = true;
  }

  public UpdateGroupRequestAutoUpdateDto add(UpdateGroupRequestAutoUpdateAddDto add) {
    this.add = add;
    this.addDefined = true;
    return this;
  }

  /**
   * Get add
   *
   * @return add
   */
  @JsonProperty(JSON_PROPERTY_ADD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public UpdateGroupRequestAutoUpdateAddDto getAdd() {
    return add;
  }

  @JsonIgnore
  public boolean getAddDefined() {
    return addDefined;
  }

  @JsonProperty(JSON_PROPERTY_ADD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAdd(UpdateGroupRequestAutoUpdateAddDto add) {
    this.add = add;
    this.addDefined = true;
  }

  public UpdateGroupRequestAutoUpdateDto remove(UpdateGroupRequestAutoUpdateRemoveDto remove) {
    this.remove = remove;
    this.removeDefined = true;
    return this;
  }

  /**
   * Get remove
   *
   * @return remove
   */
  @JsonProperty(JSON_PROPERTY_REMOVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public UpdateGroupRequestAutoUpdateRemoveDto getRemove() {
    return remove;
  }

  @JsonIgnore
  public boolean getRemoveDefined() {
    return removeDefined;
  }

  @JsonProperty(JSON_PROPERTY_REMOVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRemove(UpdateGroupRequestAutoUpdateRemoveDto remove) {
    this.remove = remove;
    this.removeDefined = true;
  }

  /** Return true if this UpdateGroup_request_auto_update object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateGroupRequestAutoUpdateDto updateGroupRequestAutoUpdate =
        (UpdateGroupRequestAutoUpdateDto) o;
    return Objects.equals(this.to, updateGroupRequestAutoUpdate.to)
        && Objects.equals(this.add, updateGroupRequestAutoUpdate.add)
        && Objects.equals(this.remove, updateGroupRequestAutoUpdate.remove);
  }

  @Override
  public int hashCode() {
    return Objects.hash(to, add, remove);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateGroupRequestAutoUpdateDto {\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    add: ").append(toIndentedString(add)).append("\n");
    sb.append("    remove: ").append(toIndentedString(remove)).append("\n");
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
