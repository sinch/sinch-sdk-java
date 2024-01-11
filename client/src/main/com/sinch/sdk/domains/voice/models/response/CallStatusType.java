package com.sinch.sdk.domains.voice.models.response;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** The status of a call */
public class CallStatusType extends EnumDynamic<String, CallStatusType> {

  public static final CallStatusType ONGOING = new CallStatusType("ONGOING");

  public static final CallStatusType FINAL = new CallStatusType("FINAL");

  /** */
  private static final EnumSupportDynamic<String, CallStatusType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          CallStatusType.class, CallStatusType::new, Arrays.asList(ONGOING, FINAL));

  private CallStatusType(String value) {
    super(value);
  }

  public static Stream<CallStatusType> values() {
    return ENUM_SUPPORT.values();
  }

  public static CallStatusType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(CallStatusType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
