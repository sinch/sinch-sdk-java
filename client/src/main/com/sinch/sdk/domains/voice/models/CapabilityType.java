package com.sinch.sdk.domains.voice.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * CapabilityType of a phone number
 *
 * <p>DID: Direct Inward CapabilityType
 *
 * @since 1.0
 */
public final class CapabilityType extends EnumDynamic<String, CapabilityType> {
  /** The SMS product can use the number. */
  public static final CapabilityType SMS = new CapabilityType("sms");

  /** The Voice product can use the number. */
  public static final CapabilityType VOICE = new CapabilityType("voice");

  private static final EnumSupportDynamic<String, CapabilityType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          CapabilityType.class, CapabilityType::new, Arrays.asList(SMS, VOICE));

  private CapabilityType(String value) {
    super(value);
  }

  public static Stream<CapabilityType> values() {
    return ENUM_SUPPORT.values();
  }

  public static CapabilityType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(CapabilityType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
