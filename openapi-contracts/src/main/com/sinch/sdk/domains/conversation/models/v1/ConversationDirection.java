package com.sinch.sdk.domains.conversation.models.v1;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * The direction of the message flow, indicating whether the message was sent to or from the
 * Conversation API app.
 */
public class ConversationDirection extends EnumDynamic<String, ConversationDirection> {

  /** Sent to the Conversation API app. */
  public static final ConversationDirection TO_APP = new ConversationDirection("TO_APP");

  /** Sent to a recipient/contact from the Conversation API app. */
  public static final ConversationDirection TO_CONTACT = new ConversationDirection("TO_CONTACT");

  private static final EnumSupportDynamic<String, ConversationDirection> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          ConversationDirection.class,
          ConversationDirection::new,
          Arrays.asList(TO_APP, TO_CONTACT));

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
