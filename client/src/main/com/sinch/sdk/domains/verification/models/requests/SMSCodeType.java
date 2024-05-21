package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Accepted values for the type of code to be generated are Numeric, Alpha, and Alphanumeric.
 *
 * @since 1.0
 */
public class SMSCodeType extends EnumDynamic<String, SMSCodeType> {

  public static final SMSCodeType NUMERIC = new SMSCodeType("Numeric");

  public static final SMSCodeType ALPHA = new SMSCodeType("Alpha");

  public static final SMSCodeType ALPHANUMERIC = new SMSCodeType("Alphanumeric");
  private static final EnumSupportDynamic<String, SMSCodeType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(SMSCodeType.class, SMSCodeType::new, Arrays.asList(NUMERIC, ALPHA, ALPHANUMERIC));

  private SMSCodeType(String value) {
    super(value);
  }

  /**
   * Get declared values
   *
   * @return Stream of values
   */
  public static Stream<SMSCodeType> values() {
    return ENUM_SUPPORT.values();
  }

  /**
   * Get value from a string
   *
   * @param value String identifier
   * @return Dynamic enum from value. A new enum is created if value is not yet registered
   */
  public static SMSCodeType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  /**
   * Value of the enum as String
   *
   * @param e The enum identifier
   * @return String identifier of the enum value
   */
  public static String valueOf(SMSCodeType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
