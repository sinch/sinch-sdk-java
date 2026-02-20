package com.sinch.sdk.domains.conversation.models.v1.messages.request;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Gets or Sets messages_source */
public class MessagesSource extends EnumDynamic<String, MessagesSource> {

  /**
   * The default messages source. Retrieves messages sent in the <code>CONVERSATION</code>
   * processing mode, which associates the messages with a specific conversation and contact.
   */
  public static final MessagesSource CONVERSATION_SOURCE =
      new MessagesSource("CONVERSATION_SOURCE");

  /**
   * Retrieves messages sent in the <code>DISPATCH</code> processing mode. These types of messages
   * are not associated with any conversation or contact.
   */
  public static final MessagesSource DISPATCH_SOURCE = new MessagesSource("DISPATCH_SOURCE");

  private static final EnumSupportDynamic<String, MessagesSource> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          MessagesSource.class,
          MessagesSource::new,
          Arrays.asList(CONVERSATION_SOURCE, DISPATCH_SOURCE));

  private MessagesSource(String value) {
    super(value);
  }

  public static Stream<MessagesSource> values() {
    return ENUM_SUPPORT.values();
  }

  public static MessagesSource from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(MessagesSource e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
