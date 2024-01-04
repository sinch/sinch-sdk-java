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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** ReplaceGroupRequestDto */
@JsonPropertyOrder({
  ReplaceGroupRequestDto.JSON_PROPERTY_MEMBERS,
  ReplaceGroupRequestDto.JSON_PROPERTY_NAME
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ReplaceGroupRequestDto {
  public static final String JSON_PROPERTY_MEMBERS = "members";
  private List<String> members;
  private boolean membersDefined = false;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;
  private boolean nameDefined = false;

  public ReplaceGroupRequestDto() {}

  public ReplaceGroupRequestDto members(List<String> members) {
    this.members = members;
    this.membersDefined = true;
    return this;
  }

  public ReplaceGroupRequestDto addMembersItem(String membersItem) {
    if (this.members == null) {
      this.members = new ArrayList<>();
    }
    this.membersDefined = true;
    this.members.add(membersItem);
    return this;
  }

  /**
   * The initial members of the group. Constraints: Elements must be phone numbers in &lt;a
   * href&#x3D;\&quot;https://community.sinch.com/t5/Glossary/E-164/ta-p/7537\&quot;
   * target&#x3D;\&quot;_blank\&quot;&gt;E.164&lt;/a&gt; format MSISDNs.
   *
   * @return members
   */
  @JsonProperty(JSON_PROPERTY_MEMBERS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public List<String> getMembers() {
    return members;
  }

  @JsonIgnore
  public boolean getMembersDefined() {
    return membersDefined;
  }

  @JsonProperty(JSON_PROPERTY_MEMBERS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMembers(List<String> members) {
    this.members = members;
    this.membersDefined = true;
  }

  public ReplaceGroupRequestDto name(String name) {
    this.name = name;
    this.nameDefined = true;
    return this;
  }

  /**
   * Name of group.
   *
   * @return name
   */
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getName() {
    return name;
  }

  @JsonIgnore
  public boolean getNameDefined() {
    return nameDefined;
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setName(String name) {
    this.name = name;
    this.nameDefined = true;
  }

  /** Return true if this ReplaceGroup_request object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReplaceGroupRequestDto replaceGroupRequest = (ReplaceGroupRequestDto) o;
    return Objects.equals(this.members, replaceGroupRequest.members)
        && Objects.equals(this.name, replaceGroupRequest.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(members, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReplaceGroupRequestDto {\n");
    sb.append("    members: ").append(toIndentedString(members)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
