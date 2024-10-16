package com.sinch.sdk.domains.voice.models.v1.applications;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Valid values are <code>voice</code> and <code>sms</code> */
public class Capability extends EnumDynamic<String, Capability> {

  /** Able to make Voice calls. */
  public static final Capability VOICE = new Capability("voice");

  /** Able to send SMS messages. */
  public static final Capability SMS = new Capability("sms");

  private static final EnumSupportDynamic<String, Capability> ENUM_SUPPORT =
      new EnumSupportDynamic<>(Capability.class, Capability::new, Arrays.asList(VOICE, SMS));

  private Capability(String value) {
    super(value);
  }

  public static Stream<Capability> values() {
    return ENUM_SUPPORT.values();
  }

  public static Capability from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(Capability e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
