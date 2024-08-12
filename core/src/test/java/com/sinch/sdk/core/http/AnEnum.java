package com.sinch.sdk.core.http;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

class AnEnum extends EnumDynamic<String, AnEnum> {

  static final AnEnum ENUM1 = new AnEnum("ENUM1 value");

  static final AnEnum ENUM2 = new AnEnum("ENUM2 value");

  private static final EnumSupportDynamic<String, AnEnum> ENUM_SUPPORT =
      new EnumSupportDynamic<>(AnEnum.class, AnEnum::new, Arrays.asList(ENUM1, ENUM2));

  private AnEnum(String value) {
    super(value);
  }

  public static Stream<AnEnum> values() {
    return ENUM_SUPPORT.values();
  }

  public static AnEnum from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(AnEnum e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
