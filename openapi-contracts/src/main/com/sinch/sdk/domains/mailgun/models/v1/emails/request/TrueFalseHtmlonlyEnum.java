package com.sinch.sdk.domains.mailgun.models.v1.emails.request;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Toggles click tracking on a per-message basis, see <a
 * href="https://documentation.mailgun.com/docs/mailgun/user-manual/tracking-messages/#tracking-clicks">Tracking
 * Clicks</a>. This overrides the domain-level click tracking setting.
 */
public class TrueFalseHtmlonlyEnum extends EnumDynamic<String, TrueFalseHtmlonlyEnum> {

  /** Enable tracking on a per-message basis */
  public static final TrueFalseHtmlonlyEnum YES = new TrueFalseHtmlonlyEnum("yes");

  /** Disable tracking on a per-message basis */
  public static final TrueFalseHtmlonlyEnum NO = new TrueFalseHtmlonlyEnum("no");

  /** Enable tracking on a per-message basis */
  public static final TrueFalseHtmlonlyEnum TRUE = new TrueFalseHtmlonlyEnum("true");

  /** Disable tracking on a per-message basis */
  public static final TrueFalseHtmlonlyEnum FALSE = new TrueFalseHtmlonlyEnum("false");

  /** Use if you only want links rewritten in the HTML part of the message */
  public static final TrueFalseHtmlonlyEnum HTMLONLY = new TrueFalseHtmlonlyEnum("htmlonly");

  private static final EnumSupportDynamic<String, TrueFalseHtmlonlyEnum> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          TrueFalseHtmlonlyEnum.class,
          TrueFalseHtmlonlyEnum::new,
          Arrays.asList(YES, NO, TRUE, FALSE, HTMLONLY));

  private TrueFalseHtmlonlyEnum(String value) {
    super(value);
  }

  public static Stream<TrueFalseHtmlonlyEnum> values() {
    return ENUM_SUPPORT.values();
  }

  public static TrueFalseHtmlonlyEnum from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(TrueFalseHtmlonlyEnum e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
