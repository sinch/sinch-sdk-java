package com.sinch.sdk.domains.conversation.models.v1.messages.request;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Specifies the message source for which the request will be processed. Used for operations on
 * messages in Dispatch Mode. For more information, see <a
 * href="https://developers.sinch.com/docs/conversation/processing-modes/">Processing Modes</a>.
 */
public class MessageSource extends EnumDynamic<String, MessageSource> {

  /**
   * The default messages source. Retrieves messages sent in the <code>CONVERSATION</code>
   * processing mode, which associates the messages with a specific conversation and contact.
   */
  public static final MessageSource CONVERSATION_SOURCE = new MessageSource("CONVERSATION_SOURCE");

  /**
   * Retrieves messages sent in the <code>DISPATCH</code> processing mode. These types of messages
   * are not associated with any conversation or contact.
   */
  public static final MessageSource DISPATCH_SOURCE = new MessageSource("DISPATCH_SOURCE");

  private static final EnumSupportDynamic<String, MessageSource> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          MessageSource.class,
          MessageSource::new,
          Arrays.asList(CONVERSATION_SOURCE, DISPATCH_SOURCE));

  private MessageSource(String value) {
    super(value);
  }

  public static Stream<MessageSource> values() {
    return ENUM_SUPPORT.values();
  }

  public static MessageSource from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(MessageSource e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
