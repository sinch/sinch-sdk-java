package com.sinch.sdk.domains.voice.models.webhooks;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** The type of information that's returned */
public class MenuInputType extends EnumDynamic<String, MenuInputType> {

  /** Returned if there's an error with the input. */
  public static final MenuInputType ERROR = new MenuInputType("error");

  /** Returned when the event has been triggered from a return command */
  public static final MenuInputType RETURN = new MenuInputType("return");

  /** Returned when the event has been triggered from collecting DTMF digits */
  public static final MenuInputType SEQUENCE = new MenuInputType("sequence");

  /** Returned when the timeout period has elapsed */
  public static final MenuInputType TIMEOUT = new MenuInputType("timeout");

  /** Returned when the call is hung up */
  public static final MenuInputType HANGUP = new MenuInputType("hangup");

  /** InvalidInput */
  public static final MenuInputType INVALID_INPUT = new MenuInputType("invalidinput");

  private static final EnumSupportDynamic<String, MenuInputType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          MenuInputType.class,
          MenuInputType::new,
          Arrays.asList(ERROR, RETURN, SEQUENCE, TIMEOUT, HANGUP, INVALID_INPUT));

  private MenuInputType(String value) {
    super(value);
  }

  public static Stream<MenuInputType> values() {
    return ENUM_SUPPORT.values();
  }

  public static MenuInputType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(MenuInputType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
