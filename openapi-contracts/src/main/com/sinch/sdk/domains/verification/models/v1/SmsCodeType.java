package com.sinch.sdk.domains.verification.models.v1;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Selects type of code which will be sent to customer */
public class SmsCodeType extends EnumDynamic<String, SmsCodeType> {

  /** Code contains numbers only. */
  public static final SmsCodeType NUMERIC = new SmsCodeType("Numeric");

  /** Code contains letters only. */
  public static final SmsCodeType ALPHA = new SmsCodeType("Alpha");

  /** Code contains both numbers and letters. */
  public static final SmsCodeType ALPHANUMERIC = new SmsCodeType("Alphanumeric");

  private static final EnumSupportDynamic<String, SmsCodeType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          SmsCodeType.class, SmsCodeType::new, Arrays.asList(NUMERIC, ALPHA, ALPHANUMERIC));

  private SmsCodeType(String value) {
    super(value);
  }

  public static Stream<SmsCodeType> values() {
    return ENUM_SUPPORT.values();
  }

  public static SmsCodeType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(SmsCodeType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
