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

/** Represents an agent that is involved in a conversation. */
@JsonPropertyOrder({
  AgentDto.JSON_PROPERTY_DISPLAY_NAME,
  AgentDto.JSON_PROPERTY_TYPE,
  AgentDto.JSON_PROPERTY_PICTURE_URL
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AgentDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_DISPLAY_NAME = "display_name";
  private String displayName;
  private boolean displayNameDefined = false;

  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;
  private boolean typeDefined = false;

  public static final String JSON_PROPERTY_PICTURE_URL = "picture_url";
  private String pictureUrl;
  private boolean pictureUrlDefined = false;

  public AgentDto() {}

  public AgentDto displayName(String displayName) {
    this.displayName = displayName;
    this.displayNameDefined = true;
    return this;
  }

  /**
   * Agent&#39;s display name
   *
   * @return displayName
   */
  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getDisplayName() {
    return displayName;
  }

  @JsonIgnore
  public boolean getDisplayNameDefined() {
    return displayNameDefined;
  }

  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
    this.displayNameDefined = true;
  }

  public AgentDto type(String type) {
    this.type = type;
    this.typeDefined = true;
    return this;
  }

  /**
   * Agent&#39;s classification. It can be UNKNOWN_AGENT_TYPE, HUMAN or BOT.
   *
   * @return type
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getType() {
    return type;
  }

  @JsonIgnore
  public boolean getTypeDefined() {
    return typeDefined;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(String type) {
    this.type = type;
    this.typeDefined = true;
  }

  public AgentDto pictureUrl(String pictureUrl) {
    this.pictureUrl = pictureUrl;
    this.pictureUrlDefined = true;
    return this;
  }

  /**
   * The Agent&#39;s picture url.
   *
   * @return pictureUrl
   */
  @JsonProperty(JSON_PROPERTY_PICTURE_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getPictureUrl() {
    return pictureUrl;
  }

  @JsonIgnore
  public boolean getPictureUrlDefined() {
    return pictureUrlDefined;
  }

  @JsonProperty(JSON_PROPERTY_PICTURE_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPictureUrl(String pictureUrl) {
    this.pictureUrl = pictureUrl;
    this.pictureUrlDefined = true;
  }

  /** Return true if this Agent object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AgentDto agent = (AgentDto) o;
    return Objects.equals(this.displayName, agent.displayName)
        && Objects.equals(this.type, agent.type)
        && Objects.equals(this.pictureUrl, agent.pictureUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(displayName, type, pictureUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AgentDto {\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    pictureUrl: ").append(toIndentedString(pictureUrl)).append("\n");
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