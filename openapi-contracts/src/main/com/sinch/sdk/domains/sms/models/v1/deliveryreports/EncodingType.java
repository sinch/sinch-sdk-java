package com.sinch.sdk.domains.sms.models.v1.deliveryreports;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Applied encoding for message. Present only if smart encoding is enabled. */
public class EncodingType extends EnumDynamic<String, EncodingType> {

  public static final EncodingType GSM = new EncodingType("GSM");

  public static final EncodingType UNICODE = new EncodingType("UNICODE");

  private static final EnumSupportDynamic<String, EncodingType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(EncodingType.class, EncodingType::new, Arrays.asList(GSM, UNICODE));

  private EncodingType(String value) {
    super(value);
  }

  public static Stream<EncodingType> values() {
    return ENUM_SUPPORT.values();
  }

  public static EncodingType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(EncodingType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
