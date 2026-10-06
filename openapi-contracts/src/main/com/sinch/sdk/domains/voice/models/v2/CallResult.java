package com.sinch.sdk.domains.voice.models.v2;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * The outcome/state of the call.
 *
 * <p>This field includes both <b>transitional</b> states (during call setup and execution) and
 * <b>final</b> states (when the call has ended).
 */
public class CallResult extends EnumDynamic<String, CallResult> {

  /** The call is queued for initiation. Transitional state. */
  public static final CallResult QUEUED = new CallResult("QUEUED");

  /** The call is connecting but the recipient has not yet answered. Transitional state. */
  public static final CallResult INITIATED = new CallResult("INITIATED");

  /** The call has been answered and is in progress. Transitional state. */
  public static final CallResult IN_PROGRESS = new CallResult("IN_PROGRESS");

  /** The call was answered and is ended. Final state. */
  public static final CallResult COMPLETED = new CallResult("COMPLETED");

  /** The call was rejected by the recipient. */
  public static final CallResult REJECTED = new CallResult("REJECTED");

  /** The call was not answered by the recipient. */
  public static final CallResult NO_ANSWER = new CallResult("NO_ANSWER");

  /** The call was cancelled. */
  public static final CallResult CANCEL = new CallResult("CANCEL");

  /** The call was not answered because the recipient was busy. */
  public static final CallResult BUSY = new CallResult("BUSY");

  /** The call could not be completed. */
  public static final CallResult FAILED = new CallResult("FAILED");

  private static final EnumSupportDynamic<String, CallResult> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          CallResult.class,
          CallResult::new,
          Arrays.asList(
              QUEUED,
              INITIATED,
              IN_PROGRESS,
              COMPLETED,
              REJECTED,
              NO_ANSWER,
              CANCEL,
              BUSY,
              FAILED));

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
