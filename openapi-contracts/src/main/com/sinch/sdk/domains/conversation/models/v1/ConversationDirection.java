package com.sinch.sdk.domains.conversation.models.v1;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Gets or Sets ConversationDirection */
public class ConversationDirection extends EnumDynamic<String, ConversationDirection> {

  public static final ConversationDirection UNDEFINED_DIRECTION =
      new ConversationDirection("UNDEFINED_DIRECTION");

  public static final ConversationDirection TO_APP = new ConversationDirection("TO_APP");

  public static final ConversationDirection TO_CONTACT = new ConversationDirection("TO_CONTACT");

  private static final EnumSupportDynamic<String, ConversationDirection> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          ConversationDirection.class,
          ConversationDirection::new,
          Arrays.asList(UNDEFINED_DIRECTION, TO_APP, TO_CONTACT));

  private ConversationDirection(String value) {
    super(value);
  }

  public static Stream<ConversationDirection> values() {
    return ENUM_SUPPORT.values();
  }

  public static ConversationDirection from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(ConversationDirection e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
