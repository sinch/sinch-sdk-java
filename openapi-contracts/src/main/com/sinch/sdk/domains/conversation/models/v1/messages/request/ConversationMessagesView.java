package com.sinch.sdk.domains.conversation.models.v1.messages.request;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Gets or Sets ConversationMessagesView */
public class ConversationMessagesView extends EnumDynamic<String, ConversationMessagesView> {

  /** View the message with metadata. */
  public static final ConversationMessagesView WITH_METADATA =
      new ConversationMessagesView("WITH_METADATA");

  /** View the message without metadata. */
  public static final ConversationMessagesView WITHOUT_METADATA =
      new ConversationMessagesView("WITHOUT_METADATA");

  private static final EnumSupportDynamic<String, ConversationMessagesView> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          ConversationMessagesView.class,
          ConversationMessagesView::new,
          Arrays.asList(WITH_METADATA, WITHOUT_METADATA));

  private ConversationMessagesView(String value) {
    super(value);
  }

  public static Stream<ConversationMessagesView> values() {
    return ENUM_SUPPORT.values();
  }

  public static ConversationMessagesView from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(ConversationMessagesView e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
