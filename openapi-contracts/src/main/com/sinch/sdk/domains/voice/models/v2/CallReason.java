package com.sinch.sdk.domains.voice.models.v2;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Reason explaining <b>why</b> the call ended in the given {@link CallResult}.
 *
 * <p>{@link CallResult} describes <b>what</b> happened (state/outcome). The reason provides
 * additional context about the underlying cause (for example, who terminated the call, routing
 * issues, or validation errors).
 */
public class CallReason extends EnumDynamic<String, CallReason> {

  /** The call was completed successfully. */
  public static final CallReason OK = new CallReason("OK");

  /** The callee was not available. */
  public static final CallReason NOT_AVAILABLE = new CallReason("NOT_AVAILABLE");

  /** The caller hung up the call. */
  public static final CallReason CALLER_HANGUP = new CallReason("CALLER_HANGUP");

  /** The callee hung up the call. */
  public static final CallReason CALLEE_HANGUP = new CallReason("CALLEE_HANGUP");

  /** The call was ended by the call manager. */
  public static final CallReason MANAGER_HANGUP = new CallReason("MANAGER_HANGUP");

  /** The DID number was not found. */
  public static final CallReason DID_NOT_FOUND = new CallReason("DID_NOT_FOUND");

  /** The SVAML script was invalid. */
  public static final CallReason INVALID_SCRIPT = new CallReason("INVALID_SCRIPT");

  /** The product associated with the call is unknown. */
  public static final CallReason UNKNOWN_PRODUCT = new CallReason("UNKNOWN_PRODUCT");

  /** There are no more routes to complete the call. */
  public static final CallReason NO_MORE_ROUTES = new CallReason("NO_MORE_ROUTES");

  /** An error occurred during the call. */
  public static final CallReason ERROR = new CallReason("ERROR");

  private static final EnumSupportDynamic<String, CallReason> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          CallReason.class,
          CallReason::new,
          Arrays.asList(
              OK,
              NOT_AVAILABLE,
              CALLER_HANGUP,
              CALLEE_HANGUP,
              MANAGER_HANGUP,
              DID_NOT_FOUND,
              INVALID_SCRIPT,
              UNKNOWN_PRODUCT,
              NO_MORE_ROUTES,
              ERROR));

  private CallReason(String value) {
    super(value);
  }

  public static Stream<CallReason> values() {
    return ENUM_SUPPORT.values();
  }

  public static CallReason from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(CallReason e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
