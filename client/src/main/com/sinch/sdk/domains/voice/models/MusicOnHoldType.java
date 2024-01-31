package com.sinch.sdk.domains.voice.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Means "music-on-hold." */
public class MusicOnHoldType extends EnumDynamic<String, MusicOnHoldType> {

  /** progress tone */
  public static final MusicOnHoldType RING = new MusicOnHoldType("ring");

  /** Music file */
  public static final MusicOnHoldType MUSIC1 = new MusicOnHoldType("music1");

  /** Music file */
  public static final MusicOnHoldType MUSIC2 = new MusicOnHoldType("music2");

  /** Music file */
  public static final MusicOnHoldType MUSIC3 = new MusicOnHoldType("music3");

  /** */
  private static final EnumSupportDynamic<String, MusicOnHoldType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          MusicOnHoldType.class, MusicOnHoldType::new, Arrays.asList(RING, MUSIC1, MUSIC2, MUSIC3));

  private MusicOnHoldType(String value) {
    super(value);
  }

  public static Stream<MusicOnHoldType> values() {
    return ENUM_SUPPORT.values();
  }

  public static MusicOnHoldType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(MusicOnHoldType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
