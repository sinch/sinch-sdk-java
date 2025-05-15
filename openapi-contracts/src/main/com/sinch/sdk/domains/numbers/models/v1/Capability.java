package com.sinch.sdk.domains.numbers.models.v1;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** The capabilities the phone number supports: SMS, Voice, or both */
public class Capability extends EnumDynamic<String, Capability> {

  /** The SMS product can use the number. */
  public static final Capability SMS = new Capability("SMS");

  /** The Voice product can use the number. */
  public static final Capability VOICE = new Capability("VOICE");

  private static final EnumSupportDynamic<String, Capability> ENUM_SUPPORT =
      new EnumSupportDynamic<>(Capability.class, Capability::new, Arrays.asList(SMS, VOICE));

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
