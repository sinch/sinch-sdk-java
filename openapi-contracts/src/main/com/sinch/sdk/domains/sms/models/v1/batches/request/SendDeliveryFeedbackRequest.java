/*
 * API Overview | Sinch
 *
 * OpenAPI document version: v1
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.sms.models.v1.batches.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

/** SendDeliveryFeedbackRequest */
@JsonDeserialize(builder = SendDeliveryFeedbackRequestImpl.Builder.class)
public interface SendDeliveryFeedbackRequest {

  /**
   * A list of phone numbers (MSISDNs) that have successfully received the message. The key is
   * required, however, the value can be an empty array (<code>[]</code>) for <em>a batch</em>. If
   * the feedback was enabled for <em>a group</em>, at least one phone number is required.
   *
   * @return recipients
   */
  List<String> getRecipients();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new SendDeliveryFeedbackRequestImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param recipients see getter
     * @return Current builder
     * @see #getRecipients
     */
    Builder setRecipients(List<String> recipients);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    SendDeliveryFeedbackRequest build();
  }
}
