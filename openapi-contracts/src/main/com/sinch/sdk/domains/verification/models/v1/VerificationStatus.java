package com.sinch.sdk.domains.verification.models.v1;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** The status of the verification */
public class VerificationStatus extends EnumDynamic<String, VerificationStatus> {

  public static final VerificationStatus PENDING = new VerificationStatus("PENDING");

  public static final VerificationStatus SUCCESSFUL = new VerificationStatus("SUCCESSFUL");

  public static final VerificationStatus FAIL = new VerificationStatus("FAIL");

  public static final VerificationStatus DENIED = new VerificationStatus("DENIED");

  public static final VerificationStatus ABORTED = new VerificationStatus("ABORTED");

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
