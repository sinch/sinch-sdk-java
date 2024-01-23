package com.sinch.sdk.domains.voice.models.webhooks;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** The type of input received. */
public class MenuResultInputMethodType extends EnumDynamic<String, MenuResultInputMethodType> {

  /** The input is key presses of specified digits */
  public static final MenuResultInputMethodType DTMF = new MenuResultInputMethodType("dtmf");

  /** The input is voice answers */
  public static final MenuResultInputMethodType VOICE = new MenuResultInputMethodType("voice");

  private static final EnumSupportDynamic<String, MenuResultInputMethodType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          MenuResultInputMethodType.class,
          MenuResultInputMethodType::new,
          Arrays.asList(VOICE, DTMF));

  private MenuResultInputMethodType(String value) {
    super(value);
  }

  public static Stream<MenuResultInputMethodType> values() {
    return ENUM_SUPPORT.values();
  }

  public static MenuResultInputMethodType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(MenuResultInputMethodType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
