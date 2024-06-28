package com.sinch.sdk.domains.verification.models.v1;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** The type of the verification request. */
public class VerificationMethod extends EnumDynamic<String, VerificationMethod> {

  /** Verification by SMS message with a PIN code. */
  public static final VerificationMethod SMS = new VerificationMethod("sms");

  /**
   * Verification by placing a flashVerificationResultEvent call (missed call) and detecting the
   * incoming calling number (CLI).
   */
  public static final VerificationMethod FLASH_CALL = new VerificationMethod("flashcall");

  /**
   * Verification by placing a PSTN call to the user's phone and playing an announcement, asking the
   * user to press a particular digit to verify the phone number.
   */
  public static final VerificationMethod PHONE_CALL = new VerificationMethod("callout");

  /**
   * Data verification. Verification by accessing internal infrastructure of mobile carriers to
   * verify if given verification attempt was originated from device with matching phone number.
   */
  public static final VerificationMethod DATA = new VerificationMethod("seamless");

  private static final EnumSupportDynamic<String, VerificationMethod> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          VerificationMethod.class,
          VerificationMethod::new,
          Arrays.asList(SMS, FLASH_CALL, PHONE_CALL, DATA));

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
