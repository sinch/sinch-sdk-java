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

package com.sinch.sdk.domains.conversation.models.v1.capability.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.Recipient;

/** QueryCapabilityRequest */
@JsonDeserialize(builder = QueryCapabilityRequestImpl.Builder.class)
public interface QueryCapabilityRequest {

  /**
   * The ID of the app to use for capability lookup.
   *
   * @return appId
   */
  String getAppId();

  /**
   * Get recipient
   *
   * @return recipient
   */
  Recipient getRecipient();

  /**
   * ID for the asynchronous response, will be generated if not set. Currently this field is not
   * used for idempotency.
   *
   * @return requestId
   */
  String getRequestId();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new QueryCapabilityRequestImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param appId see getter
     * @return Current builder
     * @see #getAppId
     */
    Builder setAppId(String appId);

    /**
     * see getter
     *
     * @param recipient see getter
     * @return Current builder
     * @see #getRecipient
     */
    Builder setRecipient(Recipient recipient);

    /**
     * see getter
     *
     * @param requestId see getter
     * @return Current builder
     * @see #getRequestId
     */
    Builder setRequestId(String requestId);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    QueryCapabilityRequest build();
  }
}
