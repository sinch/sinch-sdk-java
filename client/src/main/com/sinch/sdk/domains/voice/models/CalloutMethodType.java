package com.sinch.sdk.domains.voice.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

public class CalloutMethodType extends EnumDynamic<String, CalloutMethodType> {

  public static final CalloutMethodType CONFERENCE_CALLOUT =
      new CalloutMethodType("conferenceCallout");
  public static final CalloutMethodType TTS_CALLOUT = new CalloutMethodType("ttsCallout");
  public static final CalloutMethodType CUSTOM_CALLOUT = new CalloutMethodType("customCallout");

  /** */
  private static final EnumSupportDynamic<String, CalloutMethodType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          CalloutMethodType.class,
          CalloutMethodType::new,
          Arrays.asList(CONFERENCE_CALLOUT, TTS_CALLOUT, CUSTOM_CALLOUT));

  private CalloutMethodType(String value) {
    super(value);
  }

  public static Stream<CalloutMethodType> values() {
    return ENUM_SUPPORT.values();
  }

  public static CalloutMethodType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(CalloutMethodType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
