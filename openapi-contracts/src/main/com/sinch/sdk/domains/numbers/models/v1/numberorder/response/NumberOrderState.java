package com.sinch.sdk.domains.numbers.models.v1.numberorder.response;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** The state of the number order */
public class NumberOrderState extends EnumDynamic<String, NumberOrderState> {

  /** State not specified. */
  public static final NumberOrderState NUMBER_ORDER_STATE_UNSPECIFIED =
      new NumberOrderState("NUMBER_ORDER_STATE_UNSPECIFIED");

  /** Created state. */
  public static final NumberOrderState CREATED = new NumberOrderState("CREATED");

  /** Expired state. */
  public static final NumberOrderState EXPIRED = new NumberOrderState("EXPIRED");

  /** Order in review. */
  public static final NumberOrderState IN_REVIEW = new NumberOrderState("IN_REVIEW");

  /** Order blocked. */
  public static final NumberOrderState BLOCKED = new NumberOrderState("BLOCKED");

  /** Order rejected. */
  public static final NumberOrderState REJECTED = new NumberOrderState("REJECTED");

  /** Order completed. */
  public static final NumberOrderState COMPLETED = new NumberOrderState("COMPLETED");

  private static final EnumSupportDynamic<String, NumberOrderState> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          NumberOrderState.class,
          NumberOrderState::new,
          Arrays.asList(
              NUMBER_ORDER_STATE_UNSPECIFIED,
              CREATED,
              EXPIRED,
              IN_REVIEW,
              BLOCKED,
              REJECTED,
              COMPLETED));

  private NumberOrderState(String value) {
    super(value);
  }

  public static Stream<NumberOrderState> values() {
    return ENUM_SUPPORT.values();
  }

  public static NumberOrderState from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(NumberOrderState e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
