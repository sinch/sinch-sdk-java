package com.sinch.sdk.domains.conversation.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Whether or not Conversation API should store contacts and conversations for the app.
 *
 * <p>By default, Conversation API always associates new messages with a Contact and a Conversation.
 * If there's no existing contact or active conversation, new ones are created. This is the
 * CONVERSATION mode intended to be used by the majority of apps.
 *
 * <p>This behavior may not be desired for use cases in which contacts and conversations are not
 * leveraged, mainly unidirectional SMS campaigns. Such use cases may find the DISPATCH processing
 * mode more attractive in order to prevent storage of unused information. Dispatch mode aims to
 * address this necessity by handling messages without maintaining contacts and conversations.
 *
 * <p>For more information, see <a
 * href="https://developers.sinch.com/docs/conversation/processing-modes">Processing Modes</a>
 *
 * @since 1.0
 */
public final class ProcessingModeType extends EnumDynamic<String, ProcessingModeType> {

  /**
   * The default Processing Mode. Creates contacts and conversations automatically when a message is
   *
   * <p>sent or received and there's no existing contact or active conversation
   *
   * <ul>
   *   <li>Messages are associated with Contacts and Conversations
   *   <li>Message retention TTL is [1 - 3650] days
   *   <li>Message retention policy can be MESSAGE_EXPIRE_POLICY, CONVERSATION_EXPIRE_POLICY, and
   *       PERSIST_RETENTION_POLICY
   * </ul>
   */
  public static final ProcessingModeType CONVERSATION = new ProcessingModeType("CONVERSATION");

  /**
   * Does not associate messages with contacts and conversations.
   *
   * <p>This processing mode is mostly intended for unidirectional high volume SMS use cases. The
   * lack of contacts and conversations limits some API features as related data won't be queryable
   * in the <a
   * href="https://developers.sinch.com/docs/conversation/api-reference/conversation/tag/Contact">Contact</a>
   * and <a
   * href="https://developers.sinch.com/docs/conversation/api-reference/conversation/tag/Conversation">Conversation</a>
   * APIs
   *
   * <ul>
   *   <li>Messages are not associated with Contacts and Conversations
   *   <li>Message retention TTL is [0 - 7] days. In the case of a 0 day TTL, messages aren't stored
   *       at all
   *   <li>Message retention policy can only be MESSAGE_EXPIRE_POLICY as there are no conversations
   *       or contacts
   * </ul>
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
