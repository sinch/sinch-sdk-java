package com.sinch.sdk.domains.conversation.models.v1.messages.types.choice;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Controls the display behavior of a choice. */
public class DisplayMode extends EnumDynamic<String, DisplayMode> {

  /** Default. Transient — choice disappears when new messages arrive. */
  public static final DisplayMode DISPLAY_MODE_UNSPECIFIED =
      new DisplayMode("DISPLAY_MODE_UNSPECIFIED");

  /** Persistent — choice remains visible in the message bubble. */
  public static final DisplayMode PERSISTENT = new DisplayMode("PERSISTENT");

  private static final EnumSupportDynamic<String, DisplayMode> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          DisplayMode.class, DisplayMode::new, Arrays.asList(DISPLAY_MODE_UNSPECIFIED, PERSISTENT));

  private DisplayMode(String value) {
    super(value);
  }

  public static Stream<DisplayMode> values() {
    return ENUM_SUPPORT.values();
  }

  public static DisplayMode from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(DisplayMode e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
