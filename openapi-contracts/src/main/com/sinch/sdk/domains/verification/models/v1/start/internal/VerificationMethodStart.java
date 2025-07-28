package com.sinch.sdk.domains.verification.models.v1.start.internal;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** The type of the verification request. */
public class VerificationMethodStart extends EnumDynamic<String, VerificationMethodStart> {

  /** Verification by SMS message with an OTP code. */
  public static final VerificationMethodStart SMS = new VerificationMethodStart("sms");

  /**
   * Verification by placing a flashVerificationResultEvent call (missed call) and detecting the
   * incoming calling number (CLI).
   */
  public static final VerificationMethodStart FLASH_CALL = new VerificationMethodStart("flashcall");

  /**
   * Verification by placing a PSTN call to the user's phone and playing an announcement, asking the
   * user to press a particular digit to verify the phone number.
   */
  public static final VerificationMethodStart PHONE_CALL = new VerificationMethodStart("callout");

  /**
   * Data verification. Verification by accessing internal infrastructure of mobile carriers to
   * verify if given verification attempt was originated from device with matching phone number.
   */
  public static final VerificationMethodStart DATA = new VerificationMethodStart("seamless");

  private static final EnumSupportDynamic<String, VerificationMethodStart> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          VerificationMethodStart.class,
          VerificationMethodStart::new,
          Arrays.asList(SMS, FLASH_CALL, PHONE_CALL, DATA));

  private VerificationMethodStart(String value) {
    super(value);
  }

  public static Stream<VerificationMethodStart> values() {
    return ENUM_SUPPORT.values();
  }

  public static VerificationMethodStart from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(VerificationMethodStart e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
