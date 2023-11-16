package com.sinch.sdk.domains.sms.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * The status field describes which state a particular message is in. Note that statuses of type
 * Intermediate will only be reported if you request a status <code>per_recipient</code> or <code>
 * per_recipient_final</code> ( @see <a
 * href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/operation/GetDeliveryReportByBatchId">Retrieve
 * a recipient delivery report</a>).
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/section/Delivery-report-statuses">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/section/Delivery-report-statuses</a>
 * @since 1.0
 */
public class DeliveryReportStatus extends EnumDynamic<String, DeliveryReportStatus> {

  /**
   * Message is queued within REST API system and will be dispatched according to the rate of the
   * account.
   */
  public static final DeliveryReportStatus QUEUED = new DeliveryReportStatus("Queued");
  /** Message has been dispatched and accepted for delivery by the SMSC. */
  public static final DeliveryReportStatus DISPATCHED = new DeliveryReportStatus("Dispatched");
  /** Message was aborted before reaching the SMSC. */
  public static final DeliveryReportStatus ABORTED = new DeliveryReportStatus("Aborted");
  /** Message was cancelled by user before reaching SMSC. */
  public static final DeliveryReportStatus CANCELLED = new DeliveryReportStatus("Cancelled");
  /** Message was rejected by the SMSC. */
  public static final DeliveryReportStatus REJECTED = new DeliveryReportStatus("Rejected");
  /**
   * Message has been deleted. Message was deleted by a remote SMSC. This may happen if the
   * destination is an invalid MSISDN or opted out subscriber.
   */
  public static final DeliveryReportStatus DELETED = new DeliveryReportStatus("Deleted");
  /** Message has been delivered. */
  public static final DeliveryReportStatus DELIVERED = new DeliveryReportStatus("Delivered");
  /** Message failed to be delivered. */
  public static final DeliveryReportStatus FAILED = new DeliveryReportStatus("Failed");
  /**
   * Message expired before delivery to the SMSC. This may happen if the expiry time for the message
   * was very short.
   */
  public static final DeliveryReportStatus EXPIRED = new DeliveryReportStatus("Expired");
  /**
   * Message was delivered to the SMSC but no Delivery Receipt has been received or a Delivery
   * Receipt that couldn't be interpreted was received.
   */
  public static final DeliveryReportStatus UNKNOWN = new DeliveryReportStatus("Unknown");

  private static final EnumSupportDynamic<String, DeliveryReportStatus> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          DeliveryReportStatus.class,
          DeliveryReportStatus::new,
          Arrays.asList(
              QUEUED,
              DISPATCHED,
              ABORTED,
              CANCELLED,
              REJECTED,
              DELETED,
              DELIVERED,
              FAILED,
              EXPIRED,
              UNKNOWN));

  private DeliveryReportStatus(String value) {
    super(value);
  }

  public static Stream<DeliveryReportStatus> values() {
    return ENUM_SUPPORT.values();
  }

  public static DeliveryReportStatus from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(DeliveryReportStatus e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
