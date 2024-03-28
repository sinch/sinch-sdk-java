package com.sinch.sdk.domains.conversation.models.v1;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Whether or not Conversation API should store contacts and conversations for the app. For more
 * information, see [Processing Modes](../../../../../conversation/processing-modes/).
 */
public class ProcessingMode extends EnumDynamic<String, ProcessingMode> {

  public static final ProcessingMode CONVERSATION = new ProcessingMode("CONVERSATION");

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
