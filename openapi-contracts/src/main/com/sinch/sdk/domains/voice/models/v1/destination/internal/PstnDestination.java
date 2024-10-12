package com.sinch.sdk.domains.voice.models.v1.destination.internal;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Type <code>number</code> used for PSTN endpoints. */
public class PstnDestination extends EnumDynamic<String, PstnDestination> {

  /** A e.164 formatted number for PSTN endpoints. */
  public static final PstnDestination NUMBER = new PstnDestination("number");

  /** A e.164 formatted number for PSTN endpoints. */
  public static final PstnDestination NUMBER2 = new PstnDestination("Number");

  private static final EnumSupportDynamic<String, PstnDestination> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          PstnDestination.class, PstnDestination::new, Arrays.asList(NUMBER, NUMBER2));

  private PstnDestination(String value) {
    super(value);
  }

  public static Stream<PstnDestination> values() {
    return ENUM_SUPPORT.values();
  }

  public static PstnDestination from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(PstnDestination e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
