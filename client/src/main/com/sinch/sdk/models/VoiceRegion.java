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
 * @see <a href="https://developers.sinch.com/docs/voice/api-reference/#endpoints">endpoints
 *     description</a>
 */
public class VoiceRegion extends EnumDynamic<String, VoiceRegion> {

  /** Global - redirected by Sinch to the closest region */
  public static final VoiceRegion GLOBAL = new VoiceRegion("global");

  public static final VoiceRegion EUROPE = new VoiceRegion("europe");
  public static final VoiceRegion NORTH_AMERICA = new VoiceRegion("north-america");
  public static final VoiceRegion SOUTH_AMERICA = new VoiceRegion("south-america");
  public static final VoiceRegion SOUTH_EAST_ASIA1 = new VoiceRegion("south-east-asia1");
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

  public static Stream<VoiceRegion> values() {
    return ENUM_SUPPORT.values();
  }

  public static VoiceRegion from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(VoiceRegion value) {
    return ENUM_SUPPORT.valueOf(value);
  }
}
