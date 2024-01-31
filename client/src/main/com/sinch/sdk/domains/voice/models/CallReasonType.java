package com.sinch.sdk.domains.voice.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Describe the reason why a call ended */
public class CallReasonType extends EnumDynamic<String, CallReasonType> {

  public static final CallReasonType NA = new CallReasonType("N/A");
  public static final CallReasonType TIMEOUT = new CallReasonType("TIMEOUT");
  public static final CallReasonType CALLER_HANGUP = new CallReasonType("CALLERHANGUP");
  public static final CallReasonType CALLEE_HANGUP = new CallReasonType("CALLEEHANGUP");
  public static final CallReasonType BLOCKED = new CallReasonType("BLOCKED");
  public static final CallReasonType NO_CREDIT_PARTNER = new CallReasonType("NOCREDITPARTNER");
  public static final CallReasonType MANAGER_HANGUP = new CallReasonType("MANAGERHANGUP");
  public static final CallReasonType CANCEL = new CallReasonType("CANCEL");
  public static final CallReasonType GENERAL_ERROR = new CallReasonType("GENERALERROR");
  public static final CallReasonType INVALID_SVAMLACTION = new CallReasonType("INVALIDSVAMLACTION");

  private static final EnumSupportDynamic<String, CallReasonType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          CallReasonType.class,
          CallReasonType::new,
          Arrays.asList(
              NA,
              TIMEOUT,
              CALLER_HANGUP,
              CALLEE_HANGUP,
              BLOCKED,
              NO_CREDIT_PARTNER,
              MANAGER_HANGUP,
              CANCEL,
              GENERAL_ERROR,
              INVALID_SVAMLACTION));

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
