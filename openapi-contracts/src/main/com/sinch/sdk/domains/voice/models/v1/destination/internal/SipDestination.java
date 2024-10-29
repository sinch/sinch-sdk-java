package com.sinch.sdk.domains.voice.models.v1.destination.internal;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Type <code>sip</code> for SIP infrastructures. */
public class SipDestination extends EnumDynamic<String, SipDestination> {

  /** A SIP address for SIP infrastructures. */
  public static final SipDestination SIP = new SipDestination("sip");

  private static final EnumSupportDynamic<String, SipDestination> ENUM_SUPPORT =
      new EnumSupportDynamic<>(SipDestination.class, SipDestination::new, Arrays.asList(SIP));

  private SipDestination(String value) {
    super(value);
  }

  public static Stream<SipDestination> values() {
    return ENUM_SUPPORT.values();
  }

  public static SipDestination from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(SipDestination e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
