package com.sinch.sdk.domains.verification.models.v1.sinchevents;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Determines whether the verification can be executed. */
public class VerificationStartEventAction
    extends EnumDynamic<String, VerificationStartEventAction> {

  /** Verification allowed */
  public static final VerificationStartEventAction ALLOW =
      new VerificationStartEventAction("allow");

  /** Verification denied */
  public static final VerificationStartEventAction DENY = new VerificationStartEventAction("deny");

  private static final EnumSupportDynamic<String, VerificationStartEventAction> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          VerificationStartEventAction.class,
          VerificationStartEventAction::new,
          Arrays.asList(ALLOW, DENY));

  private VerificationStartEventAction(String value) {
    super(value);
  }

  public static Stream<VerificationStartEventAction> values() {
    return ENUM_SUPPORT.values();
  }

  public static VerificationStartEventAction from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(VerificationStartEventAction e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
