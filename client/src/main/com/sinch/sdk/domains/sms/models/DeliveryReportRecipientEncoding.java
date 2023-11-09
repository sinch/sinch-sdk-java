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
public class DeliveryReportRecipientEncoding
    extends EnumDynamic<String, DeliveryReportRecipientEncoding> {

  public static final DeliveryReportRecipientEncoding GSM =
      new DeliveryReportRecipientEncoding("GSM");
  public static final DeliveryReportRecipientEncoding UNICODE =
      new DeliveryReportRecipientEncoding("UNICODE");

  private static final EnumSupportDynamic<String, DeliveryReportRecipientEncoding> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          DeliveryReportRecipientEncoding.class,
          DeliveryReportRecipientEncoding::new,
          Arrays.asList(GSM, UNICODE));

  private DeliveryReportRecipientEncoding(String value) {
    super(value);
  }

  public static Stream<DeliveryReportRecipientEncoding> values() {
    return ENUM_SUPPORT.values();
  }

  public static DeliveryReportRecipientEncoding from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(DeliveryReportRecipientEncoding e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
