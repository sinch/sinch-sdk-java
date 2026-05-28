package com.sinch.sdk.domains.number_lookup.models.v2.request;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** */
public class LookupFeatureType extends EnumDynamic<String, LookupFeatureType> {

  /** Use to return line type information for the phone number. */
  public static final LookupFeatureType LINE_TYPE = new LookupFeatureType("LineType");

  /** Use to determine whether the phone number is SIM swapped. */
  public static final LookupFeatureType SIM_SWAP = new LookupFeatureType("SimSwap");

  /** Use to determine if the carrier is associated with a VoIP provider (alpha). */
  public static final LookupFeatureType VO_IP_DETECTION = new LookupFeatureType("VoIPDetection");

  /** Use to determine whether the phone number has been disconnected (alpha). */
  public static final LookupFeatureType RND = new LookupFeatureType("RND");

  private static final EnumSupportDynamic<String, LookupFeatureType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          LookupFeatureType.class,
          LookupFeatureType::new,
          Arrays.asList(LINE_TYPE, SIM_SWAP, VO_IP_DETECTION, RND));

  private LookupFeatureType(String value) {
    super(value);
  }

  public static Stream<LookupFeatureType> values() {
    return ENUM_SUPPORT.values();
  }

  public static LookupFeatureType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(LookupFeatureType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
