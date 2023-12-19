package com.sinch.sdk.domains.voice.models.requests;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Means "music-on-hold." */
public class MohClassType extends EnumDynamic<String, MohClassType> {

  /** progress tone */
  public static final MohClassType RING = new MohClassType("ring");

  /** Music file */
  public static final MohClassType MUSIC1 = new MohClassType("music1");

  /** Music file */
  public static final MohClassType MUSIC2 = new MohClassType("music2");

  /** Music file */
  public static final MohClassType MUSIC3 = new MohClassType("music3");

  /** */
  private static final EnumSupportDynamic<String, MohClassType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          MohClassType.class, MohClassType::new, Arrays.asList(RING, MUSIC1, MUSIC2, MUSIC3));

  private MohClassType(String value) {
    super(value);
  }

  public static Stream<MohClassType> values() {
    return ENUM_SUPPORT.values();
  }

  public static MohClassType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(MohClassType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
