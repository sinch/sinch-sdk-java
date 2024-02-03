package com.sinch.sdk.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * The Calling API uses a variety of endpoints depending on where in the world you are located.
 *
 * <p>When using methods concerning individual calls, you can define what regional endpoint you want
 * to use for the call. The following regional endpoints are available:
 *
 * <p>For cases where the call is the result of an incoming PSTN, SIP or data call, the endpoint to
 * use for managing that call is supplied in the ICE event. ICE callbacks will also provide
 * region-specific URLs in the callResourceUrl property.
 *
 * @see <a href="https://developers.sinch.com/docs/voice/api-reference/#endpoints">endpoints
 *     description</a>
 */
public class VoiceRegion extends EnumDynamic<String, VoiceRegion> {

  /** Global - redirected by Sinch to the closest region */
  public static final VoiceRegion GLOBAL = new VoiceRegion("global");

  /** Europe */
  public static final VoiceRegion EUROPE = new VoiceRegion("europe");

  /** North America */
  public static final VoiceRegion NORTH_AMERICA = new VoiceRegion("north-america");

  /** South America */
  public static final VoiceRegion SOUTH_AMERICA = new VoiceRegion("south-america");

  /** South East Asia 1 */
  public static final VoiceRegion SOUTH_EAST_ASIA1 = new VoiceRegion("south-east-asia1");

  /** South East Asia 2 */
  public static final VoiceRegion SOUTH_EAST_ASIA2 = new VoiceRegion("south-east-asia2");

  private static final EnumSupportDynamic<String, VoiceRegion> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          VoiceRegion.class,
          VoiceRegion::new,
          Arrays.asList(
              GLOBAL, EUROPE, NORTH_AMERICA, SOUTH_AMERICA, SOUTH_EAST_ASIA1, SOUTH_EAST_ASIA2));

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
