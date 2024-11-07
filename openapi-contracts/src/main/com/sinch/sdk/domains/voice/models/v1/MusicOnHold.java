package com.sinch.sdk.domains.voice.models.v1;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Available Music On Hold values */
public class MusicOnHold extends EnumDynamic<String, MusicOnHold> {

  /** Plays a progress tone. */
  public static final MusicOnHold RING = new MusicOnHold("ring");

  /** Plays music choice 1. */
  public static final MusicOnHold MUSIC1 = new MusicOnHold("music1");

  /** Plays music choice 2. */
  public static final MusicOnHold MUSIC2 = new MusicOnHold("music2");

  /** Plays music choice 3. */
  public static final MusicOnHold MUSIC3 = new MusicOnHold("music3");

  private static final EnumSupportDynamic<String, MusicOnHold> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          MusicOnHold.class, MusicOnHold::new, Arrays.asList(RING, MUSIC1, MUSIC2, MUSIC3));

  private MusicOnHold(String value) {
    super(value);
  }

  public static Stream<MusicOnHold> values() {
    return ENUM_SUPPORT.values();
  }

  public static MusicOnHold from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(MusicOnHold e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
