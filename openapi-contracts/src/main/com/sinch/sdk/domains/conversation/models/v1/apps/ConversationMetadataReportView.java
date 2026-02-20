package com.sinch.sdk.domains.conversation.models.v1.apps;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** NONE - Omit metadata. FULL - Include all metadata assigned to the conversation. */
public class ConversationMetadataReportView
    extends EnumDynamic<String, ConversationMetadataReportView> {

  /** Omit metadata. */
  public static final ConversationMetadataReportView NONE =
      new ConversationMetadataReportView("NONE");

  /** Include all metadata assigned to the conversation. */
  public static final ConversationMetadataReportView FULL =
      new ConversationMetadataReportView("FULL");

  private static final EnumSupportDynamic<String, ConversationMetadataReportView> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          ConversationMetadataReportView.class,
          ConversationMetadataReportView::new,
          Arrays.asList(NONE, FULL));

  private ConversationMetadataReportView(String value) {
    super(value);
  }

  public static Stream<ConversationMetadataReportView> values() {
    return ENUM_SUPPORT.values();
  }

  public static ConversationMetadataReportView from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(ConversationMetadataReportView e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
