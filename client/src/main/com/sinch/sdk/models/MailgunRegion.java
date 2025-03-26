package com.sinch.sdk.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Mailgun Regions
 *
 * @see <a
 *     href="https://documentation.mailgun.com/docs/mailgun/user-manual/get-started/#mailgun-regions">Mailgun
 *     Regions</a>
 * @since 1.6
 */
public class MailgunRegion extends EnumDynamic<String, MailgunRegion> {

  /** United States - default */
  public static final MailgunRegion US = new MailgunRegion("us");

  /** Europe */
  public static final MailgunRegion EUROPE = new MailgunRegion("eu");

  private static final EnumSupportDynamic<String, MailgunRegion> ENUM_SUPPORT =
      new EnumSupportDynamic<>(MailgunRegion.class, MailgunRegion::new, Arrays.asList(US, EUROPE));

  private MailgunRegion(String value) {
    super(value);
  }

  /**
   * Get declared values
   *
   * @return Stream of values
   */
  public static Stream<MailgunRegion> values() {
    return ENUM_SUPPORT.values();
  }

  /**
   * Get value from a string
   *
   * @param value String identifier
   * @return Dynamic enum from value. A new enum is created if value is not yet registered
   */
  public static MailgunRegion from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  /**
   * Value of the enum as String
   *
   * @param value The enum identifier
   * @return String identifier of the enum value
   */
  public static String valueOf(MailgunRegion value) {
    return ENUM_SUPPORT.valueOf(value);
  }
}
