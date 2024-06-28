package com.sinch.sdk.domains.verification.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * The type of the verification request authorized values
 *
 * @since 1.1
 */
public class VerificationSourceType extends EnumDynamic<String, VerificationSourceType> {

  /** Show if the call/SMS was intercepted or not. */
  public static final VerificationSourceType INTERCEPTED =
      new VerificationSourceType("intercepted");

  /** Show if the call/SMS was intercepted or not. */
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

  /**
   * Get declared values
   *
   * @return Stream of values
   */
  public static Stream<VerificationSourceType> values() {
    return ENUM_SUPPORT.values();
  }

  /**
   * Get value from a string
   *
   * @param value String identifier
   * @return Dynamic enum from value. A new enum is created if value is not yet registered
   */
  public static VerificationSourceType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  /**
   * Value of the enum as String
   *
   * @param e The enum identifier
   * @return String identifier of the enum value
   */
  public static String valueOf(VerificationSourceType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
