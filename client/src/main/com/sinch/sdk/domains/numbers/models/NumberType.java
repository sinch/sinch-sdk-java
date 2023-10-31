package com.sinch.sdk.domains.numbers.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Type of phone number
 *
 * @since 1.0
 */
public final class NumberType extends EnumDynamic<NumberType> {

  /** Numbers that belong to a specific range. */
  public static final NumberType MOBILE = new NumberType("MOBILE");
  /** Numbers that are assigned to a specific geographic region. */
  public static final NumberType LOCAL = new NumberType("LOCAL");

  /** Numbers that are free of charge for the calling party but billed for all arriving calls. */
  public static final NumberType TOLL_FREE = new NumberType("TOLL_FREE");

  private static final EnumSupportDynamic<NumberType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          NumberType.class, NumberType::new, Arrays.asList(MOBILE, LOCAL, TOLL_FREE));

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
