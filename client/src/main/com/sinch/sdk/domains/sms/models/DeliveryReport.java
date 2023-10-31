package com.sinch.sdk.domains.sms.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * DeliveryReport authorized values
 *
 * @since 1.0
 */
public class DeliveryReport extends EnumDynamic<DeliveryReport> {

  /** No delivery report callback will be sent. */
  public static final DeliveryReport NONE = new DeliveryReport("none");
  /** A single delivery report callback will be sent. */
  public static final DeliveryReport SUMMARY = new DeliveryReport("summary");
  /**
   * A single delivery report callback will be sent which includes a list of recipients per delivery
   * status.
   */
  public static final DeliveryReport FULL = new DeliveryReport("full");
  /**
   * A delivery report callback will be sent for each status change of a message. This could result
   * in a lot of callbacks and should be used with caution for larger batches. These delivery
   * reports also include a timestamp of when the Delivery Report originated from the SMSC.
   */
  public static final DeliveryReport PER_RECIPIENT = new DeliveryReport("per_recipient");
  /**
   * A delivery report callback representing the final status of a message will be sent for each
   * recipient. This will send only one callback per recipient, compared to the multiple callbacks
   * sent when using per_recipient. The delivery report will also include a timestamp of when it
   * originated from the SMSC.
   */
  public static final DeliveryReport PER_RECIPIENT_FINAl =
      new DeliveryReport("per_recipient_final");

  private static final EnumSupportDynamic<DeliveryReport> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          DeliveryReport.class,
          DeliveryReport::new,
          Arrays.asList(NONE, SUMMARY, FULL, PER_RECIPIENT, PER_RECIPIENT_FINAl));

  private DeliveryReport(String value) {
    super(value);
  }

  public static Stream<DeliveryReport> values() {
    return ENUM_SUPPORT.values();
  }

  public static DeliveryReport from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(DeliveryReport e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
