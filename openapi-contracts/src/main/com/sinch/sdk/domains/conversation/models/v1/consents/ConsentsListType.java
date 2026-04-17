package com.sinch.sdk.domains.conversation.models.v1.consents;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * The consent list type. See <a
 * href="https://developers.sinch.com/docs/conversation/consent-management">consent management</a>
 * page for more information.
 */
public class ConsentsListType extends EnumDynamic<String, ConsentsListType> {

  /** List type that blocks all kinds of messages */
  public static final ConsentsListType OPT_OUT_ALL = new ConsentsListType("OPT_OUT_ALL");

  /** List type that blocks only marketing messages */
  public static final ConsentsListType OPT_OUT_MARKETING =
      new ConsentsListType("OPT_OUT_MARKETING");

  /** List type that blocks only notification messages */
  public static final ConsentsListType OPT_OUT_NOTIFICATION =
      new ConsentsListType("OPT_OUT_NOTIFICATION");

  private static final EnumSupportDynamic<String, ConsentsListType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          ConsentsListType.class,
          ConsentsListType::new,
          Arrays.asList(OPT_OUT_ALL, OPT_OUT_MARKETING, OPT_OUT_NOTIFICATION));

  private ConsentsListType(String value) {
    super(value);
  }

  public static Stream<ConsentsListType> values() {
    return ENUM_SUPPORT.values();
  }

  public static ConsentsListType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(ConsentsListType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
