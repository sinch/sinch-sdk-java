package com.sinch.sdk.domains.numbers.models.v1.internal;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** The voice application type. Examples are RTC, EST, FAX */
public class VoiceApplicationType extends EnumDynamic<String, VoiceApplicationType> {

  /** Voice <a href="https://developers.sinch.com/docs/voice">see documentation</a> */
  public static final VoiceApplicationType RTC = new VoiceApplicationType("RTC");

  /** Elastic SIP Trunking <a href="https://developers.sinch.com/docs/est">see documentation</a> */
  public static final VoiceApplicationType EST = new VoiceApplicationType("EST");

  /**
   * FAX application <a href="https://developers.sinch.com/docs/fax/overview">see documentation</a>
   */
  public static final VoiceApplicationType FAX = new VoiceApplicationType("FAX");

  private static final EnumSupportDynamic<String, VoiceApplicationType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          VoiceApplicationType.class, VoiceApplicationType::new, Arrays.asList(RTC, EST, FAX));

  private VoiceApplicationType(String value) {
    super(value);
  }

  public static Stream<VoiceApplicationType> values() {
    return ENUM_SUPPORT.values();
  }

  public static VoiceApplicationType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(VoiceApplicationType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
