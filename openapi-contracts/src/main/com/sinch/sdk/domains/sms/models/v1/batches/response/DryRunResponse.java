/*
 * API Overview | Sinch
 *
 * OpenAPI document version: v1
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.sms.models.v1.batches.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

/** DryRunResponse */
@JsonDeserialize(builder = DryRunResponseImpl.Builder.class)
public interface DryRunResponse {

  /**
   * The number of recipients in the batch
   *
   * @return numberOfRecipients
   */
  Integer getNumberOfRecipients();

  /**
   * The total number of SMS message parts to be sent in the batch
   *
   * @return numberOfMessages
   */
  Integer getNumberOfMessages();

  /**
   * The recipient, the number of message parts to this recipient, the body of the message, and the
   * encoding type of each message
   *
   * @return perRecipient
   */
  List<DryRunPerRecipientDetails> getPerRecipient();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new DryRunResponseImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param numberOfRecipients see getter
     * @return Current builder
     * @see #getNumberOfRecipients
     */
    Builder setNumberOfRecipients(Integer numberOfRecipients);

    /**
     * see getter
     *
     * @param numberOfMessages see getter
     * @return Current builder
     * @see #getNumberOfMessages
     */
    Builder setNumberOfMessages(Integer numberOfMessages);

    /**
     * see getter
     *
     * @param perRecipient see getter
     * @return Current builder
     * @see #getPerRecipient
     */
    Builder setPerRecipient(List<DryRunPerRecipientDetails> perRecipient);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    DryRunResponse build();
  }
}