package com.sinch.sdk.domains.sms.models.v1.deliveryreports;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** The simplified status as described in <em>Delivery Report Statuses</em>. */
public class DeliveryStatus extends EnumDynamic<String, DeliveryStatus> {

  /**
   * Intermediate type. Message is queued within REST API system and will be dispatched according to
   * the rate of the account.
   */
  public static final DeliveryStatus QUEUED = new DeliveryStatus("Queued");

  /** Intermediate type. Message has been dispatched and accepted for delivery by the SMSC. */
  public static final DeliveryStatus DISPATCHED = new DeliveryStatus("Dispatched");

  /** Final type. Message was aborted before reaching the SMSC. */
  public static final DeliveryStatus ABORTED = new DeliveryStatus("Aborted");

  /** Final type. Message was cancelled by user before reaching SMSC. */
  public static final DeliveryStatus CANCELLED = new DeliveryStatus("Cancelled");

  /** Final type. Message failed to be delivered. */
  public static final DeliveryStatus FAILED = new DeliveryStatus("Failed");

  /** Final type. Message has been delivered. */
  public static final DeliveryStatus DELIVERED = new DeliveryStatus("Delivered");

  /**
   * Final type. Message expired before delivery to the SMSC. This may happen if the expiry time for
   * the message was very short.
   */
  public static final DeliveryStatus EXPIRED = new DeliveryStatus("Expired");

  /** Final type. Message was rejected by the SMSC. */
  public static final DeliveryStatus REJECTED = new DeliveryStatus("Rejected");

  /** Final type. Message was deleted by the SMSC. */
  public static final DeliveryStatus DELETED = new DeliveryStatus("Deleted");

  /**
   * Final type. Message was delivered to the SMSC but no Delivery Receipt has been received or a
   * Delivery Receipt that couldn't be interpreted was received.
   */
  public static final DeliveryStatus UNKNOWN = new DeliveryStatus("Unknown");

  private static final EnumSupportDynamic<String, DeliveryStatus> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          DeliveryStatus.class,
          DeliveryStatus::new,
          Arrays.asList(
              QUEUED,
              DISPATCHED,
              ABORTED,
              CANCELLED,
              FAILED,
              DELIVERED,
              EXPIRED,
              REJECTED,
              DELETED,
              UNKNOWN));

  private DeliveryStatus(String value) {
    super(value);
  }

  public static Stream<DeliveryStatus> values() {
    return ENUM_SUPPORT.values();
  }

  public static DeliveryStatus from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(DeliveryStatus e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
