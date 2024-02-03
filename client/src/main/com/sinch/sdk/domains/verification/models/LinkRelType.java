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

  /**
   * Get declared values
   *
   * @return Stream of values
   */
  public static Stream<LinkRelType> values() {
    return ENUM_SUPPORT.values();
  }

  /**
   * Get value from a string
   *
   * @param value String identifier
   * @return Dynamic enum from value. A new enum is created if value is not yet registered
   */
  public static LinkRelType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  /**
   * Value of the enum as String
   *
   * @param e The enum identifier
   * @return String identifier of the enum value
   */
  public static String valueOf(LinkRelType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
