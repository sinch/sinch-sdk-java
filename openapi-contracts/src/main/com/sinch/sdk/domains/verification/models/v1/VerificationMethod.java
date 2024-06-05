package com.sinch.sdk.domains.verification.models.v1;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** The type of the verification request. */
public class VerificationMethod extends EnumDynamic<String, VerificationMethod> {

  public static final VerificationMethod SMS = new VerificationMethod("sms");

  public static final VerificationMethod FLASHCALL = new VerificationMethod("flashcall");

  public static final VerificationMethod CALLOUT = new VerificationMethod("callout");

  public static final VerificationMethod SEAMLESS = new VerificationMethod("seamless");

  private static final EnumSupportDynamic<String, VerificationMethod> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          VerificationMethod.class,
          VerificationMethod::new,
          Arrays.asList(SMS, FLASHCALL, CALLOUT, SEAMLESS));

  private VerificationMethod(String value) {
    super(value);
  }

  public static Stream<VerificationMethod> values() {
    return ENUM_SUPPORT.values();
  }

  public static VerificationMethod from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(VerificationMethod e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
