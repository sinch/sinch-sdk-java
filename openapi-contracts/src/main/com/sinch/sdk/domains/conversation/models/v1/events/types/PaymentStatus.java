package com.sinch.sdk.domains.conversation.models.v1.events.types;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Status reflecting how payment flow goes */
public class PaymentStatus extends EnumDynamic<String, PaymentStatus> {

  /** The status value was not set. Treat it as null or not present field. */
  public static final PaymentStatus PAYMENT_STATUS_UNKNOWN =
      new PaymentStatus("PAYMENT_STATUS_UNKNOWN");

  /** The partner sent an order_details message but the user didn't start a payment yet. */
  public static final PaymentStatus PAYMENT_STATUS_NEW = new PaymentStatus("PAYMENT_STATUS_NEW");

  /** The user started the payment process and the payment object was created. */
  public static final PaymentStatus PAYMENT_STATUS_PENDING =
      new PaymentStatus("PAYMENT_STATUS_PENDING");

  /** The payment was captured. */
  public static final PaymentStatus PAYMENT_STATUS_CAPTURED =
      new PaymentStatus("PAYMENT_STATUS_CAPTURED");

  /** The payment was canceled by the user and no retry is possible. */
  public static final PaymentStatus PAYMENT_STATUS_CANCELED =
      new PaymentStatus("PAYMENT_STATUS_CANCELED");

  /** The payment attempt failed but the user can retry. */
  public static final PaymentStatus PAYMENT_STATUS_FAILED =
      new PaymentStatus("PAYMENT_STATUS_FAILED");

  private static final EnumSupportDynamic<String, PaymentStatus> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          PaymentStatus.class,
          PaymentStatus::new,
          Arrays.asList(
              PAYMENT_STATUS_UNKNOWN,
              PAYMENT_STATUS_NEW,
              PAYMENT_STATUS_PENDING,
              PAYMENT_STATUS_CAPTURED,
              PAYMENT_STATUS_CANCELED,
              PAYMENT_STATUS_FAILED));

  private PaymentStatus(String value) {
    super(value);
  }

  public static Stream<PaymentStatus> values() {
    return ENUM_SUPPORT.values();
  }

  public static PaymentStatus from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(PaymentStatus e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
