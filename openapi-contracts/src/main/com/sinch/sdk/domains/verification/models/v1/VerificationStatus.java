package com.sinch.sdk.domains.verification.models.v1;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** The status of the verification */
public class VerificationStatus extends EnumDynamic<String, VerificationStatus> {

  /** The verification is ongoing. */
  public static final VerificationStatus PENDING = new VerificationStatus("PENDING");

  /** The verification was successful. */
  public static final VerificationStatus SUCCESSFUL = new VerificationStatus("SUCCESSFUL");

  /** The verification attempt was made, but the number wasn't verified. */
  public static final VerificationStatus FAIL = new VerificationStatus("FAIL");

  /** The verification attempt was denied by Sinch or your backend. */
  public static final VerificationStatus DENIED = new VerificationStatus("DENIED");

  /** The verification attempt was aborted by requesting a new verification. */
  public static final VerificationStatus ABORTED = new VerificationStatus("ABORTED");

  /**
   * The verification couldn't be completed due to a network error or the number being unreachable.
   */
  public static final VerificationStatus ERROR = new VerificationStatus("ERROR");

  private static final EnumSupportDynamic<String, VerificationStatus> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          VerificationStatus.class,
          VerificationStatus::new,
          Arrays.asList(PENDING, SUCCESSFUL, FAIL, DENIED, ABORTED, ERROR));

  private VerificationStatus(String value) {
    super(value);
  }

  public static Stream<VerificationStatus> values() {
    return ENUM_SUPPORT.values();
  }

  public static VerificationStatus from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(VerificationStatus e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
