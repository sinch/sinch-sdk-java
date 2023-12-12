package com.sinch.sdk.domains.verification.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Link rel authorized values
 *
 * @since 1.0
 */
public class LinkRelType extends EnumDynamic<String, LinkRelType> {

  /** Get the status of a Verification. */
  public static final LinkRelType STATUS = new LinkRelType("status");

  /** Report a verification */
  public static final LinkRelType REPORT = new LinkRelType("report");

  private static final EnumSupportDynamic<String, LinkRelType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(LinkRelType.class, LinkRelType::new, Arrays.asList(STATUS, REPORT));

  private LinkRelType(String value) {
    super(value);
  }

  public static Stream<LinkRelType> values() {
    return ENUM_SUPPORT.values();
  }

  public static LinkRelType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(LinkRelType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
