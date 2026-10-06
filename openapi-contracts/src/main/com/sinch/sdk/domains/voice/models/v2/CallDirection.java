package com.sinch.sdk.domains.voice.models.v2;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Indicates the direction of the call. */
public class CallDirection extends EnumDynamic<String, CallDirection> {

  /** A call initiated towards the Sinch Calling Platform. */
  public static final CallDirection INBOUND = new CallDirection("INBOUND");

  /** A call initiated from the Sinch Calling Platform. */
  public static final CallDirection OUTBOUND = new CallDirection("OUTBOUND");

  private static final EnumSupportDynamic<String, CallDirection> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          CallDirection.class, CallDirection::new, Arrays.asList(INBOUND, OUTBOUND));

  private CallDirection(String value) {
    super(value);
  }

  public static Stream<CallDirection> values() {
    return ENUM_SUPPORT.values();
  }

  public static CallDirection from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(CallDirection e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
