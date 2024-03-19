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

package com.sinch.sdk.domains.conversation.models.v1.contact.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.request.IdentifiedBy;

/**
 * The recipient to check profile information. Requires either &#x60;contact_id&#x60; or
 * &#x60;identified_by&#x60;.
 */
@JsonDeserialize(builder = GetChannelProfileRequestRecipientImpl.Builder.class)
public interface GetChannelProfileRequestRecipient {

  /**
   * The ID of the contact.
   *
   * @return contactId
   */
  String getContactId();

  /**
   * Get identifiedBy
   *
   * @return identifiedBy
   */
  IdentifiedBy getIdentifiedBy();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new GetChannelProfileRequestRecipientImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param contactId see getter
     * @return Current builder
     * @see #getContactId
     */
    Builder setContactId(String contactId);

    /**
     * see getter
     *
     * @param identifiedBy see getter
     * @return Current builder
     * @see #getIdentifiedBy
     */
    Builder setIdentifiedBy(IdentifiedBy identifiedBy);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    GetChannelProfileRequestRecipient build();
  }
}
