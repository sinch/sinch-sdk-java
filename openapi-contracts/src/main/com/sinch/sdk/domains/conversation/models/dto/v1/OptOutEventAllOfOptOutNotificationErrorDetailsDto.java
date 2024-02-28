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

/** This field is populated if the opt-out failed. */
@JsonPropertyOrder({OptOutEventAllOfOptOutNotificationErrorDetailsDto.JSON_PROPERTY_DESCRIPTION})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class OptOutEventAllOfOptOutNotificationErrorDetailsDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;
  private boolean descriptionDefined = false;

  public OptOutEventAllOfOptOutNotificationErrorDetailsDto() {}

  public OptOutEventAllOfOptOutNotificationErrorDetailsDto description(String description) {
    this.description = description;
    this.descriptionDefined = true;
    return this;
  }

  /**
   * Human-readable error description.
   *
   * @return description
   */
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getDescription() {
    return description;
  }

  @JsonIgnore
  public boolean getDescriptionDefined() {
    return descriptionDefined;
  }

  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescription(String description) {
    this.description = description;
    this.descriptionDefined = true;
  }

  /**
   * Return true if this OptOutEvent_allOf_opt_out_notification_error_details object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OptOutEventAllOfOptOutNotificationErrorDetailsDto
        optOutEventAllOfOptOutNotificationErrorDetails =
            (OptOutEventAllOfOptOutNotificationErrorDetailsDto) o;
    return Objects.equals(
        this.description, optOutEventAllOfOptOutNotificationErrorDetails.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OptOutEventAllOfOptOutNotificationErrorDetailsDto {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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