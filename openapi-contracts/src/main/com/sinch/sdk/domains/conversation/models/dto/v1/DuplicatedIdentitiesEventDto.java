/*
 * Conversation API | Sinch
 * Send and receive messages globally over SMS, RCS, WhatsApp, Viber Business, Facebook messenger and other popular channels using the Sinch Conversation API.  The Conversation API endpoint uses built-in transcoding to give you the power of conversation across all supported channels and, if required, full control over channel specific features.
 *
 * The version of the OpenAPI document: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** DuplicatedIdentitiesEventDto */
@JsonPropertyOrder({DuplicatedIdentitiesEventDto.JSON_PROPERTY_DUPLICATED_IDENTITIES})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class DuplicatedIdentitiesEventDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_DUPLICATED_IDENTITIES = "duplicated_identities";
  private List<DuplicatedIdentitiesEventDuplicatedIdentitiesInnerDto> duplicatedIdentities;
  private boolean duplicatedIdentitiesDefined = false;

  public DuplicatedIdentitiesEventDto() {}

  public DuplicatedIdentitiesEventDto duplicatedIdentities(
      List<DuplicatedIdentitiesEventDuplicatedIdentitiesInnerDto> duplicatedIdentities) {
    this.duplicatedIdentities = duplicatedIdentities;
    this.duplicatedIdentitiesDefined = true;
    return this;
  }

  public DuplicatedIdentitiesEventDto addDuplicatedIdentitiesItem(
      DuplicatedIdentitiesEventDuplicatedIdentitiesInnerDto duplicatedIdentitiesItem) {
    if (this.duplicatedIdentities == null) {
      this.duplicatedIdentities = new ArrayList<>();
    }
    this.duplicatedIdentitiesDefined = true;
    this.duplicatedIdentities.add(duplicatedIdentitiesItem);
    return this;
  }

  /**
   * Get duplicatedIdentities
   *
   * @return duplicatedIdentities
   */
  @JsonProperty(JSON_PROPERTY_DUPLICATED_IDENTITIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<DuplicatedIdentitiesEventDuplicatedIdentitiesInnerDto> getDuplicatedIdentities() {
    return duplicatedIdentities;
  }

  @JsonIgnore
  public boolean getDuplicatedIdentitiesDefined() {
    return duplicatedIdentitiesDefined;
  }

  @JsonProperty(JSON_PROPERTY_DUPLICATED_IDENTITIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDuplicatedIdentities(
      List<DuplicatedIdentitiesEventDuplicatedIdentitiesInnerDto> duplicatedIdentities) {
    this.duplicatedIdentities = duplicatedIdentities;
    this.duplicatedIdentitiesDefined = true;
  }

  /** Return true if this DuplicatedIdentitiesEvent object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DuplicatedIdentitiesEventDto duplicatedIdentitiesEvent = (DuplicatedIdentitiesEventDto) o;
    return Objects.equals(
        this.duplicatedIdentities, duplicatedIdentitiesEvent.duplicatedIdentities);
  }

  @Override
  public int hashCode() {
    return Objects.hash(duplicatedIdentities);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DuplicatedIdentitiesEventDto {\n");
    sb.append("    duplicatedIdentities: ")
        .append(toIndentedString(duplicatedIdentities))
        .append("\n");
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