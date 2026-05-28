package com.sinch.sdk.domains.number_lookup.models.v2.response;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** */
public class VoIPProbabilityType extends EnumDynamic<String, VoIPProbabilityType> {

  /** Undefined */
  public static final VoIPProbabilityType UNKNOWN = new VoIPProbabilityType("Unknown");

  /** Low */
  public static final VoIPProbabilityType LOW = new VoIPProbabilityType("Low");

  /** Likely */
  public static final VoIPProbabilityType LIKELY = new VoIPProbabilityType("Likely");

  /** High */
  public static final VoIPProbabilityType HIGH = new VoIPProbabilityType("High");

  private static final EnumSupportDynamic<String, VoIPProbabilityType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          VoIPProbabilityType.class,
          VoIPProbabilityType::new,
          Arrays.asList(UNKNOWN, LOW, LIKELY, HIGH));

  private VoIPProbabilityType(String value) {
    super(value);
  }

  public static Stream<VoIPProbabilityType> values() {
    return ENUM_SUPPORT.values();
  }

  public static VoIPProbabilityType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(VoIPProbabilityType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
