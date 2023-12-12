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
public class VerificationReportStatusType
    extends EnumDynamic<String, VerificationReportStatusType> {

  /** The verification is ongoing */
  public static final VerificationReportStatusType PENDING =
      new VerificationReportStatusType("PENDING");

  /** The verification was successful */
  public static final VerificationReportStatusType SUCCESSFUL =
      new VerificationReportStatusType("SUCCESSFUL");

  /** The verification attempt was made, but the number wasn't verified */
  public static final VerificationReportStatusType FAIL = new VerificationReportStatusType("FAIL");

  /** The verification attempt was denied by Sinch or your backend */
  public static final VerificationReportStatusType DENIED =
      new VerificationReportStatusType("DENIED");

  /** The verification attempt was aborted by requesting a new verification */
  public static final VerificationReportStatusType ABORTED =
      new VerificationReportStatusType("ABORTED");

  /**
   * The verification couldn't be completed due to a network error or the number being unreachable
   */
  public static final VerificationReportStatusType ERROR =
      new VerificationReportStatusType("ERROR");

  private static final EnumSupportDynamic<String, VerificationReportStatusType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          VerificationReportStatusType.class,
          VerificationReportStatusType::new,
          Arrays.asList(PENDING, SUCCESSFUL, FAIL, DENIED, ABORTED, ERROR));

  private VerificationReportStatusType(String value) {
    super(value);
  }

  public static Stream<VerificationReportStatusType> values() {
    return ENUM_SUPPORT.values();
  }

  public static VerificationReportStatusType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(VerificationReportStatusType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
