package com.sinch.sdk.domains.voice.models.requests;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Domains type */
public class DomainType extends EnumDynamic<String, DomainType> {

  /** PSTN endpoint */
  public static final DomainType PSTN = new DomainType("pstn");

  /** data (app or web) clients */
  public static final DomainType MXP = new DomainType("mxp");

  /** */
  private static final EnumSupportDynamic<String, DomainType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(DomainType.class, DomainType::new, Arrays.asList(PSTN, MXP));

  private DomainType(String value) {
    super(value);
  }

  public static Stream<DomainType> values() {
    return ENUM_SUPPORT.values();
  }

  public static DomainType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(DomainType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
