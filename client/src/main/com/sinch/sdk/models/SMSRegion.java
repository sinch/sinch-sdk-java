package com.sinch.sdk.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * SMS Region
 *
 * <p>Available SMS region Regions are tied to a specific SMS API URL
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/sms/api-reference/#base-url/">https://developers.sinch.com/docs/sms/api-reference/#base-url/</a>
 * @since 1.0
 */
public class SMSRegion extends EnumDynamic<String, SMSRegion> {

  /** United States */
  public static final SMSRegion US = new SMSRegion("us");

  /** European Union */
  public static final SMSRegion EU = new SMSRegion("eu");

  /** Australia */
  public static final SMSRegion AU = new SMSRegion("au");

  /** Brazil */
  public static final SMSRegion BR = new SMSRegion("br");

  /** Canada */
  public static final SMSRegion CA = new SMSRegion("ca");

  private static final EnumSupportDynamic<String, SMSRegion> ENUM_SUPPORT =
      new EnumSupportDynamic<>(SMSRegion.class, SMSRegion::new, Arrays.asList(US, EU, AU, BR, CA));

  private SMSRegion(String value) {
    super(value);
  }

  /**
   * Get list of regions
   *
   * @return List of known SMS region
   */
  public static Stream<SMSRegion> values() {
    return ENUM_SUPPORT.values();
  }

  /**
   * Get SMS region from a String
   *
   * @param value String region identifier. Create an SMS Region instance if not known at
   *     compilation
   * @return SMSRegion identified by the string
   */
  public static SMSRegion from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  /**
   * Get SMS region string identifier
   *
   * @param value region identifier
   * @return String value identifier for region
   */
  public static String valueOf(SMSRegion value) {
    return ENUM_SUPPORT.valueOf(value);
  }
}
