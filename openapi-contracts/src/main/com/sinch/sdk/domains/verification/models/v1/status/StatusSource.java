package com.sinch.sdk.domains.verification.models.v1.status;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * With the PIN SMS verification method, a user&#39;s phone number is verified by sending an SMS
 * containing a PIN code that must be manually returned. If you are are using an Android handset,
 * you could instead intercept the SMS message delivery and capture the PIN code automatically.
 */
public class StatusSource extends EnumDynamic<String, StatusSource> {

  /** PIN verification was performed automatically */
  public static final StatusSource INTERCEPTED = new StatusSource("intercepted");

  /** PIN verification was manually performed */
  public static final StatusSource MANUAL = new StatusSource("manual");

  private static final EnumSupportDynamic<String, StatusSource> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          StatusSource.class, StatusSource::new, Arrays.asList(INTERCEPTED, MANUAL));

  private StatusSource(String value) {
    super(value);
  }

  public static Stream<StatusSource> values() {
    return ENUM_SUPPORT.values();
  }

  public static StatusSource from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(StatusSource e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
