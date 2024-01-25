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
import java.util.Objects;

/** GetChannelProfileResponseDto */
@JsonPropertyOrder({GetChannelProfileResponseDto.JSON_PROPERTY_PROFILE_NAME})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class GetChannelProfileResponseDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_PROFILE_NAME = "profile_name";
  private String profileName;
  private boolean profileNameDefined = false;

  public GetChannelProfileResponseDto() {}

  public GetChannelProfileResponseDto profileName(String profileName) {
    this.profileName = profileName;
    this.profileNameDefined = true;
    return this;
  }

  /**
   * The profile name.
   *
   * @return profileName
   */
  @JsonProperty(JSON_PROPERTY_PROFILE_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getProfileName() {
    return profileName;
  }

  @JsonIgnore
  public boolean getProfileNameDefined() {
    return profileNameDefined;
  }

  @JsonProperty(JSON_PROPERTY_PROFILE_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setProfileName(String profileName) {
    this.profileName = profileName;
    this.profileNameDefined = true;
  }

  /** Return true if this GetChannelProfileResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetChannelProfileResponseDto getChannelProfileResponse = (GetChannelProfileResponseDto) o;
    return Objects.equals(this.profileName, getChannelProfileResponse.profileName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(profileName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetChannelProfileResponseDto {\n");
    sb.append("    profileName: ").append(toIndentedString(profileName)).append("\n");
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
