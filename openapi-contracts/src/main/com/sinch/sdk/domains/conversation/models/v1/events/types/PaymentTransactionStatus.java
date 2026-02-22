package com.sinch.sdk.domains.conversation.models.v1.events.types;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Group of statuses of the user-initiated transaction changes. */
public class PaymentTransactionStatus extends EnumDynamic<String, PaymentTransactionStatus> {

  /** The transaction status value was not set. Treat it as null or not present field. */
  public static final PaymentTransactionStatus PAYMENT_STATUS_TRANSACTION_UNKNOWN =
      new PaymentTransactionStatus("PAYMENT_STATUS_TRANSACTION_UNKNOWN");

  /** The transaction has started. */
  public static final PaymentTransactionStatus PAYMENT_STATUS_TRANSACTION_PENDING =
      new PaymentTransactionStatus("PAYMENT_STATUS_TRANSACTION_PENDING");

  /** Transaction failed. */
  public static final PaymentTransactionStatus PAYMENT_STATUS_TRANSACTION_FAILED =
      new PaymentTransactionStatus("PAYMENT_STATUS_TRANSACTION_FAILED");

  /** Transaction completed successfully. */
  public static final PaymentTransactionStatus PAYMENT_STATUS_TRANSACTION_SUCCESS =
      new PaymentTransactionStatus("PAYMENT_STATUS_TRANSACTION_SUCCESS");

  /** Transaction got cancelled. */
  public static final PaymentTransactionStatus PAYMENT_STATUS_TRANSACTION_CANCELED =
      new PaymentTransactionStatus("PAYMENT_STATUS_TRANSACTION_CANCELED");

  private static final EnumSupportDynamic<String, PaymentTransactionStatus> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          PaymentTransactionStatus.class,
          PaymentTransactionStatus::new,
          Arrays.asList(
              PAYMENT_STATUS_TRANSACTION_UNKNOWN,
              PAYMENT_STATUS_TRANSACTION_PENDING,
              PAYMENT_STATUS_TRANSACTION_FAILED,
              PAYMENT_STATUS_TRANSACTION_SUCCESS,
              PAYMENT_STATUS_TRANSACTION_CANCELED));

  private PaymentTransactionStatus(String value) {
    super(value);
  }

  public static Stream<PaymentTransactionStatus> values() {
    return ENUM_SUPPORT.values();
  }

  public static PaymentTransactionStatus from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(PaymentTransactionStatus e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
