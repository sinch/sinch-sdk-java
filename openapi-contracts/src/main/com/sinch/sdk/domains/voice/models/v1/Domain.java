package com.sinch.sdk.domains.voice.models.v1;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Can be either <code>pstn</code> for PSTN endpoint or <code>mxp</code> for data (app or web)
 * clients.
 */
public class Domain extends EnumDynamic<String, Domain> {

  /** A call on the Public Switched Telephone Network. */
  public static final Domain PSTN = new Domain("pstn");

  /** A data call. */
  public static final Domain MXP = new Domain("mxp");

  /** A call on the Public Switched Telephone Network. */
  public static final Domain PSTN2 = new Domain("PSTN");

  /** A data call. */
  public static final Domain MXP2 = new Domain("MXP");

  private static final EnumSupportDynamic<String, Domain> ENUM_SUPPORT =
      new EnumSupportDynamic<>(Domain.class, Domain::new, Arrays.asList(PSTN, MXP, PSTN2, MXP2));

  private Domain(String value) {
    super(value);
  }

  public static Stream<Domain> values() {
    return ENUM_SUPPORT.values();
  }

  public static Domain from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(Domain e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
