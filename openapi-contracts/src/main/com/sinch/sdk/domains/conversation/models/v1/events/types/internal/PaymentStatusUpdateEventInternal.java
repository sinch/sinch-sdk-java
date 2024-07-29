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

package com.sinch.sdk.domains.conversation.models.v1.events.types.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.events.types.PaymentStatus;
import com.sinch.sdk.domains.conversation.models.v1.events.types.PaymentTransactionStatus;

/**
 * Message specific only for Payments feature to reflect current state of particular Payment Flow.
 */
@JsonDeserialize(builder = PaymentStatusUpdateEventInternalImpl.Builder.class)
public interface PaymentStatusUpdateEventInternal {

  /**
   * This is the partner supplied ID to identify the order for payments
   *
   * @return referenceId
   */
  String getReferenceId();

  /**
   * Get paymentStatus
   *
   * @return paymentStatus
   */
  PaymentStatus getPaymentStatus();

  /**
   * Get paymentTransactionStatus
   *
   * @return paymentTransactionStatus
   */
  PaymentTransactionStatus getPaymentTransactionStatus();

  /**
   * Unique id of the transaction for which one of the transaction payment_transaction_status is
   * present in event.
   *
   * @return paymentTransactionId
   */
  String getPaymentTransactionId();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new PaymentStatusUpdateEventInternalImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param referenceId see getter
     * @return Current builder
     * @see #getReferenceId
     */
    Builder setReferenceId(String referenceId);

    /**
     * see getter
     *
     * @param paymentStatus see getter
     * @return Current builder
     * @see #getPaymentStatus
     */
    Builder setPaymentStatus(PaymentStatus paymentStatus);

    /**
     * see getter
     *
     * @param paymentTransactionStatus see getter
     * @return Current builder
     * @see #getPaymentTransactionStatus
     */
    Builder setPaymentTransactionStatus(PaymentTransactionStatus paymentTransactionStatus);

    /**
     * see getter
     *
     * @param paymentTransactionId see getter
     * @return Current builder
     * @see #getPaymentTransactionId
     */
    Builder setPaymentTransactionId(String paymentTransactionId);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    PaymentStatusUpdateEventInternal build();
  }
}
