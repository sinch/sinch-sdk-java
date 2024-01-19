package com.sinch.sdk.domains.voice.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Describe the reason why a call ended */
public class CallReasonType extends EnumDynamic<String, CallReasonType> {

  public static final CallReasonType NA = new CallReasonType("N/A");
  public static final CallReasonType TIMEOUT = new CallReasonType("TIMEOUT");
  public static final CallReasonType CALLERHANGUP = new CallReasonType("CALLERHANGUP");
  public static final CallReasonType CALLEEHANGUP = new CallReasonType("CALLEEHANGUP");
  public static final CallReasonType BLOCKED = new CallReasonType("BLOCKED");
  public static final CallReasonType NOCREDITPARTNER = new CallReasonType("NOCREDITPARTNER");
  public static final CallReasonType MANAGERHANGUP = new CallReasonType("MANAGERHANGUP");
  public static final CallReasonType CANCEL = new CallReasonType("CANCEL");
  public static final CallReasonType GENERALERROR = new CallReasonType("GENERALERROR");

  private static final EnumSupportDynamic<String, CallReasonType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          CallReasonType.class,
          CallReasonType::new,
          Arrays.asList(
              NA,
              TIMEOUT,
              CALLERHANGUP,
              CALLEEHANGUP,
              BLOCKED,
              NOCREDITPARTNER,
              MANAGERHANGUP,
              CANCEL,
              GENERALERROR));

  private CallReasonType(String value) {
    super(value);
  }

  public static Stream<CallReasonType> values() {
    return ENUM_SUPPORT.values();
  }

  public static CallReasonType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(CallReasonType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
