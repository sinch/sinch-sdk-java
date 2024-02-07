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
public class VerificationReportReasonType
    extends EnumDynamic<String, VerificationReportReasonType> {

  /** FRAUD */
  public static final VerificationReportReasonType FRAUD =
      new VerificationReportReasonType("Fraud");

  /** NOT_ENOUGH_CREDIT */
  public static final VerificationReportReasonType NOT_ENOUGH_CREDIT =
      new VerificationReportReasonType("Not enough credit");

  /** BLOCKED */
  public static final VerificationReportReasonType BLOCKED =
      new VerificationReportReasonType("Blocked");

  /** DENIED_BY_CALLBACK */
  public static final VerificationReportReasonType DENIED_BY_CALLBACK =
      new VerificationReportReasonType("Denied by callback");

  /** INVALID_CALLBACK */
  public static final VerificationReportReasonType INVALID_CALLBACK =
      new VerificationReportReasonType("Invalid callback");

  /** INTERNAL_ERROR */
  public static final VerificationReportReasonType INTERNAL_ERROR =
      new VerificationReportReasonType("Internal error");

  /** DESTINATION_DENIED */
  public static final VerificationReportReasonType DESTINATION_DENIED =
      new VerificationReportReasonType("Destination denied");

  /** NETWORK_ERROR_OR_NUMBER_UNREACHABLE */
  public static final VerificationReportReasonType NETWORK_ERROR_OR_NUMBER_UNREACHABLE =
      new VerificationReportReasonType("Network error or number unreachable");

  /** FAILED_PENDING */
  public static final VerificationReportReasonType FAILED_PENDING =
      new VerificationReportReasonType("Failed pending");

  /** SMS_DELIVERY_FAILURE */
  public static final VerificationReportReasonType SMS_DELIVERY_FAILURE =
      new VerificationReportReasonType("SMS delivery failure");

  /** INVALID_CLI */
  public static final VerificationReportReasonType INVALID_CLI =
      new VerificationReportReasonType("Invalid CLI");

  /** INVALID_CODE */
  public static final VerificationReportReasonType INVALID_CODE =
      new VerificationReportReasonType("Invalid code");

  /** EXPIRED */
  public static final VerificationReportReasonType EXPIRED =
      new VerificationReportReasonType("Expired");

  /** HUNG_UP_WITHOUT_ENTERING_VALID_CODE */
  public static final VerificationReportReasonType HUNG_UP_WITHOUT_ENTERING_VALID_CODE =
      new VerificationReportReasonType("Hung up without entering valid code");

  private static final EnumSupportDynamic<String, VerificationReportReasonType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          VerificationReportReasonType.class,
          VerificationReportReasonType::new,
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

  private VerificationReportReasonType(String value) {
    super(value);
  }

  /**
   * Get declared values
   *
   * @return Stream of values
   */
  public static Stream<VerificationReportReasonType> values() {
    return ENUM_SUPPORT.values();
  }

  /**
   * Get value from a string
   *
   * @param value String identifier
   * @return Dynamic enum from value. A new enum is created if value is not yet registered
   */
  public static VerificationReportReasonType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  /**
   * Value of the enum as String
   *
   * @param e The enum identifier
   * @return String identifier of the enum value
   */
  public static String valueOf(VerificationReportReasonType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
