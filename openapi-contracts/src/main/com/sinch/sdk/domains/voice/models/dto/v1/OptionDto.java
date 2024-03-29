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

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/** A configured option that the user can trigger to perform an action. */
@JsonPropertyOrder({OptionDto.JSON_PROPERTY_DTMF, OptionDto.JSON_PROPERTY_ACTION})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class OptionDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_DTMF = "dtmf";
  private String dtmf;
  private boolean dtmfDefined = false;

  public static final String JSON_PROPERTY_ACTION = "action";
  private String action;
  private boolean actionDefined = false;

  public OptionDto() {}

  public OptionDto dtmf(String dtmf) {
    this.dtmf = dtmf;
    this.dtmfDefined = true;
    return this;
  }

  /**
   * A DTMF digit the user can press to trigger the configured action.
   *
   * @return dtmf
   */
  @JsonProperty(JSON_PROPERTY_DTMF)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getDtmf() {
    return dtmf;
  }

  @JsonIgnore
  public boolean getDtmfDefined() {
    return dtmfDefined;
  }

  @JsonProperty(JSON_PROPERTY_DTMF)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDtmf(String dtmf) {
    this.dtmf = dtmf;
    this.dtmfDefined = true;
  }

  public OptionDto action(String action) {
    this.action = action;
    this.actionDefined = true;
    return this;
  }

  /**
   * Determines which action is taken when the DTMF digit is pressed.
   *
   * @return action
   */
  @JsonProperty(JSON_PROPERTY_ACTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getAction() {
    return action;
  }

  @JsonIgnore
  public boolean getActionDefined() {
    return actionDefined;
  }

  @JsonProperty(JSON_PROPERTY_ACTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAction(String action) {
    this.action = action;
    this.actionDefined = true;
  }

  /** Return true if this option object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OptionDto option = (OptionDto) o;
    return Objects.equals(this.dtmf, option.dtmf) && Objects.equals(this.action, option.action);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dtmf, action);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OptionDto {\n");
    sb.append("    dtmf: ").append(toIndentedString(dtmf)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
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
