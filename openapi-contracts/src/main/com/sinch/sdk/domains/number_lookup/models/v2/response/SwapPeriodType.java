package com.sinch.sdk.domains.number_lookup.models.v2.response;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** */
public class SwapPeriodType extends EnumDynamic<String, SwapPeriodType> {

  /** Undefined */
  public static final SwapPeriodType UNDEFINED = new SwapPeriodType("Undefined");

  /** 4 Hours */
  public static final SwapPeriodType SP4_H = new SwapPeriodType("SP4H");

  /** 12 Hours */
  public static final SwapPeriodType SP12_H = new SwapPeriodType("SP12H");

  /** 24 Hours */
  public static final SwapPeriodType SP24_H = new SwapPeriodType("SP24H");

  /** 48 Hours */
  public static final SwapPeriodType SP48_H = new SwapPeriodType("SP48H");

  /** 5 Days */
  public static final SwapPeriodType SP5_D = new SwapPeriodType("SP5D");

  /** 7 Days */
  public static final SwapPeriodType SP7_D = new SwapPeriodType("SP7D");

  /** 14 Days */
  public static final SwapPeriodType SP14_D = new SwapPeriodType("SP14D");

  /** 30 Days */
  public static final SwapPeriodType SP30_D = new SwapPeriodType("SP30D");

  /** Maximum */
  public static final SwapPeriodType SPMAX = new SwapPeriodType("SPMAX");

  private static final EnumSupportDynamic<String, SwapPeriodType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          SwapPeriodType.class,
          SwapPeriodType::new,
          Arrays.asList(
              UNDEFINED, SP4_H, SP12_H, SP24_H, SP48_H, SP5_D, SP7_D, SP14_D, SP30_D, SPMAX));

  private SwapPeriodType(String value) {
    super(value);
  }

  public static Stream<SwapPeriodType> values() {
    return ENUM_SUPPORT.values();
  }

  public static SwapPeriodType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(SwapPeriodType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
