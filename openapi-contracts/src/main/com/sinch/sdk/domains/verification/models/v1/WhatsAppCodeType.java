package com.sinch.sdk.domains.verification.models.v1;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Selects type of code which will be sent to customer */
public class WhatsAppCodeType extends EnumDynamic<String, WhatsAppCodeType> {

  /** Code contains numbers only. */
  public static final WhatsAppCodeType NUMERIC = new WhatsAppCodeType("Numeric");

  /** Code contains letters only. */
  public static final WhatsAppCodeType ALPHA = new WhatsAppCodeType("Alpha");

  /** Code contains both numbers and letters. */
  public static final WhatsAppCodeType ALPHANUMERIC = new WhatsAppCodeType("Alphanumeric");

  private static final EnumSupportDynamic<String, WhatsAppCodeType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          WhatsAppCodeType.class,
          WhatsAppCodeType::new,
          Arrays.asList(NUMERIC, ALPHA, ALPHANUMERIC));

  private WhatsAppCodeType(String value) {
    super(value);
  }

  public static Stream<WhatsAppCodeType> values() {
    return ENUM_SUPPORT.values();
  }

  public static WhatsAppCodeType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(WhatsAppCodeType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
