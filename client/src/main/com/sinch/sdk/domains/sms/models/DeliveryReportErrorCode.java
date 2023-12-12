package com.sinch.sdk.domains.sms.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Applied encoding for message.
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/operation/deliveryReport!path=1/encoding&amp;t=request">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/operation/deliveryReport!path=1/encoding&amp;t=request</a>
 * @since 1.0
 */
public class DeliveryReportErrorCode extends EnumDynamic<Integer, DeliveryReportErrorCode> {

  /**
   * Message is queued within REST API system and will be dispatched according to the rate of the
   * account.
   */
  public static final DeliveryReportErrorCode QUEUED = new DeliveryReportErrorCode(400);

  /** Message has been dispatched to SMSC. */
  public static final DeliveryReportErrorCode DISPATCHED = new DeliveryReportErrorCode(401);

  /** SMSC rejected message. Retrying is likely to cause the same error. */
  public static final DeliveryReportErrorCode MESSAGE_UNROUTABLE = new DeliveryReportErrorCode(402);

  /** An unexpected error caused the message to fail. */
  public static final DeliveryReportErrorCode INTERNAL_ERROR = new DeliveryReportErrorCode(403);

  /** Message failed because of temporary delivery failure. Message can be retried. */
  public static final DeliveryReportErrorCode TEMPORARY_DELIVERY_FAILURE =
      new DeliveryReportErrorCode(404);

  /**
   * One or more parameters in the message body has no mapping for this recipient. See Message
   * Parameterization
   */
  public static final DeliveryReportErrorCode UNMATCHED_PARAMETER =
      new DeliveryReportErrorCode(405);

  /**
   * Message was expired before reaching SMSC. This may happen if the expiry time for the message
   * was very short.
   */
  public static final DeliveryReportErrorCode INTERNAL_EXPIRY = new DeliveryReportErrorCode(406);

  /** Message was cancelled by user before reaching SMSC. */
  public static final DeliveryReportErrorCode CANCELLED = new DeliveryReportErrorCode(407);

  /** SMSC rejected the message. Retrying is likely to cause the same error. */
  public static final DeliveryReportErrorCode INTERNAL_REJECT = new DeliveryReportErrorCode(408);

  /**
   * No default originator exists/configured for this recipient when sending message without
   * originator.
   */
  public static final DeliveryReportErrorCode UNMATCHED_DEFAULT_ORIGINATOR =
      new DeliveryReportErrorCode(410);

  /**
   * Message failed as the number of message parts exceeds the defined max number of message parts.
   */
  public static final DeliveryReportErrorCode EXCEEDED_PARTS_LIMIT =
      new DeliveryReportErrorCode(411);

  /** SMSC rejected the message. The account hasn't been provisioned for this region. */
  public static final DeliveryReportErrorCode UNPROVISIONED_REGION =
      new DeliveryReportErrorCode(412);

  /** The account is blocked. Reach out to support for help. Potentially out of credits. */
  public static final DeliveryReportErrorCode BLOCKED = new DeliveryReportErrorCode(413);

  /**
   * MMS only, the request failed due to a bad media URL. It is possible that the URL was
   * unreachable, or sent a bad response.
   */
  public static final DeliveryReportErrorCode BAD_MEDIA = new DeliveryReportErrorCode(414);

  /** MMS only, message reached MMSC but was rejected by MMS gateway or mobile network. */
  public static final DeliveryReportErrorCode DELIVERY_REPORT_REJECTED =
      new DeliveryReportErrorCode(415);

  /** MMS only, message reached MMSC but it is not supported. */
  public static final DeliveryReportErrorCode DELIVERY_REPORT_NOT_SUPPORTED =
      new DeliveryReportErrorCode(416);

  /**
   * MMS only, message reached MMSC but the destination network or the mobile subscriber cannot be
   * reached.
   */
  public static final DeliveryReportErrorCode DELIVERY_REPORT_UNREACHABLE =
      new DeliveryReportErrorCode(417);

  /**
   * MMS only, message reached MMSC but the handset of the mobile subscriber does not recognize the
   * message content.
   */
  public static final DeliveryReportErrorCode DELIVERY_REPORT_UNRECOGNIZED =
      new DeliveryReportErrorCode(418);

  private static final EnumSupportDynamic<Integer, DeliveryReportErrorCode> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          DeliveryReportErrorCode.class,
          DeliveryReportErrorCode::new,
          Arrays.asList(
              QUEUED,
              DISPATCHED,
              MESSAGE_UNROUTABLE,
              INTERNAL_ERROR,
              TEMPORARY_DELIVERY_FAILURE,
              UNMATCHED_PARAMETER,
              INTERNAL_EXPIRY,
              CANCELLED,
              INTERNAL_REJECT,
              UNMATCHED_DEFAULT_ORIGINATOR,
              EXCEEDED_PARTS_LIMIT,
              UNPROVISIONED_REGION,
              BLOCKED,
              BAD_MEDIA,
              DELIVERY_REPORT_REJECTED,
              DELIVERY_REPORT_NOT_SUPPORTED,
              DELIVERY_REPORT_UNREACHABLE,
              DELIVERY_REPORT_UNRECOGNIZED));

  private DeliveryReportErrorCode(Integer value) {
    super(value);
  }

  public static Stream<DeliveryReportErrorCode> values() {
    return ENUM_SUPPORT.values();
  }

  public static DeliveryReportErrorCode from(Integer value) {
    return ENUM_SUPPORT.from(value);
  }

  public static Integer valueOf(DeliveryReportErrorCode e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
