package com.sinch.sdk.domains.verification.models.v1.status;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** The type of the call result. */
public class StatusCallResult extends EnumDynamic<String, StatusCallResult> {

  public static final StatusCallResult ANSWERED = new StatusCallResult("ANSWERED");

  public static final StatusCallResult CANCEL = new StatusCallResult("CANCEL");

  public static final StatusCallResult COMPLETED = new StatusCallResult("COMPLETED");

  public static final StatusCallResult NO_ANSWER = new StatusCallResult("NO_ANSWER");

  public static final StatusCallResult BUSY = new StatusCallResult("BUSY");

  public static final StatusCallResult FAILED = new StatusCallResult("FAILED");

  private static final EnumSupportDynamic<String, StatusCallResult> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          StatusCallResult.class,
          StatusCallResult::new,
          Arrays.asList(ANSWERED, CANCEL, COMPLETED, NO_ANSWER, BUSY, FAILED));

  private StatusCallResult(String value) {
    super(value);
  }

  public static Stream<StatusCallResult> values() {
    return ENUM_SUPPORT.values();
  }

  public static StatusCallResult from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(StatusCallResult e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
