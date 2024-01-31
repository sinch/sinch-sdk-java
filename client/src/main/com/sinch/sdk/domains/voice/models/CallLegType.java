package com.sinch.sdk.domains.voice.models;

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
 */
public class CallLegType extends EnumDynamic<String, CallLegType> {

  public static final CallLegType CALLER = new CallLegType("caller");
  public static final CallLegType CALLEE = new CallLegType("callee");
  public static final CallLegType BOTH = new CallLegType("both");

  /** */
  private static final EnumSupportDynamic<String, CallLegType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          CallLegType.class, CallLegType::new, Arrays.asList(CALLER, CALLEE, BOTH));

  private CallLegType(String value) {
    super(value);
  }

  public static Stream<CallLegType> values() {
    return ENUM_SUPPORT.values();
  }

  public static CallLegType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(CallLegType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
