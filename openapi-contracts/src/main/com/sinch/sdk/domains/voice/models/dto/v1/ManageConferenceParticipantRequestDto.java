/*
 * Voice API | Sinch
 * The Voice API exposes calling- and conference-related functionality in the Sinch Voice Platform.
 *
 * The version of the OpenAPI document: 1.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.voice.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/** */
@JsonPropertyOrder({
  ManageConferenceParticipantRequestDto.JSON_PROPERTY_COMMAND,
  ManageConferenceParticipantRequestDto.JSON_PROPERTY_MOH
})
// @javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ManageConferenceParticipantRequestDto {
  public static final String JSON_PROPERTY_COMMAND = "command";
  private String command;

  public static final String JSON_PROPERTY_MOH = "moh";
  private String moh;

  public ManageConferenceParticipantRequestDto() {}

  public ManageConferenceParticipantRequestDto command(String command) {
    this.command = command;
    return this;
  }

  /**
   * Action to apply on conference participant.
   *
   * @return command
   */
  @JsonProperty(JSON_PROPERTY_COMMAND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getCommand() {
    return command;
  }

  @JsonProperty(JSON_PROPERTY_COMMAND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCommand(String command) {
    this.command = command;
  }

  public ManageConferenceParticipantRequestDto moh(String moh) {
    this.moh = moh;
    return this;
  }

  /**
   * Means \&quot;music on hold\&quot;. If this optional parameter is included, plays music to the
   * first participant in a conference while they&#39;re alone and waiting for other participants to
   * join. If &#x60;moh&#x60; isn&#39;t specified, the user will only hear silence while alone in
   * the conference. This property is only available to use with the &#x60;onhold&#x60; command.
   *
   * @return moh
   */
  @JsonProperty(JSON_PROPERTY_MOH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getMoh() {
    return moh;
  }

  @JsonProperty(JSON_PROPERTY_MOH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMoh(String moh) {
    this.moh = moh;
  }

  /** Return true if this manageConferenceParticipantRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ManageConferenceParticipantRequestDto manageConferenceParticipantRequest =
        (ManageConferenceParticipantRequestDto) o;
    return Objects.equals(this.command, manageConferenceParticipantRequest.command)
        && Objects.equals(this.moh, manageConferenceParticipantRequest.moh);
  }

  @Override
  public int hashCode() {
    return Objects.hash(command, moh);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ManageConferenceParticipantRequestDto {\n");
    sb.append("    command: ").append(toIndentedString(command)).append("\n");
    sb.append("    moh: ").append(toIndentedString(moh)).append("\n");
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
