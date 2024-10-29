package com.sinch.sdk.domains.voice.models.v1.destination.internal;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Type <code>did</code> for Direct Inward Dialling */
public class DidDestination extends EnumDynamic<String, DidDestination> {

  /** A DID phone number */
  public static final DidDestination DID = new DidDestination("did");

  private static final EnumSupportDynamic<String, DidDestination> ENUM_SUPPORT =
      new EnumSupportDynamic<>(DidDestination.class, DidDestination::new, Arrays.asList(DID));

  private DidDestination(String value) {
    super(value);
  }

  public static Stream<DidDestination> values() {
    return ENUM_SUPPORT.values();
  }

  public static DidDestination from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(DidDestination e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
