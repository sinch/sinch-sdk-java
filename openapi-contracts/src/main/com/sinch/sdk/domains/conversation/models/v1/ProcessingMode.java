package com.sinch.sdk.domains.conversation.models.v1;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Whether or not Conversation API should store contacts and conversations for the app. For more
 * information, see <a
 * href="https://developers.sinch.com/docs/conversation/processing-modes/">Processing Modes</a>.
 */
public class ProcessingMode extends EnumDynamic<String, ProcessingMode> {

  /**
   * Creates contacts and conversations automatically when a message is sent or received and there's
   * no existing contact or active conversation.
   */
  public static final ProcessingMode CONVERSATION = new ProcessingMode("CONVERSATION");

  /**
   * The default Processing Mode. Does not associate messages with contacts and conversations. This
   * processing mode is mostly intended for unidirectional high volume SMS use cases. The lack of
   * contacts and conversations limits some API features as related data won't be queryable in the
   * <a
   * href="https://developers.sinch.com/docs/conversation/api-reference/conversation/tag/Contact/">Contact</a>
   * and <a
   * href="https://developers.sinch.com/docs/conversation/api-reference/conversation/tag/Conversation/">Conversation</a>
   * APIs.
   */
  public static final ProcessingMode DISPATCH = new ProcessingMode("DISPATCH");

  private static final EnumSupportDynamic<String, ProcessingMode> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          ProcessingMode.class, ProcessingMode::new, Arrays.asList(CONVERSATION, DISPATCH));

  private ProcessingMode(String value) {
    super(value);
  }

  public static Stream<ProcessingMode> values() {
    return ENUM_SUPPORT.values();
  }

  public static ProcessingMode from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(ProcessingMode e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
