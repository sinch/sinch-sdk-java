package com.sinch.sdk.domains.voice.models.v2;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Indicates the origin/source of the call.
 *
 * <p>This describes <b>how the call was initiated</b> (PSTN or via the API).
 */
public class OriginationType extends EnumDynamic<String, OriginationType> {

  /** The call originated from the telephone network (PSTN). */
  public static final OriginationType PHONE = new OriginationType("PHONE");

  /** The call originated from a SIP trunk. */
  public static final OriginationType SIP = new OriginationType("SIP");

  /** The call originated through the Sinch API. */
  public static final OriginationType SERVER = new OriginationType("SERVER");

  private static final EnumSupportDynamic<String, OriginationType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          OriginationType.class, OriginationType::new, Arrays.asList(PHONE, SIP, SERVER));

  private OriginationType(String value) {
    super(value);
  }

  public static Stream<OriginationType> values() {
    return ENUM_SUPPORT.values();
  }

  public static OriginationType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(OriginationType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
