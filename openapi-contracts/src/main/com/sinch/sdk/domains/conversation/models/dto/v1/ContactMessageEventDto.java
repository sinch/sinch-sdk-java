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

/**
 * The content of the event when contact_event is not populated. Note that this object is currently
 * only available to select customers for beta testing. Mutually exclusive with contact_event.
 */
@JsonPropertyOrder({ContactMessageEventDto.JSON_PROPERTY_PAYMENT_STATUS_UPDATE_EVENT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ContactMessageEventDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_PAYMENT_STATUS_UPDATE_EVENT =
      "payment_status_update_event";
  private ContactMessageEventPaymentStatusUpdateEventDto paymentStatusUpdateEvent;
  private boolean paymentStatusUpdateEventDefined = false;

  public ContactMessageEventDto() {}

  public ContactMessageEventDto paymentStatusUpdateEvent(
      ContactMessageEventPaymentStatusUpdateEventDto paymentStatusUpdateEvent) {
    this.paymentStatusUpdateEvent = paymentStatusUpdateEvent;
    this.paymentStatusUpdateEventDefined = true;
    return this;
  }

  /**
   * Get paymentStatusUpdateEvent
   *
   * @return paymentStatusUpdateEvent
   */
  @JsonProperty(JSON_PROPERTY_PAYMENT_STATUS_UPDATE_EVENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public ContactMessageEventPaymentStatusUpdateEventDto getPaymentStatusUpdateEvent() {
    return paymentStatusUpdateEvent;
  }

  @JsonIgnore
  public boolean getPaymentStatusUpdateEventDefined() {
    return paymentStatusUpdateEventDefined;
  }

  @JsonProperty(JSON_PROPERTY_PAYMENT_STATUS_UPDATE_EVENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPaymentStatusUpdateEvent(
      ContactMessageEventPaymentStatusUpdateEventDto paymentStatusUpdateEvent) {
    this.paymentStatusUpdateEvent = paymentStatusUpdateEvent;
    this.paymentStatusUpdateEventDefined = true;
  }

  /** Return true if this ContactMessageEvent object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactMessageEventDto contactMessageEvent = (ContactMessageEventDto) o;
    return Objects.equals(
        this.paymentStatusUpdateEvent, contactMessageEvent.paymentStatusUpdateEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentStatusUpdateEvent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactMessageEventDto {\n");
    sb.append("    paymentStatusUpdateEvent: ")
        .append(toIndentedString(paymentStatusUpdateEvent))
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
