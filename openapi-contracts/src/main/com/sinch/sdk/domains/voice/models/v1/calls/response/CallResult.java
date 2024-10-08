package com.sinch.sdk.domains.voice.models.v1.calls.response;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Contains the result of a call. */
public class CallResult extends EnumDynamic<String, CallResult> {

  public static final CallResult N_A = new CallResult("N/A");

  /** The call was answered. */
  public static final CallResult ANSWERED = new CallResult("ANSWERED");

  /** The line called was busy. */
  public static final CallResult BUSY = new CallResult("BUSY");

  /** The line called failed to answer. */
  public static final CallResult NOANSWER = new CallResult("NOANSWER");

  /** The call failed. */
  public static final CallResult FAILED = new CallResult("FAILED");

  private static final EnumSupportDynamic<String, CallResult> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          CallResult.class, CallResult::new, Arrays.asList(N_A, ANSWERED, BUSY, NOANSWER, FAILED));

  private CallResult(String value) {
    super(value);
  }

  public static Stream<CallResult> values() {
    return ENUM_SUPPORT.values();
  }

  public static CallResult from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(CallResult e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
