package com.sinch.sdk.domains.voice.models.v2;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Voice V2 region. Each region is served by its own Voice V2 server.
 *
 * <p>Voice V2 regions are not the same as the Voice V1 ones.
 *
 * @see <a href="https://developers.sinch.com/docs/voice-2.0">Voice V2 documentation</a>
 * @since 2.3
 */
public class VoiceRegion extends EnumDynamic<String, VoiceRegion> {

  /** Global - redirected by Sinch to the closest region */
  public static final VoiceRegion GLOBAL = new VoiceRegion("global");

  /** North America 1 - East */
  public static final VoiceRegion NORTH_AMERICA = new VoiceRegion("us1");

  /** South America 1 - East */
  public static final VoiceRegion SOUTH_AMERICA = new VoiceRegion("br1");

  /** Europe 1 - Central */
  public static final VoiceRegion EUROPE = new VoiceRegion("eu1");

  /** Asia Pacific 1 - Southeast */
  public static final VoiceRegion ASIA_PACIFIC = new VoiceRegion("sg1");

  /** Australia and Oceania 1 - Southeast */
  public static final VoiceRegion AUSTRALIA = new VoiceRegion("au1");

  private static final EnumSupportDynamic<String, VoiceRegion> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          VoiceRegion.class,
          VoiceRegion::new,
          Arrays.asList(GLOBAL, NORTH_AMERICA, SOUTH_AMERICA, EUROPE, ASIA_PACIFIC, AUSTRALIA));

  private VoiceRegion(String value) {
    super(value);
  }

  /**
   * Get declared values
   *
   * @return Stream of values
   */
  public static Stream<VoiceRegion> values() {
    return ENUM_SUPPORT.values();
  }

  /**
   * Get value from a string
   *
   * @param value String identifier
   * @return Dynamic enum from value. A new enum is created if value is not yet registered
   */
  public static VoiceRegion from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  /**
   * Value of the enum as String
   *
   * @param value The enum identifier
   * @return String identifier of the enum value
   */
  public static String valueOf(VoiceRegion value) {
    return ENUM_SUPPORT.valueOf(value);
  }
}
