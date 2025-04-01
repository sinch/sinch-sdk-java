package com.sinch.sdk.domains.conversation.models.v1.request;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Update strategy for the <code>conversation_metadata</code> field. Only supported in <code>
 * CONVERSATION</code> processing mode.
 */
public class MetadataUpdateStrategy extends EnumDynamic<String, MetadataUpdateStrategy> {

  /**
   * The default strategy. Replaces the whole <code>conversation_metadata</code> field with the new
   * value provided.
   */
  public static final MetadataUpdateStrategy REPLACE = new MetadataUpdateStrategy("REPLACE");

  /**
   * Patches the <code>conversation_metadata</code> field with the patch provided according to RFC
   * 7386.
   */
  public static final MetadataUpdateStrategy MERGE_PATCH =
      new MetadataUpdateStrategy("MERGE_PATCH");

  private static final EnumSupportDynamic<String, MetadataUpdateStrategy> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          MetadataUpdateStrategy.class,
          MetadataUpdateStrategy::new,
          Arrays.asList(REPLACE, MERGE_PATCH));

  private MetadataUpdateStrategy(String value) {
    super(value);
  }

  public static Stream<MetadataUpdateStrategy> values() {
    return ENUM_SUPPORT.values();
  }

  public static MetadataUpdateStrategy from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(MetadataUpdateStrategy e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
