package com.sinch.sdk.domains.verification.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * The type of the verification report status
 *
 * @since 1.0
 */
public class VerificationStatusType
    extends EnumDynamic<String, VerificationStatusType> {

  /** The verification is ongoing */
  public static final VerificationStatusType PENDING =
      new VerificationStatusType("PENDING");

  /** The verification was successful */
  public static final VerificationStatusType SUCCESSFUL =
      new VerificationStatusType("SUCCESSFUL");

  /** The verification attempt was made, but the number wasn't verified */
  public static final VerificationStatusType FAIL = new VerificationStatusType("FAIL");

  /** The verification attempt was denied by Sinch or your backend */
  public static final VerificationStatusType DENIED =
      new VerificationStatusType("DENIED");

  /** The verification attempt was aborted by requesting a new verification */
  public static final VerificationStatusType ABORTED =
      new VerificationStatusType("ABORTED");

  /**
   * The verification couldn't be completed due to a network error or the number being unreachable
   */
  public static final VerificationStatusType ERROR =
      new VerificationStatusType("ERROR");

  private static final EnumSupportDynamic<String, VerificationStatusType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          VerificationStatusType.class,
          VerificationStatusType::new,
          Arrays.asList(PENDING, SUCCESSFUL, FAIL, DENIED, ABORTED, ERROR));

  private VerificationStatusType(String value) {
    super(value);
  }

  /**
   * Get declared values
   *
   * @return Stream of values
   */
  public static Stream<VerificationStatusType> values() {
    return ENUM_SUPPORT.values();
  }

  /**
   * Get value from a string
   *
   * @param value String identifier
   * @return Dynamic enum from value. A new enum is created if value is not yet registered
   */
  public static VerificationStatusType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  /**
   * Value of the enum as String
   *
   * @param e The enum identifier
   * @return String identifier of the enum value
   */
  public static String valueOf(VerificationStatusType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
