package com.sinch.sdk.domains.voice.models.v1.calls.request;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Specifies which part of the call will be managed. This option is used only by the PlayFiles and
 * Say instructions to indicate which channel the sound will be played on. Valid options are caller,
 * callee or both. If not specified, the default value is caller.
 *
 * <p>The callLeg identifier is ignored for calls that are part of a conference and calls initiated
 * using the Callout API.
 *
 * @since 1.4
 */
public class CallLeg extends EnumDynamic<String, CallLeg> {

  public static final CallLeg CALLER = new CallLeg("caller");
  public static final CallLeg CALLEE = new CallLeg("callee");
  public static final CallLeg BOTH = new CallLeg("both");

  /** */
  private static final EnumSupportDynamic<String, CallLeg> ENUM_SUPPORT =
      new EnumSupportDynamic<>(CallLeg.class, CallLeg::new, Arrays.asList(CALLER, CALLEE, BOTH));

  private CallLeg(String value) {
    super(value);
  }

  public static Stream<CallLeg> values() {
    return ENUM_SUPPORT.values();
  }

  public static CallLeg from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(CallLeg e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
