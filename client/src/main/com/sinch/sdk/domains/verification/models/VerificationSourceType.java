package com.sinch.sdk.domains.verification.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * The type of the verification request authorized values
 *
 * @since 1.0
 */
public class VerificationSourceType extends EnumDynamic<String, VerificationSourceType> {

  public static final VerificationSourceType INTERCEPTED =
      new VerificationSourceType("intercepted");

  public static final VerificationSourceType MANUAL = new VerificationSourceType("manual");

  /** */
  private static final EnumSupportDynamic<String, VerificationSourceType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          VerificationSourceType.class,
          VerificationSourceType::new,
          Arrays.asList(INTERCEPTED, MANUAL));

  private VerificationSourceType(String value) {
    super(value);
  }

  public static Stream<VerificationSourceType> values() {
    return ENUM_SUPPORT.values();
  }

  public static VerificationSourceType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(VerificationSourceType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
