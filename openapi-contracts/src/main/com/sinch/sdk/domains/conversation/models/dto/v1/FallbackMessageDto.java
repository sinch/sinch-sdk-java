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

/** Fallback message. Used when original contact message can not be handled. */
@JsonPropertyOrder({FallbackMessageDto.JSON_PROPERTY_FALLBACK_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class FallbackMessageDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_FALLBACK_MESSAGE = "fallback_message";
  private FallbackMessageFallbackMessageDto fallbackMessage;
  private boolean fallbackMessageDefined = false;

  public FallbackMessageDto() {}

  public FallbackMessageDto fallbackMessage(FallbackMessageFallbackMessageDto fallbackMessage) {
    this.fallbackMessage = fallbackMessage;
    this.fallbackMessageDefined = true;
    return this;
  }

  /**
   * Get fallbackMessage
   *
   * @return fallbackMessage
   */
  @JsonProperty(JSON_PROPERTY_FALLBACK_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public FallbackMessageFallbackMessageDto getFallbackMessage() {
    return fallbackMessage;
  }

  @JsonIgnore
  public boolean getFallbackMessageDefined() {
    return fallbackMessageDefined;
  }

  @JsonProperty(JSON_PROPERTY_FALLBACK_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFallbackMessage(FallbackMessageFallbackMessageDto fallbackMessage) {
    this.fallbackMessage = fallbackMessage;
    this.fallbackMessageDefined = true;
  }

  /** Return true if this FallbackMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FallbackMessageDto fallbackMessage = (FallbackMessageDto) o;
    return Objects.equals(this.fallbackMessage, fallbackMessage.fallbackMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fallbackMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FallbackMessageDto {\n");
    sb.append("    fallbackMessage: ").append(toIndentedString(fallbackMessage)).append("\n");
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