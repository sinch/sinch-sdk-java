package com.sinch.sdk.domains.verification.models.v1.webhooks;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Determines whether the verification can be executed. */
public class VerificationEventResponseAction
    extends EnumDynamic<String, VerificationEventResponseAction> {

  /** Verification allowed */
  public static final VerificationEventResponseAction ALLOW =
      new VerificationEventResponseAction("allow");

  /** Verification denied */
  public static final VerificationEventResponseAction DENY =
      new VerificationEventResponseAction("deny");

  private static final EnumSupportDynamic<String, VerificationEventResponseAction> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          VerificationEventResponseAction.class,
          VerificationEventResponseAction::new,
          Arrays.asList(ALLOW, DENY));

  private VerificationEventResponseAction(String value) {
    super(value);
  }

  public static Stream<VerificationEventResponseAction> values() {
    return ENUM_SUPPORT.values();
  }

  public static VerificationEventResponseAction from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(VerificationEventResponseAction e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
