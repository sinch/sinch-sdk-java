package com.sinch.sdk.domains.voice.models.response;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Describe the result of a call */
public class CallResultType extends EnumDynamic<String, CallResultType> {

  public static final CallResultType NA = new CallResultType("N/A");
  public static final CallResultType ANSWERED = new CallResultType("ANSWERED");
  public static final CallResultType BUSY = new CallResultType("BUSY");
  public static final CallResultType NOANSWER = new CallResultType("NOANSWER");
  public static final CallResultType FAILED = new CallResultType("FAILED");

  /** */
  private static final EnumSupportDynamic<String, CallResultType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          CallResultType.class,
          CallResultType::new,
          Arrays.asList(NA, ANSWERED, BUSY, NOANSWER, FAILED));

  private CallResultType(String value) {
    super(value);
  }

  public static Stream<CallResultType> values() {
    return ENUM_SUPPORT.values();
  }

  public static CallResultType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(CallResultType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
