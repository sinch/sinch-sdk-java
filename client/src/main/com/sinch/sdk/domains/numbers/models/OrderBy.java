package com.sinch.sdk.domains.numbers.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Supported fields for ordering
 *
 * @since 1.0
 */
public final class OrderBy extends EnumDynamic<String, OrderBy> {
  /** Ordering by phoneNumber */
  public static final OrderBy PHONE_NUMBER = new OrderBy("phoneNumber");
  /** Ordering by displayName */
  public static final OrderBy DISPLAY_NAME = new OrderBy("displayName");

  private static final EnumSupportDynamic<String, OrderBy> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          OrderBy.class, OrderBy::new, Arrays.asList(PHONE_NUMBER, DISPLAY_NAME));

  private OrderBy(String value) {
    super(value);
  }

  public static Stream<OrderBy> values() {
    return ENUM_SUPPORT.values();
  }

  public static OrderBy from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(OrderBy e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
