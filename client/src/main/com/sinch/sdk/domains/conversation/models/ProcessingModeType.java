package com.sinch.sdk.domains.conversation.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Whether or not Conversation API should store contacts and conversations for the app.
 *
 * <p>For more information, see <a
 * href="https://developers.sinch.com/docs/conversation/processing-modes/">Processing Modes</a>
 *
 * @since 1.0
 */
public final class ProcessingModeType extends EnumDynamic<String, ProcessingModeType> {

  /**
   * The default Processing Mode. Creates contacts and conversations automatically when a message is
   * sent or received and there's no existing contact or active conversation
   */
  public static final ProcessingModeType CONVERSATION = new ProcessingModeType("CONVERSATION");

  /**
   * Does not associate messages with contacts and conversations. This processing mode is mostly
   * intended for unidirectional high volume SMS use cases. The lack of contacts and conversations
   * limits some API features as related data won't be queryable in the <a
   * href="https://developers.sinch.com/docs/conversation/api-reference/conversation/tag/Contact">Contact</a>
   * and <a
   * href="https://developers.sinch.com/docs/conversation/api-reference/conversation/tag/Conversation">Conversation</a>
   * APIs
   */
  public static final ProcessingModeType DISPATCH = new ProcessingModeType("DISPATCH");

  private static final EnumSupportDynamic<String, ProcessingModeType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          ProcessingModeType.class, ProcessingModeType::new, Arrays.asList(CONVERSATION, DISPATCH));

  private ProcessingModeType(String value) {
    super(value);
  }

  public static Stream<ProcessingModeType> values() {
    return ENUM_SUPPORT.values();
  }

  public static ProcessingModeType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(ProcessingModeType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
