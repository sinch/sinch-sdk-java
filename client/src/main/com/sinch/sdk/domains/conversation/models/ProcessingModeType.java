package com.sinch.sdk.domains.conversation.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Whether or not Conversation API should store contacts and conversations for the app.
 *
 * <p>For more information, see {@see <a
 * href="https://developers.sinch.com/docs/conversation/processing-modes/">Processing Modes</a>}
 *
 * @since 1.0
 */
public final class ProcessingModeType extends EnumDynamic<String, ProcessingModeType> {

  public static final ProcessingModeType CONVERSATION = new ProcessingModeType("CONVERSATION");
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
