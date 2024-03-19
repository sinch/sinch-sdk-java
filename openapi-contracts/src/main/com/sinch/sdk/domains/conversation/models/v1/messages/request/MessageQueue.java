package com.sinch.sdk.domains.conversation.models.v1.messages.request;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Select the priority type for the message */
public class MessageQueue extends EnumDynamic<String, MessageQueue> {

  public static final MessageQueue NORMAL_PRIORITY = new MessageQueue("NORMAL_PRIORITY");

  public static final MessageQueue HIGH_PRIORITY = new MessageQueue("HIGH_PRIORITY");

  private static final EnumSupportDynamic<String, MessageQueue> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          MessageQueue.class, MessageQueue::new, Arrays.asList(NORMAL_PRIORITY, HIGH_PRIORITY));

  private MessageQueue(String value) {
    super(value);
  }

  public static Stream<MessageQueue> values() {
    return ENUM_SUPPORT.values();
  }

  public static MessageQueue from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(MessageQueue e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
