package com.sinch.sdk.domains.verification.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * The type of the verification request authorized values
 *
 * @since 1.0
 */
public class VerificationMethodType extends EnumDynamic<String, VerificationMethodType> {

  /** Verification by SMS message with a PIN code */
  public static final VerificationMethodType SMS = new VerificationMethodType("sms");

  /**
   * Verification by placing a flashcall (missed call) and detecting the incoming calling number
   * (CLI).
   */
  public static final VerificationMethodType FLASH_CALL = new VerificationMethodType("flashcall");

  /**
   * Verification by placing a PSTN call to the user's phone and playing an announcement, asking the
   * user to press a particular digit to verify the phone number.
   */
  public static final VerificationMethodType CALLOUT = new VerificationMethodType("callout");

  /**
   * Data verification. Verification by accessing internal infrastructure of mobile carriers to
   * verify if given verification attempt was originated from device with matching phone number.
   */
  public static final VerificationMethodType SEAMLESS = new VerificationMethodType("seamless");

  /** */
  private static final EnumSupportDynamic<String, VerificationMethodType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          VerificationMethodType.class,
          VerificationMethodType::new,
          Arrays.asList(SMS, FLASH_CALL, CALLOUT, SEAMLESS));

  private VerificationMethodType(String value) {
    super(value);
  }

  public static Stream<VerificationMethodType> values() {
    return ENUM_SUPPORT.values();
  }

  public static VerificationMethodType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(VerificationMethodType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
