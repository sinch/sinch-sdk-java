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

package com.sinch.sdk.domains.conversation.models.v1.events.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.events.ContactEvent;

/** Contact Event Type */
@JsonDeserialize(builder = ContactEventFieldInternalImpl.Builder.class)
public interface ContactEventFieldInternal {

  /**
   * Get contactEvent
   *
   * @return contactEvent
   */
  ContactEvent getContactEvent();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ContactEventFieldInternalImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param contactEvent see getter
     * @return Current builder
     * @see #getContactEvent
     */
    Builder setContactEvent(ContactEvent contactEvent);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ContactEventFieldInternal build();
  }
}