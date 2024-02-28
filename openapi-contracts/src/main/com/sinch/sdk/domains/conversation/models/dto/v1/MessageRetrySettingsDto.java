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

/** Message retry time configuration. */
@JsonPropertyOrder({MessageRetrySettingsDto.JSON_PROPERTY_RETRY_DURATION})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MessageRetrySettingsDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_RETRY_DURATION = "retry_duration";
  private Integer retryDuration;
  private boolean retryDurationDefined = false;

  public MessageRetrySettingsDto() {}

  public MessageRetrySettingsDto retryDuration(Integer retryDuration) {
    this.retryDuration = retryDuration;
    this.retryDurationDefined = true;
    return this;
  }

  /**
   * The maximum duration, in seconds, for which to retry sending a message in case of a temporary
   * processing failure. Time is counted after the first message processing failure. At least one
   * retry is guaranteed. Subsequent retry times are randomized with exponential backoff. If the
   * next retry timestamp exceeds the configured time, one last retry will be performed on the
   * cut-off time. If the message has a configured fallback channel, a switch_on_channel will be
   * triggered. The valid values for this field are [30 - 3600]. Default value is 3600 (seconds - 1
   * hour).
   *
   * @return retryDuration
   */
  @JsonProperty(JSON_PROPERTY_RETRY_DURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getRetryDuration() {
    return retryDuration;
  }

  @JsonIgnore
  public boolean getRetryDurationDefined() {
    return retryDurationDefined;
  }

  @JsonProperty(JSON_PROPERTY_RETRY_DURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRetryDuration(Integer retryDuration) {
    this.retryDuration = retryDuration;
    this.retryDurationDefined = true;
  }

  /** Return true if this MessageRetrySettings object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MessageRetrySettingsDto messageRetrySettings = (MessageRetrySettingsDto) o;
    return Objects.equals(this.retryDuration, messageRetrySettings.retryDuration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(retryDuration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MessageRetrySettingsDto {\n");
    sb.append("    retryDuration: ").append(toIndentedString(retryDuration)).append("\n");
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