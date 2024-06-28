package com.sinch.sdk.domains.verification.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * The type of the verification report reason
 *
 * @since 1.0
 */
public class VerificationStatusReasonType
    extends EnumDynamic<String, VerificationStatusReasonType> {

  /** FRAUD */
  public static final VerificationStatusReasonType FRAUD =
      new VerificationStatusReasonType("Fraud");

  /** NOT_ENOUGH_CREDIT */
  public static final VerificationStatusReasonType NOT_ENOUGH_CREDIT =
      new VerificationStatusReasonType("Not enough credit");

  /** BLOCKED */
  public static final VerificationStatusReasonType BLOCKED =
      new VerificationStatusReasonType("Blocked");

  /** DENIED_BY_CALLBACK */
  public static final VerificationStatusReasonType DENIED_BY_CALLBACK =
      new VerificationStatusReasonType("Denied by callback");

  /** INVALID_CALLBACK */
  public static final VerificationStatusReasonType INVALID_CALLBACK =
      new VerificationStatusReasonType("Invalid callback");

  /** INTERNAL_ERROR */
  public static final VerificationStatusReasonType INTERNAL_ERROR =
      new VerificationStatusReasonType("Internal error");

  /** DESTINATION_DENIED */
  public static final VerificationStatusReasonType DESTINATION_DENIED =
      new VerificationStatusReasonType("Destination denied");

  /** NETWORK_ERROR_OR_NUMBER_UNREACHABLE */
  public static final VerificationStatusReasonType NETWORK_ERROR_OR_NUMBER_UNREACHABLE =
      new VerificationStatusReasonType("Network error or number unreachable");

  /** FAILED_PENDING */
  public static final VerificationStatusReasonType FAILED_PENDING =
      new VerificationStatusReasonType("Failed pending");

  /** SMS_DELIVERY_FAILURE */
  public static final VerificationStatusReasonType SMS_DELIVERY_FAILURE =
      new VerificationStatusReasonType("SMS delivery failure");

  /** INVALID_CLI */
  public static final VerificationStatusReasonType INVALID_CLI =
      new VerificationStatusReasonType("Invalid CLI");

  /** INVALID_CODE */
  public static final VerificationStatusReasonType INVALID_CODE =
      new VerificationStatusReasonType("Invalid code");

  /** EXPIRED */
  public static final VerificationStatusReasonType EXPIRED =
      new VerificationStatusReasonType("Expired");

  /** HUNG_UP_WITHOUT_ENTERING_VALID_CODE */
  public static final VerificationStatusReasonType HUNG_UP_WITHOUT_ENTERING_VALID_CODE =
      new VerificationStatusReasonType("Hung up without entering valid code");

  private static final EnumSupportDynamic<String, VerificationStatusReasonType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          VerificationStatusReasonType.class,
          VerificationStatusReasonType::new,
          Arrays.asList(
              FRAUD,
              NOT_ENOUGH_CREDIT,
              BLOCKED,
              DENIED_BY_CALLBACK,
              INVALID_CALLBACK,
              INTERNAL_ERROR,
              DESTINATION_DENIED,
              NETWORK_ERROR_OR_NUMBER_UNREACHABLE,
              FAILED_PENDING,
              SMS_DELIVERY_FAILURE,
              INVALID_CLI,
              INVALID_CODE,
              EXPIRED,
              HUNG_UP_WITHOUT_ENTERING_VALID_CODE));

  private VerificationStatusReasonType(String value) {
    super(value);
  }

  /**
   * Get declared values
   *
   * @return Stream of values
   */
  public static Stream<VerificationStatusReasonType> values() {
    return ENUM_SUPPORT.values();
  }

  /**
   * Get value from a string
   *
   * @param value String identifier
   * @return Dynamic enum from value. A new enum is created if value is not yet registered
   */
  public static VerificationStatusReasonType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  /**
   * Value of the enum as String
   *
   * @param e The enum identifier
   * @return String identifier of the enum value
   */
  public static String valueOf(VerificationStatusReasonType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
