package com.sinch.sdk.domains.sms.models.v1.deliveryreports;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * The delivery report status code provides a more detailed view of what happened with a message.
 * The REST API error codes are a combination of <a
 * href="/docs/sms/smpp/error-codes/#status-reports-error-codes">SMPP error codes</a>, <a
 * href="/docs/mms/7-service/mms-status-codes/">MMS error codes</a> and custom codes.
 */
public class DeliveryReceiptStatusCode extends EnumDynamic<Integer, DeliveryReceiptStatusCode> {

  /**
   * Queued. Message is queued within REST API system and will be dispatched according to the rate
   * of the account.
   */
  public static final DeliveryReceiptStatusCode QUEUED = new DeliveryReceiptStatusCode(400);

  /** Dispatched. Message has been dispatched to SMSC. */
  public static final DeliveryReceiptStatusCode DISPATCHED = new DeliveryReceiptStatusCode(401);

  /** Message unroutable. SMSC rejected message. Retrying is likely to cause the same error. */
  public static final DeliveryReceiptStatusCode MESSAGE_UNROUTABLE =
      new DeliveryReceiptStatusCode(402);

  /** Internal error. An unexpected error caused the message to fail. */
  public static final DeliveryReceiptStatusCode INTERNAL_ERROR = new DeliveryReceiptStatusCode(403);

  /**
   * Temporary delivery. failure` Message failed because of temporary delivery failure. Message can
   * be retried.
   */
  public static final DeliveryReceiptStatusCode TEMPORARY_DELIVERY_FAILURE =
      new DeliveryReceiptStatusCode(404);

  /**
   * Unmatched Parameter. One or more parameters in the message body has no mapping for this
   * recipient. See <a href="../../../../resources/message-info/message-parameterization/">Message
   * Parameterization</a>
   */
  public static final DeliveryReceiptStatusCode UNMATCHED_PARAMETER =
      new DeliveryReceiptStatusCode(405);

  /**
   * Internal Expiry. Message was expired before reaching SMSC. This may happen if the expiry time
   * for the message was very short.
   */
  public static final DeliveryReceiptStatusCode INTERNAL_EXPIRY =
      new DeliveryReceiptStatusCode(406);

  /** Cancelled. Message was cancelled by user before reaching SMSC. */
  public static final DeliveryReceiptStatusCode CANCELLED = new DeliveryReceiptStatusCode(407);

  /** Internal Reject. SMSC rejected the message. Retrying is likely to cause the same error. */
  public static final DeliveryReceiptStatusCode INTERNAL_REJECT =
      new DeliveryReceiptStatusCode(408);

  /**
   * Unmatched default originator. No default originator exists/configured for this recipient when
   * sending message without originator.
   */
  public static final DeliveryReceiptStatusCode UNMATCHED_DEFAULT_ORIGINATOR =
      new DeliveryReceiptStatusCode(410);

  /**
   * Exceeded parts limit. Message failed as the number of message parts exceeds the defined max
   * number of message parts.
   */
  public static final DeliveryReceiptStatusCode EXCEEDED_PARTS_LIMIT =
      new DeliveryReceiptStatusCode(411);

  /**
   * Unprovisioned region. SMSC rejected the message. The account hasn't been provisioned for this
   * region.
   */
  public static final DeliveryReceiptStatusCode UNPROVISIONED_REGION =
      new DeliveryReceiptStatusCode(412);

  /** Blocked. The account is blocked. Reach out to support for help. Potentially out of credits. */
  public static final DeliveryReceiptStatusCode BLOCKED = new DeliveryReceiptStatusCode(413);

  /**
   * Bad Media. MMS only, the request failed due to a bad media URL. It is possible that the URL was
   * unreachable, or sent a bad response.
   */
  public static final DeliveryReceiptStatusCode BAD_MEDIA = new DeliveryReceiptStatusCode(414);

  /**
   * Delivery report Rejected. MMS only, message reached MMSC but was rejected by MMS gateway or
   * mobile network.
   */
  public static final DeliveryReceiptStatusCode DELIVERY_REPORT_REJECTED =
      new DeliveryReceiptStatusCode(415);

  /** Delivery report Not Supported. MMS only, message reached MMSC but it is not supported. */
  public static final DeliveryReceiptStatusCode DELIVERY_REPORT_NOT_SUPPORTED =
      new DeliveryReceiptStatusCode(416);

  /**
   * Delivery report Unreachable. MMS only, message reached MMSC but the destination network or the
   * mobile subscriber cannot be reached.
   */
  public static final DeliveryReceiptStatusCode DELIVERY_REPORT_UNREACHABLE =
      new DeliveryReceiptStatusCode(417);

  /**
   * Delivery report Unrecognized. MMS only, message reached MMSC but the handset of the mobile
   * subscriber does not recognize the message content.
   */
  public static final DeliveryReceiptStatusCode DELIVERY_REPORT_UNRECOGNIZED =
      new DeliveryReceiptStatusCode(418);

  private static final EnumSupportDynamic<Integer, DeliveryReceiptStatusCode> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          DeliveryReceiptStatusCode.class,
          DeliveryReceiptStatusCode::new,
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

  private DeliveryReceiptStatusCode(Integer value) {
    super(value);
  }

  public static Stream<DeliveryReceiptStatusCode> values() {
    return ENUM_SUPPORT.values();
  }

  public static DeliveryReceiptStatusCode from(Integer value) {
    return ENUM_SUPPORT.from(value);
  }

  public static Integer valueOf(DeliveryReceiptStatusCode e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
