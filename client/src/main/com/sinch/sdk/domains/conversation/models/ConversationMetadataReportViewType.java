package com.sinch.sdk.domains.conversation.models;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Type of channel
 *
 * @since 1.0
 */
public final class ConversationMetadataReportViewType
    extends EnumDynamic<String, ConversationMetadataReportViewType> {

  public static final ConversationMetadataReportViewType NONE =
      new ConversationMetadataReportViewType("NONE");
  public static final ConversationMetadataReportViewType FULL =
      new ConversationMetadataReportViewType("FULL");

  private static final EnumSupportDynamic<String, ConversationMetadataReportViewType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          ConversationMetadataReportViewType.class,
          ConversationMetadataReportViewType::new,
          Arrays.asList(NONE, FULL));

  private ConversationMetadataReportViewType(String value) {
    super(value);
  }

  public static Stream<ConversationMetadataReportViewType> values() {
    return ENUM_SUPPORT.values();
  }

  public static ConversationMetadataReportViewType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(ConversationMetadataReportViewType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
