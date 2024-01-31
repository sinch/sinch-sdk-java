package com.sinch.sdk.domains.voice.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Destination types */
public class DestinationNumberType extends EnumDynamic<String, DestinationNumberType> {

  /** * Public Switched Telephone Network */
  public static final DestinationNumberType PSTN = new DestinationNumberType("PSTN");

  /** * Direct Inward Dialing */
  public static final DestinationNumberType DID = new DestinationNumberType("DID");

  private static final EnumSupportDynamic<String, DestinationNumberType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          DestinationNumberType.class, DestinationNumberType::new, Arrays.asList(PSTN, DID));

  private DestinationNumberType(String value) {
    super(value);
  }

  public static Stream<DestinationNumberType> values() {
    return ENUM_SUPPORT.values();
  }

  public static DestinationNumberType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(DestinationNumberType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
