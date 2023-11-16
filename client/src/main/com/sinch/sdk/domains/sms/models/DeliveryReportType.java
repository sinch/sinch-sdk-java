package com.sinch.sdk.domains.sms.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * DeliveryReportType authorized values
 *
 * @since 1.0
 */
public class DeliveryReportType extends EnumDynamic<String, DeliveryReportType> {

  /** No delivery report callback will be sent. */
  public static final DeliveryReportType NONE = new DeliveryReportType("none");
  /** A single delivery report callback will be sent. */
  public static final DeliveryReportType SUMMARY = new DeliveryReportType("summary");
  /**
   * A single delivery report callback will be sent which includes a list of recipients per delivery
   * status.
   */
  public static final DeliveryReportType FULL = new DeliveryReportType("full");
  /**
   * A delivery report callback will be sent for each status change of a message. This could result
   * in a lot of callbacks and should be used with caution for larger batches. These delivery
   * reports also include a timestamp of when the Delivery Report originated from the SMSC.
   */
  public static final DeliveryReportType PER_RECIPIENT = new DeliveryReportType("per_recipient");
  /**
   * A delivery report callback representing the final status of a message will be sent for each
   * recipient. This will send only one callback per recipient, compared to the multiple callbacks
   * sent when using per_recipient. The delivery report will also include a timestamp of when it
   * originated from the SMSC.
   */
  public static final DeliveryReportType PER_RECIPIENT_FINAl =
      new DeliveryReportType("per_recipient_final");

  private static final EnumSupportDynamic<String, DeliveryReportType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          DeliveryReportType.class,
          DeliveryReportType::new,
          Arrays.asList(NONE, SUMMARY, FULL, PER_RECIPIENT, PER_RECIPIENT_FINAl));

  private DeliveryReportType(String value) {
    super(value);
  }

  public static Stream<DeliveryReportType> values() {
    return ENUM_SUPPORT.values();
  }

  public static DeliveryReportType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(DeliveryReportType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
