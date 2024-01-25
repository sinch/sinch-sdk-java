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

/** A message containing a list of options to choose from */
@JsonPropertyOrder({ListMessageDto.JSON_PROPERTY_LIST_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ListMessageDto {
  public static final String JSON_PROPERTY_LIST_MESSAGE = "list_message";
  private ListMessageListMessageDto listMessage;
  private boolean listMessageDefined = false;

  public ListMessageDto() {}

  public ListMessageDto listMessage(ListMessageListMessageDto listMessage) {
    this.listMessage = listMessage;
    this.listMessageDefined = true;
    return this;
  }

  /**
   * Get listMessage
   *
   * @return listMessage
   */
  @JsonProperty(JSON_PROPERTY_LIST_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public ListMessageListMessageDto getListMessage() {
    return listMessage;
  }

  @JsonIgnore
  public boolean getListMessageDefined() {
    return listMessageDefined;
  }

  @JsonProperty(JSON_PROPERTY_LIST_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setListMessage(ListMessageListMessageDto listMessage) {
    this.listMessage = listMessage;
    this.listMessageDefined = true;
  }

  /** Return true if this ListMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListMessageDto listMessage = (ListMessageDto) o;
    return Objects.equals(this.listMessage, listMessage.listMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(listMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListMessageDto {\n");
    sb.append("    listMessage: ").append(toIndentedString(listMessage)).append("\n");
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
