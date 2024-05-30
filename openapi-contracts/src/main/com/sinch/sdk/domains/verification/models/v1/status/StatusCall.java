package com.sinch.sdk.domains.verification.models.v1.status;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** The type of the call result. */
public class StatusCall extends EnumDynamic<String, StatusCall> {

  public static final StatusCall ANSWERED = new StatusCall("ANSWERED");

  public static final StatusCall CANCEL = new StatusCall("CANCEL");

  private static final EnumSupportDynamic<String, StatusCall> ENUM_SUPPORT =
      new EnumSupportDynamic<>(StatusCall.class, StatusCall::new, Arrays.asList(ANSWERED, CANCEL));

  private StatusCall(String value) {
    super(value);
  }

  public static Stream<StatusCall> values() {
    return ENUM_SUPPORT.values();
  }

  public static StatusCall from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(StatusCall e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
