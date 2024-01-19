package com.sinch.sdk.domains.voice.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * The type of the number
 *
 * @since 1.0
 */
public final class NumberType extends EnumDynamic<String, NumberType> {
  public static final NumberType UNKNOWN = new NumberType("Unknown");
  public static final NumberType FIXED = new NumberType("Fixed");
  public static final NumberType MOBILE = new NumberType("Mobile");
  public static final NumberType OTHER = new NumberType("Other");

  private static final EnumSupportDynamic<String, NumberType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          NumberType.class, NumberType::new, Arrays.asList(UNKNOWN, FIXED, MOBILE, OTHER));

  private NumberType(String value) {
    super(value);
  }

  public static Stream<NumberType> values() {
    return ENUM_SUPPORT.values();
  }

  public static NumberType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(NumberType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
