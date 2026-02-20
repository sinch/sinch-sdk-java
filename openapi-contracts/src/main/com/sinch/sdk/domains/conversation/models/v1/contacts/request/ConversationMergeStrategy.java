package com.sinch.sdk.domains.conversation.models.v1.contacts.request;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Gets or Sets ConversationMergeStrategy */
public class ConversationMergeStrategy extends EnumDynamic<String, ConversationMergeStrategy> {

  /** Merge the contents of the two subjects. */
  public static final ConversationMergeStrategy MERGE = new ConversationMergeStrategy("MERGE");

  private static final EnumSupportDynamic<String, ConversationMergeStrategy> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          ConversationMergeStrategy.class, ConversationMergeStrategy::new, Arrays.asList(MERGE));

  private ConversationMergeStrategy(String value) {
    super(value);
  }

  public static Stream<ConversationMergeStrategy> values() {
    return ENUM_SUPPORT.values();
  }

  public static ConversationMergeStrategy from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(ConversationMergeStrategy e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
