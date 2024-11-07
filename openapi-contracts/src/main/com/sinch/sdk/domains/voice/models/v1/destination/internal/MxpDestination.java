package com.sinch.sdk.domains.voice.models.v1.destination.internal;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Type <code>userName</code> used for data endpoints. */
public class MxpDestination extends EnumDynamic<String, MxpDestination> {

  /** A username for data endpoints. */
  public static final MxpDestination USERNAME = new MxpDestination("username");

  /** A username for data endpoints. */
  public static final MxpDestination USERNAME2 = new MxpDestination("Username");

  private static final EnumSupportDynamic<String, MxpDestination> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          MxpDestination.class, MxpDestination::new, Arrays.asList(USERNAME, USERNAME2));

  private MxpDestination(String value) {
    super(value);
  }

  public static Stream<MxpDestination> values() {
    return ENUM_SUPPORT.values();
  }

  public static MxpDestination from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(MxpDestination e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
